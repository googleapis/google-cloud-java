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

package com.google.cloud.bigquery.storage.v1alpha2.stub;

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
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.bigquery.storage.v1alpha2.Storage;
import com.google.cloud.bigquery.storage.v1alpha2.Stream;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link BigQueryWriteStub}.
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
 * <p>For example, to set the total timeout of createWriteStream to 30 seconds:
 *
 * <pre>{@code
 * BigQueryWriteStubSettings.Builder bigQueryWriteSettingsBuilder =
 *     BigQueryWriteStubSettings.newBuilder();
 * bigQueryWriteSettingsBuilder
 *     .createWriteStreamSettings()
 *     .setRetrySettings(
 *         bigQueryWriteSettingsBuilder
 *             .createWriteStreamSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * BigQueryWriteStubSettings bigQueryWriteSettings = bigQueryWriteSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class BigQueryWriteStubSettings extends StubSettings<BigQueryWriteStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/bigquery")
          .add("https://www.googleapis.com/auth/bigquery.insertdata")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<Storage.CreateWriteStreamRequest, Stream.WriteStream>
      createWriteStreamSettings;
  private final StreamingCallSettings<Storage.AppendRowsRequest, Storage.AppendRowsResponse>
      appendRowsSettings;
  private final UnaryCallSettings<Storage.GetWriteStreamRequest, Stream.WriteStream>
      getWriteStreamSettings;
  private final UnaryCallSettings<
          Storage.FinalizeWriteStreamRequest, Storage.FinalizeWriteStreamResponse>
      finalizeWriteStreamSettings;
  private final UnaryCallSettings<
          Storage.BatchCommitWriteStreamsRequest, Storage.BatchCommitWriteStreamsResponse>
      batchCommitWriteStreamsSettings;
  private final UnaryCallSettings<Storage.FlushRowsRequest, Storage.FlushRowsResponse>
      flushRowsSettings;

  /** Returns the object with the settings used for calls to createWriteStream. */
  public UnaryCallSettings<Storage.CreateWriteStreamRequest, Stream.WriteStream>
      createWriteStreamSettings() {
    return createWriteStreamSettings;
  }

  /** Returns the object with the settings used for calls to appendRows. */
  public StreamingCallSettings<Storage.AppendRowsRequest, Storage.AppendRowsResponse>
      appendRowsSettings() {
    return appendRowsSettings;
  }

  /** Returns the object with the settings used for calls to getWriteStream. */
  public UnaryCallSettings<Storage.GetWriteStreamRequest, Stream.WriteStream>
      getWriteStreamSettings() {
    return getWriteStreamSettings;
  }

  /** Returns the object with the settings used for calls to finalizeWriteStream. */
  public UnaryCallSettings<Storage.FinalizeWriteStreamRequest, Storage.FinalizeWriteStreamResponse>
      finalizeWriteStreamSettings() {
    return finalizeWriteStreamSettings;
  }

  /** Returns the object with the settings used for calls to batchCommitWriteStreams. */
  public UnaryCallSettings<
          Storage.BatchCommitWriteStreamsRequest, Storage.BatchCommitWriteStreamsResponse>
      batchCommitWriteStreamsSettings() {
    return batchCommitWriteStreamsSettings;
  }

  /** Returns the object with the settings used for calls to flushRows. */
  public UnaryCallSettings<Storage.FlushRowsRequest, Storage.FlushRowsResponse>
      flushRowsSettings() {
    return flushRowsSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public BigQueryWriteStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcBigQueryWriteStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(BigQueryWriteStubSettings.class))
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

  protected BigQueryWriteStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createWriteStreamSettings = settingsBuilder.createWriteStreamSettings().build();
    appendRowsSettings = settingsBuilder.appendRowsSettings().build();
    getWriteStreamSettings = settingsBuilder.getWriteStreamSettings().build();
    finalizeWriteStreamSettings = settingsBuilder.finalizeWriteStreamSettings().build();
    batchCommitWriteStreamsSettings = settingsBuilder.batchCommitWriteStreamsSettings().build();
    flushRowsSettings = settingsBuilder.flushRowsSettings().build();
  }

  /** Builder for BigQueryWriteStubSettings. */
  public static class Builder extends StubSettings.Builder<BigQueryWriteStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<Storage.CreateWriteStreamRequest, Stream.WriteStream>
        createWriteStreamSettings;
    private final StreamingCallSettings.Builder<
            Storage.AppendRowsRequest, Storage.AppendRowsResponse>
        appendRowsSettings;
    private final UnaryCallSettings.Builder<Storage.GetWriteStreamRequest, Stream.WriteStream>
        getWriteStreamSettings;
    private final UnaryCallSettings.Builder<
            Storage.FinalizeWriteStreamRequest, Storage.FinalizeWriteStreamResponse>
        finalizeWriteStreamSettings;
    private final UnaryCallSettings.Builder<
            Storage.BatchCommitWriteStreamsRequest, Storage.BatchCommitWriteStreamsResponse>
        batchCommitWriteStreamsSettings;
    private final UnaryCallSettings.Builder<Storage.FlushRowsRequest, Storage.FlushRowsResponse>
        flushRowsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED,
                  StatusCode.Code.UNAVAILABLE,
                  StatusCode.Code.RESOURCE_EXHAUSTED)));
      definitions.put(
          "retry_policy_1_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.RESOURCE_EXHAUSTED)));
      definitions.put(
          "retry_policy_2_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createWriteStreamSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      appendRowsSettings = StreamingCallSettings.newBuilder();
      getWriteStreamSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      finalizeWriteStreamSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCommitWriteStreamsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      flushRowsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createWriteStreamSettings,
              getWriteStreamSettings,
              finalizeWriteStreamSettings,
              batchCommitWriteStreamsSettings,
              flushRowsSettings);
      initDefaults(this);
    }

    protected Builder(BigQueryWriteStubSettings settings) {
      super(settings);

      createWriteStreamSettings = settings.createWriteStreamSettings.toBuilder();
      appendRowsSettings = settings.appendRowsSettings.toBuilder();
      getWriteStreamSettings = settings.getWriteStreamSettings.toBuilder();
      finalizeWriteStreamSettings = settings.finalizeWriteStreamSettings.toBuilder();
      batchCommitWriteStreamsSettings = settings.batchCommitWriteStreamsSettings.toBuilder();
      flushRowsSettings = settings.flushRowsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createWriteStreamSettings,
              getWriteStreamSettings,
              finalizeWriteStreamSettings,
              batchCommitWriteStreamsSettings,
              flushRowsSettings);
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
          .createWriteStreamSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getWriteStreamSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .finalizeWriteStreamSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .batchCommitWriteStreamsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .flushRowsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

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

    /** Returns the builder for the settings used for calls to createWriteStream. */
    public UnaryCallSettings.Builder<Storage.CreateWriteStreamRequest, Stream.WriteStream>
        createWriteStreamSettings() {
      return createWriteStreamSettings;
    }

    /** Returns the builder for the settings used for calls to appendRows. */
    public StreamingCallSettings.Builder<Storage.AppendRowsRequest, Storage.AppendRowsResponse>
        appendRowsSettings() {
      return appendRowsSettings;
    }

    /** Returns the builder for the settings used for calls to getWriteStream. */
    public UnaryCallSettings.Builder<Storage.GetWriteStreamRequest, Stream.WriteStream>
        getWriteStreamSettings() {
      return getWriteStreamSettings;
    }

    /** Returns the builder for the settings used for calls to finalizeWriteStream. */
    public UnaryCallSettings.Builder<
            Storage.FinalizeWriteStreamRequest, Storage.FinalizeWriteStreamResponse>
        finalizeWriteStreamSettings() {
      return finalizeWriteStreamSettings;
    }

    /** Returns the builder for the settings used for calls to batchCommitWriteStreams. */
    public UnaryCallSettings.Builder<
            Storage.BatchCommitWriteStreamsRequest, Storage.BatchCommitWriteStreamsResponse>
        batchCommitWriteStreamsSettings() {
      return batchCommitWriteStreamsSettings;
    }

    /** Returns the builder for the settings used for calls to flushRows. */
    public UnaryCallSettings.Builder<Storage.FlushRowsRequest, Storage.FlushRowsResponse>
        flushRowsSettings() {
      return flushRowsSettings;
    }

    @Override
    public BigQueryWriteStubSettings build() throws IOException {
      return new BigQueryWriteStubSettings(this);
    }
  }
}
