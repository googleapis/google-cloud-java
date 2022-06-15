# Cloud Trace Client Libraries with Native Image

This application uses the Google Cloud [Trace Client Libraries](https://github.com/googleapis/java-trace) and can be compiled with Native Image.

**Note:** In practice, the Trace Client Libraries are not used directly but through another tool, such as through the [OpenCensus Cloud Trace integration](https://cloud.google.com/trace/docs/setup/java) or through a framework like Spring via [Spring Cloud GCP Trace](https://github.com/spring-cloud/spring-cloud-gcp/blob/master/docs/src/main/asciidoc/trace.adoc).

## Setup Instructions

You will need to follow these prerequisite steps in order to run these samples:

1. If you have not already, [create a Google Cloud Platform Project](https://cloud.google.com/resource-manager/docs/creating-managing-projects#creating_a_project).

2. Install the [Google Cloud SDK](https://cloud.google.com/sdk/) which will allow you to run the sample with your project's credentials.

   Once installed, log in with Application Default Credentials using the following command:

    ```
    gcloud auth application-default login
    ```

   **Note:** Authenticating with Application Default Credentials is convenient to use during development, but we recommend [alternate methods of authentication](https://cloud.google.com/docs/authentication/production) during production use.

3. Install the native image compiler.

   You can follow the [official installation instructions](https://www.graalvm.org/docs/getting-started/#install-graalvm).
   After following the instructions, ensure that you install the Native Image extension installed by running:

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

4. Enable the [Cloud Trace APIs](https://console.cloud.google.com/apis/api/cloudtrace.googleapis.com/overview).

## Run with Native Image Compilation

Navigate to this directory in a new terminal.

1. Compile the application using the Native Image Compiler. This step may take a few minutes.

   ```
   $ mvn package -P native -DskipTests
   ```

2. Run the application:

   ```
   $ ./target/native-image-sample
   ```

3. The application will generate a new trace and send the data to Cloud Trace where it will be viewable in the [Google Cloud Console Traces Viewer](https://console.cloud.google.com/traces/traces).

   ```
   Wait some time for the Trace to be populated.
   Retrieved trace: 1be886734c6a4053adc4346b2b9040c5
   It has the following spans: 
   Span: nativeimage-trace-sample-test
   ```

4. Run the test in native-image mode:

   ```
   $ mvn test -P native
   ```
