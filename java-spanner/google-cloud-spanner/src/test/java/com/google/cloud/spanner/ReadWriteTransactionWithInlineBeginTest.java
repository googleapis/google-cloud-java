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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.spi.v1.GapicSpannerRpc;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.common.collect.Iterables;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.ListValue;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.TransactionOptions;
import com.google.spanner.v1.TransactionOptions.ReadWrite;
import com.google.spanner.v1.TypeCode;
import io.grpc.Context;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.inprocess.InProcessServerBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.AdditionalAnswers;
import org.mockito.invocation.InvocationOnMock;

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
  private static final Statement SELECT1_UNION_ALL_SELECT2 =
      Statement.of("SELECT 1 AS COL1 UNION ALL SELECT 2 AS COL1");
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
  private static final com.google.spanner.v1.ResultSet SELECT1_UNION_ALL_SELECT2_RESULTSET =
      com.google.spanner.v1.ResultSet.newBuilder()
          .addRows(
              ListValue.newBuilder()
                  .addValues(com.google.protobuf.Value.newBuilder().setStringValue("1").build())
                  .build())
          .addRows(
              ListValue.newBuilder()
                  .addValues(com.google.protobuf.Value.newBuilder().setStringValue("2").build())
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
        StatementResult.query(SELECT1_UNION_ALL_SELECT2, SELECT1_UNION_ALL_SELECT2_RESULTSET));
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
    mockSpanner.putStatementResult(
        StatementResult.read(
            "FOO_TWO_ROWS",
            KeySet.all(),
            Collections.singletonList("ID"),
            SELECT1_UNION_ALL_SELECT2_RESULTSET));

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

  private SpannerOptions createSpannerOptionsWithStreamInterceptors(
      BiFunction<InvocationOnMock, SpannerRpc, SpannerRpc.StreamingCall> executeQueryInterceptor,
      BiFunction<InvocationOnMock, SpannerRpc, SpannerRpc.StreamingCall> readInterceptor) {
    return SpannerOptions.newBuilder()
        .setProjectId("[PROJECT]")
        .setChannelProvider(channelProvider)
        .setCredentials(NoCredentials.getInstance())
        .setServiceRpcFactory(
            spannerOptions -> {
              SpannerRpc delegate = new GapicSpannerRpc(spannerOptions);
              SpannerRpc spannerRpc =
                  mock(SpannerRpc.class, AdditionalAnswers.delegatesTo(delegate));
              doAnswer(invocation -> executeQueryInterceptor.apply(invocation, delegate))
                  .when(spannerRpc)
                  .executeQuery(
                      any(ExecuteSqlRequest.class),
                      any(SpannerRpc.ResultStreamConsumer.class),
                      any(),
                      any(XGoogSpannerRequestId.class),
                      anyBoolean());
              doAnswer(invocation -> readInterceptor.apply(invocation, delegate))
                  .when(spannerRpc)
                  .read(
                      any(ReadRequest.class),
                      any(SpannerRpc.ResultStreamConsumer.class),
                      any(),
                      any(XGoogSpannerRequestId.class),
                      anyBoolean());
              return spannerRpc;
            })
        .build();
  }

  private static SpannerRpc.StreamingCall delegateExecuteQuery(
      InvocationOnMock invocation, SpannerRpc delegate) {
    Map<SpannerRpc.Option, ?> rpcOptions = invocation.getArgument(2);
    return delegate.executeQuery(
        invocation.getArgument(0),
        invocation.getArgument(1),
        rpcOptions,
        invocation.getArgument(3),
        invocation.getArgument(4));
  }

  private static SpannerRpc.StreamingCall delegateRead(
      InvocationOnMock invocation, SpannerRpc delegate) {
    Map<SpannerRpc.Option, ?> rpcOptions = invocation.getArgument(2);
    return delegate.read(
        invocation.getArgument(0),
        invocation.getArgument(1),
        rpcOptions,
        invocation.getArgument(3),
        invocation.getArgument(4));
  }

  private SpannerOptions createSpannerOptionsWithFailingStreamStart(
      AtomicBoolean failNextStreamStart) {
    return createSpannerOptionsWithFailingStreamStart(
        failNextStreamStart,
        () -> new IllegalStateException("simulated synchronous start failure"));
  }

  private SpannerOptions createSpannerOptionsWithFailingStreamStart(
      AtomicBoolean failNextStreamStart, Supplier<RuntimeException> failureSupplier) {
    return createSpannerOptionsWithStreamInterceptors(
        (invocation, delegate) -> {
          if (failNextStreamStart.compareAndSet(true, false)) {
            throw failureSupplier.get();
          }
          return delegateExecuteQuery(invocation, delegate);
        },
        (invocation, delegate) -> {
          if (failNextStreamStart.compareAndSet(true, false)) {
            throw failureSupplier.get();
          }
          return delegateRead(invocation, delegate);
        });
  }

  @Test(timeout = 10_000)
  public void synchronousStartFailureOfInlinedBeginStatement() {
    AtomicBoolean failNextStreamStart = new AtomicBoolean();
    SpannerOptions options = createSpannerOptionsWithFailingStreamStart(failNextStreamStart);
    AtomicInteger attempts = new AtomicInteger();
    try (Spanner customSpanner = options.getService()) {
      DatabaseClient customClient =
          customSpanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));

      // Single-use read context exercises the base AbstractReadContext.onStartFailed no-op hook.
      failNextStreamStart.set(true);
      try (ResultSet singleUseResultSet = customClient.singleUse().executeQuery(SELECT1)) {
        SpannerException singleUseError =
            assertThrows(SpannerException.class, singleUseResultSet::next);
        assertEquals(ErrorCode.UNKNOWN, singleUseError.getErrorCode());
      }

      mockSpanner.reset();
      customClient
          .readWriteTransaction()
          .run(
              transaction -> {
                int attempt = attempts.incrementAndGet();
                if (attempt == 1) {
                  failNextStreamStart.set(true);
                  try (ResultSet resultSet = transaction.executeQuery(SELECT1)) {
                    SpannerException firstStatementError =
                        assertThrows(SpannerException.class, resultSet::next);
                    assertEquals(ErrorCode.UNKNOWN, firstStatementError.getErrorCode());
                  }
                } else {
                  // On the retry attempt, the transaction has already been started, so a
                  // synchronous start failure has withBeginTransaction == false and does not
                  // abort the transaction.
                  failNextStreamStart.set(true);
                  try (ResultSet failingResultSet =
                      transaction.read("FOO", KeySet.all(), Collections.singletonList("ID"))) {
                    SpannerException subsequentError =
                        assertThrows(SpannerException.class, failingResultSet::next);
                    assertEquals(ErrorCode.UNKNOWN, subsequentError.getErrorCode());
                  }
                }
                try (ResultSet resultSet = transaction.executeQuery(SELECT1)) {
                  while (resultSet.next()) {}
                }
                return null;
              });
      assertEquals(2, attempts.get());
      assertEquals(1, countRequests(BeginTransactionRequest.class));
      assertEquals(1, countRequests(CommitRequest.class));

      // Also verify an inlined-begin Read failing synchronously where the user catches the error
      // and only buffers a mutation; CommitRunnable awaits transactionIdFuture and retries with an
      // explicit BeginTransaction RPC.
      mockSpanner.reset();
      AtomicInteger readAndBufferAttempts = new AtomicInteger();
      customClient
          .readWriteTransaction()
          .run(
              transaction -> {
                if (readAndBufferAttempts.incrementAndGet() == 1) {
                  failNextStreamStart.set(true);
                  try (ResultSet resultSet =
                      transaction.read("FOO", KeySet.all(), Collections.singletonList("ID"))) {
                    SpannerException readError =
                        assertThrows(SpannerException.class, resultSet::next);
                    assertEquals(ErrorCode.UNKNOWN, readError.getErrorCode());
                  }
                }
                transaction.buffer(Mutation.newInsertBuilder("FOO").set("ID").to(1L).build());
                return null;
              });
      assertEquals(2, readAndBufferAttempts.get());
      assertEquals(1, countRequests(BeginTransactionRequest.class));
      assertEquals(1, countRequests(CommitRequest.class));

      // Also verify initiateStreaming() failing synchronously before next() is called: only
      // TransactionContextImpl.onStartFailed runs during initiateStreaming(), and it must
      // immediately complete transactionIdFuture with a simulated AbortedException so a subsequent
      // statement on the transaction fails fast with AbortedException and triggers a retry.
      mockSpanner.reset();
      AtomicInteger initiateStreamingAttempts = new AtomicInteger();
      customClient
          .readWriteTransaction()
          .run(
              transaction -> {
                if (initiateStreamingAttempts.incrementAndGet() == 1) {
                  failNextStreamStart.set(true);
                  try (ResultSet resultSet = transaction.executeQuery(SELECT1)) {
                    assertThrows(
                        IllegalStateException.class,
                        () ->
                            ((StreamingResultSet) resultSet)
                                .initiateStreaming((message, prefetchChunks) -> {}));
                  }
                }
                assertEquals(1L, transaction.executeUpdate(UPDATE_STATEMENT));
                return null;
              });
      assertEquals(2, initiateStreamingAttempts.get());
      assertEquals(1, countRequests(BeginTransactionRequest.class));
      assertEquals(1, countRequests(CommitRequest.class));
    }
  }

  @Test(timeout = 10_000)
  public void synchronousStartFailureWithLastStatementDoesNotRetry() {
    AtomicBoolean failNextStreamStart = new AtomicBoolean();
    SpannerOptions options = createSpannerOptionsWithFailingStreamStart(failNextStreamStart);
    AtomicInteger attempts = new AtomicInteger();
    try (Spanner customSpanner = options.getService()) {
      DatabaseClient customClient =
          customSpanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
      SpannerException exception =
          assertThrows(
              SpannerException.class,
              () ->
                  customClient
                      .readWriteTransaction()
                      .run(
                          transaction -> {
                            attempts.incrementAndGet();
                            failNextStreamStart.set(true);
                            try (ResultSet resultSet =
                                transaction.executeQuery(SELECT1, Options.lastStatement())) {
                              SpannerException firstError =
                                  assertThrows(SpannerException.class, resultSet::next);
                              assertEquals(ErrorCode.UNKNOWN, firstError.getErrorCode());
                            }
                            // Executing a second statement awaits transactionIdFuture in
                            // getTransactionSelector(). Because the initial statement had
                            // lastStatement=true, transactionIdFuture was completed with the
                            // original exception rather than a simulated AbortedException, so
                            // this rethrows UNKNOWN without retrying the transaction.
                            try (ResultSet secondResultSet = transaction.executeQuery(SELECT1)) {
                              secondResultSet.next();
                            }
                            return null;
                          }));
      assertEquals(ErrorCode.UNKNOWN, exception.getErrorCode());
      assertEquals(1, attempts.get());

      // Also verify the uncaught single-statement path where rollbackAsync() awaits
      // transactionIdFuture and completes immediately without hanging or retrying.
      AtomicInteger uncaughtAttempts = new AtomicInteger();
      SpannerException uncaughtException =
          assertThrows(
              SpannerException.class,
              () ->
                  customClient
                      .readWriteTransaction()
                      .run(
                          transaction -> {
                            uncaughtAttempts.incrementAndGet();
                            failNextStreamStart.set(true);
                            try (ResultSet resultSet =
                                transaction.executeQuery(SELECT1, Options.lastStatement())) {
                              resultSet.next();
                            }
                            return null;
                          }));
      assertEquals(ErrorCode.UNKNOWN, uncaughtException.getErrorCode());
      assertEquals(1, uncaughtAttempts.get());

      // Also verify CommitRunnable.run() awaiting transactionIdFuture when lastStatement=true
      // stored a raw IllegalStateException in transactionIdFuture and the caller caught the query
      // failure and buffered a mutation.
      AtomicInteger commitAttempts = new AtomicInteger();
      SpannerException commitException =
          assertThrows(
              SpannerException.class,
              () ->
                  customClient
                      .readWriteTransaction()
                      .run(
                          transaction -> {
                            commitAttempts.incrementAndGet();
                            failNextStreamStart.set(true);
                            try (ResultSet resultSet =
                                transaction.executeQuery(SELECT1, Options.lastStatement())) {
                              SpannerException firstError =
                                  assertThrows(SpannerException.class, resultSet::next);
                              assertEquals(ErrorCode.UNKNOWN, firstError.getErrorCode());
                            }
                            transaction.buffer(
                                Mutation.newInsertBuilder("FOO").set("ID").to(1L).build());
                            return null;
                          }));
      assertEquals(ErrorCode.UNKNOWN, commitException.getErrorCode());
      assertEquals(1, commitAttempts.get());

      // Also verify initiateStreaming() failing synchronously when lastStatement=true: only
      // TransactionContextImpl.onStartFailed runs during initiateStreaming(), and it must
      // immediately complete transactionIdFuture with the converted SpannerException so commit()
      // fails immediately with UNKNOWN without retrying.
      AtomicInteger initiateStreamingLastStatementAttempts = new AtomicInteger();
      SpannerException initiateStreamingCommitException =
          assertThrows(
              SpannerException.class,
              () ->
                  customClient
                      .readWriteTransaction()
                      .run(
                          transaction -> {
                            initiateStreamingLastStatementAttempts.incrementAndGet();
                            failNextStreamStart.set(true);
                            try (ResultSet resultSet =
                                transaction.executeQuery(SELECT1, Options.lastStatement())) {
                              assertThrows(
                                  IllegalStateException.class,
                                  () ->
                                      ((StreamingResultSet) resultSet)
                                          .initiateStreaming((message, prefetchChunks) -> {}));
                            }
                            transaction.buffer(
                                Mutation.newInsertBuilder("FOO").set("ID").to(1L).build());
                            return null;
                          }));
      assertEquals(ErrorCode.UNKNOWN, initiateStreamingCommitException.getErrorCode());
      assertEquals(1, initiateStreamingLastStatementAttempts.get());
    }
  }

  @Test(timeout = 10_000)
  public void synchronousStartFailureWithAbortedOrInvalidatedTransactionRetries() throws Exception {
    AtomicBoolean failNextStreamStart = new AtomicBoolean();
    AtomicReference<Supplier<RuntimeException>> failureSupplierRef = new AtomicReference<>();
    SpannerOptions options =
        createSpannerOptionsWithFailingStreamStart(
            failNextStreamStart, () -> failureSupplierRef.get().get());
    try (Spanner customSpanner = options.getService()) {
      DatabaseClient customClient =
          customSpanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));

      // 1. When an inlined-begin statement with lastStatement=true fails synchronously with a raw
      // StatusRuntimeException(ABORTED) while a concurrent follower thread is blocked on
      // transactionIdFuture.get() in getTransactionSelector(), onStartFailed converts the raw
      // throwable to AbortedException so the follower thread sees e.getCause() instanceof
      // AbortedException, marks the transaction aborted, and the transaction retries with an
      // explicit BeginTransaction RPC.
      mockSpanner.reset();
      AtomicInteger abortedAttempts = new AtomicInteger();
      customClient
          .readWriteTransaction()
          .run(
              transaction -> {
                if (abortedAttempts.incrementAndGet() == 1) {
                  CountDownLatch leaderEnteredStartLatch = new CountDownLatch(1);
                  CountDownLatch followerStartedLatch = new CountDownLatch(1);
                  AtomicReference<Thread> followerThread = new AtomicReference<>();
                  SettableApiFuture<SpannerException> followerFailure = SettableApiFuture.create();
                  failureSupplierRef.set(
                      () -> {
                        leaderEnteredStartLatch.countDown();
                        try {
                          assertTrue(followerStartedLatch.await(5, TimeUnit.SECONDS));
                        } catch (InterruptedException interruptedException) {
                          Thread.currentThread().interrupt();
                          throw new RuntimeException(interruptedException);
                        }
                        while (followerThread.get().getState() != Thread.State.TIMED_WAITING
                            && !followerFailure.isDone()) {
                          Thread.yield();
                        }
                        return Status.ABORTED.asRuntimeException();
                      });
                  failNextStreamStart.set(true);
                  Thread thread =
                      new Thread(
                          () -> {
                            try {
                              assertTrue(leaderEnteredStartLatch.await(5, TimeUnit.SECONDS));
                              followerStartedLatch.countDown();
                              try (ResultSet followerResultSet =
                                  transaction.executeQuery(SELECT1)) {
                                followerResultSet.next();
                              }
                            } catch (SpannerException spannerException) {
                              followerFailure.set(spannerException);
                            } catch (Throwable throwable) {
                              followerFailure.setException(throwable);
                            }
                          });
                  followerThread.set(thread);
                  thread.start();

                  try (ResultSet firstResultSet =
                      transaction.executeQuery(SELECT1, Options.lastStatement())) {
                    SpannerException firstException =
                        assertThrows(SpannerException.class, firstResultSet::next);
                    assertEquals(ErrorCode.ABORTED, firstException.getErrorCode());
                  }
                  SpannerException followerException = followerFailure.get(5, TimeUnit.SECONDS);
                  assertTrue(followerException instanceof AbortedException);
                  thread.join(5_000);
                  throw followerException;
                }
                try (ResultSet resultSet =
                    transaction.executeQuery(SELECT1, Options.lastStatement())) {
                  while (resultSet.next()) {}
                }
                return null;
              });
      assertEquals(2, abortedAttempts.get());
      assertEquals(1, countRequests(BeginTransactionRequest.class));
      assertEquals(1, countRequests(CommitRequest.class));

      // 2. When an inlined-begin statement fails synchronously with CANCELLED ("Transaction was
      // invalidated by a later transaction in the same session"), ResumableStreamIterator preserves
      // withBeginTransaction=true so GrpcResultSet.next() passes withBeginTransaction=true to
      // TransactionRunnerImpl.onError, which marks the transaction aborted and retries with an
      // explicit BeginTransaction RPC even when lastStatement=true.
      mockSpanner.reset();
      failureSupplierRef.set(
          () ->
              Status.CANCELLED
                  .withDescription(
                      "Transaction was invalidated by a later transaction in the same session")
                  .asRuntimeException());
      AtomicInteger invalidatedAttempts = new AtomicInteger();
      customClient
          .readWriteTransaction()
          .run(
              transaction -> {
                if (invalidatedAttempts.incrementAndGet() == 1) {
                  failNextStreamStart.set(true);
                }
                try (ResultSet resultSet =
                    transaction.executeQuery(SELECT1, Options.lastStatement())) {
                  while (resultSet.next()) {}
                }
                return null;
              });
      assertEquals(2, invalidatedAttempts.get());
      assertEquals(1, countRequests(BeginTransactionRequest.class));
      assertEquals(1, countRequests(CommitRequest.class));

      // 3. When an inlined-begin statement with lastStatement=true fails synchronously with
      // CANCELLED ("Transaction was invalidated by a later transaction in the same session") and
      // the caller catches the exception and buffers a mutation, CommitRunnable awaits
      // transactionIdFuture, which must hold the translated AbortedException so the transaction
      // retries with an explicit BeginTransaction RPC instead of failing commit() with CANCELLED.
      mockSpanner.reset();
      AtomicInteger invalidatedAndBufferedAttempts = new AtomicInteger();
      customClient
          .readWriteTransaction()
          .run(
              transaction -> {
                if (invalidatedAndBufferedAttempts.incrementAndGet() == 1) {
                  failNextStreamStart.set(true);
                  try (ResultSet resultSet =
                      transaction.executeQuery(SELECT1, Options.lastStatement())) {
                    SpannerException firstException =
                        assertThrows(SpannerException.class, resultSet::next);
                    assertEquals(ErrorCode.ABORTED, firstException.getErrorCode());
                  }
                }
                transaction.buffer(Mutation.newInsertBuilder("FOO").set("ID").to(1L).build());
                return null;
              });
      assertEquals(2, invalidatedAndBufferedAttempts.get());
      assertEquals(1, countRequests(BeginTransactionRequest.class));
      assertEquals(1, countRequests(CommitRequest.class));

      // 4. Same scenario when the CANCELLED ("Transaction was invalidated...") error is returned
      // asynchronously on the gRPC stream (exercising TransactionRunnerImpl.onError translating
      // the error before completing transactionIdFuture when lastStatement=true).
      mockSpanner.reset();
      mockSpanner.setExecuteStreamingSqlExecutionTime(
          SimulatedExecutionTime.ofException(
              Status.CANCELLED
                  .withDescription(
                      "Transaction was invalidated by a later transaction in the same session")
                  .asRuntimeException()));
      AtomicInteger streamInvalidatedAndBufferedAttempts = new AtomicInteger();
      customClient
          .readWriteTransaction()
          .run(
              transaction -> {
                if (streamInvalidatedAndBufferedAttempts.incrementAndGet() == 1) {
                  try (ResultSet resultSet =
                      transaction.executeQuery(SELECT1, Options.lastStatement())) {
                    SpannerException firstException =
                        assertThrows(SpannerException.class, resultSet::next);
                    assertEquals(ErrorCode.ABORTED, firstException.getErrorCode());
                  }
                }
                transaction.buffer(Mutation.newInsertBuilder("FOO").set("ID").to(1L).build());
                return null;
              });
      assertEquals(2, streamInvalidatedAndBufferedAttempts.get());
      assertEquals(1, countRequests(BeginTransactionRequest.class));
      assertEquals(1, countRequests(CommitRequest.class));
    }
  }

  @Test(timeout = 10_000)
  public void cancelDuringRetryBackoffOfInlinedBeginStatementFailsTransactionIdFuture() {
    // When an inlined-begin stream fails with a retryable UNAVAILABLE before receiving a resume
    // token, ResumableStreamIterator sets stream = null and enters backoffSleep. Note that
    // startStream() succeeded, so onStartFailed was not called and transactionIdFuture is still
    // pending. If the gRPC Context is cancelled during backoffSleep, GrpcResultSet.next() catches
    // the cancellation exception while ResumableStreamIterator.stream is null. The
    // isWithBeginTransaction() and isLastStatement() overrides on the anonymous
    // ResumableStreamIterator must still report true and lastStatement so onError completes
    // transactionIdFuture appropriately (simulated ABORTED when lastStatement=false, or CANCELLED
    // without retry when lastStatement=true).
    AtomicReference<CountDownLatch> firstAttemptDeliveredErrorLatch = new AtomicReference<>();
    AtomicBoolean deliverTransientUnavailable = new AtomicBoolean(true);
    SpannerOptions options =
        createSpannerOptionsWithStreamInterceptors(
            (invocation, delegate) -> {
              if (deliverTransientUnavailable.get()) {
                SpannerRpc.ResultStreamConsumer consumer = invocation.getArgument(1);
                // Deliver UNAVAILABLE with a 5s retry delay on the first attempt so
                // ResumableStreamIterator sets stream = null and parks in
                // backoffSleep until the Context is cancelled.
                consumer.onError(
                    SpannerExceptionFactory.newSpannerException(
                        ErrorCode.UNAVAILABLE,
                        "simulated transient stream failure",
                        SpannerExceptionFactory.createAbortedExceptionWithRetryDelay(
                            "simulated transient stream failure", null, 5, 0)));
                CountDownLatch latch = firstAttemptDeliveredErrorLatch.get();
                if (latch != null) {
                  latch.countDown();
                }
                return new SpannerRpc.StreamingCall() {
                  @Override
                  public ApiCallContext getCallContext() {
                    return null;
                  }

                  @Override
                  public void cancel(String message) {}

                  @Override
                  public void request(int numMessages) {}
                };
              }
              return delegateExecuteQuery(invocation, delegate);
            },
            ReadWriteTransactionWithInlineBeginTest::delegateRead);

    try (Spanner customSpanner = options.getService()) {
      DatabaseClient customClient =
          customSpanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));

      // 1. With Options.lastStatement(): cancelling the Context during backoffSleep must pass
      //    withBeginTransaction=true and lastStatement=true to onError so transactionIdFuture is
      //    completed with CANCELLED (not simulated ABORTED), and commit() fails with CANCELLED
      //    after 1 attempt rather than retrying.
      CountDownLatch latch1 = new CountDownLatch(1);
      firstAttemptDeliveredErrorLatch.set(latch1);
      AtomicInteger lastStatementAttempts = new AtomicInteger();
      SpannerException lastStatementException =
          assertThrows(
              SpannerException.class,
              () ->
                  customClient
                      .readWriteTransaction()
                      .run(
                          transaction -> {
                            lastStatementAttempts.incrementAndGet();
                            Thread consumerThread = Thread.currentThread();
                            try (Context.CancellableContext cancellableContext =
                                Context.current().withCancellation()) {
                              Thread canceller =
                                  new Thread(
                                      () -> {
                                        try {
                                          assertTrue(latch1.await(5, TimeUnit.SECONDS));
                                        } catch (InterruptedException interruptedException) {
                                          Thread.currentThread().interrupt();
                                          return;
                                        }
                                        while (consumerThread.getState()
                                                != Thread.State.TIMED_WAITING
                                            && consumerThread.isAlive()) {
                                          Thread.yield();
                                        }
                                        cancellableContext.cancel(
                                            new CancellationException("cancelled during backoff"));
                                      });
                              cancellableContext.run(
                                  () -> {
                                    canceller.start();
                                    try (ResultSet resultSet =
                                        transaction.executeQuery(
                                            SELECT1, Options.lastStatement())) {
                                      SpannerException exception =
                                          assertThrows(SpannerException.class, resultSet::next);
                                      assertEquals(ErrorCode.CANCELLED, exception.getErrorCode());
                                    }
                                  });
                              canceller.join(5_000);
                            }
                            transaction.buffer(
                                Mutation.newInsertBuilder("FOO").set("ID").to(1L).build());
                            return null;
                          }));
      assertEquals(ErrorCode.CANCELLED, lastStatementException.getErrorCode());
      assertEquals(1, lastStatementAttempts.get());

      // 2. Without Options.lastStatement() (lastStatement=false): cancelling the Context during
      //    backoffSleep must pass withBeginTransaction=true and lastStatement=false to onError so
      //    transactionIdFuture is completed with a simulated AbortedException, and commit() retries
      //    the transaction with an explicit BeginTransaction RPC.
      mockSpanner.reset();
      CountDownLatch latch2 = new CountDownLatch(1);
      firstAttemptDeliveredErrorLatch.set(latch2);
      AtomicInteger nonLastStatementAttempts = new AtomicInteger();
      customClient
          .readWriteTransaction()
          .run(
              transaction -> {
                if (nonLastStatementAttempts.incrementAndGet() == 1) {
                  Thread consumerThread = Thread.currentThread();
                  try (Context.CancellableContext cancellableContext =
                      Context.current().withCancellation()) {
                    Thread canceller =
                        new Thread(
                            () -> {
                              try {
                                assertTrue(latch2.await(5, TimeUnit.SECONDS));
                              } catch (InterruptedException interruptedException) {
                                Thread.currentThread().interrupt();
                                return;
                              }
                              while (consumerThread.getState() != Thread.State.TIMED_WAITING
                                  && consumerThread.isAlive()) {
                                Thread.yield();
                              }
                              deliverTransientUnavailable.set(false);
                              cancellableContext.cancel(
                                  new CancellationException("cancelled during backoff"));
                            });
                    cancellableContext.run(
                        () -> {
                          canceller.start();
                          try (ResultSet resultSet = transaction.executeQuery(SELECT1)) {
                            SpannerException exception =
                                assertThrows(SpannerException.class, resultSet::next);
                            assertEquals(ErrorCode.CANCELLED, exception.getErrorCode());
                          }
                        });
                    canceller.join(5_000);
                  }
                }
                transaction.buffer(Mutation.newInsertBuilder("FOO").set("ID").to(1L).build());
                return null;
              });
      assertEquals(2, nonLastStatementAttempts.get());
      assertEquals(1, countRequests(BeginTransactionRequest.class));
      assertEquals(1, countRequests(CommitRequest.class));
    }
  }

  @Test(timeout = 10_000)
  public void closeBeforeTransactionIdReturnedDoesNotRaceWithCancelledConsumer() throws Exception {
    // Deterministic reproduction of the race between GrpcResultSet.close() and a consumer thread
    // blocked in GrpcResultSet.next() when the inlined-begin stream has not yet returned a
    // transaction ID:
    // 1. GrpcResultSet.close() calls iterator.close("ResultSet closed"), which cancels the gRPC
    //    call and wakes the blocked consumer thread before GrpcResultSet.close() reaches
    //    listener.onDone(true).
    // 2. When the woken consumer thread catches the stream termination error in
    // GrpcResultSet.next()
    //    and calls yieldError(e, iterator.isWithBeginTransaction() && currRow == null, ...),
    //    iterator.isWithBeginTransaction() must return false because the iterator is already
    //    closed, so onError does not overwrite transactionIdFuture with a simulated ABORTED before
    //    onDone(true) sets FAILED_PRECONDITION.
    CountDownLatch consumerFinishedNextLatch = new CountDownLatch(1);
    SpannerOptions options =
        createSpannerOptionsWithStreamInterceptors(
            (invocation, delegate) -> {
              SpannerRpc.StreamingCall delegateCall = delegateExecuteQuery(invocation, delegate);
              return new SpannerRpc.StreamingCall() {
                @Override
                public ApiCallContext getCallContext() {
                  return delegateCall.getCallContext();
                }

                @Override
                public void cancel(String message) {
                  delegateCall.cancel(message);
                  try {
                    assertTrue(consumerFinishedNextLatch.await(5, TimeUnit.SECONDS));
                  } catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                  }
                }

                @Override
                public void request(int numMessages) {
                  delegateCall.request(numMessages);
                }
              };
            },
            ReadWriteTransactionWithInlineBeginTest::delegateRead);

    ExecutorService executor = Executors.newFixedThreadPool(2);
    try (Spanner customSpanner = options.getService()) {
      DatabaseClient customClient =
          customSpanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
      SpannerException exception =
          assertThrows(
              SpannerException.class,
              () ->
                  customClient
                      .readWriteTransaction()
                      .run(
                          transaction -> {
                            mockSpanner.freeze();
                            ResultSet resultSet = transaction.executeQuery(SELECT1);
                            Future<?> nextFuture =
                                executor.submit(
                                    () -> {
                                      try {
                                        resultSet.next();
                                      } finally {
                                        consumerFinishedNextLatch.countDown();
                                      }
                                    });
                            try {
                              mockSpanner.waitForRequestsToContain(ExecuteSqlRequest.class, 5000);
                            } catch (Exception exceptionFromWait) {
                              throw new RuntimeException(exceptionFromWait);
                            }
                            resultSet.close();
                            mockSpanner.unfreeze();
                            ExecutionException consumerExecutionException =
                                assertThrows(
                                    ExecutionException.class,
                                    () -> nextFuture.get(5, TimeUnit.SECONDS));
                            assertTrue(
                                consumerExecutionException.getCause() instanceof SpannerException);
                            SpannerException consumerException =
                                (SpannerException) consumerExecutionException.getCause();
                            assertNotEquals(ErrorCode.ABORTED, consumerException.getErrorCode());
                            return transaction.executeUpdate(UPDATE_STATEMENT);
                          }));
      assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
      assertTrue(
          exception
              .getMessage()
              .contains("ResultSet was closed before a transaction id was returned"));
    } finally {
      mockSpanner.unfreeze();
      executor.shutdownNow();
    }
  }

  @Test
  public void inlinedBeginReadWithStreamRetryBeforeAndAfterResumeToken() {
    // 1. Stream retry before receiving a resumeToken (errorIndex == 0): both ReadRequests must
    //    keep the inlined BeginTransaction selector and an empty resumeToken.
    mockSpanner.setStreamingReadExecutionTime(
        SimulatedExecutionTime.ofStreamException(Status.UNAVAILABLE.asRuntimeException(), 0));
    List<Long> valuesBeforeResumeToken =
        client
            .readWriteTransaction()
            .run(
                transaction -> {
                  List<Long> values = new ArrayList<>();
                  try (ResultSet resultSet =
                      transaction.read(
                          "FOO_TWO_ROWS", KeySet.all(), Collections.singletonList("ID"))) {
                    while (resultSet.next()) {
                      values.add(resultSet.getLong(0));
                    }
                  }
                  return values;
                });
    assertEquals(Arrays.asList(1L, 2L), valuesBeforeResumeToken);
    assertEquals(0, countRequests(BeginTransactionRequest.class));
    assertEquals(2, countRequests(ReadRequest.class));
    assertEquals(1, countRequests(CommitRequest.class));
    List<ReadRequest> readRequestsBeforeResumeToken =
        mockSpanner.getRequestsOfType(ReadRequest.class);
    assertTrue(readRequestsBeforeResumeToken.get(0).getTransaction().getBegin().hasReadWrite());
    assertEquals(ByteString.EMPTY, readRequestsBeforeResumeToken.get(0).getResumeToken());
    assertTrue(readRequestsBeforeResumeToken.get(1).getTransaction().getBegin().hasReadWrite());
    assertEquals(ByteString.EMPTY, readRequestsBeforeResumeToken.get(1).getResumeToken());

    mockSpanner.reset();
    mockSpanner.removeAllExecutionTimes();

    // 2. Stream retry after receiving a resumeToken (errorIndex == 1): the first ReadRequest has
    //    the inlined BeginTransaction selector and an empty resumeToken, while the resumed
    //    ReadRequest replaces BeginTransaction with the transaction ID and sets resumeToken.
    mockSpanner.setStreamingReadExecutionTime(
        SimulatedExecutionTime.ofStreamException(Status.UNAVAILABLE.asRuntimeException(), 1));
    List<Long> valuesAfterResumeToken =
        client
            .readWriteTransaction()
            .run(
                transaction -> {
                  List<Long> values = new ArrayList<>();
                  try (ResultSet resultSet =
                      transaction.read(
                          "FOO_TWO_ROWS", KeySet.all(), Collections.singletonList("ID"))) {
                    while (resultSet.next()) {
                      values.add(resultSet.getLong(0));
                    }
                  }
                  return values;
                });
    assertEquals(Arrays.asList(1L, 2L), valuesAfterResumeToken);
    assertEquals(0, countRequests(BeginTransactionRequest.class));
    assertEquals(2, countRequests(ReadRequest.class));
    assertEquals(1, countRequests(CommitRequest.class));
    assertEquals(1, countTransactionsStarted());
    List<ReadRequest> readRequestsAfterResumeToken =
        mockSpanner.getRequestsOfType(ReadRequest.class);
    assertTrue(readRequestsAfterResumeToken.get(0).getTransaction().getBegin().hasReadWrite());
    assertEquals(ByteString.EMPTY, readRequestsAfterResumeToken.get(0).getTransaction().getId());
    assertEquals(ByteString.EMPTY, readRequestsAfterResumeToken.get(0).getResumeToken());
    assertFalse(readRequestsAfterResumeToken.get(1).getTransaction().hasBegin());
    assertNotEquals(ByteString.EMPTY, readRequestsAfterResumeToken.get(1).getTransaction().getId());
    assertNotEquals(ByteString.EMPTY, readRequestsAfterResumeToken.get(1).getResumeToken());
  }

  @Test
  public void subsequentQueryAndReadWithStreamRetryAfterResumeToken() {
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofStreamException(Status.UNAVAILABLE.asRuntimeException(), 1));
    mockSpanner.setStreamingReadExecutionTime(
        SimulatedExecutionTime.ofStreamException(Status.UNAVAILABLE.asRuntimeException(), 1));

    client
        .readWriteTransaction()
        .run(
            transaction -> {
              // First statement starts the transaction inline.
              assertEquals(1L, transaction.executeUpdate(UPDATE_STATEMENT));

              // Second statement (query) starts with transaction.id (hasBegin() == false) and
              // retries mid-stream with a resumeToken.
              List<Long> queryValues = new ArrayList<>();
              try (ResultSet queryResultSet = transaction.executeQuery(SELECT1_UNION_ALL_SELECT2)) {
                while (queryResultSet.next()) {
                  queryValues.add(queryResultSet.getLong(0));
                }
              }
              assertEquals(Arrays.asList(1L, 2L), queryValues);

              // Third statement (read) also starts with transaction.id (hasBegin() == false) and
              // retries mid-stream with a resumeToken.
              List<Long> readValues = new ArrayList<>();
              try (ResultSet readResultSet =
                  transaction.read("FOO_TWO_ROWS", KeySet.all(), Collections.singletonList("ID"))) {
                while (readResultSet.next()) {
                  readValues.add(readResultSet.getLong(0));
                }
              }
              assertEquals(Arrays.asList(1L, 2L), readValues);
              return null;
            });

    assertEquals(0, countRequests(BeginTransactionRequest.class));
    assertEquals(1, countTransactionsStarted());
    ByteString expectedTransactionId = mockSpanner.getTransactionsStarted().get(0);

    List<ExecuteSqlRequest> executeSqlRequests =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    // 1 DML + 2 streaming query attempts.
    assertEquals(3, executeSqlRequests.size());
    assertFalse(executeSqlRequests.get(1).getTransaction().hasBegin());
    assertEquals(expectedTransactionId, executeSqlRequests.get(1).getTransaction().getId());
    assertEquals(ByteString.EMPTY, executeSqlRequests.get(1).getResumeToken());
    assertFalse(executeSqlRequests.get(2).getTransaction().hasBegin());
    assertEquals(expectedTransactionId, executeSqlRequests.get(2).getTransaction().getId());
    assertNotEquals(ByteString.EMPTY, executeSqlRequests.get(2).getResumeToken());

    List<ReadRequest> readRequests = mockSpanner.getRequestsOfType(ReadRequest.class);
    assertEquals(2, readRequests.size());
    assertFalse(readRequests.get(0).getTransaction().hasBegin());
    assertEquals(expectedTransactionId, readRequests.get(0).getTransaction().getId());
    assertEquals(ByteString.EMPTY, readRequests.get(0).getResumeToken());
    assertFalse(readRequests.get(1).getTransaction().hasBegin());
    assertEquals(expectedTransactionId, readRequests.get(1).getTransaction().getId());
    assertNotEquals(ByteString.EMPTY, readRequests.get(1).getResumeToken());
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
