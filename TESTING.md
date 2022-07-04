## Google Cloud Java tools for testing

This library provides tools to help write tests for code that uses the following google-cloud services:

-  [BigQuery](#testing-code-that-uses-bigquery)
-  [Compute](#testing-code-that-uses-compute)
-  [Datastore](#testing-code-that-uses-datastore)
-  [DNS](#testing-code-that-uses-dns)
-  [Logging](#testing-code-that-uses-logging)
-  [PubSub](#testing-code-that-uses-pubsub)
-  [Resource Manager](#testing-code-that-uses-resource-manager)
-  [Storage](#testing-code-that-uses-storage)
-  [Spanner](#testing-code-that-uses-cloud-spanner)

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

1. [Install Cloud SDK](https://cloud.google.com/sdk/downloads)

2. Start the emulator
```
$ gcloud beta emulators datastore start
```
To determine which host/port the emulator is running on:
```
$ gcloud beta emulators datastore env-init
# Sample output:
#   export DATASTORE_EMULATOR_HOST=localhost:8759
```
3. Point your client to the emulator

```java
DatastoreOptions options = DatastoreOptions.newBuilder()
    .setProjectId(DatastoreOptions.getDefaultProjectId())
    .setHost(System.getenv("DATASTORE_EMULATOR_HOST"))
    .setCredentials(NoCredentials.getInstance())
    .setRetrySettings(ServiceOptions.getNoRetrySettings())
    .build();
Datastore datastore = options.getService();
```
4. Run your tests

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

You can test against a Pub/Sub emulator:

1. [Set up the emulator](https://cloud.google.com/pubsub/docs/emulator)

### Testing code that uses Redis

Currently, there isn't an emulator for Redis. An alternative is to create a test project.

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

#### On your machine

You can test against an in-memory local Storage. The in-memory configuration supports only limited number of operations; please refer to the `LocalStorageHelper` class documentation for more details. Please use `RemoteStorageHelper` (see next section) if you need to use operations which are not supported by `LocalStorageHelper`. 

To use the in-memory configuration please follow these steps:

1. Follow the [Quickstart instructions][cloud-nio] to add the nio dependency to your project.
2. In your program, create and use a fake Storage service object.  For example:

  ```java
  Storage storage = LocalStorageHelper.getOptions().getService();
  ```

3. Run your tests.

#### Remote

The alternative way of testing is to create a test project. This way allows using operations not supported by the in-memory configuration.  `RemoteStorageHelper` contains convenience methods to make setting up and cleaning up the test project easier.  To use this class, follow the steps below:

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

### Testing code that uses Translation

`RemoteTranslateHelper` contains convenience methods to make is easier to run tests against the
Google Translation service.

1. Create a test Google Cloud project.

2. Download a JSON service account credentials file from the Google Developer's Console. See more about this on the [Google Cloud Platform Authentication page][cloud-platform-authentication]
key.

3. Create a `RemoteTranslateHelper` object using your project ID and API key. Here is an example
that uses the `RemoteTranslateHelper` to list supported languages.
  ```java
  RemoteTranslateHelper translateHelper =
      RemoteTranslateHelper.create(PROJECT_ID, new FileInputStream("/path/to/my/JSON/key.json"));
  Translate translate = translateHelper.getOptions().getService();
  List<Language> languages = translate.listSupportedLanguages();
  ```

4. Run your tests.

### Testing code that uses Cloud Spanner

Currently, there isn't an emulator for Cloud Spanner, so an alternative is to create a test project.  `RemoteSpannerHelper` contains convenience methods to make setting up and cleaning up the test project easier.  To use this class, follow the steps below:

1. Create a test Google Cloud project.

2. Download a JSON service account credentials file from the Google Developer's Console. See more about this on the [Google Cloud Platform Authentication page][cloud-platform-authentication].

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
  ```

[cloud-platform-authentication]:https://cloud.google.com/docs/authentication/getting-started
[cloud-platform-storage-authentication]:https://cloud.google.com/storage/docs/authentication?hl=en#service_accounts
[create-service-account]:https://developers.google.com/identity/protocols/OAuth2ServiceAccount#creatinganaccount
[cloud-nio]:https://github.com/googleapis/google-cloud-java/tree/master/google-cloud-clients/google-cloud-contrib/google-cloud-nio
