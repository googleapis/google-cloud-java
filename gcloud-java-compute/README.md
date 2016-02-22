Google Cloud Java Client for Compute (Alpha)
====================================

Java idiomatic client for [Google Cloud Compute] (https://cloud.google.com/compute).

[![Build Status](https://travis-ci.org/GoogleCloudPlatform/gcloud-java.svg?branch=master)](https://travis-ci.org/GoogleCloudPlatform/gcloud-java)
[![Coverage Status](https://coveralls.io/repos/GoogleCloudPlatform/gcloud-java/badge.svg?branch=master)](https://coveralls.io/r/GoogleCloudPlatform/gcloud-java?branch=master)
<!-- TODO(mziccard): add in the maven shield once the artifact is pushed to maven -->
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/gcloud-java)
[![Dependency Status](https://www.versioneye.com/user/projects/56bd8ee72a29ed002d2b0969/badge.svg?style=flat)](https://www.versioneye.com/user/projects/56bd8ee72a29ed002d2b0969)

-  [Homepage] (https://googlecloudplatform.github.io/gcloud-java/)
<!-- TODO(mziccard): add link to API documentatin -->

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.

Quickstart
----------
If you are using Maven, add this to your pom.xml file
<!-- TODO(mziccard): add maven dependency code -->
If you are using Gradle, add this to your dependencies
<!-- TODO(mziccard): add gradle dependency code -->
If you are using SBT, add this to your dependencies
<!-- TODO(mziccard): add sbt dependency code -->

Example Application
-------------------
<!-- TODO(mziccard): add example application -->

Authentication
--------------

See the [Authentication](https://github.com/GoogleCloudPlatform/gcloud-java#authentication) section in the base directory's README.

About Google Cloud BigQuery
--------------------------

[Google Cloud Compute][cloud-compute] delivers virtual machines running in Google's innovative data
centers and worldwide fiber network. Compute Engine's tooling and workflow support enable scaling
from single instances to global, load-balanced cloud computing. Compute Engine's VMs boot quickly,
come with persistent disk storage, deliver consistent performance and are available in many
configurations.

Be sure to activate the Google Cloud Compute API on the Developer's Console to use Compute from
your project.

See the ``gcloud-java`` API [compute documentation][compute-api] to learn how to interact
with Google Cloud Compute using this Client Library.

Getting Started
---------------
<!-- TODO(mziccard): add code snippet -->

Troubleshooting
---------------

To get help, follow the `gcloud-java` links in the `gcloud-*`[shared Troubleshooting document](https://github.com/GoogleCloudPlatform/gcloud-common/blob/master/troubleshooting/readme.md#troubleshooting).

Java Versions
-------------

Java 7 or above is required for using this client.

Testing
-------

This library has tools to help make tests for code using Cloud BigQuery.

See [TESTING] to read more about testing.

Versioning
----------

This library follows [Semantic Versioning] (http://semver.org/).

It is currently in major version zero (``0.y.z``), which means that anything
may change at any time and the public API should not be considered
stable.

Contributing
------------

Contributions to this library are always welcome and highly encouraged.

See [CONTRIBUTING] for more information on how to get started.

License
-------

Apache 2.0 - See [LICENSE] for more information.


[CONTRIBUTING]:https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/CONTRIBUTING.md
[LICENSE]: https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/LICENSE
[TESTING]: https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/TESTING.md#testing-code-that-uses-compute
[cloud-platform]: https://cloud.google.com/

[cloud-compute]: https://cloud.google.com/compute/
[compute-api]: http://googlecloudplatform.github.io/gcloud-java/apidocs/index.html?com/google/gcloud/compute/package-summary.html
