package com.readingisgood.api.request.order;

import com.readingisgood.api.dto.book.BookDTO;
import com.readingisgood.api.dto.customer.CustomerDTO;
import lombok.Data;

import java.util.Set;

@Data
public class OrderDefinitionRequest {

    private Long orderCount;
    private CustomerDTO customer;
    private Set<BookDTO> books;
}
