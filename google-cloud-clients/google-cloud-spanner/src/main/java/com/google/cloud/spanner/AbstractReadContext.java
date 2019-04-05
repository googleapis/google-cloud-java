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

import static com.google.cloud.spanner.SpannerExceptionFactory.newSpannerException;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AbstractResultSet.CloseableIterator;
import com.google.cloud.spanner.AbstractResultSet.GrpcResultSet;
import com.google.cloud.spanner.AbstractResultSet.GrpcStreamIterator;
import com.google.cloud.spanner.AbstractResultSet.ResumableStreamIterator;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.Options.ReadOption;
import com.google.cloud.spanner.SpannerImpl.SessionImpl;
import com.google.cloud.spanner.SpannerImpl.SessionTransaction;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.protobuf.ByteString;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ExecuteSqlRequest.QueryMode;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.Transaction;
import com.google.spanner.v1.TransactionOptions;
import com.google.spanner.v1.TransactionSelector;
import io.opencensus.trace.Span;
import io.opencensus.trace.Tracing;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/**
 * Abstract base class for all {@link ReadContext}s + concrete implementations of read-only {@link
 * ReadContext}s.
 */
abstract class AbstractReadContext
    implements ReadContext, AbstractResultSet.Listener, SessionTransaction {
  /**
   * A {@code ReadContext} for standalone reads. This can only be used for a single operation, since
   * each standalone read may see a different timestamp of Cloud Spanner data.
   */
  static class SingleReadContext extends AbstractReadContext {
    final TimestampBound bound;

    @GuardedBy("lock")
    private boolean used;

    SingleReadContext(
        SessionImpl session, TimestampBound bound, SpannerRpc rpc, int defaultPrefetchChunks) {
      super(session, rpc, defaultPrefetchChunks);
      this.bound = bound;
    }

    @GuardedBy("lock")
    @Override
    void beforeReadOrQueryLocked() {
      super.beforeReadOrQueryLocked();
      checkState(!used, "Cannot use a single-read ReadContext for multiple reads");
      used = true;
    }

    @Override
    @Nullable
    TransactionSelector getTransactionSelector() {
      if (bound.getMode() == TimestampBound.Mode.STRONG) {
        // Default mode: no need to specify a transaction.
        return null;
      }
      return TransactionSelector.newBuilder()
          .setSingleUse(TransactionOptions.newBuilder().setReadOnly(bound.toProto()))
          .build();
    }
  }

  private static void assertTimestampAvailable(boolean available) {
    checkState(available, "Method can only be called after read has returned data or finished");
  }

  static class SingleUseReadOnlyTransaction extends SingleReadContext
      implements ReadOnlyTransaction {
    @GuardedBy("lock")
    private Timestamp timestamp;

    SingleUseReadOnlyTransaction(
        SessionImpl session, TimestampBound bound, SpannerRpc rpc, int defaultPrefetchChunks) {
      super(session, bound, rpc, defaultPrefetchChunks);
    }

    @Override
    public Timestamp getReadTimestamp() {
      synchronized (lock) {
        assertTimestampAvailable(timestamp != null);
        return timestamp;
      }
    }

    @Override
    @Nullable
    TransactionSelector getTransactionSelector() {
      TransactionOptions.Builder options = TransactionOptions.newBuilder();
      bound.applyToBuilder(options.getReadOnlyBuilder()).setReturnReadTimestamp(true);
      return TransactionSelector.newBuilder().setSingleUse(options).build();
    }

    @Override
    public void onTransactionMetadata(Transaction transaction) {
      synchronized (lock) {
        if (!transaction.hasReadTimestamp()) {
          throw newSpannerException(
              ErrorCode.INTERNAL, "Missing expected transaction.read_timestamp metadata field");
        }
        try {
          timestamp = Timestamp.fromProto(transaction.getReadTimestamp());
        } catch (IllegalArgumentException e) {
          throw newSpannerException(
              ErrorCode.INTERNAL, "Bad value in transaction.read_timestamp metadata field", e);
        }
      }
    }
  }

  static class MultiUseReadOnlyTransaction extends AbstractReadContext
      implements ReadOnlyTransaction {
    private TimestampBound bound;
    private final Object txnLock = new Object();

    @GuardedBy("txnLock")
    private Timestamp timestamp;

    @GuardedBy("txnLock")
    private ByteString transactionId;

    MultiUseReadOnlyTransaction(
        SessionImpl session, TimestampBound bound, SpannerRpc rpc, int defaultPrefetchChunks) {
      super(session, rpc, defaultPrefetchChunks);
      checkArgument(
          bound.getMode() != TimestampBound.Mode.MAX_STALENESS
              && bound.getMode() != TimestampBound.Mode.MIN_READ_TIMESTAMP,
          "Bounded staleness mode %s is not supported for multi-use read-only transactions."
              + " Create a single-use read or read-only transaction instead.",
          bound.getMode());
      this.bound = bound;
    }

    MultiUseReadOnlyTransaction(
        SessionImpl session,
        ByteString transactionId,
        Timestamp timestamp,
        SpannerRpc rpc,
        int defaultPrefetchChunks) {
      super(session, rpc, defaultPrefetchChunks);
      this.transactionId = transactionId;
      this.timestamp = timestamp;
    }

    @Override
    void beforeReadOrQuery() {
      super.beforeReadOrQuery();
      initTransaction();
    }

    @Override
    @Nullable
    TransactionSelector getTransactionSelector() {
      // No need for synchronization: super.readInternal() is always preceded by a check of
      // "transactionId" that provides a happens-before from initialization, and the value is never
      // changed afterwards.
      @SuppressWarnings("GuardedByChecker")
      TransactionSelector selector = TransactionSelector.newBuilder().setId(transactionId).build();
      return selector;
    }

    @Override
    public Timestamp getReadTimestamp() {
      synchronized (txnLock) {
        assertTimestampAvailable(timestamp != null);
        return timestamp;
      }
    }

    ByteString getTransactionId() {
      synchronized (txnLock) {
        return transactionId;
      }
    }

    void initTransaction() {
      SpannerImpl.throwIfTransactionsPending();

      // Since we only support synchronous calls, just block on "txnLock" while the RPC is in
      // flight. Note that we use the strategy of sending an explicit BeginTransaction() RPC,
      // rather than using the first read in the transaction to begin it implicitly. The chosen
      // strategy is sub-optimal in the case of the first read being fast, as it incurs an extra
      // RTT, but optimal if the first read is slow. As the client library is now using streaming
      // reads, a possible optimization could be to use the first read in the transaction to begin
      // it implicitly.
      synchronized (txnLock) {
        if (transactionId != null) {
          return;
        }
        span.addAnnotation("Creating Transaction");
        try {
          TransactionOptions.Builder options = TransactionOptions.newBuilder();
          bound.applyToBuilder(options.getReadOnlyBuilder()).setReturnReadTimestamp(true);
          final BeginTransactionRequest request =
              BeginTransactionRequest.newBuilder()
                  .setSession(session.getName())
                  .setOptions(options)
                  .build();
          Transaction transaction =
              SpannerImpl.runWithRetries(
                  new Callable<Transaction>() {
                    @Override
                    public Transaction call() throws Exception {
                      return rpc.beginTransaction(request, session.getOptions());
                    }
                  });
          if (!transaction.hasReadTimestamp()) {
            throw SpannerExceptionFactory.newSpannerException(
                ErrorCode.INTERNAL, "Missing expected transaction.read_timestamp metadata field");
          }
          if (transaction.getId().isEmpty()) {
            throw SpannerExceptionFactory.newSpannerException(
                ErrorCode.INTERNAL, "Missing expected transaction.id metadata field");
          }
          try {
            timestamp = Timestamp.fromProto(transaction.getReadTimestamp());
          } catch (IllegalArgumentException e) {
            throw SpannerExceptionFactory.newSpannerException(
                ErrorCode.INTERNAL, "Bad value in transaction.read_timestamp metadata field", e);
          }
          transactionId = transaction.getId();
          span.addAnnotation(
              "Transaction Creation Done", TraceUtil.getTransactionAnnotations(transaction));
        } catch (SpannerException e) {
          span.addAnnotation("Transaction Creation Failed", TraceUtil.getExceptionAnnotations(e));
          throw e;
        }
      }
    }
  }

  final Object lock = new Object();
  final SessionImpl session;
  final SpannerRpc rpc;
  final Span span;
  private final int defaultPrefetchChunks;

  @GuardedBy("lock")
  private boolean isValid = true;

  @GuardedBy("lock")
  private boolean isClosed = false;

  // A per-transaction sequence number used to identify this ExecuteSqlRequests. Required for DML,
  // ignored for query by the server.
  private AtomicLong seqNo = new AtomicLong();

  // Allow up to 512MB to be buffered (assuming 1MB chunks). In practice, restart tokens are sent
  // much more frequently.
  private static final int MAX_BUFFERED_CHUNKS = 512;

  AbstractReadContext(SessionImpl session, SpannerRpc rpc, int defaultPrefetchChunks) {
    this(session, rpc, defaultPrefetchChunks, Tracing.getTracer().getCurrentSpan());
  }

  private AbstractReadContext(
      SessionImpl session, SpannerRpc rpc, int defaultPrefetchChunks, Span span) {
    this.session = session;
    this.rpc = rpc;
    this.defaultPrefetchChunks = defaultPrefetchChunks;
    this.span = span;
  }

  long getSeqNo() {
    return seqNo.incrementAndGet();
  }

  @Override
  public final ResultSet read(
      String table, KeySet keys, Iterable<String> columns, ReadOption... options) {
    return readInternal(table, null, keys, columns, options);
  }

  @Override
  public final ResultSet readUsingIndex(
      String table, String index, KeySet keys, Iterable<String> columns, ReadOption... options) {
    return readInternal(table, checkNotNull(index), keys, columns, options);
  }

  @Nullable
  @Override
  public final Struct readRow(String table, Key key, Iterable<String> columns) {
    try (ResultSet resultSet = read(table, KeySet.singleKey(key), columns)) {
      return consumeSingleRow(resultSet);
    }
  }

  @Nullable
  @Override
  public final Struct readRowUsingIndex(
      String table, String index, Key key, Iterable<String> columns) {
    try (ResultSet resultSet = readUsingIndex(table, index, KeySet.singleKey(key), columns)) {
      return consumeSingleRow(resultSet);
    }
  }

  @Override
  public final ResultSet executeQuery(Statement statement, QueryOption... options) {
    return executeQueryInternal(
        statement, com.google.spanner.v1.ExecuteSqlRequest.QueryMode.NORMAL, options);
  }

  @Override
  public final ResultSet analyzeQuery(Statement statement, QueryAnalyzeMode readContextQueryMode) {
    switch (readContextQueryMode) {
      case PROFILE:
        return executeQueryInternal(
            statement, com.google.spanner.v1.ExecuteSqlRequest.QueryMode.PROFILE);
      case PLAN:
        return executeQueryInternal(
            statement, com.google.spanner.v1.ExecuteSqlRequest.QueryMode.PLAN);
      default:
        throw new IllegalStateException(
            "Unknown value for QueryAnalyzeMode : " + readContextQueryMode);
    }
  }

  private ResultSet executeQueryInternal(
      Statement statement,
      com.google.spanner.v1.ExecuteSqlRequest.QueryMode queryMode,
      QueryOption... options) {
    Options readOptions = Options.fromQueryOptions(options);
    return executeQueryInternalWithOptions(
        statement, queryMode, readOptions, null /*partitionToken*/);
  }

  ExecuteSqlRequest.Builder getExecuteSqlRequestBuilder(Statement statement, QueryMode queryMode) {
    ExecuteSqlRequest.Builder builder =
        ExecuteSqlRequest.newBuilder()
            .setSql(statement.getSql())
            .setQueryMode(queryMode)
            .setSession(session.getName());
    Map<String, Value> stmtParameters = statement.getParameters();
    if (!stmtParameters.isEmpty()) {
      com.google.protobuf.Struct.Builder paramsBuilder = builder.getParamsBuilder();
      for (Map.Entry<String, Value> param : stmtParameters.entrySet()) {
        paramsBuilder.putFields(param.getKey(), param.getValue().toProto());
        builder.putParamTypes(param.getKey(), param.getValue().getType().toProto());
      }
    }
    TransactionSelector selector = getTransactionSelector();
    if (selector != null) {
      builder.setTransaction(selector);
    }
    builder.setSeqno(getSeqNo());
    return builder;
  }

  ExecuteBatchDmlRequest.Builder getExecuteBatchDmlRequestBuilder(Iterable<Statement> statements) {
    ExecuteBatchDmlRequest.Builder builder =
        ExecuteBatchDmlRequest.newBuilder().setSession(session.getName());
    int idx = 0;
    for (Statement stmt : statements) {
      builder.addStatementsBuilder();
      builder.getStatementsBuilder(idx).setSql(stmt.getSql());
      Map<String, Value> stmtParameters = stmt.getParameters();
      if (!stmtParameters.isEmpty()) {
        com.google.protobuf.Struct.Builder paramsBuilder =
            builder.getStatementsBuilder(idx).getParamsBuilder();
        for (Map.Entry<String, Value> param : stmtParameters.entrySet()) {
          paramsBuilder.putFields(param.getKey(), param.getValue().toProto());
          builder
              .getStatementsBuilder(idx)
              .putParamTypes(param.getKey(), param.getValue().getType().toProto());
        }
      }
      idx++;
    }

    TransactionSelector selector = getTransactionSelector();
    if (selector != null) {
      builder.setTransaction(selector);
    }
    builder.setSeqno(getSeqNo());
    return builder;
  }

  ResultSet executeQueryInternalWithOptions(
      Statement statement,
      com.google.spanner.v1.ExecuteSqlRequest.QueryMode queryMode,
      Options readOptions,
      ByteString partitionToken) {
    beforeReadOrQuery();
    final ExecuteSqlRequest.Builder request = getExecuteSqlRequestBuilder(statement, queryMode);
    if (partitionToken != null) {
      request.setPartitionToken(partitionToken);
    }
    final int prefetchChunks =
        readOptions.hasPrefetchChunks() ? readOptions.prefetchChunks() : defaultPrefetchChunks;
    ResumableStreamIterator stream =
        new ResumableStreamIterator(MAX_BUFFERED_CHUNKS, SpannerImpl.QUERY, span) {
          @Override
          CloseableIterator<PartialResultSet> startStream(@Nullable ByteString resumeToken) {
            GrpcStreamIterator stream = new GrpcStreamIterator(prefetchChunks);
            if (resumeToken != null) {
              request.setResumeToken(resumeToken);
            }
            SpannerRpc.StreamingCall call =
                rpc.executeQuery(request.build(), stream.consumer(), session.getOptions());
            call.request(prefetchChunks);
            stream.setCall(call);
            return stream;
          }
        };
    return new GrpcResultSet(stream, this);
  }

  /**
   * Called before any read or query is started to perform state checks and initializations.
   * Subclasses should call {@code super.beforeReadOrQuery()} if overriding.
   */
  void beforeReadOrQuery() {
    synchronized (lock) {
      beforeReadOrQueryLocked();
    }
  }

  /** Called as part of {@link #beforeReadOrQuery()} under {@link #lock}. */
  @GuardedBy("lock")
  void beforeReadOrQueryLocked() {
    // Note that transactions are invalidated under some circumstances on the backend, but we
    // implement the check more strictly here to encourage coding to contract rather than the
    // implementation.
    checkState(isValid, "Context has been invalidated by a new operation on the session");
    checkState(!isClosed, "Context has been closed");
  }

  /** Invalidates the context since another context has been created more recently. */
  @Override
  public final void invalidate() {
    synchronized (lock) {
      isValid = false;
    }
  }

  @Override
  public void close() {
    span.end();
    synchronized (lock) {
      isClosed = true;
    }
  }

  @Nullable
  abstract TransactionSelector getTransactionSelector();

  @Override
  public void onTransactionMetadata(Transaction transaction) {}

  @Override
  public void onError(SpannerException e) {}

  @Override
  public void onDone() {}

  private ResultSet readInternal(
      String table,
      @Nullable String index,
      KeySet keys,
      Iterable<String> columns,
      ReadOption... options) {
    Options readOptions = Options.fromReadOptions(options);
    return readInternalWithOptions(
        table, index, keys, columns, readOptions, null /*partitionToken*/);
  }

  ResultSet readInternalWithOptions(
      String table,
      @Nullable String index,
      KeySet keys,
      Iterable<String> columns,
      Options readOptions,
      ByteString partitionToken) {
    beforeReadOrQuery();
    final ReadRequest.Builder builder =
        ReadRequest.newBuilder()
            .setSession(session.getName())
            .setTable(checkNotNull(table))
            .addAllColumns(columns);
    if (readOptions.hasLimit()) {
      builder.setLimit(readOptions.limit());
    }

    keys.appendToProto(builder.getKeySetBuilder());
    if (index != null) {
      builder.setIndex(index);
    }
    TransactionSelector selector = getTransactionSelector();
    if (selector != null) {
      builder.setTransaction(selector);
    }
    if (partitionToken != null) {
      builder.setPartitionToken(partitionToken);
    }
    final int prefetchChunks =
        readOptions.hasPrefetchChunks() ? readOptions.prefetchChunks() : defaultPrefetchChunks;
    ResumableStreamIterator stream =
        new ResumableStreamIterator(MAX_BUFFERED_CHUNKS, SpannerImpl.READ, span) {
          @Override
          CloseableIterator<PartialResultSet> startStream(@Nullable ByteString resumeToken) {
            GrpcStreamIterator stream = new GrpcStreamIterator(prefetchChunks);
            if (resumeToken != null) {
              builder.setResumeToken(resumeToken);
            }
            SpannerRpc.StreamingCall call =
                rpc.read(builder.build(), stream.consumer(), session.getOptions());
            call.request(prefetchChunks);
            stream.setCall(call);
            return stream;
          }
        };
    GrpcResultSet resultSet = new GrpcResultSet(stream, this);
    return resultSet;
  }

  private Struct consumeSingleRow(ResultSet resultSet) {
    if (!resultSet.next()) {
      return null;
    }
    Struct row = resultSet.getCurrentRowAsStruct();
    if (resultSet.next()) {
      throw newSpannerException(ErrorCode.INTERNAL, "Multiple rows returned for single key");
    }
    return row;
  }
}
