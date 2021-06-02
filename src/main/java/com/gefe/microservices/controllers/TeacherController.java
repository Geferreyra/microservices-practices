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

import com.gefe.microservices.models.Teacher;
import com.gefe.microservices.services.PersonService;
import com.gefe.microservices.services.TeacherService;

@RestController
@RequestMapping("/api/colegio")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private PersonService personService;
	
	@PostMapping("/profesor")
	public Teacher createTeacher(@Validated @RequestBody Teacher teacher) {
		return teacherService.saveTeacher(teacher);
	}
	
	@GetMapping("/profesores")
	public List<Teacher>allTeachers(){
		return teacherService.getAllTeacher();
	}
	
	@GetMapping("/profesor/{id}")
	public Optional<Teacher> findTeacher(@PathVariable String id) {
		return teacherService.getTeacher(id);
	}
	
	@PutMapping("/profesor/{id}")
	public Teacher updateTeacher(@PathVariable String id,@Validated @RequestBody Teacher teacher) {
		return teacherService.saveTeacher(teacher);
	}
	
	@DeleteMapping("/profesor/{id}")
	public void deleteTeacher(@PathVariable String id) {
		personService.deletePerson(id);
	}
	

}
