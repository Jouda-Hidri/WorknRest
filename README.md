# WorknRest

This rest service helps creating and editing exercises and saving the start time / duration for every exercise.

## Technologies used in the project

* Oracle/Open JDK 1.7 or 1.8 (must be pre-installed).
* [Gradle](http://gradle.org/) for build automation.
* [Guice](https://github.com/google/guice) for dependency injection.
* [JPA/Hibernate](http://hibernate.org/orm/) for persistence.
* [Jersey](https://jersey.java.net/) for REST endpoints.
* [Swagger UI](https://github.com/swagger-api/swagger-ui) for manual API testing and API documentation.
* [JUnit](http://junit.org/junit4/) for unit testing.
* [Mockito](http://mockito.org/) for mocked testing.
* [Rest Assured](https://github.com/rest-assured/rest-assured) for integration testing.

## How to Build and Run the Project

This project uses the [Gradle](https://gradle.org) build system, you can build the project locally just by typing the
following in the console:

```
./gradlew build
```

On Windows use `gradlew.bat` instead of `./gradlew`.

The output of the Gradle build is located in the  `build/` directory.

To run the project deploy the war-File in the `build/libs` directory to the application server of your choice.
Alternatively, you can use the Gradle Jetty plugin:

```
./gradlew jettyRun
```

## How to Extend the Project

If you want to import the project in an IDE such as Eclipse or IntelliJ IDEA then Gradle provides a way to generate all
the necessary project files.

Generate Eclipse project:
```
./gradlew cleanEclipse eclipse
```

Generate IntelliJ IDEA project:
```
./gradlew cleanIdea idea
```

Alternatively, with IntelliJ IDEA you can also import the project from the Gradle model,
just follow [this guide](https://www.jetbrains.com/help/idea/2016.1/importing-project-from-gradle-model.html).

