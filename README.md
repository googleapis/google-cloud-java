# Google BigQuery Storage Client for Java

Java idiomatic client for [BigQuery Storage][product-docs].

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
      <version>16.4.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-bigquerystorage</artifactId>
  </dependency>

```

If you are using Maven without BOM, add this to your dependencies:

```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-bigquerystorage</artifactId>
  <version>1.9.0</version>
</dependency>

```

If you are using Gradle 5.x or later, add this to your dependencies
```Groovy
implementation platform('com.google.cloud:libraries-bom:16.4.0')

compile 'com.google.cloud:google-cloud-bigquerystorage'
```
If you are using Gradle without BOM, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-bigquerystorage:1.9.0'
```

If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-bigquerystorage" % "1.9.0"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the BigQuery Storage [API enabled][enable-api].
You will need to [enable billing][enable-billing] to use Google BigQuery Storage.
[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-bigquerystorage` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-bigquerystorage` as a dependency in your code.

## About BigQuery Storage


[BigQuery Storage][product-docs] is an API for reading data stored in BigQuery. This API provides direct, high-throughput read
access to existing BigQuery tables, supports parallel access with automatic liquid sharding, and allows fine-grained
control over what data is returned.

See the [BigQuery Storage client library docs][javadocs] to learn how to
use this BigQuery Storage Client Library.





## Samples

Samples are in the [`samples/`](https://github.com/googleapis/java-bigquerystorage/tree/master/samples) directory. The samples' `README.md`
has instructions for running the samples.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| Storage Arrow Sample | [source code](https://github.com/googleapis/java-bigquerystorage/blob/master/samples/snippets/src/main/java/com/example/bigquerystorage/StorageArrowSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerystorage&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerystorage/StorageArrowSample.java) |
| Storage Sample | [source code](https://github.com/googleapis/java-bigquerystorage/blob/master/samples/snippets/src/main/java/com/example/bigquerystorage/StorageSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerystorage&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerystorage/StorageSample.java) |
| Write Committed Stream | [source code](https://github.com/googleapis/java-bigquerystorage/blob/master/samples/snippets/src/main/java/com/example/bigquerystorage/WriteCommittedStream.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerystorage&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerystorage/WriteCommittedStream.java) |
| Write Pending Stream | [source code](https://github.com/googleapis/java-bigquerystorage/blob/master/samples/snippets/src/main/java/com/example/bigquerystorage/WritePendingStream.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerystorage&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerystorage/WritePendingStream.java) |
| Write To Default Stream | [source code](https://github.com/googleapis/java-bigquerystorage/blob/master/samples/snippets/src/main/java/com/example/bigquerystorage/WriteToDefaultStream.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerystorage&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerystorage/WriteToDefaultStream.java) |



## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

BigQuery Storage uses gRPC for the transport layer.

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

[product-docs]: https://cloud.google.com/bigquery/docs/reference/storage/
[javadocs]: https://googleapis.dev/java/google-cloud-bigquerystorage/latest
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquerystorage/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquerystorage/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquerystorage/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquerystorage/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquerystorage/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquerystorage/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquerystorage/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquerystorage/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquerystorage/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquerystorage/java11.html
[stability-image]: https://img.shields.io/badge/stability-ga-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-bigquerystorage.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-bigquerystorage&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-bigquerystorage/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-bigquerystorage/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-bigquerystorage/blob/master/LICENSE
[enable-billing]: https://cloud.google.com/apis/docs/getting-started#enabling_billing
[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=bigquerystorage.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png
