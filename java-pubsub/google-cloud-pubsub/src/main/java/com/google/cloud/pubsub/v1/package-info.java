/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * A client to Cloud Pub/Sub API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= TopicAdminClient =======================
 *
 * <p>Service Description: The service that an application uses to manipulate topics, and to send
 * messages to a topic.
 *
 * <p>Sample for TopicAdminClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
 *   TopicName name = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
 *   Topic response = topicAdminClient.createTopic(name);
 * }
 * }</pre>
 *
 * <p>======================= SubscriptionAdminClient =======================
 *
 * <p>Service Description: The service that an application uses to manipulate subscriptions and to
 * consume messages from a subscription via the `Pull` method or by establishing a bi-directional
 * stream using the `StreamingPull` method.
 *
 * <p>Sample for SubscriptionAdminClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
 *   SubscriptionName name = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
 *   TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
 *   PushConfig pushConfig = PushConfig.newBuilder().build();
 *   int ackDeadlineSeconds = 2135351438;
 *   Subscription response =
 *       subscriptionAdminClient.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
 * }
 * }</pre>
 *
 * <p>======================= SchemaServiceClient =======================
 *
 * <p>Service Description: Service for doing schema-related operations.
 *
 * <p>Sample for SchemaServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   Schema schema = Schema.newBuilder().build();
 *   String schemaId = "schemaId-697673060";
 *   Schema response = schemaServiceClient.createSchema(parent, schema, schemaId);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.pubsub.v1;

import javax.annotation.Generated;
