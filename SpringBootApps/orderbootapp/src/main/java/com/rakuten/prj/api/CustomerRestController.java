/**
 * 
 */
package com.rakuten.prj.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.prj.entity.Customer;
import com.rakuten.prj.service.OrderService;

/**
 * @author nishanth
 *
 */
@RestController
@RequestMapping("customers")
public class CustomerRestController {
	@Autowired
	OrderService service;
	
	@GetMapping()
	public @ResponseBody List<Customer> getCustomers() {
		return service.getCustomers();
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Customer getCustomerById(@PathVariable("id") String id) {
		return service.getCustomer(id);
	}
	
	@PostMapping()
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer c)  {
		service.addCustomer(c);
		return new ResponseEntity<Customer>(c, HttpStatus.CREATED);
	}
	
}
