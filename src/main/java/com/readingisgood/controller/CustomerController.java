package com.readingisgood.controller;

import com.readingisgood.api.CustomerApi;
import com.readingisgood.api.dto.customer.CustomerDefinitionResultDTO;
import com.readingisgood.api.request.customer.CustomerDefinitionRequest;
import com.readingisgood.api.request.customer.CustomerListCriteriaRequest;
import com.readingisgood.api.response.customer.CustomerDefinitionResponse;
import com.readingisgood.api.response.customer.CustomerListResponse;
import com.readingisgood.model.customer.CustomerDefinitionModel;
import com.readingisgood.model.customer.CustomerListCriteriaModel;
import com.readingisgood.service.CustomerService;
import com.readingisgood.service.MapperService;
import com.readingisgood.service.exception.BusinessException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController implements CustomerApi{

    private CustomerService service;

    private MapperService mapper;

    public CustomerController(CustomerService service, MapperService mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public CustomerDefinitionResponse save(CustomerDefinitionRequest request) throws BusinessException {
        CustomerDefinitionModel customerDefinitionModel = mapper.map(request.getCustomer(), CustomerDefinitionModel.class);
        CustomerDefinitionModel customer = service.save(customerDefinitionModel);
        CustomerDefinitionResultDTO customerResult = mapper.map(customer , CustomerDefinitionResultDTO.class);
        CustomerDefinitionResponse response = new CustomerDefinitionResponse();
        response.setCustomer(customerResult);
        return response;
    }

    @Override
    public CustomerDefinitionResponse update(CustomerDefinitionRequest request) throws BusinessException {
        CustomerDefinitionModel customerDefinitionModel = mapper.map(request.getCustomer(), CustomerDefinitionModel.class);
        CustomerDefinitionModel customer = service.update(customerDefinitionModel);
        CustomerDefinitionResultDTO customerResult = mapper.map(customer , CustomerDefinitionResultDTO.class);
        CustomerDefinitionResponse response = new CustomerDefinitionResponse();
        response.setCustomer(customerResult);
        return response;
    }

    @Override
    public CustomerListResponse listCustomer(CustomerListCriteriaRequest request) throws BusinessException {
        CustomerListCriteriaModel criteriaModel = mapper.map(request, CustomerListCriteriaModel.class);
        CustomerListResponse response = new CustomerListResponse();
        response.getCustomerList().addAll(mapper.map(service.listCustomer(criteriaModel), CustomerDefinitionResultDTO.class));
        return response;
    }

    @Override
    public CustomerDefinitionResponse getCustomerDetail(Long id) {
        CustomerDefinitionModel customerDetailModel = service.getCustomerDetail(id);
        CustomerDefinitionResultDTO resultDTO = mapper.map(customerDetailModel, CustomerDefinitionResultDTO.class);
        CustomerDefinitionResponse response = new CustomerDefinitionResponse();
        response.setCustomer(resultDTO);
        return response;
    }
}
