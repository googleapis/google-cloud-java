/*
 * Copyright 2023 Google LLC
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
package com.google.cloud.spanner;

import static com.google.cloud.spanner.MockSpannerTestUtil.READ_ONE_KEY_VALUE_RESULTSET;
import static com.google.cloud.spanner.MockSpannerTestUtil.READ_ONE_KEY_VALUE_STATEMENT;
import static com.google.cloud.spanner.MockSpannerTestUtil.SELECT1;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assume.assumeFalse;

import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Server;
import io.grpc.inprocess.InProcessServerBuilder;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Category(SlowTest.class)
@RunWith(JUnit4.class)
public class BatchCreateSessionsSlowTest {
  private static final String TEST_PROJECT = "my-project";
  private static final String TEST_DATABASE_ROLE = "my-role";
  private static MockSpannerServiceImpl mockSpanner;
  private static Server server;
  private static LocalChannelProvider channelProvider;
  private Spanner spanner;

  @BeforeClass
  public static void startStaticServer() throws Exception {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D); // We don't want any unpredictable aborted transactions.
    mockSpanner.putStatementResult(
        StatementResult.query(SELECT1, MockSpannerTestUtil.SELECT1_RESULTSET));
    mockSpanner.putStatementResult(
        StatementResult.query(READ_ONE_KEY_VALUE_STATEMENT, READ_ONE_KEY_VALUE_RESULTSET));

    String uniqueName = InProcessServerBuilder.generateName();
    server =
        InProcessServerBuilder.forName(uniqueName)
            // We need to use a real executor for timeouts to occur.
            .scheduledExecutorService(new ScheduledThreadPoolExecutor(1))
            .addService(mockSpanner)
            .build()
            .start();
    channelProvider = LocalChannelProvider.create(uniqueName);
  }

  @AfterClass
  public static void stopServer() throws InterruptedException {
    server.shutdown();
    server.awaitTermination();
  }

  @Before
  public void setUp() {
    SessionPoolOptions sessionPoolOptions =
        SessionPoolOptions.newBuilder().setFailOnSessionLeak().build();
    spanner =
        SpannerOptions.newBuilder()
            .setProjectId(TEST_PROJECT)
            .setDatabaseRole(TEST_DATABASE_ROLE)
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance())
            .setSessionPoolOption(sessionPoolOptions)
            .build()
            .getService();
    // BatchCreateSessions RPC is not invoked when multiplexed sessions is enabled and just RO
    // transactions is used.
    // Use a different transaction shape (for ex - RW transactions) which is presently unsupported
    // with multiplexed sessions.
    assumeFalse(sessionPoolOptions.getUseMultiplexedSession());
  }

  @After
  public void tearDown() {
    mockSpanner.unfreeze();
    spanner.close();
    mockSpanner.reset();
    mockSpanner.removeAllExecutionTimes();
  }

  @Test
  public void testBatchCreateSessionsTimesOut_whenDeadlineExceeded() throws Exception {
    // Simulate a minimum execution time of 1000 milliseconds for the BatchCreateSessions RPC.
    mockSpanner.setBatchCreateSessionsExecutionTime(
        SimulatedExecutionTime.ofMinimumAndRandomTime(1000, 0));
    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder()
            .setProjectId("my-project")
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance());
    // Set the timeout and retry settings for BatchCreateSessions to a simple
    // single-attempt-and-timeout after 100ms.
    builder
        .getSpannerStubSettingsBuilder()
        .batchCreateSessionsSettings()
        .setSimpleTimeoutNoRetriesDuration(Duration.ofMillis(100));

    try (Spanner spanner = builder.build().getService()) {
      DatabaseId databaseId = DatabaseId.of("my-project", "my-instance", "my-database");
      DatabaseClient client = spanner.getDatabaseClient(databaseId);

      ListeningExecutorService service =
          MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(1000));
      List<ListenableFuture<Void>> futures = new ArrayList<>(5000);
      AtomicInteger counter = new AtomicInteger();
      for (int i = 0; i < 5000; i++) {
        final int index = i;
        futures.add(
            service.submit(
                () -> {
                  // The following call is non-blocking and will not generate an exception.
                  ResultSet rs = client.singleUse().executeQuery(SELECT1);
                  // Actually trying to get any results will cause an exception.
                  // The DEADLINE_EXCEEDED error of the BatchCreateSessions RPC is in this case
                  // propagated to
                  // the application.
                  SpannerException e = assertThrows(SpannerException.class, rs::next);
                  assertEquals(ErrorCode.DEADLINE_EXCEEDED, e.getErrorCode());
                  System.out.printf("finished test %d\n", counter.incrementAndGet());

                  return null;
                }));
      }
      service.shutdown();
      assertEquals(5000, Futures.allAsList(futures).get().size());
    }
  }

  @Test
  public void testBatchCreateSessionsTimesOut_whenResourceExhausted() throws Exception {
    // Simulate a minimum execution time of 2000 milliseconds for the BatchCreateSessions RPC.
    mockSpanner.setBatchCreateSessionsExecutionTime(
        SimulatedExecutionTime.ofMinimumAndRandomTime(2000, 0));
    // Add a timeout for the max amount of time (60ms) that a request waits when a session is
    // unavailable.
    SessionPoolOptions sessionPoolOptions =
        SessionPoolOptions.newBuilder()
            .setAcquireSessionTimeoutDuration(Duration.ofMillis(60))
            .build();
    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder()
            .setProjectId("my-project")
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance())
            .setSessionPoolOption(sessionPoolOptions);
    // Set the timeout and retry settings for BatchCreateSessions to a simple
    // single-attempt-and-timeout after 1000ms. This will ensure that session acquisition timeout of
    // 60ms will kick for all requests before the overall request RPC timeout is breached.
    builder
        .getSpannerStubSettingsBuilder()
        .batchCreateSessionsSettings()
        .setSimpleTimeoutNoRetriesDuration(Duration.ofMillis(1000));

    try (Spanner spanner = builder.build().getService()) {
      DatabaseId databaseId = DatabaseId.of("my-project", "my-instance", "my-database");
      DatabaseClient client = spanner.getDatabaseClient(databaseId);

      ListeningExecutorService service =
          MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(1000));
      List<ListenableFuture<Void>> futures = new ArrayList<>(5000);
      AtomicInteger counter = new AtomicInteger();
      for (int i = 0; i < 5000; i++) {
        futures.add(
            service.submit(
                () -> {
                  // The following call is non-blocking and will not generate an exception.
                  ResultSet rs = client.singleUse().executeQuery(SELECT1);
                  // Actually trying to get any results will cause an exception.
                  // When number of requests > MAX_SESSIONS, post setAcquireSessionTimeout
                  // a few requests will timeout with RESOURCE_EXHAUSTED error.
                  SpannerException e = assertThrows(SpannerException.class, rs::next);
                  assertEquals(ErrorCode.RESOURCE_EXHAUSTED, e.getErrorCode());
                  System.out.printf("finished test %d\n", counter.incrementAndGet());

                  return null;
                }));
      }
      service.shutdown();
      assertEquals(5000, Futures.allAsList(futures).get().size());
    }
  }
}
