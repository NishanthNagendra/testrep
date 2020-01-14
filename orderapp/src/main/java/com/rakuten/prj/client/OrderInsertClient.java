/**
 * 
 */
package com.rakuten.prj.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rakuten.prj.cfg.AppConfig;
import com.rakuten.prj.dao.CustomerDaoJpaImpl;
import com.rakuten.prj.dao.OrderDaoJpaImpl;
import com.rakuten.prj.dao.ProductDaoJpaImpl;
import com.rakuten.prj.service.OrderService;

/**
 * @author nishanth
 *
 */
public class OrderInsertClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();	// Creates a spring container
		// new ClassPathXmlApplicationContext("beans.xml"); if xml file is used instead of annotations
		ctx.register(OrderService.class);	// object will be orderService
		ctx.register(ProductDaoJpaImpl.class);	
		ctx.register(CustomerDaoJpaImpl.class);	// object will be productDaoJpaImpl
		ctx.register(OrderDaoJpaImpl.class);
		ctx.register(AppConfig.class);	// object will be appConfig
		// register all classes required for spring
		ctx.refresh();
		
		OrderService os = ctx.getBean("orderService", OrderService.class);	// where orderService is name of the object
		
		int[] pids = {3, 5, 6};
		int[] qts = {4, 2, 1};
		
		os.placeOrder("abc@gmail.com", pids, qts);
		
		System.out.println("Order Placed!!!");
	}

}
