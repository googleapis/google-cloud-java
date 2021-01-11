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

package com.google.cloud.videointelligence.v1p3beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.videointelligence.v1p3beta1.stub.VideoIntelligenceServiceStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link VideoIntelligenceServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (videointelligence.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of annotateVideo to 30 seconds:
 *
 * <pre>{@code
 * VideoIntelligenceServiceSettings.Builder videoIntelligenceServiceSettingsBuilder =
 *     VideoIntelligenceServiceSettings.newBuilder();
 * videoIntelligenceServiceSettingsBuilder
 *     .annotateVideoSettings()
 *     .setRetrySettings(
 *         videoIntelligenceServiceSettingsBuilder
 *             .annotateVideoSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * VideoIntelligenceServiceSettings videoIntelligenceServiceSettings =
 *     videoIntelligenceServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class VideoIntelligenceServiceSettings
    extends ClientSettings<VideoIntelligenceServiceSettings> {

  /** Returns the object with the settings used for calls to annotateVideo. */
  public UnaryCallSettings<AnnotateVideoRequest, Operation> annotateVideoSettings() {
    return ((VideoIntelligenceServiceStubSettings) getStubSettings()).annotateVideoSettings();
  }

  /** Returns the object with the settings used for calls to annotateVideo. */
  public OperationCallSettings<AnnotateVideoRequest, AnnotateVideoResponse, AnnotateVideoProgress>
      annotateVideoOperationSettings() {
    return ((VideoIntelligenceServiceStubSettings) getStubSettings())
        .annotateVideoOperationSettings();
  }

  public static final VideoIntelligenceServiceSettings create(
      VideoIntelligenceServiceStubSettings stub) throws IOException {
    return new VideoIntelligenceServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return VideoIntelligenceServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return VideoIntelligenceServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return VideoIntelligenceServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return VideoIntelligenceServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return VideoIntelligenceServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return VideoIntelligenceServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return VideoIntelligenceServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected VideoIntelligenceServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for VideoIntelligenceServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<VideoIntelligenceServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(VideoIntelligenceServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(VideoIntelligenceServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(VideoIntelligenceServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(VideoIntelligenceServiceStubSettings.newBuilder());
    }

    public VideoIntelligenceServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((VideoIntelligenceServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to annotateVideo. */
    public UnaryCallSettings.Builder<AnnotateVideoRequest, Operation> annotateVideoSettings() {
      return getStubSettingsBuilder().annotateVideoSettings();
    }

    /** Returns the builder for the settings used for calls to annotateVideo. */
    public OperationCallSettings.Builder<
            AnnotateVideoRequest, AnnotateVideoResponse, AnnotateVideoProgress>
        annotateVideoOperationSettings() {
      return getStubSettingsBuilder().annotateVideoOperationSettings();
    }

    @Override
    public VideoIntelligenceServiceSettings build() throws IOException {
      return new VideoIntelligenceServiceSettings(this);
    }
  }
}
