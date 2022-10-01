package com.readingisgood.api.request.customer;

import com.readingisgood.api.dto.customer.CustomerDTO;
import com.readingisgood.constant.ApiDoc;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;

@Data
public class CustomerDefinitionRequest {

     @ApiModelProperty(ApiDoc.Fields.CUSTOMER_INFO)
     private @Valid CustomerDTO customer;
}
