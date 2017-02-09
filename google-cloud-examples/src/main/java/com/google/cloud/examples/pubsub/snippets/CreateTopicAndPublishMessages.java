/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.examples.pubsub.snippets;

import com.google.api.gax.core.RpcFuture;
import com.google.cloud.pubsub.spi.v1.Publisher;
import com.google.cloud.pubsub.spi.v1.PublisherClient;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A snippet for Google Cloud Pub/Sub showing how to create a Pub/Sub topic and asynchronously
 * publish messages to it.
 */
public class CreateTopicAndPublishMessages {
  public static void main(String... args) throws Exception {
    TopicName topic = TopicName.create("test-project", "test-topic");
    try (PublisherClient publisherClient = PublisherClient.create()) {
      publisherClient.createTopic(topic);
    }

    Publisher publisher = null;
    try {
      publisher = Publisher.newBuilder(topic).build();
      List<String> messages = Arrays.asList("first message", "second message");
      List<RpcFuture<String>> messageIds = new ArrayList<>();
      for (String message : messages) {
        ByteString data = ByteString.copyFromUtf8(message);
        PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(data).build();
        RpcFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
        messageIds.add(messageIdFuture);
      }
      for (RpcFuture<String> messageId : messageIds) {
        System.out.println("published with message ID: " + messageId.get());
      }
    } finally {
      if (publisher != null) {
        publisher.shutdown();
      }
    }
  }
}
