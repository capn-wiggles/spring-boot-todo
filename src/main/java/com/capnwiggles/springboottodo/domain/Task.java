package com.capnwiggles.springboottodo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table (name = "tasks")
@NoArgsConstructor
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "task_name")
    private String name;

    @Column(name = "task_done", columnDefinition = "boolean default false")
    private Boolean done;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id")
    @JsonIgnore
    private Todo todo;

    public Task(String name, Todo todo) {
        this.name = name;
        this.todo = todo;
        this.done = false;
    }

    @Override
    public String toString() {
        return "Task{" +
                ", name='" + name + '\'' +
                ", done=" + done +
                '}';
    }
}
