/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.vision.v1p4beta1.stub;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
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
import com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateFilesRequest;
import com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateFilesResponse;
import com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateImagesRequest;
import com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateImagesResponse;
import com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesRequest;
import com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesResponse;
import com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesRequest;
import com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1p4beta1.OperationMetadata;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ImageAnnotatorStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (vision.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of batchAnnotateImages to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ImageAnnotatorStubSettings.Builder imageAnnotatorSettingsBuilder =
 *     ImageAnnotatorStubSettings.newBuilder();
 * imageAnnotatorSettingsBuilder
 *     .batchAnnotateImagesSettings()
 *     .setRetrySettings(
 *         imageAnnotatorSettingsBuilder
 *             .batchAnnotateImagesSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ImageAnnotatorStubSettings imageAnnotatorSettings = imageAnnotatorSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ImageAnnotatorStubSettings extends StubSettings<ImageAnnotatorStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-vision")
          .build();

  private final UnaryCallSettings<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>
      batchAnnotateImagesSettings;
  private final UnaryCallSettings<BatchAnnotateFilesRequest, BatchAnnotateFilesResponse>
      batchAnnotateFilesSettings;
  private final UnaryCallSettings<AsyncBatchAnnotateImagesRequest, Operation>
      asyncBatchAnnotateImagesSettings;
  private final OperationCallSettings<
          AsyncBatchAnnotateImagesRequest, AsyncBatchAnnotateImagesResponse, OperationMetadata>
      asyncBatchAnnotateImagesOperationSettings;
  private final UnaryCallSettings<AsyncBatchAnnotateFilesRequest, Operation>
      asyncBatchAnnotateFilesSettings;
  private final OperationCallSettings<
          AsyncBatchAnnotateFilesRequest, AsyncBatchAnnotateFilesResponse, OperationMetadata>
      asyncBatchAnnotateFilesOperationSettings;

  /** Returns the object with the settings used for calls to batchAnnotateImages. */
  public UnaryCallSettings<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>
      batchAnnotateImagesSettings() {
    return batchAnnotateImagesSettings;
  }

  /** Returns the object with the settings used for calls to batchAnnotateFiles. */
  public UnaryCallSettings<BatchAnnotateFilesRequest, BatchAnnotateFilesResponse>
      batchAnnotateFilesSettings() {
    return batchAnnotateFilesSettings;
  }

  /** Returns the object with the settings used for calls to asyncBatchAnnotateImages. */
  public UnaryCallSettings<AsyncBatchAnnotateImagesRequest, Operation>
      asyncBatchAnnotateImagesSettings() {
    return asyncBatchAnnotateImagesSettings;
  }

  /** Returns the object with the settings used for calls to asyncBatchAnnotateImages. */
  public OperationCallSettings<
          AsyncBatchAnnotateImagesRequest, AsyncBatchAnnotateImagesResponse, OperationMetadata>
      asyncBatchAnnotateImagesOperationSettings() {
    return asyncBatchAnnotateImagesOperationSettings;
  }

  /** Returns the object with the settings used for calls to asyncBatchAnnotateFiles. */
  public UnaryCallSettings<AsyncBatchAnnotateFilesRequest, Operation>
      asyncBatchAnnotateFilesSettings() {
    return asyncBatchAnnotateFilesSettings;
  }

  /** Returns the object with the settings used for calls to asyncBatchAnnotateFiles. */
  public OperationCallSettings<
          AsyncBatchAnnotateFilesRequest, AsyncBatchAnnotateFilesResponse, OperationMetadata>
      asyncBatchAnnotateFilesOperationSettings() {
    return asyncBatchAnnotateFilesOperationSettings;
  }

  public ImageAnnotatorStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcImageAnnotatorStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonImageAnnotatorStub.create(this);
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
    return "vision.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "vision.mtls.googleapis.com:443";
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ImageAnnotatorStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ImageAnnotatorStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ImageAnnotatorStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected ImageAnnotatorStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    batchAnnotateImagesSettings = settingsBuilder.batchAnnotateImagesSettings().build();
    batchAnnotateFilesSettings = settingsBuilder.batchAnnotateFilesSettings().build();
    asyncBatchAnnotateImagesSettings = settingsBuilder.asyncBatchAnnotateImagesSettings().build();
    asyncBatchAnnotateImagesOperationSettings =
        settingsBuilder.asyncBatchAnnotateImagesOperationSettings().build();
    asyncBatchAnnotateFilesSettings = settingsBuilder.asyncBatchAnnotateFilesSettings().build();
    asyncBatchAnnotateFilesOperationSettings =
        settingsBuilder.asyncBatchAnnotateFilesOperationSettings().build();
  }

  /** Builder for ImageAnnotatorStubSettings. */
  public static class Builder extends StubSettings.Builder<ImageAnnotatorStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>
        batchAnnotateImagesSettings;
    private final UnaryCallSettings.Builder<BatchAnnotateFilesRequest, BatchAnnotateFilesResponse>
        batchAnnotateFilesSettings;
    private final UnaryCallSettings.Builder<AsyncBatchAnnotateImagesRequest, Operation>
        asyncBatchAnnotateImagesSettings;
    private final OperationCallSettings.Builder<
            AsyncBatchAnnotateImagesRequest, AsyncBatchAnnotateImagesResponse, OperationMetadata>
        asyncBatchAnnotateImagesOperationSettings;
    private final UnaryCallSettings.Builder<AsyncBatchAnnotateFilesRequest, Operation>
        asyncBatchAnnotateFilesSettings;
    private final OperationCallSettings.Builder<
            AsyncBatchAnnotateFilesRequest, AsyncBatchAnnotateFilesResponse, OperationMetadata>
        asyncBatchAnnotateFilesOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
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
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      batchAnnotateImagesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchAnnotateFilesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      asyncBatchAnnotateImagesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      asyncBatchAnnotateImagesOperationSettings = OperationCallSettings.newBuilder();
      asyncBatchAnnotateFilesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      asyncBatchAnnotateFilesOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              batchAnnotateImagesSettings,
              batchAnnotateFilesSettings,
              asyncBatchAnnotateImagesSettings,
              asyncBatchAnnotateFilesSettings);
      initDefaults(this);
    }

    protected Builder(ImageAnnotatorStubSettings settings) {
      super(settings);

      batchAnnotateImagesSettings = settings.batchAnnotateImagesSettings.toBuilder();
      batchAnnotateFilesSettings = settings.batchAnnotateFilesSettings.toBuilder();
      asyncBatchAnnotateImagesSettings = settings.asyncBatchAnnotateImagesSettings.toBuilder();
      asyncBatchAnnotateImagesOperationSettings =
          settings.asyncBatchAnnotateImagesOperationSettings.toBuilder();
      asyncBatchAnnotateFilesSettings = settings.asyncBatchAnnotateFilesSettings.toBuilder();
      asyncBatchAnnotateFilesOperationSettings =
          settings.asyncBatchAnnotateFilesOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              batchAnnotateImagesSettings,
              batchAnnotateFilesSettings,
              asyncBatchAnnotateImagesSettings,
              asyncBatchAnnotateFilesSettings);
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

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .batchAnnotateImagesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchAnnotateFilesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .asyncBatchAnnotateImagesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .asyncBatchAnnotateFilesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .asyncBatchAnnotateImagesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AsyncBatchAnnotateImagesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  AsyncBatchAnnotateImagesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(5000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .asyncBatchAnnotateFilesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AsyncBatchAnnotateFilesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  AsyncBatchAnnotateFilesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(20000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(86400000L))
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

    /** Returns the builder for the settings used for calls to batchAnnotateImages. */
    public UnaryCallSettings.Builder<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>
        batchAnnotateImagesSettings() {
      return batchAnnotateImagesSettings;
    }

    /** Returns the builder for the settings used for calls to batchAnnotateFiles. */
    public UnaryCallSettings.Builder<BatchAnnotateFilesRequest, BatchAnnotateFilesResponse>
        batchAnnotateFilesSettings() {
      return batchAnnotateFilesSettings;
    }

    /** Returns the builder for the settings used for calls to asyncBatchAnnotateImages. */
    public UnaryCallSettings.Builder<AsyncBatchAnnotateImagesRequest, Operation>
        asyncBatchAnnotateImagesSettings() {
      return asyncBatchAnnotateImagesSettings;
    }

    /** Returns the builder for the settings used for calls to asyncBatchAnnotateImages. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            AsyncBatchAnnotateImagesRequest, AsyncBatchAnnotateImagesResponse, OperationMetadata>
        asyncBatchAnnotateImagesOperationSettings() {
      return asyncBatchAnnotateImagesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to asyncBatchAnnotateFiles. */
    public UnaryCallSettings.Builder<AsyncBatchAnnotateFilesRequest, Operation>
        asyncBatchAnnotateFilesSettings() {
      return asyncBatchAnnotateFilesSettings;
    }

    /** Returns the builder for the settings used for calls to asyncBatchAnnotateFiles. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            AsyncBatchAnnotateFilesRequest, AsyncBatchAnnotateFilesResponse, OperationMetadata>
        asyncBatchAnnotateFilesOperationSettings() {
      return asyncBatchAnnotateFilesOperationSettings;
    }

    @Override
    public ImageAnnotatorStubSettings build() throws IOException {
      return new ImageAnnotatorStubSettings(this);
    }
  }
}
