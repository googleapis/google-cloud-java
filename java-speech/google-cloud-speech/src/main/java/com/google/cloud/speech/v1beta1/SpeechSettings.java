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
package com.google.cloud.speech.v1beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.speech.v1beta1.stub.SpeechStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link SpeechClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (speech.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of syncRecognize to 30 seconds:
 *
 * <pre>
 * <code>
 * SpeechSettings.Builder speechSettingsBuilder =
 *     SpeechSettings.newBuilder();
 * speechSettingsBuilder.syncRecognizeSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * SpeechSettings speechSettings = speechSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class SpeechSettings extends ClientSettings<SpeechSettings> {
  /** Returns the object with the settings used for calls to syncRecognize. */
  public UnaryCallSettings<SyncRecognizeRequest, SyncRecognizeResponse> syncRecognizeSettings() {
    return ((SpeechStubSettings) getStubSettings()).syncRecognizeSettings();
  }

  /** Returns the object with the settings used for calls to asyncRecognize. */
  public UnaryCallSettings<AsyncRecognizeRequest, Operation> asyncRecognizeSettings() {
    return ((SpeechStubSettings) getStubSettings()).asyncRecognizeSettings();
  }

  /** Returns the object with the settings used for calls to asyncRecognize. */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public OperationCallSettings<
          AsyncRecognizeRequest, AsyncRecognizeResponse, AsyncRecognizeMetadata>
      asyncRecognizeOperationSettings() {
    return ((SpeechStubSettings) getStubSettings()).asyncRecognizeOperationSettings();
  }

  /** Returns the object with the settings used for calls to streamingRecognize. */
  public StreamingCallSettings<StreamingRecognizeRequest, StreamingRecognizeResponse>
      streamingRecognizeSettings() {
    return ((SpeechStubSettings) getStubSettings()).streamingRecognizeSettings();
  }

  public static final SpeechSettings create(SpeechStubSettings stub) throws IOException {
    return new SpeechSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SpeechStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SpeechStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SpeechStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SpeechStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SpeechStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SpeechStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SpeechStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SpeechSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SpeechSettings. */
  public static class Builder extends ClientSettings.Builder<SpeechSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(SpeechStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(SpeechStubSettings.newBuilder());
    }

    protected Builder(SpeechSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SpeechStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public SpeechStubSettings.Builder getStubSettingsBuilder() {
      return ((SpeechStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to syncRecognize. */
    public UnaryCallSettings.Builder<SyncRecognizeRequest, SyncRecognizeResponse>
        syncRecognizeSettings() {
      return getStubSettingsBuilder().syncRecognizeSettings();
    }

    /** Returns the builder for the settings used for calls to asyncRecognize. */
    public UnaryCallSettings.Builder<AsyncRecognizeRequest, Operation> asyncRecognizeSettings() {
      return getStubSettingsBuilder().asyncRecognizeSettings();
    }

    /** Returns the builder for the settings used for calls to asyncRecognize. */
    @BetaApi(
        "The surface for long-running operations is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            AsyncRecognizeRequest, AsyncRecognizeResponse, AsyncRecognizeMetadata>
        asyncRecognizeOperationSettings() {
      return getStubSettingsBuilder().asyncRecognizeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to streamingRecognize. */
    public StreamingCallSettings.Builder<StreamingRecognizeRequest, StreamingRecognizeResponse>
        streamingRecognizeSettings() {
      return getStubSettingsBuilder().streamingRecognizeSettings();
    }

    @Override
    public SpeechSettings build() throws IOException {
      return new SpeechSettings(this);
    }
  }
}
