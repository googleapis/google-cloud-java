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

import static com.google.cloud.spanner.SpannerExceptionFactory.newSpannerBatchUpdateException;
import static com.google.cloud.spanner.SpannerExceptionFactory.newSpannerException;
import static com.google.cloud.spanner.SpannerExceptionFactory.newSpannerExceptionForCancellation;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import com.google.api.client.util.BackOff;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.core.ApiFunction;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.longrunning.OperationFutureImpl;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.paging.Page;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.BaseService;
import com.google.cloud.PageImpl;
import com.google.cloud.PageImpl.NextPageFetcher;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AbstractReadContext.MultiUseReadOnlyTransaction;
import com.google.cloud.spanner.AbstractReadContext.SingleReadContext;
import com.google.cloud.spanner.AbstractReadContext.SingleUseReadOnlyTransaction;
import com.google.cloud.spanner.Options.ListOption;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.cloud.spanner.spi.v1.SpannerRpc.Paginated;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.FieldMask;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.spanner.admin.instance.v1.CreateInstanceMetadata;
import com.google.spanner.admin.instance.v1.UpdateInstanceMetadata;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CommitResponse;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ExecuteSqlRequest.QueryMode;
import com.google.spanner.v1.RollbackRequest;
import com.google.spanner.v1.Transaction;
import com.google.spanner.v1.TransactionOptions;
import com.google.spanner.v1.TransactionSelector;
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
  private static final Logger txnLogger = Logger.getLogger(TransactionRunner.class.getName());
  private static final Tracer tracer = Tracing.getTracer();

  private static final String CREATE_SESSION = "CloudSpannerOperation.CreateSession";
  private static final String DELETE_SESSION = "CloudSpannerOperation.DeleteSession";
  private static final String BEGIN_TRANSACTION = "CloudSpannerOperation.BeginTransaction";
  private static final String COMMIT = "CloudSpannerOperation.Commit";
  static final String QUERY = "CloudSpannerOperation.ExecuteStreamingQuery";
  static final String READ = "CloudSpannerOperation.ExecuteStreamingRead";

  private static final ThreadLocal<Boolean> hasPendingTransaction =
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

  private static long nextBackOffMillis(BackOff backoff) throws SpannerException {
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
  private static void checkContext(Context context) {
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

  static class InstanceAdminClientImpl implements InstanceAdminClient {
    final DatabaseAdminClient dbClient;
    final String projectId;
    final SpannerRpc rpc;

    InstanceAdminClientImpl(String projectId, SpannerRpc rpc, DatabaseAdminClient dbClient) {
      this.projectId = projectId;
      this.rpc = rpc;
      this.dbClient = dbClient;
    }

    @Override
    public InstanceConfig getInstanceConfig(String configId) throws SpannerException {
      final String instanceConfigName = new InstanceConfigId(projectId, configId).getName();
      return runWithRetries(
          new Callable<InstanceConfig>() {
            @Override
            public InstanceConfig call() {
              return InstanceConfig.fromProto(
                  rpc.getInstanceConfig(instanceConfigName), InstanceAdminClientImpl.this);
            }
          });
    }

    @Override
    public Page<InstanceConfig> listInstanceConfigs(ListOption... options) {
      final Options listOptions = Options.fromListOptions(options);
      Preconditions.checkArgument(
          !listOptions.hasFilter(), "Filter option is not supported by listInstanceConfigs");
      final int pageSize = listOptions.hasPageSize() ? listOptions.pageSize() : 0;
      PageFetcher<InstanceConfig, com.google.spanner.admin.instance.v1.InstanceConfig> pageFetcher =
          new PageFetcher<InstanceConfig, com.google.spanner.admin.instance.v1.InstanceConfig>() {
            @Override
            public Paginated<com.google.spanner.admin.instance.v1.InstanceConfig> getNextPage(
                String nextPageToken) {
              return rpc.listInstanceConfigs(pageSize, nextPageToken);
            }

            @Override
            public InstanceConfig fromProto(
                com.google.spanner.admin.instance.v1.InstanceConfig proto) {
              return InstanceConfig.fromProto(proto, InstanceAdminClientImpl.this);
            }
          };
      if (listOptions.hasPageToken()) {
        pageFetcher.nextPageToken = listOptions.pageToken();
      }
      return pageFetcher.getNextPage();
    }

    @Override
    public OperationFuture<Instance, CreateInstanceMetadata> createInstance(InstanceInfo instance)
        throws SpannerException {
      String projectName = PROJECT_NAME_TEMPLATE.instantiate("project", projectId);
      OperationFuture<com.google.spanner.admin.instance.v1.Instance, CreateInstanceMetadata>
          rawOperationFuture =
              rpc.createInstance(projectName, instance.getId().getInstance(), instance.toProto());

      return new OperationFutureImpl<Instance, CreateInstanceMetadata>(
          rawOperationFuture.getPollingFuture(),
          rawOperationFuture.getInitialFuture(),
          new ApiFunction<OperationSnapshot, Instance>() {
            @Override
            public Instance apply(OperationSnapshot snapshot) {
              return Instance.fromProto(
                  ProtoOperationTransformers.ResponseTransformer.create(
                          com.google.spanner.admin.instance.v1.Instance.class)
                      .apply(snapshot),
                  InstanceAdminClientImpl.this,
                  dbClient);
            }
          },
          ProtoOperationTransformers.MetadataTransformer.create(CreateInstanceMetadata.class),
          new ApiFunction<Exception, Instance>() {
            @Override
            public Instance apply(Exception e) {
              throw SpannerExceptionFactory.newSpannerException(e);
            }
          });
    }

    @Override
    public Instance getInstance(String instanceId) throws SpannerException {
      final String instanceName = new InstanceId(projectId, instanceId).getName();
      return runWithRetries(
          new Callable<Instance>() {
            @Override
            public Instance call() {
              return Instance.fromProto(
                  rpc.getInstance(instanceName), InstanceAdminClientImpl.this, dbClient);
            }
          });
    }

    @Override
    public Page<Instance> listInstances(ListOption... options) throws SpannerException {
      final Options listOptions = Options.fromListOptions(options);
      final int pageSize = listOptions.hasPageSize() ? listOptions.pageSize() : 0;
      final String filter = listOptions.filter();
      PageFetcher<Instance, com.google.spanner.admin.instance.v1.Instance> pageFetcher =
          new PageFetcher<Instance, com.google.spanner.admin.instance.v1.Instance>() {
            @Override
            public Paginated<com.google.spanner.admin.instance.v1.Instance> getNextPage(
                String nextPageToken) {
              return rpc.listInstances(pageSize, nextPageToken, filter);
            }

            @Override
            public Instance fromProto(com.google.spanner.admin.instance.v1.Instance proto) {
              return Instance.fromProto(proto, InstanceAdminClientImpl.this, dbClient);
            }
          };
      if (listOptions.hasPageToken()) {
        pageFetcher.nextPageToken = listOptions.pageToken();
      }
      return pageFetcher.getNextPage();
    }

    @Override
    public void deleteInstance(final String instanceId) throws SpannerException {
      runWithRetries(
          new Callable<Void>() {
            @Override
            public Void call() {
              rpc.deleteInstance(new InstanceId(projectId, instanceId).getName());
              return null;
            }
          });
    }

    @Override
    public OperationFuture<Instance, UpdateInstanceMetadata> updateInstance(
        InstanceInfo instance, InstanceInfo.InstanceField... fieldsToUpdate) {
      FieldMask fieldMask =
          fieldsToUpdate.length == 0
              ? InstanceInfo.InstanceField.toFieldMask(InstanceInfo.InstanceField.values())
              : InstanceInfo.InstanceField.toFieldMask(fieldsToUpdate);

      OperationFuture<com.google.spanner.admin.instance.v1.Instance, UpdateInstanceMetadata>
          rawOperationFuture = rpc.updateInstance(instance.toProto(), fieldMask);
      return new OperationFutureImpl<Instance, UpdateInstanceMetadata>(
          rawOperationFuture.getPollingFuture(),
          rawOperationFuture.getInitialFuture(),
          new ApiFunction<OperationSnapshot, Instance>() {
            @Override
            public Instance apply(OperationSnapshot snapshot) {
              return Instance.fromProto(
                  ProtoOperationTransformers.ResponseTransformer.create(
                          com.google.spanner.admin.instance.v1.Instance.class)
                      .apply(snapshot),
                  InstanceAdminClientImpl.this,
                  dbClient);
            }
          },
          ProtoOperationTransformers.MetadataTransformer.create(UpdateInstanceMetadata.class),
          new ApiFunction<Exception, Instance>() {
            @Override
            public Instance apply(Exception e) {
              throw SpannerExceptionFactory.newSpannerException(e);
            }
          });
    }

    @Override
    public Instance.Builder newInstanceBuilder(InstanceId id) {
      return new Instance.Builder(this, dbClient, id);
    }
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

  @VisibleForTesting
  static class TransactionRunnerImpl implements SessionTransaction, TransactionRunner {
    private boolean blockNestedTxn = true;

    /** Allow for testing of backoff logic */
    static class Sleeper {
      void backoffSleep(Context context, long backoffMillis) {
        SpannerImpl.backoffSleep(context, backoffMillis);
      }
    }

    private final SessionImpl session;
    private final Sleeper sleeper;
    private final Span span;
    private TransactionContextImpl txn;
    private volatile boolean isValid = true;

    @Override
    public TransactionRunner allowNestedTransaction() {
      blockNestedTxn = false;
      return this;
    }

    TransactionRunnerImpl(
        SessionImpl session, SpannerRpc rpc, Sleeper sleeper, int defaultPrefetchChunks) {
      this.session = session;
      this.sleeper = sleeper;
      this.span = Tracing.getTracer().getCurrentSpan();
      this.txn = session.newTransaction();
    }

    TransactionRunnerImpl(SessionImpl session, SpannerRpc rpc, int defaultPrefetchChunks) {
      this(session, rpc, new Sleeper(), defaultPrefetchChunks);
    }

    @Nullable
    @Override
    public <T> T run(TransactionCallable<T> callable) {
      try (Scope s = tracer.withSpan(span)) {
        if (blockNestedTxn) {
          hasPendingTransaction.set(Boolean.TRUE);
        }

        return runInternal(callable);
      } catch (RuntimeException e) {
        TraceUtil.endSpanWithFailure(span, e);
        throw e;
      } finally {
        // Remove threadLocal rather than set to FALSE to avoid a possible memory leak.
        // We also do this unconditionally in case a user has modified the flag when the transaction
        // was running.
        hasPendingTransaction.remove();
      }
    }

    private <T> T runInternal(TransactionCallable<T> callable) {
      BackOff backoff = newBackOff();
      final Context context = Context.current();
      int attempt = 0;
      // TODO: Change this to use TransactionManager.
      while (true) {
        checkState(
            isValid, "TransactionRunner has been invalidated by a new operation on the session");
        checkContext(context);
        attempt++;
        // TODO(user): When using streaming reads, consider using the first read to begin
        // the txn.
        span.addAnnotation(
            "Starting Transaction Attempt",
            ImmutableMap.of("Attempt", AttributeValue.longAttributeValue(attempt)));
        txn.ensureTxn();

        T result;
        boolean shouldRollback = true;
        try {
          result = callable.run(txn);
          shouldRollback = false;
        } catch (Exception e) {
          txnLogger.log(Level.FINE, "User-provided TransactionCallable raised exception", e);
          if (txn.isAborted() || (e instanceof AbortedException)) {
            span.addAnnotation(
                "Transaction Attempt Aborted in user operation. Retrying",
                ImmutableMap.of("Attempt", AttributeValue.longAttributeValue(attempt)));
            shouldRollback = false;
            backoff(context, backoff);
            continue;
          }
          SpannerException toThrow;
          if (e instanceof SpannerException) {
            toThrow = (SpannerException) e;
          } else {
            toThrow = newSpannerException(ErrorCode.UNKNOWN, e.getMessage(), e);
          }
          span.addAnnotation(
              "Transaction Attempt Failed in user operation",
              ImmutableMap.<String, AttributeValue>builder()
                  .putAll(TraceUtil.getExceptionAnnotations(toThrow))
                  .put("Attempt", AttributeValue.longAttributeValue(attempt))
                  .build());
          throw toThrow;
        } finally {
          if (shouldRollback) {
            txn.rollback();
          }
        }

        try {
          txn.commit();
          span.addAnnotation(
              "Transaction Attempt Succeeded",
              ImmutableMap.of("Attempt", AttributeValue.longAttributeValue(attempt)));
          return result;
        } catch (AbortedException e) {
          txnLogger.log(Level.FINE, "Commit aborted", e);
          span.addAnnotation(
              "Transaction Attempt Aborted in Commit. Retrying",
              ImmutableMap.of("Attempt", AttributeValue.longAttributeValue(attempt)));
          backoff(context, backoff);
        } catch (SpannerException e) {
          span.addAnnotation(
              "Transaction Attempt Failed in Commit",
              ImmutableMap.<String, AttributeValue>builder()
                  .putAll(TraceUtil.getExceptionAnnotations(e))
                  .put("Attempt", AttributeValue.longAttributeValue(attempt))
                  .build());
          throw e;
        }
      }
    }

    @Override
    public Timestamp getCommitTimestamp() {
      return txn.commitTimestamp();
    }

    @Override
    public void invalidate() {
      isValid = false;
    }

    private void backoff(Context context, BackOff backoff) {
      long delay = txn.getRetryDelayInMillis(backoff);
      txn = session.newTransaction();
      span.addAnnotation(
          "Backing off", ImmutableMap.of("Delay", AttributeValue.longAttributeValue(delay)));
      sleeper.backoffSleep(context, delay);
    }
  }

  static class PartitionedDMLTransaction implements SessionTransaction {
    private final ByteString transactionId;
    private final SessionImpl session;
    private final SpannerRpc rpc;
    private volatile boolean isValid = true;

    PartitionedDMLTransaction(SessionImpl session, SpannerRpc rpc) {
      this.session = session;
      this.rpc = rpc;
      this.transactionId = initTransaction();
    }

    ByteString initTransaction() {
      final BeginTransactionRequest request =
          BeginTransactionRequest.newBuilder()
              .setSession(session.getName())
              .setOptions(
                  TransactionOptions.newBuilder()
                      .setPartitionedDml(TransactionOptions.PartitionedDml.getDefaultInstance()))
              .build();
      Transaction txn =
          runWithRetries(
              new Callable<Transaction>() {
                @Override
                public Transaction call() throws Exception {
                  return rpc.beginTransaction(request, session.options);
                }
              });
      if (txn.getId().isEmpty()) {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INTERNAL,
            "Failed to init transaction, missing transaction id\n" + session.getName());
      }
      return txn.getId();
    }

    public long executePartitionedUpdate(Statement statement) {
      checkState(isValid, "Partitioned DML has been invalidated by a new operation on the session");
      final ExecuteSqlRequest.Builder builder =
          ExecuteSqlRequest.newBuilder()
              .setSql(statement.getSql())
              .setQueryMode(QueryMode.NORMAL)
              .setSession(session.name)
              .setTransaction(TransactionSelector.newBuilder().setId(transactionId).build());
      Map<String, Value> stmtParameters = statement.getParameters();
      if (!stmtParameters.isEmpty()) {
        com.google.protobuf.Struct.Builder paramsBuilder = builder.getParamsBuilder();
        for (Map.Entry<String, Value> param : stmtParameters.entrySet()) {
          paramsBuilder.putFields(param.getKey(), param.getValue().toProto());
          builder.putParamTypes(param.getKey(), param.getValue().getType().toProto());
        }
      }
      com.google.spanner.v1.ResultSet resultSet =
          runWithRetries(
              new Callable<com.google.spanner.v1.ResultSet>() {
                @Override
                public com.google.spanner.v1.ResultSet call() throws Exception {
                  return rpc.executeQuery(builder.build(), session.options);
                }
              });
      if (!resultSet.hasStats()) {
        throw new IllegalArgumentException(
            "Partitioned DML response missing stats possibly due to non-DML statement as input");
      }
      // For partitioned DML, using the row count lower bound.
      return resultSet.getStats().getRowCountLowerBound();
    }

    @Override
    public void invalidate() {
      isValid = false;
    }
  }

  @VisibleForTesting
  static class TransactionContextImpl extends AbstractReadContext implements TransactionContext {
    @GuardedBy("lock")
    private List<Mutation> mutations = new ArrayList<>();

    @GuardedBy("lock")
    private boolean aborted;

    /** Default to -1 to indicate not available. */
    @GuardedBy("lock")
    private long retryDelayInMillis = -1L;

    private ByteString transactionId;
    private Timestamp commitTimestamp;

    TransactionContextImpl(
        SessionImpl session,
        @Nullable ByteString transactionId,
        SpannerRpc rpc,
        int defaultPrefetchChunks) {
      super(session, rpc, defaultPrefetchChunks);
      this.transactionId = transactionId;
    }

    void ensureTxn() {
      if (transactionId == null) {
        span.addAnnotation("Creating Transaction");
        try {
          transactionId = session.beginTransaction();
          span.addAnnotation(
              "Transaction Creation Done",
              ImmutableMap.of(
                  "Id", AttributeValue.stringAttributeValue(transactionId.toStringUtf8())));
          txnLogger.log(
              Level.FINER,
              "Started transaction {0}",
              txnLogger.isLoggable(Level.FINER) ? transactionId.asReadOnlyByteBuffer() : null);
        } catch (SpannerException e) {
          span.addAnnotation("Transaction Creation Failed", TraceUtil.getExceptionAnnotations(e));
          throw e;
        }
      } else {
        span.addAnnotation(
            "Transaction Initialized",
            ImmutableMap.of(
                "Id", AttributeValue.stringAttributeValue(transactionId.toStringUtf8())));
        txnLogger.log(
            Level.FINER,
            "Using prepared transaction {0}",
            txnLogger.isLoggable(Level.FINER) ? transactionId.asReadOnlyByteBuffer() : null);
      }
    }

    void commit() {
      span.addAnnotation("Starting Commit");
      CommitRequest.Builder builder =
          CommitRequest.newBuilder().setSession(session.getName()).setTransactionId(transactionId);
      synchronized (lock) {
        if (!mutations.isEmpty()) {
          List<com.google.spanner.v1.Mutation> mutationsProto = new ArrayList<>();
          Mutation.toProto(mutations, mutationsProto);
          builder.addAllMutations(mutationsProto);
        }
        // Ensure that no call to buffer mutations that would be lost can succeed.
        mutations = null;
      }
      final CommitRequest commitRequest = builder.build();
      Span opSpan = tracer.spanBuilderWithExplicitParent(COMMIT, span).startSpan();
      try (Scope s = tracer.withSpan(opSpan)) {
        CommitResponse commitResponse =
            runWithRetries(
                new Callable<CommitResponse>() {
                  @Override
                  public CommitResponse call() throws Exception {
                    return rpc.commit(commitRequest, session.options);
                  }
                });

        if (!commitResponse.hasCommitTimestamp()) {
          throw newSpannerException(
              ErrorCode.INTERNAL, "Missing commitTimestamp:\n" + session.getName());
        }
        commitTimestamp = Timestamp.fromProto(commitResponse.getCommitTimestamp());
        opSpan.end();
      } catch (RuntimeException e) {
        span.addAnnotation("Commit Failed", TraceUtil.getExceptionAnnotations(e));
        TraceUtil.endSpanWithFailure(opSpan, e);
        throw e;
      }
      span.addAnnotation("Commit Done");
    }

    Timestamp commitTimestamp() {
      checkState(commitTimestamp != null, "run() has not yet returned normally");
      return commitTimestamp;
    }

    boolean isAborted() {
      synchronized (lock) {
        return aborted;
      }
    }

    /** Return the delay in milliseconds between requests to Cloud Spanner. */
    long getRetryDelayInMillis(BackOff backoff) {
      long delay = nextBackOffMillis(backoff);
      synchronized (lock) {
        if (retryDelayInMillis >= 0) {
          return retryDelayInMillis;
        }
      }
      return delay;
    }

    void rollback() {
      // We're exiting early due to a user exception, but the transaction is still active.
      // Send a rollback for the transaction to release any locks held.
      // TODO(user): Make this an async fire-and-forget request.
      try {
        // Note that we're not retrying this request since we don't particularly care about the
        // response.  Normally, the next thing that will happen is that we will make a fresh
        // transaction attempt, which should implicitly abort this one.
        span.addAnnotation("Starting Rollback");
        rpc.rollback(
            RollbackRequest.newBuilder()
                .setSession(session.getName())
                .setTransactionId(transactionId)
                .build(),
            session.options);
        span.addAnnotation("Rollback Done");
      } catch (SpannerException e) {
        txnLogger.log(Level.FINE, "Exception during rollback", e);
        span.addAnnotation("Rollback Failed", TraceUtil.getExceptionAnnotations(e));
      }
    }

    @Nullable
    @Override
    TransactionSelector getTransactionSelector() {
      return TransactionSelector.newBuilder().setId(transactionId).build();
    }

    @Override
    public void onError(SpannerException e) {
      if (e.getErrorCode() == ErrorCode.ABORTED) {
        long delay = -1L;
        if (e instanceof AbortedException) {
          delay = ((AbortedException) e).getRetryDelayInMillis();
        }
        if (delay == -1L) {
          txnLogger.log(Level.FINE, "Retry duration is missing from the exception.", e);
        }

        synchronized (lock) {
          retryDelayInMillis = delay;
          aborted = true;
        }
      }
    }

    @Override
    public void buffer(Mutation mutation) {
      synchronized (lock) {
        checkNotNull(mutations, "Context is closed");
        mutations.add(checkNotNull(mutation));
      }
    }

    @Override
    public void buffer(Iterable<Mutation> mutations) {
      synchronized (lock) {
        checkNotNull(this.mutations, "Context is closed");
        for (Mutation mutation : mutations) {
          this.mutations.add(checkNotNull(mutation));
        }
      }
    }

    @Override
    public long executeUpdate(Statement statement) {
      beforeReadOrQuery();
      final ExecuteSqlRequest.Builder builder =
          getExecuteSqlRequestBuilder(statement, QueryMode.NORMAL);
      com.google.spanner.v1.ResultSet resultSet =
          runWithRetries(
              new Callable<com.google.spanner.v1.ResultSet>() {
                @Override
                public com.google.spanner.v1.ResultSet call() throws Exception {
                  return rpc.executeQuery(builder.build(), session.options);
                }
              });
      if (!resultSet.hasStats()) {
        throw new IllegalArgumentException(
            "DML response missing stats possibly due to non-DML statement as input");
      }
      // For standard DML, using the exact row count.
      return resultSet.getStats().getRowCountExact();
    }

    @Override
    public long[] batchUpdate(Iterable<Statement> statements) {
      beforeReadOrQuery();
      final ExecuteBatchDmlRequest.Builder builder = getExecuteBatchDmlRequestBuilder(statements);
      com.google.spanner.v1.ExecuteBatchDmlResponse response =
          runWithRetries(
              new Callable<com.google.spanner.v1.ExecuteBatchDmlResponse>() {
                @Override
                public com.google.spanner.v1.ExecuteBatchDmlResponse call() throws Exception {
                  return rpc.executeBatchDml(builder.build(), session.options);
                }
              });
      long[] results = new long[response.getResultSetsCount()];
      for (int i = 0; i < response.getResultSetsCount(); ++i) {
        results[i] = response.getResultSets(i).getStats().getRowCountExact();
      }

      if (response.getStatus().getCode() != 0) {
        throw newSpannerBatchUpdateException(
            ErrorCode.fromRpcStatus(response.getStatus()),
            response.getStatus().getMessage(),
            results);
      }
      return results;
    }
  }
}
