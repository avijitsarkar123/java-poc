package com.avijit.poc.onlinestore.presentation.ajaxcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avijit.poc.onlinestore.business.entity.Address;
import com.avijit.poc.onlinestore.business.entity.State;
import com.avijit.poc.onlinestore.business.service.OnlineStoreService;
import com.avijit.poc.onlinestore.presentation.bean.Cart;
import com.avijit.poc.onlinestore.presentation.bean.OrderForm;

@Service("onlineStoreAjaxService") 
@RemoteProxy(name="onlineStoreAjaxService") 
public class OnlineStoreAjaxService {
	
	@Autowired
    private OnlineStoreService onlineStoreService;

    public void setOnlineStoreService(OnlineStoreService onlineStoreService) {
        this.onlineStoreService = onlineStoreService;
    }

    @RemoteMethod
    public String getLineItemsCountAndTotal(HttpServletRequest request) {
        Cart cart = (Cart) request.getSession().getAttribute("shoppingCart");
        return (cart == null) ? "0~0.00" : new StringBuffer(Integer.toString(cart.getCartItems().size())).append("~").append(Double.toString(cart.getLineItemsTotal())).toString();
    }

    @RemoteMethod
    public Address getShippingAddressSameAsBillingAddress(HttpServletRequest request) {
        OrderForm orderForm = (OrderForm) request.getSession().getAttribute("orderForm");
        return orderForm.getBillingAddressInfo();
    }

    @RemoteMethod
    public State[] getStatesByCountry(String countryCd) {
        List stateList = onlineStoreService.getStateListByCountryCd(countryCd);
        return (State[]) stateList.toArray(new State[stateList.size()]);
    }

    @RemoteMethod
    public double getShippingRateByShippingMethod(String shippingMethodCd) {
        return onlineStoreService.getShippingRateByShippingMethod(shippingMethodCd);
    }
}
