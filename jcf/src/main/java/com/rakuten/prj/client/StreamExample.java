package com.rakuten.prj.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.rakuten.prj.entity.Product;

/**
 * 
 * @author nishanth
 *
 */
public class StreamExample {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		products.add(new Product(645, "Hp Laptop", 135000.00, "computer"));
		products.add(new Product(224, "iPhone", 98000.00, "mobile"));
		products.add(new Product(834, "Logitech Mouse", 600.00, "computer"));
		products.add(new Product(5, "Sony Bravia", 125000.00, "tv"));
		products.add(new Product(912, "One Plus", 32000.00, "mobile"));
		products.add(new Product(88, "HP Printer", 19000.00, "computer"));

		List<Product> mobiles = products.stream().filter(p -> p.getCategory().equalsIgnoreCase("mobile"))
				.collect(Collectors.toList());

		mobiles.forEach(p -> System.out.println(p));

		System.out.println("_______________________________________________________________________________________\n");

		mobiles.forEach(System.out::println); // Shortcut

		System.out.println("_______________________________________________________________________________________\n");

		products.stream().map(p -> p.getName()).forEach(System.out::println);

		double sum = products.stream().map(p -> p.getPrice()).reduce(0.0, (v1, v2) -> v1 + v2);

		System.out.println("_______________________________________________________________________________________\n");

		System.out.println(sum);

		System.out.println("_______________________________________________________________________________________\n");

		Map<String, List<Product>> productCat = products.stream().collect(Collectors.groupingBy(p -> p.getCategory()));

		List<Product> computers = productCat.get("computer");

		for (Product product : computers) {
			System.out.println(product);
		}
	}

}
