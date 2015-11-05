Google Cloud Java Client for Pub/Sub
====================================

Java idiomatic client for [Google Cloud Pub/Sub] (https://cloud.google.com/pubsub/).

[![Build Status](https://travis-ci.org/GoogleCloudPlatform/gcloud-java.svg?branch=master)](https://travis-ci.org/GoogleCloudPlatform/gcloud-java)
[![Coverage Status](https://coveralls.io/repos/GoogleCloudPlatform/gcloud-java/badge.svg?branch=master)](https://coveralls.io/r/GoogleCloudPlatform/gcloud-java?branch=master)
[![Maven](https://img.shields.io/maven-central/v/com.google.gcloud/gcloud-java-pubsub.svg)]( https://img.shields.io/maven-central/v/com.google.gcloud/gcloud-java-pubsub.svg)

-  [Homepage] (https://googlecloudplatform.github.io/gcloud-java/)
-  [API Documentation] (http://googlecloudplatform.github.io/gcloud-java/apidocs)

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.

Quickstart
----------
Add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.gcloud</groupId>
  <artifactId>gcloud-java-pubsub</artifactId>
  <version>0.0.10</version>
</dependency>
```

Example Application
-------------------
TODO

Authentication
--------------

See the [Authentication](https://github.com/GoogleCloudPlatform/gcloud-java#authentication) section in the base directory's README.

About Google Cloud Pub/Sub
--------------------------

[Google Cloud Pub/Sub][cloud-pubsub] is designed to provide reliable,
many-to-many, asynchronous messaging between applications. Publisher
applications can send messages to a ``topic`` and other applications can
subscribe to that topic to receive the messages. By decoupling senders and
receivers, Google Cloud Pub/Sub allows developers to communicate between
independently written applications.

TODO: link to docs on activating Pub/Sub, high-level documentation on
the API, and code snippet

Java Versions
-------------

Java 7 or above is required for using this client.

Testing
-------

TODO

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

[cloud-pubsub]: https://cloud.google.com/storage/
