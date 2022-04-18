package com.theo.springjpa.repository;

import com.theo.springjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Custom JPA Methods
    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName, String lastName);

    // JPQL query - based on classes created not database
    @Query("select  s from Student s where s.emailId = ?1")
    Student getStudentByEmailId(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailId(String emailId);

    // Native SQL query - based on database created not classes
    @Query(
            value = "SELECT * " +
                    "FROM student_table AS s " +
                    "where s.email = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailIdNative(String emailId);

    @Query(
            value = "SELECT * " +
                    "FROM student_table AS s " +
                    "where s.email = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailIdNativeNamedParam(@Param("emailId") String emailId);

    // Update the db records
    @Modifying
    @Transactional
    @Query(
            value = "UPDATE student_table " +
                    "SET first_name = ?1 " +
                    "WHERE email = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);
}
