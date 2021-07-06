# Google Cloud Bigtable Client for Java

Java idiomatic client for [Cloud Bigtable][product-docs].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][product-docs]
- [Client Library Documentation][javadocs]

## Quickstart

If you are using Maven with [BOM][libraries-bom], add this to your pom.xml file
```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>libraries-bom</artifactId>
      <version>20.7.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-bigtable</artifactId>
  </dependency>

```

If you are using Maven without BOM, add this to your dependencies:

```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-bigtable</artifactId>
  <version>1.27.1</version>
</dependency>

```

If you are using Gradle 5.x or later, add this to your dependencies
```Groovy
implementation platform('com.google.cloud:libraries-bom:20.7.0')

compile 'com.google.cloud:google-cloud-bigtable'
```
If you are using Gradle without BOM, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-bigtable:1.27.2'
```

If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-bigtable" % "1.27.2"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Cloud Bigtable [API enabled][enable-api].

[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-bigtable` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-bigtable` as a dependency in your code.

## About Cloud Bigtable


[Cloud Bigtable][product-docs] 

See the [Cloud Bigtable client library docs][javadocs] to learn how to
use this Cloud Bigtable Client Library.


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

## Client request tracing: OpenCensus Tracing

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

You can view the traces on the Google Cloud Platform Console
[Trace](https://console.cloud.google.com/traces) page.

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

## Enabling Cloud Bigtable Metrics: OpenCensus Stats

Cloud Bigtable client supports [Opencensus Metrics](https://opencensus.io/stats/),
which gives insight into the client internals and aids in debugging production issues.
All Cloud Bigtable Metrics are prefixed with `cloud.google.com/java/bigtable/`. The
metrics will be tagged with:
 * `bigtable_project_id`: the project that contains the target Bigtable instance.
   Please note that this id could be different from project that the client is running
   in and different from the project where the metrics are exported to.
* `bigtable_instance_id`: the instance id of the target Bigtable instance
* `bigtable_app_profile_id`: the app profile id that is being used to access the target
  Bigtable instance

### Available operation level metric views:

* `cloud.google.com/java/bigtable/op_latency`: A distribution of latency of
  each client method call, across all of it's RPC attempts. Tagged by
  operation name and final response status.

* `cloud.google.com/java/bigtable/completed_ops`: The total count of
  method invocations. Tagged by operation name and final response status.

* `cloud.google.com/java/bigtable/read_rows_first_row_latency`: A
  distribution of the latency of receiving the first row in a ReadRows
  operation.

* `cloud.google.com/java/bigtable/attempt_latency`: A distribution of latency of
  each client RPC, tagged by operation name and the attempt status. Under normal
  circumstances, this will be identical to op_latency. However, when the client
  receives transient errors, op_latency will be the sum of all attempt_latencies
  and the exponential delays.

* `cloud.google.com/java/bigtable/attempts_per_op`: A distribution of attempts that
  each operation required, tagged by operation name and final operation status.
  Under normal circumstances, this will be 1.

### GFE metric views:
* `cloud.google.com/java/bigtable/gfe_latency`: A distribution of the latency
between Google's network receives an RPC and reads back the first byte of
the response.

* `cloud.google.com/java/bigtable/gfe_header_missing_count`: A counter of the
number of RPC responses received without the server-timing header, which
indicates that the request probably never reached Google's network.

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
// Enable GFE metric views
BigtableDataSettings.enableGfeOpenCensusStats();
```

