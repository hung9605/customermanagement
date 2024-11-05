package com.app.customermanagement.service.serviceimpl;

import java.util.List;

import com.app.customermanagement.dto.model.CustomerDto;
import com.app.customermanagement.model.Customer;
import com.app.customermanagement.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public Customer addCustomer(CustomerDto customer) {
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }

	@Override
	public Customer getCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> searchCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> searchCustomerLastName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> searchCustomerFirstNameOrLastName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> searchCustomerFirstNameOrMidNameOrLastName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> searchCustomerFirstNameAndMidNameAndLastNameAndPhoneNumber(String firstName, String midName, String lasrName, String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}
}
