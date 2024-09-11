# Google Cloud Datastore Client for Java

Java idiomatic client for [Cloud Datastore][product-docs].

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
      <version>26.45.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-datastore</artifactId>
  </dependency>

```

If you are using Maven without the BOM, add this to your dependencies:

<!-- {x-version-update-start:google-cloud-datastore:released} -->

```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-datastore</artifactId>
  <version>2.20.0</version>
</dependency>

```

If you are using Gradle 5.x or later, add this to your dependencies:

```Groovy
implementation platform('com.google.cloud:libraries-bom:26.45.0')

implementation 'com.google.cloud:google-cloud-datastore'
```
If you are using Gradle without BOM, add this to your dependencies:

```Groovy
implementation 'com.google.cloud:google-cloud-datastore:2.21.2'
```

If you are using SBT, add this to your dependencies:

```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-datastore" % "2.21.2"
```
<!-- {x-version-update-end} -->

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Authorization

The client application making API calls must be granted [authorization scopes][auth-scopes] required for the desired Cloud Datastore APIs, and the authenticated principal must have the [IAM role(s)][predefined-iam-roles] required to access GCP resources using the Cloud Datastore API calls.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Cloud Datastore [API enabled][enable-api].
You will need to [enable billing][enable-billing] to use Google Cloud Datastore.
[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud Command Line Interface][cloud-cli] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-datastore` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-datastore` as a dependency in your code.

## About Cloud Datastore


[Cloud Datastore][product-docs] is a fully managed, schemaless database for\nstoring non-relational data. Cloud Datastore automatically scales with\nyour users and supports ACID transactions, high availability of reads and\nwrites, strong consistency for reads and ancestor queries, and eventual\nconsistency for all other queries.

See the [Cloud Datastore client library docs][javadocs] to learn how to
use this Cloud Datastore Client Library.


See the [Google Cloud Datastore docs][cloud-datastore-activation] for more details on how to activate
Cloud Datastore for your project.

See the [Datastore client library docs][datastore-client-lib-docs] to learn how to interact
with the Cloud Datastore using this Client Library.

#### Creating an authorized service object
To make authenticated requests to Google Cloud Datastore, you must create a service object with credentials. You can then make API calls by calling methods on the Datastore service object. The simplest way to authenticate is to use [Application Default Credentials](https://developers.google.com/identity/protocols/application-default-credentials). These credentials are automatically inferred from your environment, so you only need the following code to create your service object:

```java
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;

Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
```

For other authentication options, see the [Authentication](https://github.com/googleapis/google-cloud-java#authentication) page.

#### Storing data
Objects in Datastore are known as entities. Entities are grouped by "kind" and have keys for easy access. In this code snippet, we will create a new entity representing a person and store that data by the person's email.  First, add the following imports at the top of your file:

```java
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
```

Then add the following code to put an entity in Datastore.

```java
KeyFactory keyFactory = datastore.newKeyFactory().setKind("Person");
Key key = keyFactory.newKey("john.doe@gmail.com");
Entity entity = Entity.newBuilder(key)
    .set("name", "John Doe")
    .set("age", 51)
    .set("favorite_food", "pizza")
    .build();
datastore.put(entity);
```

Later, if you want to get this entity back, add the following to your code:

```java
Entity johnEntity = datastore.get(key);
```

#### Running a query
In addition to retrieving entities by their keys, you can perform queries to retrieve entities by
the values of their properties. A typical query includes an entity kind, filters to select entities
with matching values, and sort orders to sequence the results. `google-cloud-datastore` supports two
types of queries: `StructuredQuery` (that allows you to construct query elements) and `GqlQuery`
(which operates using [GQL syntax](https://cloud.google.com/datastore/docs/apis/gql/gql_reference))
in string format. In this tutorial, we will use a simple `StructuredQuery`.

Suppose that you've added more people to Datastore, and now you want to find all people whose favorite food is pizza. Import the following:

```java
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
```

Then add the following code to your program:

```java
Query<Entity> query = Query.newEntityQueryBuilder()
    .setKind("Person")
    .setFilter(PropertyFilter.eq("favorite_food", "pizza"))
    .build();
