package com.bank.fileProcessor;

import com.bank.domain.input.CustomerStatementInput;
import com.bank.fileProcessor.csv.CsvProcessor;
import com.bank.fileProcessor.xml.XmlProcessor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Optional;
import java.util.function.Function;

@Component
@Log
public final class GetFileProcessorByContentType {

    private GetFileProcessorByContentType(){}

    public static Optional<Function<InputStream, CustomerStatementInput>> get(String contentType) {
        Function<InputStream, CustomerStatementInput> specificFileProcessor = null;
        switch (FileType.getFileType(contentType)) {
            case CSV:
                specificFileProcessor = CsvProcessor::process;
                break;
            case XML:
                specificFileProcessor = XmlProcessor::process;
                break;
        }
        return Optional.ofNullable(specificFileProcessor);
    }
}
