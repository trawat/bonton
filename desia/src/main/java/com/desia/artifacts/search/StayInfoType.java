
package com.desia.artifacts.search;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StayInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StayInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LoyaltyPointsAccruals" type="{http://www.opentravel.org/OTA/2003/05}LoyaltyPointsAccrualsType" minOccurs="0"/>
 *         &lt;element name="RevenueCategories" type="{http://www.opentravel.org/OTA/2003/05}RevenueCategoriesType" minOccurs="0"/>
 *         &lt;element name="ReservationID" type="{http://www.opentravel.org/OTA/2003/05}UniqueID_Type" minOccurs="0"/>
 *         &lt;element name="HotelReservation" type="{http://www.opentravel.org/OTA/2003/05}HotelReservationType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="RoomStayRPH" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="SequenceNumber" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StayInfoType", propOrder = {
    "loyaltyPointsAccruals",
    "revenueCategories",
    "reservationID",
    "hotelReservation"
})
public class StayInfoType {

    @XmlElement(name = "LoyaltyPointsAccruals")
    protected LoyaltyPointsAccrualsType loyaltyPointsAccruals;
    @XmlElement(name = "RevenueCategories")
    protected RevenueCategoriesType revenueCategories;
    @XmlElement(name = "ReservationID")
    protected UniqueIDType reservationID;
    @XmlElement(name = "HotelReservation")
    protected HotelReservationType hotelReservation;
    @XmlAttribute(name = "RoomStayRPH")
    protected BigInteger roomStayRPH;
    @XmlAttribute(name = "SequenceNumber")
    protected BigInteger sequenceNumber;

    /**
     * Gets the value of the loyaltyPointsAccruals property.
     * 
     * @return
     *     possible object is
     *     {@link LoyaltyPointsAccrualsType }
     *     
     */
    public LoyaltyPointsAccrualsType getLoyaltyPointsAccruals() {
        return loyaltyPointsAccruals;
    }

    /**
     * Sets the value of the loyaltyPointsAccruals property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoyaltyPointsAccrualsType }
     *     
     */
    public void setLoyaltyPointsAccruals(LoyaltyPointsAccrualsType value) {
        this.loyaltyPointsAccruals = value;
    }

    /**
     * Gets the value of the revenueCategories property.
     * 
     * @return
     *     possible object is
     *     {@link RevenueCategoriesType }
     *     
     */
    public RevenueCategoriesType getRevenueCategories() {
        return revenueCategories;
    }

    /**
     * Sets the value of the revenueCategories property.
     * 
     * @param value
     *     allowed object is
     *     {@link RevenueCategoriesType }
     *     
     */
    public void setRevenueCategories(RevenueCategoriesType value) {
        this.revenueCategories = value;
    }

    /**
     * Gets the value of the reservationID property.
     * 
     * @return
     *     possible object is
     *     {@link UniqueIDType }
     *     
     */
    public UniqueIDType getReservationID() {
        return reservationID;
    }

    /**
     * Sets the value of the reservationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link UniqueIDType }
     *     
     */
    public void setReservationID(UniqueIDType value) {
        this.reservationID = value;
    }

    /**
     * Gets the value of the hotelReservation property.
     * 
     * @return
     *     possible object is
     *     {@link HotelReservationType }
     *     
     */
    public HotelReservationType getHotelReservation() {
        return hotelReservation;
    }

    /**
     * Sets the value of the hotelReservation property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelReservationType }
     *     
     */
    public void setHotelReservation(HotelReservationType value) {
        this.hotelReservation = value;
    }

    /**
     * Gets the value of the roomStayRPH property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRoomStayRPH() {
        return roomStayRPH;
    }

    /**
     * Sets the value of the roomStayRPH property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRoomStayRPH(BigInteger value) {
        this.roomStayRPH = value;
    }

    /**
     * Gets the value of the sequenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * Sets the value of the sequenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSequenceNumber(BigInteger value) {
        this.sequenceNumber = value;
    }

}
