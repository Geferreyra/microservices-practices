package com.gefe.microservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gefe.microservices.repositories.IPersonRepository;

@Service
public class PersonService {

	@Autowired
	private IPersonRepository IPersonRepository;
	
	public void deletePerson(String id) {
		IPersonRepository.deleteById(id);
	}
}
