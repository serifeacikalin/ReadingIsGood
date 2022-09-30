package com.readingisgood.service.impl.order;

import com.readingisgood.model.order.CustomerOrderReportCriteriaModel;
import com.readingisgood.model.order.CustomerOrdersModel;
import com.readingisgood.repository.OrderRepository;
import com.readingisgood.service.StatisticsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {

    private OrderRepository orderRepository;

    @Override
    public CustomerOrdersModel listCustomerOrders(CustomerOrderReportCriteriaModel criteriaModel) {
        return orderRepository.getTotalCustomerOrders(criteriaModel);
    }
}
