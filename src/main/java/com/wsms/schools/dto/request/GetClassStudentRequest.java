package com.wsms.schools.dto.request;

import lombok.Data;

@Data
public class GetClassStudentRequest {
    private String classId;
    private String classAlphabeth;
    private String year;
    private String term; //[1,2,3]
}
