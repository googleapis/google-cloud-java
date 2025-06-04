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

package com.google.cloud.discoveryengine.v1.stub;

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
import com.google.cloud.discoveryengine.v1.CmekConfig;
import com.google.cloud.discoveryengine.v1.DeleteCmekConfigMetadata;
import com.google.cloud.discoveryengine.v1.DeleteCmekConfigRequest;
import com.google.cloud.discoveryengine.v1.GetCmekConfigRequest;
import com.google.cloud.discoveryengine.v1.ListCmekConfigsRequest;
import com.google.cloud.discoveryengine.v1.ListCmekConfigsResponse;
import com.google.cloud.discoveryengine.v1.UpdateCmekConfigMetadata;
import com.google.cloud.discoveryengine.v1.UpdateCmekConfigRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CmekConfigServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (discoveryengine.googleapis.com) and default port (443) are
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
 * of getCmekConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CmekConfigServiceStubSettings.Builder cmekConfigServiceSettingsBuilder =
 *     CmekConfigServiceStubSettings.newBuilder();
 * cmekConfigServiceSettingsBuilder
 *     .getCmekConfigSettings()
 *     .setRetrySettings(
 *         cmekConfigServiceSettingsBuilder
 *             .getCmekConfigSettings()
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
 * CmekConfigServiceStubSettings cmekConfigServiceSettings =
 *     cmekConfigServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for updateCmekConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CmekConfigServiceStubSettings.Builder cmekConfigServiceSettingsBuilder =
 *     CmekConfigServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * cmekConfigServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class CmekConfigServiceStubSettings extends StubSettings<CmekConfigServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<UpdateCmekConfigRequest, Operation> updateCmekConfigSettings;
  private final OperationCallSettings<UpdateCmekConfigRequest, CmekConfig, UpdateCmekConfigMetadata>
      updateCmekConfigOperationSettings;
  private final UnaryCallSettings<GetCmekConfigRequest, CmekConfig> getCmekConfigSettings;
  private final UnaryCallSettings<ListCmekConfigsRequest, ListCmekConfigsResponse>
      listCmekConfigsSettings;
  private final UnaryCallSettings<DeleteCmekConfigRequest, Operation> deleteCmekConfigSettings;
  private final OperationCallSettings<DeleteCmekConfigRequest, Empty, DeleteCmekConfigMetadata>
      deleteCmekConfigOperationSettings;

  /** Returns the object with the settings used for calls to updateCmekConfig. */
  public UnaryCallSettings<UpdateCmekConfigRequest, Operation> updateCmekConfigSettings() {
    return updateCmekConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateCmekConfig. */
  public OperationCallSettings<UpdateCmekConfigRequest, CmekConfig, UpdateCmekConfigMetadata>
      updateCmekConfigOperationSettings() {
    return updateCmekConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to getCmekConfig. */
  public UnaryCallSettings<GetCmekConfigRequest, CmekConfig> getCmekConfigSettings() {
    return getCmekConfigSettings;
  }

  /** Returns the object with the settings used for calls to listCmekConfigs. */
  public UnaryCallSettings<ListCmekConfigsRequest, ListCmekConfigsResponse>
      listCmekConfigsSettings() {
    return listCmekConfigsSettings;
  }

  /** Returns the object with the settings used for calls to deleteCmekConfig. */
  public UnaryCallSettings<DeleteCmekConfigRequest, Operation> deleteCmekConfigSettings() {
    return deleteCmekConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteCmekConfig. */
  public OperationCallSettings<DeleteCmekConfigRequest, Empty, DeleteCmekConfigMetadata>
      deleteCmekConfigOperationSettings() {
    return deleteCmekConfigOperationSettings;
  }

  public CmekConfigServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcCmekConfigServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonCmekConfigServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "discoveryengine";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "discoveryengine.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "discoveryengine.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(CmekConfigServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(CmekConfigServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CmekConfigServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected CmekConfigServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    updateCmekConfigSettings = settingsBuilder.updateCmekConfigSettings().build();
    updateCmekConfigOperationSettings = settingsBuilder.updateCmekConfigOperationSettings().build();
    getCmekConfigSettings = settingsBuilder.getCmekConfigSettings().build();
    listCmekConfigsSettings = settingsBuilder.listCmekConfigsSettings().build();
    deleteCmekConfigSettings = settingsBuilder.deleteCmekConfigSettings().build();
    deleteCmekConfigOperationSettings = settingsBuilder.deleteCmekConfigOperationSettings().build();
  }

  /** Builder for CmekConfigServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<CmekConfigServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<UpdateCmekConfigRequest, Operation>
        updateCmekConfigSettings;
    private final OperationCallSettings.Builder<
            UpdateCmekConfigRequest, CmekConfig, UpdateCmekConfigMetadata>
        updateCmekConfigOperationSettings;
    private final UnaryCallSettings.Builder<GetCmekConfigRequest, CmekConfig> getCmekConfigSettings;
    private final UnaryCallSettings.Builder<ListCmekConfigsRequest, ListCmekConfigsResponse>
        listCmekConfigsSettings;
    private final UnaryCallSettings.Builder<DeleteCmekConfigRequest, Operation>
        deleteCmekConfigSettings;
    private final OperationCallSettings.Builder<
            DeleteCmekConfigRequest, Empty, DeleteCmekConfigMetadata>
        deleteCmekConfigOperationSettings;
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

      updateCmekConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCmekConfigOperationSettings = OperationCallSettings.newBuilder();
      getCmekConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCmekConfigsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCmekConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCmekConfigOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              updateCmekConfigSettings,
              getCmekConfigSettings,
              listCmekConfigsSettings,
              deleteCmekConfigSettings);
      initDefaults(this);
    }

    protected Builder(CmekConfigServiceStubSettings settings) {
      super(settings);

      updateCmekConfigSettings = settings.updateCmekConfigSettings.toBuilder();
      updateCmekConfigOperationSettings = settings.updateCmekConfigOperationSettings.toBuilder();
      getCmekConfigSettings = settings.getCmekConfigSettings.toBuilder();
      listCmekConfigsSettings = settings.listCmekConfigsSettings.toBuilder();
      deleteCmekConfigSettings = settings.deleteCmekConfigSettings.toBuilder();
      deleteCmekConfigOperationSettings = settings.deleteCmekConfigOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              updateCmekConfigSettings,
              getCmekConfigSettings,
              listCmekConfigsSettings,
              deleteCmekConfigSettings);
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
          .updateCmekConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getCmekConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listCmekConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteCmekConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateCmekConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateCmekConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CmekConfig.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(UpdateCmekConfigMetadata.class))
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
          .deleteCmekConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteCmekConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteCmekConfigMetadata.class))
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

    /** Returns the builder for the settings used for calls to updateCmekConfig. */
    public UnaryCallSettings.Builder<UpdateCmekConfigRequest, Operation>
        updateCmekConfigSettings() {
      return updateCmekConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateCmekConfig. */
    public OperationCallSettings.Builder<
            UpdateCmekConfigRequest, CmekConfig, UpdateCmekConfigMetadata>
        updateCmekConfigOperationSettings() {
      return updateCmekConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getCmekConfig. */
    public UnaryCallSettings.Builder<GetCmekConfigRequest, CmekConfig> getCmekConfigSettings() {
      return getCmekConfigSettings;
    }

    /** Returns the builder for the settings used for calls to listCmekConfigs. */
    public UnaryCallSettings.Builder<ListCmekConfigsRequest, ListCmekConfigsResponse>
        listCmekConfigsSettings() {
      return listCmekConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCmekConfig. */
    public UnaryCallSettings.Builder<DeleteCmekConfigRequest, Operation>
        deleteCmekConfigSettings() {
      return deleteCmekConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCmekConfig. */
    public OperationCallSettings.Builder<DeleteCmekConfigRequest, Empty, DeleteCmekConfigMetadata>
        deleteCmekConfigOperationSettings() {
      return deleteCmekConfigOperationSettings;
    }

    @Override
    public CmekConfigServiceStubSettings build() throws IOException {
      return new CmekConfigServiceStubSettings(this);
    }
  }
}
