package com.avijit.poc.onlinestore.business.entity;

import java.io.Serializable;

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

@Entity
@Table(name="ORDER_LINEITEMS")
public class LineItem  implements Serializable {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@OneToOne (fetch=FetchType.EAGER)
    private Part part;
	
	@Column(name="LINE_ITEM_NUM", nullable=false)
    private int lineItemNum;
	
	@Column(name="PART_CD", nullable=false)
    private String partCd;
	
	@Column(name="QTY", nullable=false)
    private int qty;
	
	@Column(name="UNIT_PRICE", nullable=false)
    private double unitPrice;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ORDER_ID", referencedColumnName="ID")
    private Order order;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public int getLineItemNum() {
        return lineItemNum;
    }

    public void setLineItemNum(int lineItemNum) {
        this.lineItemNum = lineItemNum;
    }

    public String getPartCd() {
        return partCd;
    }

    public void setPartCd(String partCd) {
        this.partCd = partCd;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "LineItem [id=" + id + ", part=" + part + ", lineItemNum="
				+ lineItemNum + ", partCd=" + partCd + ", qty=" + qty
				+ ", unitPrice=" + unitPrice + ", order=" + order + "]";
	}
    
}
