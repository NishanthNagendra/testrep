/**
 * 
 */
package com.rakuten.prj.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.prj.entity.Course;
import com.rakuten.prj.service.CourseService;

/**
 * @author nishanth
 *
 */
@RestController
@RequestMapping("courses")
public class CourseRestController {
	@Autowired
	private CourseService service;

	@GetMapping()
	public @ResponseBody List<Course> getCourses(@RequestParam(name = "username", required = false) String username) {
		if (username == null)
			return service.getCourses();
		else
			return service.getCourseUser(username);
	}

	@GetMapping("/{id}")
	public @ResponseBody Course getCourseById(@PathVariable("id") int id) {
		return service.getCourse(id);
	}
	
	@PostMapping()
	public ResponseEntity<Course> addCourse(@RequestBody Course c) {
		service.addCourse(c);
		return new ResponseEntity<Course>(c, HttpStatus.CREATED);

	}

	@PostMapping("/{id}")
	public ResponseEntity<Course> updateCourse(@RequestBody Course c) {
		service.addCourse(c);
		return new ResponseEntity<Course>(c, HttpStatus.CREATED);

	}
}