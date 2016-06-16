
package com.desia.artifacts.booking;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TotalType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TotalType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Taxes" type="{http://www.opentravel.org/OTA/2003/05}TaxesType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="AdditionalFeesExcludedIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="AmountAfterTax" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="AmountBeforeTax" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="AmountIncludingMarkup" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="RateOverrideIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="ServiceOverrideIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="editCommission" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="editNetRate" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="editSellRate" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="editServiceCharge" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="editServiceTax" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="editTotalTax" type="{http://www.w3.org/2001/XMLSchema}decimal" />
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
@XmlType(name = "TotalType", propOrder = {
    "taxes"
})
@XmlSeeAlso({
    DiscountType.class,
    com.desia.artifacts.booking.RateUploadType.BaseByGuestAmts.BaseByGuestAmt.class
})
public class TotalType {

    @XmlElement(name = "Taxes")
    protected TaxesType taxes;
    @XmlAttribute(name = "AdditionalFeesExcludedIndicator")
    protected Boolean additionalFeesExcludedIndicator;
    @XmlAttribute(name = "AmountAfterTax")
    protected BigDecimal amountAfterTax;
    @XmlAttribute(name = "AmountBeforeTax")
    protected BigDecimal amountBeforeTax;
    @XmlAttribute(name = "AmountIncludingMarkup")
    protected BigDecimal amountIncludingMarkup;
    @XmlAttribute(name = "RateOverrideIndicator")
    protected Boolean rateOverrideIndicator;
    @XmlAttribute(name = "ServiceOverrideIndicator")
    protected Boolean serviceOverrideIndicator;
    @XmlAttribute(name = "Type")
    protected String type;
    @XmlAttribute(name = "editCommission")
    protected BigDecimal editCommission;
    @XmlAttribute(name = "editNetRate")
    protected BigDecimal editNetRate;
    @XmlAttribute(name = "editSellRate")
    protected BigDecimal editSellRate;
    @XmlAttribute(name = "editServiceCharge")
    protected BigDecimal editServiceCharge;
    @XmlAttribute(name = "editServiceTax")
    protected BigDecimal editServiceTax;
    @XmlAttribute(name = "editTotalTax")
    protected BigDecimal editTotalTax;
    @XmlAttribute(name = "CurrencyCode")
    protected String currencyCode;
    @XmlAttribute(name = "DecimalPlaces")
    protected BigInteger decimalPlaces;

    /**
     * Gets the value of the taxes property.
     * 
     * @return
     *     possible object is
     *     {@link TaxesType }
     *     
     */
    public TaxesType getTaxes() {
        return taxes;
    }

    /**
     * Sets the value of the taxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxesType }
     *     
     */
    public void setTaxes(TaxesType value) {
        this.taxes = value;
    }

    /**
     * Gets the value of the additionalFeesExcludedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAdditionalFeesExcludedIndicator() {
        return additionalFeesExcludedIndicator;
    }

    /**
     * Sets the value of the additionalFeesExcludedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAdditionalFeesExcludedIndicator(Boolean value) {
        this.additionalFeesExcludedIndicator = value;
    }

    /**
     * Gets the value of the amountAfterTax property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountAfterTax() {
        return amountAfterTax;
    }

    /**
     * Sets the value of the amountAfterTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountAfterTax(BigDecimal value) {
        this.amountAfterTax = value;
    }

    /**
     * Gets the value of the amountBeforeTax property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountBeforeTax() {
        return amountBeforeTax;
    }

    /**
     * Sets the value of the amountBeforeTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountBeforeTax(BigDecimal value) {
        this.amountBeforeTax = value;
    }

    /**
     * Gets the value of the amountIncludingMarkup property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountIncludingMarkup() {
        return amountIncludingMarkup;
    }

    /**
     * Sets the value of the amountIncludingMarkup property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountIncludingMarkup(BigDecimal value) {
        this.amountIncludingMarkup = value;
    }

    /**
     * Gets the value of the rateOverrideIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRateOverrideIndicator() {
        return rateOverrideIndicator;
    }

    /**
     * Sets the value of the rateOverrideIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRateOverrideIndicator(Boolean value) {
        this.rateOverrideIndicator = value;
    }

    /**
     * Gets the value of the serviceOverrideIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isServiceOverrideIndicator() {
        return serviceOverrideIndicator;
    }

    /**
     * Sets the value of the serviceOverrideIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setServiceOverrideIndicator(Boolean value) {
        this.serviceOverrideIndicator = value;
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
     * Gets the value of the editCommission property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEditCommission() {
        return editCommission;
    }

    /**
     * Sets the value of the editCommission property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEditCommission(BigDecimal value) {
        this.editCommission = value;
    }

    /**
     * Gets the value of the editNetRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEditNetRate() {
        return editNetRate;
    }

    /**
     * Sets the value of the editNetRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEditNetRate(BigDecimal value) {
        this.editNetRate = value;
    }

    /**
     * Gets the value of the editSellRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEditSellRate() {
        return editSellRate;
    }

    /**
     * Sets the value of the editSellRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEditSellRate(BigDecimal value) {
        this.editSellRate = value;
    }

    /**
     * Gets the value of the editServiceCharge property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEditServiceCharge() {
        return editServiceCharge;
    }

    /**
     * Sets the value of the editServiceCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEditServiceCharge(BigDecimal value) {
        this.editServiceCharge = value;
    }

    /**
     * Gets the value of the editServiceTax property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEditServiceTax() {
        return editServiceTax;
    }

    /**
     * Sets the value of the editServiceTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEditServiceTax(BigDecimal value) {
        this.editServiceTax = value;
    }

    /**
     * Gets the value of the editTotalTax property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEditTotalTax() {
        return editTotalTax;
    }

    /**
     * Sets the value of the editTotalTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEditTotalTax(BigDecimal value) {
        this.editTotalTax = value;
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
