/**
 * 
 */
package com.rakuten.prj.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rakuten.prj.cfg.AppConfig;
import com.rakuten.prj.dao.EmployeeDaoJpaImpl;
import com.rakuten.prj.dao.TicketDaoJpaImpl;
import com.rakuten.prj.entity.Employee;
import com.rakuten.prj.service.TicketService;

/**
 * @author nishanth
 *
 */
public class InsertEmployeeClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(TicketService.class);
		ctx.register(EmployeeDaoJpaImpl.class);	
		ctx.register(TicketDaoJpaImpl.class);
		ctx.register(AppConfig.class);
		ctx.refresh();
		
		TicketService ts = ctx.getBean("ticketService", TicketService.class);

		Employee[] employees = new Employee[4];
		employees[0] = new Employee(100, "abc@gmail.com", "abc", "def");
		employees[1] = new Employee(101, "ghi@gmail.com", "ghi", "jkl");
		employees[2] = new Employee(102, "mno@gmail.com", "mno", "pqr");
		employees[3] = new Employee(103, "stu@gmail.com", "stu", "vwx");
		
		for (Employee employee : employees) {
			ts.insertEmployee(employee);
		}
		
		System.out.println("Employees inserted");
	}

}
