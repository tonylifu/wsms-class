package com.wsms.schools.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * This class contains details of failed messages and associated failure codes
 */
@RequiredArgsConstructor
@Getter
public enum SchoolError {

    CLASS_EMPTY_ERROR("0010", "class is empty or nonexistence"),
    INVALID_CLASS("0011", "invalid class"),
    INVALID_CLASS_LETTER("0012", "invalid class letter"),
    INVALID_YEAR("0013", "invalid year"),
    INVALID_TERM("0014", "invalid term"),
    SOMETHING_WENT_WRONG("0099", "something went wrong");

    private final String code;
    private final String description;

    @Override
    public String toString() {
        return code + ": " + description;
    }
}
