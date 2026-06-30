# Google NIO Filesystem Provider for Google Cloud Storage Client for Java

Java idiomatic client for [NIO Filesystem Provider for Google Cloud Storage][product-docs].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][product-docs]
- [Client Library Documentation][javadocs]

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.


## Quickstart

If you are using Maven with [BOM][libraries-bom], add this to your pom.xml file

```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>libraries-bom</artifactId>
      <version>22.0.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-nio</artifactId>
  </dependency>
</dependencies>

```

If you are using Maven without BOM, add this to your dependencies:


```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-nio</artifactId>
  <version>0.123.10</version>
</dependency>

```

If you are using Gradle 5.x or later, add this to your dependencies

```Groovy
implementation platform('com.google.cloud:libraries-bom:23.0.0')

implementation 'com.google.cloud:google-cloud-nio'
```
If you are using Gradle without BOM, add this to your dependencies

```Groovy
implementation 'com.google.cloud:google-cloud-nio:0.123.10'
```

If you are using SBT, add this to your dependencies

```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-nio" % "0.123.10"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Authorization

The client application making API calls must be granted [authorization scopes][auth-scopes] required for the desired NIO Filesystem Provider for Google Cloud Storage APIs, and the authenticated principal must have the [IAM role(s)][predefined-iam-roles] required to access GCP resources using the NIO Filesystem Provider for Google Cloud Storage API calls.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the NIO Filesystem Provider for Google Cloud Storage [API enabled][enable-api].

[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-nio` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-nio` as a dependency in your code.

## About NIO Filesystem Provider for Google Cloud Storage


[NIO Filesystem Provider for Google Cloud Storage][product-docs] provides a Google Cloud Storage extension for Java's NIO Filesystem.

See the [NIO Filesystem Provider for Google Cloud Storage client library docs][javadocs] to learn how to
use this NIO Filesystem Provider for Google Cloud Storage Client Library.


#### About Google Cloud Storage

[Google Cloud Storage](https://cloud.google.com/storage/) is a durable and highly available
object storage service. Google Cloud Storage is almost infinitely scalable
and guarantees consistency: when a write succeeds, the latest copy of the
object will be returned to any GET, globally.

See the [Google Cloud Storage docs](https://cloud.google.com/storage/docs/signup?hl=en) for more details
on how to activate Cloud Storage for your project.

#### About Java NIO Providers

Java NIO Providers is an extension mechanism that is part of Java and allows
third parties to extend Java's [normal File API](https://docs.oracle.com/javase/7/docs/api/java/nio/file/Files.html) to support
additional filesystems.

#### Accessing files

The simplest way to get started is with `Paths` and `Files`:

```java
Path path = Paths.get(URI.create("gs://bucket/lolcat.csv"));
List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
```

If you know the paths will point to Google Cloud Storage, you can also use the
direct formulation:

```java
try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("bucket")) {
  Path path = fs.getPath("lolcat.csv");
  List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
}
```

Once you have a `Path` you can use it as you would a normal file. For example
you can use `InputStream` and `OutputStream` for streaming:

```java
try (InputStream input = Files.openInputStream(path)) {
  // ...
}
```

You can also set various attributes using CloudStorageOptions static helpers:

```java
Files.write(csvPath, csvLines, StandardCharsets.UTF_8,
    withMimeType(MediaType.CSV_UTF8),
    withoutCaching());
```

#### Limitations

This library is usable, but not yet complete. The following features are not
yet implemented:
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
always be assumed to exist, without performing any I/O. Paths without the trailing
slash will result in an I/O operation to check a file is present in that "directory".
This allows you to do path manipulation in the same manner as you would with the normal UNIX file
system implementation. Using this feature with buckets or "directory" paths that do not exist
is not recommended, as at the time I/O is performed the failure may not be handled gracefully.
You can disable this feature with `CloudStorageConfiguration.usePseudoDirectories()`.

#### Complete source code

There are examples in [google-cloud-nio-examples](google-cloud-nio-examples/src/main/java/com/google/cloud/examples/nio/)
for your perusal.





## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Supported Java Versions

Java 7 or above is required for using this client.

Google's Java client libraries,
[Google Cloud Client Libraries][cloudlibs]
and
[Google Cloud API Libraries][apilibs],
follow the
[Oracle Java SE support roadmap][oracle]
(see the Oracle Java SE Product Releases section).

### For new development

In general, new feature development occurs with support for the lowest Java
LTS version covered by  Oracle's Premier Support (which typically lasts 5 years
from initial General Availability). If the minimum required JVM for a given
library is changed, it is accompanied by a [semver][semver] major release.

Java 11 and (in September 2021) Java 17 are the best choices for new
development.

### Keeping production systems current

Google tests its client libraries with all current LTS versions covered by
Oracle's Extended Support (which typically lasts 8 years from initial
General Availability).

#### Legacy support

Google's client libraries support legacy versions of Java runtimes with long
term stable libraries that don't receive feature updates on a best efforts basis
as it may not be possible to backport all patches.

Google provides updates on a best efforts basis to apps that continue to use
Java 7, though apps might need to upgrade to current versions of the library
that supports their JVM.

#### Where to find specific information

The latest versions and the supported Java versions are identified on
the individual GitHub repository `github.com/GoogleAPIs/java-SERVICENAME`
and on [google-cloud-java][g-c-j].

## Versioning


This library follows [Semantic Versioning](http://semver.org/).


It is currently in major version zero (``0.y.z``), which means that anything may change at any time
and the public API should not be considered stable.


## Contributing


Contributions to this library are always welcome and highly encouraged.

See [CONTRIBUTING][contributing] for more information how to get started.

Please note that this project is released with a Contributor Code of Conduct. By participating in
this project you agree to abide by its terms. See [Code of Conduct][code-of-conduct] for more
information.


## License

Apache 2.0 - See [LICENSE][license] for more information.

Java is a registered trademark of Oracle and/or its affiliates.

[product-docs]: https://cloud.google.com/storage/docs
[javadocs]: https://googleapis.dev/java/google-cloud-nio/latest
[stability-image]: https://img.shields.io/badge/stability-beta-yellow
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-nio.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-nio&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[auth-scopes]: https://developers.google.com/identity/protocols/oauth2/scopes
[predefined-iam-roles]: https://cloud.google.com/iam/docs/understanding-roles#predefined_roles
[iam-policy]: https://cloud.google.com/iam/docs/overview#cloud-iam-policy
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/main/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-storage-nio/blob/main/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-storage-nio/blob/main/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-storage-nio/blob/main/LICENSE

[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=storage.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png

[semver]: https://semver.org/
[cloudlibs]: https://cloud.google.com/apis/docs/client-libraries-explained
[apilibs]: https://cloud.google.com/apis/docs/client-libraries-explained#google_api_client_libraries
[oracle]: https://www.oracle.com/java/technologies/java-se-support-roadmap.html
[g-c-j]: http://github.com/googleapis/google-cloud-java
