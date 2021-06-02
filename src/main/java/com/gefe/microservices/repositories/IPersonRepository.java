package com.gefe.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gefe.microservices.models.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person,String>{

}
