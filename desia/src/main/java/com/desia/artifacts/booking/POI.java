
package com.desia.artifacts.booking;

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
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opentravel.org/OTA/2003/05}HotelPOI" maxOccurs="unbounded" minOccurs="0"/>
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
    "hotelPOI"
})
@XmlRootElement(name = "POI")
public class POI {

    @XmlElement(name = "HotelPOI")
    protected List<HotelPOI> hotelPOI;

    /**
     * Gets the value of the hotelPOI property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hotelPOI property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHotelPOI().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HotelPOI }
     * 
     * 
     */
    public List<HotelPOI> getHotelPOI() {
        if (hotelPOI == null) {
            hotelPOI = new ArrayList<HotelPOI>();
        }
        return this.hotelPOI;
    }

}
