/**
 * ===============================================================
 *                       TaskService
 * ===============================================================

 * This service class provides the business logic for managing
 * Task entities in the TodoList application.
 * It interacts with the TaskRepository to perform CRUD operations
 * on the database.

 * ---------------------------------------------------------------
 * Class: TaskService
 * Repository: TaskRepository
 * ---------------------------------------------------------------

 * Methods:

 * 1. addTask(Task task)
 *    - Saves a new task or updates an existing task in the database.
 *    - Delegates to TaskRepository.save(task).
 *    - for save, take @param a task

 *    Example:
 *       Task task = new Task();
 *       task.setTitle("Go shopping");
 *       task.setDescription("Buy fruits and vegetables");
 *       task.setCompleted(false);
 *       taskService.addTask(task);

 * 2. getAllTasks()
 *    - Retrieves all tasks from the database.
 *    - Returns a List<Task>.

 *    Example:
 *       List<Task> tasks = taskService.getAllTasks();

 * 3. getTaskById(Integer id)
 *    - Retrieves a task by its ID.
 *    - Returns an Optional<Task> which may be empty if no task exists.

 *    Example:
 *       Optional<Task> task = taskService.getTaskById(1);

 * 4. updateTask(Task task)
 *    - Updates an existing task.
 *    - Typically calls repository.save(task) after verifying task exists.

 * 5. deleteTask(Integer id)
 *    - Deletes a task by ID.
 *    - Throws an exception if the task does not exist.

 * ---------------------------------------------------------------

 * ---------------------------------------------------------------
 * Notes:
 * - This service layer is designed to contain all business logic.
 * - Future custom business rules (e.g., validation, notifications)
 *   should be implemented here rather than in the controller.
 * - Promotes separation of concerns: Controller → Service → Repository
 * ===============================================================
 */

package com.api.todolist.services;

import com.api.todolist.entities.Task;
import com.api.todolist.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(Task task){
        this.taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        return this.taskRepository.findAll(); // return all task
    }
}
