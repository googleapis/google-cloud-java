# Google Natural Language Client for Java

Java idiomatic client for [Natural Language][product-docs].

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
      <version>16.2.1</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-language</artifactId>
  </dependency>

```

If you are using Maven without BOM, add this to your dependencies:

```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-language</artifactId>
  <version>1.101.9</version>
</dependency>

```

If you are using Gradle 5.x or later, add this to your dependencies
```Groovy
implementation platform('com.google.cloud:libraries-bom:16.3.0')

compile 'com.google.cloud:google-cloud-language'
```
If you are using Gradle without BOM, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-language:1.101.9'
```

If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-language" % "1.101.9"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Natural Language [API enabled][enable-api].
You will need to [enable billing][enable-billing] to use Google Natural Language.
[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-language` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-language` as a dependency in your code.

## About Natural Language


[Natural Language][product-docs] provides natural language understanding technologies to developers, including sentiment analysis, entity analysis, entity sentiment analysis, content classification, and syntax analysis. This API is part of the larger Cloud Machine Learning API family.

See the [Natural Language client library docs][javadocs] to learn how to
use this Natural Language Client Library.


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

In [AnalyzeSentiment.java](https://github.com/googleapis/google-cloud-java/blob/master/google-cloud-examples/src/main/java/com/google/cloud/examples/language/snippets/AnalyzeSentiment.java) we put the code shown above into a complete program.



## Samples

Samples are in the [`samples/`](https://github.com/googleapis/java-language/tree/master/samples) directory. The samples' `README.md`
has instructions for running the samples.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| Analyze Beta | [source code](https://github.com/googleapis/java-language/blob/master/samples/snippets/src/main/java/beta/example/language/AnalyzeBeta.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-language&page=editor&open_in_editor=samples/snippets/src/main/java/beta/example/language/AnalyzeBeta.java) |
| Analyze | [source code](https://github.com/googleapis/java-language/blob/master/samples/snippets/src/main/java/com/example/language/Analyze.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-language&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/language/Analyze.java) |
| Quickstart Sample | [source code](https://github.com/googleapis/java-language/blob/master/samples/snippets/src/main/java/com/example/language/QuickstartSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-language&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/language/QuickstartSample.java) |
| Set Endpoint | [source code](https://github.com/googleapis/java-language/blob/master/samples/snippets/src/main/java/com/example/language/SetEndpoint.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-language&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/language/SetEndpoint.java) |



## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Natural Language uses gRPC for the transport layer.

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

[product-docs]: https://cloud.google.com/natural-language/docs/
[javadocs]: https://googleapis.dev/java/google-cloud-language/latest/
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-language/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-language/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-language/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-language/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-language/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-language/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-language/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-language/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-language/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-language/java11.html
[stability-image]: https://img.shields.io/badge/stability-ga-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-language.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-language&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-language/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-language/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-language/blob/master/LICENSE
[enable-billing]: https://cloud.google.com/apis/docs/getting-started#enabling_billing
[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=language.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png
