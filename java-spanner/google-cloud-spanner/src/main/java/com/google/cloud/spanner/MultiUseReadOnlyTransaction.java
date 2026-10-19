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

package com.google.cloud.spanner;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.Options.ReadOption;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.Transaction;
import com.google.spanner.v1.TransactionOptions;
import com.google.spanner.v1.TransactionSelector;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/**
 * A {@link ReadOnlyTransaction} implementation for multi-use transactions. This allows multiple
 * read and query operations to be executed against a consistent snapshot of Cloud Spanner data,
 * coordinating transaction initialization, statement execution, and lifecycle management.
 */
class MultiUseReadOnlyTransaction extends AbstractReadContext implements ReadOnlyTransaction {
  static class Builder extends AbstractReadContext.Builder<Builder, MultiUseReadOnlyTransaction> {
    private TimestampBound bound;
    private Timestamp timestamp;
    private ByteString transactionId;
    private Options.BeginTransactionOption beginTransactionOption =
        Options.BeginTransactionOption.EXPLICIT;

    private Builder() {}

    Builder setTimestampBound(TimestampBound bound) {
      this.bound = bound;
      return this;
    }

    Builder setTimestamp(Timestamp timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    Builder setTransactionId(ByteString transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    Builder setBeginTransactionOption(Options.BeginTransactionOption beginTransactionOption) {
      this.beginTransactionOption = beginTransactionOption;
      return this;
    }

    @Override
    MultiUseReadOnlyTransaction build() {
      return new MultiUseReadOnlyTransaction(this);
    }
  }

  static Builder newBuilder() {
    return new Builder();
  }

  private TimestampBound bound;
  private final ReentrantLock txnLock = new ReentrantLock();

  @GuardedBy("txnLock")
  private Timestamp timestamp;

  @GuardedBy("txnLock")
  private ByteString transactionId;

  /**
   * Future used to synchronize concurrent operations during transaction initialization:
   *
   * <ul>
   *   <li>When using explicit {@code BeginTransaction} (e.g. via {@link #initTransaction()}), the
   *       first caller creates this future, releases {@code txnLock}, and executes the RPC outside
   *       the lock. Subsequent concurrent callers wait on this future outside the lock.
   *   <li>When using inlined {@code BeginTransaction} options, the first query or read operation
   *       creates this future and includes {@code Begin} in its {@link TransactionSelector}.
   *       Concurrent queries wait on this future until the first operation's initial response
   *       arrives and sets the transaction ID via {@link #onTransactionMetadata}.
   * </ul>
   */
  @GuardedBy("txnLock")
  private SettableApiFuture<ByteString> transactionIdFuture;

  /**
   * Future completed when all in-flight asynchronous query initializations (tracked by {@link
   * #pendingStarts}) have finished and the read context has been closed.
   */
  @GuardedBy("txnLock")
  private SettableApiFuture<Void> closeFuture;

  /**
   * Flag indicating whether the transaction has been closed or is currently closing. Once true, no
   * new reads or queries (synchronous or asynchronous) are permitted to start on this context.
   */
  @GuardedBy("txnLock")
  private boolean isClosedOrClosing;

  @GuardedBy("txnLock")
  private boolean closed;

  /**
   * Counter tracking the number of asynchronous queries created on this transaction whose delegate
   * {@link ResultSet} suppliers have not yet been executed or closed.
   */
  private final AtomicInteger pendingStarts = new AtomicInteger(0);

  private static final long WAIT_FOR_INLINE_BEGIN_TIMEOUT_MILLIS = 60_000L;

  private final Map<SpannerRpc.Option, ?> channelHint;
  private final Options.BeginTransactionOption beginTransactionOption;

  MultiUseReadOnlyTransaction(Builder builder) {
    super(builder);
    checkArgument(
        !(builder.bound != null && builder.transactionId != null)
            && !(builder.bound == null && builder.transactionId == null),
        "Either TimestampBound or TransactionId must be specified");
    if (builder.bound != null) {
      checkArgument(
          builder.bound.getMode() != TimestampBound.Mode.MAX_STALENESS
              && builder.bound.getMode() != TimestampBound.Mode.MIN_READ_TIMESTAMP,
          "Bounded staleness mode %s is not supported for multi-use read-only transactions."
              + " Create a single-use read or read-only transaction instead.",
          builder.bound.getMode());
      this.bound = builder.bound;
    } else {
      this.timestamp = builder.timestamp;
      this.transactionId = builder.transactionId;
    }
    this.channelHint =
        getChannelHintOptions(
            session.getOptions(),
            ThreadLocalRandom.current().nextLong(Long.MAX_VALUE),
            session.getSpanner().getOptions().isGrpcGcpExtensionEnabled());
    this.beginTransactionOption = builder.beginTransactionOption;
  }

  @Override
  public Map<SpannerRpc.Option, ?> getTransactionChannelHint() {
    return channelHint;
  }

  @Override
  protected boolean isRouteToLeader() {
    return false;
  }

  private boolean shouldUseInlinedBegin() {
    return beginTransactionOption == Options.BeginTransactionOption.INLINE;
  }

  @Override
  void beforeReadOrQuery() {
    super.beforeReadOrQuery();
    if (shouldUseInlinedBegin()) {
      // Keep the same nested transaction guard as the explicit BeginTransaction path. This checks
      // TransactionRunner's thread-local pending state, not the session's active transaction.
      SessionImpl.throwIfTransactionsPending();
    } else {
      initTransaction();
    }
  }

  @Override
  @Nullable
  TransactionSelector getTransactionSelector() {
    if (!shouldUseInlinedBegin()) {
      // No need for synchronization: super.readInternal() is always preceded by a check of
      // "transactionId" that provides a happens-before from initialization, and the value is
      // never changed afterwards.
      @SuppressWarnings("GuardedByChecker")
      TransactionSelector selector = TransactionSelector.newBuilder().setId(transactionId).build();
      return selector;
    }

    ApiFuture<ByteString> futureToWaitFor = null;
    txnLock.lock();
    try {
      if (transactionId != null) {
        return TransactionSelector.newBuilder().setId(transactionId).build();
      }
      if (transactionIdFuture == null) {
        transactionIdFuture = SettableApiFuture.create();
        return TransactionSelector.newBuilder()
            .setBegin(createReadOnlyTransactionOptions())
            .build();
      }
      futureToWaitFor = transactionIdFuture;
    } finally {
      txnLock.unlock();
    }

    try {
      return TransactionSelector.newBuilder()
          .setId(futureToWaitFor.get(WAIT_FOR_INLINE_BEGIN_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS))
          .build();
    } catch (ExecutionException e) {
      throw SpannerExceptionFactory.asSpannerException(e.getCause());
    } catch (TimeoutException e) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.DEADLINE_EXCEEDED,
          "Timeout while waiting for an inlined read-only transaction to be returned by another"
              + " statement.",
          e);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw SpannerExceptionFactory.newSpannerExceptionForCancellation(null, e);
    }
  }

