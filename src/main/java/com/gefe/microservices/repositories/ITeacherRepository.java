package com.gefe.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gefe.microservices.models.Teacher;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher,String> {

}
