package com.willofd.dunit.models;

import lombok.RequiredArgsConstructor;

/**
 * @author Ivan Partola
 */
@RequiredArgsConstructor
public enum Roles {
    ROLE_USER("ROLE_USER"),
    ROLE_ADMIN("ROLE_ADMIN");

    private final String role;

    public String getValue() {
        return role;
    }
}
