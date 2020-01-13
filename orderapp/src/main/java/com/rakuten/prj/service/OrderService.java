/**
 * 
 */
package com.rakuten.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.prj.dao.CustomerDao;
import com.rakuten.prj.dao.ProductDao;
import com.rakuten.prj.entity.Customer;
import com.rakuten.prj.entity.Product;

/**
 * @author nishanth
 *
 */
@Service
@Transactional
public class OrderService {
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	public void insertProduct(Product p) {
		productDao.addProduct(p);
	}
	
	public Product getProduct(int id) {
		return productDao.getProduct(id);
	}
	
	public List<Product> getAllProducts() {
		return productDao.getProducts();
	}
	
	public void insertCustomer(Customer c) {
		customerDao.addCustomer(c);
	}
	
	public Customer getCustomer(String email) {
		return customerDao.getCustomer(email);
	}
	
	public List<Customer> getAllCustomers() {
		return customerDao.getCustomers();		
	}
}
