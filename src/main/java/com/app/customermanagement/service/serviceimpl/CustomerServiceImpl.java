package com.app.customermanagement.service.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.app.customermanagement.constants.CommonConstant;
import com.app.customermanagement.dto.model.CustomerDto;
import com.app.customermanagement.mapper.CustomerMapper;
import com.app.customermanagement.model.Customer;
import com.app.customermanagement.repository.CustomerRepository;
import com.app.customermanagement.service.CustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper;

	
    @Override
    public Customer addCustomer(CustomerDto customer) {
    	customer.setStatus(0);
    	Customer customerModel = customerMapper.maptoModel(customer);
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
		  return customerRepository.findById(customer.getId()).orElse(null);
	}

	@Override
	public Customer searchCustomer(Customer customer) {
		return customerRepository.findByPhoneNumber(customer.getPhoneNumber());
	}

	@Override
	public List<Customer> searchCustomerLastName(String name) {
		return customerRepository.findByLastNameContaining(name);
	}

	@Override
	public List<Customer> searchCustomerFirstNameOrLastName(String name) {
		return customerRepository.findByLastNameContainingOrFirstNameContaining(name, name);
	}

	@Override
	public List<Customer> searchCustomerFirstNameOrMidNameOrLastName(String name) {
		return customerRepository.findByLastNameContainingOrFirstNameContainingOrMidNameContaining(name, name, name);
	}

	@Override
	public Customer searchCustomerFirstNameAndMidNameAndLastNameAndPhoneNumber(String firstName, String midName, String lastName, String phoneNumber) {
		return customerRepository.findByLastNameContainingAndFirstNameContainingAndMidNameContainingAndPhoneNumberContaining(lastName, firstName, midName, phoneNumber);
	}

	@Cacheable(value = "customer")
	@Override
	public List<Customer> list(Integer page) {
		return customerRepository.findAll();
	}
	
	@CacheEvict(value = "customer", allEntries = true)
	public void refreshCache() {
		
	}

	@Override
	public Customer updateCustomer(CustomerDto customerDto) {
		customerDto.setUpdatedBy(CommonConstant.ADMIN);
		customerDto.setUpdatedAt(new Date());
		return customerRepository.save(customerMapper.maptoModel(customerDto));
	}

	@Override
	public Integer updateName(CustomerDto customerDto) {
		return customerRepository.updateName(customerDto.getFirstName(), customerDto.getMidName(), customerDto.getLastName(), customerDto.getId());
	}
}
