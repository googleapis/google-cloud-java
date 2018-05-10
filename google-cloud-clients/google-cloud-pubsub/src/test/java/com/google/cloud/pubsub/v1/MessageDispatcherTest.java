/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.pubsub.v1;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.core.Distribution;
import com.google.auto.value.AutoValue;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.ReceivedMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.threeten.bp.Duration;

public class MessageDispatcherTest {
  private static final ReceivedMessage TEST_MESSAGE =
      ReceivedMessage.newBuilder()
          .setAckId("ackid")
          .setMessage(PubsubMessage.newBuilder().setData(ByteString.EMPTY).build())
          .build();
  private static final Runnable NOOP_RUNNABLE =
      new Runnable() {
        @Override
        public void run() {
          // No-op; don't do anything.
        }
      };

  private MessageDispatcher dispatcher;
  private LinkedBlockingQueue<AckReplyConsumer> consumers;
  private List<String> sentAcks;
  private List<ModAckItem> sentModAcks;
  private FakeClock clock;

  @AutoValue
  abstract static class ModAckItem {
    abstract String ackId();

    abstract int seconds();

    static ModAckItem of(String ackId, int seconds) {
      return new AutoValue_MessageDispatcherTest_ModAckItem(ackId, seconds);
    }
  }

  @Before
  public void setUp() {
    consumers = new LinkedBlockingQueue<>();
    sentAcks = new ArrayList<>();
    sentModAcks = new ArrayList<>();

    MessageReceiver receiver =
        new MessageReceiver() {
          @Override
          public void receiveMessage(final PubsubMessage message, final AckReplyConsumer consumer) {
            consumers.add(consumer);
          }
        };
    MessageDispatcher.AckProcessor processor =
        new MessageDispatcher.AckProcessor() {
          public void sendAckOperations(
              List<String> acksToSend,
              List<MessageDispatcher.PendingModifyAckDeadline> ackDeadlineExtensions) {
            sentAcks.addAll(acksToSend);
            for (MessageDispatcher.PendingModifyAckDeadline modack : ackDeadlineExtensions) {
              for (String ackId : modack.ackIds) {
                sentModAcks.add(ModAckItem.of(ackId, modack.deadlineExtensionSeconds));
              }
            }
          }
        };

    // This executor isn't used because we're not actually scheduling anything until we call
    // dispatcher.start(), which we're not doing here.
    ScheduledThreadPoolExecutor systemExecutor = new ScheduledThreadPoolExecutor(1);
    systemExecutor.shutdownNow();

    clock = new FakeClock();

    dispatcher =
        new MessageDispatcher(
            receiver,
            processor,
            Duration.ofSeconds(5),
            Duration.ofMinutes(60),
            new Distribution(Subscriber.MAX_ACK_DEADLINE_SECONDS + 1),
            new FlowController(FlowControlSettings.newBuilder().build()),
            new LinkedList<MessageDispatcher.OutstandingMessageBatch>(),
            MoreExecutors.directExecutor(),
            systemExecutor,
            clock);
    dispatcher.setMessageDeadlineSeconds(Subscriber.MIN_ACK_DEADLINE_SECONDS);
  }

  @Test
  public void testReceipt() throws Exception {
    dispatcher.processReceivedMessages(Collections.singletonList(TEST_MESSAGE), NOOP_RUNNABLE);
    dispatcher.processOutstandingAckOperations();
    assertThat(sentModAcks)
        .contains(ModAckItem.of(TEST_MESSAGE.getAckId(), Subscriber.MIN_ACK_DEADLINE_SECONDS));
  }

  @Test
  public void testAck() throws Exception {
    dispatcher.processReceivedMessages(Collections.singletonList(TEST_MESSAGE), NOOP_RUNNABLE);
    consumers.take().ack();
    dispatcher.processOutstandingAckOperations();
    assertThat(sentAcks).contains(TEST_MESSAGE.getAckId());
  }

  @Test
  public void testNack() throws Exception {
    dispatcher.processReceivedMessages(Collections.singletonList(TEST_MESSAGE), NOOP_RUNNABLE);
    consumers.take().nack();
    dispatcher.processOutstandingAckOperations();
    assertThat(sentModAcks).contains(ModAckItem.of(TEST_MESSAGE.getAckId(), 0));
  }

  @Test
  public void testExtension() throws Exception {
    dispatcher.processReceivedMessages(Collections.singletonList(TEST_MESSAGE), NOOP_RUNNABLE);
    dispatcher.extendDeadlines();
    assertThat(sentModAcks)
        .contains(ModAckItem.of(TEST_MESSAGE.getAckId(), Subscriber.MIN_ACK_DEADLINE_SECONDS));

    sentModAcks.clear();
    consumers.take().ack();
    dispatcher.extendDeadlines();
    assertThat(sentModAcks).isEmpty();
  }

  @Test
  public void testExtension_Close() throws Exception {
    dispatcher.processReceivedMessages(Collections.singletonList(TEST_MESSAGE), NOOP_RUNNABLE);
    dispatcher.extendDeadlines();
    assertThat(sentModAcks)
        .contains(ModAckItem.of(TEST_MESSAGE.getAckId(), Subscriber.MIN_ACK_DEADLINE_SECONDS));
    sentModAcks.clear();

    // Default total expiration is an hour (60*60 seconds). We normally would extend by 10s.
    // However, only extend by 5s here, since there's only 5s left before total expiration.
    clock.advance(60 * 60 - 5, TimeUnit.SECONDS);
    dispatcher.extendDeadlines();
    assertThat(sentModAcks).contains(ModAckItem.of(TEST_MESSAGE.getAckId(), 5));
  }

  @Test
  public void testExtension_GiveUp() throws Exception {
    dispatcher.processReceivedMessages(Collections.singletonList(TEST_MESSAGE), NOOP_RUNNABLE);
    dispatcher.extendDeadlines();
    assertThat(sentModAcks)
        .contains(ModAckItem.of(TEST_MESSAGE.getAckId(), Subscriber.MIN_ACK_DEADLINE_SECONDS));
    sentModAcks.clear();

    // If we run extendDeadlines after totalExpiration, we shouldn't send anything.
    // In particular, don't send negative modacks.
    clock.advance(1, TimeUnit.DAYS);
    dispatcher.extendDeadlines();
    assertThat(sentModAcks).isEmpty();
  }

  @Test
  public void testDeadlineAdjustment() throws Exception {
    assertThat(dispatcher.computeDeadlineSeconds()).isEqualTo(10);

    dispatcher.processReceivedMessages(Collections.singletonList(TEST_MESSAGE), NOOP_RUNNABLE);
    clock.advance(42, TimeUnit.SECONDS);
    consumers.take().ack();

    assertThat(dispatcher.computeDeadlineSeconds()).isEqualTo(42);
  }
}
