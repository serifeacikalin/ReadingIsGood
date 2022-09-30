package com.readingisgood.service;

import com.readingisgood.model.customer.CustomerDefinitionModel;
import com.readingisgood.model.customer.CustomerListCriteriaModel;
import com.readingisgood.service.exception.BusinessException;

import java.util.List;

public interface CustomerService {

    CustomerDefinitionModel save(CustomerDefinitionModel customerModel) throws BusinessException;

    CustomerDefinitionModel update(CustomerDefinitionModel customerModel) throws BusinessException;

    List<CustomerDefinitionModel> listCustomer(CustomerListCriteriaModel criteriaModel);

    CustomerDefinitionModel getCustomerDetail(Long id);
}
