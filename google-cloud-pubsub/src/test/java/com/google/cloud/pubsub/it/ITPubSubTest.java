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

package com.google.cloud.pubsub.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.core.SettableApiFuture;
import com.google.cloud.ServiceOptions;
import com.google.cloud.pubsub.spi.v1.AckReply;
import com.google.cloud.pubsub.spi.v1.AckReplyConsumer;
import com.google.cloud.pubsub.spi.v1.MessageReceiver;
import com.google.cloud.pubsub.spi.v1.Publisher;
import com.google.cloud.pubsub.spi.v1.TopicAdminClient;
import com.google.cloud.pubsub.spi.v1.Subscriber;
import com.google.cloud.pubsub.spi.v1.SubscriptionAdminClient;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.Binding;
import com.google.iam.v1.Policy;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.PushConfig;
import com.google.pubsub.v1.SubscriptionName;
import com.google.pubsub.v1.TopicName;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class ITPubSubTest {

  private static final String NAME_SUFFIX = UUID.randomUUID().toString();
  private static TopicAdminClient topicAdminClient;
  private static SubscriptionAdminClient subscriptionAdminClient;
  private static String projectId;

  @Rule public Timeout globalTimeout = Timeout.seconds(300);

  @BeforeClass
  public static void setupClass() throws Exception {
    topicAdminClient = TopicAdminClient.create();
    subscriptionAdminClient = SubscriptionAdminClient.create();
    projectId = ServiceOptions.getDefaultProjectId();
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
    topicAdminClient.close();
    subscriptionAdminClient.close();
  }

  private String formatForTest(String resourceName) {
    return resourceName + "-" + NAME_SUFFIX;
  }

  @Test
  public void testTopicPolicy() {
    TopicName topicName = TopicName.create(projectId, formatForTest("testing-topic-policy"));
    topicAdminClient.createTopic(topicName);

    Policy policy = topicAdminClient.getIamPolicy(topicName.toString());
    Binding binding =
        Binding.newBuilder().setRole("roles/viewer").addMembers("allAuthenticatedUsers").build();
    Policy newPolicy =
        topicAdminClient.setIamPolicy(
            topicName.toString(), policy.toBuilder().addBindings(binding).build());
    assertTrue(newPolicy.getBindingsList().contains(binding));

    String permissionName = "pubsub.topics.get";
    List<String> permissions =
        topicAdminClient
            .testIamPermissions(topicName.toString(), Collections.singletonList(permissionName))
            .getPermissionsList();
    assertTrue(permissions.contains(permissionName));

    topicAdminClient.deleteTopic(topicName);
  }

  @Test
  public void testPublishSubscribe() throws Exception {
    TopicName topicName =
        TopicName.create(projectId, formatForTest("testing-publish-subscribe-topic"));
    SubscriptionName subscriptionName =
        SubscriptionName.create(projectId, formatForTest("testing-publish-subscribe-subscription"));

    topicAdminClient.createTopic(topicName);
    subscriptionAdminClient.createSubscription(
        subscriptionName, topicName, PushConfig.newBuilder().build(), 10);
    PubsubMessage message =
        PubsubMessage.newBuilder().setData(ByteString.copyFromUtf8("my message")).build();

    final SettableApiFuture<PubsubMessage> received = SettableApiFuture.create();
    Subscriber subscriber =
        Subscriber.newBuilder(
                subscriptionName,
                new MessageReceiver() {
                  @Override
                  public void receiveMessage(
                      final PubsubMessage message, final AckReplyConsumer consumer) {
                    if (received.set(message)) {
                      consumer.accept(AckReply.ACK);
                    } else {
                      consumer.accept(AckReply.NACK);
                    }
                  }
                })
            .build();
    subscriber.addListener(
        new Subscriber.SubscriberListener() {
          public void failed(Subscriber.State from, Throwable failure) {
            received.setException(failure);
          }
        },
        MoreExecutors.directExecutor());
    subscriber.startAsync();

    Publisher publisher = Publisher.newBuilder(topicName).build();
    publisher.publish(message).get();
    publisher.shutdown();

    assertEquals(received.get().getData(), message.getData());
    subscriber.stopAsync().awaitTerminated();
    subscriptionAdminClient.deleteSubscription(subscriptionName);
    topicAdminClient.deleteTopic(topicName);
  }
}
