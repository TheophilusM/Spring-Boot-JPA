package com.theo.springjpa.repository;

import com.theo.springjpa.entity.Course;
import com.theo.springjpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {
        Course course =
                Course
                        .builder()
                        .title("Docker")
                        .credit(6)
                        .build();

        CourseMaterial courseMaterial =
                CourseMaterial
                        .builder()
                        .url("www.Docker.101/url")
                        .course(course)
                        .build();

        courseMaterialRepository.save(courseMaterial);
    }
}