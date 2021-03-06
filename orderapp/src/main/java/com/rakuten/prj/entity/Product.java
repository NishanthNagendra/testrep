package com.rakuten.prj.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author nishanth
 *
 */
@Entity()  // Import javax.persistence.Entity
@Table(name = "products")	// // Import javax.persistence.Table; if not given table name default Product i.e, same as entity class name
// if java fields and column names are different then @Column is used
public class Product implements Comparable<Product> {
	
	@Id	// Makes id as the primary key and import javax.persistence.Id must be used compulsory
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// Indicates id field is a primary key and key is auto-incremented
	// @GeneratedValue is optional if not given id is to be given by user
	/**
	 * id of the product.
	 */
	private int id;
	/**
	 * name of the product.
	 */
	private String name;
	/**
	 * price of the product.
	 */
	private double price;
	/**
	 * category of the product.
	 */
	private String category;
	/**
	 * 
	 */
	private int qty;

	

	/**
	 * @param id
	 * @param name
	 * @param price
	 * @param category
	 * @param qty
	 */
	public Product(int id, String name, double price, String category, int qty) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.qty = qty;
	}

	/**
	 * 
	 */
	public Product() {
	}

	/**
	 * @return the qty
	 */
	public int getQty() {
		return qty;
	}

	/**
	 * @param qty the qty to set
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}

	/**
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * 
	 * @return
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * 
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public int compareTo(Product o) {
		return this.id - o.id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
