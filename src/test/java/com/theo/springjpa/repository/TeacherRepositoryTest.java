package com.theo.springjpa.repository;

import com.theo.springjpa.entity.Course;
import com.theo.springjpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        // can create a method to add a course to the course lists
        Course course1 = Course
                .builder()
                .title("Maths")
                .credit(10)
                .build();
        Course course2 = Course
                .builder()
                .title("English")
                .credit(10)
                .build();
            Course course3 = Course
                .builder()
                .title("Computers")
                .credit(10)
                .build();
            Course course4 = Course
                .builder()
                .title("Physics")
                .credit(10)
                .build();

        Teacher teacher = Teacher
                .builder()
                .firstName("John")
                .lastName("Doe")
                //.courses(List.of(course1,course2,course3,course4))
                .build();

        teacherRepository.save(teacher);
    }

}