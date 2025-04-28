/*
 * Copyright 2024 Google LLC
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
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.auth.Credentials;
import com.google.auth.oauth2.ServiceAccountJwtAccessCredentials;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.internal.JwtCredentialsWithAudience;
import com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants;
import com.google.cloud.bigtable.data.v2.stub.metrics.CustomOpenTelemetryMetricsProvider;
import com.google.cloud.bigtable.data.v2.stub.metrics.DefaultMetricsProvider;
import com.google.cloud.bigtable.data.v2.stub.metrics.ErrorCountPerConnectionMetricTracker;
import com.google.cloud.bigtable.data.v2.stub.metrics.MetricsProvider;
import com.google.cloud.bigtable.data.v2.stub.metrics.NoopMetricsProvider;
import io.grpc.ManagedChannelBuilder;
import io.grpc.opentelemetry.GrpcOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
              universeDomain);
    } catch (Throwable t) {
      logger.log(Level.WARNING, "Failed to get OTEL, will skip exporting client side metrics", t);
    }

    // Set up channel
    InstantiatingGrpcChannelProvider.Builder transportProvider =
        builder.getTransportChannelProvider() instanceof InstantiatingGrpcChannelProvider
            ? ((InstantiatingGrpcChannelProvider) builder.getTransportChannelProvider()).toBuilder()
            : null;

    @Nullable OpenTelemetrySdk internalOtel = null;
    @Nullable ErrorCountPerConnectionMetricTracker errorCountPerConnectionMetricTracker = null;

    // Internal metrics are scoped to the connections, so we need a mutable transportProvider,
    // otherwise there is
    // no reason to build the internal OtelProvider
    if (transportProvider != null) {
      internalOtel =
          settings.getInternalMetricsProvider().createOtelProvider(settings, credentials);
      if (internalOtel != null) {
        // Set up per connection error count tracker if all dependencies are met:
        // a configurable transport provider + otel
        errorCountPerConnectionMetricTracker =
            setupPerConnectionErrorTracer(builder, transportProvider, internalOtel);

        // Configure grpc metrics
        configureGrpcOtel(transportProvider, internalOtel);
      }
    }

    if (transportProvider != null) {
      // Set up cookie holder if routing cookie is enabled
      if (builder.getEnableRoutingCookie()) {
        setupCookieHolder(transportProvider);
      }

      // Inject channel priming if enabled
      if (builder.isRefreshingChannel()) {
        transportProvider.setChannelPrimer(
            BigtableChannelPrimer.create(
                builder.getProjectId(),
                builder.getInstanceId(),
                builder.getAppProfileId(),
                credentials,
                builder.getHeaderProvider().getHeaders()));
      }

      builder.setTransportChannelProvider(transportProvider.build());
    }

    ClientContext clientContext = ClientContext.create(builder.build());

    if (errorCountPerConnectionMetricTracker != null) {
      errorCountPerConnectionMetricTracker.startConnectionErrorCountTracker(
          clientContext.getExecutor());
    }

    return new BigtableClientContext(
        clientContext, openTelemetry, internalOtel, settings.getMetricsProvider());
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
      MetricsProvider metricsProvider) {
    this.clientContext = clientContext;
    this.openTelemetry = openTelemetry;
    this.internalOpenTelemetry = internalOtel;
    this.metricsProvider = metricsProvider;
  }

  public OpenTelemetry getOpenTelemetry() {
    return this.openTelemetry;
  }

  public ClientContext getClientContext() {
    return this.clientContext;
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
  }

  private static OpenTelemetry getOpenTelemetryFromMetricsProvider(
      MetricsProvider metricsProvider,
      @Nullable Credentials defaultCredentials,
      @Nullable String metricsEndpoint,
      String universeDomain)
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
      return defaultMetricsProvider.getOpenTelemetry(metricsEndpoint, universeDomain, credentials);
    } else if (metricsProvider instanceof NoopMetricsProvider) {
      return null;
    }
    throw new IOException("Invalid MetricsProvider type " + metricsProvider);
  }

  private static void patchCredentials(EnhancedBigtableStubSettings.Builder settings)
      throws IOException {
    int i = settings.getEndpoint().lastIndexOf(":");
    String host = settings.getEndpoint().substring(0, i);
    String audience = settings.getJwtAudienceMapping().get(host);

    if (audience == null) {
      return;
    }
    URI audienceUri = null;
    try {
      audienceUri = new URI(audience);
    } catch (URISyntaxException e) {
      throw new IllegalStateException("invalid JWT audience override", e);
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

  private static ErrorCountPerConnectionMetricTracker setupPerConnectionErrorTracer(
      EnhancedBigtableStubSettings.Builder builder,
      InstantiatingGrpcChannelProvider.Builder transportProvider,
      OpenTelemetry openTelemetry) {
    ErrorCountPerConnectionMetricTracker errorCountPerConnectionMetricTracker =
        new ErrorCountPerConnectionMetricTracker(
            openTelemetry, EnhancedBigtableStub.createBuiltinAttributes(builder.build()));
    ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> oldChannelConfigurator =
        transportProvider.getChannelConfigurator();
    transportProvider.setChannelConfigurator(
        managedChannelBuilder -> {
          managedChannelBuilder.intercept(errorCountPerConnectionMetricTracker.getInterceptor());

          if (oldChannelConfigurator != null) {
            managedChannelBuilder = oldChannelConfigurator.apply(managedChannelBuilder);
          }
          return managedChannelBuilder;
        });
    return errorCountPerConnectionMetricTracker;
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
