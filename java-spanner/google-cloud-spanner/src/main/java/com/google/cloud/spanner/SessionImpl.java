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

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AbstractReadContext.MultiUseReadOnlyTransaction;
import com.google.cloud.spanner.AbstractReadContext.SingleReadContext;
import com.google.cloud.spanner.AbstractReadContext.SingleUseReadOnlyTransaction;
import com.google.cloud.spanner.ErrorHandler.DefaultErrorHandler;
import com.google.cloud.spanner.Options.TransactionOption;
import com.google.cloud.spanner.Options.UpdateOption;
import com.google.cloud.spanner.SessionClient.SessionOption;
import com.google.cloud.spanner.TransactionRunnerImpl.TransactionContextImpl;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.common.base.Ticker;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.spanner.v1.BatchWriteRequest;
import com.google.spanner.v1.BatchWriteResponse;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.RequestOptions;
import com.google.spanner.v1.Transaction;
import com.google.spanner.v1.TransactionOptions;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;

/**
 * Implementation of {@link Session}. Sessions are managed internally by the client library, and
 * users need not be aware of the actual session management, pooling and handling.
 */
class SessionImpl implements Session {
  private final TraceWrapper tracer;

  /** Keep track of running transactions on this session per thread. */
  static final ThreadLocal<Boolean> hasPendingTransaction = ThreadLocal.withInitial(() -> false);

  static void throwIfTransactionsPending() {
    if (hasPendingTransaction.get() == Boolean.TRUE) {
      throw newSpannerException(ErrorCode.INTERNAL, "Nested transactions are not supported");
    }
  }

  static TransactionOptions createReadWriteTransactionOptions(
      Options options, ByteString previousTransactionId) {
    TransactionOptions.Builder transactionOptions = TransactionOptions.newBuilder();
    if (options.withExcludeTxnFromChangeStreams() == Boolean.TRUE) {
      transactionOptions.setExcludeTxnFromChangeStreams(true);
    }
    TransactionOptions.ReadWrite.Builder readWrite = TransactionOptions.ReadWrite.newBuilder();
    if (previousTransactionId != null
        && previousTransactionId != com.google.protobuf.ByteString.EMPTY) {
      readWrite.setMultiplexedSessionPreviousTransactionId(previousTransactionId);
    }
    if (options.isolationLevel() != null) {
      transactionOptions.setIsolationLevel(options.isolationLevel());
    }
    if (options.readLockMode() != null) {
      readWrite.setReadLockMode(options.readLockMode());
    }
    transactionOptions.setReadWrite(readWrite);
    return transactionOptions.build();
  }

  /**
   * Represents a transaction within a session. "Transaction" here is used in the general sense,
   * which covers standalone reads, standalone writes, single-use and multi-use read-only
   * transactions, and read-write transactions. The defining characteristic is that a session may
   * only have one such transaction active at a time.
   */
  interface SessionTransaction {

    /** Invalidates the transaction, generally because a new one has been started on the session. */
    void invalidate();

    /** Registers the current span on the transaction. */
    void setSpan(ISpan span);

    /** Closes the transaction. */
    void close();
  }

  private static final Map<SpannerRpc.Option, ?>[] CHANNEL_HINT_OPTIONS =
      new Map[SpannerOptions.MAX_CHANNELS];

  static {
    for (int i = 0; i < CHANNEL_HINT_OPTIONS.length; i++) {
      CHANNEL_HINT_OPTIONS[i] = optionMap(SessionOption.channelHint(i));
    }
  }

  static final int NO_CHANNEL_HINT = -1;

  private final SpannerImpl spanner;
  private SessionReference sessionReference;
  private SessionTransaction activeTransaction;
  private ISpan currentSpan;
  private final Clock clock;
  private final Map<SpannerRpc.Option, ?> options;
  private final ErrorHandler errorHandler;

  SessionImpl(SpannerImpl spanner, SessionReference sessionReference) {
    this(spanner, sessionReference, NO_CHANNEL_HINT);
  }

  SessionImpl(SpannerImpl spanner, SessionReference sessionReference, int channelHint) {
    this.spanner = spanner;
    this.tracer = spanner.getTracer();
    this.sessionReference = sessionReference;
    this.clock = spanner.getOptions().getSessionPoolOptions().getPoolMaintainerClock();
    this.options = createOptions(sessionReference, channelHint);
    this.errorHandler = createErrorHandler(spanner.getOptions());
  }

