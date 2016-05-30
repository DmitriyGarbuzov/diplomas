package com.diplomas.entity;

import com.diplomas.entity.enumeration.Role;

import javax.persistence.*;

/**
 * Created by Dima on 30.05.2016.
 */
@Entity
@Table(name="users")
public class User extends BaseEntity{
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
}
