# Google Vertex AI SDK for Java

Java idiomatic SDK for [Vertex AI][product-docs].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][product-docs]


## Add Dependency

If you are using Maven with [BOM][libraries-bom], add this to your pom.xml file:

```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>libraries-bom</artifactId>
      <version>26.38.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-vertexai</artifactId>
  </dependency>
```

If you are using Maven without the BOM, add this to your dependencies:

<!-- {x-version-update-start:google-cloud-vertexai:released} -->

```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-vertexai</artifactId>
  <version>1.2.0</version>
</dependency>
```

If you are using Gradle without BOM, add this to your dependencies:

```Groovy
implementation 'com.google.cloud:google-cloud-vertexai:1.2.0'
```

If you are using SBT, add this to your dependencies:

```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-vertexai" % "1.2.0"
```
<!-- {x-version-update-end} -->

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Authorization

The client application making API calls must be granted [authorization scopes][auth-scopes] required for the desired Vertex AI APIs, and the authenticated principal must have the [IAM role(s)][predefined-iam-roles] required to access GCP resources using the Vertex AI API calls.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Vertex AI [API enabled][enable-api].
You will need to [enable billing][enable-billing] to use Google Vertex AI.
[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud Command Line Interface][cloud-cli] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

To acquire user credentials to use for [Application Default Credentials][adc], run `gcloud auth application-default login`.

### Installation and setup

You'll need to obtain the `google-cloud-vertexai` library.  See the [Add Dependency](#add-dependency) section
to add `google-cloud-vertexai` as a dependency in your code.

## About Vertex AI

[Vertex AI][product-docs] is an integrated suite of machine learning tools and services for building and using ML models with AutoML or custom code. It was previously known as AI Platform. Vertex AI offers both novices and experts the best workbench for the entire machine learning development lifecycle. This SDK currently only supports Generative AI service on the Vertex AI platform. To access the full set of services on the Vertex AI, consider using the [`google-cloud-aiplatform` client libraries][aiplatform-client-libraries].

### Vertex AI SDK
Vertex AI provides [Generative AI Studio](generative-ai-studio) that supports text generation from multi-modality input via a set of most advanced models from Google. This brings out a wide range of applications.

#### Basic Text Generation
Vertex AI SDK allows you to access the service programmatically. The following code snippet is the most basic usage of SDK

```java
package <your package name>

import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import java.io.IOException;

public class Main {
  private static final String PROJECT_ID = <your project id>;
  private static final String LOCATION = <location>;

  public static void main(String[] args) throws IOException {
    try (VertexAI vertexAi = new VertexAI(PROJECT_ID, LOCATION);) {

      GenerativeModel model = new GenerativeModel("gemini-pro", vertexAi);

      GenerateContentResponse response = model.generateContent("How are you?");
      // Do something with the response
    }
  }
}
```

#### Text Generation with Streaming
To get a streamed output, you can use the `generateContentStream` method

```java
package <your package name>

import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.generativeai.ResponseStream;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import java.io.IOException;

public class Main {
  private static final String PROJECT_ID = <your project id>;
  private static final String LOCATION = <location>;

  public static void main(String[] args) throws IOException {
    try (VertexAI vertexAi = new VertexAI(PROJECT_ID, LOCATION);) {

      GenerativeModel model = new GenerativeModel("gemini-pro", vertexAi);

      ResponseStream<GenerateContentResponse> responseStream = model.generateContentStream("How are you?");
      // Do something with the ResponseStream, which is an iterable.
    }
  }
}
```

#### Text Generation with Async
To get a future response, you can use the `generateContentAsync` method

```java
package <your package name>

import com.google.api.core.ApiFuture;
import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import java.io.IOException;

public class Main {
  private static final String PROJECT_ID = <your project id>;
  private static final String LOCATION = <location>;

  public static void main(String[] args) throws IOException {
    try (VertexAI vertexAi = new VertexAI(PROJECT_ID, LOCATION);) {

      GenerativeModel model = new GenerativeModel("gemini-pro", vertexAi);

      ApiFuture<GenerateContentResponse> future = model.generateContentAsync("How are you?");

      // Do something else.

      // Get the response from Future
      GenerateContentResponse response = future.get();

      // Do something with the response.
    }
  }
}
```

