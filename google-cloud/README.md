Google Cloud Java Client
==========================

Java idiomatic client for [Google Cloud Platform][cloud-platform] services.

[![Build Status](https://travis-ci.org/GoogleCloudPlatform/google-cloud-java.svg?branch=master)](https://travis-ci.org/GoogleCloudPlatform/google-cloud-java)
[![Coverage Status](https://coveralls.io/repos/GoogleCloudPlatform/google-cloud-java/badge.svg?branch=master)](https://coveralls.io/r/GoogleCloudPlatform/google-cloud-java?branch=master)
[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-core.svg)]( https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-core.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/google-cloud-java)
[![Dependency Status](https://www.versioneye.com/user/projects/56bd8ee72a29ed002d2b0969/badge.svg?style=flat)](https://www.versioneye.com/user/projects/56bd8ee72a29ed002d2b0969)

-  [Homepage] (https://googlecloudplatform.github.io/google-cloud-java/)
-  [API Documentation] (http://googlecloudplatform.github.io/google-cloud-java/apidocs)

This client supports the following Google Cloud Platform services:

-  [Google Cloud Datastore] (https://cloud.google.com/datastore/) [datastore documentation][datastore-api] 
-  [Google Cloud Storage] (https://cloud.google.com/storage/) [storage documentation][storage-api] 

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.

Quickstart
----------
If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud</artifactId>
  <version>0.9.2-alpha</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud:0.9.2-alpha'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud" % "0.9.2-alpha"
```

Troubleshooting
---------------

To get help, follow the instructions in the [shared Troubleshooting document](https://github.com/GoogleCloudPlatform/gcloud-common/blob/master/troubleshooting/readme.md#troubleshooting).

Java Versions
-------------

Java 7 or above is required for using this client.

Versioning
----------

This library follows [Semantic Versioning] (http://semver.org/).

It is currently in major version zero (``0.y.z``), which means that anything
may change at any time and the public API should not be considered
stable.

Contributing
------------

Contributions to this library are always welcome and highly encouraged.

See `google-cloud-java`'s [CONTRIBUTING] documentation and the [shared documentation](https://github.com/GoogleCloudPlatform/gcloud-common/blob/master/contributing/readme.md#how-to-contribute-to-gcloud) for more information on how to get started.

Please note that this project is released with a Contributor Code of Conduct. By participating in this project you agree to abide by its terms. See [Code of Conduct][code-of-conduct] for more information.

License
-------

Apache 2.0 - See [LICENSE] for more information.


[CONTRIBUTING]:https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/CONTRIBUTING.md
[code-of-conduct]:https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[LICENSE]: https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/LICENSE
[cloud-platform]: https://cloud.google.com/
[cloud-datastore]: https://cloud.google.com/datastore/docs
[cloud-datastore-docs]: https://cloud.google.com/datastore/docs
[cloud-datastore-activation]: https://cloud.google.com/datastore/docs/activate
[datastore-api]: https://googlecloudplatform.github.io/google-cloud-java/apidocs/index.html?com/google/cloud/datastore/package-summary.html

[cloud-pubsub]: https://cloud.google.com/pubsub/
[cloud-pubsub-docs]: https://cloud.google.com/pubsub/docs

[cloud-storage]: https://cloud.google.com/storage/
[cloud-storage-docs]: https://cloud.google.com/storage/docs/overview
[cloud-storage-create-bucket]: https://cloud.google.com/storage/docs/cloud-console#_creatingbuckets
[storage-api]: https://googlecloudplatform.github.io/google-cloud-java/apidocs/index.html?com/google/cloud/storage/package-summary.html
