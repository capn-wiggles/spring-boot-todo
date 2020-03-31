package com.capnwiggles.springboottodo.dao;

import com.capnwiggles.springboottodo.domain.Task;
import com.capnwiggles.springboottodo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("taskDao")
public interface JpaTaskDao extends JpaRepository<Task, Long> {
}