package com.test.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="StudentTable")
public class StudentHQL
{
	
	@Id
	private Integer sId;
	
	private String sName;
	 
	private String sCity;
	
	public StudentHQL(){
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

	
	@Override
	public String toString() {
		return "StudentHQL [sId=" + sId + ", sName=" + sName + ", sCity=" + sCity + "]";
	}
	
}
