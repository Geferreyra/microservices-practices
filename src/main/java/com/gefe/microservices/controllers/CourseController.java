package com.gefe.microservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gefe.microservices.models.Course;
import com.gefe.microservices.services.CourseService;

@RestController
@RequestMapping("/api/colegio")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@PostMapping("/curso")
	public Course createCourse(@Validated @RequestBody Course course) {
		return courseService.saveCourse(course);
	}
	
	@GetMapping("/cursos")
	public List<Course>allCourses(){
		return courseService.getAllCourses();
	}
	
	@GetMapping("/curso/{key}")
	public Optional<Course> findCourse(@PathVariable Long key) {
		return courseService.getCourse(key);
	}
	
	@PutMapping("/curso/{key}")
	public Course updateCourse(@PathVariable Long key,@Validated @RequestBody Course course) {
		return courseService.saveCourse(course);
	}
	
	@DeleteMapping("/curso/{key}")
	public void deleteCourse(@PathVariable Long key) {
		courseService.deleteCourse(key);
	}
	
}
