package com.readingisgood.service.validation.impl;

import com.readingisgood.entity.Customer;
import com.readingisgood.repository.CustomerRepository;
import com.readingisgood.service.exception.BusinessException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
class CustomerValidatorImplTest {
    @Mock
    private CustomerRepository repository;

    @InjectMocks
    private CustomerValidatorImpl validator;

    @Test
    public void  validate_shoulThrowBusinessException_whenCustomerIsExist() throws BusinessException {
        Mockito.lenient().when(repository.findCustomerByEmailAndPhoneNumberAndStatusAndRecordStatus(anyString(),anyString(),anyString(), anyBoolean())).thenReturn(relatedCustomer);
        Mockito.lenient().when(repository.findByCustomerNoAndRecordStatusAndStatus(anyLong(), anyBoolean(),anyString())).thenReturn(null);
        BusinessException thrown = assertThrows(
                BusinessException.class,
                () -> validator.validate(customer)
        );

        assertTrue(thrown.getCodeList().size()>0);
    }

    private static Customer customer = new Customer();

    private static Customer relatedCustomer = new Customer();
    private static final Long CUSTOMER_NO = 1111L;

    static {
        customer.setId(1L);
        customer.setCustomerName("musteri1");
        customer.setEmail("xxx@ccc");
        customer.setCustomerNo(CUSTOMER_NO);
        customer.setPhoneNumber("0000");
        customer.setAddress("turkiye");

        relatedCustomer.setId(1L);
        relatedCustomer.setCustomerName("musteri1");
        relatedCustomer.setEmail("xxx@ccc");
        relatedCustomer.setCustomerNo(CUSTOMER_NO);
        relatedCustomer.setPhoneNumber("0000");
        relatedCustomer.setAddress("turkiye");
    }

}