package com.avijit.poc.onlinestore.business.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.avijit.poc.onlinestore.business.exception.UnsupportedException;


public class UserACHInfo implements Serializable {
	
	private long id;
	
	private Bank bank;
	
	private String accountNumber;
	
	private String bankAbaNumber;
	
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBankAbaNumber() {
		return bankAbaNumber;
	}
	public void setBankAbaNumber(String bankAbaNumber) {
		this.bankAbaNumber = bankAbaNumber;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "UserACHInfo [bank=" + bank + ", accountNumber=" + accountNumber
				+ ", bankAbaNumber=" + bankAbaNumber + "]";
	}
}
