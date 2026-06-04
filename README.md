# Library Management System - DDD Version

## Description

This project is a simple library management system developed as part of an Architecture course assignment.

The objective was to implement the same application using three different architectural approaches in separate Git branches:

1. **Spaghetti Architecture**
2. **Layered Architecture**
3. **Domain-Driven Design (DDD) / Hexagonal Architecture** (this branch)

The application allows users to manage a collection of books through a web interface.

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
- Spring Data JPA
- Maven
- PostgreSQL

### Frontend
- React (TypeScript)
- Vite
- Tailwind CSS

---

## Architecture

This version follows Domain-Driven Design (DDD) principles with a separation of responsibilities between domain, application, infrastructure, and interface layers.

### Backend Package Structure

```text
src/main/java/uce/edu/ec/backend
│
├── application
│   └── service
│
├── domain
│   ├── model
│   └── repository
│
├── infrastructure
│   └── persistence
│       ├── entity
│       ├── mapper
│       └── repository
│
└── interfaces
    └── rest
```

---

## Layer Responsibilities

### Domain

Contains the core business logic and domain models.

- Book  
- BookRepository  

### Application

Contains use cases and application services.

- BookApplicationService  

### Infrastructure

Contains technical implementations such as persistence, database entities, mappers, and repository adapters.

- BookEntity  
- BookMapper  
- SpringBookRepository  
- BookRepositoryImpl  

### Interfaces

Contains the REST API controllers.

- BookController  

---

## Project Structure

### Backend Structure

```text
backend
├── application
├── domain
├── infrastructure
├── interfaces
```

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

### Backend

```bash
cd backend
./mvnw spring-boot:run
```

or

```bash
./mvnw clean package
java -jar target/backend-0.0.1-SNAPSHOT.jar
```

Runs at: http://localhost:8080

---

### Frontend

```bash
cd frontend
npm install
npm run dev
```

Runs at: http://localhost:5173

---
```