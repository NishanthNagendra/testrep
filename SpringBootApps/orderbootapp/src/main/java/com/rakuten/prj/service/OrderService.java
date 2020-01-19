/**
 * 
 */
package com.rakuten.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.prj.dao.CustomerDao;
import com.rakuten.prj.dao.OrderDao;
import com.rakuten.prj.dao.ProductDao;
import com.rakuten.prj.entity.Customer;
import com.rakuten.prj.entity.LineItem;
import com.rakuten.prj.entity.Order;
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
	
	@Autowired
	private OrderDao orderDao;

	private double total = 0.0;

	public List<Product> getProducts() {
		return productDao.findAll();
	}

	public Product getProduct(int id) {
		return productDao.findById(id).get();
	}

	public void addProduct(Product p) {
		productDao.save(p); // persist becomes save
	}
	
	public List<Product> getByCategory(String category) {
		return productDao.findByCategory(category);
	}
	
	public List<Product> getByRange(double lower, double upper) {
		return productDao.getByPriceRange(lower, upper);
	}
	
	public void addCustomer(Customer c) {
		customerDao.save(c);
	}
	
	public Customer getCustomer(String email) {
		return customerDao.findById(email).get();
	}
	
	public List<Customer> getCustomers() {
		return customerDao.findAll();
	}
	
	public List<Order> viewOrders() {
		return orderDao.findAll();
	}
	
	public void placeOrder(String email, int[] productIds, int[] qts) {
		Order order = new Order();	// sets order date
		Customer c = customerDao.findById(email).get();
		order.setCustomer(c); // which customer is placing the order
		
		for (int i = 0; i < productIds.length; i++) {
			LineItem item = new LineItem();
			Product p = productDao.findById(productIds[i]).get();
			item.setProduct(p);
			item.setQuantity(qts[i]);
			item.setAmount(p.getPrice() * qts[i]);
			order.getItems().add(item);
			p.setQty(p.getQty() - qts[i]);	// dirty checking, within a transaction any change is automatically synchronised with the back-end
			total += item.getAmount();
		}
		order.setTotal(total);
		orderDao.save(order);
	}
	
	public void placeOrder(Order order) { 
		orderDao.save(order);
	}
}
