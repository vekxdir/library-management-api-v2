# library-management-api-v2

A simple CRUD REST API for managing books and author — built with Spring Boot

## 🚀 Features
- Create, Read, Update, Delete Books,OneToOne relationship
- Validation (e.g., Published date cannot be in the future)
- Exception Handling
- DTO
- OneToOne Relationship

## 🛠️ Tech Stack
- Java 17
- Spring Boot
- Maven

## ⚙️ Setup
1. Clone the repo  
   ```bash
   git clone https://github.com/vek/book-api.git
   cd book-api
2. Configure your database in application.properties
3. Run the app:
     mvn spring-boot:run

## 📬 Example JSON (POST /books)

###book
```json
{
  "title": "The Art Of Spring Boot",
  "price": 699,
  "authorId":1
}

###author
```json
{
   "id":1
  "name": "vek",
  "email":"vek@demo.com",
}
