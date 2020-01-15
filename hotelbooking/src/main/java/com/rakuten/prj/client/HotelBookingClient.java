/**
 * 
 */
package com.rakuten.prj.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rakuten.prj.cfg.AppConfig;
import com.rakuten.prj.dao.BookingDaoJpaImpl;
import com.rakuten.prj.dao.HotelDaoJpaImpl;
import com.rakuten.prj.dao.UserDaoJpaImpl;
import com.rakuten.prj.entity.User;
import com.rakuten.prj.service.BookingService;

/**
 * @author nishanth
 *
 */
public class HotelBookingClient {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(BookingService.class);
		ctx.register(HotelDaoJpaImpl.class);
		ctx.register(UserDaoJpaImpl.class);
		ctx.register(BookingDaoJpaImpl.class);
		ctx.register(AppConfig.class);
		ctx.refresh();

		BookingService bs = ctx.getBean("bookingService", BookingService.class);

//		User[] users = new User[4];
//		users[0] = new User("9839092381", "abc@gmail.com", "abc");
//		users[1] = new User("9837838828", "def@gmail.com", "def");
//		users[2] = new User("9203902402", "ghi@gmail.com", "ghi");
//		users[3] = new User("9494094790", "jkl@gmail.com", "jkl");
//		
//		for (User user : users) {
//			bs.insertUser(user);
//		}
//		
//		System.out.println("Employees inserted");
//		
//		System.out.println(bs.showAllUsers());
		bs.bookHotel("ghi@gmail.com", 8, "17/01/2020", "19/01/2020");
		bs.bookHotel("ghi@gmail.com", 8, "17/02/2020", "19/02/2020");
		bs.bookHotel("abc@gmail.com", 9, "17/01/2020", "19/01/2020");
		bs.bookHotel("abc@gmail.com", 9, "17/02/2020", "19/02/2020");
		bs.bookHotel("abc@gmail.com", 9, "17/03/2020", "19/03/2020");
	}
}
