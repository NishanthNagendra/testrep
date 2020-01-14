/**
 * 
 */
package com.rakuten.prj.dao;

import java.util.List;

import com.rakuten.prj.entity.Ticket;

/**
 * @author nishanth
 *
 */
public interface TicketDao {
	void raiseTicket(Ticket t);
	List<Ticket> showOpenTickets();
	List<Ticket> showAllTickets();
	Ticket getTicket(int ticketId);
}
