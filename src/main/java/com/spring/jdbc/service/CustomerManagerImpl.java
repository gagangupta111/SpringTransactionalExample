package com.spring.jdbc.service;

import com.spring.jdbc.dao.CustomerDAO;
import com.spring.jdbc.model.Customer;
import org.springframework.transaction.annotation.Transactional;

public class CustomerManagerImpl implements CustomerManager {

    private CustomerDAO customerDAO;

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional(noRollbackFor = RuntimeException.class)
    public void createCustomer(Customer cust) {
        customerDAO.create(cust);
        try {
            customerDAO.throwExceptionTest();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
