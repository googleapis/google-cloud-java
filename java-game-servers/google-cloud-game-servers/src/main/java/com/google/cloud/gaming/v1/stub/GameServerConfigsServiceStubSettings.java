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

package com.google.cloud.gaming.v1.stub;

import static com.google.cloud.gaming.v1.GameServerConfigsServiceClient.ListGameServerConfigsPagedResponse;

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
import com.google.cloud.gaming.v1.CreateGameServerConfigRequest;
import com.google.cloud.gaming.v1.DeleteGameServerConfigRequest;
import com.google.cloud.gaming.v1.GameServerConfig;
import com.google.cloud.gaming.v1.GetGameServerConfigRequest;
import com.google.cloud.gaming.v1.ListGameServerConfigsRequest;
import com.google.cloud.gaming.v1.ListGameServerConfigsResponse;
import com.google.cloud.gaming.v1.OperationMetadata;
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
 * Settings class to configure an instance of {@link GameServerConfigsServiceStub}.
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
 * <p>For example, to set the total timeout of getGameServerConfig to 30 seconds:
 *
 * <pre>{@code
 * GameServerConfigsServiceStubSettings.Builder gameServerConfigsServiceSettingsBuilder =
 *     GameServerConfigsServiceStubSettings.newBuilder();
 * gameServerConfigsServiceSettingsBuilder
 *     .getGameServerConfigSettings()
 *     .setRetrySettings(
 *         gameServerConfigsServiceSettingsBuilder
 *             .getGameServerConfigSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * GameServerConfigsServiceStubSettings gameServerConfigsServiceSettings =
 *     gameServerConfigsServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GameServerConfigsServiceStubSettings
    extends StubSettings<GameServerConfigsServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListGameServerConfigsRequest,
          ListGameServerConfigsResponse,
          ListGameServerConfigsPagedResponse>
      listGameServerConfigsSettings;
  private final UnaryCallSettings<GetGameServerConfigRequest, GameServerConfig>
      getGameServerConfigSettings;
  private final UnaryCallSettings<CreateGameServerConfigRequest, Operation>
      createGameServerConfigSettings;
  private final OperationCallSettings<
          CreateGameServerConfigRequest, GameServerConfig, OperationMetadata>
      createGameServerConfigOperationSettings;
  private final UnaryCallSettings<DeleteGameServerConfigRequest, Operation>
      deleteGameServerConfigSettings;
  private final OperationCallSettings<DeleteGameServerConfigRequest, Empty, OperationMetadata>
      deleteGameServerConfigOperationSettings;

  private static final PagedListDescriptor<
          ListGameServerConfigsRequest, ListGameServerConfigsResponse, GameServerConfig>
      LIST_GAME_SERVER_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListGameServerConfigsRequest, ListGameServerConfigsResponse, GameServerConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGameServerConfigsRequest injectToken(
                ListGameServerConfigsRequest payload, String token) {
              return ListGameServerConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListGameServerConfigsRequest injectPageSize(
                ListGameServerConfigsRequest payload, int pageSize) {
              return ListGameServerConfigsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListGameServerConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListGameServerConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<GameServerConfig> extractResources(
                ListGameServerConfigsResponse payload) {
              return payload.getGameServerConfigsList() == null
                  ? ImmutableList.<GameServerConfig>of()
                  : payload.getGameServerConfigsList();
            }
          };

  private static final PagedListResponseFactory<
          ListGameServerConfigsRequest,
          ListGameServerConfigsResponse,
          ListGameServerConfigsPagedResponse>
      LIST_GAME_SERVER_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGameServerConfigsRequest,
              ListGameServerConfigsResponse,
              ListGameServerConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListGameServerConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGameServerConfigsRequest, ListGameServerConfigsResponse> callable,
                ListGameServerConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListGameServerConfigsResponse> futureResponse) {
              PageContext<
                      ListGameServerConfigsRequest, ListGameServerConfigsResponse, GameServerConfig>
                  pageContext =
                      PageContext.create(
                          callable, LIST_GAME_SERVER_CONFIGS_PAGE_STR_DESC, request, context);
              return ListGameServerConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listGameServerConfigs. */
  public PagedCallSettings<
          ListGameServerConfigsRequest,
          ListGameServerConfigsResponse,
          ListGameServerConfigsPagedResponse>
      listGameServerConfigsSettings() {
    return listGameServerConfigsSettings;
  }

  /** Returns the object with the settings used for calls to getGameServerConfig. */
  public UnaryCallSettings<GetGameServerConfigRequest, GameServerConfig>
      getGameServerConfigSettings() {
    return getGameServerConfigSettings;
  }

  /** Returns the object with the settings used for calls to createGameServerConfig. */
  public UnaryCallSettings<CreateGameServerConfigRequest, Operation>
      createGameServerConfigSettings() {
    return createGameServerConfigSettings;
  }

  /** Returns the object with the settings used for calls to createGameServerConfig. */
  public OperationCallSettings<CreateGameServerConfigRequest, GameServerConfig, OperationMetadata>
      createGameServerConfigOperationSettings() {
    return createGameServerConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteGameServerConfig. */
  public UnaryCallSettings<DeleteGameServerConfigRequest, Operation>
      deleteGameServerConfigSettings() {
    return deleteGameServerConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteGameServerConfig. */
  public OperationCallSettings<DeleteGameServerConfigRequest, Empty, OperationMetadata>
      deleteGameServerConfigOperationSettings() {
    return deleteGameServerConfigOperationSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public GameServerConfigsServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcGameServerConfigsServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(GameServerConfigsServiceStubSettings.class))
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

  protected GameServerConfigsServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listGameServerConfigsSettings = settingsBuilder.listGameServerConfigsSettings().build();
    getGameServerConfigSettings = settingsBuilder.getGameServerConfigSettings().build();
    createGameServerConfigSettings = settingsBuilder.createGameServerConfigSettings().build();
    createGameServerConfigOperationSettings =
        settingsBuilder.createGameServerConfigOperationSettings().build();
    deleteGameServerConfigSettings = settingsBuilder.deleteGameServerConfigSettings().build();
    deleteGameServerConfigOperationSettings =
        settingsBuilder.deleteGameServerConfigOperationSettings().build();
  }

  /** Builder for GameServerConfigsServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<GameServerConfigsServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListGameServerConfigsRequest,
            ListGameServerConfigsResponse,
            ListGameServerConfigsPagedResponse>
        listGameServerConfigsSettings;
    private final UnaryCallSettings.Builder<GetGameServerConfigRequest, GameServerConfig>
        getGameServerConfigSettings;
    private final UnaryCallSettings.Builder<CreateGameServerConfigRequest, Operation>
        createGameServerConfigSettings;
    private final OperationCallSettings.Builder<
            CreateGameServerConfigRequest, GameServerConfig, OperationMetadata>
        createGameServerConfigOperationSettings;
    private final UnaryCallSettings.Builder<DeleteGameServerConfigRequest, Operation>
        deleteGameServerConfigSettings;
    private final OperationCallSettings.Builder<
            DeleteGameServerConfigRequest, Empty, OperationMetadata>
        deleteGameServerConfigOperationSettings;
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
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_2_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listGameServerConfigsSettings =
          PagedCallSettings.newBuilder(LIST_GAME_SERVER_CONFIGS_PAGE_STR_FACT);
      getGameServerConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGameServerConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGameServerConfigOperationSettings = OperationCallSettings.newBuilder();
      deleteGameServerConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteGameServerConfigOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listGameServerConfigsSettings,
              getGameServerConfigSettings,
              createGameServerConfigSettings,
              deleteGameServerConfigSettings);
      initDefaults(this);
    }

    protected Builder(GameServerConfigsServiceStubSettings settings) {
      super(settings);

      listGameServerConfigsSettings = settings.listGameServerConfigsSettings.toBuilder();
      getGameServerConfigSettings = settings.getGameServerConfigSettings.toBuilder();
      createGameServerConfigSettings = settings.createGameServerConfigSettings.toBuilder();
      createGameServerConfigOperationSettings =
          settings.createGameServerConfigOperationSettings.toBuilder();
      deleteGameServerConfigSettings = settings.deleteGameServerConfigSettings.toBuilder();
      deleteGameServerConfigOperationSettings =
          settings.deleteGameServerConfigOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listGameServerConfigsSettings,
              getGameServerConfigSettings,
              createGameServerConfigSettings,
              deleteGameServerConfigSettings);
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
          .listGameServerConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getGameServerConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createGameServerConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .deleteGameServerConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .createGameServerConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateGameServerConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(GameServerConfig.class))
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
          .deleteGameServerConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteGameServerConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
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

    /** Returns the builder for the settings used for calls to listGameServerConfigs. */
    public PagedCallSettings.Builder<
            ListGameServerConfigsRequest,
            ListGameServerConfigsResponse,
            ListGameServerConfigsPagedResponse>
        listGameServerConfigsSettings() {
      return listGameServerConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to getGameServerConfig. */
    public UnaryCallSettings.Builder<GetGameServerConfigRequest, GameServerConfig>
        getGameServerConfigSettings() {
      return getGameServerConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createGameServerConfig. */
    public UnaryCallSettings.Builder<CreateGameServerConfigRequest, Operation>
        createGameServerConfigSettings() {
      return createGameServerConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createGameServerConfig. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateGameServerConfigRequest, GameServerConfig, OperationMetadata>
        createGameServerConfigOperationSettings() {
      return createGameServerConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGameServerConfig. */
    public UnaryCallSettings.Builder<DeleteGameServerConfigRequest, Operation>
        deleteGameServerConfigSettings() {
      return deleteGameServerConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGameServerConfig. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteGameServerConfigRequest, Empty, OperationMetadata>
        deleteGameServerConfigOperationSettings() {
      return deleteGameServerConfigOperationSettings;
    }

    @Override
    public GameServerConfigsServiceStubSettings build() throws IOException {
      return new GameServerConfigsServiceStubSettings(this);
    }
  }
}
