package com.bank.domain.validation;

import com.bank.domain.input.CustomerStatementRecord;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
public final class CsrValidationResult {
    private final CustomerStatementRecord customerStatementRecord;
    private final List<String> validationErrors;

    public CsrValidationResult(final CustomerStatementRecord customerStatementRecord,
                               final List<String> validationErrors) {
        Objects.requireNonNull(customerStatementRecord);
        this.customerStatementRecord = customerStatementRecord;
        this.validationErrors = validationErrors;
    }
}
