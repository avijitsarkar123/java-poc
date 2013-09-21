package com.avijit.poc.onlinestore.business.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="STORE_ORDER")
public class Order implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="ORDER_NUMBER", nullable=false)
	private String orderNumber;
	
	@Column(name="ORDER_CREATION_TIME", nullable=false)
    private String orderCreationDate;
	
	@OneToMany(mappedBy="order", cascade= {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH}, fetch=FetchType.EAGER)
    private Set<LineItem> lineItemList;
	
    @OneToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinColumn(name="BILLING_ID", referencedColumnName="ID", updatable=false, nullable=false)
	private OrderBilling orderBilling;
    
    @OneToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinColumn(name="SHIPPING_ID", referencedColumnName="ID", updatable=false, nullable=false)
    private OrderShipping orderShipping;

    public Order() {
        lineItemList = new HashSet<LineItem>();
        orderBilling = new OrderBilling();
        orderShipping = new OrderShipping();
    }
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public OrderBilling getOrderBilling() {
        return orderBilling;
    }

    public void setOrderBilling(OrderBilling orderBilling) {
        this.orderBilling = orderBilling;
    }

    public Set<LineItem> getLineItemList() {
        return lineItemList;
    }

    public void setLineItemList(Set<LineItem> lineItemList) {
        this.lineItemList = lineItemList;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrderShipping getOrderShipping() {
        return orderShipping;
    }

    public void setOrderShipping(OrderShipping orderShipping) {
        this.orderShipping = orderShipping;
    }

    public Iterator<LineItem> getLineItems() {
        return lineItemList.iterator();
    }

	public String getOrderCreationDate() {
		return orderCreationDate;
	}

	public void setOrderCreationDate(String orderCreationDate) {
		this.orderCreationDate = orderCreationDate;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNumber=" + orderNumber
				+ ", orderCreationDate=" + orderCreationDate
				+ ", lineItemList=" + lineItemList + ", orderBilling="
				+ orderBilling + ", orderShipping=" + orderShipping + "]";
	}
}
