/*
 * Copyright 2016 Google LLC
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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.ProjectTopicName;
import com.google.pubsub.v1.PubsubMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A snippet for Google Cloud Pub/Sub showing how to create a Pub/Sub topic and asynchronously
 * publish messages to it.
 */
public class CreateTopicAndPublishMessages {

  public static void createTopic() throws Exception {
    ProjectTopicName topic = ProjectTopicName.of("my-project-id", "my-topic-id");
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      topicAdminClient.createTopic(topic);
    }
  }

  public static void publishMessages() throws Exception {
    // [START pubsub_publish]
    ProjectTopicName topicName = ProjectTopicName.of("my-project-id", "my-topic-id");
    Publisher publisher = null;
    List<ApiFuture<String>> messageIdFutures = new ArrayList<>();

    try {
      // Create a publisher instance with default settings bound to the topic
      publisher = Publisher.newBuilder(topicName).build();

      List<String> messages = Arrays.asList("first message", "second message");

      // schedule publishing one message at a time : messages get automatically batched
      for (String message : messages) {
        ByteString data = ByteString.copyFromUtf8(message);
        PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(data).build();

        // Once published, returns a server-assigned message id (unique within the topic)
        ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
        messageIdFutures.add(messageIdFuture);
      }
    } finally {
      // wait on any pending publish requests.
      List<String> messageIds = ApiFutures.allAsList(messageIdFutures).get();

      for (String messageId : messageIds) {
        System.out.println("published with message ID: " + messageId);
      }

      if (publisher != null) {
        // When finished with the publisher, shutdown to free up resources.
        publisher.shutdown();
      }
    }
    // [END pubsub_publish]
  }

  public static void publishMessagesWithErrorHandler() throws Exception {
    // [START pubsub_publish_error_handler]
    ProjectTopicName topicName = ProjectTopicName.of("my-project-id", "my-topic-id");
    Publisher publisher = null;

    try {
      // Create a publisher instance with default settings bound to the topic
      publisher = Publisher.newBuilder(topicName).build();

      List<String> messages = Arrays.asList("first message", "second message");

      for (final String message : messages) {
        ByteString data = ByteString.copyFromUtf8(message);
        PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(data).build();

        // Once published, returns a server-assigned message id (unique within the topic)
        ApiFuture<String> future = publisher.publish(pubsubMessage);

        // Add an asynchronous callback to handle success / failure
        ApiFutures.addCallback(future, new ApiFutureCallback<String>() {

          @Override
          public void onFailure(Throwable throwable) {
            if (throwable instanceof ApiException) {
              ApiException apiException = ((ApiException) throwable);
              // details on the API exception
              System.out.println(apiException.getStatusCode().getCode());
              System.out.println(apiException.isRetryable());
            }
            System.out.println("Error publishing message : " + message);
          }

          @Override
          public void onSuccess(String messageId) {
            // Once published, returns server-assigned message ids (unique within the topic)
            System.out.println(messageId);
          }
        });
      }
    } finally {
      if (publisher != null) {
        // When finished with the publisher, shutdown to free up resources.
        publisher.shutdown();
      }
    }
    // [END pubsub_publish_error_handler]
  }
  
  public static void main(String... args) throws Exception {
    createTopic();
    publishMessages();
  }
}
