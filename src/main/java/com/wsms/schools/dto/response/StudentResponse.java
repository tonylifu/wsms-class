package com.wsms.schools.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentResponse {
    private String studentId;
    private String fullName;
    private String studentClass;
    private String isBoarder;
    private String currentBalance;
}
