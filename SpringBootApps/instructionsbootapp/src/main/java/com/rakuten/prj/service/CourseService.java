/**
 * 
 */
package com.rakuten.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.prj.dao.CourseDao;
import com.rakuten.prj.entity.Course;

/**
 * @author nishanth
 *
 */
@Service
@Transactional
public class CourseService {
	@Autowired
	private CourseDao courseDao;
	
	public List<Course> getCourses() {
		return courseDao.findAll();
	}
	
	public Course getCourse(int id) {
		return courseDao.findById(id).get();
	}
	
	public List<Course> getCourseUser(String username) {
		return courseDao.findByUsername(username);
	}
	
	public void addCourse(Course c) {
		courseDao.save(c);
	}
}
