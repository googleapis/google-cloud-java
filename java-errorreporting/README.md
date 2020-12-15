# Google Cloud Error Reporting Client for Java

Java idiomatic client for [Cloud Error Reporting][product-docs].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][product-docs]
- [Client Library Documentation][javadocs]

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.

## Quickstart

If you are using Maven with [BOM][libraries-bom], add this to your pom.xml file
```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>libraries-bom</artifactId>
      <version>16.2.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-errorreporting</artifactId>
  </dependency>
  <!-- BEGIN_EXCLUDE -->
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-core</artifactId>
  </dependency>
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.1</version>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>com.google.truth</groupId>
    <artifactId>truth</artifactId>
    <version>1.1</version>
    <scope>test</scope>
  </dependency>
  <!-- END_EXCLUDE -->
</dependencies>

```

If you are using Maven without BOM, add this to your dependencies:

```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-errorreporting</artifactId>
  <version>0.120.9-beta</version>
</dependency>

```

If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-errorreporting:0.120.11-beta'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-errorreporting" % "0.120.11-beta"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Cloud Error Reporting [API enabled][enable-api].

[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-errorreporting` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-errorreporting` as a dependency in your code.

## About Cloud Error Reporting


[Cloud Error Reporting][product-docs] counts, analyzes, and aggregates the crashes in your running cloud services. A centralized error management interface displays the results with sorting and filtering capabilities. A dedicated view shows the error details: time chart, occurrences, affected user count, first- and last-seen dates and a cleaned exception stack trace. Opt in to receive email and mobile alerts on new errors.

See the [Cloud Error Reporting client library docs][javadocs] to learn how to
use this Cloud Error Reporting Client Library.





## Samples

Samples are in the [`samples/`](https://github.com/googleapis/java-errorreporting/tree/master/samples) directory. The samples' `README.md`
has instructions for running the samples.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| Quick Start | [source code](https://github.com/googleapis/java-errorreporting/blob/master/samples/snippets/src/main/java/com/example/errorreporting/QuickStart.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-errorreporting&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/errorreporting/QuickStart.java) |



## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Cloud Error Reporting uses gRPC for the transport layer.

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

[product-docs]: https://cloud.google.com/error-reporting
[javadocs]: https://googleapis.dev/java/google-cloud-errorreporting/latest/
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-errorreporting/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-errorreporting/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-errorreporting/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-errorreporting/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-errorreporting/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-errorreporting/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-errorreporting/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-errorreporting/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-errorreporting/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-errorreporting/java11.html
[stability-image]: https://img.shields.io/badge/stability-beta-yellow
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-errorreporting.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-errorreporting&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-errorreporting/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-errorreporting/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-errorreporting/blob/master/LICENSE

[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=clouderrorreporting.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png
