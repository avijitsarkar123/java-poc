package com.avijit.poc.onlinestore.presentation.validator;

import org.apache.oro.text.perl.Perl5Util;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.avijit.poc.onlinestore.presentation.bean.OrderForm;

@Component("orderValidator")
public class OrderValidator implements Validator {
    private static final String PHONE_REGEXP = "/(\\({0,1})(\\d{3})(\\){0,1})(\\s|-)*(\\d{3})(\\s|-)*(\\d{4})/";
    private static final String CC_EXPIRATION_REGEX = "(0[1-9]|1[1-2])[ \\ ](2008-2012)";

    public boolean supports(Class clazz) {
        return OrderForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object obj, Errors errors) {
        validateCreditCard((OrderForm) obj, errors);
        validateBillingAddress((OrderForm) obj, errors);
        validateShippingAddress((OrderForm) obj, errors);
    }

    public void validateCreditCard(OrderForm orderForm, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "paymentDataBean.partialCardNumber", "CCN_REQUIRED", "FAKE (!) credit card number required.");
        /*String expirationDate = orderForm.getPaymentDataBean().getExpirationDate();
        Perl5Util perl5Util = new Perl5Util();
        if (!perl5Util.match(expirationDate, CC_EXPIRATION_REGEX)) {
        	errors.rejectValue("paymentDataBean.expirationDate","CC_EXPIRATION_DATE", "Please enter a valid expiration date.");
        }*/
        
        ValidationUtils.rejectIfEmpty(errors, "paymentDataBean.creditCardTypeId", "CARD_TYPE_REQUIRED", "Card type is required.");
        ValidationUtils.rejectIfEmpty(errors, "paymentDataBean.ccv", "CCV_CODE_REQUIRED", "CCV/CID is required.");
    }
    
    public void validateBankACH(OrderForm orderForm, Errors errors) {
    	ValidationUtils.rejectIfEmpty(errors, "paymentDataBean.bankTypeId", "BANK_REQUIRED", "Bank Name is required.");
        ValidationUtils.rejectIfEmpty(errors, "paymentDataBean.accountNumber", "ACCT_NO_REQUIRED", "Bank Account Number is required.");
        ValidationUtils.rejectIfEmpty(errors, "paymentDataBean.bankAbaNumber", "ACCT_ABA_REQUIRED", "Bank Routing Number is required.");
    }

    public void validateBillingAddress(OrderForm orderForm, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "billingName", "NAME_REQUIRED", "Full Name is required.");
        ValidationUtils.rejectIfEmpty(errors, "billingAddressLine1", "ADDRESS1_REQUIRED", "Address is required.");
        ValidationUtils.rejectIfEmpty(errors, "billingCity", "CITY_REQUIRED", "City is required.");
        /*ValidationUtils.rejectIfEmpty(errors, "billingState", "STATE_REQUIRED", "State is required.");*/
        ValidationUtils.rejectIfEmpty(errors, "billingZip", "ZIP_REQUIRED", "Zip code is required.");
        ValidationUtils.rejectIfEmpty(errors, "billingCountry", "COUNTRY_REQUIRED", "Country is required.");
        validatePhoneNumber(orderForm, errors, 0);
    }

    public void validateShippingAddress(OrderForm orderFrom, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "shippingMethodCode", "SHIPPING_METHOD_REQUIRED", "Shipping method is required.");
        ValidationUtils.rejectIfEmpty(errors, "shippingName", "NAME_REQUIRED", "Full Name is required.");
        ValidationUtils.rejectIfEmpty(errors, "shippingAddressLine1", "ADDRESS1_REQUIRED", "Address is required.");
        ValidationUtils.rejectIfEmpty(errors, "shippingCity", "CITY_REQUIRED", "City is required.");
        ValidationUtils.rejectIfEmpty(errors, "shippingState", "STATE_REQUIRED", "State is required.");
        ValidationUtils.rejectIfEmpty(errors, "shippingZip", "ZIP_REQUIRED", "Zip/postal code is required.");
        ValidationUtils.rejectIfEmpty(errors, "shippingCountry", "COUNTRY_REQUIRED", "Country is required.");
        validatePhoneNumber(orderFrom, errors, 1);
    }

    private void validatePhoneNumber(OrderForm orderFrom, Errors errors, int pageNum) {
        String phone = (pageNum == 0 ) ? orderFrom.getBillingPhoneNumber() : orderFrom.getShippingPhoneNumber();
        
        if (phone != null && !phone.trim().equalsIgnoreCase("--")) {
            Perl5Util perl5Util = new Perl5Util();
            if(!perl5Util.match(PHONE_REGEXP, phone)) {
            	if (pageNum == 0) {
            		errors.rejectValue("billingPhoneNumber", "invalid.phone", "Phone number is invalid");
            	} else {
            		errors.rejectValue("shippingPhoneNumber", "invalid.phone", "Phone number is invalid");
            	}
            }
        }
    }
}
