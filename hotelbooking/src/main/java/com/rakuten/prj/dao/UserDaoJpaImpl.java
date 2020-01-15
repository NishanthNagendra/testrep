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
import com.rakuten.prj.entity.User;

/**
 * @author nishanth
 *
 */
@Repository
public class UserDaoJpaImpl implements UserDao {
	@PersistenceContext
	private EntityManager em;

	public User getUser(String userId) {
		return em.find(User.class, userId);
	}

	public List<User> getAllUsers() {
		String jpql = "from User";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		return query.getResultList();
	}

	public void addUser(User u) {
		em.persist(u);
	}
	
	

}
