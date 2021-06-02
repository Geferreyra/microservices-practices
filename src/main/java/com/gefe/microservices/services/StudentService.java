package com.gefe.microservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gefe.microservices.models.Student;
import com.gefe.microservices.repositories.IStudentRepository;

@Service
public class StudentService {
     
	@Autowired
	private IStudentRepository iStudentRepository;

	public Student saveStudent(Student student) {
		return iStudentRepository.save(student);
	}
	
	public List<Student>getAllStudents(){
		return iStudentRepository.findAll();
	}
	
	public Optional<Student> getStudent(String id) {
		return iStudentRepository.findById(id);
	}
	
}
