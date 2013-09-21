package com.avijit.poc.onlinestore.business.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SHIPPING_METHOD")
public class ShippingMethod  implements Serializable {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="CARRIER", nullable=false)
    private String carrier;
	
	@Column(name="SHIP_METHOD_CD", nullable=false)
    private String shippingMethodCd;
	
	@Column(name="SHIP_METHOD_NAME", nullable=false)
    private String shippingMethodName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getShippingMethodCd() {
        return shippingMethodCd;
    }

    public void setShippingMethodCd(String shippingMethodCd) {
        this.shippingMethodCd = shippingMethodCd;
    }

    public String getShippingMethodName() {
        return shippingMethodName;
    }

    public void setShippingMethodName(String shippingMethodName) {
        this.shippingMethodName = shippingMethodName;
    }

	@Override
	public String toString() {
		return "ShippingMethod [id=" + id + ", carrier=" + carrier
				+ ", shippingMethodCd=" + shippingMethodCd
				+ ", shippingMethodName=" + shippingMethodName + "]";
	}
}
