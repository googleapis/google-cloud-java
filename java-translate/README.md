# Google Cloud Translation Client for Java

Java idiomatic client for [Cloud Translation][product-docs].

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
      <version>16.4.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-translate</artifactId>
  </dependency>
</dependencies>

```

If you are using Maven without BOM, add this to your dependencies:

```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-translate</artifactId>
  <version>1.95.7</version>
</dependency>

```

If you are using Gradle 5.x or later, add this to your dependencies
```Groovy
implementation platform('com.google.cloud:libraries-bom:16.4.0')

compile 'com.google.cloud:google-cloud-translate'
```
If you are using Gradle without BOM, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-translate:1.95.8'
```

If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-translate" % "1.95.8"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Cloud Translation [API enabled][enable-api].
You will need to [enable billing][enable-billing] to use Google Cloud Translation.
[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-translate` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-translate` as a dependency in your code.

## About Cloud Translation


[Cloud Translation][product-docs] can dynamically translate text between thousands of language pairs. Translation lets websites and programs programmatically integrate with the translation service.

See the [Cloud Translation client library docs][javadocs] to learn how to
use this Cloud Translation Client Library.


### Example Application

[`TranslateExample`](https://github.com/googleapis/google-cloud-java/blob/master/google-cloud-examples/src/main/java/com/google/cloud/examples/translate/TranslateExample.java)
is a simple command line interface that provides some of Google Translation's functionality.

#### Creating an authorized service object
To make authenticated requests to Google Translation, you must create a service object with
credentials or use an API key. The simplest way to authenticate is to use
[Application Default Credentials](https://developers.google.com/identity/protocols/application-default-credentials).
These credentials are automatically inferred from your environment, so you only need the following
code to create your service object:

```java
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;

Translate translate = TranslateOptions.getDefaultInstance().getService();
```

Notice that this code can be also used with an API key. By default, an API key is looked for in the
`GOOGLE_API_KEY` environment variable. Once the API key is set, you can make API calls by invoking
methods on the Translation service created via `TranslateOptions.getDefaultInstance().getService()`.

You can also explicitly set the API key as follows:
```java
Translate translate = TranslateOptions.newBuilder().setApiKey("myKey").build().getService();
```

#### Detecting language
With Google Translation you can detect the language of some text. The service will provide you with
the code of the detected language and a level of confidence.

Add the following import at the top of your file:

```java
import com.google.cloud.translate.Detection;
```

Then pick a text sample:

```java
final String mysteriousText = "Hola Mundo";
```

Then add the following code to detect the text's language:

```java
Detection detection = translate.detect(mysteriousText);
String detectedLanguage = detection.getLanguage();
```
#### Translating text

Google translation allows you to translate some text. When translating one or more texts you can
either provide the source language or let the service detect it for you.

Add the following imports at the top of your file:

```java
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.Translation;
```

Then add the following code to translate the text, specifying the previously detected language (`detectedLanguage`) as its source language and English as the target language (providing the source language is optional, if it is not specified the service will try to detect it automatically):

```java
Translation translation = translate.translate(
    mysteriousText,
    TranslateOption.sourceLanguage(detectedLanguage),
    TranslateOption.targetLanguage("en"));
```

#### Complete source code

In
[DetectLanguageAndTranslate.java](https://github.com/googleapis/google-cloud-java/tree/master/google-cloud-examples/src/main/java/com/google/cloud/examples/translate/snippets/DetectLanguageAndTranslate.java)
we put together all the code shown above into one program. The program assumes that either Application
Default Credentials or a valid API key are available.



## Samples

Samples are in the [`samples/`](https://github.com/googleapis/java-translate/tree/master/samples) directory. The samples' `README.md`
has instructions for running the samples.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| Batch Translate Text | [source code](https://github.com/googleapis/java-translate/blob/master/samples/snippets/src/main/java/com/example/translate/BatchTranslateText.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-translate&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/translate/BatchTranslateText.java) |
| Batch Translate Text With Glossary | [source code](https://github.com/googleapis/java-translate/blob/master/samples/snippets/src/main/java/com/example/translate/BatchTranslateTextWithGlossary.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-translate&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/translate/BatchTranslateTextWithGlossary.java) |
| Batch Translate Text With Glossary And Model | [source code](https://github.com/googleapis/java-translate/blob/master/samples/snippets/src/main/java/com/example/translate/BatchTranslateTextWithGlossaryAndModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-translate&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/translate/BatchTranslateTextWithGlossaryAndModel.java) |
| Batch Translate Text With Model | [source code](https://github.com/googleapis/java-translate/blob/master/samples/snippets/src/main/java/com/example/translate/BatchTranslateTextWithModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-translate&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/translate/BatchTranslateTextWithModel.java) |
| Create Glossary | [source code](https://github.com/googleapis/java-translate/blob/master/samples/snippets/src/main/java/com/example/translate/CreateGlossary.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-translate&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/translate/CreateGlossary.java) |
| Delete Glossary | [source code](https://github.com/googleapis/java-translate/blob/master/samples/snippets/src/main/java/com/example/translate/DeleteGlossary.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-translate&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/translate/DeleteGlossary.java) |
| Detect Language | [source code](https://github.com/googleapis/java-translate/blob/master/samples/snippets/src/main/java/com/example/translate/DetectLanguage.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-translate&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/translate/DetectLanguage.java) |
| Get Glossary | [source code](https://github.com/googleapis/java-translate/blob/master/samples/snippets/src/main/java/com/example/translate/GetGlossary.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-translate&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/translate/GetGlossary.java) |
| Get Supported Languages | [source code](https://github.com/googleapis/java-translate/blob/master/samples/snippets/src/main/java/com/example/translate/GetSupportedLanguages.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-translate&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/translate/GetSupportedLanguages.java) |
| Get Supported Languages For Target | [source code](https://github.com/googleapis/java-translate/blob/master/samples/snippets/src/main/java/com/example/translate/GetSupportedLanguagesForTarget.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-translate&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/translate/GetSupportedLanguagesForTarget.java) |
| List Glossaries | [source code](https://github.com/googleapis/java-translate/blob/master/samples/snippets/src/main/java/com/example/translate/ListGlossaries.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-translate&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/translate/ListGlossaries.java) |
| Quickstart Sample | [source code](https://github.com/googleapis/java-translate/blob/master/samples/snippets/src/main/java/com/example/translate/QuickstartSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-translate&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/translate/QuickstartSample.java) |
| Translate Text | [source code](https://github.com/googleapis/java-translate/blob/master/samples/snippets/src/main/java/com/example/translate/TranslateText.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-translate&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/translate/TranslateText.java) |
| Translate Text With Glossary | [source code](https://github.com/googleapis/java-translate/blob/master/samples/snippets/src/main/java/com/example/translate/TranslateTextWithGlossary.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-translate&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/translate/TranslateTextWithGlossary.java) |
| Translate Text With Glossary And Model | [source code](https://github.com/googleapis/java-translate/blob/master/samples/snippets/src/main/java/com/example/translate/TranslateTextWithGlossaryAndModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-translate&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/translate/TranslateTextWithGlossaryAndModel.java) |
| Translate Text With Model | [source code](https://github.com/googleapis/java-translate/blob/master/samples/snippets/src/main/java/com/example/translate/TranslateTextWithModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-translate&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/translate/TranslateTextWithModel.java) |



## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Cloud Translation uses both gRPC and HTTP/JSON for the transport layer.

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

[product-docs]: https://cloud.google.com/translate/docs/
[javadocs]: https://googleapis.dev/java/google-cloud-translate/latest/
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-translate/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-translate/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-translate/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-translate/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-translate/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-translate/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-translate/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-translate/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-translate/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-translate/java11.html
[stability-image]: https://img.shields.io/badge/stability-ga-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-translate.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-translate&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-translate/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-translate/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-translate/blob/master/LICENSE
[enable-billing]: https://cloud.google.com/apis/docs/getting-started#enabling_billing
[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=translation.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png
