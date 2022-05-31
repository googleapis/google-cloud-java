# Cloud Vision on Spring Boot

This sample demonstrates leveraging Cloud Vision APIs within a Spring Boot application by using
[Spring Cloud GCP libraries](https://github.com/spring-cloud/spring-cloud-gcp).

The Spring Cloud GCP libraries for Cloud Vision offer [Spring Auto-configuration classes](https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-auto-configuration.html)
and convenience libraries to allow you to more quickly start using Cloud Vision in Spring.

## Overview

This sample starts a [Spring Boot](https://spring.io/projects/spring-boot) application
containing a simple web interface that allows you submit image URLs and get the image's text or
classification labels through the Google Cloud Vision APIs.

This application is built and run with [Maven](https://maven.apache.org/), a tool for building and
managing dependencies in Java projects.

## Build and Run

1.  **Follow the set-up instructions in [the documentation](https://cloud.google.com/java/docs/setup).**

2.  Enable the Google Cloud Vision APIs for your Google Cloud Platform project.
    [Click here](https://console.cloud.google.com/flows/enableapi?apiid=vision.googleapis.com)
    to visit Cloud Platform Console and enable the Google Cloud Vision APIs.

3.  After following step 1, you should have the `gcloud` command line tool installed.
    Open up a terminal and run the command `gcloud auth application-default login`.
    This will provide the account authentication necessary to run the application.

4.  In this directory, run the following Maven command to start the Spring Boot application.
    ```
    mvn clean spring-boot:run
    ```

5. After running the command, the application can be visited at http://localhost:8080/.
