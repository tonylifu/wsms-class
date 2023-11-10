package com.wsms.schools.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SchoolApiErrorResponse {
    private boolean isError;
    private String errorMessage;
    private String errorCode;
    private String failureReason;
}
