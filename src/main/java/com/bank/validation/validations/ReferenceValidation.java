package com.bank.validation.validations;

import com.bank.domain.input.CustomerStatementInput;
import com.bank.domain.input.CustomerStatementRecord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

class ReferenceValidation implements Validation{

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^\\d+$");

    public List<String> validate(final CustomerStatementInput csrInput, final CustomerStatementRecord recordToValidate) {
        List<String> errors = new ArrayList<>();
        if (!NUMBER_PATTERN.matcher(recordToValidate.getReference()).matches()) {
            errors.add("Invalid Transaction reference");
        } else if (Collections.frequency(csrInput.getCustomerStatementRecords(), recordToValidate) > 1) {
            errors.add("Duplicate Transaction reference");
        }
        return errors;
    }
}