#### Text Generation from Multi-modal Input
To generate text based on data of multiple modalities, one needs to make a `Content`, which is made easier by `ContentMaker`:

```java
package <your package name>;

import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.generativeai.ResponseStream;
import com.google.cloud.vertexai.generativeai.ContentMaker;
import com.google.cloud.vertexai.generativeai.PartMaker;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import java.util.Arrays;

public class Main {
  private static final String PROJECT_ID = <your project id>;
  private static final String LOCATION = <location>;
  private static final String IMAGE_URI = <gcs uri to your image>

  public static void main(String[] args) throws Exception {
    try (VertexAI vertexAi = new VertexAI(PROJECT_ID, LOCATION); ) {
      // Vision model must be used for multi-modal input
      GenerativeModel model = new GenerativeModel("gemini-pro-vision", vertexAi);

      ResponseStream<GenerateContentResponse> stream =
          model.generateContentStream(ContentMaker.fromMultiModalData(
            "Please describe this image",
            PartMaker.fromMimeTypeAndData("image/jpeg", IMAGE_URI)
          ));
      // Do something with the ResponseStream, which is an iterable.
    }
  }
}
```

#### Role Change for Multi-turn Conversation
For a multi-turn conversation, one needs to make a `Content` list to represent the whole conversation between two roles: "user" and "model".

```java
package <your package name>;

import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.Content;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.generativeai.ContentMaker;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.generativeai.ResponseHandler;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
  private static final String PROJECT_ID = <your project id>;
  private static final String LOCATION = <location>;
  private static final String MODEL_NAME = "gemini-pro";

  public static void main(String[] args) throws IOException {
    try (VertexAI vertexAi = new VertexAI(PROJECT_ID, LOCATION); ) {
      GenerativeModel model =
          new GenerativeModel(MODEL_NAME, vertexAi);

      // Put all the contents in a Content list
      List<Content> contents =
          Arrays.asList(
              ContentMaker.fromString("Hi!"),
              ContentMaker.forRole("model")
                  .fromString("Hello! How may I assist you?"),
              ContentMaker.fromString(
                  "Can you explain quantum mechanis as well in only a few sentences?"));

      // generate the result
      GenerateContentResponse response = model.generateContent(contents);

      // ResponseHandler.getText is a helper function to retrieve the text part of the answer.
      System.out.println("\nPrint response: ");
      System.out.println(ResponseHandler.getText(response));
      System.out.println("\n");
    }
  }
}
```

#### Using ChatSession for Multi-turn Conversation
Yeah, we know, that isn't the most intuitive and easy way to chat with a model. Therefore we provide a `Chat` class:

```java
package <your package name>;

import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.generativeai.ChatSession;
import com.google.cloud.vertexai.generativeai.ResponseStream;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
  private static final String PROJECT_ID = <your project id>;
  private static final String LOCATION = <location>;

  public static void main(String[] args) throws IOException {
    try (VertexAI vertexAi = new VertexAI(PROJECT_ID, LOCATION); ) {
      GenerativeModel model =
          new GenerativeModel("gemini-pro", vertexAi);
      ChatSession chat = model.startChat();

      // Send the first message.
      // ChatSession also has two versions of sendMessage, stream and non-stream
      ResponseStream<GenerateContentResponse> response = chat.sendMessageStream("Hi!");

      // Do something with the output stream, possibly with ResponseHandler

      // Now send another message. The history will be remembered by the ChatSession.
      // Note: the stream needs to be consumed before you send another message
      // or fetch the history.
      ResponseStream<GenerateContentResponse> anotherResponse = chat.sendMessageStream("Can you explain quantum mechanis as well in a few sentences?");

      // Do something with the second response

      // See the whole history. Make sure you have consumed the stream.
      List<Content> history = chat.getHistory();
    }
  }
}
```

