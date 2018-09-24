
package com.bank.fileProcessor.xml.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.bank.fileProcessor.xml.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Mutation_QNAME = new QName("", "mutation");
    private final static QName _EndBalance_QNAME = new QName("", "endBalance");
    private final static QName _Description_QNAME = new QName("", "description");
    private final static QName _AccountNumber_QNAME = new QName("", "accountNumber");
    private final static QName _StartBalance_QNAME = new QName("", "startBalance");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bank.fileProcessor.xml.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Records }
     * 
     */
    public Records createRecords() {
        return new Records();
    }

    /**
     * Create an instance of {@link Record }
     * 
     */
    public Record createRecord() {
        return new Record();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "mutation")
    public JAXBElement<String> createMutation(String value) {
        return new JAXBElement<String>(_Mutation_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "endBalance")
    public JAXBElement<String> createEndBalance(String value) {
        return new JAXBElement<String>(_EndBalance_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "description")
    public JAXBElement<String> createDescription(String value) {
        return new JAXBElement<String>(_Description_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "accountNumber")
    public JAXBElement<String> createAccountNumber(String value) {
        return new JAXBElement<String>(_AccountNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "startBalance")
    public JAXBElement<String> createStartBalance(String value) {
        return new JAXBElement<String>(_StartBalance_QNAME, String.class, null, value);
    }

}
