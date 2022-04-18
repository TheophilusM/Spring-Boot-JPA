package com.theo.springjpa.repository;

import com.theo.springjpa.entity.Guardian;
import com.theo.springjpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static java.lang.Long.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest        // ideal
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {

        Student student = Student
                .builder()
                .emailId("theotakumug@gmail.com")
                .firstName("Theo")
                .lasstName("Mug")
                //.guardianEmail("guardian@mail.com")
                //.guardianMobile("074748484554")
                //.guardianName("John Doe")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian
                .builder()
                .email("guardian@mail.com")
                .name("074748484554")
                .mobile("John Doe")
                .build();

        Student student = Student
                .builder()
                .emailId("takumug@gmail.com")
                .firstName("Taku")
                .lasstName("Mat")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void getStudentByID() {
        Student student = studentRepository.findById(valueOf(1)).get();
        System.out.println(student);
    }

}