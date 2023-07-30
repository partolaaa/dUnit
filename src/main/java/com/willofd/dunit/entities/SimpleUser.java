package com.willofd.dunit.entities;

import com.willofd.dunit.models.Currencies;
import com.willofd.dunit.models.Roles;
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

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "banned", nullable = false, columnDefinition = "boolean default false")
    private Boolean banned;

    @Column(name = "role", nullable = false, columnDefinition = "varchar(50) default 'ROLE_USER'")
    private String role;

    @Column(name = "active", nullable = false, columnDefinition = "boolean default true")
    private Boolean active;

    @Column(name = "total_transactions", nullable = false, columnDefinition = "int default 0")
    private Integer totalTransactions;

    @Column(name = "balance", nullable = false, columnDefinition = "decimal(10, 2) default 0.00")
    private BigDecimal balance;

    @Column(name = "currency", nullable = false, columnDefinition = "varchar(3) default 'USD'")
    private String currency;

    @Column(name = "rating", nullable = false, columnDefinition = "decimal(3, 2) default 0")
    private Double rating;

    @Column(name = "registered_at", nullable = false, columnDefinition = "timestamp default current_timestamp")
    private Timestamp registeredAt;

    @Column(name = "created_at", nullable = false, columnDefinition = "timestamp default current_timestamp")
    private Timestamp createdAt;

    @Column(name = "profile")
    private String profile;

    @PrePersist
    public void prePersist() {
        name = "dUser" + (id != null ? id.hashCode() : System.currentTimeMillis());
        banned = false;
        role = Roles.ROLE_USER.getValue();
        active = true;
        totalTransactions = 0;
        balance = BigDecimal.valueOf(0.00);
        currency = Currencies.USD.getValue();
        rating = 0.0;
        registeredAt = new Timestamp(System.currentTimeMillis());
        createdAt = new Timestamp(System.currentTimeMillis());
    }
}

