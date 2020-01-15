/**
 * 
 */
package com.rakuten.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.rakuten.prj.entity.Hotel;

/**
 * @author nishanth
 *
 */
@Repository
public class HotelDaoJpaImpl implements HotelDao {
	@PersistenceContext
	private EntityManager em;
	
	public Hotel getHotel(int hotelId) {
		return em.find(Hotel.class, hotelId);
	}

	public List<Hotel> getAllHotels() {
		String jpql = "from Hotel";
		TypedQuery<Hotel> query = em.createQuery(jpql, Hotel.class);
		return query.getResultList();
	}

	public void addHotel(Hotel h) {
		em.persist(h);
	}

	public List<Hotel> getBookedHotels() {
		return null;
	}

	public List<Hotel> getSearchedHotels(String searchKey) {
		String jpql = "from Hotel where hotelName like concat('%', :searchKey, '%') or "
				+ "address like concat('%', :searchKey, '%') or "
				+ "city like concat('%', :searchKey, '%') or "
				+ "state like concat('%', :searchKey, '%') or "
				+ "country like concat('%', :searchKey, '%')";
		TypedQuery<Hotel> query = em.createQuery(jpql, Hotel.class);
		query.setParameter("searchKey", searchKey);
		return query.getResultList();
	}

}
