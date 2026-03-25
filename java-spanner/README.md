# Google Cloud Spanner Client for Java

Java idiomatic client for [Cloud Spanner][product-docs].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][product-docs]
- [Client Library Documentation][javadocs]


## Quickstart

If you are using Maven with [BOM][libraries-bom], add this to your pom.xml file:

```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>libraries-bom</artifactId>
      <version>26.76.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-spanner</artifactId>
  </dependency>

```

If you are using Maven without the BOM, add this to your dependencies:


```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-spanner</artifactId>
  <version>6.110.0</version>
</dependency>

```

If you are using Gradle 5.x or later, add this to your dependencies:

```Groovy
implementation platform('com.google.cloud:libraries-bom:26.78.0')

implementation 'com.google.cloud:google-cloud-spanner'
```
If you are using Gradle without BOM, add this to your dependencies:

```Groovy
implementation 'com.google.cloud:google-cloud-spanner:6.112.0'
```

If you are using SBT, add this to your dependencies:

```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-spanner" % "6.112.0"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Authorization

The client application making API calls must be granted [authorization scopes][auth-scopes] required for the desired Cloud Spanner APIs, and the authenticated principal must have the [IAM role(s)][predefined-iam-roles] required to access GCP resources using the Cloud Spanner API calls.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Cloud Spanner [API enabled][enable-api].
You will need to [enable billing][enable-billing] to use Google Cloud Spanner.
[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud Command Line Interface][cloud-cli] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-spanner` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-spanner` as a dependency in your code.

## About Cloud Spanner


[Cloud Spanner][product-docs] is a fully managed, mission-critical,  relational database service that offers transactional consistency at global scale, schemas, SQL (ANSI 2011 with extensions), and automatic, synchronous replication for high availability. Be sure to activate the Cloud Spanner API on the Developer's Console to use Cloud Spanner from your project.

See the [Cloud Spanner client library docs][javadocs] to learn how to
use this Cloud Spanner Client Library.


#### Calling Cloud Spanner
Here is a code snippet showing a simple usage example. Add the following imports
at the top of your file:

```java
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;

```

Then, to make a query to Spanner, use the following code:
```java
// Instantiates a client
SpannerOptions options = SpannerOptions.newBuilder().build();
Spanner spanner = options.getService();
String instance = "my-instance";
String database = "my-database";
try {
  // Creates a database client
  DatabaseClient dbClient = spanner.getDatabaseClient(
    DatabaseId.of(options.getProjectId(), instance, database));
  // Queries the database
  try (ResultSet resultSet = dbClient.singleUse().executeQuery(Statement.of("SELECT 1"))) {
    // Prints the results
    while (resultSet.next()) {
      System.out.printf("%d\n", resultSet.getLong(0));
    }
  }
} finally {
  // Closes the client which will free up the resources used
  spanner.close();
}
```

#### Complete source code

In [DatabaseSelect.java](https://github.com/googleapis/google-cloud-java/tree/master/google-cloud-examples/src/main/java/com/google/cloud/examples/spanner/snippets/DatabaseSelect.java) we put together all the code shown above in a single program.

## Session Pool

The Cloud Spanner client maintains a session pool, as sessions are expensive to create and are
intended to be long-lived. The client automatically takes a session from the pool and uses this
executing queries and transactions.
See [Session Pool and Channel Pool Configuration](session-and-channel-pool-configuration.md)
for in-depth background information about sessions and gRPC channels and how these are handled in
the Cloud Spanner Java client.

## Metrics

Cloud Spanner client supports [client-side metrics](https://cloud.google.com/spanner/docs/view-manage-client-side-metrics) that you can use along with server-side metrics to optimize performance and troubleshoot performance issues if they occur.

Client-side metrics are measured from the time a request leaves your application to the time your application receives the response. 
In contrast, server-side metrics are measured from the time Spanner receives a request until the last byte of data is sent to the client.

These metrics are enabled by default. You can opt out of using client-side metrics with the following code:

```
SpannerOptions options = SpannerOptions.newBuilder()
  .setBuiltInMetricsEnabled(false)
  .build();
