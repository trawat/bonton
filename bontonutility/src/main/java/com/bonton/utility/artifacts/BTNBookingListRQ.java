//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.22 at 05:35:42 PM IST 
//


package com.bonton.utility.artifacts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


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
 *         &lt;element name="Details"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="checkin" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="checkout" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="cancelled" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="filter" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="fromIndex" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="toIndex" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
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
    "details"
})
@XmlRootElement(name = "BTNBookingListRQ")
public class BTNBookingListRQ {

    @XmlElement(name = "Details", required = true)
    protected BTNBookingListRQ.Details details;

    /**
     * Gets the value of the details property.
     * 
     * @return
     *     possible object is
     *     {@link BTNBookingListRQ.Details }
     *     
     */
    public BTNBookingListRQ.Details getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     * 
     * @param value
     *     allowed object is
     *     {@link BTNBookingListRQ.Details }
     *     
     */
    public void setDetails(BTNBookingListRQ.Details value) {
        this.details = value;
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
     *       &lt;attribute name="checkin" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="checkout" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="cancelled" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="filter" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="fromIndex" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="toIndex" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
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
    public static class Details {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "checkin")
        protected String checkin;
        @XmlAttribute(name = "checkout")
        protected String checkout;
        @XmlAttribute(name = "cancelled")
        protected String cancelled;
        @XmlAttribute(name = "filter")
        protected String filter;
        @XmlAttribute(name = "fromIndex")
        protected String fromIndex;
        @XmlAttribute(name = "toIndex")
        protected String toIndex;

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
         * Gets the value of the checkin property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCheckin() {
            return checkin;
        }

        /**
         * Sets the value of the checkin property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCheckin(String value) {
            this.checkin = value;
        }

        /**
         * Gets the value of the checkout property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCheckout() {
            return checkout;
        }

        /**
         * Sets the value of the checkout property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCheckout(String value) {
            this.checkout = value;
        }

        /**
         * Gets the value of the cancelled property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCancelled() {
            return cancelled;
        }

        /**
         * Sets the value of the cancelled property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCancelled(String value) {
            this.cancelled = value;
        }

        /**
         * Gets the value of the filter property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFilter() {
            return filter;
        }

        /**
         * Sets the value of the filter property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFilter(String value) {
            this.filter = value;
        }

        /**
         * Gets the value of the fromIndex property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFromIndex() {
            return fromIndex;
        }

        /**
         * Sets the value of the fromIndex property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFromIndex(String value) {
            this.fromIndex = value;
        }

        /**
         * Gets the value of the toIndex property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getToIndex() {
            return toIndex;
        }

        /**
         * Sets the value of the toIndex property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setToIndex(String value) {
            this.toIndex = value;
        }

    }

}
