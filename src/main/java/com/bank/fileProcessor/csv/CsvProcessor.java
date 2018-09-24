package com.bank.fileProcessor.csv;

import com.bank.domain.input.CustomerStatementInput;
import com.bank.domain.exception.BadRequestException;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public final class CsvProcessor {
    private CsvProcessor(){}

    public static CustomerStatementInput process(InputStream inputStream) {
        List<CsvStatementRecord> csvStatementRecords;
        try {
            csvStatementRecords = new CsvToBeanBuilder<CsvStatementRecord>(new BufferedReader(new InputStreamReader(inputStream)))
                                            .withOrderedResults(false)
                                            .withType(CsvStatementRecord.class)
                                            .build()
                                            .parse();
        } catch (NumberFormatException | IllegalStateException exception) {
            throw new BadRequestException("Invalid CSV file", exception);
        }
        return CsvToDomainMapper.mapStatementRecordList(csvStatementRecords);
    }
}
