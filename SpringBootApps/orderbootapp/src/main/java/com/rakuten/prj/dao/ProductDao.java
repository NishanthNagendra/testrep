/**
 * 
 */
package com.rakuten.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rakuten.prj.entity.Product;

/**
 * @author nishanth
 *
 */
public interface ProductDao extends JpaRepository<Product, Integer> {
	List<Product> findByCategory(String category);
	
	@Query("from Product p where p.price between :l and :u")
	List<Product> getByPriceRange(@Param("l") double lower, @Param("u") double upper);
}