  @GuardedBy("txnLock")
  private boolean isTransactionInitializingLocked() {
    return transactionIdFuture != null && !transactionIdFuture.isDone();
  }

  @GuardedBy("txnLock")
  private boolean shouldCloseLocked() {
    return isClosedOrClosing
        && !closed
        && pendingStarts.get() <= 0
        && !isTransactionInitializingLocked();
  }

  /**
   * Checks if the transaction can be safely closed, and if so, closes it via {@code super.close()}
   * and completes {@link #closeFuture}.
   */
  private void checkAndClose() {
    SettableApiFuture<Void> futureToComplete = null;
    boolean shouldClose = false;
    txnLock.lock();
    try {
      if (shouldCloseLocked()) {
        closed = true;
        shouldClose = true;
        futureToComplete = closeFuture;
      }
    } finally {
      txnLock.unlock();
    }

    if (shouldClose) {
      Throwable error = null;
      try {
        super.close();
      } catch (Throwable throwable) {
        error = throwable;
      }
      if (futureToComplete != null) {
        if (error != null) {
          futureToComplete.setException(error);
        } else {
          futureToComplete.set(null);
        }
      }
    }
  }

  /**
   * Decrements the count of pending asynchronous query starts. When the count drops to 0, if the
   * transaction is in the process of closing (i.e. {@link #closeAsync()} was called), this method
   * closes the read context via {@code super.close()} and completes {@link #closeFuture}.
   */
  private void decrementPendingStartsAndSignal() {
    pendingStarts.decrementAndGet();
    checkAndClose();
  }

