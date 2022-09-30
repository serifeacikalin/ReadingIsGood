package com.readingisgood.api.response.customer;

import com.readingisgood.api.dto.customer.CustomerDefinitionResultDTO;
import com.readingisgood.api.response.BaseResponse;
import lombok.Data;

@Data
public class CustomerDefinitionResponse extends BaseResponse {

    private CustomerDefinitionResultDTO customer;
}
