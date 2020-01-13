package com.rakuten.prj.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rakuten.prj.cfg.AppConfig;
import com.rakuten.prj.dao.CustomerDaoJpaImpl;
import com.rakuten.prj.dao.ProductDaoJpaImpl;
import com.rakuten.prj.service.OrderService;

public class CustomerGetByEmailClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();	// Creates a spring container
		// new ClassPathCMLApplicationContext("beans.xml"); if xml file is used instead of annotations
		ctx.register(OrderService.class);	// object will be orderService
		ctx.register(CustomerDaoJpaImpl.class);	// object will be productDaoJpaImpl
		ctx.register(ProductDaoJpaImpl.class);
		ctx.register(AppConfig.class);	// object will be appConfig
		// register all classes required for spring
		ctx.refresh();
		
		OrderService os = ctx.getBean("orderService", OrderService.class);	// where orderService is name of the object
		
		System.out.println(os.getCustomer("abc@gmail.com"));
	}

}
