# Spring Boot project with Apache Kafka Demo

This project shows a demo of Spring Boot with Apache Kafka with minimal configuration

## Running Instructions
1. Start Apache Kafka with simple [docker command](https://docs.confluent.io/platform/current/platform-quickstart.html#step-1-download-and-start-cp)
2. Start the project running [SpringBootKafkaApplication](src/main/java/com/pj/springboot/kafka/SpringBootKafkaApplication.java)
3. Invoke end point http://localhost:8080/api/v1/employee/create to create an employee, and you see should see response similar to below
```log
2022-10-15 00:40:39.254  INFO 11562 --- [nio-8080-exec-1] c.p.s.kafka.service.EmployeeServiceImpl  : Sent employee: Employee{firstName='John428715731', lastName='Doe', email='jdoe@example.com', phone='123-456-7890'} to topic:employee
2022-10-15 00:40:39.272  INFO 11562 --- [ntainer#0-0-C-1] c.p.s.k.l.EmployeeListenerServiceImpl    : Raw message received:{"firstName":"John428715731","lastName":"Doe","email":"jdoe@example.com","phone":"123-456-7890"} from topic:employee 
2022-10-15 00:40:39.282  INFO 11562 --- [ntainer#0-0-C-1] c.p.s.k.l.EmployeeListenerServiceImpl    : Formatted employee information:Employee{firstName='John428715731', lastName='Doe', email='jdoe@example.com', phone='123-456-7890'} from topic:employee 
```
