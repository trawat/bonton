
package com.desia.artifacts.search;

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
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opentravel.org/OTA/2003/05}Reviews" minOccurs="0"/>
 *         &lt;element name="Multimedia" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://www.opentravel.org/OTA/2003/05}ImageJSON" minOccurs="0"/>
 *                   &lt;element name="VideoUrlList" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="ImageUrl" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="ThumbnailImageName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="ThumbnailUrl" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://www.opentravel.org/OTA/2003/05}POI" minOccurs="0"/>
 *         &lt;element ref="{http://www.opentravel.org/OTA/2003/05}Amenities" minOccurs="0"/>
 *         &lt;element name="CrossLinks" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                 &lt;/sequence>
 *                 &lt;attribute name="PropertyName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="URL" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="AllRatePlanTypes" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AmenityDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Area" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AreaSeoId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CheckInInstruction" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CheckInTime" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="CheckOutTime" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="CitySeoId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CountrySeoId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="GurusTip" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="HotelCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="HotelType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="LastBookedTime" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="NumberOfFloors" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="NumberOfRooms" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Rank" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="SeoPageSection" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="StateSeoId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="UsersViewCount" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="isFlexibleCheckIn" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="propertyType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "reviews",
    "multimedia",
    "poi",
    "amenities",
    "crossLinks"
})
@XmlRootElement(name = "HotelBasicInformation")
public class HotelBasicInformation {

    @XmlElement(name = "Reviews")
    protected Reviews reviews;
    @XmlElement(name = "Multimedia")
    protected HotelBasicInformation.Multimedia multimedia;
    @XmlElement(name = "POI")
    protected POI poi;
    @XmlElement(name = "Amenities")
    protected Amenities amenities;
    @XmlElement(name = "CrossLinks")
    protected List<HotelBasicInformation.CrossLinks> crossLinks;
    @XmlAttribute(name = "AllRatePlanTypes")
    protected String allRatePlanTypes;
    @XmlAttribute(name = "AmenityDescription")
    protected String amenityDescription;
    @XmlAttribute(name = "Area")
    protected String area;
    @XmlAttribute(name = "AreaSeoId")
    protected String areaSeoId;
    @XmlAttribute(name = "CheckInInstruction")
    protected String checkInInstruction;
    @XmlAttribute(name = "CheckInTime")
    protected Integer checkInTime;
    @XmlAttribute(name = "CheckOutTime")
    protected Integer checkOutTime;
    @XmlAttribute(name = "CitySeoId")
    protected String citySeoId;
    @XmlAttribute(name = "CountrySeoId")
    protected String countrySeoId;
    @XmlAttribute(name = "Description")
    protected String description;
    @XmlAttribute(name = "GurusTip")
    protected String gurusTip;
    @XmlAttribute(name = "HotelCategory")
    protected String hotelCategory;
    @XmlAttribute(name = "HotelCode")
    protected String hotelCode;
    @XmlAttribute(name = "HotelType")
    protected String hotelType;
    @XmlAttribute(name = "LastBookedTime")
    protected String lastBookedTime;
    @XmlAttribute(name = "NumberOfFloors")
    protected Integer numberOfFloors;
    @XmlAttribute(name = "NumberOfRooms")
    protected Integer numberOfRooms;
    @XmlAttribute(name = "Rank")
    protected Integer rank;
    @XmlAttribute(name = "SeoPageSection")
    protected String seoPageSection;
    @XmlAttribute(name = "StateSeoId")
    protected String stateSeoId;
    @XmlAttribute(name = "UsersViewCount")
    protected String usersViewCount;
    @XmlAttribute(name = "isFlexibleCheckIn")
    protected Boolean isFlexibleCheckIn;
    @XmlAttribute(name = "propertyType")
    protected String propertyType;

    /**
     * Gets the value of the reviews property.
     * 
     * @return
     *     possible object is
     *     {@link Reviews }
     *     
     */
    public Reviews getReviews() {
        return reviews;
    }

    /**
     * Sets the value of the reviews property.
     * 
     * @param value
     *     allowed object is
     *     {@link Reviews }
     *     
     */
    public void setReviews(Reviews value) {
        this.reviews = value;
    }

    /**
     * Gets the value of the multimedia property.
     * 
     * @return
     *     possible object is
     *     {@link HotelBasicInformation.Multimedia }
     *     
     */
    public HotelBasicInformation.Multimedia getMultimedia() {
        return multimedia;
    }

