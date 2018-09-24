package com.bank.validation.validations;

import com.bank.domain.input.CustomerStatementInput;
import com.bank.domain.input.CustomerStatementRecord;

import java.util.List;

public interface Validation {
    public List<String> validate(CustomerStatementInput csrInput, CustomerStatementRecord recordToValidate);
}
