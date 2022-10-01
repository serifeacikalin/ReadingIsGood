package com.readingisgood.model.order;

import com.readingisgood.model.book.BookModel;
import com.readingisgood.model.customer.CustomerModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class OrderDefinitionModel {
    private Long id;
    private Long orderNo;
    private Long orderCount;
    private LocalDate orderDate;
    private Set<BookModel> books;
    private CustomerModel customer;
}
