package com.spring.jdbc.dao;

import com.spring.jdbc.model.Customer;

public interface CustomerDAO {

    public void create(Customer customer);

    public Exception throwExceptionTest() throws Exception;

}
