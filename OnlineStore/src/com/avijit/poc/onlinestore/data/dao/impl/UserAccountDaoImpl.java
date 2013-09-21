package com.avijit.poc.onlinestore.data.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.avijit.poc.onlinestore.business.entity.Address;
import com.avijit.poc.onlinestore.business.entity.UserACHInfo;
import com.avijit.poc.onlinestore.business.entity.UserAccountDetails;
import com.avijit.poc.onlinestore.data.dao.UserAccountDAO;
import com.avijit.poc.onlinestore.data.dao.rowmapper.UserAccountRowMapper;

@Repository
public class UserAccountDaoImpl implements UserAccountDAO {
    
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void createTemplate(@Qualifier("onlineStoreDS") DataSource dataSource) { 	
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

    public UserAccountDetails loadUserByUserNamePassword(String userName, String password) {
        String query = "SELECT * FROM USER_ACCOUNT WHERE USER_NAME = ? AND PASSWORD = ?";
        Object[] params = {userName, password};
        UserAccountDetails userAccountInfo = (UserAccountDetails) jdbcTemplate.queryForObject(query, params, new UserAccountRowMapper());

        return userAccountInfo;
    }
    
    public UserAccountDetails loadUserByUserOpenId(String userOpenId) {
    	 String query = "SELECT * FROM USER_ACCOUNT WHERE USER_OPEN_ID = ?";
         Object[] params = {userOpenId};
         UserAccountDetails userAccountInfo = (UserAccountDetails) jdbcTemplate.queryForObject(query, params, new UserAccountRowMapper());
         
         return userAccountInfo;
    }

	@Override
	public boolean createUserAccount(UserAccountDetails user) {
		String query = "INSERT INTO USER_ACCOUNT (user_name, password, first_name, last_name, active, email_address, last_login_time, " +
													" address_ids, ach_info_ids, credit_card_info_ids, account_locked, account_expired, user_open_id) " +
													" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = { user.getUserName(), 
							user.getPassword(), 
							user.getFirstName(), 
							user.getLastName(), 
							user.isActive() ? "Y" : "N", 
							user.getEmailAddress(),
							user.getLastLoginTime(),
							null,
							null,
							null,
							"N",
							"N",
							user.getOpenId()
						  };
		
		jdbcTemplate.update(query, params);
		return true;
	}

	@Override
	public boolean updateUserAccount(UserAccountDetails user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Address> getUserBillingAddresses(UserAccountDetails user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> getUserShippingAddresses(UserAccountDetails user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserACHInfo> getUserPaymentMethod(UserAccountDetails user) {
		// TODO Auto-generated method stub
		return null;
	}
}
