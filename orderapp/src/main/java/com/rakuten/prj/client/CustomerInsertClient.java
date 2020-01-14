/**
 * 
 */
package com.rakuten.prj.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rakuten.prj.cfg.AppConfig;
import com.rakuten.prj.dao.CustomerDaoJpaImpl;
import com.rakuten.prj.dao.OrderDaoJpaImpl;
import com.rakuten.prj.dao.ProductDaoJpaImpl;
import com.rakuten.prj.entity.Customer;
import com.rakuten.prj.service.OrderService;

/**
 * @author nishanth
 *
 */
public class CustomerInsertClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();	// Creates a spring container
		// new ClassPathCMLApplicationContext("beans.xml"); if xml file is used instead of annotations
		ctx.register(OrderService.class);	// object will be orderService
		ctx.register(ProductDaoJpaImpl.class);	
		ctx.register(CustomerDaoJpaImpl.class);	// object will be productDaoJpaImpl
		ctx.register(OrderDaoJpaImpl.class);
		ctx.register(AppConfig.class);	// object will be appConfig
		ctx.refresh();
		
		OrderService os = ctx.getBean("orderService", OrderService.class);	// where orderService is name of the object
		
		
		/**
		 * To insert Customers
		 */
		Customer[] customers = new Customer[6];
        customers[0] = new Customer("abc@gmail.com", "abc");
        customers[1] = new Customer("def@gmail.com", "def");
        customers[2] = new Customer("ghi@gmail.com", "ghi");
        customers[3] = new Customer("jkl@gmail.com", "jkl");
        customers[4] = new Customer("mno@gmail.com", "mno");
        customers[5] = new Customer("pqr@gmail.com", "pqr");
        
        for (Customer customer : customers) {
			os.insertCustomer(customer);
		}
        
        System.out.println("Customers inserted");
	}

}
