package com.app.customermanagement.service.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.customermanagement.constants.CommonConstant;
import com.app.customermanagement.dto.model.CustomerDto;
import com.app.customermanagement.mapper.CustomerMapper;
import com.app.customermanagement.mapper.CustomerMapperImpl;
import com.app.customermanagement.model.Customer;
import com.app.customermanagement.repository.CustomerRepository;
import com.app.customermanagement.service.CustomerService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
	private final CustomerRepository customerRepository;
	
    @Override
    public Customer addCustomer(CustomerDto customer) {
    	CustomerMapper mapper = new CustomerMapperImpl();
    	customer.setStatus(0);
    	Customer customerModel = mapper.maptoModel(customer);
    	customerModel.setCreatedBy(CommonConstant.ADMIN);
    	customerModel.setCreatedAt(new Date());
        return customerRepository.save(customerModel);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

	@Override
	public Customer getCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.findById(customer.getId()).get();
	}

	@Override
	public List<Customer> searchCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.findByPhoneNumber(customer.getPhoneNumber());
	}

	@Override
	public List<Customer> searchCustomerLastName(String name) {
		// TODO Auto-generated method stub
		return customerRepository.findByLastNameContaining(name);
	}

	@Override
	public List<Customer> searchCustomerFirstNameOrLastName(String name) {
		// TODO Auto-generated method stub
		return customerRepository.findByLastNameContainingOrFirstNameContaining(name, name);
	}

	@Override
	public List<Customer> searchCustomerFirstNameOrMidNameOrLastName(String name) {
		// TODO Auto-generated method stub
		return customerRepository.findByLastNameContainingOrFirstNameContainingOrMidNameContaining(name, name, name);
	}

	@Override
	public Customer searchCustomerFirstNameAndMidNameAndLastNameAndPhoneNumber(String firstName, String midName, String lastName, String phoneNumber) {
		// TODO Auto-generated method stub
		return customerRepository.findByLastNameContainingAndFirstNameContainingAndMidNameContainingAndPhoneNumberContaining(lastName, firstName, midName, phoneNumber);
	}

	@Override
	public List<Customer> list(Integer page) {
		// TODO Auto-generated method stub
		Pageable pageable =  PageRequest.of(page, 2);
		return customerRepository.findAll(pageable).getContent();
	}
}
