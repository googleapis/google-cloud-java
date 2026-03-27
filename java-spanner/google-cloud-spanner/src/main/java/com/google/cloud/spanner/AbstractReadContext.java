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

import static com.google.cloud.spanner.SessionClient.optionMap;
import static com.google.cloud.spanner.SpannerExceptionFactory.newSpannerException;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.core.ExecutorProvider;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AbstractResultSet.CloseableIterator;
import com.google.cloud.spanner.AsyncResultSet.CallbackResponse;
import com.google.cloud.spanner.AsyncResultSet.ReadyCallback;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.Options.ReadOption;
import com.google.cloud.spanner.SessionClient.SessionOption;
import com.google.cloud.spanner.SessionImpl.SessionTransaction;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.cloud.spanner.spi.v1.SpannerRpc.Option;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.ByteString;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.DirectedReadOptions;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ExecuteSqlRequest.QueryMode;
import com.google.spanner.v1.ExecuteSqlRequest.QueryOptions;
import com.google.spanner.v1.MultiplexedSessionPrecommitToken;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.RequestOptions;
import com.google.spanner.v1.Transaction;
import com.google.spanner.v1.TransactionOptions;
import com.google.spanner.v1.TransactionSelector;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/**
 * Abstract base class for all {@link ReadContext}s + concrete implementations of read-only {@link
 * ReadContext}s.
 */
