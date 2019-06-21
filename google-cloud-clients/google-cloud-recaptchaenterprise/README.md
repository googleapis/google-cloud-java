Google Cloud Java Client for reCAPTCHA Enterprise
===================================================

Java idiomatic client for [reCAPTCHA Enterprise][product-overview].

[![Kokoro CI](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.svg)](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.html)
[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-recaptchaenterprise.svg)](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-recaptchaenterprise.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/google-cloud-java)

- [Product Documentation][product-docs]
- [Client Library Documentation][lib-docs]

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.

Quickstart
----------

[//]: # ({x-version-update-start:google-cloud-recaptchaenterprise:released})
If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-recaptchaenterprise</artifactId>
  <version>0.8.0</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-recaptchaenterprise:0.8.0'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-recaptchaenterprise" % "0.8.0"
```
[//]: # ({x-version-update-end})

Authentication
--------------

See the [Authentication](https://github.com/googleapis/google-cloud-java#authentication) section in the base directory's README.

About reCAPTCHA Enterprise
----------------------------

[reCAPTCHA Enterprise][product-overview] Help protect your website from fraudulent activity, spam, and abuse.

See the [reCAPTCHA Enterprise client library docs][lib-docs] to learn how to use this reCAPTCHA Enterprise Client Library.

Getting Started
---------------
#### Prerequisites
You will need a [Google Developers Console](https://console.developers.google.com/) project with the reCAPTCHA Enterprise API enabled. [Follow these instructions](https://cloud.google.com/resource-manager/docs/creating-managing-projects) to get your project set up. You will also need to set up the local development environment by [installing the Google Cloud SDK](https://cloud.google.com/sdk/) and running the following commands in command line: `gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

#### Installation and setup
You'll need to obtain the `google-cloud-recaptchaenterprise` library.  See the [Quickstart](#quickstart) section to add `google-cloud-recaptchaenterprise` as a dependency in your code.

Troubleshooting
---------------

To get help, follow the instructions in the [shared Troubleshooting document](https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting).

Transport
---------
reCAPTCHA Enterprise uses gRPC for the transport layer.

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


[CONTRIBUTING]:https://github.com/googleapis/google-cloud-java/blob/master/CONTRIBUTING.md
[code-of-conduct]:https://github.com/googleapis/google-cloud-java/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[LICENSE]: https://github.com/googleapis/google-cloud-java/blob/master/LICENSE
[cloud-platform]: https://cloud.google.com/
[product-overview]: https://cloud.google.com/recaptcha-enterprise/
[product-docs]: https://cloud.google.com/recaptcha-enterprise/docs/
[lib-docs]: https://googleapis.github.io/google-cloud-java/google-cloud-clients/apidocs/index.html?com/google/cloud/recaptchaenterprise/v1beta1/package-summary.html
