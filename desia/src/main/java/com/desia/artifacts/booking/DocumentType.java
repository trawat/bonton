
package com.desia.artifacts.booking;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DocumentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DocHolderName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DocHolderFormattedName" type="{http://www.opentravel.org/OTA/2003/05}PersonNameType" minOccurs="0"/>
 *         &lt;element name="DocLimitations" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AdditionalPersonNames" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="AdditionalPersonName" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="BirthCountry" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="BirthPlace" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ContactName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DocHolderNationality" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DocID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DocIssueAuthority" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DocIssueCountry" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DocIssueLocation" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DocIssueStateProv" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DocType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="HolderType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Remark" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="BirthDate" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="ExpireDate" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="ExpireDateExclusiveIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="ShareMarketInd" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ShareSynchInd" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Gender" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentType", propOrder = {
    "docHolderName",
    "docHolderFormattedName",
    "docLimitations",
    "additionalPersonNames"
})
public class DocumentType {

    @XmlElement(name = "DocHolderName")
    protected String docHolderName;
    @XmlElement(name = "DocHolderFormattedName")
    protected PersonNameType docHolderFormattedName;
    @XmlElement(name = "DocLimitations")
    protected List<String> docLimitations;
    @XmlElement(name = "AdditionalPersonNames")
    protected DocumentType.AdditionalPersonNames additionalPersonNames;
    @XmlAttribute(name = "BirthCountry")
    protected String birthCountry;
    @XmlAttribute(name = "BirthPlace")
    protected String birthPlace;
    @XmlAttribute(name = "ContactName")
    protected String contactName;
    @XmlAttribute(name = "DocHolderNationality")
    protected String docHolderNationality;
    @XmlAttribute(name = "DocID")
    protected String docID;
    @XmlAttribute(name = "DocIssueAuthority")
    protected String docIssueAuthority;
    @XmlAttribute(name = "DocIssueCountry")
    protected String docIssueCountry;
    @XmlAttribute(name = "DocIssueLocation")
    protected String docIssueLocation;
    @XmlAttribute(name = "DocIssueStateProv")
    protected String docIssueStateProv;
    @XmlAttribute(name = "DocType")
    protected String docType;
    @XmlAttribute(name = "HolderType")
    protected String holderType;
    @XmlAttribute(name = "PostalCode")
    protected String postalCode;
    @XmlAttribute(name = "Remark")
    protected String remark;
    @XmlAttribute(name = "BirthDate")
    @XmlSchemaType(name = "anySimpleType")
    protected String birthDate;
    @XmlAttribute(name = "EffectiveDate")
    @XmlSchemaType(name = "anySimpleType")
    protected String effectiveDate;
    @XmlAttribute(name = "ExpireDate")
    @XmlSchemaType(name = "anySimpleType")
    protected String expireDate;
    @XmlAttribute(name = "ExpireDateExclusiveIndicator")
    protected Boolean expireDateExclusiveIndicator;
    @XmlAttribute(name = "ShareMarketInd")
    protected String shareMarketInd;
    @XmlAttribute(name = "ShareSynchInd")
    protected String shareSynchInd;
    @XmlAttribute(name = "Gender")
    protected String gender;

    /**
     * Gets the value of the docHolderName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocHolderName() {
        return docHolderName;
    }

    /**
     * Sets the value of the docHolderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocHolderName(String value) {
        this.docHolderName = value;
    }

    /**
     * Gets the value of the docHolderFormattedName property.
     * 
     * @return
     *     possible object is
     *     {@link PersonNameType }
     *     
     */
    public PersonNameType getDocHolderFormattedName() {
        return docHolderFormattedName;
    }

    /**
     * Sets the value of the docHolderFormattedName property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonNameType }
     *     
     */
    public void setDocHolderFormattedName(PersonNameType value) {
        this.docHolderFormattedName = value;
    }

    /**
     * Gets the value of the docLimitations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the docLimitations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocLimitations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDocLimitations() {
        if (docLimitations == null) {
            docLimitations = new ArrayList<String>();
        }
        return this.docLimitations;
    }

    /**
     * Gets the value of the additionalPersonNames property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentType.AdditionalPersonNames }
     *     
     */
    public DocumentType.AdditionalPersonNames getAdditionalPersonNames() {
        return additionalPersonNames;
    }

    /**
     * Sets the value of the additionalPersonNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentType.AdditionalPersonNames }
     *     
     */
    public void setAdditionalPersonNames(DocumentType.AdditionalPersonNames value) {
        this.additionalPersonNames = value;
    }

    /**
     * Gets the value of the birthCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthCountry() {
        return birthCountry;
    }

    /**
     * Sets the value of the birthCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthCountry(String value) {
        this.birthCountry = value;
    }

    /**
     * Gets the value of the birthPlace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthPlace() {
        return birthPlace;
    }

    /**
     * Sets the value of the birthPlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthPlace(String value) {
        this.birthPlace = value;
    }

    /**
     * Gets the value of the contactName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * Sets the value of the contactName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactName(String value) {
        this.contactName = value;
    }

    /**
     * Gets the value of the docHolderNationality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocHolderNationality() {
        return docHolderNationality;
    }

    /**
     * Sets the value of the docHolderNationality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocHolderNationality(String value) {
        this.docHolderNationality = value;
    }

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
     * Gets the value of the docIssueAuthority property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocIssueAuthority() {
        return docIssueAuthority;
    }

    /**
     * Sets the value of the docIssueAuthority property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocIssueAuthority(String value) {
        this.docIssueAuthority = value;
    }

    /**
     * Gets the value of the docIssueCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocIssueCountry() {
        return docIssueCountry;
    }

    /**
     * Sets the value of the docIssueCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocIssueCountry(String value) {
        this.docIssueCountry = value;
    }

    /**
     * Gets the value of the docIssueLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocIssueLocation() {
        return docIssueLocation;
    }

    /**
     * Sets the value of the docIssueLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocIssueLocation(String value) {
        this.docIssueLocation = value;
    }

    /**
     * Gets the value of the docIssueStateProv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocIssueStateProv() {
        return docIssueStateProv;
    }

    /**
     * Sets the value of the docIssueStateProv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocIssueStateProv(String value) {
        this.docIssueStateProv = value;
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

    /**
     * Gets the value of the holderType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHolderType() {
        return holderType;
    }

    /**
     * Sets the value of the holderType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHolderType(String value) {
        this.holderType = value;
    }

    /**
     * Gets the value of the postalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the remark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets the value of the remark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemark(String value) {
        this.remark = value;
    }

    /**
     * Gets the value of the birthDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the birthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthDate(String value) {
        this.birthDate = value;
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
     * Gets the value of the shareMarketInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShareMarketInd() {
        return shareMarketInd;
    }

    /**
     * Sets the value of the shareMarketInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShareMarketInd(String value) {
        this.shareMarketInd = value;
    }

    /**
     * Gets the value of the shareSynchInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShareSynchInd() {
        return shareSynchInd;
    }

    /**
     * Sets the value of the shareSynchInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShareSynchInd(String value) {
        this.shareSynchInd = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGender(String value) {
        this.gender = value;
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
     *         &lt;element name="AdditionalPersonName" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
        "additionalPersonName"
    })
    public static class AdditionalPersonNames {

        @XmlElement(name = "AdditionalPersonName", required = true)
        protected List<String> additionalPersonName;

        /**
         * Gets the value of the additionalPersonName property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the additionalPersonName property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAdditionalPersonName().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getAdditionalPersonName() {
            if (additionalPersonName == null) {
                additionalPersonName = new ArrayList<String>();
            }
            return this.additionalPersonName;
        }

    }

}
