# Java Client for Grafeas

Java idiomatic client for [Grafeas][grafeas].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Client Library Documentation][javadocs]

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.

## Quickstart

[//]: # ({x-version-update-start:grafeas:released})
If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>io.grafeas</groupId>
  <artifactId>grafeas</artifactId>
  <version>0.24.0</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'io.grafeas:grafeas:0.24.0'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "io.grafeas" % "grafeas" % "0.24.0"
```
[//]: # ({x-version-update-end})

## About Grafeas

[Grafeas][grafeas] is an open artifact metadata API to audit and govern your
software supply chain.

Grafeas defines an API spec for managing metadata about software resources, such
as container images, Virtual Machine (VM) images, JAR files, and scripts. You
can use Grafeas to define and aggregate information about your project's
components. Grafeas provides organizations with a central source of truth for
tracking and enforcing policies across an ever growing set of software
development teams and pipelines. Build, auditing, and compliance tools can use
the Grafeas API to store, query, and retrieve comprehensive metadata on software
components of all kinds.

### Supported Implementations

This library should be able to communicate with any Grafeas-backed API,
however, you may be interested in other, custom implementations that extend this
interface:

* [Google Cloud Container Analysis](https://github.com/googleapis/java-containeranalysis)

## Getting Started

### Installation and setup

You'll need to obtain the `grafeas` library.  See the [Quickstart](#quickstart) section
to add `grafeas` as a dependency in your code.

## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Grafeas uses gRPC for the transport layer.

## Java Versions

Java 7 or above is required for using this client.

## Versioning

This library follows [Semantic Versioning](http://semver.org/).

It is currently in major version zero (``0.y.z``), which means that anything may change at any time
and the public API should not be considered stable.

## Contributing

Contributions to this library are always welcome and highly encouraged.

See [CONTRIBUTING.md][contributing] documentation for more information on how to get started.

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

[grafeas]: https://grafeas.io
[javadocs]: https://googleapis.dev/java/grafeas/latest/
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-grafeas/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-grafeas/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-grafeas/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-grafeas/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-grafeas/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-grafeas/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-grafeas/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-grafeas/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-grafeas/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-grafeas/java11.html
[stability-image]: https://img.shields.io/badge/stability-alpha-orange
[maven-version-image]: https://img.shields.io/maven-central/v/io.grafeas/grafeas.svg
[maven-version-link]: https://search.maven.org/search?q=g:io.grafeas%20AND%20a:grafeas&core=gav
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-grafeas/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-grafeas/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-grafeas/blob/master/LICENSE