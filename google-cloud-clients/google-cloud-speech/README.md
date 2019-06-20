Google Cloud Java Client for Speech
======================================

Java idiomatic client for [Google Cloud Speech][cloud-speech].

[![Kokoro CI](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.svg)](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.html)
[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-speech.svg)](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-speech.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/google-cloud-java)

- [Product Documentation][speech-product-docs]
- [Client Library Documentation][speech-client-lib-docs]

Quickstart
----------

[//]: # ({x-version-update-start:google-cloud-speech:released})
If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-speech</artifactId>
  <version>1.9.0</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-speech:1.9.0'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-speech" % "1.9.0"
```
[//]: # ({x-version-update-end})

Authentication
--------------

See the [Authentication](https://github.com/googleapis/google-cloud-java#authentication) section in the base directory's README.

About Google Cloud Speech
----------------------------

Google [Cloud Speech API][cloud-speech] enables easy integration of Google speech recognition technologies into developer applications. Send audio and receive a text transcription from the Cloud Speech API service.

See the [Speech client library docs][speech-client-lib-docs] to learn how to use this Cloud Speech API Client Library.

Getting Started
---------------
#### Prerequisites
You will need a [Google Developers Console](https://console.developers.google.com/) project with the Speech API enabled. [Follow these instructions](https://cloud.google.com/resource-manager/docs/creating-managing-projects) to get your project set up. You will also need to set up the local development environment by [installing the Google Cloud SDK](https://cloud.google.com/sdk/) and running the following commands in command line: `gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

#### Installation and setup
You'll need to obtain the `google-cloud-speech` library.  See the [Quickstart](#quickstart) section to add `google-cloud-speech` as a dependency in your code.

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

In [RecognizeSpeech.java](../../google-cloud-examples/src/main/java/com/google/cloud/examples/speech/snippets/RecognizeSpeech.java) we put a quick start example, which shows how you can use Google Speech API to automatically recognize speech based on a local file.

For an example audio file, you can use the [audio.raw](https://github.com/GoogleCloudPlatform/java-docs-samples/blob/master/speech/cloud-client/resources/audio.raw) file from the samples repository.
Note, to play the file on Unix-like system you may use the following command: `play -t raw -r 16k -e signed -b 16 -c 1 audio.raw`

Troubleshooting
---------------

To get help, follow the instructions in the [shared Troubleshooting document](https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting).

Transport
---------
Speech uses gRPC for the transport layer.

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
[cloud-speech]: https://cloud.google.com/speech/
[speech-product-docs]: https://cloud.google.com/speech/docs
[speech-client-lib-docs]: https://googleapis.github.io/google-cloud-java/google-cloud-clients/apidocs/index.html?com/google/cloud/speech/v1/package-summary.html
