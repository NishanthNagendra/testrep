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
@Table(name = "tickets")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_id")
	private int ticketId;
	
	@ManyToOne
	@JoinColumn(name = "raised_by_fk")
	private Employee raisedByEmployee;
	
	@Column(name = "raised_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date raisedDate = new Date();
	
	@Column(name = "ticket_desc", length = 100)
	private String ticketDesc;
	
	@ManyToOne
	@JoinColumn(name = "resolved_by_fk")
	private Employee resolvedByEmployee;
	
	@Column(name = "resolved_date")
	private Date resolvedDate = null;
	
	@Column(name = "resolved_desc", length = 100)
	private String resolvedDesc;

	/**
	 * 
	 */
	public Ticket() {
	}

	/**
	 * @param ticketId
	 * @param raisedByEmployee
	 * @param raisedDate
	 * @param ticketDesc
	 * @param resolvedByEmployee
	 * @param resolvedDate
	 * @param resolvedDesc
	 */
	public Ticket(int ticketId, Employee raisedByEmployee, Date raisedDate, String ticketDesc,
			Employee resolvedByEmployee, Date resolvedDate, String resolvedDesc) {
		this.ticketId = ticketId;
		this.raisedByEmployee = raisedByEmployee;
		this.raisedDate = raisedDate;
		this.ticketDesc = ticketDesc;
		this.resolvedByEmployee = resolvedByEmployee;
		this.resolvedDate = resolvedDate;
		this.resolvedDesc = resolvedDesc;
	}

	/**
	 * @return the ticketId
	 */
	public int getTicketId() {
		return ticketId;
	}

	/**
	 * @param ticketId the ticketId to set
	 */
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	/**
	 * @return the raisedByEmployee
	 */
	public Employee getRaisedByEmployee() {
		return raisedByEmployee;
	}

	/**
	 * @param raisedByEmployee the raisedByEmployee to set
	 */
	public void setRaisedByEmployee(Employee raisedByEmployee) {
		this.raisedByEmployee = raisedByEmployee;
	}

	/**
	 * @return the raisedDate
	 */
	public Date getRaisedDate() {
		return raisedDate;
	}

	/**
	 * @param raisedDate the raisedDate to set
	 */
	public void setRaisedDate(Date raisedDate) {
		this.raisedDate = raisedDate;
	}

	/**
	 * @return the ticketDesc
	 */
	public String getTicketDesc() {
		return ticketDesc;
	}

	/**
	 * @param ticketDesc the ticketDesc to set
	 */
	public void setTicketDesc(String ticketDesc) {
		this.ticketDesc = ticketDesc;
	}

	/**
	 * @return the resolvedByEmployee
	 */
	public Employee getResolvedByEmployee() {
		return resolvedByEmployee;
	}

	/**
	 * @param resolvedByEmployee the resolvedByEmployee to set
	 */
	public void setResolvedByEmployee(Employee resolvedByEmployee) {
		this.resolvedByEmployee = resolvedByEmployee;
	}

	/**
	 * @return the resolvedDate
	 */
	public Date getResolvedDate() {
		return resolvedDate;
	}

	/**
	 * @param resolvedDate the resolvedDate to set
	 */
	public void setResolvedDate(Date resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	/**
	 * @return the resolvedDesc
	 */
	public String getResolvedDesc() {
		return resolvedDesc;
	}

	/**
	 * @param resolvedDesc the resolvedDesc to set
	 */
	public void setResolvedDesc(String resolvedDesc) {
		this.resolvedDesc = resolvedDesc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((raisedByEmployee == null) ? 0 : raisedByEmployee.hashCode());
		result = prime * result + ((raisedDate == null) ? 0 : raisedDate.hashCode());
		result = prime * result + ((resolvedByEmployee == null) ? 0 : resolvedByEmployee.hashCode());
		result = prime * result + ((resolvedDate == null) ? 0 : resolvedDate.hashCode());
		result = prime * result + ((resolvedDesc == null) ? 0 : resolvedDesc.hashCode());
		result = prime * result + ((ticketDesc == null) ? 0 : ticketDesc.hashCode());
		result = prime * result + ticketId;
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
		Ticket other = (Ticket) obj;
		if (raisedByEmployee == null) {
			if (other.raisedByEmployee != null)
				return false;
		} else if (!raisedByEmployee.equals(other.raisedByEmployee))
			return false;
		if (raisedDate == null) {
			if (other.raisedDate != null)
				return false;
		} else if (!raisedDate.equals(other.raisedDate))
			return false;
		if (resolvedByEmployee == null) {
			if (other.resolvedByEmployee != null)
				return false;
		} else if (!resolvedByEmployee.equals(other.resolvedByEmployee))
			return false;
		if (resolvedDate == null) {
			if (other.resolvedDate != null)
				return false;
		} else if (!resolvedDate.equals(other.resolvedDate))
			return false;
		if (resolvedDesc == null) {
			if (other.resolvedDesc != null)
				return false;
		} else if (!resolvedDesc.equals(other.resolvedDesc))
			return false;
		if (ticketDesc == null) {
			if (other.ticketDesc != null)
				return false;
		} else if (!ticketDesc.equals(other.ticketDesc))
			return false;
		if (ticketId != other.ticketId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", raisedByEmployee=" + raisedByEmployee + ", raisedDate=" + raisedDate
				+ ", ticketDesc=" + ticketDesc + ", resolvedByEmployee=" + resolvedByEmployee + ", resolvedDate="
				+ resolvedDate + ", resolvedDesc=" + resolvedDesc + "]\n";
	}
	
	
}
