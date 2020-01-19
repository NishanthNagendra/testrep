package com.rakuten.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rakuten.prj.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, String> {
	
}
