package com.capnwiggles.springboottodo.dao;

import com.capnwiggles.springboottodo.domain.Task;
import com.capnwiggles.springboottodo.domain.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("InMemoryTodoDao")
public class InMemoryTodoDao implements TodoDao {

    List<Todo> todos;

    public InMemoryTodoDao() {
        this.todos = new ArrayList<>();
        this.todos.add(new Todo("First todo", "first description"));
        this.todos.add(new Todo("Second todo", "second description"));
    }

    @Override
    public List<Todo> findAllTodos() {
        return todos;
    }

    @Override
    public Todo findTodoByID(UUID todoId) {
        for (Todo t : todos) {
            if (t.getTodoID() == todoId) { return t; }
        }
        return null;
    }

    @Override
    public List<Task> showAllTasks(UUID todoId) {
        for (Todo t : todos) {
            if (t.getTodoID() == todoId) { return t.getTasks(); }
        }
        return null;
    }

    @Override
    public boolean insertTodo(UUID todoID, Todo todo) {
        todos.add(new Todo(todoID, todo.getName(), todo.getDescription()));
        return true;
    }
}
