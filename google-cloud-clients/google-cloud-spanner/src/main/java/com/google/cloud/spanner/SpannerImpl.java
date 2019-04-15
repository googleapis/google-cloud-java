/*
 * Copyright 2017 Google LLC
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
import static com.google.cloud.spanner.SpannerExceptionFactory.newSpannerExceptionForCancellation;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.util.BackOff;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.gax.paging.Page;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.BaseService;
import com.google.cloud.PageImpl;
import com.google.cloud.PageImpl.NextPageFetcher;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AbstractReadContext.MultiUseReadOnlyTransaction;
import com.google.cloud.spanner.AbstractReadContext.SingleReadContext;
import com.google.cloud.spanner.AbstractReadContext.SingleUseReadOnlyTransaction;
import com.google.cloud.spanner.TransactionRunnerImpl.TransactionContextImpl;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.cloud.spanner.spi.v1.SpannerRpc.Paginated;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CommitResponse;
import com.google.spanner.v1.Transaction;
import com.google.spanner.v1.TransactionOptions;
import io.grpc.Context;
import io.opencensus.common.Scope;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.Span;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.Tracing;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/** Default implementation of the Cloud Spanner interface. */
class SpannerImpl extends BaseService<SpannerOptions> implements Spanner {
  private static final int MIN_BACKOFF_MS = 1000;
  private static final int MAX_BACKOFF_MS = 32000;
  private static final PathTemplate OP_NAME_TEMPLATE =
      PathTemplate.create(
          "projects/{project}/instances/{instance}/databases/{database}/operations/{operation}");
  private static final PathTemplate PROJECT_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}");

  private static final Logger logger = Logger.getLogger(SpannerImpl.class.getName());
  private static final Tracer tracer = Tracing.getTracer();

  private static final String CREATE_SESSION = "CloudSpannerOperation.CreateSession";
  private static final String DELETE_SESSION = "CloudSpannerOperation.DeleteSession";
  private static final String BEGIN_TRANSACTION = "CloudSpannerOperation.BeginTransaction";
  static final String COMMIT = "CloudSpannerOperation.Commit";
  static final String QUERY = "CloudSpannerOperation.ExecuteStreamingQuery";
  static final String READ = "CloudSpannerOperation.ExecuteStreamingRead";

  static final ThreadLocal<Boolean> hasPendingTransaction =
      new ThreadLocal<Boolean>() {
        @Override
        protected Boolean initialValue() {
          return false;
        }
      };

  static void throwIfTransactionsPending() {
    if (hasPendingTransaction.get() == Boolean.TRUE) {
      throw newSpannerException(ErrorCode.INTERNAL, "Nested transactions are not supported");
    }
  }

  static {
    TraceUtil.exportSpans(CREATE_SESSION, DELETE_SESSION, BEGIN_TRANSACTION, COMMIT, QUERY, READ);
  }

  private final Random random = new Random();
  private final SpannerRpc gapicRpc;
  private final int defaultPrefetchChunks;

  @GuardedBy("this")
  private final Map<DatabaseId, DatabaseClientImpl> dbClients = new HashMap<>();

  private final DatabaseAdminClient dbAdminClient;
  private final InstanceAdminClient instanceClient;

  @GuardedBy("this")
  private boolean spannerIsClosed = false;

  SpannerImpl(SpannerRpc gapicRpc, int defaultPrefetchChunks, SpannerOptions options) {
    super(options);
    this.gapicRpc = gapicRpc;
    this.defaultPrefetchChunks = defaultPrefetchChunks;
    this.dbAdminClient = new DatabaseAdminClientImpl(options.getProjectId(), gapicRpc);
    this.instanceClient =
        new InstanceAdminClientImpl(options.getProjectId(), gapicRpc, dbAdminClient);
  }

  SpannerImpl(SpannerOptions options) {
    this(options.getSpannerRpcV1(), options.getPrefetchChunks(), options);
  }

  static ExponentialBackOff newBackOff() {
    return new ExponentialBackOff.Builder()
        .setInitialIntervalMillis(MIN_BACKOFF_MS)
        .setMaxIntervalMillis(MAX_BACKOFF_MS)
        .setMaxElapsedTimeMillis(Integer.MAX_VALUE) // Prevent Backoff.STOP from getting returned.
        .build();
  }

  static void backoffSleep(Context context, BackOff backoff) throws SpannerException {
    backoffSleep(context, nextBackOffMillis(backoff));
  }

  static long nextBackOffMillis(BackOff backoff) throws SpannerException {
    try {
      return backoff.nextBackOffMillis();
    } catch (IOException e) {
      throw newSpannerException(ErrorCode.INTERNAL, e.getMessage(), e);
    }
  }

  static void backoffSleep(Context context, long backoffMillis) throws SpannerException {
    tracer
        .getCurrentSpan()
        .addAnnotation(
            "Backing off",
            ImmutableMap.of("Delay", AttributeValue.longAttributeValue(backoffMillis)));
    final CountDownLatch latch = new CountDownLatch(1);
    final Context.CancellationListener listener =
        new Context.CancellationListener() {
          @Override
          public void cancelled(Context context) {
            // Wakeup on cancellation / DEADLINE_EXCEEDED.
            latch.countDown();
          }
        };

    context.addListener(listener, DirectExecutor.INSTANCE);
    try {
      if (backoffMillis == BackOff.STOP) {
        // Highly unlikely but we handle it just in case.
        backoffMillis = MAX_BACKOFF_MS;
      }
      if (latch.await(backoffMillis, TimeUnit.MILLISECONDS)) {
        // Woken by context cancellation.
        throw newSpannerExceptionForCancellation(context, null);
      }
    } catch (InterruptedException interruptExcept) {
      throw newSpannerExceptionForCancellation(context, interruptExcept);
    } finally {
      context.removeListener(listener);
    }
  }

  /**
   * Helper to execute some work, retrying with backoff on retryable errors.
   *
   * <p>TODO: Consider replacing with RetryHelper from gcloud-core.
   */
  static <T> T runWithRetries(Callable<T> callable) {
    // Use same backoff setting as abort, somewhat arbitrarily.
    Span span = tracer.getCurrentSpan();
    ExponentialBackOff backOff = newBackOff();
    Context context = Context.current();
    int attempt = 0;
    while (true) {
      attempt++;
      try {
        span.addAnnotation(
            "Starting operation",
            ImmutableMap.of("Attempt", AttributeValue.longAttributeValue(attempt)));
        T result = callable.call();
        return result;
      } catch (SpannerException e) {
        if (!e.isRetryable()) {
          throw e;
        }
        logger.log(Level.FINE, "Retryable exception, will sleep and retry", e);
        long delay = e.getRetryDelayInMillis();
        if (delay != -1) {
          backoffSleep(context, delay);
        } else {
          backoffSleep(context, backOff);
        }
      } catch (Exception e) {
        Throwables.throwIfUnchecked(e);
        throw newSpannerException(ErrorCode.INTERNAL, "Unexpected exception thrown", e);
      }
    }
  }

  // TODO(user): change this to return SessionImpl and modify all corresponding references.
  Session createSession(final DatabaseId db) throws SpannerException {
    final Map<SpannerRpc.Option, ?> options =
        optionMap(SessionOption.channelHint(random.nextLong()));
    Span span = tracer.spanBuilder(CREATE_SESSION).startSpan();
    try (Scope s = tracer.withSpan(span)) {
      com.google.spanner.v1.Session session =
          runWithRetries(
              new Callable<com.google.spanner.v1.Session>() {
                @Override
                public com.google.spanner.v1.Session call() throws Exception {
                  return gapicRpc.createSession(
                      db.getName(), getOptions().getSessionLabels(), options);
                }
              });
      span.end();
      return new SessionImpl(session.getName(), options);
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    }
  }

  SessionImpl sessionWithId(String name) {
    final Map<SpannerRpc.Option, ?> options =
        SpannerImpl.optionMap(SessionOption.channelHint(random.nextLong()));
    return new SessionImpl(name, options);
  }

  @Override
  public DatabaseAdminClient getDatabaseAdminClient() {
    return dbAdminClient;
  }

  @Override
  public InstanceAdminClient getInstanceAdminClient() {
    return instanceClient;
  }

  @Override
  public DatabaseClient getDatabaseClient(DatabaseId db) {
    synchronized (this) {
      Preconditions.checkState(!spannerIsClosed, "Cloud Spanner client has been closed");
      if (dbClients.containsKey(db)) {
        return dbClients.get(db);
      } else {
        SessionPool pool = SessionPool.createPool(getOptions(), db, SpannerImpl.this);
        DatabaseClientImpl dbClient = new DatabaseClientImpl(pool);
        dbClients.put(db, dbClient);
        return dbClient;
      }
    }
  }

  @Override
  public BatchClient getBatchClient(DatabaseId db) {
    return new BatchClientImpl(db, SpannerImpl.this);
  }

  @Override
  public void close() {
    List<ListenableFuture<Void>> closureFutures = null;
    synchronized (this) {
      Preconditions.checkState(!spannerIsClosed, "Cloud Spanner client has been closed");
      spannerIsClosed = true;
      closureFutures = new ArrayList<>();
      for (DatabaseClientImpl dbClient : dbClients.values()) {
        closureFutures.add(dbClient.closeAsync());
      }
      dbClients.clear();
    }
    try {
      Futures.successfulAsList(closureFutures).get();
    } catch (InterruptedException | ExecutionException e) {
      throw SpannerExceptionFactory.newSpannerException(e);
    }
    try {
      gapicRpc.shutdown();
    } catch (RuntimeException e) {
      logger.log(Level.WARNING, "Failed to close channels", e);
    }
  }

  /**
   * Checks that the current context is still valid, throwing a CANCELLED or DEADLINE_EXCEEDED error
   * if not.
   */
  static void checkContext(Context context) {
    if (context.isCancelled()) {
      throw newSpannerExceptionForCancellation(context, null);
    }
  }

  /**
   * Encapsulates state to be passed to the {@link SpannerRpc} layer for a given session. Currently
   * used to select the {@link io.grpc.Channel} to be used in issuing the RPCs in a Session.
   */
  static class SessionOption {
    private final SpannerRpc.Option rpcOption;
    private final Object value;

    SessionOption(SpannerRpc.Option option, Object value) {
      this.rpcOption = checkNotNull(option);
      this.value = value;
    }

    static SessionOption channelHint(long hint) {
      return new SessionOption(SpannerRpc.Option.CHANNEL_HINT, hint);
    }

    SpannerRpc.Option rpcOption() {
      return rpcOption;
    }

    Object value() {
      return value;
    }
  }

  static Map<SpannerRpc.Option, ?> optionMap(SessionOption... options) {
    if (options.length == 0) {
      return Collections.emptyMap();
    }
    Map<SpannerRpc.Option, Object> tmp = Maps.newEnumMap(SpannerRpc.Option.class);
    for (SessionOption option : options) {
      Object prev = tmp.put(option.rpcOption(), option.value());
      checkArgument(prev == null, "Duplicate option %s", option.rpcOption());
    }
    return ImmutableMap.copyOf(tmp);
  }

  private static <T extends Message> T unpack(Any response, Class<T> clazz)
      throws SpannerException {
    try {
      return response.unpack(clazz);
    } catch (InvalidProtocolBufferException e) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INTERNAL, "Error unpacking response", e);
    }
  }

  abstract static class PageFetcher<S, T> implements NextPageFetcher<S> {
    private String nextPageToken;

    @Override
    public Page<S> getNextPage() {
      Paginated<T> nextPage =
          runWithRetries(
              new Callable<Paginated<T>>() {
                @Override
                public Paginated<T> call() {
                  return getNextPage(nextPageToken);
                }
              });
      this.nextPageToken = nextPage.getNextPageToken();
      List<S> results = new ArrayList<>();
      for (T proto : nextPage.getResults()) {
        results.add(fromProto(proto));
      }
      return new PageImpl<S>(this, nextPageToken, results);
    }

    void setNextPageToken(String nextPageToken) {
      this.nextPageToken = nextPageToken;
    }

    abstract Paginated<T> getNextPage(@Nullable String nextPageToken);

    abstract S fromProto(T proto);
  }

  class SessionImpl implements Session {
    private final String name;
    private SessionTransaction activeTransaction;
    private ByteString readyTransactionId;
    private final Map<SpannerRpc.Option, ?> options;

    SessionImpl(String name, Map<SpannerRpc.Option, ?> options) {
      this.options = options;
      this.name = checkNotNull(name);
    }

    @Override
    public String getName() {
      return name;
    }

    Map<SpannerRpc.Option, ?> getOptions() {
      return options;
    }

    @Override
    public long executePartitionedUpdate(Statement stmt) {
      setActive(null);
      PartitionedDMLTransaction txn = new PartitionedDMLTransaction(this, gapicRpc);
      return txn.executePartitionedUpdate(stmt);
    }

    @Override
    public Timestamp write(Iterable<Mutation> mutations) throws SpannerException {
      TransactionRunner runner = readWriteTransaction();
      final Collection<Mutation> finalMutations =
          mutations instanceof java.util.Collection<?>
              ? (Collection<Mutation>) mutations
              : Lists.newArrayList(mutations);
      runner.run(
          new TransactionRunner.TransactionCallable<Void>() {
            @Override
            public Void run(TransactionContext ctx) {
              ctx.buffer(finalMutations);
              return null;
            }
          });
      return runner.getCommitTimestamp();
    }

    @Override
    public Timestamp writeAtLeastOnce(Iterable<Mutation> mutations) throws SpannerException {
      setActive(null);
      List<com.google.spanner.v1.Mutation> mutationsProto = new ArrayList<>();
      Mutation.toProto(mutations, mutationsProto);
      final CommitRequest request =
          CommitRequest.newBuilder()
              .setSession(name)
              .addAllMutations(mutationsProto)
              .setSingleUseTransaction(
                  TransactionOptions.newBuilder()
                      .setReadWrite(TransactionOptions.ReadWrite.getDefaultInstance()))
              .build();
      Span span = tracer.spanBuilder(COMMIT).startSpan();
      try (Scope s = tracer.withSpan(span)) {
        CommitResponse response =
            runWithRetries(
                new Callable<CommitResponse>() {
                  @Override
                  public CommitResponse call() throws Exception {
                    return gapicRpc.commit(request, options);
                  }
                });
        Timestamp t = Timestamp.fromProto(response.getCommitTimestamp());
        span.end();
        return t;
      } catch (IllegalArgumentException e) {
        TraceUtil.endSpanWithFailure(span, e);
        throw newSpannerException(ErrorCode.INTERNAL, "Could not parse commit timestamp", e);
      } catch (RuntimeException e) {
        TraceUtil.endSpanWithFailure(span, e);
        throw e;
      }
    }

    @Override
    public ReadContext singleUse() {
      return singleUse(TimestampBound.strong());
    }

    @Override
    public ReadContext singleUse(TimestampBound bound) {
      return setActive(new SingleReadContext(this, bound, gapicRpc, defaultPrefetchChunks));
    }

    @Override
    public ReadOnlyTransaction singleUseReadOnlyTransaction() {
      return singleUseReadOnlyTransaction(TimestampBound.strong());
    }

    @Override
    public ReadOnlyTransaction singleUseReadOnlyTransaction(TimestampBound bound) {
      return setActive(
          new SingleUseReadOnlyTransaction(this, bound, gapicRpc, defaultPrefetchChunks));
    }

    @Override
    public ReadOnlyTransaction readOnlyTransaction() {
      return readOnlyTransaction(TimestampBound.strong());
    }

    @Override
    public ReadOnlyTransaction readOnlyTransaction(TimestampBound bound) {
      return setActive(
          new MultiUseReadOnlyTransaction(this, bound, gapicRpc, defaultPrefetchChunks));
    }

    @Override
    public TransactionRunner readWriteTransaction() {
      return setActive(new TransactionRunnerImpl(this, gapicRpc, defaultPrefetchChunks));
    }

    @Override
    public void prepareReadWriteTransaction() {
      setActive(null);
      readyTransactionId = beginTransaction();
    }

    @Override
    public void close() {
      Span span = tracer.spanBuilder(DELETE_SESSION).startSpan();
      try (Scope s = tracer.withSpan(span)) {
        runWithRetries(
            new Callable<Void>() {
              @Override
              public Void call() throws Exception {
                gapicRpc.deleteSession(name, options);
                return null;
              }
            });
        span.end();
      } catch (RuntimeException e) {
        TraceUtil.endSpanWithFailure(span, e);
        throw e;
      }
    }

    ByteString beginTransaction() {
      Span span = tracer.spanBuilder(BEGIN_TRANSACTION).startSpan();
      try (Scope s = tracer.withSpan(span)) {
        final BeginTransactionRequest request =
            BeginTransactionRequest.newBuilder()
                .setSession(name)
                .setOptions(
                    TransactionOptions.newBuilder()
                        .setReadWrite(TransactionOptions.ReadWrite.getDefaultInstance()))
                .build();
        Transaction txn =
            runWithRetries(
                new Callable<Transaction>() {
                  @Override
                  public Transaction call() throws Exception {
                    return gapicRpc.beginTransaction(request, options);
                  }
                });
        if (txn.getId().isEmpty()) {
          throw newSpannerException(ErrorCode.INTERNAL, "Missing id in transaction\n" + getName());
        }
        span.end();
        return txn.getId();
      } catch (RuntimeException e) {
        TraceUtil.endSpanWithFailure(span, e);
        throw e;
      }
    }

    TransactionContextImpl newTransaction() {
      TransactionContextImpl txn =
          new TransactionContextImpl(this, readyTransactionId, gapicRpc, defaultPrefetchChunks);
      return txn;
    }

    <T extends SessionTransaction> T setActive(@Nullable T ctx) {
      throwIfTransactionsPending();

      if (activeTransaction != null) {
        activeTransaction.invalidate();
      }
      activeTransaction = ctx;
      readyTransactionId = null;
      return ctx;
    }

    @Override
    public TransactionManager transactionManager() {
      return new TransactionManagerImpl(this);
    }
  }

  /**
   * Represents a transaction within a session. "Transaction" here is used in the general sense,
   * which covers standalone reads, standalone writes, single-use and multi-use read-only
   * transactions, and read-write transactions. The defining characteristic is that a session may
   * only have one such transaction active at a time.
   */
  static interface SessionTransaction {
    /** Invalidates the transaction, generally because a new one has been started on the session. */
    void invalidate();
  }

  private enum DirectExecutor implements Executor {
    INSTANCE;

    @Override
    public void execute(Runnable command) {
      command.run();
    }
  }
}
