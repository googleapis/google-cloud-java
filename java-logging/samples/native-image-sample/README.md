# Cloud Logging Client Libraries with Native Image

This application uses the Google Cloud [Logging Client Libraries](https://github.com/googleapis/java-logging) and can be compiled with Native Image Native Image.

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

4. Enable the [Logging APIs](https://console.cloud.google.com/flows/enableapi?apiid=logging.googleapis.com).

## Sample

Navigate to this directory in a new terminal.

1. Compile the application using the native image Compiler. This step may take a few minutes.

   ```
   mvn package -P native -DskipTests
   ```

2. Run the application:

   ```
   ./target/native-image-sample
   ```

3. The application will log a message to your local terminal and to Google Cloud Console.

   Navigate to the [Cloud Console Logs Viewer](https://console.cloud.google.com/logs/viewer) to view you logs and find the newly generated log entry in Cloud Console:
    ```
    This is a log produced by Native Image.
    ```
### Sample Integration test with Native Image Support
In order to run the sample integration test as a native image, call the following command:

   ```
   mvn test -Pnative
   ```
