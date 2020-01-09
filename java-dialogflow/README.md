# Google Cloud Java Client for Dialogflow

Java idiomatic client for [Dialogflow][dialogflow].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Dialogflow Standard Edition Documentation][dialogflow-standard-product-docs]
- [Dialogflow Enterprise Edition Documentation][dialogflow-enterprise-product-docs]
- [Client Library Documentation][dialogflow-client-lib-docs]

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.

Quickstart
----------
If you are using Maven with a BOM, add this to your pom.xml file.
```xml
<dependencyManagement>
 <dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>libraries-bom</artifactId>
    <version>3.1.0</version>
    <type>pom</type>
    <scope>import</scope>
   </dependency>
 </dependencies>
</dependencyManagement>

<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-dialogflow</artifactId>
</dependency>
```
[//]: # ({x-version-update-start:google-cloud-dialogflow:released})
If you are using Maven without a BOM, add this to your dependencies.
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-dialogflow</artifactId>
  <version>0.120.0</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-dialogflow:0.120.0'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-dialogflow" % "0.120.0"
```
[//]: # ({x-version-update-end})

Authentication
--------------

See the [Authentication](https://github.com/googleapis/google-cloud-java#authentication) section in the base directory's README.

About Dialogflow
----------------

[Dialogflow][dialogflow] is an enterprise-grade NLU platform that makes it easy for developers to design and integrate conversational user interfaces into mobile apps, web applications, devices, and bots.

See the [Dialogflow client library docs][dialogflow-client-lib-docs] to learn how to use this Dialogflow Client Library.

Getting Started
---------------
#### Prerequisites
You will need a [Google Developers Console](https://console.developers.google.com/) project with the Dialogflow API enabled.
[Follow these instructions](https://cloud.google.com/resource-manager/docs/creating-managing-projects) to get your project set up.

#### Installation and setup
You'll need to obtain the `google-cloud-dialogflow` library.  See the [Quickstart](#quickstart) section to add `google-cloud-dialogflow` as a dependency in your code.

Troubleshooting
---------------

To get help, follow the instructions in the [shared Troubleshooting document](https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting).

Transport
---------
Dialogflow uses gRPC for the transport layer.

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

[stability-image]: https://img.shields.io/badge/stability-beta-yellow
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-dialogflow.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-dialogflow&core=gav
[CONTRIBUTING]:https://github.com/googleapis/google-cloud-java/blob/master/CONTRIBUTING.md
[code-of-conduct]:https://github.com/googleapis/google-cloud-java/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[LICENSE]: https://github.com/googleapis/google-cloud-java/blob/master/LICENSE
[dialogflow]: https://dialogflow.com/
[dialogflow-standard-product-docs]: https://dialogflow.com/docs
[dialogflow-enterprise-product-docs]: https://cloud.google.com/dialogflow-enterprise/docs/
[dialogflow-client-lib-docs]: https://googleapis.dev/java/google-cloud-clients/latest/index.html?com/google/cloud/dialogflow/v2beta1/package-summary.html
