## gcloud-java tools for testing

This library provides tools to help write tests for code that uses gcloud-java services.

### Testing code that uses Datastore

#### On your machine

You can test against a temporary local datastore by following these steps:

1. Start the local datastore emulator using `LocalGcdHelper`.  This can be done in two ways:
  - Run `LocalGcdHelper.java`'s `main` method with arguments `START` and (optionally) `--port=<port number>`.  This will create a temporary folder on your computer and bind `localhost:<port number>` for communication with the local datastore.  The port number is an optional argument.  If no port number is specified, port 8080 will be used.
  - Call `LocalGcdHelper.start(<project ID>, <port number>)` before running your tests.  Save the `LocalGcdHelper` object returned so that you can stop the emulator later.

2. In your program, create and use a datastore whose host is set host to `localhost:<port number>`.  For example, 
  ```java
  DatastoreOptions options = DatastoreOptions.builder()
      .projectId(PROJECT_ID)
      .host("http://localhost:8080")
      .build();
  Datastore localDatastore = options.service();
  ```
3. Run your tests.

4. Stop the local datastore emulator.
  - If you ran `LocalGcdHelper.java`'s `main` function to start the emulator, run `LocalGcdHelper.java`'s `main` method with arguments `STOP` and (optionally) `--port=<port number>`.  If the port is not supplied, the program will attempt to close the last port started.
  - If you ran `LocalGcdHelper.start()` to start the emulator, call the `stop()` method on the `LocalGcdHelper` object returned by `LocalGcdHelper.start()`.

#### On a remote machine

You can test against a remote datastore emulator as well.  To do this, set the `DatastoreOptions` project endpoint to the hostname of the remote machine, like the example below.

  ```java
  DatastoreOptions options = DatastoreOptions.builder()
      .projectId(PROJECT_ID)
      .host("http://<hostname of machine>:<port>")
      .build();
  Datastore localDatastore = options.service();
  ```

Note that the remote datastore must be running before your tests are run.

### Testing code that uses Storage

Currently, there isn't an emulator for Google Cloud Storage, so an alternative is to create a test project.  `RemoteGcsHelper` contains convenience methods to make setting up and cleaning up the test project easier.  To use this class, follow the steps below:

1. Create a test Google Cloud project.

2. Download a JSON service account credentials file from the Google Developer's Console.  See more about this on the [Google Cloud Platform Storage Authentication page][cloud-platform-storage-authentication]. 

3. Create a `RemoteGcsHelper` object using your project ID and JSON key.
Here is an example that uses the `RemoteGcsHelper` to create a bucket.
  ```java
  RemoteGcsHelper gcsHelper = RemoteGcsHelper.create(PROJECT_ID, "/path/to/my/JSON/key.json");
  Storage storage = gcsHelper.options().service();
  String bucket = RemoteGcsHelper.generateBucketName();
  storage.create(BucketInfo.of(bucket));
  ```

4. Run your tests.

5. Clean up the test project by using `forceDelete` to clear any buckets used.
Here is an example that clears the bucket created in Step 3 with a timeout of 5 seconds.
  ```java
  RemoteGcsHelper.forceDelete(storage, bucket, 5, TimeUnit.SECONDS);
  ```


[cloud-platform-storage-authentication]:https://cloud.google.com/storage/docs/authentication?hl=en#service_accounts
