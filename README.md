# my-assignment
#1. Technologies / Frameworks / Tools used
==========================================
* Spring Boot Framework (Parent version 2.4.5)
* Java 8
* Maven for compiling and building the Project
* Junit Jupyter write test cases for the code/component.
* Mockito to achieve Mocking during test case execution.
* Mongo db as NOSQL database.
* Intellij for project development

#2. PreRequisites for the project to build and run
===================================================
* Java 8 to be installed
* Maven to be installed
* Mongo DB Community Edition NOSQL Database to be Installed with default installation and default port

#3. build / execute the application in local machine
===================================================
* Git clone the project using git url https://github.com/omarfarukk/my-assignment.git
* Open a command Prompt and go to the downloaded project's root directory, For this project, it'll be assignment-hike
* Build the project using below command

    ./mvnw clean install

* Run the application using below command, 

    java -jar target/assignment-0.0.1-SNAPSHOT.jar

* If required, change the default port 8080 to any available Port
    
    java -jar target/assignment-0.0.1-SNAPSHOT.jar --server.port=<PORT-NUMBER>

#4. Deploy the application using Docker
========================================
* Git clone the project using git url https://github.com/omarfarukk/my-assignment.git
* Open a command Prompt and go to the downloaded project's root directory, For this project, it'll be assignment-hike
* Build the project using below command

    ./mvnw clean install

* Prepare docker image using below command 

    docker build --tag=assignment-hike:latest .

* Run the docker image using below command
    
    docker network create backend-network

    docker run -d -p 27017:27017 --name mongodb-container --net backend-network  mongo:latest

    docker run -d -p 8080:8080 --name assignment-container --net backend-network --link mongodb-container:mongo assignment-hike:latest


#5. Test the Application
============================
* To test the project , please try cURL command/Postman/Swagger-UI

    Check Actuator Health Endpoint: curl http://localhost:8080/assignment/actuator/health
    Check  Documentation page, http://localhost:8080/assignment/swagger-ui.html




