package com.bms.customer.web;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bms.customer.exception.ResourceNotFoundException;
import com.bms.customer.model.Customer;
import com.bms.customer.service.UserService;
import com.bms.customer.web.dto.UserRegistrationDto;

import io.swagger.annotations.Api;


@Controller
@Api(tags = { "UserRegistrationController and REST endpoints" })
public class UserRegistrationController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserRegistrationController.class);
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/customeregistration")
	public ResponseEntity<String>  registerUserAccount(@Valid @RequestBody UserRegistrationDto registrationDto)throws ResourceNotFoundException {
		
		logger.info("$$$$$$$$ CustomerId :");
		try{
			
			Customer custId = userService.findByCustomerId(registrationDto.getCustomerId());
			
			if (custId!=null) {
				logger.error("User not found");
	            return ResponseEntity.status(HttpStatus.CONFLICT).body("$$$$$$$$ User already exist");
			}else{
				userService.saveUserDetails(registrationDto);
				}
			
		}catch(Exception e){
			
			throw new ResourceNotFoundException("$$$$$$$$ Error in UserRegistration :"+HttpStatus.NOT_ACCEPTABLE+" "+e);
		}
		 return ResponseEntity.status(HttpStatus.CREATED).body("$$$$$$$$ User" + registrationDto.getCustomerId()+"Successfully Regisered");
	}
}
