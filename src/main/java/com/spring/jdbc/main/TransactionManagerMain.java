package com.spring.jdbc.main;

import com.spring.jdbc.model.Address;
import com.spring.jdbc.model.Customer;
import com.spring.jdbc.service.CustomerManager;
import com.spring.jdbc.service.CustomerManagerImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionManagerMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "spring.xml");

        CustomerManager customerManager = ctx.getBean("customerManager",
                CustomerManagerImpl.class);

        Customer cust = createDummyCustomer();
        customerManager.createCustomer(cust);

        ctx.close();
    }

    private static Customer createDummyCustomer() {
        Customer customer = new Customer();
        customer.setId(25);
        customer.setName("Pankaj");
        Address address = new Address();
        address.setId(25);
        address.setCountry("New");
        // setting value more than 20 chars, so that SQLException occurs
        address.setAddress("Alba");
        customer.setAddress(address);
        return customer;
    }

}