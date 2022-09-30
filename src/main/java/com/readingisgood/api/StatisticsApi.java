package com.readingisgood.api;

import com.readingisgood.api.request.order.CustomerOrderReportCriteria;
import com.readingisgood.api.response.order.CustomerOrderReportResponse;
import com.readingisgood.service.exception.BusinessException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*")
@RequestMapping("istatistik")
public interface StatisticsApi {

    @PostMapping("getir")
    CustomerOrderReportResponse listCustomerOrders(@RequestBody CustomerOrderReportCriteria request) throws BusinessException;
}
