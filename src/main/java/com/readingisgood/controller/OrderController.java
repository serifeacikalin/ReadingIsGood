package com.readingisgood.controller;

import com.readingisgood.api.OrderApi;
import com.readingisgood.api.dto.order.OrderDefinitionResultDTO;
import com.readingisgood.api.request.order.OrderDefinitionRequest;
import com.readingisgood.api.request.order.OrderListCriteriaRequest;
import com.readingisgood.api.response.order.OrderDefinitionResponse;
import com.readingisgood.api.response.order.OrderListResponse;
import com.readingisgood.model.order.OrderDefinitionModel;
import com.readingisgood.model.order.OrderListCriteriaModel;
import com.readingisgood.service.MapperService;
import com.readingisgood.service.OrderService;
import com.readingisgood.service.exception.BusinessException;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrderApi {

    private OrderService service;

    private MapperService mapper;

    public OrderController(OrderService service, MapperService mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public OrderDefinitionResponse save(OrderDefinitionRequest request) throws BusinessException {
        OrderDefinitionModel orderDefinitionModel = mapper.map(request, OrderDefinitionModel.class);
        OrderDefinitionModel order = service.save(orderDefinitionModel);
        OrderDefinitionResultDTO orderResult = mapper.map(order , OrderDefinitionResultDTO.class);
        OrderDefinitionResponse response = new OrderDefinitionResponse();
        response.setOrder(orderResult);
        return response;
    }

    @Override
    public OrderListResponse listCustomer(OrderListCriteriaRequest request) throws BusinessException {
        OrderListCriteriaModel criteriaModel = mapper.map(request, OrderListCriteriaModel.class);
        OrderListResponse response = new OrderListResponse();
        response.getOrderList().addAll(mapper.map(service.listOrder(criteriaModel), OrderDefinitionResultDTO.class));
        return response;
    }

    @Override
    public OrderDefinitionResponse getOrderDetail(Long id) {
        OrderDefinitionModel orderDefinitionModel = service.getOrderDetail(id);
        OrderDefinitionResultDTO resultDTO = mapper.map(orderDefinitionModel, OrderDefinitionResultDTO.class);
        OrderDefinitionResponse response = new OrderDefinitionResponse();
        response.setOrder(resultDTO);
        return response;
    }
}
