package com.bank.validation.validations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ValidationsConfig {

    @Bean
    public List<Validation> configuredValidations() {
        return Arrays.asList(
                new ReferenceValidation(),
                new AccountNumberValidation(),
                new BalanceValidation()
        );
    }
}
