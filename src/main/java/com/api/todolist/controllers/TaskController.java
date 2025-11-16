/**
 * ===============================================================
 *                      TodoList API - Documentation
 * ===============================================================

 * This API manages a list of tasks (Todo List).
 * It provides REST operations to create, read, update,
 * and delete tasks.

 * ---------------------------------------------------------------
 * MODEL : Task
 * ---------------------------------------------------------------
 *  - id (Long) : Unique identifier
 *  - title (String) : Task title (required)
 *  - description (String) : Optional description
 *  - completed (boolean) : Task status (default: false)

 * ===============================================================
 *                 1. CREATE A TASK (POST)
 * ===============================================================
 *  URL : POST /api/task
 *  Description : Creates a new task

 *  JSON request example :
 *  {
 *      "title": "Go to the market",
 *      "description": "Buy rice and oil",
 *      "completed": false
 *  }

 *  Example response :
 *  HTTP 201 CREATED

 *  Possible errors :
 *  - 400 BAD REQUEST : Invalid JSON or missing fields

 * ===============================================================
 *                 2. GET ALL TASKS (GET)
 * ===============================================================
 *  URL : GET /api/task
 *  Description : Returns the full list of tasks

 *  Example response :
 *  HTTP 200 OK
 *  [
 *      {
 *          "id": 1,
 *          "title": "Go to the market",
 *          "description": "Buy rice and oil",
 *          "completed": false
 *      },
 *      {
 *          "id": 2,
 *          "title": "Clean the house",
 *          "description": "",
 *          "completed": true
 *      }
 *  ]

 * ===============================================================
 *                 3. GET ONE TASK BY ID (GET)
 * ===============================================================
 *  URL : GET /api/task/{id}
 *  Description : Retrieves the task corresponding to the given ID

 *  Example :
 *  GET /api/task/1

 *  Response :
 *  HTTP 200 OK
 *  {
 *      "id": 1,
 *      "title": "Go to the market",
 *      "description": "Buy rice",
 *      "completed": false
 *  }

 *  Possible errors :
 *  - 404 NOT FOUND : Task not found

 * ===============================================================
 *                 4. UPDATE A TASK (PUT)
 * ===============================================================
 *  URL : PUT /api/task/{id}
 *  Description : Updates an existing task

 *  JSON request example :
 *  {
 *      "title": "Go to the market",
 *      "description": "Also buy bread",
 *      "completed": true
 *  }

 *  Example response :
 *  HTTP 200 OK
 *  {
 *      "message": "Task updated successfully"
 *  }

 *  Possible errors :
 *  - 404 NOT FOUND : Task does not exist

 * ===============================================================
 *                 5. DELETE A TASK (DELETE)
 * ===============================================================
 *  URL : DELETE /api/task/{id}
 *  Description : Deletes a task

 *  Example :
 *  DELETE /api/task/1

 *  Response :
 *  HTTP 204 NO CONTENT

 *  Possible errors :
 *  - 404 NOT FOUND : Task does not exist

 * ===============================================================
 *                CURL REQUEST EXAMPLES
 * ===============================================================

 *  1. Create a task :
 *     curl -X POST http://localhost:8080/api/task \
 *     -H "Content-Type: application/json" \
 *     -d '{"title":"Go to the market","description":"Buy rice","completed":false}'

 *  2. Get all tasks :
 *     curl -X GET http://localhost:8080/api/task

 *  3. Get one task :
 *     curl -X GET http://localhost:8080/api/task/1

 *  4. Update a task :
 *     curl -X PUT http://localhost:8080/api/task/1 \
 *     -H "Content-Type: application/json" \
 *     -d '{"title":"New title","description":"New description","completed":true}'

 *  5. Delete a task :
 *     curl -X DELETE http://localhost:8080/api/task/1

 * ===============================================================
 *       Notes :
 *       - All requests must be in JSON format.
 *       - Content-Type : application/json is required.
 * ===============================================================
 */

package com.api.todolist.controllers;

import com.api.todolist.entities.Task;
import com.api.todolist.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "api/task/")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void addTask(@RequestBody Task task){
        this.taskService.addTask(task); // utilisation du service pour l'enregistrement en base de donnee
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Task> getAllTasks(){
        return this.taskService.getAllTasks();
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @GetMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
    public Task getTaskById(@PathVariable("id") Long id){
        return this.taskService.getTaskById(id); // user service to get task by id
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public void updateTask(@PathVariable("id") Long id, @RequestBody Task task){
        task.setId(id);
        this.taskService.updateTask(task); // use service to update task
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void deleteTask(@PathVariable("id") Long id){
        this.taskService.deleteTask(id); // use service to delete task by id
    }
}
