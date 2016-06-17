
package com.desia.artifacts.search;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SpecialRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SpecialRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SpecialRequest" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}ParagraphType">
 *                 &lt;sequence>
 *                 &lt;/sequence>
 *                 &lt;attribute name="CodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="NumberOfUnits" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="RequestCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpecialRequestType", propOrder = {
    "specialRequest"
})
public class SpecialRequestType {

    @XmlElement(name = "SpecialRequest", required = true)
    protected List<SpecialRequestType.SpecialRequest> specialRequest;

    /**
     * Gets the value of the specialRequest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specialRequest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecialRequest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpecialRequestType.SpecialRequest }
     * 
     * 
     */
    public List<SpecialRequestType.SpecialRequest> getSpecialRequest() {
        if (specialRequest == null) {
            specialRequest = new ArrayList<SpecialRequestType.SpecialRequest>();
        }
        return this.specialRequest;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}ParagraphType">
     *       &lt;sequence>
     *       &lt;/sequence>
     *       &lt;attribute name="CodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="NumberOfUnits" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *       &lt;attribute name="RequestCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class SpecialRequest
        extends ParagraphType
    {

        @XmlAttribute(name = "CodeContext")
        protected String codeContext;
        @XmlAttribute(name = "NumberOfUnits")
        protected BigInteger numberOfUnits;
        @XmlAttribute(name = "RequestCode")
        protected String requestCode;

        /**
         * Gets the value of the codeContext property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCodeContext() {
            return codeContext;
        }

        /**
         * Sets the value of the codeContext property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCodeContext(String value) {
            this.codeContext = value;
        }

        /**
         * Gets the value of the numberOfUnits property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getNumberOfUnits() {
            return numberOfUnits;
        }

        /**
         * Sets the value of the numberOfUnits property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setNumberOfUnits(BigInteger value) {
            this.numberOfUnits = value;
        }

        /**
         * Gets the value of the requestCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRequestCode() {
            return requestCode;
        }

        /**
         * Sets the value of the requestCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRequestCode(String value) {
            this.requestCode = value;
        }

    }

}