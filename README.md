# Courses Manager Microservice

## Introduction
This project is a simple REST application for serving a courses and runners. It uses Spring Boot, Spring Data JPA and some other helper libraries.
### Documentation
It's provided by open doc api here `http://localhost:8080/swagger-ui/index.html` 
You can provide customized configuration for the swagger in the `OpenAPICongfig` located `com.pmu.coursesmanager.common.OpenAPIConfig`

### Exceptions
Managed in `com.pmu.coursesmanager.common.Handler`
I used `ControllerAdivce` to handle different exceptions such as `Validation Exceptions` and `Unique attributes`
### Database
I used ``H2``in memory database to avoid external database configuration
### Kafka Stream
 - I used spring boot and kafka to produce streams to a specific topic provide in ``application.properties``
 - To produce stream use this endpoint 
 ```shell 
 curl -X POST http://localhost:8080/api/v1/kafka/send -i
 ```
### Dependencies 
You can use this command to install all dependencies ```mvn install``` or just `./mvnw install` if you don't have a maven installed locally i added here `maven wrapper` for this use case
### Build 
Tun the following command in your terminal `mvn clean` or just `./mvnw clean` 
### Tests 
You can run tests by running the command line ```mvn test``` or just `./mvnw test`
### Run 
 - You can use this command ``mvn spring-boot:run``
 - After this you can add a new course by using 
 ```shell
 curl -X POST http://localhost:8080/api/v1/courses -i -H "Content-Type: application/json" -d '{"name":"Course One"}'
 ```
 - To get the list of courses you can use this 
 ```shell
 curl -X GET http://localhost:8080/api/v1/courses -i
 ```     
 - To add a new runners to specific course you can try this command 
 ```shell
 curl -X POST http://localhost:8080/api/v1/courses/{courseNumber}/runners -H "Content-Type: application/json" -d '{"runners":[{"name":"first Runner"},{"name":"second Runner"},{"name":"third Runner"}]}'
 ```
 - To get runners of a specific course you can use this
 ```shell
 curl -X GET http://localhost:8080/api/v1/courses/{courseNumber}/runners -i ```
