# Event Planning System
## Overview
The Event Planning System is a web application designed to help users organize, manage, and track events. It allows users to create events, manage tasks, RSVP to events, and categorize events. Additionally, users can follow each other and stay updated on their activities.

## Features
User Registration and Management: Register, log in, and manage user profiles.  
Event Creation and Management: Create, update, delete, and view events.  
RSVP System: RSVP to events and view who else is attending.  
Task Management: Create and assign tasks for events, and track their progress.  
Event Categories: Categorize events and filter them based on categories.  
Social Features: Follow other users and view their events and activities.  
## Technologies Used
Backend: Spring Boot, Spring Data JPA, Hibernate  
Database: PostgreSQL  
Build Tool: Gradle  
Security: Spring Security  
Frontend: (Optional) Thymeleaf, React, or Angular (depending on your choice)  
## Getting Started
Prerequisites
Java 17 or later
PostgreSQL
Gradle
Setup Instructions
Clone the Repository

bash
Copy code
git clone https://github.com/yourusername/event-planning-system.git
cd event-planning-system
Configure the Database

Ensure PostgreSQL is installed and running.

Create a new database for the application.

Update src/main/resources/application.properties with your PostgreSQL configuration:

properties
Copy code
spring.datasource.url=jdbc:postgresql://localhost:5432/event_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
Build and Run the Application

bash
Copy code
./gradlew build
./gradlew bootRun
Access the Application

Open your browser and go to http://localhost:8080.
API Endpoints
User Management

POST /api/auth/register - Register a new user.
POST /api/auth/login - Log in to the system.
GET /api/users/{id} - Get user profile details.
Event Management

POST /api/events - Create a new event.
GET /api/events - List all events.
GET /api/events/{id} - Get event details.
PUT /api/events/{id} - Update an event.
DELETE /api/events/{id} - Delete an event.
RSVP System

POST /api/events/{id}/rsvp - RSVP to an event.
GET /api/events/{id}/attendees - List attendees of an event.
Task Management

POST /api/tasks - Create a new task.
GET /api/tasks - List all tasks.
PUT /api/tasks/{id} - Update a task.
Event Categories

POST /api/categories - Create a new category.
GET /api/categories - List all categories.
GET /api/events/categories/{id} - List events by category.
Social Features

POST /api/users/{id}/follow - Follow a user.
POST /api/users/{id}/unfollow - Unfollow a user.
GET /api/users/{id}/following - List users that the current user is following.
GET /api/users/{id}/followers - List users who are following the current user.
Testing
To run tests, use the following command:

bash
Copy code
./gradlew test
Deployment
Prepare for Production

Update application properties for production settings.
Configure environment-specific settings.
Build the Application

bash
Copy code
./gradlew build
Deploy

Deploy the application to your chosen server or cloud platform.
Contributing
Contributions are welcome! If you would like to contribute to this project, please fork the repository and submit a pull request with your changes.

License
This project is licensed under the MIT License - see the LICENSE file for details.

Contact
For any questions or issues, please contact your_email@example.com.

Feel free to customize the README to better fit your project’s specifics, such as the exact URL of your repository or additional setup steps.