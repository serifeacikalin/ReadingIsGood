package com.readingisgood.api;

import com.readingisgood.api.request.customer.CustomerDefinitionRequest;
import com.readingisgood.api.request.customer.CustomerListCriteriaRequest;
import com.readingisgood.api.response.customer.CustomerDefinitionResponse;
import com.readingisgood.api.response.customer.CustomerListResponse;
import com.readingisgood.service.exception.BusinessException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/musteri")
public interface CustomerApi {

    @PostMapping(value = "ekle")
    CustomerDefinitionResponse save(@RequestBody CustomerDefinitionRequest request) throws BusinessException;

    @PostMapping(value = "guncelle")
    CustomerDefinitionResponse update(@RequestBody CustomerDefinitionRequest request) throws BusinessException;

    @PostMapping("listele")
    CustomerListResponse listCustomer(@Valid @RequestBody CustomerListCriteriaRequest request) throws BusinessException;

    @GetMapping("getir/{id}")
    CustomerDefinitionResponse getCustomerDetail(@PathVariable final Long id);
}
