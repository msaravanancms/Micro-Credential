package com.bms.customer.service;

import com.bms.customer.exception.ResourceNotFoundException;
import com.bms.customer.model.Customer;
import com.bms.customer.model.User;
import com.bms.customer.web.dto.UserRegistrationDto;

public interface UserService {
	User saveUserDetails(UserRegistrationDto registrationDto);

	User login(String userId) throws ResourceNotFoundException;

	Customer findByCustomerId(String customerId) throws ResourceNotFoundException;
}