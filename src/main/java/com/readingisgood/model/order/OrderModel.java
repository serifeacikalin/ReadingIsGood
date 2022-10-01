package com.readingisgood.model.order;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderModel {
    private Long id;
    private Long orderNo;
    private Long orderCount;
    private LocalDate orderDate;
}
