package com.avijit.poc.onlinestore.data.dao;

import java.util.List;

import com.avijit.poc.onlinestore.business.entity.Address;
import com.avijit.poc.onlinestore.business.entity.UserACHInfo;
import com.avijit.poc.onlinestore.business.entity.UserAccountDetails;

public interface UserAccountDAO {
	
	public UserAccountDetails loadUserByUserNamePassword(String userName, String password);
	public UserAccountDetails loadUserByUserOpenId(String userOpenId);
	
	public boolean createUserAccount(UserAccountDetails user);
	public boolean updateUserAccount(UserAccountDetails user);
	
	public List<Address> getUserBillingAddresses(UserAccountDetails user);
	public List<Address> getUserShippingAddresses(UserAccountDetails user);
	
	public List<UserACHInfo> getUserPaymentMethod(UserAccountDetails user);
}
