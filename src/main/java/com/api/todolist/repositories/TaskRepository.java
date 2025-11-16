/**
 * ===============================================================
 *                      TaskRepository
 * ===============================================================
 * @author dev gremmy
 * This interface provides the data access layer for the Task entity.
 * It extends Spring Data JPA's JpaRepository to provide standard CRUD
 * operations and pagination capabilities without the need to write
 * boilerplate code.

 * ---------------------------------------------------------------
 * Interface: TaskRepository
 * Entity: Task
 * Primary Key Type: Integer (or Long if Task uses Long)
 * ---------------------------------------------------------------

 * Inherited CRUD methods from JpaRepository:

 * 1. save(S entity)
 *    - Saves a given Task entity to the database.
 *    - If the entity has a null ID, it will perform an insert.
 *    - If the entity has an existing ID, it will perform an update.

 * 2. findById(ID id)
 *    - Retrieves a Task by its ID.
 *    - Returns an Optional<Task>, which may be empty if no task exists.

 * 3. findAll()
 *    - Returns a List<Task> containing all tasks in the database.

 * 4. findAll(Pageable pageable)
 *    - Returns a paginated list of tasks.

 * 5. deleteById(ID id)
 *    - Deletes a task with the specified ID.
 *    - Throws EmptyResultDataAccessException if the ID does not exist.

 * 6. delete(Task entity)
 *    - Deletes the provided Task entity.

 * 7. count()
 *    - Returns the total number of tasks in the database.

 * ---------------------------------------------------------------
 * Example Usage:

 * // Inject repository in service
 * @Service
 * public class TaskService {
 *     private final TaskRepository taskRepository;

 *     public TaskService(TaskRepository taskRepository) {
 *         this.taskRepository = taskRepository;
 *     }

 *     public Task addTask(Task task) {
 *         return taskRepository.save(task);
 *     }

 *     public List<Task> getAllTasks() {
 *         return taskRepository.findAll();
 *     }

 *     public Optional<Task> getTaskById(Integer id) {
 *         return taskRepository.findById(id);
 *     }

 *     public void deleteTask(Integer id) {
 *         taskRepository.deleteById(id);
 *     }
 * }

 * ---------------------------------------------------------------
 * Notes:
 * - You can define custom query methods following Spring Data JPA naming conventions.
 *   Example:
 *       List<Task> findByCompleted(boolean completed);
 *       List<Task> findByTitleContaining(String keyword);
 * - All standard CRUD and pagination methods are automatically implemented
 *   by Spring Data JPA at runtime.
 * ===============================================================
 */

package com.api.todolist.repositories;

import com.api.todolist.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
