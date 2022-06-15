# Pub/Sub Sample Application with Native Image

The Pub/Sub sample application demonstrates some common operations with Pub/Sub and is compatible with Native Image compilation.

## Setup Instructions

You will need to follow these prerequisite steps in order to run the samples:

1. If you have not already, [create a Google Cloud Platform Project](https://cloud.google.com/resource-manager/docs/creating-managing-projects#creating_a_project).

2. Install the [Google Cloud SDK](https://cloud.google.com/sdk/) which will allow you to run the sample with your project's credentials.

   Once installed, log in with Application Default Credentials using the following command:

    ```
    gcloud auth application-default login
    ```

   **Note:** Authenticating with Application Default Credentials is convenient to use during development, but we recommend [alternate methods of authentication](https://cloud.google.com/docs/authentication/production) during production use.

3. Install the native image compiler.

   You can follow the [official installation instructions](https://www.graalvm.org/docs/getting-started/#install-graalvm).
   After following the instructions, ensure that you install the native image extension installed by running:

    ```
    gu install native-image
    ```

   Once you finish following the instructions, verify that the default version of Java is set to the correct version by running `java -version` in a terminal.

   You will see something similar to the below output:

    ```
    $ java -version
   
    openjdk version "17.0.3" 2022-04-19
    OpenJDK Runtime Environment GraalVM CE 22.1.0 (build 17.0.3+7-jvmci-22.1-b06)
    OpenJDK 64-Bit Server VM GraalVM CE 22.1.0 (build 17.0.3+7-jvmci-22.1-b06, mixed mode, sharing)
    ```

4. [Enable the Pub/Sub APIs](https://console.cloud.google.com/apis/api/pubsub.googleapis.com).

### Sample

Navigate to this directory in a new terminal.

1. Compile the application using the Native Image Compiler. This step may take a few minutes.

    ```
    mvn package -P native -DskipTests
    ```

2. Run the application:

    ```
    ./target/native-image-sample
    ```

3. The application will create a new Pub/Sub topic, send and receive a message from it, and then delete the topic.

    ```
    Created topic: projects/YOUR_PROJECT_ID/topics/graal-pubsub-test-00e72640-4e36-4aff-84d2-13b7569b2289 under project: YOUR_PROJECT_ID
    Created pull subscription: projects/YOUR_PROJECT_ID/subscriptions/graal-pubsub-test-sub2fb5e3f3-cb26-439b-b88c-9cb0cfca9e45
    Published message with ID: 457327433078420
    Received Payload: Pub/Sub Native Image Test published message at timestamp: 2020-09-23T19:45:42.746514Z
    Deleted topic projects/YOUR_PROJECT_ID/topics/graal-pubsub-test-00e72640-4e36-4aff-84d2-13b7569b2289
    Deleted subscription projects/YOUR_PROJECT_ID/subscriptions/graal-pubsub-test-sub2fb5e3f3-cb26-439b-b88c-9cb0cfca9e45
    ```
   
## Sample Integration Test with native Image Support

In order to run the sample integration test as a native image, call the following command:

   ```
   mvn test -Pnative
   ```
