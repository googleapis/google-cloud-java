Google Cloud Java Client for Firestore
=================================

[![Kokoro CI](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.svg)](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.html)
[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-firestore.svg)](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-firestore.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/google-cloud-java)

-  [Product Documentation](https://cloud.google.com/firestore/docs/)
-  [Client Library Documentation](https://googleapis.github.io/google-cloud-java/google-cloud-clients/apidocs/index.html?com/google/cloud/firestore/package-summary.html)

Quickstart
----------

[//]: # ({x-version-update-start:google-cloud-firestore:released})
If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-firestore</artifactId>
  <version>1.9.0</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-firestore:1.9.0'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-firestore" % "1.9.0"
```
[//]: # ({x-version-update-end})

Authentication
--------------

See the
[Authentication](https://github.com/googleapis/google-cloud-java#authentication)
section in the base directory's README.

About Google Cloud Firestore
----------------------------

Cloud Firestore is a fully-managed NoSQL document database for mobile, web, and server development from Firebase and Google Cloud Platform.  It's backed by a multi-region replicated database that ensures once data is committed, it's durable even in the face of unexpected disasters. Not only that, but despite being a distributed database, it's also strongly consistent and offers seamless integration with other Firebase and Google Cloud Platform products, including Google Cloud Functions.

Troubleshooting
---------------

To get help, follow the instructions in the [shared Troubleshooting document](https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting).

Transport
---------
Firestore uses gRPC for the transport layer.

Java Versions
-------------

Java 7 or above is required for using this client.

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
[cloud-platform]: https://cloud.google.com/
[developers-console]:https://console.developers.google.com/
