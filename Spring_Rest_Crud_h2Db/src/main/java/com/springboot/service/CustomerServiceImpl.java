package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Customer;
import com.springboot.repo.CustomerRepo;

import jakarta.persistence.EntityNotFoundException;
@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerRepo customerRepo;
	
	public Customer insert(Customer customer)
	{
	   return	customerRepo.save(customer);
	}

	@Override
	public List<Customer> fetchAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

	@Override
	public Customer updateCustomer(Integer id,Customer cust) {
		if(customerRepo.existsById(id))
		{
		Customer updateCustomer=customerRepo.findById(id).orElse(null);
		if(updateCustomer!=null)
		{
			updateCustomer.setCustomerName(cust.getCustomerName());
			updateCustomer.setCustomerAddress(cust.getCustomerAddress());
			updateCustomer.setCustomerPhoneNo(cust.getCustomerPhoneNo());
		}
		return customerRepo.save(updateCustomer);
		}
		
		throw new EntityNotFoundException("The Customer Id :"+id+" Not Found");
	
		
	}

	@Override
	public String deleteCustomer(Integer id) {
		if(customerRepo.existsById(id))
		{
			customerRepo.deleteById(id);
			return"Customer details deleted from the server";
		}
		throw new EntityNotFoundException("Customer Not Found");
	}
	
	
	
}
