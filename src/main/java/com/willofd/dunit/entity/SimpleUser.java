package com.willofd.dunit.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

/**
 * @author Ivan Partola
 */

@Entity
@Table(name = "users")
@Data
@ToString
public class SimpleUser {
    public SimpleUser() {
        this.role = Roles.ROLE_USER.getValue();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;
}
