package com.avijit.poc.onlinestore.business.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BANK")
public class Bank implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="BANK_CD")
	private String bankCd;
	
	@Column(name="BANK_NAME")
	private String bankName;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBankCd() {
		return bankCd;
	}
	public void setBankCd(String bankCd) {
		this.bankCd = bankCd;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	@Override
	public String toString() {
		return "Bank [id=" + id + ", bankCd=" + bankCd + ", bankName="
				+ bankName + "]";
	}
}
