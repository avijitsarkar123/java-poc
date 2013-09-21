package com.avijit.poc.onlinestore.business.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COUNTRY")
public class Country implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	
	@Column(name="COUNTRY_CD", nullable=false)
    private String countryCd;
	
	@Column(name="COUNTRY_NAME", nullable=false)
    private String countryName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountryCd() {
        return countryCd;
    }

    public void setCountryCd(String countryCd) {
        this.countryCd = countryCd;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

	@Override
	public String toString() {
		return "Country [id=" + id + ", countryCd=" + countryCd
				+ ", countryName=" + countryName + "]";
	}
    
}
