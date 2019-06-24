# Google Cloud Bigtable Client for Java

Java idiomatic client for [Cloud Bigtable][cloud-bigtable].

[![Kokoro CI](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.svg)](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.html)
[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-bigtable.svg)](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-bigtable.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/google-cloud-java)

- [Product Documentation][bigtable-product-docs]
- [Client Library Documentation - Data API](https://googleapis.dev/java/google-cloud-clients/latest/com/google/cloud/bigtable/data/v2/package-summary.html)
- [Client Library Documentation - Admin API](https://googleapis.dev/java/google-cloud-clients/latest/com/google/cloud/bigtable/admin/v2/package-summary.html)
> Note: This client is a work-in-progress, and may occasionally make backwards-incompatible changes.

## Quickstart

[//]: # ({x-version-update-start:google-cloud-bigtable:released})
If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-bigtable</artifactId>
  <version>0.97.0</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-bigtable:0.97.0'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-bigtable" % "0.97.0"
```
[//]: # ({x-version-update-end})

## Authentication

See the
[Authentication](https://github.com/googleapis/google-cloud-java#authentication)
section in the base directory's README.

## Getting Started
#### Prerequisites
For this tutorial, you will need a
[Google Cloud Platform Console](https://console.developers.google.com/) project with the Cloud Bigtable 
API enabled. You will need to 
[enable billing](https://support.google.com/cloud/answer/6158867?hl=en) to use Google Cloud Bigtable.
[Follow these instructions](https://cloud.google.com/resource-manager/docs/creating-managing-projects) to get your
project set up. You will also need to set up the local development environment by [installing the
Google Cloud SDK](https://cloud.google.com/sdk/) and running the following commands in command line:
`gcloud auth login`.

## About Cloud Bigtable

[Cloud Bigtable][cloud-bigtable] is Google's NoSQL Big Data database service. It's 
the same database that powers many core Google services, including Search, Analytics, Maps, and
Gmail.

Be sure to activate the Cloud Bigtable API and the Cloud Bigtable Admin API under APIs & Services in the GCP Console to use Cloud Bigtable from your project.

See the Bigtable client library documentation ([Admin API](https://googleapis.dev/java/google-cloud-clients/latest/com/google/cloud/bigtable/admin/v2/package-summary.html) and [Data API](https://googleapis.dev/java/google-cloud-clients/latest/com/google/cloud/bigtable/data/v2/package-summary.html)) to learn how to
interact with Cloud Bigtable using this Client Library.

## Concepts

Cloud Bigtable is composed of instances, clusters, nodes and tables.
 
### Instances
Instances are containers for clusters.
 
### Clusters
Clusters represent the actual Cloud Bigtable service. Each cluster belongs to a single Cloud Bigtable instance, and an instance can have up to 4 clusters. When your application
sends requests to a Cloud Bigtable instance, those requests are actually handled by one of the clusters in the instance.

### Nodes
Each cluster in a production instance has 3 or more nodes, which are compute resources that Cloud Bigtable uses to manage your data.

### Tables
Tables contain the actual data and are replicated across all of the clusters in an instance.


## Clients
The Cloud Bigtable API consists of:

### Data API
Allows callers to persist and query data in a table. It's exposed by [BigtableDataClient](https://googleapis.dev/java/google-cloud-clients/latest/com/google/cloud/bigtable/data/v2/BigtableDataClient.html).

### Admin API
Allows callers to create and manage instances, clusters, tables, and access permissions. This API is exposed by: [BigtableInstanceAdminClient](https://googleapis.dev/java/google-cloud-clients/latest/com/google/cloud/bigtable/admin/v2/BigtableInstanceAdminClient.html) for Instance and Cluster level resources. 
 
See [BigtableTableAdminClient](https://googleapis.dev/java/google-cloud-clients/latest/com/google/cloud/bigtable/admin/v2/BigtableTableAdminClient.html) for table management.

See [BigtableDataClient](https://googleapis.dev/java/google-cloud-clients/latest/com/google/cloud/bigtable/data/v2/BigtableDataClient.html) for the data client.

See [BigtableInstanceAdminClient](https://googleapis.dev/java/google-cloud-clients/latest/com/google/cloud/bigtable/admin/v2/BigtableInstanceAdminClient.html) for the instance admin client.

See [BigtableTableAdminClient](https://googleapis.dev/java/google-cloud-clients/latest/com/google/cloud/bigtable/admin/v2/BigtableTableAdminClient.html) for the table admin client.

#### Calling Cloud Bigtable

The Cloud Bigtable API is split into 3 parts: Data API, Instance Admin API and Table Admin API.

Here is a code snippet showing simple usage of the Data API. Add the following imports
at the top of your file:

```java
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
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
BigtableDataClient dataClient = BigtableDataClient.create(projectId, instanceId);

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
import static com.google.cloud.bigtable.admin.v2.models.GCRules.GCRULES;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.Table;
```

Then, to create a table, use the following code:
```java
String projectId = "my-instance";
String instanceId = "my-database";

BigtableTableAdminClient tableAdminClient = BigtableTableAdminClient
  .create(projectId, instanceId);

try {
  tableAdminClient.createTable(
      CreateTableRequest.of("my-table")
        .addFamily("my-family")
  );
} finally {
  tableAdminClient.close();
}
```

## Opencensus Tracing

Cloud Bigtable client supports [Opencensus Tracing](https://opencensus.io/tracing/),
which gives insight into the client internals and aids in debugging production issues.
By default, the functionality is disabled. To enable, you need to add a couple of
dependencies and configure an exporter. For example to enable tracing using 
[Google Stackdriver](https://cloud.google.com/trace/docs/):

[//]: # (TODO: figure out how to keep opencensus version in sync with pom.xml)

If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>io.opencensus</groupId>
  <artifactId>opencensus-impl</artifactId>
  <version>0.18.0</version>
</dependency>
<dependency>
  <groupId>io.opencensus</groupId>
  <artifactId>opencensus-exporter-trace-stackdriver</artifactId>
  <version>0.18.0</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'io.opencensus:opencensus-impl:0.18.0'
compile 'io.opencensus:opencensus-exporter-trace-stackdriver:0.18.0'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "io.opencensus" % "opencensus-impl" % "0.18.0"
libraryDependencies += "io.opencensus" % "opencensus-exporter-trace-stackdriver" % "0.18.0"
```

Then at the start of your application configure the exporter:

```java
import io.opencensus.exporter.trace.stackdriver.StackdriverTraceConfiguration;
import io.opencensus.exporter.trace.stackdriver.StackdriverTraceExporter;

StackdriverTraceExporter.createAndRegister(
  StackdriverTraceConfiguration.builder()
      .setProjectId("YOUR-PROJECT_ID")
      .build());
```

By default traces are [sampled](https://opencensus.io/tracing/sampling) at a rate of about 1/10,000.
You can configure a higher rate by updating the active tracing params:

```java
import io.opencensus.trace.Tracing;
import io.opencensus.trace.samplers.Samplers;

Tracing.getTraceConfig().updateActiveTraceParams(
    Tracing.getTraceConfig().getActiveTraceParams().toBuilder()
        .setSampler(Samplers.probabilitySampler(0.01))
        .build()
);
```

## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting
document](https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting).

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

[CONTRIBUTING]:https://github.com/googleapis/google-cloud-java/blob/master/CONTRIBUTING.md
[DEVELOPING]:DEVELOPING.md
[LICENSE]: https://github.com/googleapis/google-cloud-java/blob/master/LICENSE
[cloud-platform]: https://cloud.google.com/
[cloud-bigtable]: https://cloud.google.com/bigtable/
[bigtable-product-docs]: https://cloud.google.com/bigtable/docs/
[bigtable-client-lib-docs]: https://googleapis.github.io/google-cloud-java/google-cloud-clients/apidocs/index.html?com/google/cloud/bigtable/package-summary.html
