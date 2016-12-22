High-Perf Client Migration
==========================
This document provides an overview of changes introduced by the
high-performance client.

`Subscriber`
------------
Previously, the client provided two ways to pull messages from topics.
- Use the [`pull`](http://googlecloudplatform.github.io/google-cloud-java/0.8.0/apidocs/com/google/cloud/pubsub/PubSub.html#pull-java.lang.String-int-) method then [`ack`](http://googlecloudplatform.github.io/google-cloud-java/0.8.0/apidocs/com/google/cloud/pubsub/PubSub.html#ack-java.lang.String-java.lang.Iterable-) or [`nack`](http://googlecloudplatform.github.io/google-cloud-java/0.8.0/apidocs/com/google/cloud/pubsub/PubSub.html#nack-java.lang.String-java.lang.Iterable-).
- Use the [`pullAsync`](http://googlecloudplatform.github.io/google-cloud-java/0.8.0/apidocs/com/google/cloud/pubsub/PubSub.html#pullAsync-java.lang.String-com.google.cloud.pubsub.PubSub.MessageProcessor-com.google.cloud.pubsub.PubSub.PullOption...-) method and provide a [`callback`](http://googlecloudplatform.github.io/google-cloud-java/0.8.0/apidocs/com/google/cloud/pubsub/PubSub.MessageProcessor.html).

With the high-perf client, there's only one way: the `Subscriber`.
The following is a whimsical example for printing all received messages
to standard output.
```java
Subscriber subscriber = myPubSub.subscriber(mySubscription, new MessageReceiver() {
  @Override
  ListenableFuture<AckReply> receiveMessage(PubsubMessage message) {
    System.out.println(message.getData());
    return Futures.immediateFuture(MessageReceiver.AckReply.ACK);
  }
});
```
