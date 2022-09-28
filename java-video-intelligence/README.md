# Google Cloud Video Intelligence Client for Java

Java idiomatic client for [Cloud Video Intelligence][product-docs].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][product-docs]
- [Client Library Documentation][javadocs]


## Quickstart

If you are using Maven with [BOM][libraries-bom], add this to your pom.xml file:

```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>libraries-bom</artifactId>
      <version>26.1.2</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-video-intelligence</artifactId>
  </dependency>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-storage</artifactId>
  </dependency>

```

If you are using Maven without BOM, add this to your dependencies:


```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-video-intelligence</artifactId>
  <version>2.2.6</version>
</dependency>
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-storage</artifactId>
  <version>2.12.0</version>
</dependency>

```

If you are using Gradle 5.x or later, add this to your dependencies:

```Groovy
implementation platform('com.google.cloud:libraries-bom:26.1.2')

implementation 'com.google.cloud:google-cloud-video-intelligence'
```
If you are using Gradle without BOM, add this to your dependencies:

```Groovy
implementation 'com.google.cloud:google-cloud-video-intelligence:2.2.9'
```

If you are using SBT, add this to your dependencies:

```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-video-intelligence" % "2.2.9"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Authorization

The client application making API calls must be granted [authorization scopes][auth-scopes] required for the desired Cloud Video Intelligence APIs, and the authenticated principal must have the [IAM role(s)][predefined-iam-roles] required to access GCP resources using the Cloud Video Intelligence API calls.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Cloud Video Intelligence [API enabled][enable-api].
You will need to [enable billing][enable-billing] to use Google Cloud Video Intelligence.
[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-video-intelligence` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-video-intelligence` as a dependency in your code.

## About Cloud Video Intelligence


[Cloud Video Intelligence][product-docs] allows developers to use Google video analysis technology as part of their applications.

See the [Cloud Video Intelligence client library docs][javadocs] to learn how to
use this Cloud Video Intelligence Client Library.





## Samples

Samples are in the [`samples/`](https://github.com/googleapis/java-video-intelligence/tree/main/samples) directory.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| Detect | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/beta/video/Detect.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/beta/video/Detect.java) |
| Detect Logo | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/beta/video/DetectLogo.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/beta/video/DetectLogo.java) |
| Detect Logo Gcs | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/beta/video/DetectLogoGcs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/beta/video/DetectLogoGcs.java) |
| Streaming Annotation To Storage | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/beta/video/StreamingAnnotationToStorage.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/beta/video/StreamingAnnotationToStorage.java) |
| Streaming Auto Ml Action Recognition | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/beta/video/StreamingAutoMlActionRecognition.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/beta/video/StreamingAutoMlActionRecognition.java) |
| Streaming Auto Ml Classification | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/beta/video/StreamingAutoMlClassification.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/beta/video/StreamingAutoMlClassification.java) |
| Streaming Auto Ml Object Tracking | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/beta/video/StreamingAutoMlObjectTracking.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/beta/video/StreamingAutoMlObjectTracking.java) |
| Streaming Explicit Content Detection | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/beta/video/StreamingExplicitContentDetection.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/beta/video/StreamingExplicitContentDetection.java) |
| Streaming Label Detection | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/beta/video/StreamingLabelDetection.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/beta/video/StreamingLabelDetection.java) |
| Streaming Object Tracking | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/beta/video/StreamingObjectTracking.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/beta/video/StreamingObjectTracking.java) |
| Streaming Shot Change Detection | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/beta/video/StreamingShotChangeDetection.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/beta/video/StreamingShotChangeDetection.java) |
| Text Detection | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/beta/video/TextDetection.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/beta/video/TextDetection.java) |
| Track Objects | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/beta/video/TrackObjects.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/beta/video/TrackObjects.java) |
| Detect | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/com/example/video/Detect.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/video/Detect.java) |
| Logo Detection | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/com/example/video/LogoDetection.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/video/LogoDetection.java) |
| Logo Detection Gcs | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/com/example/video/LogoDetectionGcs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/video/LogoDetectionGcs.java) |
| Quickstart Sample | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/com/example/video/QuickstartSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/video/QuickstartSample.java) |
| Text Detection | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/com/example/video/TextDetection.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/video/TextDetection.java) |
| Track Objects | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/com/example/video/TrackObjects.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/video/TrackObjects.java) |
| Detect | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/video/Detect.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/video/Detect.java) |
| Detect Faces | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/video/DetectFaces.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/video/DetectFaces.java) |
| Detect Faces Gcs | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/video/DetectFacesGcs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/video/DetectFacesGcs.java) |
| Detect Person | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/video/DetectPerson.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/video/DetectPerson.java) |
| Detect Person Gcs | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/video/DetectPersonGcs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/video/DetectPersonGcs.java) |
| Logo Detection | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/video/LogoDetection.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/video/LogoDetection.java) |
| Logo Detection Gcs | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/video/LogoDetectionGcs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/video/LogoDetectionGcs.java) |
| Quickstart Sample | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/video/QuickstartSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/video/QuickstartSample.java) |
| Text Detection | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/video/TextDetection.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/video/TextDetection.java) |
| Track Objects | [source code](https://github.com/googleapis/java-video-intelligence/blob/main/samples/snippets/src/main/java/video/TrackObjects.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-video-intelligence&page=editor&open_in_editor=samples/snippets/src/main/java/video/TrackObjects.java) |



## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Cloud Video Intelligence uses gRPC for the transport layer.

## Supported Java Versions

Java 8 or above is required for using this client.

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



## Contributing


Contributions to this library are always welcome and highly encouraged.

See [CONTRIBUTING][contributing] for more information how to get started.

Please note that this project is released with a Contributor Code of Conduct. By participating in
this project you agree to abide by its terms. See [Code of Conduct][code-of-conduct] for more
information.


## License

Apache 2.0 - See [LICENSE][license] for more information.

## CI Status

Java Version | Status
------------ | ------
Java 8 | [![Kokoro CI][kokoro-badge-image-2]][kokoro-badge-link-2]
Java 8 OSX | [![Kokoro CI][kokoro-badge-image-3]][kokoro-badge-link-3]
Java 8 Windows | [![Kokoro CI][kokoro-badge-image-4]][kokoro-badge-link-4]
Java 11 | [![Kokoro CI][kokoro-badge-image-5]][kokoro-badge-link-5]

Java is a registered trademark of Oracle and/or its affiliates.

[product-docs]: https://cloud.google.com/video-intelligence/docs/
[javadocs]: https://cloud.google.com/java/docs/reference/google-cloud-video-intelligence/latest/history
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-video-intelligence/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-video-intelligence/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-video-intelligence/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-video-intelligence/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-video-intelligence/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-video-intelligence/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-video-intelligence/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-video-intelligence/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-video-intelligence/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-video-intelligence/java11.html
[stability-image]: https://img.shields.io/badge/stability-stable-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-video-intelligence.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-video-intelligence&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[auth-scopes]: https://developers.google.com/identity/protocols/oauth2/scopes
[predefined-iam-roles]: https://cloud.google.com/iam/docs/understanding-roles#predefined_roles
[iam-policy]: https://cloud.google.com/iam/docs/overview#cloud-iam-policy
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/main/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-video-intelligence/blob/main/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-video-intelligence/blob/main/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-video-intelligence/blob/main/LICENSE
[enable-billing]: https://cloud.google.com/apis/docs/getting-started#enabling_billing
[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=videointelligence.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png

[semver]: https://semver.org/
[cloudlibs]: https://cloud.google.com/apis/docs/client-libraries-explained
[apilibs]: https://cloud.google.com/apis/docs/client-libraries-explained#google_api_client_libraries
[oracle]: https://www.oracle.com/java/technologies/java-se-support-roadmap.html
[g-c-j]: http://github.com/googleapis/google-cloud-java
