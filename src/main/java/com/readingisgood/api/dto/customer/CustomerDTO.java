package com.readingisgood.api.dto.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.readingisgood.api.request.ValidatedRequest;
import com.readingisgood.constant.ApiDoc;
import com.readingisgood.constant.FieldLength;
import com.readingisgood.constant.ValidationErrorCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class CustomerDTO implements ValidatedRequest {

    private Long id;

    @ApiModelProperty(ApiDoc.Fields.CUSTOMER_NO)
    @Size(max = FieldLength.CUSTOMER_NO, message = ValidationErrorCode.INVALID_INPUT)
    @JsonProperty("customerNo")
    private Long customerNo;

    @ApiModelProperty(ApiDoc.Fields.CUSTOMER_NAME)
    @NotNull(message = ValidationErrorCode.CUSTOMER_DEFINITION_INPUT_EMPTY)
    @JsonProperty("customerName")
    private String customerName;

    @ApiModelProperty(ApiDoc.Fields.EMAIL)
    @NotNull(message = ValidationErrorCode.CUSTOMER_DEFINITION_INPUT_EMPTY)
    @Email(message = ValidationErrorCode.EMAIL_ADDRESS_INVALID)
    @JsonProperty("email")
    private String email;

    @ApiModelProperty(ApiDoc.Fields.PHONE_NUMBER)
    @NotNull(message = ValidationErrorCode.CUSTOMER_DEFINITION_INPUT_EMPTY)
    @Pattern(regexp = "^[1-9]{1}[0-9]{9}[02468]{1}$", message = ValidationErrorCode.PHONE_NUMBER_INVALID)
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @ApiModelProperty(ApiDoc.Fields.ADDRESS)
    @NotNull(message = ValidationErrorCode.CUSTOMER_DEFINITION_INPUT_EMPTY)
    @JsonProperty("address")
    private String address;

    @ApiModelProperty(ApiDoc.Fields.IDENTITY_NUMBER)
    @NotNull(message = ValidationErrorCode.CUSTOMER_DEFINITION_INPUT_EMPTY)
    @Pattern(regexp = "^[1-9]{1}[0-9]{9}[02468]{1}$", message = ValidationErrorCode.IDENTITY_NUMBER_INVALID)
    @JsonProperty("identityNumber")
    private String identityNumber;
    @JsonIgnore
    @Override
    public String localizeValidationFields(String fieldName) {
        return fieldName;
    }
}
