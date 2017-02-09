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

package com.google.cloud.pubsub.deprecated;

import static org.junit.Assert.assertTrue;

import com.google.cloud.GrpcServiceOptions.ExecutorFactory;
import com.google.cloud.pubsub.spi.v1.FakeScheduledExecutorService;
import com.google.common.collect.ImmutableList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.easymock.EasyMock;
import org.easymock.IAnswer;
import org.joda.time.Duration;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class AckDeadlineRenewerTest {

  private static final int MIN_DEADLINE_MILLIS = 10_000;
  private static final Duration TIME_ADVANCE = Duration.millis(9_000);

  private static final String SUBSCRIPTION1 = "subscription1";
  private static final String SUBSCRIPTION2 = "subscription2";
  private static final String ACK_ID1 = "ack-id1";
  private static final String ACK_ID2 = "ack-id2";
  private static final String ACK_ID3 = "ack-id3";

  private PubSub pubsub;
  private FakeScheduledExecutorService executorService;
  private AckDeadlineRenewer ackDeadlineRenewer;

  @Rule
  public Timeout globalTimeout = Timeout.seconds(60);

  @Before
  public void setUp() {
    pubsub = EasyMock.createStrictMock(PubSub.class);
    executorService = new FakeScheduledExecutorService();
    ExecutorFactory executorFactory = new ExecutorFactory() {
      @Override
      public ExecutorService get() {
        return executorService;
      }
      @Override
      public void release(ExecutorService executor) {
        executorService.shutdown();
      }
    };
    PubSubOptions options =
        PubSubOptions.newBuilder()
            .setProjectId("projectId")
            .setExecutorFactory(executorFactory)
            .setClock(executorService.getClock())
            .build();
    EasyMock.expect(pubsub.getOptions()).andReturn(options);
    EasyMock.replay(pubsub);
    ackDeadlineRenewer = new AckDeadlineRenewer(pubsub);
  }

  @After
  public void tearDown() throws Exception {
    EasyMock.verify(pubsub);
    ackDeadlineRenewer.close();
  }

  private IAnswer<Future<Void>> createAnswer(final CountDownLatch latch,
      final AtomicLong renewal) {
    return new IAnswer<Future<Void>>() {
      @Override
      public Future<Void> answer() throws Throwable {
        latch.countDown();
        renewal.set(executorService.getClock().millis());
        return null;
      }
    };
  }

  @Test
  public void testAddOneMessage() throws InterruptedException {
    EasyMock.reset(pubsub);
    final CountDownLatch firstLatch = new CountDownLatch(1);
    final CountDownLatch secondLatch = new CountDownLatch(1);
    final AtomicLong firstRenewal = new AtomicLong();
    final AtomicLong secondRenewal = new AtomicLong();
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION1, MIN_DEADLINE_MILLIS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1)))
            .andAnswer(createAnswer(firstLatch, firstRenewal));
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION1, MIN_DEADLINE_MILLIS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1)))
            .andAnswer(createAnswer(secondLatch, secondRenewal));
    EasyMock.replay(pubsub);
    long addTime = executorService.getClock().millis();
    ackDeadlineRenewer.add(SUBSCRIPTION1, ACK_ID1);
    executorService.advanceTime(TIME_ADVANCE);
    firstLatch.await();
    assertTrue(firstRenewal.get() < (addTime + MIN_DEADLINE_MILLIS));
    executorService.advanceTime(TIME_ADVANCE);
    secondLatch.await();
    assertTrue(secondRenewal.get() < (firstRenewal.get() + MIN_DEADLINE_MILLIS));
  }

  @Test
  public void testAddMessages() throws InterruptedException {
    EasyMock.reset(pubsub);
    final CountDownLatch firstLatch = new CountDownLatch(2);
    final CountDownLatch secondLatch = new CountDownLatch(2);
    final AtomicLong firstRenewalSub1 = new AtomicLong();
    final AtomicLong firstRenewalSub2 = new AtomicLong();
    final AtomicLong secondRenewalSub1 = new AtomicLong();
    final AtomicLong secondRenewalSub2 = new AtomicLong();
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION1, MIN_DEADLINE_MILLIS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1, ACK_ID2)))
            .andAnswer(createAnswer(firstLatch, firstRenewalSub1));
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION2, MIN_DEADLINE_MILLIS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1)))
            .andAnswer(createAnswer(firstLatch, firstRenewalSub2));
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION1, MIN_DEADLINE_MILLIS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1, ACK_ID2)))
            .andAnswer(createAnswer(secondLatch, secondRenewalSub1));
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION2, MIN_DEADLINE_MILLIS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1, ACK_ID3)))
            .andAnswer(createAnswer(secondLatch, secondRenewalSub2));
    EasyMock.replay(pubsub);
    long addTime1 = executorService.getClock().millis();
    ackDeadlineRenewer.add(SUBSCRIPTION1, ImmutableList.of(ACK_ID1, ACK_ID2));
    ackDeadlineRenewer.add(SUBSCRIPTION2, ACK_ID1);
    executorService.advanceTime(TIME_ADVANCE);
    firstLatch.await();
    assertTrue(firstRenewalSub1.get() < (addTime1 + MIN_DEADLINE_MILLIS));
    assertTrue(firstRenewalSub2.get() < (addTime1 + MIN_DEADLINE_MILLIS));
    ackDeadlineRenewer.add(SUBSCRIPTION2, ACK_ID3);
    executorService.advanceTime(TIME_ADVANCE);
    secondLatch.await();
    assertTrue(secondRenewalSub1.get() < (firstRenewalSub1.get() + MIN_DEADLINE_MILLIS));
    assertTrue(secondRenewalSub2.get() < (firstRenewalSub2.get() + MIN_DEADLINE_MILLIS));
  }

  @Test
  public void testAddExistingMessage() throws InterruptedException {
    EasyMock.reset(pubsub);
    final CountDownLatch firstLatch = new CountDownLatch(2);
    final CountDownLatch secondLatch = new CountDownLatch(2);
    final AtomicLong firstRenewalSub1 = new AtomicLong();
    final AtomicLong firstRenewalSub2 = new AtomicLong();
    final AtomicLong secondRenewalSub1 = new AtomicLong();
    final AtomicLong secondRenewalSub2 = new AtomicLong();
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION1, MIN_DEADLINE_MILLIS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1, ACK_ID2)))
        .andAnswer(createAnswer(firstLatch, firstRenewalSub1));
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION2, MIN_DEADLINE_MILLIS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1)))
        .andAnswer(createAnswer(firstLatch, firstRenewalSub2));
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION1, MIN_DEADLINE_MILLIS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1, ACK_ID2)))
        .andAnswer(createAnswer(secondLatch, secondRenewalSub1));
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION2, MIN_DEADLINE_MILLIS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1)))
        .andAnswer(createAnswer(secondLatch, secondRenewalSub2));
    EasyMock.replay(pubsub);
    long addTime1 = executorService.getClock().millis();
    ackDeadlineRenewer.add(SUBSCRIPTION1, ImmutableList.of(ACK_ID1, ACK_ID2));
    ackDeadlineRenewer.add(SUBSCRIPTION2, ACK_ID1);
    executorService.advanceTime(TIME_ADVANCE);
    firstLatch.await();
    assertTrue(firstRenewalSub1.get() < (addTime1 + MIN_DEADLINE_MILLIS));
    assertTrue(firstRenewalSub2.get() < (addTime1 + MIN_DEADLINE_MILLIS));
    ackDeadlineRenewer.add(SUBSCRIPTION2, ACK_ID1);
    executorService.advanceTime(TIME_ADVANCE);
    secondLatch.await();
    assertTrue(secondRenewalSub1.get() < (firstRenewalSub1.get() + MIN_DEADLINE_MILLIS));
    assertTrue(secondRenewalSub2.get() < (firstRenewalSub2.get() + MIN_DEADLINE_MILLIS));
  }

  @Test
  public void testRemoveNonExistingMessage() throws InterruptedException {
    EasyMock.reset(pubsub);
    final CountDownLatch firstLatch = new CountDownLatch(2);
    final CountDownLatch secondLatch = new CountDownLatch(2);
    final AtomicLong firstRenewalSub1 = new AtomicLong();
    final AtomicLong firstRenewalSub2 = new AtomicLong();
    final AtomicLong secondRenewalSub1 = new AtomicLong();
    final AtomicLong secondRenewalSub2 = new AtomicLong();
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION1, MIN_DEADLINE_MILLIS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1, ACK_ID2)))
        .andAnswer(createAnswer(firstLatch, firstRenewalSub1));
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION2, MIN_DEADLINE_MILLIS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1)))
        .andAnswer(createAnswer(firstLatch, firstRenewalSub2));
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION1, MIN_DEADLINE_MILLIS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1, ACK_ID2)))
        .andAnswer(createAnswer(secondLatch, secondRenewalSub1));
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION2, MIN_DEADLINE_MILLIS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1)))
        .andAnswer(createAnswer(secondLatch, secondRenewalSub2));
    EasyMock.replay(pubsub);
    long addTime1 = executorService.getClock().millis();
    ackDeadlineRenewer.add(SUBSCRIPTION1, ImmutableList.of(ACK_ID1, ACK_ID2));
    ackDeadlineRenewer.add(SUBSCRIPTION2, ACK_ID1);
    executorService.advanceTime(TIME_ADVANCE);
    firstLatch.await();
    assertTrue(firstRenewalSub1.get() < (addTime1 + MIN_DEADLINE_MILLIS));
    assertTrue(firstRenewalSub2.get() < (addTime1 + MIN_DEADLINE_MILLIS));
    ackDeadlineRenewer.remove(SUBSCRIPTION1, ACK_ID3);
    executorService.advanceTime(TIME_ADVANCE);
    secondLatch.await();
    assertTrue(secondRenewalSub1.get() < (firstRenewalSub1.get() + MIN_DEADLINE_MILLIS));
    assertTrue(secondRenewalSub2.get() < (firstRenewalSub2.get() + MIN_DEADLINE_MILLIS));
  }

  @Test
  public void testRemoveMessage() throws InterruptedException {
    EasyMock.reset(pubsub);
    final CountDownLatch firstLatch = new CountDownLatch(2);
    final CountDownLatch secondLatch = new CountDownLatch(2);
    final AtomicLong firstRenewalSub1 = new AtomicLong();
    final AtomicLong firstRenewalSub2 = new AtomicLong();
    final AtomicLong secondRenewalSub1 = new AtomicLong();
    final AtomicLong secondRenewalSub2 = new AtomicLong();
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION1, MIN_DEADLINE_MILLIS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1, ACK_ID2)))
        .andAnswer(createAnswer(firstLatch, firstRenewalSub1));
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION2, MIN_DEADLINE_MILLIS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1)))
        .andAnswer(createAnswer(firstLatch, firstRenewalSub2));
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION1, MIN_DEADLINE_MILLIS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1)))
        .andAnswer(createAnswer(secondLatch, secondRenewalSub1));
    EasyMock.expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION2, MIN_DEADLINE_MILLIS,
        TimeUnit.MILLISECONDS, ImmutableList.of(ACK_ID1)))
        .andAnswer(createAnswer(secondLatch, secondRenewalSub2));
    EasyMock.replay(pubsub);
    long addTime1 = executorService.getClock().millis();
    ackDeadlineRenewer.add(SUBSCRIPTION1, ImmutableList.of(ACK_ID1, ACK_ID2));
    ackDeadlineRenewer.add(SUBSCRIPTION2, ACK_ID1);
    executorService.advanceTime(TIME_ADVANCE);
    firstLatch.await();
    assertTrue(firstRenewalSub1.get() < (addTime1 + MIN_DEADLINE_MILLIS));
    assertTrue(firstRenewalSub2.get() < (addTime1 + MIN_DEADLINE_MILLIS));
    ackDeadlineRenewer.remove(SUBSCRIPTION1, ACK_ID2);
    executorService.advanceTime(TIME_ADVANCE);
    secondLatch.await();
    assertTrue(secondRenewalSub1.get() < (firstRenewalSub1.get() + MIN_DEADLINE_MILLIS));
    assertTrue(secondRenewalSub2.get() < (firstRenewalSub2.get() + MIN_DEADLINE_MILLIS));
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testClose() throws Exception {
    PubSub pubsub = EasyMock.createStrictMock(PubSub.class);
    ScheduledExecutorService executor = EasyMock.createStrictMock(ScheduledExecutorService.class);
    ExecutorFactory executorFactory = EasyMock.createStrictMock(ExecutorFactory.class);
    EasyMock.expect(executorFactory.get()).andReturn(executor);
    PubSubOptions options = PubSubOptions.newBuilder()
        .setProjectId("projectId")
        .setExecutorFactory(executorFactory)
        .build();
    EasyMock.expect(pubsub.getOptions()).andReturn(options);
    executorFactory.release(executor);
    EasyMock.expectLastCall();
    EasyMock.replay(executor, executorFactory, pubsub);
    AckDeadlineRenewer ackDeadlineRenewer = new AckDeadlineRenewer(pubsub);
    ackDeadlineRenewer.close();
    EasyMock.verify(pubsub, executor, executorFactory);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testCloseWithMessage() throws Exception {
    PubSub pubsub = EasyMock.createStrictMock(PubSub.class);
    ScheduledExecutorService executor = EasyMock.createStrictMock(ScheduledExecutorService.class);
    ExecutorFactory executorFactory = EasyMock.createStrictMock(ExecutorFactory.class);
    EasyMock.expect(executorFactory.get()).andReturn(executor);
    ScheduledFuture future = EasyMock.createStrictMock(ScheduledFuture.class);
    EasyMock.expect(executor.schedule(EasyMock.<Runnable>anyObject(), EasyMock.anyLong(),
        EasyMock.eq(TimeUnit.MILLISECONDS))).andReturn(future);
    PubSubOptions options = PubSubOptions.newBuilder()
        .setProjectId("projectId")
        .setExecutorFactory(executorFactory)
        .build();
    EasyMock.expect(pubsub.getOptions()).andReturn(options);
    EasyMock.expect(future.cancel(true)).andReturn(true);
    executorFactory.release(executor);
    EasyMock.expectLastCall();
    EasyMock.replay(executor, executorFactory, future, pubsub);
    AckDeadlineRenewer ackDeadlineRenewer = new AckDeadlineRenewer(pubsub);
    ackDeadlineRenewer.add(SUBSCRIPTION1, ACK_ID1);
    ackDeadlineRenewer.close();
    EasyMock.verify(pubsub, executor, executorFactory, future);
  }
}
