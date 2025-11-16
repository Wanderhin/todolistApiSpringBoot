📘 TodoList API – Spring Boot REST Application

A simple and clean REST API built with Spring Boot 3, using JPA, MySQL, and following good development practices.
This API allows users to manage tasks (create, read, update, delete).

🚀 Features

Create tasks

Retrieve all tasks

Retrieve a task by ID

Update tasks

Delete tasks

JSON-based communication

Clean layered architecture (Controller → Service → Repository)

🛠 Technologies Used

Java 17+

Spring Boot 3+

Spring Web

Spring Data JPA

MySQL

Lombok

Maven

 Project Structure
src/
├── controllers/
│    └── TaskController.java
├── services/
│    └── TaskService.java
├── repositories/
│    └── TaskRepository.java
└── entities/
└── Task.java

 REST API Documentation
    Create a Task

POST /api/task

Request Body
{
"title": "Go to the market",
"description": "Buy rice",
"completed": false
}

Response

201 CREATED

    Get All Tasks

GET /api/task

Response
[
{
"id": 1,
"title": "Go to the market",
"description": "Buy rice and oil",
"completed": false
}
]

    Get a Task by ID

GET /api/task/{id}

Response
{
"id": 1,
"title": "Go to the market",
"description": "Buy rice",
"completed": false
}

    Update a Task

PUT /api/task/{id}

Request Body
{
"title": "Updated title",
"description": "Updated description",
"completed": true
}

Response
{ "message": "Task updated successfully" }

    Delete a Task

DELETE /api/task/{id}

Response

204 NO CONTENT

 cURL Examples
Create a task
curl -X POST http://localhost:8080/api/task \
-H "Content-Type: application/json" \
-d '{"title":"Go to the market","description":"Buy rice","completed":false}'

Get all tasks
curl http://localhost:8080/api/task

Get one task
curl http://localhost:8080/api/task/1

Update a task
curl -X PUT http://localhost:8080/api/task/1 \
-H "Content-Type: application/json" \
-d '{"title":"New title","description":"New description","completed":true}'

Delete a task
curl -X DELETE http://localhost:8080/api/task/1

    License

This project is open-source and free to use.