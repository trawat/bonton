
package com.desia.artifacts.search;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransportationsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransportationsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Transportations" type="{http://www.opentravel.org/OTA/2003/05}TransportationType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransportationsType", propOrder = {
    "transportations"
})
@XmlSeeAlso({
    RelativePositionType.class
})
public class TransportationsType {

    @XmlElement(name = "Transportations")
    protected TransportationType transportations;

    /**
     * Gets the value of the transportations property.
     * 
     * @return
     *     possible object is
     *     {@link TransportationType }
     *     
     */
    public TransportationType getTransportations() {
        return transportations;
    }

    /**
     * Sets the value of the transportations property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportationType }
     *     
     */
    public void setTransportations(TransportationType value) {
        this.transportations = value;
    }

}
