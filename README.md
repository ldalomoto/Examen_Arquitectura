# Library Management System - Layered Architecture (Monolith)

## Description

This is the **monolithic version using layered architecture** of a simple library management system developed as part of an Architecture course assignment.

Unlike the DDD version, this implementation follows a **traditional layered architecture approach**, organizing the application into clear but simpler layers:

- Controller
- Service
- Repository
- Model

The application provides a REST API to manage books in a library system.

---

## Features

- Add new books  
- Search books by title  
- View all books  
- Delete books  
- Change a book status between:
  - Available
  - Borrowed

---

## Technologies

### Backend
- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven
- PostgreSQL (shared with other branches if applicable)

### Frontend
- React (TypeScript)
- Vite
- Tailwind CSS

---

## Architecture Overview

This project follows a **Layered Architecture (Monolith)** approach:

- Presentation Layer → Controllers
- Business Logic Layer → Services
- Data Access Layer → Repositories
- Domain Layer → Models

---

## Backend Structure

```text
src/main/java/uce/edu/ec/backend
│
├── BackendApplication.java
│
├── controller
│   └── BookController.java
│
├── service
│   └── BookService.java
│
├── repository
│   └── BookRepository.java
│
└── model
    └── Book.java
```

---

## Layer Responsibilities

### Controller Layer

Handles HTTP requests and exposes REST endpoints.

- BookController

### Service Layer

Contains business logic and application rules.

- BookService

### Repository Layer

Handles data persistence using Spring Data JPA.

- BookRepository

### Model Layer

Defines the domain entity.

- Book

---

## Configuration

Application configuration is located in:

```text
src/main/resources/application.properties
```

It includes:
- Database connection settings
- JPA configuration
- Server port settings (if modified)

---

## Running the Application

### Prerequisites

Make sure your database (PostgreSQL) is running and configured properly.

---

### Run Backend

```bash
cd backend
./mvnw spring-boot:run
```

Or build and run:

```bash
./mvnw clean package
java -jar target/backend-0.0.1-SNAPSHOT.jar
```

---

### API Base URL

```
http://localhost:8080
```

---

## Project Structure

### Frontend Structure

```text
frontend
├── public
│   ├── favicon.svg
│   └── icons.svg
├── src
│   ├── components
│   │   ├── BookCard.tsx
│   │   └── BookForm.tsx
│   ├── pages
│   │   └── LibraryPage.tsx
│   ├── services
│   │   └── api.ts
│   ├── types
│   │   └── Book.ts
│   ├── App.css
│   ├── App.tsx
│   ├── index.css
│   └── main.tsx
├── eslint.config.js
├── index.html
├── package.json
├── tsconfig.json
└── vite.config.ts
```

---

## Infrastructure & Database (Docker)

The external services required for this application run inside Docker containers.

- PostgreSQL 15 (Alpine): Main database (port 5433)

> NOTE: All credentials and configuration are defined in `application.properties`.

---

## Running the Application

### Frontend

```bash
cd frontend
npm install
npm run dev
```

Runs at: http://localhost:5173

---

## Notes

- This version is a **monolithic layered architecture**, simpler than the DDD version.
- All business logic is centralized in the service layer.
- Suitable for small to medium-sized applications or educational purposes.

---

## Educational Purpose

This implementation was created to compare different architectural styles:

- Spaghetti (if applicable)
- Layered Monolith (this version)
- Domain-Driven Design (DDD)

The goal is to understand trade-offs between simplicity, maintainability, and scalability.
```