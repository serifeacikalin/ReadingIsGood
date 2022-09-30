package com.readingisgood.service.impl.customer;

import com.readingisgood.constant.SequenceTableName;
import com.readingisgood.entity.Customer;
import com.readingisgood.model.customer.CustomerDefinitionModel;
import com.readingisgood.model.customer.CustomerListCriteriaModel;
import com.readingisgood.model.customer.CustomerModel;
import com.readingisgood.repository.CustomerRepository;
import com.readingisgood.service.MapperService;
import com.readingisgood.service.NumberGeneratorFactory;
import com.readingisgood.service.exception.BusinessException;
import com.readingisgood.service.repository.NumberGenerator;
import com.readingisgood.service.validation.CustomerValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private MapperService mapper;

    @Mock
    private CustomerRepository repository;

    @Mock
    private NumberGeneratorFactory numberGeneratorFactory;

    @Mock
    private CustomerValidator validator;

    @Mock
    private NumberGenerator numberGenerator;

    @InjectMocks
    private CustomerServiceImpl service;

    @Test
    public void  saveCustomer_shouldCustomerRecord_whenCustomerNameNotEmpty() throws BusinessException {
        when(mapper.map(customerDefinitionModel, Customer.class)).thenReturn(customer);
        Mockito.lenient().when(repository.findCustomerByEmailAndPhoneNumberAndStatusAndRecordStatus(anyString(),anyString(),anyString(),anyBoolean())).thenReturn(customer);
        when(numberGeneratorFactory.createGenerator(SequenceTableName.CUSTOMER_NO_SEQ)).thenReturn(numberGenerator);
        when(numberGenerator.generate()).thenReturn(CUSTOMER_NO);
        when(repository.save(customer)).thenReturn(customer);
        when(mapper.map(customer, CustomerDefinitionModel.class)).thenReturn(customerDefinitionModel);
        CustomerDefinitionModel result = service.save(customerDefinitionModel);
        assertEquals(CUSTOMER_NO,result.getCustomerNo());
    }

    @Test
    public void  listCustomer_shouldCustomerList_whenCustomerNoNotEmpty() throws BusinessException {
        when(repository.searchByCriteria(criteriaModel)).thenReturn(customerList);
        when(mapper.map(customerList, CustomerDefinitionModel.class)).thenReturn(customerDefinitionModelList);
        List<CustomerDefinitionModel> resultList = service.listCustomer(criteriaModel);
        assertTrue(resultList.size()>0);
    }

    @Test
    public void  getCustomerDetail_shouldCustomerInfo_whenCustomerIdNotEmpty() throws BusinessException {
        when(repository.findById(customer.getId())).thenReturn(Optional.of(customer));
        when(mapper.map(customer, CustomerDefinitionModel.class)).thenReturn(customerDefinitionModel);
        CustomerDefinitionModel customerDetail = service.getCustomerDetail(customer.getId());
        assertEquals(CUSTOMER_NO, customerDetail.getCustomerNo());
    }

    private static CustomerDefinitionModel customerDefinitionModel = new CustomerDefinitionModel();
    private static CustomerModel customerModel = new CustomerModel();
    private static Customer customer = new Customer();

    private static List<Customer> customerList = new ArrayList<>();

    private static List<CustomerDefinitionModel> customerDefinitionModelList = new ArrayList<>();

    private static CustomerListCriteriaModel criteriaModel = new CustomerListCriteriaModel();
    private static final Long CUSTOMER_NO = 1111L;

    static {
        customerModel.setCustomerName("musteri1");
        customerModel.setEmail("xxx@ccc");
        customerModel.setCustomerNo(CUSTOMER_NO);
        customerModel.setPhoneNumber("0000");
        customerModel.setAddress("turkiye");

        customerDefinitionModel.setCustomerName("musteri1");
        customerDefinitionModel.setEmail("xxx@ccc");
        customerDefinitionModel.setCustomerNo(CUSTOMER_NO);
        customerDefinitionModel.setPhoneNumber("0000");
        customerDefinitionModel.setAddress("turkiye");

        customer.setCustomerName("musteri1");
        customer.setEmail("xxx@ccc");
        customer.setCustomerNo(CUSTOMER_NO);
        customer.setPhoneNumber("0000");
        customer.setAddress("turkiye");

        criteriaModel.setCustomerName("musteri1");
        criteriaModel.setCustomerNo(CUSTOMER_NO);

        customerList.add(customer);
        customerDefinitionModelList.add(customerDefinitionModel);
    }
}