package com.theo.springjpa.repository;

import com.theo.springjpa.entity.Guardian;
import com.theo.springjpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static java.lang.Long.valueOf;

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
                .lastName("Mug")
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

    @Test
    public void getStudentByFisrtName() {
        List<Student> studentList = studentRepository.findByFirstName("Theo");
        System.out.println(studentList);
    }

    @Test
    public void getStudentContainingFisrtNameLetter() {
        List<Student> studentList = studentRepository.findByFirstNameContaining("T");
        System.out.println(studentList);
    }

    @Test
    public void getStudentContainingLastNameLetter() {
        List<Student> studentList = studentRepository.findByLastNameNotNull();
        System.out.println(studentList);
    }

    @Test
    public void getStudentByGuardianName() {
        List<Student> studentList = studentRepository.findByGuardianName("John Doe");
        System.out.println(studentList);
    }

    @Test
    public void getStudentByFirstAndLastName() {
        Student student= studentRepository.findByFirstNameAndLastName("Taku", "Mat");
        System.out.println(student);
    }

    @Test
    public void findStudentByEmailJPQL() {
        Student student= studentRepository.getStudentByEmailId("takumug@gmail.com");
        System.out.println(student);
    }

    @Test
    public void getStudentFirstNameJPQL() {
        String firstName= studentRepository.getStudentFirstNameByEmailId("takumug@gmail.com");
        System.out.println(firstName);
    }

    @Test
    public void getStudentFirstNameNative() {
        Student firstName= studentRepository.getStudentByEmailIdNative("takumug@gmail.com");
        System.out.println(firstName);
    }

    @Test
    public void getStudentByEmailIdNativeNamedParam() {
        Student firstName= studentRepository.getStudentByEmailIdNative("takumug@gmail.com");
        System.out.println(firstName);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        int i = studentRepository.updateStudentNameByEmailId(
                "Takudwanashe", "takumug@gmail.com");
        System.out.println("Updated: " + i);
    }
}