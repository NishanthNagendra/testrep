/**
 * 
 */
package com.rakuten.prj.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rakuten.prj.cfg.AppConfig;
import com.rakuten.prj.dao.BookingDaoJpaImpl;
import com.rakuten.prj.dao.HotelDaoJpaImpl;
import com.rakuten.prj.dao.UserDaoJpaImpl;
import com.rakuten.prj.service.BookingService;

/**
 * @author nishanth
 *
 */
public class SearchHotelClient {
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

		System.out.println("Search Results for tokyo\n");
		
		System.out.println(bs.searchHotels("tokyo"));
		
		System.out.println("\n\nSearch Results for Marriot\n");
		
		System.out.println(bs.searchHotels("Marriot"));
	}

}
