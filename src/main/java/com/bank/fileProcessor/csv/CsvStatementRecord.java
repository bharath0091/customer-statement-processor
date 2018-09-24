package com.bank.fileProcessor.csv;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CsvStatementRecord {
    @CsvBindByName
    private String reference;

    @CsvBindByName
    private String accountNumber;

    @CsvBindByName
    private String description;

    @CsvBindByName(column = "Start Balance")
    private String startBalance;

    @CsvBindByName
    private String mutation;

    @CsvBindByName(column = "End Balance")
    private String endBalance;
}
