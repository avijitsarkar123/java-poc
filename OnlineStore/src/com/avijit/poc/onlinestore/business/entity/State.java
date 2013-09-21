package com.avijit.poc.onlinestore.business.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STATE")
public class State implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
    
	@Column(name="STATE_CD", nullable=false)
	private String stateCd;
	
	@Column(name="STATE_NAME", nullable=false)
    private String stateName;

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStateCd() {
        return stateCd;
    }

    public void setStateCd(String stateCd) {
        this.stateCd = stateCd;
    }

	@Override
	public String toString() {
		return "State [id=" + id + ", stateCd=" + stateCd + ", stateName="
				+ stateName + "]";
	}
}
