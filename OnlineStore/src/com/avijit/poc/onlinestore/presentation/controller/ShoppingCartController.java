package com.avijit.poc.onlinestore.presentation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.avijit.poc.onlinestore.business.entity.Part;
import com.avijit.poc.onlinestore.business.service.OnlineStoreService;
import com.avijit.poc.onlinestore.presentation.bean.Cart;
import com.avijit.poc.onlinestore.presentation.bean.CartItem;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
	@Autowired
	private OnlineStoreService onlineStoreService;

	public void setOnlineStoreService(OnlineStoreService onlineStoreService) {
		this.onlineStoreService = onlineStoreService;
	}

	@RequestMapping("/home.do")
    public ModelAndView viewHomePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView(new RedirectView("home.do"));        
    }

	@RequestMapping("/viewCart.do")
    public ModelAndView viewShoppingCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cart cart = (Cart) request.getSession().getAttribute("shoppingCart");
		if (cart == null) {
			cart = new Cart();
		}
		request.getSession().setAttribute("shoppingCart", cart);
		return new ModelAndView("ShoppingCart");
    }

	@RequestMapping("/addCartItem.do")
    public ModelAndView addCartItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String partId = request.getParameter("partId");
        String qty = "1";
        Part part = onlineStoreService.getPartDetailsByPartCd(Integer.parseInt(partId));
		Cart cart = (Cart) request.getSession().getAttribute("shoppingCart");
		if (cart == null) {
			cart = new Cart();
		}
		cart.addItem(part, Integer.parseInt(qty));
		request.getSession().setAttribute("shoppingCart", cart);
		return new ModelAndView("ShoppingCart");
	}

	@RequestMapping("/updateCart.do")
	public ModelAndView updateShoppingCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int qty;
        String[] partIds = request.getParameterValues("partId");
        String[] qtys = request.getParameterValues("qty");
        CartItem cartItem;
        Cart cart = (Cart) request.getSession().getAttribute("shoppingCart");

        if (partIds != null && partIds.length > 0 && qtys != null && qtys.length > 0) {
            for (int i=0; i<partIds.length; i++) {
                qty = Integer.parseInt(qtys[i]);
                if (qty < 1) {
                    cart.removeItemById(partIds[i]);
                } else {
                    cartItem = cart.getCartItem(partIds[i]);
                    cartItem.setQuantity(qty);
                }
            }
        }
		request.getSession().setAttribute("shoppingCart", cart);
		return new ModelAndView("ShoppingCart");
	}

	@RequestMapping("/removeCartItem.do")
	public ModelAndView removeCartItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String partId = request.getParameter("partId");
		Cart cart = (Cart) request.getSession().getAttribute("shoppingCart");
		cart.removeItemById(partId);
		request.getSession().setAttribute("shoppingCart", cart);
		return new ModelAndView("ShoppingCart");
	}

	@RequestMapping("/clearCart.do")
	public ModelAndView clearCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Cart cart = (Cart) request.getSession().getAttribute("shoppingCart");
        cart.removeAll();
		request.getSession().setAttribute("shoppingCart", cart);
		return new ModelAndView("ShoppingCart");
	}

	public String getPartSpecialPrice() {
		return "$9.0";
	}
}