```

You can also disable these metrics by setting `SPANNER_DISABLE_BUILTIN_METRICS` to `true`.

> Note: Client-side metrics needs `monitoring.timeSeries.create` IAM permission to export metrics data. Ask your administrator to grant your service account the [Monitoring Metric Writer](https://cloud.google.com/iam/docs/roles-permissions/monitoring#monitoring.metricWriter) (roles/monitoring.metricWriter) IAM role on the project.

## Traces
Cloud Spanner client supports OpenTelemetry Traces, which gives insight into the client internals and aids in debugging/troubleshooting production issues. 

By default, the functionality is disabled. You need to add OpenTelemetry dependencies, enable OpenTelemetry traces and must configure the OpenTelemetry with appropriate exporters at the startup of your application.

See [Configure client-side tracing](https://cloud.google.com/spanner/docs/set-up-tracing#configure-client-side-tracing) for more details on configuring traces.

#### OpenTelemetry Dependencies

If you are using Maven, add this to your pom.xml file
```xml
<dependency>
      <groupId>io.opentelemetry</groupId>
      <artifactId>opentelemetry-sdk</artifactId>
      <version>{opentelemetry.version}</version>
</dependency>
<dependency>
      <groupId>io.opentelemetry</groupId>
      <artifactId>opentelemetry-sdk-trace</artifactId>
      <version>{opentelemetry.version}</version>
</dependency>
<dependency>
    <groupId>io.opentelemetry</groupId>
    <artifactId>opentelemetry-exporter-otlp</artifactId>
    <version>{opentelemetry.version}</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'io.opentelemetry:opentelemetry-sdk:{opentelemetry.version}'
compile 'io.opentelemetry:opentelemetry-sdk-trace:{opentelemetry.version}'
compile 'io.opentelemetry:opentelemetry-exporter-oltp:{opentelemetry.version}'
```
#### OpenTelemetry Configuration

> Note: Enabling OpenTelemetry traces will automatically disable OpenCensus traces.

```java
// Enable OpenTelemetry traces
SpannerOptions.enableOpenTelemetryTraces();

// Create a new tracer provider
SdkTracerProvider sdkTracerProvider = SdkTracerProvider.builder()
      // Use Otlp exporter or any other exporter of your choice.
      .addSpanProcessor(SimpleSpanProcessor.builder(OtlpGrpcSpanExporter
          .builder().build()).build())
          .build();


OpenTelemetry openTelemetry = OpenTelemetrySdk.builder()
        .setTracerProvider(sdkTracerProvider)
        .build()

SpannerOptions options = SpannerOptions.newBuilder()
// Inject OpenTelemetry object via Spanner Options or register OpenTelmetry object as Global
  .setOpenTelemetry(openTelemetry)
  .build();

Spanner spanner = options.getService();
```

#### OpenTelemetry SQL Statement Tracing
The OpenTelemetry traces that are generated by the Java client include any request and transaction
tags that have been set. The traces can also include the SQL statements that are executed and the
name of the thread that executes the statement. Enable this with the `enableExtendedTracing`
option:

```
SpannerOptions options = SpannerOptions.newBuilder()
  .setOpenTelemetry(openTelemetry)
  .setEnableExtendedTracing(true)
  .build();
