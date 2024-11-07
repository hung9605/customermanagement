package com.app.customermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.customermanagement.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	
	List<Customer> findByPhoneNumber(String phoneNumber);
	List<Customer> findByLastNameContaining(String name);
	List<Customer> findByLastNameContainingOrFirstNameContainning(String lastname, String firstName);
	List<Customer> findByLastNameContainingOrFirstNameContainingOrMidNameContaining(String lastName,String firstName,String midName);
	List<Customer> findByLastNameContainingAndFirstNameContainingAndMidNameContainingAndPhoneNumberContaining(String lastName,String firstName,String midName,String phoneNumber);
}
