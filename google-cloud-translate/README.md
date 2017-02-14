Google Cloud Java Client for Translate
====================================

Java idiomatic client for [Google Translate](https://cloud.google.com/translate/).

[![Build Status](https://travis-ci.org/GoogleCloudPlatform/google-cloud-java.svg?branch=master)](https://travis-ci.org/GoogleCloudPlatform/google-cloud-java)
[![Coverage Status](https://coveralls.io/repos/GoogleCloudPlatform/google-cloud-java/badge.svg?branch=master)](https://coveralls.io/r/GoogleCloudPlatform/google-cloud-java?branch=master)
[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-translate.svg)]( https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-translate.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/google-cloud-java)
[![Dependency Status](https://www.versioneye.com/user/projects/56bd8ee72a29ed002d2b0969/badge.svg?style=flat)](https://www.versioneye.com/user/projects/56bd8ee72a29ed002d2b0969)

-  [Homepage](https://googlecloudplatform.github.io/google-cloud-java/)
-  [API Documentation](https://googlecloudplatform.github.io/google-cloud-java/apidocs/index.html?com/google/cloud/translate/package-summary.html)

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.

Quickstart
----------
If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-translate</artifactId>
  <version>0.9.2-alpha</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-translate:0.9.2-alpha'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-translate" % "0.9.2-alpha"
```

Example Application
-------------------

[`TranslateExample`](../google-cloud-examples/src/main/java/com/google/cloud/examples/translate/TranslateExample.java) is a simple command line interface that provides some of Google Translate's functionality.  Read more about using the application on the [`TranslateExample` docs page](https://googlecloudplatform.github.io/google-cloud-java/apidocs/?com/google/cloud/examples/translate/TranslateExample.html).

Authentication
--------------

Google Translate requires an API key to be passed with every request. For instructions on how to
get an API key follow the [Translate quickstart](https://cloud.google.com/translate/v2/quickstart).

About Google Translate
--------------------

[Google Translate][google-translate] provides a simple programmatic interface for translating an
arbitrary string into any supported language. Translate is highly responsive, so websites and
applications can integrate with Translate API for fast, dynamic translation of source text from the
source language to a target language (e.g., French to English). Language detection is also
available In cases where the source language is unknown.

See the [Translate quickstart](https://cloud.google.com/translate/v2/quickstart) for more details
on how to activate Google Translate for your project.

See the ``google-cloud`` API [Translate documentation][translate-api] to learn how to interact with
the Google Translate using this Client Library.

Getting Started
---------------
#### Prerequisites
For this tutorial, you need a [Google Developers Console](https://console.developers.google.com/)
project with "Translate API" enabled via the console's API Manager. You also need to enable
billing via the [Google Developers Console](https://console.developers.google.com/).

Finally, you must set up the local development environment by
[installing the Google Cloud SDK](https://cloud.google.com/sdk/) and running the following command
in command line: `gcloud auth application-default login`. Alternatively, you can authenticate
Translate requests using an API key. See
[Translate quickstart](https://cloud.google.com/translate/v2/quickstart) for more details.

#### Installation and setup
You'll need to obtain the `google-cloud-translate` library. See the [Quickstart](#quickstart)
section to add `google-cloud-translate` as a dependency in your code.

#### Creating an authorized service object
To make authenticated requests to Google Translate, you must create a service object with
credentials or with an API key. The simplest way to authenticate is to use
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
methods on the Translate service created via `TranslateOptions.getDefaultInstance().getService()`.

You can also explicitly set the API key as follows:
```java
Translate translate = TranslateOptions.newBuilder().setApiKey("myKey").getService();
```

#### Detecting language
With Google Translate you can detect the language of some text. The service will provide you with
the code of the detected language and a level of confidence.

Add the following import at the top of your file:

```java
import com.google.cloud.translate.Detection;
```

Then add the following code to detect the text's language:

```java
String detectedLanguage = detection.getLanguage();
```
#### Translating text

Google translate allows you to translate some text. When translating one or more texts you can
either provide the source language or let the service detect it for you.

Add the following imports at the top of your file:

```java
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.Translation;
```

Then add the following code to translate a text (specifying its source language):

```java
Translation translation = translate.translate(
    "World",
    TranslateOption.sourceLanguage("en"),
    TranslateOption.targetLanguage(detectedLanguage));
```

#### Complete source code

In
[DetectLanguageAndTranslate.java](../google-cloud-examples/src/main/java/com/google/cloud/examples/translate/snippets/DetectLanguageAndTranslate.java)
we put together all the code shown above into one program. The program assumes that either default
application credentials or a valid api key are available.

Troubleshooting
---------------

To get help, follow the instructions in the [shared Troubleshooting document](https://github.com/GoogleCloudPlatform/gcloud-common/blob/master/troubleshooting/readme.md#troubleshooting).

Java Versions
-------------

Java 7 or above is required for using this client.

Testing
-------

This library has tools to help make tests for code using Cloud Translate.

See [TESTING] to read more about testing.

Versioning
----------

This library follows [Semantic Versioning](http://semver.org/).

It is currently in major version zero (``0.y.z``), which means that anything
may change at any time and the public API should not be considered
stable.

Contributing
------------

Contributions to this library are always welcome and highly encouraged.

See `google-cloud`'s [CONTRIBUTING] documentation and the [shared documentation](https://github.com/GoogleCloudPlatform/gcloud-common/blob/master/contributing/readme.md#how-to-contribute-to-gcloud) for more information on how to get started.

Please note that this project is released with a Contributor Code of Conduct. By participating in this project you agree to abide by its terms. See [Code of Conduct][code-of-conduct] for more information.

License
-------

Apache 2.0 - See [LICENSE] for more information.

[CONTRIBUTING]:https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/CONTRIBUTING.md
[code-of-conduct]:https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[LICENSE]: https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/LICENSE
[TESTING]: https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/TESTING.md#testing-code-that-uses-translate
[cloud-platform]: https://cloud.google.com/

[google-translate]: https://cloud.google.com/translate/
[google-translate-docs]: https://cloud.google.com/translate/docs/
[translate-api]: https://googlecloudplatform.github.io/google-cloud-java/apidocs/index.html?com/google/cloud/translate/package-summary.html
