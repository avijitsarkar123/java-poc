package com.avijit.poc.onlinestore.presentation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avijit.poc.onlinestore.business.entity.Manufacturer;
import com.avijit.poc.onlinestore.business.entity.Part;
import com.avijit.poc.onlinestore.business.entity.PartType;
import com.avijit.poc.onlinestore.business.service.OnlineStoreService;

@Controller
@RequestMapping("/parts")
public class PartController {
    
	@Autowired
	private OnlineStoreService onlineStoreService;

    public void setOnlineStoreService(OnlineStoreService onlineStoreService) {
        this.onlineStoreService = onlineStoreService;
    }

    @RequestMapping("/details.do")
    public ModelAndView getPartDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String partId = request.getParameter("partId");
        Part part = onlineStoreService.getPartDetailsByPartCd(Integer.parseInt(partId));
        request.getSession().setAttribute("part", part);
        return new ModelAndView("ProductDetails", "part", part);
    }

    @RequestMapping("/search.do")
    public ModelAndView searchParts(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List partList;
        Manufacturer manufacturerDetails = null;
        PagedListHolder searchResultList;
        PartType partType = null;
        String searchBy = request.getParameter("searchBy");
        String manufacturerId = request.getParameter("manufacturerId");
        String partTypeId = request.getParameter("partTypeId");
        String page = request.getParameter("page");
        String pageName = "";

        if (StringUtils.isBlank(page)) {
            if (searchBy != null && searchBy.equalsIgnoreCase("manufacturer")) {
                partList = onlineStoreService.getPartsByManufacturer(Integer.parseInt(manufacturerId));
                pageName = "SearchPartsByMfrResult";
                if (partList != null && !partList.isEmpty()) {
                    manufacturerDetails = ((Part) partList.get(0)).getManufacturer();
                }
            } else {
                partList = onlineStoreService.getPartsByPartType(Integer.parseInt(partTypeId));
                pageName = "SearchPartsByPartCategory";
                if (partList != null && !partList.isEmpty()) {
                    partType = ((Part) partList.get(0)).getPartType();
                }
            }
            searchResultList = new PagedListHolder(partList);
            searchResultList.setPageSize(9);
        } else {
            searchResultList = (PagedListHolder)request.getSession().getAttribute("searchResultList");
            if (page.equalsIgnoreCase("next")) {
                searchResultList.nextPage();
            } else if (page.equalsIgnoreCase("prev")) {
                searchResultList.previousPage();
            } else if (page.equalsIgnoreCase("first")) {
                searchResultList.setPage(searchResultList.getFirstLinkedPage());
            } else if (page.equalsIgnoreCase("last")) {
                searchResultList.setPage(searchResultList.getLastLinkedPage());
            }
        }
        
        request.getSession().setAttribute("manufacturer", manufacturerDetails);
        request.getSession().setAttribute("partType", partType);
        request.getSession().setAttribute("searchResultList", searchResultList);
        return new ModelAndView(pageName);
    }
}
