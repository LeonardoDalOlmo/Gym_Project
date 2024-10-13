# Gym_Project
A school project of a gym using java spring.

This project consists in developing a API using the framework Spring, of language Java, with the objective of managing the operations of a gym. The project is connected to the database PostgreSQL where we have control of how many clients the gym has, as well as which modality the client is enrolled and their schedules.

We used Postman to test and validate CRUD (Create, Read, Update, Delete) operations.

Database Structure:
The database was designed to meet the operational needs of an academy, reflecting the main aspects of student and training management. Below is an explanation of the purpose of each table:

Students: Stores students' personal and contact data, as well as information about the student's status within the academy (active, inactive).

Instructor: Contains the data of the gym's instructors, such as name, telephone number, type of instructor and salary, allowing control of who is qualified to train students on each modality.

Student_Training_File: Records details of students' training, including training days, machines used, number of sets and repetitions, allowing personalized monitoring.

Modality: Defines the types of exercises offered by the gym, such as weight training, crossfit, among others. Each modality is associated with a set of specific activities.

Periods: Defines the periods of time in which the modalities or plans are active, including start and end dates, helping to organize contracts and signatures.

Plans: Describes the different types of plans offered by the gym, each with a specific price, such as a monthly, quarterly plan, etc.
