/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigquery.storage.v1beta1.stub;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsResponse;
import com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.FinalizeStreamRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession;
import com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamResponse;
import com.google.cloud.bigquery.storage.v1beta1.stub.readrows.ReadRowsResumptionStrategy;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.Empty;
import java.util.List;

/**
 * Settings class to configure an instance of {@link EnhancedBigQueryStorageStub}.
 *
 * <p>The default instance dynamically reads and applies the default values used by {@link
 * BigQueryStorageStub}.
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of createReadSession to 30 seconds:
 *
 * <pre>
 * <code>
 * EnhancedBigQueryStorageStubSettings.Builder builder =
 *     EnhancedBigQueryStorageStubSettings.newBuilder();
 * builder.createReadSessionSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * EnhancedBigQueryStorageStubSettings settings = builder.build();
 * </code>
 * </pre>
 */
public class EnhancedBigQueryStorageStubSettings
    extends StubSettings<EnhancedBigQueryStorageStubSettings> {

  private final UnaryCallSettings<CreateReadSessionRequest, ReadSession> createReadSessionSettings;
  private final ServerStreamingCallSettings<ReadRowsRequest, ReadRowsResponse> readRowsSettings;
  private final UnaryCallSettings<
          BatchCreateReadSessionStreamsRequest, BatchCreateReadSessionStreamsResponse>
      batchCreateReadSessionStreamsSettings;
  private final UnaryCallSettings<FinalizeStreamRequest, Empty> finalizeStreamSettings;
  private final UnaryCallSettings<SplitReadStreamRequest, SplitReadStreamResponse>
      splitReadStreamSettings;

  /** Returns the object with the settings used for calls to createReadSession. */
  public UnaryCallSettings<CreateReadSessionRequest, ReadSession> createReadSessionSettings() {
    return createReadSessionSettings;
  }

  /** Returns the object with the settings used for calls to readRows. */
  public ServerStreamingCallSettings<ReadRowsRequest, ReadRowsResponse> readRowsSettings() {
    return readRowsSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateReadSessionStreams. */
  public UnaryCallSettings<
          BatchCreateReadSessionStreamsRequest, BatchCreateReadSessionStreamsResponse>
      batchCreateReadSessionStreamsSettings() {
    return batchCreateReadSessionStreamsSettings;
  }

  /** Returns the object with the settings used for calls to finalizeStream. */
  public UnaryCallSettings<FinalizeStreamRequest, Empty> finalizeStreamSettings() {
    return finalizeStreamSettings;
  }

  /** Returns the object with the settings used for calls to splitReadStream. */
  public UnaryCallSettings<SplitReadStreamRequest, SplitReadStreamResponse>
      splitReadStreamSettings() {
    return splitReadStreamSettings;
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return BigQueryStorageStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return BigQueryStorageStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return BigQueryStorageStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return BigQueryStorageStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return BigQueryStorageStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BigQueryStorageStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return new Builder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected EnhancedBigQueryStorageStubSettings(Builder settingsBuilder) {
    super(settingsBuilder);

    createReadSessionSettings = settingsBuilder.createReadSessionSettings().build();
    readRowsSettings = settingsBuilder.readRowsSettings().build();
    batchCreateReadSessionStreamsSettings =
        settingsBuilder.batchCreateReadSessionStreamsSettings().build();
    finalizeStreamSettings = settingsBuilder.finalizeStreamSettings().build();
    splitReadStreamSettings = settingsBuilder.splitReadStreamSettings().build();
  }

  /** Builder for {@link EnhancedBigQueryStorageStubSettings}. */
  public static class Builder
      extends StubSettings.Builder<EnhancedBigQueryStorageStubSettings, Builder> {

    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<CreateReadSessionRequest, ReadSession>
        createReadSessionSettings;
    private final ServerStreamingCallSettings.Builder<ReadRowsRequest, ReadRowsResponse>
        readRowsSettings;
    private final UnaryCallSettings.Builder<
            BatchCreateReadSessionStreamsRequest, BatchCreateReadSessionStreamsResponse>
        batchCreateReadSessionStreamsSettings;
    private final UnaryCallSettings.Builder<FinalizeStreamRequest, Empty> finalizeStreamSettings;
    private final UnaryCallSettings.Builder<SplitReadStreamRequest, SplitReadStreamResponse>
        splitReadStreamSettings;

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      // Defaults provider
      BigQueryStorageStubSettings.Builder baseDefaults = BigQueryStorageStubSettings.newBuilder();
      setEndpoint(baseDefaults.getEndpoint());
      setTransportChannelProvider(defaultTransportChannelProvider());
      setCredentialsProvider(baseDefaults.getCredentialsProvider());
      setStreamWatchdogCheckInterval(baseDefaults.getStreamWatchdogCheckInterval());
      setStreamWatchdogProvider(baseDefaults.getStreamWatchdogProvider());

      // Per-method settings using baseSettings for defaults.
      createReadSessionSettings = baseDefaults.createReadSessionSettings();
      batchCreateReadSessionStreamsSettings = baseDefaults.batchCreateReadSessionStreamsSettings();
      finalizeStreamSettings = baseDefaults.finalizeStreamSettings();
      splitReadStreamSettings = baseDefaults.splitReadStreamSettings();

      // Per-method settings using override values for defaults.
      readRowsSettings =
          baseDefaults.readRowsSettings().setResumptionStrategy(new ReadRowsResumptionStrategy());

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createReadSessionSettings,
              batchCreateReadSessionStreamsSettings,
              finalizeStreamSettings,
              splitReadStreamSettings);
    }

    protected Builder(EnhancedBigQueryStorageStubSettings settings) {
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

    // NEXT_MAJOR_VER: remove 'throws Exception'
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
    public UnaryCallSettings.Builder<CreateReadSessionRequest, ReadSession>
        createReadSessionSettings() {
      return createReadSessionSettings;
    }

    /** Returns the builder for the settings used for calls to readRows. */
    public ServerStreamingCallSettings.Builder<ReadRowsRequest, ReadRowsResponse>
        readRowsSettings() {
      return readRowsSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateReadSessionStreams. */
    public UnaryCallSettings.Builder<
            BatchCreateReadSessionStreamsRequest, BatchCreateReadSessionStreamsResponse>
        batchCreateReadSessionStreamsSettings() {
      return batchCreateReadSessionStreamsSettings;
    }

    /** Returns the builder for the settings used for calls to finalizeStream. */
    public UnaryCallSettings.Builder<FinalizeStreamRequest, Empty> finalizeStreamSettings() {
      return finalizeStreamSettings;
    }

    /** Returns the builder for the settings used for calls to splitReadStream. */
    public UnaryCallSettings.Builder<SplitReadStreamRequest, SplitReadStreamResponse>
        splitReadStreamSettings() {
      return splitReadStreamSettings;
    }

    @Override
    public EnhancedBigQueryStorageStubSettings build() {
      return new EnhancedBigQueryStorageStubSettings(this);
    }
  }
}
