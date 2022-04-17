package com.theo.springjpa.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id
    private Long studentId;
    private String firstName;
    private String emailId;
    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;
}
