package com.readingisgood.api.dto.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.readingisgood.api.request.ValidatedRequest;
import com.readingisgood.constant.ApiDoc;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerDefinitionResultDTO implements ValidatedRequest {

    private Long id;

    @ApiModelProperty(ApiDoc.Fields.CUSTOMER_NO)
    private Long customerNo;

    @ApiModelProperty(ApiDoc.Fields.CUSTOMER_NAME)
    private String customerName;

    @ApiModelProperty(ApiDoc.Fields.EMAIL)
    private String email;

    @ApiModelProperty(ApiDoc.Fields.PHONE_NUMBER)
    private String phoneNumber;

    @ApiModelProperty(ApiDoc.Fields.ADDRESS)
    private String address;

    @ApiModelProperty(ApiDoc.Fields.IDENTITY_NUMBER)
    private String identityNumber;
    @JsonIgnore
    @Override
    public String localizeValidationFields(String fieldName) {
        return fieldName;
    }
}
