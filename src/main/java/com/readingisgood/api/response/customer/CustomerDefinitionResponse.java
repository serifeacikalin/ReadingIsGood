package com.readingisgood.api.response.customer;

import com.readingisgood.api.dto.customer.CustomerDefinitionResultDTO;
import com.readingisgood.api.response.BaseResponse;
import com.readingisgood.constant.ApiDoc;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerDefinitionResponse extends BaseResponse {

    @ApiModelProperty(ApiDoc.Fields.CUSTOMER_INFO)
    private CustomerDefinitionResultDTO customer;
}
