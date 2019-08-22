# JDBC Driver for Google Cloud Spanner

JDBC Driver for
[Google Cloud Spanner](https://cloud.google.com/spanner/).

## Quickstart

[//]: # ({x-version-update-start:google-cloud-spanner-jdbc:released})
If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-spanner-jdbc</artifactId>
  <version>0.3.0</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-spanner-jdbc:0.3.0'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-spanner-jdbc" % "0.3.0"
```
[//]: # ({x-version-update-end})

## Getting Started
You can access Google Cloud Spanner through JDBC like this:

```java
String url = "jdbc:cloudspanner:/projects/my_project_id/"
           + "instances/my_instance_id/"
           + "databases/my_database_name"
           + "?credentials=/home/cloudspanner-keys/my-key.json"
           + ";autocommit=false";
try (Connection connection = DriverManager.getConnection(url)) {
  try(ResultSet rs = connection.createStatement()
           .executeQuery("SELECT SingerId, AlbumId, MarketingBudget FROM Albums")) {
    while(rs.next()) {
      Long singerId = rs.getLong(1);
    }
  }
}
```

### Connection URL
The JDBC connection URL must be specified in the following format:

```
jdbc:cloudspanner:[//host[:port]]/projects/project-id[/instances/instance-id[/databases/database-name]][\?property-name=property-value[;property-name=property-value]*]?
```

The property-value strings should be url-encoded.

The project-id part of the URI may be filled with the placeholder DEFAULT_PROJECT_ID. This
placeholder will be replaced by the default project id of the environment that is requesting a
connection.
The supported connection properties are:

* credentials (String): URL for the credentials file to use for the connection. If you do not specify any credentials, the default credentials of the environment as returned by {@link GoogleCredentials#getApplicationDefault()} will be used.
* autocommit (boolean): Sets the initial autocommit mode for the connection. Default is true.
* readonly (boolean): Sets the initial readonly mode for the connection. Default is false.
* retryAbortsInternally (boolean): Sets the initial retryAbortsInternally mode for the connection. Default is true. See
CloudSpannerJdbcConnection#setRetryAbortsInternally(boolean) for more information.

### Authentication
The JDBC Driver will either use the credentials that are specified in the connection URL, or if none specified, the default credentials of the environment.

See the
[Authentication](https://github.com/googleapis/google-cloud-java#authentication)
section in the base directory's README for more information.

## Shaded JAR

You can build a shaded JAR of the JDBC Driver to use with third-party tools using the following command:

```
mvn package -Pbuild-jdbc-driver
```

## Java Versions

Java 7 or above is required for using this JDBC Driver.

## Versioning

This library follows [Semantic Versioning](http://semver.org/).

## Contributing

Contributions to this library are always welcome and highly encouraged.

See `google-cloud`'s [CONTRIBUTING] documentation and the
[shared documentation](https://github.com/googleapis/google-cloud-common/blob/master/contributing/readme.md#how-to-contribute-to-gcloud)
for more information on how to get started.

Please note that this project is released with a Contributor Code of Conduct.
By participating in this project you agree to abide by its terms. See
[Code of Conduct][code-of-conduct] for more information.

## License

Apache 2.0 - See [LICENSE] for more information.


[CONTRIBUTING]:https://github.com/googleapis/google-cloud-java/blob/master/CONTRIBUTING.md
[code-of-conduct]:https://github.com/googleapis/google-cloud-java/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[LICENSE]: https://github.com/googleapis/google-cloud-java/blob/master/LICENSE
[cloud-platform]: https://cloud.google.com/

[cloud-spanner]: https://cloud.google.com/spanner/
[cloud-spanner-docs]: https://cloud.google.com/spanner/docs/overview
