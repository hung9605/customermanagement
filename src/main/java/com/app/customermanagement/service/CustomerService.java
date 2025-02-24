package com.app.customermanagement.service;

import java.util.List;

import com.app.customermanagement.dto.model.CustomerDto;
import com.app.customermanagement.model.Customer;

public interface CustomerService {

    Customer addCustomer(CustomerDto customer);
    Customer updateCustomer(Customer customer);
    Customer getCustomer(Customer customer);
    Customer searchCustomer(Customer customer);
    List<Customer> searchCustomerLastName(String name);
    List<Customer> searchCustomerFirstNameOrLastName(String name);
    List<Customer> searchCustomerFirstNameOrMidNameOrLastName(String name);
    Customer searchCustomerFirstNameAndMidNameAndLastNameAndPhoneNumber(String firstName, String midName, String lastName, String phoneNumber);
    List<Customer> list(Integer page);
    Customer updateCustomer(CustomerDto customerDto); 
    Integer updateName(CustomerDto customerDto);
}
