/*
 * Copyright 2016, Google Inc. All rights reserved.
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

/**
 * A client to Google Cloud Pub/Sub API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>=============== PublisherClient ===============
 *
 * <p>Service Description: The service that an application uses to manipulate topics, and to send
 * messages to a topic.
 *
 * <p>Sample for PublisherClient:
 *
 * <pre>
 * <code>
 * try (PublisherClient publisherClient = PublisherClient.create()) {
 *   TopicName name = TopicName.create("[PROJECT]", "[TOPIC]");
 *   Topic response = publisherClient.createTopic(name);
 * }
 * </code>
 * </pre>
 *
 * ================ SubscriberClient ================
 *
 * <p>Service Description: The service that an application uses to manipulate subscriptions and to
 * consume messages from a subscription via the `Pull` method.
 *
 * <p>Sample for SubscriberClient:
 *
 * <pre>
 * <code>
 * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
 *   SubscriptionName name = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]");
 *   TopicName topic = TopicName.create("[PROJECT]", "[TOPIC]");
 *   PushConfig pushConfig = PushConfig.newBuilder().build();
 *   int ackDeadlineSeconds = 0;
 *   Subscription response = subscriberClient.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
 * }
 * </code>
 * </pre>
 */
package com.google.cloud.pubsub.spi.v1;