  /**
   * Creates an {@link AsyncResultSetImpl} for an asynchronous read or query. Tracks the query in
   * {@link #pendingStarts} so that {@link #closeAsync()} will not close the read context until the
   * query initialization has completed.
   */
  private ListenableAsyncResultSet createAsyncResultSet(
      Supplier<ResultSet> resultSetSupplier, int bufferRows) {
    txnLock.lock();
    try {
      checkState(!isClosedOrClosing, "Context has been closed");
      pendingStarts.incrementAndGet();
    } finally {
      txnLock.unlock();
    }
    // Make sure that we decrement the counter exactly once, either
    // when the query is actually executed, or when the result set is closed,
    // or if something goes wrong when creating the result set.
    final AtomicBoolean decremented = new AtomicBoolean(false);
    try {
      return new AsyncResultSetImpl(
          executorProvider,
          () -> {
            try {
              return resultSetSupplier.get();
            } finally {
              if (decremented.compareAndSet(false, true)) {
                decrementPendingStartsAndSignal();
              }
            }
          },
          bufferRows) {
        @Override
        public void close() {
          try {
            super.close();
          } finally {
            if (!isUsed() && decremented.compareAndSet(false, true)) {
              decrementPendingStartsAndSignal();
            }
          }
        }
      };
    } catch (Throwable throwable) {
      if (decremented.compareAndSet(false, true)) {
        decrementPendingStartsAndSignal();
      }
      throw throwable;
    }
  }

  /**
   * Ensures that the transaction is neither closed nor in the process of closing before initiating
   * a new synchronous read or query.
   */
  private void checkClosedOrClosing() {
    txnLock.lock();
    try {
      checkState(!isClosedOrClosing, "Context has been closed");
    } finally {
      txnLock.unlock();
    }
  }

  @Override
  ResultSet readInternalWithOptions(
      String table,
      @Nullable String index,
      KeySet keys,
      Iterable<String> columns,
      final Options readOptions,
      ByteString partitionToken) {
    checkClosedOrClosing();
    return super.readInternalWithOptions(table, index, keys, columns, readOptions, partitionToken);
  }

  @Override
  ResultSet executeQueryInternal(
      final Statement statement,
      final com.google.spanner.v1.ExecuteSqlRequest.QueryMode queryMode,
      final QueryOption... options) {
    checkClosedOrClosing();
    return super.executeQueryInternal(statement, queryMode, options);
  }

  @Override
  public ListenableAsyncResultSet readAsync(
      String table, KeySet keys, Iterable<String> columns, ReadOption... options) {
    Options readOptions = Options.fromReadOptions(options);
    final int bufferRows =
        readOptions.hasBufferRows()
            ? readOptions.bufferRows()
            : AsyncResultSetImpl.DEFAULT_BUFFER_SIZE;
    return createAsyncResultSet(
        () -> super.readInternalWithOptions(table, null, keys, columns, readOptions, null),
        bufferRows);
  }

  @Override
  public ListenableAsyncResultSet readUsingIndexAsync(
      String table, String index, KeySet keys, Iterable<String> columns, ReadOption... options) {
    Options readOptions = Options.fromReadOptions(options);
    final int bufferRows =
        readOptions.hasBufferRows()
            ? readOptions.bufferRows()
            : AsyncResultSetImpl.DEFAULT_BUFFER_SIZE;
    return createAsyncResultSet(
        () ->
            super.readInternalWithOptions(
                table, checkNotNull(index), keys, columns, readOptions, null),
        bufferRows);
  }

  @Override
  public ListenableAsyncResultSet executeQueryAsync(Statement statement, QueryOption... options) {
    Options readOptions = Options.fromQueryOptions(options);
    final int bufferRows =
        readOptions.hasBufferRows()
            ? readOptions.bufferRows()
            : AsyncResultSetImpl.DEFAULT_BUFFER_SIZE;
    return createAsyncResultSet(
        () ->
            super.executeQueryInternal(
                statement, com.google.spanner.v1.ExecuteSqlRequest.QueryMode.NORMAL, options),
        bufferRows);
  }

