//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.21 at 05:22:26 PM IST 
//


package com.bonton.utility.hotelbeds;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="holder"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="surname" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="rooms"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="room" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="paxes"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="pax" maxOccurs="unbounded"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;simpleContent&gt;
 *                                             &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                                               &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                               &lt;attribute name="age" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *                                               &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                               &lt;attribute name="surname" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                             &lt;/extension&gt;
 *                                           &lt;/simpleContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                           &lt;attribute name="rateKey" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="paymentData"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="paymentCard"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="cardType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="cardNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                             &lt;element name="expiryDate" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                             &lt;element name="cardCVC" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="contactData"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="clientReference" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "holder",
    "rooms",
    "paymentData",
    "clientReference"
})
@XmlRootElement(name = "bookingRQ")
public class BookingRQ {

    @XmlElement(required = true)
    protected BookingRQ.Holder holder;
    @XmlElement(required = true)
    protected BookingRQ.Rooms rooms;
    @XmlElement(required = true)
    protected BookingRQ.PaymentData paymentData;
    protected int clientReference;

    /**
     * Gets the value of the holder property.
     * 
     * @return
     *     possible object is
     *     {@link BookingRQ.Holder }
     *     
     */
    public BookingRQ.Holder getHolder() {
        return holder;
    }

    /**
     * Sets the value of the holder property.
     * 
     * @param value
     *     allowed object is
     *     {@link BookingRQ.Holder }
     *     
     */
    public void setHolder(BookingRQ.Holder value) {
        this.holder = value;
    }

    /**
     * Gets the value of the rooms property.
     * 
     * @return
     *     possible object is
     *     {@link BookingRQ.Rooms }
     *     
     */
    public BookingRQ.Rooms getRooms() {
        return rooms;
    }

    /**
     * Sets the value of the rooms property.
     * 
     * @param value
     *     allowed object is
     *     {@link BookingRQ.Rooms }
     *     
     */
    public void setRooms(BookingRQ.Rooms value) {
        this.rooms = value;
    }

    /**
     * Gets the value of the paymentData property.
     * 
     * @return
     *     possible object is
     *     {@link BookingRQ.PaymentData }
     *     
     */
    public BookingRQ.PaymentData getPaymentData() {
        return paymentData;
    }

    /**
     * Sets the value of the paymentData property.
     * 
     * @param value
     *     allowed object is
     *     {@link BookingRQ.PaymentData }
     *     
     */
    public void setPaymentData(BookingRQ.PaymentData value) {
        this.paymentData = value;
    }

    /**
     * Gets the value of the clientReference property.
     * 
     */
    public int getClientReference() {
        return clientReference;
    }

    /**
     * Sets the value of the clientReference property.
     * 
     */
    public void setClientReference(int value) {
        this.clientReference = value;
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
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="surname" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
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
    public static class Holder {

        @XmlValue
        protected String value;
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
     *         &lt;element name="paymentCard"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="cardType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="cardNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *                   &lt;element name="expiryDate" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *                   &lt;element name="cardCVC" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="contactData"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
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
        "paymentCard",
        "contactData"
    })
    public static class PaymentData {

        @XmlElement(required = true)
        protected BookingRQ.PaymentData.PaymentCard paymentCard;
        @XmlElement(required = true)
        protected BookingRQ.PaymentData.ContactData contactData;

        /**
         * Gets the value of the paymentCard property.
         * 
         * @return
         *     possible object is
         *     {@link BookingRQ.PaymentData.PaymentCard }
         *     
         */
        public BookingRQ.PaymentData.PaymentCard getPaymentCard() {
            return paymentCard;
        }

        /**
         * Sets the value of the paymentCard property.
         * 
         * @param value
         *     allowed object is
         *     {@link BookingRQ.PaymentData.PaymentCard }
         *     
         */
        public void setPaymentCard(BookingRQ.PaymentData.PaymentCard value) {
            this.paymentCard = value;
        }

        /**
         * Gets the value of the contactData property.
         * 
         * @return
         *     possible object is
         *     {@link BookingRQ.PaymentData.ContactData }
         *     
         */
        public BookingRQ.PaymentData.ContactData getContactData() {
            return contactData;
        }

        /**
         * Sets the value of the contactData property.
         * 
         * @param value
         *     allowed object is
         *     {@link BookingRQ.PaymentData.ContactData }
         *     
         */
        public void setContactData(BookingRQ.PaymentData.ContactData value) {
            this.contactData = value;
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
         *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
            "email",
            "phoneNumber"
        })
        public static class ContactData {

            @XmlElement(required = true)
            protected String email;
            protected int phoneNumber;

            /**
             * Gets the value of the email property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEmail() {
                return email;
            }

            /**
             * Sets the value of the email property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEmail(String value) {
                this.email = value;
            }

            /**
             * Gets the value of the phoneNumber property.
             * 
             */
            public int getPhoneNumber() {
                return phoneNumber;
            }

