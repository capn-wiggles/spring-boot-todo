package com.capnwiggles.springboottodo.dao;

import com.capnwiggles.springboottodo.domain.Task;
import com.capnwiggles.springboottodo.domain.Todo;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PostgresDao implements TodoDao {

    @Override
    public List<Todo> findAllTodos() {
        return null;
    }

    @Override
    public Optional<Todo> findTodoByID(UUID todoId) {
        return Optional.empty();
    }

    @Override
    public List<Task> showAllTasks(UUID todoId) {
        return null;
    }

    @Override
    public boolean addTask(UUID todoId, String taskName) {
        return false;
    }

    @Override
    public boolean setTaskDone(UUID todoId, UUID taskId) {
        return false;
    }

    @Override
    public Task findTaskById(UUID todoId, UUID taskId) {
        return null;
    }

    @Override
    public boolean insertTodo(UUID todoID, Todo todo) {
        return false;
    }
}
