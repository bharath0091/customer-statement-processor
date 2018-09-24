package com.bank.domain.input;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public final class CustomerStatementInput {
    private final List<CustomerStatementRecord> customerStatementRecords;

    public CustomerStatementInput(final List<CustomerStatementRecord> customerStatementRecords) {
        this.customerStatementRecords = Collections.unmodifiableList(customerStatementRecords);
    }
}
