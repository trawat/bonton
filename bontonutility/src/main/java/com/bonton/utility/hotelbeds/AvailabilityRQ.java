//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.11 at 01:22:18 PM IST 
//


package com.bonton.utility.hotelbeds;

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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stay">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="checkIn" type="{http://www.w3.org/2001/XMLSchema}date" />
 *                 &lt;attribute name="checkOut" type="{http://www.w3.org/2001/XMLSchema}date" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="occupancies">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="occupancy">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="paxes">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="pax">
 *                                         &lt;complexType>
 *                                           &lt;simpleContent>
 *                                             &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                               &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="age" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                               &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="surname" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                             &lt;/extension>
 *                                           &lt;/simpleContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="rooms" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="adults" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="children" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="destination">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="zone" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="hotels">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="hotel" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="filter">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="minRate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="maxRate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="packaging" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="minCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="maxCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="paymentType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
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
    "stay",
    "occupancies",
    "destination",
    "hotels",
    "filter"
})
@XmlRootElement(name = "availabilityRQ")
public class AvailabilityRQ {

    @XmlElement(required = true)
    protected AvailabilityRQ.Stay stay;
    @XmlElement(required = true)
    protected AvailabilityRQ.Occupancies occupancies;
    @XmlElement(required = true)
    protected AvailabilityRQ.Destination destination;
    @XmlElement(required = true)
    protected AvailabilityRQ.Hotels hotels;
    @XmlElement(required = true)
    protected AvailabilityRQ.Filter filter;

    /**
     * Gets the value of the stay property.
     * 
     * @return
     *     possible object is
     *     {@link AvailabilityRQ.Stay }
     *     
     */
    public AvailabilityRQ.Stay getStay() {
        return stay;
    }

    /**
     * Sets the value of the stay property.
     * 
     * @param value
     *     allowed object is
     *     {@link AvailabilityRQ.Stay }
     *     
     */
    public void setStay(AvailabilityRQ.Stay value) {
        this.stay = value;
    }

    /**
     * Gets the value of the occupancies property.
     * 
     * @return
     *     possible object is
     *     {@link AvailabilityRQ.Occupancies }
     *     
     */
    public AvailabilityRQ.Occupancies getOccupancies() {
        return occupancies;
    }

    /**
     * Sets the value of the occupancies property.
     * 
     * @param value
     *     allowed object is
     *     {@link AvailabilityRQ.Occupancies }
     *     
     */
    public void setOccupancies(AvailabilityRQ.Occupancies value) {
        this.occupancies = value;
    }

    /**
     * Gets the value of the destination property.
     * 
     * @return
     *     possible object is
     *     {@link AvailabilityRQ.Destination }
     *     
     */
    public AvailabilityRQ.Destination getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     * 
     * @param value
     *     allowed object is
     *     {@link AvailabilityRQ.Destination }
     *     
     */
    public void setDestination(AvailabilityRQ.Destination value) {
        this.destination = value;
    }

    /**
     * Gets the value of the hotels property.
     * 
     * @return
     *     possible object is
     *     {@link AvailabilityRQ.Hotels }
     *     
     */
    public AvailabilityRQ.Hotels getHotels() {
        return hotels;
    }

    /**
     * Sets the value of the hotels property.
     * 
     * @param value
     *     allowed object is
     *     {@link AvailabilityRQ.Hotels }
     *     
     */
    public void setHotels(AvailabilityRQ.Hotels value) {
        this.hotels = value;
    }

    /**
     * Gets the value of the filter property.
     * 
     * @return
     *     possible object is
     *     {@link AvailabilityRQ.Filter }
     *     
     */
    public AvailabilityRQ.Filter getFilter() {
        return filter;
    }

