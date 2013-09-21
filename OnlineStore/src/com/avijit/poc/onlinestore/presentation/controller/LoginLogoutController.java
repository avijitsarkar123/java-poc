package com.avijit.poc.onlinestore.presentation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginLogoutController {

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String showLoginPage(@RequestParam(value = "error", required = false) boolean error,	HttpServletRequest request, ModelMap model) {
		if (error == true) {
			String errorMessage = "You have entered an invalid username or password!";

			AuthenticationException authEx = (AuthenticationException) request.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);

			if (authEx != null) {
				errorMessage = authEx.getMessage();
			}
			model.put("error", errorMessage);
		} else {
			model.put("error", "");
		}

		return "login";
	}
}