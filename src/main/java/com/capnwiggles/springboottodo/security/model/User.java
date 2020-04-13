package com.capnwiggles.springboottodo.domain.auth;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String username;

    private String email;

    @Column(name = "password_digest", columnDefinition = "varchar(60) not null")
    private String password;

    @OneToOne
    private Role role;
}
