
package com.desia.artifacts.booking;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AgentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AgentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="agentName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="navCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AgentType")
public class AgentType {

    @XmlAttribute(name = "agentName")
    protected String agentName;
    @XmlAttribute(name = "navCode")
    protected String navCode;

    /**
     * Gets the value of the agentName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentName() {
        return agentName;
    }

    /**
     * Sets the value of the agentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentName(String value) {
        this.agentName = value;
    }

    /**
     * Gets the value of the navCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNavCode() {
        return navCode;
    }

    /**
     * Sets the value of the navCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNavCode(String value) {
        this.navCode = value;
    }

}
