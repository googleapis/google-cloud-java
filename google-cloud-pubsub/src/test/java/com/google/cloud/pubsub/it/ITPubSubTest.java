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

package com.google.cloud.pubsub.it;

import com.google.auto.value.AutoValue;
import com.google.cloud.ServiceOptions;
import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.cloud.pubsub.v1.SubscriptionAdminClient;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.Binding;
import com.google.iam.v1.Policy;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.ProjectTopicName;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.PushConfig;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static com.google.common.truth.Truth.assertThat;

public class ITPubSubTest {

  private static final String NAME_SUFFIX = UUID.randomUUID().toString();
  private static TopicAdminClient topicAdminClient;
  private static SubscriptionAdminClient subscriptionAdminClient;
  private static String projectId;

  @Rule public Timeout globalTimeout = Timeout.seconds(300);

  @AutoValue
  abstract static class MessageAndConsumer {
    abstract PubsubMessage message();

    abstract AckReplyConsumer consumer();

    static MessageAndConsumer create(PubsubMessage message, AckReplyConsumer consumer) {
      return new AutoValue_ITPubSubTest_MessageAndConsumer(message, consumer);
    }
  }

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
    ProjectTopicName topicName = ProjectTopicName.of(projectId, formatForTest("testing-topic-policy"));
    topicAdminClient.createTopic(topicName);

    Policy policy = topicAdminClient.getIamPolicy(topicName.toString());
    Binding binding =
        Binding.newBuilder().setRole("roles/viewer").addMembers("allAuthenticatedUsers").build();
    Policy newPolicy =
        topicAdminClient.setIamPolicy(
            topicName.toString(), policy.toBuilder().addBindings(binding).build());
    assertThat(newPolicy.getBindingsList()).contains(binding);

    String permissionName = "pubsub.topics.get";
    List<String> permissions =
        topicAdminClient
            .testIamPermissions(topicName.toString(), Collections.singletonList(permissionName))
            .getPermissionsList();
    assertThat(permissions).contains(permissionName);

    topicAdminClient.deleteTopic(topicName);
  }

  @Test
  public void testPublishSubscribe() throws Exception {
    ProjectTopicName topicName =
        ProjectTopicName.of(projectId, formatForTest("testing-publish-subscribe-topic"));
    ProjectSubscriptionName subscriptionName =
        ProjectSubscriptionName.of(projectId, formatForTest("testing-publish-subscribe-subscription"));

    topicAdminClient.createTopic(topicName);
    subscriptionAdminClient.createSubscription(
        subscriptionName, topicName, PushConfig.newBuilder().build(), 10);

    final BlockingQueue<Object> receiveQueue = new LinkedBlockingQueue<>();
    Subscriber subscriber =
        Subscriber.newBuilder(
                subscriptionName,
                new MessageReceiver() {
                  @Override
                  public void receiveMessage(
                      final PubsubMessage message, final AckReplyConsumer consumer) {
                    receiveQueue.offer(MessageAndConsumer.create(message, consumer));
                  }
                })
            .build();
    subscriber.addListener(
        new Subscriber.Listener() {
          public void failed(Subscriber.State from, Throwable failure) {
            receiveQueue.offer(failure);
          }
        },
        MoreExecutors.directExecutor());
    subscriber.startAsync();

    Publisher publisher = Publisher.newBuilder(topicName).build();
    publisher
        .publish(PubsubMessage.newBuilder().setData(ByteString.copyFromUtf8("msg1")).build())
        .get();
    publisher
        .publish(PubsubMessage.newBuilder().setData(ByteString.copyFromUtf8("msg2")).build())
        .get();
    publisher.shutdown();

    // Ack the first message.
    MessageAndConsumer toAck = pollQueue(receiveQueue);
    toAck.consumer().ack();

    // Nack the other.
    MessageAndConsumer toNack = pollQueue(receiveQueue);
    assertThat(toNack.message().getData()).isNotEqualTo(toAck.message().getData());
    toNack.consumer().nack();

    // We should get the nacked message back.
    MessageAndConsumer redelivered = pollQueue(receiveQueue);
    assertThat(redelivered.message().getData()).isEqualTo(toNack.message().getData());
    redelivered.consumer().ack();

    subscriber.stopAsync().awaitTerminated();
    subscriptionAdminClient.deleteSubscription(subscriptionName);
    topicAdminClient.deleteTopic(topicName);
  }

  private MessageAndConsumer pollQueue(BlockingQueue<Object> queue) throws InterruptedException {
    Object obj = queue.poll(1, TimeUnit.MINUTES);
    if (obj == null) {
      return null;
    }
    if (obj instanceof Throwable) {
      throw new IllegalStateException("unexpected error", (Throwable) obj);
    }
    if (obj instanceof MessageAndConsumer) {
      return (MessageAndConsumer) obj;
    }
    throw new IllegalStateException(
        "expected either MessageAndConsumer or Throwable, found: " + obj);
  }
}
