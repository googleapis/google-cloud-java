# Google Google Cloud Spanner JDBC Client for Java

Java idiomatic client for [Google Cloud Spanner JDBC][product-docs].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][product-docs]
- [Client Library Documentation][javadocs]


## Quickstart


If you are using Maven, add this to your pom.xml file:


<!--- {x-version-update-start:google-cloud-spanner-jdbc:released} -->
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-spanner-jdbc</artifactId>
  <version>2.35.4</version>
</dependency>
```
<!--- {x-version-update-end} -->


If you are using Gradle without BOM, add this to your dependencies

<!--- {x-version-update-start:google-cloud-spanner-jdbc:released} -->
```Groovy
implementation 'com.google.cloud:google-cloud-spanner-jdbc:2.35.4'
```
<!--- {x-version-update-end} -->

If you are using SBT, add this to your dependencies

<!--- {x-version-update-start:google-cloud-spanner-jdbc:released} -->
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-spanner-jdbc" % "2.35.4"
```
<!--- {x-version-update-end} -->

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Authorization

The client application making API calls must be granted [authorization scopes][auth-scopes] required for the desired Google Cloud Spanner JDBC APIs, and the authenticated principal must have the [IAM role(s)][predefined-iam-roles] required to access GCP resources using the Google Cloud Spanner JDBC API calls.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Google Cloud Spanner JDBC [API enabled][enable-api].

