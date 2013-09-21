package com.avijit.poc.onlinestore.business.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_PAYMENT_INFO")
public class OrderPaymentInfo implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="CARD_TYPE", nullable=true)
	private String cardType;

	@Column(name="CARD_HOLDER_NAME", nullable=true)
    private String cardHolderName;
	
	@Column(name="PARTIAL_CARD_NUM", nullable=true)
    private String partialCardNumber;
	
	@Column(name="EXPIRATION_DATE", nullable=true)
    private String expirationDate;
	
	@Column(name="CARD_CCV", nullable=true)
    private String ccv;
	
	@Column(name="BANK_NAME", nullable=true)
	private String bankName;
	
	@Column(name="ACH_ACCT_NUM", nullable=true)
	private String accountNumber;
	
	@Column(name="ACH_ABA_NUM", nullable=true)
	private String bankAbaNumber;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
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

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankAbaNumber() {
		return bankAbaNumber;
	}

	public void setBankAbaNumber(String bankAbaNumber) {
		this.bankAbaNumber = bankAbaNumber;
	}
	
}
