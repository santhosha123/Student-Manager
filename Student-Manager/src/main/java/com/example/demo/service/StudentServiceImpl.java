package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.error.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepo studentRepo ;

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student addStudent(Student s) {
		return studentRepo.save(s);
	}


	@Override
	public void deleteStudent(int id) {
		studentRepo.deleteById(id);
		
	}

	@Override
	public Student getStudentById(int i) throws StudentNotFoundException {
		Optional<Student> student=studentRepo.findById(i);
		if(!student.isPresent()) {
			throw new StudentNotFoundException();
		}
			return student.get();
	}

	@Override
	public Student getStudentByName(String name) throws StudentNotFoundException  {
		Optional<Student> student=studentRepo.findByName(name);

		if(!student.isPresent()) {
			throw new StudentNotFoundException();
		}
		return student.get();
	}

	@Override
	public Student updateStudent(Student s) {
		return studentRepo.save(s);
	}


	

}
