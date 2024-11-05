package com.app.customermanagement.service;

import java.util.List;

import com.app.customermanagement.dto.model.CustomerDto;
import com.app.customermanagement.model.Customer;

public interface CustomerService {

    Customer addCustomer(CustomerDto customer);
    Customer updateCustomer(Customer customer);
    Customer getCustomer(Customer customer);
    List<Customer> searchCustomer(Customer customer);
    List<Customer> searchCustomerLastName(String name);
    List<Customer> searchCustomerFirstNameOrLastName(String name);
    List<Customer> searchCustomerFirstNameOrMidNameOrLastName(String name);
    List<Customer> searchCustomerFirstNameAndMidNameAndLastNameAndPhoneNumber(String firstName, String midName, String lasrName, String phoneNumber);
}
