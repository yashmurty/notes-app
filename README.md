# Notes App

Built using Spring Boot 3.

Time to try some Java.

# Architecture

[Architecture document](./docs/architecture.md)

# Development

To develop locally with hot reloading, run:

```bash
# bootrun starts with spring-boot-devtools on classpath, which will detect changes and restart application.
developmentOnly("org.springframework.boot:spring-boot-devtools")

# Terminal Window 1
./gradlew build --continuous

# Terminal Window 2
./gradlew bootRun
```
