Google Cloud Java Client for Translation
====================================

Java idiomatic client for [Google Translation][cloud-translate].


[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][translate-product-docs]
- [Client Library Documentation][translate-client-lib-docs]

Quickstart
----------
If you are using Maven with a BOM, add this to your pom.xml file.
```xml
<dependencyManagement>
 <dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>libraries-bom</artifactId>
    <version>2.8.0</version>
    <type>pom</type>
    <scope>import</scope>
   </dependency>
 </dependencies>
</dependencyManagement>

<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-translate</artifactId>
</dependency>
```

[//]: # ({x-version-update-start:google-cloud-translate:released})
If you are using Maven without a BOM, add this to your dependencies.
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-translate</artifactId>
  <version>1.94.3</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-translate:1.94.3'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-translate" % "1.94.3"
```
[//]: # ({x-version-update-end})

Example Application
-------------------

[`TranslateExample`](https://github.com/googleapis/google-cloud-java/blob/master/google-cloud-examples/src/main/java/com/google/cloud/examples/translate/TranslateExample.java)
is a simple command line interface that provides some of Google Translation's functionality.

Authentication
--------------

For instructions on how to set up authentication and make authenticated calls,
follow
the [Translation quickstart](https://cloud.google.com/translate/v2/quickstart).

About Google Translation
--------------------

[Google Translation][cloud-translate] provides a simple programmatic interface for translating an
arbitrary string into any supported language. Translation is highly responsive, so websites and
applications can integrate with Translation API for fast, dynamic translation of source text from the
source language to a target language (e.g., French to English). Language detection is also
available in cases where the source language is unknown.

See the [Translation quickstart][cloud-translate-quickstart] for more details
on how to activate Google Translation for your project.

See the [Translation client library docs][translate-client-lib-docs] to learn how to interact with
the Google Translation using this Client Library.

Getting Started
---------------
#### Prerequisites
For this tutorial, you need a [Google Developers Console](https://console.developers.google.com/)
project with "Translation API" enabled via the console's API Manager. You also need to enable
billing via the [Google Developers Console](https://console.developers.google.com/).

Finally, you must set up the local development environment by
[installing the Google Cloud SDK](https://cloud.google.com/sdk/) and running the following command
in command line: `gcloud auth application-default login`. Alternatively, you can authenticate
Translation requests using an API key. See
[Translation quickstart](https://cloud.google.com/translate/v2/quickstart) for more details.

#### Installation and setup
You'll need to obtain the `google-cloud-translate` library. See the [Quickstart](#quickstart)
section to add `google-cloud-translate` as a dependency in your code.

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
[DetectLanguageAndTranslate.java](../../google-cloud-examples/src/main/java/com/google/cloud/examples/translate/snippets/DetectLanguageAndTranslate.java)
we put together all the code shown above into one program. The program assumes that either Application
Default Credentials or a valid API key are available.

Troubleshooting
---------------

To get help, follow the instructions in the [shared Troubleshooting document](https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting).

Transport
---------
Translate uses HTTP for the transport layer.
Translate v3beta1 uses gRPC for the transport layer.

Java Versions
-------------

Java 7 or above is required for using this client.

Testing
-------

This library has tools to help make tests for code using Cloud Translation.

See [TESTING] to read more about testing.

Versioning
----------

This library follows [Semantic Versioning](http://semver.org/).

It is currently in major version one (``1.y.z``), which means that the public API should be considered stable.

Contributing
------------

Contributions to this library are always welcome and highly encouraged.

See `google-cloud`'s [CONTRIBUTING] documentation and the [shared documentation](https://github.com/googleapis/google-cloud-common/blob/master/contributing/readme.md#how-to-contribute-to-gcloud) for more information on how to get started.

Please note that this project is released with a Contributor Code of Conduct. By participating in this project you agree to abide by its terms. See [Code of Conduct][code-of-conduct] for more information.

License
-------

Apache 2.0 - See [LICENSE] for more information.

## CI Status

Java Version | Status
------------ | ------
Java 7 | [![Kokoro CI][kokoro-badge-image-1]][kokoro-badge-link-1]
Java 8 | [![Kokoro CI][kokoro-badge-image-2]][kokoro-badge-link-2]
Java 8 OSX | [![Kokoro CI][kokoro-badge-image-3]][kokoro-badge-link-3]
Java 8 Windows | [![Kokoro CI][kokoro-badge-image-4]][kokoro-badge-link-4]
Java 11 | [![Kokoro CI][kokoro-badge-image-5]][kokoro-badge-link-5]


[CONTRIBUTING]:https://github.com/googleapis/google-cloud-java/blob/master/CONTRIBUTING.md
[code-of-conduct]:https://github.com/googleapis/google-cloud-java/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[LICENSE]: https://github.com/googleapis/google-cloud-java/blob/master/LICENSE
[TESTING]: https://github.com/googleapis/google-cloud-java/blob/master/TESTING.md#testing-code-that-uses-translate
[cloud-platform]: https://cloud.google.com/
[cloud-translate]: https://cloud.google.com/translate/
[cloud-translate-quickstart]: https://cloud.google.com/translate/v2/quickstart
[translate-product-docs]: https://cloud.google.com/translate/docs/
[translate-client-lib-docs]: https://googleapis.dev/java/google-cloud-clients/latest/index.html?com/google/cloud/translate/package-summary.html
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-translate.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-translate&core=gav
[stability-image]: https://img.shields.io/badge/stability-GA-green
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