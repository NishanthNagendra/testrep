package com.rakuten;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rakuten.prj.entity.Customer;
import com.rakuten.prj.entity.Order;
import com.rakuten.prj.entity.Product;
import com.rakuten.prj.service.OrderService;

@SpringBootApplication
public class OrderbootappApplication implements CommandLineRunner {
	@Autowired
	private OrderService os;

	// Autowired can be used only if commandlinerunner is implemented

	public static void main(String[] args) {
		SpringApplication.run(OrderbootappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		List<Product> list = os.getByRange(20000, 1000000);
//		for (Product p : list) {
//			System.out.println(p);
//		}
//		System.out.println("\n\n\n");
//		List<Customer> list1 = os.getCustomers();
//		for (Customer customer : list1) {
//			System.out.println(customer);
//		}
//		System.out.println("\n\n\n");
//		List<Order> list2 = os.viewOrders();
//		for (Order order : list2) {
//			System.out.println(order);
//		}
//		System.out.println("\n\n\n");
//		int[] pids = {3, 5, 6};
//		int[] qts = {4, 2, 1};
//		os.placeOrder("def@gmail.com", pids, qts);
//		List<Order> list3 = os.viewOrders();
//		for (Order order : list2) {
//			System.out.println(order);
//		}
	}

}
