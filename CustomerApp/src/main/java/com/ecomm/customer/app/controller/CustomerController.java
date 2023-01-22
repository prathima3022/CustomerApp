package com.ecomm.customer.app.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.customer.app.entity.Customer;
import com.ecomm.customer.app.modal.CustomerInfo;
import com.ecomm.customer.app.repository.CustomerRepository;
import com.ecomm.customer.app.response.RestServiceResponse;
import com.ecomm.customer.app.service.EmailService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	EmailService emailService;
	@PostMapping("/signUpCustomer")
	public RestServiceResponse signUpCustomer(@RequestBody CustomerInfo customerInfo) {
		Customer newCustomer = new Customer();
		newCustomer.setCustomerName(customerInfo.getCustomerName());
		newCustomer.setCustomerEmail(customerInfo.getCustomerEmail());
		Date dateTime = new Date();
		newCustomer.setCreatedDate(dateTime);
		newCustomer.setUpdatedDate(dateTime);
		newCustomer.setPrimeUSer(false);
		customerRepository.save(newCustomer);
		emailService.sendEmail(customerInfo);
		
		RestServiceResponse restServiceResponse = new RestServiceResponse();
		restServiceResponse.setStatusCode(200);
		restServiceResponse.setStatusMessage("Customer " +customerInfo.getCustomerName()+" Created Succesfully.");
		return  restServiceResponse;	
	}
}
