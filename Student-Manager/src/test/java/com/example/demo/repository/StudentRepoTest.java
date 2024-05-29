package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;


@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class StudentRepoTest {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private TestEntityManager entityManager;
    @BeforeEach
    void setUp() {
        Student student=new Student("Robin",
                "20MSR186",
                "99");
        entityManager.persist(student);
    }
//    @Test
//    public void when_findByName_then_display_Student()
//    {
//        Student student=studentRepo.findByName("Robin");
//        assertEquals(student.getName(),"Robin");
//    }
}