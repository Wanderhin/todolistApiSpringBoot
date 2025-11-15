/**
 * this class represents a Task entity in the to-do list application.
 * It uses JPA annotations to map the class to a database table named "task".
 * It includes fields for id, title, description, and isCompleted status,
 * along with appropriate annotations for primary key generation and column constraints.
 * @author dev gremmy
 * It uses Lombok annotations to automatically generate getters, setters, and a constructor with all arguments.
 * */
package com.api.todolist.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="task")
@Getter
@Setter
@AllArgsConstructor
public class Task {
    @Id
    @Column(unique = true)
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    private String title;

    private String description;

    @Basic(optional = false)
    private boolean isCompleted;

    public Task() {

    }

}
