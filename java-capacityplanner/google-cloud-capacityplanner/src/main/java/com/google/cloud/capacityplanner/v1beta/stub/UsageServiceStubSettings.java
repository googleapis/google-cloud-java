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

package com.google.cloud.capacityplanner.v1beta.stub;

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
import com.google.cloud.capacityplanner.v1beta.ExportForecastsRequest;
import com.google.cloud.capacityplanner.v1beta.ExportForecastsResponse;
import com.google.cloud.capacityplanner.v1beta.ExportReservationsUsageRequest;
import com.google.cloud.capacityplanner.v1beta.ExportReservationsUsageResponse;
import com.google.cloud.capacityplanner.v1beta.ExportUsageHistoriesRequest;
import com.google.cloud.capacityplanner.v1beta.ExportUsageHistoriesResponse;
import com.google.cloud.capacityplanner.v1beta.OperationMetadata;
import com.google.cloud.capacityplanner.v1beta.QueryForecastsRequest;
import com.google.cloud.capacityplanner.v1beta.QueryForecastsResponse;
import com.google.cloud.capacityplanner.v1beta.QueryReservationsRequest;
import com.google.cloud.capacityplanner.v1beta.QueryReservationsResponse;
import com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesRequest;
import com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link UsageServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (capacityplanner.googleapis.com) and default port (443) are
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
 * of queryUsageHistories:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * UsageServiceStubSettings.Builder usageServiceSettingsBuilder =
 *     UsageServiceStubSettings.newBuilder();
 * usageServiceSettingsBuilder
 *     .queryUsageHistoriesSettings()
 *     .setRetrySettings(
 *         usageServiceSettingsBuilder
 *             .queryUsageHistoriesSettings()
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
 * UsageServiceStubSettings usageServiceSettings = usageServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for exportUsageHistories:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * UsageServiceStubSettings.Builder usageServiceSettingsBuilder =
 *     UsageServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * usageServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class UsageServiceStubSettings extends StubSettings<UsageServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/devstorage.full_control")
          .build();

  private final UnaryCallSettings<QueryUsageHistoriesRequest, QueryUsageHistoriesResponse>
      queryUsageHistoriesSettings;
  private final UnaryCallSettings<QueryForecastsRequest, QueryForecastsResponse>
      queryForecastsSettings;
  private final UnaryCallSettings<QueryReservationsRequest, QueryReservationsResponse>
      queryReservationsSettings;
  private final UnaryCallSettings<ExportUsageHistoriesRequest, Operation>
      exportUsageHistoriesSettings;
  private final OperationCallSettings<
          ExportUsageHistoriesRequest, ExportUsageHistoriesResponse, OperationMetadata>
      exportUsageHistoriesOperationSettings;
  private final UnaryCallSettings<ExportForecastsRequest, Operation> exportForecastsSettings;
  private final OperationCallSettings<
          ExportForecastsRequest, ExportForecastsResponse, OperationMetadata>
      exportForecastsOperationSettings;
  private final UnaryCallSettings<ExportReservationsUsageRequest, Operation>
      exportReservationsUsageSettings;
  private final OperationCallSettings<
          ExportReservationsUsageRequest, ExportReservationsUsageResponse, OperationMetadata>
      exportReservationsUsageOperationSettings;

  /** Returns the object with the settings used for calls to queryUsageHistories. */
  public UnaryCallSettings<QueryUsageHistoriesRequest, QueryUsageHistoriesResponse>
      queryUsageHistoriesSettings() {
    return queryUsageHistoriesSettings;
  }

  /** Returns the object with the settings used for calls to queryForecasts. */
  public UnaryCallSettings<QueryForecastsRequest, QueryForecastsResponse> queryForecastsSettings() {
    return queryForecastsSettings;
  }

  /** Returns the object with the settings used for calls to queryReservations. */
  public UnaryCallSettings<QueryReservationsRequest, QueryReservationsResponse>
      queryReservationsSettings() {
    return queryReservationsSettings;
  }

  /** Returns the object with the settings used for calls to exportUsageHistories. */
  public UnaryCallSettings<ExportUsageHistoriesRequest, Operation> exportUsageHistoriesSettings() {
    return exportUsageHistoriesSettings;
  }

  /** Returns the object with the settings used for calls to exportUsageHistories. */
  public OperationCallSettings<
          ExportUsageHistoriesRequest, ExportUsageHistoriesResponse, OperationMetadata>
      exportUsageHistoriesOperationSettings() {
    return exportUsageHistoriesOperationSettings;
  }

  /** Returns the object with the settings used for calls to exportForecasts. */
  public UnaryCallSettings<ExportForecastsRequest, Operation> exportForecastsSettings() {
    return exportForecastsSettings;
  }

  /** Returns the object with the settings used for calls to exportForecasts. */
  public OperationCallSettings<ExportForecastsRequest, ExportForecastsResponse, OperationMetadata>
      exportForecastsOperationSettings() {
    return exportForecastsOperationSettings;
  }

  /** Returns the object with the settings used for calls to exportReservationsUsage. */
  public UnaryCallSettings<ExportReservationsUsageRequest, Operation>
      exportReservationsUsageSettings() {
    return exportReservationsUsageSettings;
  }

  /** Returns the object with the settings used for calls to exportReservationsUsage. */
  public OperationCallSettings<
          ExportReservationsUsageRequest, ExportReservationsUsageResponse, OperationMetadata>
      exportReservationsUsageOperationSettings() {
    return exportReservationsUsageOperationSettings;
  }

  public UsageServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcUsageServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonUsageServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "capacityplanner";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "capacityplanner.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "capacityplanner.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(UsageServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(UsageServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return UsageServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected UsageServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    queryUsageHistoriesSettings = settingsBuilder.queryUsageHistoriesSettings().build();
    queryForecastsSettings = settingsBuilder.queryForecastsSettings().build();
    queryReservationsSettings = settingsBuilder.queryReservationsSettings().build();
    exportUsageHistoriesSettings = settingsBuilder.exportUsageHistoriesSettings().build();
    exportUsageHistoriesOperationSettings =
        settingsBuilder.exportUsageHistoriesOperationSettings().build();
    exportForecastsSettings = settingsBuilder.exportForecastsSettings().build();
    exportForecastsOperationSettings = settingsBuilder.exportForecastsOperationSettings().build();
    exportReservationsUsageSettings = settingsBuilder.exportReservationsUsageSettings().build();
    exportReservationsUsageOperationSettings =
        settingsBuilder.exportReservationsUsageOperationSettings().build();
  }

  /** Builder for UsageServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<UsageServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<QueryUsageHistoriesRequest, QueryUsageHistoriesResponse>
        queryUsageHistoriesSettings;
    private final UnaryCallSettings.Builder<QueryForecastsRequest, QueryForecastsResponse>
        queryForecastsSettings;
    private final UnaryCallSettings.Builder<QueryReservationsRequest, QueryReservationsResponse>
        queryReservationsSettings;
    private final UnaryCallSettings.Builder<ExportUsageHistoriesRequest, Operation>
        exportUsageHistoriesSettings;
    private final OperationCallSettings.Builder<
            ExportUsageHistoriesRequest, ExportUsageHistoriesResponse, OperationMetadata>
        exportUsageHistoriesOperationSettings;
    private final UnaryCallSettings.Builder<ExportForecastsRequest, Operation>
        exportForecastsSettings;
    private final OperationCallSettings.Builder<
            ExportForecastsRequest, ExportForecastsResponse, OperationMetadata>
        exportForecastsOperationSettings;
    private final UnaryCallSettings.Builder<ExportReservationsUsageRequest, Operation>
        exportReservationsUsageSettings;
    private final OperationCallSettings.Builder<
            ExportReservationsUsageRequest, ExportReservationsUsageResponse, OperationMetadata>
        exportReservationsUsageOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE,
                  StatusCode.Code.DEADLINE_EXCEEDED,
                  StatusCode.Code.INTERNAL)));
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
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      queryUsageHistoriesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      queryForecastsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      queryReservationsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportUsageHistoriesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportUsageHistoriesOperationSettings = OperationCallSettings.newBuilder();
      exportForecastsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportForecastsOperationSettings = OperationCallSettings.newBuilder();
      exportReservationsUsageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportReservationsUsageOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              queryUsageHistoriesSettings,
              queryForecastsSettings,
              queryReservationsSettings,
              exportUsageHistoriesSettings,
              exportForecastsSettings,
              exportReservationsUsageSettings);
      initDefaults(this);
    }

    protected Builder(UsageServiceStubSettings settings) {
      super(settings);

      queryUsageHistoriesSettings = settings.queryUsageHistoriesSettings.toBuilder();
      queryForecastsSettings = settings.queryForecastsSettings.toBuilder();
      queryReservationsSettings = settings.queryReservationsSettings.toBuilder();
      exportUsageHistoriesSettings = settings.exportUsageHistoriesSettings.toBuilder();
      exportUsageHistoriesOperationSettings =
          settings.exportUsageHistoriesOperationSettings.toBuilder();
      exportForecastsSettings = settings.exportForecastsSettings.toBuilder();
      exportForecastsOperationSettings = settings.exportForecastsOperationSettings.toBuilder();
      exportReservationsUsageSettings = settings.exportReservationsUsageSettings.toBuilder();
      exportReservationsUsageOperationSettings =
          settings.exportReservationsUsageOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              queryUsageHistoriesSettings,
              queryForecastsSettings,
              queryReservationsSettings,
              exportUsageHistoriesSettings,
              exportForecastsSettings,
              exportReservationsUsageSettings);
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
          .queryUsageHistoriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .queryForecastsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .queryReservationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .exportUsageHistoriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .exportForecastsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .exportReservationsUsageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .exportUsageHistoriesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ExportUsageHistoriesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ExportUsageHistoriesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .exportForecastsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ExportForecastsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ExportForecastsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .exportReservationsUsageOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ExportReservationsUsageRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ExportReservationsUsageResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to queryUsageHistories. */
    public UnaryCallSettings.Builder<QueryUsageHistoriesRequest, QueryUsageHistoriesResponse>
        queryUsageHistoriesSettings() {
      return queryUsageHistoriesSettings;
    }

    /** Returns the builder for the settings used for calls to queryForecasts. */
    public UnaryCallSettings.Builder<QueryForecastsRequest, QueryForecastsResponse>
        queryForecastsSettings() {
      return queryForecastsSettings;
    }

    /** Returns the builder for the settings used for calls to queryReservations. */
    public UnaryCallSettings.Builder<QueryReservationsRequest, QueryReservationsResponse>
        queryReservationsSettings() {
      return queryReservationsSettings;
    }

    /** Returns the builder for the settings used for calls to exportUsageHistories. */
    public UnaryCallSettings.Builder<ExportUsageHistoriesRequest, Operation>
        exportUsageHistoriesSettings() {
      return exportUsageHistoriesSettings;
    }

    /** Returns the builder for the settings used for calls to exportUsageHistories. */
    public OperationCallSettings.Builder<
            ExportUsageHistoriesRequest, ExportUsageHistoriesResponse, OperationMetadata>
        exportUsageHistoriesOperationSettings() {
      return exportUsageHistoriesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to exportForecasts. */
    public UnaryCallSettings.Builder<ExportForecastsRequest, Operation> exportForecastsSettings() {
      return exportForecastsSettings;
    }

    /** Returns the builder for the settings used for calls to exportForecasts. */
    public OperationCallSettings.Builder<
            ExportForecastsRequest, ExportForecastsResponse, OperationMetadata>
        exportForecastsOperationSettings() {
      return exportForecastsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to exportReservationsUsage. */
    public UnaryCallSettings.Builder<ExportReservationsUsageRequest, Operation>
        exportReservationsUsageSettings() {
      return exportReservationsUsageSettings;
    }

    /** Returns the builder for the settings used for calls to exportReservationsUsage. */
    public OperationCallSettings.Builder<
            ExportReservationsUsageRequest, ExportReservationsUsageResponse, OperationMetadata>
        exportReservationsUsageOperationSettings() {
      return exportReservationsUsageOperationSettings;
    }

    @Override
    public UsageServiceStubSettings build() throws IOException {
      return new UsageServiceStubSettings(this);
    }
  }
}
