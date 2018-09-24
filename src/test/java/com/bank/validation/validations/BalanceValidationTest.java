package com.bank.validation.validations;

import com.bank.domain.input.CustomerStatementInput;
import com.bank.domain.input.CustomerStatementRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BalanceValidationTest {

    private Validation balanceValidation = new BalanceValidation();

    @Test
    @DisplayName("Validate End Balance When the start, mutation and end balance have valid numbers")
    void validateSuccessEndBalance() {
        CustomerStatementRecord customerStatementRecord = new CustomerStatementRecord("194261",
                                                        "NL91RABO0315273637",
                                                        "Clothes from Jan Bakker",
                                                        "21.6",
                                                          "-41.83",
                                                        "-20.23");

        List<String> errors = balanceValidation.validate(new CustomerStatementInput(Arrays.asList(customerStatementRecord)), customerStatementRecord);
        assertEquals(0, errors.size());
    }

    @Test
    @DisplayName("Incorrect End Balance calculation")
    void validateFailEndBalance() {
        CustomerStatementRecord customerStatementRecord = new CustomerStatementRecord("194261",
                                                    "NL91RABO0315273637",
                                                    "Clothes from Jan Bakker",
                                                    "21.6",
                                                    "1.00",
                                                    "21.6");

        List<String> errors = balanceValidation.validate(new CustomerStatementInput(Arrays.asList(customerStatementRecord)), customerStatementRecord);
        assertTrue(errors.equals(Arrays.asList("Invalid end balance calculation")));
    }

    @Test
    @DisplayName("Start Balance as invalid number")
    void validateFailStartBalance() {
        CustomerStatementRecord customerStatementRecord = new CustomerStatementRecord("194261",
                                                    "NL91RABO0315273637",
                                                    "Clothes from Jan Bakker",
                                                    "",
                                                    "1.00",
                                                    "21.6");

        List<String> errors = balanceValidation.validate(new CustomerStatementInput(Arrays.asList(customerStatementRecord)), customerStatementRecord);
        assertTrue(errors.equals(Arrays.asList("Invalid StartBalance or Mutation or End Balance")));
    }
}