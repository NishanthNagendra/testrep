/**
 * 
 */
package com.rakuten.prj.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rakuten.prj.cfg.AppConfig;
import com.rakuten.prj.dao.ActorDaoJpaImpl;
import com.rakuten.prj.dao.MovieDaoJpaImpl;
import com.rakuten.prj.entity.Actor;
import com.rakuten.prj.entity.Movie;
import com.rakuten.prj.service.MovieService;

/**
 * @author nishanth
 *
 */
public class MovieActorInsertClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(); // Creates a spring container
		ctx.register(MovieService.class);	
		ctx.register(MovieDaoJpaImpl.class);	
		ctx.register(ActorDaoJpaImpl.class);	
		ctx.register(AppConfig.class);	
		ctx.refresh();
		
		MovieService ms = ctx.getBean("movieService", MovieService.class);
		
//		Movie m1 = new Movie();
//		m1.setName("Kill Bill");
//
//		Movie m2 = new Movie();
//		m2.setName("Pulp Fiction");
//		
//		Actor a1 = new Actor();
//		a1.setName("John Travolta");
//		
//		Actor a2 = new Actor();
//		a2.setName("Uma Thruman");
//		
//		Actor a3 = new Actor();
//		a3.setName("Samuel Jackson");
//		
//		ms.addMovie(m1);
//		ms.addMovie(m2);
//		
//		ms.addActor(a1);
//		ms.addActor(a2);
//		ms.addActor(a3);
		
		Movie m1 = ms.getMovie(1);
		Actor a1 = ms.getActor(2);
		m1.getActors().add(a1);
		
		Movie m2 = ms.getMovie(2);
		Actor a2 = ms.getActor(1);
		Actor a3 = ms.getActor(3);
		
		m2.getActors().add(a2);
		m2.getActors().add(a3);
		
		ms.updateMovie(m1);
		ms.updateMovie(m2);
	}

}
