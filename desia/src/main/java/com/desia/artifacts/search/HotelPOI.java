
package com.desia.artifacts.search;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;/sequence>
 *       &lt;attribute name="POIDistance" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="POIName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "HotelPOI")
public class HotelPOI {

    @XmlAttribute(name = "POIDistance")
    protected Double poiDistance;
    @XmlAttribute(name = "POIName")
    protected String poiName;

    /**
     * Gets the value of the poiDistance property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPOIDistance() {
        return poiDistance;
    }

    /**
     * Sets the value of the poiDistance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPOIDistance(Double value) {
        this.poiDistance = value;
    }

    /**
     * Gets the value of the poiName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOIName() {
        return poiName;
    }

    /**
     * Sets the value of the poiName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOIName(String value) {
        this.poiName = value;
    }

}
