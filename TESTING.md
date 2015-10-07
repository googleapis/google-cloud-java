## gcloud-java tools for testing

gcloud-java provides tools to make testing your application easier.

### Testing interactions with Datastore

#### On your machine

You can test against a temporary local datastore by following these steps:

1. Start the local datastore emulator using `LocalGcdHelper`.  This can be done in two ways:
  - Run `LocalGcdHelper.java`'s `main` method with arguments `START` and (optionally) `--port=<port number>`.  This will create a temporary folder on your computer and bind `localhost:<port number>` for communication with the local datastore.  The port number is an optional argument.  If no port number is specified, port 8080 will be used.
  - Call `LocalGcdHelper.start(<project ID>, <port number>)` before running your tests.  Save the `LocalGcdHelper` object returned so that you can stop the emulator later.

2. In your program, create and use a datastore whose host is set host to `localhost:<port number>`.  For example, 
  ```java
  DatastoreOptions options = DatastoreOptions.builder()
      .projectId(PROJECT_ID)
      .host("localhost:8080")
      .build();
  Datastore localDatastore = DatastoreFactory.instance().get(options);
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
      .host("http://<hostname of machine>")
      .build();
  Datastore localDatastore = DatastoreFactory.instance().get(options);
  ```

Note that the remote datastore must be running before your tests are run.  Also note that the `host` argument must start with "http://" or "https://".


### Testing interactions with Storage

There currently isn't an emulator for Google Cloud Storage, so an alternative is to create a test project.  `RemoteGcsHelper` contains convenience methods to make setting up and cleaning up the test project easier.  To use this class, follow the steps below:

1. Create a test Google App Engine project.

2. Create and download a JSON key by going to the Google Developer's Console and clicking API's & Auth > Credentials > Add Credentials > Service Credentials.  Choose "JSON", download the file, and note its location.

3. Set environment variables `GCLOUD_TESTS_PROJECT_ID` and `GCLOUD_TESTS_KEY_PATH` according to your test project's ID and the location of the newly-downloaded JSON key file.

4. Create and and use a `RemoteGcsHelper` object.
Here is an example that uses the RemoteGcsHelper to create a bucket and clear the bucket at the end of the test.
```java
RemoteGcsHelper gcsHelper = RemoteGcsHelper.create();
Storage storage = StorageFactory.instance().get(gcsHelper.options());
String bucket = RemoteGcsHelper.generateBucketName();
storage.create(BucketInfo.of(bucket));
// Do tests using Storage
RemoteGcsHelper.deleteBucketRecursively(storage, bucket, 5, TimeUnit.SECONDS);
```
