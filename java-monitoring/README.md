# Google Stackdriver Monitoring Client for Java

Java idiomatic client for [Stackdriver Monitoring][product-docs].

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
    <artifactId>google-cloud-monitoring</artifactId>
  </dependency>
</dependencies>

```

If you are using Maven without BOM, add this to your dependencies:

```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-monitoring</artifactId>
  <version>2.0.9</version>
</dependency>

```

If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-monitoring:2.0.8'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-monitoring" % "2.0.8"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Stackdriver Monitoring [API enabled][enable-api].
You will need to [enable billing][enable-billing] to use Google Stackdriver Monitoring.
[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-monitoring` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-monitoring` as a dependency in your code.

## About Stackdriver Monitoring


[Stackdriver Monitoring][product-docs] collects metrics, events, and metadata from Google Cloud, Amazon Web Services (AWS), hosted uptime probes, and application instrumentation. Using the BindPlane service, you can also collect this data from over 150 common application components, on-premise systems, and hybrid cloud systems. Stackdriver ingests that data and generates insights via dashboards, charts, and alerts. BindPlane is included with your Google Cloud project at no additional cost.

See the [Stackdriver Monitoring client library docs][javadocs] to learn how to
use this Stackdriver Monitoring Client Library.





## Samples

Samples are in the [`samples/`](https://github.com/googleapis/java-monitoring/tree/master/samples) directory. The samples' `README.md`
has instructions for running the samples.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| Create Alert Policy | [source code](https://github.com/googleapis/java-monitoring/blob/master/samples/snippets/src/main/java/com/example/monitoring/CreateAlertPolicy.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-monitoring&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/monitoring/CreateAlertPolicy.java) |
| Create Metric Descriptor | [source code](https://github.com/googleapis/java-monitoring/blob/master/samples/snippets/src/main/java/com/example/monitoring/CreateMetricDescriptor.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-monitoring&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/monitoring/CreateMetricDescriptor.java) |
| Create Time Series | [source code](https://github.com/googleapis/java-monitoring/blob/master/samples/snippets/src/main/java/com/example/monitoring/CreateTimeSeries.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-monitoring&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/monitoring/CreateTimeSeries.java) |
| Delete Alert Policy | [source code](https://github.com/googleapis/java-monitoring/blob/master/samples/snippets/src/main/java/com/example/monitoring/DeleteAlertPolicy.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-monitoring&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/monitoring/DeleteAlertPolicy.java) |
| Delete Metric Descriptor | [source code](https://github.com/googleapis/java-monitoring/blob/master/samples/snippets/src/main/java/com/example/monitoring/DeleteMetricDescriptor.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-monitoring&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/monitoring/DeleteMetricDescriptor.java) |
| Delete Notification Channel | [source code](https://github.com/googleapis/java-monitoring/blob/master/samples/snippets/src/main/java/com/example/monitoring/DeleteNotificationChannel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-monitoring&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/monitoring/DeleteNotificationChannel.java) |
| Enable Disable Alert Policy | [source code](https://github.com/googleapis/java-monitoring/blob/master/samples/snippets/src/main/java/com/example/monitoring/EnableDisableAlertPolicy.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-monitoring&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/monitoring/EnableDisableAlertPolicy.java) |
| Get Alert Policy | [source code](https://github.com/googleapis/java-monitoring/blob/master/samples/snippets/src/main/java/com/example/monitoring/GetAlertPolicy.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-monitoring&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/monitoring/GetAlertPolicy.java) |
| Get Monitored Resource | [source code](https://github.com/googleapis/java-monitoring/blob/master/samples/snippets/src/main/java/com/example/monitoring/GetMonitoredResource.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-monitoring&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/monitoring/GetMonitoredResource.java) |
| List Alert Policy | [source code](https://github.com/googleapis/java-monitoring/blob/master/samples/snippets/src/main/java/com/example/monitoring/ListAlertPolicy.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-monitoring&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/monitoring/ListAlertPolicy.java) |
| List Metric Descriptor | [source code](https://github.com/googleapis/java-monitoring/blob/master/samples/snippets/src/main/java/com/example/monitoring/ListMetricDescriptor.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-monitoring&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/monitoring/ListMetricDescriptor.java) |
| List Time Series | [source code](https://github.com/googleapis/java-monitoring/blob/master/samples/snippets/src/main/java/com/example/monitoring/ListTimeSeries.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-monitoring&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/monitoring/ListTimeSeries.java) |
| Monitored Resources List | [source code](https://github.com/googleapis/java-monitoring/blob/master/samples/snippets/src/main/java/com/example/monitoring/MonitoredResourcesList.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-monitoring&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/monitoring/MonitoredResourcesList.java) |
| Quickstart Sample | [source code](https://github.com/googleapis/java-monitoring/blob/master/samples/snippets/src/main/java/com/example/monitoring/QuickstartSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-monitoring&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/monitoring/QuickstartSample.java) |
| Time Series Headers List | [source code](https://github.com/googleapis/java-monitoring/blob/master/samples/snippets/src/main/java/com/example/monitoring/TimeSeriesHeadersList.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-monitoring&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/monitoring/TimeSeriesHeadersList.java) |
| Update Alert Policy | [source code](https://github.com/googleapis/java-monitoring/blob/master/samples/snippets/src/main/java/com/example/monitoring/UpdateAlertPolicy.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-monitoring&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/monitoring/UpdateAlertPolicy.java) |
| Uptime Sample | [source code](https://github.com/googleapis/java-monitoring/blob/master/samples/snippets/src/main/java/com/example/monitoring/UptimeSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-monitoring&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/monitoring/UptimeSample.java) |



## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Stackdriver Monitoring uses gRPC for the transport layer.

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

[product-docs]: https://cloud.google.com/monitoring/docs
[javadocs]: https://googleapis.dev/java/google-cloud-monitoring/latest/
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-monitoring/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-monitoring/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-monitoring/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-monitoring/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-monitoring/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-monitoring/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-monitoring/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-monitoring/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-monitoring/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-monitoring/java11.html
[stability-image]: https://img.shields.io/badge/stability-ga-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-monitoring.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-monitoring&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-monitoring/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-monitoring/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-monitoring/blob/master/LICENSE
[enable-billing]: https://cloud.google.com/apis/docs/getting-started#enabling_billing
[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=monitoring.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png
