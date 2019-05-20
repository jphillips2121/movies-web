# Movies-Web: Web Application for displaying movie data from the [movies-api](https://github.com/jphillips2121/movies-api)

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

Before running the SpringBoot app locally ensure that the [movies-api](https://github.com/jphillips2121/movies-api) is running on your machine. Details can be found in the README of the movies-api app.

Clone this repository by going to a desired directory and typing the following `git clone git@github.com:jphillips2121/movies-web.git` 

Once that is done, use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) and type the following into the command line to get the web app to run: 

```shell
mvn spring-boot:run
```

The website can be viewed by visiting localhost:8080 in a browser
