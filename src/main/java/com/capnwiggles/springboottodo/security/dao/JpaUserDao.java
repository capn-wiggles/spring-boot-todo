package com.capnwiggles.springboottodo.dao;

import com.capnwiggles.springboottodo.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface JpaUserDao extends JpaRepository<User, Long> {
}
