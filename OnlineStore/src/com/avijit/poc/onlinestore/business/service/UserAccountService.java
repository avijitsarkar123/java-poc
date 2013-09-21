package com.avijit.poc.onlinestore.business.service;

import java.util.List;

import com.avijit.poc.onlinestore.business.entity.Address;
import com.avijit.poc.onlinestore.business.entity.UserAccountDetails;

public interface UserAccountService {
	public UserAccountDetails loadUserByUserNamePassword(String userName, String password);
	
	public UserAccountDetails loadUserByUserOpenId(String userOpenId);
	
	public boolean createUserAccount(UserAccountDetails user);
	public boolean updateUserAccount(UserAccountDetails user);
	
	public List<Address> getUserBillingAddresses(UserAccountDetails user);
	public List<Address> getUserShippingAddresses(UserAccountDetails user);
}