    /**
     * Sets the value of the filter property.
     * 
     * @param value
     *     allowed object is
     *     {@link AvailabilityRQ.Filter }
     *     
     */
    public void setFilter(AvailabilityRQ.Filter value) {
        this.filter = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="zone" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Destination {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "code")
        protected String code;
        @XmlAttribute(name = "zone")
        protected String zone;

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
         * Gets the value of the zone property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getZone() {
            return zone;
        }

        /**
         * Sets the value of the zone property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setZone(String value) {
            this.zone = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="minRate" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="maxRate" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="packaging" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="minCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="maxCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="paymentType" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Filter {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "minRate")
        protected String minRate;
        @XmlAttribute(name = "maxRate")
        protected String maxRate;
        @XmlAttribute(name = "packaging")
        protected String packaging;
        @XmlAttribute(name = "minCategory")
        protected String minCategory;
        @XmlAttribute(name = "maxCategory")
        protected String maxCategory;
        @XmlAttribute(name = "paymentType")
        protected String paymentType;

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
         * Gets the value of the minRate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMinRate() {
            return minRate;
        }

        /**
         * Sets the value of the minRate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMinRate(String value) {
            this.minRate = value;
        }

        /**
         * Gets the value of the maxRate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMaxRate() {
            return maxRate;
        }

        /**
         * Sets the value of the maxRate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMaxRate(String value) {
            this.maxRate = value;
        }

        /**
         * Gets the value of the packaging property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPackaging() {
            return packaging;
        }

        /**
         * Sets the value of the packaging property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPackaging(String value) {
            this.packaging = value;
        }

        /**
         * Gets the value of the minCategory property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMinCategory() {
            return minCategory;
        }

        /**
         * Sets the value of the minCategory property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMinCategory(String value) {
            this.minCategory = value;
        }

        /**
         * Gets the value of the maxCategory property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMaxCategory() {
            return maxCategory;
        }

        /**
         * Sets the value of the maxCategory property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMaxCategory(String value) {
            this.maxCategory = value;
        }

        /**
         * Gets the value of the paymentType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaymentType() {
            return paymentType;
        }

        /**
         * Sets the value of the paymentType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaymentType(String value) {
            this.paymentType = value;
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
     *         &lt;element name="hotel" type="{http://www.w3.org/2001/XMLSchema}short"/>
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
        "hotel"
    })
    public static class Hotels {

        protected short hotel;

        /**
         * Gets the value of the hotel property.
         * 
         */
        public short getHotel() {
            return hotel;
        }

        /**
         * Sets the value of the hotel property.
         * 
         */
        public void setHotel(short value) {
            this.hotel = value;
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
     *         &lt;element name="occupancy">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="paxes">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="pax">
     *                               &lt;complexType>
     *                                 &lt;simpleContent>
     *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                                     &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="age" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="surname" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                   &lt;/extension>
     *                                 &lt;/simpleContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="rooms" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="adults" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="children" type="{http://www.w3.org/2001/XMLSchema}byte" />
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
        "occupancy"
    })
    public static class Occupancies {

        @XmlElement(required = true)
        protected AvailabilityRQ.Occupancies.Occupancy occupancy;

        /**
         * Gets the value of the occupancy property.
         * 
         * @return
         *     possible object is
         *     {@link AvailabilityRQ.Occupancies.Occupancy }
         *     
         */
        public AvailabilityRQ.Occupancies.Occupancy getOccupancy() {
            return occupancy;
        }

        /**
         * Sets the value of the occupancy property.
         * 
         * @param value
         *     allowed object is
         *     {@link AvailabilityRQ.Occupancies.Occupancy }
         *     
         */
        public void setOccupancy(AvailabilityRQ.Occupancies.Occupancy value) {
            this.occupancy = value;
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
         *         &lt;element name="paxes">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="pax">
         *                     &lt;complexType>
         *                       &lt;simpleContent>
         *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                           &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="age" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="surname" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                         &lt;/extension>
         *                       &lt;/simpleContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="rooms" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="adults" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="children" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "paxes"
        })
        public static class Occupancy {

            @XmlElement(required = true)
            protected AvailabilityRQ.Occupancies.Occupancy.Paxes paxes;
            @XmlAttribute(name = "rooms")
            protected Byte rooms;
            @XmlAttribute(name = "adults")
            protected Byte adults;
            @XmlAttribute(name = "children")
            protected Byte children;

