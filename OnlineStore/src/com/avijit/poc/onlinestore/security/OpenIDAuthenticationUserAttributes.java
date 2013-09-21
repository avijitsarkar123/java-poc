package com.avijit.poc.onlinestore.security;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.security.openid.OpenIDAttribute;
import org.springframework.security.openid.OpenIDAuthenticationToken;

public class OpenIDAuthenticationUserAttributes {
	private Set<String> openIDUserAttributeNames = new HashSet<String>();
	private Map<String, String> openIDUserAttributeNameValue = new HashMap<String, String>();

	public void setOpenIDUserAttributeNames(Set<String> openIDUserAttributeNames) {
		this.openIDUserAttributeNames = openIDUserAttributeNames;
	}
	
	public void loadOpenIDUserAttributes(OpenIDAuthenticationToken openIdAuth) {
		
		for(OpenIDAttribute attr : openIdAuth.getAttributes()) {
			
			if (openIDUserAttributeNames.contains(attr.getName())) {
				
				if (attr.getValues() != null && !attr.getValues().isEmpty()) {
					openIDUserAttributeNameValue.put(attr.getName(), attr.getValues().get(0));
				}
			}
        }
	}
	
	public String getOpenIDUserAttribute(String attributeName) {
		return openIDUserAttributeNameValue.get(attributeName);
	}
}
