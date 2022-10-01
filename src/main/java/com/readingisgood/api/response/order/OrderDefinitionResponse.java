package com.readingisgood.api.response.order;

import com.readingisgood.api.dto.order.OrderDTO;
import com.readingisgood.api.dto.order.OrderDefinitionResultDTO;
import com.readingisgood.api.response.BaseResponse;
import com.readingisgood.constant.ApiDoc;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrderDefinitionResponse extends BaseResponse {

    @ApiModelProperty(ApiDoc.Fields.ORDER_INFO)
    private OrderDTO order;

    @ApiModelProperty(ApiDoc.Fields.ORDER_INFO)
    private OrderDefinitionResultDTO orderDetail;
}
