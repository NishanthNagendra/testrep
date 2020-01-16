/**
 * 
 */
package com.rakuten.prj.service;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.prj.dao.ActorDao;
import com.rakuten.prj.dao.MovieDao;
import com.rakuten.prj.entity.Actor;
import com.rakuten.prj.entity.Movie;

/**
 * @author nishanth
 *
 */
@Service
@Transactional
public class MovieService {
	@Autowired
	private ActorDao actorDao;
	
	@Autowired
	private MovieDao movieDao;
	
	public void addActor(Actor actor) {
		actorDao.addActor(actor);
	}

	public Actor getActor(int id) {
		return actorDao.getActor(id);
	}

	public List<Actor> getAllActors() {
		return actorDao.getAllActors();
	}
	
	public void addMovie(Movie m) {
		movieDao.addMovie(m);
	}

	public Movie getMovie(int id) {
		return movieDao.getMovie(id);
	}

	public List<Movie> getMovies() {
		return movieDao.getMovies();
	}

	public void updateMovie(Movie m) {
		movieDao.updateMovie(m);
	}

}
