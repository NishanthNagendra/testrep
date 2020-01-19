/**
 * 
 */
package com.rakuten.prj.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author nishanth
 *
 */
@Entity()
@Table(name = "campaigns")
public class Campaign {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Kolkata")
	private Date deadline;
	private double receivedAmount = 0;
	private double totalAmount;
	private String terms;
	private String status;
	
	

	/**
	 * 
	 */
	public Campaign() {
	}



	/**
	 * @param id
	 * @param title
	 * @param deadline
	 * @param receivedAmount
	 * @param totalAmount
	 * @param terms
	 * @param active
	 */
	public Campaign(int id, String title, Date deadline, double receivedAmount, double totalAmount, String terms,
			String status) {
		this.id = id;
		this.title = title;
		this.deadline = deadline;
		this.receivedAmount = receivedAmount;
		this.totalAmount = totalAmount;
		this.terms = terms;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}



	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}



	/**
	 * @return the deadline
	 */
	public Date getDeadline() {
		return deadline;
	}



	/**
	 * @param deadline the deadline to set
	 */
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}



	/**
	 * @return the receivedAmount
	 */
	public double getReceivedAmount() {
		return receivedAmount;
	}



	/**
	 * @param receivedAmount the receivedAmount to set
	 */
	public void setReceivedAmount(double receivedAmount) {
		this.receivedAmount = receivedAmount;
	}



	/**
	 * @return the totalAmount
	 */
	public double getTotalAmount() {
		return totalAmount;
	}



	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}



	/**
	 * @return the terms
	 */
	public String getTerms() {
		return terms;
	}



	/**
	 * @param terms the terms to set
	 */
	public void setTerms(String terms) {
		this.terms = terms;
	}



	/**
	 * @return the active
	 */
	public String getStatus() {
		return status;
	}



	/**
	 * @param active the active to set
	 */
	public void setActive(String status) {
		this.status = status;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((deadline == null) ? 0 : deadline.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(receivedAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((terms == null) ? 0 : terms.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		temp = Double.doubleToLongBits(totalAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Campaign other = (Campaign) obj;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (deadline == null) {
			if (other.deadline != null)
				return false;
		} else if (!deadline.equals(other.deadline))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(receivedAmount) != Double.doubleToLongBits(other.receivedAmount))
			return false;
		if (terms == null) {
			if (other.terms != null)
				return false;
		} else if (!terms.equals(other.terms))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (Double.doubleToLongBits(totalAmount) != Double.doubleToLongBits(other.totalAmount))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Campaign [id=" + id + ", title=" + title + ", deadline=" + deadline + ", receivedAmount="
				+ receivedAmount + ", totalAmount=" + totalAmount + ", terms=" + terms + ", status=" + status + "]";
	}
	
	
	
	
}
