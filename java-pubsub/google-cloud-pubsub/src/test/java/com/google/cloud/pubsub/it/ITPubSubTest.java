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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assume.assumeTrue;

import com.google.api.gax.rpc.PermissionDeniedException;
import com.google.auto.value.AutoValue;
import com.google.cloud.ServiceOptions;
import com.google.cloud.pubsub.v1.*;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.*;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.rules.Timeout;

public class ITPubSubTest {

  private static final String NAME_SUFFIX = UUID.randomUUID().toString();
  private static TopicAdminClient topicAdminClient;
  private static SubscriptionAdminClient subscriptionAdminClient;
  private static String projectId;
  private static final boolean IS_VPC_TEST =
      System.getenv("GOOGLE_CLOUD_TESTS_IN_VPCSC") != null
          && System.getenv("GOOGLE_CLOUD_TESTS_IN_VPCSC").equalsIgnoreCase("true");

  private static final int MAX_INBOUND_MESSAGE_SIZE = 20 * 1024 * 1024;

  @Rule public Timeout globalTimeout = Timeout.seconds(300);

  @AutoValue
  abstract static class MessageAndConsumer {
    abstract PubsubMessage message();

    abstract AckReplyConsumer consumer();

    static MessageAndConsumer create(PubsubMessage message, AckReplyConsumer consumer) {
      return new AutoValue_ITPubSubTest_MessageAndConsumer(message, consumer);
    }
  }

  @AutoValue
  abstract static class MessageAndConsumerWithResponse {
    abstract PubsubMessage message();

    abstract AckReplyConsumerWithResponse consumerWithResponse();

    static MessageAndConsumerWithResponse create(
        PubsubMessage message, AckReplyConsumerWithResponse consumerWithResponse) {
      return new AutoValue_ITPubSubTest_MessageAndConsumerWithResponse(
          message, consumerWithResponse);
    }
  }

  @BeforeClass
  public static void setupClass() throws Exception {
    topicAdminClient = TopicAdminClient.create();
    subscriptionAdminClient = SubscriptionAdminClient.create();
    projectId = ServiceOptions.getDefaultProjectId();
  }

  @AfterClass
  public static void tearDownClass() {
    topicAdminClient.close();
    subscriptionAdminClient.close();
  }

  private String formatForTest(String resourceName) {
    return resourceName + "-" + NAME_SUFFIX;
  }

  private Subscription getSubscription(
      SubscriptionName subscriptionName,
      TopicName topicName,
      PushConfig pushConfig,
      int ackDeadline,
      boolean enableExactlyOnceDelivery) {
    return Subscription.newBuilder()
        .setName(subscriptionName.toString())
        .setTopic(topicName.toString())
        .setPushConfig(pushConfig)
        .setAckDeadlineSeconds(ackDeadline)
        .setEnableExactlyOnceDelivery(enableExactlyOnceDelivery)
        .build();
  }

  @Test
  public void testTopicPolicy() {
    TopicName topicName =
        TopicName.newBuilder()
            .setProject(projectId)
            .setTopic(formatForTest("testing-topic-policy"))
            .build();
    topicAdminClient.createTopic(topicName);

    Policy policy =
        topicAdminClient.getIamPolicy(
            GetIamPolicyRequest.newBuilder().setResource(topicName.toString()).build());
    Binding binding =
        Binding.newBuilder().setRole("roles/viewer").addMembers("allAuthenticatedUsers").build();

    Policy newPolicy =
        topicAdminClient.setIamPolicy(
            SetIamPolicyRequest.newBuilder()
                .setResource(topicName.toString())
                .setPolicy(policy.toBuilder().addBindings(binding).build())
                .build());
    assertThat(newPolicy.getBindingsList()).contains(binding);

    String permissionName = "pubsub.topics.get";
    List<String> permissions =
        topicAdminClient
            .testIamPermissions(
                TestIamPermissionsRequest.newBuilder()
                    .setResource(topicName.toString())
                    .addAllPermissions(Collections.singletonList(permissionName))
                    .build())
            .getPermissionsList();
    assertThat(permissions).contains(permissionName);

    topicAdminClient.deleteTopic(topicName);
  }

