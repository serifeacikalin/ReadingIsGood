package com.readingisgood.api.dto.customer;

import com.readingisgood.constant.FieldLength;
import com.readingisgood.constant.ValidationErrorCode;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class CustomerDTO {

    @Size(max = FieldLength.CUSTOMER_NO, message = ValidationErrorCode.INVALID_INPUT)
    private Long customerNo;

    @NotEmpty(message = ValidationErrorCode.CUSTOMER_DEFINITION_INPUT_EMPTY)
    private String customerName;

    @NotEmpty(message = ValidationErrorCode.CUSTOMER_DEFINITION_INPUT_EMPTY)
    @Email(message = ValidationErrorCode.EMAIL_ADDRESS_INVALID)
    private String email;

    @NotEmpty(message = ValidationErrorCode.CUSTOMER_DEFINITION_INPUT_EMPTY)
    @Pattern(regexp = "^[1-9]{1}[0-9]{9}[02468]{1}$", message = ValidationErrorCode.PHONE_NUMBER_INVALID)
    private String phoneNumber;

    @NotEmpty(message = ValidationErrorCode.CUSTOMER_DEFINITION_INPUT_EMPTY)
    private String address;

    @NotEmpty(message = ValidationErrorCode.CUSTOMER_DEFINITION_INPUT_EMPTY)
    @Pattern(regexp = "^[1-9]{1}[0-9]{9}[02468]{1}$", message = ValidationErrorCode.IDENTITY_NUMBER_INVALID)
    private String identityNumber;
}
