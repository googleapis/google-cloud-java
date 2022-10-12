Google Cloud Java Client Examples
=================================

Examples for google-cloud (Java idiomatic client for [Google Cloud Platform][cloud-platform] services).

[![CircleCI](https://circleci.com/gh/googleapis/google-cloud-java/tree/master.svg?style=shield)](https://circleci.com/gh/googleapis/google-cloud-java/tree/master)
[![Coverage Status](https://coveralls.io/repos/googleapis/google-cloud-java/badge.svg?branch=master)](https://coveralls.io/r/googleapis/google-cloud-java?branch=master)
[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-examples.svg)]( https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-examples.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/google-cloud-java)
[![Dependency Status](https://www.versioneye.com/user/projects/58fe4c8d6ac171426c414772/badge.svg?style=flat)](https://www.versioneye.com/user/projects/58fe4c8d6ac171426c414772)

-  [Examples](https://googleapis.dev/java/google-cloud-clients/latest/index.html?com/google/cloud/examples/package-summary.html)

Quickstart
----------

[//]: # ({x-version-update-start:google-cloud-examples:released})
If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-examples</artifactId>
  <version>0.120.0-alpha</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-examples:0.120.0-alpha'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-examples" % "0.120.0-alpha"
```
[//]: # ({x-version-update-end})

To run examples from your command line:

1. Log in using gcloud SDK (`gcloud auth login` in command line)

2. Set your current project using `gcloud config set project PROJECT_ID`. This step is not necessary for `ResourceManagerExample`.

3. Compile using Maven: `mvn install -DskipTests` in command line from your base project directory
   then `cd google-cloud-examples` and finally `mvn package appassembler:assemble -DskipTests`.

4. Run an example from the command line using the Maven-generated scripts.

  * Here's an example run of `ComputeExample`.

    Before running the example, go to the [Google Developers Console][developers-console] to ensure
    that Compute API is enabled.
    ```
    target/appassembler/bin/ComputeExample create image-disk us-central1-a test-disk debian-cloud debian-8-jessie-v20160329
    target/appassembler/bin/ComputeExample create instance us-central1-a test-instance n1-standard-1 test-disk default
    target/appassembler/bin/ComputeExample add-access-config us-central1-a test-instance nic0 NAT
    target/appassembler/bin/ComputeExample delete instance us-central1-a test-instance
    target/appassembler/bin/ComputeExample delete disk us-central1-a test-disk
    ```

  * Here's an example run of `DatastoreExample`.

    Be sure to change the placeholder project ID "your-project-id" with your own project ID. Also note that you have to enable the Google Cloud Datastore API on the [Google Developers Console][developers-console] before running the following commands.
    ```
    target/appassembler/bin/DatastoreExample your-project-id my_name add my\ comment
    target/appassembler/bin/DatastoreExample your-project-id my_name display
    target/appassembler/bin/DatastoreExample your-project-id my_name delete
    target/appassembler/bin/DatastoreExample your-project-id my_name set myname@mydomain.com 1234
    ```

  * Here's an example run of `DnsExample`.

    Note that you have to enable the Google Cloud DNS API on the [Google Developers Console][developers-console] before running the following commands.
    You will need to replace the domain name `elaborateexample.com` with your own domain name with [verified ownership](https://www.google.com/webmasters/verification/home).
    Also, note that the example creates and deletes record sets of type A only. Operations with other record types are not implemented in the example.
    ```
    target/appassembler/bin/DnsExample create some-sample-zone elaborateexample.com. description
    target/appassembler/bin/DnsExample list
    target/appassembler/bin/DnsExample list some-sample-zone records
    target/appassembler/bin/DnsExample add-record some-sample-zone www.elaborateexample.com. 12.13.14.15 69
    target/appassembler/bin/DnsExample get some-sample-zone
    target/appassembler/bin/DnsExample delete-record some-sample-zone www.elaborateexample.com. 12.13.14.15 69
    target/appassembler/bin/DnsExample list some-sample-zone changes ascending
    target/appassembler/bin/DnsExample delete some-sample-zone
    ```

  * Here's an example run of `LoggingExample`.

    Before running the example, go to the [Google Developers Console][developers-console] to ensure
    that Logging API is enabled.
    ```
    target/appassembler/bin/LoggingExample create metric test-metric severity>=ERROR
    target/appassembler/bin/LoggingExample list metrics
    target/appassembler/bin/LoggingExample create sink test-sink bucket test-bucket severity>=ERROR
    target/appassembler/bin/LoggingExample list sinks
    target/appassembler/bin/LoggingExample write test-log-name ERROR test-message test-key test-value
    target/appassembler/bin/LoggingExample list entries
    ```

  * Here's an example run of `ParallelCountBytes`.

    Before running the example, go to the [Google Developers Console][developers-console] to ensure that Google Cloud Storage API is enabled and that you have a bucket with a file in it.
    ```
    target/appassembler/bin/ParallelCountBytes gs://mybucket/myfile.txt
    ```

  * Here's an example run of `ResourceManagerExample`.

    Be sure to change the placeholder project ID "your-project-id" with your own globally unique project ID.
    ```
    target/appassembler/bin/ResourceManagerExample create your-project-id
    target/appassembler/bin/ResourceManagerExample list
    target/appassembler/bin/ResourceManagerExample get your-project-id
    ```

 * Here's an example run of `Stat`, illustrating the use of google-cloud-nio.

    Before running the example, go to the [Google Developers Console][developers-console] to ensure that Google Cloud Storage API is enabled and that you have a bucket with a file in it.

    Run the sample with (from the google-cloud-examples folder):
    ```
    target/appassembler/bin/Stat --check

    ```
    Or, if you have a file in `gs://mybucket/myfile.txt`, you can run:
    ```
    target/appassembler/bin/Stat gs://mybucket/myfile.txt
    ```

    The sample doesn't have anything special about Google Cloud Storage in it, it just opens files
    via the NIO API. It lists google-cloud-nio as a dependency, and that enables it to interpret
    `gs://` paths.

  * Here's an example run of `TranslateExample`.

    Before running the example, go to the [Google Developers Console][developers-console] to ensure that "Google Translation API" is enabled.
    ```
    target/appassembler/bin/TranslateExample languages
    target/appassembler/bin/TranslateExample detect Hello,\ World!
    target/appassembler/bin/TranslateExample translate ¡Hola\ Mundo!
    target/appassembler/bin/TranslateExample es translate Hello,\ World!
    ```

Troubleshooting
---------------

To get help, follow the instructions in the [shared Troubleshooting document](https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting).

Java Versions
-------------

Java 7 or above is required for using this client.

Versioning
----------

This library follows [Semantic Versioning](http://semver.org/).

It is currently in major version zero (``0.y.z``), which means that anything
may change at any time and the public API should not be considered
stable.

Contributing
------------

Contributions to this library are always welcome and highly encouraged.

See `google-cloud`'s [CONTRIBUTING] documentation and the [shared documentation](https://github.com/googleapis/google-cloud-common/blob/master/contributing/readme.md#how-to-contribute-to-gcloud) for more information on how to get started.

Please note that this project is released with a Contributor Code of Conduct. By participating in this project you agree to abide by its terms. See [Code of Conduct][code-of-conduct] for more information.

License
-------

Apache 2.0 - See [LICENSE] for more information.


[CONTRIBUTING]:https://github.com/googleapis/google-cloud-java/blob/master/CONTRIBUTING.md
[code-of-conduct]:https://github.com/googleapis/google-cloud-java/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[LICENSE]: https://github.com/googleapis/google-cloud-java/blob/master/LICENSE
[cloud-platform]: https://cloud.google.com/
[developers-console]:https://console.developers.google.com/
