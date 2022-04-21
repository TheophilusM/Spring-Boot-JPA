package com.theo.springjpa.repository;

import com.theo.springjpa.entity.Course;
import com.theo.springjpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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

    @Test
    public void findAllPagination() {
        Pageable pageable3 = PageRequest.of(0,3);
        // Pageable pageable2 = PageRequest.of(1,2);

        long totalElements = courseRepository.findAll(pageable3).getTotalElements();
        long totalPages = courseRepository.findAll(pageable3).getTotalPages();

        List<Course> courses = courseRepository.findAll(pageable3).getContent();
        System.out.println("courses: " + courses);
        System.out.println("totalElements: " + totalElements);
        System.out.println("totalPages: " + totalPages);
    }
}