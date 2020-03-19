package com.luv2code.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;



@RestController
@RequestMapping("customerapi")
public class CustomerController {
	

	@Autowired
	CustomerService custser;
		
	@PostMapping("addCustomer")
	public Customer saveSuctomer(@RequestBody Customer cust) {
		custser.saveCustomer(cust);
		return cust;
	}
}
