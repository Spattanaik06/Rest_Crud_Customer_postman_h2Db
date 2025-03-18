package com.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>
{

}
