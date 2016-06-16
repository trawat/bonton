
package com.desia.artifacts.search;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TPA_ExtensionsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TPA_ExtensionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opentravel.org/OTA/2003/05}Pagination" minOccurs="0"/>
 *         &lt;element ref="{http://www.opentravel.org/OTA/2003/05}HotelBasicInformation" minOccurs="0"/>
 *         &lt;element name="CardHolderFirstName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CardHolderSurname">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DelayedPayment">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ResGuest">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                 &lt;/sequence>
 *                 &lt;attribute name="IsOccupant" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="IsTattooInRPH" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Rate" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Base" type="{http://www.opentravel.org/OTA/2003/05}TotalType" minOccurs="0"/>
 *                   &lt;element name="AdditionalGuestAmounts" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="AdditionalGuestAmount" type="{http://www.opentravel.org/OTA/2003/05}AdditionalGuestAmountType" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="AmountAfterTax" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                           &lt;attribute name="AmountBeforeTax" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Fees" type="{http://www.opentravel.org/OTA/2003/05}FeesType" minOccurs="0"/>
 *                   &lt;element name="Discount" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://www.opentravel.org/OTA/2003/05}DiscountType">
 *                           &lt;sequence>
 *                           &lt;/sequence>
 *                           &lt;attribute name="AppliesTo" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="ItemRPH" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="BaseAdultOccupancy" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="BaseChildOccupancy" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="Bookable" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="NonBookableReason" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="RatePlanCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="RoomTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RoomType" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                 &lt;/sequence>
 *                 &lt;attribute name="maxAdult" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="maxChild" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="maxChildAge" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="maxGuest" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="maxInfant" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="minChildAge" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="propertyLevel" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="smoking" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="UserAuthentication" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                 &lt;/sequence>
 *                 &lt;attribute name="password" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="propertyId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="username" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DeepLinkInformation" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                 &lt;/sequence>
 *                 &lt;attribute name="overviewURL" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SeoInformation" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Destinations" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Destination" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="OtherDestinations" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="OtherDestination" maxOccurs="unbounded" minOccurs="0">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                         &lt;/sequence>
 *                                                         &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                                         &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                                         &lt;attribute name="URL" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="AvgReviewRating" type="{http://www.w3.org/2001/XMLSchema}float" />
 *                                     &lt;attribute name="DestinationDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="DestinationId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="DestinationLatLong" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="DestinationName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="DestinationPOI" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="DestinationParentId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="DestinationSeoId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="DestinationTitle" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="GuruImageVersion" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                                     &lt;attribute name="GuruName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="GuruTip" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="HeroImageDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="HeroImageName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="HeroImageVersion" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                                     &lt;attribute name="MetaTagDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="MetaTagKeywords" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="POIMandatoryFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                     &lt;attribute name="TotalReviewCount" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                                     &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="SeoPageData" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="OtherSeoPages" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="OtherSeoPage" maxOccurs="unbounded" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                               &lt;/sequence>
 *                                               &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="URL" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="HeroImageDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="HeroImageName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="HeroImageVersion" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="MetaTagDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="MetaTagKeywords" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="PageContent" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="PageId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="PageSeoId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="PageTitle" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="Summary" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="CountryName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="CountrySeoId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="DestinationType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="SeoPageType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="StateName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="StateSeoId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="TotalNumberOfProperties" type="{http://www.w3.org/2001/XMLSchema}int" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CancelDates" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Dates" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://www.opentravel.org/OTA/2003/05}HotelsInfo" minOccurs="0"/>
 *         &lt;element name="Deals" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Deal" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                           &lt;/sequence>
 *                           &lt;attribute name="ApplicableNights" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="ApplyTo" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="MLOS" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="StayDateFrom" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="StayDateTo" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="Value1" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="Value2" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Promotion" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                 &lt;/sequence>
 *                 &lt;attribute name="CLPApplied" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="CancellationPolicyId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AdditionalGuests" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="AdditionalGuest" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                           &lt;/sequence>
 *                           &lt;attribute name="adults" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="children" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="roomNo" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DiscountCouponDisplayIndicator" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AgentInformation" type="{http://www.opentravel.org/OTA/2003/05}AgentType" minOccurs="0"/>
 *         &lt;element name="BestRatePlan" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="GPOProfitAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="LowestRatePlanId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="PkgSavingsAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="RatePlanCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RefundAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="RoomTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SeoEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="StopSell" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPA_ExtensionsType", propOrder = {
    "pagination",
    "hotelBasicInformation",
    "cardHolderFirstName",
    "cardHolderSurname",
    "delayedPayment",
    "resGuest",
    "rate",
    "roomType",
    "userAuthentication",
    "deepLinkInformation",
    "seoInformation",
    "cancelDates",
    "hotelsInfo",
    "deals",
    "promotion",
    "additionalGuests",
    "discountCouponDisplayIndicator",
    "agentInformation",
    "bestRatePlan"
})
public class TPAExtensionsType {

    @XmlElement(name = "Pagination")
    protected Pagination pagination;
    @XmlElement(name = "HotelBasicInformation")
    protected HotelBasicInformation hotelBasicInformation;
    @XmlElement(name = "CardHolderFirstName", required = true)
    protected String cardHolderFirstName;
    @XmlElement(name = "CardHolderSurname", required = true)
    protected String cardHolderSurname;
    @XmlElement(name = "DelayedPayment", required = true)
    protected String delayedPayment;
    @XmlElement(name = "ResGuest", required = true)
    protected TPAExtensionsType.ResGuest resGuest;
    @XmlElement(name = "Rate")
    protected TPAExtensionsType.Rate rate;
    @XmlElement(name = "RoomType")
    protected TPAExtensionsType.RoomType roomType;
    @XmlElement(name = "UserAuthentication")
    protected TPAExtensionsType.UserAuthentication userAuthentication;
    @XmlElement(name = "DeepLinkInformation")
    protected TPAExtensionsType.DeepLinkInformation deepLinkInformation;
    @XmlElement(name = "SeoInformation")
    protected TPAExtensionsType.SeoInformation seoInformation;
    @XmlElement(name = "CancelDates")
    protected TPAExtensionsType.CancelDates cancelDates;
    @XmlElement(name = "HotelsInfo")
    protected HotelsInfo hotelsInfo;
    @XmlElement(name = "Deals")
    protected TPAExtensionsType.Deals deals;
    @XmlElement(name = "Promotion")
    protected TPAExtensionsType.Promotion promotion;
    @XmlElement(name = "AdditionalGuests")
    protected TPAExtensionsType.AdditionalGuests additionalGuests;
    @XmlElement(name = "DiscountCouponDisplayIndicator")
    protected TPAExtensionsType.DiscountCouponDisplayIndicator discountCouponDisplayIndicator;
    @XmlElement(name = "AgentInformation")
    protected AgentType agentInformation;
    @XmlElement(name = "BestRatePlan")
    protected Boolean bestRatePlan;
    @XmlAttribute(name = "GPOProfitAmount")
    protected BigDecimal gpoProfitAmount;
    @XmlAttribute(name = "LowestRatePlanId")
    protected String lowestRatePlanId;
    @XmlAttribute(name = "PkgSavingsAmount")
    protected BigDecimal pkgSavingsAmount;
    @XmlAttribute(name = "RatePlanCode")
    protected String ratePlanCode;
    @XmlAttribute(name = "RefundAmount")
    protected BigDecimal refundAmount;
    @XmlAttribute(name = "RoomTypeCode")
    protected String roomTypeCode;
    @XmlAttribute(name = "SeoEnabled")
    protected Boolean seoEnabled;
    @XmlAttribute(name = "StopSell")
    protected Boolean stopSell;

    /**
     * Gets the value of the pagination property.
     * 
     * @return
     *     possible object is
     *     {@link Pagination }
     *     
     */
    public Pagination getPagination() {
        return pagination;
    }

    /**
     * Sets the value of the pagination property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pagination }
     *     
     */
    public void setPagination(Pagination value) {
        this.pagination = value;
    }

    /**
     * Gets the value of the hotelBasicInformation property.
     * 
     * @return
     *     possible object is
     *     {@link HotelBasicInformation }
     *     
     */
    public HotelBasicInformation getHotelBasicInformation() {
        return hotelBasicInformation;
    }

    /**
     * Sets the value of the hotelBasicInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelBasicInformation }
     *     
     */
    public void setHotelBasicInformation(HotelBasicInformation value) {
        this.hotelBasicInformation = value;
    }

    /**
     * Gets the value of the cardHolderFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardHolderFirstName() {
        return cardHolderFirstName;
    }

    /**
     * Sets the value of the cardHolderFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardHolderFirstName(String value) {
        this.cardHolderFirstName = value;
    }

    /**
     * Gets the value of the cardHolderSurname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardHolderSurname() {
        return cardHolderSurname;
    }

    /**
     * Sets the value of the cardHolderSurname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardHolderSurname(String value) {
        this.cardHolderSurname = value;
    }

    /**
     * Gets the value of the delayedPayment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelayedPayment() {
        return delayedPayment;
    }

    /**
     * Sets the value of the delayedPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelayedPayment(String value) {
        this.delayedPayment = value;
    }

    /**
     * Gets the value of the resGuest property.
     * 
     * @return
     *     possible object is
     *     {@link TPAExtensionsType.ResGuest }
     *     
     */
    public TPAExtensionsType.ResGuest getResGuest() {
        return resGuest;
    }

    /**
     * Sets the value of the resGuest property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPAExtensionsType.ResGuest }
     *     
     */
    public void setResGuest(TPAExtensionsType.ResGuest value) {
        this.resGuest = value;
    }

    /**
     * Gets the value of the rate property.
     * 
     * @return
     *     possible object is
     *     {@link TPAExtensionsType.Rate }
     *     
     */
    public TPAExtensionsType.Rate getRate() {
        return rate;
    }

    /**
     * Sets the value of the rate property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPAExtensionsType.Rate }
     *     
     */
    public void setRate(TPAExtensionsType.Rate value) {
        this.rate = value;
    }

    /**
     * Gets the value of the roomType property.
     * 
     * @return
     *     possible object is
     *     {@link TPAExtensionsType.RoomType }
     *     
     */
    public TPAExtensionsType.RoomType getRoomType() {
        return roomType;
    }

    /**
     * Sets the value of the roomType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPAExtensionsType.RoomType }
     *     
     */
    public void setRoomType(TPAExtensionsType.RoomType value) {
        this.roomType = value;
    }

    /**
     * Gets the value of the userAuthentication property.
     * 
     * @return
     *     possible object is
     *     {@link TPAExtensionsType.UserAuthentication }
     *     
     */
    public TPAExtensionsType.UserAuthentication getUserAuthentication() {
        return userAuthentication;
    }

    /**
     * Sets the value of the userAuthentication property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPAExtensionsType.UserAuthentication }
     *     
     */
    public void setUserAuthentication(TPAExtensionsType.UserAuthentication value) {
        this.userAuthentication = value;
    }

    /**
     * Gets the value of the deepLinkInformation property.
     * 
     * @return
     *     possible object is
     *     {@link TPAExtensionsType.DeepLinkInformation }
     *     
     */
    public TPAExtensionsType.DeepLinkInformation getDeepLinkInformation() {
        return deepLinkInformation;
    }

    /**
     * Sets the value of the deepLinkInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPAExtensionsType.DeepLinkInformation }
     *     
     */
    public void setDeepLinkInformation(TPAExtensionsType.DeepLinkInformation value) {
        this.deepLinkInformation = value;
    }

    /**
     * Gets the value of the seoInformation property.
     * 
     * @return
     *     possible object is
     *     {@link TPAExtensionsType.SeoInformation }
     *     
     */
    public TPAExtensionsType.SeoInformation getSeoInformation() {
        return seoInformation;
    }

    /**
     * Sets the value of the seoInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPAExtensionsType.SeoInformation }
     *     
     */
    public void setSeoInformation(TPAExtensionsType.SeoInformation value) {
        this.seoInformation = value;
    }

    /**
     * Gets the value of the cancelDates property.
     * 
     * @return
     *     possible object is
     *     {@link TPAExtensionsType.CancelDates }
     *     
     */
    public TPAExtensionsType.CancelDates getCancelDates() {
        return cancelDates;
    }

    /**
     * Sets the value of the cancelDates property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPAExtensionsType.CancelDates }
     *     
     */
    public void setCancelDates(TPAExtensionsType.CancelDates value) {
        this.cancelDates = value;
    }

    /**
     * Gets the value of the hotelsInfo property.
     * 
     * @return
     *     possible object is
     *     {@link HotelsInfo }
     *     
     */
    public HotelsInfo getHotelsInfo() {
        return hotelsInfo;
    }

    /**
     * Sets the value of the hotelsInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelsInfo }
     *     
     */
    public void setHotelsInfo(HotelsInfo value) {
        this.hotelsInfo = value;
    }

    /**
     * Gets the value of the deals property.
     * 
     * @return
     *     possible object is
     *     {@link TPAExtensionsType.Deals }
     *     
     */
    public TPAExtensionsType.Deals getDeals() {
        return deals;
    }

    /**
     * Sets the value of the deals property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPAExtensionsType.Deals }
     *     
     */
    public void setDeals(TPAExtensionsType.Deals value) {
        this.deals = value;
    }

    /**
     * Gets the value of the promotion property.
     * 
     * @return
     *     possible object is
     *     {@link TPAExtensionsType.Promotion }
     *     
     */
    public TPAExtensionsType.Promotion getPromotion() {
        return promotion;
    }

    /**
     * Sets the value of the promotion property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPAExtensionsType.Promotion }
     *     
     */
    public void setPromotion(TPAExtensionsType.Promotion value) {
        this.promotion = value;
    }

    /**
     * Gets the value of the additionalGuests property.
     * 
     * @return
     *     possible object is
     *     {@link TPAExtensionsType.AdditionalGuests }
     *     
     */
    public TPAExtensionsType.AdditionalGuests getAdditionalGuests() {
        return additionalGuests;
    }

    /**
     * Sets the value of the additionalGuests property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPAExtensionsType.AdditionalGuests }
     *     
     */
    public void setAdditionalGuests(TPAExtensionsType.AdditionalGuests value) {
        this.additionalGuests = value;
    }

    /**
     * Gets the value of the discountCouponDisplayIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link TPAExtensionsType.DiscountCouponDisplayIndicator }
     *     
     */
    public TPAExtensionsType.DiscountCouponDisplayIndicator getDiscountCouponDisplayIndicator() {
        return discountCouponDisplayIndicator;
    }

    /**
     * Sets the value of the discountCouponDisplayIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPAExtensionsType.DiscountCouponDisplayIndicator }
     *     
     */
    public void setDiscountCouponDisplayIndicator(TPAExtensionsType.DiscountCouponDisplayIndicator value) {
        this.discountCouponDisplayIndicator = value;
    }

    /**
     * Gets the value of the agentInformation property.
     * 
     * @return
     *     possible object is
     *     {@link AgentType }
     *     
     */
    public AgentType getAgentInformation() {
        return agentInformation;
    }

    /**
     * Sets the value of the agentInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link AgentType }
     *     
     */
    public void setAgentInformation(AgentType value) {
        this.agentInformation = value;
    }

    /**
     * Gets the value of the bestRatePlan property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBestRatePlan() {
        return bestRatePlan;
    }

    /**
     * Sets the value of the bestRatePlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBestRatePlan(Boolean value) {
        this.bestRatePlan = value;
    }

    /**
     * Gets the value of the gpoProfitAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGPOProfitAmount() {
        return gpoProfitAmount;
    }

    /**
     * Sets the value of the gpoProfitAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGPOProfitAmount(BigDecimal value) {
        this.gpoProfitAmount = value;
    }

    /**
     * Gets the value of the lowestRatePlanId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLowestRatePlanId() {
        return lowestRatePlanId;
    }

    /**
     * Sets the value of the lowestRatePlanId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLowestRatePlanId(String value) {
        this.lowestRatePlanId = value;
    }

    /**
     * Gets the value of the pkgSavingsAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPkgSavingsAmount() {
        return pkgSavingsAmount;
    }

    /**
     * Sets the value of the pkgSavingsAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPkgSavingsAmount(BigDecimal value) {
        this.pkgSavingsAmount = value;
    }

    /**
     * Gets the value of the ratePlanCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRatePlanCode() {
        return ratePlanCode;
    }

    /**
     * Sets the value of the ratePlanCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRatePlanCode(String value) {
        this.ratePlanCode = value;
    }

    /**
     * Gets the value of the refundAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    /**
     * Sets the value of the refundAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRefundAmount(BigDecimal value) {
        this.refundAmount = value;
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
     * Gets the value of the seoEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSeoEnabled() {
        return seoEnabled;
    }

    /**
     * Sets the value of the seoEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSeoEnabled(Boolean value) {
        this.seoEnabled = value;
    }

    /**
     * Gets the value of the stopSell property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStopSell() {
        return stopSell;
    }

    /**
     * Sets the value of the stopSell property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStopSell(Boolean value) {
        this.stopSell = value;
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
     *         &lt;element name="AdditionalGuest" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                 &lt;/sequence>
     *                 &lt;attribute name="adults" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="children" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="roomNo" type="{http://www.w3.org/2001/XMLSchema}int" />
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
        "additionalGuest"
    })
    public static class AdditionalGuests {

        @XmlElement(name = "AdditionalGuest", required = true)
        protected List<TPAExtensionsType.AdditionalGuests.AdditionalGuest> additionalGuest;

        /**
         * Gets the value of the additionalGuest property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the additionalGuest property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAdditionalGuest().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TPAExtensionsType.AdditionalGuests.AdditionalGuest }
         * 
         * 
         */
        public List<TPAExtensionsType.AdditionalGuests.AdditionalGuest> getAdditionalGuest() {
            if (additionalGuest == null) {
                additionalGuest = new ArrayList<TPAExtensionsType.AdditionalGuests.AdditionalGuest>();
            }
            return this.additionalGuest;
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
         *       &lt;attribute name="adults" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="children" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="roomNo" type="{http://www.w3.org/2001/XMLSchema}int" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class AdditionalGuest {

            @XmlAttribute(name = "adults")
            protected Integer adults;
            @XmlAttribute(name = "children")
            protected Integer children;
            @XmlAttribute(name = "roomNo")
            protected Integer roomNo;

            /**
             * Gets the value of the adults property.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getAdults() {
                return adults;
            }

            /**
             * Sets the value of the adults property.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setAdults(Integer value) {
                this.adults = value;
            }

            /**
             * Gets the value of the children property.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getChildren() {
                return children;
            }

            /**
             * Sets the value of the children property.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setChildren(Integer value) {
                this.children = value;
            }

            /**
             * Gets the value of the roomNo property.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getRoomNo() {
                return roomNo;
            }

            /**
             * Sets the value of the roomNo property.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setRoomNo(Integer value) {
                this.roomNo = value;
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
     *         &lt;element name="Dates" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
        "dates"
    })
    public static class CancelDates {

        @XmlElement(name = "Dates", required = true)
        protected List<String> dates;

        /**
         * Gets the value of the dates property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the dates property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDates().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getDates() {
            if (dates == null) {
                dates = new ArrayList<String>();
            }
            return this.dates;
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
     *         &lt;element name="Deal" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                 &lt;/sequence>
     *                 &lt;attribute name="ApplicableNights" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="ApplyTo" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="MLOS" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="StayDateFrom" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="StayDateTo" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="Value1" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="Value2" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        "deal"
    })
    public static class Deals {

        @XmlElement(name = "Deal")
        protected List<TPAExtensionsType.Deals.Deal> deal;

        /**
         * Gets the value of the deal property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the deal property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDeal().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TPAExtensionsType.Deals.Deal }
         * 
         * 
         */
        public List<TPAExtensionsType.Deals.Deal> getDeal() {
            if (deal == null) {
                deal = new ArrayList<TPAExtensionsType.Deals.Deal>();
            }
            return this.deal;
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
         *       &lt;attribute name="ApplicableNights" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="ApplyTo" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="MLOS" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="StayDateFrom" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="StayDateTo" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="Value1" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="Value2" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Deal {

            @XmlAttribute(name = "ApplicableNights")
            protected String applicableNights;
            @XmlAttribute(name = "ApplyTo")
            protected String applyTo;
            @XmlAttribute(name = "MLOS")
            protected String mlos;
            @XmlAttribute(name = "StayDateFrom")
            protected String stayDateFrom;
            @XmlAttribute(name = "StayDateTo")
            protected String stayDateTo;
            @XmlAttribute(name = "Type")
            protected String type;
            @XmlAttribute(name = "Value1")
            protected String value1;
            @XmlAttribute(name = "Value2")
            protected String value2;

            /**
             * Gets the value of the applicableNights property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getApplicableNights() {
                return applicableNights;
            }

            /**
             * Sets the value of the applicableNights property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setApplicableNights(String value) {
                this.applicableNights = value;
            }

            /**
             * Gets the value of the applyTo property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getApplyTo() {
                return applyTo;
            }

            /**
             * Sets the value of the applyTo property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setApplyTo(String value) {
                this.applyTo = value;
            }

            /**
             * Gets the value of the mlos property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMLOS() {
                return mlos;
            }

            /**
             * Sets the value of the mlos property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMLOS(String value) {
                this.mlos = value;
            }

            /**
             * Gets the value of the stayDateFrom property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStayDateFrom() {
                return stayDateFrom;
            }

            /**
             * Sets the value of the stayDateFrom property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStayDateFrom(String value) {
                this.stayDateFrom = value;
            }

            /**
             * Gets the value of the stayDateTo property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStayDateTo() {
                return stayDateTo;
            }

            /**
             * Sets the value of the stayDateTo property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStayDateTo(String value) {
                this.stayDateTo = value;
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
             * Gets the value of the value1 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue1() {
                return value1;
            }

            /**
             * Sets the value of the value1 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue1(String value) {
                this.value1 = value;
            }

            /**
             * Gets the value of the value2 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue2() {
                return value2;
            }

            /**
             * Sets the value of the value2 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue2(String value) {
                this.value2 = value;
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
     *       &lt;attribute name="overviewURL" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class DeepLinkInformation {

        @XmlAttribute(name = "overviewURL")
        protected String overviewURL;

        /**
         * Gets the value of the overviewURL property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOverviewURL() {
            return overviewURL;
        }

        /**
         * Sets the value of the overviewURL property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOverviewURL(String value) {
            this.overviewURL = value;
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
     *       &lt;attribute name="Enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class DiscountCouponDisplayIndicator {

        @XmlAttribute(name = "Enabled")
        protected Boolean enabled;

        /**
         * Gets the value of the enabled property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isEnabled() {
            return enabled;
        }

        /**
         * Sets the value of the enabled property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setEnabled(Boolean value) {
            this.enabled = value;
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
     *       &lt;attribute name="CLPApplied" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="CancellationPolicyId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Promotion {

        @XmlAttribute(name = "CLPApplied")
        protected Boolean clpApplied;
        @XmlAttribute(name = "CancellationPolicyId")
        protected String cancellationPolicyId;
        @XmlAttribute(name = "Id")
        protected String id;
        @XmlAttribute(name = "Name")
        protected String name;
        @XmlAttribute(name = "Type")
        protected String type;

        /**
         * Gets the value of the clpApplied property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isCLPApplied() {
            return clpApplied;
        }

        /**
         * Sets the value of the clpApplied property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setCLPApplied(Boolean value) {
            this.clpApplied = value;
        }

        /**
         * Gets the value of the cancellationPolicyId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCancellationPolicyId() {
            return cancellationPolicyId;
        }

        /**
         * Sets the value of the cancellationPolicyId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCancellationPolicyId(String value) {
            this.cancellationPolicyId = value;
        }

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
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
        public void setId(String value) {
            this.id = value;
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
     *         &lt;element name="Base" type="{http://www.opentravel.org/OTA/2003/05}TotalType" minOccurs="0"/>
     *         &lt;element name="AdditionalGuestAmounts" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="AdditionalGuestAmount" type="{http://www.opentravel.org/OTA/2003/05}AdditionalGuestAmountType" maxOccurs="unbounded"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="AmountAfterTax" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *                 &lt;attribute name="AmountBeforeTax" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Fees" type="{http://www.opentravel.org/OTA/2003/05}FeesType" minOccurs="0"/>
     *         &lt;element name="Discount" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}DiscountType">
     *                 &lt;sequence>
     *                 &lt;/sequence>
     *                 &lt;attribute name="AppliesTo" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="ItemRPH" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="BaseAdultOccupancy" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *       &lt;attribute name="BaseChildOccupancy" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *       &lt;attribute name="Bookable" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="NonBookableReason" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="RatePlanCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="RoomTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "base",
        "additionalGuestAmounts",
        "fees",
        "discount"
    })
    public static class Rate {

        @XmlElement(name = "Base")
        protected TotalType base;
        @XmlElement(name = "AdditionalGuestAmounts")
        protected TPAExtensionsType.Rate.AdditionalGuestAmounts additionalGuestAmounts;
        @XmlElement(name = "Fees")
        protected FeesType fees;
        @XmlElement(name = "Discount")
        protected List<TPAExtensionsType.Rate.Discount> discount;
        @XmlAttribute(name = "BaseAdultOccupancy")
        protected BigInteger baseAdultOccupancy;
        @XmlAttribute(name = "BaseChildOccupancy")
        protected BigInteger baseChildOccupancy;
        @XmlAttribute(name = "Bookable")
        protected Boolean bookable;
        @XmlAttribute(name = "NonBookableReason")
        protected String nonBookableReason;
        @XmlAttribute(name = "RatePlanCode")
        protected String ratePlanCode;
        @XmlAttribute(name = "RoomTypeCode")
        protected String roomTypeCode;
        @XmlAttribute(name = "Type")
        protected String type;

        /**
         * Gets the value of the base property.
         * 
         * @return
         *     possible object is
         *     {@link TotalType }
         *     
         */
        public TotalType getBase() {
            return base;
        }

        /**
         * Sets the value of the base property.
         * 
         * @param value
         *     allowed object is
         *     {@link TotalType }
         *     
         */
        public void setBase(TotalType value) {
            this.base = value;
        }

        /**
         * Gets the value of the additionalGuestAmounts property.
         * 
         * @return
         *     possible object is
         *     {@link TPAExtensionsType.Rate.AdditionalGuestAmounts }
         *     
         */
        public TPAExtensionsType.Rate.AdditionalGuestAmounts getAdditionalGuestAmounts() {
            return additionalGuestAmounts;
        }

        /**
         * Sets the value of the additionalGuestAmounts property.
         * 
         * @param value
         *     allowed object is
         *     {@link TPAExtensionsType.Rate.AdditionalGuestAmounts }
         *     
         */
        public void setAdditionalGuestAmounts(TPAExtensionsType.Rate.AdditionalGuestAmounts value) {
            this.additionalGuestAmounts = value;
        }

        /**
         * Gets the value of the fees property.
         * 
         * @return
         *     possible object is
         *     {@link FeesType }
         *     
         */
        public FeesType getFees() {
            return fees;
        }

        /**
         * Sets the value of the fees property.
         * 
         * @param value
         *     allowed object is
         *     {@link FeesType }
         *     
         */
        public void setFees(FeesType value) {
            this.fees = value;
        }

        /**
         * Gets the value of the discount property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the discount property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDiscount().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TPAExtensionsType.Rate.Discount }
         * 
         * 
         */
        public List<TPAExtensionsType.Rate.Discount> getDiscount() {
            if (discount == null) {
                discount = new ArrayList<TPAExtensionsType.Rate.Discount>();
            }
            return this.discount;
        }

        /**
         * Gets the value of the baseAdultOccupancy property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getBaseAdultOccupancy() {
            return baseAdultOccupancy;
        }

        /**
         * Sets the value of the baseAdultOccupancy property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setBaseAdultOccupancy(BigInteger value) {
            this.baseAdultOccupancy = value;
        }

        /**
         * Gets the value of the baseChildOccupancy property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getBaseChildOccupancy() {
            return baseChildOccupancy;
        }

        /**
         * Sets the value of the baseChildOccupancy property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setBaseChildOccupancy(BigInteger value) {
            this.baseChildOccupancy = value;
        }

        /**
         * Gets the value of the bookable property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isBookable() {
            return bookable;
        }

        /**
         * Sets the value of the bookable property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setBookable(Boolean value) {
            this.bookable = value;
        }

        /**
         * Gets the value of the nonBookableReason property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNonBookableReason() {
            return nonBookableReason;
        }

        /**
         * Sets the value of the nonBookableReason property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNonBookableReason(String value) {
            this.nonBookableReason = value;
        }

        /**
         * Gets the value of the ratePlanCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRatePlanCode() {
            return ratePlanCode;
        }

        /**
         * Sets the value of the ratePlanCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRatePlanCode(String value) {
            this.ratePlanCode = value;
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
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="AdditionalGuestAmount" type="{http://www.opentravel.org/OTA/2003/05}AdditionalGuestAmountType" maxOccurs="unbounded"/>
         *       &lt;/sequence>
         *       &lt;attribute name="AmountAfterTax" type="{http://www.w3.org/2001/XMLSchema}decimal" />
         *       &lt;attribute name="AmountBeforeTax" type="{http://www.w3.org/2001/XMLSchema}decimal" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "additionalGuestAmount"
        })
        public static class AdditionalGuestAmounts {

            @XmlElement(name = "AdditionalGuestAmount", required = true)
            protected List<AdditionalGuestAmountType> additionalGuestAmount;
            @XmlAttribute(name = "AmountAfterTax")
            protected BigDecimal amountAfterTax;
            @XmlAttribute(name = "AmountBeforeTax")
            protected BigDecimal amountBeforeTax;

            /**
             * Gets the value of the additionalGuestAmount property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the additionalGuestAmount property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getAdditionalGuestAmount().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link AdditionalGuestAmountType }
             * 
             * 
             */
            public List<AdditionalGuestAmountType> getAdditionalGuestAmount() {
                if (additionalGuestAmount == null) {
                    additionalGuestAmount = new ArrayList<AdditionalGuestAmountType>();
                }
                return this.additionalGuestAmount;
            }

            /**
             * Gets the value of the amountAfterTax property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getAmountAfterTax() {
                return amountAfterTax;
            }

            /**
             * Sets the value of the amountAfterTax property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setAmountAfterTax(BigDecimal value) {
                this.amountAfterTax = value;
            }

            /**
             * Gets the value of the amountBeforeTax property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getAmountBeforeTax() {
                return amountBeforeTax;
            }

            /**
             * Sets the value of the amountBeforeTax property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setAmountBeforeTax(BigDecimal value) {
                this.amountBeforeTax = value;
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
         *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}DiscountType">
         *       &lt;sequence>
         *       &lt;/sequence>
         *       &lt;attribute name="AppliesTo" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="ItemRPH" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Discount
            extends DiscountType
        {

            @XmlAttribute(name = "AppliesTo")
            protected String appliesTo;
            @XmlAttribute(name = "ItemRPH")
            protected String itemRPH;

            /**
             * Gets the value of the appliesTo property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAppliesTo() {
                return appliesTo;
            }

            /**
             * Sets the value of the appliesTo property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAppliesTo(String value) {
                this.appliesTo = value;
            }

            /**
             * Gets the value of the itemRPH property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getItemRPH() {
                return itemRPH;
            }

            /**
             * Sets the value of the itemRPH property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setItemRPH(String value) {
                this.itemRPH = value;
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
     *       &lt;attribute name="IsOccupant" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="IsTattooInRPH" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ResGuest {

        @XmlAttribute(name = "IsOccupant")
        protected String isOccupant;
        @XmlAttribute(name = "IsTattooInRPH")
        protected String isTattooInRPH;

        /**
         * Gets the value of the isOccupant property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIsOccupant() {
            return isOccupant;
        }

        /**
         * Sets the value of the isOccupant property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIsOccupant(String value) {
            this.isOccupant = value;
        }

        /**
         * Gets the value of the isTattooInRPH property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIsTattooInRPH() {
            return isTattooInRPH;
        }

        /**
         * Sets the value of the isTattooInRPH property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIsTattooInRPH(String value) {
            this.isTattooInRPH = value;
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
     *       &lt;attribute name="maxAdult" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *       &lt;attribute name="maxChild" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *       &lt;attribute name="maxChildAge" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *       &lt;attribute name="maxGuest" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *       &lt;attribute name="maxInfant" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *       &lt;attribute name="minChildAge" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *       &lt;attribute name="propertyLevel" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="smoking" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class RoomType {

        @XmlAttribute(name = "maxAdult")
        protected BigInteger maxAdult;
        @XmlAttribute(name = "maxChild")
        protected BigInteger maxChild;
        @XmlAttribute(name = "maxChildAge")
        protected BigInteger maxChildAge;
        @XmlAttribute(name = "maxGuest")
        protected BigInteger maxGuest;
        @XmlAttribute(name = "maxInfant")
        protected BigInteger maxInfant;
        @XmlAttribute(name = "minChildAge")
        protected BigInteger minChildAge;
        @XmlAttribute(name = "propertyLevel")
        protected String propertyLevel;
        @XmlAttribute(name = "smoking")
        protected String smoking;

        /**
         * Gets the value of the maxAdult property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getMaxAdult() {
            return maxAdult;
        }

        /**
         * Sets the value of the maxAdult property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setMaxAdult(BigInteger value) {
            this.maxAdult = value;
        }

        /**
         * Gets the value of the maxChild property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getMaxChild() {
            return maxChild;
        }

        /**
         * Sets the value of the maxChild property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setMaxChild(BigInteger value) {
            this.maxChild = value;
        }

        /**
         * Gets the value of the maxChildAge property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getMaxChildAge() {
            return maxChildAge;
        }

        /**
         * Sets the value of the maxChildAge property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setMaxChildAge(BigInteger value) {
            this.maxChildAge = value;
        }

        /**
         * Gets the value of the maxGuest property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getMaxGuest() {
            return maxGuest;
        }

        /**
         * Sets the value of the maxGuest property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setMaxGuest(BigInteger value) {
            this.maxGuest = value;
        }

        /**
         * Gets the value of the maxInfant property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getMaxInfant() {
            return maxInfant;
        }

        /**
         * Sets the value of the maxInfant property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setMaxInfant(BigInteger value) {
            this.maxInfant = value;
        }

        /**
         * Gets the value of the minChildAge property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getMinChildAge() {
            return minChildAge;
        }

        /**
         * Sets the value of the minChildAge property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setMinChildAge(BigInteger value) {
            this.minChildAge = value;
        }

        /**
         * Gets the value of the propertyLevel property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPropertyLevel() {
            return propertyLevel;
        }

        /**
         * Sets the value of the propertyLevel property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPropertyLevel(String value) {
            this.propertyLevel = value;
        }

        /**
         * Gets the value of the smoking property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSmoking() {
            return smoking;
        }

        /**
         * Sets the value of the smoking property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSmoking(String value) {
            this.smoking = value;
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
     *         &lt;element name="Destinations" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Destination" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="OtherDestinations" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="OtherDestination" maxOccurs="unbounded" minOccurs="0">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                               &lt;/sequence>
     *                                               &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                               &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                               &lt;attribute name="URL" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                           &lt;attribute name="AvgReviewRating" type="{http://www.w3.org/2001/XMLSchema}float" />
     *                           &lt;attribute name="DestinationDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="DestinationId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="DestinationLatLong" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="DestinationName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="DestinationPOI" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="DestinationParentId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="DestinationSeoId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="DestinationTitle" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="GuruImageVersion" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                           &lt;attribute name="GuruName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="GuruTip" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="HeroImageDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="HeroImageName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="HeroImageVersion" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                           &lt;attribute name="MetaTagDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="MetaTagKeywords" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="POIMandatoryFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                           &lt;attribute name="TotalReviewCount" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                           &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="SeoPageData" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="OtherSeoPages" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="OtherSeoPage" maxOccurs="unbounded" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                     &lt;/sequence>
     *                                     &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="URL" type="{http://www.w3.org/2001/XMLSchema}string" />
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
     *                 &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="HeroImageDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="HeroImageName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="HeroImageVersion" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="MetaTagDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="MetaTagKeywords" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="PageContent" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="PageId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="PageSeoId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="PageTitle" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="Summary" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="CountryName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="CountrySeoId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="DestinationType" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="SeoPageType" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="StateName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="StateSeoId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="TotalNumberOfProperties" type="{http://www.w3.org/2001/XMLSchema}int" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "destinations",
        "seoPageData"
    })
    public static class SeoInformation {

        @XmlElement(name = "Destinations")
        protected TPAExtensionsType.SeoInformation.Destinations destinations;
        @XmlElement(name = "SeoPageData")
        protected TPAExtensionsType.SeoInformation.SeoPageData seoPageData;
        @XmlAttribute(name = "CountryName")
        protected String countryName;
        @XmlAttribute(name = "CountrySeoId")
        protected String countrySeoId;
        @XmlAttribute(name = "DestinationType")
        protected String destinationType;
        @XmlAttribute(name = "SeoPageType")
        protected String seoPageType;
        @XmlAttribute(name = "StateName")
        protected String stateName;
        @XmlAttribute(name = "StateSeoId")
        protected String stateSeoId;
        @XmlAttribute(name = "TotalNumberOfProperties")
        protected Integer totalNumberOfProperties;

        /**
         * Gets the value of the destinations property.
         * 
         * @return
         *     possible object is
         *     {@link TPAExtensionsType.SeoInformation.Destinations }
         *     
         */
        public TPAExtensionsType.SeoInformation.Destinations getDestinations() {
            return destinations;
        }

        /**
         * Sets the value of the destinations property.
         * 
         * @param value
         *     allowed object is
         *     {@link TPAExtensionsType.SeoInformation.Destinations }
         *     
         */
        public void setDestinations(TPAExtensionsType.SeoInformation.Destinations value) {
            this.destinations = value;
        }

        /**
         * Gets the value of the seoPageData property.
         * 
         * @return
         *     possible object is
         *     {@link TPAExtensionsType.SeoInformation.SeoPageData }
         *     
         */
        public TPAExtensionsType.SeoInformation.SeoPageData getSeoPageData() {
            return seoPageData;
        }

        /**
         * Sets the value of the seoPageData property.
         * 
         * @param value
         *     allowed object is
         *     {@link TPAExtensionsType.SeoInformation.SeoPageData }
         *     
         */
        public void setSeoPageData(TPAExtensionsType.SeoInformation.SeoPageData value) {
            this.seoPageData = value;
        }

        /**
         * Gets the value of the countryName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCountryName() {
            return countryName;
        }

        /**
         * Sets the value of the countryName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCountryName(String value) {
            this.countryName = value;
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
         * Gets the value of the destinationType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDestinationType() {
            return destinationType;
        }

        /**
         * Sets the value of the destinationType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDestinationType(String value) {
            this.destinationType = value;
        }

        /**
         * Gets the value of the seoPageType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSeoPageType() {
            return seoPageType;
        }

        /**
         * Sets the value of the seoPageType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSeoPageType(String value) {
            this.seoPageType = value;
        }

        /**
         * Gets the value of the stateName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStateName() {
            return stateName;
        }

        /**
         * Sets the value of the stateName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStateName(String value) {
            this.stateName = value;
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
         * Gets the value of the totalNumberOfProperties property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getTotalNumberOfProperties() {
            return totalNumberOfProperties;
        }

        /**
         * Sets the value of the totalNumberOfProperties property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setTotalNumberOfProperties(Integer value) {
            this.totalNumberOfProperties = value;
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
         *         &lt;element name="Destination" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="OtherDestinations" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="OtherDestination" maxOccurs="unbounded" minOccurs="0">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                     &lt;/sequence>
         *                                     &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                                     &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                                     &lt;attribute name="URL" type="{http://www.w3.org/2001/XMLSchema}string" />
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
         *                 &lt;attribute name="AvgReviewRating" type="{http://www.w3.org/2001/XMLSchema}float" />
         *                 &lt;attribute name="DestinationDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="DestinationId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="DestinationLatLong" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="DestinationName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="DestinationPOI" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="DestinationParentId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="DestinationSeoId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="DestinationTitle" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="GuruImageVersion" type="{http://www.w3.org/2001/XMLSchema}int" />
         *                 &lt;attribute name="GuruName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="GuruTip" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="HeroImageDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="HeroImageName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="HeroImageVersion" type="{http://www.w3.org/2001/XMLSchema}int" />
         *                 &lt;attribute name="MetaTagDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="MetaTagKeywords" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="POIMandatoryFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *                 &lt;attribute name="TotalReviewCount" type="{http://www.w3.org/2001/XMLSchema}int" />
         *                 &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
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
            "destination"
        })
        public static class Destinations {

            @XmlElement(name = "Destination")
            protected List<TPAExtensionsType.SeoInformation.Destinations.Destination> destination;

            /**
             * Gets the value of the destination property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the destination property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getDestination().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link TPAExtensionsType.SeoInformation.Destinations.Destination }
             * 
             * 
             */
            public List<TPAExtensionsType.SeoInformation.Destinations.Destination> getDestination() {
                if (destination == null) {
                    destination = new ArrayList<TPAExtensionsType.SeoInformation.Destinations.Destination>();
                }
                return this.destination;
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
             *         &lt;element name="OtherDestinations" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="OtherDestination" maxOccurs="unbounded" minOccurs="0">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                           &lt;/sequence>
             *                           &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                           &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                           &lt;attribute name="URL" type="{http://www.w3.org/2001/XMLSchema}string" />
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
             *       &lt;attribute name="AvgReviewRating" type="{http://www.w3.org/2001/XMLSchema}float" />
             *       &lt;attribute name="DestinationDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="DestinationId" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="DestinationLatLong" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="DestinationName" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="DestinationPOI" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="DestinationParentId" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="DestinationSeoId" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="DestinationTitle" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="GuruImageVersion" type="{http://www.w3.org/2001/XMLSchema}int" />
             *       &lt;attribute name="GuruName" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="GuruTip" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="HeroImageDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="HeroImageName" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="HeroImageVersion" type="{http://www.w3.org/2001/XMLSchema}int" />
             *       &lt;attribute name="MetaTagDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="MetaTagKeywords" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="POIMandatoryFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" />
             *       &lt;attribute name="TotalReviewCount" type="{http://www.w3.org/2001/XMLSchema}int" />
             *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "otherDestinations"
            })
            public static class Destination {

                @XmlElement(name = "OtherDestinations")
                protected TPAExtensionsType.SeoInformation.Destinations.Destination.OtherDestinations otherDestinations;
                @XmlAttribute(name = "AvgReviewRating")
                protected Float avgReviewRating;
                @XmlAttribute(name = "DestinationDescription")
                protected String destinationDescription;
                @XmlAttribute(name = "DestinationId")
                protected String destinationId;
                @XmlAttribute(name = "DestinationLatLong")
                protected String destinationLatLong;
                @XmlAttribute(name = "DestinationName")
                protected String destinationName;
                @XmlAttribute(name = "DestinationPOI")
                protected String destinationPOI;
                @XmlAttribute(name = "DestinationParentId")
                protected String destinationParentId;
                @XmlAttribute(name = "DestinationSeoId")
                protected String destinationSeoId;
                @XmlAttribute(name = "DestinationTitle")
                protected String destinationTitle;
                @XmlAttribute(name = "GuruImageVersion")
                protected Integer guruImageVersion;
                @XmlAttribute(name = "GuruName")
                protected String guruName;
                @XmlAttribute(name = "GuruTip")
                protected String guruTip;
                @XmlAttribute(name = "HeroImageDescription")
                protected String heroImageDescription;
                @XmlAttribute(name = "HeroImageName")
                protected String heroImageName;
                @XmlAttribute(name = "HeroImageVersion")
                protected Integer heroImageVersion;
                @XmlAttribute(name = "MetaTagDescription")
                protected String metaTagDescription;
                @XmlAttribute(name = "MetaTagKeywords")
                protected String metaTagKeywords;
                @XmlAttribute(name = "POIMandatoryFlag")
                protected Boolean poiMandatoryFlag;
                @XmlAttribute(name = "TotalReviewCount")
                protected Integer totalReviewCount;
                @XmlAttribute(name = "Type")
                protected String type;

                /**
                 * Gets the value of the otherDestinations property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link TPAExtensionsType.SeoInformation.Destinations.Destination.OtherDestinations }
                 *     
                 */
                public TPAExtensionsType.SeoInformation.Destinations.Destination.OtherDestinations getOtherDestinations() {
                    return otherDestinations;
                }

                /**
                 * Sets the value of the otherDestinations property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link TPAExtensionsType.SeoInformation.Destinations.Destination.OtherDestinations }
                 *     
                 */
                public void setOtherDestinations(TPAExtensionsType.SeoInformation.Destinations.Destination.OtherDestinations value) {
                    this.otherDestinations = value;
                }

                /**
                 * Gets the value of the avgReviewRating property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Float }
                 *     
                 */
                public Float getAvgReviewRating() {
                    return avgReviewRating;
                }

                /**
                 * Sets the value of the avgReviewRating property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Float }
                 *     
                 */
                public void setAvgReviewRating(Float value) {
                    this.avgReviewRating = value;
                }

                /**
                 * Gets the value of the destinationDescription property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDestinationDescription() {
                    return destinationDescription;
                }

                /**
                 * Sets the value of the destinationDescription property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDestinationDescription(String value) {
                    this.destinationDescription = value;
                }

                /**
                 * Gets the value of the destinationId property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDestinationId() {
                    return destinationId;
                }

                /**
                 * Sets the value of the destinationId property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDestinationId(String value) {
                    this.destinationId = value;
                }

                /**
                 * Gets the value of the destinationLatLong property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDestinationLatLong() {
                    return destinationLatLong;
                }

                /**
                 * Sets the value of the destinationLatLong property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDestinationLatLong(String value) {
                    this.destinationLatLong = value;
                }

                /**
                 * Gets the value of the destinationName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDestinationName() {
                    return destinationName;
                }

                /**
                 * Sets the value of the destinationName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDestinationName(String value) {
                    this.destinationName = value;
                }

                /**
                 * Gets the value of the destinationPOI property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDestinationPOI() {
                    return destinationPOI;
                }

                /**
                 * Sets the value of the destinationPOI property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDestinationPOI(String value) {
                    this.destinationPOI = value;
                }

                /**
                 * Gets the value of the destinationParentId property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDestinationParentId() {
                    return destinationParentId;
                }

                /**
                 * Sets the value of the destinationParentId property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDestinationParentId(String value) {
                    this.destinationParentId = value;
                }

                /**
                 * Gets the value of the destinationSeoId property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDestinationSeoId() {
                    return destinationSeoId;
                }

                /**
                 * Sets the value of the destinationSeoId property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDestinationSeoId(String value) {
                    this.destinationSeoId = value;
                }

                /**
                 * Gets the value of the destinationTitle property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDestinationTitle() {
                    return destinationTitle;
                }

                /**
                 * Sets the value of the destinationTitle property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDestinationTitle(String value) {
                    this.destinationTitle = value;
                }

                /**
                 * Gets the value of the guruImageVersion property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Integer }
                 *     
                 */
                public Integer getGuruImageVersion() {
                    return guruImageVersion;
                }

                /**
                 * Sets the value of the guruImageVersion property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Integer }
                 *     
                 */
                public void setGuruImageVersion(Integer value) {
                    this.guruImageVersion = value;
                }

                /**
                 * Gets the value of the guruName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getGuruName() {
                    return guruName;
                }

                /**
                 * Sets the value of the guruName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setGuruName(String value) {
                    this.guruName = value;
                }

                /**
                 * Gets the value of the guruTip property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getGuruTip() {
                    return guruTip;
                }

                /**
                 * Sets the value of the guruTip property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setGuruTip(String value) {
                    this.guruTip = value;
                }

                /**
                 * Gets the value of the heroImageDescription property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getHeroImageDescription() {
                    return heroImageDescription;
                }

                /**
                 * Sets the value of the heroImageDescription property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setHeroImageDescription(String value) {
                    this.heroImageDescription = value;
                }

                /**
                 * Gets the value of the heroImageName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getHeroImageName() {
                    return heroImageName;
                }

                /**
                 * Sets the value of the heroImageName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setHeroImageName(String value) {
                    this.heroImageName = value;
                }

                /**
                 * Gets the value of the heroImageVersion property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Integer }
                 *     
                 */
                public Integer getHeroImageVersion() {
                    return heroImageVersion;
                }

                /**
                 * Sets the value of the heroImageVersion property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Integer }
                 *     
                 */
                public void setHeroImageVersion(Integer value) {
                    this.heroImageVersion = value;
                }

                /**
                 * Gets the value of the metaTagDescription property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getMetaTagDescription() {
                    return metaTagDescription;
                }

                /**
                 * Sets the value of the metaTagDescription property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setMetaTagDescription(String value) {
                    this.metaTagDescription = value;
                }

                /**
                 * Gets the value of the metaTagKeywords property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getMetaTagKeywords() {
                    return metaTagKeywords;
                }

                /**
                 * Sets the value of the metaTagKeywords property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setMetaTagKeywords(String value) {
                    this.metaTagKeywords = value;
                }

                /**
                 * Gets the value of the poiMandatoryFlag property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isPOIMandatoryFlag() {
                    return poiMandatoryFlag;
                }

                /**
                 * Sets the value of the poiMandatoryFlag property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setPOIMandatoryFlag(Boolean value) {
                    this.poiMandatoryFlag = value;
                }

                /**
                 * Gets the value of the totalReviewCount property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Integer }
                 *     
                 */
                public Integer getTotalReviewCount() {
                    return totalReviewCount;
                }

                /**
                 * Sets the value of the totalReviewCount property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Integer }
                 *     
                 */
                public void setTotalReviewCount(Integer value) {
                    this.totalReviewCount = value;
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
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="OtherDestination" maxOccurs="unbounded" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                 &lt;/sequence>
                 *                 &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *                 &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *                 &lt;attribute name="URL" type="{http://www.w3.org/2001/XMLSchema}string" />
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
                    "otherDestination"
                })
                public static class OtherDestinations {

                    @XmlElement(name = "OtherDestination")
                    protected List<TPAExtensionsType.SeoInformation.Destinations.Destination.OtherDestinations.OtherDestination> otherDestination;

                    /**
                     * Gets the value of the otherDestination property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the otherDestination property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getOtherDestination().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link TPAExtensionsType.SeoInformation.Destinations.Destination.OtherDestinations.OtherDestination }
                     * 
                     * 
                     */
                    public List<TPAExtensionsType.SeoInformation.Destinations.Destination.OtherDestinations.OtherDestination> getOtherDestination() {
                        if (otherDestination == null) {
                            otherDestination = new ArrayList<TPAExtensionsType.SeoInformation.Destinations.Destination.OtherDestinations.OtherDestination>();
                        }
                        return this.otherDestination;
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
                     *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
                     *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
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
                    public static class OtherDestination {

                        @XmlAttribute(name = "Name")
                        protected String name;
                        @XmlAttribute(name = "Type")
                        protected String type;
                        @XmlAttribute(name = "URL")
                        protected String url;

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
         *         &lt;element name="OtherSeoPages" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="OtherSeoPage" maxOccurs="unbounded" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                           &lt;/sequence>
         *                           &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="URL" type="{http://www.w3.org/2001/XMLSchema}string" />
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
         *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="HeroImageDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="HeroImageName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="HeroImageVersion" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="MetaTagDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="MetaTagKeywords" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="PageContent" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="PageId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="PageSeoId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="PageTitle" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="Summary" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "otherSeoPages"
        })
        public static class SeoPageData {

            @XmlElement(name = "OtherSeoPages")
            protected TPAExtensionsType.SeoInformation.SeoPageData.OtherSeoPages otherSeoPages;
            @XmlAttribute(name = "Code")
            protected String code;
            @XmlAttribute(name = "HeroImageDescription")
            protected String heroImageDescription;
            @XmlAttribute(name = "HeroImageName")
            protected String heroImageName;
            @XmlAttribute(name = "HeroImageVersion")
            protected Integer heroImageVersion;
            @XmlAttribute(name = "MetaTagDescription")
            protected String metaTagDescription;
            @XmlAttribute(name = "MetaTagKeywords")
            protected String metaTagKeywords;
            @XmlAttribute(name = "Name")
            protected String name;
            @XmlAttribute(name = "PageContent")
            protected String pageContent;
            @XmlAttribute(name = "PageId")
            protected String pageId;
            @XmlAttribute(name = "PageSeoId")
            protected String pageSeoId;
            @XmlAttribute(name = "PageTitle")
            protected String pageTitle;
            @XmlAttribute(name = "Summary")
            protected String summary;
            @XmlAttribute(name = "Type")
            protected String type;

            /**
             * Gets the value of the otherSeoPages property.
             * 
             * @return
             *     possible object is
             *     {@link TPAExtensionsType.SeoInformation.SeoPageData.OtherSeoPages }
             *     
             */
            public TPAExtensionsType.SeoInformation.SeoPageData.OtherSeoPages getOtherSeoPages() {
                return otherSeoPages;
            }

            /**
             * Sets the value of the otherSeoPages property.
             * 
             * @param value
             *     allowed object is
             *     {@link TPAExtensionsType.SeoInformation.SeoPageData.OtherSeoPages }
             *     
             */
            public void setOtherSeoPages(TPAExtensionsType.SeoInformation.SeoPageData.OtherSeoPages value) {
                this.otherSeoPages = value;
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
             * Gets the value of the heroImageDescription property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHeroImageDescription() {
                return heroImageDescription;
            }

            /**
             * Sets the value of the heroImageDescription property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHeroImageDescription(String value) {
                this.heroImageDescription = value;
            }

            /**
             * Gets the value of the heroImageName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHeroImageName() {
                return heroImageName;
            }

            /**
             * Sets the value of the heroImageName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHeroImageName(String value) {
                this.heroImageName = value;
            }

            /**
             * Gets the value of the heroImageVersion property.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getHeroImageVersion() {
                return heroImageVersion;
            }

            /**
             * Sets the value of the heroImageVersion property.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setHeroImageVersion(Integer value) {
                this.heroImageVersion = value;
            }

            /**
             * Gets the value of the metaTagDescription property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMetaTagDescription() {
                return metaTagDescription;
            }

            /**
             * Sets the value of the metaTagDescription property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMetaTagDescription(String value) {
                this.metaTagDescription = value;
            }

            /**
             * Gets the value of the metaTagKeywords property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMetaTagKeywords() {
                return metaTagKeywords;
            }

            /**
             * Sets the value of the metaTagKeywords property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMetaTagKeywords(String value) {
                this.metaTagKeywords = value;
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
             * Gets the value of the pageContent property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPageContent() {
                return pageContent;
            }

            /**
             * Sets the value of the pageContent property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPageContent(String value) {
                this.pageContent = value;
            }

            /**
             * Gets the value of the pageId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPageId() {
                return pageId;
            }

            /**
             * Sets the value of the pageId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPageId(String value) {
                this.pageId = value;
            }

            /**
             * Gets the value of the pageSeoId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPageSeoId() {
                return pageSeoId;
            }

            /**
             * Sets the value of the pageSeoId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPageSeoId(String value) {
                this.pageSeoId = value;
            }

            /**
             * Gets the value of the pageTitle property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPageTitle() {
                return pageTitle;
            }

            /**
             * Sets the value of the pageTitle property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPageTitle(String value) {
                this.pageTitle = value;
            }

            /**
             * Gets the value of the summary property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSummary() {
                return summary;
            }

            /**
             * Sets the value of the summary property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSummary(String value) {
                this.summary = value;
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
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="OtherSeoPage" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                 &lt;/sequence>
             *                 &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="URL" type="{http://www.w3.org/2001/XMLSchema}string" />
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
                "otherSeoPage"
            })
            public static class OtherSeoPages {

                @XmlElement(name = "OtherSeoPage")
                protected List<TPAExtensionsType.SeoInformation.SeoPageData.OtherSeoPages.OtherSeoPage> otherSeoPage;

                /**
                 * Gets the value of the otherSeoPage property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the otherSeoPage property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getOtherSeoPage().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link TPAExtensionsType.SeoInformation.SeoPageData.OtherSeoPages.OtherSeoPage }
                 * 
                 * 
                 */
                public List<TPAExtensionsType.SeoInformation.SeoPageData.OtherSeoPages.OtherSeoPage> getOtherSeoPage() {
                    if (otherSeoPage == null) {
                        otherSeoPage = new ArrayList<TPAExtensionsType.SeoInformation.SeoPageData.OtherSeoPages.OtherSeoPage>();
                    }
                    return this.otherSeoPage;
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
                 *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
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
                public static class OtherSeoPage {

                    @XmlAttribute(name = "Name")
                    protected String name;
                    @XmlAttribute(name = "Type")
                    protected String type;
                    @XmlAttribute(name = "URL")
                    protected String url;

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
     *       &lt;attribute name="password" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="propertyId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="username" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class UserAuthentication {

        @XmlAttribute(name = "password")
        protected String password;
        @XmlAttribute(name = "propertyId")
        protected String propertyId;
        @XmlAttribute(name = "username")
        protected String username;

        /**
         * Gets the value of the password property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPassword() {
            return password;
        }

        /**
         * Sets the value of the password property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPassword(String value) {
            this.password = value;
        }

        /**
         * Gets the value of the propertyId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPropertyId() {
            return propertyId;
        }

        /**
         * Sets the value of the propertyId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPropertyId(String value) {
            this.propertyId = value;
        }

        /**
         * Gets the value of the username property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUsername() {
            return username;
        }

        /**
         * Sets the value of the username property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUsername(String value) {
            this.username = value;
        }

    }

}
