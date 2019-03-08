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
import com.google.api.gax.rpc.ServerStream;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.BaseService;
import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.PageImpl;
import com.google.cloud.PageImpl.NextPageFetcher;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Options.ListOption;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.Options.ReadOption;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.cloud.spanner.spi.v1.SpannerRpc.Paginated;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ListValue;
import com.google.protobuf.Message;
import com.google.protobuf.Value.KindCase;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import com.google.spanner.admin.instance.v1.CreateInstanceMetadata;
import com.google.spanner.admin.instance.v1.UpdateInstanceMetadata;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CommitResponse;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ExecuteSqlRequest.QueryMode;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import com.google.spanner.v1.RollbackRequest;
import com.google.spanner.v1.Transaction;
import com.google.spanner.v1.TransactionOptions;
import com.google.spanner.v1.TransactionSelector;
import com.google.spanner.v1.TypeCode;
import io.grpc.Context;
import io.opencensus.common.Scope;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.Span;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.Tracing;
import java.io.IOException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
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
  private static final String QUERY = "CloudSpannerOperation.ExecuteStreamingQuery";
  private static final String READ = "CloudSpannerOperation.ExecuteStreamingRead";

  private static final ThreadLocal<Boolean> hasPendingTransaction =
      new ThreadLocal<Boolean>() {
        @Override
        protected Boolean initialValue() {
          return false;
        }
      };

  private static void throwIfTransactionsPending() {
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

  private static ExponentialBackOff newBackOff() {
    return new ExponentialBackOff.Builder()
        .setInitialIntervalMillis(MIN_BACKOFF_MS)
        .setMaxIntervalMillis(MAX_BACKOFF_MS)
        .setMaxElapsedTimeMillis(Integer.MAX_VALUE) // Prevent Backoff.STOP from getting returned.
        .build();
  }

  private static void backoffSleep(Context context, BackOff backoff) throws SpannerException {
    backoffSleep(context, nextBackOffMillis(backoff));
  }

  private static long nextBackOffMillis(BackOff backoff) throws SpannerException {
    try {
      return backoff.nextBackOffMillis();
    } catch (IOException e) {
      throw newSpannerException(ErrorCode.INTERNAL, e.getMessage(), e);
    }
  }

  private static void backoffSleep(Context context, long backoffMillis) throws SpannerException {
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

  private abstract static class PageFetcher<S, T> implements NextPageFetcher<S> {
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

    abstract Paginated<T> getNextPage(@Nullable String nextPageToken);

    abstract S fromProto(T proto);
  }

  private static String randomOperationId() {
    UUID uuid = UUID.randomUUID();
    return ("r" + uuid.toString()).replace("-", "_");
  }

  static class DatabaseAdminClientImpl implements DatabaseAdminClient {

    private final String projectId;
    private final SpannerRpc rpc;

    DatabaseAdminClientImpl(String projectId, SpannerRpc rpc) {
      this.projectId = projectId;
      this.rpc = rpc;
    }

    @Override
    public OperationFuture<Database, CreateDatabaseMetadata> createDatabase(
        String instanceId, String databaseId, Iterable<String> statements) throws SpannerException {
      // CreateDatabase() is not idempotent, so we're not retrying this request.
      String instanceName = getInstanceName(instanceId);
      String createStatement = "CREATE DATABASE `" + databaseId + "`";
      OperationFuture<com.google.spanner.admin.database.v1.Database, CreateDatabaseMetadata>
          rawOperationFuture = rpc.createDatabase(instanceName, createStatement, statements);
      return new OperationFutureImpl<Database, CreateDatabaseMetadata>(
          rawOperationFuture.getPollingFuture(),
          rawOperationFuture.getInitialFuture(),
          new ApiFunction<OperationSnapshot, Database>() {
            @Override
            public Database apply(OperationSnapshot snapshot) {
              return Database.fromProto(
                  ProtoOperationTransformers.ResponseTransformer.create(
                          com.google.spanner.admin.database.v1.Database.class)
                      .apply(snapshot),
                  DatabaseAdminClientImpl.this);
            }
          },
          ProtoOperationTransformers.MetadataTransformer.create(CreateDatabaseMetadata.class),
          new ApiFunction<Exception, Database>() {
            @Override
            public Database apply(Exception e) {
              throw SpannerExceptionFactory.newSpannerException(e);
            }
          });
    }

    @Override
    public Database getDatabase(String instanceId, String databaseId) throws SpannerException {
      final String dbName = getDatabaseName(instanceId, databaseId);
      Callable<Database> callable =
          new Callable<Database>() {
            @Override
            public Database call() throws Exception {
              return Database.fromProto(rpc.getDatabase(dbName), DatabaseAdminClientImpl.this);
            }
          };
      return runWithRetries(callable);
    }

    @Override
    public OperationFuture<Void, UpdateDatabaseDdlMetadata> updateDatabaseDdl(
        final String instanceId,
        final String databaseId,
        final Iterable<String> statements,
        @Nullable String operationId)
        throws SpannerException {
      final String dbName = getDatabaseName(instanceId, databaseId);
      final String opId = operationId != null ? operationId : randomOperationId();
      OperationFuture<Empty, UpdateDatabaseDdlMetadata> rawOperationFuture =
          rpc.updateDatabaseDdl(dbName, statements, opId);
      return new OperationFutureImpl<Void, UpdateDatabaseDdlMetadata>(
          rawOperationFuture.getPollingFuture(),
          rawOperationFuture.getInitialFuture(),
          new ApiFunction<OperationSnapshot, Void>() {
            @Override
            public Void apply(OperationSnapshot snapshot) {
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class).apply(snapshot);
              return null;
            }
          },
          ProtoOperationTransformers.MetadataTransformer.create(UpdateDatabaseDdlMetadata.class),
          new ApiFunction<Exception, Void>() {
            @Override
            public Void apply(Exception e) {
              throw SpannerExceptionFactory.newSpannerException(e);
            }
          });
    }

    @Override
    public void dropDatabase(String instanceId, String databaseId) throws SpannerException {
      final String dbName = getDatabaseName(instanceId, databaseId);
      Callable<Void> callable =
          new Callable<Void>() {
            @Override
            public Void call() throws Exception {
              rpc.dropDatabase(dbName);
              return null;
            }
          };
      runWithRetries(callable);
    }

    @Override
    public List<String> getDatabaseDdl(String instanceId, String databaseId) {
      final String dbName = getDatabaseName(instanceId, databaseId);
      Callable<List<String>> callable =
          new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
              return rpc.getDatabaseDdl(dbName);
            }
          };
      return runWithRetries(callable);
    }

    @Override
    public Page<Database> listDatabases(String instanceId, ListOption... options) {
      final String instanceName = getInstanceName(instanceId);
      final Options listOptions = Options.fromListOptions(options);
      Preconditions.checkArgument(
          !listOptions.hasFilter(), "Filter option is not support by" + "listDatabases");
      final int pageSize = listOptions.hasPageSize() ? listOptions.pageSize() : 0;
      PageFetcher<Database, com.google.spanner.admin.database.v1.Database> pageFetcher =
          new PageFetcher<Database, com.google.spanner.admin.database.v1.Database>() {
            @Override
            public Paginated<com.google.spanner.admin.database.v1.Database> getNextPage(
                String nextPageToken) {
              return rpc.listDatabases(instanceName, pageSize, nextPageToken);
            }

            @Override
            public Database fromProto(com.google.spanner.admin.database.v1.Database proto) {
              return Database.fromProto(proto, DatabaseAdminClientImpl.this);
            }
          };
      if (listOptions.hasPageToken()) {
        pageFetcher.nextPageToken = listOptions.pageToken();
      }
      return pageFetcher.getNextPage();
    }

    private String getInstanceName(String instanceId) {
      return new InstanceId(projectId, instanceId).getName();
    }

    private String getDatabaseName(String instanceId, String databaseId) {
      return new DatabaseId(new InstanceId(projectId, instanceId), databaseId).getName();
    }
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

  abstract static class AbstractReadContext
      implements ReadContext, AbstractResultSet.Listener, SessionTransaction {
    final Object lock = new Object();
    final SessionImpl session;
    final SpannerRpc rpc;
    final int defaultPrefetchChunks;
    final Span span;

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

    private AbstractReadContext(SessionImpl session, SpannerRpc rpc, int defaultPrefetchChunks) {
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
    public final ResultSet analyzeQuery(
        Statement statement, QueryAnalyzeMode readContextQueryMode) {
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

    ExecuteSqlRequest.Builder getExecuteSqlRequestBuilder(
        Statement statement, QueryMode queryMode) {
      ExecuteSqlRequest.Builder builder =
          ExecuteSqlRequest.newBuilder()
              .setSql(statement.getSql())
              .setQueryMode(queryMode)
              .setSession(session.name);
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

    ExecuteBatchDmlRequest.Builder getExecuteBatchDmlRequestBuilder(
        Iterable<Statement> statements) {
      ExecuteBatchDmlRequest.Builder builder =
          ExecuteBatchDmlRequest.newBuilder().setSession(session.name);
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
          new ResumableStreamIterator(MAX_BUFFERED_CHUNKS, QUERY, span) {
            @Override
            CloseableIterator<PartialResultSet> startStream(@Nullable ByteString resumeToken) {
              GrpcStreamIterator stream = new GrpcStreamIterator(prefetchChunks);
              if (resumeToken != null) {
                request.setResumeToken(resumeToken);
              }
              SpannerRpc.StreamingCall call =
                  rpc.executeQuery(request.build(), stream.consumer(), session.options);
              call.request(prefetchChunks);
              stream.setCall(call);
              return stream;
            }
          };
      return new GrpcResultSet(stream, this, queryMode);
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
              .setSession(session.name)
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
          new ResumableStreamIterator(MAX_BUFFERED_CHUNKS, READ, span) {
            @Override
            CloseableIterator<PartialResultSet> startStream(@Nullable ByteString resumeToken) {
              GrpcStreamIterator stream = new GrpcStreamIterator(prefetchChunks);
              if (resumeToken != null) {
                builder.setResumeToken(resumeToken);
              }
              SpannerRpc.StreamingCall call =
                  rpc.read(builder.build(), stream.consumer(), session.options);
              call.request(prefetchChunks);
              stream.setCall(call);
              return stream;
            }
          };
      GrpcResultSet resultSet =
          new GrpcResultSet(stream, this, com.google.spanner.v1.ExecuteSqlRequest.QueryMode.NORMAL);
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

  /**
   * A {@code ReadContext} for standalone reads. This can only be used for a single operation, since
   * each standalone read may see a different timestamp of Cloud Spanner data.
   */
  private static class SingleReadContext extends AbstractReadContext {
    final TimestampBound bound;

    @GuardedBy("lock")
    private boolean used;

    private SingleReadContext(
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

  private class SingleUseReadOnlyTransaction extends SingleReadContext
      implements ReadOnlyTransaction {
    @GuardedBy("lock")
    private Timestamp timestamp;

    private SingleUseReadOnlyTransaction(
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
      throwIfTransactionsPending();

      // Since we only support synchronous calls, just block on "txnLock" while the RPC is in
      // flight.  Note that we use the strategy of sending an explicit BeginTransaction() RPC,
      // rather than using the first read in the transaction to begin it implicitly.  The chosen
      // strategy is sub-optimal in the case of the first read being fast, as it incurs an extra
      // RTT, but optimal if the first read is slow.  Since we don't know how fast the read will be,
      // and we are using non-streaming reads (so we don't see the metadata until the entire read
      // has finished), using BeginTransaction() is the safest path.
      // TODO(user): Fix comment / begin transaction on first read; we now use streaming reads.
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
              runWithRetries(
                  new Callable<Transaction>() {
                    @Override
                    public Transaction call() throws Exception {
                      return rpc.beginTransaction(request, session.options);
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

  @VisibleForTesting
  abstract static class AbstractResultSet<R> extends AbstractStructReader implements ResultSet {
    interface Listener {
      /**
       * Called when transaction metadata is seen. This method may be invoked at most once. If the
       * method is invoked, it will precede {@link #onError(SpannerException)} or {@link #onDone()}.
       */
      void onTransactionMetadata(Transaction transaction) throws SpannerException;

      /** Called when the read finishes with an error. */
      void onError(SpannerException e);

      /** Called when the read finishes normally. */
      void onDone();
    }

    protected abstract GrpcStruct currRow();

    @Override
    public Struct getCurrentRowAsStruct() {
      return currRow().immutableCopy();
    }

    @Override
    protected boolean getBooleanInternal(int columnIndex) {
      return currRow().getBooleanInternal(columnIndex);
    }

    @Override
    protected long getLongInternal(int columnIndex) {
      return currRow().getLongInternal(columnIndex);
    }

    @Override
    protected double getDoubleInternal(int columnIndex) {
      return currRow().getDoubleInternal(columnIndex);
    }

    @Override
    protected String getStringInternal(int columnIndex) {
      return currRow().getStringInternal(columnIndex);
    }

    @Override
    protected ByteArray getBytesInternal(int columnIndex) {
      return currRow().getBytesInternal(columnIndex);
    }

    @Override
    protected Timestamp getTimestampInternal(int columnIndex) {
      return currRow().getTimestampInternal(columnIndex);
    }

    @Override
    protected Date getDateInternal(int columnIndex) {
      return currRow().getDateInternal(columnIndex);
    }

    @Override
    protected boolean[] getBooleanArrayInternal(int columnIndex) {
      return currRow().getBooleanArrayInternal(columnIndex);
    }

    @Override
    protected List<Boolean> getBooleanListInternal(int columnIndex) {
      return currRow().getBooleanListInternal(columnIndex);
    }

    @Override
    protected long[] getLongArrayInternal(int columnIndex) {
      return currRow().getLongArrayInternal(columnIndex);
    }

    @Override
    protected List<Long> getLongListInternal(int columnIndex) {
      return currRow().getLongListInternal(columnIndex);
    }

    @Override
    protected double[] getDoubleArrayInternal(int columnIndex) {
      return currRow().getDoubleArrayInternal(columnIndex);
    }

    @Override
    protected List<Double> getDoubleListInternal(int columnIndex) {
      return currRow().getDoubleListInternal(columnIndex);
    }

    @Override
    protected List<String> getStringListInternal(int columnIndex) {
      return currRow().getStringListInternal(columnIndex);
    }

    @Override
    protected List<ByteArray> getBytesListInternal(int columnIndex) {
      return currRow().getBytesListInternal(columnIndex);
    }

    @Override
    protected List<Timestamp> getTimestampListInternal(int columnIndex) {
      return currRow().getTimestampListInternal(columnIndex);
    }

    @Override
    protected List<Date> getDateListInternal(int columnIndex) {
      return currRow().getDateListInternal(columnIndex);
    }

    @Override
    protected List<Struct> getStructListInternal(int columnIndex) {
      return currRow().getStructListInternal(columnIndex);
    }

    @Override
    public boolean isNull(int columnIndex) {
      return currRow().isNull(columnIndex);
    }
  }

  @VisibleForTesting
  static class GrpcResultSet extends AbstractResultSet<List<Object>> {
    private final GrpcValueIterator iterator;
    private final Listener listener;
    private final QueryMode queryMode;
    private GrpcStruct currRow;
    private SpannerException error;
    private ResultSetStats statistics;
    private boolean closed;

    GrpcResultSet(
        CloseableIterator<PartialResultSet> iterator, Listener listener, QueryMode queryMode) {
      this.iterator = new GrpcValueIterator(iterator);
      this.listener = listener;
      this.queryMode = queryMode;
    }

    @Override
    protected GrpcStruct currRow() {
      checkState(!closed, "ResultSet is closed");
      checkState(currRow != null, "next() call required");
      return currRow;
    }

    @Override
    public boolean next() throws SpannerException {
      if (error != null) {
        throw newSpannerException(error);
      }
      try {
        if (currRow == null) {
          ResultSetMetadata metadata = iterator.getMetadata();
          if (metadata.hasTransaction()) {
            listener.onTransactionMetadata(metadata.getTransaction());
          }
          currRow = new GrpcStruct(iterator.type(), new ArrayList<>());
        }
        boolean hasNext = currRow.consumeRow(iterator);
        if (!hasNext) {
          statistics = iterator.getStats();
        }
        return hasNext;
      } catch (SpannerException e) {
        throw yieldError(e);
      }
    }

    @Override
    @Nullable
    public ResultSetStats getStats() {
      return statistics;
    }

    @Override
    public void close() {
      iterator.close("ResultSet closed");
      closed = true;
    }

    @Override
    public Type getType() {
      checkState(currRow != null, "next() call required");
      return currRow.getType();
    }

    private SpannerException yieldError(SpannerException e) {
      close();
      listener.onError(e);
      throw e;
    }
  }

  private static class GrpcStruct extends Struct implements Serializable {

    protected final Type type;
    protected final List<Object> rowData;

    /**
     * Builds an immutable version of this struct using {@link Struct#newBuilder()} which is used as
     * a serialization proxy.
     */
    private Object writeReplace() {
      Builder builder = Struct.newBuilder();
      List<Type.StructField> structFields = getType().getStructFields();
      for (int i = 0; i < structFields.size(); i++) {
        Type.StructField field = structFields.get(i);
        String fieldName = field.getName();
        Object value = rowData.get(i);
        Type fieldType = field.getType();
        switch (fieldType.getCode()) {
          case BOOL:
            builder.set(fieldName).to((Boolean) value);
            break;
          case INT64:
            builder.set(fieldName).to((Long) value);
            break;
          case FLOAT64:
            builder.set(fieldName).to((Double) value);
            break;
          case STRING:
            builder.set(fieldName).to((String) value);
            break;
          case BYTES:
            builder.set(fieldName).to((ByteArray) value);
            break;
          case TIMESTAMP:
            builder.set(fieldName).to((Timestamp) value);
            break;
          case DATE:
            builder.set(fieldName).to((Date) value);
            break;
          case ARRAY:
            switch (fieldType.getArrayElementType().getCode()) {
              case BOOL:
                builder.set(fieldName).toBoolArray((Iterable<Boolean>) value);
                break;
              case INT64:
                builder.set(fieldName).toInt64Array((Iterable<Long>) value);
                break;
              case FLOAT64:
                builder.set(fieldName).toFloat64Array((Iterable<Double>) value);
                break;
              case STRING:
                builder.set(fieldName).toStringArray((Iterable<String>) value);
                break;
              case BYTES:
                builder.set(fieldName).toBytesArray((Iterable<ByteArray>) value);
                break;
              case TIMESTAMP:
                builder.set(fieldName).toTimestampArray((Iterable<Timestamp>) value);
                break;
              case DATE:
                builder.set(fieldName).toDateArray((Iterable<Date>) value);
                break;
              case STRUCT:
                builder
                    .set(fieldName)
                    .toStructArray(fieldType.getArrayElementType(), (Iterable<Struct>) value);
                break;
              default:
                throw new AssertionError(
                    "Unhandled array type code: " + fieldType.getArrayElementType());
            }
            break;
          case STRUCT:
            if (value == null) {
              builder.set(fieldName).to(fieldType, null);
            } else {
              builder.set(fieldName).to((Struct) value);
            }
            break;
          default:
            throw new AssertionError("Unhandled type code: " + fieldType.getCode());
        }
      }
      return builder.build();
    }

    GrpcStruct(Type type, List<Object> rowData) {
      this.type = type;
      this.rowData = rowData;
    }

    @Override
    public String toString() {
      return this.rowData.toString();
    }

    boolean consumeRow(Iterator<com.google.protobuf.Value> iterator) {
      rowData.clear();
      if (!iterator.hasNext()) {
        return false;
      }
      for (Type.StructField fieldType : getType().getStructFields()) {
        if (!iterator.hasNext()) {
          throw newSpannerException(
              ErrorCode.INTERNAL,
              "Invalid value stream: end of stream reached before row is complete");
        }
        com.google.protobuf.Value value = iterator.next();
        rowData.add(decodeValue(fieldType.getType(), value));
      }
      return true;
    }

    private static Object decodeValue(Type fieldType, com.google.protobuf.Value proto) {
      if (proto.getKindCase() == KindCase.NULL_VALUE) {
        return null;
      }
      switch (fieldType.getCode()) {
        case BOOL:
          checkType(fieldType, proto, KindCase.BOOL_VALUE);
          return proto.getBoolValue();
        case INT64:
          checkType(fieldType, proto, KindCase.STRING_VALUE);
          return Long.parseLong(proto.getStringValue());
        case FLOAT64:
          return valueProtoToFloat64(proto);
        case STRING:
          checkType(fieldType, proto, KindCase.STRING_VALUE);
          return proto.getStringValue();
        case BYTES:
          checkType(fieldType, proto, KindCase.STRING_VALUE);
          return ByteArray.fromBase64(proto.getStringValue());
        case TIMESTAMP:
          checkType(fieldType, proto, KindCase.STRING_VALUE);
          return Timestamp.parseTimestamp(proto.getStringValue());
        case DATE:
          checkType(fieldType, proto, KindCase.STRING_VALUE);
          return Date.parseDate(proto.getStringValue());
        case ARRAY:
          checkType(fieldType, proto, KindCase.LIST_VALUE);
          ListValue listValue = proto.getListValue();
          return decodeArrayValue(fieldType.getArrayElementType(), listValue);
        case STRUCT:
          checkType(fieldType, proto, KindCase.LIST_VALUE);
          ListValue structValue = proto.getListValue();
          return decodeStructValue(fieldType, structValue);
        default:
          throw new AssertionError("Unhandled type code: " + fieldType.getCode());
      }
    }

    private static Struct decodeStructValue(Type structType, ListValue structValue) {
      List<Type.StructField> fieldTypes = structType.getStructFields();
      checkArgument(
          structValue.getValuesCount() == fieldTypes.size(),
          "Size mismatch between type descriptor and actual values.");
      List<Object> fields = new ArrayList<>(fieldTypes.size());
      List<com.google.protobuf.Value> fieldValues = structValue.getValuesList();
      for (int i = 0; i < fieldTypes.size(); ++i) {
        fields.add(decodeValue(fieldTypes.get(i).getType(), fieldValues.get(i)));
      }
      return new GrpcStruct(structType, fields);
    }

    private static Object decodeArrayValue(Type elementType, ListValue listValue) {
      switch (elementType.getCode()) {
        case BOOL:
          // Use a view: element conversion is virtually free.
          return Lists.transform(
              listValue.getValuesList(),
              new Function<com.google.protobuf.Value, Boolean>() {
                @Override
                public Boolean apply(com.google.protobuf.Value input) {
                  return input.getKindCase() == KindCase.NULL_VALUE ? null : input.getBoolValue();
                }
              });
        case INT64:
          // For int64/float64 types, use custom containers.  These avoid wrapper object
          // creation for non-null arrays.
          return new Int64Array(listValue);
        case FLOAT64:
          return new Float64Array(listValue);
        case STRING:
          return Lists.transform(
              listValue.getValuesList(),
              new Function<com.google.protobuf.Value, String>() {
                @Override
                public String apply(com.google.protobuf.Value input) {
                  return input.getKindCase() == KindCase.NULL_VALUE ? null : input.getStringValue();
                }
              });
        case BYTES:
          {
            // Materialize list: element conversion is expensive and should happen only once.
            ArrayList<Object> list = new ArrayList<>(listValue.getValuesCount());
            for (com.google.protobuf.Value value : listValue.getValuesList()) {
              list.add(
                  value.getKindCase() == KindCase.NULL_VALUE
                      ? null
                      : ByteArray.fromBase64(value.getStringValue()));
            }
            return list;
          }
        case TIMESTAMP:
          {
            // Materialize list: element conversion is expensive and should happen only once.
            ArrayList<Object> list = new ArrayList<>(listValue.getValuesCount());
            for (com.google.protobuf.Value value : listValue.getValuesList()) {
              list.add(
                  value.getKindCase() == KindCase.NULL_VALUE
                      ? null
                      : Timestamp.parseTimestamp(value.getStringValue()));
            }
            return list;
          }
        case DATE:
          {
            // Materialize list: element conversion is expensive and should happen only once.
            ArrayList<Object> list = new ArrayList<>(listValue.getValuesCount());
            for (com.google.protobuf.Value value : listValue.getValuesList()) {
              list.add(
                  value.getKindCase() == KindCase.NULL_VALUE
                      ? null
                      : Date.parseDate(value.getStringValue()));
            }
            return list;
          }

        case STRUCT:
          {
            ArrayList<Struct> list = new ArrayList<>(listValue.getValuesCount());
            for (com.google.protobuf.Value value : listValue.getValuesList()) {
              if (value.getKindCase() == KindCase.NULL_VALUE) {
                list.add(null);
              } else {
                ListValue structValue = value.getListValue();
                list.add(decodeStructValue(elementType, structValue));
              }
            }
            return list;
          }
        default:
          throw new AssertionError("Unhandled type code: " + elementType.getCode());
      }
    }

    private static void checkType(
        Type fieldType, com.google.protobuf.Value proto, KindCase expected) {
      if (proto.getKindCase() != expected) {
        throw newSpannerException(
            ErrorCode.INTERNAL,
            "Invalid value for column type "
                + fieldType
                + " expected "
                + expected
                + " but was "
                + proto.getKindCase());
      }
    }

    Struct immutableCopy() {
      return new GrpcStruct(type, new ArrayList<>(rowData));
    }

    @Override
    public Type getType() {
      return type;
    }

    @Override
    public boolean isNull(int columnIndex) {
      return rowData.get(columnIndex) == null;
    }

    @Override
    protected boolean getBooleanInternal(int columnIndex) {
      return (Boolean) rowData.get(columnIndex);
    }

    @Override
    protected long getLongInternal(int columnIndex) {
      return (Long) rowData.get(columnIndex);
    }

    @Override
    protected double getDoubleInternal(int columnIndex) {
      return (Double) rowData.get(columnIndex);
    }

    @Override
    protected String getStringInternal(int columnIndex) {
      return (String) rowData.get(columnIndex);
    }

    @Override
    protected ByteArray getBytesInternal(int columnIndex) {
      return (ByteArray) rowData.get(columnIndex);
    }

    @Override
    protected Timestamp getTimestampInternal(int columnIndex) {
      return (Timestamp) rowData.get(columnIndex);
    }

    @Override
    protected Date getDateInternal(int columnIndex) {
      return (Date) rowData.get(columnIndex);
    }

    @Override
    protected Struct getStructInternal(int columnIndex) {
      return (Struct) rowData.get(columnIndex);
    }

    @Override
    protected boolean[] getBooleanArrayInternal(int columnIndex) {
      @SuppressWarnings("unchecked") // We know ARRAY<BOOL> produces a List<Boolean>.
      List<Boolean> values = (List<Boolean>) rowData.get(columnIndex);
      boolean[] r = new boolean[values.size()];
      for (int i = 0; i < values.size(); ++i) {
        if (values.get(i) == null) {
          throw throwNotNull(columnIndex);
        }
        r[i] = values.get(i);
      }
      return r;
    }

    @Override
    @SuppressWarnings("unchecked") // We know ARRAY<BOOL> produces a List<Boolean>.
    protected List<Boolean> getBooleanListInternal(int columnIndex) {
      return Collections.unmodifiableList((List<Boolean>) rowData.get(columnIndex));
    }

    @Override
    protected long[] getLongArrayInternal(int columnIndex) {
      return getLongListInternal(columnIndex).toPrimitiveArray(columnIndex);
    }

    @Override
    protected Int64Array getLongListInternal(int columnIndex) {
      return (Int64Array) rowData.get(columnIndex);
    }

    @Override
    protected double[] getDoubleArrayInternal(int columnIndex) {
      return getDoubleListInternal(columnIndex).toPrimitiveArray(columnIndex);
    }

    @Override
    protected Float64Array getDoubleListInternal(int columnIndex) {
      return (Float64Array) rowData.get(columnIndex);
    }

    @Override
    @SuppressWarnings("unchecked") // We know ARRAY<STRING> produces a List<String>.
    protected List<String> getStringListInternal(int columnIndex) {
      return Collections.unmodifiableList((List<String>) rowData.get(columnIndex));
    }

    @Override
    @SuppressWarnings("unchecked") // We know ARRAY<BYTES> produces a List<ByteArray>.
    protected List<ByteArray> getBytesListInternal(int columnIndex) {
      return Collections.unmodifiableList((List<ByteArray>) rowData.get(columnIndex));
    }

    @Override
    @SuppressWarnings("unchecked") // We know ARRAY<TIMESTAMP> produces a List<Timestamp>.
    protected List<Timestamp> getTimestampListInternal(int columnIndex) {
      return Collections.unmodifiableList((List<Timestamp>) rowData.get(columnIndex));
    }

    @Override
    @SuppressWarnings("unchecked") // We know ARRAY<DATE> produces a List<Date>.
    protected List<Date> getDateListInternal(int columnIndex) {
      return Collections.unmodifiableList((List<Date>) rowData.get(columnIndex));
    }

    @Override
    @SuppressWarnings("unchecked") // We know ARRAY<STRUCT<...>> produces a List<STRUCT>.
    protected List<Struct> getStructListInternal(int columnIndex) {
      return Collections.unmodifiableList((List<Struct>) rowData.get(columnIndex));
    }
  }

  @VisibleForTesting
  interface CloseableIterator<T> extends Iterator<T> {

    /**
     * Closes the iterator, freeing any underlying resources.
     *
     * @param message a message to include in the final RPC status
     */
    void close(@Nullable String message);
  }

  private static final class CloseableServerStreamIterator<T> implements CloseableIterator<T> {

    private final ServerStream<T> stream;
    private final Iterator<T> iterator;

    public CloseableServerStreamIterator(ServerStream<T> stream) {
      this.stream = stream;
      this.iterator = stream.iterator();
    }

    @Override
    public boolean hasNext() {
      try {
        return iterator.hasNext();
      } catch (Exception e) {
        throw SpannerExceptionFactory.newSpannerException(e);
      }
    }

    @Override
    public T next() {
      try {
        return iterator.next();
      } catch (Exception e) {
        throw SpannerExceptionFactory.newSpannerException(e);
      }
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("Not supported: remove.");
    }

    @Override
    public void close(@Nullable String message) {
      try {
        stream.cancel();
      } catch (Exception e) {
        throw SpannerExceptionFactory.newSpannerException(e);
      }
    }
  }

  /** Adapts a streaming read/query call into an iterator over partial result sets. */
  @VisibleForTesting
  static class GrpcStreamIterator extends AbstractIterator<PartialResultSet>
      implements CloseableIterator<PartialResultSet> {
    private static final PartialResultSet END_OF_STREAM = PartialResultSet.newBuilder().build();

    private final ConsumerImpl consumer = new ConsumerImpl();
    private final BlockingQueue<PartialResultSet> stream;

    private SpannerRpc.StreamingCall call;
    private SpannerException error;

    // Visible for testing.
    GrpcStreamIterator(int prefetchChunks) {
      // One extra to allow for END_OF_STREAM message.
      this.stream = new LinkedBlockingQueue<>(prefetchChunks + 1);
    }

    protected final SpannerRpc.ResultStreamConsumer consumer() {
      return consumer;
    }

    public void setCall(SpannerRpc.StreamingCall call) {
      this.call = call;
    }

    @Override
    public void close(@Nullable String message) {
      if (call != null) {
        call.cancel(message);
      }
    }

    @Override
    protected final PartialResultSet computeNext() {
      PartialResultSet next;
      try {
        // TODO: Ideally honor io.grpc.Context while blocking here.  In practice,
        //       cancellation/deadline results in an error being delivered to "stream", which
        //       should mean that we do not block significantly longer afterwards, but it would
        //       be more robust to use poll() with a timeout.
        next = stream.take();
      } catch (InterruptedException e) {
        // Treat interrupt as a request to cancel the read.
        throw SpannerExceptionFactory.propagateInterrupt(e);
      }
      if (next != END_OF_STREAM) {
        call.request(1);
        return next;
      }

      // All done - close() no longer needs to cancel the call.
      call = null;

      if (error != null) {
        throw SpannerExceptionFactory.newSpannerException(error);
      }

      endOfData();
      return null;
    }

    private void addToStream(PartialResultSet results) {
      // We assume that nothing from the user will interrupt gRPC event threads.
      Uninterruptibles.putUninterruptibly(stream, results);
    }

    private class ConsumerImpl implements SpannerRpc.ResultStreamConsumer {
      @Override
      public void onPartialResultSet(PartialResultSet results) {
        addToStream(results);
      }

      @Override
      public void onCompleted() {
        addToStream(END_OF_STREAM);
      }

      @Override
      public void onError(SpannerException e) {
        error = e;
        addToStream(END_OF_STREAM);
      }

      // Visible only for testing.
      @VisibleForTesting
      void setCall(SpannerRpc.StreamingCall call) {
        GrpcStreamIterator.this.setCall(call);
      }
    }
  }

  /**
   * Wraps an iterator over partial result sets, supporting resuming RPCs on error. This class keeps
   * track of the most recent resume token seen, and will buffer partial result set chunks that do
   * not have a resume token until one is seen or buffer space is exceeded, which reduces the chance
   * of yielding data to the caller that cannot be resumed.
   */
  @VisibleForTesting
  abstract static class ResumableStreamIterator extends AbstractIterator<PartialResultSet>
      implements CloseableIterator<PartialResultSet> {
    private final BackOff backOff = newBackOff();
    private final LinkedList<PartialResultSet> buffer = new LinkedList<>();
    private final int maxBufferSize;
    private final Span span;
    private CloseableIterator<PartialResultSet> stream;
    private ByteString resumeToken;
    private boolean finished;
    /**
     * Indicates whether it is currently safe to retry RPCs. This will be {@code false} if we have
     * reached the maximum buffer size without seeing a restart token; in this case, we will drain
     * the buffer and remain in this state until we see a new restart token.
     */
    private boolean safeToRetry = true;

    protected ResumableStreamIterator(int maxBufferSize, String streamName, Span parent) {
      checkArgument(maxBufferSize >= 0);
      this.maxBufferSize = maxBufferSize;
      this.span = tracer.spanBuilderWithExplicitParent(streamName, parent).startSpan();
    }

    abstract CloseableIterator<PartialResultSet> startStream(@Nullable ByteString resumeToken);

    @Override
    public void close(@Nullable String message) {
      if (stream != null) {
        stream.close(message);
      }
    }

    @Override
    protected PartialResultSet computeNext() {
      Context context = Context.current();
      while (true) {
        // Eagerly start stream before consuming any buffered items.
        if (stream == null) {
          span.addAnnotation(
              "Starting/Resuming stream",
              ImmutableMap.of(
                  "ResumeToken",
                  AttributeValue.stringAttributeValue(
                      resumeToken == null ? "null" : resumeToken.toStringUtf8())));
          try (Scope s = tracer.withSpan(span)) {
            // When start a new stream set the Span as current to make the gRPC Span a child of
            // this Span.
            stream = checkNotNull(startStream(resumeToken));
          }
        }
        // Buffer contains items up to a resume token or has reached capacity: flush.
        if (!buffer.isEmpty()
            && (finished || !safeToRetry || !buffer.getLast().getResumeToken().isEmpty())) {
          return buffer.pop();
        }
        try {
          if (stream.hasNext()) {
            PartialResultSet next = stream.next();
            boolean hasResumeToken = !next.getResumeToken().isEmpty();
            if (hasResumeToken) {
              resumeToken = next.getResumeToken();
              safeToRetry = true;
            }
            // If the buffer is empty and this chunk has a resume token or we cannot resume safely
            // anyway, we can yield it immediately rather than placing it in the buffer to be
            // returned on the next iteration.
            if ((hasResumeToken || !safeToRetry) && buffer.isEmpty()) {
              return next;
            }
            buffer.add(next);
            if (buffer.size() > maxBufferSize && buffer.getLast().getResumeToken().isEmpty()) {
              // We need to flush without a restart token.  Errors encountered until we see
              // such a token will fail the read.
              safeToRetry = false;
            }
          } else {
            finished = true;
            if (buffer.isEmpty()) {
              endOfData();
              return null;
            }
          }
        } catch (SpannerException e) {
          if (safeToRetry && e.isRetryable()) {
            span.addAnnotation(
                "Stream broken. Safe to retry", TraceUtil.getExceptionAnnotations(e));
            logger.log(Level.FINE, "Retryable exception, will sleep and retry", e);
            // Truncate any items in the buffer before the last retry token.
            while (!buffer.isEmpty() && buffer.getLast().getResumeToken().isEmpty()) {
              buffer.removeLast();
            }
            assert buffer.isEmpty() || buffer.getLast().getResumeToken().equals(resumeToken);
            stream = null;
            try (Scope s = tracer.withSpan(span)) {
              long delay = e.getRetryDelayInMillis();
              if (delay != -1) {
                backoffSleep(context, delay);
              } else {
                backoffSleep(context, backOff);
              }
            }
            continue;
          }
          span.addAnnotation("Stream broken. Not safe to retry");
          TraceUtil.endSpanWithFailure(span, e);
          throw e;
        } catch (RuntimeException e) {
          span.addAnnotation("Stream broken. Not safe to retry");
          TraceUtil.endSpanWithFailure(span, e);
          throw e;
        }
      }
    }
  }

  /**
   * Adapts a stream of {@code PartialResultSet} messages into a stream of {@code Value} messages.
   */
  private static class GrpcValueIterator extends AbstractIterator<com.google.protobuf.Value> {
    private enum StreamValue {
      METADATA,
      RESULT,
    }

    private final CloseableIterator<PartialResultSet> stream;
    private ResultSetMetadata metadata;
    private Type type;
    private PartialResultSet current;
    private int pos;
    private ResultSetStats statistics;

    GrpcValueIterator(CloseableIterator<PartialResultSet> stream) {
      this.stream = stream;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected com.google.protobuf.Value computeNext() {
      if (!ensureReady(StreamValue.RESULT)) {
        endOfData();
        return null;
      }
      com.google.protobuf.Value value = current.getValues(pos++);
      KindCase kind = value.getKindCase();

      if (!isMergeable(kind)) {
        if (pos == current.getValuesCount() && current.getChunkedValue()) {
          throw newSpannerException(ErrorCode.INTERNAL, "Unexpected chunked PartialResultSet.");
        } else {
          return value;
        }
      }
      if (!current.getChunkedValue() || pos != current.getValuesCount()) {
        return value;
      }

      Object merged =
          kind == KindCase.STRING_VALUE
              ? value.getStringValue()
              : new ArrayList<com.google.protobuf.Value>(value.getListValue().getValuesList());
      while (current.getChunkedValue() && pos == current.getValuesCount()) {
        if (!ensureReady(StreamValue.RESULT)) {
          throw newSpannerException(
              ErrorCode.INTERNAL, "Stream closed in the middle of chunked value");
        }
        com.google.protobuf.Value newValue = current.getValues(pos++);
        if (newValue.getKindCase() != kind) {
          throw newSpannerException(
              ErrorCode.INTERNAL,
              "Unexpected type in middle of chunked value. Expected: "
                  + kind
                  + " but got: "
                  + newValue.getKindCase());
        }
        if (kind == KindCase.STRING_VALUE) {
          merged = (String) merged + newValue.getStringValue();
        } else {
          concatLists(
              (List<com.google.protobuf.Value>) merged, newValue.getListValue().getValuesList());
        }
      }
      if (kind == KindCase.STRING_VALUE) {
        return com.google.protobuf.Value.newBuilder().setStringValue((String) merged).build();
      } else {
        return com.google.protobuf.Value.newBuilder()
            .setListValue(
                ListValue.newBuilder().addAllValues((List<com.google.protobuf.Value>) merged))
            .build();
      }
    }

    ResultSetMetadata getMetadata() throws SpannerException {
      if (metadata == null) {
        if (!ensureReady(StreamValue.METADATA)) {
          throw newSpannerException(ErrorCode.INTERNAL, "Stream closed without sending metadata");
        }
      }
      return metadata;
    }

    /*
     * Get the query statistics. Query statistics are delivered with the last PartialResultSet
     * in the stream. Any attempt to call this method before the caller has finished consuming the
     * results will return null.
     */
    @Nullable
    ResultSetStats getStats() {
      return statistics;
    }

    Type type() {
      checkState(type != null, "metadata has not been received");
      return type;
    }

    private boolean ensureReady(StreamValue requiredValue) throws SpannerException {
      while (current == null || pos >= current.getValuesCount()) {
        if (!stream.hasNext()) {
          return false;
        }
        current = stream.next();
        pos = 0;
        if (type == null) {
          // This is the first message on the stream.
          if (!current.hasMetadata() || !current.getMetadata().hasRowType()) {
            throw newSpannerException(ErrorCode.INTERNAL, "Missing type metadata in first message");
          }
          metadata = current.getMetadata();
          com.google.spanner.v1.Type typeProto =
              com.google.spanner.v1.Type.newBuilder()
                  .setCode(TypeCode.STRUCT)
                  .setStructType(metadata.getRowType())
                  .build();
          try {
            type = Type.fromProto(typeProto);
          } catch (IllegalArgumentException e) {
            throw newSpannerException(
                ErrorCode.INTERNAL, "Invalid type metadata: " + e.getMessage(), e);
          }
        }
        if (current.hasStats()) {
          statistics = current.getStats();
        }
        if (requiredValue == StreamValue.METADATA) {
          return true;
        }
      }
      return true;
    }

    void close(@Nullable String message) {
      stream.close(message);
    }

    /*
     * @param a is a mutable list and b will be concatenated into a.
     */
    private void concatLists(List<com.google.protobuf.Value> a, List<com.google.protobuf.Value> b) {
      if (a.size() == 0 || b.size() == 0) {
        a.addAll(b);
        return;
      } else {
        com.google.protobuf.Value last = a.get(a.size() - 1);
        com.google.protobuf.Value first = b.get(0);
        KindCase lastKind = last.getKindCase();
        KindCase firstKind = first.getKindCase();
        if (isMergeable(lastKind) && lastKind == firstKind) {
          com.google.protobuf.Value merged = null;
          if (lastKind == KindCase.STRING_VALUE) {
            String lastStr = last.getStringValue();
            String firstStr = first.getStringValue();
            merged =
                com.google.protobuf.Value.newBuilder().setStringValue(lastStr + firstStr).build();
          } else { // List
            List<com.google.protobuf.Value> mergedList = new ArrayList<>();
            mergedList.addAll(last.getListValue().getValuesList());
            concatLists(mergedList, first.getListValue().getValuesList());
            merged =
                com.google.protobuf.Value.newBuilder()
                    .setListValue(ListValue.newBuilder().addAllValues(mergedList))
                    .build();
          }
          a.set(a.size() - 1, merged);
          a.addAll(b.subList(1, b.size()));
        } else {
          a.addAll(b);
        }
      }
    }

    private boolean isMergeable(KindCase kind) {
      return kind == KindCase.STRING_VALUE || kind == KindCase.LIST_VALUE;
    }
  }

  private static double valueProtoToFloat64(com.google.protobuf.Value proto) {
    if (proto.getKindCase() == KindCase.STRING_VALUE) {
      switch (proto.getStringValue()) {
        case "-Infinity":
          return Double.NEGATIVE_INFINITY;
        case "Infinity":
          return Double.POSITIVE_INFINITY;
        case "NaN":
          return Double.NaN;
        default:
          // Fall-through to handling below to produce an error.
      }
    }
    if (proto.getKindCase() != KindCase.NUMBER_VALUE) {
      throw newSpannerException(
          ErrorCode.INTERNAL,
          "Invalid value for column type "
              + Type.float64()
              + " expected NUMBER_VALUE or STRING_VALUE with value one of"
              + " \"Infinity\", \"-Infinity\", or \"NaN\" but was "
              + proto.getKindCase()
              + (proto.getKindCase() == KindCase.STRING_VALUE
                  ? " with value \"" + proto.getStringValue() + "\""
                  : ""));
    }
    return proto.getNumberValue();
  }

  private static NullPointerException throwNotNull(int columnIndex) {
    throw new NullPointerException(
        "Cannot call array getter for column " + columnIndex + " with null elements");
  }

  /**
   * Memory-optimized base class for {@code ARRAY<INT64>} and {@code ARRAY<FLOAT64>} types. Both of
   * these involve conversions from the type yielded by JSON parsing, which are {@code String} and
   * {@code BigDecimal} respectively. Rather than construct new wrapper objects for each array
   * element, we use primitive arrays and a {@code BitSet} to track nulls.
   */
  private abstract static class PrimitiveArray<T, A> extends AbstractList<T> {
    private final A data;
    private final BitSet nulls;
    private final int size;

    PrimitiveArray(ListValue protoList) {
      this.size = protoList.getValuesCount();
      A data = newArray(size);
      BitSet nulls = new BitSet(size);
      for (int i = 0; i < protoList.getValuesCount(); ++i) {
        if (protoList.getValues(i).getKindCase() == KindCase.NULL_VALUE) {
          nulls.set(i);
        } else {
          setProto(data, i, protoList.getValues(i));
        }
      }
      this.data = data;
      this.nulls = nulls;
    }

    PrimitiveArray(A data, BitSet nulls, int size) {
      this.data = data;
      this.nulls = nulls;
      this.size = size;
    }

    abstract A newArray(int size);

    abstract void setProto(A array, int i, com.google.protobuf.Value protoValue);

    abstract T get(A array, int i);

    @Override
    public T get(int index) {
      if (index < 0 || index >= size) {
        throw new ArrayIndexOutOfBoundsException("index=" + index + " size=" + size);
      }
      return nulls.get(index) ? null : get(data, index);
    }

    @Override
    public int size() {
      return size;
    }

    A toPrimitiveArray(int columnIndex) {
      if (nulls.length() > 0) {
        throw throwNotNull(columnIndex);
      }
      A r = newArray(size);
      System.arraycopy(data, 0, r, 0, size);
      return r;
    }
  }

  private static class Int64Array extends PrimitiveArray<Long, long[]> {
    Int64Array(ListValue protoList) {
      super(protoList);
    }

    Int64Array(long[] data, BitSet nulls) {
      super(data, nulls, data.length);
    }

    @Override
    long[] newArray(int size) {
      return new long[size];
    }

    @Override
    void setProto(long[] array, int i, com.google.protobuf.Value protoValue) {
      array[i] = Long.parseLong(protoValue.getStringValue());
    }

    @Override
    Long get(long[] array, int i) {
      return array[i];
    }
  }

  private static class Float64Array extends PrimitiveArray<Double, double[]> {
    Float64Array(ListValue protoList) {
      super(protoList);
    }

    Float64Array(double[] data, BitSet nulls) {
      super(data, nulls, data.length);
    }

    @Override
    double[] newArray(int size) {
      return new double[size];
    }

    @Override
    void setProto(double[] array, int i, com.google.protobuf.Value protoValue) {
      array[i] = valueProtoToFloat64(protoValue);
    }

    @Override
    Double get(double[] array, int i) {
      return array[i];
    }
  }
}
