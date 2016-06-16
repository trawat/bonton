
package com.desia.artifacts.search;

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
 * <p>Java class for GuaranteeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GuaranteeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GuaranteesAccepted" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="GuaranteeAccepted" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://www.opentravel.org/OTA/2003/05}PaymentFormType">
 *                           &lt;sequence>
 *                           &lt;/sequence>
 *                           &lt;attribute name="AddressReqInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                           &lt;attribute name="BookingSourceAllowedInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                           &lt;attribute name="CorpDiscountNbrAllowedInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                           &lt;attribute name="Default" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                           &lt;attribute name="InterbankNbrReqInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                           &lt;attribute name="NameReqInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                           &lt;attribute name="NoCardHolderInfoReqInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                           &lt;attribute name="PhoneReqInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Deadline" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                 &lt;/sequence>
 *                 &lt;attribute name="AbsoluteDeadline" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="OffsetDropTime" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="OffsetTimeUnit" type="{http://www.opentravel.org/OTA/2003/05}timeUnitType" />
 *                 &lt;attribute name="OffsetUnitMultiplier" type="{http://www.w3.org/2001/XMLSchema}int" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Comments" type="{http://www.opentravel.org/OTA/2003/05}CommentType" minOccurs="0"/>
 *         &lt;element name="GuaranteeDescription" type="{http://www.opentravel.org/OTA/2003/05}ParagraphType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="GuaranteeCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="GuaranteeType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="HoldTime" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="RetributionType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GuaranteeType", propOrder = {
    "guaranteesAccepted",
    "deadline",
    "comments",
    "guaranteeDescription"
})
@XmlSeeAlso({
    com.desia.artifacts.search.BookingRulesType.BookingRule.AcceptableGuarantees.AcceptableGuarantee.class
})
public class GuaranteeType {

    @XmlElement(name = "GuaranteesAccepted")
    protected GuaranteeType.GuaranteesAccepted guaranteesAccepted;
    @XmlElement(name = "Deadline")
    protected GuaranteeType.Deadline deadline;
    @XmlElement(name = "Comments")
    protected CommentType comments;
    @XmlElement(name = "GuaranteeDescription")
    protected List<ParagraphType> guaranteeDescription;
    @XmlAttribute(name = "GuaranteeCode")
    protected String guaranteeCode;
    @XmlAttribute(name = "GuaranteeType")
    protected String guaranteeType;
    @XmlAttribute(name = "HoldTime")
    @XmlSchemaType(name = "anySimpleType")
    protected String holdTime;
    @XmlAttribute(name = "RetributionType")
    protected String retributionType;

    /**
     * Gets the value of the guaranteesAccepted property.
     * 
     * @return
     *     possible object is
     *     {@link GuaranteeType.GuaranteesAccepted }
     *     
     */
    public GuaranteeType.GuaranteesAccepted getGuaranteesAccepted() {
        return guaranteesAccepted;
    }

    /**
     * Sets the value of the guaranteesAccepted property.
     * 
     * @param value
     *     allowed object is
     *     {@link GuaranteeType.GuaranteesAccepted }
     *     
     */
    public void setGuaranteesAccepted(GuaranteeType.GuaranteesAccepted value) {
        this.guaranteesAccepted = value;
    }

    /**
     * Gets the value of the deadline property.
     * 
     * @return
     *     possible object is
     *     {@link GuaranteeType.Deadline }
     *     
     */
    public GuaranteeType.Deadline getDeadline() {
        return deadline;
    }

