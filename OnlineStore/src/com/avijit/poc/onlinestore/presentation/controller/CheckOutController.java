package com.avijit.poc.onlinestore.presentation.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.avijit.poc.onlinestore.business.entity.Order;
import com.avijit.poc.onlinestore.business.entity.Tax;
import com.avijit.poc.onlinestore.business.service.OnlineStoreService;
import com.avijit.poc.onlinestore.business.service.jms.OrderConfirmationEmailMessageSender;
import com.avijit.poc.onlinestore.presentation.bean.Cart;
import com.avijit.poc.onlinestore.presentation.bean.OrderForm;
import com.avijit.poc.onlinestore.presentation.validator.OrderValidator;

@Controller
@RequestMapping("/checkout")
public class CheckOutController {
    
	@Autowired
	private OnlineStoreService onlineStoreService;
	
	@Autowired
	private OrderValidator orderValidator;
	
	@Autowired
    private OrderConfirmationEmailMessageSender orderConfirmationEmailMessageSender;

	@ModelAttribute("orderForm")
	public OrderForm initOrderForm(HttpServletRequest request) {
		
		OrderForm orderForm = (OrderForm) request.getSession(false).getAttribute("orderForm");
		
		if (orderForm == null) {
			orderForm = new OrderForm();
	        orderForm.setBankList(onlineStoreService.getBankList());
	        orderForm.setCreditCardTypes(onlineStoreService.getCreditCardTypeList());
	        orderForm.setShippingMethods(onlineStoreService.getShippingMethodTypeList());
	        orderForm.setCountryList(onlineStoreService.getCountryList());
		}
		
        return orderForm;
	}
	
	@RequestMapping(value = "/loadBillingPage.do")
	public String loadBillingPage() {
		return "Billing";
	}
	
	@RequestMapping(value = "/submitBillingPage.do")
	public String processBillingSubmit(HttpServletRequest request, @ModelAttribute OrderForm orderForm, BindingResult result, SessionStatus status) {
		
		//String paymentType = ServletRequestUtils.getStringParameter(request, "paymentType", "");
		//orderForm.setPaymentType(paymentType);
		
		if (orderForm.getPaymentType().equalsIgnoreCase("CC")) {
    		orderValidator.validateCreditCard(orderForm, result);
    		String creditCardExpiry = new StringBuffer(ServletRequestUtils.getStringParameter(request, "expMonth", ""))
    								.append(" / ")
    								.append(ServletRequestUtils.getStringParameter(request, "expYear", "")).toString();
            orderForm.getPaymentDataBean().setExpirationDate(creditCardExpiry);         
            
    		
    	} else {
    		orderValidator.validateBankACH(orderForm, result);
    	}
		
		orderValidator.validateBillingAddress(orderForm, result);
		
		String phone = new StringBuffer(ServletRequestUtils.getStringParameter(request, "phone1", ""))
							.append("-")
							.append(ServletRequestUtils.getStringParameter(request, "phone2", ""))
							.append("-")
							.append(ServletRequestUtils.getStringParameter(request, "phone3", "")).toString();
		orderForm.setBillingPhoneNumber(phone);
		
		request.getSession(false).setAttribute("orderForm", orderForm);
		if (result.hasErrors()) {
			return "Billing";
		} else {
			status.setComplete();
			return "Shipping";
		}
		
	}
	
	@RequestMapping(value = "/loadShippingPage.do")
	public String loadShippingPage(HttpServletRequest request) {
		return "Shipping";
	}
	
	@RequestMapping(value = "/submitShippingPage.do")
	public String processShippingSubmit(HttpServletRequest request, @ModelAttribute OrderForm orderForm, BindingResult result, SessionStatus status) {
		
   		orderValidator.validateShippingAddress(orderForm, result);
   		
   		String phone = new StringBuffer(ServletRequestUtils.getStringParameter(request, "phone1", ""))
				.append("-")
				.append(ServletRequestUtils.getStringParameter(request, "phone2", ""))
				.append("-")
				.append(ServletRequestUtils.getStringParameter(request, "phone3", "")).toString();
		orderForm.setShippingPhoneNumber(phone);
		
		request.getSession(false).setAttribute("orderForm", orderForm);
		if (result.hasErrors()) {
			return "Shipping";
		} else {
			
			Cart cart = (Cart) request.getSession().getAttribute("shoppingCart");
			double lineItemsTotal = cart.getLineItemsTotal();
			Tax tax = onlineStoreService.calculateOrderTax(lineItemsTotal);
			
			orderForm.setLineItemsTotal(lineItemsTotal);
			orderForm.setTax(tax.getTaxAmt());
			
			status.setComplete();
			return "ReviewOrder";
		}
		
	}
	
	@RequestMapping(value = "/placeOrder.do")
	public ModelAndView placeOrder(HttpServletRequest request) {
		
		Cart cart = (Cart) request.getSession().getAttribute("shoppingCart");
		OrderForm orderForm = (OrderForm) request.getSession(false).getAttribute("orderForm");
        Order order = onlineStoreService.createOrder(orderForm, cart);
        
        try {
        	//System.out.println(order);
            onlineStoreService.saveOrder(order);
            orderConfirmationEmailMessageSender.sendOrderConfirmationEmail(order);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("order", order);
        
        request.getSession().removeAttribute("shoppingCart");
        request.getSession().removeAttribute("orderForm");

        return new ModelAndView("OrderConfirm", model);
	}
	
	@RequestMapping(value = "/cancelOrder.do")
	public ModelAndView cancelOrder(HttpServletRequest request) {
        //((OrderForm)command).resetOrder();
        return new ModelAndView(new RedirectView("shoppingCart.do?operation=viewShoppingCart"));
    }
}

