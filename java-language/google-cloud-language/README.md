Google Cloud Java Client for Natural Language
======================================

Java idiomatic client for [Google Cloud Natural Language][cloud-language].

[![Kokoro CI](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.svg)](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.html)
[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-language.svg)](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-language.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/google-cloud-java)

- [Product Documentation][language-product-docs]
- [Client Library Documentation][language-client-lib-docs]

Quickstart
----------

[//]: # ({x-version-update-start:google-cloud-language:released})
If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-language</artifactId>
  <version>1.79.0</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-language:1.79.0'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-language" % "1.79.0"
```
[//]: # ({x-version-update-end})

Authentication
--------------

See the [Authentication](https://github.com/googleapis/google-cloud-java#authentication) section in the base directory's README.

About Google Cloud Natural Language
----------------------------

Google [Cloud Natural Language API][cloud-language] provides natural language understanding technologies to developers, including sentiment analysis, entity analysis, and syntax analysis. This API is part of the larger Cloud Machine Learning API family.

See the [Natural Language client library docs][language-client-lib-docs] to learn how to use this Cloud Natural Language API Client Library.

Getting Started
---------------
#### Prerequisites
You will need a [Google Developers Console](https://console.developers.google.com/) project with the Natural Language API enabled. [Follow these instructions](https://cloud.google.com/resource-manager/docs/creating-managing-projects) to get your project set up. You will also need to set up the local development environment by [installing the Google Cloud SDK](https://cloud.google.com/sdk/) and running the following commands in command line: `gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

#### Installation and setup
You'll need to obtain the `google-cloud-language` library.  See the [Quickstart](#quickstart) section to add `google-cloud-language` as a dependency in your code.

#### Analyzing sentiment
With Cloud Natural Language, you can analyze the sentiment of text. Add the following imports at the top of your file:

``` java
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.Document.Type;
import com.google.cloud.language.v1.Sentiment;
```
Then, to analyze the sentiment of some text, use the following code:

``` java
// Instantiates a client
LanguageServiceClient language = LanguageServiceClient.create();

// The text to analyze
String[] texts = {"I love this!", "I hate this!"};
for (String text : texts) {
  Document doc = Document.newBuilder().setContent(text).setType(Type.PLAIN_TEXT).build();
  // Detects the sentiment of the text
  Sentiment sentiment = language.analyzeSentiment(doc).getDocumentSentiment();

  System.out.printf("Text: \"%s\"%n", text);
  System.out.printf(
      "Sentiment: score = %s, magnitude = %s%n",
      sentiment.getScore(), sentiment.getMagnitude());
}
```

#### Complete source code

In [AnalyzeSentiment.java](../../google-cloud-examples/src/main/java/com/google/cloud/examples/language/snippets/AnalyzeSentiment.java) we put the code shown above into a complete program.

Troubleshooting
---------------

To get help, follow the instructions in the [shared Troubleshooting document](https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting).

Transport
---------
Language uses gRPC for the transport layer.

Java Versions
-------------

Java 7 or above is required for using this client.

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


[CONTRIBUTING]:https://github.com/googleapis/google-cloud-java/blob/master/CONTRIBUTING.md
[code-of-conduct]:https://github.com/googleapis/google-cloud-java/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[LICENSE]: https://github.com/googleapis/google-cloud-java/blob/master/LICENSE
[cloud-platform]: https://cloud.google.com/
[cloud-language]: https://cloud.google.com/natural-language/
[language-product-docs]: https://cloud.google.com/natural-language/docs/
[language-client-lib-docs]: https://googleapis.github.io/google-cloud-java/google-cloud-clients/apidocs/index.html?com/google/cloud/language/v1beta2/package-summary.html
