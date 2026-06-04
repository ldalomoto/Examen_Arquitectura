# Library Management System - Architecture Comparison Project

## Overview

This project was developed as part of an Architecture course at UCE.  
The main goal is to compare different software architecture styles by implementing the same application using multiple approaches.

The system is a simple **Library Management System** that allows users to manage books through a web interface.

---

## Architecture Comparison

The project is divided into different Git branches, each representing a different architectural style:

```
feature/spaghetti-code
feature/layered-monolith
feature/ddd
main
```

Each branch contains a different backend implementation of the same application.

---

## Implemented Architectures

### 1. Spaghetti Architecture (`feature/spaghetti-code`)
- All logic is concentrated in a single controller
- No separation of concerns
- Used as a baseline to demonstrate poor architectural practices

---

### 2. Layered Architecture (`feature/layered-monolith`)
- Classic monolithic layered structure
- Separation into:
  - Controller
  - Service
  - Repository
  - Model
- More maintainable and structured than spaghetti code

---

### 3. Domain-Driven Design (DDD) (`feature/ddd`)
- Clean Architecture / Hexagonal approach
- Clear separation between:
  - Domain
  - Application
  - Infrastructure
  - Interfaces
- Focus on business logic isolation and scalability

---

## Frontend (Shared Across All Branches)

For simplicity and consistency, **the same frontend was used across all architecture versions**.

The frontend was built using:

- React (TypeScript)
- Vite
- Tailwind CSS

### Key decision

The frontend was **not modified between branches**.  
Only the backend implementation changes depending on the architecture being evaluated.

This decision allows:
- Fair comparison between architectures
- Focus only on backend structural differences
- Reduced duplication of frontend code

---

## Project Purpose

The purpose of this project is to understand:

- How architectural decisions affect code organization
- Trade-offs between simplicity and scalability
- Maintainability differences between architectures
- Evolution from unstructured to clean architecture

---

## Summary

This repository demonstrates a progressive comparison of:

1. Spaghetti Code (no structure)
2. Layered Monolith (structured but simple)
3. Domain-Driven Design (clean and scalable architecture)

All versions share the same frontend and database configuration, differing only in backend structure and design philosophy.
```