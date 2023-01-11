/*
 * Copyright 2022 Google LLC
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

package com.google.monitoring.metricsscope.v1.stub;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
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
import com.google.monitoring.metricsscope.v1.CreateMonitoredProjectRequest;
import com.google.monitoring.metricsscope.v1.DeleteMonitoredProjectRequest;
import com.google.monitoring.metricsscope.v1.GetMetricsScopeRequest;
import com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectRequest;
import com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectResponse;
import com.google.monitoring.metricsscope.v1.MetricsScope;
import com.google.monitoring.metricsscope.v1.MonitoredProject;
import com.google.monitoring.metricsscope.v1.OperationMetadata;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MetricsScopesStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (monitoring.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getMetricsScope to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MetricsScopesStubSettings.Builder metricsScopesSettingsBuilder =
 *     MetricsScopesStubSettings.newBuilder();
 * metricsScopesSettingsBuilder
 *     .getMetricsScopeSettings()
 *     .setRetrySettings(
 *         metricsScopesSettingsBuilder.getMetricsScopeSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * MetricsScopesStubSettings metricsScopesSettings = metricsScopesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class MetricsScopesStubSettings extends StubSettings<MetricsScopesStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/monitoring")
          .add("https://www.googleapis.com/auth/monitoring.read")
          .add("https://www.googleapis.com/auth/monitoring.write")
          .build();

  private final UnaryCallSettings<GetMetricsScopeRequest, MetricsScope> getMetricsScopeSettings;
  private final UnaryCallSettings<
          ListMetricsScopesByMonitoredProjectRequest, ListMetricsScopesByMonitoredProjectResponse>
      listMetricsScopesByMonitoredProjectSettings;
  private final UnaryCallSettings<CreateMonitoredProjectRequest, Operation>
      createMonitoredProjectSettings;
  private final OperationCallSettings<
          CreateMonitoredProjectRequest, MonitoredProject, OperationMetadata>
      createMonitoredProjectOperationSettings;
  private final UnaryCallSettings<DeleteMonitoredProjectRequest, Operation>
      deleteMonitoredProjectSettings;
  private final OperationCallSettings<DeleteMonitoredProjectRequest, Empty, OperationMetadata>
      deleteMonitoredProjectOperationSettings;

  /** Returns the object with the settings used for calls to getMetricsScope. */
  public UnaryCallSettings<GetMetricsScopeRequest, MetricsScope> getMetricsScopeSettings() {
    return getMetricsScopeSettings;
  }

  /** Returns the object with the settings used for calls to listMetricsScopesByMonitoredProject. */
  public UnaryCallSettings<
          ListMetricsScopesByMonitoredProjectRequest, ListMetricsScopesByMonitoredProjectResponse>
      listMetricsScopesByMonitoredProjectSettings() {
    return listMetricsScopesByMonitoredProjectSettings;
  }

  /** Returns the object with the settings used for calls to createMonitoredProject. */
  public UnaryCallSettings<CreateMonitoredProjectRequest, Operation>
      createMonitoredProjectSettings() {
    return createMonitoredProjectSettings;
  }

  /** Returns the object with the settings used for calls to createMonitoredProject. */
  public OperationCallSettings<CreateMonitoredProjectRequest, MonitoredProject, OperationMetadata>
      createMonitoredProjectOperationSettings() {
    return createMonitoredProjectOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteMonitoredProject. */
  public UnaryCallSettings<DeleteMonitoredProjectRequest, Operation>
      deleteMonitoredProjectSettings() {
    return deleteMonitoredProjectSettings;
  }

  /** Returns the object with the settings used for calls to deleteMonitoredProject. */
  public OperationCallSettings<DeleteMonitoredProjectRequest, Empty, OperationMetadata>
      deleteMonitoredProjectOperationSettings() {
    return deleteMonitoredProjectOperationSettings;
  }

  public MetricsScopesStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcMetricsScopesStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "monitoring.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "monitoring.mtls.googleapis.com:443";
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(MetricsScopesStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected MetricsScopesStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getMetricsScopeSettings = settingsBuilder.getMetricsScopeSettings().build();
    listMetricsScopesByMonitoredProjectSettings =
        settingsBuilder.listMetricsScopesByMonitoredProjectSettings().build();
    createMonitoredProjectSettings = settingsBuilder.createMonitoredProjectSettings().build();
    createMonitoredProjectOperationSettings =
        settingsBuilder.createMonitoredProjectOperationSettings().build();
    deleteMonitoredProjectSettings = settingsBuilder.deleteMonitoredProjectSettings().build();
    deleteMonitoredProjectOperationSettings =
        settingsBuilder.deleteMonitoredProjectOperationSettings().build();
  }

  /** Builder for MetricsScopesStubSettings. */
  public static class Builder extends StubSettings.Builder<MetricsScopesStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetMetricsScopeRequest, MetricsScope>
        getMetricsScopeSettings;
    private final UnaryCallSettings.Builder<
            ListMetricsScopesByMonitoredProjectRequest, ListMetricsScopesByMonitoredProjectResponse>
        listMetricsScopesByMonitoredProjectSettings;
    private final UnaryCallSettings.Builder<CreateMonitoredProjectRequest, Operation>
        createMonitoredProjectSettings;
    private final OperationCallSettings.Builder<
            CreateMonitoredProjectRequest, MonitoredProject, OperationMetadata>
        createMonitoredProjectOperationSettings;
    private final UnaryCallSettings.Builder<DeleteMonitoredProjectRequest, Operation>
        deleteMonitoredProjectSettings;
    private final OperationCallSettings.Builder<
            DeleteMonitoredProjectRequest, Empty, OperationMetadata>
        deleteMonitoredProjectOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getMetricsScopeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listMetricsScopesByMonitoredProjectSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMonitoredProjectSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMonitoredProjectOperationSettings = OperationCallSettings.newBuilder();
      deleteMonitoredProjectSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteMonitoredProjectOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getMetricsScopeSettings,
              listMetricsScopesByMonitoredProjectSettings,
              createMonitoredProjectSettings,
              deleteMonitoredProjectSettings);
      initDefaults(this);
    }

    protected Builder(MetricsScopesStubSettings settings) {
      super(settings);

      getMetricsScopeSettings = settings.getMetricsScopeSettings.toBuilder();
      listMetricsScopesByMonitoredProjectSettings =
          settings.listMetricsScopesByMonitoredProjectSettings.toBuilder();
      createMonitoredProjectSettings = settings.createMonitoredProjectSettings.toBuilder();
      createMonitoredProjectOperationSettings =
          settings.createMonitoredProjectOperationSettings.toBuilder();
      deleteMonitoredProjectSettings = settings.deleteMonitoredProjectSettings.toBuilder();
      deleteMonitoredProjectOperationSettings =
          settings.deleteMonitoredProjectOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getMetricsScopeSettings,
              listMetricsScopesByMonitoredProjectSettings,
              createMonitoredProjectSettings,
              deleteMonitoredProjectSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .getMetricsScopeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listMetricsScopesByMonitoredProjectSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createMonitoredProjectSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteMonitoredProjectSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createMonitoredProjectOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateMonitoredProjectRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MonitoredProject.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(1000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelay(Duration.ofMillis(10000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(900000L))
                      .build()));

      builder
          .deleteMonitoredProjectOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteMonitoredProjectRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(1000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelay(Duration.ofMillis(10000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(900000L))
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

    /** Returns the builder for the settings used for calls to getMetricsScope. */
    public UnaryCallSettings.Builder<GetMetricsScopeRequest, MetricsScope>
        getMetricsScopeSettings() {
      return getMetricsScopeSettings;
    }

    /**
     * Returns the builder for the settings used for calls to listMetricsScopesByMonitoredProject.
     */
    public UnaryCallSettings.Builder<
            ListMetricsScopesByMonitoredProjectRequest, ListMetricsScopesByMonitoredProjectResponse>
        listMetricsScopesByMonitoredProjectSettings() {
      return listMetricsScopesByMonitoredProjectSettings;
    }

    /** Returns the builder for the settings used for calls to createMonitoredProject. */
    public UnaryCallSettings.Builder<CreateMonitoredProjectRequest, Operation>
        createMonitoredProjectSettings() {
      return createMonitoredProjectSettings;
    }

    /** Returns the builder for the settings used for calls to createMonitoredProject. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateMonitoredProjectRequest, MonitoredProject, OperationMetadata>
        createMonitoredProjectOperationSettings() {
      return createMonitoredProjectOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMonitoredProject. */
    public UnaryCallSettings.Builder<DeleteMonitoredProjectRequest, Operation>
        deleteMonitoredProjectSettings() {
      return deleteMonitoredProjectSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMonitoredProject. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteMonitoredProjectRequest, Empty, OperationMetadata>
        deleteMonitoredProjectOperationSettings() {
      return deleteMonitoredProjectOperationSettings;
    }

    @Override
    public MetricsScopesStubSettings build() throws IOException {
      return new MetricsScopesStubSettings(this);
    }
  }
}
