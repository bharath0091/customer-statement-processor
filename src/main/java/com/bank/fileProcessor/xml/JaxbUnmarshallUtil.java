package com.bank.fileProcessor.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.InputStream;

public final class JaxbUnmarshallUtil {
    private JaxbUnmarshallUtil(){}

    public static <T> T unmarshall(InputStream inputStream, Class<T> theClass) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(theClass);
        return (T)jaxbContext.createUnmarshaller().unmarshal(inputStream);
    }
}
