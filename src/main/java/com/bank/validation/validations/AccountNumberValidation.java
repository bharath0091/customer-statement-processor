package com.bank.validation.validations;

import com.bank.domain.input.CustomerStatementInput;
import com.bank.domain.input.CustomerStatementRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class AccountNumberValidation implements Validation{

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^\\d+$");

    public List<String> validate(final CustomerStatementInput csrInput, final CustomerStatementRecord recordToValidate) {
        List<String> errors = new ArrayList<>();
        if (recordToValidate.getAccountNumber() == null || recordToValidate.getAccountNumber().length() != 18) {
            errors.add("Invalid IBAN"); // There would be more rules on IBAN, adding simple length check to start with
        }
        return errors;
    }
}
