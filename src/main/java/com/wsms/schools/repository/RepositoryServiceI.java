package com.wsms.schools.repository;

import com.wsms.schools.dto.response.SchoolApiErrorResponse;
import com.wsms.schools.entity.Student;
import io.vavr.control.Either;
import java.util.List;

public interface RepositoryServiceI {
    Either<SchoolApiErrorResponse, List<Student>> getStudents(String assignedClass);

    String getStudentBalance(String id);
}
