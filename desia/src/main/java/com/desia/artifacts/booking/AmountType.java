
package com.desia.artifacts.booking;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AmountType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AmountType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Base" type="{http://www.opentravel.org/OTA/2003/05}TotalType" minOccurs="0"/>
 *         &lt;element name="AdditionalGuestAmounts" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="AdditionalGuestAmount" type="{http://www.opentravel.org/OTA/2003/05}AdditionalGuestAmountType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="AmountAfterTax" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                 &lt;attribute name="AmountBeforeTax" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                 &lt;attribute name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="DecimalPlaces" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Fees" type="{http://www.opentravel.org/OTA/2003/05}FeesType" minOccurs="0"/>
 *         &lt;element name="CancelPolicies" type="{http://www.opentravel.org/OTA/2003/05}CancelPenaltiesType" minOccurs="0"/>
 *         &lt;element name="PaymentPolicies" type="{http://www.opentravel.org/OTA/2003/05}RequiredPaymentsType" minOccurs="0"/>
 *         &lt;element name="Discount" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}DiscountType">
 *                 &lt;sequence>
 *                 &lt;/sequence>
 *                 &lt;attribute name="AppliesTo" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="ItemRPH" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Total" type="{http://www.opentravel.org/OTA/2003/05}TotalType" minOccurs="0"/>
 *         &lt;element name="RateDescription" type="{http://www.opentravel.org/OTA/2003/05}ParagraphType" minOccurs="0"/>
 *         &lt;element name="AdditionalCharges" type="{http://www.opentravel.org/OTA/2003/05}HotelAdditionalChargesType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="AlternateCurrencyInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="ChargeType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="GuaranteedInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="MaxGuestApplicable" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="MaxLOS" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="MinGuestApplicable" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="MinLOS" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="NumberOfUnits" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="QuoteID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RateTimeUnit" type="{http://www.opentravel.org/OTA/2003/05}timeUnitType" />
 *       &lt;attribute name="StayOverDate" type="{http://www.opentravel.org/OTA/2003/05}dayOfWeekType" />
 *       &lt;attribute name="UnitMultiplier" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="AgeBucket" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AgeQualifyingCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AgeTimeUnit" type="{http://www.opentravel.org/OTA/2003/05}timeUnitType" />
 *       &lt;attribute name="MaxAge" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="MinAge" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="ExpireDate" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="ExpireDateExclusiveIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmountType", propOrder = {
    "base",
    "additionalGuestAmounts",
    "fees",
    "cancelPolicies",
    "paymentPolicies",
    "discount",
    "total",
    "rateDescription",
    "additionalCharges"
})
@XmlSeeAlso({
    com.desia.artifacts.booking.RateType.Rate.class
})
public class AmountType {

    @XmlElement(name = "Base")
    protected TotalType base;
    @XmlElement(name = "AdditionalGuestAmounts")
    protected AmountType.AdditionalGuestAmounts additionalGuestAmounts;
    @XmlElement(name = "Fees")
    protected FeesType fees;
    @XmlElement(name = "CancelPolicies")
    protected CancelPenaltiesType cancelPolicies;
    @XmlElement(name = "PaymentPolicies")
    protected RequiredPaymentsType paymentPolicies;
    @XmlElement(name = "Discount")
    protected List<AmountType.Discount> discount;
    @XmlElement(name = "Total")
    protected TotalType total;
    @XmlElement(name = "RateDescription")
    protected ParagraphType rateDescription;
    @XmlElement(name = "AdditionalCharges")
    protected HotelAdditionalChargesType additionalCharges;
    @XmlAttribute(name = "AlternateCurrencyInd")
    protected Boolean alternateCurrencyInd;
    @XmlAttribute(name = "ChargeType")
    protected String chargeType;
    @XmlAttribute(name = "GuaranteedInd")
    protected Boolean guaranteedInd;
    @XmlAttribute(name = "MaxGuestApplicable")
    protected BigInteger maxGuestApplicable;
    @XmlAttribute(name = "MaxLOS")
    protected BigInteger maxLOS;
    @XmlAttribute(name = "MinGuestApplicable")
    protected BigInteger minGuestApplicable;
    @XmlAttribute(name = "MinLOS")
    protected BigInteger minLOS;
    @XmlAttribute(name = "NumberOfUnits")
    protected BigInteger numberOfUnits;
    @XmlAttribute(name = "QuoteID")
    protected String quoteID;
    @XmlAttribute(name = "RateTimeUnit")
    protected TimeUnitType rateTimeUnit;
    @XmlAttribute(name = "StayOverDate")
    protected DayOfWeekType stayOverDate;
    @XmlAttribute(name = "UnitMultiplier")
    protected BigInteger unitMultiplier;
    @XmlAttribute(name = "AgeBucket")
    protected String ageBucket;
    @XmlAttribute(name = "AgeQualifyingCode")
    protected String ageQualifyingCode;
    @XmlAttribute(name = "AgeTimeUnit")
    protected TimeUnitType ageTimeUnit;
    @XmlAttribute(name = "MaxAge")
    protected Integer maxAge;
    @XmlAttribute(name = "MinAge")
    protected Integer minAge;
    @XmlAttribute(name = "EffectiveDate")
    @XmlSchemaType(name = "anySimpleType")
    protected String effectiveDate;
    @XmlAttribute(name = "ExpireDate")
    @XmlSchemaType(name = "anySimpleType")
    protected String expireDate;
    @XmlAttribute(name = "ExpireDateExclusiveIndicator")
    protected Boolean expireDateExclusiveIndicator;

    /**
     * Gets the value of the base property.
     * 
     * @return
     *     possible object is
     *     {@link TotalType }
     *     
     */
    public TotalType getBase() {
        return base;
    }

    /**
     * Sets the value of the base property.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalType }
     *     
     */
    public void setBase(TotalType value) {
        this.base = value;
    }

    /**
     * Gets the value of the additionalGuestAmounts property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType.AdditionalGuestAmounts }
     *     
     */
    public AmountType.AdditionalGuestAmounts getAdditionalGuestAmounts() {
        return additionalGuestAmounts;
    }

    /**
     * Sets the value of the additionalGuestAmounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType.AdditionalGuestAmounts }
     *     
     */
    public void setAdditionalGuestAmounts(AmountType.AdditionalGuestAmounts value) {
        this.additionalGuestAmounts = value;
    }

    /**
     * Gets the value of the fees property.
     * 
     * @return
     *     possible object is
     *     {@link FeesType }
     *     
     */
    public FeesType getFees() {
        return fees;
    }

    /**
     * Sets the value of the fees property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeesType }
     *     
     */
    public void setFees(FeesType value) {
        this.fees = value;
    }

    /**
     * Gets the value of the cancelPolicies property.
     * 
     * @return
     *     possible object is
     *     {@link CancelPenaltiesType }
     *     
     */
    public CancelPenaltiesType getCancelPolicies() {
        return cancelPolicies;
    }

    /**
     * Sets the value of the cancelPolicies property.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelPenaltiesType }
     *     
     */
    public void setCancelPolicies(CancelPenaltiesType value) {
        this.cancelPolicies = value;
    }

    /**
     * Gets the value of the paymentPolicies property.
     * 
     * @return
     *     possible object is
     *     {@link RequiredPaymentsType }
     *     
     */
    public RequiredPaymentsType getPaymentPolicies() {
        return paymentPolicies;
    }

    /**
     * Sets the value of the paymentPolicies property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequiredPaymentsType }
     *     
     */
    public void setPaymentPolicies(RequiredPaymentsType value) {
        this.paymentPolicies = value;
    }

    /**
     * Gets the value of the discount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the discount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDiscount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType.Discount }
     * 
     * 
     */
    public List<AmountType.Discount> getDiscount() {
        if (discount == null) {
            discount = new ArrayList<AmountType.Discount>();
        }
        return this.discount;
    }

    /**
     * Gets the value of the total property.
     * 
     * @return
     *     possible object is
     *     {@link TotalType }
     *     
     */
    public TotalType getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalType }
     *     
     */
    public void setTotal(TotalType value) {
        this.total = value;
    }

    /**
     * Gets the value of the rateDescription property.
     * 
     * @return
     *     possible object is
     *     {@link ParagraphType }
     *     
     */
    public ParagraphType getRateDescription() {
        return rateDescription;
    }

    /**
     * Sets the value of the rateDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParagraphType }
     *     
     */
    public void setRateDescription(ParagraphType value) {
        this.rateDescription = value;
    }

    /**
     * Gets the value of the additionalCharges property.
     * 
     * @return
     *     possible object is
     *     {@link HotelAdditionalChargesType }
     *     
     */
    public HotelAdditionalChargesType getAdditionalCharges() {
        return additionalCharges;
    }

    /**
     * Sets the value of the additionalCharges property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelAdditionalChargesType }
     *     
     */
    public void setAdditionalCharges(HotelAdditionalChargesType value) {
        this.additionalCharges = value;
    }

    /**
     * Gets the value of the alternateCurrencyInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAlternateCurrencyInd() {
        return alternateCurrencyInd;
    }

    /**
     * Sets the value of the alternateCurrencyInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAlternateCurrencyInd(Boolean value) {
        this.alternateCurrencyInd = value;
    }

    /**
     * Gets the value of the chargeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargeType() {
        return chargeType;
    }

    /**
     * Sets the value of the chargeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargeType(String value) {
        this.chargeType = value;
    }

    /**
     * Gets the value of the guaranteedInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGuaranteedInd() {
        return guaranteedInd;
    }

    /**
     * Sets the value of the guaranteedInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGuaranteedInd(Boolean value) {
        this.guaranteedInd = value;
    }

    /**
     * Gets the value of the maxGuestApplicable property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxGuestApplicable() {
        return maxGuestApplicable;
    }

    /**
     * Sets the value of the maxGuestApplicable property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxGuestApplicable(BigInteger value) {
        this.maxGuestApplicable = value;
    }

    /**
     * Gets the value of the maxLOS property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxLOS() {
        return maxLOS;
    }

    /**
     * Sets the value of the maxLOS property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxLOS(BigInteger value) {
        this.maxLOS = value;
    }

    /**
     * Gets the value of the minGuestApplicable property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMinGuestApplicable() {
        return minGuestApplicable;
    }

    /**
     * Sets the value of the minGuestApplicable property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMinGuestApplicable(BigInteger value) {
        this.minGuestApplicable = value;
    }

    /**
     * Gets the value of the minLOS property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMinLOS() {
        return minLOS;
    }

    /**
     * Sets the value of the minLOS property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMinLOS(BigInteger value) {
        this.minLOS = value;
    }

    /**
     * Gets the value of the numberOfUnits property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfUnits() {
        return numberOfUnits;
    }

    /**
     * Sets the value of the numberOfUnits property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfUnits(BigInteger value) {
        this.numberOfUnits = value;
    }

    /**
     * Gets the value of the quoteID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuoteID() {
        return quoteID;
    }

    /**
     * Sets the value of the quoteID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuoteID(String value) {
        this.quoteID = value;
    }

    /**
     * Gets the value of the rateTimeUnit property.
     * 
     * @return
     *     possible object is
     *     {@link TimeUnitType }
     *     
     */
    public TimeUnitType getRateTimeUnit() {
        return rateTimeUnit;
    }

    /**
     * Sets the value of the rateTimeUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeUnitType }
     *     
     */
    public void setRateTimeUnit(TimeUnitType value) {
        this.rateTimeUnit = value;
    }

    /**
     * Gets the value of the stayOverDate property.
     * 
     * @return
     *     possible object is
     *     {@link DayOfWeekType }
     *     
     */
    public DayOfWeekType getStayOverDate() {
        return stayOverDate;
    }

    /**
     * Sets the value of the stayOverDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DayOfWeekType }
     *     
     */
    public void setStayOverDate(DayOfWeekType value) {
        this.stayOverDate = value;
    }

    /**
     * Gets the value of the unitMultiplier property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getUnitMultiplier() {
        return unitMultiplier;
    }

    /**
     * Sets the value of the unitMultiplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setUnitMultiplier(BigInteger value) {
        this.unitMultiplier = value;
    }

    /**
     * Gets the value of the ageBucket property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgeBucket() {
        return ageBucket;
    }

    /**
     * Sets the value of the ageBucket property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgeBucket(String value) {
        this.ageBucket = value;
    }

    /**
     * Gets the value of the ageQualifyingCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgeQualifyingCode() {
        return ageQualifyingCode;
    }

    /**
     * Sets the value of the ageQualifyingCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgeQualifyingCode(String value) {
        this.ageQualifyingCode = value;
    }

    /**
     * Gets the value of the ageTimeUnit property.
     * 
     * @return
     *     possible object is
     *     {@link TimeUnitType }
     *     
     */
    public TimeUnitType getAgeTimeUnit() {
        return ageTimeUnit;
    }

    /**
     * Sets the value of the ageTimeUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeUnitType }
     *     
     */
    public void setAgeTimeUnit(TimeUnitType value) {
        this.ageTimeUnit = value;
    }

    /**
     * Gets the value of the maxAge property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxAge() {
        return maxAge;
    }

    /**
     * Sets the value of the maxAge property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxAge(Integer value) {
        this.maxAge = value;
    }

    /**
     * Gets the value of the minAge property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinAge() {
        return minAge;
    }

    /**
     * Sets the value of the minAge property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinAge(Integer value) {
        this.minAge = value;
    }

    /**
     * Gets the value of the effectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Sets the value of the effectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEffectiveDate(String value) {
        this.effectiveDate = value;
    }

    /**
     * Gets the value of the expireDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpireDate() {
        return expireDate;
    }

    /**
     * Sets the value of the expireDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpireDate(String value) {
        this.expireDate = value;
    }

    /**
     * Gets the value of the expireDateExclusiveIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExpireDateExclusiveIndicator() {
        return expireDateExclusiveIndicator;
    }

    /**
     * Sets the value of the expireDateExclusiveIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExpireDateExclusiveIndicator(Boolean value) {
        this.expireDateExclusiveIndicator = value;
    }


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
     *         &lt;element name="AdditionalGuestAmount" type="{http://www.opentravel.org/OTA/2003/05}AdditionalGuestAmountType" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *       &lt;attribute name="AmountAfterTax" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *       &lt;attribute name="AmountBeforeTax" type="{http://www.w3.org/2001/XMLSchema}decimal" />
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
    @XmlType(name = "", propOrder = {
        "additionalGuestAmount"
    })
    public static class AdditionalGuestAmounts {

        @XmlElement(name = "AdditionalGuestAmount", required = true)
        protected List<AdditionalGuestAmountType> additionalGuestAmount;
        @XmlAttribute(name = "AmountAfterTax")
        protected BigDecimal amountAfterTax;
        @XmlAttribute(name = "AmountBeforeTax")
        protected BigDecimal amountBeforeTax;
        @XmlAttribute(name = "CurrencyCode")
        protected String currencyCode;
        @XmlAttribute(name = "DecimalPlaces")
        protected BigInteger decimalPlaces;

        /**
         * Gets the value of the additionalGuestAmount property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the additionalGuestAmount property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAdditionalGuestAmount().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AdditionalGuestAmountType }
         * 
         * 
         */
        public List<AdditionalGuestAmountType> getAdditionalGuestAmount() {
            if (additionalGuestAmount == null) {
                additionalGuestAmount = new ArrayList<AdditionalGuestAmountType>();
            }
            return this.additionalGuestAmount;
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}DiscountType">
     *       &lt;sequence>
     *       &lt;/sequence>
     *       &lt;attribute name="AppliesTo" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="ItemRPH" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Discount
        extends DiscountType
    {

        @XmlAttribute(name = "AppliesTo")
        protected String appliesTo;
        @XmlAttribute(name = "ItemRPH")
        protected String itemRPH;

        /**
         * Gets the value of the appliesTo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAppliesTo() {
            return appliesTo;
        }

        /**
         * Sets the value of the appliesTo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAppliesTo(String value) {
            this.appliesTo = value;
        }

        /**
         * Gets the value of the itemRPH property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getItemRPH() {
            return itemRPH;
        }

        /**
         * Sets the value of the itemRPH property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setItemRPH(String value) {
            this.itemRPH = value;
        }

    }

}
