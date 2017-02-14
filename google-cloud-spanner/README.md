# Google Cloud Java Client for Spanner

Java idiomatic client for [Cloud
Spanner](https://cloud.google.com/spanner).

[![Build
Status](https://travis-ci.org/GoogleCloudPlatform/google-cloud-java.svg?branch=master)](https://travis-ci.org/GoogleCloudPlatform/google-cloud-java)
[![Coverage
Status](https://coveralls.io/repos/GoogleCloudPlatform/google-cloud-java/badge.svg?branch=master)](https://coveralls.io/r/GoogleCloudPlatform/google-cloud-java?branch=master)
[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-spanner.svg)](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-spanner.svg)
[![Codacy
Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/google-cloud-java)
[![Dependency
Status](https://www.versioneye.com/user/projects/56bd8ee72a29ed002d2b0969/badge.svg?style=flat)](https://www.versioneye.com/user/projects/56bd8ee72a29ed002d2b0969)

-   [Homepage](https://googlecloudplatform.github.io/google-cloud-java/)
-   [API
    Documentation](https://googlecloudplatform.github.io/google-cloud-java/apidocs/index.html?com/google/cloud/spanner/package-summary.html)

> Note: This client is a work-in-progress, and may occasionally make
> backwards-incompatible changes.

## Quickstart

If you are using Maven, add this to your pom.xml file `xml <dependency>
<groupId>com.google.cloud</groupId>
<artifactId>google-cloud-spanner</artifactId> <version>0.9.2-beta</version>
</dependency>` If you are using Gradle, add this to your dependencies `Groovy
compile 'com.google.cloud:google-cloud-spanner:0.9.2-beta'` If you are using
SBT, add this to your dependencies `Scala libraryDependencies +=
"com.google.cloud" % "google-cloud-spanner" % "0.9.2-beta"`

## Authentication

See the
[Authentication](https://github.com/GoogleCloudPlatform/google-cloud-java#authentication)
section in the base directory's README.

## About Cloud Spanner

[Cloud Spanner][cloud-spanner] is a fully managed, mission-critical relational database service
built from the ground up and battle tested for transactional consistency, high
availability, and global scale. With traditional relational semantics (schemas,
ACID transactions, SQL) and automatic, synchronous replication for high
availability, Cloud Spanner is the only database service of its kind on the
market.

Be sure to activate the Cloud Spanner API on the Developer's Console to
use Cloud Spanner from your project.

See the `google-cloud` API [spanner documentation][spanner-api] to learn how to
interact with Cloud Spanner using this Client Library.

## Getting Started

Please refer to the [getting
started](https://cloud.google.com/spanner/docs/getting-started/java/) guide.

## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting
document](https://github.com/GoogleCloudPlatform/gcloud-common/blob/master/troubleshooting/readme.md#troubleshooting).

## Java Versions

Java 7 or above is required for using this client.

## Testing

This library has tools to help make tests for code using Cloud Spanner.

See [TESTING] to read more about testing.

## Versioning

This library follows [Semantic Versioning](http://semver.org/).

It is currently in major version zero (`0.y.z`), which means that anything may
change at any time and the public API should not be considered stable.

## Contributing

Contributions to this library are always welcome and highly encouraged.

See [CONTRIBUTING] for more information on how to get started.

## License

Apache 2.0 - See [LICENSE] for more information.

[CONTRIBUTING]:https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/CONTRIBUTING.md
[LICENSE]: https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/LICENSE
[TESTING]: https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/TESTING.md#testing-code-that-uses-cloud-spanner
[cloud-platform]: https://cloud.google.com/
[cloud-spanner]: https://cloud.google.com/spanner/
[spanner-api]: https://googlecloudplatform.github.io/google-cloud-java/apidocs/index.html?com/google/cloud/spanner/package-summary.html
