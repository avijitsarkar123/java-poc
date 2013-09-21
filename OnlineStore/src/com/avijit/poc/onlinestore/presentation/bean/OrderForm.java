package com.avijit.poc.onlinestore.presentation.bean;

import java.text.DecimalFormat;
import java.util.List;

import com.avijit.poc.onlinestore.business.entity.Address;
import com.avijit.poc.onlinestore.business.entity.Bank;
import com.avijit.poc.onlinestore.business.entity.Country;
import com.avijit.poc.onlinestore.business.entity.CreditCardType;
import com.avijit.poc.onlinestore.business.entity.ShippingMethod;


public class OrderForm {

	private static final DecimalFormat DECIMAL_FORMATTER = new DecimalFormat("#,###,###,##0.00");
	
	private String paymentType;
    private PaymentDataBean paymentDataBean;
    
    //Billing Info
    private String billingName;
    private String billingAddressLine1;
    private String billingAddressLine2;
    private String billingCity;
    private String billingState;
    private String billingZip;
    private String billingCountry;
    private String billingPhoneNumber;
    
    //Shipping Info
    private String shippingMethodCode;
    private String shippingMethodName;
    private String shippingCarrier;
    private String shippingName;
    private String shippingAddressLine1;
    private String shippingAddressLine2;
    private String shippingCity;
    private String shippingState;
    private String shippingZip;
    private String shippingCountry;
    private String shippingPhoneNumber;
    
    //Static Order Form Data
    private List<CreditCardType> creditCardTypes;
    private List<Bank> bankList;
    private List<ShippingMethod> shippingMethods;
    private List<Country> countryList;
    
    private double lineItemsTotal;
    private String shippingRate;
    private double tax;
    private double orderTotal;

    public OrderForm() {
        paymentDataBean = new PaymentDataBean();
    }

    public PaymentDataBean getPaymentDataBean() {
		return paymentDataBean;
	}
    
	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getBillingName() {
		return billingName;
	}

	public void setBillingName(String billingName) {
		this.billingName = billingName;
	}

	public String getBillingAddressLine1() {
		return billingAddressLine1;
	}

	public void setBillingAddressLine1(String billingAddressLine1) {
		this.billingAddressLine1 = billingAddressLine1;
	}

	public String getBillingAddressLine2() {
		return billingAddressLine2;
	}

	public void setBillingAddressLine2(String billingAddressLine2) {
		this.billingAddressLine2 = billingAddressLine2;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getBillingState() {
		return billingState;
	}

	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}

	public String getBillingZip() {
		return billingZip;
	}

	public void setBillingZip(String billingZip) {
		this.billingZip = billingZip;
	}

