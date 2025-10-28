/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.maps.routeoptimization.v1.stub;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.maps.routeoptimization.v1.BatchOptimizeToursMetadata;
import com.google.maps.routeoptimization.v1.BatchOptimizeToursRequest;
import com.google.maps.routeoptimization.v1.BatchOptimizeToursResponse;
import com.google.maps.routeoptimization.v1.OptimizeToursLongRunningMetadata;
import com.google.maps.routeoptimization.v1.OptimizeToursRequest;
import com.google.maps.routeoptimization.v1.OptimizeToursResponse;
import com.google.maps.routeoptimization.v1.OptimizeToursUriMetadata;
import com.google.maps.routeoptimization.v1.OptimizeToursUriRequest;
import com.google.maps.routeoptimization.v1.OptimizeToursUriResponse;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RouteOptimizationStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (routeoptimization.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of optimizeTours:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RouteOptimizationStubSettings.Builder routeOptimizationSettingsBuilder =
 *     RouteOptimizationStubSettings.newBuilder();
 * routeOptimizationSettingsBuilder
 *     .optimizeToursSettings()
 *     .setRetrySettings(
 *         routeOptimizationSettingsBuilder
 *             .optimizeToursSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * RouteOptimizationStubSettings routeOptimizationSettings =
 *     routeOptimizationSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for batchOptimizeTours:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RouteOptimizationStubSettings.Builder routeOptimizationSettingsBuilder =
 *     RouteOptimizationStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * routeOptimizationSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RouteOptimizationStubSettings extends StubSettings<RouteOptimizationStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<OptimizeToursRequest, OptimizeToursResponse>
      optimizeToursSettings;
  private final UnaryCallSettings<BatchOptimizeToursRequest, Operation> batchOptimizeToursSettings;
  private final OperationCallSettings<
          BatchOptimizeToursRequest, BatchOptimizeToursResponse, BatchOptimizeToursMetadata>
      batchOptimizeToursOperationSettings;
  private final UnaryCallSettings<OptimizeToursRequest, Operation> optimizeToursLongRunningSettings;
  private final OperationCallSettings<
          OptimizeToursRequest, OptimizeToursResponse, OptimizeToursLongRunningMetadata>
      optimizeToursLongRunningOperationSettings;
  private final UnaryCallSettings<OptimizeToursUriRequest, Operation> optimizeToursUriSettings;
  private final OperationCallSettings<
          OptimizeToursUriRequest, OptimizeToursUriResponse, OptimizeToursUriMetadata>
      optimizeToursUriOperationSettings;

  /** Returns the object with the settings used for calls to optimizeTours. */
  public UnaryCallSettings<OptimizeToursRequest, OptimizeToursResponse> optimizeToursSettings() {
    return optimizeToursSettings;
  }

  /** Returns the object with the settings used for calls to batchOptimizeTours. */
  public UnaryCallSettings<BatchOptimizeToursRequest, Operation> batchOptimizeToursSettings() {
    return batchOptimizeToursSettings;
  }

  /** Returns the object with the settings used for calls to batchOptimizeTours. */
  public OperationCallSettings<
          BatchOptimizeToursRequest, BatchOptimizeToursResponse, BatchOptimizeToursMetadata>
      batchOptimizeToursOperationSettings() {
    return batchOptimizeToursOperationSettings;
  }

  /** Returns the object with the settings used for calls to optimizeToursLongRunning. */
  public UnaryCallSettings<OptimizeToursRequest, Operation> optimizeToursLongRunningSettings() {
    return optimizeToursLongRunningSettings;
  }

  /** Returns the object with the settings used for calls to optimizeToursLongRunning. */
  public OperationCallSettings<
          OptimizeToursRequest, OptimizeToursResponse, OptimizeToursLongRunningMetadata>
      optimizeToursLongRunningOperationSettings() {
    return optimizeToursLongRunningOperationSettings;
  }

  /** Returns the object with the settings used for calls to optimizeToursUri. */
  public UnaryCallSettings<OptimizeToursUriRequest, Operation> optimizeToursUriSettings() {
    return optimizeToursUriSettings;
  }

  /** Returns the object with the settings used for calls to optimizeToursUri. */
  public OperationCallSettings<
          OptimizeToursUriRequest, OptimizeToursUriResponse, OptimizeToursUriMetadata>
      optimizeToursUriOperationSettings() {
    return optimizeToursUriOperationSettings;
  }

  public RouteOptimizationStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcRouteOptimizationStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonRouteOptimizationStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "routeoptimization";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "routeoptimization.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "routeoptimization.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(RouteOptimizationStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(RouteOptimizationStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RouteOptimizationStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected RouteOptimizationStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    optimizeToursSettings = settingsBuilder.optimizeToursSettings().build();
    batchOptimizeToursSettings = settingsBuilder.batchOptimizeToursSettings().build();
    batchOptimizeToursOperationSettings =
        settingsBuilder.batchOptimizeToursOperationSettings().build();
    optimizeToursLongRunningSettings = settingsBuilder.optimizeToursLongRunningSettings().build();
    optimizeToursLongRunningOperationSettings =
        settingsBuilder.optimizeToursLongRunningOperationSettings().build();
    optimizeToursUriSettings = settingsBuilder.optimizeToursUriSettings().build();
    optimizeToursUriOperationSettings = settingsBuilder.optimizeToursUriOperationSettings().build();
  }

  /** Builder for RouteOptimizationStubSettings. */
  public static class Builder extends StubSettings.Builder<RouteOptimizationStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<OptimizeToursRequest, OptimizeToursResponse>
        optimizeToursSettings;
    private final UnaryCallSettings.Builder<BatchOptimizeToursRequest, Operation>
        batchOptimizeToursSettings;
    private final OperationCallSettings.Builder<
            BatchOptimizeToursRequest, BatchOptimizeToursResponse, BatchOptimizeToursMetadata>
        batchOptimizeToursOperationSettings;
    private final UnaryCallSettings.Builder<OptimizeToursRequest, Operation>
        optimizeToursLongRunningSettings;
    private final OperationCallSettings.Builder<
            OptimizeToursRequest, OptimizeToursResponse, OptimizeToursLongRunningMetadata>
        optimizeToursLongRunningOperationSettings;
    private final UnaryCallSettings.Builder<OptimizeToursUriRequest, Operation>
        optimizeToursUriSettings;
    private final OperationCallSettings.Builder<
            OptimizeToursUriRequest, OptimizeToursUriResponse, OptimizeToursUriMetadata>
        optimizeToursUriOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(3600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(3600000L))
              .setTotalTimeoutDuration(Duration.ofMillis(3600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      optimizeToursSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchOptimizeToursSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchOptimizeToursOperationSettings = OperationCallSettings.newBuilder();
      optimizeToursLongRunningSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      optimizeToursLongRunningOperationSettings = OperationCallSettings.newBuilder();
      optimizeToursUriSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      optimizeToursUriOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              optimizeToursSettings,
              batchOptimizeToursSettings,
              optimizeToursLongRunningSettings,
              optimizeToursUriSettings);
      initDefaults(this);
    }

    protected Builder(RouteOptimizationStubSettings settings) {
      super(settings);

      optimizeToursSettings = settings.optimizeToursSettings.toBuilder();
      batchOptimizeToursSettings = settings.batchOptimizeToursSettings.toBuilder();
      batchOptimizeToursOperationSettings =
          settings.batchOptimizeToursOperationSettings.toBuilder();
      optimizeToursLongRunningSettings = settings.optimizeToursLongRunningSettings.toBuilder();
      optimizeToursLongRunningOperationSettings =
          settings.optimizeToursLongRunningOperationSettings.toBuilder();
      optimizeToursUriSettings = settings.optimizeToursUriSettings.toBuilder();
      optimizeToursUriOperationSettings = settings.optimizeToursUriOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              optimizeToursSettings,
              batchOptimizeToursSettings,
              optimizeToursLongRunningSettings,
              optimizeToursUriSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .optimizeToursSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchOptimizeToursSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .optimizeToursLongRunningSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .optimizeToursUriSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchOptimizeToursOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchOptimizeToursRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BatchOptimizeToursResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  BatchOptimizeToursMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .optimizeToursLongRunningOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<OptimizeToursRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(OptimizeToursResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  OptimizeToursLongRunningMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .optimizeToursUriOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<OptimizeToursUriRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(OptimizeToursUriResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OptimizeToursUriMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to optimizeTours. */
    public UnaryCallSettings.Builder<OptimizeToursRequest, OptimizeToursResponse>
        optimizeToursSettings() {
      return optimizeToursSettings;
    }

    /** Returns the builder for the settings used for calls to batchOptimizeTours. */
    public UnaryCallSettings.Builder<BatchOptimizeToursRequest, Operation>
        batchOptimizeToursSettings() {
      return batchOptimizeToursSettings;
    }

    /** Returns the builder for the settings used for calls to batchOptimizeTours. */
    public OperationCallSettings.Builder<
            BatchOptimizeToursRequest, BatchOptimizeToursResponse, BatchOptimizeToursMetadata>
        batchOptimizeToursOperationSettings() {
      return batchOptimizeToursOperationSettings;
    }

    /** Returns the builder for the settings used for calls to optimizeToursLongRunning. */
    public UnaryCallSettings.Builder<OptimizeToursRequest, Operation>
        optimizeToursLongRunningSettings() {
      return optimizeToursLongRunningSettings;
    }

    /** Returns the builder for the settings used for calls to optimizeToursLongRunning. */
    public OperationCallSettings.Builder<
            OptimizeToursRequest, OptimizeToursResponse, OptimizeToursLongRunningMetadata>
        optimizeToursLongRunningOperationSettings() {
      return optimizeToursLongRunningOperationSettings;
    }

    /** Returns the builder for the settings used for calls to optimizeToursUri. */
    public UnaryCallSettings.Builder<OptimizeToursUriRequest, Operation>
        optimizeToursUriSettings() {
      return optimizeToursUriSettings;
    }

    /** Returns the builder for the settings used for calls to optimizeToursUri. */
    public OperationCallSettings.Builder<
            OptimizeToursUriRequest, OptimizeToursUriResponse, OptimizeToursUriMetadata>
        optimizeToursUriOperationSettings() {
      return optimizeToursUriOperationSettings;
    }

    @Override
    public RouteOptimizationStubSettings build() throws IOException {
      return new RouteOptimizationStubSettings(this);
    }
  }
}
