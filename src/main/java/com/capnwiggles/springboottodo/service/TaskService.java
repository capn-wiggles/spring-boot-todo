package com.capnwiggles.springboottodo.service;

import com.capnwiggles.springboottodo.dao.JpaTaskDao;
import com.capnwiggles.springboottodo.domain.Task;
import com.capnwiggles.springboottodo.domain.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final JpaTaskDao taskDao;

    @Autowired
    public TaskService(JpaTaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public void addTask(String name, Todo todo) {
        Task newTask = new Task(name, todo);
        taskDao.save(newTask);
    }

}
