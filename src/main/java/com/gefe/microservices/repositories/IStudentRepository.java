package com.gefe.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gefe.microservices.models.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student,String> {

}
