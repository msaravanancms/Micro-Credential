package com.bms.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	public List<Customer>  findByCustomerId(String customerId);
}
