
package com.desia.artifacts.booking;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pmsResStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="pmsResStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Reserved"/>
 *     &lt;enumeration value="Requested"/>
 *     &lt;enumeration value="Request denied"/>
 *     &lt;enumeration value="No-show"/>
 *     &lt;enumeration value="Cancelled"/>
 *     &lt;enumeration value="In-house"/>
 *     &lt;enumeration value="Checked out"/>
 *     &lt;enumeration value="Waitlisted"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "pmsResStatusType")
@XmlEnum
public enum PmsResStatusType {

    @XmlEnumValue("Reserved")
    RESERVED("Reserved"),
    @XmlEnumValue("Requested")
    REQUESTED("Requested"),
    @XmlEnumValue("Request denied")
    REQUEST_DENIED("Request denied"),
    @XmlEnumValue("No-show")
    NO_SHOW("No-show"),
    @XmlEnumValue("Cancelled")
    CANCELLED("Cancelled"),
    @XmlEnumValue("In-house")
    IN_HOUSE("In-house"),
    @XmlEnumValue("Checked out")
    CHECKED_OUT("Checked out"),
    @XmlEnumValue("Waitlisted")
    WAITLISTED("Waitlisted");
    private final String value;

    PmsResStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PmsResStatusType fromValue(String v) {
        for (PmsResStatusType c: PmsResStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
