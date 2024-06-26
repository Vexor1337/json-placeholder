# json-placeholder
Application that uses the jsonplaceholder API to save posts to separate files.

### Description
This project is an API designed to allow consumers to save to separate files all posts from placeholder API.
This project is built using the Hexagonal Architecture, also known as Ports and Adapters. This architectural style emphasizes the separation of concerns by dividing the application into distinct layers with clear responsibilities.
# Getting Started
### Dependencies
This project is built with the following key dependencies:

- **Kotlin**: Utilized as the primary programming language, offering a modern, concise, and feature-rich syntax.
- **Spring Boot**: Provides a robust framework for building stand-alone, production-grade Spring based Applications with minimal hassle.
- **Gradle**: Chosen for build automation, it enhances the build process through flexibility and dependency management.
- **Feign**: Simplifies building HTTP clients, making it easier to consume RESTful services.
- **Kotlin Arrow**: Empowers the project with functional programming features, making code more concise, flexible, and resilient.

#### Specified Versions
- **Kotlin**: 1.9.0
- **Spring Boot**: 3.1.1
- **Gradle**: 8.1.1
- **Feign**: 12.4
- **Kotlin Arrow**: 1.2.1

### Gradle Configuration

To include these dependencies in your project, add the following to your `build.gradle.kts`:

```kotlin
plugins {
    id("org.springframework.boot") version "3.1.1"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.spring") version "1.9.0"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation(group = "io.arrow-kt", name = "arrow-core", version = "1.2.1")
    
    implementation(group = "io.github.openfeign", name = "feign-core", version = "12.4")
    implementation(group = "io.github.openfeign", name = "feign-gson", version = "12.4")
    implementation(group = "io.github.openfeign", name = "feign-okhttp", version = "12.4")
    implementation(group = "io.github.openfeign", name = "feign-slf4j", version = "12.4")
    
}
```

## Installing

Follow these steps to get your development environment set up and run the project.

### Prerequisites

Make sure you have the following installed:
- JDK 17
- Gradle 8.1.1

### Clone the repository

First, clone the project repository to your local machine:

```bash
git clone https://github.com/Vexor1337/json-placeholder.git
cd json-placeholder
```
## Build the project
To build the project, run the following command in the root directory of the project:
```` bash
./gradlew build
````
## Run the project
To run the project, run the following command in the root directory of the project:
```` bash
 ./gradlew bootRun
````
# API Reference
http://localhost:8080/swagger-ui/index.html#/


### Get List of Repositories by Username

To save all posts from placeholder API, you can use the following `curl` command:

```bash
curl -X GET 'http://localhost:8080/placeholder/getAllPostsAndSaveToSeparateFiles' -H 'accept: */*'
```
