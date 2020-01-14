package com.rakuten.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rakuten.prj.cfg.AppConfig;
import com.rakuten.prj.dao.CustomerDaoJpaImpl;
import com.rakuten.prj.dao.OrderDaoJpaImpl;
import com.rakuten.prj.dao.ProductDaoJpaImpl;
import com.rakuten.prj.entity.Product;
import com.rakuten.prj.service.OrderService;

public class ProductClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();	// Creates a spring container
		// new ClassPathCMLApplicationContext("beans.xml"); if xml file is used instead of annotations
		ctx.register(OrderService.class);	// object will be orderService
		ctx.register(ProductDaoJpaImpl.class);	
		ctx.register(CustomerDaoJpaImpl.class);	// object will be productDaoJpaImpl
		ctx.register(OrderDaoJpaImpl.class);
		ctx.register(AppConfig.class);	// object will be appConfig
		// register all classes required for spring
		ctx.refresh();
		
		OrderService os = ctx.getBean("orderService", OrderService.class);	// where orderService is name of the object
		
		
		/**
		 * To insert products
		 */
//		Product[] products = new Product[6];
//        products[0] = new Product(0, "Hp Laptop", 135000.00, "computer");
//        products[1] = new Product(0, "iPhone", 98000.00, "mobile");
//        products[2] = new Product(0, "Logitech Mouse", 600.00, "computer");
//        products[3] = new Product(0, "Sony Bravia", 125000.00, "tv");
//        products[4] = new Product(0, "One Plus", 32000.00, "mobile");
//        products[5] = new Product(0, "HP Printer", 19000.00, "computer");
//		
//        for (Product product : products) {
//			os.insertProduct(product);
//		}
//        
//        System.out.println("Products inserted");
		
		
		/**
		 * To view product of specific index
		 */
		System.out.println(os.getProduct(3) + "\n\n\n");
		
		/**
		 * To view all products
		 */
		List<Product> products = os.getAllProducts();
		for (Product product : products) {
			System.out.println(product);
		}
	}

}