  static Map<SpannerRpc.Option, ?> createOptions(
      SessionReference sessionReference, int channelHint) {
    if (channelHint == NO_CHANNEL_HINT) {
      return sessionReference.getOptions();
    }
    return CHANNEL_HINT_OPTIONS[channelHint % CHANNEL_HINT_OPTIONS.length];
  }

  private ErrorHandler createErrorHandler(SpannerOptions options) {
    if (RetryOnDifferentGrpcChannelErrorHandler.isEnabled()) {
      return new RetryOnDifferentGrpcChannelErrorHandler(options.getNumChannels(), this);
    }
    return DefaultErrorHandler.INSTANCE;
  }

  @Override
  public String getName() {
    return sessionReference.getName();
  }

  @Override
  public String getDatabaseRole() {
    return sessionReference.getDatabaseRole();
  }

  /**
   * Updates the session reference with the fallback session. This should only be used for updating
   * session reference with regular session in case of unimplemented error in multiplexed session.
   */
  void setFallbackSessionReference(SessionReference sessionReference) {
    this.sessionReference = sessionReference;
  }

  Map<SpannerRpc.Option, ?> getOptions() {
    return options;
  }

  ErrorHandler getErrorHandler() {
    return this.errorHandler;
  }

  SpannerImpl getSpanner() {
    return spanner;
  }

  void setCurrentSpan(ISpan span) {
    currentSpan = span;
  }

  ISpan getCurrentSpan() {
    return currentSpan;
  }

  Instant getLastUseTime() {
    return sessionReference.getLastUseTime();
  }

  Instant getCreateTime() {
    return sessionReference.getCreateTime();
  }

  boolean getIsMultiplexed() {
    return sessionReference.getIsMultiplexed();
  }

  SessionReference getSessionReference() {
    return sessionReference;
  }

  void markUsed(Instant instant) {
    sessionReference.markUsed(instant);
  }

  TransactionOptions defaultTransactionOptions() {
    return this.spanner.getOptions().getDefaultTransactionOptions();
  }

  public DatabaseId getDatabaseId() {
    return sessionReference.getDatabaseId();
  }

  @Override
  public long executePartitionedUpdate(Statement stmt, UpdateOption... options) {
    setActive(null);
    PartitionedDmlTransaction txn =
        new PartitionedDmlTransaction(this, spanner.getRpc(), Ticker.systemTicker());
    return txn.executeStreamingPartitionedUpdate(
        stmt, spanner.getOptions().getPartitionedDmlTimeoutDuration(), options);
  }

  @Override
  public Timestamp write(Iterable<Mutation> mutations) throws SpannerException {
    return writeWithOptions(mutations).getCommitTimestamp();
  }

  @Override
  public CommitResponse writeWithOptions(Iterable<Mutation> mutations, TransactionOption... options)
      throws SpannerException {
    TransactionRunner runner = readWriteTransaction(options);
    final Collection<Mutation> finalMutations =
        mutations instanceof java.util.Collection<?>
            ? (Collection<Mutation>) mutations
            : Lists.newArrayList(mutations);
    runner.run(
        ctx -> {
          ctx.buffer(finalMutations);
          return null;
        });
    return runner.getCommitResponse();
  }

  @Override
  public Timestamp writeAtLeastOnce(Iterable<Mutation> mutations) throws SpannerException {
    return writeAtLeastOnceWithOptions(mutations).getCommitTimestamp();
  }

