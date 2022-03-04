/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package utilities;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/** Sample methods for Publishing messages to a topic in Pub/Sub. */
public class PublishOperations {

  public static void publishMessage(String projectId, String topicId) throws Exception {

    Publisher publisher = Publisher.newBuilder(TopicName.of(projectId, topicId)).build();

    try {
      String message = "Pub/Sub Native Image Test published message at timestamp: " + Instant.now();
      ByteString data = ByteString.copyFromUtf8(message);
      PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(data).build();

      publisher.publish(pubsubMessage);

      ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
      String messageId = messageIdFuture.get();

      System.out.println("Published message with ID: " + messageId);
    } finally {
      publisher.shutdown();
    }
  }

  public static void publishWithCustomAttributes(String projectId, String topicId)
      throws Exception {

    TopicName topicName = TopicName.of(projectId, topicId);
    Publisher publisher = Publisher.newBuilder(topicName).build();

    try {
      String message = "first message";
      ByteString data = ByteString.copyFromUtf8(message);
      PubsubMessage pubsubMessage =
          PubsubMessage.newBuilder()
              .setData(data)
              .putAllAttributes(Collections.singletonMap("year", "2020"))
              .build();

      // Once published, returns a server-assigned message id (unique within the topic)
      ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
      String messageId = messageIdFuture.get();
      System.out.println("Published a message with custom attributes: " + messageId);
    } finally {
      publisher.shutdown();
    }
  }

  public static void publishWithBatchSettings(String projectId, String topicId)
      throws IOException, ExecutionException, InterruptedException {

    TopicName topicName = TopicName.of(projectId, topicId);
    Publisher publisher = Publisher.newBuilder(topicName).build();
    List<ApiFuture<String>> messageIdFutures = new ArrayList<>();

    try {
      // schedule publishing one message at a time : messages get automatically batched
      for (int i = 0; i < 100; i++) {
        String message = "message " + i;
        ByteString data = ByteString.copyFromUtf8(message);
        PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(data).build();

        // Once published, returns a server-assigned message id (unique within the topic)
        ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
        messageIdFutures.add(messageIdFuture);
      }
    } finally {
      // Wait on any pending publish requests.
      List<String> messageIds = ApiFutures.allAsList(messageIdFutures).get();
      System.out.println("Published " + messageIds.size() + " messages with batch settings.");

      publisher.shutdown();
    }
  }

  public static void publishWithErrorHandler(String projectId, String topicId) throws IOException {

    TopicName topicName = TopicName.of(projectId, topicId);
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
        ApiFutures.addCallback(
            future,
            new ApiFutureCallback<String>() {

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
                System.out.println("Success Callback: Published message " + messageId);
              }
            },
            MoreExecutors.directExecutor());
      }
    } finally {
      if (publisher != null) {
        // When finished with the publisher, shutdown to free up resources.
        publisher.shutdown();
      }
    }
  }
}
