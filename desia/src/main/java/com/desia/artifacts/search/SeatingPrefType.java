
package com.desia.artifacts.search;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for SeatingPrefType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SeatingPrefType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="SeatDirection" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SeatLocation" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SeatPosition" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SeatRow" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="PreferLevel" type="{http://www.opentravel.org/OTA/2003/05}preferLevelType" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SeatingPrefType", propOrder = {
    "value"
})
public class SeatingPrefType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "SeatDirection")
    protected String seatDirection;
    @XmlAttribute(name = "SeatLocation")
    protected String seatLocation;
    @XmlAttribute(name = "SeatPosition")
    protected String seatPosition;
    @XmlAttribute(name = "SeatRow")
    protected String seatRow;
    @XmlAttribute(name = "PreferLevel")
    protected PreferLevelType preferLevel;

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
     * Gets the value of the seatDirection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeatDirection() {
        return seatDirection;
    }

    /**
     * Sets the value of the seatDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeatDirection(String value) {
        this.seatDirection = value;
    }

    /**
     * Gets the value of the seatLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeatLocation() {
        return seatLocation;
    }

    /**
     * Sets the value of the seatLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeatLocation(String value) {
        this.seatLocation = value;
    }

    /**
     * Gets the value of the seatPosition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeatPosition() {
        return seatPosition;
    }

    /**
     * Sets the value of the seatPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeatPosition(String value) {
        this.seatPosition = value;
    }

    /**
     * Gets the value of the seatRow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeatRow() {
        return seatRow;
    }

    /**
     * Sets the value of the seatRow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeatRow(String value) {
        this.seatRow = value;
    }

    /**
     * Gets the value of the preferLevel property.
     * 
     * @return
     *     possible object is
     *     {@link PreferLevelType }
     *     
     */
    public PreferLevelType getPreferLevel() {
        return preferLevel;
    }

    /**
     * Sets the value of the preferLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreferLevelType }
     *     
     */
    public void setPreferLevel(PreferLevelType value) {
        this.preferLevel = value;
    }

}
