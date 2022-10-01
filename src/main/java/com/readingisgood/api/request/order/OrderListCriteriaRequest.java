package com.readingisgood.api.request.order;

import com.readingisgood.constant.ApiDoc;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderListCriteriaRequest {

    @ApiModelProperty(ApiDoc.Fields.ORDER_NO)
    private Long orderNo;

    @ApiModelProperty(ApiDoc.Fields.CUSTOMER_NO)
    private Long customerNo;

    @ApiModelProperty(ApiDoc.Fields.STATUS)
    private String status;

    @ApiModelProperty(ApiDoc.Fields.ORDER_DATE)
    private LocalDate orderDate;
}
