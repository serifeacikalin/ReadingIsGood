package com.readingisgood.api;

import com.readingisgood.api.request.order.OrderDefinitionRequest;
import com.readingisgood.api.request.order.OrderListCriteriaRequest;
import com.readingisgood.api.response.order.OrderDefinitionResponse;
import com.readingisgood.api.response.order.OrderListResponse;
import com.readingisgood.constant.ApiDoc;
import com.readingisgood.infra.InboundService;
import com.readingisgood.service.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RequestMapping("siparis")
@Api(tags = ApiDoc.API_NAME_ORDER, description = ApiDoc.Summary.ORDER_SERVICE_SUMMARY)
public interface OrderApi {

    @InboundService
    @ApiOperation(value = ApiDoc.Description.SAVE_ORDER, notes = ApiDoc.Summary.SAVE_ORDER)
    @PostMapping("ekle")
    OrderDefinitionResponse save(@Valid @RequestBody OrderDefinitionRequest request) throws BusinessException;

    @InboundService
    @ApiOperation(value = ApiDoc.Description.LIST_ORDER, notes = ApiDoc.Summary.LIST_ORDER)
    @PostMapping("listele")
    OrderListResponse listCustomer(@Valid @RequestBody OrderListCriteriaRequest request) throws BusinessException;

    @InboundService
    @ApiOperation(value = ApiDoc.Description.GET_ORDER_DETAIL, notes = ApiDoc.Summary.GET_ORDER_DETAIL)
    @GetMapping("getir/{id}")
    OrderDefinitionResponse getOrderDetail(@PathVariable final Long id);
}
