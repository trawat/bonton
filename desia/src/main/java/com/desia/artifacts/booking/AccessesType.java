
package com.desia.artifacts.booking;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccessesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccessesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Access" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="AccessPerson" type="{http://www.opentravel.org/OTA/2003/05}PersonNameType" minOccurs="0"/>
 *                   &lt;element name="AccessComment" type="{http://www.opentravel.org/OTA/2003/05}FreeTextType" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="ActionDateTime" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                 &lt;attribute name="ActionType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="ID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="CreateDateTime" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="ShareMarketInd" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ShareSynchInd" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccessesType", propOrder = {
    "access"
})
public class AccessesType {

    @XmlElement(name = "Access", required = true)
    protected List<AccessesType.Access> access;
    @XmlAttribute(name = "CreateDateTime")
    @XmlSchemaType(name = "anySimpleType")
    protected String createDateTime;
    @XmlAttribute(name = "ShareMarketInd")
    protected String shareMarketInd;
    @XmlAttribute(name = "ShareSynchInd")
    protected String shareSynchInd;

    /**
     * Gets the value of the access property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the access property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccess().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccessesType.Access }
     * 
     * 
     */
    public List<AccessesType.Access> getAccess() {
        if (access == null) {
            access = new ArrayList<AccessesType.Access>();
        }
        return this.access;
    }

    /**
     * Gets the value of the createDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateDateTime() {
        return createDateTime;
    }

    /**
     * Sets the value of the createDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateDateTime(String value) {
        this.createDateTime = value;
    }

    /**
     * Gets the value of the shareMarketInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShareMarketInd() {
        return shareMarketInd;
    }

    /**
     * Sets the value of the shareMarketInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShareMarketInd(String value) {
        this.shareMarketInd = value;
    }

    /**
     * Gets the value of the shareSynchInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShareSynchInd() {
        return shareSynchInd;
    }

    /**
     * Sets the value of the shareSynchInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShareSynchInd(String value) {
        this.shareSynchInd = value;
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
     *         &lt;element name="AccessPerson" type="{http://www.opentravel.org/OTA/2003/05}PersonNameType" minOccurs="0"/>
     *         &lt;element name="AccessComment" type="{http://www.opentravel.org/OTA/2003/05}FreeTextType" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="ActionDateTime" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *       &lt;attribute name="ActionType" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="ID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "accessPerson",
        "accessComment"
    })
    public static class Access {

        @XmlElement(name = "AccessPerson")
        protected PersonNameType accessPerson;
        @XmlElement(name = "AccessComment")
        protected FreeTextType accessComment;
        @XmlAttribute(name = "ActionDateTime")
        @XmlSchemaType(name = "anySimpleType")
        protected String actionDateTime;
        @XmlAttribute(name = "ActionType")
        protected String actionType;
        @XmlAttribute(name = "ID", required = true)
        protected String id;

        /**
         * Gets the value of the accessPerson property.
         * 
         * @return
         *     possible object is
         *     {@link PersonNameType }
         *     
         */
        public PersonNameType getAccessPerson() {
            return accessPerson;
        }

        /**
         * Sets the value of the accessPerson property.
         * 
         * @param value
         *     allowed object is
         *     {@link PersonNameType }
         *     
         */
        public void setAccessPerson(PersonNameType value) {
            this.accessPerson = value;
        }

        /**
         * Gets the value of the accessComment property.
         * 
         * @return
         *     possible object is
         *     {@link FreeTextType }
         *     
         */
        public FreeTextType getAccessComment() {
            return accessComment;
        }

        /**
         * Sets the value of the accessComment property.
         * 
         * @param value
         *     allowed object is
         *     {@link FreeTextType }
         *     
         */
        public void setAccessComment(FreeTextType value) {
            this.accessComment = value;
        }

        /**
         * Gets the value of the actionDateTime property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getActionDateTime() {
            return actionDateTime;
        }

        /**
         * Sets the value of the actionDateTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setActionDateTime(String value) {
            this.actionDateTime = value;
        }

        /**
         * Gets the value of the actionType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getActionType() {
            return actionType;
        }

        /**
         * Sets the value of the actionType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setActionType(String value) {
            this.actionType = value;
        }

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getID() {
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
        public void setID(String value) {
            this.id = value;
        }

    }

}
