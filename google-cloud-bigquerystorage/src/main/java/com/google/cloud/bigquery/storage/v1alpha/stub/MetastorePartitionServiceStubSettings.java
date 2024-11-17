/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.bigquery.storage.v1alpha.stub;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.bigquery.storage.v1alpha.BatchCreateMetastorePartitionsRequest;
import com.google.cloud.bigquery.storage.v1alpha.BatchCreateMetastorePartitionsResponse;
import com.google.cloud.bigquery.storage.v1alpha.BatchDeleteMetastorePartitionsRequest;
import com.google.cloud.bigquery.storage.v1alpha.BatchUpdateMetastorePartitionsRequest;
import com.google.cloud.bigquery.storage.v1alpha.BatchUpdateMetastorePartitionsResponse;
import com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsRequest;
import com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsResponse;
import com.google.cloud.bigquery.storage.v1alpha.StreamMetastorePartitionsRequest;
import com.google.cloud.bigquery.storage.v1alpha.StreamMetastorePartitionsResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MetastorePartitionServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (bigquerystorage.googleapis.com) and default port (443) are
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
 * of batchCreateMetastorePartitions:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MetastorePartitionServiceStubSettings.Builder metastorePartitionServiceSettingsBuilder =
 *     MetastorePartitionServiceStubSettings.newBuilder();
 * metastorePartitionServiceSettingsBuilder
 *     .batchCreateMetastorePartitionsSettings()
 *     .setRetrySettings(
 *         metastorePartitionServiceSettingsBuilder
 *             .batchCreateMetastorePartitionsSettings()
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
 * MetastorePartitionServiceStubSettings metastorePartitionServiceSettings =
 *     metastorePartitionServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class MetastorePartitionServiceStubSettings
    extends StubSettings<MetastorePartitionServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/bigquery")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<
          BatchCreateMetastorePartitionsRequest, BatchCreateMetastorePartitionsResponse>
      batchCreateMetastorePartitionsSettings;
  private final UnaryCallSettings<BatchDeleteMetastorePartitionsRequest, Empty>
      batchDeleteMetastorePartitionsSettings;
  private final UnaryCallSettings<
          BatchUpdateMetastorePartitionsRequest, BatchUpdateMetastorePartitionsResponse>
      batchUpdateMetastorePartitionsSettings;
  private final UnaryCallSettings<ListMetastorePartitionsRequest, ListMetastorePartitionsResponse>
      listMetastorePartitionsSettings;
  private final StreamingCallSettings<
          StreamMetastorePartitionsRequest, StreamMetastorePartitionsResponse>
      streamMetastorePartitionsSettings;

  /** Returns the object with the settings used for calls to batchCreateMetastorePartitions. */
  public UnaryCallSettings<
          BatchCreateMetastorePartitionsRequest, BatchCreateMetastorePartitionsResponse>
      batchCreateMetastorePartitionsSettings() {
    return batchCreateMetastorePartitionsSettings;
  }

  /** Returns the object with the settings used for calls to batchDeleteMetastorePartitions. */
  public UnaryCallSettings<BatchDeleteMetastorePartitionsRequest, Empty>
      batchDeleteMetastorePartitionsSettings() {
    return batchDeleteMetastorePartitionsSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateMetastorePartitions. */
  public UnaryCallSettings<
          BatchUpdateMetastorePartitionsRequest, BatchUpdateMetastorePartitionsResponse>
      batchUpdateMetastorePartitionsSettings() {
    return batchUpdateMetastorePartitionsSettings;
  }

  /** Returns the object with the settings used for calls to listMetastorePartitions. */
  public UnaryCallSettings<ListMetastorePartitionsRequest, ListMetastorePartitionsResponse>
      listMetastorePartitionsSettings() {
    return listMetastorePartitionsSettings;
  }

  /** Returns the object with the settings used for calls to streamMetastorePartitions. */
  public StreamingCallSettings<StreamMetastorePartitionsRequest, StreamMetastorePartitionsResponse>
      streamMetastorePartitionsSettings() {
    return streamMetastorePartitionsSettings;
  }

  public MetastorePartitionServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcMetastorePartitionServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "bigquerystorage";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "bigquerystorage.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "bigquerystorage.mtls.googleapis.com:443";
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

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(MetastorePartitionServiceStubSettings.class))
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

  protected MetastorePartitionServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    batchCreateMetastorePartitionsSettings =
        settingsBuilder.batchCreateMetastorePartitionsSettings().build();
    batchDeleteMetastorePartitionsSettings =
        settingsBuilder.batchDeleteMetastorePartitionsSettings().build();
    batchUpdateMetastorePartitionsSettings =
        settingsBuilder.batchUpdateMetastorePartitionsSettings().build();
    listMetastorePartitionsSettings = settingsBuilder.listMetastorePartitionsSettings().build();
    streamMetastorePartitionsSettings = settingsBuilder.streamMetastorePartitionsSettings().build();
  }

  /** Builder for MetastorePartitionServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<MetastorePartitionServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<
            BatchCreateMetastorePartitionsRequest, BatchCreateMetastorePartitionsResponse>
        batchCreateMetastorePartitionsSettings;
    private final UnaryCallSettings.Builder<BatchDeleteMetastorePartitionsRequest, Empty>
        batchDeleteMetastorePartitionsSettings;
    private final UnaryCallSettings.Builder<
            BatchUpdateMetastorePartitionsRequest, BatchUpdateMetastorePartitionsResponse>
        batchUpdateMetastorePartitionsSettings;
    private final UnaryCallSettings.Builder<
            ListMetastorePartitionsRequest, ListMetastorePartitionsResponse>
        listMetastorePartitionsSettings;
    private final StreamingCallSettings.Builder<
            StreamMetastorePartitionsRequest, StreamMetastorePartitionsResponse>
        streamMetastorePartitionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(240000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(240000L))
              .setTotalTimeoutDuration(Duration.ofMillis(240000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(240000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(240000L))
              .setTotalTimeoutDuration(Duration.ofMillis(240000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      batchCreateMetastorePartitionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeleteMetastorePartitionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateMetastorePartitionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listMetastorePartitionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      streamMetastorePartitionsSettings = StreamingCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              batchCreateMetastorePartitionsSettings,
              batchDeleteMetastorePartitionsSettings,
              batchUpdateMetastorePartitionsSettings,
              listMetastorePartitionsSettings);
      initDefaults(this);
    }

    protected Builder(MetastorePartitionServiceStubSettings settings) {
      super(settings);

      batchCreateMetastorePartitionsSettings =
          settings.batchCreateMetastorePartitionsSettings.toBuilder();
      batchDeleteMetastorePartitionsSettings =
          settings.batchDeleteMetastorePartitionsSettings.toBuilder();
      batchUpdateMetastorePartitionsSettings =
          settings.batchUpdateMetastorePartitionsSettings.toBuilder();
      listMetastorePartitionsSettings = settings.listMetastorePartitionsSettings.toBuilder();
      streamMetastorePartitionsSettings = settings.streamMetastorePartitionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              batchCreateMetastorePartitionsSettings,
              batchDeleteMetastorePartitionsSettings,
              batchUpdateMetastorePartitionsSettings,
              listMetastorePartitionsSettings);
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

    private static Builder initDefaults(Builder builder) {
      builder
          .batchCreateMetastorePartitionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchDeleteMetastorePartitionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchUpdateMetastorePartitionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listMetastorePartitionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

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

    /** Returns the builder for the settings used for calls to batchCreateMetastorePartitions. */
    public UnaryCallSettings.Builder<
            BatchCreateMetastorePartitionsRequest, BatchCreateMetastorePartitionsResponse>
        batchCreateMetastorePartitionsSettings() {
      return batchCreateMetastorePartitionsSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeleteMetastorePartitions. */
    public UnaryCallSettings.Builder<BatchDeleteMetastorePartitionsRequest, Empty>
        batchDeleteMetastorePartitionsSettings() {
      return batchDeleteMetastorePartitionsSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateMetastorePartitions. */
    public UnaryCallSettings.Builder<
            BatchUpdateMetastorePartitionsRequest, BatchUpdateMetastorePartitionsResponse>
        batchUpdateMetastorePartitionsSettings() {
      return batchUpdateMetastorePartitionsSettings;
    }

    /** Returns the builder for the settings used for calls to listMetastorePartitions. */
    public UnaryCallSettings.Builder<
            ListMetastorePartitionsRequest, ListMetastorePartitionsResponse>
        listMetastorePartitionsSettings() {
      return listMetastorePartitionsSettings;
    }

    /** Returns the builder for the settings used for calls to streamMetastorePartitions. */
    public StreamingCallSettings.Builder<
            StreamMetastorePartitionsRequest, StreamMetastorePartitionsResponse>
        streamMetastorePartitionsSettings() {
      return streamMetastorePartitionsSettings;
    }

    @Override
    public MetastorePartitionServiceStubSettings build() throws IOException {
      return new MetastorePartitionServiceStubSettings(this);
    }
  }
}
