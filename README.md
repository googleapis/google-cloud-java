# Google Cloud Logging Logback Appender Client for Java

Java idiomatic client for [Cloud Logging Logback Appender][product-docs].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][product-docs]
- [Client Library Documentation][javadocs]

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.


## Quickstart


If you are using Maven, add this to your pom.xml file:


```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-logging-logback</artifactId>
  <version>0.127.15-alpha</version>
</dependency>
```

If you are using Gradle without BOM, add this to your dependencies:

```Groovy
implementation 'com.google.cloud:google-cloud-logging-logback:0.127.15-alpha'
```

If you are using SBT, add this to your dependencies:

```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-logging-logback" % "0.127.15-alpha"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Authorization

The client application making API calls must be granted [authorization scopes][auth-scopes] required for the desired Cloud Logging Logback Appender APIs, and the authenticated principal must have the [IAM role(s)][predefined-iam-roles] required to access GCP resources using the Cloud Logging Logback Appender API calls.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Cloud Logging Logback Appender [API enabled][enable-api].

[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-logging-logback` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-logging-logback` as a dependency in your code.

## About Cloud Logging Logback Appender


[Cloud Logging Logback Appender][product-docs] 

See the [Cloud Logging Logback Appender client library docs][javadocs] to learn how to
use this Cloud Logging Logback Appender Client Library.


### Usage
Add the appender to your [Logback configuration](https://logback.qos.ch/manual/configuration.html) `logback.xml`.
See [Logback filters](https://logback.qos.ch/manual/filters.html#thresholdFilter) for information on filtering log output and
 [encoders](https://logback.qos.ch/manual/encoders.html) for information on formatting.


```xml
<configuration>
  <appender name="CLOUD" class="com.google.cloud.logging.logback.LoggingAppender">
    <!-- Optional: filter logs at and above this level -->
    <filter class="ch.qos.logback.classic.filter.ThresholdFilter">
        <level>INFO</level>
    </filter>

    <!-- Optional: defaults to "java.log" -->
    <log>application.log</log>

    <!-- Optional: defaults to "ERROR" -->
    <flushLevel>WARNING</flushLevel>

    <!-- Optional: defaults to ASYNC -->
    <writeSynchronicity>SYNC</writeSynchronicity>

    <!-- Optional: defaults to true -->
    <autoPopulateMetadata>false</autoPopulateMetadata>

    <!-- Optional: defaults to false -->
    <redirectToStdout>true</redirectToStdout>

    <!-- Optional: auto detects on App Engine Flex, Standard, GCE and GKE, defaults to "global". -->
    <resourceType></resourceType>

    <!-- Optional: defaults to the default credentials of the environment -->
    <credentialsFile>/path/to/credentials/file</credentialsFile>

    <!-- Optional: defaults to the project id obtained during authentication process. Project id is also used to construct resource name of the log entries -->
    <logDestinationProjectId>String</logDestinationProjectId>

    <!-- Optional: add custom labels to log entries using LoggingEnhancer classes -->
    <enhancer>com.example.enhancers.TestLoggingEnhancer</enhancer>
    <enhancer>com.example.enhancers.AnotherEnhancer</enhancer>
  </appender>

  <root level="info">
    <appender-ref ref="CLOUD" />
  </root>
</configuration>
```

In your code:

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogger {
    private final Logger logger = LoggerFactory.getLogger(TestLogger.class);

    public void log(String name) {
        logger.info("This is a test");
    }

    public static void main(String[] args) {
        TestLogger testLogger = new TestLogger();
        testLogger.log("test");
    }
}
```

### Populate log entries with metadata

The library provides multiple ways to enrich log entries with additional information.
You can select one or more ways to customize log entries that will be written into Cloud Logging.

* Manually update a log entry using [`LoggingEnhancer`]
(https://github.com/googleapis/java-logging/blob/main/google-cloud-logging/src/main/java/com/google/cloud/logging/.
* Use [`ILoggingEvent`](https://logback.qos.ch/apidocs/ch/qos/logback/classic/spi/ILoggingEvent.html) to update a log entry with [`LoggingEventEnhancer`]
(https://github.com/googleapis/java-logging-logback/blob/main/src/main/java/com/google/cloud/logging/logback/LoggingEventEnhancer.java).
* Enable [auto-population](https://github.com/googleapis/java-logging#auto-population-of-log-entrys-metadata) of the `LogEntry` metadata using the `autoPopulateMetadata` configuration flag.

#### Optimize log ingestion

By default, the appender will ingest log entries asynchronously by calling Logging API.
Multiple calls may be aggregated before being sent to improve use of API quota and bandwidth.
You can set the `writeSynchronicity` configuration flag to `SYNC` if they want to ingest log entries synchronously.
Note that configuring synchronous ingestion will probably result in performance penalties to your applications.
If you plan to deploy your application in one of Google Cloud managed environments (e.g. Cloud Run, Cloud Function or App Engine),
you can leverage the support provided by the implicit logging agent and the [structured logging](https://cloud.google.com/logging/docs/structured-logging) feature.
To use it, set the `redirectToStdout` configuration flag to `true`.
This flag instructs the appender to print the log entries to `stdout` instead of ingesting them using Logging API.
The log entries are printed using the [structured logging Json format](https://cloud.google.com/logging/docs/structured-logging#special-payload-fields).
In result, the logging agent will be responsible for ingesting the logs to Logging API.
Note that using the structured logging Json format you cannot control the log name where the logs will be ingested.
The logs will be ingested into the project that hosts the environment where your application is running.
The configuration `logDestinationProjectId` will be ignored.




## Samples

Samples are in the [`samples/`](https://github.com/googleapis/java-logging-logback/tree/main/samples) directory.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| Quickstart | [source code](https://github.com/googleapis/java-logging-logback/blob/main/samples/snippets/src/main/java/com/example/logging/logback/Quickstart.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-logging-logback&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/logging/logback/Quickstart.java) |
| Example Enhancer | [source code](https://github.com/googleapis/java-logging-logback/blob/main/samples/snippets/src/main/java/com/example/logging/logback/enhancers/ExampleEnhancer.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-logging-logback&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/logging/logback/enhancers/ExampleEnhancer.java) |



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


It is currently in major version zero (``0.y.z``), which means that anything may change at any time
and the public API should not be considered stable.


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

[product-docs]: https://cloud.google.com/logging/docs/setup/java#logback_appender_for
[javadocs]: https://cloud.google.com/java/docs/reference/google-cloud-logging-logback/latest/history
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-logging-logback/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-logging-logback/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-logging-logback/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-logging-logback/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-logging-logback/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-logging-logback/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-logging-logback/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-logging-logback/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-logging-logback/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-logging-logback/java11.html
[stability-image]: https://img.shields.io/badge/stability-preview-yellow
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-logging-logback.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-logging-logback&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[auth-scopes]: https://developers.google.com/identity/protocols/oauth2/scopes
[predefined-iam-roles]: https://cloud.google.com/iam/docs/understanding-roles#predefined_roles
[iam-policy]: https://cloud.google.com/iam/docs/overview#cloud-iam-policy
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/main/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-logging-logback/blob/main/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-logging-logback/blob/main/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-logging-logback/blob/main/LICENSE

[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=logging.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png

[semver]: https://semver.org/
[cloudlibs]: https://cloud.google.com/apis/docs/client-libraries-explained
[apilibs]: https://cloud.google.com/apis/docs/client-libraries-explained#google_api_client_libraries
[oracle]: https://www.oracle.com/java/technologies/java-se-support-roadmap.html
[g-c-j]: http://github.com/googleapis/google-cloud-java
