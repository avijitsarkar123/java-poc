package com.avijit.poc.onlinestore.business.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PART_SPECIFICATION")
public class PartSpecification  implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="PART_ID", referencedColumnName="ID")
    private Part part;
	
	@Column(name="PART_SPEC_NAME")
    private String partSpecificationName;
	
	@Column(name="PART_SPEC_VALUE")
    private String partSpecificationValue;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Part getPart() {
        return part;
    }

    public void setPartId(Part part) {
        this.part = part;
    }

    public String getPartSpecificationName() {
        return partSpecificationName;
    }

    public void setPartSpecificationName(String partSpecificationName) {
        this.partSpecificationName = partSpecificationName;
    }

    public String getPartSpecificationValue() {
        return partSpecificationValue;
    }

    public void setPartSpecificationValue(String partSpecificationValue) {
        this.partSpecificationValue = partSpecificationValue;
    }

	@Override
	public String toString() {
		return "PartSpecification [id=" + id + ", part=" + part
				+ ", partSpecificationName=" + partSpecificationName
				+ ", partSpecificationValue=" + partSpecificationValue + "]";
	}
}
