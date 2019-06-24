Google Cloud BigQuery Storage Java Client
==================================

Java idiomatic client for Cloud BigQuery Storage.

[![Kokoro CI](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.svg)](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.html)
[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-bigquerystorage.svg)]( https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-bigquerystorage.svg)

- [Client Library Documentation][bigquerystorage-client-lib-docs]

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.

Quickstart
----------

[//]: # ({x-version-update-start:google-cloud-bigquerystorage:released})
Add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-bigquerystorage</artifactId>
  <version>0.97.0-beta</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-bigquerystorage:0.97.0-beta'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-bigquerystorage" % "0.97.0-beta"
```
[//]: # ({x-version-update-end})

Authentication
--------------

See the [Authentication](https://github.com/googleapis/google-cloud-java#authentication) section in the base directory's README.

About Cloud BigQuery Storage
---------------------

Cloud BigQuery Storage is an API for reading data stored in BigQuery. This API provides direct, high-throughput read
access to existing BigQuery tables, supports parallel access with automatic liquid sharding, and allows fine-grained
control over what data is returned.


See the [Cloud BigQuery Storage client library docs][bigquerystorage-client-lib-docs] to learn how to read date stored
in BigQuery using this library.

Getting Started

#### Installation and setup
You'll need to obtain the `google-cloud-bigquerystorage` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-bigquerystorage` as a dependency in your code.

Transport
---------
Cloud BigQuery Storage uses gRPC for the transport layer.

Java Versions
-------------

Java 7 or above is required for using this client.

Testing
-------

This library has tools to help make tests for code using Cloud BigQuery Storage.

Versioning
----------

This library follows [Semantic Versioning](http://semver.org/).

It is currently in major version zero (``0.y.z``), which means that anything
may change at any time and the public API should not be considered
stable.

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

[bigquerystorage-client-lib-docs]: https://googleapis.github.io/google-cloud-java/google-cloud-clients/apidocs/index.html?com/google/cloud/bigquery/storage/v1beta1/package-summary.html
