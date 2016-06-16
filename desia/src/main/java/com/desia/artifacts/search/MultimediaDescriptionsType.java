
package com.desia.artifacts.search;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MultimediaDescriptionsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MultimediaDescriptionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MultimediaDescription" type="{http://www.opentravel.org/OTA/2003/05}MultimediaDescriptionType" maxOccurs="unbounded"/>
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
@XmlType(name = "MultimediaDescriptionsType", propOrder = {
    "multimediaDescription"
})
@XmlSeeAlso({
    com.desia.artifacts.search.HotelInfoType.Descriptions.MultimediaDescriptions.class,
    com.desia.artifacts.search.AreaInfoType.Recreations.Recreation.MultimediaDescriptions.class,
    com.desia.artifacts.search.RestaurantType.MultimediaDescriptions.class
})
public class MultimediaDescriptionsType {

    @XmlElement(name = "MultimediaDescription", required = true)
    protected List<MultimediaDescriptionType> multimediaDescription;
    @XmlAttribute(name = "LastUpdated")
    @XmlSchemaType(name = "anySimpleType")
    protected String lastUpdated;

    /**
     * Gets the value of the multimediaDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the multimediaDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMultimediaDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MultimediaDescriptionType }
     * 
     * 
     */
    public List<MultimediaDescriptionType> getMultimediaDescription() {
        if (multimediaDescription == null) {
            multimediaDescription = new ArrayList<MultimediaDescriptionType>();
        }
        return this.multimediaDescription;
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

}
