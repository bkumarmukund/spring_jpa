package com.freemyip.c0de.dto;

import com.freemyip.c0de.entities.Enrollment;
import com.freemyip.c0de.entities.Student;

public record EnrolledStudent(
    Student student,
    Enrollment enrollment
) {
    
}
