package com.wsms.schools.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClassStudentResponse {
    private boolean isError;
    private List<StudentResponse> classStudentResponse;
}