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
  <version>0.119.0-alpha</version>
</dependency>
```

If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-logging-logback:0.119.0-alpha'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-logging-logback" % "0.119.0-alpha"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

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

    <!-- Optional: auto detects on App Engine Flex, Standard, GCE and GKE, defaults to "global". See supported resource types  -->
    <resourceType></resourceType>

    <!-- Optional: defaults to the default credentials of the environment -->
    <credentialsFile>/path/to/credentials/file</credentialsFile>

    <!-- Optional: add custom labels to log entries using LoggingEnhancer classes -->
    <enhancer>com.example.enhancers.TestLoggingEnhancer</enhancer>
    <enhancer>com.example.enhancers.AnotherEnhancer</enhancer>
  </appender>

  <root level="info">
    <appender-ref ref="CLOUD" />
  </root>
</configuration>
```

In your code :

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



## Samples

Samples are in the [`samples/`](https://github.com/googleapis/java-logging-logback/tree/master/samples) directory. The samples' `README.md`
has instructions for running the samples.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| Quickstart | [source code](https://github.com/googleapis/java-logging-logback/blob/master/samples/snippets/src/main/java/com/example/logging/logback/Quickstart.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-logging-logback&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/logging/logback/Quickstart.java) |
| Example Enhancer | [source code](https://github.com/googleapis/java-logging-logback/blob/master/samples/snippets/src/main/java/com/example/logging/logback/enhancers/ExampleEnhancer.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-logging-logback&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/logging/logback/enhancers/ExampleEnhancer.java) |



## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Java Versions

Java 7 or above is required for using this client.

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
Java 7 | [![Kokoro CI][kokoro-badge-image-1]][kokoro-badge-link-1]
Java 8 | [![Kokoro CI][kokoro-badge-image-2]][kokoro-badge-link-2]
Java 8 OSX | [![Kokoro CI][kokoro-badge-image-3]][kokoro-badge-link-3]
Java 8 Windows | [![Kokoro CI][kokoro-badge-image-4]][kokoro-badge-link-4]
Java 11 | [![Kokoro CI][kokoro-badge-image-5]][kokoro-badge-link-5]

Java is a registered trademark of Oracle and/or its affiliates.

[product-docs]: https://cloud.google.com/logging-logback/docs/
[javadocs]: https://googleapis.dev/java/google-cloud-logging-logback/latest/index.html
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
[stability-image]: https://img.shields.io/badge/stability-alpha-orange
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-logging-logback.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-logging-logback&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-logging-logback/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-logging-logback/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-logging-logback/blob/master/LICENSE

[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=logging.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png
