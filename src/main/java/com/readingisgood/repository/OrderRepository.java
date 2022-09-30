package com.readingisgood.repository;

import com.readingisgood.entity.Order;
import com.readingisgood.model.order.CustomerOrderReportCriteriaModel;
import com.readingisgood.model.order.CustomerOrdersModel;
import com.readingisgood.model.order.OrderListCriteriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.recordStatus = true and " +
            "(:#{#c.id} is null or o.id = :#{#c.id}) and " +
            "(:#{#c.orderNo} is null or o.orderNo = :#{#c.orderNo}) and " +
            "(:#{#c.customerNo} is null or o.customer.customerNo = :#{#c.customerNo}) and " +
            "(:#{#c.status} is null or o.status = :#{#c.status})")
    List<Order> searchByCriteria(@Param("c") OrderListCriteriaModel criteriaModel);

    List<Order> findByRecordStatusAndStatusAndCustomer_CustomerNo(Boolean recordStatus, String status, Long customerNo);

   Order findByRecordStatusAndStatusAndOrderNo(Boolean recordStatus, String status, Long orderNo);

   String query = "SELECT new com.readingisgood.model.order.CustomerOrdersModel(c.customer_no, COUNT(O), COUNT(B), SUM(B.book_amount),b.book_name) FROM ORDER O "+
           "INNER JOIN CUSTOMER C ON O.CUSTOMER_ID=C.ID AND C.RECORD_STATUS= 1 "+
           "INNER JOIN BOOK B ON O.ORDER_ID = O.ID AND B.RECORD_STATUS=1 " +
           "WHERE O.KAYIT_DURUM=1 AND "+
           "(:#{#p.customerNo} is null or c.customer_no = :#{#p.customerNo})";

    @Query(value = query, nativeQuery = true)
    CustomerOrdersModel getTotalCustomerOrders(@Param("p") CustomerOrderReportCriteriaModel criteriaModel);
}