  @Override
  public void onTransactionMetadata(Transaction transaction, boolean shouldIncludeId) {
    Timestamp readTimestamp = null;
    if (transaction.hasReadTimestamp()) {
      try {
        readTimestamp = Timestamp.fromProto(transaction.getReadTimestamp());
      } catch (IllegalArgumentException e) {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INTERNAL, "Bad value in transaction.read_timestamp metadata field", e);
      }
    }
    if (shouldIncludeId && transaction.getId().isEmpty()) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.FAILED_PRECONDITION, NO_TRANSACTION_RETURNED_MSG);
    }
    txnLock.lock();
    try {
      if (timestamp == null) {
        if (readTimestamp == null) {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.INTERNAL, "Missing expected transaction.read_timestamp metadata field");
        }
        timestamp = readTimestamp;
      }
      if (shouldIncludeId && transactionId == null) {
        transactionId = transaction.getId();
        if (transactionIdFuture != null && !transactionIdFuture.isDone()) {
          transactionIdFuture.set(transactionId);
        }
      }
    } finally {
      txnLock.unlock();
    }
    checkAndClose();
  }

  @Override
  public SpannerException onError(
      SpannerException e, boolean withBeginTransaction, boolean lastStatement) {
    e = super.onError(e, withBeginTransaction, lastStatement);
    if (withBeginTransaction) {
      failTransactionIdFuture(e);
    }
    return e;
  }

  @Override
  public void onDone(boolean withBeginTransaction) {
    if (withBeginTransaction) {
      failTransactionIdFuture(
          SpannerExceptionFactory.newSpannerException(
              ErrorCode.FAILED_PRECONDITION,
              "ResultSet was closed before a read-only transaction id was returned"));
    }
    super.onDone(withBeginTransaction);
  }

  @Override
  void onStartFailed(boolean withBeginTransaction, Throwable throwable) {
    if (withBeginTransaction) {
      failTransactionIdFuture(throwable);
    }
  }

  private void failTransactionIdFuture(Throwable throwable) {
    txnLock.lock();
    try {
      if (transactionIdFuture != null && !transactionIdFuture.isDone()) {
        transactionIdFuture.setException(throwable);
      }
    } finally {
      txnLock.unlock();
    }
    checkAndClose();
  }

  @Override
  public Timestamp getReadTimestamp() {
    txnLock.lock();
    try {
      assertTimestampAvailable(timestamp != null);
      return timestamp;
    } finally {
      txnLock.unlock();
    }
  }

  ByteString getTransactionId() {
    txnLock.lock();
    try {
      return transactionId;
    } finally {
      txnLock.unlock();
    }
  }

  /**
   * Closes the transaction asynchronously.
   *
   * <p>If there are no in-flight asynchronous query initializations ({@code pendingStarts == 0}),
   * the read context is closed immediately and a completed future is returned. If there are pending
   * starts, this method marks {@code isClosedOrClosing = true} and returns a {@link
   * SettableApiFuture} that will be completed by {@link #decrementPendingStartsAndSignal()} when
   * all pending starts finish.
   */
  @Override
  public ApiFuture<Void> closeAsync() {
    boolean shouldCloseImmediately = false;
    txnLock.lock();
    try {
      if (isClosedOrClosing) {
        return closeFuture;
      }
      isClosedOrClosing = true;
      closeFuture = SettableApiFuture.create();
      if (shouldCloseLocked()) {
        closed = true;
        shouldCloseImmediately = true;
      } else {
        return closeFuture;
      }
    } finally {
      txnLock.unlock();
    }

    if (shouldCloseImmediately) {
      try {
        super.close();
        closeFuture.set(null);
      } catch (Throwable throwable) {
        closeFuture.setException(throwable);
      }
    }
    return closeFuture;
  }

  @Override
  public void close() {
    SpannerApiFutures.get(closeAsync());
  }

  private TransactionOptions createReadOnlyTransactionOptions() {
    TransactionOptions.Builder options = TransactionOptions.newBuilder();
    if (timestamp != null) {
      options
          .getReadOnlyBuilder()
          .setReadTimestamp(timestamp.toProto())
          .setReturnReadTimestamp(true);
    } else {
      bound.applyToBuilder(options.getReadOnlyBuilder()).setReturnReadTimestamp(true);
    }
    return options.build();
  }

  /**
   * Initializes the transaction with the timestamp specified within MultiUseReadOnlyTransaction.
   * This is used only for fallback of PartitionQueryRequest and PartitionReadRequest with
   * Multiplexed Session.
   */
  void initFallbackTransaction() {
    initTransaction();
  }

  /**
   * Initializes the transaction by issuing a BeginTransaction RPC.
   *
   * <p>To prevent blocking concurrent operations (such as {@link #closeAsync()}) while a network
   * RPC is in-flight, {@code rpc.beginTransaction} is executed <b>outside</b> {@code txnLock}. A
   * leader/follower pattern using {@link #transactionIdFuture} is used: the first caller acquires
   * the lock, creates {@code transactionIdFuture}, releases the lock, and executes the RPC.
   * Subsequent concurrent callers retrieve {@code transactionIdFuture} and wait on it outside the
   * lock.
   */
  void initTransaction() {
    SessionImpl.throwIfTransactionsPending();

    ApiFuture<ByteString> futureToWaitFor = null;
    BeginTransactionRequest request = null;
    txnLock.lock();
    try {
      if (transactionId != null) {
        return;
      }
      if (transactionIdFuture != null) {
        futureToWaitFor = transactionIdFuture;
      } else {
        transactionIdFuture = SettableApiFuture.create();
        span.addAnnotation("Creating Transaction");
        request =
            BeginTransactionRequest.newBuilder()
                .setSession(session.getName())
                .setOptions(createReadOnlyTransactionOptions())
                .build();
      }
    } finally {
      txnLock.unlock();
    }

    if (futureToWaitFor != null) {
      try {
        futureToWaitFor.get();
        return;
      } catch (ExecutionException executionException) {
        throw SpannerExceptionFactory.asSpannerException(executionException.getCause());
      } catch (InterruptedException interruptedException) {
        Thread.currentThread().interrupt();
        throw SpannerExceptionFactory.newSpannerExceptionForCancellation(
            null, interruptedException);
      }
    }

    initTransactionInternal(request);
  }

  /**
   * Executes the BeginTransaction RPC outside {@code txnLock}, updates transaction state under
   * {@code txnLock}, and completes or fails {@link #transactionIdFuture} so waiting callers are
   * notified.
   */
  private void initTransactionInternal(BeginTransactionRequest request) {
    try {
      Transaction transaction =
          rpc.beginTransaction(request, getTransactionChannelHint(), isRouteToLeader());
      if (!transaction.hasReadTimestamp()) {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INTERNAL, "Missing expected transaction.read_timestamp metadata field");
      }
      if (transaction.getId().isEmpty()) {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INTERNAL, "Missing expected transaction.id metadata field");
      }
      Timestamp readTimestamp;
      try {
        readTimestamp = Timestamp.fromProto(transaction.getReadTimestamp());
      } catch (IllegalArgumentException illegalArgumentException) {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INTERNAL,
            "Bad value in transaction.read_timestamp metadata field",
            illegalArgumentException);
      }
      txnLock.lock();
      try {
        timestamp = readTimestamp;
        transactionId = transaction.getId();
        if (transactionIdFuture != null && !transactionIdFuture.isDone()) {
          transactionIdFuture.set(transactionId);
        }
      } finally {
        txnLock.unlock();
      }
      checkAndClose();
      span.addAnnotation(
          "Transaction Creation Done",
          ImmutableMap.of(
              "Id", transaction.getId().toStringUtf8(), "Timestamp", readTimestamp.toString()));
    } catch (Throwable throwable) {
      SpannerException spannerException = SpannerExceptionFactory.asSpannerException(throwable);
      span.addAnnotation("Transaction Creation Failed", spannerException);
      txnLock.lock();
      try {
        if (transactionIdFuture != null && !transactionIdFuture.isDone()) {
          transactionIdFuture.setException(spannerException);
        }
      } finally {
        txnLock.unlock();
      }
      checkAndClose();
      throw spannerException;
    }
  }
}
