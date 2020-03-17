package com.capnwiggles.springboottodo.controller;

import com.capnwiggles.springboottodo.domain.Todo;
import com.capnwiggles.springboottodo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/todo")
@RestController
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public void addTodo(@RequestBody Todo todo) {
        todoService.insertTodo(todo);
    }
}
