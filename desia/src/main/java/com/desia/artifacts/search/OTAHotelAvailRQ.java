
package com.desia.artifacts.search;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="POS" type="{http://www.opentravel.org/OTA/2003/05}POS_Type" minOccurs="0"/>
 *         &lt;element name="AvailRequestSegments">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}AvailRequestSegmentsType">
 *                 &lt;sequence>
 *                 &lt;/sequence>
 *                 &lt;attribute name="MaximumWaitTime" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="AllowPartialAvail" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="AvailRatesOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="BestOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="DuplicateInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="ExactMatchOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="HotelStayOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="IsModify" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="OnRequestInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="PricingMethod" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RateDetailsInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="RateRangeOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="RequestedCurrency" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RequestedCurrencyIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="SearchCacheLevel" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SortOrder" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SummaryOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="MaxResponses" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="MapHeight" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="MapRequired" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="MapWidth" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="CorrelationID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="EchoToken" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RetransmissionIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="SequenceNmbr" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="Target" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TargetName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TimeStamp" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="TransactionIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TransactionStatusCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Version" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="PrimaryLangID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AltLangID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pos",
    "availRequestSegments"
})
@XmlRootElement(name = "OTA_HotelAvailRQ")
public class OTAHotelAvailRQ {

    @XmlElement(name = "POS")
    protected POSType pos;
    @XmlElement(name = "AvailRequestSegments", required = true)
    protected OTAHotelAvailRQ.AvailRequestSegments availRequestSegments;
    @XmlAttribute(name = "AllowPartialAvail")
    protected Boolean allowPartialAvail;
    @XmlAttribute(name = "AvailRatesOnly")
    protected Boolean availRatesOnly;
    @XmlAttribute(name = "BestOnly")
    protected Boolean bestOnly;
    @XmlAttribute(name = "DuplicateInd")
    protected Boolean duplicateInd;
    @XmlAttribute(name = "ExactMatchOnly")
    protected Boolean exactMatchOnly;
    @XmlAttribute(name = "HotelStayOnly")
    protected Boolean hotelStayOnly;
    @XmlAttribute(name = "IsModify")
    protected Boolean isModify;
    @XmlAttribute(name = "OnRequestInd")
    protected Boolean onRequestInd;
    @XmlAttribute(name = "PricingMethod")
    protected String pricingMethod;
    @XmlAttribute(name = "RateDetailsInd")
    protected Boolean rateDetailsInd;
    @XmlAttribute(name = "RateRangeOnly")
    protected Boolean rateRangeOnly;
    @XmlAttribute(name = "RequestedCurrency")
    protected String requestedCurrency;
    @XmlAttribute(name = "RequestedCurrencyIndicator")
    protected Boolean requestedCurrencyIndicator;
    @XmlAttribute(name = "SearchCacheLevel")
    protected String searchCacheLevel;
    @XmlAttribute(name = "SortOrder")
    protected String sortOrder;
    @XmlAttribute(name = "SummaryOnly")
    protected Boolean summaryOnly;
    @XmlAttribute(name = "MaxResponses")
    protected BigInteger maxResponses;
    @XmlAttribute(name = "MapHeight")
    protected Integer mapHeight;
    @XmlAttribute(name = "MapRequired")
    protected Boolean mapRequired;
    @XmlAttribute(name = "MapWidth")
    protected Integer mapWidth;
    @XmlAttribute(name = "CorrelationID")
    protected String correlationID;
    @XmlAttribute(name = "EchoToken")
    protected String echoToken;
    @XmlAttribute(name = "RetransmissionIndicator")
    protected Boolean retransmissionIndicator;
    @XmlAttribute(name = "SequenceNmbr")
    protected BigInteger sequenceNmbr;
    @XmlAttribute(name = "Target")
    protected String target;
    @XmlAttribute(name = "TargetName")
    protected String targetName;
    @XmlAttribute(name = "TimeStamp")
    @XmlSchemaType(name = "anySimpleType")
    protected String timeStamp;
    @XmlAttribute(name = "TransactionIdentifier")
    protected String transactionIdentifier;
    @XmlAttribute(name = "TransactionStatusCode")
    protected String transactionStatusCode;
    @XmlAttribute(name = "Version", required = true)
    protected BigDecimal version;
    @XmlAttribute(name = "PrimaryLangID")
    protected String primaryLangID;
    @XmlAttribute(name = "AltLangID")
    protected String altLangID;

