package com.avijit.poc.onlinestore.business.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_SHIPPING")
public class OrderShipping  implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="ORDER_NUM")
    private String orderNum;
	
	@OneToOne(cascade={CascadeType.REFRESH}, fetch=FetchType.LAZY)
	@JoinColumn(name="PAYMENT_ID", referencedColumnName="ID")
    private ShippingMethod orderShippingMethod;
	
	@Column(name="SHIPPING_COST")
    private double shippingCost;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH}, fetch=FetchType.LAZY)
	@JoinColumn(name="ADDRESS_ID", referencedColumnName="ID")
    private Address shippingAddress;

    public OrderShipping() {
        this.orderShippingMethod = new ShippingMethod();
        this.shippingAddress = new Address();
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public ShippingMethod getOrderShippingMethod() {
        return orderShippingMethod;
    }

    public void setOrderShippingMethod(ShippingMethod orderShippingMethod) {
        this.orderShippingMethod = orderShippingMethod;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

	@Override
	public String toString() {
		return "OrderShipping [id=" + id + ", orderNum=" + orderNum
				+ ", orderShippingMethod=" + orderShippingMethod
				+ ", shippingCost=" + shippingCost + ", shippingAddress="
				+ shippingAddress + "]";
	}

}
