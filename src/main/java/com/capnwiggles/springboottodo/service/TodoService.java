package com.capnwiggles.springboottodo.service;

import com.capnwiggles.springboottodo.dao.TodoDao;
import com.capnwiggles.springboottodo.domain.Task;
import com.capnwiggles.springboottodo.domain.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TodoService {

    private final TodoDao todoDao;

    @Autowired
    public TodoService(@Qualifier("inMemoryTodoDao") TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public void insertTodo(Todo todo) {
        UUID id = UUID.randomUUID();
        todoDao.insertTodo(id, todo);
    }

    public List<Todo> findAllTodos() {
        return todoDao.findAllTodos();
    }

    public Optional<Todo> findTodoById(UUID todoId) { return todoDao.findTodoByID(todoId); }

    public List<Task> showAllTasks(UUID todoId) { return todoDao.showAllTasks(todoId); }

    public boolean addTask(UUID todoId, String taskName) { return todoDao.addTask(todoId, taskName); }

    public Task findTaskById(UUID todoId, UUID taskId) {return todoDao.findTaskById(todoId, taskId); }

    public boolean setTaskDone(UUID todoId, UUID taskId) { return todoDao.setTaskDone(todoId, taskId); }
}
