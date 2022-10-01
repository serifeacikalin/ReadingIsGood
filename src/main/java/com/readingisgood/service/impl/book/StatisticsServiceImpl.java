package com.readingisgood.service.impl.book;

import com.readingisgood.model.order.CustomerOrderReportCriteriaModel;
import com.readingisgood.model.order.CustomerOrdersModel;
import com.readingisgood.repository.BookRepository;
import com.readingisgood.service.StatisticsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {
    private BookRepository bookRepository;
    @Override
    public CustomerOrdersModel listCustomerOrders(CustomerOrderReportCriteriaModel criteriaModel) {
        return bookRepository.getTotalCustomerOrders(criteriaModel);
    }
}