QueryResults<Entity> results = datastore.run(query);
while (results.hasNext()) {
  Entity currentEntity = results.next();
  System.out.println(currentEntity.getString("name") + ", you're invited to a pizza party!");
}
```

Cloud Datastore relies on indexing to run queries. Indexing is turned on by default for most types of properties. To read more about indexing, see the [Cloud Datastore Index Configuration documentation](https://cloud.google.com/datastore/docs/tools/indexconfig).

#### Updating data
Another thing you'll probably want to do is update your data. The following snippet shows how to update a Datastore entity if it exists.

```java
KeyFactory keyFactory = datastore.newKeyFactory().setKind("keyKind");
Key key = keyFactory.newKey("keyName");
Entity entity = datastore.get(key);
if (entity != null) {
  System.out.println("Updating access_time for " + entity.getString("name"));
  entity = Entity.newBuilder(entity)
      .set("access_time", DateTime.now())
      .build();
  datastore.update(entity);
}
```

The complete source code can be found at
[UpdateEntity.java](https://github.com/googleapis/google-cloud-java/blob/2c1850d4f82f3fbd7b4a50582384c008085aa1a8/google-cloud-examples/src/main/java/com/google/cloud/examples/datastore/snippets/UpdateEntity.java).

#### Complete source code

In
[AddEntitiesAndRunQuery.java](https://github.com/googleapis/google-cloud-java/blob/2c1850d4f82f3fbd7b4a50582384c008085aa1a8/google-cloud-examples/src/main/java/com/google/cloud/examples/datastore/snippets/AddEntitiesAndRunQuery.java)
we put together all the code to store data and run queries into one program. The program assumes that you are
running on Compute Engine or from your own desktop. To run the example on App Engine, simply move
the code from the main method to your application's servlet class and change the print statements to
display on your webpage.

gRPC Java Datastore Client User Guide
-------
In this feature launch, the [Java Datastore client](https://github.com/googleapis/java-datastore) now offers gRPC as a transport layer option with experimental support. Using [gRPC connection pooling](https://grpc.io/docs/guides/performance/) enables distributing RPCs over multiple connections which may improve performance.

#### Download Instructions
Instructions:
1. Clone the grpc-experimental branch from GitHub:
```python
git clone -b grpc-experimental https://github.com/googleapis/java-datastore.git
```
2. Run the following commands to build the library:
```python
# Go to the directory the code was downloaded to
cd java-datastore/

# Build the library
mvn clean install -DskipTests=true
```
3. Add the following dependency to your project:
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-datastore</artifactId>
  <version>2.20.0-grpc-experimental-1-SNAPSHOT</version>
</dependency>
```

#### How to Use
To opt-in to the gRPC transport behavior, simply add the below line of code (`setTransportOptions`) to your Datastore client instantiation.

Example:
```java
DatastoreOptions datastoreOptions =
     DatastoreOptions.newBuilder()
             .setProjectId("my-project")
             .setDatabaseId("my-database")
             .setTransportOptions(GrpcTransportOptions.newBuilder().build())
             .build();
```
Setting the transport options explicitly to `GrpcTransportOptions` will signal the client to use gRPC instead of HTTP when making calls to the server.

To revert back to the existing stable behavior and transport, simply remove the transport options line or replace it with `HttpTransportOptions`. Please note this will require an application rebuild and restart.
Example:
```java
// will default to existing HTTP transport behavior
DatastoreOptions datastoreOptions = DatastoreOptions.newBuilder()
    .setProjectId("my-project")
    .setDatabaseId("my-database")
    .build();

// will also default to existing HTTP transport behavior
DatastoreOptions datastoreOptions =
            DatastoreOptions.newBuilder()
              .setProjectId("my-project")
              .setDatabaseId("my-database")
              .setTransportOptions(HttpTransportOptions.newBuilder()
              .setConnectTimeout(1000)
              .build()).build();
```

Note: client instantiations that already use `setTransportOptions` with `HttpTransportOptions` will continue to have the same behavior. Only transports that are explicitly set to gRPC will change.

