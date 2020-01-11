/**
 * 
 */
package com.rakuten.prj.client;

import com.rakuten.prj.entity.Mobile;
import com.rakuten.prj.entity.Product;
import com.rakuten.prj.entity.Tv;

/**
 * @author nishanth
 *
 */
public class ProductClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Product[] products = new Product[5]; // Array of 5 Pointers
		products[0] = new Tv(133, "Sony Bravia", 135000.00, "LED"); // up casting
		products[1] = new Mobile(453, "MotoG", 12999.00, "4G");
		products[2] = new Tv(634, "Onida Thunder", 3500.00, "CRT");
		products[3] = new Mobile(621, "iPhone XR", 99999.00, "4G");
		products[4] = new Mobile(844, "Oppo", 9999.00, "4G");

		displayExpensive(products);

		displayDetails(products);
	}

	private static void displayDetails(Product[] products) {
		for (Product product : products) {
			System.out.println(product.getName() + ", " + product.getPrice());
			if (product instanceof Tv) {
				Tv t = (Tv) product;
				System.out.println(t.getScreenType());
			} else if (product instanceof Mobile) {
				Mobile m = (Mobile) product;
				System.out.println(m.getPrice());
			}
		}
	}

	private static void displayExpensive(Product[] products) {
		for (Product product : products) {
			if (product.isExpensive()) { // Polymorphism and dynamic binding
				System.out.println(product.getName() + " is expensive");
			} else {
				System.out.println(product.getName() + " is not expensive");
			}
		}
	}

}
