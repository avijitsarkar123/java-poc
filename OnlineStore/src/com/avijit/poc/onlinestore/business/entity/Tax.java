package com.avijit.poc.onlinestore.business.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TAX")
public class Tax  implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="TAX_RATE", nullable=false)
	private double taxRate;
	
	@Column(name="TAX_AMT", nullable=false)
    private double taxAmt;

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getTaxAmt() {
        return taxAmt;
    }

    public void setTaxAmt(double taxAmt) {
        this.taxAmt = taxAmt;
    }

	@Override
	public String toString() {
		return "Tax [id=" + id + ", taxRate=" + taxRate + ", taxAmt=" + taxAmt
				+ "]";
	}
}
