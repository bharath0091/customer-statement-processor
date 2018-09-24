package com.bank.domain.output;


import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

/**
 * Immutable
 */

@Getter
@ToString
@Slf4j
public final class CustomerStatementRecord {
    private final String reference;
    private final String description;
    private final List<String> errors;

    public CustomerStatementRecord(final String reference, final String description, final List<String> errors) {
        this.reference = reference;
        this.description = description;
        this.errors = Collections.unmodifiableList(errors);
    }
}
