/*
 * Copyright 2019 Google LLC
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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.TransactionRunner.TransactionCallable;
import com.google.common.base.Stopwatch;
import com.google.protobuf.ListValue;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.TypeCode;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.inprocess.InProcessServerBuilder;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BatchCreateSessionsTest {
  private static final Statement SELECT1AND2 =
      Statement.of("SELECT 1 AS COL1 UNION ALL SELECT 2 AS COL1");
  private static final ResultSetMetadata SELECT1AND2_METADATA =
      ResultSetMetadata.newBuilder()
          .setRowType(
              StructType.newBuilder()
                  .addFields(
                      Field.newBuilder()
                          .setName("COL1")
                          .setType(
                              com.google.spanner.v1.Type.newBuilder()
                                  .setCode(TypeCode.INT64)
                                  .build())
                          .build())
                  .build())
          .build();
  private static final com.google.spanner.v1.ResultSet SELECT1_RESULTSET =
      com.google.spanner.v1.ResultSet.newBuilder()
          .addRows(
              ListValue.newBuilder()
                  .addValues(com.google.protobuf.Value.newBuilder().setStringValue("1").build())
                  .build())
          .addRows(
              ListValue.newBuilder()
                  .addValues(com.google.protobuf.Value.newBuilder().setStringValue("2").build())
                  .build())
          .setMetadata(SELECT1AND2_METADATA)
          .build();

  private static MockSpannerServiceImpl mockSpanner;
  private static Server server;
  private static LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D); // We don't want any unpredictable aborted transactions.
    mockSpanner.putStatementResult(StatementResult.query(SELECT1AND2, SELECT1_RESULTSET));

    String uniqueName = InProcessServerBuilder.generateName();
    server =
        InProcessServerBuilder.forName(uniqueName)
            .directExecutor()
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
  public void setUp() throws IOException {
    mockSpanner.reset();
  }

  private Spanner createSpanner(int minSessions, int maxSessions) {
    SessionPoolOptions sessionPoolOptions =
        SessionPoolOptions.newBuilder()
            .setMinSessions(minSessions)
            .setMaxSessions(maxSessions)
            .build();
    return SpannerOptions.newBuilder()
        .setProjectId("[PROJECT]")
        .setChannelProvider(channelProvider)
        .setSessionPoolOption(sessionPoolOptions)
        .setCredentials(NoCredentials.getInstance())
        .build()
        .getService();
  }

  @Test
  public void testCreatedMinSessions() throws InterruptedException {
    int minSessions = 1000;
    int maxSessions = 4000;
    try (Spanner spanner = createSpanner(minSessions, maxSessions)) {
      DatabaseClientImpl client =
          (DatabaseClientImpl)
              spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
      Stopwatch watch = Stopwatch.createStarted();
      while (client.pool.totalSessions() < minSessions && watch.elapsed(TimeUnit.SECONDS) < 10) {
        Thread.sleep(10L);
      }
      assertThat(client.pool.totalSessions(), is(equalTo(minSessions)));
    }
  }

  @Test
  public void testClosePoolWhileInitializing() throws InterruptedException {
    int minSessions = 10_000;
    int maxSessions = 10_000;
    DatabaseClientImpl client = null;
    // Freeze the server to prevent it from creating sessions before we want to.
    mockSpanner.freeze();
    try (Spanner spanner = createSpanner(minSessions, maxSessions)) {
      // Create a database client which will create a session pool.
      // No sessions will be created at the moment as the server is frozen.
      client =
          (DatabaseClientImpl)
              spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
      // Make sure session creation takes a little time to avoid all sessions being created at once.
      mockSpanner.setBatchCreateSessionsExecutionTime(
          SimulatedExecutionTime.ofMinimumAndRandomTime(10, 0));
      // Unfreeze the server to allow session creation to start.
      mockSpanner.unfreeze();
      // Wait until at least one batch of sessions has been created.
      Stopwatch watch = Stopwatch.createStarted();
      while (client.pool.totalSessions() == 0 && watch.elapsed(TimeUnit.SECONDS) < 10) {
        Thread.sleep(1L);
      }
      // Close the Spanner instance which will start to delete sessions while the session pool is
      // still being initialized.
    }
    // Verify that all sessions have been deleted.
    assertThat(client.pool.totalSessions(), is(equalTo(0)));
  }

  @Test
  public void testSpannerReturnsAllAvailableSessionsAndThenNoSessions()
      throws InterruptedException {
    int minSessions = 1000;
    int maxSessions = 1000;
    // Set a maximum number of sessions that will be created by the server.
    // After this the server will return an error when batchCreateSessions is called.
    // This error is not propagated to the client.
    int maxServerSessions = 550;
    DatabaseClientImpl client = null;
    mockSpanner.setMaxTotalSessions(maxServerSessions);
    try (Spanner spanner = createSpanner(minSessions, maxSessions)) {
      // Create a database client which will create a session pool.
      client =
          (DatabaseClientImpl)
              spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
      Stopwatch watch = Stopwatch.createStarted();
      while (client.pool.totalSessions() < maxServerSessions
          && watch.elapsed(TimeUnit.SECONDS) < 10) {
        Thread.sleep(10L);
      }
      assertThat(client.pool.totalSessions(), is(equalTo(maxServerSessions)));
      // Wait until the pool has given up creating sessions.
      watch = watch.reset();
      watch.start();
      while (client.pool.getNumberOfSessionsBeingCreated() > 0
          && watch.elapsed(TimeUnit.SECONDS) < 10) {
        Thread.sleep(10L);
      }
      // Remove the max server sessions limit.
      mockSpanner.setMaxTotalSessions(Integer.MAX_VALUE);
      // Wait a little. No more sessions should be created, as the previous requests have given up,
      // and no new sessions have been requested from the pool.
      Thread.sleep(20L);
      assertThat(client.pool.totalSessions(), is(equalTo(maxServerSessions)));
    }
    // Verify that all sessions have been deleted.
    assertThat(client.pool.totalSessions(), is(equalTo(0)));
  }

  @Test
  public void testSpannerReturnsResourceExhausted() throws InterruptedException {
    int minSessions = 100;
    int maxSessions = 1000;
    int expectedSessions = minSessions;
    DatabaseClientImpl client = null;
    // Make the first BatchCreateSessions return an error.
    mockSpanner.addException(Status.RESOURCE_EXHAUSTED.asRuntimeException());
    try (Spanner spanner = createSpanner(minSessions, maxSessions)) {
      // Create a database client which will create a session pool.
      client =
          (DatabaseClientImpl)
              spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
      // Wait for the pool to be initialized.
      // The first session creation request will fail.
      expectedSessions = minSessions - minSessions / spanner.getOptions().getNumChannels();
      Stopwatch watch = Stopwatch.createStarted();
      while (client.pool.totalSessions() < expectedSessions
          && watch.elapsed(TimeUnit.SECONDS) < 10) {
        Thread.sleep(10L);
      }
      // Wait a little to allow any additional session creation to finish.
      Thread.sleep(20L);
    }
    // Verify that all sessions have been deleted.
    assertThat(client.pool.totalSessions(), is(equalTo(0)));
  }

  @Test
  public void testPrepareSessionFailPropagatesToUser() throws InterruptedException {
    // Do not create any sessions by default.
    // This also means that when a read/write session is requested, the session pool
    // will start preparing a read session at that time. Any errors that might occur
    // during the BeginTransaction call will be propagated to the user.
    int minSessions = 0;
    int maxSessions = 1000;
    DatabaseClientImpl client = null;
    mockSpanner.setBeginTransactionExecutionTime(
        SimulatedExecutionTime.ofException(
            Status.ABORTED.withDescription("BeginTransaction failed").asRuntimeException()));
    try (Spanner spanner = createSpanner(minSessions, maxSessions)) {
      client =
          (DatabaseClientImpl)
              spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
      TransactionRunner runner = client.readWriteTransaction();
      runner.run(
          new TransactionCallable<Void>() {
            @Override
            public Void run(TransactionContext transaction) throws Exception {
              return null;
            }
          });
      fail("missing expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode(), is(equalTo(ErrorCode.ABORTED)));
      assertThat(e.getMessage().endsWith("BeginTransaction failed"), is(true));
    }
  }

  @Test
  public void testPrepareSessionFailDoesNotPropagateToUser() throws InterruptedException {
    // Create 5 sessions and 20% write prepared sessions.
    // That should prepare exactly 1 session for r/w.
    int minSessions = 5;
    int maxSessions = 1000;
    DatabaseClientImpl client = null;
    // The first prepare should fail.
    // The prepare will then be retried and should succeed.
    mockSpanner.setBeginTransactionExecutionTime(
        SimulatedExecutionTime.ofException(
            Status.ABORTED.withDescription("BeginTransaction failed").asRuntimeException()));
    try (Spanner spanner = createSpanner(minSessions, maxSessions)) {
      client =
          (DatabaseClientImpl)
              spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
      // Wait until the session pool has initialized and a session has been prepared.
      Stopwatch watch = Stopwatch.createStarted();
      while ((client.pool.totalSessions() < minSessions
              || client.pool.getNumberOfAvailableWritePreparedSessions() != 1)
          && watch.elapsed(TimeUnit.SECONDS) < 10) {
        Thread.sleep(10L);
      }

      // There should be 1 prepared session and a r/w transaction should succeed.
      assertThat(client.pool.getNumberOfAvailableWritePreparedSessions(), is(equalTo(1)));
      TransactionRunner runner = client.readWriteTransaction();
      runner.run(
          new TransactionCallable<Void>() {
            @Override
            public Void run(TransactionContext transaction) throws Exception {
              return null;
            }
          });
    }
  }
}
