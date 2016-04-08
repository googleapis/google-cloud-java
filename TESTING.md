## gcloud-java tools for testing

This library provides tools to help write tests for code that uses the following gcloud-java services:

-  [Datastore] (#testing-code-that-uses-datastore)
-  [Storage] (#testing-code-that-uses-storage)
-  [Resource Manager] (#testing-code-that-uses-resource-manager)
-  [BigQuery] (#testing-code-that-uses-bigquery)

### Testing code that uses Datastore

#### On your machine

You can test against a temporary local Datastore by following these steps:

1. Start the local Datastore emulator before running your tests using `LocalDatastoreHelper`'s `create` and `start` methods. This will create a temporary folder on your computer and bind a port for communication with the local Datastore. There is an optional argument for `create`: consistency. The consistency setting controls the fraction of Datastore writes that are immediately visible in global queries.
  ```java
  // Use the default consistency setting of 0.9
  LocalDatastoreHelper helper = LocalDatastoreHelper.create();
  // or explicitly set the consistency
  helper = LocalDatastoreHelper.create(0.6);

  helper.start(); // Starts the local Datastore emulator in a separate process
  ```

2. Create and use a `Datastore` object with the options given by the `LocalDatastoreHelper` instance.  For example:
  ```java
  Datastore localDatastore = helper.options().service();
  ```

3. Run your tests.

4. Stop the local datastore emulator by calling the `stop()` method, like so:
  ```java
  helper.stop();
  ```

#### On a remote machine

You can test against a remote Datastore emulator as well.  To do this, set the `DatastoreOptions` project endpoint to the hostname of the remote machine, like the example below.

  ```java
  DatastoreOptions options = DatastoreOptions.builder()
      .projectId("my-project-id") // must match project ID specified on remote machine
      .host("http://<hostname of machine>:<port>")
      .authCredentials(AuthCredentials.noAuth())
      .build();
  Datastore localDatastore = options.service();
  ```

We recommend that you start the emulator on the remote machine using the [Google Cloud SDK](https://cloud.google.com/sdk/gcloud/reference/beta/emulators/datastore/) from command line, as shown below:

```
gcloud beta emulators datastore start --host-port <hostname of machine>:<port>
```

### Testing code that uses Storage

Currently, there isn't an emulator for Google Cloud Storage, so an alternative is to create a test project.  `RemoteStorageHelper` contains convenience methods to make setting up and cleaning up the test project easier.  To use this class, follow the steps below:

1. Create a test Google Cloud project.

2. Download a JSON service account credentials file from the Google Developer's Console.  See more about this on the [Google Cloud Platform Storage Authentication page][cloud-platform-storage-authentication]. 

3. Create a `RemoteStorageHelper` object using your project ID and JSON key.
Here is an example that uses the `RemoteStorageHelper` to create a bucket.
  ```java
  RemoteStorageHelper helper =
      RemoteStorageHelper.create(PROJECT_ID, new FileInputStream("/path/to/my/JSON/key.json"));
  Storage storage = helper.options().service();
  String bucket = RemoteStorageHelper.generateBucketName();
  storage.create(BucketInfo.of(bucket));
  ```

4. Run your tests.

5. Clean up the test project by using `forceDelete` to clear any buckets used.
Here is an example that clears the bucket created in Step 3 with a timeout of 5 seconds.
  ```java
  RemoteStorageHelper.forceDelete(storage, bucket, 5, TimeUnit.SECONDS);
  ```

### Testing code that uses Resource Manager

#### On your machine

You can test against a temporary local Resource Manager by following these steps:

1. Before running your testing code, start the Resource Manager emulator `LocalResourceManagerHelper`. This can be done as follows:

  ```java
  import com.google.gcloud.resourcemanager.testing.LocalResourceManagerHelper;

  LocalResourceManagerHelper helper = LocalResourceManagerHelper.create();
  helper.start();
  ```

  This will spawn a server thread that listens to `localhost` at an ephemeral port for Resource Manager requests.

2. In your program, create and use a Resource Manager service object whose host is set to `localhost` at the appropriate port.  For example:

  ```java
  ResourceManager resourceManager = LocalResourceManagerHelper.options().service();
  ```

3. Run your tests.

4. Stop the Resource Manager emulator.

  ```java
  helper.stop();
  ```

  This method will block until the server thread has been terminated.

### Testing code that uses BigQuery

Currently, there isn't an emulator for Google BigQuery, so an alternative is to create a test
project. `RemoteBigQueryHelper` contains convenience methods to make setting up and cleaning up the
test project easier. To use this class, follow the steps below:

1. Create a test Google Cloud project.

2. Download a [JSON service account credentials file][create-service-account] from the Google
Developer's Console.

3. Create a `RemoteBigQueryHelper` object using your project ID and JSON key.
Here is an example that uses the `RemoteBigQueryHelper` to create a dataset.
  ```java
  RemoteBigQueryHelper bigqueryHelper =
      RemoteBigQueryHelper.create(PROJECT_ID, new FileInputStream("/path/to/my/JSON/key.json"));
  BigQuery bigquery = bigqueryHelper.options().service();
  String dataset = RemoteBigQueryHelper.generateDatasetName();
  bigquery.create(DatasetInfo.builder(dataset).build());
  ```

4. Run your tests.

5. Clean up the test project by using `forceDelete` to clear any datasets used.
Here is an example that clears the dataset created in Step 3.
  ```java
  RemoteBigQueryHelper.forceDelete(bigquery, dataset);
  ```

[cloud-platform-storage-authentication]:https://cloud.google.com/storage/docs/authentication?hl=en#service_accounts
[create-service-account]:https://developers.google.com/identity/protocols/OAuth2ServiceAccount#creatinganaccount
