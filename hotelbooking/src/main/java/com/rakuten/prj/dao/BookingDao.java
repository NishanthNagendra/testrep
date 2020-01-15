/**
 * 
 */
package com.rakuten.prj.dao;

import java.util.Date;
import java.util.List;

import com.rakuten.prj.entity.Booking;
import com.rakuten.prj.entity.Hotel;
import com.rakuten.prj.entity.User;

/**
 * @author nishanth
 *
 */
public interface BookingDao {
	boolean checkHotel(User user, Hotel hotel, Date checkIn, Date checkOut);
	void addHotel(Booking b);
	List<Booking> listBookingsInDates(Date fromDate, Date toDate);
}
