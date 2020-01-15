/**
 * 
 */
package com.rakuten.prj.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author nishanth
 *
 */
@Entity
@Table(name = "bookings")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private int bookingId;
	
	@ManyToOne
	@JoinColumn(name = "booked_hotel")
	private Hotel bookedHotel;
	
	@Column(name = "booking_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date bookingDate = new Date();
	
	@Column(name = "check_in_date")
	private Date checkInDate;
	
	@Column(name = "check_out_date")
	private Date checkOutDate;
	
	@ManyToOne
	@JoinColumn(name = "booked_by")
	private User bookedBy;
	
	@Column(name = "price")
	private double price;

	/**
	 * 
	 */
	public Booking() {
	}

	
	/**
	 * @param bookingId
	 * @param bookedHotel
	 * @param bookingDate
	 * @param checkInDate
	 * @param checkOutDate
	 * @param bookedBy
	 * @param price
	 */
	public Booking(int bookingId, Hotel bookedHotel, Date bookingDate, Date checkInDate, Date checkOutDate,
			User bookedBy, double price) {
		this.bookingId = bookingId;
		this.bookedHotel = bookedHotel;
		this.bookingDate = bookingDate;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.bookedBy = bookedBy;
		this.price = price;
	}


	/**
	 * @return the bookingId
	 */
	public int getBookingId() {
		return bookingId;
	}

	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * @return the bookedHotel
	 */
	public Hotel getBookedHotel() {
		return bookedHotel;
	}

	/**
	 * @param bookedHotel the bookedHotel to set
	 */
	public void setBookedHotel(Hotel bookedHotel) {
		this.bookedHotel = bookedHotel;
	}

	/**
	 * @return the bookingDate
	 */
	public Date getBookingDate() {
		return bookingDate;
	}

	/**
	 * @param bookingDate the bookingDate to set
	 */
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	/**
	 * @return the checkInDate
	 */
	public Date getCheckInDate() {
		return checkInDate;
	}

	/**
	 * @param checkInDate the checkInDate to set
	 */
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	/**
	 * @return the checkOutDate
	 */
	public Date getCheckOutDate() {
		return checkOutDate;
	}

	/**
	 * @param checkOutDate the checkOutDate to set
	 */
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	/**
	 * @return the bookedBy
	 */
	public User getBookedBy() {
		return bookedBy;
	}

	/**
	 * @param bookedBy the bookedBy to set
	 */
	public void setBookedBy(User bookedBy) {
		this.bookedBy = bookedBy;
	}

	
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookedBy == null) ? 0 : bookedBy.hashCode());
		result = prime * result + ((bookedHotel == null) ? 0 : bookedHotel.hashCode());
		result = prime * result + ((bookingDate == null) ? 0 : bookingDate.hashCode());
		result = prime * result + bookingId;
		result = prime * result + ((checkInDate == null) ? 0 : checkInDate.hashCode());
		result = prime * result + ((checkOutDate == null) ? 0 : checkOutDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		if (bookedBy == null) {
			if (other.bookedBy != null)
				return false;
		} else if (!bookedBy.equals(other.bookedBy))
			return false;
		if (bookedHotel == null) {
			if (other.bookedHotel != null)
				return false;
		} else if (!bookedHotel.equals(other.bookedHotel))
			return false;
		if (bookingDate == null) {
			if (other.bookingDate != null)
				return false;
		} else if (!bookingDate.equals(other.bookingDate))
			return false;
		if (bookingId != other.bookingId)
			return false;
		if (checkInDate == null) {
			if (other.checkInDate != null)
				return false;
		} else if (!checkInDate.equals(other.checkInDate))
			return false;
		if (checkOutDate == null) {
			if (other.checkOutDate != null)
				return false;
		} else if (!checkOutDate.equals(other.checkOutDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[bookingId=" + bookingId + ", bookedHotel=" + bookedHotel + ", bookingDate=" + bookingDate
				+ ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", bookedBy=" + bookedBy + "]\n";
	}

	
	
}
