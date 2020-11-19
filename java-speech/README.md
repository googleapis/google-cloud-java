# Google Cloud Speech Client for Java

Java idiomatic client for [Cloud Speech][product-docs].

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
      <version>16.1.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-speech</artifactId>
  </dependency>
</dependencies>

```

If you are using Maven without BOM, add this to your dependencies:

```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-speech</artifactId>
  <version>1.24.6</version>
</dependency>

```

If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-speech:1.24.7'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-speech" % "1.24.7"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

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



## Samples

Samples are in the [`samples/`](https://github.com/googleapis/java-speech/tree/master/samples) directory. The samples' `README.md`
has instructions for running the samples.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| Transcribe Audio File using Long Running Operation (Local File) (LRO) | [source code](https://github.com/googleapis/java-speech/blob/master/samples/generated/src/main/java/com/google/cloud/examples/speech/v1/SpeechTranscribeAsync.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/speech/v1/SpeechTranscribeAsync.java) |
| Transcript Audio File using Long Running Operation (Cloud Storage) (LRO) | [source code](https://github.com/googleapis/java-speech/blob/master/samples/generated/src/main/java/com/google/cloud/examples/speech/v1/SpeechTranscribeAsyncGcs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/speech/v1/SpeechTranscribeAsyncGcs.java) |
| Getting word timestamps (Cloud Storage) (LRO) | [source code](https://github.com/googleapis/java-speech/blob/master/samples/generated/src/main/java/com/google/cloud/examples/speech/v1/SpeechTranscribeAsyncWordTimeOffsetsGcs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/speech/v1/SpeechTranscribeAsyncWordTimeOffsetsGcs.java) |
| Using Enhanced Models (Local File) | [source code](https://github.com/googleapis/java-speech/blob/master/samples/generated/src/main/java/com/google/cloud/examples/speech/v1/SpeechTranscribeEnhancedModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/speech/v1/SpeechTranscribeEnhancedModel.java) |
| Selecting a Transcription Model (Local File) | [source code](https://github.com/googleapis/java-speech/blob/master/samples/generated/src/main/java/com/google/cloud/examples/speech/v1/SpeechTranscribeModelSelection.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/speech/v1/SpeechTranscribeModelSelection.java) |
| Selecting a Transcription Model (Cloud Storage) | [source code](https://github.com/googleapis/java-speech/blob/master/samples/generated/src/main/java/com/google/cloud/examples/speech/v1/SpeechTranscribeModelSelectionGcs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/speech/v1/SpeechTranscribeModelSelectionGcs.java) |
| Multi-Channel Audio Transcription (Local File) | [source code](https://github.com/googleapis/java-speech/blob/master/samples/generated/src/main/java/com/google/cloud/examples/speech/v1/SpeechTranscribeMultichannel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/speech/v1/SpeechTranscribeMultichannel.java) |
| Multi-Channel Audio Transcription (Cloud Storage) | [source code](https://github.com/googleapis/java-speech/blob/master/samples/generated/src/main/java/com/google/cloud/examples/speech/v1/SpeechTranscribeMultichannelGcs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/speech/v1/SpeechTranscribeMultichannelGcs.java) |
| Transcribe Audio File (Local File) | [source code](https://github.com/googleapis/java-speech/blob/master/samples/generated/src/main/java/com/google/cloud/examples/speech/v1/SpeechTranscribeSync.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/speech/v1/SpeechTranscribeSync.java) |
| Transcript Audio File (Cloud Storage) | [source code](https://github.com/googleapis/java-speech/blob/master/samples/generated/src/main/java/com/google/cloud/examples/speech/v1/SpeechTranscribeSyncGcs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/speech/v1/SpeechTranscribeSyncGcs.java) |
| Speech Adaptation (Cloud Storage) | [source code](https://github.com/googleapis/java-speech/blob/master/samples/generated/src/main/java/com/google/cloud/examples/speech/v1p1beta1/SpeechAdaptationBeta.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/speech/v1p1beta1/SpeechAdaptationBeta.java) |
| Using Context Classes (Cloud Storage) | [source code](https://github.com/googleapis/java-speech/blob/master/samples/generated/src/main/java/com/google/cloud/examples/speech/v1p1beta1/SpeechContextsClassesBeta.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/speech/v1p1beta1/SpeechContextsClassesBeta.java) |
| Quickstart Beta | [source code](https://github.com/googleapis/java-speech/blob/master/samples/generated/src/main/java/com/google/cloud/examples/speech/v1p1beta1/SpeechQuickstartBeta.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/speech/v1p1beta1/SpeechQuickstartBeta.java) |
| Getting punctuation in results (Local File) (Beta) | [source code](https://github.com/googleapis/java-speech/blob/master/samples/generated/src/main/java/com/google/cloud/examples/speech/v1p1beta1/SpeechTranscribeAutoPunctuationBeta.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/speech/v1p1beta1/SpeechTranscribeAutoPunctuationBeta.java) |
| Separating different speakers (Local File) (LRO) (Beta) | [source code](https://github.com/googleapis/java-speech/blob/master/samples/generated/src/main/java/com/google/cloud/examples/speech/v1p1beta1/SpeechTranscribeDiarizationBeta.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/speech/v1p1beta1/SpeechTranscribeDiarizationBeta.java) |
| Detecting language spoken automatically (Local File) (Beta) | [source code](https://github.com/googleapis/java-speech/blob/master/samples/generated/src/main/java/com/google/cloud/examples/speech/v1p1beta1/SpeechTranscribeMultilanguageBeta.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/speech/v1p1beta1/SpeechTranscribeMultilanguageBeta.java) |
| Adding recognition metadata (Local File) (Beta) | [source code](https://github.com/googleapis/java-speech/blob/master/samples/generated/src/main/java/com/google/cloud/examples/speech/v1p1beta1/SpeechTranscribeRecognitionMetadataBeta.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/speech/v1p1beta1/SpeechTranscribeRecognitionMetadataBeta.java) |
| Enabling word-level confidence (Local File) (Beta) | [source code](https://github.com/googleapis/java-speech/blob/master/samples/generated/src/main/java/com/google/cloud/examples/speech/v1p1beta1/SpeechTranscribeWordLevelConfidenceBeta.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/speech/v1p1beta1/SpeechTranscribeWordLevelConfidenceBeta.java) |
| Infinite Stream Recognize | [source code](https://github.com/googleapis/java-speech/blob/master/samples/snippets/src/main/java/com/example/speech/InfiniteStreamRecognize.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/speech/InfiniteStreamRecognize.java) |
| Infinite Stream Recognize Options | [source code](https://github.com/googleapis/java-speech/blob/master/samples/snippets/src/main/java/com/example/speech/InfiniteStreamRecognizeOptions.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/speech/InfiniteStreamRecognizeOptions.java) |
| Quickstart Sample | [source code](https://github.com/googleapis/java-speech/blob/master/samples/snippets/src/main/java/com/example/speech/QuickstartSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/speech/QuickstartSample.java) |
| Recognize | [source code](https://github.com/googleapis/java-speech/blob/master/samples/snippets/src/main/java/com/example/speech/Recognize.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/speech/Recognize.java) |
| Recognize Beta | [source code](https://github.com/googleapis/java-speech/blob/master/samples/snippets/src/main/java/com/example/speech/RecognizeBeta.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/speech/RecognizeBeta.java) |
| Speech Adaptation | [source code](https://github.com/googleapis/java-speech/blob/master/samples/snippets/src/main/java/com/example/speech/SpeechAdaptation.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/speech/SpeechAdaptation.java) |
| Transcribe Context Classes | [source code](https://github.com/googleapis/java-speech/blob/master/samples/snippets/src/main/java/com/example/speech/TranscribeContextClasses.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/speech/TranscribeContextClasses.java) |
| Transcribe Diarization | [source code](https://github.com/googleapis/java-speech/blob/master/samples/snippets/src/main/java/com/example/speech/TranscribeDiarization.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/speech/TranscribeDiarization.java) |
| Transcribe Diarization Gcs | [source code](https://github.com/googleapis/java-speech/blob/master/samples/snippets/src/main/java/com/example/speech/TranscribeDiarizationGcs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-speech&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/speech/TranscribeDiarizationGcs.java) |



## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Cloud Speech uses gRPC for the transport layer.

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

[product-docs]: https://cloud.google.com/speech-to-text/docs/
[javadocs]: https://googleapis.dev/java/google-cloud-speech/latest/
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
[stability-image]: https://img.shields.io/badge/stability-ga-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-speech.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-speech&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-speech/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-speech/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-speech/blob/master/LICENSE

[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=speech.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png
