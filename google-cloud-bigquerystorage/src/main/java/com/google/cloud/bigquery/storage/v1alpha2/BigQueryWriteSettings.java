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

package com.google.cloud.bigquery.storage.v1alpha2;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.bigquery.storage.v1alpha2.stub.BigQueryWriteStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link BigQueryWriteClient}.
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
 * BigQueryWriteSettings.Builder bigQueryWriteSettingsBuilder = BigQueryWriteSettings.newBuilder();
 * bigQueryWriteSettingsBuilder
 *     .createWriteStreamSettings()
 *     .setRetrySettings(
 *         bigQueryWriteSettingsBuilder
 *             .createWriteStreamSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * BigQueryWriteSettings bigQueryWriteSettings = bigQueryWriteSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class BigQueryWriteSettings extends ClientSettings<BigQueryWriteSettings> {

  /** Returns the object with the settings used for calls to createWriteStream. */
  public UnaryCallSettings<Storage.CreateWriteStreamRequest, Stream.WriteStream>
      createWriteStreamSettings() {
    return ((BigQueryWriteStubSettings) getStubSettings()).createWriteStreamSettings();
  }

  /** Returns the object with the settings used for calls to appendRows. */
  public StreamingCallSettings<Storage.AppendRowsRequest, Storage.AppendRowsResponse>
      appendRowsSettings() {
    return ((BigQueryWriteStubSettings) getStubSettings()).appendRowsSettings();
  }

  /** Returns the object with the settings used for calls to getWriteStream. */
  public UnaryCallSettings<Storage.GetWriteStreamRequest, Stream.WriteStream>
      getWriteStreamSettings() {
    return ((BigQueryWriteStubSettings) getStubSettings()).getWriteStreamSettings();
  }

  /** Returns the object with the settings used for calls to finalizeWriteStream. */
  public UnaryCallSettings<Storage.FinalizeWriteStreamRequest, Storage.FinalizeWriteStreamResponse>
      finalizeWriteStreamSettings() {
    return ((BigQueryWriteStubSettings) getStubSettings()).finalizeWriteStreamSettings();
  }

  /** Returns the object with the settings used for calls to batchCommitWriteStreams. */
  public UnaryCallSettings<
          Storage.BatchCommitWriteStreamsRequest, Storage.BatchCommitWriteStreamsResponse>
      batchCommitWriteStreamsSettings() {
    return ((BigQueryWriteStubSettings) getStubSettings()).batchCommitWriteStreamsSettings();
  }

  /** Returns the object with the settings used for calls to flushRows. */
  public UnaryCallSettings<Storage.FlushRowsRequest, Storage.FlushRowsResponse>
      flushRowsSettings() {
    return ((BigQueryWriteStubSettings) getStubSettings()).flushRowsSettings();
  }

  public static final BigQueryWriteSettings create(BigQueryWriteStubSettings stub)
      throws IOException {
    return new BigQueryWriteSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return BigQueryWriteStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return BigQueryWriteStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return BigQueryWriteStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return BigQueryWriteStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return BigQueryWriteStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return BigQueryWriteStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BigQueryWriteStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected BigQueryWriteSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for BigQueryWriteSettings. */
  public static class Builder extends ClientSettings.Builder<BigQueryWriteSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(BigQueryWriteStubSettings.newBuilder(clientContext));
    }

    protected Builder(BigQueryWriteSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(BigQueryWriteStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(BigQueryWriteStubSettings.newBuilder());
    }

    public BigQueryWriteStubSettings.Builder getStubSettingsBuilder() {
      return ((BigQueryWriteStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to createWriteStream. */
    public UnaryCallSettings.Builder<Storage.CreateWriteStreamRequest, Stream.WriteStream>
        createWriteStreamSettings() {
      return getStubSettingsBuilder().createWriteStreamSettings();
    }

    /** Returns the builder for the settings used for calls to appendRows. */
    public StreamingCallSettings.Builder<Storage.AppendRowsRequest, Storage.AppendRowsResponse>
        appendRowsSettings() {
      return getStubSettingsBuilder().appendRowsSettings();
    }

    /** Returns the builder for the settings used for calls to getWriteStream. */
    public UnaryCallSettings.Builder<Storage.GetWriteStreamRequest, Stream.WriteStream>
        getWriteStreamSettings() {
      return getStubSettingsBuilder().getWriteStreamSettings();
    }

    /** Returns the builder for the settings used for calls to finalizeWriteStream. */
    public UnaryCallSettings.Builder<
            Storage.FinalizeWriteStreamRequest, Storage.FinalizeWriteStreamResponse>
        finalizeWriteStreamSettings() {
      return getStubSettingsBuilder().finalizeWriteStreamSettings();
    }

    /** Returns the builder for the settings used for calls to batchCommitWriteStreams. */
    public UnaryCallSettings.Builder<
            Storage.BatchCommitWriteStreamsRequest, Storage.BatchCommitWriteStreamsResponse>
        batchCommitWriteStreamsSettings() {
      return getStubSettingsBuilder().batchCommitWriteStreamsSettings();
    }

    /** Returns the builder for the settings used for calls to flushRows. */
    public UnaryCallSettings.Builder<Storage.FlushRowsRequest, Storage.FlushRowsResponse>
        flushRowsSettings() {
      return getStubSettingsBuilder().flushRowsSettings();
    }

    @Override
    public BigQueryWriteSettings build() throws IOException {
      return new BigQueryWriteSettings(this);
    }
  }
}
