package com.avijit.poc.onlinestore.business.entity;

import java.io.Serializable;

public class UserRole  implements Serializable{
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

	@Override
	public String toString() {
		return "UserRole [roleName=" + roleName + "]";
	}
}
