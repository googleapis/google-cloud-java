Google Cloud Java Client for Logging
====================================

Java idiomatic client for [Stackdriver Logging][stackdriver-logging].

[![Kokoro CI](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.svg)](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.html)
[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-logging.svg)]( https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-logging.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/google-cloud-java)

- [Product Documentation][logging-product-docs]
- [Client Library Documentation][logging-client-lib-docs]

Quickstart
----------

[//]: # ({x-version-update-start:google-cloud-logging:released})
Add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-logging</artifactId>
  <version>1.79.0</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-logging:1.79.0'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-logging" % "1.79.0"
```
[//]: # ({x-version-update-end})

Example Application
-------------------
[`LoggingExample`](../../google-cloud-examples/src/main/java/com/google/cloud/examples/logging/LoggingExample.java)
is a simple command line interface that provides some of Stackdriver Logging's functionality. Read
more about using the application on the
[`LoggingExample` docs page](https://googleapis.github.io/google-cloud-java/apidocs/?com/google/cloud/examples/logging/LoggingExample.html).

Authentication
--------------

See the [Authentication](https://github.com/googleapis/google-cloud-java#authentication) section in the base directory's README.

About Stackdriver Logging
--------------------------

[Stackdriver Logging][stackdriver-logging] allows you to store, search, analyze, monitor, and alert
on log data and events from Google Cloud Platform and Amazon Web Services (AWS). Logging is a
fully-managed service that performs at scale and can ingest application and system log data from
thousands of VMs. Even better, you can analyze all that log data in real-time.

See the [Stackdriver Logging docs][stackdriver-logging-quickstart] for more details on how to
activate Logging for your project.

See the [Logging client library docs][logging-client-lib-docs] to learn how to interact with the
Stackdriver Logging using this Client Library.

Getting Started
---------------
#### Prerequisites
For this tutorial, you will need a
[Google Developers Console](https://console.developers.google.com/) project with the Logging API
enabled. You will need to [enable billing](https://support.google.com/cloud/answer/6158867?hl=en) to
use Stackdriver Logging.
[Follow these instructions](https://cloud.google.com/resource-manager/docs/creating-managing-projects) to get your
project set up. You will also need to set up the local development environment by [installing the
Google Cloud SDK](https://cloud.google.com/sdk/) and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

#### Installation and setup
You'll need to obtain the `google-cloud-logging` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-logging` as a dependency in your code.

#### Creating an authorized service object
To make authenticated requests to Stackdriver Logging, you must create a service object with
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
Iterator<LogEntry> entryIterator = entries.iterateAll();
while (entryIterator.hasNext()) {
  System.out.println(entryIterator.next());
}
```

#### Add a Stackdriver Logging handler to a logger
You can also register a `LoggingHandler` to a `java.util.logging.Logger` that publishes log entries
to Stackdriver Logging. Given the following logger:
```java
private final static Logger LOGGER = Logger.getLogger(MyClass.class.getName());
```
You can register a `LoggingHandler` with the code:
```java
LoggingHandler.addHandler(LOGGER, new LoggingHandler());
```
After that, logs generated using `LOGGER` will be also directed to Stackdriver Logging.

Notice that you can also register a `LoggingHandler` via the `logging.properties` configuration
file. Adding, for instance, the following line:
```
com.google.cloud.examples.logging.snippets.AddLoggingHandler.handlers=com.google.cloud.logging.LoggingHandler
```
#### Complete source code

In
[CreateAndListMetrics.java](../../google-cloud-examples/src/main/java/com/google/cloud/examples/logging/snippets/CreateAndListMetrics.java),
[WriteAndListLogEntries.java](../../google-cloud-examples/src/main/java/com/google/cloud/examples/logging/snippets/WriteAndListLogEntries.java)
and
[AddLoggingHandler.java](../../google-cloud-examples/src/main/java/com/google/cloud/examples/logging/snippets/AddLoggingHandler.java)
we put together all the code shown above into three programs. The programs assume that you are
running on Compute Engine or from your own desktop.

Transport
---------
Logging uses gRPC for the transport layer.

Java Versions
-------------

Java 7 or above is required for using this client.

Testing
-------

This library has tools to help make tests for code using Stackdriver Logging.

See [TESTING] to read more about testing.

Versioning
----------

This library follows [Semantic Versioning](http://semver.org/).

It is currently in major version one (``1.y.z``), which means that the public API should be considered stable.

Contributing
------------

Contributions to this library are always welcome and highly encouraged.

See `google-cloud`'s [CONTRIBUTING] documentation and the [shared documentation](https://github.com/googleapis/google-cloud-common/blob/master/contributing/readme.md#how-to-contribute-to-gcloud) for more information on how to get started.

Please note that this project is released with a Contributor Code of Conduct. By participating in this project you agree to abide by its terms. See [Code of Conduct][code-of-conduct] for more information.

License
-------

Apache 2.0 - See [LICENSE] for more information.


[CONTRIBUTING]:https://github.com/googleapis/google-cloud-java/blob/master/CONTRIBUTING.md
[code-of-conduct]:https://github.com/googleapis/google-cloud-java/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[LICENSE]: https://github.com/googleapis/google-cloud-java/blob/master/LICENSE
[TESTING]: https://github.com/googleapis/google-cloud-java/blob/master/TESTING.md#testing-code-that-uses-logging


[stackdriver-logging]: https://cloud.google.com/logging/
[stackdriver-logging-quickstart]: https://cloud.google.com/logging/docs/quickstart-sdk
[logging-product-docs]: https://cloud.google.com/logging/docs/
[logging-client-lib-docs]: https://googleapis.github.io/google-cloud-java/google-cloud-clients/apidocs/index.html?com/google/cloud/logging/package-summary.html
