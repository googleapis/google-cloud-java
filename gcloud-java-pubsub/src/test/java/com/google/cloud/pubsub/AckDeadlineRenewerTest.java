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

package com.google.cloud.pubsub;

import com.google.cloud.GrpcServiceOptions.ExecutorFactory;
import com.google.cloud.ServiceOptions.Clock;
import com.google.common.collect.ImmutableList;

import org.easymock.Capture;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class AckDeadlineRenewerTest {

  private static final int MIN_DEADLINE_MILLISECONDS = 10_000;

  private static final String SUBSCRIPTION1 = "subscription1";
  private static final String SUBSCRIPTION2 = "subscription2";
  private static final String ACK_ID1 = "ack-id1";
  private static final String ACK_ID2 = "ack-id2";
  private static final String ACK_ID3 = "ack-id3";

  private final Capture<Runnable> renewRunnable = Capture.newInstance();
  private Clock clock;
  private PubSub pubsub;
  private ScheduledExecutorService executor;
  private ExecutorFactory executorFactory;
  private AckDeadlineRenewer ackDeadlineRenewer;
  private ScheduledFuture scheduledFuture;

  @Before
  public void setUp() {
    clock = EasyMock.createStrictMock(Clock.class);
    pubsub = EasyMock.createStrictMock(PubSub.class);
    executor = EasyMock.createStrictMock(ScheduledExecutorService.class);
    executorFactory = EasyMock.createStrictMock(ExecutorFactory.class);
    EasyMock.expect(executorFactory.get()).andReturn(executor);
    scheduledFuture = EasyMock.createStrictMock(ScheduledFuture.class);
    EasyMock.expect(executor.scheduleWithFixedDelay(EasyMock.capture(renewRunnable),
        EasyMock.eq(0L), EasyMock.eq(1L), EasyMock.same(TimeUnit.SECONDS)))
        .andReturn(scheduledFuture);
    PubSubOptions options = PubSubOptions.builder()
        .projectId("projectId")
        .clock(clock)
        .executorFactory(executorFactory)
        .build();
    EasyMock.expect(pubsub.options()).andReturn(options);
    EasyMock.replay(executor, executorFactory, scheduledFuture, pubsub);
    ackDeadlineRenewer = new AckDeadlineRenewer(pubsub);
    EasyMock.reset(pubsub);
  }

  @After
  public void tearDown() {
    EasyMock.verify(clock, pubsub, executor, executorFactory, scheduledFuture);
  }

  @Test
  public void testAddOneMessage() {
    EasyMock.expect(clock.millis()).andReturn(0L);
    EasyMock.expect(clock.millis()).andReturn(9_000L);
    EasyMock.expect(clock.millis()).andReturn(10_000L);
    EasyMock.expect(clock.millis()).andReturn(15_000L);
    EasyMock.expect(clock.millis()).andReturn(19_000L);
    EasyMock.expect(clock.millis()).andReturn(20_000L);
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION1, MIN_DEADLINE_MILLISECONDS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1))).andReturn(null);
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION1, MIN_DEADLINE_MILLISECONDS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1))).andReturn(null);
    EasyMock.replay(clock, pubsub);
    // Added for clock.millis() == 0
    ackDeadlineRenewer.add(SUBSCRIPTION1, ACK_ID1);
    // The following call is for clock.millis() == 9000, we renew the message
    renewRunnable.getValue().run();
    // The following call is for clock.millis() == 15_000, we don't renew the message
    renewRunnable.getValue().run();
    // The following call is for clock.millis() == 19_000, we renew the message
    renewRunnable.getValue().run();
  }

  @Test
  public void testAddMessages() {
    EasyMock.expect(clock.millis()).andReturn(0L).times(2);
    EasyMock.expect(clock.millis()).andReturn(9_000L).times(1);
    EasyMock.expect(clock.millis()).andReturn(10_000L).times(3);
    EasyMock.expect(clock.millis()).andReturn(10_500L);
    EasyMock.expect(clock.millis()).andReturn(15_000L);
    EasyMock.expect(clock.millis()).andReturn(19_000L);
    EasyMock.expect(clock.millis()).andReturn(20_000L).times(4);
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION1, MIN_DEADLINE_MILLISECONDS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1, ACK_ID2))).andReturn(null);
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION2, MIN_DEADLINE_MILLISECONDS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1))).andReturn(null);
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION1, MIN_DEADLINE_MILLISECONDS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1, ACK_ID2))).andReturn(null);
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION2, MIN_DEADLINE_MILLISECONDS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1, ACK_ID3))).andReturn(null);
    EasyMock.replay(clock, pubsub);
    // Added for clock.millis() == 0
    ackDeadlineRenewer.add(SUBSCRIPTION1, ImmutableList.of(ACK_ID1, ACK_ID2));
    ackDeadlineRenewer.add(SUBSCRIPTION2, ACK_ID1);
    renewRunnable.getValue().run();
    // Added for clock.millis() == 10_500
    ackDeadlineRenewer.add(SUBSCRIPTION2, ACK_ID3);
    // The following call is for clock.millis() == 15_000, no messages are renewed
    renewRunnable.getValue().run();
    // The following call is for clock.millis() == 19_000, we renew old messages and the new one
    renewRunnable.getValue().run();
  }

  @Test
  public void testAddExistingMessage() {
    EasyMock.expect(clock.millis()).andReturn(0L).times(2);
    EasyMock.expect(clock.millis()).andReturn(9_000L).times(1);
    EasyMock.expect(clock.millis()).andReturn(10_000L).times(3);
    EasyMock.expect(clock.millis()).andReturn(14_000L);
    EasyMock.expect(clock.millis()).andReturn(15_000L);
    EasyMock.expect(clock.millis()).andReturn(19_000L);
    EasyMock.expect(clock.millis()).andReturn(20_000L).times(2);
    EasyMock.expect(clock.millis()).andReturn(24_000L);
    EasyMock.expect(clock.millis()).andReturn(34_000L).times(1);
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION1, MIN_DEADLINE_MILLISECONDS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1, ACK_ID2))).andReturn(null);
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION2, MIN_DEADLINE_MILLISECONDS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1))).andReturn(null);
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION1, MIN_DEADLINE_MILLISECONDS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID2))).andReturn(null);
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION2, MIN_DEADLINE_MILLISECONDS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1))).andReturn(null);
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION1, MIN_DEADLINE_MILLISECONDS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1))).andReturn(null);
    EasyMock.replay(clock, pubsub);
    // Added for clock.millis() == 0
    ackDeadlineRenewer.add(SUBSCRIPTION1, ImmutableList.of(ACK_ID1, ACK_ID2));
    ackDeadlineRenewer.add(SUBSCRIPTION2, ACK_ID1);
    renewRunnable.getValue().run();
    // Added again for clock.millis() == 14_000
    ackDeadlineRenewer.add(SUBSCRIPTION1, ACK_ID1);
    // The following call is for clock.millis() == 15_000, no messages are renewed
    renewRunnable.getValue().run();
    // The following call is for clock.millis() == 19_000, we renew old messages but the updated one
    renewRunnable.getValue().run();
    // The following call is for clock.millis() == 24_000, wre renew the updated message
    renewRunnable.getValue().run();
  }

  @Test
  public void testRemoveNonExistingMessage() {
    EasyMock.expect(clock.millis()).andReturn(0L).times(2);
    EasyMock.expect(clock.millis()).andReturn(9_000L).times(1);
    EasyMock.expect(clock.millis()).andReturn(10_000L).times(3);
    EasyMock.expect(clock.millis()).andReturn(15_000L);
    EasyMock.expect(clock.millis()).andReturn(19_000L);
    EasyMock.expect(clock.millis()).andReturn(20_000L).times(3);
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION1, MIN_DEADLINE_MILLISECONDS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1, ACK_ID2))).andReturn(null);
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION2, MIN_DEADLINE_MILLISECONDS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1))).andReturn(null);
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION1, MIN_DEADLINE_MILLISECONDS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1, ACK_ID2))).andReturn(null);
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION2, MIN_DEADLINE_MILLISECONDS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1))).andReturn(null);
    EasyMock.replay(clock, pubsub);
    // Added for clock.millis() == 0
    ackDeadlineRenewer.add(SUBSCRIPTION1, ImmutableList.of(ACK_ID1, ACK_ID2));
    ackDeadlineRenewer.add(SUBSCRIPTION2, ACK_ID1);
    renewRunnable.getValue().run();
    // Remove a message
    ackDeadlineRenewer.remove(SUBSCRIPTION1, ACK_ID3);
    // The following call is for clock.millis() == 15_000, no messages are renewed
    renewRunnable.getValue().run();
    // The following call is for clock.millis() == 19_000, we renew old messages
    renewRunnable.getValue().run();
  }

  @Test
  public void testRemoveMessage() {
    EasyMock.expect(clock.millis()).andReturn(0L).times(2);
    EasyMock.expect(clock.millis()).andReturn(9_000L).times(1);
    EasyMock.expect(clock.millis()).andReturn(10_000L).times(3);
    EasyMock.expect(clock.millis()).andReturn(15_000L);
    EasyMock.expect(clock.millis()).andReturn(19_000L);
    EasyMock.expect(clock.millis()).andReturn(20_000L).times(2);
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION1, MIN_DEADLINE_MILLISECONDS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1, ACK_ID2))).andReturn(null);
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION2, MIN_DEADLINE_MILLISECONDS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1))).andReturn(null);
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION1, MIN_DEADLINE_MILLISECONDS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1))).andReturn(null);
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION2, MIN_DEADLINE_MILLISECONDS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1))).andReturn(null);
    EasyMock.replay(clock, pubsub);
    // Added for clock.millis() == 0
    ackDeadlineRenewer.add(SUBSCRIPTION1, ImmutableList.of(ACK_ID1, ACK_ID2));
    ackDeadlineRenewer.add(SUBSCRIPTION2, ACK_ID1);
    renewRunnable.getValue().run();
    // Remove a message
    ackDeadlineRenewer.remove(SUBSCRIPTION1, ACK_ID2);
    // The following call is for clock.millis() == 15_000, no messages are renewed
    renewRunnable.getValue().run();
    // The following call is for clock.millis() == 19_000, we renew old messages
    renewRunnable.getValue().run();
  }

  @Test
  public void testClose() throws Exception {
    EasyMock.reset(scheduledFuture, executorFactory);
    EasyMock.expect(scheduledFuture.cancel(false)).andReturn(true);
    executorFactory.release(executor);
    EasyMock.expectLastCall();
    EasyMock.replay(clock, pubsub, scheduledFuture, executorFactory);
    ackDeadlineRenewer.close();
  }
}
