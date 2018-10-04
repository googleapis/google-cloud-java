# Google Cloud Java Client for Bigtable Admin

Java idiomatic client for [Cloud Bigtable Admin][cloud-bigtable]. Please note that this client is under
heavy development and is not ready for production use. Please continue to use the 
[HBase API client](https://github.com/GoogleCloudPlatform/cloud-bigtable-client) for production.

[![Kokoro CI](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.svg)](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.html)
[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-bigtable.svg)](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-bigtable-admin.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/google-cloud-java)

- [Product Documentation][bigtable-product-docs]
- [Client Library Documentation][bigtable-admin-client-lib-docs]

> Note: This client is under heavy development and should not be used in production.

## Quickstart

[//]: # ({x-version-update-start:google-cloud-bigtable-admin:released})
If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-bigtable-admin</artifactId>
  <version>0.65.0-alpha</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-bigtable-admin:0.65.0-alpha'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-bigtable-admin" % "0.65.0-alpha"
```
[//]: # ({x-version-update-end})

## Authentication

See the
[Authentication](https://github.com/GoogleCloudPlatform/google-cloud-java#authentication)
section in the base directory's README.

## About Cloud Bigtable Admin

[Cloud Bigtable][cloud-bigtable] is Google's NoSQL Big Data database service. It's 
the same database that powers many core Google services, including Search, Analytics, Maps, and
Gmail. The API is split into the data api and the admin api. This client targets the admin api.

Be sure to activate the Cloud Bigtable Admin API on the Developer's Console to use Cloud Bigtable
from your project.

See the [Bigtable Amin client lib docs][bigtable-admin-client-lib-docs] to learn how to
interact with Cloud Bigtable Admin API using this Client Library.

## Getting Started
#### Prerequisites
For this tutorial, you will need a
[Google Developers Console](https://console.developers.google.com/) project with the Cloud Bigtable 
API enabled. You will need to 
[enable billing](https://support.google.com/cloud/answer/6158867?hl=en) to use Google Cloud Bigtable.
[Follow these instructions](https://cloud.google.com/docs/authentication#preparation) to get your
project set up. You will also need to set up the local development environment by [installing the
Google Cloud SDK](https://cloud.google.com/sdk/) and running the following commands in command line:
`gcloud auth login`.

#### Calling Cloud Bigtable

The Cloud Bigtable API is split into 2 parts: Data API, Instance Admin API and Table Admin API.

Here is a code snippet showing simple usage of the Table API. Add the following imports
at the top of your file:


```java
import com.google.bigtable.admin.v2.ColumnFamily;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
```

Then, to create a table, use the following code:
```java
InstanceName instanceName = InstanceName.of("my-project", "my-instance");

TableAdminClient tableAdminClient = TableAdminClient.create(instanceName);

try {
    CreateTable createTableReq = TableAdminRequests.createTable("tableId")
      .addFamily("cf2", GCRULES.maxVersions(10));
    client.createTable(createTableReq);

} finally {
  tableAdminClient.close();
}
```

## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting
document](https://github.com/GoogleCloudPlatform/gcloud-common/blob/master/troubleshooting/readme.md#troubleshooting).

Transport
---------
Bigtable uses gRPC for the transport layer.

## Java Versions

Java 7 or above is required for using this client.

## Versioning

This library follows [Semantic Versioning](http://semver.org/).

It is currently in major version zero (`0.y.z`), which means that anything may
change at any time and the public API should not be considered stable.

## Contributing

Contributions to this library are always welcome and highly encouraged.

See [CONTRIBUTING] for more information on how to get started and [DEVELOPING] for a layout of the
codebase.

## License

Apache 2.0 - See [LICENSE] for more information.

[CONTRIBUTING]:https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/CONTRIBUTING.md
[LICENSE]: https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/LICENSE
[cloud-platform]: https://cloud.google.com/
[cloud-bigtable]: https://cloud.google.com/bigtable/
[bigtable-product-docs]: https://cloud.google.com/bigtable/docs/
[bigtable-admin-client-lib-docs]: https://googlecloudplatform.github.io/google-cloud-java/google-cloud-clients/apidocs/index.html?com/google/cloud/bigtable/admin/v2/package-summary.html
