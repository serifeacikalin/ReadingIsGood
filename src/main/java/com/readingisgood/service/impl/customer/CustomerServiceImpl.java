package com.readingisgood.service.impl.customer;

import com.readingisgood.constant.ReadingIsGoodStatus;
import com.readingisgood.constant.SequenceTableName;
import com.readingisgood.entity.Customer;
import com.readingisgood.model.customer.CustomerDefinitionModel;
import com.readingisgood.model.customer.CustomerListCriteriaModel;
import com.readingisgood.repository.CustomerRepository;
import com.readingisgood.service.CustomerService;
import com.readingisgood.service.MapperService;
import com.readingisgood.service.NumberGeneratorFactory;
import com.readingisgood.service.exception.BusinessException;
import com.readingisgood.service.validation.CustomerValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private MapperService mapper;

    private CustomerRepository repository;

    private NumberGeneratorFactory numberGeneratorFactory;

    private CustomerValidator validator;


    @Override
    public CustomerDefinitionModel save(CustomerDefinitionModel customerModel) throws BusinessException {
        Customer customer = mapper.map(customerModel, Customer.class);
        validator.validate(customer);
        customer.setStatus(ReadingIsGoodStatus.AKTIF.getValue());
        customer.setRecordStatus(Boolean.TRUE);
        customer.setCustomerNo((Long) numberGeneratorFactory.createGenerator(SequenceTableName.CUSTOMER_NO_SEQ).generate());
        Customer newRecord = repository.save(customer);
        return mapper.map(newRecord, CustomerDefinitionModel.class);
    }

    @Override
    public CustomerDefinitionModel update(CustomerDefinitionModel customerModel) throws BusinessException {
        Customer customer = mapper.map(customerModel, Customer.class);
        validator.validate(customer);
        return updateCustomerInfo(customer);
    }

    private CustomerDefinitionModel updateCustomerInfo(Customer customer) {
        Customer relatedCustomer = repository.findByCustomerNoAndRecordStatusAndStatus(customer.getCustomerNo(), Boolean.TRUE,  ReadingIsGoodStatus.AKTIF.getValue());
        relatedCustomer.setCustomerName(customer.getCustomerName());
        relatedCustomer.setAddress(customer.getAddress());
        relatedCustomer.setIdentityNumber(customer.getIdentityNumber());
        relatedCustomer.setEmail(customer.getEmail());
        relatedCustomer.setPhoneNumber(customer.getPhoneNumber());
        relatedCustomer.setUpdatedUser(customer.getCreatedUser());
        customer.setStatus(ReadingIsGoodStatus.AKTIF.getValue());
        customer.setRecordStatus(Boolean.TRUE);
        Customer newRecord = repository.save(relatedCustomer);
        return mapper.map(newRecord, CustomerDefinitionModel.class);
    }

    @Override
    public List<CustomerDefinitionModel> listCustomer(CustomerListCriteriaModel criteriaModel) {
        List<Customer> customerList = repository.searchByCriteria(criteriaModel);
        return mapper.map(customerList, CustomerDefinitionModel.class);
    }

    @Override
    public CustomerDefinitionModel getCustomerDetail(Long id) {
        Customer customer = repository.findById(id).get();
        return mapper.map(customer, CustomerDefinitionModel.class);
    }
}