[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-spanner-jdbc` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-spanner-jdbc` as a dependency in your code.

## About Google Cloud Spanner JDBC


[Google Cloud Spanner JDBC][product-docs] 

See the [Google Cloud Spanner JDBC client library docs][javadocs] to learn how to
use this Google Cloud Spanner JDBC Client Library.


### Creating a JDBC Connection

The following example shows how to create a JDBC connection to Cloud Spanner and execute a simple query.

```java
String projectId = "my-project";
String instanceId = "my-instance";
String databaseId = "my-database";

try (Connection connection =
    DriverManager.getConnection(
        String.format(
            "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
            projectId, instanceId, databaseId))) {
  try (Statement statement = connection.createStatement()) {
    try (ResultSet rs = statement.executeQuery("SELECT CURRENT_TIMESTAMP()")) {
      while (rs.next()) {
        System.out.printf(
            "Connected to Cloud Spanner at [%s]%n", rs.getTimestamp(1).toString());
      }
    }
  }
}
```

### Connection URL Properties

The Cloud Spanner JDBC driver supports the following connection URL properties. Note that all of
these can also be supplied in a Properties instance that is passed to the
`DriverManager#getConnection(String url, Properties properties)` method.

See [Supported Connection Properties](documentation/connection_properties.md) for a full list of all
supported connection properties.

#### Commonly Used Properties
- default_isolation_level (String): Spanner supports isolation levels REPEATABLE_READ or SERIALIZABLE. SERIALIZABLE is the default. Using isolation level REPEATABLE_READ improves performance by reducing the amount of locks that are taken by transactions that execute a large number of queries in read/write transactions. See https://cloud.google.com/spanner/docs/isolation-levels for more information on the supported isolation levels in Spanner.
- credentials (String): URL for the credentials file to use for the connection. If you do not specify any credentials at all, the default credentials of the environment as returned by `GoogleCredentials#getApplicationDefault()` is used. Example: `jdbc:cloudspanner:/projects/my-project/instances/my-instance/databases/my-db;credentials=/path/to/credentials.json`
- autocommit (boolean): Sets the initial autocommit mode for the connection. Default is true.
- readonly (boolean): Sets the initial readonly mode for the connection. Default is false.
- autoConfigEmulator (boolean): Automatically configure the connection to try to connect to the Cloud Spanner emulator. You do not need to specify any host or port in the connection string as long as the emulator is running on the default host/port (localhost:9010). The instance and database in the connection string will automatically be created if these do not yet exist on the emulator. This means that you do not need to execute any `gcloud` commands on the emulator to create the instance and database before you can connect to it. Example: `jdbc:cloudspanner:/projects/test-project/instances/test-instance/databases/test-db;autoConfigEmulator=true`
- usePlainText (boolean): Sets whether the JDBC connection should establish an unencrypted connection to a (local) server. This option can only be used when connecting to a local emulator that does not require an encrypted connection, and that does not require authentication. Example: `jdbc:cloudspanner://localhost:9010/projects/test-project/instances/test-instance/databases/test-db;usePlainText=true`
- optimizerVersion (String): Sets the default query optimizer version to use for this connection. See also https://cloud.google.com/spanner/docs/query-optimizer/query-optimizer-versions.

#### Advanced Properties
- DEPRECATED minSessions (int): Sets the minimum number of sessions in the backing session pool. Defaults to 100. This configuration option is no longer needed, as the JDBC driver by default uses a [single multiplexed session for all operations](https://cloud.google.com/spanner/docs/sessions#multiplexed_sessions).
- DEPRECATED maxSessions (int): Sets the maximum number of sessions in the backing session pool. Defaults to 400. This configuration option is no longer needed, as the JDBC driver by default uses a [single multiplexed session for all operations](https://cloud.google.com/spanner/docs/sessions#multiplexed_sessions).
- numChannels (int): Sets the number of gRPC channels to use. Defaults to 4.
- retryAbortsInternally (boolean): The JDBC driver will by default automatically retry aborted transactions internally. This is done by keeping track of all statements and the results of these during a transaction, and if the transaction is aborted by Cloud Spanner, it will replay the statements on a new transaction and compare the results with the initial attempt. Disable this option if you want to handle aborted transactions in your own application.
- autocommit_dml_mode (string): Determines the transaction type that is used to execute
  [DML statements](https://cloud.google.com/spanner/docs/dml-tasks#using-dml) when the connection is
  in auto-commit mode. The following values are supported:
  - TRANSACTIONAL (default): Uses atomic read/write transactions.
  - PARTITIONED_NON_ATOMIC: Use Partitioned DML for DML statements in auto-commit mode. Use this mode
    to execute DML statements that exceed the transaction mutation limit in Spanner.
  - TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC: Execute DML statements using atomic read/write
    transactions. If this fails because the mutation limit on Spanner has been exceeded, the DML statement
    is retried using a Partitioned DML transaction.
- auto_batch_dml (boolean): Automatically buffer DML statements and execute them as one batch,
  instead of executing them on Spanner directly. The buffered DML statements are executed on Spanner
  in one batch when a query is executed, or when the transaction is committed. This option can for
  example be used in combination with Hibernate to automatically group more (small) DML statements
  into one batch.
- oauthToken (string): A valid pre-existing OAuth token to use for authentication for this connection. Setting this property will take precedence over any value set for a credentials file.
- lenient (boolean): Enable this to force the JDBC driver to ignore unknown properties in the connection URL. Some applications automatically add additional properties to the URL that are not recognized by the JDBC driver. Normally, the JDBC driver will reject this, unless `lenient` mode is enabled.
- enableDirectAccess (boolean): Sets whether the JDBC connection should establish connection using Directpath. Setting this property will enable client to establish connection directly to Spanner if client is running in GCP VM, Otherwise it will fall back standard network path. 

For a full list of supported connection properties, see
[Supported Connection Properties](documentation/connection_properties.md).

### Jar with Dependencies
A single jar with all dependencies can be downloaded from https://repo1.maven.org/maven2/com/google/cloud/google-cloud-spanner-jdbc/latest
or be built with the command `mvn package` (select the jar that is named `google-cloud-spanner-jdbc-<version>-single-jar-with-dependencies.jar`).

### Creating a Shaded Jar

A jar with all dependencies included is automatically generated when you execute `mvn package`.
The dependencies in this jar are not shaded. To create a jar with shaded dependencies you must
activate the `shade` profile like this:

 ```
 mvn package -Pshade
 ```

## Samples

See the [samples](/samples) directory for various examples for using the Spanner JDBC driver.

- [snippets](/samples/snippets): Contains small code snippets for commonly used JDBC and Spanner
  features. Refer to these snippets for examples on how to execute DDL and DML batches, use various
  data types with the JDBC driver, execute various types of transactions (read/write, read-only,
  Partitioned DML), use request and transaction tags, etc.
- [spring-data-jdbc](/samples/spring-data-jdbc): Contains a sample application that uses Spring Data
  JDBC in combination with a Spanner PostgreSQL database.
- [spring-data-mybatis](/samples/spring-data-mybatis): Contains a sample application that uses
  Spring Data MyBatis in combination with a Spanner PostgreSQL database.
- [quickperf](/samples/quickperf): Contains a simple benchmarking application.


## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

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

[product-docs]: https://cloud.google.com/spanner/docs/use-oss-jdbc
[javadocs]: https://googleapis.dev/java/google-cloud-spanner-jdbc/latest/index.html
[stability-image]: https://img.shields.io/badge/stability-ga-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-spanner-jdbc.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-spanner-jdbc&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[auth-scopes]: https://developers.google.com/identity/protocols/oauth2/scopes
[predefined-iam-roles]: https://cloud.google.com/iam/docs/understanding-roles#predefined_roles
[iam-policy]: https://cloud.google.com/iam/docs/overview#cloud-iam-policy
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-java/blob/main/TROUBLESHOOTING.md
[contributing]: https://github.com/googleapis/java-spanner-jdbc/blob/main/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-spanner-jdbc/blob/main/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-spanner-jdbc/blob/main/LICENSE


[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png

[semver]: https://semver.org/
[cloudlibs]: https://cloud.google.com/apis/docs/client-libraries-explained
[apilibs]: https://cloud.google.com/apis/docs/client-libraries-explained#google_api_client_libraries
[oracle]: https://www.oracle.com/java/technologies/java-se-support-roadmap.html
[g-c-j]: http://github.com/googleapis/google-cloud-java
