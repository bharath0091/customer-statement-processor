package com.bank.domain.output;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public final class CustomerStatementOutput {
    private final List<CustomerStatementRecord> failedCsrRecords;

    public CustomerStatementOutput(final List<CustomerStatementRecord> failedCsrRecords) {
        this.failedCsrRecords = Collections.unmodifiableList(failedCsrRecords);
    }
}
