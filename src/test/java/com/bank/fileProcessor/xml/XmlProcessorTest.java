package com.bank.fileProcessor.xml;

import com.bank.domain.input.CustomerStatementInput;
import com.bank.domain.exception.BadRequestException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XmlProcessorTest {

    @Test
    @DisplayName("Invalid input stream, expect bad request exception")
    void processFailInvalidStream() {
        assertThrows(BadRequestException.class, () -> XmlProcessor.process(getClass().getResourceAsStream("/invalidRecords.xml")));
    }

    @Test
    @DisplayName("Valid input steam and expect success response")
    void processSuccessValidStream() {
        CustomerStatementInput csrInput = XmlProcessor.process(getClass().getResourceAsStream("/records.xml"));

        assertEquals("130498", csrInput.getCustomerStatementRecords().get(0).getReference());
        assertEquals("NL69ABNA0433647324", csrInput.getCustomerStatementRecords().get(0).getAccountNumber());
        assertEquals("Tickets for Peter", csrInput.getCustomerStatementRecords().get(0).getDescription());
        assertEquals("26.9", csrInput.getCustomerStatementRecords().get(0).getStartBalance());
        assertEquals("-18.78", csrInput.getCustomerStatementRecords().get(0).getMutation());
        assertEquals("8.12", csrInput.getCustomerStatementRecords().get(0).getEndBalance());
    }
}