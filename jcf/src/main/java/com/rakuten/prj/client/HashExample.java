package com.rakuten.prj.client;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.rakuten.prj.entity.Product;

/**
 * 
 * @author nishanth
 *
 */
public class HashExample {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Product> products = new HashSet<>();
		products.add(new Product(645, "Hp Laptop", 135000.00, "computer"));
		products.add(new Product(224, "iPhone", 98000.00, "mobile"));
		products.add(new Product(834, "Logitech Mouse", 600.00, "computer"));
		products.add(new Product(5, "Sony Bravia", 125000.00, "tv"));
		products.add(new Product(912, "One Plus", 32000.00, "mobile"));
		products.add(new Product(88, "HP Printer", 19000.00, "computer"));

		for (Product product : products) {
			System.out.println(product);
		}

		System.out.println("____________________________________________________________________________\n");

		Set<Product> productsa = new TreeSet<>();
		productsa.add(new Product(645, "Hp Laptop", 135000.00, "computer"));
		productsa.add(new Product(224, "iPhone", 98000.00, "mobile"));
		productsa.add(new Product(834, "Logitech Mouse", 600.00, "computer"));
		productsa.add(new Product(5, "Sony Bravia", 125000.00, "tv"));
		productsa.add(new Product(912, "One Plus", 32000.00, "mobile"));
		productsa.add(new Product(88, "HP Printer", 19000.00, "computer"));

		for (Product product : productsa) {
			System.out.println(product);
		}

		System.out.println("____________________________________________________________________________\n");

		Set<Product> productsb = new TreeSet<>((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
		productsb.add(new Product(645, "Hp Laptop", 135000.00, "computer"));
		productsb.add(new Product(224, "iPhone", 98000.00, "mobile"));
		productsb.add(new Product(834, "Logitech Mouse", 600.00, "computer"));
		productsb.add(new Product(5, "Sony Bravia", 125000.00, "tv"));
		productsb.add(new Product(912, "One Plus", 32000.00, "mobile"));
		productsb.add(new Product(88, "HP Printer", 19000.00, "computer"));

		for (Product product : productsb) {
			System.out.println(product);
		}

		System.out.println("____________________________________________________________________________\n");

	}

}
