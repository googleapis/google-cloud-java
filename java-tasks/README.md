Google Cloud Java Client for Cloud Tasks
======================================

Java idiomatic client for [Cloud Tasks][cloud-tasks].

[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-tasks.svg)](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-tasks.svg)
![Stability][stability-image]

- [Product Documentation][tasks]
- [Client Library Documentation][tasks-client-lib-docs]

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.

Quickstart
----------
If you are using Maven with Bom, Add this to your pom.xml file.
```xml
<dependencyManagement>
 <dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>libraries-bom</artifactId>
    <version>3.5.0</version>
    <type>pom</type>
    <scope>import</scope>
   </dependency>
 </dependencies>
</dependencyManagement>

<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-tasks</artifactId>
</dependency>
```
[//]: # ({x-version-update-start:google-cloud-tasks:released})
If you are using Maven without Bom, Add this to your dependencies.
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-tasks</artifactId>
  <version>1.28.0</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-tasks:1.28.0'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-tasks" % "1.28.0"
```
[//]: # ({x-version-update-end})

Authentication
--------------

See the [Authentication](https://github.com/googleapis/google-cloud-java#authentication) section in the base directory's README.

About Google Cloud Cloud Tasks
----------------------------

Google [Cloud Tasks API][cloud-tasks] manages Cloud Tasks queues and tasks.

See the [Cloud Tasks client library docs][tasks-client-lib-docs] to learn how to use this Cloud Tasks API Client Library.

Getting Started
---------------
#### Prerequisites
You will need a [Google Developers Console](https://console.developers.google.com/) project with the Cloud Tasks API enabled. [Follow these instructions](https://cloud.google.com/resource-manager/docs/creating-managing-projects) to get your project set up. You will also need to set up the local development environment by [installing the Google Cloud SDK](https://cloud.google.com/sdk/) and running the following commands in command line: `gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

#### Installation and setup
You'll need to obtain the `google-cloud-tasks` library.  See the [Quickstart](#quickstart) section to add `google-cloud-tasks` as a dependency in your code.

Troubleshooting
---------------

To get help, follow the instructions in the [shared Troubleshooting document](https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting).

Transport
---------
Cloud Tasks uses gRPC for the transport layer.

Java Versions
-------------

Java 7 or above is required for using this client.

Versioning
----------

This library follows [Semantic Versioning](http://semver.org/).

It is currently in major version zero (``0.y.z``), which means that anything may change at any time and the public API should not be considered stable.

Contributing
------------

Contributions to this library are always welcome and highly encouraged.

See `google-cloud`'s [CONTRIBUTING] documentation and the [shared documentation](https://github.com/googleapis/google-cloud-common/blob/master/contributing/readme.md#how-to-contribute-to-gcloud) for more information on how to get started.

Please note that this project is released with a Contributor Code of Conduct. By participating in this project you agree to abide by its terms. See [Code of Conduct][code-of-conduct] for more information.

License
-------

Apache 2.0 - See [LICENSE] for more information.

## CI Status

Java Version | Status
------------ | ------
Java 7 | [![Kokoro CI][kokoro-badge-image-1]][kokoro-badge-link-1]
Java 8 | [![Kokoro CI][kokoro-badge-image-2]][kokoro-badge-link-2]
Java 8 OSX | [![Kokoro CI][kokoro-badge-image-3]][kokoro-badge-link-3]
Java 8 Windows | [![Kokoro CI][kokoro-badge-image-4]][kokoro-badge-link-4]
Java 11 | [![Kokoro CI][kokoro-badge-image-5]][kokoro-badge-link-5]

[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-tasks/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-tasks/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-tasks/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-tasks/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-tasks/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-tasks/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-tasks/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-tasks/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-tasks/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-tasks/java11.html
[stability-image]: https://img.shields.io/badge/stability-ga-green
[CONTRIBUTING]: https://github.com/googleapis/java-tasks/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-tasks/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[LICENSE]: https://github.com/googleapis/java-tasks/blob/master/LICENSE
[cloud-platform]: https://cloud.google.com/
[cloud-tasks]: https://cloud.google.com/tasks
[tasks]: https://cloud.google.com/tasks/docs
[tasks-client-lib-docs]: https://googleapis.dev/java/google-cloud-tasks/latest/index.html
