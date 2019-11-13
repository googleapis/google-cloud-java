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
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.TransactionRunner.TransactionCallable;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ListValue;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.TypeCode;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.inprocess.InProcessServerBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class InlineBeginTransactionTest {
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
    mockSpanner.reset();
    mockSpanner.removeAllExecutionTimes();
    // Create a Spanner instance that will inline BeginTransaction calls. It also has no prepared
    // sessions in the pool to prevent session preparing from interfering with test cases.
    spanner =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance())
            .setInlineBeginForReadWriteTransaction(true)
            .setSessionPoolOption(
                SessionPoolOptions.newBuilder().setWriteSessionsFraction(0.0f).build())
            .build()
            .getService();
  }

  @After
  public void tearDown() throws Exception {
    spanner.close();
    mockSpanner.reset();
  }

  @Test
  public void testInlinedBeginTx() {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
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
    assertThat(updateCount).isEqualTo(UPDATE_COUNT);
    assertThat(countRequests(BeginTransactionRequest.class)).isEqualTo(0);
    assertThat(countTransactionsStarted()).isEqualTo(1);
  }

  @Test
  public void testInlinedBeginTxAborted() {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
    final AtomicBoolean firstAttempt = new AtomicBoolean(true);
    long updateCount =
        client
            .readWriteTransaction()
            .run(
                new TransactionCallable<Long>() {
                  @Override
                  public Long run(TransactionContext transaction) throws Exception {
                    long res = transaction.executeUpdate(UPDATE_STATEMENT);
                    if (firstAttempt.getAndSet(false)) {
                      mockSpanner.abortTransaction(transaction);
                    }
                    return res;
                  }
                });
    assertThat(updateCount).isEqualTo(UPDATE_COUNT);
    assertThat(countRequests(BeginTransactionRequest.class)).isEqualTo(0);
    // We have started 2 transactions, because the first transaction aborted.
    assertThat(countTransactionsStarted()).isEqualTo(2);
  }

  @Test
  public void testInlinedBeginTxWithQuery() {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
    long updateCount =
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
    assertThat(updateCount).isEqualTo(1L);
    assertThat(countRequests(BeginTransactionRequest.class)).isEqualTo(0);
    assertThat(countTransactionsStarted()).isEqualTo(1);
  }

  @Test
  public void testInlinedBeginTxWithError() {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
    long updateCount =
        client
            .readWriteTransaction()
            .run(
                new TransactionCallable<Long>() {
                  @Override
                  public Long run(TransactionContext transaction) throws Exception {
                    try {
                      transaction.executeUpdate(INVALID_UPDATE_STATEMENT);
                      fail("missing expected exception");
                    } catch (SpannerException e) {
                      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
                    }
                    return transaction.executeUpdate(UPDATE_STATEMENT);
                  }
                });
    assertThat(updateCount).isEqualTo(UPDATE_COUNT);
    assertThat(countRequests(BeginTransactionRequest.class)).isEqualTo(0);
    // The first update will start a transaction, but then fail the update statement. This will
    // start a transaction on the mock server, but that transaction will never be returned to the
    // client.
    assertThat(countTransactionsStarted()).isEqualTo(2);
  }

  @Test
  public void testInlinedBeginTxWithParallelQueries() {
    final int numQueries = 100;
    final ScheduledExecutorService executor = Executors.newScheduledThreadPool(16);
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
    long updateCount =
        client
            .readWriteTransaction()
            .run(
                new TransactionCallable<Long>() {
                  @Override
                  public Long run(final TransactionContext transaction) throws Exception {
                    List<Future<Long>> futures = new ArrayList<>(numQueries);
                    for (int i = 0; i < numQueries; i++) {
                      futures.add(
                          executor.submit(
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
                    Long res = 0L;
                    for (Future<Long> f : futures) {
                      res += f.get();
                    }
                    return res;
                  }
                });
    assertThat(updateCount).isEqualTo(1L * numQueries);
    assertThat(countRequests(BeginTransactionRequest.class)).isEqualTo(0);
    assertThat(countTransactionsStarted()).isEqualTo(1);
  }

  @Test
  public void testInlinedBeginTxWithOnlyMutations() {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
    client
        .readWriteTransaction()
        .run(
            new TransactionCallable<Void>() {
              @Override
              public Void run(TransactionContext transaction) throws Exception {
                transaction.buffer(Mutation.delete("FOO", Key.of(1L)));
                return null;
              }
            });
    // There should be 1 call to BeginTransaction because there is no statement that we can use to
    // inline the BeginTransaction call with.
    assertThat(countRequests(BeginTransactionRequest.class)).isEqualTo(1);
    assertThat(countTransactionsStarted()).isEqualTo(1);
  }

  @SuppressWarnings("resource")
  @Test
  public void testTransactionManagerInlinedBeginTx() {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
    try (TransactionManager txMgr = client.transactionManager()) {
      TransactionContext txn = txMgr.begin();
      while (true) {
        try {
          assertThat(txn.executeUpdate(UPDATE_STATEMENT)).isEqualTo(UPDATE_COUNT);
          txMgr.commit();
          break;
        } catch (AbortedException e) {
          txn = txMgr.resetForRetry();
        }
      }
    }
    assertThat(countRequests(BeginTransactionRequest.class)).isEqualTo(0);
    assertThat(countTransactionsStarted()).isEqualTo(1);
  }

  @SuppressWarnings("resource")
  @Test
  public void testTransactionManagerInlinedBeginTxAborted() {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
    try (TransactionManager txMgr = client.transactionManager()) {
      TransactionContext txn = txMgr.begin();
      boolean first = true;
      while (true) {
        try {
          assertThat(txn.executeUpdate(UPDATE_STATEMENT)).isEqualTo(UPDATE_COUNT);
          if (first) {
            mockSpanner.abortAllTransactions();
            first = false;
          }
          txMgr.commit();
          break;
        } catch (AbortedException e) {
          txn = txMgr.resetForRetry();
        }
      }
    }
    assertThat(countRequests(BeginTransactionRequest.class)).isEqualTo(0);
    assertThat(countTransactionsStarted()).isEqualTo(2);
  }

  @SuppressWarnings("resource")
  @Test
  public void testTransactionManagerInlinedBeginTxWithOnlyMutations() {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
    try (TransactionManager txMgr = client.transactionManager()) {
      TransactionContext txn = txMgr.begin();
      while (true) {
        try {
          txn.buffer(Mutation.delete("FOO", Key.of(1L)));
          txMgr.commit();
          break;
        } catch (AbortedException e) {
          txn = txMgr.resetForRetry();
        }
      }
    }
    // There should be 1 call to BeginTransaction because there is no statement that we can use to
    // inline the BeginTransaction call with.
    assertThat(countRequests(BeginTransactionRequest.class)).isEqualTo(1);
    assertThat(countTransactionsStarted()).isEqualTo(1);
  }

  @SuppressWarnings("resource")
  @Test
  public void testTransactionManagerInlinedBeginTxWithError() {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
    try (TransactionManager txMgr = client.transactionManager()) {
      TransactionContext txn = txMgr.begin();
      while (true) {
        try {
          try {
            txn.executeUpdate(INVALID_UPDATE_STATEMENT);
            fail("missing expected exception");
          } catch (SpannerException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
          }
          assertThat(txn.executeUpdate(UPDATE_STATEMENT)).isEqualTo(UPDATE_COUNT);
          txMgr.commit();
          break;
        } catch (AbortedException e) {
          txn = txMgr.resetForRetry();
        }
      }
    }
    assertThat(countRequests(BeginTransactionRequest.class)).isEqualTo(0);
    // The first statement will start a transaction, but it will never be returned to the client as
    // the update statement fails.
    assertThat(countTransactionsStarted()).isEqualTo(2);
  }

  private int countRequests(Class<? extends AbstractMessage> requestType) {
    int count = 0;
    for (AbstractMessage msg : mockSpanner.getRequests()) {
      if (msg.getClass().equals(requestType)) {
        count++;
      }
    }
    return count;
  }

  private int countTransactionsStarted() {
    return mockSpanner.getTransactionsStarted().size();
  }
}
