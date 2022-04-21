package com.theo.springjpa.repository;

import com.theo.springjpa.entity.Course;
import com.theo.springjpa.entity.Guardian;
import com.theo.springjpa.entity.Student;
import com.theo.springjpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(0,3, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0,3, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(0,3,
                        Sort.by("title")
                                .descending()
                                .and(Sort.by("credit")));


        List<Course> sortByTitleCourses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("sortedCourses: " + sortByTitleCourses);
        List<Course> sortByCreditDescCourses = courseRepository.findAll(sortByCreditDesc).getContent();
        System.out.println("sortedCourses: " + sortByCreditDescCourses);
        List<Course> sortByTitleAndCreditDescCourses = courseRepository.findAll(sortByTitleAndCreditDesc).getContent();
        System.out.println("sortedCourses: " + sortByTitleAndCreditDescCourses);
    }

    @Test
    public void findByTitleContaining() {
        Pageable findByTitleContainingRecords = PageRequest.of(0,3);

        List<Course> findByTitleContainingRecordsCourses = courseRepository.findByTitleContaining("S", findByTitleContainingRecords).getContent();
        System.out.println("findByTitleContainingRecordsCourses: " + findByTitleContainingRecordsCourses);
    }

    @Test
    public void saveCourseithStudentAndTeacher() {
        Guardian guardian = Guardian
                .builder()
                .email("guardian@mail.com")
                .name("John Doe")
                .mobile("074748484554")
                .build();

        Student student = Student
                .builder()
                .emailId("takumug@gmail.com")
                .firstName("Taku")
                .lastName("Mat")
                .guardian(guardian)
                .build();

        Teacher teacher =
                Teacher
                        .builder()
                        .firstName("Mark")
                        .lastName("Smith")
                        .build();
        Course course =
                Course
                        .builder()
                        .title("JUnit")
                        .credit(4)
                        .teacher(teacher)
                        .build();

        course.addStudents(student);

        courseRepository.save(course);

        System.out.println("Done");
    }
}