package com.app.customermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.customermanagement.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	
	Customer findByPhoneNumber(String phoneNumber);
	List<Customer> findByLastNameContaining(String name);
	List<Customer> findByLastNameContainingOrFirstNameContaining(String lastname, String firstName);
	List<Customer> findByLastNameContainingOrFirstNameContainingOrMidNameContaining(String lastName,String firstName,String midName);
	Customer findByLastNameContainingAndFirstNameContainingAndMidNameContainingAndPhoneNumberContaining(String lastName,String firstName,String midName,String phoneNumber);

	@Transactional
	@Modifying
	@Query("UPDATE Customer c SET c.firstName = :firstName, c.midName = :midName, c.lastName = :lastName WHERE c.id = :id")
	int updateName(@Param("firstName") String firstName, @Param("midName") String midName, @Param("lastName") String lastName, @Param("id") Integer id);

}