package com.readingisgood.api.response.order;

import com.readingisgood.constant.ApiDoc;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerOrderReportResponse {

    @ApiModelProperty(ApiDoc.Fields.TOTAL_ORDER_COUNT)
    private Long totalOrderCount;

    @ApiModelProperty(ApiDoc.Fields.TOTAL_BOOK_COUNT)
    private Long totalBookCount;

    @ApiModelProperty(ApiDoc.Fields.TOTAL_AMOUNT)
    private Long totalPurchasedAmount;
}
