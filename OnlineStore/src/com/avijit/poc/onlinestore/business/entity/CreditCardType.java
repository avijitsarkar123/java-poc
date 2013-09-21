package com.avijit.poc.onlinestore.business.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CREDITCARD_TYPE")
public class CreditCardType  implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="CREDIT_CARD_CD", nullable=false)
	private String creditCardCd;
	
	@Column(name="CREDIT_CARD_NAME", nullable=false)
    private String creditCardName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreditCardCd() {
        return creditCardCd;
    }

    public void setCreditCardCd(String creditCardCd) {
        this.creditCardCd = creditCardCd;
    }

    public String getCreditCardName() {
        return creditCardName;
    }

    public void setCreditCardName(String creditCardName) {
        this.creditCardName = creditCardName;
    }

	@Override
	public String toString() {
		return "CreditCardType [id=" + id + ", creditCardCd=" + creditCardCd
				+ ", creditCardName=" + creditCardName + "]";
	}
    
}
