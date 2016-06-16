
package com.desia.artifacts.booking;

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
 *       &lt;attribute name="ReviewComment" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ReviewCount" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="ReviewImageUrl" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ReviewPercentage" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ReviewPostDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ReviewRating" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="ReviewerName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ReviewerRating" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Reviews")
public class Reviews {

    @XmlAttribute(name = "ReviewComment")
    protected String reviewComment;
    @XmlAttribute(name = "ReviewCount")
    protected Integer reviewCount;
    @XmlAttribute(name = "ReviewImageUrl")
    protected String reviewImageUrl;
    @XmlAttribute(name = "ReviewPercentage")
    protected String reviewPercentage;
    @XmlAttribute(name = "ReviewPostDate")
    protected String reviewPostDate;
    @XmlAttribute(name = "ReviewRating")
    protected Float reviewRating;
    @XmlAttribute(name = "ReviewerName")
    protected String reviewerName;
    @XmlAttribute(name = "ReviewerRating")
    protected String reviewerRating;

    /**
     * Gets the value of the reviewComment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReviewComment() {
        return reviewComment;
    }

    /**
     * Sets the value of the reviewComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReviewComment(String value) {
        this.reviewComment = value;
    }

    /**
     * Gets the value of the reviewCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getReviewCount() {
        return reviewCount;
    }

    /**
     * Sets the value of the reviewCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setReviewCount(Integer value) {
        this.reviewCount = value;
    }

    /**
     * Gets the value of the reviewImageUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReviewImageUrl() {
        return reviewImageUrl;
    }

    /**
     * Sets the value of the reviewImageUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReviewImageUrl(String value) {
        this.reviewImageUrl = value;
    }

    /**
     * Gets the value of the reviewPercentage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReviewPercentage() {
        return reviewPercentage;
    }

    /**
     * Sets the value of the reviewPercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReviewPercentage(String value) {
        this.reviewPercentage = value;
    }

    /**
     * Gets the value of the reviewPostDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReviewPostDate() {
        return reviewPostDate;
    }

    /**
     * Sets the value of the reviewPostDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReviewPostDate(String value) {
        this.reviewPostDate = value;
    }

    /**
     * Gets the value of the reviewRating property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getReviewRating() {
        return reviewRating;
    }

    /**
     * Sets the value of the reviewRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setReviewRating(Float value) {
        this.reviewRating = value;
    }

    /**
     * Gets the value of the reviewerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReviewerName() {
        return reviewerName;
    }

    /**
     * Sets the value of the reviewerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReviewerName(String value) {
        this.reviewerName = value;
    }

    /**
     * Gets the value of the reviewerRating property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReviewerRating() {
        return reviewerRating;
    }

    /**
     * Sets the value of the reviewerRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReviewerRating(String value) {
        this.reviewerRating = value;
    }

}
