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
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.core.ExecutorProvider;
import com.google.cloud.grpc.GcpManagedChannel.ChannelAffinityRef;
import com.google.cloud.spanner.AbstractResultSet.CloseableIterator;
import com.google.cloud.spanner.AsyncResultSet.CallbackResponse;
import com.google.cloud.spanner.AsyncResultSet.ReadyCallback;
import com.google.cloud.spanner.AsyncResultSet.StreamMessageListener;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.Options.ReadOption;
import com.google.cloud.spanner.SessionClient.SessionOption;
import com.google.cloud.spanner.SessionImpl.SessionTransaction;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.ByteString;
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
import com.google.spanner.v1.TransactionSelector;
import io.opentelemetry.api.common.Attributes;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;
import org.jspecify.annotations.Nullable;

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
      this.clock = checkNotNull(clock);
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

  static void assertTimestampAvailable(boolean available) {
    checkState(available, "Method can only be called after read has returned data or finished");
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
  final DirectedReadOptions defaultDirectedReadOptions;
  private final DecodeMode defaultDecodeMode;
  private final Clock clock;
  private volatile String cachedRequestTag;

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

  ResultSet executeQueryInternal(
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
      // Read-write transactions support transaction-level tags only. We populate the
      // transaction tag on the builder if it is non-empty.
      if (!getTransactionTag().isEmpty()) {
        builder.setTransactionTag(getTransactionTag());
      }
    } else if (session.getSpanner().getOptions().isAutoTaggingEnabled()
        && builder.getRequestTag().isEmpty()) {
      // Read-only contexts (both single-use and multi-use) do not support transaction-level tags.
      // We lazily resolve and populate the request tag instead.
      if (this.cachedRequestTag == null) {
        String autoTag = AutoTagHelper.getAutoTag(session.getSpanner().getOptions());
        this.cachedRequestTag = autoTag == null ? "" : autoTag;
      }
      if (!this.cachedRequestTag.isEmpty()) {
        builder.setRequestTag(this.cachedRequestTag);
      }
    }
    return builder.build();
  }

  ExecuteSqlRequest.Builder getExecuteSqlRequestBuilder(
      Statement statement, QueryMode queryMode, Options options, boolean withTransactionSelector) {
    return getExecuteSqlRequest(
            statement, queryMode, options, /* partitionToken= */ null, withTransactionSelector)
        .getBuilder();
  }

  private ReadOrQueryRequest.Query getExecuteSqlRequest(
      Statement statement,
      QueryMode queryMode,
      Options options,
      @Nullable ByteString partitionToken,
      boolean withTransactionSelector) {
    ExecuteSqlRequest.Builder builder =
        ExecuteSqlRequest.newBuilder().setSql(statement.getSql()).setQueryMode(queryMode);
    addParameters(builder, statement.getParameters());
    if (withTransactionSelector) {
      TransactionSelector selector = getTransactionSelector();
      if (selector != null) {
        builder.setTransaction(selector);
      }
    }
    if (!isReadOnly()) {
      builder.setSeqno(getSeqNo());
    }
    if (options.hasLastStatement()) {
      builder.setLastStatement(options.isLastStatement());
    }
    builder.setQueryOptions(buildQueryOptions(statement.getQueryOptions()));
    return ReadOrQueryRequest.forQuery(this, builder, statement, options, partitionToken);
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

  private ResultSet createStreamingResultSet(
      ReadOrQueryRequest request, Attributes attributes, Options options) {
    final int prefetchChunks =
        options.hasPrefetchChunks() ? options.prefetchChunks() : this.defaultPrefetchChunks;
    final boolean lastStatement = options.hasLastStatement() && options.isLastStatement();
    ResumableStreamIterator stream =
        new ResumableStreamIterator(
            MAX_BUFFERED_CHUNKS,
            request.getOperationName(),
            this.span,
            this.tracer,
            attributes,
            this.session.getErrorHandler(),
            request.getRetrySettings(this.rpc),
            request.getRetryableCodes(this.rpc),
            this.session.getRequestIdCreator()) {
          private volatile boolean closed;

          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamListener,
              XGoogSpannerRequestId requestId) {
            if (resumeToken != null) {
              request.setResumeToken(resumeToken);
            }
            // 1. When starting the stream for the first time (resumeToken == null and
            //    !request.hasTransaction()), look up and set the TransactionSelector.
            //    If the stream is retried before receiving a resumeToken (resumeToken == null)
            //    and already has a TransactionSelector, we reuse the existing selector. In
            //    particular, if the initial request included an inlined BeginTransaction, the
            //    retry must still send BeginTransaction, and calling getTransactionSelector()
            //    again before the transaction ID has been received would block waiting on its
            //    own transactionIdFuture.
            // 2. When resuming a stream after receiving a resumeToken (resumeToken != null),
            //    the TransactionSelector only changes if the initial request included an
            //    inlined BeginTransaction (request.isWithBeginTransaction()): receiving a
            //    resumeToken means the first response chunk (and its Transaction metadata) has
            //    already been processed, so we replace the BeginTransaction selector with the
            //    transaction ID selector for the resumed stream.
            if ((resumeToken == null && !request.hasTransaction())
                || (resumeToken != null && request.isWithBeginTransaction())) {
              TransactionSelector selector = getTransactionSelector();
              if (selector != null) {
                request.setTransaction(selector);
              }
            }
            boolean withBeginTransaction = request.isWithBeginTransaction();
            GrpcStreamIterator stream =
                new GrpcStreamIterator(
                    request.getStatement(),
                    lastStatement,
                    prefetchChunks,
                    cancelQueryWhenClientIsClosed,
                    withBeginTransaction);
            if (streamListener != null) {
              stream.registerListener(streamListener);
            }
            SpannerRpc.StreamingCall call;
            try {
              call =
                  request.start(
                      rpc,
                      stream.consumer(),
                      getTransactionChannelHint(),
                      requestId,
                      isRouteToLeader());
            } catch (Throwable throwable) {
              onStartFailed(withBeginTransaction, lastStatement, throwable);
              throw throwable;
            }
            session.markUsed(clock.instant());
            stream.setCall(call);
            return stream;
          }

          @Override
          boolean prepareIteratorForRetryOnDifferentGrpcChannel() {
            return AbstractReadContext.this.prepareRetryOnDifferentGrpcChannel();
          }

          @Override
          public void close(@Nullable String message) {
            // Mark closed before super.close() cancels the underlying gRPC call so that a consumer
            // thread woken by the cancellation never reports an inlined-begin failure for a closed
            // result set.
            this.closed = true;
            super.close(message);
          }

          @Override
          public boolean isWithBeginTransaction() {
            return !this.closed && request.isWithBeginTransaction();
          }

          @Override
          public boolean isLastStatement() {
            return lastStatement;
          }
        };
    return new GrpcResultSet(
        stream, this, options.hasDecodeMode() ? options.decodeMode() : this.defaultDecodeMode);
  }

  ResultSet executeQueryInternalWithOptions(
      final Statement statement,
      final QueryMode queryMode,
      final Options options,
      final ByteString partitionToken) {
    beforeReadOrQuery();
    return createStreamingResultSet(
        getExecuteSqlRequest(
            statement, queryMode, options, partitionToken, /* withTransactionSelector= */ false),
        this.tracer.createStatementAttributes(statement, options),
        options);
  }

  static Map<SpannerRpc.Option, ?> getChannelHintOptions(
      Map<SpannerRpc.Option, ?> channelHintForSession, Long channelHintForTransaction) {
    return getChannelHintOptions(
        channelHintForSession, channelHintForTransaction, /* useTransactionHint= */ false);
  }

  static Map<SpannerRpc.Option, ?> getChannelHintOptions(
      Map<SpannerRpc.Option, ?> channelHintForSession,
      Long channelHintForTransaction,
      boolean grpcGcpEnabled) {
    // grpc-gcp uses a per-operation/per-transaction random hint instead of reusing the session
    // hint so requests distribute independently from session affinity. Use direct channel-ref
    // affinity so grpc-gcp does not need affinity-key map entries for Spanner operations.
    if (grpcGcpEnabled && channelHintForTransaction != null) {
      return optionMap(SessionOption.channelAffinityRef(new ChannelAffinityRef()));
    }
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
  @Nullable String getTransactionTag() {
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

  void onStartFailed(boolean withBeginTransaction, boolean lastStatement, Throwable throwable) {}

  /**
   * For transactions other than read-write, the MultiplexedSessionPrecommitToken will not be
   * present in the RPC response. In such cases, this method will be a no-op.
   */
  @Override
  public void onPrecommitToken(MultiplexedSessionPrecommitToken token) {}

  ResultSet readInternal(
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
        ReadRequest.newBuilder().setTable(checkNotNull(table)).addAllColumns(columns);
    if (readOptions.hasLimit()) {
      builder.setLimit(readOptions.limit());
    }
    keys.appendToProto(builder.getKeySetBuilder());
    if (index != null) {
      builder.setIndex(index);
    }
    if (readOptions.hasOrderBy()) {
      builder.setOrderBy(readOptions.orderBy());
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
    return createStreamingResultSet(
        ReadOrQueryRequest.forRead(this, builder, readOptions, partitionToken),
        this.tracer.createTableAttributes(table, readOptions),
        readOptions);
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
