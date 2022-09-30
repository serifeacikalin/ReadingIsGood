package com.readingisgood.api.response.order;

import lombok.Data;

@Data
public class CustomerOrderReportResponse {
    private Long totalOrderCount;
    private Long totalBookCount;
    private Long totalPurchasedAmount;
    private String month;
}
