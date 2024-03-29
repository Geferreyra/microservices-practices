package com.gefe.microservices.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name="Teacher")
@Table(name="\"Teachers\"", schema="public")

@OnDelete(action=OnDeleteAction.CASCADE)
public class Teacher extends Person implements Serializable {
	
	private static final long serialVersionUID= 1L;

	@PrimaryKeyJoinColumn(name="id", foreignKey=@ForeignKey(name="fk_teacher_"))
	
	//Titulo,licenciatura
	@Column(name="degree",nullable=false)
	private String degree;
	
	@Column(name="salary",nullable=false)
	private double salary;
	
	@Column(name="state",columnDefinition="integer DEFAULT '1'")
	private Integer state=1;
	
	@JsonIdentityInfo(
			
			generator= ObjectIdGenerators.PropertyGenerator.class,
			property= "key"
			)
	@JsonIdentityReference(alwaysAsId=true)
	
	//por parametro pasamos el obejto teacher que esta dentro de curso
	@OneToMany(mappedBy="teacher" ,fetch= FetchType.LAZY,cascade= CascadeType.ALL,orphanRemoval=true)
	private List<Course> courses;

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

//	@Override
//	public String toString() {
//		return "Teacher [degree=" + degree + ", salary=" + salary + ", state=" + state + ", courses=" + courses
//				+ ", getId()=" + getId() + ", getName()=" + getName() + ", getGender()=" + getGender() + ", getEmail()="
//				+ getEmail() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
//				+ super.toString() + "]";
//	}

	@Override
	public String toString() {
		return "  \niId: " + getId() + "  \nTit: " + degree + "  Nombre: "
				+ getName() + "  \nEmail: " + getEmail();
	}




	

}
