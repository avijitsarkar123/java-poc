package com.avijit.poc.onlinestore.business.service;

import java.util.List;

import com.avijit.poc.onlinestore.business.entity.Bank;
import com.avijit.poc.onlinestore.business.entity.Country;
import com.avijit.poc.onlinestore.business.entity.CreditCardType;
import com.avijit.poc.onlinestore.business.entity.Manufacturer;
import com.avijit.poc.onlinestore.business.entity.Order;
import com.avijit.poc.onlinestore.business.entity.Part;
import com.avijit.poc.onlinestore.business.entity.PartSpecification;
import com.avijit.poc.onlinestore.business.entity.PartType;
import com.avijit.poc.onlinestore.business.entity.ShippingMethod;
import com.avijit.poc.onlinestore.business.entity.State;
import com.avijit.poc.onlinestore.business.entity.Tax;
import com.avijit.poc.onlinestore.presentation.bean.Cart;
import com.avijit.poc.onlinestore.presentation.bean.OrderForm;

public interface OnlineStoreService {
    public List<PartType> getPartTypeList();
    public List<Manufacturer> getManufacturerList();
    public List<Part> getPartsByManufacturer(int manufacturerId);
    public List<Part> getPartsByPartType(int partTypeId);
    public Part getPartDetailsByPartCd(int partId);
    public List<PartSpecification> getPartSpecification(int partId);
    public List<CreditCardType> getCreditCardTypeList();
    public List<ShippingMethod> getShippingMethodTypeList();
    public List<Country> getCountryList();
    public List<Bank> getBankList();
    public List<State> getStateListByCountryCd(String countryCd);
    public double getShippingRateByShippingMethod(String shippingMethodCd);
    public Tax calculateOrderTax(double lineItemTotal);
    public Order createOrder(OrderForm orderForm, Cart shoppingCart);
    public boolean saveOrder(Order order);
}


