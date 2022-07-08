# Cloud Tasks Sample Application with Native Image

The Cloud Tasks sample application demonstrates some common operations with
[Google Cloud Tasks](https://cloud.google.com/tasks) and is compatible with
Native Image compilation.

This application will create a new queue called `graal-test-queue` if it does
not already exist.
It will then submit a new task to this queue.

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

4. [Enable the Cloud Tasks APIs](https://console.cloud.google.com/apis/api/cloudtasks.googleapis.com).

### Run with Native Image Compilation

Navigate to this directory in a new terminal.

1. The project uses an environment variable `LOCATION_ID` to run the test. Set the environment variable by calling:

   ```
   export LOCATION_ID=us-east1
   ```
 
2. Compile the application using the native image Compiler. This step may take a few minutes.

   ```
   $ mvn package -P native
   ```

   
    
3. Run the application:

   ```
   $ ./target/native-image-sample
   ```

4. The application runs through some basic Cloud Tasks operations (create queue, create task) and then prints some results of the operations.

   ```
   Test queue ready: name: "projects/xxxxxxxxxx/locations/us-central1/queues/graal-test-queue-4009"
   rate_limits {
   max_dispatches_per_second: 500.0
   max_burst_size: 100
   max_concurrent_dispatches: 1
   }
   retry_config {
   max_attempts: 100
   min_backoff {
   nanos: 100000000
   }
   max_backoff {
   seconds: 3600
   }
   max_doublings: 16
   }
   state: RUNNING
   
   Created task: name: "projects/xxxxxxxxxx/locations/us-central1/queues/graal-test-queue-4009/tasks/5886258204485021611"
   http_request {
   url: "https://google.com/"
   http_method: GET
   headers {
   key: "User-Agent"
   value: "Google-Cloud-Tasks"
   }
   }
   schedule_time {
   seconds: 1613189391
   nanos: 486293000
   }
   create_time {
   seconds: 1613189391
   }
   dispatch_deadline {
   seconds: 600
   }
   view: BASIC
   
   Queue purged
   Queue deleted
   ```

5. Run the test in the project in the native-image mode

   ```
   $ export LOCATION_ID=us-east1 && mvn test -P native
   ...
   [INFO] -------------------------------------------------------
   [INFO]  T E S T S
   [INFO] -------------------------------------------------------
   [INFO] Running com.example.tasks.ITNativeImageTasksSample
   ...
   [INFO] --- native-maven-plugin:0.9.9:test (test-native) @ native-image-sample ---
   [INFO] ====================
   [INFO] Initializing project: native-image-sample
   ...
   com.example.tasks.ITNativeImageTasksSample > testRunSampleApplication SUCCESSFUL
   
   
   Test run finished after 1025 ms
   [         3 containers found      ]
   [         0 containers skipped    ]
   [         3 containers started    ]
   [         0 containers aborted    ]
   [         3 containers successful ]
   [         0 containers failed     ]
   [         1 tests found           ]
   [         0 tests skipped         ]
   [         1 tests started         ]
   [         0 tests aborted         ]
   [         1 tests successful      ]
   [         0 tests failed          ]
   
   [INFO] ------------------------------------------------------------------------
   [INFO] BUILD SUCCESS
   [INFO] ------------------------------------------------------------------------
   [INFO] Total time:  02:27 min
   ...
   ```