    /**
     * Sets the value of the deadline property.
     * 
     * @param value
     *     allowed object is
     *     {@link GuaranteeType.Deadline }
     *     
     */
    public void setDeadline(GuaranteeType.Deadline value) {
        this.deadline = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link CommentType }
     *     
     */
    public CommentType getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommentType }
     *     
     */
    public void setComments(CommentType value) {
        this.comments = value;
    }

    /**
     * Gets the value of the guaranteeDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the guaranteeDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGuaranteeDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParagraphType }
     * 
     * 
     */
    public List<ParagraphType> getGuaranteeDescription() {
        if (guaranteeDescription == null) {
            guaranteeDescription = new ArrayList<ParagraphType>();
        }
        return this.guaranteeDescription;
    }

    /**
     * Gets the value of the guaranteeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuaranteeCode() {
        return guaranteeCode;
    }

    /**
     * Sets the value of the guaranteeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuaranteeCode(String value) {
        this.guaranteeCode = value;
    }

    /**
     * Gets the value of the guaranteeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuaranteeType() {
        return guaranteeType;
    }

    /**
     * Sets the value of the guaranteeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuaranteeType(String value) {
        this.guaranteeType = value;
    }

    /**
     * Gets the value of the holdTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHoldTime() {
        return holdTime;
    }

    /**
     * Sets the value of the holdTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHoldTime(String value) {
        this.holdTime = value;
    }

    /**
     * Gets the value of the retributionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRetributionType() {
        return retributionType;
    }

    /**
     * Sets the value of the retributionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRetributionType(String value) {
        this.retributionType = value;
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
     *       &lt;attribute name="AbsoluteDeadline" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="OffsetDropTime" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="OffsetTimeUnit" type="{http://www.opentravel.org/OTA/2003/05}timeUnitType" />
     *       &lt;attribute name="OffsetUnitMultiplier" type="{http://www.w3.org/2001/XMLSchema}int" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Deadline {

        @XmlAttribute(name = "AbsoluteDeadline")
        protected String absoluteDeadline;
        @XmlAttribute(name = "OffsetDropTime")
        protected String offsetDropTime;
        @XmlAttribute(name = "OffsetTimeUnit")
        protected TimeUnitType offsetTimeUnit;
        @XmlAttribute(name = "OffsetUnitMultiplier")
        protected Integer offsetUnitMultiplier;

        /**
         * Gets the value of the absoluteDeadline property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAbsoluteDeadline() {
            return absoluteDeadline;
        }

        /**
         * Sets the value of the absoluteDeadline property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAbsoluteDeadline(String value) {
            this.absoluteDeadline = value;
        }

        /**
         * Gets the value of the offsetDropTime property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOffsetDropTime() {
            return offsetDropTime;
        }

        /**
         * Sets the value of the offsetDropTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOffsetDropTime(String value) {
            this.offsetDropTime = value;
        }

        /**
         * Gets the value of the offsetTimeUnit property.
         * 
         * @return
         *     possible object is
         *     {@link TimeUnitType }
         *     
         */
        public TimeUnitType getOffsetTimeUnit() {
            return offsetTimeUnit;
        }

        /**
         * Sets the value of the offsetTimeUnit property.
         * 
         * @param value
         *     allowed object is
         *     {@link TimeUnitType }
         *     
         */
        public void setOffsetTimeUnit(TimeUnitType value) {
            this.offsetTimeUnit = value;
        }

        /**
         * Gets the value of the offsetUnitMultiplier property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getOffsetUnitMultiplier() {
            return offsetUnitMultiplier;
        }

        /**
         * Sets the value of the offsetUnitMultiplier property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setOffsetUnitMultiplier(Integer value) {
            this.offsetUnitMultiplier = value;
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
     *         &lt;element name="GuaranteeAccepted" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}PaymentFormType">
     *                 &lt;sequence>
     *                 &lt;/sequence>
     *                 &lt;attribute name="AddressReqInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                 &lt;attribute name="BookingSourceAllowedInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                 &lt;attribute name="CorpDiscountNbrAllowedInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                 &lt;attribute name="Default" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                 &lt;attribute name="InterbankNbrReqInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                 &lt;attribute name="NameReqInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                 &lt;attribute name="NoCardHolderInfoReqInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                 &lt;attribute name="PhoneReqInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
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
        "guaranteeAccepted"
    })
    public static class GuaranteesAccepted {

        @XmlElement(name = "GuaranteeAccepted", required = true)
        protected List<GuaranteeType.GuaranteesAccepted.GuaranteeAccepted> guaranteeAccepted;

        /**
         * Gets the value of the guaranteeAccepted property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the guaranteeAccepted property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getGuaranteeAccepted().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GuaranteeType.GuaranteesAccepted.GuaranteeAccepted }
         * 
         * 
         */
        public List<GuaranteeType.GuaranteesAccepted.GuaranteeAccepted> getGuaranteeAccepted() {
            if (guaranteeAccepted == null) {
                guaranteeAccepted = new ArrayList<GuaranteeType.GuaranteesAccepted.GuaranteeAccepted>();
            }
            return this.guaranteeAccepted;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}PaymentFormType">
         *       &lt;sequence>
         *       &lt;/sequence>
         *       &lt;attribute name="AddressReqInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *       &lt;attribute name="BookingSourceAllowedInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *       &lt;attribute name="CorpDiscountNbrAllowedInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *       &lt;attribute name="Default" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *       &lt;attribute name="InterbankNbrReqInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *       &lt;attribute name="NameReqInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *       &lt;attribute name="NoCardHolderInfoReqInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *       &lt;attribute name="PhoneReqInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class GuaranteeAccepted
            extends PaymentFormType
        {

            @XmlAttribute(name = "AddressReqInd")
            protected Boolean addressReqInd;
            @XmlAttribute(name = "BookingSourceAllowedInd")
            protected Boolean bookingSourceAllowedInd;
            @XmlAttribute(name = "CorpDiscountNbrAllowedInd")
            protected Boolean corpDiscountNbrAllowedInd;
            @XmlAttribute(name = "Default")
            protected Boolean _default;
            @XmlAttribute(name = "InterbankNbrReqInd")
            protected Boolean interbankNbrReqInd;
            @XmlAttribute(name = "NameReqInd")
            protected Boolean nameReqInd;
            @XmlAttribute(name = "NoCardHolderInfoReqInd")
            protected Boolean noCardHolderInfoReqInd;
            @XmlAttribute(name = "PhoneReqInd")
            protected Boolean phoneReqInd;

            /**
             * Gets the value of the addressReqInd property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isAddressReqInd() {
                return addressReqInd;
            }

            /**
             * Sets the value of the addressReqInd property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setAddressReqInd(Boolean value) {
                this.addressReqInd = value;
            }

            /**
             * Gets the value of the bookingSourceAllowedInd property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isBookingSourceAllowedInd() {
                return bookingSourceAllowedInd;
            }

            /**
             * Sets the value of the bookingSourceAllowedInd property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setBookingSourceAllowedInd(Boolean value) {
                this.bookingSourceAllowedInd = value;
            }

            /**
             * Gets the value of the corpDiscountNbrAllowedInd property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isCorpDiscountNbrAllowedInd() {
                return corpDiscountNbrAllowedInd;
            }

            /**
             * Sets the value of the corpDiscountNbrAllowedInd property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setCorpDiscountNbrAllowedInd(Boolean value) {
                this.corpDiscountNbrAllowedInd = value;
            }

            /**
             * Gets the value of the default property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isDefault() {
                return _default;
            }

            /**
             * Sets the value of the default property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setDefault(Boolean value) {
                this._default = value;
            }

            /**
             * Gets the value of the interbankNbrReqInd property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isInterbankNbrReqInd() {
                return interbankNbrReqInd;
            }

            /**
             * Sets the value of the interbankNbrReqInd property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setInterbankNbrReqInd(Boolean value) {
                this.interbankNbrReqInd = value;
            }

            /**
             * Gets the value of the nameReqInd property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isNameReqInd() {
                return nameReqInd;
            }

            /**
             * Sets the value of the nameReqInd property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setNameReqInd(Boolean value) {
                this.nameReqInd = value;
            }

            /**
             * Gets the value of the noCardHolderInfoReqInd property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isNoCardHolderInfoReqInd() {
                return noCardHolderInfoReqInd;
            }

            /**
             * Sets the value of the noCardHolderInfoReqInd property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setNoCardHolderInfoReqInd(Boolean value) {
                this.noCardHolderInfoReqInd = value;
            }

            /**
             * Gets the value of the phoneReqInd property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isPhoneReqInd() {
                return phoneReqInd;
            }

            /**
             * Sets the value of the phoneReqInd property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setPhoneReqInd(Boolean value) {
                this.phoneReqInd = value;
            }

        }

    }

}
