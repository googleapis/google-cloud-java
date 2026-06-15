# Google BigQuery JDBC Client for Java

Java idiomatic client for [BigQuery JDBC][product-docs].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][product-docs]
- [Client Library Documentation][javadocs]


## Quickstart


If you are using Maven, add this to your pom.xml file:

```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-bigquery-jdbc</artifactId>
  <version>LATEST_VERSION</version>
</dependency>
```

If you are using Gradle without BOM, add this to your dependencies:

```Groovy
implementation 'com.google.cloud:google-cloud-bigquery-jdbc:LATEST_VERSION'
```

If you are using SBT, add this to your dependencies:

```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-bigquery-jdbc" % "LATEST_VERSION"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Authorization

The client application making API calls must be granted [authorization scopes][auth-scopes] required for the desired BigQuery JDBC APIs, and the authenticated principal must have the [IAM role(s)][predefined-iam-roles] required to access GCP resources using the BigQuery JDBC API calls.

## Developer Guide

### Prerequisites

You need to have either Java with Maven installed or Docker. You might want to install [`Make`](https://www.gnu.org/software/make/) to simplify running commands, otherwise please look into Makefile to check for specific configurations.

### Setup

`make install` primarily relies on `mvn install` command. All following commands are primarily applicable for the `google-cloud-bigquery-jdbc` project.
You can also use `make clean` to clean the project and `make lint` to format the code.

### Running tests

#### Unittests

Run all unittests

`make unittest`

Run specific unittests

`make unittest test=<filter>` 

Please reference [Maven documentation](https://maven.apache.org/surefire/maven-surefire-plugin/examples/single-test.html) for details about `<filter>`

Example: `make unittest test=BigQueryArrowStructTest`

#### Integration tests

IMPORTANT: Running integration tests will skip unit tests by default. To include unit tests, run `make integration-test skipSurefire=false`. Primary focus of this command is to run specific set of tests without a lot of overhead.

Set the following environment variables to run the integration tests:

```
# Default gcloud auth setup
export GOOGLE_APPLICATION_CREDENTIALS=<path-to-service-account-json-config-file>

# Test specfic envs
export SA_EMAIL=email@email.com
export SA_SECRET=<path-to-service-account-json-config-file>
# Alternatively it can be json content:
export SA_SECRET=`cat <path-to-service-account-json-config-file>`
```

Run all integration tests (currently takes 15+ minutes, so this is discouraged).

`make integration-test`

Run specific integration test

`make integration-test test=<filter>` 

Please reference [Maven documentation](https://maven.apache.org/surefire/maven-surefire-plugin/examples/single-test.html) for details about `<filter>`

Example: `make integration-test test=ITBigQueryJDBCTest#testValidServiceAccountAuthenticationOAuthPvtKey`

### Dockerized environment

If you don't have Java or Maven, or if you want to test changes with a different Java version, you can leverage dockerized environment.

One-time run commands are similar to local development make commands:

```
make docker-build
make docker-unittest
make docker-integration-test
```

Please note that running unit or integration tests within docker doesn't leverage maven cache because it is not persisted. 
If you want to run multiple commands, you can start a session and treat this shell session as your local environment. 

```
make docker-session
```

All Docker commands rely only on `GOOGLE_APPLICATION_CREDENTIALS` env being present, it will create rest of env vars as needed.

### Packaging

There are a few ways to package the Google JDBC Driver. The output of the packaging commands can be found in the `target` directory.

`make package` or `make docker-package` will create both a thin jar and a zip file with all dependencies.
`make package-all-dependencies` or `make docker-package-all-dependencies` will create a single jar with all dependencies included.
`make package-all-dependencies-shaded` or `make docker-package-all-dependencies-shaded` will create a single shaded jar with all dependencies included.

#### Thin jar

The thin jar is created with `make package`. The thin jar is packaged as a zip file with its dependencies listed in a `dependencies.txt` file, compatible with `pom.xml`.

#### All dependencies

The jar with all dependencies is also created. This jar includes all dependencies and can be used as a standalone jar with tools like R-Studio. You can run `make package-all-dependencies` or `make docker-package-all-dependencies` to build only the jar with all dependencies.

#### Shaded Jar
You can also build a shaded jar with all dependencies. This can be done by running `make package-all-dependencies-shaded` or `make docker-package-all-dependencies-shaded`.

### Nightly builds

The nightly build runs the full set of integration tests, including the `ITBigQueryJDBCTest` and `ITNightlyBigQueryTest` test suites. It also includes some long-running tests (takes 20+ minutes to complete).

**Note:** These builds are intended for testing and development purposes only and are not recommended for production use.

Nightly Integration Tests include a step to build a full and thin jars and upload them to Google Storage.

They can be retrieved via following commands:

```
gsutil cp gs://bq_devtools_release_private/drivers/jdbc/google-cloud-bigquery-jdbc-latest-all.jar .
gsutil cp gs://bq_devtools_release_private/drivers/jdbc/google-cloud-bigquery-jdbc-latest.zip .
```

#### Performance tests

Cloud Build Pipeline is uploading latest full jar to the internal location for perf tests once a week.

### Code Coverage

We're using [JaCoCo](https://www.eclemma.org/jacoco/) to track Code Coverage. `Makefile` has 2 separate set of commands for unittests and integration tests reports.

You can run `make unit-test-coverage` to generate a coverage report for unit tests. The output will be in `jacoco-unittests.zip`.
You can run `make full-coverage` to generate a coverage report for both unit and integration tests. The output will be in `jacoco-full.zip`.

You can also run `make docker-coverage` which will produce both results. You can find `jacoco-unittests.zip` and `jacoco-full.zip` files in the root with results.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the BigQuery JDBC [API enabled][enable-api].

[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud Command Line Interface][cloud-cli] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-bigquery-jdbc` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-bigquery-jdbc` as a dependency in your code.

## About BigQuery JDBC


[BigQuery JDBC][product-docs] 

See the [BigQuery JDBC client library docs][javadocs] to learn how to
use this BigQuery JDBC Client Library.






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

[product-docs]: https://cloud.google.com/bigquery
[javadocs]: https://cloud.google.com/java/docs/reference/google-cloud-bigquery/latest/history
[stability-image]: https://img.shields.io/badge/stability-unknown-red
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-bigquery-jdbc.svg
[maven-version-link]: https://central.sonatype.com/artifact/com.google.cloud/google-cloud-bigquery-jdbc/0.0.0
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[auth-scopes]: https://developers.google.com/identity/protocols/oauth2/scopes
[predefined-iam-roles]: https://cloud.google.com/iam/docs/understanding-roles#predefined_roles
[iam-policy]: https://cloud.google.com/iam/docs/overview#cloud-iam-policy
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-cli]: https://cloud.google.com/cli
[troubleshooting]: https://github.com/googleapis/google-cloud-java/blob/main/TROUBLESHOOTING.md
[contributing]: https://github.com/googleapis/java-bigquery/blob/main/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-bigquery/blob/main/CODE_OF_CONDUCT.md
[license]: https://github.com/googleapis/java-bigquery/blob/main/LICENSE

[semver]: https://semver.org/
[cloudlibs]: https://cloud.google.com/apis/docs/client-libraries-explained
[apilibs]: https://cloud.google.com/apis/docs/client-libraries-explained#google_api_client_libraries
[oracle]: https://www.oracle.com/java/technologies/java-se-support-roadmap.html
[g-c-j]: http://github.com/googleapis/google-cloud-java
