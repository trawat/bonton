
package com.desia.artifacts.booking;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}MessageAcknowledgementType">
 *       &lt;sequence>
 *         &lt;element name="NotifDetails" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="HotelNotifReport">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="AvailStatusMessages" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="AvailStatusMessage" maxOccurs="unbounded">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;extension base="{http://www.opentravel.org/OTA/2003/05}AvailStatusMessageType">
 *                                               &lt;sequence>
 *                                               &lt;/sequence>
 *                                             &lt;/extension>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="BrandCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="BrandName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="ChainCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="ChainName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="HotelCityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="HotelCodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="AreaID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="RateAmountMessages" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="RateAmountMessage" type="{http://www.opentravel.org/OTA/2003/05}RateAmountMessageType" maxOccurs="unbounded"/>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="BrandCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="BrandName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="ChainCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="ChainName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="HotelCityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="HotelCodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="AreaID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="HotelDescriptiveContents" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="HotelDescriptiveContent" maxOccurs="unbounded">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;extension base="{http://www.opentravel.org/OTA/2003/05}HotelDescriptiveContentType">
 *                                               &lt;sequence>
 *                                               &lt;/sequence>
 *                                               &lt;attribute name="BrandCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="BrandName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="ChainCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="ChainName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="HotelCityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="HotelCodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="AreaID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                             &lt;/extension>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="BrandCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="BrandName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="ChainCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="ChainName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="HotelCityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="HotelCodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="AreaID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
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
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "notifDetails"
})
@XmlRootElement(name = "OTA_NotifReportRQ")
public class OTANotifReportRQ
    extends MessageAcknowledgementType
{

    @XmlElement(name = "NotifDetails")
    protected OTANotifReportRQ.NotifDetails notifDetails;

    /**
     * Gets the value of the notifDetails property.
     * 
     * @return
     *     possible object is
     *     {@link OTANotifReportRQ.NotifDetails }
     *     
     */
    public OTANotifReportRQ.NotifDetails getNotifDetails() {
        return notifDetails;
    }

    /**
     * Sets the value of the notifDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link OTANotifReportRQ.NotifDetails }
     *     
     */
    public void setNotifDetails(OTANotifReportRQ.NotifDetails value) {
        this.notifDetails = value;
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
     *         &lt;element name="HotelNotifReport">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="AvailStatusMessages" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="AvailStatusMessage" maxOccurs="unbounded">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;extension base="{http://www.opentravel.org/OTA/2003/05}AvailStatusMessageType">
     *                                     &lt;sequence>
     *                                     &lt;/sequence>
     *                                   &lt;/extension>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                           &lt;attribute name="BrandCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="BrandName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="ChainCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="ChainName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="HotelCityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="HotelCodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="AreaID" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="RateAmountMessages" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="RateAmountMessage" type="{http://www.opentravel.org/OTA/2003/05}RateAmountMessageType" maxOccurs="unbounded"/>
     *                           &lt;/sequence>
     *                           &lt;attribute name="BrandCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="BrandName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="ChainCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="ChainName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="HotelCityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="HotelCodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="AreaID" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="HotelDescriptiveContents" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="HotelDescriptiveContent" maxOccurs="unbounded">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;extension base="{http://www.opentravel.org/OTA/2003/05}HotelDescriptiveContentType">
     *                                     &lt;sequence>
     *                                     &lt;/sequence>
     *                                     &lt;attribute name="BrandCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="BrandName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="ChainCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="ChainName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="HotelCityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="HotelCodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="AreaID" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                   &lt;/extension>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                           &lt;attribute name="BrandCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="BrandName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="ChainCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="ChainName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="HotelCityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="HotelCodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="AreaID" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
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
        "hotelNotifReport"
    })
    public static class NotifDetails {

        @XmlElement(name = "HotelNotifReport", required = true)
        protected OTANotifReportRQ.NotifDetails.HotelNotifReport hotelNotifReport;

        /**
         * Gets the value of the hotelNotifReport property.
         * 
         * @return
         *     possible object is
         *     {@link OTANotifReportRQ.NotifDetails.HotelNotifReport }
         *     
         */
        public OTANotifReportRQ.NotifDetails.HotelNotifReport getHotelNotifReport() {
            return hotelNotifReport;
        }

        /**
         * Sets the value of the hotelNotifReport property.
         * 
         * @param value
         *     allowed object is
         *     {@link OTANotifReportRQ.NotifDetails.HotelNotifReport }
         *     
         */
        public void setHotelNotifReport(OTANotifReportRQ.NotifDetails.HotelNotifReport value) {
            this.hotelNotifReport = value;
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
         *         &lt;element name="AvailStatusMessages" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="AvailStatusMessage" maxOccurs="unbounded">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;extension base="{http://www.opentravel.org/OTA/2003/05}AvailStatusMessageType">
         *                           &lt;sequence>
         *                           &lt;/sequence>
         *                         &lt;/extension>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *                 &lt;attribute name="BrandCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="BrandName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="ChainCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="ChainName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="HotelCityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="HotelCodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="AreaID" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="RateAmountMessages" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="RateAmountMessage" type="{http://www.opentravel.org/OTA/2003/05}RateAmountMessageType" maxOccurs="unbounded"/>
         *                 &lt;/sequence>
         *                 &lt;attribute name="BrandCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="BrandName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="ChainCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="ChainName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="HotelCityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="HotelCodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="AreaID" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="HotelDescriptiveContents" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="HotelDescriptiveContent" maxOccurs="unbounded">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;extension base="{http://www.opentravel.org/OTA/2003/05}HotelDescriptiveContentType">
         *                           &lt;sequence>
         *                           &lt;/sequence>
         *                           &lt;attribute name="BrandCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="BrandName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="ChainCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="ChainName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="HotelCityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="HotelCodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="AreaID" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                         &lt;/extension>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *                 &lt;attribute name="BrandCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="BrandName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="ChainCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="ChainName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="HotelCityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="HotelCodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="AreaID" type="{http://www.w3.org/2001/XMLSchema}string" />
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
            "availStatusMessages",
            "rateAmountMessages",
            "hotelDescriptiveContents"
        })
        public static class HotelNotifReport {

            @XmlElement(name = "AvailStatusMessages")
            protected OTANotifReportRQ.NotifDetails.HotelNotifReport.AvailStatusMessages availStatusMessages;
            @XmlElement(name = "RateAmountMessages")
            protected OTANotifReportRQ.NotifDetails.HotelNotifReport.RateAmountMessages rateAmountMessages;
            @XmlElement(name = "HotelDescriptiveContents")
            protected OTANotifReportRQ.NotifDetails.HotelNotifReport.HotelDescriptiveContents hotelDescriptiveContents;

            /**
             * Gets the value of the availStatusMessages property.
             * 
             * @return
             *     possible object is
             *     {@link OTANotifReportRQ.NotifDetails.HotelNotifReport.AvailStatusMessages }
             *     
             */
            public OTANotifReportRQ.NotifDetails.HotelNotifReport.AvailStatusMessages getAvailStatusMessages() {
                return availStatusMessages;
            }

            /**
             * Sets the value of the availStatusMessages property.
             * 
             * @param value
             *     allowed object is
             *     {@link OTANotifReportRQ.NotifDetails.HotelNotifReport.AvailStatusMessages }
             *     
             */
            public void setAvailStatusMessages(OTANotifReportRQ.NotifDetails.HotelNotifReport.AvailStatusMessages value) {
                this.availStatusMessages = value;
            }

            /**
             * Gets the value of the rateAmountMessages property.
             * 
             * @return
             *     possible object is
             *     {@link OTANotifReportRQ.NotifDetails.HotelNotifReport.RateAmountMessages }
             *     
             */
            public OTANotifReportRQ.NotifDetails.HotelNotifReport.RateAmountMessages getRateAmountMessages() {
                return rateAmountMessages;
            }

            /**
             * Sets the value of the rateAmountMessages property.
             * 
             * @param value
             *     allowed object is
             *     {@link OTANotifReportRQ.NotifDetails.HotelNotifReport.RateAmountMessages }
             *     
             */
            public void setRateAmountMessages(OTANotifReportRQ.NotifDetails.HotelNotifReport.RateAmountMessages value) {
                this.rateAmountMessages = value;
            }

            /**
             * Gets the value of the hotelDescriptiveContents property.
             * 
             * @return
             *     possible object is
             *     {@link OTANotifReportRQ.NotifDetails.HotelNotifReport.HotelDescriptiveContents }
             *     
             */
            public OTANotifReportRQ.NotifDetails.HotelNotifReport.HotelDescriptiveContents getHotelDescriptiveContents() {
                return hotelDescriptiveContents;
            }

            /**
             * Sets the value of the hotelDescriptiveContents property.
             * 
             * @param value
             *     allowed object is
             *     {@link OTANotifReportRQ.NotifDetails.HotelNotifReport.HotelDescriptiveContents }
             *     
             */
            public void setHotelDescriptiveContents(OTANotifReportRQ.NotifDetails.HotelNotifReport.HotelDescriptiveContents value) {
                this.hotelDescriptiveContents = value;
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
             *         &lt;element name="AvailStatusMessage" maxOccurs="unbounded">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}AvailStatusMessageType">
             *                 &lt;sequence>
             *                 &lt;/sequence>
             *               &lt;/extension>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *       &lt;attribute name="BrandCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="BrandName" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="ChainCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="ChainName" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="HotelCityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="HotelCodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="AreaID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "availStatusMessage"
            })
            public static class AvailStatusMessages {

                @XmlElement(name = "AvailStatusMessage", required = true)
                protected List<OTANotifReportRQ.NotifDetails.HotelNotifReport.AvailStatusMessages.AvailStatusMessage> availStatusMessage;
                @XmlAttribute(name = "BrandCode")
                protected String brandCode;
                @XmlAttribute(name = "BrandName")
                protected String brandName;
                @XmlAttribute(name = "ChainCode")
                protected String chainCode;
                @XmlAttribute(name = "ChainName")
                protected String chainName;
                @XmlAttribute(name = "HotelCityCode")
                protected String hotelCityCode;
                @XmlAttribute(name = "HotelCode")
                protected String hotelCode;
                @XmlAttribute(name = "HotelCodeContext")
                protected String hotelCodeContext;
                @XmlAttribute(name = "HotelName")
                protected String hotelName;
                @XmlAttribute(name = "AreaID")
                protected String areaID;

                /**
                 * Gets the value of the availStatusMessage property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the availStatusMessage property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getAvailStatusMessage().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link OTANotifReportRQ.NotifDetails.HotelNotifReport.AvailStatusMessages.AvailStatusMessage }
                 * 
                 * 
                 */
                public List<OTANotifReportRQ.NotifDetails.HotelNotifReport.AvailStatusMessages.AvailStatusMessage> getAvailStatusMessage() {
                    if (availStatusMessage == null) {
                        availStatusMessage = new ArrayList<OTANotifReportRQ.NotifDetails.HotelNotifReport.AvailStatusMessages.AvailStatusMessage>();
                    }
                    return this.availStatusMessage;
                }

                /**
                 * Gets the value of the brandCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getBrandCode() {
                    return brandCode;
                }

                /**
                 * Sets the value of the brandCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setBrandCode(String value) {
                    this.brandCode = value;
                }

                /**
                 * Gets the value of the brandName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getBrandName() {
                    return brandName;
                }

                /**
                 * Sets the value of the brandName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setBrandName(String value) {
                    this.brandName = value;
                }

                /**
                 * Gets the value of the chainCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getChainCode() {
                    return chainCode;
                }

                /**
                 * Sets the value of the chainCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setChainCode(String value) {
                    this.chainCode = value;
                }

                /**
                 * Gets the value of the chainName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getChainName() {
                    return chainName;
                }

                /**
                 * Sets the value of the chainName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setChainName(String value) {
                    this.chainName = value;
                }

                /**
                 * Gets the value of the hotelCityCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getHotelCityCode() {
                    return hotelCityCode;
                }

                /**
                 * Sets the value of the hotelCityCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setHotelCityCode(String value) {
                    this.hotelCityCode = value;
                }

                /**
                 * Gets the value of the hotelCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getHotelCode() {
                    return hotelCode;
                }

                /**
                 * Sets the value of the hotelCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setHotelCode(String value) {
                    this.hotelCode = value;
                }

                /**
                 * Gets the value of the hotelCodeContext property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getHotelCodeContext() {
                    return hotelCodeContext;
                }

                /**
                 * Sets the value of the hotelCodeContext property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setHotelCodeContext(String value) {
                    this.hotelCodeContext = value;
                }

                /**
                 * Gets the value of the hotelName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getHotelName() {
                    return hotelName;
                }

                /**
                 * Sets the value of the hotelName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setHotelName(String value) {
                    this.hotelName = value;
                }

                /**
                 * Gets the value of the areaID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAreaID() {
                    return areaID;
                }

                /**
                 * Sets the value of the areaID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAreaID(String value) {
                    this.areaID = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}AvailStatusMessageType">
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
                public static class AvailStatusMessage
                    extends AvailStatusMessageType
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
             *         &lt;element name="HotelDescriptiveContent" maxOccurs="unbounded">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}HotelDescriptiveContentType">
             *                 &lt;sequence>
             *                 &lt;/sequence>
             *                 &lt;attribute name="BrandCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="BrandName" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="ChainCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="ChainName" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="HotelCityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="HotelCodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="AreaID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *               &lt;/extension>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *       &lt;attribute name="BrandCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="BrandName" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="ChainCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="ChainName" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="HotelCityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="HotelCodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="AreaID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "hotelDescriptiveContent"
            })
            public static class HotelDescriptiveContents {

                @XmlElement(name = "HotelDescriptiveContent", required = true)
                protected List<OTANotifReportRQ.NotifDetails.HotelNotifReport.HotelDescriptiveContents.HotelDescriptiveContent> hotelDescriptiveContent;
                @XmlAttribute(name = "BrandCode")
                protected String brandCode;
                @XmlAttribute(name = "BrandName")
                protected String brandName;
                @XmlAttribute(name = "ChainCode")
                protected String chainCode;
                @XmlAttribute(name = "ChainName")
                protected String chainName;
                @XmlAttribute(name = "HotelCityCode")
                protected String hotelCityCode;
                @XmlAttribute(name = "HotelCode")
                protected String hotelCode;
                @XmlAttribute(name = "HotelCodeContext")
                protected String hotelCodeContext;
                @XmlAttribute(name = "HotelName")
                protected String hotelName;
                @XmlAttribute(name = "AreaID")
                protected String areaID;

                /**
                 * Gets the value of the hotelDescriptiveContent property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the hotelDescriptiveContent property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getHotelDescriptiveContent().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link OTANotifReportRQ.NotifDetails.HotelNotifReport.HotelDescriptiveContents.HotelDescriptiveContent }
                 * 
                 * 
                 */
                public List<OTANotifReportRQ.NotifDetails.HotelNotifReport.HotelDescriptiveContents.HotelDescriptiveContent> getHotelDescriptiveContent() {
                    if (hotelDescriptiveContent == null) {
                        hotelDescriptiveContent = new ArrayList<OTANotifReportRQ.NotifDetails.HotelNotifReport.HotelDescriptiveContents.HotelDescriptiveContent>();
                    }
                    return this.hotelDescriptiveContent;
                }

                /**
                 * Gets the value of the brandCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getBrandCode() {
                    return brandCode;
                }

                /**
                 * Sets the value of the brandCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setBrandCode(String value) {
                    this.brandCode = value;
                }

                /**
                 * Gets the value of the brandName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getBrandName() {
                    return brandName;
                }

                /**
                 * Sets the value of the brandName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setBrandName(String value) {
                    this.brandName = value;
                }

                /**
                 * Gets the value of the chainCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getChainCode() {
                    return chainCode;
                }

                /**
                 * Sets the value of the chainCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setChainCode(String value) {
                    this.chainCode = value;
                }

                /**
                 * Gets the value of the chainName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getChainName() {
                    return chainName;
                }

                /**
                 * Sets the value of the chainName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setChainName(String value) {
                    this.chainName = value;
                }

                /**
                 * Gets the value of the hotelCityCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getHotelCityCode() {
                    return hotelCityCode;
                }

                /**
                 * Sets the value of the hotelCityCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setHotelCityCode(String value) {
                    this.hotelCityCode = value;
                }

                /**
                 * Gets the value of the hotelCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getHotelCode() {
                    return hotelCode;
                }

                /**
                 * Sets the value of the hotelCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setHotelCode(String value) {
                    this.hotelCode = value;
                }

                /**
                 * Gets the value of the hotelCodeContext property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getHotelCodeContext() {
                    return hotelCodeContext;
                }

                /**
                 * Sets the value of the hotelCodeContext property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setHotelCodeContext(String value) {
                    this.hotelCodeContext = value;
                }

                /**
                 * Gets the value of the hotelName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getHotelName() {
                    return hotelName;
                }

                /**
                 * Sets the value of the hotelName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setHotelName(String value) {
                    this.hotelName = value;
                }

                /**
                 * Gets the value of the areaID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAreaID() {
                    return areaID;
                }

                /**
                 * Sets the value of the areaID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAreaID(String value) {
                    this.areaID = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}HotelDescriptiveContentType">
                 *       &lt;sequence>
                 *       &lt;/sequence>
                 *       &lt;attribute name="BrandCode" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="BrandName" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="ChainCode" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="ChainName" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="HotelCityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="HotelCodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="AreaID" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *     &lt;/extension>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class HotelDescriptiveContent
                    extends HotelDescriptiveContentType
                {

                    @XmlAttribute(name = "BrandCode")
                    protected String brandCode;
                    @XmlAttribute(name = "BrandName")
                    protected String brandName;
                    @XmlAttribute(name = "ChainCode")
                    protected String chainCode;
                    @XmlAttribute(name = "ChainName")
                    protected String chainName;
                    @XmlAttribute(name = "HotelCityCode")
                    protected String hotelCityCode;
                    @XmlAttribute(name = "HotelCode")
                    protected String hotelCode;
                    @XmlAttribute(name = "HotelCodeContext")
                    protected String hotelCodeContext;
                    @XmlAttribute(name = "HotelName")
                    protected String hotelName;
                    @XmlAttribute(name = "AreaID")
                    protected String areaID;

                    /**
                     * Gets the value of the brandCode property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getBrandCode() {
                        return brandCode;
                    }

                    /**
                     * Sets the value of the brandCode property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setBrandCode(String value) {
                        this.brandCode = value;
                    }

                    /**
                     * Gets the value of the brandName property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getBrandName() {
                        return brandName;
                    }

                    /**
                     * Sets the value of the brandName property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setBrandName(String value) {
                        this.brandName = value;
                    }

                    /**
                     * Gets the value of the chainCode property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getChainCode() {
                        return chainCode;
                    }

                    /**
                     * Sets the value of the chainCode property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setChainCode(String value) {
                        this.chainCode = value;
                    }

                    /**
                     * Gets the value of the chainName property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getChainName() {
                        return chainName;
                    }

                    /**
                     * Sets the value of the chainName property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setChainName(String value) {
                        this.chainName = value;
                    }

                    /**
                     * Gets the value of the hotelCityCode property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getHotelCityCode() {
                        return hotelCityCode;
                    }

                    /**
                     * Sets the value of the hotelCityCode property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setHotelCityCode(String value) {
                        this.hotelCityCode = value;
                    }

                    /**
                     * Gets the value of the hotelCode property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getHotelCode() {
                        return hotelCode;
                    }

                    /**
                     * Sets the value of the hotelCode property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setHotelCode(String value) {
                        this.hotelCode = value;
                    }

                    /**
                     * Gets the value of the hotelCodeContext property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getHotelCodeContext() {
                        return hotelCodeContext;
                    }

                    /**
                     * Sets the value of the hotelCodeContext property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setHotelCodeContext(String value) {
                        this.hotelCodeContext = value;
                    }

                    /**
                     * Gets the value of the hotelName property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getHotelName() {
                        return hotelName;
                    }

                    /**
                     * Sets the value of the hotelName property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setHotelName(String value) {
                        this.hotelName = value;
                    }

                    /**
                     * Gets the value of the areaID property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getAreaID() {
                        return areaID;
                    }

                    /**
                     * Sets the value of the areaID property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setAreaID(String value) {
                        this.areaID = value;
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
             *         &lt;element name="RateAmountMessage" type="{http://www.opentravel.org/OTA/2003/05}RateAmountMessageType" maxOccurs="unbounded"/>
             *       &lt;/sequence>
             *       &lt;attribute name="BrandCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="BrandName" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="ChainCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="ChainName" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="HotelCityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="HotelCodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="AreaID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "rateAmountMessage"
            })
            public static class RateAmountMessages {

                @XmlElement(name = "RateAmountMessage", required = true)
                protected List<RateAmountMessageType> rateAmountMessage;
                @XmlAttribute(name = "BrandCode")
                protected String brandCode;
                @XmlAttribute(name = "BrandName")
                protected String brandName;
                @XmlAttribute(name = "ChainCode")
                protected String chainCode;
                @XmlAttribute(name = "ChainName")
                protected String chainName;
                @XmlAttribute(name = "HotelCityCode")
                protected String hotelCityCode;
                @XmlAttribute(name = "HotelCode")
                protected String hotelCode;
                @XmlAttribute(name = "HotelCodeContext")
                protected String hotelCodeContext;
                @XmlAttribute(name = "HotelName")
                protected String hotelName;
                @XmlAttribute(name = "AreaID")
                protected String areaID;

                /**
                 * Gets the value of the rateAmountMessage property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the rateAmountMessage property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getRateAmountMessage().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link RateAmountMessageType }
                 * 
                 * 
                 */
                public List<RateAmountMessageType> getRateAmountMessage() {
                    if (rateAmountMessage == null) {
                        rateAmountMessage = new ArrayList<RateAmountMessageType>();
                    }
                    return this.rateAmountMessage;
                }

                /**
                 * Gets the value of the brandCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getBrandCode() {
                    return brandCode;
                }

                /**
                 * Sets the value of the brandCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setBrandCode(String value) {
                    this.brandCode = value;
                }

                /**
                 * Gets the value of the brandName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getBrandName() {
                    return brandName;
                }

                /**
                 * Sets the value of the brandName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setBrandName(String value) {
                    this.brandName = value;
                }

                /**
                 * Gets the value of the chainCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getChainCode() {
                    return chainCode;
                }

                /**
                 * Sets the value of the chainCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setChainCode(String value) {
                    this.chainCode = value;
                }

                /**
                 * Gets the value of the chainName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getChainName() {
                    return chainName;
                }

                /**
                 * Sets the value of the chainName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setChainName(String value) {
                    this.chainName = value;
                }

                /**
                 * Gets the value of the hotelCityCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getHotelCityCode() {
                    return hotelCityCode;
                }

                /**
                 * Sets the value of the hotelCityCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setHotelCityCode(String value) {
                    this.hotelCityCode = value;
                }

                /**
                 * Gets the value of the hotelCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getHotelCode() {
                    return hotelCode;
                }

                /**
                 * Sets the value of the hotelCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setHotelCode(String value) {
                    this.hotelCode = value;
                }

                /**
                 * Gets the value of the hotelCodeContext property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getHotelCodeContext() {
                    return hotelCodeContext;
                }

                /**
                 * Sets the value of the hotelCodeContext property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setHotelCodeContext(String value) {
                    this.hotelCodeContext = value;
                }

                /**
                 * Gets the value of the hotelName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getHotelName() {
                    return hotelName;
                }

                /**
                 * Sets the value of the hotelName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setHotelName(String value) {
                    this.hotelName = value;
                }

                /**
                 * Gets the value of the areaID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAreaID() {
                    return areaID;
                }

                /**
                 * Sets the value of the areaID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAreaID(String value) {
                    this.areaID = value;
                }

            }

        }

    }

}
