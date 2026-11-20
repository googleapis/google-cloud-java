/*
 * Copyright 2026 Google LLC
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.api.core.AbstractApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.pubsub.v1.ProjectTopicName;
import com.google.pubsub.v1.PublishResponse;
import io.grpc.ManagedChannel;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CancellationSharerTest {
  private ManagedChannel channel;
  private Publisher publisher;
  private ExecutorService executor;
  private CancellationSharer coordinator;

  @Before
  public void setUp() throws Exception {
    // The coordinator only uses local futures. No RPCs are sent.
    channel = InProcessChannelBuilder.forName(InProcessServerBuilder.generateName()).build();
    publisher =
        Publisher.newBuilder(ProjectTopicName.of("test-project", "test-topic"))
            .setChannelProvider(
                FixedTransportChannelProvider.create(GrpcTransportChannel.create(channel)))
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    executor = Executors.newFixedThreadPool(2);
    coordinator =
        new CancellationSharer(
            publisher.new OutstandingBatch(Collections.emptyList(), 0, ""), publisher, 0);
  }

  @After
  public void tearDown() {
    if (executor != null) {
      executor.shutdownNow();
    }
    if (publisher != null) {
      publisher.shutdown();
    }
    if (channel != null) {
      channel.shutdownNow();
    }
  }

  @Test
  public void testSuccessfulPublishReleasesBatchLockBeforeCancellingHedge() throws Exception {
    SettableApiFuture<PublishResponse> original = SettableApiFuture.create();
    BlockingCancellationFuture hedge = new BlockingCancellationFuture();
    coordinator.addAttempt(0, original);
    coordinator.addAttempt(1, hedge);
    PublishResponse response = PublishResponse.newBuilder().addMessageIds("1").build();

    assertBatchInactiveDuringCancellation(hedge, () -> original.set(response));

    assertEquals(response, coordinator.get(5, TimeUnit.SECONDS));
  }

  @Test
  public void testCallerCancellationReleasesBatchLockBeforeCancellingAttempt() throws Exception {
    BlockingCancellationFuture original = new BlockingCancellationFuture();
    coordinator.addAttempt(0, original);

    assertBatchInactiveDuringCancellation(original, () -> coordinator.cancel(false));

    assertTrue(coordinator.isCancelled());
    assertFalse(coordinator.cancel(false));
  }

  private void assertBatchInactiveDuringCancellation(
      BlockingCancellationFuture attempt, Callable<Boolean> complete) throws Exception {
    Future<Boolean> completion = executor.submit(complete);
    try {
      assertTrue(
          "The attempt should be cancelled",
          attempt.cancellationStarted.await(5, TimeUnit.SECONDS));
      Future<Publisher.OutstandingBatch> batch = executor.submit(coordinator::getBatchIfActive);
      assertNull(batch.get(5, TimeUnit.SECONDS));
    } finally {
      attempt.finishCancellation.countDown();
    }
    assertTrue(completion.get(5, TimeUnit.SECONDS));
    assertTrue(attempt.isCancelled());
  }

  private static final class BlockingCancellationFuture extends AbstractApiFuture<PublishResponse> {
    final CountDownLatch cancellationStarted = new CountDownLatch(1);
    final CountDownLatch finishCancellation = new CountDownLatch(1);

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
      cancellationStarted.countDown();
      try {
        finishCancellation.await();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        return false;
      }
      return super.cancel(mayInterruptIfRunning);
    }
  }
}
