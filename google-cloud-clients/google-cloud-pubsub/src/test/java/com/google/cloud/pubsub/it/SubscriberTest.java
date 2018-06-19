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

import com.google.cloud.ServiceOptions;
import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.cloud.pubsub.v1.SubscriptionAdminClient;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.common.util.concurrent.MoreExecutors;

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

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class SubscriberTest {

  private static final String NAME_SUFFIX = UUID.randomUUID().toString();

  private static TopicAdminClient topicAdminClient;

  private static SubscriptionAdminClient subscriptionAdminClient;

  private static String projectId;

  @Rule
  public Timeout globalTimeout = Timeout.seconds(300);

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

  @Test
  public void testPublishSubscribe() throws Exception {
    ProjectTopicName topicName = ProjectTopicName.of(projectId, formatForTest("testing-publish-subscribe-topic"));
    ProjectSubscriptionName subscriptionName = ProjectSubscriptionName.of(projectId,
        formatForTest("testing-publish-subscribe-subscription"));

    topicAdminClient.createTopic(topicName);
    subscriptionAdminClient.createSubscription(
        subscriptionName, topicName, PushConfig.newBuilder().build(), 10);

    final BlockingQueue<Pair<PubsubMessage, AckReplyConsumer>> receiveQueue = new LinkedBlockingQueue<>();
    Subscriber subscriber = Subscriber.newBuilder(
        subscriptionName,
        new MessageReceiver() {
          @Override
          public void receiveMessage(
              final PubsubMessage message, final AckReplyConsumer consumer) {
            receiveQueue.offer(Pair.of(message, consumer));
          }
        })
        .build();
    subscriber.addListener(
        new Subscriber.Listener() {
          public void failed(Subscriber.State from, Throwable failure) {
            failure.printStackTrace();
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

    // Recieve the first message, don't ack or nack
    Pair<PubsubMessage, AckReplyConsumer> msgAck = receiveQueue.poll(10, TimeUnit.SECONDS);
    String firstMsg = msgAck.getFirst().getData().toStringUtf8();


    // Nack the other.
    msgAck = receiveQueue.poll(1, TimeUnit.SECONDS);
    String secondMsg = msgAck.getFirst().getData().toStringUtf8();
    msgAck.getSecond().nack();

    boolean gotSecondMsg = false;
    boolean gotFirstdMsg = false;

    // We should get both messages back.
    for (int i = 0; i < 30; i++) {
      Pair<PubsubMessage, AckReplyConsumer> message = receiveQueue.poll(1, TimeUnit.SECONDS);
      if (message != null) {
        String msg = message.getFirst().getData().toStringUtf8();
        message.getSecond().ack();
        if(firstMsg.equals(msg)) {
          gotFirstdMsg = true;
        }else if(secondMsg.equals(msg)) {
          gotSecondMsg = true;
        }
        if(gotFirstdMsg && gotSecondMsg){
          break;
        }
      }
      Thread.sleep(1000);
    }

    assertThat(gotFirstdMsg).isTrue();
    assertThat(gotSecondMsg).isTrue();
    subscriber.stopAsync();
    subscriptionAdminClient.deleteSubscription(subscriptionName);
    topicAdminClient.deleteTopic(topicName);
  }
}

class Pair<A, B> {
  private A first;
  private B second;

  public static <A, B> Pair<A, B>  of(A first, B second){
    return new Pair<>(first, second);
  }

  private Pair(A first, B second) {
    this.first = first;
    this.second = second;
  }

  public A getFirst() {
    return first;
  }

  public B getSecond() {
    return second;
  }
}