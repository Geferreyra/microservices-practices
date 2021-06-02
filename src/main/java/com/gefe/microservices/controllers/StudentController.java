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

import com.gefe.microservices.models.Student;
import com.gefe.microservices.services.MailService;
import com.gefe.microservices.services.PersonService;
import com.gefe.microservices.services.StudentService;

@RestController
@RequestMapping("/api/colegio")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private MailService mailService;
	
	@PostMapping("/estudiante")
	public Student createStudent(@Validated @RequestBody Student student) {
		
		Student newStudent = studentService.saveStudent(student);
		
		
		if (newStudent!=null) {
			
			mailService.sendEMail(newStudent.getEmail(), "Inscripcion Registrada", newStudent.toString());
		}

		return newStudent;
		
	}
	
	@GetMapping("/estudiantes")
	public List<Student> readStudent(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/estudiante/{id}")
	public Optional<Student> findStudent(@PathVariable String id) {
		return studentService.getStudent(id);
	}
	
	@PutMapping("/estudiante/{id}")
	public Student updateStudent(@PathVariable String id,@Validated @RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@DeleteMapping("/estudiante/{id}")
	public void deleteStudent(@PathVariable String id) {
		personService.deletePerson(id);
	}

}
