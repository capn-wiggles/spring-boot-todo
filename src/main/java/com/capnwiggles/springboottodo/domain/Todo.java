package com.capnwiggles.springboottodo.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "todos")
@NoArgsConstructor
@Getter
@Setter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Column(name = "todo_name")
    private String name;

    @Column(name = "todo_description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "todo")
    private List<Task> tasks;

    public Todo(@NotBlank String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public String toString() {
        return "\n[TODO_ID] " + id + "\n" +
                "[TODO_NAME] " + name + "\n" +
                "[TODO_DESC] " + description + "\n" +
                "[TODO_TASKS] " + tasks + "\n";
    }
}