    /**
     * Sets the value of the multimedia property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelBasicInformation.Multimedia }
     *     
     */
    public void setMultimedia(HotelBasicInformation.Multimedia value) {
        this.multimedia = value;
    }

    /**
     * Gets the value of the poi property.
     * 
     * @return
     *     possible object is
     *     {@link POI }
     *     
     */
    public POI getPOI() {
        return poi;
    }

    /**
     * Sets the value of the poi property.
     * 
     * @param value
     *     allowed object is
     *     {@link POI }
     *     
     */
    public void setPOI(POI value) {
        this.poi = value;
    }

    /**
     * Gets the value of the amenities property.
     * 
     * @return
     *     possible object is
     *     {@link Amenities }
     *     
     */
    public Amenities getAmenities() {
        return amenities;
    }

    /**
     * Sets the value of the amenities property.
     * 
     * @param value
     *     allowed object is
     *     {@link Amenities }
     *     
     */
    public void setAmenities(Amenities value) {
        this.amenities = value;
    }

    /**
     * Gets the value of the crossLinks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the crossLinks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCrossLinks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HotelBasicInformation.CrossLinks }
     * 
     * 
     */
    public List<HotelBasicInformation.CrossLinks> getCrossLinks() {
        if (crossLinks == null) {
            crossLinks = new ArrayList<HotelBasicInformation.CrossLinks>();
        }
        return this.crossLinks;
    }

