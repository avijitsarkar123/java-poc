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
@Table(name="ORDER_BILLING")
public class OrderBilling  implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="ORDER_NUM")
    private String orderNum;
	
	@Column(name="LINE_ITEM_TOTAL")
	private double lineItemTotal;
	
	@Column(name="SHIPPING_PRICE")
	private double shippingPrice;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH}, fetch=FetchType.LAZY)
	@JoinColumn(name="TAX_ID", referencedColumnName="ID")
    private Tax tax;
	
	@Column(name="ORDER_TOTAL")
	private double orderTotal;
	
	@Column(name="PAYMENT_TYPE")
    private String paymentType;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH}, fetch=FetchType.LAZY)
	@JoinColumn(name="ORDER_PAYMENT_INFO_ID", referencedColumnName="ID")
    private OrderPaymentInfo orderPaymentInfo;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH}, fetch=FetchType.LAZY)
	@JoinColumn(name="ADDRESS_ID", referencedColumnName="ID")
    private Address billingAddress;

	
    public OrderBilling() {
		this.orderPaymentInfo = new OrderPaymentInfo();
        this.billingAddress = new Address();
        this.tax =  new Tax();
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public double getShippingPrice() {
		return shippingPrice;
	}

	public void setShippingPrice(double shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

	public double getLineItemTotal() {
		return lineItemTotal;
	}

	public void setLineItemTotal(double lineItemTotal) {
		this.lineItemTotal = lineItemTotal;
	}

	public Tax getTax() {
		return tax;
	}

	public void setTax(Tax tax) {
		this.tax = tax;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
    
	public OrderPaymentInfo getOrderPaymentInfo() {
		return orderPaymentInfo;
	}

	public void setOrderPaymentInfo(OrderPaymentInfo orderPaymentInfo) {
		this.orderPaymentInfo = orderPaymentInfo;
	}

	@Override
	public String toString() {
		return "OrderBilling [id=" + id + ", orderNum=" + orderNum
				+ paymentType + ", billingAddress=" + billingAddress
				+ ", shippingPrice=" + shippingPrice + ", lineItemTotal="
				+ lineItemTotal + ", tax=" + tax + ", orderTotal=" + orderTotal
				+ "]";
	}

}
