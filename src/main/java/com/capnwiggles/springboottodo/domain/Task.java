package com.capnwiggles.springboottodo.domain;

import java.util.UUID;

public class Task {

    private final UUID taskID; // primary
    private final UUID todoID; // foreign

    private final String name;
    private Boolean done;

    public Task(UUID todoID, String name) {
        this.todoID = todoID;
        this.name = name;
        this.done = false;
        this.taskID = UUID.randomUUID();
    }

    public void toggleDone() {
        this.done = !this.done;
    }

    @Override
    public String toString() {
        return "Task{" +
                ", name='" + name + '\'' +
                ", done=" + done +
                '}';
    }
}
