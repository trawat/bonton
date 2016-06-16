
package com.desia.artifacts.search;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonNameType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonNameType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NamePrefix" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="GivenName" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="MiddleName" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SurnamePrefix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Surname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NameSuffix" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NameTitle" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Document" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                 &lt;/sequence>
 *                 &lt;attribute name="DocID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="DocType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="NameType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ShareMarketInd" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ShareSynchInd" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonNameType", propOrder = {
    "namePrefix",
    "givenName",
    "middleName",
    "surnamePrefix",
    "surname",
    "nameSuffix",
    "nameTitle",
    "document"
})
@XmlSeeAlso({
    com.desia.artifacts.search.OTACancelRQ.OriginAndDestinationSegment.Traveler.class,
    com.desia.artifacts.search.DonationType.DonorInfo.Name.class,
    com.desia.artifacts.search.VerificationType.PersonName.class,
    com.desia.artifacts.search.TravelClubType.ClubMemberName.class,
    com.desia.artifacts.search.ContactsType.Name.class,
    com.desia.artifacts.search.OrganizationType.OrgMemberName.class
})
public class PersonNameType {

    @XmlElement(name = "NamePrefix")
    protected List<String> namePrefix;
    @XmlElement(name = "GivenName")
    protected List<String> givenName;
    @XmlElement(name = "MiddleName")
    protected List<String> middleName;
    @XmlElement(name = "SurnamePrefix")
    protected String surnamePrefix;
    @XmlElement(name = "Surname", required = true)
    protected String surname;
    @XmlElement(name = "NameSuffix")
    protected List<String> nameSuffix;
    @XmlElement(name = "NameTitle")
    protected List<String> nameTitle;
    @XmlElement(name = "Document")
    protected PersonNameType.Document document;
    @XmlAttribute(name = "NameType")
    protected String nameType;
    @XmlAttribute(name = "ShareMarketInd")
    protected String shareMarketInd;
    @XmlAttribute(name = "ShareSynchInd")
    protected String shareSynchInd;

    /**
     * Gets the value of the namePrefix property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the namePrefix property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNamePrefix().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNamePrefix() {
        if (namePrefix == null) {
            namePrefix = new ArrayList<String>();
        }
        return this.namePrefix;
    }

    /**
     * Gets the value of the givenName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the givenName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGivenName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getGivenName() {
        if (givenName == null) {
            givenName = new ArrayList<String>();
        }
        return this.givenName;
    }

    /**
     * Gets the value of the middleName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the middleName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMiddleName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getMiddleName() {
        if (middleName == null) {
            middleName = new ArrayList<String>();
        }
        return this.middleName;
    }

    /**
     * Gets the value of the surnamePrefix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurnamePrefix() {
        return surnamePrefix;
    }

    /**
     * Sets the value of the surnamePrefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurnamePrefix(String value) {
        this.surnamePrefix = value;
    }

    /**
     * Gets the value of the surname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the value of the surname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurname(String value) {
        this.surname = value;
    }

    /**
     * Gets the value of the nameSuffix property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nameSuffix property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNameSuffix().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNameSuffix() {
        if (nameSuffix == null) {
            nameSuffix = new ArrayList<String>();
        }
        return this.nameSuffix;
    }

    /**
     * Gets the value of the nameTitle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nameTitle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNameTitle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNameTitle() {
        if (nameTitle == null) {
            nameTitle = new ArrayList<String>();
        }
        return this.nameTitle;
    }

    /**
     * Gets the value of the document property.
     * 
     * @return
     *     possible object is
     *     {@link PersonNameType.Document }
     *     
     */
    public PersonNameType.Document getDocument() {
        return document;
    }

    /**
     * Sets the value of the document property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonNameType.Document }
     *     
     */
    public void setDocument(PersonNameType.Document value) {
        this.document = value;
    }

    /**
     * Gets the value of the nameType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameType() {
        return nameType;
    }

    /**
     * Sets the value of the nameType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameType(String value) {
        this.nameType = value;
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
     *       &lt;attribute name="DocID" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="DocType" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Document {

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
