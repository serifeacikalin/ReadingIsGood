package com.readingisgood.api.request.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.readingisgood.api.dto.customer.CustomerDTO;
import com.readingisgood.api.request.ValidatedRequest;
import com.readingisgood.constant.ApiDoc;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;

@Data
public class CustomerDefinitionRequest implements ValidatedRequest {

     @ApiModelProperty(ApiDoc.Fields.CUSTOMER_INFO)
     private @Valid CustomerDTO customer;
     @JsonIgnore
     @Override
     public String localizeValidationFields(String fieldName) {
          return fieldName;
     }
}
