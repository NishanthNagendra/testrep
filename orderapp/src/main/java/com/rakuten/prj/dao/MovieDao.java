/**
 * 
 */
package com.rakuten.prj.dao;

import java.util.List;

import com.rakuten.prj.entity.Movie;

/**
 * @author nishanth
 *
 */
public interface MovieDao {
	void addMovie(Movie m);
	Movie getMovie(int id);
	List<Movie> getMovies();
	void updateMovie(Movie m);
}
