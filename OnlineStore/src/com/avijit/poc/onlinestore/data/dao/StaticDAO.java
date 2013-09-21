package com.avijit.poc.onlinestore.data.dao;

import java.util.List;

import com.avijit.poc.onlinestore.business.entity.Bank;
import com.avijit.poc.onlinestore.business.entity.Country;
import com.avijit.poc.onlinestore.business.entity.CreditCardType;
import com.avijit.poc.onlinestore.business.entity.ShippingMethod;
import com.avijit.poc.onlinestore.business.entity.State;

public interface StaticDAO {
    public List<CreditCardType> getCreditCardTypeList();
    public List<ShippingMethod> getShippingMethodTypeList();
    public List<Country> getCountryList();
    public List<State> getStateListByCountryCd(String countryCd);
    public List<Bank> getBankList();
}
