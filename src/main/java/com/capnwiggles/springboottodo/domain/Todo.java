package com.capnwiggles.springboottodo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Todo {

    private final UUID todoID;

    @NotBlank
    private final String name;

    private final String description;

    List<Task> tasks;

    public Todo(@JsonProperty("id") UUID todoID,
                @JsonProperty("name") String name,
                @JsonProperty("description") String description) {
        this.todoID = todoID;
        this.name = name;
        this.description = description;
        this.tasks = new ArrayList<>();
    }

    public Todo(String name, String description) {
        this.todoID = UUID.randomUUID();
        this.name = name;
        this.description = description;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public UUID getTodoID() {
        return todoID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        return "\n[TODO_ID] " + todoID + "\n" +
                "[TODO_NAME] " + name + "\n" +
                "[TODO_DESC] " + description + "\n" +
                "[TODO_TASKS] " + tasks + "\n";
    }
}