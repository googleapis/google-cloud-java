# BigQuery Sample Application with Native Image

The BigQuery sample application demonstrates some common operations with [Google Cloud BigQuery](https://cloud.google.com/bigquery) and is compatible with Native Image compilation.


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

   You can follow [the installation instructions](https://www.graalvm.org/docs/getting-started/#install-graalvm).
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

2. [Enable the BigQuery APIs](https://console.cloud.google.com/apis/api/bigquery.googleapis.com).

### Run with Native Image Support

Navigate to this directory in a new terminal.

1. Compile the application using the native image Compiler. This step may take a few minutes.

    ```
    mvn package -P native -DskipTests
    ```

2. Run the application:

    ```
    ./target/native-image-sample
    ```

3. The application will create a sample BigQuery dataset in your GCP project called `nativeimage_test_dataset` and perform some simple operations like creating a table, inserting data, and running a query.

   If you would like to delete the BigQuery dataset later, you can manage your BigQuery resources through [Google Cloud Console](https://console.cloud.google.com/bigquery) to clean up BigQuery resources under your project.

   When you run the application, you'll see output like this in the terminal:

    ```
    Created new table: nativeimage_test_table_2351b0891d2f48af9309bd289c3bad13
    Successfully inserted test row.
    Queried the following records: 
    User id: TestUser-2f39e3ec-d81a-483f-9ec0-b9bd54155710 | age: 40
    Deleted table: nativeimage_test_table_2351b0891d2f48af9309bd289c3bad13
   ```

### Sample Integration test with Native Image Support

In order to run the sample integration test, call the following command:

```
mvn test -Pnative
```
