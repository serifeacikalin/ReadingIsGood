package com.readingisgood.service.validation.impl;

import com.readingisgood.constant.ReadingIsGoodStatus;
import com.readingisgood.entity.Books;
import com.readingisgood.entity.Customer;
import com.readingisgood.entity.Order;
import com.readingisgood.repository.BookRepository;
import com.readingisgood.repository.CustomerRepository;
import com.readingisgood.repository.OrderRepository;
import com.readingisgood.service.exception.BusinessException;
import com.readingisgood.service.validation.OrderValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderValidatorImpl implements OrderValidator {

    private OrderRepository repository;

    private CustomerRepository customerRepository;

    private BookRepository bookRepository;

    @Override
    public void validate(Order order) throws BusinessException {

        if(order.getCustomer() == null){
            throw new BusinessException("");
        }

        Customer customer = customerRepository.findByCustomerNoAndRecordStatusAndStatus(order.getCustomer().getCustomerNo(), Boolean.TRUE, ReadingIsGoodStatus.AKTIF.getValue());

        if(customer == null){
            throw new BusinessException("");
        }

        if(order.getBooks().isEmpty()){
            throw new BusinessException("");
        }

        for (Books book: order.getBooks()) {
            Books relatedBook = bookRepository.findByRecordStatusAndStatusAndBookNo(Boolean.TRUE, ReadingIsGoodStatus.AKTIF.getValue(), book.getBookNo());

            if(relatedBook == null){
                throw new BusinessException("");
            }

            if(relatedBook.getStock() < order.getOrderCount()){
                throw new BusinessException("");
            }
        }

    }
}
