package com.avijit.poc.onlinestore.business.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="Address")
public class Address  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="NAME", nullable=false)
	private String name;

	@Column(name="ADDRESS1", nullable=false)
	private String addressLine1;

	@Column(name="ADDRESS2")
	private String addressLine2;

	@Column(name="CITY", nullable=false)
	private String city;

	@Column(name="STATE", nullable=false)
	private String state;

	@Column(name="ZIP", nullable=false)
	private String zip;

	@Column(name="COUNTRY", nullable=false)
	private String country;

	@Column(name="PHONE_NUM", nullable=false)
	private String phoneNumber;

	@Column(name="ADDRESS_TYPE", nullable=false)
    private String addressType;

    public Address() {
	}

	public Address(Address address) {
		this.name = address.getName();
		this.addressLine1 = address.getAddressLine1();
		this.addressLine2 = address.getAddressLine2();
		this.city = address.getCity();
		this.state = address.getState();
		this.zip = address.getZip();
		this.country = address.getCountry();
		this.phoneNumber = address.getPhoneNumber();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", city="
				+ city + ", state=" + state + ", zip=" + zip + ", country="
				+ country + ", phoneNumber=" + phoneNumber + ", addressType="
				+ addressType + "]";
	}
    
}
