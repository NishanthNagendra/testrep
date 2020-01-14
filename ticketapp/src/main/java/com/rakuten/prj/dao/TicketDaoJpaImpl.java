/**
 * 
 */
package com.rakuten.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.rakuten.prj.entity.Ticket;

/**
 * @author nishanth
 *
 */
@Repository
public class TicketDaoJpaImpl implements TicketDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void raiseTicket(Ticket t) {
		em.persist(t);
	}

	@Override
	public List<Ticket> showAllTickets() {
		String jpql = "from Ticket";
		TypedQuery<Ticket> query = em.createQuery(jpql, Ticket.class);
		return query.getResultList();
	}

	@Override
	public List<Ticket> showOpenTickets() {
		String jpql = "from Ticket where resolvedByEmployee is NULL";
		TypedQuery<Ticket> query = em.createQuery(jpql, Ticket.class);
		return query.getResultList();
	}

	@Override
	public Ticket getTicket(int ticketId) {
		return em.find(Ticket.class, ticketId);
	}

}
