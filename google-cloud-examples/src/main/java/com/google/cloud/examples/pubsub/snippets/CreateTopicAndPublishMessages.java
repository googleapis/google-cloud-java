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

import com.google.cloud.pubsub.Message;
import com.google.cloud.pubsub.PubSub;
import com.google.cloud.pubsub.PubSubOptions;
import com.google.cloud.pubsub.Topic;
import com.google.cloud.pubsub.TopicInfo;

/**
 * A snippet for Google Cloud Pub/Sub showing how to create a Pub/Sub topic and asynchronously
 * publish messages to it.
 */
public class CreateTopicAndPublishMessages {

  public static void main(String... args) throws Exception {
    try (PubSub pubsub = PubSubOptions.getDefaultInstance().getService()) {
      Topic topic = pubsub.create(TopicInfo.of("test-topic"));
      Message message1 = Message.of("First message");
      Message message2 = Message.of("Second message");
      topic.publishAsync(message1, message2);
    }
  }
}
