package com.test.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Student 
{
	
	@Id
	//@Column(name = "SID")
	private Integer sId;
	
	//@Column(name = "SNAME")
	private String sName;
	 
	//@Transient
	//@Column(name = "SCITY")
	private String sCity;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Courses> courses;
	
	public Student(){
		System.out.println("Zero Param Constructor of Students");
	}
	
	
	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsCity() {
		return sCity;
	}

	public void setsCity(String sCity) {
		this.sCity = sCity;
	}

	public Set<Courses> getCourses() {
		return courses;
	}


	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}
	
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", sCity=" + sCity + ", courses=" + courses + "]";
	}
	
}
