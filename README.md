# Gorest API Testing Project

This project is built to test the [Gorest API](https://www.gorest.co.in/) using positive test cases, negative test cases, and boundary tests. The project is written in Java programming language, using the JUnit testing framework and Gradle as the build tool. It leverages various dependencies like RestAssured, Cucumber, Assertion, JSON and JSONSchemaValidator for API testing and validation.

## Project Structure

Here is the breakdown of the project structure:
- **api.feature**: The feature file that contains the scenarios to be tested in Gorest API.
- **JSON Schema Data**: Defines the structure and validation rules for JSON objects used in API requests and responses, ensuring data integrity.
- **Endpoint**: The specific URL path for accessing the Gorest API, enabling interaction with resources like users and posts.
- **Models**: Defines the structure and behavior of data objects used in the application. It includes static responses that link API responses to their respective page representations, facilitating smooth integration and data flow between components.
- **Utility**: Contains helper functions and classes that provide common functionality, promoting code reuse and simplifying application logic.
- **ApiPage**: Object-oriented representations of API endpoints or related logic.
- **ApiRunner**: Contains the runner classes for running the Cucumber tests.
- **ApiStep**: Contains the step definitions that link Cucumber steps to actual code logic.

## Requirements

- [Java 8 or above](https://www.oracle.com/java/technologies/javaese-downloads.html)
- [IntelliJ IDEA](https://www.jetbrains.com/idea) or another Java IDE
- [Gradle](https://www.gradle.org/install/) for dependency management and build automation
- [JUnit](https://junit.org/junit5/)
- [RestAssured](https://rest-assured.io/)
- [Maven Repository](https://mvnrepository.com)
- [Cucumber](https:cucumber.io)
- [JSONValidator](https://github.com/json-schema-org./json-schema-validator)

## Dependencies

The following dependencies are included in the project:
- testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.1'
- testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.1'
- testImplementation 'org.junit.vintage:junit-vintage-engine:5.7.2'
- testImplementation group: 'io.rest-assured', name: 'rest-assured', version: '5.5.0'
- implementation group: 'io.cucumber', name: 'cucumber-java', version: '7.19.0'
- testImplementation group: 'io.cucumber', name: 'cucumber-junit', version: '7.19.0'
- testImplementation group: 'org.json', name: 'json', version: '20240303'
- implementation group: 'io.rest-assured', name: 'json-schema-validator', version: '5.5.0'
- testImplementation group: 'io.rest-assured', name: 'json-path', version: '5.5.0'
- testImplementation group: 'org.assertj', name: 'assertj-core', version: '3.26.3'

## Installation

1. Clone the repository:
   git clone https://github.com/yourusername/gorest-api-testing.git
2. Open the project in IntelliJ IDEA or your preferred IDE
3. Ensure that Gradle is installed and properly configured in your IDE
4. Run the following Gradle command to download the required dependencies: ./gradlew build

## Configurations

To run this project, make sure you have the following configured:
1. **Java Development Kit (JDK)**: Install JDK 8 or higher on your machine. You can download it from the [Oracle website](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html) or use [OpenJDK](https://www.openjdk.java.net/install/).
2. **Gradle**: Ensure you have Gradle installed. You can install it following the instructions on the [Gradle website](https://gradle.org/install/).
3. **IntelliJ IDEA**: Use IntelliJ IDEA as your IDE for coding. You can download it from the [JetBrains website](https://jetbrains.com/idea/download/).
4. **Dependencies**: The project uses the following dependencies, which are included in the 'build.gradle' file:
   - JUnit
   - RestAssured
   - Cucumber
   - Assertion
   - JSON
   - JSONSchemaValidator
  
After setting up these tools, you can run the tests and work on the project.

## Running the Tests

You can run the tests in the project using the Gradle wrapper or directly from the IDE.

### Running via IDE

1. Navigate to the Runner class.
2. Right-click the class and select "Run" to execute the Cucumber feature.

### Running via Command Line
1. Use the Gradle command: ./gradlew test

## Test Cases

The project includes a total of 23 test cases categorized into:
- **Positive Test Cases**: Validate the successful execution of API calls with valid inputs.
- **Negative Test Cases**: Verify the API's behavior with invalid inputs or missing required fields.
- **Boundary Test Cases**: Ensure correct handling of boundary values (e.g., maximum and minimum limits).

You can view all the test cases in the [api.feature file](src/test/resources/features/api.feature).
