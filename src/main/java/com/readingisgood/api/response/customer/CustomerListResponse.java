package com.readingisgood.api.response.customer;

import com.readingisgood.api.dto.customer.CustomerDefinitionResultDTO;
import com.readingisgood.api.response.BaseResponse;
import com.readingisgood.constant.ApiDoc;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerListResponse extends BaseResponse {

    @ApiModelProperty(ApiDoc.Fields.CUSTOMER_LIST)
    private List<CustomerDefinitionResultDTO> customerList = new ArrayList<>();
}
