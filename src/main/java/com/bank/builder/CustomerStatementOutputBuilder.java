package com.bank.builder;

import com.bank.domain.output.CustomerStatementOutput;
import com.bank.domain.output.CustomerStatementRecord;
import com.bank.domain.validation.CsrValidationResult;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class CustomerStatementOutputBuilder {
    private CustomerStatementOutputBuilder() {}

    public static CustomerStatementOutput build(List<CsrValidationResult> validationResults) {
     return new CustomerStatementOutput(
                    validationResults.parallelStream()
                            .filter(validationResult -> validationResult.getValidationErrors().size() > 0)
                            .map(prepareFailedCsrFunction())
                            .collect(Collectors.toList())
            );
    }

    private static Function<CsrValidationResult, CustomerStatementRecord> prepareFailedCsrFunction() {
        return csrValidationResult ->
                new CustomerStatementRecord(csrValidationResult.getCustomerStatementRecord().getReference(),
                        csrValidationResult.getCustomerStatementRecord().getDescription(),
                        csrValidationResult.getValidationErrors());
    }

}
