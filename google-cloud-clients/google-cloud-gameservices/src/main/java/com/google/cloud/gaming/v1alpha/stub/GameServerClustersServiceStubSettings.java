/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.gaming.v1alpha.stub;

import static com.google.cloud.gaming.v1alpha.GameServerClustersServiceClient.ListGameServerClustersPagedResponse;

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
import com.google.cloud.gaming.v1alpha.CreateGameServerClusterRequest;
import com.google.cloud.gaming.v1alpha.DeleteGameServerClusterRequest;
import com.google.cloud.gaming.v1alpha.GameServerCluster;
import com.google.cloud.gaming.v1alpha.GetGameServerClusterRequest;
import com.google.cloud.gaming.v1alpha.ListGameServerClustersRequest;
import com.google.cloud.gaming.v1alpha.ListGameServerClustersResponse;
import com.google.cloud.gaming.v1alpha.UpdateGameServerClusterRequest;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS
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
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of getGameServerCluster to 30 seconds:
 *
 * <pre>
 * <code>
 * GameServerClustersServiceStubSettings.Builder gameServerClustersServiceSettingsBuilder =
 *     GameServerClustersServiceStubSettings.newBuilder();
 * gameServerClustersServiceSettingsBuilder.getGameServerClusterSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * GameServerClustersServiceStubSettings gameServerClustersServiceSettings = gameServerClustersServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
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
  private final OperationCallSettings<CreateGameServerClusterRequest, GameServerCluster, Empty>
      createGameServerClusterOperationSettings;
  private final UnaryCallSettings<DeleteGameServerClusterRequest, Operation>
      deleteGameServerClusterSettings;
  private final OperationCallSettings<DeleteGameServerClusterRequest, Empty, Empty>
      deleteGameServerClusterOperationSettings;
  private final UnaryCallSettings<UpdateGameServerClusterRequest, Operation>
      updateGameServerClusterSettings;
  private final OperationCallSettings<UpdateGameServerClusterRequest, GameServerCluster, Empty>
      updateGameServerClusterOperationSettings;

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
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallSettings<CreateGameServerClusterRequest, GameServerCluster, Empty>
      createGameServerClusterOperationSettings() {
    return createGameServerClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteGameServerCluster. */
  public UnaryCallSettings<DeleteGameServerClusterRequest, Operation>
      deleteGameServerClusterSettings() {
    return deleteGameServerClusterSettings;
  }

  /** Returns the object with the settings used for calls to deleteGameServerCluster. */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallSettings<DeleteGameServerClusterRequest, Empty, Empty>
      deleteGameServerClusterOperationSettings() {
    return deleteGameServerClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateGameServerCluster. */
  public UnaryCallSettings<UpdateGameServerClusterRequest, Operation>
      updateGameServerClusterSettings() {
    return updateGameServerClusterSettings;
  }

  /** Returns the object with the settings used for calls to updateGameServerCluster. */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallSettings<UpdateGameServerClusterRequest, GameServerCluster, Empty>
      updateGameServerClusterOperationSettings() {
    return updateGameServerClusterOperationSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public GameServerClustersServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcGameServerClustersServiceStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "gameservices.googleapis.com:443";
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
    return InstantiatingGrpcChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(GameServerClustersServiceStubSettings.class))
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

  protected GameServerClustersServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listGameServerClustersSettings = settingsBuilder.listGameServerClustersSettings().build();
    getGameServerClusterSettings = settingsBuilder.getGameServerClusterSettings().build();
    createGameServerClusterSettings = settingsBuilder.createGameServerClusterSettings().build();
    createGameServerClusterOperationSettings =
        settingsBuilder.createGameServerClusterOperationSettings().build();
    deleteGameServerClusterSettings = settingsBuilder.deleteGameServerClusterSettings().build();
    deleteGameServerClusterOperationSettings =
        settingsBuilder.deleteGameServerClusterOperationSettings().build();
    updateGameServerClusterSettings = settingsBuilder.updateGameServerClusterSettings().build();
    updateGameServerClusterOperationSettings =
        settingsBuilder.updateGameServerClusterOperationSettings().build();
  }

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
              return payload.getGameServerClustersList() != null
                  ? payload.getGameServerClustersList()
                  : ImmutableList.<GameServerCluster>of();
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
            CreateGameServerClusterRequest, GameServerCluster, Empty>
        createGameServerClusterOperationSettings;
    private final UnaryCallSettings.Builder<DeleteGameServerClusterRequest, Operation>
        deleteGameServerClusterSettings;
    private final OperationCallSettings.Builder<DeleteGameServerClusterRequest, Empty, Empty>
        deleteGameServerClusterOperationSettings;
    private final UnaryCallSettings.Builder<UpdateGameServerClusterRequest, Operation>
        updateGameServerClusterSettings;
    private final OperationCallSettings.Builder<
            UpdateGameServerClusterRequest, GameServerCluster, Empty>
        updateGameServerClusterOperationSettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(20000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listGameServerClustersSettings =
          PagedCallSettings.newBuilder(LIST_GAME_SERVER_CLUSTERS_PAGE_STR_FACT);

      getGameServerClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createGameServerClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createGameServerClusterOperationSettings = OperationCallSettings.newBuilder();

      deleteGameServerClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteGameServerClusterOperationSettings = OperationCallSettings.newBuilder();

      updateGameServerClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateGameServerClusterOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listGameServerClustersSettings,
              getGameServerClusterSettings,
              createGameServerClusterSettings,
              deleteGameServerClusterSettings,
              updateGameServerClusterSettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .listGameServerClustersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getGameServerClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createGameServerClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteGameServerClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateGameServerClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));
      builder
          .createGameServerClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateGameServerClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(GameServerCluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Empty.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(5000L))
                      .setInitialRpcTimeout(Duration.ZERO) // ignored
                      .setRpcTimeoutMultiplier(1.0) // ignored
                      .setMaxRpcTimeout(Duration.ZERO) // ignored
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));
      builder
          .deleteGameServerClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteGameServerClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Empty.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(5000L))
                      .setInitialRpcTimeout(Duration.ZERO) // ignored
                      .setRpcTimeoutMultiplier(1.0) // ignored
                      .setMaxRpcTimeout(Duration.ZERO) // ignored
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));
      builder
          .updateGameServerClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateGameServerClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(GameServerCluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Empty.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(5000L))
                      .setInitialRpcTimeout(Duration.ZERO) // ignored
                      .setRpcTimeoutMultiplier(1.0) // ignored
                      .setMaxRpcTimeout(Duration.ZERO) // ignored
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      return builder;
    }

    protected Builder(GameServerClustersServiceStubSettings settings) {
      super(settings);

      listGameServerClustersSettings = settings.listGameServerClustersSettings.toBuilder();
      getGameServerClusterSettings = settings.getGameServerClusterSettings.toBuilder();
      createGameServerClusterSettings = settings.createGameServerClusterSettings.toBuilder();
      createGameServerClusterOperationSettings =
          settings.createGameServerClusterOperationSettings.toBuilder();
      deleteGameServerClusterSettings = settings.deleteGameServerClusterSettings.toBuilder();
      deleteGameServerClusterOperationSettings =
          settings.deleteGameServerClusterOperationSettings.toBuilder();
      updateGameServerClusterSettings = settings.updateGameServerClusterSettings.toBuilder();
      updateGameServerClusterOperationSettings =
          settings.updateGameServerClusterOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listGameServerClustersSettings,
              getGameServerClusterSettings,
              createGameServerClusterSettings,
              deleteGameServerClusterSettings,
              updateGameServerClusterSettings);
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
    public OperationCallSettings.Builder<CreateGameServerClusterRequest, GameServerCluster, Empty>
        createGameServerClusterOperationSettings() {
      return createGameServerClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGameServerCluster. */
    public UnaryCallSettings.Builder<DeleteGameServerClusterRequest, Operation>
        deleteGameServerClusterSettings() {
      return deleteGameServerClusterSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGameServerCluster. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteGameServerClusterRequest, Empty, Empty>
        deleteGameServerClusterOperationSettings() {
      return deleteGameServerClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateGameServerCluster. */
    public UnaryCallSettings.Builder<UpdateGameServerClusterRequest, Operation>
        updateGameServerClusterSettings() {
      return updateGameServerClusterSettings;
    }

    /** Returns the builder for the settings used for calls to updateGameServerCluster. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateGameServerClusterRequest, GameServerCluster, Empty>
        updateGameServerClusterOperationSettings() {
      return updateGameServerClusterOperationSettings;
    }

    @Override
    public GameServerClustersServiceStubSettings build() throws IOException {
      return new GameServerClustersServiceStubSettings(this);
    }
  }
}