You can view the metrics on the Google Cloud Platform Console
[Metrics explorer](https://console.cloud.google.com/monitoring/metrics-explorer)
page.

You can configure how frequently metrics are pushed to StackDriver and the
[Monitored resource type](https://cloud.google.com/monitoring/api/resources) by
updating `StackdriverStatsConfiguration`:

``` java
// Example: configuring export interval and monitored resource type
StackdriverStatsExporter.createAndRegister(
    StackdriverStatsConfiguration.builder()
        .setProjectId("YOUR_PROJECT_ID")
        // Exporting metrics every 10 seconds
        .setExportInterval(Duration.create(10, 0))
        // Configure monitored resource type. A common practice is to use the
        // monitored resource objects that represent the physical resources
        // where your application code is running. See the full list of
        // monitored resource type here:
        // https://cloud.google.com/monitoring/api/resources
        .setMonitoredResource(MonitoredResource.newBuilder()
            .setType("global")
            .putLabels("project_id", "YOUR_PROJECT_ID")
          .build())
        .build()
);
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
          <version>1.28.0</version>
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




## Samples

Samples are in the [`samples/`](https://github.com/googleapis/java-bigtable/tree/master/samples) directory. The samples' `README.md`
has instructions for running the samples.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| Configure Connection Pool | [source code](https://github.com/googleapis/java-bigtable/blob/master/samples/snippets/src/main/java/com/example/bigtable/ConfigureConnectionPool.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigtable&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigtable/ConfigureConnectionPool.java) |
| Filters | [source code](https://github.com/googleapis/java-bigtable/blob/master/samples/snippets/src/main/java/com/example/bigtable/Filters.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigtable&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigtable/Filters.java) |
| Hello World | [source code](https://github.com/googleapis/java-bigtable/blob/master/samples/snippets/src/main/java/com/example/bigtable/HelloWorld.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigtable&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigtable/HelloWorld.java) |
| Instance Admin Example | [source code](https://github.com/googleapis/java-bigtable/blob/master/samples/snippets/src/main/java/com/example/bigtable/InstanceAdminExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigtable&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigtable/InstanceAdminExample.java) |
| Quickstart | [source code](https://github.com/googleapis/java-bigtable/blob/master/samples/snippets/src/main/java/com/example/bigtable/Quickstart.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigtable&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigtable/Quickstart.java) |
| Reads | [source code](https://github.com/googleapis/java-bigtable/blob/master/samples/snippets/src/main/java/com/example/bigtable/Reads.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigtable&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigtable/Reads.java) |
| Table Admin Example | [source code](https://github.com/googleapis/java-bigtable/blob/master/samples/snippets/src/main/java/com/example/bigtable/TableAdminExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigtable&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigtable/TableAdminExample.java) |
| Write Batch | [source code](https://github.com/googleapis/java-bigtable/blob/master/samples/snippets/src/main/java/com/example/bigtable/WriteBatch.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigtable&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigtable/WriteBatch.java) |
| Write Conditionally | [source code](https://github.com/googleapis/java-bigtable/blob/master/samples/snippets/src/main/java/com/example/bigtable/WriteConditionally.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigtable&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigtable/WriteConditionally.java) |
| Write Increment | [source code](https://github.com/googleapis/java-bigtable/blob/master/samples/snippets/src/main/java/com/example/bigtable/WriteIncrement.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigtable&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigtable/WriteIncrement.java) |
| Write Simple | [source code](https://github.com/googleapis/java-bigtable/blob/master/samples/snippets/src/main/java/com/example/bigtable/WriteSimple.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigtable&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigtable/WriteSimple.java) |



## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Java Versions

Java 7 or above is required for using this client.

## Versioning


This library follows [Semantic Versioning](http://semver.org/).


## Contributing


Contributions to this library are always welcome and highly encouraged.

See [CONTRIBUTING][contributing] for more information how to get started.

Please note that this project is released with a Contributor Code of Conduct. By participating in
this project you agree to abide by its terms. See [Code of Conduct][code-of-conduct] for more
information.

## License

Apache 2.0 - See [LICENSE][license] for more information.

## CI Status

Java Version | Status
------------ | ------
Java 7 | [![Kokoro CI][kokoro-badge-image-1]][kokoro-badge-link-1]
Java 8 | [![Kokoro CI][kokoro-badge-image-2]][kokoro-badge-link-2]
Java 8 OSX | [![Kokoro CI][kokoro-badge-image-3]][kokoro-badge-link-3]
Java 8 Windows | [![Kokoro CI][kokoro-badge-image-4]][kokoro-badge-link-4]
Java 11 | [![Kokoro CI][kokoro-badge-image-5]][kokoro-badge-link-5]

Java is a registered trademark of Oracle and/or its affiliates.

[product-docs]: https://cloud.google.com/bigtable
[javadocs]: https://googleapis.dev/java/google-cloud-bigtable/latest/index.html
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
[stability-image]: https://img.shields.io/badge/stability-ga-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-bigtable.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-bigtable&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-bigtable/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-bigtable/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-bigtable/blob/master/LICENSE

[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=bigtable.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png
