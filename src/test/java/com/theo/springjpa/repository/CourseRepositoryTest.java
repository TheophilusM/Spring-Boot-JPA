package com.theo.springjpa.repository;

import com.theo.springjpa.entity.Course;
import com.theo.springjpa.entity.CourseMaterial;
import com.theo.springjpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courseList = courseRepository.findAll();
        System.out.println(courseList);
    }

    @Test
    public void saveCourseWithTeacherObject() {
        Teacher teacher =
                Teacher
                        .builder()
                        .firstName("Mark")
                        .lastName(("Smith"))
                        .build();
        Course course =
                Course
                        .builder()
                        .title("JUnit")
                        .credit(4)
                        .teacher(teacher)
                        .build();

        courseRepository.save(course);
    }
}