package com.avijit.poc.onlinestore.presentation.bean;


public class PaymentDataBean {
	
	// Credit Card Data
	private String creditCardTypeId;
	private String cardHolderName;
    private String partialCardNumber;
    private String expirationDate;
    private String ccv;
    
    // Bank Account Data
    private String bankTypeId;
	private String accountNumber;
	private String bankAbaNumber;
	
	public String getCreditCardTypeId() {
		return creditCardTypeId;
	}
	public void setCreditCardTypeId(String creditCardTypeCode) {
		this.creditCardTypeId = creditCardTypeCode;
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
	public String getBankTypeId() {
		return bankTypeId;
	}
	public void setBankTypeId(String bankTypeCode) {
		this.bankTypeId = bankTypeCode;
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
