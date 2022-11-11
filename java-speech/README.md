# Google Cloud Speech Client for Java

Java idiomatic client for [Cloud Speech][product-docs].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][product-docs]
- [Client Library Documentation][javadocs]


## Quickstart


If you are using Maven, add this to your pom.xml file:


```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-speech</artifactId>
  <version>4.0.0</version>
</dependency>
```

If you are using Gradle without BOM, add this to your dependencies:

```Groovy
implementation 'com.google.cloud:google-cloud-speech:4.0.0'
```

If you are using SBT, add this to your dependencies:

```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-speech" % "4.0.0"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Authorization

The client application making API calls must be granted [authorization scopes][auth-scopes] required for the desired Cloud Speech APIs, and the authenticated principal must have the [IAM role(s)][predefined-iam-roles] required to access GCP resources using the Cloud Speech API calls.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Cloud Speech [API enabled][enable-api].

[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-speech` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-speech` as a dependency in your code.

## About Cloud Speech


[Cloud Speech][product-docs] enables easy integration of Google speech recognition technologies into developer applications. Send audio and receive a text transcription from the Speech-to-Text API service.

See the [Cloud Speech client library docs][javadocs] to learn how to
use this Cloud Speech Client Library.


### Recognizing speech
The following code sample shows how to recognize speech using an audio file from a Cloud Storage bucket as input.
First, add the following imports at the top of your file:

```java
import com.google.cloud.speech.v1.SpeechClient;
import com.google.cloud.speech.v1.RecognitionAudio;
import com.google.cloud.speech.v1.RecognitionConfig;
import com.google.cloud.speech.v1.RecognitionConfig.AudioEncoding;
import com.google.cloud.speech.v1.RecognizeResponse;
```
Then add the following code to do the speech recognization:
```java
 try (SpeechClient speechClient = SpeechClient.create()) {
   RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.FLAC;
   int sampleRateHertz = 44100;
   String languageCode = "en-US";
   RecognitionConfig config = RecognitionConfig.newBuilder()
     .setEncoding(encoding)
     .setSampleRateHertz(sampleRateHertz)
     .setLanguageCode(languageCode)
     .build();
   String uri = "gs://bucket_name/file_name.flac";
   RecognitionAudio audio = RecognitionAudio.newBuilder()
     .setUri(uri)
     .build();
   RecognizeResponse response = speechClient.recognize(config, audio);
 }
```

#### Complete source code

In [RecognizeSpeech.java](https://github.com/googleapis/google-cloud-java/blob/master/google-cloud-examples/src/main/java/com/google/cloud/examples/speech/snippets/RecognizeSpeech.java) we put a quick start example, which shows how you can use Google Speech API to automatically recognize speech based on a local file.

For an example audio file, you can use the [audio.raw](https://github.com/GoogleCloudPlatform/java-docs-samples/blob/master/speech/cloud-client/resources/audio.raw) file from the samples repository.
Note, to play the file on Unix-like system you may use the following command: `play -t raw -r 16k -e signed -b 16 -c 1 audio.raw`




## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Cloud Speech uses gRPC for the transport layer.

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

[product-docs]: https://cloud.google.com/speech-to-text/docs/
[javadocs]: https://cloud.google.com/java/docs/reference/google-cloud-speech/latest/overview
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-speech/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-speech/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-speech/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-speech/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-speech/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-speech/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-speech/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-speech/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-speech/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-speech/java11.html
[stability-image]: https://img.shields.io/badge/stability-stable-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-speech.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-speech&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[auth-scopes]: https://developers.google.com/identity/protocols/oauth2/scopes
[predefined-iam-roles]: https://cloud.google.com/iam/docs/understanding-roles#predefined_roles
[iam-policy]: https://cloud.google.com/iam/docs/overview#cloud-iam-policy
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/main/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-speech/blob/main/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-speech/blob/main/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-speech/blob/main/LICENSE

[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=speech.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png

[semver]: https://semver.org/
[cloudlibs]: https://cloud.google.com/apis/docs/client-libraries-explained
[apilibs]: https://cloud.google.com/apis/docs/client-libraries-explained#google_api_client_libraries
[oracle]: https://www.oracle.com/java/technologies/java-se-support-roadmap.html
[g-c-j]: http://github.com/googleapis/google-cloud-java
