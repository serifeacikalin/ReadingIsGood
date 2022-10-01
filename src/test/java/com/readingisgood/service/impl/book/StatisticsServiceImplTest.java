package com.readingisgood.service.impl.book;

import com.readingisgood.model.order.CustomerOrderReportCriteriaModel;
import com.readingisgood.model.order.CustomerOrdersModel;
import com.readingisgood.model.order.OrderDefinitionModel;
import com.readingisgood.repository.BookRepository;
import com.readingisgood.service.exception.BusinessException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StatisticsServiceImplTest {

    @Mock
    private BookRepository repository;

    @InjectMocks
    private StatisticsServiceImpl service;


    @Test
    public void listCustomerOrder_shouldCustomerOrderReport_whenCustomerNoNotEmpty() throws BusinessException {
        when(repository.getTotalCustomerOrders(criteriaModel)).thenReturn(customerOrdersModel);
        CustomerOrdersModel resultList = service.listCustomerOrders(criteriaModel);
        assertEquals(CUSTOMER_NO, resultList.getCustomerNo());
    }

    private static final Long CUSTOMER_NO = 1111L;
    private static CustomerOrderReportCriteriaModel criteriaModel = new CustomerOrderReportCriteriaModel();
    private static CustomerOrdersModel customerOrdersModel = new CustomerOrdersModel(CUSTOMER_NO,1l,1l, BigDecimal.TEN);


    static {
        criteriaModel.setCustomerNo(CUSTOMER_NO);
    }
}