package com.theo.springjpa.repository;

import com.theo.springjpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

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
                .guardianEmail("guardian@mail.com")
                .guardianMobile("074748484554")
                .guardianName("John Doe")
                .build();

        studentRepository.save(student);
    }

}