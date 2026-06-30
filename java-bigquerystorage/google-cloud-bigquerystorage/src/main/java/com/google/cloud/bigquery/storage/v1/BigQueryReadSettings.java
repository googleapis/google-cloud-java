/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.bigquery.storage.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.bigquery.storage.v1.stub.EnhancedBigQueryReadStubSettings;
import io.grpc.Metadata;
import io.grpc.Status;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.trace.TracerProvider;
import java.io.IOException;
import java.util.List;

/**
 * Settings class to configure an instance of {@link BigQueryReadClient}.
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
 * <pre>
 * <code>
 * BigQueryReadSettings.Builder BigQueryReadSettingsBuilder =
 *     BigQueryReadSettings.newBuilder();
 * BigQueryReadSettingsBuilder.createReadSessionSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * BigQueryReadSettings BigQueryReadSettings = BigQueryReadSettingsBuilder.build();
 * </code>
 * </pre>
 */
@BetaApi
public class BigQueryReadSettings extends ClientSettings<BigQueryReadSettings> {
  /** Returns the object with the settings used for calls to createReadSession. */
  public UnaryCallSettings<CreateReadSessionRequest, ReadSession> createReadSessionSettings() {
    return getTypedStubSettings().createReadSessionSettings();
  }

  /** Returns the object with the settings used for calls to readRows. */
  public ServerStreamingCallSettings<ReadRowsRequest, ReadRowsResponse> readRowsSettings() {
    return getTypedStubSettings().readRowsSettings();
  }

  public static interface RetryAttemptListener {
    public void onRetryAttempt(Status prevStatus, Metadata prevMetadata);
  }

  private RetryAttemptListener readRowsRetryAttemptListener = null;
  private boolean enableOpenTelemetryTracing = false;
  private Tracer openTelemetryTracer = null;
  private TracerProvider openTelemetryTracerProvider = null;

  /**
   * If a non null readRowsRetryAttemptListener is provided, client will call onRetryAttempt
   * function before a failed ReadRows request is retried. This can be used as negative feedback
   * mechanism for future decision to split read streams because some retried failures are due to
   * resource exhaustion that increased parallelism only makes it worse.
   */
  public void setReadRowsRetryAttemptListener(RetryAttemptListener readRowsRetryAttemptListener) {
    this.readRowsRetryAttemptListener = readRowsRetryAttemptListener;
  }

  public void setEnableOpenTelemetryTracing(
      boolean enableOpenTelemetryTracing, TracerProvider openTelemetryTracerProvider) {
    this.enableOpenTelemetryTracing = enableOpenTelemetryTracing;
    if (enableOpenTelemetryTracing) {
      if (openTelemetryTracerProvider == null) {
        this.openTelemetryTracer =
            Singletons.getOpenTelemetry()
                .getTracerProvider()
                .tracerBuilder("com.google.cloud.bigquery.storage.v1.read")
                .build();
      } else {
        this.openTelemetryTracerProvider = openTelemetryTracerProvider;
        this.openTelemetryTracer =
            openTelemetryTracerProvider
                .tracerBuilder("com.google.cloud.bigquery.storage.v1.read")
                .build();
      }
    }
  }

  public RetryAttemptListener getReadRowsRetryAttemptListener() {
    return readRowsRetryAttemptListener;
  }

  public boolean isOpenTelemetryEnabled() {
    return this.enableOpenTelemetryTracing;
  }

  public Tracer getOpenTelemetryTracer() {
    return this.openTelemetryTracer;
  }

  public TracerProvider getOpenTelemetryTracerProvider() {
    return this.openTelemetryTracerProvider;
  }

  /** Returns the object with the settings used for calls to splitReadStream. */
  public UnaryCallSettings<SplitReadStreamRequest, SplitReadStreamResponse>
      splitReadStreamSettings() {
    return getTypedStubSettings().splitReadStreamSettings();
  }

  EnhancedBigQueryReadStubSettings getTypedStubSettings() {
    return (EnhancedBigQueryReadStubSettings) getStubSettings();
  }

  public static final BigQueryReadSettings create(EnhancedBigQueryReadStubSettings stub)
      throws IOException {
    return new BigQueryReadSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return EnhancedBigQueryReadStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return EnhancedBigQueryReadStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return EnhancedBigQueryReadStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return EnhancedBigQueryReadStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return EnhancedBigQueryReadStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return EnhancedBigQueryReadStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return EnhancedBigQueryReadStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected BigQueryReadSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for BigQueryReadSettings. */
  public static class Builder extends ClientSettings.Builder<BigQueryReadSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(EnhancedBigQueryReadStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(EnhancedBigQueryReadStubSettings.newBuilder());
    }

    protected Builder(BigQueryReadSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(EnhancedBigQueryReadStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public EnhancedBigQueryReadStubSettings.Builder getStubSettingsBuilder() {
      return ((EnhancedBigQueryReadStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
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

    private RetryAttemptListener readRowsRetryAttemptListener = null;
    private boolean enableOpenTelemetryTracing = false;
    private TracerProvider openTelemetryTracerProvider = null;

    public Builder setReadRowsRetryAttemptListener(
        RetryAttemptListener readRowsRetryAttemptListener) {
      this.readRowsRetryAttemptListener = readRowsRetryAttemptListener;
      return this;
    }

    public Builder setEnableOpenTelemetryTracing(boolean enableOpenTelemetryTracing) {
      this.enableOpenTelemetryTracing = enableOpenTelemetryTracing;
      return this;
    }

    public Builder setOpenTelemetryTracerProvider(TracerProvider tracerProvider) {
      this.openTelemetryTracerProvider = tracerProvider;
      return this;
    }

    /** Returns the builder for the settings used for calls to createReadSession. */
    public UnaryCallSettings.Builder<CreateReadSessionRequest, ReadSession>
        createReadSessionSettings() {
      return getStubSettingsBuilder().createReadSessionSettings();
    }

    /** Returns the builder for the settings used for calls to readRows. */
    public ServerStreamingCallSettings.Builder<ReadRowsRequest, ReadRowsResponse>
        readRowsSettings() {
      return getStubSettingsBuilder().readRowsSettings();
    }

    /** Returns the builder for the settings used for calls to splitReadStream. */
    public UnaryCallSettings.Builder<SplitReadStreamRequest, SplitReadStreamResponse>
        splitReadStreamSettings() {
      return getStubSettingsBuilder().splitReadStreamSettings();
    }

    @Override
    public BigQueryReadSettings build() throws IOException {
      BigQueryReadSettings settings = new BigQueryReadSettings(this);
      settings.setReadRowsRetryAttemptListener(readRowsRetryAttemptListener);
      settings.setEnableOpenTelemetryTracing(
          enableOpenTelemetryTracing, openTelemetryTracerProvider);
      return settings;
    }
  }
}
