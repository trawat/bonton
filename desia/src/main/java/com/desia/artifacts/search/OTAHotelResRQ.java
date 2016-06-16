
package com.desia.artifacts.search;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}HotelResRequestType">
 *       &lt;sequence>
 *         &lt;element name="DonationInformation" type="{http://www.opentravel.org/OTA/2003/05}DonationType" minOccurs="0"/>
 *         &lt;element name="RebatePrograms" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="RebateProgram" type="{http://www.opentravel.org/OTA/2003/05}RebateType" maxOccurs="unbounded" minOccurs="0"/>
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
    "donationInformation",
    "rebatePrograms"
})
@XmlRootElement(name = "OTA_HotelResRQ")
public class OTAHotelResRQ
    extends HotelResRequestType
{

    @XmlElement(name = "DonationInformation")
    protected DonationType donationInformation;
    @XmlElement(name = "RebatePrograms")
    protected OTAHotelResRQ.RebatePrograms rebatePrograms;

    /**
     * Gets the value of the donationInformation property.
     * 
     * @return
     *     possible object is
     *     {@link DonationType }
     *     
     */
    public DonationType getDonationInformation() {
        return donationInformation;
    }

    /**
     * Sets the value of the donationInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link DonationType }
     *     
     */
    public void setDonationInformation(DonationType value) {
        this.donationInformation = value;
    }

    /**
     * Gets the value of the rebatePrograms property.
     * 
     * @return
     *     possible object is
     *     {@link OTAHotelResRQ.RebatePrograms }
     *     
     */
    public OTAHotelResRQ.RebatePrograms getRebatePrograms() {
        return rebatePrograms;
    }

    /**
     * Sets the value of the rebatePrograms property.
     * 
     * @param value
     *     allowed object is
     *     {@link OTAHotelResRQ.RebatePrograms }
     *     
     */
    public void setRebatePrograms(OTAHotelResRQ.RebatePrograms value) {
        this.rebatePrograms = value;
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
     *         &lt;element name="RebateProgram" type="{http://www.opentravel.org/OTA/2003/05}RebateType" maxOccurs="unbounded" minOccurs="0"/>
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
        "rebateProgram"
    })
    public static class RebatePrograms {

        @XmlElement(name = "RebateProgram")
        protected List<RebateType> rebateProgram;

        /**
         * Gets the value of the rebateProgram property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the rebateProgram property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRebateProgram().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RebateType }
         * 
         * 
         */
        public List<RebateType> getRebateProgram() {
            if (rebateProgram == null) {
                rebateProgram = new ArrayList<RebateType>();
            }
            return this.rebateProgram;
        }

    }

}
