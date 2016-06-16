
package com.desia.artifacts.booking;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FacilityInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FacilityInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MeetingRooms" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}MeetingRoomsType">
 *                 &lt;sequence>
 *                   &lt;element name="Codes" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Code" type="{http://www.opentravel.org/OTA/2003/05}MeetingRoomCodeType" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="GuestRooms" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="GuestRoom" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="TypeRoom" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="Count" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                                     &lt;attribute name="MaxCribs" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                                     &lt;attribute name="MaxRollaways" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                                     &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="Size" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                                     &lt;attribute name="StandardNumBeds" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                                     &lt;attribute name="StandardOccupancy" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                                     &lt;attribute name="TypeImplied" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="BedTypeCode">
 *                                       &lt;simpleType>
 *                                         &lt;list itemType="{http://www.w3.org/2001/XMLSchema}string" />
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                     &lt;attribute name="Composite" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                     &lt;attribute name="Configuration" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="Floor" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                                     &lt;attribute name="InvBlockCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="NonSmoking" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                     &lt;attribute name="Quantity" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                                     &lt;attribute name="RoomArchitectureCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="RoomCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="RoomClassificationCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="RoomGender" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="RoomID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="RoomLocationCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="RoomType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="RoomTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="RoomViewCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="SharedRoomInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                     &lt;attribute name="SizeMeasurement" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="PromotionCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="PromotionVendorCode">
 *                                       &lt;simpleType>
 *                                         &lt;list itemType="{http://www.w3.org/2001/XMLSchema}string" />
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="Amenities" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Amenity" maxOccurs="unbounded">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="OperationSchedules" type="{http://www.opentravel.org/OTA/2003/05}OperationSchedulesPlusChargeType" minOccurs="0"/>
 *                                                 &lt;element name="ContactInfo" type="{http://www.opentravel.org/OTA/2003/05}ContactInfoRootType" maxOccurs="unbounded" minOccurs="0"/>
 *                                                 &lt;element name="MultimediaDescriptions" type="{http://www.opentravel.org/OTA/2003/05}MultimediaDescriptionsType" minOccurs="0"/>
 *                                                 &lt;element name="DescriptiveText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                               &lt;/sequence>
 *                                               &lt;attribute name="ExistsCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="IncludedInRateIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                               &lt;attribute name="RoomAmenityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="CodeDetail" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="Removal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                               &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="Quantity" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="Features" type="{http://www.opentravel.org/OTA/2003/05}FeaturesType" minOccurs="0"/>
 *                             &lt;element name="MultimediaDescriptions" type="{http://www.opentravel.org/OTA/2003/05}MultimediaDescriptionsType" minOccurs="0"/>
 *                             &lt;element name="DescriptiveText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="Composite" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                           &lt;attribute name="MaxAdultOccupancy" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                           &lt;attribute name="MaxChildOccupancy" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                           &lt;attribute name="MaxOccupancy" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                           &lt;attribute name="NonsmokingQuantity" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                           &lt;attribute name="Quality" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="RoomTypeName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="Sort" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                           &lt;attribute name="URI" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="Quantity" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                           &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="CodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="MaxOccupancy" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Restaurants" type="{http://www.opentravel.org/OTA/2003/05}RestaurantsType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="LastUpdated" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FacilityInfoType", propOrder = {
    "meetingRooms",
    "guestRooms",
    "restaurants"
})
public class FacilityInfoType {

    @XmlElement(name = "MeetingRooms")
    protected FacilityInfoType.MeetingRooms meetingRooms;
    @XmlElement(name = "GuestRooms")
    protected FacilityInfoType.GuestRooms guestRooms;
    @XmlElement(name = "Restaurants")
    protected RestaurantsType restaurants;
    @XmlAttribute(name = "LastUpdated")
    @XmlSchemaType(name = "anySimpleType")
    protected String lastUpdated;

    /**
     * Gets the value of the meetingRooms property.
     * 
     * @return
     *     possible object is
     *     {@link FacilityInfoType.MeetingRooms }
     *     
     */
    public FacilityInfoType.MeetingRooms getMeetingRooms() {
        return meetingRooms;
    }

    /**
     * Sets the value of the meetingRooms property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilityInfoType.MeetingRooms }
     *     
     */
    public void setMeetingRooms(FacilityInfoType.MeetingRooms value) {
        this.meetingRooms = value;
    }

    /**
     * Gets the value of the guestRooms property.
     * 
     * @return
     *     possible object is
     *     {@link FacilityInfoType.GuestRooms }
     *     
     */
    public FacilityInfoType.GuestRooms getGuestRooms() {
        return guestRooms;
    }

    /**
     * Sets the value of the guestRooms property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilityInfoType.GuestRooms }
     *     
     */
    public void setGuestRooms(FacilityInfoType.GuestRooms value) {
        this.guestRooms = value;
    }

    /**
     * Gets the value of the restaurants property.
     * 
     * @return
     *     possible object is
     *     {@link RestaurantsType }
     *     
     */
    public RestaurantsType getRestaurants() {
        return restaurants;
    }

    /**
     * Sets the value of the restaurants property.
     * 
     * @param value
     *     allowed object is
     *     {@link RestaurantsType }
     *     
     */
    public void setRestaurants(RestaurantsType value) {
        this.restaurants = value;
    }

    /**
     * Gets the value of the lastUpdated property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     * Sets the value of the lastUpdated property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastUpdated(String value) {
        this.lastUpdated = value;
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
     *         &lt;element name="GuestRoom" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="TypeRoom" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                           &lt;/sequence>
     *                           &lt;attribute name="Count" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                           &lt;attribute name="MaxCribs" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                           &lt;attribute name="MaxRollaways" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                           &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="Size" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                           &lt;attribute name="StandardNumBeds" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                           &lt;attribute name="StandardOccupancy" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                           &lt;attribute name="TypeImplied" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="BedTypeCode">
     *                             &lt;simpleType>
     *                               &lt;list itemType="{http://www.w3.org/2001/XMLSchema}string" />
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                           &lt;attribute name="Composite" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                           &lt;attribute name="Configuration" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="Floor" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                           &lt;attribute name="InvBlockCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="NonSmoking" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                           &lt;attribute name="Quantity" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                           &lt;attribute name="RoomArchitectureCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="RoomCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="RoomClassificationCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="RoomGender" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="RoomID" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="RoomLocationCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="RoomType" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="RoomTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="RoomViewCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="SharedRoomInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                           &lt;attribute name="SizeMeasurement" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="PromotionCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="PromotionVendorCode">
     *                             &lt;simpleType>
     *                               &lt;list itemType="{http://www.w3.org/2001/XMLSchema}string" />
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="Amenities" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Amenity" maxOccurs="unbounded">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="OperationSchedules" type="{http://www.opentravel.org/OTA/2003/05}OperationSchedulesPlusChargeType" minOccurs="0"/>
     *                                       &lt;element name="ContactInfo" type="{http://www.opentravel.org/OTA/2003/05}ContactInfoRootType" maxOccurs="unbounded" minOccurs="0"/>
     *                                       &lt;element name="MultimediaDescriptions" type="{http://www.opentravel.org/OTA/2003/05}MultimediaDescriptionsType" minOccurs="0"/>
     *                                       &lt;element name="DescriptiveText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                     &lt;/sequence>
     *                                     &lt;attribute name="ExistsCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="IncludedInRateIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                                     &lt;attribute name="RoomAmenityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="CodeDetail" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="Removal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                                     &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="Quantity" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="Features" type="{http://www.opentravel.org/OTA/2003/05}FeaturesType" minOccurs="0"/>
     *                   &lt;element name="MultimediaDescriptions" type="{http://www.opentravel.org/OTA/2003/05}MultimediaDescriptionsType" minOccurs="0"/>
     *                   &lt;element name="DescriptiveText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="Composite" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                 &lt;attribute name="MaxAdultOccupancy" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                 &lt;attribute name="MaxChildOccupancy" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                 &lt;attribute name="MaxOccupancy" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                 &lt;attribute name="NonsmokingQuantity" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                 &lt;attribute name="Quality" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="RoomTypeName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="Sort" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                 &lt;attribute name="URI" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="Quantity" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                 &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="CodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="MaxOccupancy" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "guestRoom"
    })
    public static class GuestRooms {

        @XmlElement(name = "GuestRoom", required = true)
        protected List<FacilityInfoType.GuestRooms.GuestRoom> guestRoom;
        @XmlAttribute(name = "MaxOccupancy")
        protected BigInteger maxOccupancy;

        /**
         * Gets the value of the guestRoom property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the guestRoom property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getGuestRoom().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FacilityInfoType.GuestRooms.GuestRoom }
         * 
         * 
         */
        public List<FacilityInfoType.GuestRooms.GuestRoom> getGuestRoom() {
            if (guestRoom == null) {
                guestRoom = new ArrayList<FacilityInfoType.GuestRooms.GuestRoom>();
            }
            return this.guestRoom;
        }

        /**
         * Gets the value of the maxOccupancy property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getMaxOccupancy() {
            return maxOccupancy;
        }

        /**
         * Sets the value of the maxOccupancy property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setMaxOccupancy(BigInteger value) {
            this.maxOccupancy = value;
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
         *         &lt;element name="TypeRoom" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                 &lt;/sequence>
         *                 &lt;attribute name="Count" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *                 &lt;attribute name="MaxCribs" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *                 &lt;attribute name="MaxRollaways" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *                 &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="Size" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *                 &lt;attribute name="StandardNumBeds" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *                 &lt;attribute name="StandardOccupancy" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *                 &lt;attribute name="TypeImplied" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="BedTypeCode">
         *                   &lt;simpleType>
         *                     &lt;list itemType="{http://www.w3.org/2001/XMLSchema}string" />
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *                 &lt;attribute name="Composite" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *                 &lt;attribute name="Configuration" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="Floor" type="{http://www.w3.org/2001/XMLSchema}int" />
         *                 &lt;attribute name="InvBlockCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="NonSmoking" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *                 &lt;attribute name="Quantity" type="{http://www.w3.org/2001/XMLSchema}int" />
         *                 &lt;attribute name="RoomArchitectureCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="RoomCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="RoomClassificationCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="RoomGender" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="RoomID" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="RoomLocationCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="RoomType" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="RoomTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="RoomViewCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="SharedRoomInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *                 &lt;attribute name="SizeMeasurement" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="PromotionCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="PromotionVendorCode">
         *                   &lt;simpleType>
         *                     &lt;list itemType="{http://www.w3.org/2001/XMLSchema}string" />
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="Amenities" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Amenity" maxOccurs="unbounded">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="OperationSchedules" type="{http://www.opentravel.org/OTA/2003/05}OperationSchedulesPlusChargeType" minOccurs="0"/>
         *                             &lt;element name="ContactInfo" type="{http://www.opentravel.org/OTA/2003/05}ContactInfoRootType" maxOccurs="unbounded" minOccurs="0"/>
         *                             &lt;element name="MultimediaDescriptions" type="{http://www.opentravel.org/OTA/2003/05}MultimediaDescriptionsType" minOccurs="0"/>
         *                             &lt;element name="DescriptiveText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                           &lt;/sequence>
         *                           &lt;attribute name="ExistsCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="IncludedInRateIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *                           &lt;attribute name="RoomAmenityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="CodeDetail" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="Removal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *                           &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="Quantity" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="Features" type="{http://www.opentravel.org/OTA/2003/05}FeaturesType" minOccurs="0"/>
         *         &lt;element name="MultimediaDescriptions" type="{http://www.opentravel.org/OTA/2003/05}MultimediaDescriptionsType" minOccurs="0"/>
         *         &lt;element name="DescriptiveText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/sequence>
         *       &lt;attribute name="Composite" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *       &lt;attribute name="MaxAdultOccupancy" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *       &lt;attribute name="MaxChildOccupancy" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *       &lt;attribute name="MaxOccupancy" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *       &lt;attribute name="NonsmokingQuantity" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *       &lt;attribute name="Quality" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="RoomTypeName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="Sort" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *       &lt;attribute name="URI" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="Quantity" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="CodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "typeRoom",
            "amenities",
            "features",
            "multimediaDescriptions",
            "descriptiveText"
        })
        public static class GuestRoom {

            @XmlElement(name = "TypeRoom")
            protected List<FacilityInfoType.GuestRooms.GuestRoom.TypeRoom> typeRoom;
            @XmlElement(name = "Amenities")
            protected FacilityInfoType.GuestRooms.GuestRoom.Amenities amenities;
            @XmlElement(name = "Features")
            protected FeaturesType features;
            @XmlElement(name = "MultimediaDescriptions")
            protected MultimediaDescriptionsType multimediaDescriptions;
            @XmlElement(name = "DescriptiveText")
            protected String descriptiveText;
            @XmlAttribute(name = "Composite")
            protected Boolean composite;
            @XmlAttribute(name = "MaxAdultOccupancy")
            protected BigInteger maxAdultOccupancy;
            @XmlAttribute(name = "MaxChildOccupancy")
            protected BigInteger maxChildOccupancy;
            @XmlAttribute(name = "MaxOccupancy")
            protected BigInteger maxOccupancy;
            @XmlAttribute(name = "NonsmokingQuantity")
            protected BigInteger nonsmokingQuantity;
            @XmlAttribute(name = "Quality")
            protected String quality;
            @XmlAttribute(name = "RoomTypeName")
            protected String roomTypeName;
            @XmlAttribute(name = "Sort")
            protected BigInteger sort;
            @XmlAttribute(name = "URI")
            protected String uri;
            @XmlAttribute(name = "Quantity")
            protected BigInteger quantity;
            @XmlAttribute(name = "Code")
            protected String code;
            @XmlAttribute(name = "CodeContext")
            protected String codeContext;
            @XmlAttribute(name = "ID")
            protected String id;

            /**
             * Gets the value of the typeRoom property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the typeRoom property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTypeRoom().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link FacilityInfoType.GuestRooms.GuestRoom.TypeRoom }
             * 
             * 
             */
            public List<FacilityInfoType.GuestRooms.GuestRoom.TypeRoom> getTypeRoom() {
                if (typeRoom == null) {
                    typeRoom = new ArrayList<FacilityInfoType.GuestRooms.GuestRoom.TypeRoom>();
                }
                return this.typeRoom;
            }

            /**
             * Gets the value of the amenities property.
             * 
             * @return
             *     possible object is
             *     {@link FacilityInfoType.GuestRooms.GuestRoom.Amenities }
             *     
             */
            public FacilityInfoType.GuestRooms.GuestRoom.Amenities getAmenities() {
                return amenities;
            }

            /**
             * Sets the value of the amenities property.
             * 
             * @param value
             *     allowed object is
             *     {@link FacilityInfoType.GuestRooms.GuestRoom.Amenities }
             *     
             */
            public void setAmenities(FacilityInfoType.GuestRooms.GuestRoom.Amenities value) {
                this.amenities = value;
            }

            /**
             * Gets the value of the features property.
             * 
             * @return
             *     possible object is
             *     {@link FeaturesType }
             *     
             */
            public FeaturesType getFeatures() {
                return features;
            }

            /**
             * Sets the value of the features property.
             * 
             * @param value
             *     allowed object is
             *     {@link FeaturesType }
             *     
             */
            public void setFeatures(FeaturesType value) {
                this.features = value;
            }

            /**
             * Gets the value of the multimediaDescriptions property.
             * 
             * @return
             *     possible object is
             *     {@link MultimediaDescriptionsType }
             *     
             */
            public MultimediaDescriptionsType getMultimediaDescriptions() {
                return multimediaDescriptions;
            }

            /**
             * Sets the value of the multimediaDescriptions property.
             * 
             * @param value
             *     allowed object is
             *     {@link MultimediaDescriptionsType }
             *     
             */
            public void setMultimediaDescriptions(MultimediaDescriptionsType value) {
                this.multimediaDescriptions = value;
            }

            /**
             * Gets the value of the descriptiveText property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDescriptiveText() {
                return descriptiveText;
            }

            /**
             * Sets the value of the descriptiveText property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDescriptiveText(String value) {
                this.descriptiveText = value;
            }

            /**
             * Gets the value of the composite property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isComposite() {
                return composite;
            }

            /**
             * Sets the value of the composite property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setComposite(Boolean value) {
                this.composite = value;
            }

            /**
             * Gets the value of the maxAdultOccupancy property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMaxAdultOccupancy() {
                return maxAdultOccupancy;
            }

            /**
             * Sets the value of the maxAdultOccupancy property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMaxAdultOccupancy(BigInteger value) {
                this.maxAdultOccupancy = value;
            }

            /**
             * Gets the value of the maxChildOccupancy property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMaxChildOccupancy() {
                return maxChildOccupancy;
            }

            /**
             * Sets the value of the maxChildOccupancy property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMaxChildOccupancy(BigInteger value) {
                this.maxChildOccupancy = value;
            }

            /**
             * Gets the value of the maxOccupancy property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMaxOccupancy() {
                return maxOccupancy;
            }

            /**
             * Sets the value of the maxOccupancy property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMaxOccupancy(BigInteger value) {
                this.maxOccupancy = value;
            }

            /**
             * Gets the value of the nonsmokingQuantity property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getNonsmokingQuantity() {
                return nonsmokingQuantity;
            }

            /**
             * Sets the value of the nonsmokingQuantity property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setNonsmokingQuantity(BigInteger value) {
                this.nonsmokingQuantity = value;
            }

            /**
             * Gets the value of the quality property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getQuality() {
                return quality;
            }

            /**
             * Sets the value of the quality property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setQuality(String value) {
                this.quality = value;
            }

            /**
             * Gets the value of the roomTypeName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRoomTypeName() {
                return roomTypeName;
            }

            /**
             * Sets the value of the roomTypeName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRoomTypeName(String value) {
                this.roomTypeName = value;
            }

            /**
             * Gets the value of the sort property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getSort() {
                return sort;
            }

            /**
             * Sets the value of the sort property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setSort(BigInteger value) {
                this.sort = value;
            }

            /**
             * Gets the value of the uri property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getURI() {
                return uri;
            }

            /**
             * Sets the value of the uri property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setURI(String value) {
                this.uri = value;
            }

            /**
             * Gets the value of the quantity property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getQuantity() {
                return quantity;
            }

            /**
             * Sets the value of the quantity property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setQuantity(BigInteger value) {
                this.quantity = value;
            }

            /**
             * Gets the value of the code property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCode() {
                return code;
            }

            /**
             * Sets the value of the code property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCode(String value) {
                this.code = value;
            }

            /**
             * Gets the value of the codeContext property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCodeContext() {
                return codeContext;
            }

            /**
             * Sets the value of the codeContext property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCodeContext(String value) {
                this.codeContext = value;
            }

            /**
             * Gets the value of the id property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getID() {
                return id;
            }

            /**
             * Sets the value of the id property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setID(String value) {
                this.id = value;
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
             *         &lt;element name="Amenity" maxOccurs="unbounded">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="OperationSchedules" type="{http://www.opentravel.org/OTA/2003/05}OperationSchedulesPlusChargeType" minOccurs="0"/>
             *                   &lt;element name="ContactInfo" type="{http://www.opentravel.org/OTA/2003/05}ContactInfoRootType" maxOccurs="unbounded" minOccurs="0"/>
             *                   &lt;element name="MultimediaDescriptions" type="{http://www.opentravel.org/OTA/2003/05}MultimediaDescriptionsType" minOccurs="0"/>
             *                   &lt;element name="DescriptiveText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                 &lt;/sequence>
             *                 &lt;attribute name="ExistsCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="IncludedInRateIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" />
             *                 &lt;attribute name="RoomAmenityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="CodeDetail" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="Removal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
             *                 &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="Quantity" type="{http://www.w3.org/2001/XMLSchema}integer" />
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
                "amenity"
            })
            public static class Amenities {

                @XmlElement(name = "Amenity", required = true)
                protected List<FacilityInfoType.GuestRooms.GuestRoom.Amenities.Amenity> amenity;

                /**
                 * Gets the value of the amenity property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the amenity property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getAmenity().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link FacilityInfoType.GuestRooms.GuestRoom.Amenities.Amenity }
                 * 
                 * 
                 */
                public List<FacilityInfoType.GuestRooms.GuestRoom.Amenities.Amenity> getAmenity() {
                    if (amenity == null) {
                        amenity = new ArrayList<FacilityInfoType.GuestRooms.GuestRoom.Amenities.Amenity>();
                    }
                    return this.amenity;
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
                 *         &lt;element name="OperationSchedules" type="{http://www.opentravel.org/OTA/2003/05}OperationSchedulesPlusChargeType" minOccurs="0"/>
                 *         &lt;element name="ContactInfo" type="{http://www.opentravel.org/OTA/2003/05}ContactInfoRootType" maxOccurs="unbounded" minOccurs="0"/>
                 *         &lt;element name="MultimediaDescriptions" type="{http://www.opentravel.org/OTA/2003/05}MultimediaDescriptionsType" minOccurs="0"/>
                 *         &lt;element name="DescriptiveText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *       &lt;/sequence>
                 *       &lt;attribute name="ExistsCode" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="IncludedInRateIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" />
                 *       &lt;attribute name="RoomAmenityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="CodeDetail" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="Removal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
                 *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="Quantity" type="{http://www.w3.org/2001/XMLSchema}integer" />
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "operationSchedules",
                    "contactInfo",
                    "multimediaDescriptions",
                    "descriptiveText"
                })
                public static class Amenity {

                    @XmlElement(name = "OperationSchedules")
                    protected OperationSchedulesPlusChargeType operationSchedules;
                    @XmlElement(name = "ContactInfo")
                    protected List<ContactInfoRootType> contactInfo;
                    @XmlElement(name = "MultimediaDescriptions")
                    protected MultimediaDescriptionsType multimediaDescriptions;
                    @XmlElement(name = "DescriptiveText")
                    protected String descriptiveText;
                    @XmlAttribute(name = "ExistsCode")
                    protected String existsCode;
                    @XmlAttribute(name = "IncludedInRateIndicator")
                    protected Boolean includedInRateIndicator;
                    @XmlAttribute(name = "RoomAmenityCode")
                    protected String roomAmenityCode;
                    @XmlAttribute(name = "CodeDetail")
                    protected String codeDetail;
                    @XmlAttribute(name = "Removal")
                    protected Boolean removal;
                    @XmlAttribute(name = "ID")
                    protected String id;
                    @XmlAttribute(name = "Quantity")
                    protected BigInteger quantity;

                    /**
                     * Gets the value of the operationSchedules property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link OperationSchedulesPlusChargeType }
                     *     
                     */
                    public OperationSchedulesPlusChargeType getOperationSchedules() {
                        return operationSchedules;
                    }

                    /**
                     * Sets the value of the operationSchedules property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link OperationSchedulesPlusChargeType }
                     *     
                     */
                    public void setOperationSchedules(OperationSchedulesPlusChargeType value) {
                        this.operationSchedules = value;
                    }

                    /**
                     * Gets the value of the contactInfo property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the contactInfo property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getContactInfo().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link ContactInfoRootType }
                     * 
                     * 
                     */
                    public List<ContactInfoRootType> getContactInfo() {
                        if (contactInfo == null) {
                            contactInfo = new ArrayList<ContactInfoRootType>();
                        }
                        return this.contactInfo;
                    }

                    /**
                     * Gets the value of the multimediaDescriptions property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link MultimediaDescriptionsType }
                     *     
                     */
                    public MultimediaDescriptionsType getMultimediaDescriptions() {
                        return multimediaDescriptions;
                    }

                    /**
                     * Sets the value of the multimediaDescriptions property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link MultimediaDescriptionsType }
                     *     
                     */
                    public void setMultimediaDescriptions(MultimediaDescriptionsType value) {
                        this.multimediaDescriptions = value;
                    }

                    /**
                     * Gets the value of the descriptiveText property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getDescriptiveText() {
                        return descriptiveText;
                    }

                    /**
                     * Sets the value of the descriptiveText property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setDescriptiveText(String value) {
                        this.descriptiveText = value;
                    }

                    /**
                     * Gets the value of the existsCode property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getExistsCode() {
                        return existsCode;
                    }

                    /**
                     * Sets the value of the existsCode property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setExistsCode(String value) {
                        this.existsCode = value;
                    }

                    /**
                     * Gets the value of the includedInRateIndicator property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Boolean }
                     *     
                     */
                    public Boolean isIncludedInRateIndicator() {
                        return includedInRateIndicator;
                    }

                    /**
                     * Sets the value of the includedInRateIndicator property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Boolean }
                     *     
                     */
                    public void setIncludedInRateIndicator(Boolean value) {
                        this.includedInRateIndicator = value;
                    }

                    /**
                     * Gets the value of the roomAmenityCode property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getRoomAmenityCode() {
                        return roomAmenityCode;
                    }

                    /**
                     * Sets the value of the roomAmenityCode property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setRoomAmenityCode(String value) {
                        this.roomAmenityCode = value;
                    }

                    /**
                     * Gets the value of the codeDetail property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getCodeDetail() {
                        return codeDetail;
                    }

                    /**
                     * Sets the value of the codeDetail property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setCodeDetail(String value) {
                        this.codeDetail = value;
                    }

                    /**
                     * Gets the value of the removal property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Boolean }
                     *     
                     */
                    public Boolean isRemoval() {
                        return removal;
                    }

                    /**
                     * Sets the value of the removal property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Boolean }
                     *     
                     */
                    public void setRemoval(Boolean value) {
                        this.removal = value;
                    }

                    /**
                     * Gets the value of the id property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getID() {
                        return id;
                    }

                    /**
                     * Sets the value of the id property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setID(String value) {
                        this.id = value;
                    }

                    /**
                     * Gets the value of the quantity property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getQuantity() {
                        return quantity;
                    }

                    /**
                     * Sets the value of the quantity property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setQuantity(BigInteger value) {
                        this.quantity = value;
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
             *       &lt;attribute name="Count" type="{http://www.w3.org/2001/XMLSchema}integer" />
             *       &lt;attribute name="MaxCribs" type="{http://www.w3.org/2001/XMLSchema}integer" />
             *       &lt;attribute name="MaxRollaways" type="{http://www.w3.org/2001/XMLSchema}integer" />
             *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="Size" type="{http://www.w3.org/2001/XMLSchema}integer" />
             *       &lt;attribute name="StandardNumBeds" type="{http://www.w3.org/2001/XMLSchema}integer" />
             *       &lt;attribute name="StandardOccupancy" type="{http://www.w3.org/2001/XMLSchema}integer" />
             *       &lt;attribute name="TypeImplied" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="BedTypeCode">
             *         &lt;simpleType>
             *           &lt;list itemType="{http://www.w3.org/2001/XMLSchema}string" />
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *       &lt;attribute name="Composite" type="{http://www.w3.org/2001/XMLSchema}boolean" />
             *       &lt;attribute name="Configuration" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="Floor" type="{http://www.w3.org/2001/XMLSchema}int" />
             *       &lt;attribute name="InvBlockCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="NonSmoking" type="{http://www.w3.org/2001/XMLSchema}boolean" />
             *       &lt;attribute name="Quantity" type="{http://www.w3.org/2001/XMLSchema}int" />
             *       &lt;attribute name="RoomArchitectureCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="RoomCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="RoomClassificationCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="RoomGender" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="RoomID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="RoomLocationCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="RoomType" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="RoomTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="RoomViewCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="SharedRoomInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
             *       &lt;attribute name="SizeMeasurement" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="PromotionCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="PromotionVendorCode">
             *         &lt;simpleType>
             *           &lt;list itemType="{http://www.w3.org/2001/XMLSchema}string" />
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class TypeRoom {

                @XmlAttribute(name = "Count")
                protected BigInteger count;
                @XmlAttribute(name = "MaxCribs")
                protected BigInteger maxCribs;
                @XmlAttribute(name = "MaxRollaways")
                protected BigInteger maxRollaways;
                @XmlAttribute(name = "Name")
                protected String name;
                @XmlAttribute(name = "Size")
                protected BigInteger size;
                @XmlAttribute(name = "StandardNumBeds")
                protected BigInteger standardNumBeds;
                @XmlAttribute(name = "StandardOccupancy")
                protected BigInteger standardOccupancy;
                @XmlAttribute(name = "TypeImplied")
                protected String typeImplied;
                @XmlAttribute(name = "BedTypeCode")
                protected List<String> bedTypeCode;
                @XmlAttribute(name = "Composite")
                protected Boolean composite;
                @XmlAttribute(name = "Configuration")
                protected String configuration;
                @XmlAttribute(name = "Floor")
                protected Integer floor;
                @XmlAttribute(name = "InvBlockCode")
                protected String invBlockCode;
                @XmlAttribute(name = "NonSmoking")
                protected Boolean nonSmoking;
                @XmlAttribute(name = "Quantity")
                protected Integer quantity;
                @XmlAttribute(name = "RoomArchitectureCode")
                protected String roomArchitectureCode;
                @XmlAttribute(name = "RoomCategory")
                protected String roomCategory;
                @XmlAttribute(name = "RoomClassificationCode")
                protected String roomClassificationCode;
                @XmlAttribute(name = "RoomGender")
                protected String roomGender;
                @XmlAttribute(name = "RoomID")
                protected String roomID;
                @XmlAttribute(name = "RoomLocationCode")
                protected String roomLocationCode;
                @XmlAttribute(name = "RoomType")
                protected String roomType;
                @XmlAttribute(name = "RoomTypeCode")
                protected String roomTypeCode;
                @XmlAttribute(name = "RoomViewCode")
                protected String roomViewCode;
                @XmlAttribute(name = "SharedRoomInd")
                protected Boolean sharedRoomInd;
                @XmlAttribute(name = "SizeMeasurement")
                protected String sizeMeasurement;
                @XmlAttribute(name = "PromotionCode")
                protected String promotionCode;
                @XmlAttribute(name = "PromotionVendorCode")
                protected List<String> promotionVendorCode;

                /**
                 * Gets the value of the count property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getCount() {
                    return count;
                }

                /**
                 * Sets the value of the count property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setCount(BigInteger value) {
                    this.count = value;
                }

                /**
                 * Gets the value of the maxCribs property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getMaxCribs() {
                    return maxCribs;
                }

                /**
                 * Sets the value of the maxCribs property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setMaxCribs(BigInteger value) {
                    this.maxCribs = value;
                }

                /**
                 * Gets the value of the maxRollaways property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getMaxRollaways() {
                    return maxRollaways;
                }

                /**
                 * Sets the value of the maxRollaways property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setMaxRollaways(BigInteger value) {
                    this.maxRollaways = value;
                }

                /**
                 * Gets the value of the name property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getName() {
                    return name;
                }

                /**
                 * Sets the value of the name property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setName(String value) {
                    this.name = value;
                }

                /**
                 * Gets the value of the size property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getSize() {
                    return size;
                }

                /**
                 * Sets the value of the size property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setSize(BigInteger value) {
                    this.size = value;
                }

                /**
                 * Gets the value of the standardNumBeds property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getStandardNumBeds() {
                    return standardNumBeds;
                }

                /**
                 * Sets the value of the standardNumBeds property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setStandardNumBeds(BigInteger value) {
                    this.standardNumBeds = value;
                }

                /**
                 * Gets the value of the standardOccupancy property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getStandardOccupancy() {
                    return standardOccupancy;
                }

                /**
                 * Sets the value of the standardOccupancy property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setStandardOccupancy(BigInteger value) {
                    this.standardOccupancy = value;
                }

                /**
                 * Gets the value of the typeImplied property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getTypeImplied() {
                    return typeImplied;
                }

                /**
                 * Sets the value of the typeImplied property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setTypeImplied(String value) {
                    this.typeImplied = value;
                }

                /**
                 * Gets the value of the bedTypeCode property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the bedTypeCode property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getBedTypeCode().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link String }
                 * 
                 * 
                 */
                public List<String> getBedTypeCode() {
                    if (bedTypeCode == null) {
                        bedTypeCode = new ArrayList<String>();
                    }
                    return this.bedTypeCode;
                }

                /**
                 * Gets the value of the composite property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isComposite() {
                    return composite;
                }

                /**
                 * Sets the value of the composite property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setComposite(Boolean value) {
                    this.composite = value;
                }

                /**
                 * Gets the value of the configuration property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getConfiguration() {
                    return configuration;
                }

                /**
                 * Sets the value of the configuration property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setConfiguration(String value) {
                    this.configuration = value;
                }

                /**
                 * Gets the value of the floor property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Integer }
                 *     
                 */
                public Integer getFloor() {
                    return floor;
                }

                /**
                 * Sets the value of the floor property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Integer }
                 *     
                 */
                public void setFloor(Integer value) {
                    this.floor = value;
                }

                /**
                 * Gets the value of the invBlockCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getInvBlockCode() {
                    return invBlockCode;
                }

                /**
                 * Sets the value of the invBlockCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setInvBlockCode(String value) {
                    this.invBlockCode = value;
                }

                /**
                 * Gets the value of the nonSmoking property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isNonSmoking() {
                    return nonSmoking;
                }

                /**
                 * Sets the value of the nonSmoking property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setNonSmoking(Boolean value) {
                    this.nonSmoking = value;
                }

                /**
                 * Gets the value of the quantity property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Integer }
                 *     
                 */
                public Integer getQuantity() {
                    return quantity;
                }

                /**
                 * Sets the value of the quantity property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Integer }
                 *     
                 */
                public void setQuantity(Integer value) {
                    this.quantity = value;
                }

                /**
                 * Gets the value of the roomArchitectureCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getRoomArchitectureCode() {
                    return roomArchitectureCode;
                }

                /**
                 * Sets the value of the roomArchitectureCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setRoomArchitectureCode(String value) {
                    this.roomArchitectureCode = value;
                }

                /**
                 * Gets the value of the roomCategory property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getRoomCategory() {
                    return roomCategory;
                }

                /**
                 * Sets the value of the roomCategory property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setRoomCategory(String value) {
                    this.roomCategory = value;
                }

                /**
                 * Gets the value of the roomClassificationCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getRoomClassificationCode() {
                    return roomClassificationCode;
                }

                /**
                 * Sets the value of the roomClassificationCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setRoomClassificationCode(String value) {
                    this.roomClassificationCode = value;
                }

                /**
                 * Gets the value of the roomGender property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getRoomGender() {
                    return roomGender;
                }

                /**
                 * Sets the value of the roomGender property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setRoomGender(String value) {
                    this.roomGender = value;
                }

                /**
                 * Gets the value of the roomID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getRoomID() {
                    return roomID;
                }

                /**
                 * Sets the value of the roomID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setRoomID(String value) {
                    this.roomID = value;
                }

                /**
                 * Gets the value of the roomLocationCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getRoomLocationCode() {
                    return roomLocationCode;
                }

                /**
                 * Sets the value of the roomLocationCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setRoomLocationCode(String value) {
                    this.roomLocationCode = value;
                }

                /**
                 * Gets the value of the roomType property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getRoomType() {
                    return roomType;
                }

                /**
                 * Sets the value of the roomType property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setRoomType(String value) {
                    this.roomType = value;
                }

                /**
                 * Gets the value of the roomTypeCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getRoomTypeCode() {
                    return roomTypeCode;
                }

                /**
                 * Sets the value of the roomTypeCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setRoomTypeCode(String value) {
                    this.roomTypeCode = value;
                }

                /**
                 * Gets the value of the roomViewCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getRoomViewCode() {
                    return roomViewCode;
                }

                /**
                 * Sets the value of the roomViewCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setRoomViewCode(String value) {
                    this.roomViewCode = value;
                }

                /**
                 * Gets the value of the sharedRoomInd property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isSharedRoomInd() {
                    return sharedRoomInd;
                }

                /**
                 * Sets the value of the sharedRoomInd property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setSharedRoomInd(Boolean value) {
                    this.sharedRoomInd = value;
                }

                /**
                 * Gets the value of the sizeMeasurement property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getSizeMeasurement() {
                    return sizeMeasurement;
                }

                /**
                 * Sets the value of the sizeMeasurement property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setSizeMeasurement(String value) {
                    this.sizeMeasurement = value;
                }

                /**
                 * Gets the value of the promotionCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPromotionCode() {
                    return promotionCode;
                }

                /**
                 * Sets the value of the promotionCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPromotionCode(String value) {
                    this.promotionCode = value;
                }

                /**
                 * Gets the value of the promotionVendorCode property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the promotionVendorCode property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getPromotionVendorCode().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link String }
                 * 
                 * 
                 */
                public List<String> getPromotionVendorCode() {
                    if (promotionVendorCode == null) {
                        promotionVendorCode = new ArrayList<String>();
                    }
                    return this.promotionVendorCode;
                }

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
     *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}MeetingRoomsType">
     *       &lt;sequence>
     *         &lt;element name="Codes" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Code" type="{http://www.opentravel.org/OTA/2003/05}MeetingRoomCodeType" maxOccurs="unbounded"/>
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
        "codes"
    })
    public static class MeetingRooms
        extends MeetingRoomsType
    {

        @XmlElement(name = "Codes")
        protected FacilityInfoType.MeetingRooms.Codes codes;

        /**
         * Gets the value of the codes property.
         * 
         * @return
         *     possible object is
         *     {@link FacilityInfoType.MeetingRooms.Codes }
         *     
         */
        public FacilityInfoType.MeetingRooms.Codes getCodes() {
            return codes;
        }

        /**
         * Sets the value of the codes property.
         * 
         * @param value
         *     allowed object is
         *     {@link FacilityInfoType.MeetingRooms.Codes }
         *     
         */
        public void setCodes(FacilityInfoType.MeetingRooms.Codes value) {
            this.codes = value;
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
         *         &lt;element name="Code" type="{http://www.opentravel.org/OTA/2003/05}MeetingRoomCodeType" maxOccurs="unbounded"/>
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
            "code"
        })
        public static class Codes {

            @XmlElement(name = "Code", required = true)
            protected List<MeetingRoomCodeType> code;

            /**
             * Gets the value of the code property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the code property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCode().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link MeetingRoomCodeType }
             * 
             * 
             */
            public List<MeetingRoomCodeType> getCode() {
                if (code == null) {
                    code = new ArrayList<MeetingRoomCodeType>();
                }
                return this.code;
            }

        }

    }

}
