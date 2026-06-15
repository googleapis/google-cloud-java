/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigtable.data.v2.internal.api;

import com.google.api.gax.tracing.BaseApiTracerFactory;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.bigtable.v2.CloseSessionRequest;
import com.google.bigtable.v2.CloseSessionRequest.CloseSessionReason;
import com.google.bigtable.v2.FeatureFlags;
import com.google.bigtable.v2.OpenAuthorizedViewRequest;
import com.google.bigtable.v2.OpenMaterializedViewRequest;
import com.google.bigtable.v2.OpenTableRequest.Permission;
import com.google.cloud.bigtable.data.v2.internal.api.ChannelProviders.ChannelProvider;
import com.google.cloud.bigtable.data.v2.internal.api.ChannelProviders.ConfiguredChannelProvider;
import com.google.cloud.bigtable.data.v2.internal.channels.ChannelPool;
import com.google.cloud.bigtable.data.v2.internal.channels.SwitchingChannelPool;
import com.google.cloud.bigtable.data.v2.internal.csm.MetricRegistry;
import com.google.cloud.bigtable.data.v2.internal.csm.Metrics;
import com.google.cloud.bigtable.data.v2.internal.csm.MetricsImpl;
import com.google.cloud.bigtable.data.v2.internal.csm.NoopMetrics;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.session.BigtableTimer;
import com.google.cloud.bigtable.data.v2.internal.session.NettyWheelTimer;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPool;
import com.google.cloud.bigtable.data.v2.internal.util.ClientConfigurationManager;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.grpc.CallOptions;
import io.opencensus.stats.Stats;
import io.opencensus.tags.Tags;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client implements AutoCloseable {
  private static final Logger logger = Logger.getLogger(Client.class.getName());

  // Per-pool drain budget during close. One full watchdog tick (5 min) plus 1 min buffer; if a
  // pool can't drain in that window, something is genuinely wrong on the server side and we give
  // up on it so close() returns. The watchdog interval is what makes the worst case finite.
  private static final Duration POOL_DRAIN_TIMEOUT = Duration.ofMinutes(6);

  public static final FeatureFlags BASE_FEATURE_FLAGS =
      FeatureFlags.newBuilder()
          .setReverseScans(false)
          .setMutateRowsRateLimit(false)
          .setMutateRowsRateLimit2(false)
          .setLastScannedRowResponses(false)
          .setRoutingCookie(true)
          .setRetryInfo(true)
          .setClientSideMetricsEnabled(true)
          // These are set by the channel provider
          // .setTrafficDirectorEnabled(true)
          // .setDirectAccessRequested(true)
          .setPeerInfo(true)
          .setSessionsCompatible(true)
          .build();
  // gRPC keep-alive interval 60 seconds.
  public static final int KEEPALIVE_TIME_MS = 60000;
  // gRPC keep-alive timeout 10 seconds.
  public static final int KEEPALIVE_TIMEOUT_MS = 10000;

  private final FeatureFlags featureFlags;
  private final ClientInfo clientInfo;
  private final Resource<ScheduledExecutorService> backgroundExecutor;
  // Drains the per-op SerializingExecutor. Cached pool so a blocked user callback does not starve
  // heartbeats, retry delays, or other vRPCs (which all run on backgroundExecutor).
  // TODO: source from the gax TransportChannelProvider so transport and user-callback dispatch
  // share the same pool. Blocked on missing APIs to extract the configured executor from gax.
  private final Resource<ExecutorService> userCallbackExecutor;
  // Hashed-wheel timer for heartbeat / deadline / watchdog / retry scheduling. Built over
  // backgroundExecutor (the timer's tick thread dispatches bodies onto it). Single tick thread per
  // Client, shared across every SessionPoolImpl.
  private final BigtableTimer sessionTimer;

  private final CallOptions defaultCallOptions;
  private final ChannelPool channelPool;
  private final Resource<Metrics> metrics;
  private final Resource<ClientConfigurationManager> configManager;

  private final Set<SessionPool<?>> sessionPools = Collections.newSetFromMap(new WeakHashMap<>());
  // Guarded by sessionPools' monitor: close() sets it before snapshotting the pool set, and the
  // open* methods check it before adding a new pool, so a racing open cannot insert a pool that
  // close() has already missed in its snapshot.
  private boolean closed = false;

  public static Client create(ClientSettings settings) throws IOException {
    FeatureFlags featureFlags =
        settings.getChannelProvider().updateFeatureFlags(BASE_FEATURE_FLAGS);

    ClientInfo clientInfo =
        ClientInfo.builder()
            .setInstanceName(settings.getInstanceName())
            .setAppProfileId(settings.getAppProfileId())
            .build();

    ScheduledExecutorService backgroundExecutor = Executors.newScheduledThreadPool(4);
    ExecutorService userCallbackExecutor =
        Executors.newCachedThreadPool(
            new ThreadFactoryBuilder()
                .setNameFormat("bigtable-callback-%d")
                .setDaemon(true)
                .build());

    // TODO: compat layer: get this from settings
    String universeDomain = "googleapis.com";

    Metrics metrics;
    if (settings.getChannelProvider() instanceof ChannelProviders.EmulatorChannelProvider) {
      metrics = new NoopMetrics();
    } else {
      GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
      MetricRegistry registry = new MetricRegistry();
      OpenTelemetrySdk otel =
          MetricsImpl.createBuiltinOtel(
              registry, clientInfo, credentials, null, universeDomain, backgroundExecutor);
      metrics =
          new MetricsImpl(
              registry,
              clientInfo,
              BaseApiTracerFactory.getInstance(),
              otel,
              null,
              Tags.getTagger(),
              Stats.getStatsRecorder(),
              backgroundExecutor);
      metrics.start();
    }

    ClientConfigurationManager configManager = null;

    try {
      configManager =
          new ClientConfigurationManager(
              featureFlags,
              clientInfo,
              settings.getChannelProvider(),
              metrics.getDebugTagTracer(),
              backgroundExecutor);
      configManager.start().get();
      metrics.getDebugTagTracer().setClientConfigurationManager(configManager);
    } catch (Exception e) {
      if (e instanceof InterruptedException) {
        Thread.currentThread().interrupt();
      }
      if (configManager != null) {
        configManager.close();
      }
      metrics.close();
      backgroundExecutor.shutdown();
      userCallbackExecutor.shutdown();
      throw new RuntimeException("Failed to fetch initial config", e);
    }

    if (configManager.areSessionsRequired()) {
      featureFlags = featureFlags.toBuilder().setSessionsCompatible(true).build();
    }

    return new Client(
        featureFlags,
        clientInfo,
        settings.getChannelProvider(),
        Resource.createOwned(metrics, metrics::close),
        Resource.createOwned(configManager, configManager::close),
        Resource.createOwned(backgroundExecutor, backgroundExecutor::shutdown),
        Resource.createOwned(userCallbackExecutor, () -> shutdownAndAwait(userCallbackExecutor)));
  }

  public Client(
      FeatureFlags featureFlags,
      ClientInfo clientInfo,
      ChannelProvider channelProvider,
      Resource<Metrics> metrics,
      Resource<ClientConfigurationManager> configManager,
      Resource<ScheduledExecutorService> bgExecutor,
      Resource<ExecutorService> userCallbackExecutor)
      throws IOException {
    this.featureFlags = featureFlags;
    this.clientInfo = clientInfo;
    this.metrics = metrics;
    this.configManager = configManager;
    this.backgroundExecutor = bgExecutor;
    this.userCallbackExecutor = userCallbackExecutor;
    // Timer's tick thread dispatches bodies onto backgroundExecutor — tick-thread-blocking work
    // (anything that takes a pool lock) gets handed off there instead of stalling the wheel.
    this.sessionTimer = new NettyWheelTimer("bigtable-session-timer", bgExecutor.get());

    defaultCallOptions = CallOptions.DEFAULT;

    ChannelProvider configuredChannelProvider =
        new ConfiguredChannelProvider(
            channelProvider,
            channelBuilder ->
                metrics
                    .get()
                    .configureGrpcChannel(channelBuilder)
                    .keepAliveTime(KEEPALIVE_TIME_MS, TimeUnit.MILLISECONDS)
                    .keepAliveTimeout(KEEPALIVE_TIMEOUT_MS, TimeUnit.MILLISECONDS)
                    // TODO: consider localizing this for large reads
                    .maxInboundMessageSize(256 * 1024 * 1024));

    channelPool =
        new SwitchingChannelPool(
            configuredChannelProvider,
            configManager.get(),
            metrics.get(),
            backgroundExecutor.get());
    channelPool.start();
  }

  @Override
  public void close() {
    List<SessionPool<?>> toClose;
    synchronized (sessionPools) {
      if (closed) {
        return; // idempotent
      }
      closed = true;
      toClose = new ArrayList<>(sessionPools);
    }

    CloseSessionRequest closeReq =
        CloseSessionRequest.newBuilder()
            .setReason(CloseSessionReason.CLOSE_SESSION_REASON_USER)
            .setDescription("Client closing")
            .build();

    // Phase 1: initiate graceful close on each pool. Returns immediately; sessions transition
    // CLOSING → graceful CloseSessionRequest → WAIT_SERVER_CLOSE → CLOSED asynchronously.
    toClose.forEach(p -> p.close(closeReq));

    // Phase 2: wait for sessions to drain. The pool's watchdog stays alive during this wait and
    // escalates anything stuck in WAIT_SERVER_CLOSE longer than its tick interval (5 min). Once
    // a pool's last session reaches CLOSED, drainedFuture completes and awaitTerminated returns.
    // Sequential: worst case is POOL_DRAIN_TIMEOUT * N pools, but the happy path drains in << 1s.
    for (SessionPool<?> pool : toClose) {
      try {
        if (!pool.awaitTerminated(POOL_DRAIN_TIMEOUT)) {
          logger.warning(
              "SessionPool did not drain within "
                  + POOL_DRAIN_TIMEOUT
                  + "; abandoning and continuing shutdown");
        }
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        logger.log(Level.WARNING, "Interrupted while draining SessionPool", e);
        break;
      }
    }

    // Phase 3: tear down infrastructure.
    //
    // sessionTimer.stop() runs FIRST so its onStop hooks can drive any pending Scheduled retries
    // to a terminal Done — that delivery hops through op executor → userCallbackExecutor, both
    // of which must still be alive at this moment.
    //
    // userCallbackExecutor.close() next, with a 5s drain to catch the listener.onClose tasks
    // queued by both the session drain (Phase 2) and the just-fired retry shutdowns.
    //
    // backgroundExecutor must close last because it's the timer's dispatcher and the op
    // executor's chain ultimately runs ScheduledExecutorService tasks here.
    sessionTimer.stop();
    userCallbackExecutor.close();
    metrics.close();
    channelPool.close();
    configManager.close();
    backgroundExecutor.close();
  }

  // The closed check and pool insertion run under sessionPools' monitor so close() (which flips
  // closed under the same monitor) cannot snapshot the pool set between our check and our insert.
  // Opens are infrequent (typically once per table at app startup), so holding the monitor across
  // createAndStart is acceptable.
  public TableAsync openTableAsync(String tableId, Permission permission) {
    synchronized (sessionPools) {
      if (closed) {
        throw new IllegalStateException("Client is closed");
      }
      TableAsync tableAsync =
          TableAsync.createAndStart(
              featureFlags,
              clientInfo,
              configManager.get(),
              channelPool,
              defaultCallOptions,
              tableId,
              permission,
              metrics.get(),
              sessionTimer,
              userCallbackExecutor.get());
      sessionPools.add(tableAsync.getSessionPool());
      return tableAsync;
    }
  }

  public AuthorizedViewAsync openAuthorizedViewAsync(
      String tableId, String viewId, OpenAuthorizedViewRequest.Permission permission) {
    synchronized (sessionPools) {
      if (closed) {
        throw new IllegalStateException("Client is closed");
      }
      AuthorizedViewAsync viewAsync =
          AuthorizedViewAsync.createAndStart(
              featureFlags,
              clientInfo,
              configManager.get(),
              channelPool,
              defaultCallOptions,
              tableId,
              viewId,
              permission,
              metrics.get(),
              sessionTimer,
              userCallbackExecutor.get());
      sessionPools.add(viewAsync.getSessionPool());
      return viewAsync;
    }
  }

  public MaterializedViewAsync openMaterializedViewAsync(
      String viewId, OpenMaterializedViewRequest.Permission permission) {
    synchronized (sessionPools) {
      if (closed) {
        throw new IllegalStateException("Client is closed");
      }
      MaterializedViewAsync viewAsync =
          MaterializedViewAsync.createAndStart(
              featureFlags,
              clientInfo,
              configManager.get(),
              channelPool,
              defaultCallOptions,
              viewId,
              permission,
              metrics.get(),
              sessionTimer,
              userCallbackExecutor.get());
      sessionPools.add(viewAsync.getSessionPool());
      return viewAsync;
    }
  }

  public static class Resource<T> {
    private final T value;
    private final Runnable closer;
    private final java.util.concurrent.atomic.AtomicBoolean closed =
        new java.util.concurrent.atomic.AtomicBoolean(false);

    public static <T> Resource<T> createOwned(T value, Runnable closer) {
      return new Resource<>(value, closer);
    }

    public static <T> Resource<T> createShared(T value) {
      return new Resource<>(value, () -> {});
    }

    private Resource(T value, Runnable closer) {
      this.value = value;
      this.closer = closer;
    }

    /** Idempotent. Repeat calls are no-ops. */
    public void close() {
      if (closed.compareAndSet(false, true)) {
        this.closer.run();
      }
    }

    public T get() {
      return value;
    }
  }

  // Drain in-flight listener.onClose tasks before the executor is shut down; bound the wait at 5s
  // so close() doesn't hang the caller on a pathological listener. Public so the compat
  // ShimImpl (different package) can reuse the same shutdown semantics for the user-callback
  // executor it owns.
  public static void shutdownAndAwait(ExecutorService exec) {
    exec.shutdown();
    try {
      if (!exec.awaitTermination(5, TimeUnit.SECONDS)) {
        exec.shutdownNow();
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      exec.shutdownNow();
    }
  }
}
