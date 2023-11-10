package com.wsms.schools.controller;

import com.wsms.schools.dto.request.GetClassStudentRequest;
import com.wsms.schools.model.StudentClassModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StudentClassController {
    private final StudentClassModel studentClassModel;

    public static final String STUDENT_CLASS_PATH = "/api/v1/classes/students";
    public static final String STUDENT_CLASS_TEST = "/api/v1/classes/test";

    @RequestMapping(
            value = STUDENT_CLASS_PATH,
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public HttpEntity<?> getStudentClass(final @RequestBody GetClassStudentRequest getClassStudentRequest) {
        return studentClassModel
                .getStudentClass(getClassStudentRequest)
                .fold(errorResponse -> new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST),
                response -> new ResponseEntity<>(response, HttpStatus.OK));
    }

    @RequestMapping(value = STUDENT_CLASS_TEST, method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public String test(){
        return """
                {
                    "isOkay": true
                }
                """;
    }
}