    /**
     * Gets the value of the allRatePlanTypes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllRatePlanTypes() {
        return allRatePlanTypes;
    }

    /**
     * Sets the value of the allRatePlanTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllRatePlanTypes(String value) {
        this.allRatePlanTypes = value;
    }

    /**
     * Gets the value of the amenityDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmenityDescription() {
        return amenityDescription;
    }

    /**
     * Sets the value of the amenityDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmenityDescription(String value) {
        this.amenityDescription = value;
    }

    /**
     * Gets the value of the area property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArea() {
        return area;
    }

    /**
     * Sets the value of the area property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArea(String value) {
        this.area = value;
    }

    /**
     * Gets the value of the areaSeoId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaSeoId() {
        return areaSeoId;
    }

    /**
     * Sets the value of the areaSeoId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaSeoId(String value) {
        this.areaSeoId = value;
    }

    /**
     * Gets the value of the checkInInstruction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckInInstruction() {
        return checkInInstruction;
    }

    /**
     * Sets the value of the checkInInstruction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckInInstruction(String value) {
        this.checkInInstruction = value;
    }

    /**
     * Gets the value of the checkInTime property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCheckInTime() {
        return checkInTime;
    }

    /**
     * Sets the value of the checkInTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCheckInTime(Integer value) {
        this.checkInTime = value;
    }

    /**
     * Gets the value of the checkOutTime property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCheckOutTime() {
        return checkOutTime;
    }

    /**
     * Sets the value of the checkOutTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCheckOutTime(Integer value) {
        this.checkOutTime = value;
    }

    /**
     * Gets the value of the citySeoId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCitySeoId() {
        return citySeoId;
    }

    /**
     * Sets the value of the citySeoId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCitySeoId(String value) {
        this.citySeoId = value;
    }

    /**
     * Gets the value of the countrySeoId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountrySeoId() {
        return countrySeoId;
    }

    /**
     * Sets the value of the countrySeoId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountrySeoId(String value) {
        this.countrySeoId = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the gurusTip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGurusTip() {
        return gurusTip;
    }

    /**
     * Sets the value of the gurusTip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGurusTip(String value) {
        this.gurusTip = value;
    }

    /**
     * Gets the value of the hotelCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelCategory() {
        return hotelCategory;
    }

    /**
     * Sets the value of the hotelCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelCategory(String value) {
        this.hotelCategory = value;
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
     * Gets the value of the hotelType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelType() {
        return hotelType;
    }

    /**
     * Sets the value of the hotelType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelType(String value) {
        this.hotelType = value;
    }

    /**
     * Gets the value of the lastBookedTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastBookedTime() {
        return lastBookedTime;
    }

    /**
     * Sets the value of the lastBookedTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastBookedTime(String value) {
        this.lastBookedTime = value;
    }

    /**
     * Gets the value of the numberOfFloors property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    /**
     * Sets the value of the numberOfFloors property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberOfFloors(Integer value) {
        this.numberOfFloors = value;
    }

    /**
     * Gets the value of the numberOfRooms property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    /**
     * Sets the value of the numberOfRooms property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberOfRooms(Integer value) {
        this.numberOfRooms = value;
    }

    /**
     * Gets the value of the rank property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * Sets the value of the rank property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRank(Integer value) {
        this.rank = value;
    }

    /**
     * Gets the value of the seoPageSection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeoPageSection() {
        return seoPageSection;
    }

    /**
     * Sets the value of the seoPageSection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeoPageSection(String value) {
        this.seoPageSection = value;
    }

    /**
     * Gets the value of the stateSeoId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateSeoId() {
        return stateSeoId;
    }

    /**
     * Sets the value of the stateSeoId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateSeoId(String value) {
        this.stateSeoId = value;
    }

    /**
     * Gets the value of the usersViewCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsersViewCount() {
        return usersViewCount;
    }

    /**
     * Sets the value of the usersViewCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsersViewCount(String value) {
        this.usersViewCount = value;
    }

    /**
     * Gets the value of the isFlexibleCheckIn property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsFlexibleCheckIn() {
        return isFlexibleCheckIn;
    }

    /**
     * Sets the value of the isFlexibleCheckIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsFlexibleCheckIn(Boolean value) {
        this.isFlexibleCheckIn = value;
    }

    /**
     * Gets the value of the propertyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertyType() {
        return propertyType;
    }

    /**
     * Sets the value of the propertyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertyType(String value) {
        this.propertyType = value;
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
     *       &lt;attribute name="PropertyName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="URL" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class CrossLinks {

        @XmlAttribute(name = "PropertyName")
        protected String propertyName;
        @XmlAttribute(name = "URL")
        protected String url;

        /**
         * Gets the value of the propertyName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPropertyName() {
            return propertyName;
        }

        /**
         * Sets the value of the propertyName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPropertyName(String value) {
            this.propertyName = value;
        }

        /**
         * Gets the value of the url property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getURL() {
            return url;
        }

        /**
         * Sets the value of the url property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setURL(String value) {
            this.url = value;
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
     *         &lt;element ref="{http://www.opentravel.org/OTA/2003/05}ImageJSON" minOccurs="0"/>
     *         &lt;element name="VideoUrlList" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="ImageUrl" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="ThumbnailImageName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="ThumbnailUrl" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "imageJSON",
        "videoUrlList"
    })
    public static class Multimedia {

        @XmlElement(name = "ImageJSON")
        protected ImageJSON imageJSON;
        @XmlElement(name = "VideoUrlList")
        protected List<String> videoUrlList;
        @XmlAttribute(name = "ImageUrl")
        protected String imageUrl;
        @XmlAttribute(name = "ThumbnailImageName")
        protected String thumbnailImageName;
        @XmlAttribute(name = "ThumbnailUrl")
        protected String thumbnailUrl;

        /**
         * Gets the value of the imageJSON property.
         * 
         * @return
         *     possible object is
         *     {@link ImageJSON }
         *     
         */
        public ImageJSON getImageJSON() {
            return imageJSON;
        }

        /**
         * Sets the value of the imageJSON property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImageJSON }
         *     
         */
        public void setImageJSON(ImageJSON value) {
            this.imageJSON = value;
        }

        /**
         * Gets the value of the videoUrlList property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the videoUrlList property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getVideoUrlList().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getVideoUrlList() {
            if (videoUrlList == null) {
                videoUrlList = new ArrayList<String>();
            }
            return this.videoUrlList;
        }

        /**
         * Gets the value of the imageUrl property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getImageUrl() {
            return imageUrl;
        }

        /**
         * Sets the value of the imageUrl property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setImageUrl(String value) {
            this.imageUrl = value;
        }

        /**
         * Gets the value of the thumbnailImageName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getThumbnailImageName() {
            return thumbnailImageName;
        }

        /**
         * Sets the value of the thumbnailImageName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setThumbnailImageName(String value) {
            this.thumbnailImageName = value;
        }

        /**
         * Gets the value of the thumbnailUrl property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getThumbnailUrl() {
            return thumbnailUrl;
        }

        /**
         * Sets the value of the thumbnailUrl property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setThumbnailUrl(String value) {
            this.thumbnailUrl = value;
        }

    }

}
