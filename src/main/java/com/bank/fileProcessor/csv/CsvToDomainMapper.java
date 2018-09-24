package com.bank.fileProcessor.csv;

import com.bank.domain.input.CustomerStatementInput;
import com.bank.domain.input.CustomerStatementRecord;

import java.util.List;
import java.util.stream.Collectors;

public final class CsvToDomainMapper {

    private CsvToDomainMapper(){}

    public static CustomerStatementInput mapStatementRecordList(List<CsvStatementRecord> csvStatementRecords) {
        List<CustomerStatementRecord> records = csvStatementRecords.parallelStream()
                                                    .map(CsvToDomainMapper::mapStatementRecord)
                                                    .collect(Collectors.toList());
        return new CustomerStatementInput(records);
    }

    private static CustomerStatementRecord mapStatementRecord(CsvStatementRecord csvStatementRecord) {
        return new CustomerStatementRecord(
                    csvStatementRecord.getReference(),
                    csvStatementRecord.getAccountNumber(),
                    csvStatementRecord.getDescription(),
                    csvStatementRecord.getStartBalance(),
                    csvStatementRecord.getMutation(),
                    csvStatementRecord.getEndBalance()
        );
    }
}