  @Override
  public CommitResponse writeAtLeastOnceWithOptions(
      Iterable<Mutation> mutations, TransactionOption... transactionOptions)
      throws SpannerException {
    setActive(null);
    List<com.google.spanner.v1.Mutation> mutationsProto = new ArrayList<>();
    Mutation.toProtoAndReturnRandomMutation(mutations, mutationsProto);
    Options options = Options.fromTransactionOptions(transactionOptions);
    final CommitRequest.Builder requestBuilder =
        CommitRequest.newBuilder()
            .setSession(getName())
            .setReturnCommitStats(options.withCommitStats())
            .addAllMutations(mutationsProto);

    TransactionOptions.Builder transactionOptionsBuilder =
        TransactionOptions.newBuilder()
            .setReadWrite(TransactionOptions.ReadWrite.getDefaultInstance());
    if (options.withExcludeTxnFromChangeStreams() == Boolean.TRUE) {
      transactionOptionsBuilder.setExcludeTxnFromChangeStreams(true);
    }
    if (options.isolationLevel() != null) {
      transactionOptionsBuilder.setIsolationLevel(options.isolationLevel());
    }
    if (options.readLockMode() != null) {
      transactionOptionsBuilder.getReadWriteBuilder().setReadLockMode(options.readLockMode());
    }
    requestBuilder.setSingleUseTransaction(
        defaultTransactionOptions().toBuilder().mergeFrom(transactionOptionsBuilder.build()));

    if (options.hasMaxCommitDelay()) {
      requestBuilder.setMaxCommitDelay(
          Duration.newBuilder()
              .setSeconds(options.maxCommitDelay().getSeconds())
              .setNanos(options.maxCommitDelay().getNano())
              .build());
    }
    RequestOptions commitRequestOptions = getRequestOptions(transactionOptions);

    if (commitRequestOptions != null) {
      requestBuilder.setRequestOptions(commitRequestOptions);
    }
    CommitRequest request = requestBuilder.build();
    ISpan span = tracer.spanBuilder(SpannerImpl.COMMIT);

    try (IScope s = tracer.withSpan(span)) {
      return SpannerRetryHelper.runTxWithRetriesOnAborted(
          () -> new CommitResponse(spanner.getRpc().commit(request, getOptions())));
    } catch (RuntimeException e) {
      span.setStatus(e);
      throw e;
    } finally {
      span.end();
    }
  }

  private RequestOptions getRequestOptions(TransactionOption... transactionOptions) {
    Options requestOptions = Options.fromTransactionOptions(transactionOptions);
    if (requestOptions.hasPriority() || requestOptions.hasTag()) {
      RequestOptions.Builder requestOptionsBuilder = RequestOptions.newBuilder();
      if (requestOptions.hasPriority()) {
        requestOptionsBuilder.setPriority(requestOptions.priority());
      }
      if (requestOptions.hasTag()) {
        requestOptionsBuilder.setTransactionTag(requestOptions.tag());
      }
      return requestOptionsBuilder.build();
    }
    return null;
  }

  @Override
  public ServerStream<BatchWriteResponse> batchWriteAtLeastOnce(
      Iterable<MutationGroup> mutationGroups, TransactionOption... transactionOptions)
      throws SpannerException {
    setActive(null);
    List<BatchWriteRequest.MutationGroup> mutationGroupsProto =
        MutationGroup.toListProto(mutationGroups);
    final BatchWriteRequest.Builder requestBuilder =
        BatchWriteRequest.newBuilder()
            .setSession(getName())
            .addAllMutationGroups(mutationGroupsProto);
    RequestOptions batchWriteRequestOptions = getRequestOptions(transactionOptions);
    Options allOptions = Options.fromTransactionOptions(transactionOptions);
    if (batchWriteRequestOptions != null) {
      requestBuilder.setRequestOptions(batchWriteRequestOptions);
    }
    if (allOptions.withExcludeTxnFromChangeStreams() == Boolean.TRUE) {
      requestBuilder.setExcludeTxnFromChangeStreams(true);
    }
    ISpan span = tracer.spanBuilder(SpannerImpl.BATCH_WRITE);
    try (IScope s = tracer.withSpan(span)) {
      return spanner.getRpc().batchWriteAtLeastOnce(requestBuilder.build(), getOptions());
    } catch (Throwable e) {
      span.setStatus(e);
      throw SpannerExceptionFactory.newSpannerException(e);
    } finally {
      span.end();
      onTransactionDone();
    }
  }

  @Override
  public ReadContext singleUse() {
    return singleUse(TimestampBound.strong());
  }

  @Override
  public ReadContext singleUse(TimestampBound bound) {
    return setActive(
        SingleReadContext.newBuilder()
            .setSession(this)
            .setTimestampBound(bound)
            .setRpc(spanner.getRpc())
            .setDefaultQueryOptions(spanner.getDefaultQueryOptions(getDatabaseId()))
            .setDefaultPrefetchChunks(spanner.getDefaultPrefetchChunks())
            .setDefaultDecodeMode(spanner.getDefaultDecodeMode())
            .setDefaultDirectedReadOptions(spanner.getOptions().getDirectedReadOptions())
            .setSpan(currentSpan)
            .setTracer(tracer)
            .setExecutorProvider(spanner.getAsyncExecutorProvider())
            .setClock(clock)
            .build());
  }

