package com.example.demo.controller;

import java.util.List;

import com.example.demo.error.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/Student")
public class StudentController {
	@Autowired
	StudentService service ;

	@GetMapping("/list")
	public List<Student> getAllStudents(){
		List<Student> arr=service.getAllStudents();
		return arr;
	}
	
	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student ){
		System.out.println(student);
		Student student2=service.addStudent(student);
		return student2;
	}
	
	@PutMapping("/update/{id}")
	public Student updateStudent(@PathVariable("id")int id, @RequestBody Student student ) throws StudentNotFoundException {
		Student student2 =service.getStudentById(id);
		student2.setCgpa(student.getCgpa());
		student2.setName(student.getName());
		student2.setRollNo(student.getRollNo());
		Student student3 = service.updateStudent(student2);
		return student3;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") int id){
		service.deleteStudent(id);
		return "Deleted Successfully";
	}
	
	@RequestMapping("/get/{id}")
	public Student getStudent(@PathVariable("id")int id) throws StudentNotFoundException {
		return service.getStudentById(id);
	}

	@RequestMapping("/getbyname/{name}")
	public Student getStudentByName(@PathVariable("name") String name) throws StudentNotFoundException {
		return service.getStudentByName(name);
	}
}
