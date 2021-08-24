/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.bigtable.data.v2.stub;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.bigtable.v2.CheckAndMutateRowRequest;
import com.google.bigtable.v2.CheckAndMutateRowResponse;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowResponse;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.bigtable.v2.ReadModifyWriteRowRequest;
import com.google.bigtable.v2.ReadModifyWriteRowResponse;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.SampleRowKeysRequest;
import com.google.bigtable.v2.SampleRowKeysResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/** For internal use only. */
@Generated("by gapic-generator")
@InternalApi
public class BigtableStubSettings extends StubSettings<BigtableStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/bigtable.data")
          .add("https://www.googleapis.com/auth/bigtable.data.readonly")
          .add("https://www.googleapis.com/auth/cloud-bigtable.data")
          .add("https://www.googleapis.com/auth/cloud-bigtable.data.readonly")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .build();

  private final ServerStreamingCallSettings<ReadRowsRequest, ReadRowsResponse> readRowsSettings;
  private final ServerStreamingCallSettings<SampleRowKeysRequest, SampleRowKeysResponse>
      sampleRowKeysSettings;
  private final UnaryCallSettings<MutateRowRequest, MutateRowResponse> mutateRowSettings;
  private final ServerStreamingCallSettings<MutateRowsRequest, MutateRowsResponse>
      mutateRowsSettings;
  private final UnaryCallSettings<CheckAndMutateRowRequest, CheckAndMutateRowResponse>
      checkAndMutateRowSettings;
  private final UnaryCallSettings<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse>
      readModifyWriteRowSettings;

  /** Returns the object with the settings used for calls to readRows. */
  public ServerStreamingCallSettings<ReadRowsRequest, ReadRowsResponse> readRowsSettings() {
    return readRowsSettings;
  }

  /** Returns the object with the settings used for calls to sampleRowKeys. */
  public ServerStreamingCallSettings<SampleRowKeysRequest, SampleRowKeysResponse>
      sampleRowKeysSettings() {
    return sampleRowKeysSettings;
  }

  /** Returns the object with the settings used for calls to mutateRow. */
  public UnaryCallSettings<MutateRowRequest, MutateRowResponse> mutateRowSettings() {
    return mutateRowSettings;
  }

  /** Returns the object with the settings used for calls to mutateRows. */
  public ServerStreamingCallSettings<MutateRowsRequest, MutateRowsResponse> mutateRowsSettings() {
    return mutateRowsSettings;
  }

  /** Returns the object with the settings used for calls to checkAndMutateRow. */
  public UnaryCallSettings<CheckAndMutateRowRequest, CheckAndMutateRowResponse>
      checkAndMutateRowSettings() {
    return checkAndMutateRowSettings;
  }

  /** Returns the object with the settings used for calls to readModifyWriteRow. */
  public UnaryCallSettings<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse>
      readModifyWriteRowSettings() {
    return readModifyWriteRowSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public BigtableStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcBigtableStub.create(this);
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
    return "bigtable.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "bigtable.mtls.googleapis.com:443";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(BigtableStubSettings.class))
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

  protected BigtableStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    readRowsSettings = settingsBuilder.readRowsSettings().build();
    sampleRowKeysSettings = settingsBuilder.sampleRowKeysSettings().build();
    mutateRowSettings = settingsBuilder.mutateRowSettings().build();
    mutateRowsSettings = settingsBuilder.mutateRowsSettings().build();
    checkAndMutateRowSettings = settingsBuilder.checkAndMutateRowSettings().build();
    readModifyWriteRowSettings = settingsBuilder.readModifyWriteRowSettings().build();
  }

  /** Builder for BigtableStubSettings. */
  public static class Builder extends StubSettings.Builder<BigtableStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final ServerStreamingCallSettings.Builder<ReadRowsRequest, ReadRowsResponse>
        readRowsSettings;
    private final ServerStreamingCallSettings.Builder<SampleRowKeysRequest, SampleRowKeysResponse>
        sampleRowKeysSettings;
    private final UnaryCallSettings.Builder<MutateRowRequest, MutateRowResponse> mutateRowSettings;
    private final ServerStreamingCallSettings.Builder<MutateRowsRequest, MutateRowsResponse>
        mutateRowsSettings;
    private final UnaryCallSettings.Builder<CheckAndMutateRowRequest, CheckAndMutateRowResponse>
        checkAndMutateRowSettings;
    private final UnaryCallSettings.Builder<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse>
        readModifyWriteRowSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_3_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_4_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.DEADLINE_EXCEEDED)));
      definitions.put(
          "retry_policy_2_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(10L))
              .setRetryDelayMultiplier(2.0)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(43200000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(43200000L))
              .setTotalTimeout(Duration.ofMillis(43200000L))
              .build();
      definitions.put("retry_policy_3_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(10L))
              .setRetryDelayMultiplier(2.0)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(10L))
              .setRetryDelayMultiplier(2.0)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_4_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(10L))
              .setRetryDelayMultiplier(2.0)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_2_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(10L))
              .setRetryDelayMultiplier(2.0)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(20000L))
              .setTotalTimeout(Duration.ofMillis(20000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      readRowsSettings = ServerStreamingCallSettings.newBuilder();
      sampleRowKeysSettings = ServerStreamingCallSettings.newBuilder();
      mutateRowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      mutateRowsSettings = ServerStreamingCallSettings.newBuilder();
      checkAndMutateRowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      readModifyWriteRowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              mutateRowSettings, checkAndMutateRowSettings, readModifyWriteRowSettings);
      initDefaults(this);
    }

    protected Builder(BigtableStubSettings settings) {
      super(settings);

      readRowsSettings = settings.readRowsSettings.toBuilder();
      sampleRowKeysSettings = settings.sampleRowKeysSettings.toBuilder();
      mutateRowSettings = settings.mutateRowSettings.toBuilder();
      mutateRowsSettings = settings.mutateRowsSettings.toBuilder();
      checkAndMutateRowSettings = settings.checkAndMutateRowSettings.toBuilder();
      readModifyWriteRowSettings = settings.readModifyWriteRowSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              mutateRowSettings, checkAndMutateRowSettings, readModifyWriteRowSettings);
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
          .readRowsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .sampleRowKeysSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .mutateRowSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_4_params"));

      builder
          .mutateRowsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .checkAndMutateRowSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .readModifyWriteRowSettings()
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

    /** Returns the builder for the settings used for calls to readRows. */
    public ServerStreamingCallSettings.Builder<ReadRowsRequest, ReadRowsResponse>
        readRowsSettings() {
      return readRowsSettings;
    }

    /** Returns the builder for the settings used for calls to sampleRowKeys. */
    public ServerStreamingCallSettings.Builder<SampleRowKeysRequest, SampleRowKeysResponse>
        sampleRowKeysSettings() {
      return sampleRowKeysSettings;
    }

    /** Returns the builder for the settings used for calls to mutateRow. */
    public UnaryCallSettings.Builder<MutateRowRequest, MutateRowResponse> mutateRowSettings() {
      return mutateRowSettings;
    }

    /** Returns the builder for the settings used for calls to mutateRows. */
    public ServerStreamingCallSettings.Builder<MutateRowsRequest, MutateRowsResponse>
        mutateRowsSettings() {
      return mutateRowsSettings;
    }

    /** Returns the builder for the settings used for calls to checkAndMutateRow. */
    public UnaryCallSettings.Builder<CheckAndMutateRowRequest, CheckAndMutateRowResponse>
        checkAndMutateRowSettings() {
      return checkAndMutateRowSettings;
    }

    /** Returns the builder for the settings used for calls to readModifyWriteRow. */
    public UnaryCallSettings.Builder<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse>
        readModifyWriteRowSettings() {
      return readModifyWriteRowSettings;
    }

    @Override
    public BigtableStubSettings build() throws IOException {
      return new BigtableStubSettings(this);
    }
  }
}
