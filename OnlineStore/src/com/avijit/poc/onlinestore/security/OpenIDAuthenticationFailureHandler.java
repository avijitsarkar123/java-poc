package com.avijit.poc.onlinestore.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.openid.OpenIDAttribute;
import org.springframework.security.openid.OpenIDAuthenticationStatus;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class OpenIDAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private String userRegistrationUrl;
    private OpenIDAuthenticationUserAttributes openIDAuthenticationUserAttributes;

    public void setUserRegistrationUrl(String userRegistrationUrl) {
		this.userRegistrationUrl = userRegistrationUrl;
	}
    
	public void setOpenIDAuthenticationUserAttributes(OpenIDAuthenticationUserAttributes openIDAuthenticationUserAttributes) {
		this.openIDAuthenticationUserAttributes = openIDAuthenticationUserAttributes;
	}

	@Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if (openIdAuthenticationSuccesfullButUserIsNotRegistered(exception)) {
        	
        	OpenIDAuthenticationToken openIdAuth = (OpenIDAuthenticationToken)exception.getAuthentication();
        	openIDAuthenticationUserAttributes.loadOpenIDUserAttributes(openIdAuth);
        	request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception);
            redirectToOpenIdRegistrationUrl(request, response, exception);
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }

    private void redirectToOpenIdRegistrationUrl(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        DefaultRedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        redirectStrategy.sendRedirect(request, response, userRegistrationUrl);
    }

    private boolean openIdAuthenticationSuccesfullButUserIsNotRegistered(AuthenticationException exception) {
        return exception instanceof UsernameNotFoundException 
        		&& exception.getAuthentication() instanceof OpenIDAuthenticationToken 
        		&& OpenIDAuthenticationStatus.SUCCESS.equals(((OpenIDAuthenticationToken) exception.getAuthentication()).getStatus());
    }

}