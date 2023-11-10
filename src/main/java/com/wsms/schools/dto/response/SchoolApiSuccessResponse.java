package com.wsms.schools.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SchoolApiSuccessResponse {
    private Long schoolId;
    private String statusMessage;
    private String statusCode;
    private String license;
}
