package com.capnwiggles.springboottodo.domain;

import java.util.UUID;

public class Task {

    private UUID taskID; // primary
    private UUID todoID; // foreign

    private String name;
    private Boolean done;

    public Task(UUID todoID, String name) {
        this.todoID = todoID;
        this.name = name;
        this.done = false;
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
