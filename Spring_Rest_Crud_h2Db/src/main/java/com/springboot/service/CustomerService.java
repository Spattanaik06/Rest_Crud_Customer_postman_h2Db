package com.springboot.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.springboot.entity.Customer;
@Service
public interface CustomerService 
{
	public Customer insert(Customer customer);
	List<Customer> fetchAllCustomers();
	Customer updateCustomer(Integer id,Customer cust);
	String deleteCustomer(Integer id);
}
