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

package com.google.cloud.gkehub.v1alpha.stub;

import static com.google.cloud.gkehub.v1alpha.GkeHubClient.ListFeaturesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
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
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkehub.v1alpha.CreateFeatureRequest;
import com.google.cloud.gkehub.v1alpha.DeleteFeatureRequest;
import com.google.cloud.gkehub.v1alpha.Feature;
import com.google.cloud.gkehub.v1alpha.GetFeatureRequest;
import com.google.cloud.gkehub.v1alpha.ListFeaturesRequest;
import com.google.cloud.gkehub.v1alpha.ListFeaturesResponse;
import com.google.cloud.gkehub.v1alpha.OperationMetadata;
import com.google.cloud.gkehub.v1alpha.UpdateFeatureRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link GkeHubStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (gkehub.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getFeature to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GkeHubStubSettings.Builder gkeHubSettingsBuilder = GkeHubStubSettings.newBuilder();
 * gkeHubSettingsBuilder
 *     .getFeatureSettings()
 *     .setRetrySettings(
 *         gkeHubSettingsBuilder
 *             .getFeatureSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * GkeHubStubSettings gkeHubSettings = gkeHubSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GkeHubStubSettings extends StubSettings<GkeHubStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>
      listFeaturesSettings;
  private final UnaryCallSettings<GetFeatureRequest, Feature> getFeatureSettings;
  private final UnaryCallSettings<CreateFeatureRequest, Operation> createFeatureSettings;
  private final OperationCallSettings<CreateFeatureRequest, Feature, OperationMetadata>
      createFeatureOperationSettings;
  private final UnaryCallSettings<DeleteFeatureRequest, Operation> deleteFeatureSettings;
  private final OperationCallSettings<DeleteFeatureRequest, Empty, OperationMetadata>
      deleteFeatureOperationSettings;
  private final UnaryCallSettings<UpdateFeatureRequest, Operation> updateFeatureSettings;
  private final OperationCallSettings<UpdateFeatureRequest, Feature, OperationMetadata>
      updateFeatureOperationSettings;

  private static final PagedListDescriptor<ListFeaturesRequest, ListFeaturesResponse, Feature>
      LIST_FEATURES_PAGE_STR_DESC =
          new PagedListDescriptor<ListFeaturesRequest, ListFeaturesResponse, Feature>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFeaturesRequest injectToken(ListFeaturesRequest payload, String token) {
              return ListFeaturesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFeaturesRequest injectPageSize(ListFeaturesRequest payload, int pageSize) {
              return ListFeaturesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFeaturesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFeaturesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Feature> extractResources(ListFeaturesResponse payload) {
              return payload.getResourcesList() == null
                  ? ImmutableList.<Feature>of()
                  : payload.getResourcesList();
            }
          };

  private static final PagedListResponseFactory<
          ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>
      LIST_FEATURES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>() {
            @Override
            public ApiFuture<ListFeaturesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFeaturesRequest, ListFeaturesResponse> callable,
                ListFeaturesRequest request,
                ApiCallContext context,
                ApiFuture<ListFeaturesResponse> futureResponse) {
              PageContext<ListFeaturesRequest, ListFeaturesResponse, Feature> pageContext =
                  PageContext.create(callable, LIST_FEATURES_PAGE_STR_DESC, request, context);
              return ListFeaturesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listFeatures. */
  public PagedCallSettings<ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>
      listFeaturesSettings() {
    return listFeaturesSettings;
  }

  /** Returns the object with the settings used for calls to getFeature. */
  public UnaryCallSettings<GetFeatureRequest, Feature> getFeatureSettings() {
    return getFeatureSettings;
  }

  /** Returns the object with the settings used for calls to createFeature. */
  public UnaryCallSettings<CreateFeatureRequest, Operation> createFeatureSettings() {
    return createFeatureSettings;
  }

  /** Returns the object with the settings used for calls to createFeature. */
  public OperationCallSettings<CreateFeatureRequest, Feature, OperationMetadata>
      createFeatureOperationSettings() {
    return createFeatureOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteFeature. */
  public UnaryCallSettings<DeleteFeatureRequest, Operation> deleteFeatureSettings() {
    return deleteFeatureSettings;
  }

  /** Returns the object with the settings used for calls to deleteFeature. */
  public OperationCallSettings<DeleteFeatureRequest, Empty, OperationMetadata>
      deleteFeatureOperationSettings() {
    return deleteFeatureOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateFeature. */
  public UnaryCallSettings<UpdateFeatureRequest, Operation> updateFeatureSettings() {
    return updateFeatureSettings;
  }

  /** Returns the object with the settings used for calls to updateFeature. */
  public OperationCallSettings<UpdateFeatureRequest, Feature, OperationMetadata>
      updateFeatureOperationSettings() {
    return updateFeatureOperationSettings;
  }

  public GkeHubStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcGkeHubStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonGkeHubStub.create(this);
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
    return "gkehub.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "gkehub.mtls.googleapis.com:443";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(GkeHubStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(GkeHubStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return GkeHubStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected GkeHubStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listFeaturesSettings = settingsBuilder.listFeaturesSettings().build();
    getFeatureSettings = settingsBuilder.getFeatureSettings().build();
    createFeatureSettings = settingsBuilder.createFeatureSettings().build();
    createFeatureOperationSettings = settingsBuilder.createFeatureOperationSettings().build();
    deleteFeatureSettings = settingsBuilder.deleteFeatureSettings().build();
    deleteFeatureOperationSettings = settingsBuilder.deleteFeatureOperationSettings().build();
    updateFeatureSettings = settingsBuilder.updateFeatureSettings().build();
    updateFeatureOperationSettings = settingsBuilder.updateFeatureOperationSettings().build();
  }

  /** Builder for GkeHubStubSettings. */
  public static class Builder extends StubSettings.Builder<GkeHubStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>
        listFeaturesSettings;
    private final UnaryCallSettings.Builder<GetFeatureRequest, Feature> getFeatureSettings;
    private final UnaryCallSettings.Builder<CreateFeatureRequest, Operation> createFeatureSettings;
    private final OperationCallSettings.Builder<CreateFeatureRequest, Feature, OperationMetadata>
        createFeatureOperationSettings;
    private final UnaryCallSettings.Builder<DeleteFeatureRequest, Operation> deleteFeatureSettings;
    private final OperationCallSettings.Builder<DeleteFeatureRequest, Empty, OperationMetadata>
        deleteFeatureOperationSettings;
    private final UnaryCallSettings.Builder<UpdateFeatureRequest, Operation> updateFeatureSettings;
    private final OperationCallSettings.Builder<UpdateFeatureRequest, Feature, OperationMetadata>
        updateFeatureOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listFeaturesSettings = PagedCallSettings.newBuilder(LIST_FEATURES_PAGE_STR_FACT);
      getFeatureSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFeatureSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFeatureOperationSettings = OperationCallSettings.newBuilder();
      deleteFeatureSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFeatureOperationSettings = OperationCallSettings.newBuilder();
      updateFeatureSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFeatureOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listFeaturesSettings,
              getFeatureSettings,
              createFeatureSettings,
              deleteFeatureSettings,
              updateFeatureSettings);
      initDefaults(this);
    }

    protected Builder(GkeHubStubSettings settings) {
      super(settings);

      listFeaturesSettings = settings.listFeaturesSettings.toBuilder();
      getFeatureSettings = settings.getFeatureSettings.toBuilder();
      createFeatureSettings = settings.createFeatureSettings.toBuilder();
      createFeatureOperationSettings = settings.createFeatureOperationSettings.toBuilder();
      deleteFeatureSettings = settings.deleteFeatureSettings.toBuilder();
      deleteFeatureOperationSettings = settings.deleteFeatureOperationSettings.toBuilder();
      updateFeatureSettings = settings.updateFeatureSettings.toBuilder();
      updateFeatureOperationSettings = settings.updateFeatureOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listFeaturesSettings,
              getFeatureSettings,
              createFeatureSettings,
              deleteFeatureSettings,
              updateFeatureSettings);
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
          .listFeaturesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getFeatureSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createFeatureSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteFeatureSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateFeatureSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createFeatureOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateFeatureRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Feature.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteFeatureOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteFeatureRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateFeatureOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateFeatureRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Feature.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
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

    /** Returns the builder for the settings used for calls to listFeatures. */
    public PagedCallSettings.Builder<
            ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>
        listFeaturesSettings() {
      return listFeaturesSettings;
    }

    /** Returns the builder for the settings used for calls to getFeature. */
    public UnaryCallSettings.Builder<GetFeatureRequest, Feature> getFeatureSettings() {
      return getFeatureSettings;
    }

    /** Returns the builder for the settings used for calls to createFeature. */
    public UnaryCallSettings.Builder<CreateFeatureRequest, Operation> createFeatureSettings() {
      return createFeatureSettings;
    }

    /** Returns the builder for the settings used for calls to createFeature. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateFeatureRequest, Feature, OperationMetadata>
        createFeatureOperationSettings() {
      return createFeatureOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFeature. */
    public UnaryCallSettings.Builder<DeleteFeatureRequest, Operation> deleteFeatureSettings() {
      return deleteFeatureSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFeature. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteFeatureRequest, Empty, OperationMetadata>
        deleteFeatureOperationSettings() {
      return deleteFeatureOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateFeature. */
    public UnaryCallSettings.Builder<UpdateFeatureRequest, Operation> updateFeatureSettings() {
      return updateFeatureSettings;
    }

    /** Returns the builder for the settings used for calls to updateFeature. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateFeatureRequest, Feature, OperationMetadata>
        updateFeatureOperationSettings() {
      return updateFeatureOperationSettings;
    }

    @Override
    public GkeHubStubSettings build() throws IOException {
      return new GkeHubStubSettings(this);
    }
  }
}
