/**
 * 
 */
package com.rakuten.prj.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author nishanth
 *
 */
@Entity()
@Table(name = "donations")
public class Donation {
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "campaign_fk")
	private Campaign campaign;

	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String email;
	/**
	 * 
	 */
	private String phoneNumber;

	/**
	 * 
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Kolkata")
	private Date date = new Date();

	/**
	 * 
	 */
	private double amount;
	/**
	 * 
	 */
	private String paymentMode;
	/**
	 * 
	 */
	private String status;

	/**
	 * 
	 */
	public Donation() {
	}

	/**
	 * @param id
	 * @param campaign
	 * @param name
	 * @param email
	 * @param phoneNumber
	 * @param date
	 * @param amount
	 * @param paymentMode
	 * @param status
	 */
	public Donation(int id, Campaign campaign, String name, String email, String phoneNumber, Date date, double amount,
			String paymentMode, String status) {
		this.id = id;
		this.campaign = campaign;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.date = date;
		this.amount = amount;
		this.paymentMode = paymentMode;
		this.status = status;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the campaign
	 */
	public Campaign getCampaign() {
		return campaign;
	}

	/**
	 * @param campaign the campaign to set
	 */
	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the paymentMode
	 */
	public String getPaymentMode() {
		return paymentMode;
	}

	/**
	 * @param paymentMode the paymentMode to set
	 */
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((email == null) ? 0 : email.hashCode());
//		result = prime * result + id;
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Donation other = (Donation) obj;
//		if (email == null) {
//			if (other.email != null)
//				return false;
//		} else if (!email.equals(other.email))
//			return false;
//		if (id != other.id)
//			return false;
//		return true;
//	}
//
//	@Override
//	public String toString() {
//		return "Donation [id=" + id + ", campaign=" + campaign + ", name=" + name + ", email=" + email
//				+ ", phoneNumber=" + phoneNumber + ", amount=" + amount + ", paymentMode=" + paymentMode + ", status="
//				+ status + "]";
//	}

}
