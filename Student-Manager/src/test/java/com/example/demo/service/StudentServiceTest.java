package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.error.StudentNotFoundException;
import com.example.demo.repository.StudentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class StudentServiceTest {
    @MockBean
 private StudentRepo studentRepo;
    @BeforeEach
    void setUp()
    {
        Student student=new Student("Batman",
            "20csr186",
            "90");
        Mockito.when(studentRepo.findByName("Batman")).thenReturn(Optional.of(student));
        Mockito.when(studentRepo.findAll()).thenReturn(Stream.of(new Student("S","1","89"),new Student("A","2","67")).collect(Collectors.toList()));
    }

    @Autowired
    private StudentService studentService;
    @Test
    @DisplayName("Get data based on name")
    public void when_student_name_matches_display_student() throws StudentNotFoundException {
        String  name="Batman";
        Student found=studentService.getStudentByName(name);
        assertEquals(name,found.getName());

    }
    @Test
    public void get_all_students_test()
    {
        List<Student> getall=studentService.getAllStudents();
        assertEquals(2,getall.size());

    }
    @Test
    public void delete_student_test()
    {
        Student student=new Student("B",
                "20c",
                "90");
        studentService.deleteStudent(1);
        studentService.deleteStudent(1);
        verify(studentRepo,times(2)).deleteById(1);
    }
}