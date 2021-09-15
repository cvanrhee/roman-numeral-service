# Roman Numeral Service

Api takes an integer or a range between `1-3999` and asynchronously converts it to it's corresponding [Roman Numeral](https://en.wikipedia.org/wiki/Roman_numerals). 

- [Getting Started](#getting-started)
- [Endpoints](#endpoints)
- [Dependencies](#dependencies)
- [Executing Program](#executing-program)
- [Tests](#tests)

## Getting Started

1. Clone
   ```git clone https://github.com/cvanrhee/roman-numeral-service.git```
2. Import into your IDE of choice and [execute](#Executing program)

## Endpoints:
### Converting Roman Numeral

* **URL:** /romannumeral
* **Method:**
  `GET`
* **URL Params**

   **Required:**
   `?query=[integer]` or `?min=[integer]&max=[integer]`
* **Success Response:**
    * **Code:** 200 <br />
      **Content:** `{
          "input": 1,
          "output": "I"
         }`
* **Error Response:**
    * **Code:** 400 Bad Request <br />
      **Content:** 
  `{
    "timestamp": "2021-09-15T03:19:26.004+00:00",
    "status": 400,
    "error": "Bad Request",
    "message": "Invalid query range. Numbers must be between 1 and 3999",
    "path": "/romannumeral"
    }`

### Swagger Json

* **URL:** /v2/api-docs
* **Method:**
  `GET`

* **Success Response:**
    * **Code:** 200 <br />

### Health Check:

* **URL:** /actuator/health/
* **Method:**
  `GET`

* **Success Response:**
    * **Code:** 200 <br />
    * **Content:** `{
      "status": "UP"
      }`
    
## Dependencies

- Java 11
- Gradle

## Project written using:
- Java 11
- [Springboot](https://spring.io/)
- [Gradle](https://gradle.org/)
- [Junit](https://junit.org/junit5/)
- [AssertJ](https://joel-costigliola.github.io/assertj/)
- [Swagger](https://swagger.io/)

## Executing program

- Run the app using the gradle wrapper: 
```
./gradlew bootRun
```

You can also import the project into your IDE and run the ```com.interview.Application.java``` 
  as an Application.

## Tests

You can run the tests with gradle using

``` 
./gradlew test 
```

or run the tests using the IDE of your choice

## Code layout
Code is formatted to the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html).
If you are using Intellij, you can format your code using the [intellij-java-google-style.xml](intellij-java-google-style.xml).

## Authors

Caleb Van Rhee
