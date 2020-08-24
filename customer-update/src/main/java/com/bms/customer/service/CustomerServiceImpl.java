package com.bms.customer.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.customer.controller.CustomerController;
import com.bms.customer.exception.CustomerException;
import com.bms.customer.model.Account;
import com.bms.customer.model.Customer;
import com.bms.customer.model.CustomerDTO;
import com.bms.customer.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerServices {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getCustomerList(String customerId) throws CustomerException {
		List<Customer> custId = customerRepository.findByCustomerId(customerId);
		return null;
	}

	@Override
	public Customer updateCustomer(@Valid CustomerDTO customerObj) throws CustomerException {

		Customer customer = new Customer();
		
		List<Customer>   cust = customerRepository.findByCustomerId(customerObj.getCustomerId());
		 if (cust.isEmpty()) {
			 logger.error("$$$$$$$ Customer ID not found :: ");
				 throw new CustomerException("Customer ID not found :: "  );
			}
		 else {
			customer.setId(cust.get(0).getId());
			customer.setCustomerId(customerObj.getCustomerId());
			customer.setCustomerName(customerObj.getCustomerName());
			customer.setAddress(customerObj.getAddress());
			customer.setPassword(customerObj.getPassword());
			customer.setCustomerId(customerObj.getCustomerId());
			customer.setEmail(customerObj.getEmail());
			customer.setFirstName(customerObj.getFirstName());
			
			customer.setLastName(customerObj.getLastName());
			customer.setState(customerObj.getState());
			Account acc = new Account();

			acc.setAccountName(customerObj.getAccountName());
			acc.setAccountNumber(customerObj.getAccountNumber());
			acc.setAccountType(customerObj.getAccountType());
			acc.setDob(customerObj.getDob());
			acc.setPanNumber(customerObj.getPanNumber());
			acc.setCustomerId(customerObj.getCustomerId());
			//customer.setAccount(acc);
			customerRepository.save(customer);

		}
		return customer;
	}

}
