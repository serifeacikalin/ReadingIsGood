package com.readingisgood.service.validation.impl;

import com.readingisgood.constant.ReadingIsGoodStatus;
import com.readingisgood.constant.ValidationErrorCode;
import com.readingisgood.entity.Customer;
import com.readingisgood.repository.CustomerRepository;
import com.readingisgood.service.exception.BusinessException;
import com.readingisgood.service.validation.CustomerValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerValidatorImpl implements CustomerValidator {

    private CustomerRepository customerRepository;

    @Override
    public void validate(Customer customer) throws BusinessException {
        Customer relatedCustomer = customerRepository.findCustomerByEmailAndPhoneNumberAndStatusAndRecordStatus(customer.getEmail(),customer.getPhoneNumber(), ReadingIsGoodStatus.AKTIF.getValue(), Boolean.TRUE);

        if(customer.getId() != null){
            //guncelleme islemidir
            validateForUpdate(customer);
        }

        if(relatedCustomer != null && customer.getCustomerNo() == null ){
            throw new BusinessException(ValidationErrorCode.CUSTOMER_IS_EXIST);
        }
    }

    private void validateForUpdate(Customer customer) throws BusinessException {
        Customer relatedCustomer = customerRepository.findByCustomerNoAndRecordStatusAndStatus(customer.getCustomerNo(), Boolean.TRUE, ReadingIsGoodStatus.AKTIF.getValue());
        if(relatedCustomer == null){
            throw new BusinessException(ValidationErrorCode.CUSTOMER_IS_EXIST);
        }
    }
}
