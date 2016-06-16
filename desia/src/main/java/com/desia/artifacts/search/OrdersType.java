
package com.desia.artifacts.search;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrdersType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrdersType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Order" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Products" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Product" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="DiscountCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="ListOfRecipientRPH">
 *                                       &lt;simpleType>
 *                                         &lt;list itemType="{http://www.w3.org/2001/XMLSchema}string" />
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                     &lt;attribute name="ProductID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="ProductIssueDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="ProductQuantity" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                                     &lt;attribute name="ProductSerialNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="ProductType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="Status" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                                     &lt;attribute name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="DecimalPlaces" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="ListOfRecipientRPH">
 *                   &lt;simpleType>
 *                     &lt;list itemType="{http://www.w3.org/2001/XMLSchema}string" />
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="OrderID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="OrderType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="DiscountCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="OrderID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="OrderType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="VendorPurchaseOrderID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrdersType", propOrder = {
    "order"
})
public class OrdersType {

    @XmlElement(name = "Order")
    protected List<OrdersType.Order> order;
    @XmlAttribute(name = "DiscountCode")
    protected String discountCode;
    @XmlAttribute(name = "OrderID")
    protected String orderID;
    @XmlAttribute(name = "OrderType")
    protected String orderType;
    @XmlAttribute(name = "VendorPurchaseOrderID")
    protected String vendorPurchaseOrderID;

    /**
     * Gets the value of the order property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the order property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrder().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrdersType.Order }
     * 
     * 
     */
    public List<OrdersType.Order> getOrder() {
        if (order == null) {
            order = new ArrayList<OrdersType.Order>();
        }
        return this.order;
    }

    /**
     * Gets the value of the discountCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscountCode() {
        return discountCode;
    }

    /**
     * Sets the value of the discountCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscountCode(String value) {
        this.discountCode = value;
    }

    /**
     * Gets the value of the orderID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * Sets the value of the orderID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderID(String value) {
        this.orderID = value;
    }

    /**
     * Gets the value of the orderType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * Sets the value of the orderType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderType(String value) {
        this.orderType = value;
    }

    /**
     * Gets the value of the vendorPurchaseOrderID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVendorPurchaseOrderID() {
        return vendorPurchaseOrderID;
    }

    /**
     * Sets the value of the vendorPurchaseOrderID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVendorPurchaseOrderID(String value) {
        this.vendorPurchaseOrderID = value;
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
     *         &lt;element name="Products" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Product" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                           &lt;/sequence>
     *                           &lt;attribute name="DiscountCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="ListOfRecipientRPH">
     *                             &lt;simpleType>
     *                               &lt;list itemType="{http://www.w3.org/2001/XMLSchema}string" />
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                           &lt;attribute name="ProductID" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="ProductIssueDate" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="ProductQuantity" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                           &lt;attribute name="ProductSerialNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="ProductType" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="Status" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *                           &lt;attribute name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="DecimalPlaces" type="{http://www.w3.org/2001/XMLSchema}integer" />
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
     *       &lt;attribute name="ListOfRecipientRPH">
     *         &lt;simpleType>
     *           &lt;list itemType="{http://www.w3.org/2001/XMLSchema}string" />
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="OrderID" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="OrderType" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "products"
    })
    public static class Order {

        @XmlElement(name = "Products")
        protected OrdersType.Order.Products products;
        @XmlAttribute(name = "ListOfRecipientRPH")
        protected List<String> listOfRecipientRPH;
        @XmlAttribute(name = "OrderID")
        protected String orderID;
        @XmlAttribute(name = "OrderType")
        protected String orderType;

        /**
         * Gets the value of the products property.
         * 
         * @return
         *     possible object is
         *     {@link OrdersType.Order.Products }
         *     
         */
        public OrdersType.Order.Products getProducts() {
            return products;
        }

        /**
         * Sets the value of the products property.
         * 
         * @param value
         *     allowed object is
         *     {@link OrdersType.Order.Products }
         *     
         */
        public void setProducts(OrdersType.Order.Products value) {
            this.products = value;
        }

