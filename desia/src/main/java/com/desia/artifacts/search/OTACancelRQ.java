
package com.desia.artifacts.search;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="UniqueID" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}UniqueID_Type">
 *                 &lt;sequence>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Reason" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Verification" type="{http://www.opentravel.org/OTA/2003/05}VerificationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Segment" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                 &lt;/sequence>
 *                 &lt;attribute name="FirstItinSegNbr" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="ItinSegNbr" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="LastItinSegNbr" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="OriginAndDestinationSegment" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="OriginLocation" type="{http://www.opentravel.org/OTA/2003/05}LocationType"/>
 *                   &lt;element name="DestinationLocation" type="{http://www.opentravel.org/OTA/2003/05}LocationType"/>
 *                   &lt;element name="Traveler" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://www.opentravel.org/OTA/2003/05}PersonNameType">
 *                           &lt;sequence>
 *                           &lt;/sequence>
 *                           &lt;attribute name="DocID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="DocType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Segment" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="DepartureStation" type="{http://www.opentravel.org/OTA/2003/05}LocationType"/>
 *                             &lt;element name="ArrivalStation" type="{http://www.opentravel.org/OTA/2003/05}LocationType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CancellationOverrides" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CancellationOverride" type="{http://www.opentravel.org/OTA/2003/05}CancelRuleType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Reasons" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Reason" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>FreeTextType">
 *                           &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CancellationContactPerson" type="{http://www.opentravel.org/OTA/2003/05}ContactPersonType" minOccurs="0"/>
 *         &lt;element name="TPA_Extensions" type="{http://www.opentravel.org/OTA/2003/05}TPA_ExtensionsType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="CancelType" use="required" type="{http://www.opentravel.org/OTA/2003/05}transactionActionType" />
 *       &lt;attribute name="TravelSector" type="{http://www.w3.org/2001/XMLSchema}string" />
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
 *       &lt;attribute name="ReqRespVersion" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    "uniqueID",
    "verification",
    "segment",
    "originAndDestinationSegment",
    "cancellationOverrides",
    "reasons",
    "cancellationContactPerson",
    "tpaExtensions"
})
@XmlRootElement(name = "OTA_CancelRQ")
public class OTACancelRQ {

    @XmlElement(name = "POS")
    protected POSType pos;
    @XmlElement(name = "UniqueID", required = true)
    protected List<OTACancelRQ.UniqueID> uniqueID;
    @XmlElement(name = "Verification")
    protected List<VerificationType> verification;
    @XmlElement(name = "Segment")
    protected List<OTACancelRQ.Segment> segment;
    @XmlElement(name = "OriginAndDestinationSegment")
    protected List<OTACancelRQ.OriginAndDestinationSegment> originAndDestinationSegment;
    @XmlElement(name = "CancellationOverrides")
    protected OTACancelRQ.CancellationOverrides cancellationOverrides;
    @XmlElement(name = "Reasons")
    protected OTACancelRQ.Reasons reasons;
    @XmlElement(name = "CancellationContactPerson")
    protected ContactPersonType cancellationContactPerson;
    @XmlElement(name = "TPA_Extensions", required = true)
    protected TPAExtensionsType tpaExtensions;
    @XmlAttribute(name = "CancelType", required = true)
    protected TransactionActionType cancelType;
    @XmlAttribute(name = "TravelSector")
    protected String travelSector;
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
    @XmlAttribute(name = "ReqRespVersion")
    protected String reqRespVersion;

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
     * Gets the value of the uniqueID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uniqueID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUniqueID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OTACancelRQ.UniqueID }
     * 
     * 
     */
    public List<OTACancelRQ.UniqueID> getUniqueID() {
        if (uniqueID == null) {
            uniqueID = new ArrayList<OTACancelRQ.UniqueID>();
        }
        return this.uniqueID;
    }

    /**
     * Gets the value of the verification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the verification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVerification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VerificationType }
     * 
     * 
     */
    public List<VerificationType> getVerification() {
        if (verification == null) {
            verification = new ArrayList<VerificationType>();
        }
        return this.verification;
    }

    /**
     * Gets the value of the segment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the segment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSegment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OTACancelRQ.Segment }
     * 
     * 
     */
    public List<OTACancelRQ.Segment> getSegment() {
        if (segment == null) {
            segment = new ArrayList<OTACancelRQ.Segment>();
        }
        return this.segment;
    }

    /**
     * Gets the value of the originAndDestinationSegment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the originAndDestinationSegment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOriginAndDestinationSegment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OTACancelRQ.OriginAndDestinationSegment }
     * 
     * 
     */
    public List<OTACancelRQ.OriginAndDestinationSegment> getOriginAndDestinationSegment() {
        if (originAndDestinationSegment == null) {
            originAndDestinationSegment = new ArrayList<OTACancelRQ.OriginAndDestinationSegment>();
        }
        return this.originAndDestinationSegment;
    }

    /**
     * Gets the value of the cancellationOverrides property.
     * 
     * @return
     *     possible object is
     *     {@link OTACancelRQ.CancellationOverrides }
     *     
     */
    public OTACancelRQ.CancellationOverrides getCancellationOverrides() {
        return cancellationOverrides;
    }

    /**
     * Sets the value of the cancellationOverrides property.
     * 
     * @param value
     *     allowed object is
     *     {@link OTACancelRQ.CancellationOverrides }
     *     
     */
    public void setCancellationOverrides(OTACancelRQ.CancellationOverrides value) {
        this.cancellationOverrides = value;
    }

    /**
     * Gets the value of the reasons property.
     * 
     * @return
     *     possible object is
     *     {@link OTACancelRQ.Reasons }
     *     
     */
    public OTACancelRQ.Reasons getReasons() {
        return reasons;
    }

    /**
     * Sets the value of the reasons property.
     * 
     * @param value
     *     allowed object is
     *     {@link OTACancelRQ.Reasons }
     *     
     */
    public void setReasons(OTACancelRQ.Reasons value) {
        this.reasons = value;
    }

    /**
     * Gets the value of the cancellationContactPerson property.
     * 
     * @return
     *     possible object is
     *     {@link ContactPersonType }
     *     
     */
    public ContactPersonType getCancellationContactPerson() {
        return cancellationContactPerson;
    }

    /**
     * Sets the value of the cancellationContactPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactPersonType }
     *     
     */
    public void setCancellationContactPerson(ContactPersonType value) {
        this.cancellationContactPerson = value;
    }

    /**
     * Gets the value of the tpaExtensions property.
     * 
     * @return
     *     possible object is
     *     {@link TPAExtensionsType }
     *     
     */
    public TPAExtensionsType getTPAExtensions() {
        return tpaExtensions;
    }

    /**
     * Sets the value of the tpaExtensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPAExtensionsType }
     *     
     */
    public void setTPAExtensions(TPAExtensionsType value) {
        this.tpaExtensions = value;
    }

    /**
     * Gets the value of the cancelType property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionActionType }
     *     
     */
    public TransactionActionType getCancelType() {
        return cancelType;
    }

    /**
     * Sets the value of the cancelType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionActionType }
     *     
     */
    public void setCancelType(TransactionActionType value) {
        this.cancelType = value;
    }

    /**
     * Gets the value of the travelSector property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTravelSector() {
        return travelSector;
    }

    /**
     * Sets the value of the travelSector property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTravelSector(String value) {
        this.travelSector = value;
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
     * Gets the value of the reqRespVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReqRespVersion() {
        return reqRespVersion;
    }

    /**
     * Sets the value of the reqRespVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReqRespVersion(String value) {
        this.reqRespVersion = value;
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
     *         &lt;element name="CancellationOverride" type="{http://www.opentravel.org/OTA/2003/05}CancelRuleType" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "cancellationOverride"
    })
    public static class CancellationOverrides {

        @XmlElement(name = "CancellationOverride")
        protected CancelRuleType cancellationOverride;

        /**
         * Gets the value of the cancellationOverride property.
         * 
         * @return
         *     possible object is
         *     {@link CancelRuleType }
         *     
         */
        public CancelRuleType getCancellationOverride() {
            return cancellationOverride;
        }

        /**
         * Sets the value of the cancellationOverride property.
         * 
         * @param value
         *     allowed object is
         *     {@link CancelRuleType }
         *     
         */
        public void setCancellationOverride(CancelRuleType value) {
            this.cancellationOverride = value;
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
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="OriginLocation" type="{http://www.opentravel.org/OTA/2003/05}LocationType"/>
     *         &lt;element name="DestinationLocation" type="{http://www.opentravel.org/OTA/2003/05}LocationType"/>
     *         &lt;element name="Traveler" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}PersonNameType">
     *                 &lt;sequence>
     *                 &lt;/sequence>
     *                 &lt;attribute name="DocID" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="DocType" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Segment" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="DepartureStation" type="{http://www.opentravel.org/OTA/2003/05}LocationType"/>
     *                   &lt;element name="ArrivalStation" type="{http://www.opentravel.org/OTA/2003/05}LocationType"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "originLocation",
        "destinationLocation",
        "traveler",
        "segment"
    })
    public static class OriginAndDestinationSegment {

        @XmlElement(name = "OriginLocation", required = true)
        protected LocationType originLocation;
        @XmlElement(name = "DestinationLocation", required = true)
        protected LocationType destinationLocation;
        @XmlElement(name = "Traveler")
        protected List<OTACancelRQ.OriginAndDestinationSegment.Traveler> traveler;
        @XmlElement(name = "Segment")
        protected List<OTACancelRQ.OriginAndDestinationSegment.Segment> segment;

        /**
         * Gets the value of the originLocation property.
         * 
         * @return
         *     possible object is
         *     {@link LocationType }
         *     
         */
        public LocationType getOriginLocation() {
            return originLocation;
        }

        /**
         * Sets the value of the originLocation property.
         * 
         * @param value
         *     allowed object is
         *     {@link LocationType }
         *     
         */
        public void setOriginLocation(LocationType value) {
            this.originLocation = value;
        }

        /**
         * Gets the value of the destinationLocation property.
         * 
         * @return
         *     possible object is
         *     {@link LocationType }
         *     
         */
        public LocationType getDestinationLocation() {
            return destinationLocation;
        }

        /**
         * Sets the value of the destinationLocation property.
         * 
         * @param value
         *     allowed object is
         *     {@link LocationType }
         *     
         */
        public void setDestinationLocation(LocationType value) {
            this.destinationLocation = value;
        }

        /**
         * Gets the value of the traveler property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the traveler property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTraveler().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OTACancelRQ.OriginAndDestinationSegment.Traveler }
         * 
         * 
         */
        public List<OTACancelRQ.OriginAndDestinationSegment.Traveler> getTraveler() {
            if (traveler == null) {
                traveler = new ArrayList<OTACancelRQ.OriginAndDestinationSegment.Traveler>();
            }
            return this.traveler;
        }

        /**
         * Gets the value of the segment property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the segment property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSegment().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OTACancelRQ.OriginAndDestinationSegment.Segment }
         * 
         * 
         */
        public List<OTACancelRQ.OriginAndDestinationSegment.Segment> getSegment() {
            if (segment == null) {
                segment = new ArrayList<OTACancelRQ.OriginAndDestinationSegment.Segment>();
            }
            return this.segment;
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
         *         &lt;element name="DepartureStation" type="{http://www.opentravel.org/OTA/2003/05}LocationType"/>
         *         &lt;element name="ArrivalStation" type="{http://www.opentravel.org/OTA/2003/05}LocationType"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "departureStation",
            "arrivalStation"
        })
        public static class Segment {

            @XmlElement(name = "DepartureStation", required = true)
            protected LocationType departureStation;
            @XmlElement(name = "ArrivalStation", required = true)
            protected LocationType arrivalStation;

            /**
             * Gets the value of the departureStation property.
             * 
             * @return
             *     possible object is
             *     {@link LocationType }
             *     
             */
            public LocationType getDepartureStation() {
                return departureStation;
            }

            /**
             * Sets the value of the departureStation property.
             * 
             * @param value
             *     allowed object is
             *     {@link LocationType }
             *     
             */
            public void setDepartureStation(LocationType value) {
                this.departureStation = value;
            }

            /**
             * Gets the value of the arrivalStation property.
             * 
             * @return
             *     possible object is
             *     {@link LocationType }
             *     
             */
            public LocationType getArrivalStation() {
                return arrivalStation;
            }

            /**
             * Sets the value of the arrivalStation property.
             * 
             * @param value
             *     allowed object is
             *     {@link LocationType }
             *     
             */
            public void setArrivalStation(LocationType value) {
                this.arrivalStation = value;
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
         *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}PersonNameType">
         *       &lt;sequence>
         *       &lt;/sequence>
         *       &lt;attribute name="DocID" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="DocType" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Traveler
            extends PersonNameType
        {

            @XmlAttribute(name = "DocID")
            protected String docID;
            @XmlAttribute(name = "DocType")
            protected String docType;

            /**
             * Gets the value of the docID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDocID() {
                return docID;
            }

            /**
             * Sets the value of the docID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDocID(String value) {
                this.docID = value;
            }

            /**
             * Gets the value of the docType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDocType() {
                return docType;
            }

            /**
             * Sets the value of the docType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDocType(String value) {
                this.docType = value;
            }

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
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Reason" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>FreeTextType">
     *                 &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "reason"
    })
    public static class Reasons {

        @XmlElement(name = "Reason", required = true)
        protected List<OTACancelRQ.Reasons.Reason> reason;

        /**
         * Gets the value of the reason property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the reason property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getReason().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OTACancelRQ.Reasons.Reason }
         * 
         * 
         */
        public List<OTACancelRQ.Reasons.Reason> getReason() {
            if (reason == null) {
                reason = new ArrayList<OTACancelRQ.Reasons.Reason>();
            }
            return this.reason;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>FreeTextType">
         *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Reason
            extends FreeTextType
        {

            @XmlAttribute(name = "Type")
            protected String type;

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
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *       &lt;/sequence>
     *       &lt;attribute name="FirstItinSegNbr" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *       &lt;attribute name="ItinSegNbr" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *       &lt;attribute name="LastItinSegNbr" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Segment {

        @XmlAttribute(name = "FirstItinSegNbr")
        protected BigInteger firstItinSegNbr;
        @XmlAttribute(name = "ItinSegNbr")
        protected BigInteger itinSegNbr;
        @XmlAttribute(name = "LastItinSegNbr")
        protected BigInteger lastItinSegNbr;

        /**
         * Gets the value of the firstItinSegNbr property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getFirstItinSegNbr() {
            return firstItinSegNbr;
        }

        /**
         * Sets the value of the firstItinSegNbr property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setFirstItinSegNbr(BigInteger value) {
            this.firstItinSegNbr = value;
        }

        /**
         * Gets the value of the itinSegNbr property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getItinSegNbr() {
            return itinSegNbr;
        }

        /**
         * Sets the value of the itinSegNbr property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setItinSegNbr(BigInteger value) {
            this.itinSegNbr = value;
        }

        /**
         * Gets the value of the lastItinSegNbr property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getLastItinSegNbr() {
            return lastItinSegNbr;
        }

        /**
         * Sets the value of the lastItinSegNbr property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setLastItinSegNbr(BigInteger value) {
            this.lastItinSegNbr = value;
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
     *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}UniqueID_Type">
     *       &lt;sequence>
     *       &lt;/sequence>
     *       &lt;attribute name="Reason" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class UniqueID
        extends UniqueIDType
    {

        @XmlAttribute(name = "Reason")
        protected String reason;

        /**
         * Gets the value of the reason property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getReason() {
            return reason;
        }

        /**
         * Sets the value of the reason property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setReason(String value) {
            this.reason = value;
        }

    }

}
