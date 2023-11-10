package com.wsms.schools.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * This class contains details of success messages and associated success codes
 */
@RequiredArgsConstructor
@Getter
public enum SchoolSuccess {
    SUCCESS("00", "Successful");

    private final String code;
    private final String description;

    @Override
    public String toString() {
        return code + ": " + description;
    }
}