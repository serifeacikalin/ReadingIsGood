package com.readingisgood.service.validation.impl;

import com.readingisgood.entity.Books;
import com.readingisgood.entity.Customer;
import com.readingisgood.entity.Order;
import com.readingisgood.repository.BookRepository;
import com.readingisgood.repository.CustomerRepository;
import com.readingisgood.repository.OrderRepository;
import com.readingisgood.service.exception.BusinessException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
class OrderValidatorImplTest {

    @Mock
    private OrderRepository repository;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private OrderValidatorImpl validator;

    @Test
    public void  validate_shoulThrowBusinessException_whenCustomerIsNotExist() throws BusinessException {
        Mockito.lenient().when(customerRepository.findByCustomerNoAndRecordStatusAndStatus(anyLong(), anyBoolean(), anyString())).thenReturn(null);
        Mockito.lenient().when(bookRepository.findByRecordStatusAndStatusAndBookNo(anyBoolean(),anyString(),anyLong())).thenReturn(book);
        BusinessException thrown = assertThrows(
                BusinessException.class,
                () -> validator.validate(order)
        );
        assertTrue(thrown.getCodeList().size()>0);
    }

    private static Order order = new Order();
    private static List<Order> orderList = new ArrayList<>();
    private static Books book = new Books();
    private static Set<Books> bookList = new HashSet<>();
    private static Customer customer = new Customer();
    private static final Long ORDER_NO = 1111L;
    private static final Long BOOK_NO = 1111L;
    private static final Long CUSTOMER_NO = 1L;

    static {
        order.setOrderNo(ORDER_NO);
        order.setOrderCount(1L);

        book.setBookName("kitap1");
        book.setAuthorName("yazar1");
        book.setBookNo(BOOK_NO);
        book.setPublicationYear("2022");
        book.setStock(2L);
        bookList.add(book);

        order.setBooks(bookList);
        orderList.add(order);

        customer.setCustomerName("musteri1");
        customer.setEmail("xxx@ccc");
        customer.setCustomerNo(CUSTOMER_NO);
        customer.setPhoneNumber("0000");
        customer.setAddress("turkiye");

        order.setCustomer(customer);
    }
}