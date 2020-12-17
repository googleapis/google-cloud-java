/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.bigquery.storage.v1beta1.stub;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
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
import com.google.cloud.bigquery.storage.v1beta1.Storage;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link BigQueryStorageStub}.
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
 * <p>For example, to set the total timeout of createReadSession to 30 seconds:
 *
 * <pre>{@code
 * BigQueryStorageStubSettings.Builder bigQueryStorageSettingsBuilder =
 *     BigQueryStorageStubSettings.newBuilder();
 * bigQueryStorageSettingsBuilder
 *     .createReadSessionSettings()
 *     .setRetrySettings(
 *         bigQueryStorageSettingsBuilder
 *             .createReadSessionSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * BigQueryStorageStubSettings bigQueryStorageSettings = bigQueryStorageSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class BigQueryStorageStubSettings extends StubSettings<BigQueryStorageStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/bigquery")
          .add("https://www.googleapis.com/auth/bigquery.readonly")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<Storage.CreateReadSessionRequest, Storage.ReadSession>
      createReadSessionSettings;
  private final ServerStreamingCallSettings<Storage.ReadRowsRequest, Storage.ReadRowsResponse>
      readRowsSettings;
  private final UnaryCallSettings<
          Storage.BatchCreateReadSessionStreamsRequest,
          Storage.BatchCreateReadSessionStreamsResponse>
      batchCreateReadSessionStreamsSettings;
  private final UnaryCallSettings<Storage.FinalizeStreamRequest, Empty> finalizeStreamSettings;
  private final UnaryCallSettings<Storage.SplitReadStreamRequest, Storage.SplitReadStreamResponse>
      splitReadStreamSettings;

  /** Returns the object with the settings used for calls to createReadSession. */
  public UnaryCallSettings<Storage.CreateReadSessionRequest, Storage.ReadSession>
      createReadSessionSettings() {
    return createReadSessionSettings;
  }

  /** Returns the object with the settings used for calls to readRows. */
  public ServerStreamingCallSettings<Storage.ReadRowsRequest, Storage.ReadRowsResponse>
      readRowsSettings() {
    return readRowsSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateReadSessionStreams. */
  public UnaryCallSettings<
          Storage.BatchCreateReadSessionStreamsRequest,
          Storage.BatchCreateReadSessionStreamsResponse>
      batchCreateReadSessionStreamsSettings() {
    return batchCreateReadSessionStreamsSettings;
  }

  /** Returns the object with the settings used for calls to finalizeStream. */
  public UnaryCallSettings<Storage.FinalizeStreamRequest, Empty> finalizeStreamSettings() {
    return finalizeStreamSettings;
  }

  /** Returns the object with the settings used for calls to splitReadStream. */
  public UnaryCallSettings<Storage.SplitReadStreamRequest, Storage.SplitReadStreamResponse>
      splitReadStreamSettings() {
    return splitReadStreamSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public BigQueryStorageStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcBigQueryStorageStub.create(this);
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
    return "bigquerystorage.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
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
            "gapic", GaxProperties.getLibraryVersion(BigQueryStorageStubSettings.class))
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

  protected BigQueryStorageStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createReadSessionSettings = settingsBuilder.createReadSessionSettings().build();
    readRowsSettings = settingsBuilder.readRowsSettings().build();
    batchCreateReadSessionStreamsSettings =
        settingsBuilder.batchCreateReadSessionStreamsSettings().build();
    finalizeStreamSettings = settingsBuilder.finalizeStreamSettings().build();
    splitReadStreamSettings = settingsBuilder.splitReadStreamSettings().build();
  }

  /** Builder for BigQueryStorageStubSettings. */
  public static class Builder extends StubSettings.Builder<BigQueryStorageStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<Storage.CreateReadSessionRequest, Storage.ReadSession>
        createReadSessionSettings;
    private final ServerStreamingCallSettings.Builder<
            Storage.ReadRowsRequest, Storage.ReadRowsResponse>
        readRowsSettings;
    private final UnaryCallSettings.Builder<
            Storage.BatchCreateReadSessionStreamsRequest,
            Storage.BatchCreateReadSessionStreamsResponse>
        batchCreateReadSessionStreamsSettings;
    private final UnaryCallSettings.Builder<Storage.FinalizeStreamRequest, Empty>
        finalizeStreamSettings;
    private final UnaryCallSettings.Builder<
            Storage.SplitReadStreamRequest, Storage.SplitReadStreamResponse>
        splitReadStreamSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "retry_policy_1_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "retry_policy_2_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(86400000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(86400000L))
              .setTotalTimeout(Duration.ofMillis(86400000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_2_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createReadSessionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      readRowsSettings = ServerStreamingCallSettings.newBuilder();
      batchCreateReadSessionStreamsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      finalizeStreamSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      splitReadStreamSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createReadSessionSettings,
              batchCreateReadSessionStreamsSettings,
              finalizeStreamSettings,
              splitReadStreamSettings);
      initDefaults(this);
    }

    protected Builder(BigQueryStorageStubSettings settings) {
      super(settings);

      createReadSessionSettings = settings.createReadSessionSettings.toBuilder();
      readRowsSettings = settings.readRowsSettings.toBuilder();
      batchCreateReadSessionStreamsSettings =
          settings.batchCreateReadSessionStreamsSettings.toBuilder();
      finalizeStreamSettings = settings.finalizeStreamSettings.toBuilder();
      splitReadStreamSettings = settings.splitReadStreamSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createReadSessionSettings,
              batchCreateReadSessionStreamsSettings,
              finalizeStreamSettings,
              splitReadStreamSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createReadSessionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .readRowsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .batchCreateReadSessionStreamsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .finalizeStreamSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .splitReadStreamSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      return builder;
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to createReadSession. */
    public UnaryCallSettings.Builder<Storage.CreateReadSessionRequest, Storage.ReadSession>
        createReadSessionSettings() {
      return createReadSessionSettings;
    }

    /** Returns the builder for the settings used for calls to readRows. */
    public ServerStreamingCallSettings.Builder<Storage.ReadRowsRequest, Storage.ReadRowsResponse>
        readRowsSettings() {
      return readRowsSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateReadSessionStreams. */
    public UnaryCallSettings.Builder<
            Storage.BatchCreateReadSessionStreamsRequest,
            Storage.BatchCreateReadSessionStreamsResponse>
        batchCreateReadSessionStreamsSettings() {
      return batchCreateReadSessionStreamsSettings;
    }

    /** Returns the builder for the settings used for calls to finalizeStream. */
    public UnaryCallSettings.Builder<Storage.FinalizeStreamRequest, Empty>
        finalizeStreamSettings() {
      return finalizeStreamSettings;
    }

    /** Returns the builder for the settings used for calls to splitReadStream. */
    public UnaryCallSettings.Builder<
            Storage.SplitReadStreamRequest, Storage.SplitReadStreamResponse>
        splitReadStreamSettings() {
      return splitReadStreamSettings;
    }

    @Override
    public BigQueryStorageStubSettings build() throws IOException {
      return new BigQueryStorageStubSettings(this);
    }
  }
}
