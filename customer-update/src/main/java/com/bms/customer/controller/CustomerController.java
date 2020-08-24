package com.bms.customer.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bms.customer.exception.CustomerException;
import com.bms.customer.exception.ResourceNotFoundException;
import com.bms.customer.model.Customer;
import com.bms.customer.model.CustomerDTO;
import com.bms.customer.service.CustomerServices;

import io.swagger.annotations.Api;

@RestController
@Api(tags = { "Banking Managemens and REST endpoints" })
public class CustomerController {
	@Autowired
	private CustomerServices customerServices;
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@PostMapping("/updatecustomer")
	public ResponseEntity<String> updateCustomer(@Valid @RequestBody CustomerDTO customerObj) throws ResourceNotFoundException, CustomerException {

		try {

				Customer customer = customerServices.updateCustomer(customerObj);
				
				Optional user = Optional.ofNullable(customer);
				
				if (!user.isPresent()) {
		        	logger.error("$$$$$$ Customer ID not found");
		            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("$$$$$$ Customer ID not found");
		        }

		} catch (Exception e) {
			logger.error(" $$$$$$ Exception in Customer update " );
			throw new ResourceNotFoundException("Exception in Customer update :: " + e);
		}
		logger.info(" $$$$$$ Customer udated Successflly :: " );
		return ResponseEntity.status(HttpStatus.CREATED).body("$$$$$$$$ Customer updated Successflly");
		
	}
	}
	
