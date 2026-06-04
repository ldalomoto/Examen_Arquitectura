# Library Management System - Spaghetti Architecture

## Description

This is the **Spaghetti Architecture version** of a simple library management system developed as part of an Architecture course assignment.

This implementation represents the most basic and unstructured version of the application, where all logic is concentrated in a single controller without separation of concerns.

The goal of this version is to demonstrate the problems of poor architectural design, such as:
- Lack of separation of responsibilities
- Difficult maintainability
- Tight coupling of logic
- Low scalability

Despite its simplicity, the application provides the same core functionality as the other architectural versions.

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
- Maven
- PostgreSQL (shared across versions if applicable)

### Frontend (Shared for all architectures)

- React (TypeScript)
- Vite
- Tailwind CSS

---

## Architecture Overview

This version follows a **Spaghetti Architecture**, meaning:

- All logic is placed inside a single controller (`SpaghettiController`)
- No separation between layers
- Business logic, data handling, and API handling are mixed together

This makes the system:
- Easy to start
- Hard to maintain or scale

---

## Backend Structure

```text
src/main/java/uce/edu/ec/backend
│
├── BackendApplication.java
└── SpaghettiController.java
```

---

## Configuration

Application configuration is located in:

```text
src/main/resources/application.properties
```

Includes:
- Database connection
- Server configuration

---

## Running the Application

### Prerequisites

Make sure PostgreSQL is running and properly configured.

---

### Run Backend

```bash
cd backend
./mvnw spring-boot:run
```

Or:

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

## Frontend Structure (Shared Across All Branches)

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

## Running the Application

### Frontend

```bash
cd frontend
npm install
npm run dev
```

Runs at: http://localhost:5173

---

## Infrastructure & Database (Docker)

The external services required for this application run inside Docker containers.

- PostgreSQL 15 (Alpine): Main database (port 5433)

> NOTE: All credentials and configuration are defined in `application.properties`.

---

## Features (Frontend)

- Display list of books
- Add new books via form
- Delete books
- Communicate with backend REST API

---

## Educational Purpose

This version was created to demonstrate why Spaghetti Architecture is problematic.

It serves as a comparison baseline against:
- Layered Architecture
- Domain-Driven Design (DDD)

The purpose is to highlight how lack of structure negatively impacts:
- Maintainability
- Scalability
- Code readability
```