  @Override
  public ReadOnlyTransaction singleUseReadOnlyTransaction() {
    return singleUseReadOnlyTransaction(TimestampBound.strong());
  }

  @Override
  public ReadOnlyTransaction singleUseReadOnlyTransaction(TimestampBound bound) {
    return setActive(
        SingleUseReadOnlyTransaction.newBuilder()
            .setSession(this)
            .setTimestampBound(bound)
            .setRpc(spanner.getRpc())
            .setDefaultQueryOptions(spanner.getDefaultQueryOptions(getDatabaseId()))
            .setDefaultPrefetchChunks(spanner.getDefaultPrefetchChunks())
            .setDefaultDecodeMode(spanner.getDefaultDecodeMode())
            .setDefaultDirectedReadOptions(spanner.getOptions().getDirectedReadOptions())
            .setSpan(currentSpan)
            .setTracer(tracer)
            .setExecutorProvider(spanner.getAsyncExecutorProvider())
            .setClock(clock)
            .buildSingleUseReadOnlyTransaction());
  }

  @Override
  public ReadOnlyTransaction readOnlyTransaction() {
    return readOnlyTransaction(TimestampBound.strong());
  }

  @Override
  public ReadOnlyTransaction readOnlyTransaction(TimestampBound bound) {
    return setActive(
        MultiUseReadOnlyTransaction.newBuilder()
            .setSession(this)
            .setTimestampBound(bound)
            .setRpc(spanner.getRpc())
            .setDefaultQueryOptions(spanner.getDefaultQueryOptions(getDatabaseId()))
            .setDefaultPrefetchChunks(spanner.getDefaultPrefetchChunks())
            .setDefaultDecodeMode(spanner.getDefaultDecodeMode())
            .setDefaultDirectedReadOptions(spanner.getOptions().getDirectedReadOptions())
            .setSpan(currentSpan)
            .setTracer(tracer)
            .setExecutorProvider(spanner.getAsyncExecutorProvider())
            .setClock(clock)
            .build());
  }

  @Override
  public TransactionRunner readWriteTransaction(TransactionOption... options) {
    return setActive(new TransactionRunnerImpl(this, options));
  }

  @Override
  public AsyncRunner runAsync(TransactionOption... options) {
    return new AsyncRunnerImpl(setActive(new TransactionRunnerImpl(this, options)));
  }

  @Override
  public TransactionManager transactionManager(TransactionOption... options) {
    return new TransactionManagerImpl(this, currentSpan, tracer, options);
  }

  @Override
  public AsyncTransactionManagerImpl transactionManagerAsync(TransactionOption... options) {
    return new AsyncTransactionManagerImpl(this, currentSpan, options);
  }

  @Override
  public ApiFuture<Empty> asyncClose() {
    if (getIsMultiplexed()) {
      return com.google.api.core.ApiFutures.immediateFuture(Empty.getDefaultInstance());
    }
    return spanner.getRpc().asyncDeleteSession(getName(), getOptions());
  }

  @Override
  public void close() {
    if (getIsMultiplexed()) {
      return;
    }
    ISpan span = tracer.spanBuilder(SpannerImpl.DELETE_SESSION);
    try (IScope s = tracer.withSpan(span)) {
      spanner.getRpc().deleteSession(getName(), getOptions());
    } catch (RuntimeException e) {
      span.setStatus(e);
      throw e;
    } finally {
      span.end();
    }
  }