#### Generation with customized configurations

The Vertex AI SDK for Java provides configurations for customizing content
generation. You can configure options like
[GenerationConfig][generationconfig-ref] and [SafetySetting][safetysetting-ref],
or add [Tool][tool-ref] for function calling.

You can choose between two configuration approaches: set configs during model
instantiation for consistency across all text generations, or adjust them on a
per-request basis for fine-grained control.

##### Model level configurations

```java
package <PACKAGE_NAME>

import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.api.GenerationConfig;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.generativeai.ResponseHandler;
import java.io.IOException;

public class Main {
  private static final String PROJECT_ID = <PROJECT_ID>;
  private static final String LOCATION = <LOCATION>;

  public static void main(String[] args) throws IOException {
    try (VertexAI vertexAi = new VertexAI(PROJECT_ID, LOCATION);) {
      // Build a GenerationConfig instance.
      GenerationConfig generationConfig =
          GenerationConfig.newBuilder().setMaxOutputTokens(50).build();

      // Use the builder to instantialize the model with the configuration.
      GenerativeModel model =
          new GenerativeModel.Builder()
              .setModelName("gemino-pro")
              .setVertexAi(vertexAi)
              .setGenerationConfig(generationConfig)
              .build();

      // Generate the response.
      GenerateContentResponse response = model.generateContent("Please explain LLM?");

      // Do something with the response.
    }
  }
}
```

##### Request level configurations

Our SDK provides fluent APIs to control request level configurations.

```java
package <PACKAGE_NAME>

import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.api.HarmCategory;
import com.google.cloud.vertexai.api.SafetySetting;
import com.google.cloud.vertexai.api.SafetySetting.HarmBlockThreshold;
import com.google.cloud.vertexai.generativeai.GenerateContentConfig;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import java.io.IOException;
import java.util.Arrays;

public class Main {
  private static final String PROJECT_ID = <PROJECT_ID>;
  private static final String LOCATION = <LOCATION>;

  public static void main(String[] args) throws IOException {
    try (VertexAI vertexAi = new VertexAI(PROJECT_ID, LOCATION); ) {
      // Build a SafetySetting instance.
      SafetySetting safetySetting =
          SafetySetting.newBuilder()
              .setCategory(HarmCategory.HARM_CATEGORY_DANGEROUS_CONTENT)
              .setThreshold(HarmBlockThreshold.BLOCK_LOW_AND_ABOVE)
              .build();

      // Generate the response with the fluent API `withSafetySetting`.
      GenerateContentResponse response =
          model
              .withSafetySetting(Arrays.asList(SafetySetting))
              .generateContent("Please explain LLM?");

      // Do something with the response.
    }
  }
}
```

#### Configurations for ChatSession

When a chat session is started (`ChatSesson chat = model.startChat()`),
it inherits all configurations from the model. You can also use fluent APIs
to update these settings during the chat.

```java
package <PACKAGE_NAME>

import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.api.GenerationConfig;
import com.google.cloud.vertexai.generativeai.ChatSession;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.generativeai.ResponseHandler;
import java.io.IOException;

public class Main {
  private static final String PROJECT_ID = <PROJECT_ID>;
  private static final String LOCATION = <LOCATION>;

  public static void main(String[] args) throws IOException {
    try (VertexAI vertexAi = new VertexAI(PROJECT_ID, LOCATION);) {
      // Instantiate a model with GenerationConfig
      GenerationConfig generationConfig =
          GenerationConfig.newBuilder().setMaxOutputTokens(50).build();
      GenerativeModel model =
          new GenerativeModel.Builder()
              .setModelName("gemino-pro")
              .setVertexAi(vertexAi)
              .setGenerationConfig(generationConfig)
              .build();

      // Start a chat session
      ChatSession chat = model.startChat();

      // Send a message. The model level GenerationConfig will be applied here
      GenerateContentResponse response = chat.sendMessage("Please explain LLM?");

      // Do something with the response

      // Send another message, using Fluent API to update the GenerationConfig
      response =
          chat.withGenerationConfig(GenerationConfig.getDefaultInstance())
              .sendMessage("Tell me more about what you can do.");

      // Do something with the response
    }
  }
}
```


