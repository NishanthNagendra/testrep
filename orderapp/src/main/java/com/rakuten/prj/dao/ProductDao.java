/**
 * 
 */
package com.rakuten.prj.dao;

import java.util.List;

import com.rakuten.prj.entity.Product;

/**
 * @author nishanth
 *
 */
public interface ProductDao {
	void addProduct(Product p);
	Product getProduct(int id);
	List<Product> getProducts();
}
