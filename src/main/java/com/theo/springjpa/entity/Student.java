package com.theo.springjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "student_table",
        uniqueConstraints = @UniqueConstraint(
                name = "emailId_unique",
                columnNames = "email"
        )
)
public class Student {

    @Id
    // auto increment in sequence
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;
    private String firstName;
    private String lastName;

    @Column(
            name = "email",
            nullable = false
    )
    private String emailId;

    // Using an embeddable Guardian Class
    private Guardian guardian;
}
