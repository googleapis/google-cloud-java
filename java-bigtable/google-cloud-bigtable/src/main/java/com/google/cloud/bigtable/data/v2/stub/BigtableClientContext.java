/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub;

import com.google.api.core.ApiFunction;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.core.FixedExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.auth.Credentials;
import com.google.auth.oauth2.ServiceAccountJwtAccessCredentials;
import com.google.cloud.bigtable.data.v2.internal.JwtCredentialsWithAudience;
import com.google.cloud.bigtable.data.v2.internal.api.InstanceName;
import com.google.cloud.bigtable.data.v2.internal.compat.DisabledShim;
import com.google.cloud.bigtable.data.v2.internal.compat.Shim;
import com.google.cloud.bigtable.data.v2.internal.compat.ShimImpl;
import com.google.cloud.bigtable.data.v2.internal.csm.MetricRegistry;
import com.google.cloud.bigtable.data.v2.internal.csm.Metrics;
import com.google.cloud.bigtable.data.v2.internal.csm.MetricsImpl;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.dp.AlwaysEnabledDirectAccessChecker;
import com.google.cloud.bigtable.data.v2.internal.dp.ClassicDirectAccessChecker;
import com.google.cloud.bigtable.data.v2.internal.dp.DirectAccessChecker;
import com.google.cloud.bigtable.data.v2.internal.dp.NoopDirectAccessChecker;
import com.google.cloud.bigtable.data.v2.stub.metrics.CustomOpenTelemetryMetricsProvider;
import com.google.cloud.bigtable.gaxx.grpc.BigtableTransportChannelProvider;
import com.google.cloud.bigtable.gaxx.grpc.ChannelPrimer;
import com.google.common.annotations.VisibleForTesting;
import io.grpc.ManagedChannelBuilder;
import io.opencensus.stats.Stats;
import io.opencensus.stats.StatsRecorder;
import io.opencensus.tags.Tagger;
import io.opencensus.tags.Tags;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/**
 * This class wraps all state needed during the lifetime of the Bigtable client. This includes gax's
 * {@link ClientContext} plus any additional state that Bigtable Client needs.
 */
@InternalApi
public class BigtableClientContext {

  private static final Logger logger = Logger.getLogger(BigtableClientContext.class.getName());

  private final boolean isChild;
  private final ClientInfo clientInfo;
  private final Metrics metrics;
  private final ClientContext clientContext;
  // the background executor shared for OTEL instances and monitoring client and all other
  // background tasks
  private final ExecutorProvider backgroundExecutorProvider;
  private final Shim sessionShim;

  @InternalApi("Visible for testing")
  @VisibleForTesting
  @FunctionalInterface
  public interface BuiltinOtelFactory {
    @Nullable
    OpenTelemetrySdk create(
        MetricRegistry metricRegistry,
        ClientInfo clientInfo,
        @Nullable Credentials defaultCredentials,
        @Nullable String metricsEndpoint,
        String universeDomain,
        ScheduledExecutorService executor)
        throws IOException;
  }

  public static BigtableClientContext create(EnhancedBigtableStubSettings settings)
      throws IOException {
    return create(
        settings, Tags.getTagger(), Stats.getStatsRecorder(), MetricsImpl::createBuiltinOtel);
  }

  /**
   * @deprecated This method was only intended for internal testing and was accidentally exposed.
   *     Use {@link #create(EnhancedBigtableStubSettings)} instead.
   */
  @Deprecated
  public static BigtableClientContext create(
      EnhancedBigtableStubSettings settings, Tagger ocTagger, StatsRecorder ocRecorder)
      throws IOException {
    return create(settings, ocTagger, ocRecorder, MetricsImpl::createBuiltinOtel);
  }