	public String getBillingCountry() {
		return billingCountry;
	}

	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}

	public String getBillingPhoneNumber() {
		return billingPhoneNumber;
	}

	public void setBillingPhoneNumber(String billingPhoneNumber) {
		this.billingPhoneNumber = billingPhoneNumber;
	}

	public String getShippingMethodCode() {
		return shippingMethodCode;
	}

	public void setShippingMethodCode(String shippingMethodCode) {
		this.shippingMethodCode = shippingMethodCode;
	}

	public String getShippingCarrier() {
		return shippingCarrier;
	}

	public void setShippingCarrier(String shippingCarrier) {
		this.shippingCarrier = shippingCarrier;
	}

	public String getShippingName() {
		return shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	public String getShippingAddressLine1() {
		return shippingAddressLine1;
	}

	public void setShippingAddressLine1(String shippingAddressLine1) {
		this.shippingAddressLine1 = shippingAddressLine1;
	}

	public String getShippingAddressLine2() {
		return shippingAddressLine2;
	}

	public void setShippingAddressLine2(String shippingAddressLine2) {
		this.shippingAddressLine2 = shippingAddressLine2;
	}

	public String getShippingCity() {
		return shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getShippingState() {
		return shippingState;
	}

	public void setShippingState(String shippingState) {
		this.shippingState = shippingState;
	}

	public String getShippingZip() {
		return shippingZip;
	}

	public void setShippingZip(String shippingZip) {
		this.shippingZip = shippingZip;
	}

	public String getShippingCountry() {
		return shippingCountry;
	}

	public void setShippingCountry(String shippingCountry) {
		this.shippingCountry = shippingCountry;
	}

	public String getShippingPhoneNumber() {
		return shippingPhoneNumber;
	}

	public void setShippingPhoneNumber(String shippingPhoneNumber) {
		this.shippingPhoneNumber = shippingPhoneNumber;
	}

	public void setPaymentDataBean(PaymentDataBean paymentDataBean) {
		this.paymentDataBean = paymentDataBean;
	}

	public String getShippingRate() {
		return shippingRate;
	}

	public void setShippingRate(String shippingRate) {
		this.shippingRate = shippingRate;
	}
	
	public String getShippingMethodName() {
		return shippingMethodName;
	}

	public void setShippingMethodName(String shippingMethodName) {
		this.shippingMethodName = shippingMethodName;
	}

	public List<CreditCardType> getCreditCardTypes() {
		return creditCardTypes;
	}

	public void setCreditCardTypes(List<CreditCardType> creditCardTypes) {
		this.creditCardTypes = creditCardTypes;
	}

	public List<Bank> getBankList() {
		return bankList;
	}

	public void setBankList(List<Bank> bankList) {
		this.bankList = bankList;
	}

	public List<ShippingMethod> getShippingMethods() {
		return shippingMethods;
	}

	public void setShippingMethods(List<ShippingMethod> shippingMethods) {
		this.shippingMethods = shippingMethods;
	}

	public List<Country> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}
	
	public String getLineItemsTotal() {
		return DECIMAL_FORMATTER.format(lineItemsTotal);
	}

	public void setLineItemsTotal(double lineItemsTotal) {
		this.lineItemsTotal = lineItemsTotal;
	}

	public String getTax() {
		return DECIMAL_FORMATTER.format(tax);
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public String getOrderTotal() {
		orderTotal = lineItemsTotal + Double.parseDouble(shippingRate) + tax;
		return DECIMAL_FORMATTER.format(orderTotal);
	}

	public Address getShippingAddressInfo() {
		Address address = new Address();
		address.setAddressType("S");
		address.setName(shippingName);
		address.setAddressLine1(shippingAddressLine1);
		address.setAddressLine2(shippingAddressLine2);
		address.setCity(shippingCity);
		address.setState(shippingState);
		address.setZip(shippingZip);
		address.setCountry(shippingCountry);
		address.setPhoneNumber(shippingPhoneNumber);
		return address;
	}
	
	public Address getBillingAddressInfo() {
		Address address = new Address();
		address.setAddressType("B");
		address.setName(billingName);
		address.setAddressLine1(billingAddressLine1);
		address.setAddressLine2(billingAddressLine2);
		address.setCity(billingCity);
		address.setState(billingState);
		address.setZip(billingZip);
		address.setCountry(billingCountry);
		address.setPhoneNumber(billingPhoneNumber);
		return address;
	}
	
	public ShippingMethod getShippingMethodInfo() {
		for (ShippingMethod shippingMethod : getShippingMethods()) {
    		if (shippingMethod.getShippingMethodCd().equals(shippingMethodCode)) {
    			return shippingMethod;
    		}
    	}
		return null;
	}
	
	public CreditCardType getCreditCardTypeInfo() {
		for (CreditCardType creditCardType : getCreditCardTypes()) {
    		if (creditCardType.getId() == Long.parseLong(getPaymentDataBean().getCreditCardTypeId())) {
    			return creditCardType;
    		}
    	}
		return null;
	}
	
	public Bank getBankInfo() {
		for (Bank bank : getBankList()) {
    		if (bank.getId() == Long.parseLong(getPaymentDataBean().getBankTypeId())) {
    			return bank;
    		}
    	}
		return null;
	}
	
}
