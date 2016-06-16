
package com.desia.artifacts.booking;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AffiliationInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AffiliationInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DistribSystems" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DistribSystem">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="CompanyName" type="{http://www.opentravel.org/OTA/2003/05}CompanyNameType" minOccurs="0"/>
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
 *                           &lt;attribute name="Removal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Brands" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Brand" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                           &lt;/sequence>
 *                           &lt;attribute name="CategoryCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="Marketing" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="URL" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="CodeDetail" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="Removal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="LoyalPrograms" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="LoyalProgram" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ProgramDescription" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;extension base="{http://www.opentravel.org/OTA/2003/05}ParagraphType">
 *                                     &lt;sequence>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="Removal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                   &lt;/extension>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="ProgramRestriction" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;extension base="{http://www.opentravel.org/OTA/2003/05}ParagraphType">
 *                                     &lt;sequence>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="Removal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                   &lt;/extension>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="BlackoutDates" type="{http://www.opentravel.org/OTA/2003/05}BlackoutDateType" minOccurs="0"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="AffiliateProgramName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="HotelLevel" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="ProgramCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="ProgramName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="SecondaryProgramName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="TravelSector" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="Removal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Awards" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Award" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                           &lt;/sequence>
 *                           &lt;attribute name="Date" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                           &lt;attribute name="OfficialAppointmentInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                           &lt;attribute name="Provider" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="Rating" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="RatingSymbol" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="Removal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PartnerInfos" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PartnerInfo" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Contact" type="{http://www.opentravel.org/OTA/2003/05}ContactInfoType" minOccurs="0"/>
 *                             &lt;element name="Description" type="{http://www.opentravel.org/OTA/2003/05}ParagraphType" minOccurs="0"/>
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
 *         &lt;element name="Descriptions" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Description" type="{http://www.opentravel.org/OTA/2003/05}ParagraphType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
@XmlType(name = "AffiliationInfoType", propOrder = {
    "distribSystems",
    "brands",
    "loyalPrograms",
    "awards",
    "partnerInfos",
    "descriptions"
})
public class AffiliationInfoType {

    @XmlElement(name = "DistribSystems")
    protected AffiliationInfoType.DistribSystems distribSystems;
    @XmlElement(name = "Brands")
    protected AffiliationInfoType.Brands brands;
    @XmlElement(name = "LoyalPrograms")
    protected AffiliationInfoType.LoyalPrograms loyalPrograms;
    @XmlElement(name = "Awards")
    protected AffiliationInfoType.Awards awards;
    @XmlElement(name = "PartnerInfos")
    protected AffiliationInfoType.PartnerInfos partnerInfos;
    @XmlElement(name = "Descriptions")
    protected AffiliationInfoType.Descriptions descriptions;
    @XmlAttribute(name = "LastUpdated")
    @XmlSchemaType(name = "anySimpleType")
    protected String lastUpdated;

    /**
     * Gets the value of the distribSystems property.
     * 
     * @return
     *     possible object is
     *     {@link AffiliationInfoType.DistribSystems }
     *     
     */
    public AffiliationInfoType.DistribSystems getDistribSystems() {
        return distribSystems;
    }

    /**
     * Sets the value of the distribSystems property.
     * 
     * @param value
     *     allowed object is
     *     {@link AffiliationInfoType.DistribSystems }
     *     
     */
    public void setDistribSystems(AffiliationInfoType.DistribSystems value) {
        this.distribSystems = value;
    }

    /**
     * Gets the value of the brands property.
     * 
     * @return
     *     possible object is
     *     {@link AffiliationInfoType.Brands }
     *     
     */
    public AffiliationInfoType.Brands getBrands() {
        return brands;
    }

    /**
     * Sets the value of the brands property.
     * 
     * @param value
     *     allowed object is
     *     {@link AffiliationInfoType.Brands }
     *     
     */
    public void setBrands(AffiliationInfoType.Brands value) {
        this.brands = value;
    }

    /**
     * Gets the value of the loyalPrograms property.
     * 
     * @return
     *     possible object is
     *     {@link AffiliationInfoType.LoyalPrograms }
     *     
     */
    public AffiliationInfoType.LoyalPrograms getLoyalPrograms() {
        return loyalPrograms;
    }

    /**
     * Sets the value of the loyalPrograms property.
     * 
     * @param value
     *     allowed object is
     *     {@link AffiliationInfoType.LoyalPrograms }
     *     
     */
    public void setLoyalPrograms(AffiliationInfoType.LoyalPrograms value) {
        this.loyalPrograms = value;
    }

    /**
     * Gets the value of the awards property.
     * 
     * @return
     *     possible object is
     *     {@link AffiliationInfoType.Awards }
     *     
     */
    public AffiliationInfoType.Awards getAwards() {
        return awards;
    }

    /**
     * Sets the value of the awards property.
     * 
     * @param value
     *     allowed object is
     *     {@link AffiliationInfoType.Awards }
     *     
     */
    public void setAwards(AffiliationInfoType.Awards value) {
        this.awards = value;
    }

    /**
     * Gets the value of the partnerInfos property.
     * 
     * @return
     *     possible object is
     *     {@link AffiliationInfoType.PartnerInfos }
     *     
     */
    public AffiliationInfoType.PartnerInfos getPartnerInfos() {
        return partnerInfos;
    }

    /**
     * Sets the value of the partnerInfos property.
     * 
     * @param value
     *     allowed object is
     *     {@link AffiliationInfoType.PartnerInfos }
     *     
     */
    public void setPartnerInfos(AffiliationInfoType.PartnerInfos value) {
        this.partnerInfos = value;
    }

    /**
     * Gets the value of the descriptions property.
     * 
     * @return
     *     possible object is
     *     {@link AffiliationInfoType.Descriptions }
     *     
     */
    public AffiliationInfoType.Descriptions getDescriptions() {
        return descriptions;
    }

    /**
     * Sets the value of the descriptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link AffiliationInfoType.Descriptions }
     *     
     */
    public void setDescriptions(AffiliationInfoType.Descriptions value) {
        this.descriptions = value;
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
     *         &lt;element name="Award" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                 &lt;/sequence>
     *                 &lt;attribute name="Date" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *                 &lt;attribute name="OfficialAppointmentInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                 &lt;attribute name="Provider" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="Rating" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="RatingSymbol" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="Removal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
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
        "award"
    })
    public static class Awards {

        @XmlElement(name = "Award", required = true)
        protected List<AffiliationInfoType.Awards.Award> award;

        /**
         * Gets the value of the award property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the award property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAward().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AffiliationInfoType.Awards.Award }
         * 
         * 
         */
        public List<AffiliationInfoType.Awards.Award> getAward() {
            if (award == null) {
                award = new ArrayList<AffiliationInfoType.Awards.Award>();
            }
            return this.award;
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
         *       &lt;attribute name="Date" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
         *       &lt;attribute name="OfficialAppointmentInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *       &lt;attribute name="Provider" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="Rating" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="RatingSymbol" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="Removal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Award {

            @XmlAttribute(name = "Date")
            @XmlSchemaType(name = "anySimpleType")
            protected String date;
            @XmlAttribute(name = "OfficialAppointmentInd")
            protected Boolean officialAppointmentInd;
            @XmlAttribute(name = "Provider")
            protected String provider;
            @XmlAttribute(name = "Rating")
            protected String rating;
            @XmlAttribute(name = "RatingSymbol")
            protected String ratingSymbol;
            @XmlAttribute(name = "Removal")
            protected Boolean removal;

            /**
             * Gets the value of the date property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDate() {
                return date;
            }

            /**
             * Sets the value of the date property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDate(String value) {
                this.date = value;
            }

            /**
             * Gets the value of the officialAppointmentInd property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isOfficialAppointmentInd() {
                return officialAppointmentInd;
            }

            /**
             * Sets the value of the officialAppointmentInd property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setOfficialAppointmentInd(Boolean value) {
                this.officialAppointmentInd = value;
            }

            /**
             * Gets the value of the provider property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProvider() {
                return provider;
            }

            /**
             * Sets the value of the provider property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProvider(String value) {
                this.provider = value;
            }

            /**
             * Gets the value of the rating property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRating() {
                return rating;
            }

            /**
             * Sets the value of the rating property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRating(String value) {
                this.rating = value;
            }

            /**
             * Gets the value of the ratingSymbol property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRatingSymbol() {
                return ratingSymbol;
            }

            /**
             * Sets the value of the ratingSymbol property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRatingSymbol(String value) {
                this.ratingSymbol = value;
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
     *         &lt;element name="Brand" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                 &lt;/sequence>
     *                 &lt;attribute name="CategoryCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="Marketing" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="URL" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="CodeDetail" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="Removal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
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
        "brand"
    })
    public static class Brands {

        @XmlElement(name = "Brand", required = true)
        protected List<AffiliationInfoType.Brands.Brand> brand;

        /**
         * Gets the value of the brand property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the brand property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBrand().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AffiliationInfoType.Brands.Brand }
         * 
         * 
         */
        public List<AffiliationInfoType.Brands.Brand> getBrand() {
            if (brand == null) {
                brand = new ArrayList<AffiliationInfoType.Brands.Brand>();
            }
            return this.brand;
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
         *       &lt;attribute name="CategoryCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="Marketing" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="URL" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="CodeDetail" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="Removal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Brand {

            @XmlAttribute(name = "CategoryCode")
            protected String categoryCode;
            @XmlAttribute(name = "Marketing")
            protected String marketing;
            @XmlAttribute(name = "URL")
            protected String url;
            @XmlAttribute(name = "CodeDetail")
            protected String codeDetail;
            @XmlAttribute(name = "Removal")
            protected Boolean removal;

            /**
             * Gets the value of the categoryCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCategoryCode() {
                return categoryCode;
            }

            /**
             * Sets the value of the categoryCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCategoryCode(String value) {
                this.categoryCode = value;
            }

            /**
             * Gets the value of the marketing property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMarketing() {
                return marketing;
            }

            /**
             * Sets the value of the marketing property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMarketing(String value) {
                this.marketing = value;
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
     *         &lt;element name="Description" type="{http://www.opentravel.org/OTA/2003/05}ParagraphType" maxOccurs="unbounded"/>
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
        "description"
    })
    public static class Descriptions {

        @XmlElement(name = "Description", required = true)
        protected List<ParagraphType> description;

        /**
         * Gets the value of the description property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the description property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDescription().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ParagraphType }
         * 
         * 
         */
        public List<ParagraphType> getDescription() {
            if (description == null) {
                description = new ArrayList<ParagraphType>();
            }
            return this.description;
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
     *         &lt;element name="DistribSystem">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="CompanyName" type="{http://www.opentravel.org/OTA/2003/05}CompanyNameType" minOccurs="0"/>
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
     *                 &lt;attribute name="Removal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
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
        "distribSystem"
    })
    public static class DistribSystems {

        @XmlElement(name = "DistribSystem", required = true)
        protected AffiliationInfoType.DistribSystems.DistribSystem distribSystem;

        /**
         * Gets the value of the distribSystem property.
         * 
         * @return
         *     possible object is
         *     {@link AffiliationInfoType.DistribSystems.DistribSystem }
         *     
         */
        public AffiliationInfoType.DistribSystems.DistribSystem getDistribSystem() {
            return distribSystem;
        }

        /**
         * Sets the value of the distribSystem property.
         * 
         * @param value
         *     allowed object is
         *     {@link AffiliationInfoType.DistribSystems.DistribSystem }
         *     
         */
        public void setDistribSystem(AffiliationInfoType.DistribSystems.DistribSystem value) {
            this.distribSystem = value;
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
         *         &lt;element name="CompanyName" type="{http://www.opentravel.org/OTA/2003/05}CompanyNameType" minOccurs="0"/>
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
         *       &lt;attribute name="Removal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "companyName"
        })
        public static class DistribSystem {

            @XmlElement(name = "CompanyName")
            protected CompanyNameType companyName;
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
            @XmlAttribute(name = "Removal")
            protected Boolean removal;

            /**
             * Gets the value of the companyName property.
             * 
             * @return
             *     possible object is
             *     {@link CompanyNameType }
             *     
             */
            public CompanyNameType getCompanyName() {
                return companyName;
            }

            /**
             * Sets the value of the companyName property.
             * 
             * @param value
             *     allowed object is
             *     {@link CompanyNameType }
             *     
             */
            public void setCompanyName(CompanyNameType value) {
                this.companyName = value;
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
     *         &lt;element name="LoyalProgram" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ProgramDescription" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;extension base="{http://www.opentravel.org/OTA/2003/05}ParagraphType">
     *                           &lt;sequence>
     *                           &lt;/sequence>
     *                           &lt;attribute name="Removal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                         &lt;/extension>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="ProgramRestriction" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;extension base="{http://www.opentravel.org/OTA/2003/05}ParagraphType">
     *                           &lt;sequence>
     *                           &lt;/sequence>
     *                           &lt;attribute name="Removal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                         &lt;/extension>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="BlackoutDates" type="{http://www.opentravel.org/OTA/2003/05}BlackoutDateType" minOccurs="0"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="AffiliateProgramName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="HotelLevel" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="ProgramCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="ProgramName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="SecondaryProgramName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="TravelSector" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="Removal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
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
        "loyalProgram"
    })
    public static class LoyalPrograms {

        @XmlElement(name = "LoyalProgram", required = true)
        protected List<AffiliationInfoType.LoyalPrograms.LoyalProgram> loyalProgram;

        /**
         * Gets the value of the loyalProgram property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the loyalProgram property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLoyalProgram().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AffiliationInfoType.LoyalPrograms.LoyalProgram }
         * 
         * 
         */
        public List<AffiliationInfoType.LoyalPrograms.LoyalProgram> getLoyalProgram() {
            if (loyalProgram == null) {
                loyalProgram = new ArrayList<AffiliationInfoType.LoyalPrograms.LoyalProgram>();
            }
            return this.loyalProgram;
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
         *         &lt;element name="ProgramDescription" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}ParagraphType">
         *                 &lt;sequence>
         *                 &lt;/sequence>
         *                 &lt;attribute name="Removal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *               &lt;/extension>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="ProgramRestriction" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}ParagraphType">
         *                 &lt;sequence>
         *                 &lt;/sequence>
         *                 &lt;attribute name="Removal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *               &lt;/extension>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="BlackoutDates" type="{http://www.opentravel.org/OTA/2003/05}BlackoutDateType" minOccurs="0"/>
         *       &lt;/sequence>
         *       &lt;attribute name="AffiliateProgramName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="HotelLevel" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="ProgramCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="ProgramName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="SecondaryProgramName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="TravelSector" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="Removal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "programDescription",
            "programRestriction",
            "blackoutDates"
        })
        public static class LoyalProgram {

            @XmlElement(name = "ProgramDescription")
            protected List<AffiliationInfoType.LoyalPrograms.LoyalProgram.ProgramDescription> programDescription;
            @XmlElement(name = "ProgramRestriction")
            protected AffiliationInfoType.LoyalPrograms.LoyalProgram.ProgramRestriction programRestriction;
            @XmlElement(name = "BlackoutDates")
            protected BlackoutDateType blackoutDates;
            @XmlAttribute(name = "AffiliateProgramName")
            protected String affiliateProgramName;
            @XmlAttribute(name = "HotelLevel")
            protected String hotelLevel;
            @XmlAttribute(name = "ProgramCode")
            protected String programCode;
            @XmlAttribute(name = "ProgramName")
            protected String programName;
            @XmlAttribute(name = "SecondaryProgramName")
            protected String secondaryProgramName;
            @XmlAttribute(name = "TravelSector")
            protected String travelSector;
            @XmlAttribute(name = "Removal")
            protected Boolean removal;

            /**
             * Gets the value of the programDescription property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the programDescription property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getProgramDescription().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link AffiliationInfoType.LoyalPrograms.LoyalProgram.ProgramDescription }
             * 
             * 
             */
            public List<AffiliationInfoType.LoyalPrograms.LoyalProgram.ProgramDescription> getProgramDescription() {
                if (programDescription == null) {
                    programDescription = new ArrayList<AffiliationInfoType.LoyalPrograms.LoyalProgram.ProgramDescription>();
                }
                return this.programDescription;
            }

            /**
             * Gets the value of the programRestriction property.
             * 
             * @return
             *     possible object is
             *     {@link AffiliationInfoType.LoyalPrograms.LoyalProgram.ProgramRestriction }
             *     
             */
            public AffiliationInfoType.LoyalPrograms.LoyalProgram.ProgramRestriction getProgramRestriction() {
                return programRestriction;
            }

            /**
             * Sets the value of the programRestriction property.
             * 
             * @param value
             *     allowed object is
             *     {@link AffiliationInfoType.LoyalPrograms.LoyalProgram.ProgramRestriction }
             *     
             */
            public void setProgramRestriction(AffiliationInfoType.LoyalPrograms.LoyalProgram.ProgramRestriction value) {
                this.programRestriction = value;
            }

            /**
             * Gets the value of the blackoutDates property.
             * 
             * @return
             *     possible object is
             *     {@link BlackoutDateType }
             *     
             */
            public BlackoutDateType getBlackoutDates() {
                return blackoutDates;
            }

            /**
             * Sets the value of the blackoutDates property.
             * 
             * @param value
             *     allowed object is
             *     {@link BlackoutDateType }
             *     
             */
            public void setBlackoutDates(BlackoutDateType value) {
                this.blackoutDates = value;
            }

            /**
             * Gets the value of the affiliateProgramName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAffiliateProgramName() {
                return affiliateProgramName;
            }

            /**
             * Sets the value of the affiliateProgramName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAffiliateProgramName(String value) {
                this.affiliateProgramName = value;
            }

            /**
             * Gets the value of the hotelLevel property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHotelLevel() {
                return hotelLevel;
            }

            /**
             * Sets the value of the hotelLevel property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHotelLevel(String value) {
                this.hotelLevel = value;
            }

            /**
             * Gets the value of the programCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProgramCode() {
                return programCode;
            }

            /**
             * Sets the value of the programCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProgramCode(String value) {
                this.programCode = value;
            }

            /**
             * Gets the value of the programName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProgramName() {
                return programName;
            }

            /**
             * Sets the value of the programName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProgramName(String value) {
                this.programName = value;
            }

            /**
             * Gets the value of the secondaryProgramName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSecondaryProgramName() {
                return secondaryProgramName;
            }

            /**
             * Sets the value of the secondaryProgramName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSecondaryProgramName(String value) {
                this.secondaryProgramName = value;
            }

            /**
             * Gets the value of the travelSector property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTravelSector() {
                return travelSector;
            }

            /**
             * Sets the value of the travelSector property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTravelSector(String value) {
                this.travelSector = value;
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
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}ParagraphType">
             *       &lt;sequence>
             *       &lt;/sequence>
             *       &lt;attribute name="Removal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
             *     &lt;/extension>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class ProgramDescription
                extends ParagraphType
            {

                @XmlAttribute(name = "Removal")
                protected Boolean removal;

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

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}ParagraphType">
             *       &lt;sequence>
             *       &lt;/sequence>
             *       &lt;attribute name="Removal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
             *     &lt;/extension>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class ProgramRestriction
                extends ParagraphType
            {

                @XmlAttribute(name = "Removal")
                protected Boolean removal;

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
     *         &lt;element name="PartnerInfo" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Contact" type="{http://www.opentravel.org/OTA/2003/05}ContactInfoType" minOccurs="0"/>
     *                   &lt;element name="Description" type="{http://www.opentravel.org/OTA/2003/05}ParagraphType" minOccurs="0"/>
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
        "partnerInfo"
    })
    public static class PartnerInfos {

        @XmlElement(name = "PartnerInfo", required = true)
        protected List<AffiliationInfoType.PartnerInfos.PartnerInfo> partnerInfo;

        /**
         * Gets the value of the partnerInfo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the partnerInfo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPartnerInfo().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AffiliationInfoType.PartnerInfos.PartnerInfo }
         * 
         * 
         */
        public List<AffiliationInfoType.PartnerInfos.PartnerInfo> getPartnerInfo() {
            if (partnerInfo == null) {
                partnerInfo = new ArrayList<AffiliationInfoType.PartnerInfos.PartnerInfo>();
            }
            return this.partnerInfo;
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
         *         &lt;element name="Contact" type="{http://www.opentravel.org/OTA/2003/05}ContactInfoType" minOccurs="0"/>
         *         &lt;element name="Description" type="{http://www.opentravel.org/OTA/2003/05}ParagraphType" minOccurs="0"/>
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
            "contact",
            "description"
        })
        public static class PartnerInfo {

            @XmlElement(name = "Contact")
            protected ContactInfoType contact;
            @XmlElement(name = "Description")
            protected ParagraphType description;

            /**
             * Gets the value of the contact property.
             * 
             * @return
             *     possible object is
             *     {@link ContactInfoType }
             *     
             */
            public ContactInfoType getContact() {
                return contact;
            }

            /**
             * Sets the value of the contact property.
             * 
             * @param value
             *     allowed object is
             *     {@link ContactInfoType }
             *     
             */
            public void setContact(ContactInfoType value) {
                this.contact = value;
            }

            /**
             * Gets the value of the description property.
             * 
             * @return
             *     possible object is
             *     {@link ParagraphType }
             *     
             */
            public ParagraphType getDescription() {
                return description;
            }

            /**
             * Sets the value of the description property.
             * 
             * @param value
             *     allowed object is
             *     {@link ParagraphType }
             *     
             */
            public void setDescription(ParagraphType value) {
                this.description = value;
            }

        }

    }

}
