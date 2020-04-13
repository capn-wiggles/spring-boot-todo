package com.capnwiggles.springboottodo.dao;

import com.capnwiggles.springboottodo.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleDao")
public interface JpaRoleDao extends JpaRepository<Role, Long> {
}
