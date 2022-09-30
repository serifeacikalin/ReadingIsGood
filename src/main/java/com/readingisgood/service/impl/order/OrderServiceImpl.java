package com.readingisgood.service.impl.order;

import com.readingisgood.constant.ReadingIsGoodStatus;
import com.readingisgood.constant.SequenceTableName;
import com.readingisgood.entity.Books;
import com.readingisgood.entity.Customer;
import com.readingisgood.entity.Order;
import com.readingisgood.model.order.OrderDefinitionModel;
import com.readingisgood.model.order.OrderListCriteriaModel;
import com.readingisgood.repository.BookRepository;
import com.readingisgood.repository.CustomerRepository;
import com.readingisgood.repository.OrderRepository;
import com.readingisgood.service.MapperService;
import com.readingisgood.service.NumberGeneratorFactory;
import com.readingisgood.service.OrderService;
import com.readingisgood.service.exception.BusinessException;
import com.readingisgood.service.validation.OrderValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private MapperService mapper;

    private OrderRepository repository;

    private NumberGeneratorFactory numberGeneratorFactory;

    private OrderValidator validator;

    private BookRepository bookRepository;

    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public OrderDefinitionModel save(OrderDefinitionModel orderModel) throws BusinessException {
        Order order = mapper.map(orderModel, Order.class);
        validator.validate(order);
        order.setStatus(ReadingIsGoodStatus.AKTIF.getValue());
        order.setRecordStatus(Boolean.TRUE);
        order.setOrderNo((Long) numberGeneratorFactory.createGenerator(SequenceTableName.ORDER_NO_SEQ).generate());
        setOrderCustomerInfo(order);
        setBookOrderInfo(order);
        Order newRecord = repository.save(order);
        updateBookStock(order.getBooks(), order);
        return mapper.map(newRecord, OrderDefinitionModel.class);
    }

    private void setOrderCustomerInfo(Order order) {
        Customer relatedCustomer = customerRepository.findByCustomerNoAndRecordStatusAndStatus(order.getCustomer().getCustomerNo(), Boolean.TRUE, ReadingIsGoodStatus.AKTIF.getValue());
        order.setCustomer(relatedCustomer);
    }

    private void setBookOrderInfo(Order order) {
        for (Books book : order.getBooks()) {
            Books relatedBook = bookRepository.findByRecordStatusAndStatusAndBookNo(Boolean.TRUE, ReadingIsGoodStatus.AKTIF.getValue(), book.getBookNo());
            order.addBook(relatedBook);
        }
    }

    private void updateBookStock(Set<Books> books, Order order) {
        for (Books book : books) {
            Books relatedBook = bookRepository.findByRecordStatusAndStatusAndBookNo(Boolean.TRUE, ReadingIsGoodStatus.AKTIF.getValue(), book.getBookNo());
            relatedBook.setStock(relatedBook.getStock()-order.getOrderCount());
            bookRepository.save(relatedBook);
        }
    }

    @Override
    public List<OrderDefinitionModel> listOrder(OrderListCriteriaModel criteriaModel) {
        List<Order> customerList = repository.searchByCriteria(criteriaModel);
        return mapper.map(customerList, OrderDefinitionModel.class);
    }

    @Override
    public OrderDefinitionModel getOrderDetail(Long id) {
        Order order = repository.findById(id).get();
        return mapper.map(order, OrderDefinitionModel.class);
    }

    @Override
    public List<OrderDefinitionModel> listCustomerOrder(Long customerNo) {
        List<Order> orderList = repository.findByRecordStatusAndStatusAndCustomer_CustomerNo(Boolean.TRUE, ReadingIsGoodStatus.AKTIF.getValue(), customerNo);
        return mapper.map(orderList, OrderDefinitionModel.class);
    }
}
