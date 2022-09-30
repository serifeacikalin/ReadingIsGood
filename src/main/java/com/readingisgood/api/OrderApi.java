package com.readingisgood.api;

import com.readingisgood.api.request.order.OrderDefinitionRequest;
import com.readingisgood.api.request.order.OrderListCriteriaRequest;
import com.readingisgood.api.response.order.OrderDefinitionResponse;
import com.readingisgood.api.response.order.OrderListResponse;
import com.readingisgood.service.exception.BusinessException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RequestMapping("siparis")
public interface OrderApi {

    @PostMapping("ekle")
    OrderDefinitionResponse save(@Valid @RequestBody OrderDefinitionRequest request) throws BusinessException;

    @PostMapping("listele")
    OrderListResponse listCustomer(@Valid @RequestBody OrderListCriteriaRequest request) throws BusinessException;

    @GetMapping("getir/{id}")
    OrderDefinitionResponse getOrderDetail(@PathVariable final Long id);
}