  @InternalApi("Visible for testing")
  @VisibleForTesting
  public static BigtableClientContext create(
      EnhancedBigtableStubSettings settings,
      Tagger ocTagger,
      StatsRecorder ocRecorder,
      BuiltinOtelFactory builtinOtelFactory)
      throws IOException {
    ClientInfo clientInfo =
        ClientInfo.builder()
            .setInstanceName(InstanceName.of(settings.getProjectId(), settings.getInstanceId()))
            .setAppProfileId(settings.getAppProfileId())
            .build();

    EnhancedBigtableStubSettings.Builder builder = settings.toBuilder();

    // Fix the credentials so that they can be shared
    @Nullable Credentials credentials = null;
    if (builder.getCredentialsProvider() != null) {
      credentials = builder.getCredentialsProvider().getCredentials();
    }
    @Nullable Credentials dataCredentials = patchCredentials(builder.getJwtAudience(), credentials);
    builder.setCredentialsProvider(FixedCredentialsProvider.create(dataCredentials));

    String universeDomain = settings.getUniverseDomain();

    boolean shouldAutoClose = settings.getBackgroundExecutorProvider().shouldAutoClose();
    ScheduledExecutorService backgroundExecutor =
        settings.getBackgroundExecutorProvider().getExecutor();
    FixedExecutorProvider executorProvider =
        FixedExecutorProvider.create(backgroundExecutor, shouldAutoClose);
    builder.setBackgroundExecutorProvider(executorProvider);

    MetricRegistry metricRegistry = new MetricRegistry();
    // Set up OpenTelemetry
    @Nullable OpenTelemetry userOtel = null;
    if (settings.getMetricsProvider() instanceof CustomOpenTelemetryMetricsProvider) {
      userOtel =
          ((CustomOpenTelemetryMetricsProvider) settings.getMetricsProvider()).getOpenTelemetry();
    }

    @Nullable OpenTelemetrySdk builtinOtel = null;
    try {
      if (settings.areInternalMetricsEnabled()) {
        builtinOtel =
            builtinOtelFactory.create(
                metricRegistry,
                clientInfo,
                credentials,
                settings.getMetricsEndpoint(),
                universeDomain,
                backgroundExecutor);
      }
    } catch (Throwable t) {
      logger.log(Level.WARNING, "Failed to get OTEL, will skip exporting client side metrics", t);
    }

    Metrics metrics =
        new MetricsImpl(
            metricRegistry,
            clientInfo,
            settings.getTracerFactory(),
            builtinOtel,
            userOtel,
            ocTagger,
            ocRecorder,
            backgroundExecutor);

    // Set up channel
    InstantiatingGrpcChannelProvider.Builder transportProvider =
        builder.getTransportChannelProvider() instanceof InstantiatingGrpcChannelProvider
            ? ((InstantiatingGrpcChannelProvider) builder.getTransportChannelProvider()).toBuilder()
            : null;

    if (transportProvider != null) {
      configureGrpcOtel(transportProvider, metrics);

      setupCookieHolder(transportProvider);

      ChannelPrimer channelPrimer = NoOpChannelPrimer.create();

      // Inject channel priming if enabled
      if (isRefreshingEnabled(builder)) {
        channelPrimer =
            BigtableChannelPrimer.create(
                builder.getProjectId(),
                builder.getInstanceId(),
                builder.getAppProfileId(),
                dataCredentials,
                builder.getHeaderProvider().getHeaders());
      }

      DirectAccessChecker directAccessChecker = null;
      switch (settings.getDirectPathConfig()) {
        case FORCED_ON:
          directAccessChecker = AlwaysEnabledDirectAccessChecker.INSTANCE;
          break;
        case FORCED_OFF:
          directAccessChecker = NoopDirectAccessChecker.INSTANCE;
          break;
        case DEFAULT:
        default:
          directAccessChecker =
              new ClassicDirectAccessChecker(
                  metrics.getDirectPathCompatibleTracer(), channelPrimer, backgroundExecutor);
          break;
      }

      BigtableTransportChannelProvider btTransportProvider =
          BigtableTransportChannelProvider.create(
              transportProvider.build(),
              channelPrimer,
              metrics.getChannelPoolMetricsTracer(),
              backgroundExecutor,
              directAccessChecker);

      builder.setTransportChannelProvider(btTransportProvider);
    }

    ClientContext clientContext = ClientContext.create(builder.build());

    metrics.start();

    Shim shim =
        settings.isSessionsEnabled()
            ? ShimImpl.create(clientInfo, dataCredentials, metrics, backgroundExecutor, settings)
            : new DisabledShim();

    try {
      return new BigtableClientContext(
          false, shim, clientInfo, clientContext, metrics, executorProvider);
    } catch (IOException | RuntimeException t) {
      metrics.close();
      throw t;
    }
  }

