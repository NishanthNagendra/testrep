/**
 * 
 */
package com.rakuten.prj.service;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.prj.dao.EmployeeDao;
import com.rakuten.prj.dao.TicketDao;
import com.rakuten.prj.entity.Employee;
import com.rakuten.prj.entity.Ticket;

/**
 * @author nishanth
 *
 */
@Service
@Transactional
public class TicketService {
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private TicketDao ticketDao;
	
	public void insertEmployee(Employee e) {
		employeeDao.addEmployee(e);
	}
	
	public Employee getEmployee(int id) {
		return employeeDao.getEmployee(id);
	}
	
	public List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}
	
	public void insertTicket(int id, String ticketDesc) {
		Ticket ticket = new Ticket();
		Employee employee = employeeDao.getEmployee(id);
		ticket.setRaisedByEmployee(employee);
		ticket.setTicketDesc(ticketDesc);
		ticketDao.raiseTicket(ticket);
	}
	
	public List<Ticket> getTickets() {
		return ticketDao.showAllTickets();
	}
	
	public List<Ticket> getOpenTickets() {
		return ticketDao.showOpenTickets();
	}

	public void resolveTicket(int ticketId, int empId, String resolvedDesc) {
		Employee employee = employeeDao.getEmployee(empId);
		Ticket ticket = ticketDao.getTicket(ticketId);	
		Date date = new Date();
		ticket.setResolvedDate(date);
		ticket.setResolvedByEmployee(employee);
		ticket.setResolvedDesc(resolvedDesc);
	}
}
