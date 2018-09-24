package com.bank.fileProcessor.xml;

import com.bank.domain.input.CustomerStatementInput;
import com.bank.domain.input.CustomerStatementRecord;
import com.bank.fileProcessor.xml.generated.Record;
import com.bank.fileProcessor.xml.generated.Records;

import java.util.List;
import java.util.stream.Collectors;

public final class XmlToDomainMapper {

    private XmlToDomainMapper(){}

    public static CustomerStatementInput mapStatementRecordList(Records xmlStatementRecordList) {
        List<CustomerStatementRecord> records = xmlStatementRecordList.getRecord().parallelStream()
                                                        .map(XmlToDomainMapper::mapStatementRecord)
                                                        .collect(Collectors.toList());
        return new CustomerStatementInput(records);
    }

    private static CustomerStatementRecord mapStatementRecord(Record record) {
        return new CustomerStatementRecord(
                    record.getReference(),
                    record.getAccountNumber(),
                    record.getDescription(),
                    record.getStartBalance(),
                    record.getMutation(),
                    record.getEndBalance()
        );
    }
}
