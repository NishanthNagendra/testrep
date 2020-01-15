/**
 * 
 */
package com.rakuten.prj.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.rakuten.prj.entity.Booking;
import com.rakuten.prj.entity.Hotel;
import com.rakuten.prj.entity.User;

/**
 * @author nishanth
 *
 */
@Repository
public class BookingDaoJpaImpl implements BookingDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean checkHotel(User user, Hotel hotel, Date checkIn, Date checkOut) {
		String jpql = "from Booking where bookedHotel = :booked and " // bookedBy != :user and "
				+ "checkInDate <= :checkInD and checkOutDate >= :checkInD or "
				+ "checkInDate <= :checkOutD and checkOutDate >= :checkOutD";
		TypedQuery<Booking> query = em.createQuery(jpql, Booking.class);
//		query.setParameter("user", user);
		query.setParameter("booked", hotel);
		query.setParameter("checkInD", checkIn);
		query.setParameter("checkOutD", checkOut);
//		System.out.println(query.getResultList());
		if (query.getResultList().isEmpty()) {
			System.out.println("Booking Succeeded!!!");
			return true;
		} else {
			System.out.println("Your booking clashes with previous bookings");
			return false;
		}
	}

	@Override
	public void addHotel(Booking b) {
		em.persist(b);
	}

	@Override
	public List<Booking> listBookingsInDates(Date fromDate, Date toDate) {
		String jpql = "from Booking where checkInDate >= :fromDate and checkOutDate <= :toDate";
		TypedQuery<Booking> query = em.createQuery(jpql, Booking.class);
		query.setParameter("fromDate", fromDate);
		query.setParameter("toDate", toDate);
		return query.getResultList();
	}

}
