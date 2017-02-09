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

/**
 * A client to Google Cloud Pub/Sub.
 *
 * <p>Here's a simple usage example for using google-cloud from Compute Engine/App Engine Flexible.
 * This example shows how to create a Pub/Sub topic and asynchronously publish messages to it. For
 * the complete source code see
 * <a href="https://github.com/GoogleCloudPlatform/google-cloud-java/tree/master/google-cloud-examples/src/main/java/com/google/cloud/examples/pubsub/snippets/CreateTopicAndPublishMessages.java">
 * CreateTopicAndPublishMessages.java</a>.
 * <pre> {@code
 * try (PubSub pubsub = PubSubOptions.getDefaultInstance().getService()) {
 *   Topic topic = pubsub.create(TopicInfo.of("test-topic"));
 *   Message message1 = Message.of("First message");
 *   Message message2 = Message.of("Second message");
 *   topic.publishAsync(message1, message2);
 * }}</pre>
 *
 * <p>This second example shows how to create a Pub/Sub pull subscription and asynchronously pull
 * messages from it. For the complete source code see
 * <a href="https://github.com/GoogleCloudPlatform/google-cloud-java/tree/master/google-cloud-examples/src/main/java/com/google/cloud/examples/pubsub/snippets/CreateSubscriptionAndPullMessages.java">
 * CreateSubscriptionAndPullMessages.java</a>.
 * <pre> {@code
 * try (PubSub pubsub = PubSubOptions.getDefaultInstance().getService()) {
 *   Subscription subscription =
 *   pubsub.create(SubscriptionInfo.of("test-topic", "test-subscription"));
 *   MessageProcessor callback = new MessageProcessor() {
 *     public void process(Message message) throws Exception {
 *       System.out.printf("Received message \"%s\"%n", message.payloadAsString());
 *     }
 *   };
 *   // Create a message consumer and pull messages (for 60 seconds)
 *   try (MessageConsumer consumer = subscription.pullAsync(callback)) {
 *     Thread.sleep(60_000);
 *   }
 * }}</pre>
 *
 * @see <a href="https://cloud.google.com/pubsub/">Google Cloud Pub/Sub</a>
 */
package com.google.cloud.pubsub.deprecated;
