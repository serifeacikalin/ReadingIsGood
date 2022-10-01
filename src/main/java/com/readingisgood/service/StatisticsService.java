package com.readingisgood.service;

import com.readingisgood.model.order.CustomerOrderReportCriteriaModel;
import com.readingisgood.model.order.CustomerOrdersModel;

public interface StatisticsService {
    CustomerOrdersModel listCustomerOrders(CustomerOrderReportCriteriaModel criteriaModel);
}
