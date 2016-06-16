
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
 *       &lt;attribute name="enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="hotelsFrom" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="hotelsTo" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Pagination")
public class Pagination {

    @XmlAttribute(name = "enabled")
    protected Boolean enabled;
    @XmlAttribute(name = "hotelsFrom", required = true)
    protected int hotelsFrom;
    @XmlAttribute(name = "hotelsTo", required = true)
    protected int hotelsTo;

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

    /**
     * Gets the value of the hotelsFrom property.
     * 
     */
    public int getHotelsFrom() {
        return hotelsFrom;
    }

    /**
     * Sets the value of the hotelsFrom property.
     * 
     */
    public void setHotelsFrom(int value) {
        this.hotelsFrom = value;
    }

    /**
     * Gets the value of the hotelsTo property.
     * 
     */
    public int getHotelsTo() {
        return hotelsTo;
    }

    /**
     * Sets the value of the hotelsTo property.
     * 
     */
    public void setHotelsTo(int value) {
        this.hotelsTo = value;
    }

}
