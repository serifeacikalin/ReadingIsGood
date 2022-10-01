package com.readingisgood.repository;

import com.readingisgood.entity.Order;
import com.readingisgood.model.order.OrderListCriteriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.recordStatus = true and " +
            "(:#{#c.orderNo} is null or o.orderNo = :#{#c.orderNo}) and " +
            "(:#{#c.customerNo} is null or o.customer.customerNo = :#{#c.customerNo}) and " +
            "(:#{#c.orderDate} is null or o.orderDate = :#{#c.orderDate}) and " +
            "(:#{#c.status} is null or o.status = :#{#c.status})")
    List<Order> searchByCriteria(@Param("c") OrderListCriteriaModel criteriaModel);

    List<Order> findByRecordStatusAndStatusAndCustomer_CustomerNo(Boolean recordStatus, String status, Long customerNo);
}
