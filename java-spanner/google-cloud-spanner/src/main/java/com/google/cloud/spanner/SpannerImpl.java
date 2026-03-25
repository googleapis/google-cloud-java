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

import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.paging.Page;
import com.google.cloud.BaseService;
import com.google.cloud.PageImpl;
import com.google.cloud.PageImpl.NextPageFetcher;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.spanner.SessionClient.SessionId;
import com.google.cloud.spanner.SpannerOptions.CloseableExecutorProvider;
import com.google.cloud.spanner.admin.database.v1.stub.DatabaseAdminStubSettings;
import com.google.cloud.spanner.admin.instance.v1.stub.InstanceAdminStubSettings;
import com.google.cloud.spanner.spi.v1.GapicSpannerRpc;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.cloud.spanner.spi.v1.SpannerRpc.Paginated;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.spanner.v1.ExecuteSqlRequest.QueryOptions;
import io.opencensus.trace.Tracing;
import io.opentelemetry.api.common.Attributes;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/** Default implementation of the Cloud Spanner interface. */
class SpannerImpl extends BaseService<SpannerOptions> implements Spanner {
  private static final Logger logger = Logger.getLogger(SpannerImpl.class.getName());
  final TraceWrapper tracer =
      new TraceWrapper(
          Tracing.getTracer(),
          getOptions()
              .getOpenTelemetry()
              .getTracer(
                  MetricRegistryConstants.INSTRUMENTATION_SCOPE,
                  GaxProperties.getLibraryVersion(this.getOptions().getClass())),
          getOptions().isEnableExtendedTracing());

  static final String CREATE_MULTIPLEXED_SESSION = "CloudSpannerOperation.CreateMultiplexedSession";
  static final String CREATE_SESSION = "CloudSpannerOperation.CreateSession";
  static final String BATCH_CREATE_SESSIONS = "CloudSpannerOperation.BatchCreateSessions";
  static final String BATCH_CREATE_SESSIONS_REQUEST =
      "CloudSpannerOperation.BatchCreateSessionsRequest";
  static final String DELETE_SESSION = "CloudSpannerOperation.DeleteSession";
  static final String BEGIN_TRANSACTION = "CloudSpannerOperation.BeginTransaction";
  static final String COMMIT = "CloudSpannerOperation.Commit";
  static final String QUERY = "CloudSpannerOperation.ExecuteStreamingQuery";
  static final String READ = "CloudSpannerOperation.ExecuteStreamingRead";
  static final String BATCH_WRITE = "CloudSpannerOperation.BatchWrite";
  static final String UPDATE = "CloudSpannerOperation.ExecuteUpdate";
  static final String BATCH_UPDATE = "CloudSpannerOperation.BatchUpdate";

  private static final Object CLIENT_ID_LOCK = new Object();

  @GuardedBy("CLIENT_ID_LOCK")
  private static final Map<DatabaseId, Long> CLIENT_IDS = new HashMap<>();

  private static String nextDatabaseClientId(DatabaseId databaseId) {
    synchronized (CLIENT_ID_LOCK) {
      Long id = CLIENT_IDS.get(databaseId);
      if (id == null) {
        id = 1L;
      } else {
        id++;
      }
      CLIENT_IDS.put(databaseId, id);
      return String.format("client-%d", id);
    }
  }

  private final SpannerRpc gapicRpc;

  @GuardedBy("this")
  private final Map<DatabaseId, DatabaseClientImpl> dbClients = new HashMap<>();

  @GuardedBy("dbBatchClientLock")
  private final Map<DatabaseId, BatchClientImpl> dbBatchClients = new HashMap<>();

  private final ReentrantLock dbBatchClientLock = new ReentrantLock();

  private final CloseableExecutorProvider asyncExecutorProvider;

  @GuardedBy("this")
  private final Map<DatabaseId, SessionClient> sessionClients = new HashMap<>();

  private final DatabaseAdminClient dbAdminClient;
  private final InstanceAdminClient instanceClient;

  /**
   * Exception class used to track the stack trace at the point when a Spanner instance is closed.
   * This exception will be thrown if a user tries to use any resources that were returned by this
   * Spanner instance after the instance has been closed. This makes it easier to track down the
   * code that (accidentally) closed the Spanner instance.
   */
  static final class ClosedException extends RuntimeException {
    private static final long serialVersionUID = 1451131180314064914L;

    ClosedException() {
      super("Spanner client was closed at " + Instant.now());
    }
  }

  @GuardedBy("this")
  private ClosedException closedException;

