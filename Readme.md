# Journal Spring Boot Application

A secure, scalable backend journaling platform built with **Spring Boot** and **MongoDB**.  
Users can create, read, update, and delete personal journal entries with full authentication and authorization.

[![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![MongoDB](https://img.shields.io/badge/MongoDB-Atlas-47A248?style=for-the-badge&logo=mongodb&logoColor=white)](https://www.mongodb.com/)
[![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)](LICENSE)

## Features

- **User Authentication & Authorization** using Spring Security + JWT
- **CRUD operations** for journal entries (Create, Read, Update, Delete)
- **Role-based access control** (User/Admin)
- **MongoDB** integration for flexible, schema-less storage
- **Input validation** and error handling
- **Secure endpoints** protected against common vulnerabilities (CSRF, injection, etc.)
- Designed with **microservices-friendly principles** (modular, scalable)
- Ready for integration with payment gateways or external APIs (future-proof)

## Technologies Used

- **Backend**: Java 17+, Spring Boot 3.x, Spring Security, Spring Data MongoDB
- **Database**: MongoDB (NoSQL)
- **Authentication**: JWT (JSON Web Tokens)
- **Build Tool**: Maven (or Gradle – adjust as per your project)
- **Other**: Lombok (optional), Spring Boot Starter Web, Validation

## Prerequisites

- Java 17 or higher
- Maven 3.8+ (or Gradle)
- MongoDB installed locally **or** MongoDB Atlas account (recommended)
- Git

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/YOUR-USERNAME/journal-app-spring-boot.git
cd journal-app-spring-boot
```
### 2. Configure Application Properties 
```bash
spring:
  application:
    name: journal-app
  data:
    mongodb:
      uri: mongodb+srv://<username>:<password>@cluster0.mongodb.net/journaldb?retryWrites=true&w=majority
      database: journaldb

jwt:
  secret: your-very-long-and-secure-secret-key-here   # Change this!
  expiration: 86400000   # 24 hours in ms

server:
  port: 8080
```

### 3. Build the Application
```bash
mvn clean install
# or if using Gradle: ./gradlew build
```
### 4. Run the Application
```bash
mvn spring-boot:run
# or: java -jar target/journal-app-0.0.1-SNAPSHOT.jar
```
