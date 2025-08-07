# 🎓 Student Management System

A simple and efficient Java-based CRUD application for managing student records using **MySQL** as the database and **JDBC** for connectivity. The system allows administrators to **add**, **update**, **delete**, **view**, and **search** student information via a console UI.

---

## 📌 Features

- ✅ Add new students with roll number, name, city, and department
- ✅ Update existing student records
- ✅ Delete students from the system
- ✅ View all students (sorted by roll/name/city)
- ✅ Search students by roll number or name
- ✅ Relational mapping with departments (foreign key)

---

## 🧰 Tech Stack

| Layer        | Technology       |
|--------------|------------------|
| Language     | Java (Core Java) |
| UI           | Console          |
| Backend DB   | MySQL            |
| Connectivity | JDBC             |
| IDE          | IntelliJ         |
|--------------|------------------|

---

## 🗃️ Database Schema

### 🏢 `dept` table:
```sql
CREATE TABLE dept (
    deptno INT PRIMARY KEY,
    deptname VARCHAR(50)
);
```
### 🎓 `student` table
```sql
CREATE TABLE student (
    roll INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    city VARCHAR(50),
    deptno INT,
    FOREIGN KEY (deptno) REFERENCES dept(deptno)
);
```

