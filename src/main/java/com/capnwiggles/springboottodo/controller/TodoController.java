package com.capnwiggles.springboottodo.controller;

import com.capnwiggles.springboottodo.domain.Task;
import com.capnwiggles.springboottodo.domain.Todo;
import com.capnwiggles.springboottodo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @PostMapping(path = "id/{id}")
    public void addTask(@PathVariable("id") UUID todoId, @RequestBody String taskName) {
        todoService.addTask(todoId, taskName);
    }

    @PostMapping(path = "id/{id}/tasks/{taskId}/done")
    public void setTaskDone(@PathVariable("id") UUID todoId, @PathVariable("taskId") UUID taskId) {
        todoService.setTaskDone(todoId, taskId);
    }

    @GetMapping
    public List<Todo> findAllTodos() {
        return todoService.findAllTodos();
    }

    @GetMapping(path = "id/{id}")
    public Todo findTodoById(@PathVariable("id") UUID todoId) {
        return todoService.findTodoById(todoId).orElse(null);
    }

    @GetMapping(path = "/id/{id}/tasks")
    public List<Task> showAllTasks(@PathVariable("id") UUID todoId) {
        return todoService.showAllTasks(todoId);
    }

    @GetMapping(path = "/id/{id}/tasks/{taskId}")
    public Task findTaskById(@PathVariable("id") UUID todoId, @PathVariable("taskId") UUID taskId) {
        return todoService.findTaskById(todoId, taskId);
    }
}
