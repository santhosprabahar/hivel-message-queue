# Message Queue App
Application to produce and consume messages

### Running the application locally
There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the ```com.hivel.message.queue.MessageQueueApplication``` class from your IDE.

Alternatively you can use the Spring Boot Maven plugin like so:

```mvn spring-boot:run```

### Tech Stack
- JDK 17
- Maven 3
- Spring Boot - V3.0.6
- Apache Kafka
- PostgreSQL

### Features
- POST /message api gets the message via REST and produces it to queue where-in the consumer consumes that message and saves it to Database
- GET /message api returns the saved message based on the name
- UPDATE /message api updates the already save message based on the name
- DELETE /message api deletes the message based on the name

### Flow
![Flow Diagram](https://user-images.githubusercontent.com/89078208/234008390-319e2aa2-474f-4046-aac0-292a94b33907.png)