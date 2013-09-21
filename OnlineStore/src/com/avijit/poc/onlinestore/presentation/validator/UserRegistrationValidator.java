package com.avijit.poc.onlinestore.presentation.validator;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.avijit.poc.onlinestore.presentation.bean.UserForm;

@Component("userRegistrationValidator")
public class UserRegistrationValidator implements Validator {
    private static final String PHONE_REGEXP = "/(\\({0,1})(\\d{3})(\\){0,1})(\\s|-)*(\\d{3})(\\s|-)*(\\d{4})/";

    public boolean supports(Class clazz) {
        return UserForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object obj, Errors errors) {
        validateUserForm((UserForm) obj, errors);
    }

    public void validateUserForm(UserForm userForm, Errors errors) {
    	if (StringUtils.isBlank(userForm.getOpenId())) {
    		ValidationUtils.rejectIfEmpty(errors, "userName", "NAME_REQUIRED", "User Name is required.");
    		ValidationUtils.rejectIfEmpty(errors, "password", "PASSWORD_REQUIRED", "Password is required.");
    		ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "CONFIRM_PASSWORD_REQUIRED", "Password is required.");
    	}
        ValidationUtils.rejectIfEmpty(errors, "firstName", "FIRST_NAME_REQUIRED", "First Name is required.");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "LAST_NAME_REQUIRED", "Last Name is required.");
        ValidationUtils.rejectIfEmpty(errors, "emailAddress", "EMAIL_REQUIRED", "Email is required.");
        
        if (userForm.getConfirmPassword() != null
        		&& userForm.getPassword() != null
        		&& !userForm.getConfirmPassword().trim().equals(userForm.getPassword())) {
        	
        	errors.rejectValue("confirmPassword", "CONFIRM_PASSWORD_ERROR", "Confirm password not matching with password.");
        }
    }

}
