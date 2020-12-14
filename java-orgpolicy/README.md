# Google Cloud Organization Policy Client for Java

Java idiomatic client for [Cloud Organization Policy][product-docs].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][product-docs]
- [Client Library Documentation][javadocs]

## Quickstart


If you are using Maven, add this to your pom.xml file:

```xml
<dependency>
  <groupId>com.google.api.grpc</groupId>
  <artifactId>proto-google-cloud-orgpolicy-v1</artifactId>
  <version>1.0.2</version>
</dependency>
```

[//]: # ({x-version-update-start:proto-google-cloud-orgpolicy-v1:released})

If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.api.grpc:proto-google-cloud-orgpolicy-v1:1.0.8'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.api.grpc" % "proto-google-cloud-orgpolicy-v1" % "1.0.8"
```
[//]: # ({x-version-update-end})

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Cloud Organization Policy [API enabled][enable-api].
You will need to [enable billing][enable-billing] to use Google Cloud Organization Policy.
[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `proto-google-cloud-orgpolicy-v1` library.  See the [Quickstart](#quickstart) section
to add `proto-google-cloud-orgpolicy-v1` as a dependency in your code.

## About Cloud Organization Policy


[Cloud Organization Policy][product-docs] n/a

See the [Cloud Organization Policy client library docs][javadocs] to learn how to
use this Cloud Organization Policy Client Library.






## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Cloud Organization Policy uses gRPC for the transport layer.

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

[product-docs]: n/a
[javadocs]: https://googleapis.dev/java/proto-google-cloud-orgpolicy-v1/latest/index.html
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-orgpolicy/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-orgpolicy/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-orgpolicy/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-orgpolicy/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-orgpolicy/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-orgpolicy/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-orgpolicy/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-orgpolicy/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-orgpolicy/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-orgpolicy/java11.html
[stability-image]: https://img.shields.io/badge/stability-ga-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.api.grpc/proto-google-cloud-orgpolicy-v1.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.api.grpc%20AND%20a:proto-google-cloud-orgpolicy-v1&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-orgpolicy/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-orgpolicy/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-orgpolicy/blob/master/LICENSE
[enable-billing]: https://cloud.google.com/apis/docs/getting-started#enabling_billing

[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png
