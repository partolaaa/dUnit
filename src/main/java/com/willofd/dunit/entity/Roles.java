package com.willofd.dunit.entity;

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
