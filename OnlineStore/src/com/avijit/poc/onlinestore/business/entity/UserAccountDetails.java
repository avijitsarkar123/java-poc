package com.avijit.poc.onlinestore.business.entity;

import java.sql.Timestamp;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserAccountDetails implements UserDetails {
	private long id;
	
	private String userName;
	
	private String openId;
    
	private String password;
	
    private boolean active;
	
    private String firstName;
	
    private String lastName;
	
    private String emailAddress;
	
    private Timestamp lastLoginTime;
	
	private String addressIds;
	
	private String creditCardInfoIds;
	
	private String achInfoIds;
	
	private boolean accountLocked;
	
	private boolean accountExpired;
	
	private Collection<? extends GrantedAuthority> authorities;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean isEnabled) {
		this.active = isEnabled;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getAddressIds() {
		return addressIds;
	}

	public void setAddressIds(String addressIds) {
		this.addressIds = addressIds;
	}

	public String getCreditCardInfoIds() {
		return creditCardInfoIds;
	}

	public void setCreditCardInfoIds(String creditCardInfoIds) {
		this.creditCardInfoIds = creditCardInfoIds;
	}

	public String getAchInfoIds() {
		return achInfoIds;
	}

	public void setAchInfoIds(String achInfoIds) {
		this.achInfoIds = achInfoIds;
	}
	
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getUsername() {
		return getUserName();
	}
	
	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	public void setAccountExpired(boolean accountExpired) {
		this.accountExpired = accountExpired;
	}

	@Override
	public boolean isAccountNonExpired() {
		return !accountExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !accountLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return isActive();
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}
}
