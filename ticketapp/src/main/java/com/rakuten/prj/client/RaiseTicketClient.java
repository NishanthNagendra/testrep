/**
 * 
 */
package com.rakuten.prj.client;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rakuten.prj.cfg.AppConfig;
import com.rakuten.prj.dao.EmployeeDaoJpaImpl;
import com.rakuten.prj.dao.TicketDaoJpaImpl;
import com.rakuten.prj.entity.Employee;
import com.rakuten.prj.entity.Ticket;
import com.rakuten.prj.service.TicketService;

/**
 * @author nishanth
 *
 */
public class RaiseTicketClient {

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
		
		ts.insertTicket(102, "Faulty Keypad");
		ts.insertTicket(101, "Display Issues");
		ts.insertTicket(103, "Trackpad not working");
		ts.insertTicket(103, "Faulty charging port");
		
		System.out.println("Raised Ticket");
	}

}
