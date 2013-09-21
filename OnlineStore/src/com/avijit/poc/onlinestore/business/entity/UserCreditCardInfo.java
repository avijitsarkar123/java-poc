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

public class UserCreditCardInfo implements Serializable {
	private long id;

	private CreditCardType creditCardType;
	
	private Address address;
	
    private String cardHolderName;
	
    private String partialCardNumber;
	
    private String expirationDate;
	
    private String ccv;

    public UserCreditCardInfo() {
        address = new Address();
    }

    public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getPartialCardNumber() {
        return partialCardNumber;
    }

    public void setPartialCardNumber(String partialCardNumber) {
        this.partialCardNumber = partialCardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CreditCardType getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(CreditCardType creditCardType) {
		this.creditCardType = creditCardType;
	}

	@Override
	public String toString() {
		return "UserCreditCardInfo [id=" + id + ", creditCardType="
				+ creditCardType + ", address=" + address + ", cardHolderName="
				+ cardHolderName + ", partialCardNumber=" + partialCardNumber
				+ ", expirationDate=" + expirationDate + ", ccv=" + ccv + "]";
	}

}
