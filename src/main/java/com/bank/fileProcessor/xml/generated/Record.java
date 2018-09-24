
package com.bank.fileProcessor.xml.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}accountNumber" minOccurs="0"/>
 *         &lt;element ref="{}description" minOccurs="0"/>
 *         &lt;element ref="{}startBalance" minOccurs="0"/>
 *         &lt;element ref="{}mutation" minOccurs="0"/>
 *         &lt;element ref="{}endBalance" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="reference" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "accountNumber",
    "description",
    "startBalance",
    "mutation",
    "endBalance"
})
@XmlRootElement(name = "record")
public class Record {

    protected String accountNumber;
    protected String description;
    protected String startBalance;
    protected String mutation;
    protected String endBalance;
    @XmlAttribute(name = "reference")
    protected String reference;

    /**
     * Gets the value of the accountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the startBalance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartBalance() {
        return startBalance;
    }

    /**
     * Sets the value of the startBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartBalance(String value) {
        this.startBalance = value;
    }

    /**
     * Gets the value of the mutation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMutation() {
        return mutation;
    }

    /**
     * Sets the value of the mutation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMutation(String value) {
        this.mutation = value;
    }

    /**
     * Gets the value of the endBalance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndBalance() {
        return endBalance;
    }

    /**
     * Sets the value of the endBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndBalance(String value) {
        this.endBalance = value;
    }

    /**
     * Gets the value of the reference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference(String value) {
        this.reference = value;
    }

}
