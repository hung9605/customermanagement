package com.app.customermanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.customermanagement.dto.response.Account;
import com.app.customermanagement.dto.response.AccountChartDto;
import com.app.customermanagement.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	
	Optional<Customer> findByPhoneNumber(String phoneNumber);
	List<Customer> findByLastNameContaining(String name);
	List<Customer> findByLastNameContainingOrFirstNameContaining(String lastname, String firstName);
	List<Customer> findByLastNameContainingOrFirstNameContainingOrMidNameContaining(String lastName,String firstName,String midName);
	Customer findByLastNameContainingAndFirstNameContainingAndMidNameContainingAndPhoneNumberContaining(String lastName,String firstName,String midName,String phoneNumber);

	@Transactional
	@Modifying
	@Query("UPDATE Customer c SET c.firstName = :firstName, c.midName = :midName, c.lastName = :lastName WHERE c.id = :id")
	int updateName(@Param("firstName") String firstName, @Param("midName") String midName, @Param("lastName") String lastName, @Param("id") Integer id);
	
	@Query(value = "select \n"
			+ "	count(id) as `total` \n"
			+ "	,sum(case when status = 1 then 1 else 0 end) as 'numberNotActive' \n"
			+ "	,sum(case when status = 0 then 1 else 0 end) as 'numberActive' \n"
			+ "from account;",
      nativeQuery = true)
	Account getDataDashBoardAccount();
	
	@Query(value = "select \r\n"
			+ "	count(id) as `total` \r\n"
			+ "	,monthname(created_at) as `month` \r\n"
			+ "from account \r\n"
			+ "where \r\n"
			+ "	year(created_at) = year(curdate()) \r\n"
			+ "group by monthname(created_at),month(created_at)\r\n"
			+ "order by month(created_at);",
      nativeQuery = true)
	List<AccountChartDto> getDataChart();
	

}