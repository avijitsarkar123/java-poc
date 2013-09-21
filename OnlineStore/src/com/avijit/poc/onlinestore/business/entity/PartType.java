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
@Table(name="PART_TYPE")
public class PartType  implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="PART_TYPE_CD", nullable=false)
    private String partTypeCd;
	
	@Column(name="PART_TYPE_NAME", nullable=false)
    private String partTypeName;
	
	@Column(name="PART_TYPE_DESC", nullable=false)
    private String partTypeDesc;
	
	@Column(name="PART_TYPE_LOGO", nullable=false)
    private String partTypeLogo;
	
	@OneToMany(mappedBy="partType", cascade=CascadeType.REMOVE, fetch=FetchType.LAZY)
    private Set<Part> partList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPartTypeCd() {
        return partTypeCd;
    }

    public void setPartTypeCd(String partTypeCd) {
        this.partTypeCd = partTypeCd;
    }

    public String getPartTypeName() {
        return partTypeName;
    }

    public void setPartTypeName(String partTypeName) {
        this.partTypeName = partTypeName;
    }

    public String getPartTypeDesc() {
        return partTypeDesc;
    }

    public void setPartTypeDesc(String partTypeDesc) {
        this.partTypeDesc = partTypeDesc;
    }

    public String getPartTypeLogo() {
        return partTypeLogo;
    }

    public void setPartTypeLogo(String partTypeLogo) {
        this.partTypeLogo = partTypeLogo;
    }

    public Set<Part> getPartList() {
        return partList;
    }

    public void setPartList(Set<Part> partList) {
        this.partList = partList;
    }

	@Override
	public String toString() {
		return "PartType [id=" + id + ", partTypeCd=" + partTypeCd
				+ ", partTypeName=" + partTypeName + ", partTypeDesc="
				+ partTypeDesc + ", partTypeLogo=" + partTypeLogo
				+ ", partList=" + partList + "]";
	}
}
