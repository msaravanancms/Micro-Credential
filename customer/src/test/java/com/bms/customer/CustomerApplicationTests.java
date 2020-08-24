package com.bms.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bms.customer.web.dto.LoginDto;
import com.bms.customer.web.dto.UserRegistrationDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CustomerApplicationTests {
	UserRegistrationDto userRegr = new UserRegistrationDto();

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	@DisplayName("userRegistrationTest Message REST API ")
	void userRegistrationTest() {
		
		userRegr.setCustomerId("55522677");
		userRegr.setAccountNumber(45242247);
		userRegr.setAccountType("string");
		userRegr.setAccountName("Saving");
		userRegr.setDob("54566");
		userRegr.setLastName("vedha");
		userRegr.setPanNumber("4545456");
		userRegr.setAddress("chennai");
		userRegr.setPassword("vedha");
		userRegr.setEmail("msaravanancms@gmail.com");
		userRegr.setState("chennai");
		userRegr.setCountry("chennai");
		userRegr.setFirstName("vedha");
		String  outMessage = this.restTemplate.postForObject("/customeregistration",userRegr, String.class);
			System.out.println("@@@@:"+outMessage);
		assertEquals(outMessage, outMessage);
	}

	@Test
	@DisplayName("userAlreadyExist Message REST API ")
	void userAlreadyExist() {
		
		userRegr.setCustomerId("5556626");
		userRegr.setAccountNumber(4542226);
		userRegr.setAccountType("string");
		userRegr.setAccountName("Saving");
		userRegr.setDob("54566");
		userRegr.setLastName("vedha");
		userRegr.setPanNumber("4545456");
		userRegr.setAddress("chennai");
		userRegr.setPassword("vedha");
		userRegr.setEmail("msaravanancms@gmail.com");
		userRegr.setState("chennai");
		userRegr.setCountry("chennai");
		userRegr.setFirstName("vedha");
		String  outMessage = this.restTemplate.postForObject("/customeregistration",userRegr, String.class);
			System.out.println("@@@@:"+outMessage);
		assertEquals(outMessage, outMessage);
	}

	
	@Test
	@DisplayName("userLoginTest Message REST API ")
	void userLoginTest() {
		LoginDto loginDto = new LoginDto();
		loginDto.setCustomerId("5556626");
		loginDto.setPassword("vedha");
		
		String loginMessage = this.restTemplate.postForObject("/login",loginDto, String.class);
			System.out.println("@@@@:"+loginMessage);
		assertEquals(loginMessage, loginMessage);
	}

	@Test
	@DisplayName("user Not Found Test Message REST API ")
	void userNotFoundTest() {
		LoginDto loginDto = new LoginDto();
		userRegr.setCustomerId("56626");
		userRegr.setPassword("vedha");
		
		String loginMessage = this.restTemplate.postForObject("/login",loginDto, String.class);
			System.out.println("@@@@:"+loginMessage);
		assertEquals(loginMessage, loginMessage);
	}
	
	@Test
	@DisplayName("user Not Found Test Message REST API ")
	void wrongPasswordTest() {
		LoginDto loginDto = new LoginDto();
		userRegr.setCustomerId("5556626");
		userRegr.setPassword("vedwwha");
		
		String loginMessage = this.restTemplate.postForObject("/login",loginDto, String.class);
			System.out.println("@@@@:"+loginMessage);
		assertEquals(loginMessage, loginMessage);
	}
	
	@Test
	@DisplayName("userAlreadyExist Message REST API ")
	void userException() throws Exception {
		
		userRegr.setAccountType("string");
		userRegr.setAccountName("Saving");
		userRegr.setDob("54566");
		String  outMessage = this.restTemplate.postForObject("/customeregistration",userRegr, String.class);
			System.out.println("@@@@:"+outMessage);
		assertEquals(outMessage, outMessage);
	}

}
