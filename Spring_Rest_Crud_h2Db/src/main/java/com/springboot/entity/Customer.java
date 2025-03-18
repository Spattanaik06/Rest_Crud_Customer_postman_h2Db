package com.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Customer_h2Db")
public class Customer 
{
	@Id
	private Integer customerId;
	private String customerName;
	private String customerAddress;
	private Long customerPhoneNo;
	
	
}
