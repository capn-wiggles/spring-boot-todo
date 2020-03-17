package com.capnwiggles.springboottodo.domain;

import java.util.UUID;

public class Task {

    private final UUID taskID; // primary
    private final UUID todoID; // foreign

    private final String name;
    private Boolean done;

    public Task(UUID taskId, UUID todoId, String name) {
        this.todoID = todoId;
        this.name = name;
        this.done = false;
        this.taskID = taskId;
    }

    public void toggleDone() {
        this.done = !this.done;
    }

    public UUID getTaskID() {
        return taskID;
    }

    public UUID getTodoID() {
        return todoID;
    }

    public String getName() {
        return name;
    }

    public Boolean getDone() {
        return done;
    }

    @Override
    public String toString() {
        return "Task{" +
                ", name='" + name + '\'' +
                ", done=" + done +
                '}';
    }
}
