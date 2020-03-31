package com.capnwiggles.springboottodo.controller.api;

import com.capnwiggles.springboottodo.domain.Task;
import com.capnwiggles.springboottodo.domain.Todo;
import com.capnwiggles.springboottodo.service.TodoService;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TodoController {

    private final TodoService todoService;

    @PostMapping(path = "todo")
    public void addTodo(@RequestBody @Valid Todo todo) {
        todoService.insertTodo(todo);
    }

    @PostMapping(path = "todo/{id}")
    public void addTask(@PathVariable("id") Long todoId, @RequestParam String task) {
        todoService.addTask(todoId, task);
    }

    @GetMapping
    public List<Todo> findAllTodos() {
        return todoService.findAllTodos();
    }

    @GetMapping(path = "todo/{id}")
    public Todo findTodoById(@PathVariable("id") Long todoId) {
        return todoService.findTodoById(todoId).orElse(null);
    }

    @GetMapping(path = "todo/{id}/tasks")
    public List<Task> showAllTasks(@PathVariable("id") Long todoId) {
        return todoService.showAllTasks(todoId);
    }
}
