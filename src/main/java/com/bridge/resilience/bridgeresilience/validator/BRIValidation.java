package com.bridge.resilience.bridgeresilience.validator;

import com.bridge.resilience.bridgeresilience.model.BridgeNamevalidtion;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class BRIValidation implements Validator {
    private EmailValidator emailValidator = EmailValidator.getInstance();

    // This validator only checks for the CustomerForm.
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == BridgeNamevalidtion.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BridgeNamevalidtion bridge_name = (BridgeNamevalidtion) target;

        // Check the fields of CustomerForm.
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bridge_name", "NotEmpty.BridgeNamevalidtion.bridge_name");

        if (!emailValidator.isValid(bridge_name.getBridge_name())) {
            errors.rejectValue("bridge_name", "Pattern.BridgeNamevalidtion.bridge_name");
        }
    }
}