  @VisibleForTesting
  SpannerImpl(SpannerRpc gapicRpc, SpannerOptions options) {
    super(options);
    this.gapicRpc = gapicRpc;
    this.asyncExecutorProvider =
        MoreObjects.firstNonNull(
            options.getAsyncExecutorProvider(),
            SpannerOptions.createDefaultAsyncExecutorProvider());
    this.dbAdminClient = new DatabaseAdminClientImpl(options.getProjectId(), gapicRpc);
    this.instanceClient =
        new InstanceAdminClientImpl(options.getProjectId(), gapicRpc, dbAdminClient);
    logSpannerOptions(options);
  }

  SpannerImpl(SpannerOptions options) {
    this(options.getSpannerRpcV1(), options);
  }

  private void logSpannerOptions(SpannerOptions options) {
    logger.log(
        Level.INFO,
        "Spanner options: "
            + "\nProject ID: "
            + options.getProjectId()
            + "\nHost: "
            + options.getHost()
            + "\nNum gRPC channels: "
            + options.getNumChannels()
            + "\nLeader aware routing enabled: "
            + options.isLeaderAwareRoutingEnabled()
            + "\nDirect access enabled: "
            + options.isEnableDirectAccess()
            + "\nActive Tracing Framework: "
            + SpannerOptions.getActiveTracingFramework()
            + "\nAPI tracing enabled: "
            + options.isEnableApiTracing()
            + "\nExtended tracing enabled: "
            + options.isEnableExtendedTracing()
            + "\nEnd to end tracing enabled: "
            + options.isEndToEndTracingEnabled()
            + "\nBuilt-in metrics enabled: "
            + options.isEnableBuiltInMetrics());
    if (options.getSessionPoolOptions() != null) {
      logger.log(
          Level.INFO,
          "Session pool options (deprecated, no longer used): "
              + "\nSession pool min sessions: "
              + options.getSessionPoolOptions().getMinSessions()
              + "\nSession pool max sessions: "
              + options.getSessionPoolOptions().getMaxSessions()
              + "\nMultiplexed sessions enabled: "
              + options.getSessionPoolOptions().getUseMultiplexedSession()
              + "\nMultiplexed sessions enabled for RW: "
              + options.getSessionPoolOptions().getUseMultiplexedSessionForRW()
              + "\nMultiplexed sessions enabled for blind write: "
              + options.getSessionPoolOptions().getUseMultiplexedSessionBlindWrite()
              + "\nMultiplexed sessions enabled for partitioned ops: "
              + options.getSessionPoolOptions().getUseMultiplexedSessionPartitionedOps());
    }
  }

  /** Returns the {@link SpannerRpc} of this {@link SpannerImpl} instance. */
  SpannerRpc getRpc() {
    return gapicRpc;
  }

  /** Returns the default setting for prefetchChunks of this {@link SpannerImpl} instance. */
  int getDefaultPrefetchChunks() {
    return getOptions().getPrefetchChunks();
  }

  DecodeMode getDefaultDecodeMode() {
    return getOptions().getDecodeMode();
  }

  /** Returns the default query options that should be used for the specified database. */
  QueryOptions getDefaultQueryOptions(DatabaseId databaseId) {
    return getOptions().getDefaultQueryOptions(databaseId);
  }

  TraceWrapper getTracer() {
    return this.tracer;
  }

  /**
   * Returns the {@link ExecutorProvider} to use for async methods that need a background executor.
   */
  public ExecutorProvider getAsyncExecutorProvider() {
    return asyncExecutorProvider;
  }

  SessionImpl sessionWithId(String name) {
    Preconditions.checkArgument(!Strings.isNullOrEmpty(name), "name is null or empty");
    SessionId id = SessionId.of(name);
    return getSessionClient(id.getDatabaseId()).sessionWithId(name);
  }

  void checkClosed() {
    synchronized (this) {
      if (closedException != null) {
        throw new IllegalStateException("Cloud Spanner client has been closed", closedException);
      }
    }
  }

  SessionClient getSessionClient(DatabaseId db) {
    synchronized (this) {
      checkClosed();
      if (sessionClients.containsKey(db)) {
        return sessionClients.get(db);
      } else {
        SessionClient client =
            new SessionClient(
                this,
                db,
                ((GrpcTransportOptions) getOptions().getTransportOptions()).getExecutorFactory());
        sessionClients.put(db, client);
        return client;
      }
    }
  }

  @Override
  public DatabaseAdminClient getDatabaseAdminClient() {
    return dbAdminClient;
  }

  @Override
  public com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient
      createDatabaseAdminClient() {
    try {
      final DatabaseAdminStubSettings settings =
          Preconditions.checkNotNull(gapicRpc.getDatabaseAdminStubSettings());
      return com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.create(
          settings.createStub());
    } catch (IOException ex) {
      throw SpannerExceptionFactory.newSpannerException(ex);
    }
  }

