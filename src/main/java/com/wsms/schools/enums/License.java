package com.wsms.schools.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * represents license status of schools
 */
public enum License {
    TRIAL, EXPIRED, ACTIVE, DEACTIVATED, DELETED, UNKNOWN;

    private static final Map<String, License> LICENSE_MAP = new HashMap<>();

    static {
        for (License license : values()) {
            LICENSE_MAP.put(license.name().toLowerCase(), license);
        }
    }

    public static License fromStringValue(String value) {
        if (Objects.isNull(value)) {
            return UNKNOWN;
        }
        var result = LICENSE_MAP.get(value.trim().toLowerCase());
        return result != null ? result : UNKNOWN;
    }
}
