
package com.desia.artifacts.search;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="ImagesList" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ThumbnailImageObj" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                           &lt;/sequence>
 *                           &lt;attribute name="caption" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="category" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="height" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="sizeName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="subCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="url" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="LargeImageObj" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                           &lt;/sequence>
 *                           &lt;attribute name="caption" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="category" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="height" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="sizeName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="subCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="url" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
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
@XmlType(name = "", propOrder = {
    "imagesList"
})
@XmlRootElement(name = "ImageJSON")
public class ImageJSON {

    @XmlElement(name = "ImagesList")
    protected List<ImageJSON.ImagesList> imagesList;

    /**
     * Gets the value of the imagesList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the imagesList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImagesList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImageJSON.ImagesList }
     * 
     * 
     */
    public List<ImageJSON.ImagesList> getImagesList() {
        if (imagesList == null) {
            imagesList = new ArrayList<ImageJSON.ImagesList>();
        }
        return this.imagesList;
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
     *         &lt;element name="ThumbnailImageObj" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                 &lt;/sequence>
     *                 &lt;attribute name="caption" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="category" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="height" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="sizeName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="subCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="url" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="LargeImageObj" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                 &lt;/sequence>
     *                 &lt;attribute name="caption" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="category" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="height" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="sizeName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="subCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="url" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
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
    @XmlType(name = "", propOrder = {
        "thumbnailImageObj",
        "largeImageObj"
    })
    public static class ImagesList {

        @XmlElement(name = "ThumbnailImageObj")
        protected ImageJSON.ImagesList.ThumbnailImageObj thumbnailImageObj;
        @XmlElement(name = "LargeImageObj")
        protected ImageJSON.ImagesList.LargeImageObj largeImageObj;

        /**
         * Gets the value of the thumbnailImageObj property.
         * 
         * @return
         *     possible object is
         *     {@link ImageJSON.ImagesList.ThumbnailImageObj }
         *     
         */
        public ImageJSON.ImagesList.ThumbnailImageObj getThumbnailImageObj() {
            return thumbnailImageObj;
        }

        /**
         * Sets the value of the thumbnailImageObj property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImageJSON.ImagesList.ThumbnailImageObj }
         *     
         */
        public void setThumbnailImageObj(ImageJSON.ImagesList.ThumbnailImageObj value) {
            this.thumbnailImageObj = value;
        }

        /**
         * Gets the value of the largeImageObj property.
         * 
         * @return
         *     possible object is
         *     {@link ImageJSON.ImagesList.LargeImageObj }
         *     
         */
        public ImageJSON.ImagesList.LargeImageObj getLargeImageObj() {
            return largeImageObj;
        }

        /**
         * Sets the value of the largeImageObj property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImageJSON.ImagesList.LargeImageObj }
         *     
         */
        public void setLargeImageObj(ImageJSON.ImagesList.LargeImageObj value) {
            this.largeImageObj = value;
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
         *       &lt;/sequence>
         *       &lt;attribute name="caption" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="category" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="height" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="sizeName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="subCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="url" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class LargeImageObj {

            @XmlAttribute(name = "caption")
            protected String caption;
            @XmlAttribute(name = "category")
            protected String category;
            @XmlAttribute(name = "height")
            protected String height;
            @XmlAttribute(name = "sizeName")
            protected String sizeName;
            @XmlAttribute(name = "subCategory")
            protected String subCategory;
            @XmlAttribute(name = "url")
            protected String url;
            @XmlAttribute(name = "width")
            protected String width;

            /**
             * Gets the value of the caption property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCaption() {
                return caption;
            }

            /**
             * Sets the value of the caption property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCaption(String value) {
                this.caption = value;
            }

            /**
             * Gets the value of the category property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCategory() {
                return category;
            }

            /**
             * Sets the value of the category property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCategory(String value) {
                this.category = value;
            }

            /**
             * Gets the value of the height property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHeight() {
                return height;
            }

            /**
             * Sets the value of the height property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHeight(String value) {
                this.height = value;
            }

            /**
             * Gets the value of the sizeName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSizeName() {
                return sizeName;
            }

            /**
             * Sets the value of the sizeName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSizeName(String value) {
                this.sizeName = value;
            }

            /**
             * Gets the value of the subCategory property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSubCategory() {
                return subCategory;
            }

            /**
             * Sets the value of the subCategory property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSubCategory(String value) {
                this.subCategory = value;
            }

            /**
             * Gets the value of the url property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUrl() {
                return url;
            }

            /**
             * Sets the value of the url property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUrl(String value) {
                this.url = value;
            }

            /**
             * Gets the value of the width property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWidth() {
                return width;
            }

            /**
             * Sets the value of the width property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWidth(String value) {
                this.width = value;
            }

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
         *       &lt;/sequence>
         *       &lt;attribute name="caption" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="category" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="height" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="sizeName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="subCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="url" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class ThumbnailImageObj {

            @XmlAttribute(name = "caption")
            protected String caption;
            @XmlAttribute(name = "category")
            protected String category;
            @XmlAttribute(name = "height")
            protected String height;
            @XmlAttribute(name = "sizeName")
            protected String sizeName;
            @XmlAttribute(name = "subCategory")
            protected String subCategory;
            @XmlAttribute(name = "url")
            protected String url;
            @XmlAttribute(name = "width")
            protected String width;

            /**
             * Gets the value of the caption property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCaption() {
                return caption;
            }

            /**
             * Sets the value of the caption property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCaption(String value) {
                this.caption = value;
            }

            /**
             * Gets the value of the category property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCategory() {
                return category;
            }

            /**
             * Sets the value of the category property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCategory(String value) {
                this.category = value;
            }

            /**
             * Gets the value of the height property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHeight() {
                return height;
            }

            /**
             * Sets the value of the height property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHeight(String value) {
                this.height = value;
            }

            /**
             * Gets the value of the sizeName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSizeName() {
                return sizeName;
            }

            /**
             * Sets the value of the sizeName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSizeName(String value) {
                this.sizeName = value;
            }

            /**
             * Gets the value of the subCategory property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSubCategory() {
                return subCategory;
            }

            /**
             * Sets the value of the subCategory property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSubCategory(String value) {
                this.subCategory = value;
            }

            /**
             * Gets the value of the url property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUrl() {
                return url;
            }

            /**
             * Sets the value of the url property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUrl(String value) {
                this.url = value;
            }

            /**
             * Gets the value of the width property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWidth() {
                return width;
            }

            /**
             * Sets the value of the width property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWidth(String value) {
                this.width = value;
            }

        }

    }

}
