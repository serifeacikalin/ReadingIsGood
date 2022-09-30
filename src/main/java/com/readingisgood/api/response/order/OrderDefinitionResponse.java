package com.readingisgood.api.response.order;

import com.readingisgood.api.dto.order.OrderDefinitionResultDTO;
import com.readingisgood.api.response.BaseResponse;
import lombok.Data;

@Data
public class OrderDefinitionResponse extends BaseResponse {

    private OrderDefinitionResultDTO order;
}
