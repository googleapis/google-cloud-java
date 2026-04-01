/*
 * Copyright 2020 Google LLC
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.common.collect.Iterables;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ListValue;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.TransactionOptions;
import com.google.spanner.v1.TransactionOptions.ReadWrite;
import com.google.spanner.v1.TypeCode;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.inprocess.InProcessServerBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ReadWriteTransactionWithInlineBeginTest {
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
  private static final TransactionOptions OPTIMISTIC_LOCK_OPTIONS =
      TransactionOptions.newBuilder()
          .setReadWrite(ReadWrite.newBuilder().setReadLockMode(ReadWrite.ReadLockMode.OPTIMISTIC))
          .build();
  private Spanner spanner;
  private DatabaseClient client;

  @BeforeClass
  public static void startStaticServer() throws Exception {
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
    mockSpanner.putStatementResult(
        StatementResult.read(
            "FOO", KeySet.all(), Collections.singletonList("ID"), SELECT1_RESULTSET));

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
    mockSpanner.reset();
    mockSpanner.removeAllExecutionTimes();
    spanner =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance())
            .build()
            .getService();
    client = spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
  }

  @After
  public void tearDown() {
    spanner.close();
  }

  @Test
  public void singleUpdate() {
    Long updateCount =
        client
            .readWriteTransaction()
            .run(transaction -> transaction.executeUpdate(UPDATE_STATEMENT));
    assertThat(updateCount).isEqualTo(UPDATE_COUNT);
    assertThat(countRequests(BeginTransactionRequest.class)).isEqualTo(0);
    assertThat(countTransactionsStarted()).isEqualTo(1);
  }

  @Test
  public void singleBatchUpdate() {
    long[] updateCounts =
        client
            .readWriteTransaction()
            .run(
                transaction ->
                    transaction.batchUpdate(Arrays.asList(UPDATE_STATEMENT, UPDATE_STATEMENT)));
    assertThat(updateCounts).isEqualTo(new long[] {UPDATE_COUNT, UPDATE_COUNT});
    assertThat(countRequests(BeginTransactionRequest.class)).isEqualTo(0);
    assertThat(countTransactionsStarted()).isEqualTo(1);
  }

  @Test
  public void singleQuery() {
    Long value = MockSpannerTestActions.executeSelect1(client);
    assertThat(value).isEqualTo(1L);
    assertThat(countRequests(BeginTransactionRequest.class)).isEqualTo(0);
    assertThat(countTransactionsStarted()).isEqualTo(1);
  }

  @Test
  public void updateAndQuery() {
    long[] res =
        client
            .readWriteTransaction()
            .run(
                transaction -> {
                  long updateCount = transaction.executeUpdate(UPDATE_STATEMENT);
                  long val = 0L;
                  try (ResultSet rs = transaction.executeQuery(SELECT1)) {
                    while (rs.next()) {
                      val = rs.getLong(0);
                    }
                  }
                  return new long[] {updateCount, val};
                });
    assertThat(res).isEqualTo(new long[] {UPDATE_COUNT, 1L});
    assertThat(countRequests(BeginTransactionRequest.class)).isEqualTo(0);
    assertThat(countTransactionsStarted()).isEqualTo(1);
  }

  @Test
  public void concurrentUpdates() {
    final int updates = 100;
    final ExecutorService service = Executors.newFixedThreadPool(8);
    Long updateCount =
        client
            .readWriteTransaction()
            .run(
                transaction -> {
                  List<Future<Long>> list = new ArrayList<>(updates);
                  for (int i = 0; i < updates; i++) {
                    list.add(service.submit(() -> transaction.executeUpdate(UPDATE_STATEMENT)));
                  }
                  long totalUpdateCount = 0L;
                  for (Future<Long> fut : list) {
                    totalUpdateCount += fut.get();
                  }
                  return totalUpdateCount;
                });
    assertThat(updateCount).isEqualTo(UPDATE_COUNT * updates);
    assertThat(countRequests(BeginTransactionRequest.class)).isEqualTo(0);
    assertThat(countTransactionsStarted()).isEqualTo(1);
  }

  @Test
  public void concurrentBatchUpdates() {
    final int updates = 100;
    final ExecutorService service = Executors.newFixedThreadPool(8);
    Long updateCount =
        client
            .readWriteTransaction()
            .run(
                transaction -> {
                  List<Future<long[]>> list = new ArrayList<>(updates);
                  for (int i = 0; i < updates; i++) {
                    list.add(
                        service.submit(
                            () ->
                                transaction.batchUpdate(
                                    Arrays.asList(UPDATE_STATEMENT, UPDATE_STATEMENT))));
                  }
                  long totalUpdateCount = 0L;
                  for (Future<long[]> fut : list) {
                    for (long l : fut.get()) {
                      totalUpdateCount += l;
                    }
                  }
                  return totalUpdateCount;
                });
    assertThat(updateCount).isEqualTo(UPDATE_COUNT * updates * 2);
    assertThat(countRequests(BeginTransactionRequest.class)).isEqualTo(0);
    assertThat(countTransactionsStarted()).isEqualTo(1);
  }

  @Test
  public void concurrentQueries() {
    final int queries = 100;
    final ExecutorService service = Executors.newFixedThreadPool(8);
    Long selectedTotal =
        client
            .readWriteTransaction()
            .run(
                transaction -> {
                  List<Future<Long>> list = new ArrayList<>(queries);
                  for (int i = 0; i < queries; i++) {
                    list.add(
                        service.submit(
                            () -> {
                              try (ResultSet rs = transaction.executeQuery(SELECT1)) {
                                while (rs.next()) {
                                  return rs.getLong(0);
                                }
                              }
                              return 0L;
                            }));
                  }
                  long selectedTotal1 = 0L;
                  for (Future<Long> fut : list) {
                    selectedTotal1 += fut.get();
                  }
                  return selectedTotal1;
                });
    assertThat(selectedTotal).isEqualTo(queries);
    assertThat(countRequests(BeginTransactionRequest.class)).isEqualTo(0);
    assertThat(countTransactionsStarted()).isEqualTo(1);
  }

  @Test
  public void failedUpdate() {
    SpannerException e =
        assertThrows(
            SpannerException.class,
            () ->
                client
                    .readWriteTransaction()
                    .run(transaction -> transaction.executeUpdate(INVALID_UPDATE_STATEMENT)));
    assertEquals(ErrorCode.INVALID_ARGUMENT, e.getErrorCode());
    assertThat(countRequests(BeginTransactionRequest.class)).isEqualTo(0);
    assertThat(countTransactionsStarted()).isEqualTo(1);
  }

  @Test
  public void failedBatchUpdate() {
    SpannerException e =
        assertThrows(
            SpannerException.class,
            () ->
                client
                    .readWriteTransaction()
                    .run(
                        transaction ->
                            transaction.batchUpdate(
                                Arrays.asList(INVALID_UPDATE_STATEMENT, UPDATE_STATEMENT))));
    assertEquals(ErrorCode.INVALID_ARGUMENT, e.getErrorCode());
    assertThat(countRequests(BeginTransactionRequest.class)).isEqualTo(0);
    assertThat(countTransactionsStarted()).isEqualTo(1);
  }

  @Test
  public void failedQuery() {
    SpannerException e =
        assertThrows(
            SpannerException.class,
            () ->
                client
                    .readWriteTransaction()
                    .run(
                        transaction -> {
                          try (ResultSet rs = transaction.executeQuery(INVALID_SELECT_STATEMENT)) {
                            rs.next();
                          }
                          return null;
                        }));
    assertEquals(ErrorCode.INVALID_ARGUMENT, e.getErrorCode());
    assertThat(countRequests(BeginTransactionRequest.class)).isEqualTo(0);
    assertThat(countTransactionsStarted()).isEqualTo(1);
  }

  @Test
  public void failedUpdateAndThenUpdate() {
    Long updateCount =
        client
            .readWriteTransaction()
            .run(
                transaction -> {
                  // This update statement carries the BeginTransaction, but fails. This will
                  // cause the entire transaction to be retried with an explicit
                  // BeginTransaction RPC to ensure all statements in the transaction are
                  // actually executed against the same transaction.
                  SpannerException e =
                      assertThrows(
                          SpannerException.class,
                          () -> transaction.executeUpdate(INVALID_UPDATE_STATEMENT));
                  assertEquals(ErrorCode.INVALID_ARGUMENT, e.getErrorCode());
                  return transaction.executeUpdate(UPDATE_STATEMENT);
                });
    assertThat(updateCount).isEqualTo(1L);
    assertThat(countRequests(BeginTransactionRequest.class)).isEqualTo(1);
    assertThat(countTransactionsStarted()).isEqualTo(2);
  }

  @Test
  public void failedBatchUpdateAndThenUpdate() {
    Long updateCount =
        client
            .readWriteTransaction()
            .run(
                transaction -> {
                  // This update statement carries the BeginTransaction, but fails. This will
                  // cause the entire transaction to be retried with an explicit
                  // BeginTransaction RPC to ensure all statements in the transaction are
                  // actually executed against the same transaction.
                  SpannerException e =
                      assertThrows(
                          SpannerException.class,
                          () ->
                              transaction.batchUpdate(
                                  Arrays.asList(INVALID_UPDATE_STATEMENT, UPDATE_STATEMENT)));
                  assertEquals(ErrorCode.INVALID_ARGUMENT, e.getErrorCode());
                  return transaction.executeUpdate(UPDATE_STATEMENT);
                });
    assertThat(updateCount).isEqualTo(1L);
    assertThat(countRequests(BeginTransactionRequest.class)).isEqualTo(1);
    assertThat(countTransactionsStarted()).isEqualTo(2);
  }

  @Test
  public void executeSqlWithOptimisticConcurrencyControl() {
    MockSpannerTestActions.executeSelect1(client, Options.optimisticLock());
    Collection<AbstractMessage> requests =
        mockSpanner.getRequests().stream()
            .filter(msg -> msg.getClass().equals(ExecuteSqlRequest.class))
            .collect(Collectors.toList());
    assertEquals(requests.size(), 1);
    ExecuteSqlRequest request = (ExecuteSqlRequest) Iterables.getOnlyElement(requests);
    assertEquals(request.getTransaction().getBegin(), OPTIMISTIC_LOCK_OPTIONS);
  }

  @Test
  public void readWithOptimisticConcurrencyControl() {
    Long updateCount = MockSpannerTestActions.executeReadFoo(client, Options.optimisticLock());
    assertThat(updateCount).isEqualTo(1L);
    Collection<AbstractMessage> requests =
        mockSpanner.getRequests().stream()
            .filter(msg -> msg.getClass().equals(ReadRequest.class))
            .collect(Collectors.toList());
    assertEquals(requests.size(), 1);
    ReadRequest request = (ReadRequest) Iterables.getOnlyElement(requests);
    assertThat(request.getTransaction().getBegin()).isEqualTo(OPTIMISTIC_LOCK_OPTIONS);
  }

  @Test
  public void beginTransactionWithOptimisticConcurrencyControl() {
    MockSpannerTestActions.executeInvalidAndValidSql(client, Options.optimisticLock());
    Collection<AbstractMessage> requests =
        mockSpanner.getRequests().stream()
            .filter(msg -> msg.getClass().equals(BeginTransactionRequest.class))
            .collect(Collectors.toList());
    assertEquals(requests.size(), 1);
    BeginTransactionRequest request = (BeginTransactionRequest) Iterables.getOnlyElement(requests);
    assertEquals(request.getOptions(), OPTIMISTIC_LOCK_OPTIONS);
  }

  @Test
  public void failedQueryAndThenUpdate() {
    Long updateCount = MockSpannerTestActions.executeInvalidAndValidSql(client);
    assertThat(updateCount).isEqualTo(1L);
    assertThat(countRequests(BeginTransactionRequest.class)).isEqualTo(1);
    assertThat(countTransactionsStarted()).isEqualTo(2);
  }

  @Test
  public void abortedUpdate() {
    final AtomicInteger attempt = new AtomicInteger();
    Long updateCount =
        client
            .readWriteTransaction()
            .run(
                transaction -> {
                  if (attempt.incrementAndGet() == 1) {
                    // We use abortNextTransaction here, as the transaction context does not yet
                    // have a transaction (it will be requested by the first update statement).
                    mockSpanner.abortNextTransaction();
                  }
                  return transaction.executeUpdate(UPDATE_STATEMENT);
                });
    assertThat(updateCount).isEqualTo(UPDATE_COUNT);
    assertThat(attempt.get()).isEqualTo(2);
    assertThat(countRequests(BeginTransactionRequest.class)).isEqualTo(0);
    assertThat(countTransactionsStarted()).isEqualTo(2);
  }

  @Test
  public void abortedBatchUpdate() {
    final AtomicInteger attempt = new AtomicInteger();
    long[] updateCounts =
        client
            .readWriteTransaction()
            .run(
                transaction -> {
                  if (attempt.incrementAndGet() == 1) {
                    // We use abortNextTransaction here, as the transaction context does not yet
                    // have a transaction (it will be requested by the first update statement).
                    mockSpanner.abortNextTransaction();
                  }
                  return transaction.batchUpdate(Arrays.asList(UPDATE_STATEMENT, UPDATE_STATEMENT));
                });
    assertThat(updateCounts).isEqualTo(new long[] {UPDATE_COUNT, UPDATE_COUNT});
    assertThat(attempt.get()).isEqualTo(2);
    assertThat(countRequests(BeginTransactionRequest.class)).isEqualTo(0);
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
