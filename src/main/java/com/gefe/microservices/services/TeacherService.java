package com.gefe.microservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gefe.microservices.models.Teacher;
import com.gefe.microservices.repositories.ITeacherRepository;

@Service
public class TeacherService {

	@Autowired
	private ITeacherRepository ITeacherRepository;

	public Teacher saveTeacher(Teacher teacher) {
		return ITeacherRepository.save(teacher);
	}
	
	public List<Teacher>getAllTeacher(){
		return ITeacherRepository.findAll();
	}
	
	
	public Optional<Teacher> getTeacher(String id) {
		return ITeacherRepository.findById(id);
	}

}
