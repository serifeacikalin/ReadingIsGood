package com.readingisgood.api.request.customer;

import com.readingisgood.api.dto.order.OrderDTO;
import com.readingisgood.constant.ValidationErrorCode;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Data
public class CustomerListCriteriaRequest {

    private Long customerNo;
    private String customerName;

    @Email(message = ValidationErrorCode.EMAIL_ADDRESS_INVALID)
    private String email;

    @Pattern(regexp = "^[1-9]{1}[0-9]{9}[02468]{1}$", message = ValidationErrorCode.PHONE_NUMBER_INVALID)
    private String phoneNumber;

    private String address;

    @Pattern(regexp = "^[1-9]{1}[0-9]{9}[02468]{1}$", message = ValidationErrorCode.IDENTITY_NUMBER_INVALID)
    private String identityNumber;

    private String status;

    private Set<OrderDTO> order;
}
