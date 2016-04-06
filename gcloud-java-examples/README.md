Google Cloud Java Client Examples
=================================

Examples for gcloud-java (Java idiomatic client for [Google Cloud Platform][cloud-platform] services).

[![Build Status](https://travis-ci.org/GoogleCloudPlatform/gcloud-java.svg?branch=master)](https://travis-ci.org/GoogleCloudPlatform/gcloud-java)
[![Coverage Status](https://coveralls.io/repos/GoogleCloudPlatform/gcloud-java/badge.svg?branch=master)](https://coveralls.io/r/GoogleCloudPlatform/gcloud-java?branch=master)
[![Maven](https://img.shields.io/maven-central/v/com.google.gcloud/gcloud-java-examples.svg)]( https://img.shields.io/maven-central/v/com.google.gcloud/gcloud-java-examples.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/gcloud-java)
[![Dependency Status](https://www.versioneye.com/user/projects/56bd8ee72a29ed002d2b0969/badge.svg?style=flat)](https://www.versioneye.com/user/projects/56bd8ee72a29ed002d2b0969)

-  [Homepage] (https://googlecloudplatform.github.io/gcloud-java/)
-  [Examples] (http://googlecloudplatform.github.io/gcloud-java/apidocs/index.html?com/google/gcloud/examples/package-summary.html)

Quickstart
----------
If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.gcloud</groupId>
  <artifactId>gcloud-java-examples</artifactId>
  <version>0.1.7</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.gcloud:gcloud-java-examples:0.1.7'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.gcloud" % "gcloud-java-examples" % "0.1.7"
```

To run examples from your command line:

1. Login using gcloud SDK (`gcloud auth login` in command line)

2. Set your current project using `gcloud config set project PROJECT_ID`. This step is not necessary for `ResourceManagerExample`.

3. Compile using Maven (`mvn compile` in command line from your base project directory)

4. Run an example using Maven from command line.

  * Here's an example run of `BigQueryExample`.

    Before running the example, go to the [Google Developers Console][developers-console] to ensure
    that BigQuery API is enabled. You can upload a CSV file `my_csv_file` to the `my_bucket` bucket
    (replace `my_csv_file` and `my_bucket` with actual file and bucket names) using the GCS
    [web browser](https://console.developers.google.com/storage/browser). The CSV file will be used to
    load data into a BigQuery table and should look something like:
    ```csv
    value1
    value2
    value3
    ```
    Then you are ready to run the following example:
    ```
    mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.bigquery.BigQueryExample" -Dexec.args="create dataset new_dataset_id"
    mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.bigquery.BigQueryExample" -Dexec.args="create table new_dataset_id new_table_id field_name:string"
    mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.bigquery.BigQueryExample" -Dexec.args="list tables new_dataset_id"
    mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.bigquery.BigQueryExample" -Dexec.args="load new_dataset_id new_table_id CSV gs://my_bucket/my_csv_file"
    mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.bigquery.BigQueryExample" -Dexec.args="query 'select * from new_dataset_id.new_table_id'"
    ```

  * Here's an example run of `DatastoreExample`.

    Be sure to change the placeholder project ID "your-project-id" with your own project ID. Also note that you have to enable the Google Cloud Datastore API on the [Google Developers Console][developers-console] before running the following commands.
    ```
    mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.datastore.DatastoreExample" -Dexec.args="your-project-id my_name add my\ comment"
    mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.datastore.DatastoreExample" -Dexec.args="your-project-id my_name display"
    mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.datastore.DatastoreExample" -Dexec.args="your-project-id my_name delete"
    ```

  * Here's an example run of `DnsExample`.

    Note that you have to enable the Google Cloud DNS API on the [Google Developers Console][developers-console] before running the following commands.
    You will need to replace the domain name `elaborateexample.com` with your own domain name with [verified ownership] (https://www.google.com/webmasters/verification/home).
    Also, note that the example creates and deletes record sets of type A only. Operations with other record types are not implemented in the example.
    ```
    mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.dns.DnsExample" -Dexec.args="create some-sample-zone elaborateexample.com. description"
    mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.dns.DnsExample" -Dexec.args="list"
    mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.dns.DnsExample" -Dexec.args="list some-sample-zone records"
    mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.dns.DnsExample" -Dexec.args="add-record some-sample-zone www.elaborateexample.com. 12.13.14.15 69"
    mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.dns.DnsExample" -Dexec.args="get some-sample-zone"
    mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.dns.DnsExample" -Dexec.args="delete-record some-sample-zone www.elaborateexample.com. 12.13.14.15 69"
    mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.dns.DnsExample" -Dexec.args="list some-sample-zone changes ascending"
    mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.dns.DnsExample" -Dexec.args="delete some-sample-zone"
    ```

  * Here's an example run of `ResourceManagerExample`.

    Be sure to change the placeholder project ID "your-project-id" with your own globally unique project ID.
    ```
    mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.resourcemanager.ResourceManagerExample" -Dexec.args="create your-project-id"
    mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.resourcemanager.ResourceManagerExample" -Dexec.args="list"
    mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.resourcemanager.ResourceManagerExample" -Dexec.args="get your-project-id"
    ```

  * Here's an example run of `StorageExample`.

    Before running the example, go to the [Google Developers Console][developers-console] to ensure that "Google Cloud Storage" and "Google Cloud Storage JSON API" are enabled and that you have a bucket.  Also ensure that you have a test file (`test.txt` is chosen here) to upload to Cloud Storage stored locally on your machine.
    ```
    mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.storage.StorageExample" -Dexec.args="upload /path/to/test.txt <bucket_name>"
    mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.storage.StorageExample" -Dexec.args="list <bucket_name>"
    mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.storage.StorageExample" -Dexec.args="download <bucket_name> test.txt"
    mvn exec:java -Dexec.mainClass="com.google.gcloud.examples.storage.StorageExample" -Dexec.args="delete <bucket_name> test.txt"
    ```

Troubleshooting
---------------

To get help, follow the `gcloud-java` links in the `gcloud-*` [shared Troubleshooting document](https://github.com/GoogleCloudPlatform/gcloud-common/blob/master/troubleshooting/readme.md#troubleshooting).

Java Versions
-------------

Java 7 or above is required for using this client.

Versioning
----------

This library follows [Semantic Versioning] (http://semver.org/).

It is currently in major version zero (``0.y.z``), which means that anything
may change at any time and the public API should not be considered
stable.

Contributing
------------

Contributions to this library are always welcome and highly encouraged.

See `gcloud-java`'s [CONTRIBUTING] documentation and the `gcloud-*` [shared documentation](https://github.com/GoogleCloudPlatform/gcloud-common/blob/master/contributing/readme.md#how-to-contribute-to-gcloud) for more information on how to get started.

Please note that this project is released with a Contributor Code of Conduct. By participating in this project you agree to abide by its terms. See [Code of Conduct][code-of-conduct] for more information.

License
-------

Apache 2.0 - See [LICENSE] for more information.


[CONTRIBUTING]:https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/CONTRIBUTING.md
[code-of-conduct]:https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[LICENSE]: https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/LICENSE
[cloud-platform]: https://cloud.google.com/
[developers-console]:https://console.developers.google.com/
