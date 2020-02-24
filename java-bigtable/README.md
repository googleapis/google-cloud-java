# Google Cloud Bigtable Client for Java

Java idiomatic client for [Cloud Bigtable][cloud-bigtable].

[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-bigtable.svg)](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-bigtable.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/google-cloud-java)

- [Product Documentation][bigtable-product-docs]
- [Client Library Documentation](https://googleapis.dev/java/google-cloud-bigtable/latest/index.html)

## Quickstart

[//]: # ({x-version-update-start:google-cloud-bigtable:released})
If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-bigtable</artifactId>
  <version>1.10.0</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-bigtable:1.10.0'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-bigtable" % "1.10.0"
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
String projectId = "my-project";
String instanceId = "my-instance";
String tableId = "my-table";

// Create the client.
// Please note that creating the client is a very expensive operation
// and should only be done once and shared in an application.
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

TIP: If you are experiencing version conflicts with gRPC, see [Version Conflicts](#version-conflicts).

## OpenCensus Tracing

Cloud Bigtable client supports [OpenCensus Tracing](https://opencensus.io/tracing/),
which gives insight into the client internals and aids in debugging production issues.
By default, the functionality is disabled. For example to enable tracing using
[Google Stackdriver](https://cloud.google.com/trace/docs/):

[//]: # (TODO: figure out how to keep opencensus version in sync with pom.xml)

If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>io.opencensus</groupId>
  <artifactId>opencensus-impl</artifactId>
  <version>0.24.0</version>
  <scope>runtime</scope>
</dependency>
<dependency>
  <groupId>io.opencensus</groupId>
  <artifactId>opencensus-exporter-trace-stackdriver</artifactId>
  <version>0.24.0</version>
  <exclusions>
    <exclusion>
      <groupId>io.grpc</groupId>
      <artifactId>*</artifactId>
    </exclusion>
    <exclusion>
      <groupId>com.google.auth</groupId>
      <artifactId>*</artifactId>
    </exclusion>
  </exclusions>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'io.opencensus:opencensus-impl:0.24.0'
compile 'io.opencensus:opencensus-exporter-trace-stackdriver:0.24.0'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "io.opencensus" % "opencensus-impl" % "0.24.0"
libraryDependencies += "io.opencensus" % "opencensus-exporter-trace-stackdriver" % "0.24.0"
```

At the start of your application configure the exporter:

```java
import io.opencensus.exporter.trace.stackdriver.StackdriverTraceConfiguration;
import io.opencensus.exporter.trace.stackdriver.StackdriverTraceExporter;

StackdriverTraceExporter.createAndRegister(
  StackdriverTraceConfiguration.builder()
      .setProjectId("YOUR_PROJECT_ID")
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

## OpenCensus Stats

Cloud Bigtable client supports [Opencensus Metrics](https://opencensus.io/stats/),
which gives insight into the client internals and aids in debugging production issues.
Metrics prefixed with `cloud.google.com/java/bigtable/` focus on operation level
metrics across all of the retry attempts that occurred during that operation. RPC
level metrics can be gleaned from gRPC's metrics, which are prefixed with
`grpc.io/client/`.

### Available operation level metric views:

* `cloud.google.com/java/bigtable/op_latency`: A distribution latency of
  each client method call, across all of it's RPC attempts. Tagged by
  method name and final response status.

* `cloud.google.com/java/bigtable/completed_ops`: The total count of
  method invocations. Tagged by method name. Can be compared to
  `grpc.io/client/completed_rpcs` to visualize retry attempts.

* `cloud.google.com/java/bigtable/read_rows_first_row_latency`: A
  distribution of the latency of receiving the first row in a ReadRows
  operation.

* `cloud.google.com/java/bigtable/rows_per_op`: A distribution of rows
  read per ReadRows operation across all retry attempts.

* `cloud.google.com/java/bigtable/mutations_per_batch`: A distribution
  of mutations per BulkMutation.


By default, the functionality is disabled. For example to enable metrics using
[Google Stackdriver](https://cloud.google.com/monitoring/docs/):


[//]: # (TODO: figure out how to keep opencensus version in sync with pom.xml)

If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>io.opencensus</groupId>
  <artifactId>opencensus-impl</artifactId>
  <version>0.24.0</version>
  <scope>runtime</scope>
</dependency>
<dependency>
  <groupId>io.opencensus</groupId>
  <artifactId>opencensus-exporter-stats-stackdriver</artifactId>
  <version>0.24.0</version>
  <exclusions>
    <exclusion>
      <groupId>io.grpc</groupId>
      <artifactId>*</artifactId>
    </exclusion>
    <exclusion>
      <groupId>com.google.auth</groupId>
      <artifactId>*</artifactId>
    </exclusion>
  </exclusions>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'io.opencensus:opencensus-impl:0.24.0'
compile 'io.opencensus:opencensus-exporter-stats-stackdriver:0.24.0'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "io.opencensus" % "opencensus-impl" % "0.24.0"
libraryDependencies += "io.opencensus" % "opencensus-exporter-stats-stackdriver" % "0.24.0"
```

At the start of your application configure the exporter and enable the Bigtable stats views:

```java
import io.opencensus.exporter.stats.stackdriver.StackdriverStatsConfiguration;
import io.opencensus.exporter.stats.stackdriver.StackdriverStatsExporter;

StackdriverStatsExporter.createAndRegister(
    StackdriverStatsConfiguration.builder()
        .setProjectId("YOUR_PROJECT_ID")
        .build()
);

BigtableDataSettings.enableOpenCensusStats();
```

## Version Conflicts

google-cloud-bigtable depends on gRPC directly which may conflict with the versions brought
in by other libraries, for example Apache Beam. This happens because internal dependencies
between gRPC libraries are pinned to an exact version of grpc-core
(see [here](https://github.com/grpc/grpc-java/commit/90db93b990305aa5a8428cf391b55498c7993b6e)).
If both google-cloud-bigtable and the other library bring in two gRPC libraries that depend
on the different versions of grpc-core, then dependency resolution will fail.
The easiest way to fix this is to depend on the gRPC bom, which will force all the gRPC
transitive libraries to use the same version.

Add the following to your project's pom.xml.

```
    <dependencyManagement>
      <dependencies>
        <dependency>
          <groupId>io.grpc</groupId>
          <artifactId>grpc-bom</artifactId>
          <version>1.27.0</version>
          <type>pom</type>
          <scope>import</scope>
        </dependency>
      </dependencies>
    </dependencyManagement>
```

## Container Deployment

While deploying this client in [Google Kubernetes Engine(GKE)](https://cloud.google.com/kubernetes-engine) with [CoS](https://cloud.google.com/container-optimized-os/docs/). Please make sure to provide CPU configuration in your deployment file. With default configuration JVM detects only 1 CPU, which affects the number of channels with the client, resulting in performance repercussion.

Also, The number of `grpc-nio-worker-ELG-1-#` thread is same as number of CPUs. These are managed by a single `grpc-default-executor-#` thread, which is shared among multiple client instances.

For example:
```yaml
appVersion: v1
...
spec:
  ...
  container:
    resources:
      requests:
        cpu: "1" # Here 1 represents 100% of single node CPUs whereas other than 1 represents the number of CPU it would use from a node.
```
see [Assign CPU Resources to Containers](https://kubernetes.io/docs/tasks/configure-pod-container/assign-cpu-resource/#specify-a-cpu-request-and-a-cpu-limit) for more information.

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

## Contributing

Contributions to this library are always welcome and highly encouraged.

See [CONTRIBUTING] for more information on how to get started and [DEVELOPING] for a layout of the
codebase.

## License

Apache 2.0 - See [LICENSE] for more information.

## CI Status

Java Version | Status
------------ | ------
Java 7 | [![Kokoro CI][kokoro-badge-image-1]][kokoro-badge-link-1]
Java 8 | [![Kokoro CI][kokoro-badge-image-2]][kokoro-badge-link-2]
Java 8 OSX | [![Kokoro CI][kokoro-badge-image-3]][kokoro-badge-link-3]
Java 8 Windows | [![Kokoro CI][kokoro-badge-image-4]][kokoro-badge-link-4]
Java 11 | [![Kokoro CI][kokoro-badge-image-5]][kokoro-badge-link-5]

[CONTRIBUTING]:https://github.com/googleapis/google-cloud-java/blob/master/CONTRIBUTING.md
[DEVELOPING]:DEVELOPING.md
[LICENSE]: https://github.com/googleapis/google-cloud-java/blob/master/LICENSE
[cloud-platform]: https://cloud.google.com/
[cloud-bigtable]: https://cloud.google.com/bigtable/
[bigtable-product-docs]: https://cloud.google.com/bigtable/docs/
[bigtable-client-lib-docs]: https://googleapis.dev/java/google-cloud-clients/latest/index.html?com/google/cloud/bigtable/package-summary.html
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigtable/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigtable/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigtable/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigtable/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigtable/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigtable/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigtable/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigtable/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigtable/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigtable/java11.html