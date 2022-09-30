package com.readingisgood.service;

import com.readingisgood.model.order.OrderDefinitionModel;
import com.readingisgood.model.order.OrderListCriteriaModel;
import com.readingisgood.service.exception.BusinessException;

import java.util.List;

public interface OrderService {

    OrderDefinitionModel save(OrderDefinitionModel orderModel) throws BusinessException;

    List<OrderDefinitionModel> listOrder(OrderListCriteriaModel criteriaModel);

    OrderDefinitionModel getOrderDetail(Long id);

    List<OrderDefinitionModel> listCustomerOrder(Long customerNo);
}
