/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in Publisher's javadoc. Any change to this file should be reflected in
 * Publisher's javadoc.
 */
package com.google.cloud.examples.pubsub.snippets;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.batching.FlowController.LimitExceededBehavior;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.pubsub.spi.v1.Publisher;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import org.joda.time.Duration;

/** This class contains snippets for the {@link Publisher} interface. */
public class PublisherSnippets {
  private final Publisher publisher;

  public PublisherSnippets(Publisher publisher) {
    this.publisher = publisher;
  }

  /** Example of publishing a message. */
  // [TARGET publish(PubsubMessage)]
  // [VARIABLE "my_message"]
  public ApiFuture<String> publish(String message) {
    // [START publish]
    ByteString data = ByteString.copyFromUtf8(message);
    PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(data).build();

    ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);

    // add an asynchronous callback
    ApiFutures.addCallback(messageIdFuture, new ApiFutureCallback<String>() {
      public void onSuccess(String messageId) {
        System.out.println("published with message id: " + messageId);
      }

      public void onFailure(Throwable t) {
        System.out.println("failed to publish: " + t);
      }
    });
    // [END publish]
    return messageIdFuture;
  }

  /** Example of creating a {@code Publisher}. */
  // [TARGET newBuilder(TopicName)]
  // [VARIABLE "my_project"]
  // [VARIABLE "my_topic"]
  public static void newBuilder(String projectId, String topicId) throws Exception {
    // [START createPublisher]
    TopicName topic = TopicName.create(projectId, topicId);
    Publisher publisher = Publisher.defaultBuilder(topic).build();
    try {
      // ...
    } finally {
      // When finished with the publisher, make sure to shutdown to free up resources.
      publisher.shutdown();
    }
    // [END createPublisher]
  }

  public Publisher getPublisherWithCustomSettings(String projectId, String topicId)
      throws Exception {
    // batch publishing based on message count
    // [START publisherBatchSettings]
    // Batch settings control how the publisher batches messages
    long requestBytesThreshold = 5000L; // default : 1kb
    long messageCountBatchSize = 10L; // default : 100
    Duration publishDelayThreshold = Duration.millis(100); // default : 1 ms
    // Order of precedence in batching thresholds : request size > message count > publish delay
    BatchingSettings batchingSettings = BatchingSettings.newBuilder()
        .setElementCountThreshold(messageCountBatchSize)
        .setRequestByteThreshold(requestBytesThreshold)
        .setDelayThreshold(publishDelayThreshold)
        .build();
    // ...
    // [END publisherBatchSettings]

    // [START publisherRetrySettings]
    // Retry settings control how the publisher handles failures
    // Retry delays have an in-built multiplier-based backoff, up to the max
    Duration retryDelay = Duration.millis(100); // default : 1 ms
    Duration maxRetryDelay = Duration.standardSeconds(5); // default : 10 seconds
    double retryDelayMultiplier = 2.0; // default : ?

    RetrySettings retrySettings = RetrySettings.newBuilder()
        .setInitialRetryDelay(retryDelay)
        .setRetryDelayMultiplier(retryDelayMultiplier)
        .setMaxRetryDelay(maxRetryDelay)
        .build();
    // [END publisherRetrySettings]

    // [START publisherFlowControlSettings]
    // Flow settings control how the publisher manages outstanding
    int maxOutstandingBatches = 2; // default : disabled
    int maxOutstandingRequestBytes = 5000; // default : disabled
    // default behavior is to throw an exception
    LimitExceededBehavior limitExceededBehavior = LimitExceededBehavior.Block;

    FlowControlSettings flowControlSettings = FlowControlSettings.newBuilder()
        .setMaxOutstandingElementCount(maxOutstandingBatches)
        .setMaxOutstandingRequestBytes(maxOutstandingRequestBytes)
        .setLimitExceededBehavior(limitExceededBehavior)
        .build();
    // [END publisherFlowControlSettings]

    // [START createPublisherWithCustomConfig]
    TopicName topicName = TopicName.create(projectId, topicId);
    Publisher publisher = Publisher.defaultBuilder(topicName)
        .setBatchingSettings(batchingSettings)
        .setRetrySettings(retrySettings)
        .setFlowControlSettings(flowControlSettings)
        .build();
    // [END createPublisherWithBatchConfig]
    return publisher;
  }
}
