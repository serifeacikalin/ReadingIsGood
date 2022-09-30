package com.readingisgood.model.order;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerOrdersModel {
    private Long totalOrderCount;
    private Long totalBookCount;
    private Long totalPurchasedAmount;
    private String month;
}