        /**
         * Gets the value of the listOfRecipientRPH property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the listOfRecipientRPH property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getListOfRecipientRPH().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getListOfRecipientRPH() {
            if (listOfRecipientRPH == null) {
                listOfRecipientRPH = new ArrayList<String>();
            }
            return this.listOfRecipientRPH;
        }

        /**
         * Gets the value of the orderID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrderID() {
            return orderID;
        }

        /**
         * Sets the value of the orderID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrderID(String value) {
            this.orderID = value;
        }

        /**
         * Gets the value of the orderType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrderType() {
            return orderType;
        }

        /**
         * Sets the value of the orderType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrderType(String value) {
            this.orderType = value;
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
         *         &lt;element name="Product" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                 &lt;/sequence>
         *                 &lt;attribute name="DiscountCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="ListOfRecipientRPH">
         *                   &lt;simpleType>
         *                     &lt;list itemType="{http://www.w3.org/2001/XMLSchema}string" />
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *                 &lt;attribute name="ProductID" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="ProductIssueDate" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="ProductQuantity" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *                 &lt;attribute name="ProductSerialNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="ProductType" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="Status" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
         *                 &lt;attribute name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="DecimalPlaces" type="{http://www.w3.org/2001/XMLSchema}integer" />
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
            "product"
        })
        public static class Products {

            @XmlElement(name = "Product")
            protected List<OrdersType.Order.Products.Product> product;

            /**
             * Gets the value of the product property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the product property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getProduct().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link OrdersType.Order.Products.Product }
             * 
             * 
             */
            public List<OrdersType.Order.Products.Product> getProduct() {
                if (product == null) {
                    product = new ArrayList<OrdersType.Order.Products.Product>();
                }
                return this.product;
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
             *       &lt;attribute name="DiscountCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="ListOfRecipientRPH">
             *         &lt;simpleType>
             *           &lt;list itemType="{http://www.w3.org/2001/XMLSchema}string" />
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *       &lt;attribute name="ProductID" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="ProductIssueDate" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="ProductQuantity" type="{http://www.w3.org/2001/XMLSchema}integer" />
             *       &lt;attribute name="ProductSerialNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="ProductType" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="Status" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
             *       &lt;attribute name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="DecimalPlaces" type="{http://www.w3.org/2001/XMLSchema}integer" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Product {

                @XmlAttribute(name = "DiscountCode")
                protected String discountCode;
                @XmlAttribute(name = "ListOfRecipientRPH")
                protected List<String> listOfRecipientRPH;
                @XmlAttribute(name = "ProductID")
                protected String productID;
                @XmlAttribute(name = "ProductIssueDate")
                protected String productIssueDate;
                @XmlAttribute(name = "ProductQuantity")
                protected BigInteger productQuantity;
                @XmlAttribute(name = "ProductSerialNumber")
                protected String productSerialNumber;
                @XmlAttribute(name = "ProductType")
                protected String productType;
                @XmlAttribute(name = "Status")
                protected String status;
                @XmlAttribute(name = "Amount")
                protected BigDecimal amount;
                @XmlAttribute(name = "CurrencyCode")
                protected String currencyCode;
                @XmlAttribute(name = "DecimalPlaces")
                protected BigInteger decimalPlaces;

                /**
                 * Gets the value of the discountCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDiscountCode() {
                    return discountCode;
                }

                /**
                 * Sets the value of the discountCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDiscountCode(String value) {
                    this.discountCode = value;
                }

                /**
                 * Gets the value of the listOfRecipientRPH property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the listOfRecipientRPH property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getListOfRecipientRPH().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link String }
                 * 
                 * 
                 */
                public List<String> getListOfRecipientRPH() {
                    if (listOfRecipientRPH == null) {
                        listOfRecipientRPH = new ArrayList<String>();
                    }
                    return this.listOfRecipientRPH;
                }

                /**
                 * Gets the value of the productID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getProductID() {
                    return productID;
                }

                /**
                 * Sets the value of the productID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setProductID(String value) {
                    this.productID = value;
                }

                /**
                 * Gets the value of the productIssueDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getProductIssueDate() {
                    return productIssueDate;
                }

                /**
                 * Sets the value of the productIssueDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setProductIssueDate(String value) {
                    this.productIssueDate = value;
                }

                /**
                 * Gets the value of the productQuantity property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getProductQuantity() {
                    return productQuantity;
                }

                /**
                 * Sets the value of the productQuantity property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setProductQuantity(BigInteger value) {
                    this.productQuantity = value;
                }

                /**
                 * Gets the value of the productSerialNumber property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getProductSerialNumber() {
                    return productSerialNumber;
                }

                /**
                 * Sets the value of the productSerialNumber property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setProductSerialNumber(String value) {
                    this.productSerialNumber = value;
                }

                /**
                 * Gets the value of the productType property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getProductType() {
                    return productType;
                }

                /**
                 * Sets the value of the productType property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setProductType(String value) {
                    this.productType = value;
                }

                /**
                 * Gets the value of the status property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getStatus() {
                    return status;
                }

                /**
                 * Sets the value of the status property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setStatus(String value) {
                    this.status = value;
                }

                /**
                 * Gets the value of the amount property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getAmount() {
                    return amount;
                }

                /**
                 * Sets the value of the amount property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setAmount(BigDecimal value) {
                    this.amount = value;
                }

                /**
                 * Gets the value of the currencyCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCurrencyCode() {
                    return currencyCode;
                }

                /**
                 * Sets the value of the currencyCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCurrencyCode(String value) {
                    this.currencyCode = value;
                }

                /**
                 * Gets the value of the decimalPlaces property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getDecimalPlaces() {
                    return decimalPlaces;
                }

                /**
                 * Sets the value of the decimalPlaces property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setDecimalPlaces(BigInteger value) {
                    this.decimalPlaces = value;
                }

            }

        }

    }

}
