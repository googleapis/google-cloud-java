Google Cloud Java Client for Dataproc
=====================================

Java idiomatic client for [Google Cloud Dataproc][cloud-dataproc].

[![Kokoro CI](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.svg)](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.html)
[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-dataproc.svg)]( https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-dataproc.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/google-cloud-java)

- [Product Documentation][dataproc-product-docs]
- [Client Library Documentation][dataproc-client-lib-docs]

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.

Quickstart
----------

[//]: # ({x-version-update-start:google-cloud-dataproc:released})
Add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-dataproc</artifactId>
  <version>0.97.0-alpha</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-dataproc:0.97.0-alpha'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-dataproc" % "0.97.0-alpha"
```
[//]: # ({x-version-update-end})

Authentication
--------------

See the [Authentication](https://github.com/googleapis/google-cloud-java#authentication) section in the base directory's README.

About Google Cloud Dataproc
---------------------------

[Google Cloud Dataproc][cloud-dataproc] manages Hadoop-based clusters and jobs on Google Cloud
Platform.

See the [Google Cloud Dataproc docs][cloud-dataproc-quickstart] for more details on how to activate
Cloud Dataproc for your project.

See the [Dataproc client library docs][dataproc-client-lib-docs] to learn how to interact with the
Cloud Dataproc using this Client Library.

Getting Started
---------------
#### Prerequisites
For this tutorial, you will need a
[Google Developers Console](https://console.developers.google.com/) project with the Dataproc API
enabled. You will need to [enable billing](https://support.google.com/cloud/answer/6158867?hl=en) to
use Google Cloud Dataproc.
[Follow these instructions](https://cloud.google.com/resource-manager/docs/creating-managing-projects) to get your
project set up. [Set up authentication with a service account][auth] so you can access the
API from your local workstation.

#### Installation and setup
You'll need to obtain the `google-cloud-dataproc` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-dataproc` as a dependency in your code.

Transport
---------
Dataproc uses gRPC for the transport layer.

Java Versions
-------------

Java 7 or above is required for using this client.

Testing
-------

This library has tools to help make tests for code using Cloud Dataproc.

See [TESTING] to read more about testing.

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
[TESTING]: https://github.com/googleapis/google-cloud-java/blob/master/TESTING.md

[cloud-dataproc]: https://cloud.google.com/dataproc/
[cloud-dataproc-quickstart]: https://cloud.google.com/dataproc/quickstart-console#before-you-begin
[dataproc-product-docs]: https://cloud.google.com/dataproc/docs/
[dataproc-client-lib-docs]: https://googleapis.github.io/google-cloud-java/google-cloud-clients/apidocs/index.html?com/google/cloud/dataproc/v1/package-summary.html
[auth]: https://cloud.google.com/docs/authentication/getting-started
