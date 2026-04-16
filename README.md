# Software Projects – Course Repository

## Introduction

This repository contains the **examples and materials used in the course _Software Projects_**.  
It documents the **progress of the lecture** and provides students with the **code developed during the sessions**.

The repository evolves during the semester and reflects the **chronological development of topics, tools, and programming concepts** introduced in the course.

Students can use this repository to:

- access lecture examples
- review discussed technologies
- follow the course progress
- retrieve the latest code from the lecture

---

## Repository Structure

The project follows a **standard Maven-based Java structure**.

```
src
 └─ main
     ├─ java
     │   ├─ unit01
     │   │   ├─ HelloWorld.java
     │   │   ├─ Person.java
     │   │   ├─ ReadByScanner.java
     │   │   └─ ReadFromFile.java
     │   ├─ unit02
     │   │   ├─ lombok
     │   │   └─ readFromFile
     │   ├─ unit03
     │   │   └─ Main.java (CSV Export)
     │   └─ unit04
     │       ├─ exercise (Hotel SQL Assignment)
     │       ├─ gui (Swing Login)
     │       └─ structure (Sets, Sorting)
     └─ resources
```

Each unit contains the examples and experiments from the corresponding lecture session.

---

## Current Contents

The repository covers the progress of the course with a focus on practical application and clean code:

### Unit 01: Basics & Setup
- **Focus:** Java project setup, IntelliJ IDEA introduction, Maven structure.
- **Outcomes:** First Java programs, reading data from console and files using `Scanner`.

### Unit 02: Advanced Git & Lombok
- **Focus:** Advanced Git workflows (branching, merging), reducing boilerplate code with Lombok.
- **Outcomes:** Efficient data modeling using `@Data` and `@Builder`, integration of external libraries via Maven.

### Unit 03: Collections & File Export
- **Focus:** Working with `ArrayList`, Java Time API, and structured file export.
- **Outcomes:** Exporting object data to CSV files, handling dates and times in Java, basic UI feedback via `JOptionPane`.

### Unit 04: GUI, Sorting & Assignment
- **Focus:** Introduction to GUI development (Swing), advanced data structures (Sets), and sorting objects.
- **Outcomes:** Simple Login GUI, implementation of `Comparable` for custom sorting, SQL export utility as a practical exercise.

---

## Technologies

The course uses the following technologies and libraries:

- **Language:** Java
- **Build Tool:** Maven
- **IDE:** IntelliJ IDEA
- **VCS:** Git
- **Libraries:**
    - Lombok (Code simplification)
    - Java Swing (GUI)
    - Java Time API (Date & Time)

---

## Version Control

Students can retrieve the latest lecture code using Git.

Clone the repository:

```
git clone <repository-url>
```

Update the local repository:

```
git pull
```

---

## Purpose

This repository serves as a **living documentation of the course** and will gradually include additional examples, experiments, and project components developed throughout the semester.