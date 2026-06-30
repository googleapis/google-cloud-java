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

import static com.google.cloud.spanner.MockSpannerTestUtil.INVALID_UPDATE_STATEMENT;
import static com.google.cloud.spanner.MockSpannerTestUtil.READ_COLUMN_NAMES;
import static com.google.cloud.spanner.MockSpannerTestUtil.READ_TABLE_NAME;
import static com.google.cloud.spanner.MockSpannerTestUtil.UPDATE_ABORTED_STATEMENT;
import static com.google.cloud.spanner.MockSpannerTestUtil.UPDATE_COUNT;
import static com.google.cloud.spanner.MockSpannerTestUtil.UPDATE_STATEMENT;
import static com.google.cloud.spanner.SpannerApiFutures.get;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.cloud.spanner.AsyncTransactionManager.AsyncTransactionFunction;
import com.google.cloud.spanner.AsyncTransactionManager.AsyncTransactionStep;
import com.google.cloud.spanner.AsyncTransactionManager.CommitTimestampFuture;
import com.google.cloud.spanner.AsyncTransactionManager.TransactionContextFuture;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.Options.ReadOption;
import com.google.cloud.spanner.TransactionRunnerImpl.TransactionContextImpl;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Range;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Message;
import com.google.spanner.v1.BatchCreateSessionsRequest;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.RollbackRequest;
import com.google.spanner.v1.TransactionSelector;
import io.grpc.Status;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AsyncTransactionManagerTest extends AbstractAsyncTransactionTest {

  @Parameter public Executor executor;

  @Parameters(name = "executor = {0}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {MoreExecutors.directExecutor()},
          {Executors.newSingleThreadExecutor()},
          {Executors.newFixedThreadPool(4)}
        });
  }

  /**
   * Static helper methods that simplifies creating {@link AsyncTransactionFunction}s for Java7.
   * Java8 and higher can use lambda expressions.
   */
  public static class AsyncTransactionManagerHelper {

    public static <I> AsyncTransactionFunction<I, AsyncResultSet> readAsync(
        final String table,
        final KeySet keys,
        final Iterable<String> columns,
        final ReadOption... options) {
      return (transaction, ignored) ->
          ApiFutures.immediateFuture(transaction.readAsync(table, keys, columns, options));
    }

    public static <I> AsyncTransactionFunction<I, Struct> readRowAsync(
        final String table, final Key key, final Iterable<String> columns) {
      return (transaction, ignored) -> transaction.readRowAsync(table, key, columns);
    }

    public static <I> AsyncTransactionFunction<I, Void> buffer(Mutation mutation) {
      return buffer(ImmutableList.of(mutation));
    }

    public static <I> AsyncTransactionFunction<I, Void> buffer(final Iterable<Mutation> mutations) {
      return (transaction, ignored) -> {
        transaction.buffer(mutations);
        return ApiFutures.immediateFuture(null);
      };
    }

    public static <I> AsyncTransactionFunction<I, Long> executeUpdateAsync(Statement statement) {
      return executeUpdateAsync(SettableApiFuture.create(), statement);
    }

    public static <I> AsyncTransactionFunction<I, Long> executeUpdateAsync(
        final SettableApiFuture<Long> result, final Statement statement) {
      return (transaction, ignored) -> {
        ApiFuture<Long> updateCount = transaction.executeUpdateAsync(statement);
        ApiFutures.addCallback(
            updateCount,
            new ApiFutureCallback<Long>() {
              @Override
              public void onFailure(Throwable t) {
                result.setException(t);
              }

              @Override
              public void onSuccess(Long input) {
                result.set(input);
              }
            },
            MoreExecutors.directExecutor());
        return updateCount;
      };
    }

    public static <I> AsyncTransactionFunction<I, long[]> batchUpdateAsync(
        final Statement... statements) {
      return batchUpdateAsync(SettableApiFuture.create(), statements);
    }

    public static <I> AsyncTransactionFunction<I, long[]> batchUpdateAsync(
        final SettableApiFuture<long[]> result, final Statement... statements) {
      return (transaction, ignored) -> {
        ApiFuture<long[]> updateCounts = transaction.batchUpdateAsync(Arrays.asList(statements));
        ApiFutures.addCallback(
            updateCounts,
            new ApiFutureCallback<long[]>() {
              @Override
              public void onFailure(Throwable t) {
                result.setException(t);
              }

              @Override
              public void onSuccess(long[] input) {
                result.set(input);
              }
            },
            MoreExecutors.directExecutor());
        return updateCounts;
      };
    }
  }

  @Test
  public void asyncTransactionManager_shouldRollbackOnCloseAsync() throws Exception {
    AsyncTransactionManager manager = client().transactionManagerAsync();
    TransactionContext txn = manager.beginAsync().get();
    txn.executeUpdateAsync(UPDATE_STATEMENT).get();
    TransactionContextImpl impl = (TransactionContextImpl) txn;
    final TransactionSelector selector = impl.getTransactionSelector();

    SpannerApiFutures.get(manager.closeAsync());
    // The mock server should already have the Rollback request, as we are waiting for the returned
    // ApiFuture to be done.
    mockSpanner.waitForRequestsToContain(
        input -> {
          if (input instanceof RollbackRequest) {
            RollbackRequest request = (RollbackRequest) input;
            return request.getTransactionId().equals(selector.getId());
          }
          return false;
        },
        0L);
  }

  @Test
  public void testAsyncTransactionManager_getCommitResponseReturnsErrorBeforeCommit() {
    try (AsyncTransactionManager manager = client().transactionManagerAsync()) {
      TransactionContextFuture transactionContextFuture = manager.beginAsync();
      assertThrows(IllegalStateException.class, manager::getCommitResponse);
    }
  }

  @Test
  public void testAsyncTransactionManager_returnsCommitStats() throws Exception {
    try (AsyncTransactionManager manager =
        client().transactionManagerAsync(Options.commitStats())) {
      TransactionContextFuture transactionContextFuture = manager.beginAsync();
      while (true) {
        try {
          CommitTimestampFuture commitTimestamp =
              transactionContextFuture
                  .then(
                      (transactionContext, ignored) ->
                          transactionContext.bufferAsync(
                              Collections.singleton(Mutation.delete("FOO", Key.of("foo")))),
                      executor)
                  .commitAsync();
          assertNotNull(commitTimestamp.get());
          assertNotNull(manager.getCommitResponse().get());
          assertNotNull(manager.getCommitResponse().get().getCommitStats());
          assertEquals(1L, manager.getCommitResponse().get().getCommitStats().getMutationCount());
          break;
        } catch (AbortedException e) {
          transactionContextFuture = manager.resetForRetryAsync();
        }
      }
    }
  }

  @Test
  public void asyncTransactionManagerUpdate() throws Exception {
    try (AsyncTransactionManager manager = client().transactionManagerAsync()) {
      TransactionContextFuture transactionContextFuture = manager.beginAsync();
      while (true) {
        try {
          AsyncTransactionStep<Void, Long> updateCount =
              transactionContextFuture.then(
                  (transactionContext, ignored) ->
                      transactionContext.executeUpdateAsync(UPDATE_STATEMENT),
                  executor);
          CommitTimestampFuture commitTimestamp = updateCount.commitAsync();
          assertThat(updateCount.get()).isEqualTo(UPDATE_COUNT);
          assertThat(commitTimestamp.get()).isNotNull();
          break;
        } catch (AbortedException e) {
          transactionContextFuture = manager.resetForRetryAsync();
        }
      }
    }
  }

  @Test
  public void asyncTransactionManagerIsNonBlocking() throws Exception {
    // TODO: Remove this condition once DelayedAsyncTransactionManager is made non-blocking with
    // multiplexed sessions.
    assumeFalse(
        "DelayedAsyncTransactionManager is currently blocking with multiplexed sessions.",
        spanner.getOptions().getSessionPoolOptions().getUseMultiplexedSessionForRW());
    mockSpanner.freeze();
    try (AsyncTransactionManager manager = client().transactionManagerAsync()) {
      TransactionContextFuture transactionContextFuture = manager.beginAsync();
      while (true) {
        try {
          AsyncTransactionStep<Void, Long> updateCount =
              transactionContextFuture.then(
                  (transactionContext, ignored) ->
                      transactionContext.executeUpdateAsync(UPDATE_STATEMENT),
                  executor);
          CommitTimestampFuture commitTimestamp = updateCount.commitAsync();
          mockSpanner.unfreeze();
          assertThat(updateCount.get(10L, TimeUnit.SECONDS)).isEqualTo(UPDATE_COUNT);
          assertThat(commitTimestamp.get(10L, TimeUnit.SECONDS)).isNotNull();
          break;
        } catch (AbortedException e) {
          transactionContextFuture = manager.resetForRetryAsync();
        }
      }
    }
  }

  @Test
  public void asyncTransactionManagerInvalidUpdate() throws Exception {
    try (AsyncTransactionManager manager = client().transactionManagerAsync()) {
      TransactionContextFuture transactionContextFuture = manager.beginAsync();
      CommitTimestampFuture commitTimestamp =
          transactionContextFuture
              .then(
                  (transaction, ignored) ->
                      transaction.executeUpdateAsync(INVALID_UPDATE_STATEMENT),
                  executor)
              .commitAsync();
      SpannerException e = assertThrows(SpannerException.class, () -> get(commitTimestamp));
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
      assertThat(e.getMessage()).contains("invalid statement");
    }
  }

  @Test
  public void asyncTransactionManagerCommitAborted() throws Exception {
    final AtomicInteger attempt = new AtomicInteger();
    CountDownLatch abortedLatch = new CountDownLatch(1);
    try (AsyncTransactionManager manager = client().transactionManagerAsync()) {
      TransactionContextFuture transactionContextFuture = manager.beginAsync();
      while (true) {
        try {
          attempt.incrementAndGet();
          AsyncTransactionStep<Void, Long> updateCount =
              transactionContextFuture.then(
                  (transaction, ignored) -> transaction.executeUpdateAsync(UPDATE_STATEMENT),
                  executor);
          updateCount.then(
              (transaction, ignored) -> {
                if (attempt.get() == 1) {
                  mockSpanner.abortTransaction(transaction);
                  abortedLatch.countDown();
                }
                return ApiFutures.immediateFuture(null);
              },
              executor);
          abortedLatch.await(10L, TimeUnit.SECONDS);
          CommitTimestampFuture commitTimestamp = updateCount.commitAsync();
          assertThat(updateCount.get()).isEqualTo(UPDATE_COUNT);
          assertThat(commitTimestamp.get()).isNotNull();
          assertThat(attempt.get()).isEqualTo(2);
          break;
        } catch (AbortedException e) {
          transactionContextFuture = manager.resetForRetryAsync();
        }
      }
    }
  }

  @Test
  public void asyncTransactionManagerFireAndForgetInvalidUpdate() throws Exception {
    try (AsyncTransactionManager manager = client().transactionManagerAsync()) {
      TransactionContextFuture transactionContextFuture = manager.beginAsync();
      while (true) {
        try {
          AsyncTransactionStep<Void, Long> transaction =
              transactionContextFuture.then(
                  (transactionContext, ignored) -> {
                    // This fire-and-forget update statement should not fail the transaction.
                    // The exception will however cause the transaction to be retried, as the
                    // statement will not return a transaction id.
                    transactionContext.executeUpdateAsync(INVALID_UPDATE_STATEMENT);
                    return transactionContext.executeUpdateAsync(UPDATE_STATEMENT);
                  },
                  executor);
          CommitTimestampFuture commitTimestamp = transaction.commitAsync();
          assertThat(commitTimestamp.get()).isNotNull();
          assertThat(transaction.get()).isEqualTo(UPDATE_COUNT);
          break;
        } catch (AbortedException e) {
          transactionContextFuture = manager.resetForRetryAsync();
        }
      }
    }
    ImmutableList<Class<? extends Message>> expectedRequestsWithMultiplexedSessionForRW =
        ImmutableList.of(
            CreateSessionRequest.class,
            // The first update that fails. This will cause a transaction retry.
            ExecuteSqlRequest.class,
            // The retry will use an explicit BeginTransaction call.
            BeginTransactionRequest.class,
            // The first update will again fail, but now there is a transaction id, so the
            // transaction can continue.
            ExecuteSqlRequest.class,
            ExecuteSqlRequest.class,
            CommitRequest.class);
    assertThat(mockSpanner.getRequestTypes())
        .containsExactlyElementsIn(expectedRequestsWithMultiplexedSessionForRW);
  }

  @Test
  public void asyncTransactionManagerChain() throws Exception {
    try (AsyncTransactionManager manager = client().transactionManagerAsync()) {
      TransactionContextFuture transactionContextFuture = manager.beginAsync();
      while (true) {
        try {
          CommitTimestampFuture commitTimestamp =
              transactionContextFuture
                  .then(
                      (transaction, ignored) -> transaction.executeUpdateAsync(UPDATE_STATEMENT),
                      executor)
                  .then(
                      (transactionContext, ignored) ->
                          transactionContext.readRowAsync(
                              READ_TABLE_NAME, Key.of(1L), READ_COLUMN_NAMES),
                      executor)
                  .then(
                      (ignored, input) -> ApiFutures.immediateFuture(input.getString("Value")),
                      executor)
                  .then(
                      (ignored, input) -> {
                        assertThat(input).isEqualTo("v1");
                        return ApiFutures.immediateFuture(null);
                      },
                      executor)
                  .commitAsync();
          assertThat(commitTimestamp.get()).isNotNull();
          break;
        } catch (AbortedException e) {
          transactionContextFuture = manager.resetForRetryAsync();
        }
      }
    }
  }

  @Test
  public void asyncTransactionManagerChainWithErrorInTheMiddle() throws Exception {
    try (AsyncTransactionManager manager = client().transactionManagerAsync()) {
      TransactionContextFuture transactionContextFuture = manager.beginAsync();
      while (true) {
        try {
          CommitTimestampFuture commitTimestampFuture =
              transactionContextFuture
                  .then(
                      (transactionContext, ignored) ->
                          transactionContext.executeUpdateAsync(INVALID_UPDATE_STATEMENT),
                      executor)
                  .then(
                      (ignored1, ignored2) -> {
                        throw new IllegalStateException("this should not be executed");
                      },
                      executor)
                  .commitAsync();
          SpannerException e =
              assertThrows(SpannerException.class, () -> get(commitTimestampFuture));
          assertThat(e.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
          break;
        } catch (AbortedException e) {
          transactionContextFuture = manager.resetForRetryAsync();
        }
      }
    }
  }

  @Test
  public void asyncTransactionManagerUpdateAborted() throws Exception {
    try (AsyncTransactionManager manager = client().transactionManagerAsync()) {
      // Temporarily set the result of the update to 2 rows.
      mockSpanner.putStatementResult(StatementResult.update(UPDATE_STATEMENT, UPDATE_COUNT + 1L));
      final AtomicInteger attempt = new AtomicInteger();

      TransactionContextFuture transactionContextFuture = manager.beginAsync();
      while (true) {
        try {
          CommitTimestampFuture commitTimestampFuture =
              transactionContextFuture
                  .then(
                      (ignored1, ignored2) -> {
                        if (attempt.incrementAndGet() == 1) {
                          // Abort the first attempt.
                          mockSpanner.abortNextStatement();
                        } else {
                          // Set the result of the update statement back to 1 row.
                          mockSpanner.putStatementResult(
                              StatementResult.update(UPDATE_STATEMENT, UPDATE_COUNT));
                        }
                        return ApiFutures.immediateFuture(null);
                      },
                      executor)
                  .then(
                      (transactionContext, ignored) ->
                          transactionContext.executeUpdateAsync(UPDATE_STATEMENT),
                      executor)
                  .commitAsync();
          assertThat(commitTimestampFuture.get()).isNotNull();
          break;
        } catch (AbortedException e) {
          transactionContextFuture = manager.resetForRetryAsync();
        }
      }
      assertThat(attempt.get()).isEqualTo(2);
    } finally {
      mockSpanner.putStatementResult(StatementResult.update(UPDATE_STATEMENT, UPDATE_COUNT));
    }
  }

  @Test
  public void asyncTransactionManagerUpdateAbortedWithoutGettingResult() throws Exception {
    final AtomicInteger attempt = new AtomicInteger();
    try (AsyncTransactionManager manager = client().transactionManagerAsync()) {
      TransactionContextFuture transactionContextFuture = manager.beginAsync();
      while (true) {
        try {
          CommitTimestampFuture commitTimestampFuture =
              transactionContextFuture
                  .then(
                      (transaction, ignored) -> {
                        if (attempt.incrementAndGet() == 1) {
                          mockSpanner.abortNextStatement();
                        }
                        // This update statement will be aborted, but the error will not
                        // propagated to the transaction runner and cause the transaction to
                        // retry. Instead, the commit call will do that.
                        transaction.executeUpdateAsync(UPDATE_STATEMENT);
                        // Resolving this future will not resolve the result of the entire
                        // transaction. The transaction result will be resolved when the commit
                        // has actually finished successfully.
                        return ApiFutures.immediateFuture(null);
                      },
                      executor)
                  .commitAsync();
          assertThat(commitTimestampFuture.get()).isNotNull();
          assertThat(attempt.get()).isEqualTo(2);
          // The server may receive 1 or 2 commit requests depending on whether the call to
          // commitAsync() already knows that the transaction has aborted. If it does, it will not
          // attempt to call the Commit RPC and instead directly propagate the Aborted error.
          assertThat(mockSpanner.getRequestTypes())
              .containsAtLeast(
                  CreateSessionRequest.class,
                  ExecuteSqlRequest.class,
                  // The retry will use a BeginTransaction RPC.
                  BeginTransactionRequest.class,
                  ExecuteSqlRequest.class,
                  CommitRequest.class);
          break;
        } catch (AbortedException e) {
          transactionContextFuture = manager.resetForRetryAsync();
        }
      }
    }
  }

  @Test
  public void asyncTransactionManagerCommitFails() throws Exception {
    mockSpanner.setCommitExecutionTime(
        SimulatedExecutionTime.ofException(
            Status.INVALID_ARGUMENT
                .withDescription("mutation limit exceeded")
                .asRuntimeException()));
    try (AsyncTransactionManager mgr = client().transactionManagerAsync()) {
      TransactionContextFuture txn = mgr.beginAsync();
      SpannerException e =
          assertThrows(
              SpannerException.class,
              () ->
                  get(
                      txn.then(
                              AsyncTransactionManagerHelper.executeUpdateAsync(UPDATE_STATEMENT),
                              executor)
                          .commitAsync()));
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
      assertThat(e.getMessage()).contains("mutation limit exceeded");
    }
  }

  @Test
  public void asyncTransactionManagerWaitsUntilAsyncUpdateHasFinished() throws Exception {
    try (AsyncTransactionManager mgr = client().transactionManagerAsync()) {
      TransactionContextFuture txn = mgr.beginAsync();
      while (true) {
        try {
          txn.then(
                  (transaction, input) -> {
                    // Shoot-and-forget update. The commit will still wait for this request to
                    // finish.
                    transaction.executeUpdateAsync(UPDATE_STATEMENT);
                    return ApiFutures.immediateFuture(null);
                  },
                  executor)
              .commitAsync()
              .get();
          assertThat(mockSpanner.getRequestTypes())
              .containsExactly(
                  CreateSessionRequest.class, ExecuteSqlRequest.class, CommitRequest.class);
          break;
        } catch (AbortedException e) {
          txn = mgr.resetForRetryAsync();
        }
      }
    }
  }

  @Test
  public void asyncTransactionManagerBatchUpdate() throws Exception {
    try (AsyncTransactionManager manager = client().transactionManagerAsync()) {
      TransactionContextFuture transactionContextFuture = manager.beginAsync();
      while (true) {
        try {
          AsyncTransactionStep<Void, long[]> updateCounts =
              transactionContextFuture.then(
                  (transaction, ignored) ->
                      transaction.batchUpdateAsync(
                          ImmutableList.of(UPDATE_STATEMENT, UPDATE_STATEMENT)),
                  executor);
          get(updateCounts.commitAsync());
          assertThat(get(updateCounts)).asList().containsExactly(UPDATE_COUNT, UPDATE_COUNT);
          break;
        } catch (AbortedException e) {
          transactionContextFuture = manager.resetForRetryAsync();
        }
      }
    }
  }

  @Test
  public void asyncTransactionManagerIsNonBlockingWithBatchUpdate() throws Exception {
    // TODO: Remove this condition once DelayedAsyncTransactionManager is made non-blocking with
    // multiplexed sessions.
    assumeFalse(
        "DelayedAsyncTransactionManager is currently blocking with multiplexed sessions.",
        spanner.getOptions().getSessionPoolOptions().getUseMultiplexedSessionForRW());
    mockSpanner.freeze();
    try (AsyncTransactionManager manager = client().transactionManagerAsync()) {
      TransactionContextFuture transactionContextFuture = manager.beginAsync();
      while (true) {
        try {
          AsyncTransactionStep<Void, long[]> updateCounts =
              transactionContextFuture.then(
                  (transactionContext, ignored) ->
                      transactionContext.batchUpdateAsync(Collections.singleton(UPDATE_STATEMENT)),
                  executor);
          CommitTimestampFuture commitTimestampFuture = updateCounts.commitAsync();
          mockSpanner.unfreeze();
          assertThat(commitTimestampFuture.get()).isNotNull();
          assertThat(updateCounts.get()).asList().containsExactly(UPDATE_COUNT);
          break;
        } catch (AbortedException e) {
          transactionContextFuture = manager.resetForRetryAsync();
        }
      }
    }
  }

  @Test
  public void asyncTransactionManagerInvalidBatchUpdate() throws Exception {
    try (AsyncTransactionManager manager = client().transactionManagerAsync()) {
      TransactionContextFuture transactionContextFuture = manager.beginAsync();
      SpannerException e =
          assertThrows(
              SpannerException.class,
              () ->
                  get(
                      transactionContextFuture
                          .then(
                              (transactionContext, ignored) ->
                                  transactionContext.batchUpdateAsync(
                                      ImmutableList.of(UPDATE_STATEMENT, INVALID_UPDATE_STATEMENT)),
                              executor)
                          .commitAsync()));
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
      assertThat(e.getMessage()).contains("invalid statement");
    }
  }

  @Test
  public void asyncTransactionManagerFireAndForgetInvalidBatchUpdate() throws Exception {
    try (AsyncTransactionManager manager = client().transactionManagerAsync()) {
      TransactionContextFuture transactionContextFuture = manager.beginAsync();
      while (true) {
        try {
          AsyncTransactionStep<Void, long[]> updateCounts =
              transactionContextFuture
                  .then(
                      (transactionContext, ignored) -> {
                        transactionContext.batchUpdateAsync(
                            ImmutableList.of(UPDATE_STATEMENT, INVALID_UPDATE_STATEMENT));
                        return ApiFutures.<Void>immediateFuture(null);
                      },
                      executor)
                  .then(
                      (transactionContext, ignored) ->
                          transactionContext.batchUpdateAsync(
                              ImmutableList.of(UPDATE_STATEMENT, UPDATE_STATEMENT)),
                      executor);
          updateCounts.commitAsync().get();
          assertThat(updateCounts.get()).asList().containsExactly(UPDATE_COUNT, UPDATE_COUNT);
          break;
        } catch (AbortedException e) {
          transactionContextFuture = manager.resetForRetryAsync();
        }
      }
    }
    ImmutableList<Class<? extends Message>> expectedRequests =
        ImmutableList.of(
            BatchCreateSessionsRequest.class,
            ExecuteBatchDmlRequest.class,
            ExecuteBatchDmlRequest.class,
            CommitRequest.class);
    ImmutableList<Class<? extends Message>> expectedRequestsWithMultiplexedSessionsRW =
        ImmutableList.of(
            CreateSessionRequest.class,
            ExecuteBatchDmlRequest.class,
            ExecuteBatchDmlRequest.class,
            CommitRequest.class);
    assertThat(mockSpanner.getRequestTypes())
        .containsExactlyElementsIn(expectedRequestsWithMultiplexedSessionsRW);
  }

  @Test
  public void asyncTransactionManagerBatchUpdateAborted() throws Exception {
    final AtomicInteger attempt = new AtomicInteger();
    try (AsyncTransactionManager manager = client().transactionManagerAsync()) {
      TransactionContextFuture transactionContextFuture = manager.beginAsync();
      while (true) {
        try {
          transactionContextFuture
              .then(
                  (transaction, ignored) -> {
                    if (attempt.incrementAndGet() == 1) {
                      return transaction.batchUpdateAsync(
                          ImmutableList.of(UPDATE_STATEMENT, UPDATE_ABORTED_STATEMENT));
                    } else {
                      return transaction.batchUpdateAsync(
                          ImmutableList.of(UPDATE_STATEMENT, UPDATE_STATEMENT));
                    }
                  },
                  executor)
              .commitAsync()
              .get();
          break;
        } catch (AbortedException e) {
          transactionContextFuture = manager.resetForRetryAsync();
        }
      }
    }
    assertThat(attempt.get()).isEqualTo(2);
    // There should only be 1 CommitRequest, as the first attempt should abort already after the
    // ExecuteBatchDmlRequest.
    ImmutableList<Class<? extends Message>> expectedRequests =
        ImmutableList.of(
            BatchCreateSessionsRequest.class,
            ExecuteBatchDmlRequest.class,
            BeginTransactionRequest.class,
            ExecuteBatchDmlRequest.class,
            CommitRequest.class);
    ImmutableList<Class<? extends Message>> expectedRequestsWithMultiplexedSessionsRW =
        ImmutableList.of(
            CreateSessionRequest.class,
            ExecuteBatchDmlRequest.class,
            BeginTransactionRequest.class,
            ExecuteBatchDmlRequest.class,
            CommitRequest.class);
    assertThat(mockSpanner.getRequestTypes())
        .containsExactlyElementsIn(expectedRequestsWithMultiplexedSessionsRW);
  }

  @Test
  public void asyncTransactionManagerBatchUpdateAbortedBeforeFirstStatement() throws Exception {
    final AtomicInteger attempt = new AtomicInteger();
    try (AsyncTransactionManager manager = client().transactionManagerAsync()) {
      TransactionContextFuture transactionContextFuture = manager.beginAsync();
      while (true) {
        try {
          transactionContextFuture
              .then(
                  (transactionContext, ignored) -> {
                    if (attempt.incrementAndGet() == 1) {
                      mockSpanner.abortNextStatement();
                    }
                    return transactionContext.batchUpdateAsync(
                        ImmutableList.of(UPDATE_STATEMENT, UPDATE_STATEMENT));
                  },
                  executor)
              .commitAsync()
              .get();
          break;
        } catch (AbortedException e) {
          transactionContextFuture = manager.resetForRetryAsync();
        }
      }
    }
    assertThat(attempt.get()).isEqualTo(2);
    // There should only be 1 CommitRequest, as the first attempt should abort already after the
    // ExecuteBatchDmlRequest.
    ImmutableList<Class<? extends Message>> expectedRequests =
        ImmutableList.of(
            BatchCreateSessionsRequest.class,
            ExecuteBatchDmlRequest.class,
            BeginTransactionRequest.class,
            ExecuteBatchDmlRequest.class,
            CommitRequest.class);
    // When requests run using multiplexed session with read-write enabled, the
    // BatchCreateSessionsRequest will not be
    // triggered because we are creating an empty pool during initialization.
    ImmutableList<Class<? extends Message>> expectedRequestsWithMultiplexedSessionsRW =
        ImmutableList.of(
            CreateSessionRequest.class,
            ExecuteBatchDmlRequest.class,
            BeginTransactionRequest.class,
            ExecuteBatchDmlRequest.class,
            CommitRequest.class);
    assertThat(mockSpanner.getRequestTypes())
        .containsExactlyElementsIn(expectedRequestsWithMultiplexedSessionsRW);
  }

  @Test
  public void asyncTransactionManagerWithBatchUpdateCommitAborted() throws Exception {
    try (AsyncTransactionManager manager = client().transactionManagerAsync()) {
      // Temporarily set the result of the update to 2 rows.
      mockSpanner.putStatementResult(StatementResult.update(UPDATE_STATEMENT, UPDATE_COUNT + 1L));
      final AtomicInteger attempt = new AtomicInteger();
      TransactionContextFuture txn = manager.beginAsync();
      while (true) {
        try {
          AsyncTransactionStep<Void, long[]> updateCounts =
              txn.then(
                      (ignored1, ignored2) -> {
                        if (attempt.get() > 0) {
                          // Set the result of the update statement back to 1 row.
                          mockSpanner.putStatementResult(
                              StatementResult.update(UPDATE_STATEMENT, UPDATE_COUNT));
                        }
                        return ApiFutures.<Void>immediateFuture(null);
                      },
                      executor)
                  .then(
                      (transactionContext, ignored) ->
                          transactionContext.batchUpdateAsync(
                              ImmutableList.of(UPDATE_STATEMENT, UPDATE_STATEMENT)),
                      executor);
          updateCounts
              .then(
                  (transaction, ignored) -> {
                    if (attempt.incrementAndGet() == 1) {
                      mockSpanner.abortTransaction(transaction);
                    }
                    return ApiFutures.immediateFuture(null);
                  },
                  executor)
              .commitAsync()
              .get();
          assertThat(updateCounts.get()).asList().containsExactly(UPDATE_COUNT, UPDATE_COUNT);
          assertThat(attempt.get()).isEqualTo(2);
          break;
        } catch (AbortedException e) {
          txn = manager.resetForRetryAsync();
        }
      }
    } finally {
      mockSpanner.putStatementResult(StatementResult.update(UPDATE_STATEMENT, UPDATE_COUNT));
    }
    ImmutableList<Class<? extends Message>> expectedRequests =
        ImmutableList.of(
            BatchCreateSessionsRequest.class,
            ExecuteBatchDmlRequest.class,
            CommitRequest.class,
            BeginTransactionRequest.class,
            ExecuteBatchDmlRequest.class,
            CommitRequest.class);
    ImmutableList<Class<? extends Message>> expectedRequestsWithMultiplexedSessionsRW =
        ImmutableList.of(
            CreateSessionRequest.class,
            ExecuteBatchDmlRequest.class,
            CommitRequest.class,
            BeginTransactionRequest.class,
            ExecuteBatchDmlRequest.class,
            CommitRequest.class);
    assertThat(mockSpanner.getRequestTypes())
        .containsExactlyElementsIn(expectedRequestsWithMultiplexedSessionsRW);
  }

  @Test
  public void asyncTransactionManagerBatchUpdateAbortedWithoutGettingResult() throws Exception {
    final AtomicInteger attempt = new AtomicInteger();
    try (AsyncTransactionManager manager = client().transactionManagerAsync()) {
      TransactionContextFuture transactionContextFuture = manager.beginAsync();
      while (true) {
        try {
          transactionContextFuture
              .then(
                  (transactionContext, ignored) -> {
                    if (attempt.incrementAndGet() == 1) {
                      mockSpanner.abortNextStatement();
                    }
                    // This update statement will be aborted, but the error will not propagated
                    // to the transaction manager and cause the transaction to retry. Instead,
                    // the commit call will do that. Depending on the timing, that will happen
                    // directly in the transaction manager if the ABORTED error has already been
                    // returned by the batch update call before the commit call starts.
                    // Otherwise, the backend will return an ABORTED error for the commit call.
                    transactionContext.batchUpdateAsync(
                        ImmutableList.of(UPDATE_STATEMENT, UPDATE_STATEMENT));
                    return ApiFutures.immediateFuture(null);
                  },
                  executor)
              .commitAsync()
              .get();
          break;
        } catch (AbortedException e) {
          transactionContextFuture = manager.resetForRetryAsync();
        }
      }
    }
    assertThat(attempt.get()).isEqualTo(2);
    List<Class<? extends AbstractMessage>> requests = mockSpanner.getRequestTypes();
    int size = Iterables.size(requests);
    assertThat(size).isIn(Range.closed(5, 6));
    if (size == 5) {
      assertThat(requests)
          .containsExactly(
              CreateSessionRequest.class,
              ExecuteBatchDmlRequest.class,
              BeginTransactionRequest.class,
              ExecuteBatchDmlRequest.class,
              CommitRequest.class);
    } else {
      assertThat(requests)
          .containsExactly(
              CreateSessionRequest.class,
              ExecuteBatchDmlRequest.class,
              CommitRequest.class,
              BeginTransactionRequest.class,
              ExecuteBatchDmlRequest.class,
              CommitRequest.class);
    }
  }

  @Test
  public void asyncTransactionManagerWithBatchUpdateCommitFails() {
    mockSpanner.setCommitExecutionTime(
        SimulatedExecutionTime.ofException(
            Status.INVALID_ARGUMENT
                .withDescription("mutation limit exceeded")
                .asRuntimeException()));
    try (AsyncTransactionManager manager = client().transactionManagerAsync()) {
      TransactionContextFuture transactionContextFuture = manager.beginAsync();
      SpannerException e =
          assertThrows(
              SpannerException.class,
              () ->
                  get(
                      transactionContextFuture
                          .then(
                              (transactionContext, ignored) ->
                                  transactionContext.batchUpdateAsync(
                                      ImmutableList.of(UPDATE_STATEMENT, UPDATE_STATEMENT)),
                              executor)
                          .commitAsync()));
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
      assertThat(e.getMessage()).contains("mutation limit exceeded");
    }
    ImmutableList<Class<? extends Message>> expectedRequests =
        ImmutableList.of(
            BatchCreateSessionsRequest.class, ExecuteBatchDmlRequest.class, CommitRequest.class);
    ImmutableList<Class<? extends Message>> expectedRequestsWithMultiplexedSessionsRW =
        ImmutableList.of(
            CreateSessionRequest.class, ExecuteBatchDmlRequest.class, CommitRequest.class);
    assertThat(mockSpanner.getRequestTypes())
        .containsExactlyElementsIn(expectedRequestsWithMultiplexedSessionsRW);
  }

  @Test
  public void asyncTransactionManagerWaitsUntilAsyncBatchUpdateHasFinished() throws Exception {
    try (AsyncTransactionManager manager = client().transactionManagerAsync()) {
      TransactionContextFuture transactionContextFuture = manager.beginAsync();
      while (true) {
        try {
          transactionContextFuture
              .then(
                  (transactionContext, ignored) -> {
                    transactionContext.batchUpdateAsync(ImmutableList.of(UPDATE_STATEMENT));
                    return ApiFutures.immediateFuture(null);
                  },
                  executor)
              .commitAsync()
              .get();
          break;
        } catch (AbortedException e) {
          transactionContextFuture = manager.resetForRetryAsync();
        }
      }
    }
    ImmutableList<Class<? extends Message>> expectedRequests =
        ImmutableList.of(
            BatchCreateSessionsRequest.class, ExecuteBatchDmlRequest.class, CommitRequest.class);
    ImmutableList<Class<? extends Message>> expectedRequestsWithMultiplexedSessionsRW =
        ImmutableList.of(
            CreateSessionRequest.class, ExecuteBatchDmlRequest.class, CommitRequest.class);
    assertThat(mockSpanner.getRequestTypes())
        .containsExactlyElementsIn(expectedRequestsWithMultiplexedSessionsRW);
  }

  @Test
  public void asyncTransactionManagerReadRow() throws Exception {
    try (AsyncTransactionManager manager = client().transactionManagerAsync()) {
      TransactionContextFuture transactionContextFuture = manager.beginAsync();
      while (true) {
        try {
          AsyncTransactionStep<Struct, String> value =
              transactionContextFuture
                  .then(
                      (transactionContext, ignored) ->
                          transactionContext.readRowAsync(
                              READ_TABLE_NAME, Key.of(1L), READ_COLUMN_NAMES),
                      executor)
                  .then(
                      (ignored, input) -> ApiFutures.immediateFuture(input.getString("Value")),
                      executor);
          value.commitAsync().get();
          assertThat(value.get()).isEqualTo("v1");
          break;
        } catch (AbortedException e) {
          transactionContextFuture = manager.resetForRetryAsync();
        }
      }
    }
  }

  @Test
  public void asyncTransactionManagerRead() throws Exception {
    try (AsyncTransactionManager manager = client().transactionManagerAsync()) {
      TransactionContextFuture transactionContextFuture = manager.beginAsync();
      while (true) {
        try {
          AsyncTransactionStep<Void, List<String>> values =
              transactionContextFuture.then(
                  (transactionContext, ignored) ->
                      transactionContext
                          .readAsync(READ_TABLE_NAME, KeySet.all(), READ_COLUMN_NAMES)
                          .toListAsync(
                              input -> input.getString("Value"), MoreExecutors.directExecutor()),
                  executor);
          // Commit the transaction.
          values.commitAsync().get();
          assertThat(values.get()).containsExactly("v1", "v2", "v3");
          break;
        } catch (AbortedException e) {
          transactionContextFuture = manager.resetForRetryAsync();
        }
      }
    }
  }

  @Test
  public void asyncTransactionManagerQuery() throws Exception {
    mockSpanner.putStatementResult(
        StatementResult.query(
            Statement.of("SELECT FirstName FROM Singers WHERE ID=1"),
            MockSpannerTestUtil.READ_FIRST_NAME_SINGERS_RESULTSET));
    final long singerId = 1L;
    try (AsyncTransactionManager manager = client().transactionManagerAsync()) {
      TransactionContextFuture transactionContextFuture = manager.beginAsync();
      while (true) {
        final String column = "FirstName";
        CommitTimestampFuture commitTimestamp =
            transactionContextFuture
                .then(
                    (transactionContext, ignored) ->
                        transactionContext.readRowAsync(
                            "Singers", Key.of(singerId), Collections.singleton(column)),
                    executor)
                .then(
                    (transaction, input) -> {
                      String name = input.getString(column);
                      return transaction.bufferAsync(
                          Mutation.newUpdateBuilder("Singers")
                              .set(column)
                              .to(name.toUpperCase())
                              .build());
                    },
                    executor)
                .commitAsync();
        try {
          commitTimestamp.get();
          break;
        } catch (AbortedException e) {
          transactionContextFuture = manager.resetForRetryAsync();
        }
      }
    }
  }

  @Test
  public void asyncTransactionManager_shouldPropagateStatementFailure()
      throws ExecutionException, InterruptedException, TimeoutException {
    DatabaseClient dbClient = client();
    try (AsyncTransactionManager transactionManager = dbClient.transactionManagerAsync()) {
      TransactionContextFuture txnContextFuture = transactionManager.beginAsync();
      AsyncTransactionStep<Void, Long> updateFuture =
          txnContextFuture.then(
              (transaction, ignored) -> transaction.executeUpdateAsync(INVALID_UPDATE_STATEMENT),
              executor);
      final SettableApiFuture<Void> res = SettableApiFuture.create();
      ApiFutures.addCallback(
          updateFuture,
          new ApiFutureCallback<Long>() {
            @Override
            public void onFailure(Throwable throwable) {
              // Check that we got the expected failure.
              try {
                assertThat(throwable).isInstanceOf(SpannerException.class);
                SpannerException e = (SpannerException) throwable;
                assertThat(e.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
                assertThat(e.getMessage()).contains("invalid statement");
                res.set(null);
              } catch (Throwable t) {
                res.setException(t);
              }
            }

            @Override
            public void onSuccess(Long aLong) {
              res.setException(new AssertionError("Statement should not succeed."));
            }
          },
          executor);

      assertThat(res.get(10L, TimeUnit.SECONDS)).isNull();
    }
  }

  @Test
  public void testAbandonedAsyncTransactionManager_rollbackFails() throws Exception {
    mockSpanner.setRollbackExecutionTime(
        SimulatedExecutionTime.ofException(Status.PERMISSION_DENIED.asRuntimeException()));

    boolean gotException = false;
    try (AsyncTransactionManager manager = client().transactionManagerAsync()) {
      TransactionContextFuture transactionContextFuture = manager.beginAsync();
      while (true) {
        try {
          AsyncTransactionStep<Void, Long> updateCount =
              transactionContextFuture.then(
                  (transactionContext, ignored) ->
                      transactionContext.executeUpdateAsync(UPDATE_STATEMENT),
                  executor);
          assertEquals(1L, updateCount.get().longValue());
          // Break without committing or rolling back the transaction.
          break;
        } catch (AbortedException e) {
          transactionContextFuture = manager.resetForRetryAsync();
        }
      }
    } catch (SpannerException spannerException) {
      // The error from the automatically executed Rollback is surfaced when the
      // AsyncTransactionManager is closed.
      assertEquals(ErrorCode.PERMISSION_DENIED, spannerException.getErrorCode());
      gotException = true;
    }
    assertTrue(gotException);
  }
}
