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
import com.google.cloud.bigtable.data.v2.internal.session.SessionPool;
import com.google.cloud.bigtable.data.v2.internal.util.ClientConfigurationManager;
import io.grpc.CallOptions;
import io.opencensus.stats.Stats;
import io.opencensus.tags.Tags;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Client implements AutoCloseable {
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

  private final CallOptions defaultCallOptions;
  private final ChannelPool channelPool;
  private final Resource<Metrics> metrics;
  private final Resource<ClientConfigurationManager> configManager;

  private final Set<SessionPool<?>> sessionPools = Collections.newSetFromMap(new WeakHashMap<>());

  public static Client create(ClientSettings settings) throws IOException {
    FeatureFlags featureFlags =
        settings.getChannelProvider().updateFeatureFlags(BASE_FEATURE_FLAGS);

    ClientInfo clientInfo =
        ClientInfo.builder()
            .setInstanceName(settings.getInstanceName())
            .setAppProfileId(settings.getAppProfileId())
            .build();

    ScheduledExecutorService backgroundExecutor = Executors.newScheduledThreadPool(4);

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
        Resource.createOwned(backgroundExecutor, backgroundExecutor::shutdown));
  }

  public Client(
      FeatureFlags featureFlags,
      ClientInfo clientInfo,
      ChannelProvider channelProvider,
      Resource<Metrics> metrics,
      Resource<ClientConfigurationManager> configManager,
      Resource<ScheduledExecutorService> bgExecutor)
      throws IOException {
    this.featureFlags = featureFlags;
    this.clientInfo = clientInfo;
    this.metrics = metrics;
    this.configManager = configManager;
    this.backgroundExecutor = bgExecutor;

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
    sessionPools.forEach(
        pool ->
            pool.close(
                CloseSessionRequest.newBuilder()
                    .setReason(CloseSessionReason.CLOSE_SESSION_REASON_USER)
                    .setDescription("Client closing")
                    .build()));
    metrics.close();
    channelPool.close();
    configManager.close();
    backgroundExecutor.close();
  }

  public TableAsync openTableAsync(String tableId, Permission permission) {
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
            backgroundExecutor.get());
    sessionPools.add(tableAsync.getSessionPool());
    return tableAsync;
  }

  public AuthorizedViewAsync openAuthorizedViewAsync(
      String tableId, String viewId, OpenAuthorizedViewRequest.Permission permission) {
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
            backgroundExecutor.get());
    sessionPools.add(viewAsync.getSessionPool());
    return viewAsync;
  }

  public MaterializedViewAsync openMaterializedViewAsync(
      String viewId, OpenMaterializedViewRequest.Permission permission) {
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
            backgroundExecutor.get());
    sessionPools.add(viewAsync.getSessionPool());
    return viewAsync;
  }

  public static class Resource<T> {
    private T value;
    private Runnable closer;

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

    public void close() {
      this.closer.run();
    }

    public T get() {
      return value;
    }
  }
}
