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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;

import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.TransactionRunner.TransactionCallable;
import com.google.protobuf.ListValue;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.TypeCode;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.inprocess.InProcessServerBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ReadWriteTransactionWithInlineBeginTest {
  @Rule public ExpectedException exception = ExpectedException.none();

  private static MockSpannerServiceImpl mockSpanner;
  private static Server server;
  private static LocalChannelProvider channelProvider;
  private static final Statement UPDATE_STATEMENT =
      Statement.of("UPDATE FOO SET BAR=1 WHERE BAZ=2");
  private static final Statement INVALID_UPDATE_STATEMENT =
      Statement.of("UPDATE NON_EXISTENT_TABLE SET BAR=1 WHERE BAZ=2");
  private static final Statement INVALID_SELECT_STATEMENT =
      Statement.of("SELECT * FROM NON_EXISTENT_TABLE");
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
  private DatabaseClient client;

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
    mockSpanner.putStatementResult(
        StatementResult.exception(
            INVALID_SELECT_STATEMENT,
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
    mockSpanner.reset();
    mockSpanner.removeAllExecutionTimes();
    // Create a Spanner instance with no read/write prepared sessions in the pool.
    spanner =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setInlineBeginForReadWriteTransaction(true)
            .setSessionPoolOption(
                SessionPoolOptions.newBuilder().setWriteSessionsFraction(0.0f).build())
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance())
            .build()
            .getService();
    // Make sure that calling BeginTransaction would lead to an error.
    mockSpanner.setBeginTransactionExecutionTime(
        SimulatedExecutionTime.ofException(Status.PERMISSION_DENIED.asRuntimeException()));
    client = spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
  }

  @After
  public void tearDown() throws Exception {
    spanner.close();
  }

  @Test
  public void singleUpdate() {
    Long updateCount =
        client
            .readWriteTransaction()
            .run(
                new TransactionCallable<Long>() {
                  @Override
                  public Long run(TransactionContext transaction) throws Exception {
                    return transaction.executeUpdate(UPDATE_STATEMENT);
                  }
                });
    assertThat(updateCount).isEqualTo(UPDATE_COUNT);
  }

  @Test
  public void singleBatchUpdate() {
    long[] updateCounts =
        client
            .readWriteTransaction()
            .run(
                new TransactionCallable<long[]>() {
                  @Override
                  public long[] run(TransactionContext transaction) throws Exception {
                    return transaction.batchUpdate(
                        Arrays.asList(UPDATE_STATEMENT, UPDATE_STATEMENT));
                  }
                });
    assertThat(updateCounts).isEqualTo(new long[] {UPDATE_COUNT, UPDATE_COUNT});
  }

  @Test
  public void singleQuery() {
    Long value =
        client
            .readWriteTransaction()
            .run(
                new TransactionCallable<Long>() {
                  @Override
                  public Long run(TransactionContext transaction) throws Exception {
                    try (ResultSet rs = transaction.executeQuery(SELECT1)) {
                      while (rs.next()) {
                        return rs.getLong(0);
                      }
                    }
                    return 0L;
                  }
                });
    assertThat(value).isEqualTo(1L);
  }

  @Test
  public void updateAndQuery() {
    long[] res =
        client
            .readWriteTransaction()
            .run(
                new TransactionCallable<long[]>() {
                  @Override
                  public long[] run(TransactionContext transaction) throws Exception {
                    long updateCount = transaction.executeUpdate(UPDATE_STATEMENT);
                    long val = 0L;
                    try (ResultSet rs = transaction.executeQuery(SELECT1)) {
                      while (rs.next()) {
                        val = rs.getLong(0);
                      }
                    }
                    return new long[] {updateCount, val};
                  }
                });
    assertThat(res).isEqualTo(new long[] {UPDATE_COUNT, 1L});
  }

  @Test
  public void concurrentUpdates() {
    final int updates = 100;
    final ExecutorService service = Executors.newFixedThreadPool(8);
    Long updateCount =
        client
            .readWriteTransaction()
            .run(
                new TransactionCallable<Long>() {
                  @Override
                  public Long run(final TransactionContext transaction) throws Exception {
                    List<Future<Long>> list = new ArrayList<>(updates);
                    for (int i = 0; i < updates; i++) {
                      list.add(
                          service.submit(
                              new Callable<Long>() {
                                @Override
                                public Long call() throws Exception {
                                  return transaction.executeUpdate(UPDATE_STATEMENT);
                                }
                              }));
                    }
                    long totalUpdateCount = 0L;
                    for (Future<Long> fut : list) {
                      totalUpdateCount += fut.get();
                    }
                    return totalUpdateCount;
                  }
                });
    assertThat(updateCount).isEqualTo(UPDATE_COUNT * updates);
  }

  @Test
  public void concurrentBatchUpdates() {
    final int updates = 100;
    final ExecutorService service = Executors.newFixedThreadPool(8);
    Long updateCount =
        client
            .readWriteTransaction()
            .run(
                new TransactionCallable<Long>() {
                  @Override
                  public Long run(final TransactionContext transaction) throws Exception {
                    List<Future<long[]>> list = new ArrayList<>(updates);
                    for (int i = 0; i < updates; i++) {
                      list.add(
                          service.submit(
                              new Callable<long[]>() {
                                @Override
                                public long[] call() throws Exception {
                                  return transaction.batchUpdate(
                                      Arrays.asList(UPDATE_STATEMENT, UPDATE_STATEMENT));
                                }
                              }));
                    }
                    long totalUpdateCount = 0L;
                    for (Future<long[]> fut : list) {
                      for (long l : fut.get()) {
                        totalUpdateCount += l;
                      }
                    }
                    return totalUpdateCount;
                  }
                });
    assertThat(updateCount).isEqualTo(UPDATE_COUNT * updates * 2);
  }

  @Test
  public void concurrentQueries() {
    final int queries = 100;
    final ExecutorService service = Executors.newFixedThreadPool(8);
    Long selectedTotal =
        client
            .readWriteTransaction()
            .run(
                new TransactionCallable<Long>() {
                  @Override
                  public Long run(final TransactionContext transaction) throws Exception {
                    List<Future<Long>> list = new ArrayList<>(queries);
                    for (int i = 0; i < queries; i++) {
                      list.add(
                          service.submit(
                              new Callable<Long>() {
                                @Override
                                public Long call() throws Exception {
                                  try (ResultSet rs = transaction.executeQuery(SELECT1)) {
                                    while (rs.next()) {
                                      return rs.getLong(0);
                                    }
                                  }
                                  return 0L;
                                }
                              }));
                    }
                    long selectedTotal = 0L;
                    for (Future<Long> fut : list) {
                      selectedTotal += fut.get();
                    }
                    return selectedTotal;
                  }
                });
    assertThat(selectedTotal).isEqualTo(queries);
  }

  @Test
  public void failedUpdate() {
    exception.expect(SpannerMatchers.isSpannerException(ErrorCode.INVALID_ARGUMENT));
    client
        .readWriteTransaction()
        .run(
            new TransactionCallable<Long>() {
              @Override
              public Long run(TransactionContext transaction) throws Exception {
                return transaction.executeUpdate(INVALID_UPDATE_STATEMENT);
              }
            });
  }

  @Test
  public void failedBatchUpdate() {
    exception.expect(SpannerMatchers.isSpannerException(ErrorCode.INVALID_ARGUMENT));
    client
        .readWriteTransaction()
        .run(
            new TransactionCallable<long[]>() {
              @Override
              public long[] run(TransactionContext transaction) throws Exception {
                return transaction.batchUpdate(
                    Arrays.asList(INVALID_UPDATE_STATEMENT, UPDATE_STATEMENT));
              }
            });
  }

  @Test
  public void failedQuery() {
    exception.expect(SpannerMatchers.isSpannerException(ErrorCode.INVALID_ARGUMENT));
    client
        .readWriteTransaction()
        .run(
            new TransactionCallable<Void>() {
              @Override
              public Void run(TransactionContext transaction) throws Exception {
                try (ResultSet rs = transaction.executeQuery(INVALID_SELECT_STATEMENT)) {
                  rs.next();
                }
                return null;
              }
            });
  }

  @Test
  public void failedUpdateAndThenUpdate() {
    Long updateCount =
        client
            .readWriteTransaction()
            .run(
                new TransactionCallable<Long>() {
                  @Override
                  public Long run(TransactionContext transaction) throws Exception {
                    try {
                      // This update statement carries the BeginTransaction, but fails. The
                      // BeginTransaction will then be carried by the subsequent statement.
                      transaction.executeUpdate(INVALID_UPDATE_STATEMENT);
                      fail("Missing expected exception");
                    } catch (SpannerException e) {
                      if (e.getErrorCode() != ErrorCode.INVALID_ARGUMENT) {
                        fail("Error mismatch, expected INVALID_ARGUMENT");
                      }
                    }
                    return transaction.executeUpdate(UPDATE_STATEMENT);
                  }
                });
    assertThat(updateCount).isEqualTo(1L);
  }

  @Test
  public void failedBatchUpdateAndThenUpdate() {
    Long updateCount =
        client
            .readWriteTransaction()
            .run(
                new TransactionCallable<Long>() {
                  @Override
                  public Long run(TransactionContext transaction) throws Exception {
                    try {
                      // This update statement carries the BeginTransaction, but fails. The
                      // BeginTransaction will then be carried by the subsequent statement.
                      transaction.batchUpdate(
                          Arrays.asList(INVALID_UPDATE_STATEMENT, UPDATE_STATEMENT));
                      fail("Missing expected exception");
                    } catch (SpannerException e) {
                      if (e.getErrorCode() != ErrorCode.INVALID_ARGUMENT) {
                        fail("Error mismatch, expected INVALID_ARGUMENT");
                      }
                    }
                    return transaction.executeUpdate(UPDATE_STATEMENT);
                  }
                });
    assertThat(updateCount).isEqualTo(1L);
  }

  @Test
  public void failedQueryAndThenUpdate() {
    Long updateCount =
        client
            .readWriteTransaction()
            .run(
                new TransactionCallable<Long>() {
                  @Override
                  public Long run(TransactionContext transaction) throws Exception {
                    // This query carries the BeginTransaction, but fails. The BeginTransaction will
                    // then be carried by the subsequent statement.
                    try (ResultSet rs = transaction.executeQuery(INVALID_SELECT_STATEMENT)) {
                      rs.next();
                      fail("Missing expected exception");
                    } catch (SpannerException e) {
                      if (e.getErrorCode() != ErrorCode.INVALID_ARGUMENT) {
                        fail("Error mismatch, expected INVALID_ARGUMENT");
                      }
                    }
                    return transaction.executeUpdate(UPDATE_STATEMENT);
                  }
                });
    assertThat(updateCount).isEqualTo(1L);
  }

  @Test
  public void abortedUpdate() {
    final AtomicInteger attempt = new AtomicInteger();
    Long updateCount =
        client
            .readWriteTransaction()
            .run(
                new TransactionCallable<Long>() {
                  @Override
                  public Long run(TransactionContext transaction) throws Exception {
                    if (attempt.incrementAndGet() == 1) {
                      // We use abortNextTransaction here, as the transaction context does not yet
                      // have a transaction (it will be requested by the first update statement).
                      mockSpanner.abortNextTransaction();
                    }
                    return transaction.executeUpdate(UPDATE_STATEMENT);
                  }
                });
    assertThat(updateCount).isEqualTo(UPDATE_COUNT);
    assertThat(attempt.get()).isEqualTo(2);
  }

  @Test
  public void abortedBatchUpdate() {
    final AtomicInteger attempt = new AtomicInteger();
    long[] updateCounts =
        client
            .readWriteTransaction()
            .run(
                new TransactionCallable<long[]>() {
                  @Override
                  public long[] run(TransactionContext transaction) throws Exception {
                    if (attempt.incrementAndGet() == 1) {
                      // We use abortNextTransaction here, as the transaction context does not yet
                      // have a transaction (it will be requested by the first update statement).
                      mockSpanner.abortNextTransaction();
                    }
                    return transaction.batchUpdate(
                        Arrays.asList(UPDATE_STATEMENT, UPDATE_STATEMENT));
                  }
                });
    assertThat(updateCounts).isEqualTo(new long[] {UPDATE_COUNT, UPDATE_COUNT});
    assertThat(attempt.get()).isEqualTo(2);
  }
}
