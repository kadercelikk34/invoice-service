package com.emlakjet.invoiceservice.validator;

import com.emlakjet.invoiceservice.dto.InvoiceDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class InvoiceValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return InvoiceDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productName", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "billingNo", "NotEmpty");

    }
}

