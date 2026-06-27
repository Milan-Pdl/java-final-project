# Blog App with Spring Boot, React, and MongoDB

This project now includes a simple blog-style application with a Spring Boot backend, a React frontend, and a Docker-based MongoDB setup so it can run consistently across laptops and peer machines.

## Why Docker is the highlight

Using Docker helps the team avoid version and runtime mismatches that often happen when everyone configures Java, Node, and MongoDB locally on different machines. With containers, everyone runs the same environment, which makes development, testing, and demoing much smoother and more reliable.

## Architecture

- Backend: Spring Boot REST API in Java
- Frontend: React + Vite
- Database: MongoDB running in Docker
- Orchestration: Docker Compose

## Folder structure

- backend logic in src/main/java
- frontend UI in frontend/src
- container setup in Dockerfile and docker-compose.yml

## Prerequisites

- Docker Desktop
- Java 17 (if you want to run the backend outside Docker)
- Node.js 20+ (if you want to run the frontend outside Docker)

## Run with Docker Compose

From the project root:

```bash
docker compose up --build
```

Then open:

- Frontend: http://localhost:3000
- Backend API: http://localhost:8080/api/v1/posts
- MongoDB: localhost:27017

## Run backend only

```bash
./mvnw spring-boot:run
```

## Run frontend only

```bash
cd frontend
npm install
npm run dev
```

## API endpoints

- GET /api/v1/posts
- GET /api/v1/posts/{id}
- POST /api/v1/posts
- PUT /api/v1/posts/{id}
- DELETE /api/v1/posts/{id}

Example payload:

```json
{
  "title": "My first post",
  "content": "Hello from the blog",
  "author": "Ada",
  "category": "Tech"
}
```

## Notes

- The backend uses MongoDB at mongodb://localhost:27017/blogdb when run locally.
- Inside Docker, the backend connects to mongodb://mongodb:27017/blogdb.
- The frontend talks to the backend through the Vite proxy.

## Special thanks

A very special thank you to Prof. Narendra Chaudhary for his guidance throughout this Java course. His support helped us understand challenging programming concepts like functions, object-oriented programming, and loops, and made this project possible.

