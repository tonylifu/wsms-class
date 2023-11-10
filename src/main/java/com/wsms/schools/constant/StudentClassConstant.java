package com.wsms.schools.constant;


import com.wsms.schools.dto.response.SchoolApiErrorResponse;
import com.wsms.schools.dto.response.SchoolApiSuccessResponse;

/**
 * holds constant values that are related to school application wide
 */
public class StudentClassConstant {

    private StudentClassConstant(){}

    /**
     * generates success response for school related operations
     * @param schoolId
     * @param statusMessage
     * @param statusCode
     * @return {@link SchoolApiSuccessResponse}
     */
    public static SchoolApiSuccessResponse getSchoolApiSuccessResponse(Long schoolId, String statusMessage, String statusCode, String license) {
        return SchoolApiSuccessResponse.builder()
                .schoolId(schoolId)
                .statusMessage(statusMessage)
                .statusCode(statusCode)
                .license(license)
                .build();
    }

    /**
     * generates error response for school related operations
     * @param errorMessage
     * @param errorCode
     * @param failureReason
     * @return {@link SchoolApiErrorResponse}
     */
    public static SchoolApiErrorResponse getSchoolApiErrorResponse(String errorMessage, String errorCode, String failureReason) {
        return SchoolApiErrorResponse.builder()
                .isError(Boolean.TRUE)
                .errorMessage(errorMessage)
                .errorCode(errorCode)
                .failureReason(failureReason)
                .build();
    }
}
