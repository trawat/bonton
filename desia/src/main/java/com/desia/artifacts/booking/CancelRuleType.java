
package com.desia.artifacts.booking;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CancelRuleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CancelRuleType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PaymentCard" type="{http://www.opentravel.org/OTA/2003/05}PaymentCardType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="CancelByDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Percent" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DecimalPlaces" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancelRuleType", propOrder = {
    "paymentCard"
})
public class CancelRuleType {

    @XmlElement(name = "PaymentCard")
    protected PaymentCardType paymentCard;
    @XmlAttribute(name = "CancelByDate")
    protected String cancelByDate;
    @XmlAttribute(name = "Percent")
    protected BigDecimal percent;
    @XmlAttribute(name = "Type")
    protected String type;
    @XmlAttribute(name = "Amount")
    protected BigDecimal amount;
    @XmlAttribute(name = "CurrencyCode")
    protected String currencyCode;
    @XmlAttribute(name = "DecimalPlaces")
    protected BigInteger decimalPlaces;

    /**
     * Gets the value of the paymentCard property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentCardType }
     *     
     */
    public PaymentCardType getPaymentCard() {
        return paymentCard;
    }

    /**
     * Sets the value of the paymentCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentCardType }
     *     
     */
    public void setPaymentCard(PaymentCardType value) {
        this.paymentCard = value;
    }

    /**
     * Gets the value of the cancelByDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancelByDate() {
        return cancelByDate;
    }

    /**
     * Sets the value of the cancelByDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancelByDate(String value) {
        this.cancelByDate = value;
    }

    /**
     * Gets the value of the percent property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPercent() {
        return percent;
    }

    /**
     * Sets the value of the percent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPercent(BigDecimal value) {
        this.percent = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the decimalPlaces property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDecimalPlaces() {
        return decimalPlaces;
    }

    /**
     * Sets the value of the decimalPlaces property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDecimalPlaces(BigInteger value) {
        this.decimalPlaces = value;
    }

}
