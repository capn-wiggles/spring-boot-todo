package com.capnwiggles.springboottodo.dao;

import com.capnwiggles.springboottodo.domain.Task;
import com.capnwiggles.springboottodo.domain.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("inMemoryTodoDao")
public class InMemoryTodoDao implements TodoDao {

    private List<Todo> todos;

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
    public Optional<Todo> findTodoByID(UUID todoId) {
        return todos.stream().filter(todo -> todo.getTodoID().equals(todoId)).findFirst();
    }

    // TODO: update logic with streams
    @Override
    public List<Task> showAllTasks(UUID todoId) {
        for (Todo t : todos) {
            if (t.getTodoID().equals(todoId)) {
                return t.getTasks();
            }
        }
        return null;
    }

    // TODO: update logic with streams
    @Override
    public boolean addTask(UUID todoId, String taskName) {
        for (Todo t : todos) {
            if (t.getTodoID().equals(todoId)) {
                t.addTask(taskName);
                return true;
            }
        }
        return false;
    }

    @Override
    public Task findTaskById(UUID todoId, UUID taskId) {
        Todo todoInst = todos.stream().filter(todo -> todo.getTodoID().equals(todoId)).findFirst().orElse(null);
        return todoInst.getTasks().stream().filter(task -> task.getTaskID().equals(taskId)).findFirst().orElse(null);
    }

    // TODO: update logic with streams
    @Override
    public boolean setTaskDone(UUID todoId, UUID taskId) {
        for (Todo t : todos) {
            if (t.getTodoID().equals(todoId)) {
                for (Task tsk : t.getTasks()) {
                    if (tsk.getTaskID().equals(taskId)) {
                        tsk.toggleDone();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean insertTodo(UUID todoID, Todo todo) {
        todos.add(new Todo(todoID, todo.getName(), todo.getDescription()));
        return true;
    }
}
