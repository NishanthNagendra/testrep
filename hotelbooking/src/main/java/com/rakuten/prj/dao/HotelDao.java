/**
 * 
 */
package com.rakuten.prj.dao;

import java.util.List;

import com.rakuten.prj.entity.Hotel;

/**
 * @author nishanth
 *
 */
public interface HotelDao {
	Hotel getHotel(int hotelId);
	List<Hotel> getAllHotels();
	void addHotel(Hotel h); 
	List<Hotel> getBookedHotels();
	List<Hotel> getSearchedHotels(String searchKey);
}
