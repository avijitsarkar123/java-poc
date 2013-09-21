package com.avijit.poc.onlinestore.security;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.avijit.poc.onlinestore.business.entity.UserAccountDetails;
import com.avijit.poc.onlinestore.business.service.UserAccountService;

@Component("onlineStoreAthenticationProvider")
public class OnlineStoreAthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserAccountService userAccountService; 
	
	public void setUserAccountService(UserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}

	protected void additionalAuthenticationChecks(UserDetails arg0,	UsernamePasswordAuthenticationToken arg1) throws AuthenticationException {
	}

	
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		UserAccountDetails userAccount = null;
		
		String userName = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		if (StringUtils.isBlank(userName) || StringUtils.isBlank(password) ) {
			throw new BadCredentialsException("Invalid User Name / Password");
		}
		
		try {
			userAccount = userAccountService.loadUserByUserNamePassword(userName, password);
		} catch (EmptyResultDataAccessException erdaex) {
			throw new AuthenticationCredentialsNotFoundException("Invalid User Name / Password");
		} catch (Throwable th) {
			throw new AuthenticationServiceException("Authentication Service exception, please try later.");
		}
		
		userAccount.setAuthorities(getAuthorities());
				
		return new UsernamePasswordAuthenticationToken(userAccount, authentication.getCredentials(), userAccount.getAuthorities());
	}
	
	protected UserDetails retrieveUser(String userName,	UsernamePasswordAuthenticationToken userToken) throws AuthenticationException {
		return new User(userName, userToken.getCredentials().toString(), userToken.getAuthorities());
	}
	
	private List<GrantedAuthority> getAuthorities() {
		return AuthorityUtils.commaSeparatedStringToAuthorityList("USER");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}
	
}
