
package com.desia.artifacts.booking;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DonationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DonationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FrontOfficeInfo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                 &lt;/sequence>
 *                 &lt;attribute name="CorporateID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="OfficeID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="ProductName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="ProductVersion" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CreditCardInfo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}PaymentCardType">
 *                 &lt;sequence>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Currency" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="DonationAmount" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DonorInfo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Name" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://www.opentravel.org/OTA/2003/05}PersonNameType">
 *                           &lt;sequence>
 *                           &lt;/sequence>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="ContactInfo" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://www.opentravel.org/OTA/2003/05}AddressType">
 *                           &lt;sequence>
 *                           &lt;/sequence>
 *                           &lt;attribute name="EmailAddress" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="AskForReceiptInd" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="CountryCode" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="GDS_ID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Language" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="StateCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DonationType", propOrder = {
    "frontOfficeInfo",
    "creditCardInfo",
    "donorInfo"
})
public class DonationType {

    @XmlElement(name = "FrontOfficeInfo")
    protected DonationType.FrontOfficeInfo frontOfficeInfo;
    @XmlElement(name = "CreditCardInfo", required = true)
    protected DonationType.CreditCardInfo creditCardInfo;
    @XmlElement(name = "DonorInfo")
    protected DonationType.DonorInfo donorInfo;
    @XmlAttribute(name = "AskForReceiptInd", required = true)
    protected boolean askForReceiptInd;
    @XmlAttribute(name = "CountryCode", required = true)
    protected String countryCode;
    @XmlAttribute(name = "GDS_ID")
    protected String gdsid;
    @XmlAttribute(name = "Language", required = true)
    protected String language;
    @XmlAttribute(name = "StateCode")
    protected String stateCode;

    /**
     * Gets the value of the frontOfficeInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DonationType.FrontOfficeInfo }
     *     
     */
    public DonationType.FrontOfficeInfo getFrontOfficeInfo() {
        return frontOfficeInfo;
    }

    /**
     * Sets the value of the frontOfficeInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DonationType.FrontOfficeInfo }
     *     
     */
    public void setFrontOfficeInfo(DonationType.FrontOfficeInfo value) {
        this.frontOfficeInfo = value;
    }

    /**
     * Gets the value of the creditCardInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DonationType.CreditCardInfo }
     *     
     */
    public DonationType.CreditCardInfo getCreditCardInfo() {
        return creditCardInfo;
    }

    /**
     * Sets the value of the creditCardInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DonationType.CreditCardInfo }
     *     
     */
    public void setCreditCardInfo(DonationType.CreditCardInfo value) {
        this.creditCardInfo = value;
    }

    /**
     * Gets the value of the donorInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DonationType.DonorInfo }
     *     
     */
    public DonationType.DonorInfo getDonorInfo() {
        return donorInfo;
    }

    /**
     * Sets the value of the donorInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DonationType.DonorInfo }
     *     
     */
    public void setDonorInfo(DonationType.DonorInfo value) {
        this.donorInfo = value;
    }

    /**
     * Gets the value of the askForReceiptInd property.
     * 
     */
    public boolean isAskForReceiptInd() {
        return askForReceiptInd;
    }

    /**
     * Sets the value of the askForReceiptInd property.
     * 
     */
    public void setAskForReceiptInd(boolean value) {
        this.askForReceiptInd = value;
    }

    /**
     * Gets the value of the countryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * Gets the value of the gdsid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGDSID() {
        return gdsid;
    }

    /**
     * Sets the value of the gdsid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGDSID(String value) {
        this.gdsid = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the stateCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateCode() {
        return stateCode;
    }

    /**
     * Sets the value of the stateCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateCode(String value) {
        this.stateCode = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}PaymentCardType">
     *       &lt;sequence>
     *       &lt;/sequence>
     *       &lt;attribute name="Currency" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="DonationAmount" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class CreditCardInfo
        extends PaymentCardType
    {

        @XmlAttribute(name = "Currency", required = true)
        protected String currency;
        @XmlAttribute(name = "DonationAmount", required = true)
        protected BigDecimal donationAmount;

        /**
         * Gets the value of the currency property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCurrency() {
            return currency;
        }

        /**
         * Sets the value of the currency property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCurrency(String value) {
            this.currency = value;
        }

        /**
         * Gets the value of the donationAmount property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getDonationAmount() {
            return donationAmount;
        }

        /**
         * Sets the value of the donationAmount property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setDonationAmount(BigDecimal value) {
            this.donationAmount = value;
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
     *         &lt;element name="Name" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}PersonNameType">
     *                 &lt;sequence>
     *                 &lt;/sequence>
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="ContactInfo" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}AddressType">
     *                 &lt;sequence>
     *                 &lt;/sequence>
     *                 &lt;attribute name="EmailAddress" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
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
        "name",
        "contactInfo"
    })
    public static class DonorInfo {

        @XmlElement(name = "Name")
        protected DonationType.DonorInfo.Name name;
        @XmlElement(name = "ContactInfo")
        protected DonationType.DonorInfo.ContactInfo contactInfo;

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link DonationType.DonorInfo.Name }
         *     
         */
        public DonationType.DonorInfo.Name getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link DonationType.DonorInfo.Name }
         *     
         */
        public void setName(DonationType.DonorInfo.Name value) {
            this.name = value;
        }

        /**
         * Gets the value of the contactInfo property.
         * 
         * @return
         *     possible object is
         *     {@link DonationType.DonorInfo.ContactInfo }
         *     
         */
        public DonationType.DonorInfo.ContactInfo getContactInfo() {
            return contactInfo;
        }

        /**
         * Sets the value of the contactInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link DonationType.DonorInfo.ContactInfo }
         *     
         */
        public void setContactInfo(DonationType.DonorInfo.ContactInfo value) {
            this.contactInfo = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}AddressType">
         *       &lt;sequence>
         *       &lt;/sequence>
         *       &lt;attribute name="EmailAddress" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class ContactInfo
            extends AddressType
        {

            @XmlAttribute(name = "EmailAddress")
            protected String emailAddress;

            /**
             * Gets the value of the emailAddress property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEmailAddress() {
                return emailAddress;
            }

            /**
             * Sets the value of the emailAddress property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEmailAddress(String value) {
                this.emailAddress = value;
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
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Name
            extends PersonNameType
        {


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
     *       &lt;attribute name="CorporateID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="OfficeID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="ProductName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="ProductVersion" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class FrontOfficeInfo {

        @XmlAttribute(name = "CorporateID", required = true)
        protected String corporateID;
        @XmlAttribute(name = "OfficeID", required = true)
        protected String officeID;
        @XmlAttribute(name = "ProductName", required = true)
        protected String productName;
        @XmlAttribute(name = "ProductVersion", required = true)
        protected String productVersion;

        /**
         * Gets the value of the corporateID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCorporateID() {
            return corporateID;
        }

        /**
         * Sets the value of the corporateID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCorporateID(String value) {
            this.corporateID = value;
        }

        /**
         * Gets the value of the officeID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOfficeID() {
            return officeID;
        }

        /**
         * Sets the value of the officeID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOfficeID(String value) {
            this.officeID = value;
        }

        /**
         * Gets the value of the productName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProductName() {
            return productName;
        }

        /**
         * Sets the value of the productName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProductName(String value) {
            this.productName = value;
        }

        /**
         * Gets the value of the productVersion property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProductVersion() {
            return productVersion;
        }

        /**
         * Sets the value of the productVersion property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProductVersion(String value) {
            this.productVersion = value;
        }

    }

}