#### Verify Datastore Transport Options Type
To verify which type of TransportOptions you have successfully configured, you can use the below lines of code to compare transport options type:
```java
// checks if using gRPC transport options
boolean isGRPC = datastore.getOptions().getTransportOptions() instanceof GrpcTransportOptions;

// checks if using HTTP transport options
boolean isHTTP = datastore.getOptions().getTransportOptions() instanceof HTTPTransportOptions;
```

#### New Features
There are new gRPC specific features available to use in this update.

##### Channel Pooling
To customize the number of channels your client uses, you can update the channel provider in the DatastoreOptions. 
See [ChannelPoolSettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.grpc.ChannelPoolSettings) and [Performance Best Practices](https://grpc.io/docs/guides/performance/) for more information on channel pools and best practices for performance.

Example:
```java
InstantiatingGrpcChannelProvider channelProvider =
      DatastoreSettings.defaultGrpcTransportProviderBuilder()
              .setChannelPoolSettings(
                     ChannelPoolSettings.builder()
                              .setInitialChannelCount(MIN_VAL)
                              .setMaxChannelCount(MAX_VAL)
                              .build())
              .build();

DatastoreOptions options = DatastoreOptions.newBuilder()
                          .setProjectId("my-project")
                          .setChannelProvider(channelProvider)
                          .setTransportOptions(GrpcTransportOptions.newBuilder().build())
                          .build();
```
Testing
-------

This library has tools to help write tests for code that uses the Datastore.

#### On your machine

You can test against a temporary local Datastore by following these steps:

1. [Install Cloud SDK and start the emulator](https://cloud.google.com/datastore/docs/tools/datastore-emulator)

To determine which host/port the emulator is running on:

```
$ gcloud beta emulators datastore env-init

# Sample output:
#   export DATASTORE_EMULATOR_HOST=localhost:8759
```

3. Point your client to the emulator

```java
DatastoreOptions options = DatastoreOptions.newBuilder()
.setProjectId(DatastoreOptions.getDefaultProjectId())
.setHost(System.getenv("DATASTORE_EMULATOR_HOST"))
.setCredentials(NoCredentials.getInstance())
.setRetrySettings(ServiceOptions.getNoRetrySettings())
.build();
Datastore datastore = options.getService();
```
4. Run your tests

Example Applications
--------------------
- [`Bookshelf`](https://github.com/GoogleCloudPlatform/getting-started-java/tree/main/bookshelf) - An App Engine app that manages a virtual bookshelf.
  - This app uses `google-cloud` to interface with Cloud Datastore and Cloud Storage. It also uses Cloud SQL, another Google Cloud Platform service.
- [`Flexible Environment/Datastore example`](https://github.com/GoogleCloudPlatform/java-docs-samples/tree/main/flexible/datastore) - A simple app that uses Cloud Datastore to list the last 10 IP addresses that visited your site.
- [`SparkDemo`](https://github.com/GoogleCloudPlatform/java-docs-samples/blob/main/flexible/sparkjava) - An example of using `google-cloud-datastore` from within the SparkJava and App Engine Flexible Environment frameworks.
  - Read about how it works on the example's [README page](https://github.com/GoogleCloudPlatform/java-docs-samples/tree/main/flexible/sparkjava#how-does-it-work).




## Samples

Samples are in the [`samples/`](https://github.com/googleapis/java-datastore/tree/main/samples) directory.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| Quickstart Sample | [source code](https://github.com/googleapis/java-datastore/blob/main/samples/snippets/src/main/java/com/example/datastore/QuickstartSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-datastore&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/datastore/QuickstartSample.java) |
| Avg Aggregation On Kind | [source code](https://github.com/googleapis/java-datastore/blob/main/samples/snippets/src/main/java/com/example/datastore/aggregation/AvgAggregationOnKind.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-datastore&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/datastore/aggregation/AvgAggregationOnKind.java) |
| Avg Aggregation With Limit | [source code](https://github.com/googleapis/java-datastore/blob/main/samples/snippets/src/main/java/com/example/datastore/aggregation/AvgAggregationWithLimit.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-datastore&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/datastore/aggregation/AvgAggregationWithLimit.java) |
| Avg Aggregation With Order By | [source code](https://github.com/googleapis/java-datastore/blob/main/samples/snippets/src/main/java/com/example/datastore/aggregation/AvgAggregationWithOrderBy.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-datastore&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/datastore/aggregation/AvgAggregationWithOrderBy.java) |
| Avg Aggregation With Property Filter | [source code](https://github.com/googleapis/java-datastore/blob/main/samples/snippets/src/main/java/com/example/datastore/aggregation/AvgAggregationWithPropertyFilter.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-datastore&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/datastore/aggregation/AvgAggregationWithPropertyFilter.java) |
| Count Aggregation In Transaction | [source code](https://github.com/googleapis/java-datastore/blob/main/samples/snippets/src/main/java/com/example/datastore/aggregation/CountAggregationInTransaction.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-datastore&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/datastore/aggregation/CountAggregationInTransaction.java) |
| Count Aggregation On Kind | [source code](https://github.com/googleapis/java-datastore/blob/main/samples/snippets/src/main/java/com/example/datastore/aggregation/CountAggregationOnKind.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-datastore&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/datastore/aggregation/CountAggregationOnKind.java) |
| Count Aggregation With Gql Query | [source code](https://github.com/googleapis/java-datastore/blob/main/samples/snippets/src/main/java/com/example/datastore/aggregation/CountAggregationWithGqlQuery.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-datastore&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/datastore/aggregation/CountAggregationWithGqlQuery.java) |
| Count Aggregation With Limit | [source code](https://github.com/googleapis/java-datastore/blob/main/samples/snippets/src/main/java/com/example/datastore/aggregation/CountAggregationWithLimit.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-datastore&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/datastore/aggregation/CountAggregationWithLimit.java) |
| Count Aggregation With Order By | [source code](https://github.com/googleapis/java-datastore/blob/main/samples/snippets/src/main/java/com/example/datastore/aggregation/CountAggregationWithOrderBy.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-datastore&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/datastore/aggregation/CountAggregationWithOrderBy.java) |
| Count Aggregation With Property Filter | [source code](https://github.com/googleapis/java-datastore/blob/main/samples/snippets/src/main/java/com/example/datastore/aggregation/CountAggregationWithPropertyFilter.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-datastore&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/datastore/aggregation/CountAggregationWithPropertyFilter.java) |
| Count Aggregation With Stale Read | [source code](https://github.com/googleapis/java-datastore/blob/main/samples/snippets/src/main/java/com/example/datastore/aggregation/CountAggregationWithStaleRead.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-datastore&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/datastore/aggregation/CountAggregationWithStaleRead.java) |
| Multiple Aggregations In Gql Query | [source code](https://github.com/googleapis/java-datastore/blob/main/samples/snippets/src/main/java/com/example/datastore/aggregation/MultipleAggregationsInGqlQuery.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-datastore&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/datastore/aggregation/MultipleAggregationsInGqlQuery.java) |
| Multiple Aggregations In Structured Query | [source code](https://github.com/googleapis/java-datastore/blob/main/samples/snippets/src/main/java/com/example/datastore/aggregation/MultipleAggregationsInStructuredQuery.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-datastore&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/datastore/aggregation/MultipleAggregationsInStructuredQuery.java) |
| Sum Aggregation On Kind | [source code](https://github.com/googleapis/java-datastore/blob/main/samples/snippets/src/main/java/com/example/datastore/aggregation/SumAggregationOnKind.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-datastore&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/datastore/aggregation/SumAggregationOnKind.java) |
| Sum Aggregation With Limit | [source code](https://github.com/googleapis/java-datastore/blob/main/samples/snippets/src/main/java/com/example/datastore/aggregation/SumAggregationWithLimit.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-datastore&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/datastore/aggregation/SumAggregationWithLimit.java) |
| Sum Aggregation With Order By | [source code](https://github.com/googleapis/java-datastore/blob/main/samples/snippets/src/main/java/com/example/datastore/aggregation/SumAggregationWithOrderBy.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-datastore&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/datastore/aggregation/SumAggregationWithOrderBy.java) |
| Sum Aggregation With Property Filter | [source code](https://github.com/googleapis/java-datastore/blob/main/samples/snippets/src/main/java/com/example/datastore/aggregation/SumAggregationWithPropertyFilter.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-datastore&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/datastore/aggregation/SumAggregationWithPropertyFilter.java) |
| Create a union between two filters | [source code](https://github.com/googleapis/java-datastore/blob/main/samples/snippets/src/main/java/com/example/datastore/filters/OrFilterQuery.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-datastore&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/datastore/filters/OrFilterQuery.java) |
| Query Profile Explain | [source code](https://github.com/googleapis/java-datastore/blob/main/samples/snippets/src/main/java/com/example/datastore/queryprofile/QueryProfileExplain.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-datastore&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/datastore/queryprofile/QueryProfileExplain.java) |
| Query Profile Explain Aggregation | [source code](https://github.com/googleapis/java-datastore/blob/main/samples/snippets/src/main/java/com/example/datastore/queryprofile/QueryProfileExplainAggregation.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-datastore&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/datastore/queryprofile/QueryProfileExplainAggregation.java) |
| Query Profile Explain Analyze | [source code](https://github.com/googleapis/java-datastore/blob/main/samples/snippets/src/main/java/com/example/datastore/queryprofile/QueryProfileExplainAnalyze.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-datastore&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/datastore/queryprofile/QueryProfileExplainAnalyze.java) |
| Query Profile Explain Analyze Aggregation | [source code](https://github.com/googleapis/java-datastore/blob/main/samples/snippets/src/main/java/com/example/datastore/queryprofile/QueryProfileExplainAnalyzeAggregation.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-datastore&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/datastore/queryprofile/QueryProfileExplainAnalyzeAggregation.java) |
| Task List | [source code](https://github.com/googleapis/java-datastore/blob/main/samples/snippets/src/main/java/com/google/datastore/snippets/TaskList.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-datastore&page=editor&open_in_editor=samples/snippets/src/main/java/com/google/datastore/snippets/TaskList.java) |



## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Cloud Datastore uses both gRPC and HTTP/JSON for the transport layer.

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

## CI Status

Java Version | Status
------------ | ------
Java 8 | [![Kokoro CI][kokoro-badge-image-2]][kokoro-badge-link-2]
Java 8 OSX | [![Kokoro CI][kokoro-badge-image-3]][kokoro-badge-link-3]
Java 8 Windows | [![Kokoro CI][kokoro-badge-image-4]][kokoro-badge-link-4]
Java 11 | [![Kokoro CI][kokoro-badge-image-5]][kokoro-badge-link-5]

Java is a registered trademark of Oracle and/or its affiliates.

[product-docs]: https://cloud.google.com/datastore
[javadocs]: https://cloud.google.com/java/docs/reference/google-cloud-datastore/latest/history
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-datastore/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-datastore/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-datastore/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-datastore/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-datastore/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-datastore/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-datastore/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-datastore/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-datastore/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-datastore/java11.html
[stability-image]: https://img.shields.io/badge/stability-stable-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-datastore.svg
[maven-version-link]: https://central.sonatype.com/artifact/com.google.cloud/google-cloud-datastore/2.21.2
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[auth-scopes]: https://developers.google.com/identity/protocols/oauth2/scopes
[predefined-iam-roles]: https://cloud.google.com/iam/docs/understanding-roles#predefined_roles
[iam-policy]: https://cloud.google.com/iam/docs/overview#cloud-iam-policy
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-cli]: https://cloud.google.com/cli
[troubleshooting]: https://github.com/googleapis/google-cloud-java/blob/main/TROUBLESHOOTING.md
[contributing]: https://github.com/googleapis/java-datastore/blob/main/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-datastore/blob/main/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-datastore/blob/main/LICENSE
[enable-billing]: https://cloud.google.com/apis/docs/getting-started#enabling_billing
[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=datastore.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png

[semver]: https://semver.org/
[cloudlibs]: https://cloud.google.com/apis/docs/client-libraries-explained
[apilibs]: https://cloud.google.com/apis/docs/client-libraries-explained#google_api_client_libraries
[oracle]: https://www.oracle.com/java/technologies/java-se-support-roadmap.html
[g-c-j]: http://github.com/googleapis/google-cloud-java
