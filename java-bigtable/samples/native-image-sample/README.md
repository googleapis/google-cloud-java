# BigTable Sample Application with Native Image

This application uses the [Google Cloud BigTable Client Libraries](https://cloud.google.com/bigtable/docs/reference/libraries) and is compatible with Native Image compilation.

The application runs through some simple BigTable Client Library operations to demonstrate compatibility.

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

   Once you finish following the instructions, verify that the default version of Java is set to the GraalVM version by running `java -version` in a terminal.

   You will see something similar to the below output:

    ```
    $ java -version
   
    openjdk version "17.0.3" 2022-04-19
    OpenJDK Runtime Environment GraalVM CE 22.1.0 (build 17.0.3+7-jvmci-22.1-b06)
    OpenJDK 64-Bit Server VM GraalVM CE 22.1.0 (build 17.0.3+7-jvmci-22.1-b06, mixed mode, sharing)
    ```
   
## BigTable Environment setup
The following sections describe how you can run the sample application against the BigTable emulator or a real BigTable instance.

1. *(Using emulator)* If you wish to run the application against the [BigTable emulator](https://cloud.google.com/bigtable/docs/emulator), ensure that you have the [Google Cloud SDK](https://cloud.google.com/sdk) installed.

       In a new terminal window, start the emulator via `gcloud`:

       ```
       gcloud beta emulators bigtable start --host-port=localhost:9010
       ```

       Leave the emulator running in this terminal for now.
       In the next section, we will run the sample application against the BigTable emulator instance.

2. *(Using real BigTable instance)* If instead you wish to run the application against a real BigTable instance, ensure you already have a BigTable instance created.

   For example, the following command creates a new BigTable instance named `nativeimage-test-instance`.

   ```
   gcloud bigtable instances create nativeimage-test-instance \
       --cluster=nativeimage-test-cluster \
       --cluster-zone=us-central1-c \
       --cluster-num-nodes=1 \
       --display-name=nativeimage-test-instance
   ```

   You can also manually manage your BigTable resources through the [BigTable Cloud Console view](http://console.cloud.google.com/bigtable).

## Run with Native Image Compilation

1. Compile the application with the Native Image compiler.

    ```
    mvn package -P native -DskipTests
    ```

2. **(Optional)** If you're using the emulator, export the `BIGTABLE_EMULATOR_HOST` as an environment variable in your terminal.

    ```
    export BIGTABLE_EMULATOR_HOST=localhost:9010
    ``` 

   The BigTable Client Libraries will detect this environment variable and automatically connect to the emulator instance if this variable is set.

3. Run the application.
   Pass in the BigTable instance you wish to use via the `-Dbigtable.instance` property.

    ```
    ./target/bigtable-sample -Dbigtable.instance={BIGTABLE_INSTANCE_NAME}
    ```

4. The application will run through some basic BigTable operations and log some output statements.

    ```
    Created table: nativeimage-test-table2b5b0031-f4ea-4c39-bc0c-bf6c3c62c90c
    Successfully wrote row: phone#1608775178843000
    Reading phone data in table: 
    Key: phone#1608775178843000
        connected_cell:  @1608775178843000
        connected_wifi:  @1608775178843000
        os_build: PQ2A.190405.003 @1608775178843000
    Deleted table: nativeimage-test-table2b5b0031-f4ea-4c39-bc0c-bf6c3c62c90c
    ```
## Run integration test for the sample

In order to run the sample's integration test, call the following command:

   ```
    mvn test -P native 
   ```