            /**
             * Sets the value of the phoneNumber property.
             * 
             */
            public void setPhoneNumber(int value) {
                this.phoneNumber = value;
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
         *         &lt;element name="cardType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="cardNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
         *         &lt;element name="expiryDate" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
         *         &lt;element name="cardCVC" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
            "cardType",
            "cardNumber",
            "expiryDate",
            "cardCVC"
        })
        public static class PaymentCard {

            @XmlElement(required = true)
            protected String cardType;
            protected int cardNumber;
            protected int expiryDate;
            protected int cardCVC;

            /**
             * Gets the value of the cardType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCardType() {
                return cardType;
            }

            /**
             * Sets the value of the cardType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCardType(String value) {
                this.cardType = value;
            }

            /**
             * Gets the value of the cardNumber property.
             * 
             */
            public int getCardNumber() {
                return cardNumber;
            }

            /**
             * Sets the value of the cardNumber property.
             * 
             */
            public void setCardNumber(int value) {
                this.cardNumber = value;
            }

            /**
             * Gets the value of the expiryDate property.
             * 
             */
            public int getExpiryDate() {
                return expiryDate;
            }

            /**
             * Sets the value of the expiryDate property.
             * 
             */
            public void setExpiryDate(int value) {
                this.expiryDate = value;
            }

            /**
             * Gets the value of the cardCVC property.
             * 
             */
            public int getCardCVC() {
                return cardCVC;
            }

            /**
             * Sets the value of the cardCVC property.
             * 
             */
            public void setCardCVC(int value) {
                this.cardCVC = value;
            }

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
     *         &lt;element name="room" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="paxes"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="pax" maxOccurs="unbounded"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;simpleContent&gt;
     *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *                                     &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                                     &lt;attribute name="age" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
     *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                                     &lt;attribute name="surname" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                                   &lt;/extension&gt;
     *                                 &lt;/simpleContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attribute name="rateKey" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
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
        "room"
    })
    public static class Rooms {

        @XmlElement(required = true)
        protected List<BookingRQ.Rooms.Room> room;

        /**
         * Gets the value of the room property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the room property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRoom().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BookingRQ.Rooms.Room }
         * 
         * 
         */
        public List<BookingRQ.Rooms.Room> getRoom() {
            if (room == null) {
                room = new ArrayList<BookingRQ.Rooms.Room>();
            }
            return this.room;
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
         *         &lt;element name="paxes"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="pax" maxOccurs="unbounded"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;simpleContent&gt;
         *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
         *                           &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                           &lt;attribute name="age" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
         *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                           &lt;attribute name="surname" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                         &lt;/extension&gt;
         *                       &lt;/simpleContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *       &lt;attribute name="rateKey" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "paxes"
        })
        public static class Room {

            @XmlElement(required = true)
            protected BookingRQ.Rooms.Room.Paxes paxes;
            @XmlAttribute(name = "rateKey")
            protected String rateKey;

            /**
             * Gets the value of the paxes property.
             * 
             * @return
             *     possible object is
             *     {@link BookingRQ.Rooms.Room.Paxes }
             *     
             */
            public BookingRQ.Rooms.Room.Paxes getPaxes() {
                return paxes;
            }

            /**
             * Sets the value of the paxes property.
             * 
             * @param value
             *     allowed object is
             *     {@link BookingRQ.Rooms.Room.Paxes }
             *     
             */
            public void setPaxes(BookingRQ.Rooms.Room.Paxes value) {
                this.paxes = value;
            }

            /**
             * Gets the value of the rateKey property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRateKey() {
                return rateKey;
            }

            /**
             * Sets the value of the rateKey property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRateKey(String value) {
                this.rateKey = value;
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
             *         &lt;element name="pax" maxOccurs="unbounded"&gt;
             *           &lt;complexType&gt;
             *             &lt;simpleContent&gt;
             *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
             *                 &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *                 &lt;attribute name="age" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
             *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *                 &lt;attribute name="surname" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
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
                "pax"
            })
            public static class Paxes {

                @XmlElement(required = true)
                protected List<BookingRQ.Rooms.Room.Paxes.Pax> pax;

                /**
                 * Gets the value of the pax property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the pax property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getPax().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link BookingRQ.Rooms.Room.Paxes.Pax }
                 * 
                 * 
                 */
                public List<BookingRQ.Rooms.Room.Paxes.Pax> getPax() {
                    if (pax == null) {
                        pax = new ArrayList<BookingRQ.Rooms.Room.Paxes.Pax>();
                    }
                    return this.pax;
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
                 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
                 *       &lt;attribute name="age" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
                 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
                 *       &lt;attribute name="surname" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
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
                public static class Pax {

                    @XmlValue
                    protected String value;
                    @XmlAttribute(name = "type")
                    protected String type;
                    @XmlAttribute(name = "age")
                    protected Integer age;
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
                     *     {@link Integer }
                     *     
                     */
                    public Integer getAge() {
                        return age;
                    }

                    /**
                     * Sets the value of the age property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Integer }
                     *     
                     */
                    public void setAge(Integer value) {
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

}