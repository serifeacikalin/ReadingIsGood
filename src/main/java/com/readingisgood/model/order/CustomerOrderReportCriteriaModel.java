package com.readingisgood.model.order;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerOrderReportCriteriaModel {
    private Long customerNo;
    private LocalDate startDate;
    private LocalDate endDate;
}
