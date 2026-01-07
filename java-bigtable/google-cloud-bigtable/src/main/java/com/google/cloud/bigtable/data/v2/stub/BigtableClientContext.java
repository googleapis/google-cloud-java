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
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.auth.Credentials;
import com.google.auth.oauth2.ServiceAccountJwtAccessCredentials;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.internal.JwtCredentialsWithAudience;
import com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants;
import com.google.cloud.bigtable.data.v2.stub.metrics.ChannelPoolMetricsTracer;
import com.google.cloud.bigtable.data.v2.stub.metrics.CustomOpenTelemetryMetricsProvider;
import com.google.cloud.bigtable.data.v2.stub.metrics.DefaultMetricsProvider;
import com.google.cloud.bigtable.data.v2.stub.metrics.MetricsProvider;
import com.google.cloud.bigtable.data.v2.stub.metrics.NoopMetricsProvider;
import com.google.cloud.bigtable.gaxx.grpc.BigtableTransportChannelProvider;
import com.google.cloud.bigtable.gaxx.grpc.ChannelPrimer;
import io.grpc.ManagedChannelBuilder;
import io.grpc.opentelemetry.GrpcOpenTelemetry;
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

  @Nullable private final OpenTelemetry openTelemetry;
  @Nullable private final OpenTelemetrySdk internalOpenTelemetry;
  private final MetricsProvider metricsProvider;
  private final ClientContext clientContext;
  // the background executor shared for OTEL instances and monitoring client and all other
  // background tasks
  private final ExecutorProvider backgroundExecutorProvider;

  public static BigtableClientContext create(EnhancedBigtableStubSettings settings)
      throws IOException {
    EnhancedBigtableStubSettings.Builder builder = settings.toBuilder();

    // Set up credentials
    patchCredentials(builder);

    // Fix the credentials so that they can be shared
    Credentials credentials = null;
    if (builder.getCredentialsProvider() != null) {
      credentials = builder.getCredentialsProvider().getCredentials();
    }
    builder.setCredentialsProvider(FixedCredentialsProvider.create(credentials));

    String universeDomain = settings.getUniverseDomain();

    boolean shouldAutoClose = settings.getBackgroundExecutorProvider().shouldAutoClose();
    ScheduledExecutorService backgroundExecutor =
        settings.getBackgroundExecutorProvider().getExecutor();
    // TODO: after gax change is merged, migrate to use gax's FixedExecutorProvider
    BigtableExecutorProvider executorProvider =
        BigtableExecutorProvider.create(backgroundExecutor, shouldAutoClose);
    builder.setBackgroundExecutorProvider(executorProvider);

    // Set up OpenTelemetry
    OpenTelemetry openTelemetry = null;
    try {
      // We don't want client side metrics to crash the client, so catch any exception when getting
      // the OTEL instance and log the exception instead.
      openTelemetry =
          getOpenTelemetryFromMetricsProvider(
              settings.getMetricsProvider(),
              credentials,
              settings.getMetricsEndpoint(),
              universeDomain,
              backgroundExecutor);
    } catch (Throwable t) {
      logger.log(Level.WARNING, "Failed to get OTEL, will skip exporting client side metrics", t);
    }

    // Set up channel
    InstantiatingGrpcChannelProvider.Builder transportProvider =
        builder.getTransportChannelProvider() instanceof InstantiatingGrpcChannelProvider
            ? ((InstantiatingGrpcChannelProvider) builder.getTransportChannelProvider()).toBuilder()
            : null;

    @Nullable OpenTelemetrySdk internalOtel = null;
    @Nullable ChannelPoolMetricsTracer channelPoolMetricsTracer = null;
    // Internal metrics are scoped to the connections, so we need a mutable transportProvider,
    // otherwise there is
    // no reason to build the internal OtelProvider
    if (transportProvider != null) {
      internalOtel =
          settings
              .getInternalMetricsProvider()
              .createOtelProvider(settings, credentials, backgroundExecutor);
      if (internalOtel != null) {
        channelPoolMetricsTracer =
            new ChannelPoolMetricsTracer(
                internalOtel, EnhancedBigtableStub.createBuiltinAttributes(builder.build()));

        // Configure grpc metrics
        configureGrpcOtel(transportProvider, internalOtel);
      }
    }

    if (transportProvider != null) {
      // Set up cookie holder if routing cookie is enabled
      if (builder.getEnableRoutingCookie()) {
        setupCookieHolder(transportProvider);
      }

      ChannelPrimer channelPrimer = NoOpChannelPrimer.create();

      // Inject channel priming if enabled
      if (builder.isRefreshingChannel()) {
        channelPrimer =
            BigtableChannelPrimer.create(
                builder.getProjectId(),
                builder.getInstanceId(),
                builder.getAppProfileId(),
                credentials,
                builder.getHeaderProvider().getHeaders());
      }

      BigtableTransportChannelProvider btTransportProvider =
          BigtableTransportChannelProvider.create(
              (InstantiatingGrpcChannelProvider) transportProvider.build(),
              channelPrimer,
              channelPoolMetricsTracer);

      builder.setTransportChannelProvider(btTransportProvider);
    }

    ClientContext clientContext = ClientContext.create(builder.build());
    if (channelPoolMetricsTracer != null) {
      channelPoolMetricsTracer.start(clientContext.getExecutor());
    }

    return new BigtableClientContext(
        clientContext,
        openTelemetry,
        internalOtel,
        settings.getMetricsProvider(),
        executorProvider);
  }

  private static void configureGrpcOtel(
      InstantiatingGrpcChannelProvider.Builder transportProvider, OpenTelemetrySdk otel) {

    GrpcOpenTelemetry grpcOtel =
        GrpcOpenTelemetry.newBuilder()
            .sdk(otel)
            .addOptionalLabel("grpc.lb.locality")
            // Disable default grpc metrics
            .disableAllMetrics()
            // Enable specific grpc metrics
            .enableMetrics(BuiltinMetricsConstants.GRPC_METRICS.keySet())
            .build();

    @SuppressWarnings("rawtypes")
    ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> oldConfigurator =
        transportProvider.getChannelConfigurator();

    transportProvider.setChannelConfigurator(
        b -> {
          if (oldConfigurator != null) {
            b = oldConfigurator.apply(b);
          }
          grpcOtel.configureChannelBuilder(b);
          return b;
        });
  }

  private BigtableClientContext(
      ClientContext clientContext,
      @Nullable OpenTelemetry openTelemetry,
      @Nullable OpenTelemetrySdk internalOtel,
      MetricsProvider metricsProvider,
      ExecutorProvider backgroundExecutorProvider) {
    this.clientContext = clientContext;
    this.openTelemetry = openTelemetry;
    this.internalOpenTelemetry = internalOtel;
    this.metricsProvider = metricsProvider;
    this.backgroundExecutorProvider = backgroundExecutorProvider;
  }

  public OpenTelemetry getOpenTelemetry() {
    return this.openTelemetry;
  }

  public ClientContext getClientContext() {
    return this.clientContext;
  }

  public BigtableClientContext withClientContext(ClientContext clientContext) {
    return new BigtableClientContext(
        clientContext,
        openTelemetry,
        internalOpenTelemetry,
        metricsProvider,
        backgroundExecutorProvider);
  }

  public void close() throws Exception {
    for (BackgroundResource resource : clientContext.getBackgroundResources()) {
      resource.close();
    }
    if (internalOpenTelemetry != null) {
      internalOpenTelemetry.close();
    }
    if (metricsProvider instanceof DefaultMetricsProvider && openTelemetry != null) {
      ((OpenTelemetrySdk) openTelemetry).close();
    }
    if (backgroundExecutorProvider.shouldAutoClose()) {
      backgroundExecutorProvider.getExecutor().shutdown();
    }
  }

  private static OpenTelemetry getOpenTelemetryFromMetricsProvider(
      MetricsProvider metricsProvider,
      @Nullable Credentials defaultCredentials,
      @Nullable String metricsEndpoint,
      String universeDomain,
      ScheduledExecutorService executor)
      throws IOException {
    if (metricsProvider instanceof CustomOpenTelemetryMetricsProvider) {
      CustomOpenTelemetryMetricsProvider customMetricsProvider =
          (CustomOpenTelemetryMetricsProvider) metricsProvider;
      return customMetricsProvider.getOpenTelemetry();
    } else if (metricsProvider instanceof DefaultMetricsProvider) {
      Credentials credentials =
          BigtableDataSettings.getMetricsCredentials() != null
              ? BigtableDataSettings.getMetricsCredentials()
              : defaultCredentials;
      DefaultMetricsProvider defaultMetricsProvider = (DefaultMetricsProvider) metricsProvider;
      return defaultMetricsProvider.getOpenTelemetry(
          metricsEndpoint, universeDomain, credentials, executor);
    } else if (metricsProvider instanceof NoopMetricsProvider) {
      return null;
    }
    throw new IOException("Invalid MetricsProvider type " + metricsProvider);
  }

  private static void patchCredentials(EnhancedBigtableStubSettings.Builder settings)
      throws IOException {
    String audience = settings.getJwtAudience();

    URI audienceUri = null;
    try {
      audienceUri = new URI(audience);
    } catch (URISyntaxException e) {
      throw new IllegalStateException("invalid JWT audience", e);
    }

    CredentialsProvider credentialsProvider = settings.getCredentialsProvider();
    if (credentialsProvider == null) {
      return;
    }

    Credentials credentials = credentialsProvider.getCredentials();
    if (credentials == null) {
      return;
    }

    if (!(credentials instanceof ServiceAccountJwtAccessCredentials)) {
      return;
    }

    ServiceAccountJwtAccessCredentials jwtCreds = (ServiceAccountJwtAccessCredentials) credentials;
    JwtCredentialsWithAudience patchedCreds = new JwtCredentialsWithAudience(jwtCreds, audienceUri);
    settings.setCredentialsProvider(FixedCredentialsProvider.create(patchedCreds));
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
}