  @Override
  public InstanceAdminClient getInstanceAdminClient() {
    return instanceClient;
  }

  @Override
  public com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient
      createInstanceAdminClient() {
    try {
      final InstanceAdminStubSettings settings =
          Preconditions.checkNotNull(gapicRpc.getInstanceAdminStubSettings());
      return com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient.create(
          settings.createStub());
    } catch (IOException ex) {
      throw SpannerExceptionFactory.newSpannerException(ex);
    }
  }

  @Override
  public DatabaseClient getDatabaseClient(DatabaseId db) {
    synchronized (this) {
      checkClosed();
      String clientId = null;
      if (dbClients.containsKey(db) && !dbClients.get(db).isValid()) {
        // Close the invalidated client and remove it.
        dbClients.get(db).closeAsync(new ClosedException());
        clientId = dbClients.get(db).clientId;
        dbClients.remove(db);
      }
      if (dbClients.containsKey(db)) {
        return dbClients.get(db);
      } else {
        if (clientId == null) {
          clientId = nextDatabaseClientId(db);
        }
        MultiplexedSessionDatabaseClient multiplexedSessionDatabaseClient =
            new MultiplexedSessionDatabaseClient(SpannerImpl.this.getSessionClient(db));
        DatabaseClientImpl dbClient =
            createDatabaseClient(
                clientId,
                multiplexedSessionDatabaseClient,
                this.tracer.createDatabaseAttributes(db));
        dbClients.put(db, dbClient);
        return dbClient;
      }
    }
  }

  @VisibleForTesting
  DatabaseClientImpl createDatabaseClient(
      String clientId,
      MultiplexedSessionDatabaseClient multiplexedSessionClient,
      Attributes databaseAttributes) {
    return new DatabaseClientImpl(clientId, multiplexedSessionClient, tracer, databaseAttributes);
  }

  @Override
  public BatchClient getBatchClient(DatabaseId db) {
    this.dbBatchClientLock.lock();
    try {
      if (this.dbBatchClients.containsKey(db)) {
        return this.dbBatchClients.get(db);
      }
      BatchClientImpl batchClient = new BatchClientImpl(getSessionClient(db));
      this.dbBatchClients.put(db, batchClient);
      return batchClient;
    } finally {
      this.dbBatchClientLock.unlock();
    }
  }

  @Override
  public void close() {
    close(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
  }

  void close(long timeout, TimeUnit unit) {
    List<ListenableFuture<Void>> closureFutures;
    synchronized (this) {
      checkClosed();
      closedException = new ClosedException();
    }
    try {
      closureFutures = new ArrayList<>();
      for (DatabaseClientImpl dbClient : dbClients.values()) {
        closureFutures.add(dbClient.closeAsync(closedException));
      }
      dbClients.clear();
      Futures.successfulAsList(closureFutures).get(timeout, unit);
    } catch (InterruptedException | ExecutionException | TimeoutException e) {
      throw SpannerExceptionFactory.newSpannerException(e);
    } finally {
      for (SessionClient sessionClient : sessionClients.values()) {
        sessionClient.close();
      }
      sessionClients.clear();
      asyncExecutorProvider.close();
      try {
        if (timeout == Long.MAX_VALUE || !(gapicRpc instanceof GapicSpannerRpc)) {
          gapicRpc.shutdown();
        } else {
          ((GapicSpannerRpc) gapicRpc).shutdownNow();
        }
      } catch (RuntimeException e) {
        logger.log(Level.WARNING, "Failed to close channels", e);
      }
    }
  }

  @Override
  public boolean isClosed() {
    synchronized (this) {
      return closedException != null;
    }
  }

  void resetRequestIdCounters() {
    gapicRpc.getRequestIdCreator().reset();
  }

  long getRequestIdClientId() {
    return gapicRpc.getRequestIdCreator().getClientId();
  }

  /** Helper class for gRPC calls that can return paginated results. */
  abstract static class PageFetcher<S, T> implements NextPageFetcher<S> {
    private String nextPageToken;

    @Override
    public Page<S> getNextPage() {
      Paginated<T> nextPage = getNextPage(nextPageToken);
      this.nextPageToken = nextPage.getNextPageToken();
      List<S> results = new ArrayList<>();
      for (T proto : nextPage.getResults()) {
        results.add(fromProto(proto));
      }
      return new PageImpl<>(this, nextPageToken, results);
    }

    void setNextPageToken(String nextPageToken) {
      this.nextPageToken = nextPageToken;
    }

    abstract Paginated<T> getNextPage(@Nullable String nextPageToken);

    abstract S fromProto(T proto);
  }
}
