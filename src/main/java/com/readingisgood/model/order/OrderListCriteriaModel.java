package com.readingisgood.model.order;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class OrderListCriteriaModel {
    private Long orderNo;
    private Long customerNo;
    private String status;
    private LocalDate orderDate;
}
