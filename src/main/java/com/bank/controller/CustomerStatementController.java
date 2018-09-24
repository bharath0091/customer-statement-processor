package com.bank.controller;

import com.bank.domain.output.CustomerStatementOutput;
import com.bank.domain.exception.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@RestController
@Slf4j
public class CustomerStatementController {

    @Autowired
    private CustomerStatementOrchestrator customerStatementOrchestrator;

    @PostMapping("/customer-statement")
    public ResponseEntity<CustomerStatementOutput> handleCsrFile(@NotNull @RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(customerStatementOrchestrator.process(file));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestException(RuntimeException exception) {
        log.info("BadRequestException", exception);
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<?> multipartException(MultipartException exception) {
        log.info("MultipartException", exception);
        return ResponseEntity.badRequest().body("Invalid file");
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runtimeException(RuntimeException exception) {
        log.warn("RuntimeException", exception);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Couldn't process the request, Internal error");
    }
}
