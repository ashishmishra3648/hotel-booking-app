# 🏨 Hotel Booking App
A Full-Stack Hotel Management System built using Spring Boot for the backend and HTML/CSS/JavaScript for the frontend. It enables users to manage hotel reservations, rooms, and customer information efficiently with database connectivity.

## 🚀 Features
Room Reservation Management – Create, view, update, and delete bookings

Customer Details – Store and manage customer information

Responsive Frontend – Elegant and user-friendly interface using HTML/CSS/JS

Database Integration – MySQL backend connected via Spring Data JPA

REST API Ready – Easily integrate with front-end or third-party apps

Cross-Platform – Works on Windows, macOS, and Linux

## 🛠️ Technology Stack
Backend
Spring Boot 3.x

Java 24+

Spring Data JPA / Hibernate

MySQL Database

Frontend
HTML5, CSS3, JavaScript

AJAX for API integration

Tools
IntelliJ IDEA

## ⚙️ Setup Instructions
1. Clone the Repository
bash
git clone https://github.com/ashishmishra3648/hotel-booking-app.git
cd hotel-booking-app
2. Configure Database
In src/main/resources/application.properties:

text
spring.datasource.url=jdbc:mysql://localhost:3306/hotel_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

## ▶️ Run the Application
Using IntelliJ IDEA or Terminal
bash
./mvnw spring-boot:run
Once the app starts, visit:

text
http://localhost:8080
You’ll see your hotel reservation front-end interface.


## 📁 Project Structure
text
hotel-booking-app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── Jar/
│   │   │       ├── HotelReservationSystemApplication.java
│   │   ├── resources/
│   │       ├── static/
│   │       │   └── index.html
│   │       └── application.properties
├── pom.xml
└── README.md

## Output 
<img width="1862" height="378" alt="image" src="https://github.com/user-attachments/assets/9613b9ca-2cbb-497a-aa84-6f482c9398f2" />
<img width="1767" height="792" alt="image" src="https://github.com/user-attachments/assets/4abfc399-5355-4e4d-a6c8-19cb2100bf7f" />
<img width="1791" height="852" alt="image" src="https://github.com/user-attachments/assets/90501944-99c6-4503-9e1c-24afe652536a" />



## 🧠 Future Upgrades
Add login/authentication system
Advanced analytics dashboard
Online payment integration
Multi-user role (Admin/Customer)
Maven
Git & GitHub
