package com.bank.validation;

import com.bank.domain.input.CustomerStatementInput;
import com.bank.domain.input.CustomerStatementRecord;
import com.bank.domain.validation.CsrValidationResult;
import com.bank.validation.validations.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ValidationsExecutorImpl implements ValidationsExecutor {

    @Autowired
    private List<Validation> configuredValidations;

    public List<CsrValidationResult> execute(final CustomerStatementInput csrInput) {
        return  csrInput.getCustomerStatementRecords().parallelStream()
                .map(validationResultFunction(csrInput))
                .collect(Collectors.toList());

    }

    private Function<CustomerStatementRecord, CsrValidationResult> validationResultFunction(final CustomerStatementInput csrInput) {
        return customerStatementRecord -> {
            List<String> errors = configuredValidations.stream()
                                        .map(validation -> validation.validate(csrInput, customerStatementRecord))
                                        .flatMap(List::stream)
                                        .collect(Collectors.toList());
            return new CsrValidationResult(customerStatementRecord, errors);
        };
    }
}
