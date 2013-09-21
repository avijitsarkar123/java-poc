package com.avijit.poc.onlinestore.presentation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avijit.poc.onlinestore.business.service.OnlineStoreService;

@Controller
public class ViewCartController {
    @Autowired
	private OnlineStoreService onlineStoreService;

    public void setOnlineStoreService(OnlineStoreService onlineStoreService) {
        this.onlineStoreService = onlineStoreService;
    }

    @RequestMapping("/viewCart.do")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("ShoppingCart");
    }
}