```

This option can also be enabled by setting the environment variable
`SPANNER_ENABLE_EXTENDED_TRACING=true`.

#### OpenTelemetry API Tracing
You can enable tracing of each API call that the Spanner client executes with the `enableApiTracing`
option. These traces also include any retry attempts for an API call:
  
```
SpannerOptions options = SpannerOptions.newBuilder()
.setOpenTelemetry(openTelemetry)
.setEnableApiTracing(true)
.build();
```
  
This option can also be enabled by setting the environment variable
`SPANNER_ENABLE_API_TRACING=true`.

> Note: The attribute keys that are used for additional information about retry attempts and the number of requests might change in a future release.

#### End-to-end Tracing 
            
In addition to client-side tracing, you can opt in for [end-to-end tracing](https://cloud.google.com/spanner/docs/tracing-overview#end-to-end-side-tracing). End-to-end tracing helps you understand and debug latency issues that are specific to Spanner such as the following:
* Identify whether the latency is due to network latency between your application and Spanner, or if the latency is occurring within Spanner.
* Identify the Google Cloud regions that your application requests are being routed through and if there is a cross-region request. A cross-region request usually means higher latencies between your application and Spanner.

```
SpannerOptions options = SpannerOptions.newBuilder()
.setOpenTelemetry(openTelemetry)
.setEnableEndToEndTracing(true)
.build();
```

Refer to [Configure end-to-end tracing](https://cloud.google.com/spanner/docs/set-up-tracing#configure-end-to-end-tracing) to configure end-to-end tracing and to understand its attributes.

> Note: End-to-end traces can only be exported to [Cloud Trace](https://cloud.google.com/trace/docs).


## Instrument with OpenCensus

> Note: OpenCensus project is deprecated. See [Sunsetting OpenCensus](https://opentelemetry.io/blog/2023/sunsetting-opencensus/).
We recommend migrating to OpenTelemetry, the successor project.

## Migrate from OpenCensus to OpenTelemetry

> Using the [OpenTelemetry OpenCensus Bridge](https://mvnrepository.com/artifact/io.opentelemetry/opentelemetry-opencensus-shim), you can immediately begin exporting your metrics and traces with OpenTelemetry.

#### Disable OpenCensus metrics
Disable OpenCensus metrics for Spanner by including the following code if you still possess OpenCensus dependencies and exporter.

```java
SpannerOptions.disableOpenCensusMetrics();
```

#### Disable OpenCensus traces
Enabling OpenTelemetry traces for Spanner will automatically disable OpenCensus traces.

```java
SpannerOptions.enableOpenTelemetryTraces();
```

#### Remove OpenCensus Dependencies and Code
Remove any OpenCensus-related code and dependencies from your codebase if all your dependencies are ready to move to OpenTelemetry.

* Remove the OpenCensus Exporters which were configured [here](#configure-the-opencensus-exporter)
* Remove SpannerRPCViews reference which were configured [here](#enable-rpc-views)
* Remove the OpenCensus dependencies which were added [here](#opencensus-dependencies)

#### Update your Dashboards and Alerts

Update your dashboards and alerts to reflect below changes
* **Metrics name** : `cloud.google.com/java` prefix has been removed from OpenTelemery metrics and instead has been added as Instrumenation Scope.
* **Metrics namespace** : OpenTelmetry exporters uses `workload.googleapis.com` namespace opposed to `custom.googleapis.com` with OpenCensus. 



## Samples

Samples are in the [`samples/`](https://github.com/googleapis/google-cloud-java/tree/main/samples) directory.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| Add And Drop Database Role | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/AddAndDropDatabaseRole.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/AddAndDropDatabaseRole.java) |
| Add Json Column Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/AddJsonColumnSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/AddJsonColumnSample.java) |
| Add Jsonb Column Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/AddJsonbColumnSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/AddJsonbColumnSample.java) |
| Add Numeric Column Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/AddNumericColumnSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/AddNumericColumnSample.java) |
| Add Proto Column Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/AddProtoColumnSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/AddProtoColumnSample.java) |
| Alter Sequence Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/AlterSequenceSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/AlterSequenceSample.java) |
| Alter Table With Foreign Key Delete Cascade Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/AlterTableWithForeignKeyDeleteCascadeSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/AlterTableWithForeignKeyDeleteCascadeSample.java) |
| Async Dml Example | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/AsyncDmlExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/AsyncDmlExample.java) |
| Async Query Example | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/AsyncQueryExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/AsyncQueryExample.java) |
| Async Query To List Async Example | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/AsyncQueryToListAsyncExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/AsyncQueryToListAsyncExample.java) |
| Async Read Example | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/AsyncReadExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/AsyncReadExample.java) |
| Async Read Only Transaction Example | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/AsyncReadOnlyTransactionExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/AsyncReadOnlyTransactionExample.java) |
| Async Read Row Example | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/AsyncReadRowExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/AsyncReadRowExample.java) |
| Async Read Using Index Example | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/AsyncReadUsingIndexExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/AsyncReadUsingIndexExample.java) |
| Async Runner Example | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/AsyncRunnerExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/AsyncRunnerExample.java) |
| Async Transaction Manager Example | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/AsyncTransactionManagerExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/AsyncTransactionManagerExample.java) |
| Batch Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/BatchSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/BatchSample.java) |
| Batch Write At Least Once Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/BatchWriteAtLeastOnceSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/BatchWriteAtLeastOnceSample.java) |
| Change Streams Txn Exclusion Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/ChangeStreamsTxnExclusionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/ChangeStreamsTxnExclusionSample.java) |
| Copy Backup Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/CopyBackupSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/CopyBackupSample.java) |
| Copy Backup With Multi Region Encryption Key | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/CopyBackupWithMultiRegionEncryptionKey.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/CopyBackupWithMultiRegionEncryptionKey.java) |
| Create Backup With Encryption Key | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/CreateBackupWithEncryptionKey.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/CreateBackupWithEncryptionKey.java) |
| Create Backup With Multi Region Encryption Key | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/CreateBackupWithMultiRegionEncryptionKey.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/CreateBackupWithMultiRegionEncryptionKey.java) |
| Create Database With Default Leader Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/CreateDatabaseWithDefaultLeaderSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/CreateDatabaseWithDefaultLeaderSample.java) |
| Create Database With Encryption Key | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/CreateDatabaseWithEncryptionKey.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/CreateDatabaseWithEncryptionKey.java) |
| Create Database With Multi Region Encryption Key | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/CreateDatabaseWithMultiRegionEncryptionKey.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/CreateDatabaseWithMultiRegionEncryptionKey.java) |
| Create Database With Version Retention Period Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/CreateDatabaseWithVersionRetentionPeriodSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/CreateDatabaseWithVersionRetentionPeriodSample.java) |
| Create Full Backup Schedule Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/CreateFullBackupScheduleSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/CreateFullBackupScheduleSample.java) |
| Create Incremental Backup Schedule Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/CreateIncrementalBackupScheduleSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/CreateIncrementalBackupScheduleSample.java) |
| Create Instance Config Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/CreateInstanceConfigSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/CreateInstanceConfigSample.java) |
| Create Instance Example | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/CreateInstanceExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/CreateInstanceExample.java) |
| Create Instance Partition Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/CreateInstancePartitionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/CreateInstancePartitionSample.java) |
| Create Instance With Asymmetric Autoscaling Config Example | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/CreateInstanceWithAsymmetricAutoscalingConfigExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/CreateInstanceWithAsymmetricAutoscalingConfigExample.java) |
| Create Instance With Autoscaling Config Example | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/CreateInstanceWithAutoscalingConfigExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/CreateInstanceWithAutoscalingConfigExample.java) |
| Create Instance With Processing Units Example | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/CreateInstanceWithProcessingUnitsExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/CreateInstanceWithProcessingUnitsExample.java) |
| Create Instance Without Default Backup Schedules Example | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/CreateInstanceWithoutDefaultBackupSchedulesExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/CreateInstanceWithoutDefaultBackupSchedulesExample.java) |
| Create Sequence Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/CreateSequenceSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/CreateSequenceSample.java) |
| Create Table With Foreign Key Delete Cascade Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/CreateTableWithForeignKeyDeleteCascadeSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/CreateTableWithForeignKeyDeleteCascadeSample.java) |
| Custom Timeout And Retry Settings Example | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/CustomTimeoutAndRetrySettingsExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/CustomTimeoutAndRetrySettingsExample.java) |
| Database Add Split Points Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/DatabaseAddSplitPointsSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/DatabaseAddSplitPointsSample.java) |
| Delete Backup Schedule Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/DeleteBackupScheduleSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/DeleteBackupScheduleSample.java) |
| Delete Instance Config Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/DeleteInstanceConfigSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/DeleteInstanceConfigSample.java) |
| Delete Using Dml Returning Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/DeleteUsingDmlReturningSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/DeleteUsingDmlReturningSample.java) |
| Directed Read Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/DirectedReadSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/DirectedReadSample.java) |
| Drop Foreign Key Constraint Delete Cascade Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/DropForeignKeyConstraintDeleteCascadeSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/DropForeignKeyConstraintDeleteCascadeSample.java) |
| Drop Sequence Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/DropSequenceSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/DropSequenceSample.java) |
| Enable Fine Grained Access | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/EnableFineGrainedAccess.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/EnableFineGrainedAccess.java) |
| Get Backup Schedule Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/GetBackupScheduleSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/GetBackupScheduleSample.java) |
| Get Commit Stats Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/GetCommitStatsSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/GetCommitStatsSample.java) |
| Get Database Ddl Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/GetDatabaseDdlSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/GetDatabaseDdlSample.java) |
| Get Instance Config Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/GetInstanceConfigSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/GetInstanceConfigSample.java) |
| Insert Using Dml Returning Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/InsertUsingDmlReturningSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/InsertUsingDmlReturningSample.java) |
| Isolation Level And Read Lock Mode Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/IsolationLevelAndReadLockModeSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/IsolationLevelAndReadLockModeSample.java) |
| Last Statement Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/LastStatementSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/LastStatementSample.java) |
| List Backup Schedules Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/ListBackupSchedulesSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/ListBackupSchedulesSample.java) |
| List Database Roles | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/ListDatabaseRoles.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/ListDatabaseRoles.java) |
| List Databases Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/ListDatabasesSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/ListDatabasesSample.java) |
| List Instance Config Operations Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/ListInstanceConfigOperationsSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/ListInstanceConfigOperationsSample.java) |
| List Instance Configs Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/ListInstanceConfigsSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/ListInstanceConfigsSample.java) |
| Pg Alter Sequence Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/PgAlterSequenceSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/PgAlterSequenceSample.java) |
| Pg Async Query To List Async Example | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/PgAsyncQueryToListAsyncExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/PgAsyncQueryToListAsyncExample.java) |
| Pg Async Runner Example | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/PgAsyncRunnerExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/PgAsyncRunnerExample.java) |
| Pg Async Transaction Manager Example | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/PgAsyncTransactionManagerExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/PgAsyncTransactionManagerExample.java) |
| Pg Batch Dml Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/PgBatchDmlSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/PgBatchDmlSample.java) |
| Pg Case Sensitivity Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/PgCaseSensitivitySample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/PgCaseSensitivitySample.java) |
| Pg Create Sequence Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/PgCreateSequenceSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/PgCreateSequenceSample.java) |
| Pg Delete Using Dml Returning Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/PgDeleteUsingDmlReturningSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/PgDeleteUsingDmlReturningSample.java) |
| Pg Drop Sequence Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/PgDropSequenceSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/PgDropSequenceSample.java) |
| Pg Insert Using Dml Returning Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/PgInsertUsingDmlReturningSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/PgInsertUsingDmlReturningSample.java) |
| Pg Interleaved Table Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/PgInterleavedTableSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/PgInterleavedTableSample.java) |
| Pg Last Statement Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/PgLastStatementSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/PgLastStatementSample.java) |
| Pg Partitioned Dml Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/PgPartitionedDmlSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/PgPartitionedDmlSample.java) |
| Pg Query With Numeric Parameter Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/PgQueryWithNumericParameterSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/PgQueryWithNumericParameterSample.java) |
| Pg Spanner Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/PgSpannerSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/PgSpannerSample.java) |
| Pg Update Using Dml Returning Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/PgUpdateUsingDmlReturningSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/PgUpdateUsingDmlReturningSample.java) |
| Query Information Schema Database Options Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/QueryInformationSchemaDatabaseOptionsSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/QueryInformationSchemaDatabaseOptionsSample.java) |
| Query With Json Parameter Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/QueryWithJsonParameterSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/QueryWithJsonParameterSample.java) |
| Query With Jsonb Parameter Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/QueryWithJsonbParameterSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/QueryWithJsonbParameterSample.java) |
| Query With Numeric Parameter Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/QueryWithNumericParameterSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/QueryWithNumericParameterSample.java) |
| Query With Proto Parameter Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/QueryWithProtoParameterSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/QueryWithProtoParameterSample.java) |
| Quickstart Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/QuickstartSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/QuickstartSample.java) |
| Read Data With Database Role | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/ReadDataWithDatabaseRole.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/ReadDataWithDatabaseRole.java) |
| Restore Backup With Encryption Key | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/RestoreBackupWithEncryptionKey.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/RestoreBackupWithEncryptionKey.java) |
| Restore Backup With Multi Region Encryption Key | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/RestoreBackupWithMultiRegionEncryptionKey.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/RestoreBackupWithMultiRegionEncryptionKey.java) |
| Set Max Commit Delay Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/SetMaxCommitDelaySample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/SetMaxCommitDelaySample.java) |
| Singer Proto | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/SingerProto.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/SingerProto.java) |
| Spanner Graph Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/SpannerGraphSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/SpannerGraphSample.java) |
| Spanner Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/SpannerSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/SpannerSample.java) |
| Statement Timeout Example | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/StatementTimeoutExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/StatementTimeoutExample.java) |
| Tag Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/TagSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/TagSample.java) |
| Tracing Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/TracingSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/TracingSample.java) |
| Transaction Timeout Example | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/TransactionTimeoutExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/TransactionTimeoutExample.java) |
| Unnamed Parameters Example | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/UnnamedParametersExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/UnnamedParametersExample.java) |
| Update Backup Schedule Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/UpdateBackupScheduleSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/UpdateBackupScheduleSample.java) |
| Update Database Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/UpdateDatabaseSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/UpdateDatabaseSample.java) |
| Update Database With Default Leader Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/UpdateDatabaseWithDefaultLeaderSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/UpdateDatabaseWithDefaultLeaderSample.java) |
| Update Instance Config Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/UpdateInstanceConfigSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/UpdateInstanceConfigSample.java) |
| Update Instance Default Backup Schedule Type Example | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/UpdateInstanceDefaultBackupScheduleTypeExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/UpdateInstanceDefaultBackupScheduleTypeExample.java) |
| Update Instance Example | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/UpdateInstanceExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/UpdateInstanceExample.java) |
| Update Json Data Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/UpdateJsonDataSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/UpdateJsonDataSample.java) |
| Update Jsonb Data Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/UpdateJsonbDataSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/UpdateJsonbDataSample.java) |
| Update Numeric Data Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/UpdateNumericDataSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/UpdateNumericDataSample.java) |
| Update Proto Data Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/UpdateProtoDataSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/UpdateProtoDataSample.java) |
| Update Proto Data Sample Using Dml | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/UpdateProtoDataSampleUsingDml.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/UpdateProtoDataSampleUsingDml.java) |
| Update Using Dml Returning Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/UpdateUsingDmlReturningSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/UpdateUsingDmlReturningSample.java) |
| Add And Drop Database Role | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/AddAndDropDatabaseRole.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/AddAndDropDatabaseRole.java) |
| Add Json Column Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/AddJsonColumnSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/AddJsonColumnSample.java) |
| Add Jsonb Column Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/AddJsonbColumnSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/AddJsonbColumnSample.java) |
| Add Numeric Column Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/AddNumericColumnSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/AddNumericColumnSample.java) |
| Alter Sequence Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/AlterSequenceSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/AlterSequenceSample.java) |
| Alter Table With Foreign Key Delete Cascade Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/AlterTableWithForeignKeyDeleteCascadeSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/AlterTableWithForeignKeyDeleteCascadeSample.java) |
| Copy Backup Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/CopyBackupSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/CopyBackupSample.java) |
| Create Backup With Encryption Key | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/CreateBackupWithEncryptionKey.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/CreateBackupWithEncryptionKey.java) |
| Create Database With Default Leader Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/CreateDatabaseWithDefaultLeaderSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/CreateDatabaseWithDefaultLeaderSample.java) |
| Create Database With Encryption Key | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/CreateDatabaseWithEncryptionKey.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/CreateDatabaseWithEncryptionKey.java) |
| Create Database With Version Retention Period Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/CreateDatabaseWithVersionRetentionPeriodSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/CreateDatabaseWithVersionRetentionPeriodSample.java) |
| Create Instance Config Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/CreateInstanceConfigSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/CreateInstanceConfigSample.java) |
| Create Instance Example | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/CreateInstanceExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/CreateInstanceExample.java) |
| Create Instance With Autoscaling Config Example | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/CreateInstanceWithAutoscalingConfigExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/CreateInstanceWithAutoscalingConfigExample.java) |
| Create Instance With Processing Units Example | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/CreateInstanceWithProcessingUnitsExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/CreateInstanceWithProcessingUnitsExample.java) |
| Create Sequence Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/CreateSequenceSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/CreateSequenceSample.java) |
| Create Table With Foreign Key Delete Cascade Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/CreateTableWithForeignKeyDeleteCascadeSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/CreateTableWithForeignKeyDeleteCascadeSample.java) |
| Delete Instance Config Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/DeleteInstanceConfigSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/DeleteInstanceConfigSample.java) |
| Drop Foreign Key Constraint Delete Cascade Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/DropForeignKeyConstraintDeleteCascadeSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/DropForeignKeyConstraintDeleteCascadeSample.java) |
| Drop Sequence Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/DropSequenceSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/DropSequenceSample.java) |
| Enable Fine Grained Access | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/EnableFineGrainedAccess.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/EnableFineGrainedAccess.java) |
| Get Database Ddl Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/GetDatabaseDdlSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/GetDatabaseDdlSample.java) |
| Get Instance Config Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/GetInstanceConfigSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/GetInstanceConfigSample.java) |
| List Database Roles | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/ListDatabaseRoles.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/ListDatabaseRoles.java) |
| List Databases Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/ListDatabasesSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/ListDatabasesSample.java) |
| List Instance Config Operations Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/ListInstanceConfigOperationsSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/ListInstanceConfigOperationsSample.java) |
| List Instance Configs Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/ListInstanceConfigsSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/ListInstanceConfigsSample.java) |
| Pg Alter Sequence Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/PgAlterSequenceSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/PgAlterSequenceSample.java) |
| Pg Case Sensitivity Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/PgCaseSensitivitySample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/PgCaseSensitivitySample.java) |
| Pg Create Sequence Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/PgCreateSequenceSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/PgCreateSequenceSample.java) |
| Pg Drop Sequence Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/PgDropSequenceSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/PgDropSequenceSample.java) |
| Pg Interleaved Table Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/PgInterleavedTableSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/PgInterleavedTableSample.java) |
| Pg Spanner Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/PgSpannerSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/PgSpannerSample.java) |
| Restore Backup With Encryption Key | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/RestoreBackupWithEncryptionKey.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/RestoreBackupWithEncryptionKey.java) |
| Spanner Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/SpannerSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/SpannerSample.java) |
| Update Database Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/UpdateDatabaseSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/UpdateDatabaseSample.java) |
| Update Database With Default Leader Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/UpdateDatabaseWithDefaultLeaderSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/UpdateDatabaseWithDefaultLeaderSample.java) |
| Update Instance Config Sample | [source code](https://github.com/googleapis/google-cloud-java/blob/main/samples/snippets/src/main/java/com/example/spanner/admin/archived/UpdateInstanceConfigSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/google-cloud-java&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/spanner/admin/archived/UpdateInstanceConfigSample.java) |



## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Cloud Spanner uses gRPC for the transport layer.

## Supported Java Versions

Java 8 or above is required for using this client.

Google's Java client libraries,
[Google Cloud Client Libraries][cloudlibs]
and
[Google Cloud API Libraries][apilibs],
follow the
[Oracle Java SE support roadmap][oracle]
(see the Oracle Java SE Product Releases section).

### For new development

In general, new feature development occurs with support for the lowest Java
LTS version covered by  Oracle's Premier Support (which typically lasts 5 years
from initial General Availability). If the minimum required JVM for a given
library is changed, it is accompanied by a [semver][semver] major release.

Java 11 and (in September 2021) Java 17 are the best choices for new
development.

### Keeping production systems current

Google tests its client libraries with all current LTS versions covered by
Oracle's Extended Support (which typically lasts 8 years from initial
General Availability).

#### Legacy support

Google's client libraries support legacy versions of Java runtimes with long
term stable libraries that don't receive feature updates on a best efforts basis
as it may not be possible to backport all patches.

Google provides updates on a best efforts basis to apps that continue to use
Java 7, though apps might need to upgrade to current versions of the library
that supports their JVM.

#### Where to find specific information

The latest versions and the supported Java versions are identified on
the individual GitHub repository `github.com/GoogleAPIs/java-SERVICENAME`
and on [google-cloud-java][g-c-j].

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

Java is a registered trademark of Oracle and/or its affiliates.

[product-docs]: https://cloud.google.com/spanner/docs/
[javadocs]: https://cloud.google.com/java/docs/reference/google-cloud-spanner/latest/history
[stability-image]: https://img.shields.io/badge/stability-stable-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-spanner.svg
[maven-version-link]: https://central.sonatype.com/artifact/com.google.cloud/google-cloud-spanner/6.112.0
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[auth-scopes]: https://developers.google.com/identity/protocols/oauth2/scopes
[predefined-iam-roles]: https://cloud.google.com/iam/docs/understanding-roles#predefined_roles
[iam-policy]: https://cloud.google.com/iam/docs/overview#cloud-iam-policy
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-cli]: https://cloud.google.com/cli
[troubleshooting]: https://github.com/googleapis/google-cloud-java/blob/main/TROUBLESHOOTING.md
[contributing]: https://github.com/googleapis/google-cloud-java/blob/main/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/google-cloud-java/blob/main/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/google-cloud-java/blob/main/LICENSE
[enable-billing]: https://cloud.google.com/apis/docs/getting-started#enabling_billing
[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=spanner.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png

[semver]: https://semver.org/
[cloudlibs]: https://cloud.google.com/apis/docs/client-libraries-explained
[apilibs]: https://cloud.google.com/apis/docs/client-libraries-explained#google_api_client_libraries
[oracle]: https://www.oracle.com/java/technologies/java-se-support-roadmap.html
[g-c-j]: http://github.com/googleapis/google-cloud-java
