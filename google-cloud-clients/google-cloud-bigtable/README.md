# Google Cloud Java Client for Bigtable

Java idiomatic client for [Cloud Bigtable][cloud-bigtable]. Please note that this client is under
heavy development and is not ready for production use. Please continue to use the 
[HBase API client](https://github.com/GoogleCloudPlatform/cloud-bigtable-client) for production.

[[![CircleCI](https://circleci.com/gh/GoogleCloudPlatform/google-cloud-java/tree/master.svg?style=shield)](https://circleci.com/gh/GoogleCloudPlatform/google-cloud-java/tree/master)
[![Coverage Status](https://coveralls.io/repos/GoogleCloudPlatform/google-cloud-java/badge.svg?branch=master)](https://coveralls.io/r/GoogleCloudPlatform/google-cloud-java?branch=master)
[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-bigtable.svg)](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-bigtable.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/google-cloud-java)
[![Dependency Status](https://www.versioneye.com/user/projects/58fe4c8d6ac171426c414772/badge.svg?style=flat)](https://www.versioneye.com/user/projects/58fe4c8d6ac171426c414772)

- [Product Documentation][bigtable-product-docs]
- [Client Library Documentation][bigtable-client-lib-docs]

> Note: This client is under heavy development and should not be used in production.

## Quickstart

[//]: # ({x-version-update-start:google-cloud-bigtable:released})
If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-bigtable</artifactId>
  <version>0.59.0-alpha</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-bigtable:0.59.0-alpha'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-bigtable" % "0.59.0-alpha"
```
[//]: # ({x-version-update-end})

## Authentication

See the
[Authentication](https://github.com/GoogleCloudPlatform/google-cloud-java#authentication)
section in the base directory's README.

## About Cloud Bigtable

[Cloud Bigtable][cloud-bigtable] is Google's NoSQL Big Data database service. It's 
the same database that powers many core Google services, including Search, Analytics, Maps, and
Gmail.

Be sure to activate the Cloud Bigtable API and the Cloud Bigtable Admin API on the Developer's 
Console to use Cloud Bigtable from your project.

See the [Bigtable client lib docs][bigtable-client-lib-docs] to learn how to
interact with Cloud Bigtable using this Client Library.

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

The Cloud Bigtable API is split into 3 parts: Data API, Instance Admin API and Table Admin API.

Here is a code snippet showing simple usage of the Data API. Add the following imports
at the top of your file:

```java
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.InstanceName;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;

```

Then, to make a query to Bigtable, use the following code:
```java
// Instantiates a client
String projectId = "my-instance";
String instanceId = "my-database";
String tableId = "my-table";

// Create the client
BigtableDataClient dataClient = BigtableDataClient.create(
    InstanceName.of(projectId, instanceId));

try {
  // Query a table
  Query query = Query.create(tableId)
      .range("a", "z")
      .limit(26);

  for (Row row : dataClient.readRows(query)) {
    System.out.println(row.getKey());
  }
} finally {
  dataClient.close();
}
```

The Admin APIs are similar. Here is a code snippet showing how to create a table. Add the following
imports at the top of your file:

```java
import com.google.bigtable.admin.v2.ColumnFamily;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.Table;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
```

Then, to create a table, use the following code:
```java
String projectId = "my-instance";
String instanceId = "my-database";

BigtableTableAdminClient tableAdminClient = BigtableTableAdminClient.create();

try {
  tableAdminClient.createTable(
      InstanceName.of(projectId, instanceId),
      "new-table-id",
      Table.newBuilder()
          .putColumnFamilies("my-family", ColumnFamily.getDefaultInstance())
          .build()
  );
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
[bigtable-client-lib-docs]: https://googlecloudplatform.github.io/google-cloud-java/google-cloud-clients/apidocs/index.html?com/google/cloud/bigtable/package-summary.html
