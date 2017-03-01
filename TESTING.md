## Google Cloud Java tools for testing

This library provides tools to help write tests for code that uses the following google-cloud services:

-  [BigQuery] (#testing-code-that-uses-bigquery)
-  [Compute] (#testing-code-that-uses-compute)
-  [Datastore] (#testing-code-that-uses-datastore)
-  [DNS] (#testing-code-that-uses-dns)
-  [Logging] (#testing-code-that-uses-logging)
-  [PubSub] (#testing-code-that-uses-pubsub)
-  [Resource Manager] (#testing-code-that-uses-resource-manager)
-  [Storage] (#testing-code-that-uses-storage)
-  [Spanner] (#testing-code-that-uses-cloud-spanner)

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
  BigQuery bigquery = bigqueryHelper.getOptions().getService();
  String dataset = RemoteBigQueryHelper.generateDatasetName();
  bigquery.create(DatasetInfo.newBuilder(dataset).build());
  ```

4. Run your tests.

5. Clean up the test project by using `forceDelete` to clear any datasets used.
Here is an example that clears the dataset created in Step 3.
  ```java
  RemoteBigQueryHelper.forceDelete(bigquery, dataset);
  ```

### Testing code that uses Compute

Currently, there isn't an emulator for Google Compute, so an alternative is to create a test
project. `RemoteComputeHelper` contains convenience methods to make setting up the test project
easier. To use this class, follow the steps below:

1. Create a test Google Cloud project.

2. Download a [JSON service account credentials file][create-service-account] from the Google
Developer's Console.

3. Create a `RemoteComputeHelper` object using your project ID and JSON key. Here is an example that
uses the `RemoteComputeHelper` to create an address.
  ```java
  RemoteComputeHelper computeHelper =
      RemoteBigQueryHelper.create(PROJECT_ID, new FileInputStream("/path/to/my/JSON/key.json"));
  Compute compute = computeHelper.getOptions().getService();
  // Pick a name for the resource with low probability of clashing
  String addressName = RemoteComputeHelper.baseResourceName() + "address";
  AddressId addressId = RegionAddressId.of(REGION, addressName);
  AddressInfo addressInfo = AddressInfo.of(addressId);
  Operation operation = compute.create(addressInfo);
  ```

4. Run your tests.

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
  Datastore localDatastore = helper.getOptions().getService();
  ```

3. Run your tests.

4. Stop the local datastore emulator by calling the `stop()` method, like so:
  ```java
  helper.stop();
  ```

#### On a remote machine

You can test against a remote Datastore emulator as well.  To do this, set the `DatastoreOptions` project endpoint to the hostname of the remote machine, like the example below.

  ```java
  DatastoreOptions options = DatastoreOptions.newBuilder()
      .setProjectId("my-project-id") // must match project ID specified on remote machine
      .setHost("http://<hostname of machine>:<port>")
      .setCredentials(NoCredentials.getInstance())
      .build();
  Datastore localDatastore = options.getService();
  ```

We recommend that you start the emulator on the remote machine using the [Google Cloud SDK](https://cloud.google.com/sdk/gcloud/reference/beta/emulators/datastore/) from command line, as shown below:

```
gcloud beta emulators datastore start --host-port <hostname of machine>:<port>
```

### Testing code that uses DNS

Currently, there isn't an emulator for DNS. An alternative is to create a test project.

### Testing code that uses Logging

Currently, there isn't an emulator for Stackdriver Logging, so an alternative is to create a test
project. `RemoteLoggingHelper` contains convenience methods to make setting up the test project
easier. To use this class, follow the steps below:

1. Create a test Google Cloud project.

2. Download a [JSON service account credentials file][create-service-account] from the Google
Developer's Console.

3. Create a `RemoteLoggingHelper` object using your project ID and JSON key. Here is an example that
uses the `RemoteLoggingHelper` to create a metric.
  ```java
  RemoteLoggingHelper loggingHelper =
      RemoteLoggingHelper.create(PROJECT_ID, new FileInputStream("/path/to/my/JSON/key.json"));
  Logging logging = loggingHelper.getOptions().getService();
  // Pick a name for the resource with low probability of clashing
  String metricName = RemoteLoggingHelper.formatForTest("test-metric");
  MetricInfo metricInfo = MetricInfo.of(name, "logName:syslog");
  Metric metric = logging.create(metricInfo);
  ```

4. Run your tests.

### Testing code that uses Pub/Sub

#### On your machine

You can test against a temporary local Pub/Sub by following these steps:

1. Start the local Pub/Sub emulator before running your tests using `LocalPubSubHelper`'s `create`
and `start` methods. This will bind a port for communication with the local Pub/Sub emulator.
  ```java
  LocalPubSubHelper helper = LocalPubSubHelper.create();

  helper.start(); // Starts the local Pub/Sub emulator in a separate process
  ```

2. Create and use a `PubSub` object with the options given by the `LocalPubSubHelper` instance. For
example:
  ```java
  PubSub localPubsub = helper.getOptions().getService();
  ```

3. Run your tests.

4. Stop the local Pub/Sub emulator by calling the `stop()` method, like so:
  ```java
  helper.stop();
  ```

#### On a remote machine

You can test against a remote Pub/Sub emulator as well. To do this, set the `PubSubOptions` project
endpoint to the hostname of the remote machine, like the example below.

  ```java
  PubSubOptions options = PubSubOptions.newBuilder()
      .setProjectId("my-project-id") // must match project ID specified on remote machine
      .setHost("<hostname of machine>:<port>")
      .setCredentials(NoCredentials.getInstance())
      .build();
  PubSub localPubsub = options.getService();
  ```

### Testing code that uses Resource Manager

#### On your machine

You can test against an in-memory local Resource Manager by following these steps:

1. Before running your testing code, start the Resource Manager emulator `LocalResourceManagerHelper`. This can be done as follows:

  ```java
  LocalResourceManagerHelper helper = LocalResourceManagerHelper.create();
  helper.start();
  ```

  This will spawn a server thread that listens to `localhost` at an ephemeral port for Resource Manager requests.

2. In your program, create and use a Resource Manager service object whose host is set to `localhost` at the appropriate port.  For example:

  ```java
  ResourceManager resourceManager = LocalResourceManagerHelper.getOptions().getService();
  ```

3. Run your tests.

4. Stop the Resource Manager emulator.

  ```java
  helper.stop();
  ```

  This method will block until the server thread has been terminated.

### Testing code that uses Storage

Currently, there isn't an emulator for Google Cloud Storage, so an alternative is to create a test project.  `RemoteStorageHelper` contains convenience methods to make setting up and cleaning up the test project easier.  To use this class, follow the steps below:

1. Create a test Google Cloud project.

2. Download a JSON service account credentials file from the Google Developer's Console.  See more about this on the [Google Cloud Platform Storage Authentication page][cloud-platform-storage-authentication].

3. Create a `RemoteStorageHelper` object using your project ID and JSON key.
Here is an example that uses the `RemoteStorageHelper` to create a bucket.
  ```java
  RemoteStorageHelper helper =
      RemoteStorageHelper.create(PROJECT_ID, new FileInputStream("/path/to/my/JSON/key.json"));
  Storage storage = helper.getOptions().getService();
  String bucket = RemoteStorageHelper.generateBucketName();
  storage.create(BucketInfo.of(bucket));
  ```

4. Run your tests.

5. Clean up the test project by using `forceDelete` to clear any buckets used.
Here is an example that clears the bucket created in Step 3 with a timeout of 5 seconds.
  ```java
  RemoteStorageHelper.forceDelete(storage, bucket, 5, TimeUnit.SECONDS);
  ```

### Testing code that uses Translate

`RemoteTranslateHelper` contains convenience methods to make is easier to run tests against the
Google Translate service.

1. Create a test Google Cloud project.

2. Follow [Translate Quickstart](https://cloud.google.com/translate/v2/quickstart) to get an API
key.

3. Create a `RemoteTranslateHelper` object using your project ID and API key. Here is an example
that uses the `RemoteTranslateHelper` to list supported languages.
  ```java
  RemoteTranslateHelper translateHelper = RemoteTranslateHelper.create(PROJECT_ID, API_KEY);
  Translate translate = translateHelper.getOptions().getService();
  List<Language> languages = translate.listSupportedLanguages();
  ```

4. Run your tests.

### Testing code that uses Cloud Spanner

Currently, there isn't an emulator for Cloud Spanner, so an alternative is to create a test project.  `RemoteSpannerHelper` contains convenience methods to make setting up and cleaning up the test project easier.  To use this class, follow the steps below:

1. Create a test Google Cloud project.

2. Download a JSON service account credentials file from the Google Developer's Console.  See more about this on the [Google Cloud Platform Storage Authentication page][cloud-platform-storage-authentication].

3. Create or use an existing Cloud Spanner Instance.

4. Create a `RemoteSpannerHelper` object using your instance ID and
   `SpannerOptions` pointing to the credentials file.
Here is an example that uses the `RemoteSpannerHelper` to create a database.
  ```java
  SpannerOptions options = SpannerOptions.newBuilder()
      .setCredentials(GoogleCredentials.fromStream(new FileInputStream("/path/to/my/JSON/key.json")))
      .build()
  RemoteSpannerHelper helper =
      RemoteSpannerHelper.create(options, InstanceId.of(options.getProjectId(), INSTANCE_ID),
        new FileInputStream("/path/to/my/JSON/key.json"));
  Database db = RemoteSpannerHelper.createTestDatabase("my ddl statements"...);
  DatabaseClient client = RemoteSpannerHelper.getDatabaseClient(db);
  ```

5. Run your tests.

6. Clean up the test project by using `cleanUp` to clear any databases created.
  ```java
  RemoteSpannerHelper.cleanUp();

[cloud-platform-storage-authentication]:https://cloud.google.com/storage/docs/authentication?hl=en#service_accounts
[create-service-account]:https://developers.google.com/identity/protocols/OAuth2ServiceAccount#creatinganaccount
