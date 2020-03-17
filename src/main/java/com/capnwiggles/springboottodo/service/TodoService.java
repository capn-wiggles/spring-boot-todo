package com.capnwiggles.springboottodo.service;

import com.capnwiggles.springboottodo.dao.TodoDao;
import com.capnwiggles.springboottodo.domain.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TodoService {

    private final TodoDao todoDao;

    @Autowired
    public TodoService(@Qualifier("InMemoryTodoDao") TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public void insertTodo(Todo todo) {
        UUID id = UUID.randomUUID();
        todoDao.insertTodo(id, todo);
    }

    public List<Todo> findAllTodos() {
        return todoDao.findAllTodos();
    }
}
