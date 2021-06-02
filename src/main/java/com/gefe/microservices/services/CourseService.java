package com.gefe.microservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gefe.microservices.models.Course;
import com.gefe.microservices.repositories.ICourseRepository;

@Service
public class CourseService {

	@Autowired
	private ICourseRepository ICourseRepository;
	
	public Course saveCourse(Course course) {
		return ICourseRepository.save(course);
	}
	
	public List<Course>getAllCourses(){
		return ICourseRepository.findAll();
	}
	
	public void deleteCourse(Long key) {
		ICourseRepository.deleteById(key);
	}
	
	public Optional<Course> getCourse(Long key) {
		return ICourseRepository.findById(key);
	}
	
}
