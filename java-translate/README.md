# Google Cloud Translation Client for Java

Java idiomatic client for [Cloud Translation][product-docs].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][product-docs]
- [Client Library Documentation][javadocs]


## Quickstart


If you are using Maven, add this to your pom.xml file:


```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-translate</artifactId>
  <version>2.6.0</version>
</dependency>
```

If you are using Gradle without BOM, add this to your dependencies:

```Groovy
implementation 'com.google.cloud:google-cloud-translate:2.6.0'
```

If you are using SBT, add this to your dependencies:

```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-translate" % "2.6.0"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Authorization

The client application making API calls must be granted [authorization scopes][auth-scopes] required for the desired Cloud Translation APIs, and the authenticated principal must have the [IAM role(s)][predefined-iam-roles] required to access GCP resources using the Cloud Translation API calls.

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




## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Cloud Translation uses both gRPC and HTTP/JSON for the transport layer.

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

[product-docs]: https://cloud.google.com/translate/docs/
[javadocs]: https://cloud.google.com/java/docs/reference/google-cloud-translate/latest/overview
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/java11.html
[stability-image]: https://img.shields.io/badge/stability-stable-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-translate.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-translate&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[auth-scopes]: https://developers.google.com/identity/protocols/oauth2/scopes
[predefined-iam-roles]: https://cloud.google.com/iam/docs/understanding-roles#predefined_roles
[iam-policy]: https://cloud.google.com/iam/docs/overview#cloud-iam-policy
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/main/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/google-cloud-java/blob/main/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/google-cloud-java/blob/main/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/google-cloud-java/blob/main/LICENSE
[enable-billing]: https://cloud.google.com/apis/docs/getting-started#enabling_billing
[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=translation.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png

[semver]: https://semver.org/
[cloudlibs]: https://cloud.google.com/apis/docs/client-libraries-explained
[apilibs]: https://cloud.google.com/apis/docs/client-libraries-explained#google_api_client_libraries
[oracle]: https://www.oracle.com/java/technologies/java-se-support-roadmap.html
[g-c-j]: http://github.com/googleapis/google-cloud-java
