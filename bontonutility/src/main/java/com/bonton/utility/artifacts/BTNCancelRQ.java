//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.07.08 at 10:52:55 AM IST 
//


package com.bonton.utility.artifacts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Supplier" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PeriodOfStay" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="CheckOutDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                   &lt;element name="CheckInDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="CancelDetails"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="language" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="referenceId" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="cancelFlag" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "supplier",
    "periodOfStay",
    "cancelDetails"
})
@XmlRootElement(name = "BTNCancelRQ")
public class BTNCancelRQ {

    @XmlElement(name = "Supplier", required = true)
    protected String supplier;
    @XmlElement(name = "PeriodOfStay")
    protected BTNCancelRQ.PeriodOfStay periodOfStay;
    @XmlElement(name = "CancelDetails", required = true)
    protected BTNCancelRQ.CancelDetails cancelDetails;

    /**
     * Gets the value of the supplier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplier() {
        return supplier;
    }

    /**
     * Sets the value of the supplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplier(String value) {
        this.supplier = value;
    }

    /**
     * Gets the value of the periodOfStay property.
     * 
     * @return
     *     possible object is
     *     {@link BTNCancelRQ.PeriodOfStay }
     *     
     */
    public BTNCancelRQ.PeriodOfStay getPeriodOfStay() {
        return periodOfStay;
    }

    /**
     * Sets the value of the periodOfStay property.
     * 
     * @param value
     *     allowed object is
     *     {@link BTNCancelRQ.PeriodOfStay }
     *     
     */
    public void setPeriodOfStay(BTNCancelRQ.PeriodOfStay value) {
        this.periodOfStay = value;
    }

    /**
     * Gets the value of the cancelDetails property.
     * 
     * @return
     *     possible object is
     *     {@link BTNCancelRQ.CancelDetails }
     *     
     */
    public BTNCancelRQ.CancelDetails getCancelDetails() {
        return cancelDetails;
    }

    /**
     * Sets the value of the cancelDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link BTNCancelRQ.CancelDetails }
     *     
     */
    public void setCancelDetails(BTNCancelRQ.CancelDetails value) {
        this.cancelDetails = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *       &lt;attribute name="language" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="referenceId" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="cancelFlag" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class CancelDetails {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "language")
        protected String language;
        @XmlAttribute(name = "referenceId")
        protected String referenceId;
        @XmlAttribute(name = "cancelFlag")
        protected String cancelFlag;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
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
         * Gets the value of the referenceId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getReferenceId() {
            return referenceId;
        }

        /**
         * Sets the value of the referenceId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setReferenceId(String value) {
            this.referenceId = value;
        }

        /**
         * Gets the value of the cancelFlag property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCancelFlag() {
            return cancelFlag;
        }

        /**
         * Sets the value of the cancelFlag property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCancelFlag(String value) {
            this.cancelFlag = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="CheckOutDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *         &lt;element name="CheckInDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "checkOutDate",
        "checkInDate"
    })
    public static class PeriodOfStay {

        @XmlElement(name = "CheckOutDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar checkOutDate;
        @XmlElement(name = "CheckInDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar checkInDate;

        /**
         * Gets the value of the checkOutDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getCheckOutDate() {
            return checkOutDate;
        }

        /**
         * Sets the value of the checkOutDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setCheckOutDate(XMLGregorianCalendar value) {
            this.checkOutDate = value;
        }

        /**
         * Gets the value of the checkInDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getCheckInDate() {
            return checkInDate;
        }

        /**
         * Sets the value of the checkInDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setCheckInDate(XMLGregorianCalendar value) {
            this.checkInDate = value;
        }

    }

}
