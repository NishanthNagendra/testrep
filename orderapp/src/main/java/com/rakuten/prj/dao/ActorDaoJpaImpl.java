/**
 * 
 */
package com.rakuten.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.rakuten.prj.entity.Actor;

/**
 * @author nishanth
 *
 */
@Repository
public class ActorDaoJpaImpl implements ActorDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addActor(Actor actor) {
		em.persist(actor);
	}

	@Override
	public Actor getActor(int id) {
		return em.find(Actor.class, id);
	}

	@Override
	public List<Actor> getAllActors() {
		String jpql = "from Actor";
		TypedQuery<Actor> query = em.createQuery(jpql, Actor.class);
		return query.getResultList();
	}

}
