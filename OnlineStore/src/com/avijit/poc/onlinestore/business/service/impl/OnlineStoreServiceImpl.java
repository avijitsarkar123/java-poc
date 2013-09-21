package com.avijit.poc.onlinestore.business.service.impl;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.avijit.poc.onlinestore.business.entity.Bank;
import com.avijit.poc.onlinestore.business.entity.Country;
import com.avijit.poc.onlinestore.business.entity.CreditCardType;
import com.avijit.poc.onlinestore.business.entity.LineItem;
import com.avijit.poc.onlinestore.business.entity.Manufacturer;
import com.avijit.poc.onlinestore.business.entity.Order;
import com.avijit.poc.onlinestore.business.entity.OrderBilling;
import com.avijit.poc.onlinestore.business.entity.OrderPaymentInfo;
import com.avijit.poc.onlinestore.business.entity.OrderShipping;
import com.avijit.poc.onlinestore.business.entity.Part;
import com.avijit.poc.onlinestore.business.entity.PartSpecification;
import com.avijit.poc.onlinestore.business.entity.PartType;
import com.avijit.poc.onlinestore.business.entity.ShippingMethod;
import com.avijit.poc.onlinestore.business.entity.State;
import com.avijit.poc.onlinestore.business.entity.Tax;
import com.avijit.poc.onlinestore.business.service.OnlineStoreService;
import com.avijit.poc.onlinestore.data.dao.ManufacturerDAO;
import com.avijit.poc.onlinestore.data.dao.OrderDAO;
import com.avijit.poc.onlinestore.data.dao.PartDAO;
import com.avijit.poc.onlinestore.data.dao.PartTypeDAO;
import com.avijit.poc.onlinestore.data.dao.StaticDAO;
import com.avijit.poc.onlinestore.presentation.bean.Cart;
import com.avijit.poc.onlinestore.presentation.bean.CartItem;
import com.avijit.poc.onlinestore.presentation.bean.OrderForm;
import com.googlecode.ehcache.annotations.Cacheable;

@Service("onlineStoreService")
@Transactional(propagation=Propagation.REQUIRED)
public class OnlineStoreServiceImpl implements OnlineStoreService {
    
	private static final SimpleDateFormat DATE_FORMAT_LONG_DASH = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final DecimalFormat DECIMAL_FORMATTER = new DecimalFormat("#,###,###,##0.00");
	
	@Autowired
	private PartTypeDAO partTypeDAO;
    
	@Autowired
	private ManufacturerDAO manufacturerDAO;
    
	@Autowired
	private PartDAO partDAO;
    
	@Autowired
	private StaticDAO staticDAO;
    
	@Autowired
	private OrderDAO orderDAO;

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public void setPartTypeDAO(PartTypeDAO partTypeDAO) {
        this.partTypeDAO = partTypeDAO;
    }

    public void setPartDAO(PartDAO partDAO) {
        this.partDAO = partDAO;
    }

    public void setManufacturerDAO(ManufacturerDAO manufacturerDAO) {
        this.manufacturerDAO = manufacturerDAO;
    }

    public void setStaticDAO(StaticDAO staticDAO) {
        this.staticDAO = staticDAO;
    }

    @Cacheable(cacheName = "partTypeCache")
    public List<PartType> getPartTypeList() {
        return partTypeDAO.getPartTypeList();
    }

    @Cacheable(cacheName = "manufacturerCache")
    public List<Manufacturer> getManufacturerList() {
        return manufacturerDAO.getManufacturerList();
    }

    @Cacheable(cacheName = "manufacturerPartCache")
    public List<Part> getPartsByManufacturer(int manufacturerId) {
        return partDAO.getPartsByManufacturer(manufacturerId);
    }

    @Cacheable(cacheName = "partTypePartCache")
    public List<Part> getPartsByPartType(int partTypeId) {
        return partDAO.getPartsByPartType(partTypeId);
    }

    @Cacheable(cacheName = "partDetailCache")
    public Part getPartDetailsByPartCd(int partId) {
        return partDAO.getPartDetailsByPartCd(partId);
    }

    public List<PartSpecification> getPartSpecification(int partId) {
        return partDAO.getPartSpecification(partId);
    }

    @Cacheable(cacheName = "cardTypeCache")
    public List<CreditCardType> getCreditCardTypeList() {
        return staticDAO.getCreditCardTypeList();
    }

    @Cacheable(cacheName = "shippingMethodsCache")
    public List<ShippingMethod> getShippingMethodTypeList() {
        return staticDAO.getShippingMethodTypeList();
    }

    @Cacheable(cacheName = "countryCache")
    public List<Country> getCountryList() {
        return staticDAO.getCountryList();
    }

    @Cacheable(cacheName = "countryStatesCache")
    public List<State> getStateListByCountryCd(String countryCd) {
        return staticDAO.getStateListByCountryCd(countryCd); 
    }
    
