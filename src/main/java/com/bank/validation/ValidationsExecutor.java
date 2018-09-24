package com.bank.validation;

import com.bank.domain.input.CustomerStatementInput;
import com.bank.domain.validation.CsrValidationResult;

import java.util.List;

public interface ValidationsExecutor {
    public List<CsrValidationResult> execute(CustomerStatementInput csrInput);
}