  @Test
  public void testVPCPushSubscriber() {
    assumeTrue(IS_VPC_TEST);
    TopicName topicName =
        TopicName.newBuilder()
            .setProject(projectId)
            .setTopic(formatForTest("testing-vpc-push-subscriber-topic"))
            .build();
    SubscriptionName subscriptionName =
        SubscriptionName.of(projectId, formatForTest("testing-vpc-push-subscriber-subscription"));
    topicAdminClient.createTopic(topicName);

    try {
      subscriptionAdminClient.createSubscription(
          getSubscription(
              subscriptionName,
              topicName,
              PushConfig.newBuilder().setPushEndpoint("https://random_point").build(),
              10,
              false));
      subscriptionAdminClient.deleteSubscription(subscriptionName);
      Assert.fail("No exception raised");
    } catch (PermissionDeniedException e) {
      // expected
    }

    topicAdminClient.deleteTopic(topicName);
  }

  @Test
  public void testPublishSubscribe() throws Exception {
    TopicName topicName =
        TopicName.newBuilder()
            .setProject(projectId)
            .setTopic(formatForTest("testing-publish-subscribe-topic"))
            .build();
    SubscriptionName subscriptionName =
        SubscriptionName.of(projectId, formatForTest("testing-publish-subscribe-subscription"));

    topicAdminClient.createTopic(topicName);

    subscriptionAdminClient.createSubscription(
        getSubscription(subscriptionName, topicName, PushConfig.newBuilder().build(), 10, false));

    final BlockingQueue<Object> receiveQueue = new LinkedBlockingQueue<>();
    Subscriber subscriber =
        Subscriber.newBuilder(
                subscriptionName.toString(),
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
    publisher.awaitTermination(1, TimeUnit.MINUTES);

    MessageAndConsumer toAck = pollQueueMessageAndConsumer(receiveQueue);
    // Ack the first message.
    toAck.consumer().ack();

    MessageAndConsumer toNack = pollQueueMessageAndConsumer(receiveQueue);
    // Because we are not using ordering keys, we have to compare the received messages to each
    // other
    assertNotEquals(toNack.message().getData(), toAck.message().getData());
    // Nack
    toNack.consumer().nack();

    // We should get the nacked message back.
    MessageAndConsumer redeliveredToAck = pollQueueMessageAndConsumer(receiveQueue);
    assertEquals(toNack.message().getData(), redeliveredToAck.message().getData());
    redeliveredToAck.consumer().ack();

    subscriber.stopAsync().awaitTerminated();
    subscriptionAdminClient.deleteSubscription(subscriptionName);
    topicAdminClient.deleteTopic(topicName);
  }

  @Test
  public void testPublishSubscribeMessageFutures() throws Exception {
    TopicName topicName =
        TopicName.newBuilder()
            .setProject(projectId)
            .setTopic(formatForTest("testing-publish-subscribe-message-futures"))
            .build();
    SubscriptionName subscriptionName =
        SubscriptionName.of(projectId, formatForTest("testing-publish-subscribe-message-futures"));

    topicAdminClient.createTopic(topicName);
    subscriptionAdminClient.createSubscription(
        getSubscription(subscriptionName, topicName, PushConfig.newBuilder().build(), 10, false));

    final BlockingQueue<Object> receiveQueue = new LinkedBlockingQueue<>();
    Subscriber subscriber =
        Subscriber.newBuilder(
                subscriptionName.toString(),
                new MessageReceiverWithAckResponse() {
                  @Override
                  public void receiveMessage(
                      final PubsubMessage message,
                      final AckReplyConsumerWithResponse consumerWithResponse) {
                    receiveQueue.offer(
                        MessageAndConsumerWithResponse.create(message, consumerWithResponse));
                  }
                })
            .setChannelProvider(
                SubscriptionAdminSettings.defaultGrpcTransportProviderBuilder()
                    .setMaxInboundMessageSize(MAX_INBOUND_MESSAGE_SIZE)
                    .build())
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
    publisher.awaitTermination(1, TimeUnit.MINUTES);

    // Ack the first message.
    MessageAndConsumerWithResponse toAck = pollQueueMessageAndConsumerWithResponse(receiveQueue);
    Future<AckResponse> ackResponseFuture = toAck.consumerWithResponse().ack();
    assertEquals(AckResponse.SUCCESSFUL, ackResponseFuture.get());

    MessageAndConsumerWithResponse toNack = pollQueueMessageAndConsumerWithResponse(receiveQueue);
    //  Because we are not using ordering keys, we have to compare the received messages to each
    // other
    assertNotEquals(toNack.message().getData(), toAck.message().getData());
    Future<AckResponse> nackResponseFuture = toNack.consumerWithResponse().nack();
    assertEquals(AckResponse.SUCCESSFUL, nackResponseFuture.get());

    MessageAndConsumerWithResponse redeliveredToAck =
        pollQueueMessageAndConsumerWithResponse(receiveQueue);
    Future<AckResponse> redeliveredToAckResponse = redeliveredToAck.consumerWithResponse().ack();

    assertEquals(toNack.message().getData(), redeliveredToAck.message().getData());
    assertEquals(AckResponse.SUCCESSFUL, redeliveredToAckResponse.get());

    subscriber.stopAsync().awaitTerminated();
    subscriptionAdminClient.deleteSubscription(subscriptionName);
    topicAdminClient.deleteTopic(topicName);
  }

  @Test
  public void testPublishSubscribeExactlyOnce() throws Exception {
    TopicName topicName =
        TopicName.newBuilder()
            .setProject(projectId)
            .setTopic(formatForTest("testing-publish-subscribe-exactly-once-topic"))
            .build();
    SubscriptionName subscriptionName =
        SubscriptionName.of(
            projectId, formatForTest("testing-publish-subscribe-exactly-once-subscription"));

    topicAdminClient.createTopic(topicName);
    subscriptionAdminClient.createSubscription(
        getSubscription(subscriptionName, topicName, PushConfig.newBuilder().build(), 60, true));

    final BlockingQueue<Object> receiveQueue = new LinkedBlockingQueue<>();
    Subscriber subscriber =
        Subscriber.newBuilder(
                subscriptionName.toString(),
                new MessageReceiverWithAckResponse() {
                  @Override
                  public void receiveMessage(
                      final PubsubMessage message,
                      final AckReplyConsumerWithResponse consumerWithResponse) {
                    receiveQueue.offer(
                        MessageAndConsumerWithResponse.create(message, consumerWithResponse));
                  }
                })
            .setChannelProvider(
                SubscriptionAdminSettings.defaultGrpcTransportProviderBuilder()
                    .setMaxInboundMessageSize(MAX_INBOUND_MESSAGE_SIZE)
                    .build())
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
    publisher.awaitTermination(1, TimeUnit.MINUTES);

    // Ack the first message.
    MessageAndConsumerWithResponse toAck = pollQueueMessageAndConsumerWithResponse(receiveQueue);
    Future<AckResponse> ackResponseFuture = toAck.consumerWithResponse().ack();
    assertEquals(AckResponse.SUCCESSFUL, ackResponseFuture.get());

    MessageAndConsumerWithResponse toNack = pollQueueMessageAndConsumerWithResponse(receiveQueue);
    // Because we are not using ordering keys, we have to compare the received messages to each
    // other
    assertNotEquals(toNack.message().getData(), toAck.message().getData());
    Future<AckResponse> nackResponseFuture = toNack.consumerWithResponse().nack();
    assertEquals(AckResponse.SUCCESSFUL, nackResponseFuture.get());

    MessageAndConsumerWithResponse redeliveredToAck =
        pollQueueMessageAndConsumerWithResponse(receiveQueue);
    Future<AckResponse> redeliveredToAckResponse = redeliveredToAck.consumerWithResponse().ack();

    assertEquals(toNack.message().getData(), redeliveredToAck.message().getData());
    assertEquals(AckResponse.SUCCESSFUL, redeliveredToAckResponse.get());

    subscriber.stopAsync().awaitTerminated();
    subscriptionAdminClient.deleteSubscription(subscriptionName);
    topicAdminClient.deleteTopic(topicName);
  }

  @Test
  public void testPublishSubscribeWithCompression() throws Exception {
    TopicName topicName =
        TopicName.newBuilder()
            .setProject(projectId)
            .setTopic(formatForTest("testing-compression-topic"))
            .build();
    SubscriptionName subscriptionName =
        SubscriptionName.of(projectId, formatForTest("testing-compression-subscription"));

    topicAdminClient.createTopic(topicName);

    subscriptionAdminClient.createSubscription(
        getSubscription(subscriptionName, topicName, PushConfig.newBuilder().build(), 10, false));

    final BlockingQueue<Object> receiveQueue = new LinkedBlockingQueue<>();
    Subscriber subscriber =
        Subscriber.newBuilder(
                subscriptionName.toString(),
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

    Publisher publisher = Publisher.newBuilder(topicName).setEnableCompression(true).build();

    String msg1 = generateMessage("msg1", 1000);
    String msg2 = generateMessage("msg2", 1500);
    publisher
        .publish(PubsubMessage.newBuilder().setData(ByteString.copyFromUtf8(msg1)).build())
        .get();
    publisher
        .publish(PubsubMessage.newBuilder().setData(ByteString.copyFromUtf8(msg2)).build())
        .get();
    publisher.shutdown();
    publisher.awaitTermination(1, TimeUnit.MINUTES);

    // Ack the first message.
    MessageAndConsumer toAck1 = pollQueueMessageAndConsumer(receiveQueue);
    toAck1.consumer().ack();

    // Ack the second message.
    MessageAndConsumer toAck2 = pollQueueMessageAndConsumer(receiveQueue);
    toAck2.consumer().ack();

    assertNotEquals(toAck1.message().getData(), toAck2.message().getData());

    subscriber.stopAsync().awaitTerminated();
    subscriptionAdminClient.deleteSubscription(subscriptionName);
    topicAdminClient.deleteTopic(topicName);
  }

  private MessageAndConsumer pollQueueMessageAndConsumer(BlockingQueue<Object> queue)
      throws InterruptedException {
    Object obj = pollQueue(queue);
    if (obj instanceof MessageAndConsumer) {
      return (MessageAndConsumer) obj;
    }
    throw new IllegalStateException(
        "expected either MessageAndConsumer or Throwable, found: " + obj);
  }

  private MessageAndConsumerWithResponse pollQueueMessageAndConsumerWithResponse(
      BlockingQueue<Object> queue) throws InterruptedException {
    Object obj = pollQueue(queue);
    if (obj instanceof MessageAndConsumerWithResponse) {
      return (MessageAndConsumerWithResponse) obj;
    }
    throw new IllegalStateException(
        "expected either MessageAndConsumerWithResponse or Throwable, found: " + obj);
  }

  private Object pollQueue(BlockingQueue<Object> queue) throws InterruptedException {
    Object obj = queue.poll(10, TimeUnit.MINUTES);
    if (obj == null) {
      return null;
    }
    if (obj instanceof Throwable) {
      throw new IllegalStateException("unexpected error", (Throwable) obj);
    }

    return obj;
  }

  /** Generates message of given bytes by repeatedly concatenating a token. */
  private String generateMessage(String token, int bytes) {
    String result = "";
    int tokenBytes = token.length();
    for (int i = 0; i < Math.floor(bytes / tokenBytes) + 1; i++) {
      result = result.concat(token);
    }
    return result;
  }
}
