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

package com.google.cloud.examples.pubsub;

import com.google.api.gax.core.RpcFuture;
import com.google.api.gax.core.RpcFutureCallback;
import com.google.cloud.pubsub.spi.v1.Publisher;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import java.util.Arrays;
import java.util.List;

public class PublisherSnippets {
  /**
   * Example of publishing messages.
   */
  // [TARGET publish(PubsubMessage)]
  // [VARIABLE "my_project_name"]
  // [VARIABLE "my_topic_name"]
  public void publish(String projectName, String topicName) throws Exception {
    // [START publish]
    Publisher publisher = Publisher.newBuilder(TopicName.create(projectName, topicName)).build();
    List<String> messages = Arrays.asList("message1", "message2");

    for (String message : messages) {
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
    }

    publisher.shutdown();
    // [END publish]
  }
}
