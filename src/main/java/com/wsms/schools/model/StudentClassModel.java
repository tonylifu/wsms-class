package com.wsms.schools.model;

import com.wsms.schools.dto.request.GetClassStudentRequest;
import com.wsms.schools.dto.response.ClassStudentResponse;
import com.wsms.schools.dto.response.SchoolApiErrorResponse;
import io.vavr.control.Either;

/**
 * This provides functionalities for reading student from class
 */
public interface StudentClassModel {

    /**
     * this creates a new school entity
     * @param classStudentRequest
     * @return {@link Either<SchoolApiErrorResponse, ClassStudentResponse>}
     */
    Either<SchoolApiErrorResponse, ClassStudentResponse> getStudentClass(GetClassStudentRequest classStudentRequest);

}
