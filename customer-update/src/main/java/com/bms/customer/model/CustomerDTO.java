package com.bms.customer.model;

public class CustomerDTO {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String customerId;
	private String address;
	private String state;
	private String country;
	private String customerName;
	private String accountName;
	private int accountNumber;
	private String panNumber;
	private String accountType;
	private String dob;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getAddress() {
		return address;
	}
	public String getState() {
		return state;
	}
	public String getCountry() {
		return country;
	}
	public String getAccountName() {
		return accountName;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public String getDob() {
		return dob;
	}
	public String getCustomerName() {
		return customerName;
	}
	
}
