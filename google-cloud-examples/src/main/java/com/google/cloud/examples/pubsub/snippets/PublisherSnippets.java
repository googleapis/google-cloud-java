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

package com.google.cloud.examples.pubsub.snippets;

import com.google.api.gax.core.RpcFuture;
import com.google.api.gax.core.RpcFutureCallback;
import com.google.cloud.pubsub.spi.v1.Publisher;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;

public class PublisherSnippets {
  private final Publisher publisher;

  public PublisherSnippets(Publisher publisher) {
    this.publisher = publisher;
  }

  /**
   * Example of publishing a message.
   */
  // [TARGET publish(PubsubMessage)]
  // [VARIABLE "my_message"]
  public RpcFuture<String> publish(String message) {
    // [START publish]
    ByteString data = ByteString.copyFromUtf8(message);
    PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(data).build();
    RpcFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
    messageIdFuture.addCallback(new RpcFutureCallback<String>() {
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

  /**
   * Example of creating a {@code Publisher}.
   */
  // [TARGET newBuilder(TopicName)]
  // [VARIABLE "my_project"]
  // [VARIABLE "my_topic"]
  public static void newBuilder(String projectName, String topicName) throws Exception {
    // [START newBuilder]
    TopicName topic = TopicName.create(projectName, topicName);
    Publisher publisher = Publisher.newBuilder(topic).build();
    try {
      // ...
    } finally {
      // When finished with the publisher, make sure to shutdown to free up resources.
      publisher.shutdown();
    }
    // [END newBuilder]
  }
}
