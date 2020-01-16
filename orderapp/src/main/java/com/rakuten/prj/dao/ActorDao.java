/**
 * 
 */
package com.rakuten.prj.dao;

import java.util.List;

import com.rakuten.prj.entity.Actor;

/**
 * @author nishanth
 *
 */
public interface ActorDao {
	void addActor(Actor actor);
	Actor getActor(int id);
	List<Actor> getAllActors();
}
