//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.08.19 at 12:48:38 AM EDT 
//


package com.avijit.poc.onlinestore.orderbo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="orderNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="orderDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://onlinestore.com/OrderService/schema}lineItems"/>
 *         &lt;element ref="{http://onlinestore.com/OrderService/schema}orderBilling"/>
 *         &lt;element ref="{http://onlinestore.com/OrderService/schema}orderShipping"/>
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
    "orderNumber",
    "orderDate",
    "lineItems",
    "orderBilling",
    "orderShipping"
})
@XmlRootElement(name = "order")
public class Order {

    @XmlElement(required = true)
    protected String orderNumber;
    @XmlElement(required = true)
    protected String orderDate;
    @XmlElement(namespace = "http://onlinestore.com/OrderService/schema", required = true)
    protected LineItems lineItems;
    @XmlElement(namespace = "http://onlinestore.com/OrderService/schema", required = true)
    protected OrderBilling orderBilling;
    @XmlElement(namespace = "http://onlinestore.com/OrderService/schema", required = true)
    protected OrderShipping orderShipping;

    /**
     * Gets the value of the orderNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * Sets the value of the orderNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderNumber(String value) {
        this.orderNumber = value;
    }

    /**
     * Gets the value of the orderDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * Sets the value of the orderDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderDate(String value) {
        this.orderDate = value;
    }

    /**
     * Gets the value of the lineItems property.
     * 
     * @return
     *     possible object is
     *     {@link LineItems }
     *     
     */
    public LineItems getLineItems() {
        return lineItems;
    }

    /**
     * Sets the value of the lineItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineItems }
     *     
     */
    public void setLineItems(LineItems value) {
        this.lineItems = value;
    }

    /**
     * Gets the value of the orderBilling property.
     * 
     * @return
     *     possible object is
     *     {@link OrderBilling }
     *     
     */
    public OrderBilling getOrderBilling() {
        return orderBilling;
    }

    /**
     * Sets the value of the orderBilling property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderBilling }
     *     
     */
    public void setOrderBilling(OrderBilling value) {
        this.orderBilling = value;
    }

    /**
     * Gets the value of the orderShipping property.
     * 
     * @return
     *     possible object is
     *     {@link OrderShipping }
     *     
     */
    public OrderShipping getOrderShipping() {
        return orderShipping;
    }

    /**
     * Sets the value of the orderShipping property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderShipping }
     *     
     */
    public void setOrderShipping(OrderShipping value) {
        this.orderShipping = value;
    }

}
