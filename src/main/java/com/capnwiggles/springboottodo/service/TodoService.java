package com.capnwiggles.springboottodo.service;

import com.capnwiggles.springboottodo.dao.JpaTaskDao;
import com.capnwiggles.springboottodo.dao.JpaTodoDao;
import com.capnwiggles.springboottodo.domain.Task;
import com.capnwiggles.springboottodo.domain.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TodoService {

    private final JpaTodoDao todoDao;
    private final TaskService taskService;

    @Autowired
    public TodoService(JpaTodoDao todoDao, TaskService taskService) {
        this.todoDao = todoDao;
        this.taskService = taskService;
    }

    public void insertTodo(Todo todo) {
        todoDao.save(todo);
    }

    public List<Todo> findAllTodos() {
        return todoDao.findAll();
    }

    public Optional<Todo> findTodoById(Long todoId) {
        return todoDao.findById(todoId);
    }

    public List<Task> showAllTasks(Long todoId) {
        Optional<Todo> optionalTodo = todoDao.findById(todoId);
        return optionalTodo.isPresent() ? optionalTodo.get().getTasks() : Collections.emptyList();
    }

    public boolean addTask(Long todoId, String taskName) {
        Optional<Todo> optionalTodo = todoDao.findById(todoId);
        if (optionalTodo.isPresent()) {
            taskService.addTask(taskName, optionalTodo.get());
            return true;
        }
        return false;
    }
}
