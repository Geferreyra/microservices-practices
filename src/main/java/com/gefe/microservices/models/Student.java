package com.gefe.microservices.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity(name="Student")
@Table(name="\"Students\"",schema="public")
@OnDelete(action= OnDeleteAction.CASCADE)
//A eliminar un estudiante tambien se elimina sus datos de la clase padre
public class Student extends Person implements Serializable {

	private static final long serialVersionUID =1L;
	
	@PrimaryKeyJoinColumn(name= "id", foreignKey=@ForeignKey(name="fk_student_"))
	//indica la relacion 1 a 1 , siendo id primaria y foranea
	
	//Beca
	@Column(name="schoolarship", columnDefinition="boolean DEFAULT 'false'")
	private Boolean schoolarship = false;
	
	//state 1= inscripto, 2 retirado, 3 graduadp
	@Column(name="state", columnDefinition="integer DEFAULT '1'")
	private Integer state = 1;

	
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name= "\"StudentCourse\"",
			
			joinColumns= @JoinColumn(name="student_id", referencedColumnName="id"//,
					
				//	,foreignKey=@ForeignKey(name="fk_student_course"
//					
//					foreignKeyDefinition="FOREIGN KEY (student_id)\r\n"
//							+ " REFERENCES public.\"Students\" (id) MATCH SIMPLE\r\n"
//							+ "  ON UPDATE CASCADE\r\n"
//							+ "  ON DELETE CASCADE",
//							value=ConstraintMode.CONSTRAINT
//							
					//		)
			  ),
			//configurar la relacion inversa ,haciendo referencia a la entidad curso
			inverseJoinColumns= @JoinColumn(name="course_key", referencedColumnName="key"//,
					
					//foreignKey=@ForeignKey(name="fk_student_course"//,
//					
//					foreignKeyDefinition="FOREIGN KEY (course_key)\r\n"
//							+ " REFERENCES public.\"Courses\" (key) MATCH SIMPLE\r\n"
//							+ "  ON UPDATE CASCADE\r\n"
//							+ "  ON DELETE CASCADE",
//							value=ConstraintMode.CONSTRAINT
//							
						//	)
			    ),
	
			uniqueConstraints= @UniqueConstraint(name="composite_key", columnNames= {"student_id","course_key"})
			)
	private List<Course> enrolled_courses;
	
	public Boolean getSchoolarship() {
		return schoolarship;
	}

	public void setSchoolarship(Boolean schoolarship) {
		this.schoolarship = schoolarship;
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

	public List<Course> getEnrolled_course() {
		return enrolled_courses;
	}

	public void setEnrolled_course(List<Course> enrolled_course) {
		this.enrolled_courses = enrolled_course;
	}

	@Override
	public String toString() {
		
		String schoolarship_description="";
		String state_description="";
		
		if(schoolarship) {
			schoolarship_description="Aplica";
		}else {
			schoolarship_description="No aplica";
		}
		
		if(state==1) {
			state_description="Inscripto";
		}else {
			state_description="No inscripto";
		}
		
		
		
		
		
		return "Estudiante:"+"  \nId: " + getId() + "  \nNombre: " + getName() + "  \nEmail: "
				+ getEmail() +"  \nBeca:" + schoolarship_description + "  \nEstado:" + state_description+  "\nCursos: "+enrolled_courses;
	}

				

	
	
}
