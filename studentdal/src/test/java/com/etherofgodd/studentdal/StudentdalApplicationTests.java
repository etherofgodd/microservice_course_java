package com.etherofgodd.studentdal;

import com.etherofgodd.studentdal.entities.Student;
import com.etherofgodd.studentdal.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentdalApplicationTests {

    @Autowired
    private StudentRepository studentRepository;


    @Test
    void testCreateStudent() {
        Student student = new Student();

        student.setName("Femi Cole");
        student.setFees(300_000.00);
        student.setCourse("Serverless using AWS Lambda");

        studentRepository.save(student);
    }

    @Test
    void testFindStudentById() {
        Student student = studentRepository.findById(1L).get();
        System.out.println(student);
    }

    @Test
    void testUpdateStudent() {
        Student student = studentRepository.findById(1L).get();
        student.setFees(40d);

        studentRepository.save(student);
    }

    @Test
    void testDeleteStudent() {
        studentRepository.deleteById(2L);
    }

}