    /**
     * Gets the value of the pos property.
     * 
     * @return
     *     possible object is
     *     {@link POSType }
     *     
     */
    public POSType getPOS() {
        return pos;
    }

    /**
     * Sets the value of the pos property.
     * 
     * @param value
     *     allowed object is
     *     {@link POSType }
     *     
     */
    public void setPOS(POSType value) {
        this.pos = value;
    }

    /**
     * Gets the value of the availRequestSegments property.
     * 
     * @return
     *     possible object is
     *     {@link OTAHotelAvailRQ.AvailRequestSegments }
     *     
     */
    public OTAHotelAvailRQ.AvailRequestSegments getAvailRequestSegments() {
        return availRequestSegments;
    }

    /**
     * Sets the value of the availRequestSegments property.
     * 
     * @param value
     *     allowed object is
     *     {@link OTAHotelAvailRQ.AvailRequestSegments }
     *     
     */
    public void setAvailRequestSegments(OTAHotelAvailRQ.AvailRequestSegments value) {
        this.availRequestSegments = value;
    }

    /**
     * Gets the value of the allowPartialAvail property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowPartialAvail() {
        return allowPartialAvail;
    }

    /**
     * Sets the value of the allowPartialAvail property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowPartialAvail(Boolean value) {
        this.allowPartialAvail = value;
    }

    /**
     * Gets the value of the availRatesOnly property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAvailRatesOnly() {
        return availRatesOnly;
    }

    /**
     * Sets the value of the availRatesOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAvailRatesOnly(Boolean value) {
        this.availRatesOnly = value;
    }

    /**
     * Gets the value of the bestOnly property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBestOnly() {
        return bestOnly;
    }

    /**
     * Sets the value of the bestOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBestOnly(Boolean value) {
        this.bestOnly = value;
    }

    /**
     * Gets the value of the duplicateInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDuplicateInd() {
        return duplicateInd;
    }

    /**
     * Sets the value of the duplicateInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDuplicateInd(Boolean value) {
        this.duplicateInd = value;
    }

    /**
     * Gets the value of the exactMatchOnly property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExactMatchOnly() {
        return exactMatchOnly;
    }

    /**
     * Sets the value of the exactMatchOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExactMatchOnly(Boolean value) {
        this.exactMatchOnly = value;
    }

    /**
     * Gets the value of the hotelStayOnly property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHotelStayOnly() {
        return hotelStayOnly;
    }

    /**
     * Sets the value of the hotelStayOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHotelStayOnly(Boolean value) {
        this.hotelStayOnly = value;
    }

    /**
     * Gets the value of the isModify property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsModify() {
        return isModify;
    }

    /**
     * Sets the value of the isModify property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsModify(Boolean value) {
        this.isModify = value;
    }

    /**
     * Gets the value of the onRequestInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOnRequestInd() {
        return onRequestInd;
    }

    /**
     * Sets the value of the onRequestInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOnRequestInd(Boolean value) {
        this.onRequestInd = value;
    }

    /**
     * Gets the value of the pricingMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPricingMethod() {
        return pricingMethod;
    }

    /**
     * Sets the value of the pricingMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPricingMethod(String value) {
        this.pricingMethod = value;
    }

    /**
     * Gets the value of the rateDetailsInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRateDetailsInd() {
        return rateDetailsInd;
    }

    /**
     * Sets the value of the rateDetailsInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRateDetailsInd(Boolean value) {
        this.rateDetailsInd = value;
    }

    /**
     * Gets the value of the rateRangeOnly property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRateRangeOnly() {
        return rateRangeOnly;
    }

    /**
     * Sets the value of the rateRangeOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRateRangeOnly(Boolean value) {
        this.rateRangeOnly = value;
    }

    /**
     * Gets the value of the requestedCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestedCurrency() {
        return requestedCurrency;
    }

    /**
     * Sets the value of the requestedCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestedCurrency(String value) {
        this.requestedCurrency = value;
    }

    /**
     * Gets the value of the requestedCurrencyIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRequestedCurrencyIndicator() {
        return requestedCurrencyIndicator;
    }

    /**
     * Sets the value of the requestedCurrencyIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRequestedCurrencyIndicator(Boolean value) {
        this.requestedCurrencyIndicator = value;
    }

    /**
     * Gets the value of the searchCacheLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchCacheLevel() {
        return searchCacheLevel;
    }

    /**
     * Sets the value of the searchCacheLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchCacheLevel(String value) {
        this.searchCacheLevel = value;
    }

    /**
     * Gets the value of the sortOrder property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSortOrder() {
        return sortOrder;
    }

    /**
     * Sets the value of the sortOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSortOrder(String value) {
        this.sortOrder = value;
    }

    /**
     * Gets the value of the summaryOnly property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSummaryOnly() {
        return summaryOnly;
    }

    /**
     * Sets the value of the summaryOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSummaryOnly(Boolean value) {
        this.summaryOnly = value;
    }

    /**
     * Gets the value of the maxResponses property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxResponses() {
        return maxResponses;
    }

    /**
     * Sets the value of the maxResponses property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxResponses(BigInteger value) {
        this.maxResponses = value;
    }

    /**
     * Gets the value of the mapHeight property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMapHeight() {
        return mapHeight;
    }

    /**
     * Sets the value of the mapHeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMapHeight(Integer value) {
        this.mapHeight = value;
    }

    /**
     * Gets the value of the mapRequired property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMapRequired() {
        return mapRequired;
    }

    /**
     * Sets the value of the mapRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMapRequired(Boolean value) {
        this.mapRequired = value;
    }

    /**
     * Gets the value of the mapWidth property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMapWidth() {
        return mapWidth;
    }

    /**
     * Sets the value of the mapWidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMapWidth(Integer value) {
        this.mapWidth = value;
    }

    /**
     * Gets the value of the correlationID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrelationID() {
        return correlationID;
    }

    /**
     * Sets the value of the correlationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrelationID(String value) {
        this.correlationID = value;
    }

    /**
     * Gets the value of the echoToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEchoToken() {
        return echoToken;
    }

    /**
     * Sets the value of the echoToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEchoToken(String value) {
        this.echoToken = value;
    }

    /**
     * Gets the value of the retransmissionIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRetransmissionIndicator() {
        return retransmissionIndicator;
    }

    /**
     * Sets the value of the retransmissionIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRetransmissionIndicator(Boolean value) {
        this.retransmissionIndicator = value;
    }

    /**
     * Gets the value of the sequenceNmbr property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSequenceNmbr() {
        return sequenceNmbr;
    }

    /**
     * Sets the value of the sequenceNmbr property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSequenceNmbr(BigInteger value) {
        this.sequenceNmbr = value;
    }

    /**
     * Gets the value of the target property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTarget() {
        return target;
    }

    /**
     * Sets the value of the target property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTarget(String value) {
        this.target = value;
    }

    /**
     * Gets the value of the targetName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetName() {
        return targetName;
    }

    /**
     * Sets the value of the targetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetName(String value) {
        this.targetName = value;
    }

    /**
     * Gets the value of the timeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets the value of the timeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeStamp(String value) {
        this.timeStamp = value;
    }

    /**
     * Gets the value of the transactionIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionIdentifier() {
        return transactionIdentifier;
    }

    /**
     * Sets the value of the transactionIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionIdentifier(String value) {
        this.transactionIdentifier = value;
    }

    /**
     * Gets the value of the transactionStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionStatusCode() {
        return transactionStatusCode;
    }

    /**
     * Sets the value of the transactionStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionStatusCode(String value) {
        this.transactionStatusCode = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVersion(BigDecimal value) {
        this.version = value;
    }

    /**
     * Gets the value of the primaryLangID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryLangID() {
        return primaryLangID;
    }

    /**
     * Sets the value of the primaryLangID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryLangID(String value) {
        this.primaryLangID = value;
    }

    /**
     * Gets the value of the altLangID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAltLangID() {
        return altLangID;
    }

    /**
     * Sets the value of the altLangID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAltLangID(String value) {
        this.altLangID = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}AvailRequestSegmentsType">
     *       &lt;sequence>
     *       &lt;/sequence>
     *       &lt;attribute name="MaximumWaitTime" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class AvailRequestSegments
        extends AvailRequestSegmentsType
    {

        @XmlAttribute(name = "MaximumWaitTime")
        protected BigDecimal maximumWaitTime;

        /**
         * Gets the value of the maximumWaitTime property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getMaximumWaitTime() {
            return maximumWaitTime;
        }

        /**
         * Sets the value of the maximumWaitTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setMaximumWaitTime(BigDecimal value) {
            this.maximumWaitTime = value;
        }

    }

}
