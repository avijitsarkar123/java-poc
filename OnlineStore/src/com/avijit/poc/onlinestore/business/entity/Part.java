package com.avijit.poc.onlinestore.business.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PART")
public class Part  implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="PART_CD")
    private String partCd;
	
	@Column(name="PART_NAME")
    private String partName;
	
	@Column(name="PRIMARY_PICTURE")
    private String primaryPicture;
	
	@ManyToOne
	@JoinColumn(name="PART_TYPE_ID", referencedColumnName="ID")
    private PartType partType;
	
	@ManyToOne
	@JoinColumn(name="MANUFACTURER_ID", referencedColumnName="ID")
    private Manufacturer manufacturer;
	
	@Column(name="MODEL_NUMBER")
    private String modelNumber;
	
	@Column(name="MANUFACTURER_PART_NUMBER")
    private String manufacturerPartNumber;
	
	@Column(name="PART_DESC")
    private String partDescription;
	
	@Column(name="UNIT_PRICE")
    private double unitPrice;
	
	@OneToMany(mappedBy="part", fetch=FetchType.LAZY, cascade={CascadeType.REFRESH, CascadeType.REMOVE})
    private List<PartSpecification> partSpecificationList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPartCd() {
        return partCd;
    }

    public void setPartCd(String partCd) {
        this.partCd = partCd;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public PartType getPartType() {
        return partType;
    }

    public void setPartType(PartType partType) {
        this.partType = partType;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPrimaryPicture() {
        return primaryPicture;
    }

    public void setPrimaryPicture(String primaryPicture) {
        this.primaryPicture = primaryPicture;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getManufacturerPartNumber() {
        return manufacturerPartNumber;
    }

    public void setManufacturerPartNumber(String manufacturerPartNumber) {
        this.manufacturerPartNumber = manufacturerPartNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public List<PartSpecification> getPartSpecificationList() {
        return partSpecificationList;
    }

    public void setPartSpecificationList(List<PartSpecification> partSpecificationList) {
        this.partSpecificationList = partSpecificationList;
    }

	@Override
	public String toString() {
		return "Part [id=" + id + ", partCd=" + partCd + ", partName="
				+ partName + ", primaryPicture=" + primaryPicture
				+ ", partType=" + partType + ", manufacturer=" + manufacturer
				+ ", modelNumber=" + modelNumber + ", manufacturerPartNumber="
				+ manufacturerPartNumber + ", partDescription="
				+ partDescription + ", unitPrice=" + unitPrice
				+ ", partSpecificationList=" + partSpecificationList + "]";
	}
}