    @Cacheable(cacheName = "bankCache")
    public List<Bank> getBankList() {
		return staticDAO.getBankList();
	}

    /**
     * Some logic will be here to calculate the ShippingRate based on the carrier and shippingMethod
     * @param shippingMethodCd
     * @return shippingAmt
     */
    public double getShippingRateByShippingMethod(String shippingMethodCd) {
        if (shippingMethodCd.equalsIgnoreCase("SM1")) {
            return 12.25;
        } else if (shippingMethodCd.equalsIgnoreCase("SM2")) {
            return 5.0;
        }  else if (shippingMethodCd.equalsIgnoreCase("SM3")) {
            return 8.5;
        }  else if (shippingMethodCd.equalsIgnoreCase("SM4")) {
            return 17.5;
        }

        return 0.0;
    }

    public Tax calculateOrderTax(double lineItemTotal) {
        Tax tax = new Tax();
        tax.setTaxRate(0.06);
        tax.setTaxAmt(tax.getTaxRate() * lineItemTotal);
        return tax;
    }
    
    public Order createOrder(OrderForm orderForm, Cart shoppingCart) {
    	
    	int count = 0;
    	double lineItemTotal = 0;
        Set<LineItem> lineItemList = null;
        LineItem lineItem;

        String orderNumber = DATE_FORMAT_LONG_DASH.format(System.currentTimeMillis());
        Order order = new Order();
        
        if (!shoppingCart.isCartEmpty()) {
        	
        	//Create Line Items for the Cart Items
        	List<CartItem> cartItems = shoppingCart.getCartItems();
        	lineItemList = new LinkedHashSet<LineItem>();
        	
        	for (CartItem cartItem : cartItems) {
        		lineItem = new LineItem();
                lineItem.setLineItemNum(++count);
                lineItem.setPart(cartItem.getPart());
                lineItem.setPartCd(cartItem.getPart().getPartCd());
                lineItem.setQty(cartItem.getQuantity());
                lineItem.setUnitPrice(cartItem.getUnitPrice());
                lineItemList.add(lineItem);
                lineItemTotal += lineItem.getUnitPrice() * lineItem.getQty();
        	}
        	order.setLineItemList(lineItemList);
        	
        	//Set Order Shipping Information
        	OrderShipping orderShipping = new OrderShipping();
        	orderShipping.setOrderNum(orderNumber);
        	orderShipping.setShippingAddress(orderForm.getShippingAddressInfo());
        	orderShipping.setShippingCost(Double.parseDouble(orderForm.getShippingRate()));
        	orderShipping.setOrderShippingMethod(orderForm.getShippingMethodInfo());
        	order.setOrderShipping(orderShipping);
        	
        	Tax tax = calculateOrderTax(lineItemTotal);
        	
        	//Set Order Billing Information
        	OrderBilling orderBilling = new OrderBilling();
        	orderBilling.setOrderNum(orderNumber);
        	orderBilling.setBillingAddress(orderForm.getBillingAddressInfo());
        	orderBilling.setLineItemTotal(lineItemTotal);
        	orderBilling.setOrderTotal(Double.parseDouble(DECIMAL_FORMATTER.format(lineItemTotal + orderShipping.getShippingCost() + tax.getTaxAmt())));
        	orderBilling.setPaymentType(orderForm.getPaymentType());
        	orderBilling.setShippingPrice(orderShipping.getShippingCost());
        	orderBilling.setTax(tax);
        	
        	OrderPaymentInfo orderPaymentInfo = new OrderPaymentInfo();
        	if ("CC".equals(orderForm.getPaymentType())) {
        		orderPaymentInfo.setCardHolderName(orderForm.getBillingName());
        		orderPaymentInfo.setPartialCardNumber(orderForm.getPaymentDataBean().getPartialCardNumber());
        		orderPaymentInfo.setExpirationDate(orderForm.getPaymentDataBean().getExpirationDate());
        		orderPaymentInfo.setCcv(orderForm.getPaymentDataBean().getCcv());
        		orderPaymentInfo.setCardType(orderForm.getCreditCardTypeInfo().getCreditCardName());
            	
        	} else {
        		orderPaymentInfo.setBankName(orderForm.getBankInfo().getBankName());
        		orderPaymentInfo.setAccountNumber(orderForm.getPaymentDataBean().getAccountNumber());
        		orderPaymentInfo.setBankAbaNumber(orderForm.getPaymentDataBean().getBankAbaNumber());
        	}
        	orderBilling.setOrderPaymentInfo(orderPaymentInfo);
        	order.setOrderBilling(orderBilling);
        	
            order.setOrderCreationDate(DATE_FORMAT_LONG_DASH.format(new Date(System.currentTimeMillis())));
            order.setOrderNumber(orderNumber);
        }
        
        return order;
    	
    }

    public boolean saveOrder(Order order) {
        return orderDAO.saveOrder(order);
    }
}
