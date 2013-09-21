package com.avijit.poc.onlinestore.data.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.avijit.poc.onlinestore.business.entity.UserAccountDetails;

public class UserAccountRowMapper implements RowMapper<UserAccountDetails> {

	@Override
	public UserAccountDetails mapRow(ResultSet rs, int rowCount) throws SQLException {
		UserAccountDetails userAccountInfo = new UserAccountDetails();
        userAccountInfo.setId(rs.getLong("ID"));
        userAccountInfo.setUserName(rs.getString("USER_NAME"));
        userAccountInfo.setPassword(rs.getString("PASSWORD"));
        userAccountInfo.setFirstName(rs.getString("FIRST_NAME"));
        userAccountInfo.setLastName(rs.getString("LAST_NAME"));
        userAccountInfo.setEmailAddress(rs.getString("EMAIL_ADDRESS"));
        userAccountInfo.setActive(rs.getString("ACTIVE").equals("Y") ? true : false);
        userAccountInfo.setLastLoginTime(rs.getTimestamp("LAST_LOGIN_TIME"));
        userAccountInfo.setAccountLocked(rs.getString("ACCOUNT_LOCKED").equals("Y") ? true : false);
        userAccountInfo.setAccountExpired(rs.getString("ACCOUNT_EXPIRED").equals("Y") ? true : false);
        userAccountInfo.setAddressIds(rs.getString("ADDRESS_IDS"));
        userAccountInfo.setCreditCardInfoIds(rs.getString("ADDRESS_IDS"));
        userAccountInfo.setAchInfoIds(rs.getString("ACH_INFO_IDS"));
        userAccountInfo.setCreditCardInfoIds(rs.getString("CREDIT_CARD_INFO_IDS"));
        return userAccountInfo;
	}
}
