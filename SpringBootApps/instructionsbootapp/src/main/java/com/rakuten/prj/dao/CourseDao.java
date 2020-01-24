/**
 * 
 */
package com.rakuten.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rakuten.prj.entity.Course;

/**
 * @author nishanth
 *
 */
public interface CourseDao extends JpaRepository<Course, Integer> {
	List<Course> findByUsername(String username); 
}
