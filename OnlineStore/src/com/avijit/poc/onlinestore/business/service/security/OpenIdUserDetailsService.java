package com.avijit.poc.onlinestore.business.service.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avijit.poc.onlinestore.business.entity.UserAccountDetails;
import com.avijit.poc.onlinestore.business.service.UserAccountService;
 
@Service("openIdUserDetailsService")
@Transactional(readOnly = true)
public class OpenIdUserDetailsService implements UserDetailsService {
	
	@Autowired
    private UserAccountService userAccountService;
 
    public void setUserAccountService(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }
 
    @Transactional
    public UserDetails loadUserByUsername(String loginOpenId) throws UsernameNotFoundException, DataAccessException {
    	UserAccountDetails userAccountDetails = null;
    	
    	try {
    		userAccountDetails = userAccountService.loadUserByUserOpenId(loginOpenId);
    	} catch (EmptyResultDataAccessException erdaex) {
			throw new UsernameNotFoundException("User with open id login " + loginOpenId + "  has not been found.");
		} catch (Throwable th) {
			throw new AuthenticationServiceException("Authentication Service exception, please try later.");
		}
    	
    	userAccountDetails.setAuthorities(getAuthorities());
        return userAccountDetails;
    }
 
    private List<GrantedAuthority> getAuthorities() {
    	return AuthorityUtils.commaSeparatedStringToAuthorityList("USER");
	}
}