package com.capnwiggles.springboottodo.domain.auth;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String role;

    @OneToOne(mappedBy = "role")
    User user;
}
