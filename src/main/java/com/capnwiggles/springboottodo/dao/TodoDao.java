package com.capnwiggles.springboottodo.dao;

import com.capnwiggles.springboottodo.domain.Task;
import com.capnwiggles.springboottodo.domain.Todo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoDao {

    List<Todo> findAllTodos();

    Optional<Todo> findTodoByID(UUID todoId);

    List<Task> showAllTasks(UUID todoId);

    boolean addTask(UUID todoId, String taskName);

    boolean setTaskDone(UUID todoId, UUID taskId);

    Task findTaskById(UUID todoId, UUID taskId);

    boolean insertTodo(UUID todoID, Todo todo);

    default boolean addTodo(Todo todo) {
        UUID id = UUID.randomUUID();
        return insertTodo(id, todo);
    }
}
