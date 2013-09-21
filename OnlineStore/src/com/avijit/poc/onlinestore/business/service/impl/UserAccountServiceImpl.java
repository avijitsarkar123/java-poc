package com.avijit.poc.onlinestore.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.avijit.poc.onlinestore.business.entity.Address;
import com.avijit.poc.onlinestore.business.entity.UserAccountDetails;
import com.avijit.poc.onlinestore.business.service.UserAccountService;
import com.avijit.poc.onlinestore.data.dao.UserAccountDAO;

@Service("authenticationService")
@Transactional(propagation=Propagation.REQUIRED)
public class UserAccountServiceImpl implements UserAccountService {

	@Autowired
	private UserAccountDAO userAccountDAO;

	public void setUserAccountDAO(UserAccountDAO userAccountDAO) {
		this.userAccountDAO = userAccountDAO;
	}

	public UserAccountDetails loadUserByUserNamePassword(String userName, String password) {
		return userAccountDAO.loadUserByUserNamePassword(userName, password);
	}
	
	public UserAccountDetails loadUserByUserOpenId(String userOpenId) {
		return userAccountDAO.loadUserByUserOpenId(userOpenId);
	}

	public boolean createUserAccount(UserAccountDetails user) {
		return userAccountDAO.createUserAccount(user);
	}

	public boolean updateUserAccount(UserAccountDetails user) {
		return false;
	}

	public List<Address> getUserBillingAddresses(UserAccountDetails user) {
		return null;
	}

	public List<Address> getUserShippingAddresses(UserAccountDetails user) {
		return null;
	}

}
