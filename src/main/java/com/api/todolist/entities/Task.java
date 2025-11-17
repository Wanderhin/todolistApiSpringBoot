/**
 * this class represents a Task entity in the to-do list application.
 * It uses JPA annotations to map the class to a database table named "task".
 * It includes fields for id, title, description, and isCompleted status,
 * along with appropriate annotations for primary key generation and column constraints.
 * @author dev gremmy
 * It uses Lombok annotations to automatically generate getters, setters, and a constructor with all arguments.
 * */
package com.api.todolist.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Schema(description = "represent a task to do")
public class Task {
    @Id
    @Column(unique = true)
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "value unique of objet in database")
    private Long id;

    @Basic(optional = false)
    @Schema(description = "title of the task ")
    private String title;
    @Schema(description = "represent the description of the task")
    private String description;

    public boolean isCompleted() {
        return completed;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    @Basic(optional = false)
    @Schema(description = "the task is completed or no")
    private boolean completed;

    public Task() {

    }

}
