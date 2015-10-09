Google Cloud Java Client Examples
=================================

Examples for gcloud-java (Java idiomatic client for [Google Cloud Platform][cloud-platform] services).

[![Build Status](https://travis-ci.org/GoogleCloudPlatform/gcloud-java.svg?branch=master)](https://travis-ci.org/GoogleCloudPlatform/gcloud-java)
[![Coverage Status](https://coveralls.io/repos/GoogleCloudPlatform/gcloud-java/badge.svg?branch=master)](https://coveralls.io/r/GoogleCloudPlatform/gcloud-java?branch=master)

-  [Homepage] (https://googlecloudplatform.github.io/gcloud-java/)
-  [Examples] (http://googlecloudplatform.github.io/gcloud-java/apidocs/index.html?com/google/gcloud/examples/package-summary.html)

Quickstart
----------
Add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.gcloud</groupId>
  <artifactId>gcloud-java-examples</artifactId>
  <version>0.0.9</version>
</dependency>
```

To run examples from your command line:

1. Login using gcloud SDK (`gcloud auth login` in command line)

2. Set your current project using `gcloud config set project PROJECT_ID`

3. Compile using Maven (`mvn compile` in command line from your base project directory)

4. Run an example using Maven from command line.

  Here's an example run of `DatastoreExample`.
  
  Note that you have to enable the Google Cloud Datastore API on the [Google Developers Console][developers-console] before running the following commands.
  ```
  $mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.DatastoreExample" -Dexec.args="my_name add my\ comment"
  $mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.DatastoreExample" -Dexec.args="my_name display"
  $mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.DatastoreExample" -Dexec.args="my_name delete"
  ```

  Here's an example run of `StorageExample`.

  Before running the example, go to the [Google Developers Console][developers-console] to ensure that Google Cloud Storage API is enabled and that you have a bucket.  Also ensure that you have a test file (`test.txt` is chosen here) to upload to Cloud Storage stored locally on your machine.
  ```
  $mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.StorageExample" -Dexec.args="upload /path/to/test.txt <bucket_name>"
  $mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.StorageExample" -Dexec.args="list <bucket_name>"
  $mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.StorageExample" -Dexec.args="download <bucket_name> test.txt"
  $mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.StorageExample" -Dexec.args="delete <bucket_name> test.txt"
```

Contributing
------------

Contributions to this library are always welcome and highly encouraged.

See [CONTRIBUTING] for more information on how to get started.

Java Versions
-------------

Java 7 or above is required for using this client.

Versioning
----------

This library follows [Semantic Versioning] (http://semver.org/).

It is currently in major version zero (``0.y.z``), which means that anything
may change at any time and the public API should not be considered
stable.

License
-------

Apache 2.0 - See [LICENSE] for more information.


[CONTRIBUTING]:https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/CONTRIBUTING.md
[LICENSE]: https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/LICENSE
[cloud-platform]: https://cloud.google.com/
[developers-console]:https://console.developers.google.com/
