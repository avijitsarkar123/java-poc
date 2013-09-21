package com.avijit.poc.onlinestore.business.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MANUFACTURER")
public class Manufacturer  implements Serializable {


	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="MANUFACTURER_CD", nullable=false)
    private String manufacturerCd;
	
	@Column(name="MANUFACTURER_NAME", nullable=false)
    private String manufacturerName;
	
	@Column(name="MANUFACTURER_DESC")
    private String manufacturerDesc;
	
	@Column(name="MANUFACTURER_LOGO", nullable=false)
    private String manufacturerLogo;
	
	@OneToMany(mappedBy="manufacturer", cascade=CascadeType.REMOVE, fetch=FetchType.LAZY)
    private Set<Part> partList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getManufacturerCd() {
        return manufacturerCd;
    }

    public void setManufacturerCd(String manufacturerCd) {
        this.manufacturerCd = manufacturerCd;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturerDesc() {
        return manufacturerDesc;
    }

    public void setManufacturerDesc(String manufacturerDesc) {
        this.manufacturerDesc = manufacturerDesc;
    }

    public String getManufacturerLogo() {
        return manufacturerLogo;
    }

    public void setManufacturerLogo(String manufacturerLogo) {
        this.manufacturerLogo = manufacturerLogo;
    }

    public Set<Part> getPartList() {
        return partList;
    }

    public void setPartList(Set<Part> partList) {
        this.partList = partList;
    }

	@Override
	public String toString() {
		return "Manufacturer [id=" + id + ", manufacturerCd=" + manufacturerCd
				+ ", manufacturerName=" + manufacturerName
				+ ", manufacturerDesc=" + manufacturerDesc
				+ ", manufacturerLogo=" + manufacturerLogo + ", partList="
				+ partList + "]";
	}
    
}
