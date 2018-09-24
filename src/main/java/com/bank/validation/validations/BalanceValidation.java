package com.bank.validation.validations;

import com.bank.domain.input.CustomerStatementInput;
import com.bank.domain.input.CustomerStatementRecord;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class BalanceValidation implements Validation {

    private static final int SCALE = 2;

    public List<String> validate(final CustomerStatementInput csrInput, final CustomerStatementRecord recordToValidate) {
        List<String> errors = new ArrayList<>();
        BigDecimal startBalance = getBigDecimalValue(recordToValidate.getStartBalance());
        BigDecimal mutation = getBigDecimalValue(recordToValidate.getMutation());
        BigDecimal endBalance = getBigDecimalValue(recordToValidate.getEndBalance());

        if (startBalance == null || mutation == null || endBalance == null) {
            errors.add("Invalid StartBalance or Mutation or End Balance");
        } else if (!startBalance.add(mutation).equals(endBalance)) {
            errors.add("Invalid end balance calculation");
        }
        return errors;
    }

    private BigDecimal getBigDecimalValue(String startBalance) {
        try {
            return new BigDecimal(startBalance).setScale(SCALE);
        } catch (NumberFormatException exception) {
            return null;
        }
    }
}
