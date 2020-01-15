/**
 * 
 */
package com.rakuten.prj.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.prj.dao.BookingDao;
import com.rakuten.prj.dao.HotelDao;
import com.rakuten.prj.dao.UserDao;
import com.rakuten.prj.entity.Booking;
import com.rakuten.prj.entity.Hotel;
import com.rakuten.prj.entity.User;

/**
 * @author nishanth
 *
 */
@Service
@Transactional
public class BookingService {
	@Autowired
	private UserDao userDao;

	@Autowired
	private HotelDao hotelDao;

	@Autowired
	private BookingDao bookingDao;

	public List<Hotel> searchHotels(String searchKey) {
		return hotelDao.getSearchedHotels(searchKey);
	}

	public void insertUser(User user) {
		userDao.addUser(user);
	}

	public List<User> showAllUsers() {
		return userDao.getAllUsers();
	}

	public void bookHotel(String email, int hotelId, String checkIn, String checkOut) {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date checkInD = null;
		Date checkOutD = null;
		try {
			checkInD = (Date) formatter.parse(checkIn);
			checkOutD = (Date) formatter.parse(checkOut);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Hotel hotel = hotelDao.getHotel(hotelId);
		User user = userDao.getUser(email);
		if (bookingDao.checkHotel(user, hotel, checkInD, checkOutD)) {
			Booking b = new Booking();
			b.setBookedBy(user);
			b.setBookedHotel(hotel);
			b.setCheckInDate(checkInD);
			b.setCheckOutDate(checkOutD);
			b.setPrice(hotel.getPrice());
			bookingDao.addHotel(b);
		}
	}

	public List<Booking> listBookings(String fromDate, String toDate) {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date fromDateConv = null;
		Date toDateConv = null;
		try {
			fromDateConv = (Date) formatter.parse(fromDate);
			toDateConv = (Date) formatter.parse(toDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return bookingDao.listBookingsInDates(fromDateConv, toDateConv);
	}
}
