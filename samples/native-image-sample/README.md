# Datastore Sample Application with Native Image

This application uses the [Google Cloud Datastore client library](https://cloud.google.com/datastore/docs/reference/libraries) and is compatible with Native Image compilation.

This sample runs through some basic operations of creating/deleting entities, running queries, and running transaction code.

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

   You can follow the [installation instructions](https://www.graalvm.org/docs/getting-started/#install-graalvm).
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
## Sample
1. **(Optional)** If you wish to run the application against the [Datastore emulator](https://cloud.google.com/sdk/gcloud/reference/beta/emulators/datastore), ensure that you have the [Google Cloud SDK](https://cloud.google.com/sdk) installed.

   In a new terminal window, start the emulator via `gcloud`:

    ```
    gcloud beta emulators datastore start --host-port=localhost:9010
    ```

   Leave the emulator running in this terminal for now.
   In the next section, we will run the sample application against the Datastore emulator instance.

2. Navigate to this directory and compile the application with the native image compiler.

    ```
    mvn package -P native -DskipTests
    ```

3. **(Optional)** If you're using the emulator, export the `DATASTORE_EMULATOR_HOST` as an environment variable in your terminal.

    ```
    export DATASTORE_EMULATOR_HOST=localhost:9010
    ``` 

   The Datastore Client Libraries will detect this environment variable and automatically connect to the emulator instance if this variable is set.

4. Run the application.

    ```
    ./target/native-image-sample
    ```

5. The application will run through some basic Datastore operations and log some output statements.

   ```
      Successfully added entity.
      Reading entity: 1cf34cc1-2b8a-4945-9fc4-058f03dcd08e
      Successfully deleted entity: 1cf34cc1-2b8a-4945-9fc4-058f03dcd08e
      Run fake transaction code.
      Found entity:
          name=de4f36f4-3936-4252-98d3-e0d56d485254
          kind=test-kind
          namespace=nativeimage-test-namespace
          properties={description=StringValue{valueType=STRING, excludeFromIndexes=false, meaning=0, value=hello world}}
      Ran transaction callable.
   ```

### Sample Integration test with Native Image Support

In order to run the sample integration test as a native image, call the following command:

   ```
   mvn test -Pnative
   ```
