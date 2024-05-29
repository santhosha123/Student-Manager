package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

	void deleteById(int i);
	Optional<Student> findById(int id);

	public Optional<Student> findByName(String name);
}
