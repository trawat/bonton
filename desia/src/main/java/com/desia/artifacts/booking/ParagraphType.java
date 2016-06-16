
package com.desia.artifacts.booking;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParagraphType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParagraphType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="Image" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;element name="Text" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextTextType"/>
 *           &lt;element name="URL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;element name="ListItem">
 *             &lt;complexType>
 *               &lt;simpleContent>
 *                 &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>FormattedTextTextType">
 *                   &lt;attribute name="ListItem" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;/extension>
 *               &lt;/simpleContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ParagraphNumber" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="Language" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CreateDateTime" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="CreatorID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="LastModifierID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="LastModifyDateTime" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="PurgeDate" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParagraphType", propOrder = {
    "imageOrTextOrURL"
})
@XmlSeeAlso({
    com.desia.artifacts.booking.ProfileType.Comments.Comment.class,
    DescriptionType.class,
    com.desia.artifacts.booking.SpecialRequestType.SpecialRequest.class,
    com.desia.artifacts.booking.CommentType.Comment.class,
    com.desia.artifacts.booking.AffiliationInfoType.LoyalPrograms.LoyalProgram.ProgramDescription.class,
    com.desia.artifacts.booking.AffiliationInfoType.LoyalPrograms.LoyalProgram.ProgramRestriction.class,
    com.desia.artifacts.booking.InvBlockType.BlockDescriptions.BlockDescription.class
})
public class ParagraphType {

    @XmlElementRefs({
        @XmlElementRef(name = "Text", namespace = "http://www.opentravel.org/OTA/2003/05", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ListItem", namespace = "http://www.opentravel.org/OTA/2003/05", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Image", namespace = "http://www.opentravel.org/OTA/2003/05", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "URL", namespace = "http://www.opentravel.org/OTA/2003/05", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> imageOrTextOrURL;
    @XmlAttribute(name = "Name")
    protected String name;
    @XmlAttribute(name = "ParagraphNumber")
    protected BigInteger paragraphNumber;
    @XmlAttribute(name = "Language")
    protected String language;
    @XmlAttribute(name = "CreateDateTime")
    @XmlSchemaType(name = "anySimpleType")
    protected String createDateTime;
    @XmlAttribute(name = "CreatorID")
    protected String creatorID;
    @XmlAttribute(name = "LastModifierID")
    protected String lastModifierID;
    @XmlAttribute(name = "LastModifyDateTime")
    @XmlSchemaType(name = "anySimpleType")
    protected String lastModifyDateTime;
    @XmlAttribute(name = "PurgeDate")
    @XmlSchemaType(name = "anySimpleType")
    protected String purgeDate;

    /**
     * Gets the value of the imageOrTextOrURL property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the imageOrTextOrURL property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImageOrTextOrURL().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link FormattedTextTextType }{@code >}
     * {@link JAXBElement }{@code <}{@link ParagraphType.ListItem }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getImageOrTextOrURL() {
        if (imageOrTextOrURL == null) {
            imageOrTextOrURL = new ArrayList<JAXBElement<?>>();
        }
        return this.imageOrTextOrURL;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the paragraphNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getParagraphNumber() {
        return paragraphNumber;
    }

    /**
     * Sets the value of the paragraphNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setParagraphNumber(BigInteger value) {
        this.paragraphNumber = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
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
     * Gets the value of the creatorID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatorID() {
        return creatorID;
    }

    /**
     * Sets the value of the creatorID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatorID(String value) {
        this.creatorID = value;
    }

    /**
     * Gets the value of the lastModifierID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastModifierID() {
        return lastModifierID;
    }

    /**
     * Sets the value of the lastModifierID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastModifierID(String value) {
        this.lastModifierID = value;
    }

    /**
     * Gets the value of the lastModifyDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastModifyDateTime() {
        return lastModifyDateTime;
    }

    /**
     * Sets the value of the lastModifyDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastModifyDateTime(String value) {
        this.lastModifyDateTime = value;
    }

    /**
     * Gets the value of the purgeDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurgeDate() {
        return purgeDate;
    }

    /**
     * Sets the value of the purgeDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurgeDate(String value) {
        this.purgeDate = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>FormattedTextTextType">
     *       &lt;attribute name="ListItem" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ListItem
        extends FormattedTextTextType
    {

        @XmlAttribute(name = "ListItem")
        protected BigInteger listItem;

        /**
         * Gets the value of the listItem property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getListItem() {
            return listItem;
        }

        /**
         * Sets the value of the listItem property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setListItem(BigInteger value) {
            this.listItem = value;
        }

    }

}