abstract class AbstractReadContext
    implements ReadContext, AbstractResultSet.Listener, SessionTransaction {
  private static final Logger logger = Logger.getLogger(AbstractReadContext.class.getName());

  abstract static class Builder<B extends Builder<?, T>, T extends AbstractReadContext> {
    private SessionImpl session;
    private boolean cancelQueryWhenClientIsClosed;
    private SpannerRpc rpc;
    private ISpan span;
    private TraceWrapper tracer;
    private int defaultPrefetchChunks = SpannerOptions.Builder.DEFAULT_PREFETCH_CHUNKS;
    private QueryOptions defaultQueryOptions = SpannerOptions.Builder.DEFAULT_QUERY_OPTIONS;
    private DecodeMode defaultDecodeMode = SpannerOptions.Builder.DEFAULT_DECODE_MODE;
    private DirectedReadOptions defaultDirectedReadOption;
    private ExecutorProvider executorProvider;
    private Clock clock = Clock.INSTANCE;

    Builder() {}

    @SuppressWarnings("unchecked")
    B self() {
      return (B) this;
    }

    B setSession(SessionImpl session) {
      this.session = session;
      return self();
    }

    B setCancelQueryWhenClientIsClosed(boolean cancelQueryWhenClientIsClosed) {
      this.cancelQueryWhenClientIsClosed = cancelQueryWhenClientIsClosed;
      return self();
    }

    B setRpc(SpannerRpc rpc) {
      this.rpc = rpc;
      return self();
    }

    B setSpan(ISpan span) {
      this.span = span;
      return self();
    }

    B setTracer(TraceWrapper tracer) {
      this.tracer = tracer;
      return self();
    }

    B setDefaultPrefetchChunks(int defaultPrefetchChunks) {
      this.defaultPrefetchChunks = defaultPrefetchChunks;
      return self();
    }

    B setDefaultQueryOptions(QueryOptions defaultQueryOptions) {
      this.defaultQueryOptions = defaultQueryOptions;
      return self();
    }

    B setDefaultDecodeMode(DecodeMode defaultDecodeMode) {
      this.defaultDecodeMode = defaultDecodeMode;
      return self();
    }

    B setExecutorProvider(ExecutorProvider executorProvider) {
      this.executorProvider = executorProvider;
      return self();
    }

    B setClock(Clock clock) {
      this.clock = Preconditions.checkNotNull(clock);
      return self();
    }

    B setDefaultDirectedReadOptions(DirectedReadOptions directedReadOptions) {
      this.defaultDirectedReadOption = directedReadOptions;
      return self();
    }

    abstract T build();
  }

  /**
   * {@link AsyncResultSet} that supports adding listeners that are called when all rows from the
   * underlying result stream have been fetched.
   */
  interface ListenableAsyncResultSet extends AsyncResultSet {
    /** Adds a listener to this {@link AsyncResultSet}. */
    void addListener(Runnable listener);

    void removeListener(Runnable listener);
  }

  /**
   * A {@code ReadContext} for standalone reads. This can only be used for a single operation, since
   * each standalone read may see a different timestamp of Cloud Spanner data.
   */
  static class SingleReadContext extends AbstractReadContext {
    static class Builder extends AbstractReadContext.Builder<Builder, SingleReadContext> {
      private TimestampBound bound;

      private Builder() {}

      Builder setTimestampBound(TimestampBound bound) {
        this.bound = bound;
        return self();
      }

      @Override
      SingleReadContext build() {
        return new SingleReadContext(this);
      }

      SingleUseReadOnlyTransaction buildSingleUseReadOnlyTransaction() {
        return new SingleUseReadOnlyTransaction(this);
      }
    }

    static Builder newBuilder() {
      return new Builder();
    }

    final TimestampBound bound;

    @GuardedBy("lock")
    private boolean used;

    private Map<SpannerRpc.Option, ?> channelHint;

    private SingleReadContext(Builder builder) {
      super(builder);
      this.bound = builder.bound;
      // single use transaction have a single RPC and hence there is no need
      // of a channel hint. GAX will automatically choose a hint when used
      // with a multiplexed session to perform a round-robin channel selection. We are
      // passing a hint here to prefer random channel selection instead of doing GAX round-robin.
      this.channelHint =
          getChannelHintOptions(
              session.getOptions(), ThreadLocalRandom.current().nextLong(Long.MAX_VALUE));
    }

    @Override
    protected boolean isRouteToLeader() {
      return false;
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

    @Override
    Map<SpannerRpc.Option, ?> getTransactionChannelHint() {
      return channelHint;
    }

    @Override
    boolean prepareRetryOnDifferentGrpcChannel() {
      if (session.getIsMultiplexed() && channelHint.get(Option.CHANNEL_HINT) != null) {
        long channelHintForTransaction = Option.CHANNEL_HINT.getLong(channelHint) + 1L;
        channelHint = optionMap(SessionOption.channelHint(channelHintForTransaction));
        return true;
      }
      return super.prepareRetryOnDifferentGrpcChannel();
    }
  }

  private static void assertTimestampAvailable(boolean available) {
    checkState(available, "Method can only be called after read has returned data or finished");
  }

  static class SingleUseReadOnlyTransaction extends SingleReadContext
      implements ReadOnlyTransaction {

    @GuardedBy("lock")
    private Timestamp timestamp;

    private SingleUseReadOnlyTransaction(SingleReadContext.Builder builder) {
      super(builder);
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
    public void onTransactionMetadata(Transaction transaction, boolean shouldIncludeId) {
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
    static class Builder extends AbstractReadContext.Builder<Builder, MultiUseReadOnlyTransaction> {
      private TimestampBound bound;
      private Timestamp timestamp;
      private ByteString transactionId;

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

      @Override
      MultiUseReadOnlyTransaction build() {
        return new MultiUseReadOnlyTransaction(this);
      }
    }

    static Builder newBuilder() {
      return new Builder();
    }

    private TimestampBound bound;
    private final Object txnLock = new Object();

    @GuardedBy("txnLock")
    private Timestamp timestamp;

    @GuardedBy("txnLock")
    private ByteString transactionId;

    private final Map<SpannerRpc.Option, ?> channelHint;

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
              session.getOptions(), ThreadLocalRandom.current().nextLong(Long.MAX_VALUE));
    }

    @Override
    public Map<SpannerRpc.Option, ?> getTransactionChannelHint() {
      return channelHint;
    }

    @Override
    protected boolean isRouteToLeader() {
      return false;
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

    @Override
    public void close() {
      ByteString id = getTransactionId();
      if (id != null && !id.isEmpty()) {
        rpc.clearTransactionAffinity(id);
      }
      super.close();
    }

    /**
     * Initializes the transaction with the timestamp specified within MultiUseReadOnlyTransaction.
     * This is used only for fallback of PartitionQueryRequest and PartitionReadRequest with
     * Multiplexed Session.
     */
    void initFallbackTransaction() {
      synchronized (txnLock) {
        span.addAnnotation("Creating Transaction");
        TransactionOptions.Builder options = TransactionOptions.newBuilder();
        if (timestamp != null) {
          options
              .getReadOnlyBuilder()
              .setReadTimestamp(timestamp.toProto())
              .setReturnReadTimestamp(true);
        } else {
          bound.applyToBuilder(options.getReadOnlyBuilder()).setReturnReadTimestamp(true);
        }
        final BeginTransactionRequest request =
            BeginTransactionRequest.newBuilder()
                .setSession(session.getName())
                .setOptions(options)
                .build();
        initTransactionInternal(request);
      }
    }

    void initTransaction() {
      SessionImpl.throwIfTransactionsPending();

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
        TransactionOptions.Builder options = TransactionOptions.newBuilder();
        bound.applyToBuilder(options.getReadOnlyBuilder()).setReturnReadTimestamp(true);
        final BeginTransactionRequest request =
            BeginTransactionRequest.newBuilder()
                .setSession(session.getName())
                .setOptions(options)
                .build();
        initTransactionInternal(request);
      }
    }

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
        try {
          timestamp = Timestamp.fromProto(transaction.getReadTimestamp());
        } catch (IllegalArgumentException e) {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.INTERNAL, "Bad value in transaction.read_timestamp metadata field", e);
        }
        transactionId = transaction.getId();
        span.addAnnotation(
            "Transaction Creation Done",
            ImmutableMap.of(
                "Id", transaction.getId().toStringUtf8(), "Timestamp", timestamp.toString()));
      } catch (SpannerException e) {
        span.addAnnotation("Transaction Creation Failed", e);
        throw e;
      }
    }
  }

  final Object lock = new Object();
  final SessionImpl session;
  final boolean cancelQueryWhenClientIsClosed;
  final SpannerRpc rpc;
  final ExecutorProvider executorProvider;
  ISpan span;
  TraceWrapper tracer;
  private final int defaultPrefetchChunks;
  private final QueryOptions defaultQueryOptions;
  private final DirectedReadOptions defaultDirectedReadOptions;
  private final DecodeMode defaultDecodeMode;
  private final Clock clock;

  @GuardedBy("lock")
  private boolean isValid = true;

  @GuardedBy("lock")
  protected boolean isClosed = false;

  // A per-transaction sequence number used to identify this ExecuteSqlRequests. Required for DML,
  // ignored for query by the server.
  private final AtomicLong seqNo = new AtomicLong();

  // Allow up to 512MB to be buffered (assuming 1MB chunks). In practice, restart tokens are sent
  // much more frequently.
  private static final int MAX_BUFFERED_CHUNKS = 512;

  protected static final String NO_TRANSACTION_RETURNED_MSG =
      "The statement did not return a transaction even though one was requested";

  AbstractReadContext(Builder<?, ?> builder) {
    this.session = builder.session;
    this.cancelQueryWhenClientIsClosed = builder.cancelQueryWhenClientIsClosed;
    this.rpc = builder.rpc;
    this.defaultPrefetchChunks = builder.defaultPrefetchChunks;
    this.defaultQueryOptions = builder.defaultQueryOptions;
    this.defaultDirectedReadOptions = builder.defaultDirectedReadOption;
    this.defaultDecodeMode = builder.defaultDecodeMode;
    this.span = builder.span;
    this.executorProvider = builder.executorProvider;
    this.clock = builder.clock;
    this.tracer = builder.tracer;
  }

  @Override
  public void setSpan(ISpan span) {
    this.span = span;
  }

  long getSeqNo() {
    return seqNo.incrementAndGet();
  }

  protected boolean isReadOnly() {
    return true;
  }

  protected boolean isRouteToLeader() {
    return false;
  }

  @Override
  public final ResultSet read(
      String table, KeySet keys, Iterable<String> columns, ReadOption... options) {
    return readInternal(table, null, keys, columns, options);
  }

  @Override
  public ListenableAsyncResultSet readAsync(
      String table, KeySet keys, Iterable<String> columns, ReadOption... options) {
    Options readOptions = Options.fromReadOptions(options);
    final int bufferRows =
        readOptions.hasBufferRows()
            ? readOptions.bufferRows()
            : AsyncResultSetImpl.DEFAULT_BUFFER_SIZE;
    return new AsyncResultSetImpl(
        executorProvider, readInternal(table, null, keys, columns, options), bufferRows);
  }

  @Override
  public final ResultSet readUsingIndex(
      String table, String index, KeySet keys, Iterable<String> columns, ReadOption... options) {
    return readInternal(table, checkNotNull(index), keys, columns, options);
  }

  @Override
  public ListenableAsyncResultSet readUsingIndexAsync(
      String table, String index, KeySet keys, Iterable<String> columns, ReadOption... options) {
    Options readOptions = Options.fromReadOptions(options);
    final int bufferRows =
        readOptions.hasBufferRows()
            ? readOptions.bufferRows()
            : AsyncResultSetImpl.DEFAULT_BUFFER_SIZE;
    return new AsyncResultSetImpl(
        executorProvider,
        readInternal(table, checkNotNull(index), keys, columns, options),
        bufferRows);
  }

  @Nullable
  @Override
  public final Struct readRow(String table, Key key, Iterable<String> columns) {
    try (ResultSet resultSet = read(table, KeySet.singleKey(key), columns)) {
      return consumeSingleRow(resultSet);
    }
  }

  @Override
  public final ApiFuture<Struct> readRowAsync(String table, Key key, Iterable<String> columns) {
    try (AsyncResultSet resultSet = readAsync(table, KeySet.singleKey(key), columns)) {
      return consumeSingleRowAsync(resultSet);
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
  public final ApiFuture<Struct> readRowUsingIndexAsync(
      String table, String index, Key key, Iterable<String> columns) {
    try (AsyncResultSet resultSet =
        readUsingIndexAsync(table, index, KeySet.singleKey(key), columns)) {
      return consumeSingleRowAsync(resultSet);
    }
  }

  @Override
  public final ResultSet executeQuery(Statement statement, QueryOption... options) {
    return executeQueryInternal(
        statement, com.google.spanner.v1.ExecuteSqlRequest.QueryMode.NORMAL, options);
  }

  @Override
  public ListenableAsyncResultSet executeQueryAsync(Statement statement, QueryOption... options) {
    Options readOptions = Options.fromQueryOptions(options);
    final int bufferRows =
        readOptions.hasBufferRows()
            ? readOptions.bufferRows()
            : AsyncResultSetImpl.DEFAULT_BUFFER_SIZE;
    return new AsyncResultSetImpl(
        executorProvider,
        executeQueryInternal(
            statement, com.google.spanner.v1.ExecuteSqlRequest.QueryMode.NORMAL, options),
        bufferRows);
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
    Options queryOptions = Options.fromQueryOptions(options);
    return executeQueryInternalWithOptions(
        statement, queryMode, queryOptions, null /*partitionToken*/);
  }

  /**
   * Determines the {@link QueryOptions} to use for a query. This is determined using the following
   * precedence:
   *
   * <ol>
   *   <li>Specific {@link QueryOptions} passed in for this query.
   *   <li>Any value specified in a valid environment variable when the {@link SpannerOptions}
   *       instance was created.
   *   <li>The default {@link SpannerOptions#getDefaultQueryOptions(DatabaseId)} ()} specified for
   *       the database where the query is executed.
   * </ol>
   */
  @VisibleForTesting
  QueryOptions buildQueryOptions(QueryOptions requestOptions) {
    // Shortcut for the most common return value.
    if (requestOptions == null) {
      return defaultQueryOptions;
    }
    return defaultQueryOptions.toBuilder().mergeFrom(requestOptions).build();
  }

  RequestOptions buildRequestOptions(Options options) {
    RequestOptions.Builder builder = options.toRequestOptionsProto(false).toBuilder();
    RequestOptions.ClientContext defaultClientContext =
        session.getSpanner().getOptions().getClientContext();
    if (defaultClientContext != null) {
      RequestOptions.ClientContext.Builder clientContextBuilder = defaultClientContext.toBuilder();
      if (builder.hasClientContext()) {
        clientContextBuilder.mergeFrom(builder.getClientContext());
      }
      builder.setClientContext(clientContextBuilder.build());
    }
    if (getTransactionTag() != null) {
      builder.setTransactionTag(getTransactionTag());
    }
    return builder.build();
  }

  ExecuteSqlRequest.Builder getExecuteSqlRequestBuilder(
      Statement statement, QueryMode queryMode, Options options, boolean withTransactionSelector) {
    ExecuteSqlRequest.Builder builder =
        ExecuteSqlRequest.newBuilder()
            .setSql(statement.getSql())
            .setQueryMode(queryMode)
            .setSession(session.getName());
    addParameters(builder, statement.getParameters());
    if (withTransactionSelector) {
      TransactionSelector selector = getTransactionSelector();
      if (selector != null) {
        builder.setTransaction(selector);
      }
    }
    if (options.hasDataBoostEnabled()) {
      builder.setDataBoostEnabled(options.dataBoostEnabled());
    }
    if (options.hasDirectedReadOptions()) {
      builder.setDirectedReadOptions(options.directedReadOptions());
    } else if (defaultDirectedReadOptions != null) {
      builder.setDirectedReadOptions(defaultDirectedReadOptions);
    }
    if (!isReadOnly()) {
      builder.setSeqno(getSeqNo());
    }
    if (options.hasLastStatement()) {
      builder.setLastStatement(options.isLastStatement());
    }
    builder.setQueryOptions(buildQueryOptions(statement.getQueryOptions()));
    builder.setRequestOptions(buildRequestOptions(options));
    return builder;
  }

  static void addParameters(ExecuteSqlRequest.Builder builder, Map<String, Value> stmtParameters) {
    if (!stmtParameters.isEmpty()) {
      com.google.protobuf.Struct.Builder paramsBuilder = builder.getParamsBuilder();
      for (Map.Entry<String, Value> param : stmtParameters.entrySet()) {
        paramsBuilder.putFields(param.getKey(), Value.toProto(param.getValue()));
        if (param.getValue() != null && param.getValue().getType() != null) {
          builder.putParamTypes(param.getKey(), param.getValue().getType().toProto());
        }
      }
    }
  }

  ExecuteBatchDmlRequest.Builder getExecuteBatchDmlRequestBuilder(
      Iterable<Statement> statements, Options options) {
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
          paramsBuilder.putFields(param.getKey(), Value.toProto(param.getValue()));
          if (param.getValue() != null && param.getValue().getType() != null) {
            builder
                .getStatementsBuilder(idx)
                .putParamTypes(param.getKey(), param.getValue().getType().toProto());
          }
        }
      }
      idx++;
    }

    TransactionSelector selector = getTransactionSelector();
    if (selector != null) {
      builder.setTransaction(selector);
    }
    if (options.hasLastStatement()) {
      builder.setLastStatements(options.isLastStatement());
    }
    builder.setSeqno(getSeqNo());
    builder.setRequestOptions(buildRequestOptions(options));
    return builder;
  }

  ResultSet executeQueryInternalWithOptions(
      final Statement statement,
      final com.google.spanner.v1.ExecuteSqlRequest.QueryMode queryMode,
      final Options options,
      final ByteString partitionToken) {
    beforeReadOrQuery();
    final int prefetchChunks =
        options.hasPrefetchChunks() ? options.prefetchChunks() : defaultPrefetchChunks;
    final ExecuteSqlRequest.Builder request =
        getExecuteSqlRequestBuilder(
            statement, queryMode, options, /* withTransactionSelector= */ false);
    ResumableStreamIterator stream =
        new ResumableStreamIterator(
            MAX_BUFFERED_CHUNKS,
            SpannerImpl.QUERY,
            span,
            tracer,
            tracer.createStatementAttributes(statement, options),
            session.getErrorHandler(),
            rpc.getExecuteQueryRetrySettings(),
            rpc.getExecuteQueryRetryableCodes(),
            session.getRequestIdCreator()) {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              AsyncResultSet.StreamMessageListener streamListener,
              XGoogSpannerRequestId requestId) {
            GrpcStreamIterator stream =
                new GrpcStreamIterator(
                    statement,
                    request.getLastStatement(),
                    prefetchChunks,
                    cancelQueryWhenClientIsClosed);
            if (streamListener != null) {
              stream.registerListener(streamListener);
            }
            if (partitionToken != null) {
              request.setPartitionToken(partitionToken);
            }
            TransactionSelector selector = null;
            if (resumeToken != null) {
              request.setResumeToken(resumeToken);
              selector = getTransactionSelector();
            } else if (!request.hasTransaction()) {
              selector = getTransactionSelector();
            }
            if (selector != null) {
              request.setTransaction(selector);
            }
            SpannerRpc.StreamingCall call =
                rpc.executeQuery(
                    request.build(),
                    stream.consumer(),
                    getTransactionChannelHint(),
                    requestId,
                    isRouteToLeader());
            session.markUsed(clock.instant());
            stream.setCall(call, request.getTransaction().hasBegin());
            return stream;
          }

          @Override
          boolean prepareIteratorForRetryOnDifferentGrpcChannel() {
            return AbstractReadContext.this.prepareRetryOnDifferentGrpcChannel();
          }
        };
    return new GrpcResultSet(
        stream, this, options.hasDecodeMode() ? options.decodeMode() : defaultDecodeMode);
  }

  static Map<SpannerRpc.Option, ?> getChannelHintOptions(
      Map<SpannerRpc.Option, ?> channelHintForSession, Long channelHintForTransaction) {
    if (channelHintForSession != null) {
      return channelHintForSession;
    } else if (channelHintForTransaction != null) {
      return optionMap(SessionOption.channelHint(channelHintForTransaction));
    }
    return null;
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
    session.onTransactionDone();
    span.end();
    synchronized (lock) {
      isClosed = true;
    }
  }

  /**
   * Returns the {@link TransactionSelector} that should be used for a statement that is executed on
   * this read context. This could be a reference to an existing transaction ID, or it could be a
   * BeginTransaction option that should be included with the statement.
   */
  @Nullable
  abstract TransactionSelector getTransactionSelector();

  /**
   * Channel hint to be used for a transaction. This enables soft-stickiness per transaction by
   * ensuring all RPCs within a transaction land up on the same channel.
   */
  abstract Map<SpannerRpc.Option, ?> getTransactionChannelHint();

  boolean prepareRetryOnDifferentGrpcChannel() {
    return false;
  }

  /**
   * Returns the transaction tag for this {@link AbstractReadContext} or <code>null</code> if this
   * {@link AbstractReadContext} does not have a transaction tag.
   */
  @Nullable
  String getTransactionTag() {
    return null;
  }

  /** This method is called when a statement returned a new transaction as part of its results. */
  @Override
  public void onTransactionMetadata(Transaction transaction, boolean shouldIncludeId) {}

  @Override
  public SpannerException onError(
      SpannerException e, boolean withBeginTransaction, boolean lastStatement) {
    this.session.onError(e);
    return e;
  }

  @Override
  public void onDone(boolean withBeginTransaction) {
    this.session.onReadDone();
  }

  /**
   * For transactions other than read-write, the MultiplexedSessionPrecommitToken will not be
   * present in the RPC response. In such cases, this method will be a no-op.
   */
  @Override
  public void onPrecommitToken(MultiplexedSessionPrecommitToken token) {}

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
      final Options readOptions,
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
    if (partitionToken != null) {
      builder.setPartitionToken(partitionToken);
    }
    if (readOptions.hasDataBoostEnabled()) {
      builder.setDataBoostEnabled(readOptions.dataBoostEnabled());
    }
    if (readOptions.hasOrderBy()) {
      builder.setOrderBy(readOptions.orderBy());
    }
    if (readOptions.hasDirectedReadOptions()) {
      builder.setDirectedReadOptions(readOptions.directedReadOptions());
    } else if (defaultDirectedReadOptions != null) {
      builder.setDirectedReadOptions(defaultDirectedReadOptions);
    }
    if (readOptions.hasLockHint()) {
      if (isReadOnly()) {
        logger.warning(
            "Lock hint is only supported for ReadWrite transactions. "
                + "Overriding lock hint to default unspecified.");
      } else {
        builder.setLockHint(readOptions.lockHint());
      }
    }
    final int prefetchChunks =
        readOptions.hasPrefetchChunks() ? readOptions.prefetchChunks() : defaultPrefetchChunks;
    final boolean lastStatement =
        readOptions.hasLastStatement() ? readOptions.isLastStatement() : false;
    ResumableStreamIterator stream =
        new ResumableStreamIterator(
            MAX_BUFFERED_CHUNKS,
            SpannerImpl.READ,
            span,
            tracer,
            tracer.createTableAttributes(table, readOptions),
            session.getErrorHandler(),
            rpc.getReadRetrySettings(),
            rpc.getReadRetryableCodes(),
            session.getRequestIdCreator()) {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              AsyncResultSet.StreamMessageListener streamListener,
              XGoogSpannerRequestId requestId) {
            GrpcStreamIterator stream =
                new GrpcStreamIterator(
                    lastStatement, prefetchChunks, cancelQueryWhenClientIsClosed);
            if (streamListener != null) {
              stream.registerListener(streamListener);
            }
            TransactionSelector selector = null;
            if (resumeToken != null) {
              builder.setResumeToken(resumeToken);
              selector = getTransactionSelector();
            } else if (!builder.hasTransaction()) {
              selector = getTransactionSelector();
            }
            if (selector != null) {
              builder.setTransaction(selector);
            }
            builder.setRequestOptions(buildRequestOptions(readOptions));
            SpannerRpc.StreamingCall call =
                rpc.read(
                    builder.build(),
                    stream.consumer(),
                    getTransactionChannelHint(),
                    requestId,
                    isRouteToLeader());
            session.markUsed(clock.instant());
            stream.setCall(call, /* withBeginTransaction= */ builder.getTransaction().hasBegin());
            return stream;
          }

          @Override
          boolean prepareIteratorForRetryOnDifferentGrpcChannel() {
            return AbstractReadContext.this.prepareRetryOnDifferentGrpcChannel();
          }
        };
    return new GrpcResultSet(
        stream, this, readOptions.hasDecodeMode() ? readOptions.decodeMode() : defaultDecodeMode);
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

  static ApiFuture<Struct> consumeSingleRowAsync(AsyncResultSet resultSet) {
    final SettableApiFuture<Struct> result = SettableApiFuture.create();
    // We can safely use a directExecutor here, as we will only be consuming one row, and we will
    // not be doing any blocking stuff in the handler.
    final SettableApiFuture<Struct> row = SettableApiFuture.create();
    ApiFutures.addCallback(
        resultSet.setCallback(MoreExecutors.directExecutor(), ConsumeSingleRowCallback.create(row)),
        new ApiFutureCallback<Void>() {
          @Override
          public void onFailure(Throwable t) {
            result.setException(t);
          }

          @Override
          public void onSuccess(Void input) {
            try {
              result.set(row.get());
            } catch (Throwable t) {
              result.setException(t);
            }
          }
        },
        MoreExecutors.directExecutor());
    return result;
  }

  /**
   * {@link ReadyCallback} for returning the first row in a result set as a future {@link Struct}.
   */
  private static class ConsumeSingleRowCallback implements ReadyCallback {
    private final SettableApiFuture<Struct> result;
    private Struct row;

    static ConsumeSingleRowCallback create(SettableApiFuture<Struct> result) {
      return new ConsumeSingleRowCallback(result);
    }

    private ConsumeSingleRowCallback(SettableApiFuture<Struct> result) {
      this.result = result;
    }

    @Override
    public CallbackResponse cursorReady(AsyncResultSet resultSet) {
      try {
        switch (resultSet.tryNext()) {
          case DONE:
            result.set(row);
            return CallbackResponse.DONE;
          case NOT_READY:
            return CallbackResponse.CONTINUE;
          case OK:
            if (row != null) {
              throw newSpannerException(
                  ErrorCode.INTERNAL, "Multiple rows returned for single key");
            }
            row = resultSet.getCurrentRowAsStruct();
            return CallbackResponse.CONTINUE;
          default:
            throw new IllegalStateException();
        }
      } catch (Throwable t) {
        result.setException(t);
        return CallbackResponse.DONE;
      }
    }
  }
}