#### Using ChatSession for Function-calling
In a chat, we can also do function calling.

```java
package <your package name>;
import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.generativeai.ChatSession;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.generativeai.ResponseHandler;
import com.google.cloud.vertexai.generativeai.ResponseStream;
import com.google.cloud.vertexai.api.Content;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import java.io.IOException;

public class Main {
  private static final String PROJECT_ID = "<your project>";
  private static final String LOCATION = "<location>";
  private static final String MODEL_NAME = "gemini-pro";
  private static final String TEXT = "What's the weather in Vancouver?";

  public static void main(String[] args) throws IOException {
    try (VertexAI vertexAi = new VertexAI(PROJECT_ID, LOCATION); ) {
      // Declare a function to be used in a request.
      // We construct a jsonString that corresponds to the following function
      // declaration.
      // {
      //   "name": "getCurrentWeather",
      //   "description": "Get the current weather in a given location",
      //   "parameters": {
      //     "type": "OBJECT",
      //     "properties": {
      //       "location": {
      //         "type": "STRING",
      //         "description": "location"
      //       }
      //     }
      //   }
      // }
      // With JDK 15 and above, you can do
      //
      // String jsonString = """
      //   {
      //     "name": "getCurrentWeather",
      //     "description": "Get the current weather in a given location",
      //     "parameters": {
      //       "type": "OBJECT",
      //       "properties": {
      //         "location": {
      //           "type": "STRING",
      //           "description": "location"
      //         }
      //       }
      //     }
      //   }
      //  """
      String jsonString =
              "{\n"
            + " \"name\": \"getCurrentWeather\",\n"
            + " \"description\": \"Get the current weather in a given location\",\n"
            + " \"parameters\": {\n"
            + "   \"type\": \"OBJECT\", \n"
            + "   \"properties\": {\n"
            + "     \"location\": {\n"
            + "       \"type\": \"STRING\",\n"
            + "       \"description\": \"location\"\n"
            + "     }\n"
            + "   }\n"
            + " }\n"
            + "}";
      Tool tool =
          Tool.newBuilder()
              .addFunctionDeclarations(
                FunctionDeclarationMaker.fromJsonString(jsonString)
              )
              .build();

      // Start a chat session from a model, with the use of the declared
      // function.
      GenerativeModel model =
          new GenerativeModel.Builder()
              .setModelName(MODEL_NAME)
              .setVertexAi(vertexAi)
              .setTools(Arrays.asList(tool))
              .build();
      ChatSession chat = model.startChat();

      System.out.println(String.format("Ask the question: %s", TEXT));
      GenerateContentResponse response = chat.sendMessage(TEXT);

      // The model will most likely return a function call to the declared
      // function `getCurrentWeather` with "Vancouver" as the value for the
      // argument `location`.
      System.out.println("\nPrint response: ");
      System.out.println(ResponseHandler.getContent(response));
      System.out.println("\n");

      // Provide an answer to the model so that it knows what the result of a
      // "function call" is.
      Content content =
          ContentMaker.fromMultiModalData(
              PartMaker.fromFunctionResponse(
                  "getCurrentWeather", Collections.singletonMap("currentWeather", "snowing")));
      System.out.println("Provide the function response: ");
      System.out.println(content);
      System.out.println("\n");
      response = chat.sendMessage(content);

      // See what the model replies now
      System.out.println("\nPrint response: ");
      System.out.println(ResponseHandler.getText(response));
      System.out.println("\n");
    }
  }
}
```

