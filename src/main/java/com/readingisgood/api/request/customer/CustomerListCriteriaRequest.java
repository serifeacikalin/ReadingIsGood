package com.readingisgood.api.request.customer;

import com.readingisgood.api.dto.order.OrderDTO;
import com.readingisgood.constant.ApiDoc;
import com.readingisgood.constant.ValidationErrorCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Data
public class CustomerListCriteriaRequest {

    @ApiModelProperty(ApiDoc.Fields.CUSTOMER_NO)
    private Long customerNo;

    @ApiModelProperty(ApiDoc.Fields.CUSTOMER_NAME)
    private String customerName;

    @ApiModelProperty(ApiDoc.Fields.EMAIL)
    @Email(message = ValidationErrorCode.EMAIL_ADDRESS_INVALID)
    private String email;

    @ApiModelProperty(ApiDoc.Fields.PHONE_NUMBER)
    @Pattern(regexp = "^[1-9]{1}[0-9]{9}[02468]{1}$", message = ValidationErrorCode.PHONE_NUMBER_INVALID)
    private String phoneNumber;

    @ApiModelProperty(ApiDoc.Fields.ADDRESS)
    private String address;

    @ApiModelProperty(ApiDoc.Fields.IDENTITY_NUMBER)
    @Pattern(regexp = "^[1-9]{1}[0-9]{9}[02468]{1}$", message = ValidationErrorCode.IDENTITY_NUMBER_INVALID)
    private String identityNumber;

    @ApiModelProperty(ApiDoc.Fields.STATUS)
    private String status;

    @ApiModelProperty(ApiDoc.Fields.ORDER_LIST)
    private Set<OrderDTO> order;
}
