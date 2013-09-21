package com.avijit.poc.onlinestore.presentation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avijit.poc.onlinestore.business.entity.Manufacturer;
import com.avijit.poc.onlinestore.business.entity.PartType;
import com.avijit.poc.onlinestore.business.service.OnlineStoreService;

@Controller
public class StoreHomePageController {
    
	@Autowired
	private OnlineStoreService onlineStoreService;

    public void setOnlineStoreService(OnlineStoreService onlineStoreService) {
        this.onlineStoreService = onlineStoreService;
    }

    @RequestMapping("/home.do")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Manufacturer> manufacturerList = onlineStoreService.getManufacturerList();
        List<PartType> partTypeList = onlineStoreService.getPartTypeList();

        request.getSession().setAttribute("manufacturerList", manufacturerList);
        request.getSession().setAttribute("partTypeList", partTypeList);
        return new ModelAndView("HomePage");
    }
}
