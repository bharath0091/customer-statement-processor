package com.bank.fileProcessor.xml;

import com.bank.domain.input.CustomerStatementInput;
import com.bank.domain.exception.BadRequestException;
import com.bank.fileProcessor.xml.generated.Records;

import javax.xml.bind.JAXBException;
import java.io.InputStream;

public final class XmlProcessor {
    private XmlProcessor(){}

    public static CustomerStatementInput process(InputStream inputStream) {
        Records xmlStatementRecordList;
        try {
            xmlStatementRecordList = JaxbUnmarshallUtil.unmarshall(inputStream, Records.class);
        } catch (JAXBException exception) {
            throw new BadRequestException("Invalid XML file", exception);
        }
        return XmlToDomainMapper.mapStatementRecordList(xmlStatementRecordList);
    }
}
