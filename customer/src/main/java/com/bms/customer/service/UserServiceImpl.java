package com.bms.customer.service;

import java.util.Arrays;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.bms.customer.model.Account;
import com.bms.customer.model.Customer;
import com.bms.customer.model.Role;
import com.bms.customer.model.User;
import com.bms.customer.repository.CustomerRepository;
import com.bms.customer.repository.UserRepository;
import com.bms.customer.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	private UserRepository userRepository;
	@Autowired
	private CustomerRepository customRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUserDetails(UserRegistrationDto registrationDto) {
		logger.info("$$$$$$$ User Service Method Start");
		User user = new User(registrationDto.getFirstName(), registrationDto.getCustomerId(),
				hashPassword(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));
		Customer customer = new Customer();
		customer.setCustomerName(registrationDto.getFirstName());
		customer.setAddress(registrationDto.getAddress());
		customer.setPassword(hashPassword(registrationDto.getPassword()));
		customer.setCustomerId(registrationDto.getCustomerId());
		customer.setEmail(registrationDto.getEmail());

		Account acc = new Account();
		acc.setAccountName(registrationDto.getAccountName());
		acc.setAccountNumber(registrationDto.getAccountNumber());
		acc.setAccountType(registrationDto.getAccountType());
		acc.setDob(registrationDto.getDob());
		acc.setPanNumber(registrationDto.getPanNumber());
		acc.setCustomerId(registrationDto.getCustomerId());
		customer.setAccount(acc);
		// accountRepository.save(acc);
		customRepository.save(customer);
		logger.info("$$$$$$$ User Service Method END");
		return userRepository.save(user);
	}

	private String hashPassword(String plainTextPassword) {
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}

	@Override
	public User login(String userId) {
		
		User dbUser = null;

		Optional user = Optional.ofNullable(userId);
		
		if (!user.isPresent()) {
			logger.debug("Given userId is empty");
			
		} else {
			
			dbUser = userRepository.findByCustomerId(userId);
		}
		return dbUser;
	}

	@Override
	public Customer findByCustomerId(String customerId) {
		
		Customer custId = customRepository.findByCustomerId(customerId);
		return custId;
	}
}
