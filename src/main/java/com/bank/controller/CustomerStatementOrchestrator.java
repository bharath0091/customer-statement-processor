package com.bank.controller;

import com.bank.builder.CustomerStatementOutputBuilder;
import com.bank.domain.output.CustomerStatementOutput;
import com.bank.domain.exception.BadRequestException;
import com.bank.fileProcessor.GetFileProcessorByContentType;
import com.bank.validation.ValidationsExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.function.Supplier;

@Component
public class CustomerStatementOrchestrator {

    @Autowired
    private ValidationsExecutor validationsExecutor;

    public CustomerStatementOutput process(MultipartFile file) {
        return Optional.of(file)
                .map(MultipartFile::getContentType)
                .map(GetFileProcessorByContentType::get)
                .map(optionalProcessor -> optionalProcessor.orElseThrow(badRequest()))
                .map(theProcessor -> theProcessor.apply(getInputStream(file)))
                .map(validationsExecutor::execute)
                .map(CustomerStatementOutputBuilder::build)
                .get();
    }

    private Supplier<RuntimeException> badRequest() {
        return () -> new BadRequestException("Invalid Content Type");
    }

    private InputStream getInputStream(MultipartFile file) {
        try {
            return file.getInputStream();
        } catch (IOException ioe) {
            throw new RuntimeException("Couldn't read the given file", ioe);
        }
    }
}
