/**
 * 
 */
package com.rakuten.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.rakuten.prj.entity.Employee;

/**
 * @author nishanth
 *
 */
@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addEmployee(Employee e) {
		em.persist(e);
	}

	@Override
	public Employee getEmployee(int id) {
		return em.find(Employee.class, id);
	}

	@Override
	public List<Employee> getEmployees() {
		String jpql = "from Employee";
		TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
		return query.getResultList();
	}

}
