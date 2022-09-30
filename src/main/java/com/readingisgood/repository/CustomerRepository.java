package com.readingisgood.repository;

import com.readingisgood.entity.Customer;
import com.readingisgood.model.customer.CustomerListCriteriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE c.recordStatus = true and " +
            "(:#{#p.customerNo} is null or c.customerNo = :#{#p.customerNo}) and " +
            "(:#{#p.status} is null or c.status = :#{#p.status})")
    List<Customer> searchByCriteria(@Param("p")CustomerListCriteriaModel criteriaModel);

    Customer findCustomerByEmailAndPhoneNumberAndStatusAndRecordStatus(String email,String phoneNumber, String status, Boolean recordStatus);

    Customer findByCustomerNoAndRecordStatusAndStatus(Long customerNo, Boolean recordStatus, String status);

}