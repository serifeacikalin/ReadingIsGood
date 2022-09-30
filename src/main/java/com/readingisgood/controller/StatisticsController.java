package com.readingisgood.controller;

import com.readingisgood.api.StatisticsApi;
import com.readingisgood.api.request.order.CustomerOrderReportCriteria;
import com.readingisgood.api.response.order.CustomerOrderReportResponse;
import com.readingisgood.model.order.CustomerOrderReportCriteriaModel;
import com.readingisgood.service.MapperService;
import com.readingisgood.service.StatisticsService;
import com.readingisgood.service.exception.BusinessException;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsController implements StatisticsApi {
    private StatisticsService service;
    private MapperService mapper;

    public StatisticsController(StatisticsService service, MapperService mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public CustomerOrderReportResponse listCustomerOrders(CustomerOrderReportCriteria request) throws BusinessException {
        CustomerOrderReportCriteriaModel criteriaModel = mapper.map(request, CustomerOrderReportCriteriaModel.class);
        return mapper.map(service.listCustomerOrders(criteriaModel), CustomerOrderReportResponse.class);
    }
}