  @SuppressWarnings("deprecation")
  private static boolean isRefreshingEnabled(EnhancedBigtableStubSettings.Builder b) {
    return b.isRefreshingChannel();
  }

  private static void configureGrpcOtel(
      InstantiatingGrpcChannelProvider.Builder transportProvider, Metrics metrics) {
    @SuppressWarnings("rawtypes")
    ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> oldConfigurator =
        transportProvider.getChannelConfigurator();

    transportProvider.setChannelConfigurator(
        b -> {
          if (oldConfigurator != null) {
            b = oldConfigurator.apply(b);
          }
          return metrics.configureGrpcChannel(b);
        });
  }

  private BigtableClientContext(
      boolean isChild,
      Shim shim,
      ClientInfo clientInfo,
      ClientContext clientContext,
      Metrics metrics,
      ExecutorProvider backgroundExecutorProvider)
      throws IOException {
    this.isChild = isChild;
    this.sessionShim = shim;
    this.clientInfo = clientInfo;

    this.metrics = metrics;
    this.backgroundExecutorProvider = backgroundExecutorProvider;

    this.clientContext =
        clientContext.toBuilder().setTracerFactory(metrics.createTracerFactory(clientInfo)).build();
  }

  public ClientInfo getClientInfo() {
    return clientInfo;
  }

  public Metrics getMetrics() {
    return metrics;
  }

  public ClientContext getClientContext() {
    return this.clientContext;
  }

  public BigtableClientContext createChild(InstanceName instanceName, String appProfileId)
      throws IOException {
    ClientInfo childInfo =
        clientInfo.toBuilder().setInstanceName(instanceName).setAppProfileId(appProfileId).build();

    Shim childShim = sessionShim;
    if (sessionShim instanceof ShimImpl) {
      ShimImpl parentShim = (ShimImpl) sessionShim;
      childShim =
          ShimImpl.createForFactoryChild(
              childInfo,
              metrics,
              backgroundExecutorProvider.getExecutor(),
              parentShim.getUserCallbackExecutor(),
              parentShim.getChannelPool(),
              parentShim.getConfigManager(),
              parentShim.getFeatureFlags());
    }

    return new BigtableClientContext(
        true, childShim, childInfo, clientContext, metrics, backgroundExecutorProvider);
  }

  public void close() throws Exception {
    // Always close the shim: no-op for DisabledShim, closes session pools for factory children.
    sessionShim.close();

    if (isChild) {
      // Shared resources (metrics, executor, transport) are owned by the parent context.
      return;
    }

    for (BackgroundResource resource : clientContext.getBackgroundResources()) {
      resource.close();
    }
    metrics.close();

    if (backgroundExecutorProvider.shouldAutoClose()) {
      backgroundExecutorProvider.getExecutor().shutdown();
    }
  }

  @Nullable
  private static Credentials patchCredentials(String audience, @Nullable Credentials credentials) {
    URI audienceUri;
    try {
      audienceUri = new URI(audience);
    } catch (URISyntaxException e) {
      throw new IllegalStateException("invalid JWT audience", e);
    }

    if (!(credentials instanceof ServiceAccountJwtAccessCredentials)) {
      return credentials;
    }

    ServiceAccountJwtAccessCredentials jwtCreds = (ServiceAccountJwtAccessCredentials) credentials;
    return new JwtCredentialsWithAudience(jwtCreds, audienceUri);
  }

  private static void setupCookieHolder(
      InstantiatingGrpcChannelProvider.Builder transportProvider) {
    ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> oldChannelConfigurator =
        transportProvider.getChannelConfigurator();
    transportProvider.setChannelConfigurator(
        managedChannelBuilder -> {
          managedChannelBuilder.intercept(new CookiesInterceptor());

          if (oldChannelConfigurator != null) {
            managedChannelBuilder = oldChannelConfigurator.apply(managedChannelBuilder);
          }
          return managedChannelBuilder;
        });
  }

  public Shim getSessionShim() {
    return sessionShim;
  }
}
