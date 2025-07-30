# Notes API

A simple RESTful API built with Spring Boot that allows users to create, retrieve, update, and delete notes. Notes are stored in a **List**.

## Requirements
- Java 17 or later
- Maven 3.6 or later

Run the application:

The app runs by default at: http://localhost:8080

| Method | Endpoint      | Description       |
| ------ | ------------- | ----------------- |
| POST   | `/notes`      | Create a new note |
| GET    | `/notes`      | Get all notes     |
| GET    | `/notes/{id}` | Get note by ID    |
| PUT    | `/notes/{id}` | Update note by ID |
| DELETE | `/notes/{id}` | Delete note by ID |

## Sample Request:


### Create a note:

POST /notes

```json
{
"title": "Project Plan",
"body": "Discuss deadlines and milestones."
}
```

### Generic Response format:

Success:
```json
{
  "success": true,
  "message": "Note created",
  "data": {
    "id": 1,
    "title": "Project Plan",
    "body": "Discuss deadlines and milestones."
  }
}
```

Fail:
```json 
{ 
    "success": true, 
    "message": "Note deleted", 
    "data": null 
}
```
