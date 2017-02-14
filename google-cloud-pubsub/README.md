Google Cloud Java Client for Pub/Sub
====================================

Java idiomatic client for [Google Cloud Pub/Sub] (https://cloud.google.com/pubsub/).

[![Build Status](https://travis-ci.org/GoogleCloudPlatform/google-cloud-java.svg?branch=master)](https://travis-ci.org/GoogleCloudPlatform/google-cloud-java)
[![Coverage Status](https://coveralls.io/repos/GoogleCloudPlatform/google-cloud-java/badge.svg?branch=master)](https://coveralls.io/r/GoogleCloudPlatform/google-cloud-java?branch=master)
[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-pubsub.svg)]( https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-pubsub.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/google-cloud-java)
[![Dependency Status](https://www.versioneye.com/user/projects/56bd8ee72a29ed002d2b0969/badge.svg?style=flat)](https://www.versioneye.com/user/projects/56bd8ee72a29ed002d2b0969)

-  [Homepage] (https://googlecloudplatform.github.io/google-cloud-java/)
-  [API Documentation] (https://googlecloudplatform.github.io/google-cloud-java/apidocs)

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.

Quickstart
----------

> `google-cloud-pubsub` uses gRPC as transport layer, which is not (yet) supported by App Engine
Standard. `google-cloud-pubsub` will work on App Engine Flexible.

Add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-pubsub</artifactId>
  <version>0.9.2-alpha</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-pubsub:0.9.2-alpha'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-pubsub" % "0.9.2-alpha"
```

Example Application
-------------------

[`PubSubExample`](../google-cloud-examples/src/main/java/com/google/cloud/examples/pubsub/PubSubExample.java) is a simple command line interface that provides some of Cloud Pub/Sub's functionality.  Read more about using the application on the [`PubSubExample` docs page](https://googlecloudplatform.github.io/google-cloud-java/apidocs/?com/google/cloud/examples/pubsub/PubSubExample.html).

Authentication
--------------

See the [Authentication](https://github.com/GoogleCloudPlatform/google-cloud-java#authentication) section in the base directory's README.

About Google Cloud Pub/Sub
--------------------------

[Google Cloud Pub/Sub][cloud-pubsub] is designed to provide reliable,
many-to-many, asynchronous messaging between applications. Publisher
applications can send messages to a ``topic`` and other applications can
subscribe to that topic to receive the messages. By decoupling senders and
receivers, Google Cloud Pub/Sub allows developers to communicate between
independently written applications.

See the [Google Cloud Pub/Sub docs][cloud-pubsub-quickstart] for more details on how to activate
Cloud Pub/Sub for your project.

See the ``google-cloud`` API [Pub/Sub documentation][pubsub-api] to learn how to interact with the
Cloud Pub/Sub using this Client Library.

Getting Started
---------------
#### Prerequisites
For this tutorial, you will need a
[Google Developers Console](https://console.developers.google.com/) project with the Pub/Sub API
enabled. You will need to [enable billing](https://support.google.com/cloud/answer/6158867?hl=en) to
use Google Cloud Pub/Sub.
[Follow these instructions](https://cloud.google.com/docs/authentication#preparation) to get your
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
These credentials are automatically inferred from your environment, so you only need the following
code to create your service object:

```java
import com.google.cloud.pubsub.PubSub;
import com.google.cloud.pubsub.PubSubOptions;

try(PubSub pubsub = PubSubOptions.getDefaultInstance().getService()) {
  // use pubsub here
}
```

For other authentication options, see the
[Authentication](https://github.com/GoogleCloudPlatform/google-cloud-java#authentication) page.

#### Creating a topic
With Pub/Sub you can create topics. A topic is a named resource to which messages are sent by
publishers. Add the following imports at the top of your file:

```java
import com.google.cloud.pubsub.Topic;
import com.google.cloud.pubsub.TopicInfo;
```
Then, to create the topic, use the following code:

```java
Topic topic = pubsub.create(TopicInfo.of("test-topic"));
```

#### Publishing messages
With Pub/Sub you can publish messages to a topic. Add the following import at the top of your file:

```java
import com.google.cloud.pubsub.Message;
```
Then, to publish messages asynchronously, use the following code:

```java
Message message1 = Message.of("First message");
Message message2 = Message.of("Second message");
topic.publishAsync(message1, message2);
```

#### Creating a subscription
With Pub/Sub you can create subscriptions. A subscription represents the stream of messages from a
single, specific topic. Add the following imports at the top of your file:

```java
import com.google.cloud.pubsub.Subscription;
import com.google.cloud.pubsub.SubscriptionInfo;
```
Then, to create the subscription, use the following code:

```java
Subscription subscription =
    pubsub.create(SubscriptionInfo.of("test-topic", "test-subscription"));
```

#### Pulling messages
With Pub/Sub you can pull messages from a subscription. Add the following imports at the top of your
file:

```java
import com.google.cloud.pubsub.Message;
import com.google.cloud.pubsub.PubSub.MessageConsumer;
import com.google.cloud.pubsub.PubSub.MessageProcessor;
```
Then, to pull messages asynchronously, use the following code:

```java
MessageProcessor callback = new MessageProcessor() {
  @Override
  public void process(Message message) throws Exception {
    System.out.printf("Received message \"%s\"%n", message.getPayloadAsString());
  }
};
// Create a message consumer and pull messages (for 60 seconds)
try (MessageConsumer consumer = subscription.pullAsync(callback)) {
  Thread.sleep(60_000);
}
```
#### Complete source code

In
[CreateTopicAndPublishMessages.java](../google-cloud-examples/src/main/java/com/google/cloud/examples/pubsub/snippets/CreateTopicAndPublishMessages.java)
and
[CreateSubscriptionAndPullMessages.java](../google-cloud-examples/src/main/java/com/google/cloud/examples/pubsub/snippets/CreateSubscriptionAndPullMessages.java)
we put together all the code shown above into two programs. The programs assume that you are
running on Compute Engine, App Engine Flexible or from your own desktop.

Java Versions
-------------

Java 7 or above is required for using this client.

Testing
-------

This library has tools to help make tests for code using Cloud Pub/Sub.

See [TESTING] to read more about testing.

Versioning
----------

This library follows [Semantic Versioning] (http://semver.org/).

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
[TESTING]: https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/TESTING.md#testing-code-that-uses-pubsub

[cloud-pubsub]: https://cloud.google.com/storage/
[cloud-pubsub-quickstart]: https://cloud.google.com/pubsub/quickstart-console#before-you-begin
[pubsub-api]: https://googlecloudplatform.github.io/google-cloud-java/apidocs/index.html?com/google/cloud/pubsub/package-summary.html
