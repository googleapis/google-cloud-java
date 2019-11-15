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

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
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
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class DatabaseClientImplTest {
  private static final String DATABASE_DOES_NOT_EXIST_MSG =
      "Database not found: projects/<project>/instances/<instance>/databases/<database> resource_type: \"type.googleapis.com/google.spanner.admin.database.v1.Database\" resource_name: \"projects/<project>/instances/<instance>/databases/<database>\" description: \"Database does not exist.\"";
  private static MockSpannerServiceImpl mockSpanner;
  private static Server server;
  private static LocalChannelProvider channelProvider;
  private static final Statement UPDATE_STATEMENT =
      Statement.of("UPDATE FOO SET BAR=1 WHERE BAZ=2");
  private static final Statement INVALID_UPDATE_STATEMENT =
      Statement.of("UPDATE NON_EXISTENT_TABLE SET BAR=1 WHERE BAZ=2");
  private static final long UPDATE_COUNT = 1L;
  private static final Statement SELECT1 = Statement.of("SELECT 1 AS COL1");
  private static final ResultSetMetadata SELECT1_METADATA =
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
          .setMetadata(SELECT1_METADATA)
          .build();
  private Spanner spanner;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D); // We don't want any unpredictable aborted transactions.
    mockSpanner.putStatementResult(StatementResult.update(UPDATE_STATEMENT, UPDATE_COUNT));
    mockSpanner.putStatementResult(StatementResult.query(SELECT1, SELECT1_RESULTSET));
    mockSpanner.putStatementResult(
        StatementResult.exception(
            INVALID_UPDATE_STATEMENT,
            Status.INVALID_ARGUMENT.withDescription("invalid statement").asRuntimeException()));

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
  public void setUp() throws IOException {
    spanner =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance())
            .build()
            .getService();
  }

  @After
  public void tearDown() throws Exception {
    spanner.close();
    mockSpanner.reset();
    mockSpanner.removeAllExecutionTimes();
  }

  /**
   * Test that the update statement can be executed as a partitioned transaction that returns a
   * lower bound update count.
   */
  @Test
  public void testExecutePartitionedDml() {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
    long updateCount = client.executePartitionedUpdate(UPDATE_STATEMENT);
    assertThat(updateCount, is(equalTo(UPDATE_COUNT)));
  }

  /** {@link AbortedException} should automatically be retried. */
  @Test
  public void testExecutePartitionedDmlAborted() {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
    mockSpanner.abortNextTransaction();
    long updateCount = client.executePartitionedUpdate(UPDATE_STATEMENT);
    assertThat(updateCount, is(equalTo(UPDATE_COUNT)));
  }

  /**
   * A valid query that returns a {@link ResultSet} should not be accepted by a partitioned dml
   * transaction.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testExecutePartitionedDmlWithQuery() {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
    client.executePartitionedUpdate(SELECT1);
  }

  /** Server side exceptions that are not {@link AbortedException}s should propagate to the user. */
  @Test(expected = SpannerException.class)
  public void testExecutePartitionedDmlWithException() {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
    client.executePartitionedUpdate(INVALID_UPDATE_STATEMENT);
  }

  @Test
  public void testPartitionedDmlDoesNotTimeout() throws Exception {
    mockSpanner.setExecuteSqlExecutionTime(SimulatedExecutionTime.ofMinimumAndRandomTime(10, 0));
    final RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRpcTimeout(Duration.ofMillis(1L))
            .setMaxRpcTimeout(Duration.ofMillis(1L))
            .setMaxAttempts(1)
            .setTotalTimeout(Duration.ofMillis(1L))
            .build();
    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance());
    // Set normal DML timeout value.
    builder.getSpannerStubSettingsBuilder().executeSqlSettings().setRetrySettings(retrySettings);
    try (Spanner spanner = builder.build().getService()) {
      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));

      assertThat(
          spanner.getOptions().getPartitionedDmlTimeout(), is(equalTo(Duration.ofHours(2L))));

      // PDML should not timeout with these settings.
      long updateCount = client.executePartitionedUpdate(UPDATE_STATEMENT);
      assertThat(updateCount, is(equalTo(UPDATE_COUNT)));

      // Normal DML should timeout.
      try {
        client
            .readWriteTransaction()
            .run(
                new TransactionCallable<Void>() {
                  @Override
                  public Void run(TransactionContext transaction) throws Exception {
                    transaction.executeUpdate(UPDATE_STATEMENT);
                    return null;
                  }
                });
        fail("expected DEADLINE_EXCEEDED");
      } catch (SpannerException e) {
        if (e.getErrorCode() != ErrorCode.DEADLINE_EXCEEDED) {
          fail("expected DEADLINE_EXCEEDED");
        }
      }
    }
  }

  @Test
  public void testPartitionedDmlWithTimeout() throws Exception {
    mockSpanner.setExecuteSqlExecutionTime(SimulatedExecutionTime.ofMinimumAndRandomTime(1000, 0));
    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance());
    // Set PDML timeout value.
    builder.setPartitionedDmlTimeout(Duration.ofMillis(100L));
    try (Spanner spanner = builder.build().getService()) {
      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
      assertThat(
          spanner.getOptions().getPartitionedDmlTimeout(), is(equalTo(Duration.ofMillis(100L))));
      // PDML should timeout with these settings.
      try {
        client.executePartitionedUpdate(UPDATE_STATEMENT);
        fail("expected DEADLINE_EXCEEDED");
      } catch (SpannerException e) {
        if (e.getErrorCode() != ErrorCode.DEADLINE_EXCEEDED) {
          fail("expected DEADLINE_EXCEEDED");
        }
      }

      // Normal DML should not timeout.
      mockSpanner.setExecuteSqlExecutionTime(SimulatedExecutionTime.ofMinimumAndRandomTime(10, 0));
      long updateCount =
          client
              .readWriteTransaction()
              .run(
                  new TransactionCallable<Long>() {
                    @Override
                    public Long run(TransactionContext transaction) throws Exception {
                      return transaction.executeUpdate(UPDATE_STATEMENT);
                    }
                  });
      assertThat(updateCount, is(equalTo(UPDATE_COUNT)));
    }
  }

  @Test
  public void testDatabaseDoesNotExistOnPrepareSession() throws Exception {
    mockSpanner.setBeginTransactionExecutionTime(
        SimulatedExecutionTime.ofStickyException(
            Status.NOT_FOUND.withDescription(DATABASE_DOES_NOT_EXIST_MSG).asRuntimeException()));
    DatabaseClientImpl dbClient =
        (DatabaseClientImpl)
            spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
    // Wait until all sessions have been created.
    Stopwatch watch = Stopwatch.createStarted();
    while (watch.elapsed(TimeUnit.SECONDS) < 5
        && dbClient.pool.getNumberOfSessionsBeingCreated() > 0) {
      Thread.sleep(1L);
    }
    // Ensure that no sessions could be prepared and that the session pool gives up trying to
    // prepare sessions.
    watch = watch.reset().start();
    while (watch.elapsed(TimeUnit.SECONDS) < 5
        && dbClient.pool.getNumberOfSessionsBeingPrepared() > 0) {
      Thread.sleep(1L);
    }
    assertThat(dbClient.pool.getNumberOfSessionsBeingPrepared(), is(equalTo(0)));
    assertThat(dbClient.pool.getNumberOfAvailableWritePreparedSessions(), is(equalTo(0)));
    try {
      dbClient
          .readWriteTransaction()
          .run(
              new TransactionCallable<Void>() {
                @Override
                public Void run(TransactionContext transaction) throws Exception {
                  return null;
                }
              });
      fail("missing expected NOT_FOUND exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode(), is(equalTo(ErrorCode.NOT_FOUND)));
      assertThat(e.getMessage(), containsString("Database not found"));
    }
  }

  @Test
  public void testDatabaseDoesNotExistOnInitialization() throws Exception {
    mockSpanner.setBatchCreateSessionsExecutionTime(
        SimulatedExecutionTime.ofStickyException(
            Status.NOT_FOUND.withDescription(DATABASE_DOES_NOT_EXIST_MSG).asRuntimeException()));
    DatabaseClientImpl dbClient =
        (DatabaseClientImpl)
            spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
    // Wait until session creation has finished.
    Stopwatch watch = Stopwatch.createStarted();
    while (watch.elapsed(TimeUnit.SECONDS) < 5
        && dbClient.pool.getNumberOfSessionsBeingCreated() > 0) {
      Thread.sleep(1L);
    }
    // All session creation should fail and stop trying.
    assertThat(dbClient.pool.getNumberOfSessionsInPool(), is(equalTo(0)));
    assertThat(dbClient.pool.getNumberOfSessionsBeingCreated(), is(equalTo(0)));
  }

  @Test
  public void testDatabaseDoesNotExistOnCreate() throws Exception {
    mockSpanner.setBatchCreateSessionsExecutionTime(
        SimulatedExecutionTime.ofStickyException(
            Status.NOT_FOUND.withDescription(DATABASE_DOES_NOT_EXIST_MSG).asRuntimeException()));
    // Ensure there are no sessions in the pool by default.
    try (Spanner spanner =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance())
            .setSessionPoolOption(SessionPoolOptions.newBuilder().setMinSessions(0).build())
            .build()
            .getService()) {
      DatabaseClientImpl dbClient =
          (DatabaseClientImpl)
              spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
      // The create session failure should propagate to the client and not retry.
      try (ResultSet rs = dbClient.singleUse().executeQuery(SELECT1)) {
        fail("missing expected exception");
      } catch (SpannerException e) {
        assertThat(e.getErrorCode(), is(equalTo(ErrorCode.NOT_FOUND)));
        assertThat(e.getMessage(), containsString(DATABASE_DOES_NOT_EXIST_MSG));
      }
      try {
        dbClient.readWriteTransaction();
        fail("missing expected exception");
      } catch (SpannerException e) {
        assertThat(e.getErrorCode(), is(equalTo(ErrorCode.NOT_FOUND)));
        assertThat(e.getMessage(), containsString(DATABASE_DOES_NOT_EXIST_MSG));
      }
    }
  }

  @Test
  public void testDatabaseDoesNotExistOnReplenish() throws Exception {
    mockSpanner.setBatchCreateSessionsExecutionTime(
        SimulatedExecutionTime.ofStickyException(
            Status.NOT_FOUND.withDescription(DATABASE_DOES_NOT_EXIST_MSG).asRuntimeException()));
    DatabaseClientImpl dbClient =
        (DatabaseClientImpl)
            spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
    // Wait until session creation has finished.
    Stopwatch watch = Stopwatch.createStarted();
    while (watch.elapsed(TimeUnit.SECONDS) < 5
        && dbClient.pool.getNumberOfSessionsBeingCreated() > 0) {
      Thread.sleep(1L);
    }
    // All session creation should fail and stop trying.
    assertThat(dbClient.pool.getNumberOfSessionsInPool(), is(equalTo(0)));
    assertThat(dbClient.pool.getNumberOfSessionsBeingCreated(), is(equalTo(0)));
    // Force a maintainer run. This should schedule new session creation.
    dbClient.pool.poolMaintainer.maintainPool();
    // Wait until the replenish has finished.
    watch = watch.reset().start();
    while (watch.elapsed(TimeUnit.SECONDS) < 5
        && dbClient.pool.getNumberOfSessionsBeingCreated() > 0) {
      Thread.sleep(1L);
    }
    // All session creation from replenishPool should fail and stop trying.
    assertThat(dbClient.pool.getNumberOfSessionsInPool(), is(equalTo(0)));
    assertThat(dbClient.pool.getNumberOfSessionsBeingCreated(), is(equalTo(0)));
  }

  @Test
  public void testPermissionDeniedOnPrepareSession() throws Exception {
    mockSpanner.setBeginTransactionExecutionTime(
        SimulatedExecutionTime.ofStickyException(
            Status.PERMISSION_DENIED
                .withDescription(
                    "Caller is missing IAM permission spanner.databases.beginOrRollbackReadWriteTransaction on resource")
                .asRuntimeException()));
    DatabaseClientImpl dbClient =
        (DatabaseClientImpl)
            spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
    // Wait until all sessions have been created.
    Stopwatch watch = Stopwatch.createStarted();
    while (watch.elapsed(TimeUnit.SECONDS) < 5
        && dbClient.pool.getNumberOfSessionsBeingCreated() > 0) {
      Thread.sleep(1L);
    }
    // Ensure that no sessions could be prepared and that the session pool gives up trying to
    // prepare sessions.
    watch = watch.reset().start();
    while (watch.elapsed(TimeUnit.SECONDS) < 5
        && dbClient.pool.getNumberOfSessionsBeingPrepared() > 0) {
      Thread.sleep(1L);
    }
    assertThat(dbClient.pool.getNumberOfSessionsBeingPrepared(), is(equalTo(0)));
    assertThat(dbClient.pool.getNumberOfAvailableWritePreparedSessions(), is(equalTo(0)));
    try {
      dbClient
          .readWriteTransaction()
          .run(
              new TransactionCallable<Void>() {
                @Override
                public Void run(TransactionContext transaction) throws Exception {
                  return null;
                }
              });
      fail("missing expected PERMISSION_DENIED exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode(), is(equalTo(ErrorCode.PERMISSION_DENIED)));
    }
  }
}
