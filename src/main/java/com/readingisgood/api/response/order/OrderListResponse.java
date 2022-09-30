package com.readingisgood.api.response.order;

import com.readingisgood.api.dto.order.OrderDefinitionResultDTO;
import com.readingisgood.api.response.BaseResponse;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderListResponse extends BaseResponse {
    private List<OrderDefinitionResultDTO> orderList = new ArrayList<>();
}
