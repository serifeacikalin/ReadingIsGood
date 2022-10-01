package com.readingisgood.service.impl.order;

import com.readingisgood.constant.SequenceTableName;
import com.readingisgood.entity.Books;
import com.readingisgood.entity.Customer;
import com.readingisgood.entity.Order;
import com.readingisgood.model.book.BookModel;
import com.readingisgood.model.order.OrderDefinitionModel;
import com.readingisgood.model.order.OrderListCriteriaModel;
import com.readingisgood.model.order.OrderModel;
import com.readingisgood.repository.BookRepository;
import com.readingisgood.repository.CustomerRepository;
import com.readingisgood.repository.OrderRepository;
import com.readingisgood.service.MapperService;
import com.readingisgood.service.NumberGeneratorFactory;
import com.readingisgood.service.exception.BusinessException;
import com.readingisgood.service.repository.NumberGenerator;
import com.readingisgood.service.validation.OrderValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.CachingUserDetailsService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private MapperService mapper;

    @Mock
    private OrderRepository repository;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private NumberGeneratorFactory numberGeneratorFactory;

    @Mock
    private NumberGenerator numberGenerator;

    @Mock
    private OrderValidator validator;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private OrderServiceImpl service;

    @Test
    public void  saveOrder_shouldOrderRecord_whenOrderNoNotEmpty() throws BusinessException {
        when(mapper.map(orderDefinitionModel, Order.class)).thenReturn(order);
        when(bookRepository.findByRecordStatusAndStatusAndBookNo(anyBoolean(), anyString(), anyLong())).thenReturn(book);
        when(bookRepository.save(book)).thenReturn(book);
        when(numberGeneratorFactory.createGenerator(SequenceTableName.ORDER_NO_SEQ)).thenReturn(numberGenerator);
        when(numberGenerator.generate()).thenReturn(ORDER_NO);
        when(repository.save(order)).thenReturn(order);
        when(customerRepository.findByCustomerNoAndRecordStatusAndStatus(anyLong(),anyBoolean(), anyString())).thenReturn(customer);
        when(mapper.map(order, OrderModel.class)).thenReturn(orderModel);
        OrderModel result = service.save(orderDefinitionModel);
        assertEquals(ORDER_NO,result.getOrderNo());
    }

    @Test
    public void listOrder_shouldOrderList_whenOrderNoNotEmpty() throws BusinessException {
        when(repository.searchByCriteria(criteriaModel)).thenReturn(orderList);
        when(mapper.map(orderList, OrderDefinitionModel.class)).thenReturn(orderDefinitionModels);
        List<OrderDefinitionModel> resultList = service.listOrder(criteriaModel);
        assertTrue(resultList.size()>0);
    }

    @Test
    void getOrderDetail() {
        when(repository.findById(order.getId())).thenReturn(Optional.of(order));
        when(mapper.map(order, OrderDefinitionModel.class)).thenReturn(orderDefinitionModel);
        OrderDefinitionModel result = service.getOrderDetail(order.getId());
        assertEquals(ORDER_NO, result.getOrderNo());
    }

    @Test
    void listCustomerOrder() {
        when(repository.findByRecordStatusAndStatusAndCustomer_CustomerNo(anyBoolean(), anyString(), anyLong())).thenReturn(orderList);
        when(mapper.map(orderList, OrderDefinitionModel.class)).thenReturn(orderDefinitionModels);
        List<OrderDefinitionModel> resultList = service.listCustomerOrder(criteriaModel.getCustomerNo());
        assertTrue(resultList.size()>0);
    }

    private static OrderDefinitionModel orderDefinitionModel = new OrderDefinitionModel();
    private static OrderModel orderModel = new OrderModel();
    private static Order order = new Order();
    private static List<Order> orderList = new ArrayList<>();
    private static Books book = new Books();
    private static Set<Books> bookList = new HashSet<>();
    private static BookModel bookModel = new BookModel();
    private static Set<BookModel> bookModels = new HashSet<>();
    private static List<OrderDefinitionModel> orderDefinitionModels = new ArrayList<>();
    private static OrderListCriteriaModel criteriaModel = new OrderListCriteriaModel();

    private static Customer customer = new Customer();
    private static final Long ORDER_NO = 1111L;
    private static final Long BOOK_NO = 1111L;
    private static final Long CUSTOMER_NO = 1L;

    static {
        orderModel.setOrderNo(ORDER_NO);
        order.setOrderNo(ORDER_NO);
        order.setOrderCount(1L);

        book.setBookName("kitap1");
        book.setAuthorName("yazar1");
        book.setBookNo(BOOK_NO);
        book.setPublicationYear("2022");
        book.setStock(2L);
        bookList.add(book);

        order.setBooks(bookList);

        bookModel.setBookName("kitap1");
        bookModel.setAuthorName("yazar1");
        bookModel.setBookNo(BOOK_NO);
        bookModel.setPublicationYear("2022");
        bookModel.setStock(2L);
        bookModels.add(bookModel);

        orderDefinitionModel.setOrderNo(ORDER_NO);
        orderDefinitionModel.setBooks(bookModels);

        criteriaModel.setOrderNo(ORDER_NO);
        criteriaModel.setCustomerNo(CUSTOMER_NO);

        orderList.add(order);
        orderDefinitionModels.add(orderDefinitionModel);

        customer.setCustomerName("musteri1");
        customer.setEmail("xxx@ccc");
        customer.setCustomerNo(CUSTOMER_NO);
        customer.setPhoneNumber("0000");
        customer.setAddress("turkiye");

        order.setCustomer(customer);
    }


}