            /**
             * Gets the value of the paxes property.
             * 
             * @return
             *     possible object is
             *     {@link AvailabilityRQ.Occupancies.Occupancy.Paxes }
             *     
             */
            public AvailabilityRQ.Occupancies.Occupancy.Paxes getPaxes() {
                return paxes;
            }

            /**
             * Sets the value of the paxes property.
             * 
             * @param value
             *     allowed object is
             *     {@link AvailabilityRQ.Occupancies.Occupancy.Paxes }
             *     
             */
            public void setPaxes(AvailabilityRQ.Occupancies.Occupancy.Paxes value) {
                this.paxes = value;
            }

            /**
             * Gets the value of the rooms property.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getRooms() {
                return rooms;
            }

            /**
             * Sets the value of the rooms property.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setRooms(Byte value) {
                this.rooms = value;
            }

            /**
             * Gets the value of the adults property.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getAdults() {
                return adults;
            }

            /**
             * Sets the value of the adults property.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setAdults(Byte value) {
                this.adults = value;
            }

            /**
             * Gets the value of the children property.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getChildren() {
                return children;
            }

            /**
             * Sets the value of the children property.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setChildren(Byte value) {
                this.children = value;
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
             *         &lt;element name="pax">
             *           &lt;complexType>
             *             &lt;simpleContent>
             *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *                 &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="age" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="surname" type="{http://www.w3.org/2001/XMLSchema}string" />
             *               &lt;/extension>
             *             &lt;/simpleContent>
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
                "pax"
            })
            public static class Paxes {

                @XmlElement(required = true)
                protected AvailabilityRQ.Occupancies.Occupancy.Paxes.Pax pax;

                /**
                 * Gets the value of the pax property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link AvailabilityRQ.Occupancies.Occupancy.Paxes.Pax }
                 *     
                 */
                public AvailabilityRQ.Occupancies.Occupancy.Paxes.Pax getPax() {
                    return pax;
                }

                /**
                 * Sets the value of the pax property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link AvailabilityRQ.Occupancies.Occupancy.Paxes.Pax }
                 *     
                 */
                public void setPax(AvailabilityRQ.Occupancies.Occupancy.Paxes.Pax value) {
                    this.pax = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;simpleContent>
                 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
                 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="age" type="{http://www.w3.org/2001/XMLSchema}byte" />
                 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="surname" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *     &lt;/extension>
                 *   &lt;/simpleContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "value"
                })
                public static class Pax {

                    @XmlValue
                    protected String value;
                    @XmlAttribute(name = "type")
                    protected String type;
                    @XmlAttribute(name = "age")
                    protected Byte age;
                    @XmlAttribute(name = "name")
                    protected String name;
                    @XmlAttribute(name = "surname")
                    protected String surname;

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
                     * Gets the value of the type property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getType() {
                        return type;
                    }

                    /**
                     * Sets the value of the type property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setType(String value) {
                        this.type = value;
                    }

                    /**
                     * Gets the value of the age property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Byte }
                     *     
                     */
                    public Byte getAge() {
                        return age;
                    }

                    /**
                     * Sets the value of the age property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Byte }
                     *     
                     */
                    public void setAge(Byte value) {
                        this.age = value;
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
                     * Gets the value of the surname property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getSurname() {
                        return surname;
                    }

                    /**
                     * Sets the value of the surname property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setSurname(String value) {
                        this.surname = value;
                    }

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
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="checkIn" type="{http://www.w3.org/2001/XMLSchema}date" />
     *       &lt;attribute name="checkOut" type="{http://www.w3.org/2001/XMLSchema}date" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Stay {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "checkIn")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar checkIn;
        @XmlAttribute(name = "checkOut")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar checkOut;

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
         * Gets the value of the checkIn property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getCheckIn() {
            return checkIn;
        }

        /**
         * Sets the value of the checkIn property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setCheckIn(XMLGregorianCalendar value) {
            this.checkIn = value;
        }

        /**
         * Gets the value of the checkOut property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getCheckOut() {
            return checkOut;
        }

        /**
         * Sets the value of the checkOut property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setCheckOut(XMLGregorianCalendar value) {
            this.checkOut = value;
        }

    }

}
