package com.springboot.controller;

import java.util.List;

import org.hibernate.query.sqm.mutation.internal.temptable.UpdateExecutionDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Customer;
import com.springboot.service.CustomerService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/")
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/insert")
	public Customer insertCustomer(@RequestBody Customer cust)
	{
		return customerService.insert(cust);
	}
	
	
	@GetMapping("/allEmployee")
	public List<Customer> getAllCustomer()
	{
		return customerService.fetchAllCustomers();
	}
	
	@PutMapping("update/{id}")
	public String updateCustomerbyId(@PathVariable Integer id,@RequestBody Customer customer) {
		
		customerService.updateCustomer(id, customer);
		return "updated";
		
	}
	@DeleteMapping("/delete/{id}")
	public String  deleteCustomerById(@PathVariable Integer id)
	{
		String deleteCustomer = customerService.deleteCustomer(id);
		return deleteCustomer;
	}
	
	
}
