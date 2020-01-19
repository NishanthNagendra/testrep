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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.prj.entity.Product;
import com.rakuten.prj.service.OrderService;
/**
 * @author nishanth
 *
 */
@RestController
@RequestMapping("products")
public class ProductRestController {
	@Autowired
	private OrderService service;

	@GetMapping()
	public @ResponseBody List<Product> getProducts(@RequestParam(name = "category", required = false) String category) {
		if (category == null)
			return service.getProducts();
		else
			return service.getByCategory(category);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Product getProductById(@PathVariable("id") int id) {
		return service.getProduct(id);
	}
	
	@PostMapping()
	public ResponseEntity<Product> addProduct(@RequestBody Product p)  {
		service.addProduct(p);
		return new ResponseEntity<Product>(p, HttpStatus.CREATED);
	}
}
