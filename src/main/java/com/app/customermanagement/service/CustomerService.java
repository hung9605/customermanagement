package com.app.customermanagement.service;

import com.app.customermanagement.model.Customer;

public interface CustomerService {

    Customer addCustomer(Customer customer);
    Customer updateCustomer(Customer customer);

}
