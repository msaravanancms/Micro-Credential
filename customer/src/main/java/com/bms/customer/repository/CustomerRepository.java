package com.bms.customer.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.customer.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long>{
	public Customer findByCustomerId(String customerId);
}