See the [Vertex AI SDK docs][javadocs] to learn more about how to use this Vertex AI SDK in more advanced ways.

## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Other Configurations
### Vertex-scoped Configurations
#### Transport

Vertex AI uses gRPC and rest for the transport layer. By default, we use gRPC transport. To use rest, passing a `Transport.REST` to the `VertexAI` constructor as the example below:

```java
package <your package name>

import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.generativeai.Transport;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import java.io.IOException;

public class Main {
  private static final String PROJECT_ID = <your project id>;
  private static final String LOCATION = <location>;

  public static void main(String[] args) throws IOException {
    try (VertexAI vertexAi = new VertexAI.Builder()
                                  .setProjectId(PROJECT_ID)
                                  .setLocation(LOCATION)
                                  .setTransport(Transport.REST);) {

      GenerativeModel model = new GenerativeModel("gemini-pro", vertexAi);

      GenerateContentResponse response = model.generateContent("How are you?");
      // Do something with the response
    }
  }
}
```

#### ApiEndpoint
To use a different API endpoint, one can set it when instantiating `VertexAI`.

```java
package <your package name>

import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import java.io.IOException;

public class Main {
  private static final String PROJECT_ID = <your project id>;
  private static final String LOCATION = <location>;

  public static void main(String[] args) throws IOException {
    try (VertexAI vertexAi = new VertexAI.Builder()
                                  .setProjectId(PROJECT_ID)
                                  .setLocation(LOCATION)
                                  .setApiEndpoint(<new_endpoint>);) {

      GenerativeModel model = new GenerativeModel("gemini-pro", vertexAi);

      GenerateContentResponse response = model.generateContent("How are you?");
      // Do something with the response
    }
  }
}
```


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

[product-docs]: https://cloud.google.com/vertex-ai/docs
[javadocs]: https://cloud.google.com/java/docs/reference/google-cloud-vertexai/latest/overview
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
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-vertexai.svg
[maven-version-link]: https://central.sonatype.com/artifact/com.google.cloud/google-cloud-vertexai/0.0.1
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[auth-scopes]: https://developers.google.com/identity/protocols/oauth2/scopes
[predefined-iam-roles]: https://cloud.google.com/iam/docs/understanding-roles#predefined_roles
[iam-policy]: https://cloud.google.com/iam/docs/overview#cloud-iam-policy
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-cli]: https://cloud.google.com/cli
[troubleshooting]: https://github.com/googleapis/google-cloud-java/blob/main/TROUBLESHOOTING.md
[contributing]: https://github.com/googleapis/google-cloud-java/blob/main/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/google-cloud-java/blob/main/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/google-cloud-java/blob/main/LICENSE
[enable-billing]: https://cloud.google.com/apis/docs/getting-started#enabling_billing
[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=aiplatform.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png
[aiplatform-client-libraries]: https://cloud.google.com/java/docs/reference/google-cloud-aiplatform/latest/overview
[adc]: https://cloud.google.com/docs/authentication/application-default-credentials
[semver]: https://semver.org/
[cloudlibs]: https://cloud.google.com/apis/docs/client-libraries-explained
[apilibs]: https://cloud.google.com/apis/docs/client-libraries-explained#google_api_client_libraries
[oracle]: https://www.oracle.com/java/technologies/java-se-support-roadmap.html
[g-c-j]: http://github.com/googleapis/google-cloud-java
[generative-ai-studio]: https://cloud.google.com/generative-ai-studio?hl=en
[generationconfig-ref]: https://cloud.google.com/java/docs/reference/google-cloud-vertexai/latest/com.google.cloud.vertexai.api.GenerationConfig.Builder
[safetysetting-ref]: https://cloud.google.com/java/docs/reference/google-cloud-vertexai/latest/com.google.cloud.vertexai.api.SafetySetting.Builder
[tool-ref]: https://cloud.google.com/java/docs/reference/google-cloud-vertexai/latest/com.google.cloud.vertexai.api.Tool.Builder