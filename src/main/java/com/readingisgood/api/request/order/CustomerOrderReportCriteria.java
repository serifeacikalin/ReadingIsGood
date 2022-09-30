package com.readingisgood.api.request.order;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerOrderReportCriteria {
    private Long customerNo;
    private LocalDate startDate;
    private LocalDate endDate;
}
