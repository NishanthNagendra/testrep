/**
 * 
 */
package com.rakuten.prj.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author nishanth
 *
 */
@Entity()
@Table(name = "phones")
public class Phone {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String img;
    private double price;
    private String company;
    private String info;
    private boolean inCart;
    private int count;
    @Transient
    private double total;
	
    /**
	 * 
	 */
	public Phone() {
	}
	/**
	 * @param id
	 * @param title
	 * @param img
	 * @param price
	 * @param company
	 * @param info
	 * @param inCart
	 * @param count
	 * @param total
	 */
	public Phone(int id, String title, String img, double price, String company, String info, boolean inCart, int count,
			double total) {
		this.id = id;
		this.title = title;
		this.img = img;
		this.price = price;
		this.company = company;
		this.info = info;
		this.inCart = inCart;
		this.count = count;
		this.total = total;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}
	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	/**
	 * @return the inCart
	 */
	public boolean isInCart() {
		return inCart;
	}
	/**
	 * @param inCart the inCart to set
	 */
	public void setInCart(boolean inCart) {
		this.inCart = inCart;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}
    
    
}
