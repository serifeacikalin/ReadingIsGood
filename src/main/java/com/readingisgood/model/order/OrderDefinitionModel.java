package com.readingisgood.model.order;

import com.readingisgood.model.book.BookModel;
import com.readingisgood.model.customer.CustomerModel;
import lombok.Data;

import java.util.Set;

@Data
public class OrderDefinitionModel {
    private Long orderNo;
    private Long orderCount;
    private Set<BookModel> books;
    private CustomerModel customer;
}
