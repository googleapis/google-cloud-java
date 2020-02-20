# Google Cloud Java Client for Google Cloud Pub/Sub

Java idiomatic client for [Google Cloud Pub/Sub][api-reference].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][product-docs]
- [Client Library Documentation][javadocs]

## Quickstart

If you are using Maven with a BOM, add this to your pom.xml file:

```xml
<dependencyManagement>
 <dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>libraries-bom</artifactId>
    <version>2.9.0</version>
    <type>pom</type>
    <scope>import</scope>
   </dependency>
 </dependencies>
</dependencyManagement>

<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-pubsub</artifactId>
</dependency>
```

[//]: # ({x-version-update-start:google-cloud-pubsub:released})
If you are using Maven without a BOM, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-pubsub</artifactId>
  <version>1.103.0</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-pubsub:1.103.0'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-pubsub" % "1.103.0"
```
[//]: # ({x-version-update-end})

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## About Google Cloud Pub/Sub

[Google Cloud Pub/Sub][api-reference] is designed to provide reliable,
many-to-many, asynchronous messaging between applications. Publisher
applications can send messages to a topic and other applications can
subscribe to that topic to receive the messages. By decoupling senders and
receivers, Google Cloud Pub/Sub allows developers to communicate between
independently written applications.

See the [Google Cloud Pub/Sub docs](https://cloud.google.com/pubsub/quickstart-console#before-you-begin) for more details on how to activate
Cloud Pub/Sub for your project.

See the [Pub/Sub client library docs][javadocs] to learn how to interact with the
Cloud Pub/Sub using this Client Library.

## Getting Started

### Prerequisites

For this tutorial, you will need a
[Google Developers Console](https://console.developers.google.com/) project with the Pub/Sub API
enabled. You will need to [enable billing](https://support.google.com/cloud/answer/6158867?hl=en) to
use Google Cloud Pub/Sub.
[Follow these instructions](https://cloud.google.com/resource-manager/docs/creating-managing-projects) to get your
project set up. You will also need to set up the local development environment by [installing the
Google Cloud SDK](https://cloud.google.com/sdk/) and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

#### Installation and setup

You'll need to obtain the `google-cloud-pubsub` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-pubsub` as a dependency in your code.

#### Creating an authorized service object

To make authenticated requests to Google Cloud Pub/Sub, you must create a service object with
credentials. You can then make API calls by calling methods on the Pub/Sub service object. The
simplest way to authenticate is to use
[Application Default Credentials](https://developers.google.com/identity/protocols/application-default-credentials).
These credentials are automatically inferred from your environment.

For other authentication options, see the
[Authentication](https://github.com/googleapis/google-cloud-java#authentication) page.

#### Creating a topic

With Pub/Sub you can create topics. A topic is a named resource to which messages are sent by
publishers. Add the following imports at the top of your file:

```java
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.pubsub.v1.ProjectTopicName;
```
Then, to create the topic, use the following code:

```java
ProjectTopicName topic = ProjectTopicName.of("test-project", "test-topic");
try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
  topicAdminClient.createTopic(topic);
}
```

#### Publishing messages

With Pub/Sub you can publish messages to a topic. Add the following import at the top of your file:

```java
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
```
Then, to publish messages asynchronously, use the following code:

```java
Publisher publisher = null;
try {
  publisher = Publisher.newBuilder(topic).build();
  ByteString data = ByteString.copyFromUtf8("my-message");
  PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(data).build();
  ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
  ApiFutures.addCallback(messageIdFuture, new ApiFutureCallback<String>() {
    public void onSuccess(String messageId) {
      System.out.println("published with message id: " + messageId);
    }

    public void onFailure(Throwable t) {
      System.out.println("failed to publish: " + t);
    }
  }, MoreExecutors.directExecutor());
  //...
} finally {
  if (publisher != null) {
    publisher.shutdown();
    publisher.awaitTermination(1, TimeUnit.MINUTES);
  }
}
```

#### Creating a subscription

With Pub/Sub you can create subscriptions. A subscription represents the stream of messages from a
single, specific topic. Add the following imports at the top of your file:

```java
import com.google.cloud.pubsub.v1.SubscriptionAdminClient;
import com.google.pubsub.v1.PushConfig;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.ProjectTopicName;
```
Then, to create the subscription, use the following code:

```java
ProjectTopicName topic = ProjectTopicName.of("test-project", "test-topic");
ProjectSubscriptionName subscription = ProjectSubscriptionName.of("test-project", "test-subscription");

try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
  subscriptionAdminClient.createSubscription(subscription, topic, PushConfig.getDefaultInstance(), 0);
}
```

#### Pulling messages

With Pub/Sub you can pull messages from a subscription. Add the following imports at the top of your
file:

```java
import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.ProjectTopicName;
```
Then, to pull messages asynchronously, use the following code:

```java
ProjectSubscriptionName subscription = ProjectSubscriptionName.of("test-project", "test-subscription");

MessageReceiver receiver =
  new MessageReceiver() {
    @Override
    public void receiveMessage(PubsubMessage message, AckReplyConsumer consumer) {
      System.out.println("got message: " + message.getData().toStringUtf8());
      consumer.ack();
    }
  };

Subscriber subscriber = null;
try {
  subscriber = Subscriber.newBuilder(subscription, receiver).build();
  subscriber.addListener(
    new Subscriber.Listener() {
      @Override
      public void failed(Subscriber.State from, Throwable failure) {
        // Handle failure. This is called when the Subscriber encountered a fatal error and is shutting down.
        System.err.println(failure);
      }
    },
    MoreExecutors.directExecutor());
  subscriber.startAsync().awaitRunning();
  //...
} finally {
  if (subscriber != null) {
    subscriber.stopAsync();
  }
}
```
#### Complete source code

In [CreateTopicAndPublishMessages.java](../../google-cloud-examples/src/main/java/com/google/cloud/examples/pubsub/snippets/CreateTopicAndPublishMessages.java) and [CreateSubscriptionAndConsumeMessages.java](../../google-cloud-examples/src/main/java/com/google/cloud/examples/pubsub/snippets/CreateSubscriptionAndConsumeMessages.java) we put together all the code shown above into two programs. The programs assume that you are running on Compute Engine, App Engine Flexible or from your own desktop.


## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Google Cloud Pub/Sub uses gRPC for the transport layer.

## Java Versions

Java 7 or above is required for using this client.

## Versioning

This library follows [Semantic Versioning](http://semver.org/).

It is currently in major version zero (``0.y.z``), which means that anything may change at any time
and the public API should not be considered stable.

## Contributing

Contributions to this library are always welcome and highly encouraged.

See [CONTRIBUTING.md][contributing] documentation for more information on how to get started.

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

[api-reference]: https://cloud.google.com/pubsub/
[product-docs]: https://cloud.google.com/pubsub/docs/
[javadocs]: https://googleapis.dev/java/google-cloud-clients/latest/index.html?com/google/cloud/pubsub/v1/package-summary.html
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-pubsub/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-pubsub/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-pubsub/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-pubsub/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-pubsub/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-pubsub/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-pubsub/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-pubsub/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-pubsub/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-pubsub/java11.html
[stability-image]: https://img.shields.io/badge/stability-ga-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-pubsub.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-pubsub&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-pubsub/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-pubsub/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-pubsub/blob/master/LICENSE
