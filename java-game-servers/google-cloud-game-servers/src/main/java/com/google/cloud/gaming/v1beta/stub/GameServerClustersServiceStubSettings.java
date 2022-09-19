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

package com.google.cloud.gaming.v1beta.stub;

import static com.google.cloud.gaming.v1beta.GameServerClustersServiceClient.ListGameServerClustersPagedResponse;

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
import com.google.cloud.gaming.v1beta.CreateGameServerClusterRequest;
import com.google.cloud.gaming.v1beta.DeleteGameServerClusterRequest;
import com.google.cloud.gaming.v1beta.GameServerCluster;
import com.google.cloud.gaming.v1beta.GetGameServerClusterRequest;
import com.google.cloud.gaming.v1beta.ListGameServerClustersRequest;
import com.google.cloud.gaming.v1beta.ListGameServerClustersResponse;
import com.google.cloud.gaming.v1beta.OperationMetadata;
import com.google.cloud.gaming.v1beta.PreviewCreateGameServerClusterRequest;
import com.google.cloud.gaming.v1beta.PreviewCreateGameServerClusterResponse;
import com.google.cloud.gaming.v1beta.PreviewDeleteGameServerClusterRequest;
import com.google.cloud.gaming.v1beta.PreviewDeleteGameServerClusterResponse;
import com.google.cloud.gaming.v1beta.PreviewUpdateGameServerClusterRequest;
import com.google.cloud.gaming.v1beta.PreviewUpdateGameServerClusterResponse;
import com.google.cloud.gaming.v1beta.UpdateGameServerClusterRequest;
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
 * Settings class to configure an instance of {@link GameServerClustersServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (gameservices.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getGameServerCluster to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GameServerClustersServiceStubSettings.Builder gameServerClustersServiceSettingsBuilder =
 *     GameServerClustersServiceStubSettings.newBuilder();
 * gameServerClustersServiceSettingsBuilder
 *     .getGameServerClusterSettings()
 *     .setRetrySettings(
 *         gameServerClustersServiceSettingsBuilder
 *             .getGameServerClusterSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * GameServerClustersServiceStubSettings gameServerClustersServiceSettings =
 *     gameServerClustersServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GameServerClustersServiceStubSettings
    extends StubSettings<GameServerClustersServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListGameServerClustersRequest,
          ListGameServerClustersResponse,
          ListGameServerClustersPagedResponse>
      listGameServerClustersSettings;
  private final UnaryCallSettings<GetGameServerClusterRequest, GameServerCluster>
      getGameServerClusterSettings;
  private final UnaryCallSettings<CreateGameServerClusterRequest, Operation>
      createGameServerClusterSettings;
  private final OperationCallSettings<
          CreateGameServerClusterRequest, GameServerCluster, OperationMetadata>
      createGameServerClusterOperationSettings;
  private final UnaryCallSettings<
          PreviewCreateGameServerClusterRequest, PreviewCreateGameServerClusterResponse>
      previewCreateGameServerClusterSettings;
  private final UnaryCallSettings<DeleteGameServerClusterRequest, Operation>
      deleteGameServerClusterSettings;
  private final OperationCallSettings<DeleteGameServerClusterRequest, Empty, OperationMetadata>
      deleteGameServerClusterOperationSettings;
  private final UnaryCallSettings<
          PreviewDeleteGameServerClusterRequest, PreviewDeleteGameServerClusterResponse>
      previewDeleteGameServerClusterSettings;
  private final UnaryCallSettings<UpdateGameServerClusterRequest, Operation>
      updateGameServerClusterSettings;
  private final OperationCallSettings<
          UpdateGameServerClusterRequest, GameServerCluster, OperationMetadata>
      updateGameServerClusterOperationSettings;
  private final UnaryCallSettings<
          PreviewUpdateGameServerClusterRequest, PreviewUpdateGameServerClusterResponse>
      previewUpdateGameServerClusterSettings;

  private static final PagedListDescriptor<
          ListGameServerClustersRequest, ListGameServerClustersResponse, GameServerCluster>
      LIST_GAME_SERVER_CLUSTERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListGameServerClustersRequest, ListGameServerClustersResponse, GameServerCluster>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGameServerClustersRequest injectToken(
                ListGameServerClustersRequest payload, String token) {
              return ListGameServerClustersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListGameServerClustersRequest injectPageSize(
                ListGameServerClustersRequest payload, int pageSize) {
              return ListGameServerClustersRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListGameServerClustersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListGameServerClustersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<GameServerCluster> extractResources(
                ListGameServerClustersResponse payload) {
              return payload.getGameServerClustersList() == null
                  ? ImmutableList.<GameServerCluster>of()
                  : payload.getGameServerClustersList();
            }
          };

  private static final PagedListResponseFactory<
          ListGameServerClustersRequest,
          ListGameServerClustersResponse,
          ListGameServerClustersPagedResponse>
      LIST_GAME_SERVER_CLUSTERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGameServerClustersRequest,
              ListGameServerClustersResponse,
              ListGameServerClustersPagedResponse>() {
            @Override
            public ApiFuture<ListGameServerClustersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGameServerClustersRequest, ListGameServerClustersResponse>
                    callable,
                ListGameServerClustersRequest request,
                ApiCallContext context,
                ApiFuture<ListGameServerClustersResponse> futureResponse) {
              PageContext<
                      ListGameServerClustersRequest,
                      ListGameServerClustersResponse,
                      GameServerCluster>
                  pageContext =
                      PageContext.create(
                          callable, LIST_GAME_SERVER_CLUSTERS_PAGE_STR_DESC, request, context);
              return ListGameServerClustersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listGameServerClusters. */
  public PagedCallSettings<
          ListGameServerClustersRequest,
          ListGameServerClustersResponse,
          ListGameServerClustersPagedResponse>
      listGameServerClustersSettings() {
    return listGameServerClustersSettings;
  }

  /** Returns the object with the settings used for calls to getGameServerCluster. */
  public UnaryCallSettings<GetGameServerClusterRequest, GameServerCluster>
      getGameServerClusterSettings() {
    return getGameServerClusterSettings;
  }

  /** Returns the object with the settings used for calls to createGameServerCluster. */
  public UnaryCallSettings<CreateGameServerClusterRequest, Operation>
      createGameServerClusterSettings() {
    return createGameServerClusterSettings;
  }

  /** Returns the object with the settings used for calls to createGameServerCluster. */
  public OperationCallSettings<CreateGameServerClusterRequest, GameServerCluster, OperationMetadata>
      createGameServerClusterOperationSettings() {
    return createGameServerClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to previewCreateGameServerCluster. */
  public UnaryCallSettings<
          PreviewCreateGameServerClusterRequest, PreviewCreateGameServerClusterResponse>
      previewCreateGameServerClusterSettings() {
    return previewCreateGameServerClusterSettings;
  }

  /** Returns the object with the settings used for calls to deleteGameServerCluster. */
  public UnaryCallSettings<DeleteGameServerClusterRequest, Operation>
      deleteGameServerClusterSettings() {
    return deleteGameServerClusterSettings;
  }

  /** Returns the object with the settings used for calls to deleteGameServerCluster. */
  public OperationCallSettings<DeleteGameServerClusterRequest, Empty, OperationMetadata>
      deleteGameServerClusterOperationSettings() {
    return deleteGameServerClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to previewDeleteGameServerCluster. */
  public UnaryCallSettings<
          PreviewDeleteGameServerClusterRequest, PreviewDeleteGameServerClusterResponse>
      previewDeleteGameServerClusterSettings() {
    return previewDeleteGameServerClusterSettings;
  }

  /** Returns the object with the settings used for calls to updateGameServerCluster. */
  public UnaryCallSettings<UpdateGameServerClusterRequest, Operation>
      updateGameServerClusterSettings() {
    return updateGameServerClusterSettings;
  }

  /** Returns the object with the settings used for calls to updateGameServerCluster. */
  public OperationCallSettings<UpdateGameServerClusterRequest, GameServerCluster, OperationMetadata>
      updateGameServerClusterOperationSettings() {
    return updateGameServerClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to previewUpdateGameServerCluster. */
  public UnaryCallSettings<
          PreviewUpdateGameServerClusterRequest, PreviewUpdateGameServerClusterResponse>
      previewUpdateGameServerClusterSettings() {
    return previewUpdateGameServerClusterSettings;
  }

  public GameServerClustersServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcGameServerClustersServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonGameServerClustersServiceStub.create(this);
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
    return "gameservices.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "gameservices.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(GameServerClustersServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(GameServerClustersServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return GameServerClustersServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected GameServerClustersServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listGameServerClustersSettings = settingsBuilder.listGameServerClustersSettings().build();
    getGameServerClusterSettings = settingsBuilder.getGameServerClusterSettings().build();
    createGameServerClusterSettings = settingsBuilder.createGameServerClusterSettings().build();
    createGameServerClusterOperationSettings =
        settingsBuilder.createGameServerClusterOperationSettings().build();
    previewCreateGameServerClusterSettings =
        settingsBuilder.previewCreateGameServerClusterSettings().build();
    deleteGameServerClusterSettings = settingsBuilder.deleteGameServerClusterSettings().build();
    deleteGameServerClusterOperationSettings =
        settingsBuilder.deleteGameServerClusterOperationSettings().build();
    previewDeleteGameServerClusterSettings =
        settingsBuilder.previewDeleteGameServerClusterSettings().build();
    updateGameServerClusterSettings = settingsBuilder.updateGameServerClusterSettings().build();
    updateGameServerClusterOperationSettings =
        settingsBuilder.updateGameServerClusterOperationSettings().build();
    previewUpdateGameServerClusterSettings =
        settingsBuilder.previewUpdateGameServerClusterSettings().build();
  }

  /** Builder for GameServerClustersServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<GameServerClustersServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListGameServerClustersRequest,
            ListGameServerClustersResponse,
            ListGameServerClustersPagedResponse>
        listGameServerClustersSettings;
    private final UnaryCallSettings.Builder<GetGameServerClusterRequest, GameServerCluster>
        getGameServerClusterSettings;
    private final UnaryCallSettings.Builder<CreateGameServerClusterRequest, Operation>
        createGameServerClusterSettings;
    private final OperationCallSettings.Builder<
            CreateGameServerClusterRequest, GameServerCluster, OperationMetadata>
        createGameServerClusterOperationSettings;
    private final UnaryCallSettings.Builder<
            PreviewCreateGameServerClusterRequest, PreviewCreateGameServerClusterResponse>
        previewCreateGameServerClusterSettings;
    private final UnaryCallSettings.Builder<DeleteGameServerClusterRequest, Operation>
        deleteGameServerClusterSettings;
    private final OperationCallSettings.Builder<
            DeleteGameServerClusterRequest, Empty, OperationMetadata>
        deleteGameServerClusterOperationSettings;
    private final UnaryCallSettings.Builder<
            PreviewDeleteGameServerClusterRequest, PreviewDeleteGameServerClusterResponse>
        previewDeleteGameServerClusterSettings;
    private final UnaryCallSettings.Builder<UpdateGameServerClusterRequest, Operation>
        updateGameServerClusterSettings;
    private final OperationCallSettings.Builder<
            UpdateGameServerClusterRequest, GameServerCluster, OperationMetadata>
        updateGameServerClusterOperationSettings;
    private final UnaryCallSettings.Builder<
            PreviewUpdateGameServerClusterRequest, PreviewUpdateGameServerClusterResponse>
        previewUpdateGameServerClusterSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_2_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(120000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(120000L))
              .setTotalTimeout(Duration.ofMillis(120000L))
              .build();
      definitions.put("no_retry_2_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listGameServerClustersSettings =
          PagedCallSettings.newBuilder(LIST_GAME_SERVER_CLUSTERS_PAGE_STR_FACT);
      getGameServerClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGameServerClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGameServerClusterOperationSettings = OperationCallSettings.newBuilder();
      previewCreateGameServerClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteGameServerClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteGameServerClusterOperationSettings = OperationCallSettings.newBuilder();
      previewDeleteGameServerClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateGameServerClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateGameServerClusterOperationSettings = OperationCallSettings.newBuilder();
      previewUpdateGameServerClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listGameServerClustersSettings,
              getGameServerClusterSettings,
              createGameServerClusterSettings,
              previewCreateGameServerClusterSettings,
              deleteGameServerClusterSettings,
              previewDeleteGameServerClusterSettings,
              updateGameServerClusterSettings,
              previewUpdateGameServerClusterSettings);
      initDefaults(this);
    }

    protected Builder(GameServerClustersServiceStubSettings settings) {
      super(settings);

      listGameServerClustersSettings = settings.listGameServerClustersSettings.toBuilder();
      getGameServerClusterSettings = settings.getGameServerClusterSettings.toBuilder();
      createGameServerClusterSettings = settings.createGameServerClusterSettings.toBuilder();
      createGameServerClusterOperationSettings =
          settings.createGameServerClusterOperationSettings.toBuilder();
      previewCreateGameServerClusterSettings =
          settings.previewCreateGameServerClusterSettings.toBuilder();
      deleteGameServerClusterSettings = settings.deleteGameServerClusterSettings.toBuilder();
      deleteGameServerClusterOperationSettings =
          settings.deleteGameServerClusterOperationSettings.toBuilder();
      previewDeleteGameServerClusterSettings =
          settings.previewDeleteGameServerClusterSettings.toBuilder();
      updateGameServerClusterSettings = settings.updateGameServerClusterSettings.toBuilder();
      updateGameServerClusterOperationSettings =
          settings.updateGameServerClusterOperationSettings.toBuilder();
      previewUpdateGameServerClusterSettings =
          settings.previewUpdateGameServerClusterSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listGameServerClustersSettings,
              getGameServerClusterSettings,
              createGameServerClusterSettings,
              previewCreateGameServerClusterSettings,
              deleteGameServerClusterSettings,
              previewDeleteGameServerClusterSettings,
              updateGameServerClusterSettings,
              previewUpdateGameServerClusterSettings);
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
          .listGameServerClustersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getGameServerClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createGameServerClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .previewCreateGameServerClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteGameServerClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .previewDeleteGameServerClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateGameServerClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .previewUpdateGameServerClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createGameServerClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateGameServerClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(GameServerCluster.class))
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
          .deleteGameServerClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteGameServerClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
          .updateGameServerClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateGameServerClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(GameServerCluster.class))
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

    /** Returns the builder for the settings used for calls to listGameServerClusters. */
    public PagedCallSettings.Builder<
            ListGameServerClustersRequest,
            ListGameServerClustersResponse,
            ListGameServerClustersPagedResponse>
        listGameServerClustersSettings() {
      return listGameServerClustersSettings;
    }

    /** Returns the builder for the settings used for calls to getGameServerCluster. */
    public UnaryCallSettings.Builder<GetGameServerClusterRequest, GameServerCluster>
        getGameServerClusterSettings() {
      return getGameServerClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createGameServerCluster. */
    public UnaryCallSettings.Builder<CreateGameServerClusterRequest, Operation>
        createGameServerClusterSettings() {
      return createGameServerClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createGameServerCluster. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateGameServerClusterRequest, GameServerCluster, OperationMetadata>
        createGameServerClusterOperationSettings() {
      return createGameServerClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to previewCreateGameServerCluster. */
    public UnaryCallSettings.Builder<
            PreviewCreateGameServerClusterRequest, PreviewCreateGameServerClusterResponse>
        previewCreateGameServerClusterSettings() {
      return previewCreateGameServerClusterSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGameServerCluster. */
    public UnaryCallSettings.Builder<DeleteGameServerClusterRequest, Operation>
        deleteGameServerClusterSettings() {
      return deleteGameServerClusterSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGameServerCluster. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteGameServerClusterRequest, Empty, OperationMetadata>
        deleteGameServerClusterOperationSettings() {
      return deleteGameServerClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to previewDeleteGameServerCluster. */
    public UnaryCallSettings.Builder<
            PreviewDeleteGameServerClusterRequest, PreviewDeleteGameServerClusterResponse>
        previewDeleteGameServerClusterSettings() {
      return previewDeleteGameServerClusterSettings;
    }

    /** Returns the builder for the settings used for calls to updateGameServerCluster. */
    public UnaryCallSettings.Builder<UpdateGameServerClusterRequest, Operation>
        updateGameServerClusterSettings() {
      return updateGameServerClusterSettings;
    }

    /** Returns the builder for the settings used for calls to updateGameServerCluster. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateGameServerClusterRequest, GameServerCluster, OperationMetadata>
        updateGameServerClusterOperationSettings() {
      return updateGameServerClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to previewUpdateGameServerCluster. */
    public UnaryCallSettings.Builder<
            PreviewUpdateGameServerClusterRequest, PreviewUpdateGameServerClusterResponse>
        previewUpdateGameServerClusterSettings() {
      return previewUpdateGameServerClusterSettings;
    }

    @Override
    public GameServerClustersServiceStubSettings build() throws IOException {
      return new GameServerClustersServiceStubSettings(this);
    }
  }
}
