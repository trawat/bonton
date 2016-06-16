
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
 * <p>Java class for AvailRequestSegmentsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AvailRequestSegmentsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AvailRequestSegment" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="HotelSearchCriteria" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://www.opentravel.org/OTA/2003/05}HotelSearchCriteriaType">
 *                           &lt;sequence>
 *                           &lt;/sequence>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="TPA_Extensions" type="{http://www.opentravel.org/OTA/2003/05}TPA_ExtensionsType" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="AvailReqType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="InfoSource" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="MoreDataEchoToken" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="ResponseType" type="{http://www.w3.org/2001/XMLSchema}string" />
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
@XmlType(name = "AvailRequestSegmentsType", propOrder = {
    "availRequestSegment"
})
@XmlSeeAlso({
    com.desia.artifacts.search.OTAHotelAvailRQ.AvailRequestSegments.class
})
public class AvailRequestSegmentsType {

    @XmlElement(name = "AvailRequestSegment", required = true)
    protected List<AvailRequestSegmentsType.AvailRequestSegment> availRequestSegment;

    /**
     * Gets the value of the availRequestSegment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the availRequestSegment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAvailRequestSegment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AvailRequestSegmentsType.AvailRequestSegment }
     * 
     * 
     */
    public List<AvailRequestSegmentsType.AvailRequestSegment> getAvailRequestSegment() {
        if (availRequestSegment == null) {
            availRequestSegment = new ArrayList<AvailRequestSegmentsType.AvailRequestSegment>();
        }
        return this.availRequestSegment;
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
     *         &lt;element name="HotelSearchCriteria" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}HotelSearchCriteriaType">
     *                 &lt;sequence>
     *                 &lt;/sequence>
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="TPA_Extensions" type="{http://www.opentravel.org/OTA/2003/05}TPA_ExtensionsType" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="AvailReqType" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="InfoSource" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="MoreDataEchoToken" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="ResponseType" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "hotelSearchCriteria",
        "tpaExtensions"
    })
    public static class AvailRequestSegment {

        @XmlElement(name = "HotelSearchCriteria")
        protected AvailRequestSegmentsType.AvailRequestSegment.HotelSearchCriteria hotelSearchCriteria;
        @XmlElement(name = "TPA_Extensions")
        protected TPAExtensionsType tpaExtensions;
        @XmlAttribute(name = "AvailReqType")
        protected String availReqType;
        @XmlAttribute(name = "InfoSource")
        protected String infoSource;
        @XmlAttribute(name = "MoreDataEchoToken")
        protected String moreDataEchoToken;
        @XmlAttribute(name = "ResponseType")
        protected String responseType;

        /**
         * Gets the value of the hotelSearchCriteria property.
         * 
         * @return
         *     possible object is
         *     {@link AvailRequestSegmentsType.AvailRequestSegment.HotelSearchCriteria }
         *     
         */
        public AvailRequestSegmentsType.AvailRequestSegment.HotelSearchCriteria getHotelSearchCriteria() {
            return hotelSearchCriteria;
        }

        /**
         * Sets the value of the hotelSearchCriteria property.
         * 
         * @param value
         *     allowed object is
         *     {@link AvailRequestSegmentsType.AvailRequestSegment.HotelSearchCriteria }
         *     
         */
        public void setHotelSearchCriteria(AvailRequestSegmentsType.AvailRequestSegment.HotelSearchCriteria value) {
            this.hotelSearchCriteria = value;
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
         * Gets the value of the availReqType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAvailReqType() {
            return availReqType;
        }

        /**
         * Sets the value of the availReqType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAvailReqType(String value) {
            this.availReqType = value;
        }

        /**
         * Gets the value of the infoSource property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInfoSource() {
            return infoSource;
        }

        /**
         * Sets the value of the infoSource property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInfoSource(String value) {
            this.infoSource = value;
        }

        /**
         * Gets the value of the moreDataEchoToken property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMoreDataEchoToken() {
            return moreDataEchoToken;
        }

        /**
         * Sets the value of the moreDataEchoToken property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMoreDataEchoToken(String value) {
            this.moreDataEchoToken = value;
        }

        /**
         * Gets the value of the responseType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getResponseType() {
            return responseType;
        }

        /**
         * Sets the value of the responseType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setResponseType(String value) {
            this.responseType = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}HotelSearchCriteriaType">
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
        public static class HotelSearchCriteria
            extends HotelSearchCriteriaType
        {


        }

    }

}
