package com.avijit.poc.onlinestore.presentation.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.avijit.poc.onlinestore.business.entity.UserAccountDetails;
import com.avijit.poc.onlinestore.business.service.UserAccountService;
import com.avijit.poc.onlinestore.presentation.bean.UserForm;
import com.avijit.poc.onlinestore.presentation.validator.UserRegistrationValidator;
import com.avijit.poc.onlinestore.security.OpenIDAuthenticationUserAttributes;

@Controller
@RequestMapping("/userManagement")
public class UserManagementController {

	@Autowired
	private UserAccountService userAccountService;
	
	@Autowired
	OpenIDAuthenticationUserAttributes openIDAuthenticationUserAttributes;

	@Autowired
	UserRegistrationValidator userRegistrationValidator;
	
	@ModelAttribute("userForm")
	public UserForm initUserForm(HttpServletRequest request) {
		
		UserForm userForm = (UserForm) request.getSession().getAttribute("userForm");
		
		if (userForm == null) {
			userForm = new UserForm();
	        userForm.setFirstName(openIDAuthenticationUserAttributes.getOpenIDUserAttribute("firstName"));
	        userForm.setLastName(openIDAuthenticationUserAttributes.getOpenIDUserAttribute("lastName"));
	        userForm.setEmailAddress(openIDAuthenticationUserAttributes.getOpenIDUserAttribute("email"));
	        
	        AuthenticationException authEx = (AuthenticationException) request.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	        if (authEx != null && authEx.getAuthentication() instanceof OpenIDAuthenticationToken) {
	        	OpenIDAuthenticationToken openIdAuth = (OpenIDAuthenticationToken)authEx.getAuthentication();
	        	userForm.setOpenId((String)openIdAuth.getPrincipal());
	        }
	        
	        
	        request.getSession(false).setAttribute("userForm", userForm);
		}
		
        return userForm;
	}
	
	
	@RequestMapping(value = "/register.do", method = RequestMethod.GET)
	public String showRegistrationPage() {
		return "UserRegistration";
	}
	
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public ModelAndView registerUser(HttpServletRequest request, @ModelAttribute UserForm userForm, BindingResult result, SessionStatus status) {
		
		UserAccountDetails userAccountDetails = null;
		userRegistrationValidator.validateUserForm(userForm, result);
		
		if (!result.hasErrors()) {
			userAccountDetails = new UserAccountDetails();
			userAccountDetails.setUserName(userForm.getUserName());
			userAccountDetails.setPassword(userForm.getPassword());
			userAccountDetails.setFirstName(userForm.getFirstName());
			userAccountDetails.setLastName(userForm.getLastName());
			userAccountDetails.setEmailAddress(userForm.getEmailAddress());
			userAccountDetails.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
			userAccountDetails.setActive(true);
			userAccountDetails.setAccountExpired(false);
			userAccountDetails.setAccountLocked(false);
			userAccountDetails.setOpenId(userForm.getOpenId());

			userAccountService.createUserAccount(userAccountDetails);
			SecurityContextHolder.getContext().setAuthentication(
					new UsernamePasswordAuthenticationToken(userAccountDetails, userForm.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("USER")));
			
			return new ModelAndView("redirect:/home.do");
			
		} else {
			return new ModelAndView("UserRegistration");
		}
		
	}
	
}
