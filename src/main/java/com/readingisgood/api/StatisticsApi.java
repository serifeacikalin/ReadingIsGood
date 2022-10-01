package com.readingisgood.api;

import com.readingisgood.api.request.order.CustomerOrderReportCriteria;
import com.readingisgood.api.response.order.CustomerOrderReportResponse;
import com.readingisgood.constant.ApiDoc;
import com.readingisgood.infra.InboundService;
import com.readingisgood.service.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*")
@RequestMapping("istatistik")
@Api(tags = ApiDoc.API_NAME_STATISTIC, description = ApiDoc.Summary.STATISTIC_SUMMARY)
public interface StatisticsApi {
    @InboundService
    @ApiOperation(value = ApiDoc.Description.STATISTIC_LIST, notes = ApiDoc.Summary.STATISTIC_LIST)
    @PostMapping("getir")
    CustomerOrderReportResponse listCustomerOrders(@RequestBody CustomerOrderReportCriteria request) throws BusinessException;
}
