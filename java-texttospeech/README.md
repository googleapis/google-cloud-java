# Google Cloud Text-to-Speech Client for Java

Java idiomatic client for [Cloud Text-to-Speech][product-docs].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][product-docs]
- [Client Library Documentation][javadocs]

## Quickstart

If you are using Maven with [BOM][libraries-bom], add this to your pom.xml file
```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>libraries-bom</artifactId>
      <version>17.0.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-texttospeech</artifactId>
  </dependency>
</dependencies>

```

If you are using Maven without BOM, add this to your dependencies:

```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-texttospeech</artifactId>
  <version>1.2.9</version>
</dependency>

```

If you are using Gradle 5.x or later, add this to your dependencies
```Groovy
implementation platform('com.google.cloud:libraries-bom:17.0.0')

compile 'com.google.cloud:google-cloud-texttospeech'
```
If you are using Gradle without BOM, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-texttospeech:1.2.9'
```

If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-texttospeech" % "1.2.9"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Cloud Text-to-Speech [API enabled][enable-api].

[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-texttospeech` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-texttospeech` as a dependency in your code.

## About Cloud Text-to-Speech


[Cloud Text-to-Speech][product-docs] enables easy integration of Google text recognition technologies into developer applications. Send text and receive synthesized audio output from the Cloud Text-to-Speech API service.

See the [Cloud Text-to-Speech client library docs][javadocs] to learn how to
use this Cloud Text-to-Speech Client Library.





## Samples

Samples are in the [`samples/`](https://github.com/googleapis/java-texttospeech/tree/master/samples) directory. The samples' `README.md`
has instructions for running the samples.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| List All Supported Voices | [source code](https://github.com/googleapis/java-texttospeech/blob/master/samples/snippets/src/main/java/com/example/texttospeech/ListAllSupportedVoices.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-texttospeech&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/texttospeech/ListAllSupportedVoices.java) |
| List All Supported Voices Beta | [source code](https://github.com/googleapis/java-texttospeech/blob/master/samples/snippets/src/main/java/com/example/texttospeech/ListAllSupportedVoicesBeta.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-texttospeech&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/texttospeech/ListAllSupportedVoicesBeta.java) |
| Quickstart Sample | [source code](https://github.com/googleapis/java-texttospeech/blob/master/samples/snippets/src/main/java/com/example/texttospeech/QuickstartSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-texttospeech&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/texttospeech/QuickstartSample.java) |
| Quickstart Sample Beta | [source code](https://github.com/googleapis/java-texttospeech/blob/master/samples/snippets/src/main/java/com/example/texttospeech/QuickstartSampleBeta.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-texttospeech&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/texttospeech/QuickstartSampleBeta.java) |
| Ssml Addresses | [source code](https://github.com/googleapis/java-texttospeech/blob/master/samples/snippets/src/main/java/com/example/texttospeech/SsmlAddresses.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-texttospeech&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/texttospeech/SsmlAddresses.java) |
| Synthesize File | [source code](https://github.com/googleapis/java-texttospeech/blob/master/samples/snippets/src/main/java/com/example/texttospeech/SynthesizeFile.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-texttospeech&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/texttospeech/SynthesizeFile.java) |
| Synthesize File Beta | [source code](https://github.com/googleapis/java-texttospeech/blob/master/samples/snippets/src/main/java/com/example/texttospeech/SynthesizeFileBeta.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-texttospeech&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/texttospeech/SynthesizeFileBeta.java) |
| Synthesize Text | [source code](https://github.com/googleapis/java-texttospeech/blob/master/samples/snippets/src/main/java/com/example/texttospeech/SynthesizeText.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-texttospeech&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/texttospeech/SynthesizeText.java) |
| Synthesize Text Beta | [source code](https://github.com/googleapis/java-texttospeech/blob/master/samples/snippets/src/main/java/com/example/texttospeech/SynthesizeTextBeta.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-texttospeech&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/texttospeech/SynthesizeTextBeta.java) |



## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Cloud Text-to-Speech uses gRPC for the transport layer.

## Java Versions

Java 7 or above is required for using this client.

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
Java 7 | [![Kokoro CI][kokoro-badge-image-1]][kokoro-badge-link-1]
Java 8 | [![Kokoro CI][kokoro-badge-image-2]][kokoro-badge-link-2]
Java 8 OSX | [![Kokoro CI][kokoro-badge-image-3]][kokoro-badge-link-3]
Java 8 Windows | [![Kokoro CI][kokoro-badge-image-4]][kokoro-badge-link-4]
Java 11 | [![Kokoro CI][kokoro-badge-image-5]][kokoro-badge-link-5]

Java is a registered trademark of Oracle and/or its affiliates.

[product-docs]: https://cloud.google.com/text-to-speech
[javadocs]: https://googleapis.dev/java/google-cloud-texttospeech/latest/
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-texttospeech/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-texttospeech/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-texttospeech/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-texttospeech/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-texttospeech/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-texttospeech/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-texttospeech/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-texttospeech/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-texttospeech/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-texttospeech/java11.html
[stability-image]: https://img.shields.io/badge/stability-ga-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-texttospeech.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-texttospeech&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-texttospeech/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-texttospeech/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-texttospeech/blob/master/LICENSE

[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=texttospeech.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png
