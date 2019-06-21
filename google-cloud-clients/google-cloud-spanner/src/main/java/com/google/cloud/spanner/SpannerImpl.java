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
import com.google.cloud.BaseService;
import com.google.cloud.PageImpl;
import com.google.cloud.PageImpl.NextPageFetcher;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.cloud.spanner.spi.v1.SpannerRpc.Paginated;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.Context;
import io.opencensus.common.Scope;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.Span;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.Tracing;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
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

  private static final Logger logger = Logger.getLogger(SpannerImpl.class.getName());
  private static final Tracer tracer = Tracing.getTracer();

  private static final String CREATE_SESSION = "CloudSpannerOperation.CreateSession";
  static final String DELETE_SESSION = "CloudSpannerOperation.DeleteSession";
  static final String BEGIN_TRANSACTION = "CloudSpannerOperation.BeginTransaction";
  static final String COMMIT = "CloudSpannerOperation.Commit";
  static final String QUERY = "CloudSpannerOperation.ExecuteStreamingQuery";
  static final String READ = "CloudSpannerOperation.ExecuteStreamingRead";

  static {
    TraceUtil.exportSpans(CREATE_SESSION, DELETE_SESSION, BEGIN_TRANSACTION, COMMIT, QUERY, READ);
  }

  private final Random random = new Random();
  private final SpannerRpc gapicRpc;

  @GuardedBy("this")
  private final Map<DatabaseId, DatabaseClientImpl> dbClients = new HashMap<>();

  private final DatabaseAdminClient dbAdminClient;
  private final InstanceAdminClient instanceClient;

  @GuardedBy("this")
  private boolean spannerIsClosed = false;

  @VisibleForTesting
  SpannerImpl(SpannerRpc gapicRpc, SpannerOptions options) {
    super(options);
    this.gapicRpc = gapicRpc;
    this.dbAdminClient = new DatabaseAdminClientImpl(options.getProjectId(), gapicRpc);
    this.instanceClient =
        new InstanceAdminClientImpl(options.getProjectId(), gapicRpc, dbAdminClient);
  }

  SpannerImpl(SpannerOptions options) {
    this(options.getSpannerRpcV1(), options);
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

  /** Returns the {@link SpannerRpc} of this {@link SpannerImpl} instance. */
  SpannerRpc getRpc() {
    return gapicRpc;
  }

  /** Returns the default setting for prefetchChunks of this {@link SpannerImpl} instance. */
  int getDefaultPrefetchChunks() {
    return getOptions().getPrefetchChunks();
  }

  SessionImpl createSession(final DatabaseId db) throws SpannerException {
    final Map<SpannerRpc.Option, ?> options =
        optionMap(SessionOption.channelHint(random.nextLong()));
    Span span = tracer.spanBuilder(CREATE_SESSION).startSpan();
    try (Scope s = tracer.withSpan(span)) {
      com.google.spanner.v1.Session session =
          gapicRpc.createSession(db.getName(), getOptions().getSessionLabels(), options);
      span.end();
      return new SessionImpl(this, session.getName(), options);
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    }
  }

  SessionImpl sessionWithId(String name) {
    final Map<SpannerRpc.Option, ?> options =
        SpannerImpl.optionMap(SessionOption.channelHint(random.nextLong()));
    return new SessionImpl(this, name, options);
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
        DatabaseClientImpl dbClient = createDatabaseClient(pool);
        dbClients.put(db, dbClient);
        return dbClient;
      }
    }
  }

  @VisibleForTesting
  DatabaseClientImpl createDatabaseClient(SessionPool pool) {
    return new DatabaseClientImpl(pool);
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
      return new PageImpl<S>(this, nextPageToken, results);
    }

    void setNextPageToken(String nextPageToken) {
      this.nextPageToken = nextPageToken;
    }

    abstract Paginated<T> getNextPage(@Nullable String nextPageToken);

    abstract S fromProto(T proto);
  }

  private enum DirectExecutor implements Executor {
    INSTANCE;

    @Override
    public void execute(Runnable command) {
      command.run();
    }
  }
}