  ApiFuture<Transaction> beginTransactionAsync(
      Options transactionOptions,
      boolean routeToLeader,
      Map<SpannerRpc.Option, ?> channelHint,
      ByteString previousTransactionId,
      com.google.spanner.v1.Mutation mutation) {
    final SettableApiFuture<Transaction> res = SettableApiFuture.create();
    final ISpan span = tracer.spanBuilder(SpannerImpl.BEGIN_TRANSACTION);
    BeginTransactionRequest.Builder requestBuilder =
        BeginTransactionRequest.newBuilder()
            .setSession(getName())
            .setOptions(
                defaultTransactionOptions().toBuilder()
                    .mergeFrom(
                        createReadWriteTransactionOptions(
                            transactionOptions, previousTransactionId)));
    if (sessionReference.getIsMultiplexed() && mutation != null) {
      requestBuilder.setMutationKey(mutation);
    }
    RequestOptions.Builder optionsBuilder =
        transactionOptions.toRequestOptionsProto(true).toBuilder();
    RequestOptions.ClientContext defaultClientContext = spanner.getOptions().getClientContext();
    if (defaultClientContext != null) {
      RequestOptions.ClientContext.Builder builder = defaultClientContext.toBuilder();
      if (optionsBuilder.hasClientContext()) {
        builder.mergeFrom(optionsBuilder.getClientContext());
      }
      optionsBuilder.setClientContext(builder.build());
    }
    if (!sessionReference.getIsMultiplexed()) {
      optionsBuilder.clearTransactionTag();
    }
    RequestOptions requestOptions = optionsBuilder.build();
    if (!requestOptions.equals(RequestOptions.getDefaultInstance())) {
      requestBuilder.setRequestOptions(requestOptions);
    }
    final BeginTransactionRequest request = requestBuilder.build();
    final ApiFuture<Transaction> requestFuture;
    try (IScope ignore = tracer.withSpan(span)) {
      requestFuture = spanner.getRpc().beginTransactionAsync(request, channelHint, routeToLeader);
    }
    requestFuture.addListener(
        () -> {
          try (IScope ignore = tracer.withSpan(span)) {
            Transaction txn = requestFuture.get();
            if (txn.getId().isEmpty()) {
              throw newSpannerException(
                  ErrorCode.INTERNAL, "Missing id in transaction\n" + getName());
            }
            span.end();
            res.set(txn);
          } catch (ExecutionException e) {
            span.setStatus(e);
            span.end();
            res.setException(
                SpannerExceptionFactory.newSpannerException(
                    e.getCause() == null ? e : e.getCause()));
          } catch (InterruptedException e) {
            span.setStatus(e);
            span.end();
            res.setException(SpannerExceptionFactory.propagateInterrupt(e));
          } catch (Exception e) {
            span.setStatus(e);
            span.end();
            res.setException(e);
          }
        },
        MoreExecutors.directExecutor());
    return res;
  }

  TransactionContextImpl newTransaction(Options options, ByteString previousTransactionId) {
    return TransactionContextImpl.newBuilder()
        .setSession(this)
        .setOptions(options)
        .setTransactionId(null)
        .setPreviousTransactionId(previousTransactionId)
        .setTrackTransactionStarter(spanner.getOptions().isTrackTransactionStarter())
        .setRpc(spanner.getRpc())
        .setDefaultQueryOptions(spanner.getDefaultQueryOptions(getDatabaseId()))
        .setDefaultPrefetchChunks(spanner.getDefaultPrefetchChunks())
        .setDefaultDecodeMode(spanner.getDefaultDecodeMode())
        .setSpan(currentSpan)
        .setTracer(tracer)
        .setExecutorProvider(spanner.getAsyncExecutorProvider())
        .setClock(clock)
        .build();
  }

  SessionTransaction getActiveTransaction() {
    return this.activeTransaction;
  }

  <T extends SessionTransaction> T setActive(@Nullable T ctx) {
    throwIfTransactionsPending();
    // multiplexed sessions support running concurrent transactions
    if (!getIsMultiplexed()) {
      if (activeTransaction != null) {
        activeTransaction.invalidate();
      }
    }
    activeTransaction = ctx;
    if (activeTransaction != null) {
      activeTransaction.setSpan(currentSpan);
    }
    return ctx;
  }

  void onError(SpannerException spannerException) {}

  void onReadDone() {}

  void onTransactionDone() {}

  TraceWrapper getTracer() {
    return tracer;
  }

  public XGoogSpannerRequestId.RequestIdCreator getRequestIdCreator() {
    return this.spanner.getRpc().getRequestIdCreator();
  }

  int getChannel() {
    if (getIsMultiplexed()) {
      return 0;
    }
    Map<SpannerRpc.Option, ?> options = this.getOptions();
    if (options == null) {
      return 0;
    }
    Long channelHint = (Long) options.get(SpannerRpc.Option.CHANNEL_HINT);
    if (channelHint == null) {
      return 0;
    }
    return (int) (channelHint % this.spanner.getOptions().getNumChannels());
  }
}
