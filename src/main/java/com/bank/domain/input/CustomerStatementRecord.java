package com.bank.domain.input;


import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * Immutable
 */

@Getter
@ToString
@Slf4j
public final class CustomerStatementRecord {
    private final String reference;
    private final String accountNumber;
    private final String description;
    private final String startBalance;
    private final String mutation;
    private final String endBalance;


    public CustomerStatementRecord(String reference, String accountNumber, String description, String startBalance, String mutation, String endBalance) {
        this.reference = reference;
        this.accountNumber = accountNumber;
        this.description = description;
        this.startBalance = startBalance;
        this.mutation = mutation;
        this.endBalance = endBalance;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        CustomerStatementRecord that = (CustomerStatementRecord) obj;

        return reference != null ? reference.equals(that.reference) : that.reference == null;
    }

    @Override
    public int hashCode() {
        return reference != null ? reference.hashCode() : 0;
    }
}
