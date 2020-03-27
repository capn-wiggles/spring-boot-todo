package com.capnwiggles.springboottodo.dao;

import com.capnwiggles.springboottodo.domain.Todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("todoDao")
public interface JpaTodoDao extends JpaRepository<Todo, Long> {
}