# Google Cloud Java Client for Spanner

Java idiomatic client for [Cloud Spanner][cloud-spanner].

[![Kokoro CI](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.svg)](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.html)
[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-spanner.svg)](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-spanner.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/google-cloud-java)

- [Product Documentation][spanner-product-docs]
- [Client Library Documentation][spanner-client-lib-docs]

## Quickstart

[//]: # ({x-version-update-start:google-cloud-spanner:released})
If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-spanner</artifactId>
  <version>1.24.0</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-spanner:1.24.0'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-spanner" % "1.24.0"
```
[//]: # ({x-version-update-end})

## Authentication

See the
[Authentication](https://github.com/googleapis/google-cloud-java#authentication)
section in the base directory's README.

## About Cloud Spanner

[Cloud Spanner][cloud-spanner] is a fully managed, mission-critical, 
relational database service that offers transactional consistency at global scale, 
schemas, SQL (ANSI 2011 with extensions), and automatic, synchronous replication 
for high availability.

Be sure to activate the Cloud Spanner API on the Developer's Console to
use Cloud Spanner from your project.

See the [Spanner client lib docs][spanner-client-lib-docs] to learn how to
interact with Cloud Spanner using this Client Library.

## Getting Started
#### Prerequisites
Please refer to the [getting
started](https://cloud.google.com/spanner/docs/getting-started/java/) guide.

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

In [DatabaseSelect.java](../../google-cloud-examples/src/main/java/com/google/cloud/examples/spanner/snippets/DatabaseSelect.java) we put together all the code shown above in a single program.

## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting
document](https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting).

Transport
---------
Spanner uses gRPC for the transport layer.

## Java Versions

Java 7 or above is required for using this client.

## Testing

This library has tools to help make tests for code using Cloud Spanner.

See [TESTING] to read more about testing.

## Versioning

This library follows [Semantic Versioning](http://semver.org/).

It is currently in major version zero (`0.y.z`), which means that anything may
change at any time and the public API should not be considered stable.

## Contributing

Contributions to this library are always welcome and highly encouraged.

See [CONTRIBUTING] for more information on how to get started.

## License

Apache 2.0 - See [LICENSE] for more information.

[CONTRIBUTING]:https://github.com/googleapis/google-cloud-java/blob/master/CONTRIBUTING.md
[LICENSE]: https://github.com/googleapis/google-cloud-java/blob/master/LICENSE
[TESTING]: https://github.com/googleapis/google-cloud-java/blob/master/TESTING.md#testing-code-that-uses-cloud-spanner
[cloud-platform]: https://cloud.google.com/
[cloud-spanner]: https://cloud.google.com/spanner/
[spanner-product-docs]: https://cloud.google.com/spanner/docs/
[spanner-client-lib-docs]: https://googleapis.github.io/google-cloud-java/google-cloud-clients/apidocs/index.html?com/google/cloud/spanner/package-summary.html
