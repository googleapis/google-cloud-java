NIO Filesystem Provider for Google Cloud Storage
========================================================

Implementation of Java 7 `java.nio.file.FileSystem` for
[Google Cloud Storage](https://cloud.google.com/storage/).

This library allows you to use the standardized Java file system API
for interacting with Google Cloud Storage.

[![Build Status](https://travis-ci.org/GoogleCloudPlatform/google-cloud-java.svg?branch=master)](https://travis-ci.org/GoogleCloudPlatform/google-cloud-java)
[![Coverage Status](https://coveralls.io/repos/GoogleCloudPlatform/google-cloud-java/badge.svg?branch=master)](https://coveralls.io/r/GoogleCloudPlatform/google-cloud-java?branch=master)
[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-nio.svg)]( https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-nio.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/google-cloud-java)
[![Dependency Status](https://www.versioneye.com/user/projects/56bd8ee72a29ed002d2b0969/badge.svg?style=flat)](https://www.versioneye.com/user/projects/56bd8ee72a29ed002d2b0969)

-  [Homepage](https://googlecloudplatform.github.io/google-cloud-java/)
-  [API Documentation](https://googlecloudplatform.github.io/google-cloud-java/apidocs/index.html?com/google/cloud/storage/package-summary.html)

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.

Quickstart
----------
If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-nio</artifactId>
  <version>0.9.2-alpha</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-nio:0.9.2-alpha'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-nio" % "0.9.2-alpha"
```

Example Applications
-------------------

* [`Stat`](../../google-cloud-examples/src/main/java/com/google/cloud/examples/nio/Stat.java)
shows how to get started with NIO.

* [`ParallelCountBytes`](../../google-cloud-examples/src/main/java/com/google/cloud/examples/nio/ParallelCountBytes.java)
efficiently downloads a file from Google Cloud Storage.

* [`ListFileSystems`](../google-cloud-nio-examples/README.md) illustrates how
NIO can add Google Cloud Storage support to some legacy programs, without
having to modify them.


Authentication
--------------

See the [Authentication](https://github.com/GoogleCloudPlatform/google-cloud-java#authentication)
section in the base directory's README.

About Google Cloud Storage
--------------------------

[Google Cloud Storage][cloud-storage] is a durable and highly available
object storage service. Google Cloud Storage is almost infinitely scalable
and guarantees consistency: when a write succeeds, the latest copy of the
object will be returned to any GET, globally.

See the [Google Cloud Storage docs][cloud-storage-activation] for more details
on how to activate Cloud Storage for your project.

About Java NIO Providers
------------------------

Java NIO Providers is an extension mechanism that is part of Java and allows
third parties to extend Java's [normal File API][java-file-api] to support
additional filesystems.

Getting Started
---------------
#### Prerequisites

For this tutorial, you will need a [Google Developers
Console](https://console.developers.google.com/) project with "Google Cloud
Storage" and "Google Cloud Storage JSON API" enabled via the console's API
Manager. You will need to [enable
billing](https://support.google.com/cloud/answer/6158867?hl=en) to use Google
Cloud Storage. [Follow these
instructions](https://cloud.google.com/docs/authentication#preparation) to get
your project set up. You will also need to set up the local development
environment by [installing the Google Cloud SDK](https://cloud.google.com/sdk/)
and running the following commands in command line: `gcloud auth login` and
`gcloud config set project [YOUR PROJECT ID]`.

#### Installation and setup
You'll need to obtain the `google-cloud-nio` library.

There are two ways to use this library.

The recommended way is to follow the [Quickstart](#quickstart) section to add
`google-cloud-nio` as a dependency in your code.

The second way is more complicated, but it allows you to add Google Cloud
Storage support to some legacy Java programs. This approach is described in the
[google-cloud-nio-examples README](../google-cloud-nio-examples/README.md).

#### Accessing files

The simplest way to get started is with `Paths` and `Files`:

    Path path = Paths.get(URI.create("gs://bucket/lolcat.csv"));
    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

If you know the paths will point to Google Cloud Storage, you can also use the
direct formulation:

    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("bucket") {
      Path path = fs.getPath("lolcat.csv");
      List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
    }

Once you have a `Path` you can use it as you would a normal file. For example
you can use `InputStream` and `OutputStream` for streaming:

    try (InputStream input = Files.openInputStream(path)) {
      // ...
    }

You can also set various attributes using CloudStorageOptions static helpers:

    Files.write(csvPath, csvLines, StandardCharsets.UTF_8,
        withMimeType(MediaType.CSV_UTF8),
        withoutCaching());

Limitations
-----------

This library is usable, but not yet complete. The following features are not
yet implemented:
 * Listing all the buckets
 * Resuming upload or download
 * Generations
 * File attributes
 * (more - list is not exhaustive)

Some features are not on the roadmap: this library would be a poor choice to
mirror a local filesystem onto the cloud because Google Cloud Storage has a
different set of features from your local disk. This library, by design,
does not mask those differences. Rather, it aims to expose the common
subset via a familiar interface.

**NOTE:** Cloud Storage uses a flat namespace and therefore doesn't support real
directories. So this library supports what's known as "pseudo-directories". Any
path that includes a trailing slash, will be considered a directory. It will
always be assumed to exist, without performing any I/O. This allows you to do
path manipulation in the same manner as you would with the normal UNIX file
system implementation. You can disable this feature with
`CloudStorageConfiguration.usePseudoDirectories()`.

#### Complete source code

There are examples in [google-cloud-examples](../google-cloud-examples/src/main/java/com/google/cloud/examples/nio/)
for your perusal.

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

See `google-cloud`'s [CONTRIBUTING] documentation and the
[shared documentation](https://github.com/GoogleCloudPlatform/gcloud-common/blob/master/contributing/readme.md#how-to-contribute-to-gcloud)
for more information on how to get started.

Please note that this project is released with a Contributor Code of Conduct.
By participating in this project you agree to abide by its terms. See
[Code of Conduct][code-of-conduct] for more information.

License
-------

Apache 2.0 - See [LICENSE] for more information.


[CONTRIBUTING]:https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/CONTRIBUTING.md
[code-of-conduct]:https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[LICENSE]: https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/LICENSE
[TESTING]: https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/TESTING.md#testing-code-that-uses-storage
[cloud-platform]: https://cloud.google.com/

[cloud-storage]: https://cloud.google.com/storage/
[cloud-storage-docs]: https://cloud.google.com/storage/docs/overview
[cloud-storage-create-bucket]: https://cloud.google.com/storage/docs/cloud-console#_creatingbuckets
[storage-api]: https://googlecloudplatform.github.io/google-cloud-java/apidocs/index.html?com/google/cloud/storage/package-summary.html
[cloud-storage-activation]:https://cloud.google.com/storage/docs/signup?hl=en

[java-file-api]: https://docs.oracle.com/javase/7/docs/api/java/nio/file/Files.html
