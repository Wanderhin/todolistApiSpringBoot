package com.api.todolist.services;

import com.api.todolist.entities.Task;
import com.api.todolist.repositories.TaskRepository;
import org.springframework.stereotype.Service;


@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(Task task){
        this.taskRepository.save(task);
    }
}
