package com.wsms.schools.service;

import com.wsms.schools.constant.StudentClassConstant;
import com.wsms.schools.dto.request.GetClassStudentRequest;
import com.wsms.schools.dto.response.ClassStudentResponse;
import com.wsms.schools.dto.response.SchoolApiErrorResponse;
import com.wsms.schools.dto.response.StudentResponse;
import com.wsms.schools.entity.Student;
import com.wsms.schools.enums.SchoolError;
import com.wsms.schools.model.StudentClassModel;
import com.wsms.schools.repository.RepositoryServiceI;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class StudentClassService implements StudentClassModel {
    private final RepositoryServiceI repositoryService;

    @Override
    public Either<SchoolApiErrorResponse, ClassStudentResponse> getStudentClass(GetClassStudentRequest classStudentRequest) {
        log.info("----in get students in a class-----");
        var validateParams = validateGetStudentParams(classStudentRequest);
        if (validateParams.isLeft()) {
            return Either.left(validateParams.getLeft());
        }
        String assignedClass = String.format("%s"+"%s"+"%s"+"%s",
                classStudentRequest.getClassId(), classStudentRequest.getClassAlphabeth(),
                classStudentRequest.getYear(),classStudentRequest.getTerm());
        log.info("=== {} ===", assignedClass);
        return repositoryService.getStudents(assignedClass)
                .map(this::buildStudentClassResponse);
    }

    private Either<SchoolApiErrorResponse, Boolean> validateGetStudentParams(GetClassStudentRequest classStudentRequest) {
        if (Strings.isBlank(classStudentRequest.getClassId())) {
            return Either.left(StudentClassConstant.getSchoolApiErrorResponse(
                    SchoolError.INVALID_CLASS.getDescription(),
                    SchoolError.INVALID_CLASS.getCode(), "invalid student class"));
        }

        if (Strings.isBlank(classStudentRequest.getClassAlphabeth())) {
            return Either.left(StudentClassConstant.getSchoolApiErrorResponse(
                    SchoolError.INVALID_CLASS_LETTER.getDescription(),
                    SchoolError.INVALID_CLASS_LETTER.getCode(), "invalid student class letter"));
        }

        if (Strings.isBlank(classStudentRequest.getYear())) {
            return Either.left(StudentClassConstant.getSchoolApiErrorResponse(
                    SchoolError.INVALID_YEAR.getDescription(),
                    SchoolError.INVALID_YEAR.getCode(), "invalid year"));
        }

        if (Strings.isBlank(classStudentRequest.getTerm())) {
            return Either.left(StudentClassConstant.getSchoolApiErrorResponse(
                    SchoolError.INVALID_TERM.getDescription(),
                    SchoolError.INVALID_TERM.getCode(), "invalid term"));
        }

        return Either.right(Boolean.TRUE);
    }

    /**
     * maps List of Students to response class
     * @param students
     * @return {@link ClassStudentResponse}
     */
    private ClassStudentResponse buildStudentClassResponse(List<Student> students) {
//        log.info("\n\n:::: \n{}\n ::::\n\n", students);

        List<StudentResponse> studentResponses = new ArrayList<>();
        students.forEach(std -> {
            studentResponses.add(StudentResponse.builder()
                            .studentClass(std.getEntryClassAssigned())
                            .studentId(std.getId())
                            .currentBalance(repositoryService.getStudentBalance(std.getId()))
                            .fullName(std.getOtherNames()+" "+std.getSurName())
                            .isBoarder(std.getEntryBorderStatus())

                    .build());
        });
        return ClassStudentResponse.builder()
                .isError(Boolean.FALSE)
                .classStudentResponse(studentResponses)
                .build();
    }

}
