package com.example.demo.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "roll_no")
	private String rollNo;
	
	
	@Column(name = "cgpa")
	private String cgpa;
	
	public Student() {
		
	}

	
	public Student(Student student ) {
		this.name=student.name;
		this.rollNo=student.rollNo;
		this.cgpa=student.cgpa;
	}
	
	public Student(String name, String rollNo, String cgpa) {
		this.name = name;
		this.rollNo = rollNo;
		this.cgpa = cgpa;
	}

	public Student(String name, String rollNo, String cgpa, int id)
	{
		this.name = name;
		this.rollNo = rollNo;
		this.id=id;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getCgpa() {
		return cgpa;
	}

	public void setCgpa(String cgpa) {
		this.cgpa = cgpa;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", rollNo=" + rollNo + ", cgpa=" + cgpa + "]";
	}
	
	
}
