# Google Cloud Logging Client for Java

Java idiomatic client for [Cloud Logging][product-docs].

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
      <version>16.1.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-logging</artifactId>
  </dependency>
</dependencies>

```

If you are using Maven without BOM, add this to your dependencies:

```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-logging</artifactId>
  <version>2.1.1-SNAPSHOT</version>
</dependency>

```

If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-logging:2.1.0'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-logging" % "2.1.0"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Cloud Logging [API enabled][enable-api].

[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-logging` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-logging` as a dependency in your code.

## About Cloud Logging


[Cloud Logging][product-docs] allows you to store, search, analyze, monitor, and alert on log data and events from Google Cloud and Amazon Web Services. Using the BindPlane service, you can also collect this data from over 150 common application components, on-premises systems, and hybrid cloud systems. BindPlane is included with your Google Cloud project at no additional cost.

See the [Cloud Logging client library docs][javadocs] to learn how to
use this Cloud Logging Client Library.


#### Creating an authorized service object
To make authenticated requests to Cloud Logging, you must create a service object with
credentials. You can then make API calls by calling methods on the Logging service object. The
simplest way to authenticate is to use
[Application Default Credentials](https://developers.google.com/identity/protocols/application-default-credentials).
These credentials are automatically inferred from your environment, so you only need the following
code to create your service object:

```java
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingOptions;

LoggingOptions options = LoggingOptions.getDefaultInstance();
try(Logging logging = options.getService()) {
  // use logging here
}
```

For other authentication options, see the
[Authentication](https://github.com/googleapis/google-cloud-java#authentication) page.

#### Creating a metric
With Logging you can create logs-based metrics. Logs-based metrics allow to keep track of the number
of log messages associated to specific events. Add the following imports at the top of your file:

```java
import com.google.cloud.logging.Metric;
import com.google.cloud.logging.MetricInfo;
```
Then, to create the metric, use the following code:

```java
MetricInfo metricInfo = MetricInfo.newBuilder("test-metric", "severity >= ERROR")
    .setDescription("Log entries with severity higher or equal to ERROR")
    .build();
logging.create(metricInfo);
```

#### Writing log entries
With Logging you can also write custom log entries. Add the following imports at the top of your
file:
```java
import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.Payload.StringPayload;

import java.util.Collections;
```
Then, to write the log entries, use the following code:
```java
LogEntry firstEntry = LogEntry.newBuilder(StringPayload.of("message"))
    .setLogName("test-log")
    .setResource(MonitoredResource.newBuilder("global")
        .addLabel("project_id", options.getProjectId())
        .build())
    .build();
logging.write(Collections.singleton(firstEntry));
```

#### Listing log entries
With Logging you can also list log entries that have been previously written. Add the following
imports at the top of your file:
```java
import com.google.cloud.Page;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging.EntryListOption;
```
Then, to list the log entries, use the following code:

``` java
Page<LogEntry> entries = logging.listLogEntries(
    EntryListOption.filter("logName=projects/" + options.getProjectId() + "/logs/test-log"));
Iterator<LogEntry> entryIterator = entries.iterateAll().iterator();
while (entryIterator.hasNext()) {
  System.out.println(entryIterator.next());
}
```

#### Add a Cloud Logging handler to a logger
You can also register a `LoggingHandler` to a `java.util.logging.Logger` that publishes log entries
to Cloud Logging. Given the following logger:
```java
private final static Logger LOGGER = Logger.getLogger(MyClass.class.getName());
```
You can register a `LoggingHandler` with the code:
```java
LoggingHandler.addHandler(LOGGER, new LoggingHandler());
```
After that, logs generated using `LOGGER` will be also directed to Cloud Logging.

Notice that you can also register a `LoggingHandler` via the `logging.properties` configuration
file. Adding, for instance, the following line:
```
com.google.cloud.examples.logging.snippets.AddLoggingHandler.handlers=com.google.cloud.logging.LoggingHandler
```
#### Complete source code

In
[CreateAndListMetrics.java](https://github.com/googleapis/google-cloud-java/tree/master/google-cloud-examples/src/main/java/com/google/cloud/examples/logging/snippets/CreateAndListMetrics.java),
[WriteAndListLogEntries.java](https://github.com/googleapis/google-cloud-java/tree/master/google-cloud-examples/src/main/java/com/google/cloud/examples/logging/snippets/WriteAndListLogEntries.java)
and
[AddLoggingHandler.java](https://github.com/googleapis/google-cloud-java/tree/master/google-cloud-examples/src/main/java/com/google/cloud/examples/logging/snippets/AddLoggingHandler.java)
we put together all the code shown above into three programs. The programs assume that you are
running on Compute Engine or from your own desktop.



## Samples

Samples are in the [`samples/`](https://github.com/googleapis/java-logging/tree/master/samples) directory. The samples' `README.md`
has instructions for running the samples.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| List Logs | [source code](https://github.com/googleapis/java-logging/blob/master/samples/snippets/src/main/java/com/example/logging/ListLogs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-logging&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/logging/ListLogs.java) |
| Quickstart Sample | [source code](https://github.com/googleapis/java-logging/blob/master/samples/snippets/src/main/java/com/example/logging/QuickstartSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-logging&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/logging/QuickstartSample.java) |
| Quickstart | [source code](https://github.com/googleapis/java-logging/blob/master/samples/snippets/src/main/java/com/example/logging/jul/Quickstart.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-logging&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/logging/jul/Quickstart.java) |
| Example Enhancer | [source code](https://github.com/googleapis/java-logging/blob/master/samples/snippets/src/main/java/com/example/logging/jul/enhancers/ExampleEnhancer.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-logging&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/logging/jul/enhancers/ExampleEnhancer.java) |



## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Cloud Logging uses gRPC for the transport layer.

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

[product-docs]: https://cloud.google.com/logging/docs
[javadocs]: https://googleapis.dev/java/google-cloud-logging/latest/
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-logging/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-logging/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-logging/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-logging/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-logging/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-logging/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-logging/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-logging/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-logging/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-logging/java11.html
[stability-image]: https://img.shields.io/badge/stability-ga-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-logging.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-logging&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-logging/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-logging/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-logging/blob/master/LICENSE

[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=logging.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png
