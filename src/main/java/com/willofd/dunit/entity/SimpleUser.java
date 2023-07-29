package com.willofd.dunit.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author Ivan Partola
 */

@Entity
@Table(name = "users")
@Data
@ToString
public class SimpleUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "banned", nullable = false, columnDefinition = "boolean default false")
    private Boolean banned = false;

    @Column(name = "role", nullable = false, columnDefinition = "varchar(50) default 'ROLE_USER'")
    private String role = "ROLE_USER";

    @Column(name = "active", nullable = false, columnDefinition = "boolean default true")
    private Boolean active = true;

    @Column(name = "total_transactions", nullable = false, columnDefinition = "int default 0")
    private Integer totalTransactions = 0;

    @Column(name = "balance", nullable = false, columnDefinition = "decimal(10, 2) default 0.00")
    private BigDecimal balance = BigDecimal.valueOf(0.00);

    @Column(name = "rating", nullable = false, columnDefinition = "decimal(3, 2) default 0")
    private Double rating = 0.0;

    @Column(name = "registered_at", nullable = false, columnDefinition = "timestamp default current_timestamp")
    private Timestamp registeredAt = new Timestamp(System.currentTimeMillis());

    @Column(name = "created_at", nullable = false, columnDefinition = "timestamp default current_timestamp")
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

    @Column(name = "profile")
    private String profile;
}

