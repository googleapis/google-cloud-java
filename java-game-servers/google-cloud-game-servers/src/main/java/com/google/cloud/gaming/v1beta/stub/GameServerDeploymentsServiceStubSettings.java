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

package com.google.cloud.gaming.v1beta.stub;

import static com.google.cloud.gaming.v1beta.GameServerDeploymentsServiceClient.ListGameServerDeploymentsPagedResponse;

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
import com.google.cloud.gaming.v1beta.CreateGameServerDeploymentRequest;
import com.google.cloud.gaming.v1beta.DeleteGameServerDeploymentRequest;
import com.google.cloud.gaming.v1beta.FetchDeploymentStateRequest;
import com.google.cloud.gaming.v1beta.FetchDeploymentStateResponse;
import com.google.cloud.gaming.v1beta.GameServerDeployment;
import com.google.cloud.gaming.v1beta.GameServerDeploymentRollout;
import com.google.cloud.gaming.v1beta.GetGameServerDeploymentRequest;
import com.google.cloud.gaming.v1beta.GetGameServerDeploymentRolloutRequest;
import com.google.cloud.gaming.v1beta.ListGameServerDeploymentsRequest;
import com.google.cloud.gaming.v1beta.ListGameServerDeploymentsResponse;
import com.google.cloud.gaming.v1beta.OperationMetadata;
import com.google.cloud.gaming.v1beta.PreviewGameServerDeploymentRolloutRequest;
import com.google.cloud.gaming.v1beta.PreviewGameServerDeploymentRolloutResponse;
import com.google.cloud.gaming.v1beta.UpdateGameServerDeploymentRequest;
import com.google.cloud.gaming.v1beta.UpdateGameServerDeploymentRolloutRequest;
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
 * Settings class to configure an instance of {@link GameServerDeploymentsServiceStub}.
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
 * <p>For example, to set the total timeout of getGameServerDeployment to 30 seconds:
 *
 * <pre>{@code
 * GameServerDeploymentsServiceStubSettings.Builder gameServerDeploymentsServiceSettingsBuilder =
 *     GameServerDeploymentsServiceStubSettings.newBuilder();
 * gameServerDeploymentsServiceSettingsBuilder
 *     .getGameServerDeploymentSettings()
 *     .setRetrySettings(
 *         gameServerDeploymentsServiceSettingsBuilder
 *             .getGameServerDeploymentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * GameServerDeploymentsServiceStubSettings gameServerDeploymentsServiceSettings =
 *     gameServerDeploymentsServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GameServerDeploymentsServiceStubSettings
    extends StubSettings<GameServerDeploymentsServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListGameServerDeploymentsRequest,
          ListGameServerDeploymentsResponse,
          ListGameServerDeploymentsPagedResponse>
      listGameServerDeploymentsSettings;
  private final UnaryCallSettings<GetGameServerDeploymentRequest, GameServerDeployment>
      getGameServerDeploymentSettings;
  private final UnaryCallSettings<CreateGameServerDeploymentRequest, Operation>
      createGameServerDeploymentSettings;
  private final OperationCallSettings<
          CreateGameServerDeploymentRequest, GameServerDeployment, OperationMetadata>
      createGameServerDeploymentOperationSettings;
  private final UnaryCallSettings<DeleteGameServerDeploymentRequest, Operation>
      deleteGameServerDeploymentSettings;
  private final OperationCallSettings<DeleteGameServerDeploymentRequest, Empty, OperationMetadata>
      deleteGameServerDeploymentOperationSettings;
  private final UnaryCallSettings<UpdateGameServerDeploymentRequest, Operation>
      updateGameServerDeploymentSettings;
  private final OperationCallSettings<
          UpdateGameServerDeploymentRequest, GameServerDeployment, OperationMetadata>
      updateGameServerDeploymentOperationSettings;
  private final UnaryCallSettings<
          GetGameServerDeploymentRolloutRequest, GameServerDeploymentRollout>
      getGameServerDeploymentRolloutSettings;
  private final UnaryCallSettings<UpdateGameServerDeploymentRolloutRequest, Operation>
      updateGameServerDeploymentRolloutSettings;
  private final OperationCallSettings<
          UpdateGameServerDeploymentRolloutRequest, GameServerDeployment, OperationMetadata>
      updateGameServerDeploymentRolloutOperationSettings;
  private final UnaryCallSettings<
          PreviewGameServerDeploymentRolloutRequest, PreviewGameServerDeploymentRolloutResponse>
      previewGameServerDeploymentRolloutSettings;
  private final UnaryCallSettings<FetchDeploymentStateRequest, FetchDeploymentStateResponse>
      fetchDeploymentStateSettings;

  private static final PagedListDescriptor<
          ListGameServerDeploymentsRequest, ListGameServerDeploymentsResponse, GameServerDeployment>
      LIST_GAME_SERVER_DEPLOYMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListGameServerDeploymentsRequest,
              ListGameServerDeploymentsResponse,
              GameServerDeployment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGameServerDeploymentsRequest injectToken(
                ListGameServerDeploymentsRequest payload, String token) {
              return ListGameServerDeploymentsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListGameServerDeploymentsRequest injectPageSize(
                ListGameServerDeploymentsRequest payload, int pageSize) {
              return ListGameServerDeploymentsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListGameServerDeploymentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListGameServerDeploymentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<GameServerDeployment> extractResources(
                ListGameServerDeploymentsResponse payload) {
              return payload.getGameServerDeploymentsList() == null
                  ? ImmutableList.<GameServerDeployment>of()
                  : payload.getGameServerDeploymentsList();
            }
          };

  private static final PagedListResponseFactory<
          ListGameServerDeploymentsRequest,
          ListGameServerDeploymentsResponse,
          ListGameServerDeploymentsPagedResponse>
      LIST_GAME_SERVER_DEPLOYMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGameServerDeploymentsRequest,
              ListGameServerDeploymentsResponse,
              ListGameServerDeploymentsPagedResponse>() {
            @Override
            public ApiFuture<ListGameServerDeploymentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGameServerDeploymentsRequest, ListGameServerDeploymentsResponse>
                    callable,
                ListGameServerDeploymentsRequest request,
                ApiCallContext context,
                ApiFuture<ListGameServerDeploymentsResponse> futureResponse) {
              PageContext<
                      ListGameServerDeploymentsRequest,
                      ListGameServerDeploymentsResponse,
                      GameServerDeployment>
                  pageContext =
                      PageContext.create(
                          callable, LIST_GAME_SERVER_DEPLOYMENTS_PAGE_STR_DESC, request, context);
              return ListGameServerDeploymentsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listGameServerDeployments. */
  public PagedCallSettings<
          ListGameServerDeploymentsRequest,
          ListGameServerDeploymentsResponse,
          ListGameServerDeploymentsPagedResponse>
      listGameServerDeploymentsSettings() {
    return listGameServerDeploymentsSettings;
  }

  /** Returns the object with the settings used for calls to getGameServerDeployment. */
  public UnaryCallSettings<GetGameServerDeploymentRequest, GameServerDeployment>
      getGameServerDeploymentSettings() {
    return getGameServerDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to createGameServerDeployment. */
  public UnaryCallSettings<CreateGameServerDeploymentRequest, Operation>
      createGameServerDeploymentSettings() {
    return createGameServerDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to createGameServerDeployment. */
  public OperationCallSettings<
          CreateGameServerDeploymentRequest, GameServerDeployment, OperationMetadata>
      createGameServerDeploymentOperationSettings() {
    return createGameServerDeploymentOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteGameServerDeployment. */
  public UnaryCallSettings<DeleteGameServerDeploymentRequest, Operation>
      deleteGameServerDeploymentSettings() {
    return deleteGameServerDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to deleteGameServerDeployment. */
  public OperationCallSettings<DeleteGameServerDeploymentRequest, Empty, OperationMetadata>
      deleteGameServerDeploymentOperationSettings() {
    return deleteGameServerDeploymentOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateGameServerDeployment. */
  public UnaryCallSettings<UpdateGameServerDeploymentRequest, Operation>
      updateGameServerDeploymentSettings() {
    return updateGameServerDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to updateGameServerDeployment. */
  public OperationCallSettings<
          UpdateGameServerDeploymentRequest, GameServerDeployment, OperationMetadata>
      updateGameServerDeploymentOperationSettings() {
    return updateGameServerDeploymentOperationSettings;
  }

  /** Returns the object with the settings used for calls to getGameServerDeploymentRollout. */
  public UnaryCallSettings<GetGameServerDeploymentRolloutRequest, GameServerDeploymentRollout>
      getGameServerDeploymentRolloutSettings() {
    return getGameServerDeploymentRolloutSettings;
  }

  /** Returns the object with the settings used for calls to updateGameServerDeploymentRollout. */
  public UnaryCallSettings<UpdateGameServerDeploymentRolloutRequest, Operation>
      updateGameServerDeploymentRolloutSettings() {
    return updateGameServerDeploymentRolloutSettings;
  }

  /** Returns the object with the settings used for calls to updateGameServerDeploymentRollout. */
  public OperationCallSettings<
          UpdateGameServerDeploymentRolloutRequest, GameServerDeployment, OperationMetadata>
      updateGameServerDeploymentRolloutOperationSettings() {
    return updateGameServerDeploymentRolloutOperationSettings;
  }

  /** Returns the object with the settings used for calls to previewGameServerDeploymentRollout. */
  public UnaryCallSettings<
          PreviewGameServerDeploymentRolloutRequest, PreviewGameServerDeploymentRolloutResponse>
      previewGameServerDeploymentRolloutSettings() {
    return previewGameServerDeploymentRolloutSettings;
  }

  /** Returns the object with the settings used for calls to fetchDeploymentState. */
  public UnaryCallSettings<FetchDeploymentStateRequest, FetchDeploymentStateResponse>
      fetchDeploymentStateSettings() {
    return fetchDeploymentStateSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public GameServerDeploymentsServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcGameServerDeploymentsServiceStub.create(this);
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
            "gapic",
            GaxProperties.getLibraryVersion(GameServerDeploymentsServiceStubSettings.class))
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

  protected GameServerDeploymentsServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listGameServerDeploymentsSettings = settingsBuilder.listGameServerDeploymentsSettings().build();
    getGameServerDeploymentSettings = settingsBuilder.getGameServerDeploymentSettings().build();
    createGameServerDeploymentSettings =
        settingsBuilder.createGameServerDeploymentSettings().build();
    createGameServerDeploymentOperationSettings =
        settingsBuilder.createGameServerDeploymentOperationSettings().build();
    deleteGameServerDeploymentSettings =
        settingsBuilder.deleteGameServerDeploymentSettings().build();
    deleteGameServerDeploymentOperationSettings =
        settingsBuilder.deleteGameServerDeploymentOperationSettings().build();
    updateGameServerDeploymentSettings =
        settingsBuilder.updateGameServerDeploymentSettings().build();
    updateGameServerDeploymentOperationSettings =
        settingsBuilder.updateGameServerDeploymentOperationSettings().build();
    getGameServerDeploymentRolloutSettings =
        settingsBuilder.getGameServerDeploymentRolloutSettings().build();
    updateGameServerDeploymentRolloutSettings =
        settingsBuilder.updateGameServerDeploymentRolloutSettings().build();
    updateGameServerDeploymentRolloutOperationSettings =
        settingsBuilder.updateGameServerDeploymentRolloutOperationSettings().build();
    previewGameServerDeploymentRolloutSettings =
        settingsBuilder.previewGameServerDeploymentRolloutSettings().build();
    fetchDeploymentStateSettings = settingsBuilder.fetchDeploymentStateSettings().build();
  }

  /** Builder for GameServerDeploymentsServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<GameServerDeploymentsServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListGameServerDeploymentsRequest,
            ListGameServerDeploymentsResponse,
            ListGameServerDeploymentsPagedResponse>
        listGameServerDeploymentsSettings;
    private final UnaryCallSettings.Builder<GetGameServerDeploymentRequest, GameServerDeployment>
        getGameServerDeploymentSettings;
    private final UnaryCallSettings.Builder<CreateGameServerDeploymentRequest, Operation>
        createGameServerDeploymentSettings;
    private final OperationCallSettings.Builder<
            CreateGameServerDeploymentRequest, GameServerDeployment, OperationMetadata>
        createGameServerDeploymentOperationSettings;
    private final UnaryCallSettings.Builder<DeleteGameServerDeploymentRequest, Operation>
        deleteGameServerDeploymentSettings;
    private final OperationCallSettings.Builder<
            DeleteGameServerDeploymentRequest, Empty, OperationMetadata>
        deleteGameServerDeploymentOperationSettings;
    private final UnaryCallSettings.Builder<UpdateGameServerDeploymentRequest, Operation>
        updateGameServerDeploymentSettings;
    private final OperationCallSettings.Builder<
            UpdateGameServerDeploymentRequest, GameServerDeployment, OperationMetadata>
        updateGameServerDeploymentOperationSettings;
    private final UnaryCallSettings.Builder<
            GetGameServerDeploymentRolloutRequest, GameServerDeploymentRollout>
        getGameServerDeploymentRolloutSettings;
    private final UnaryCallSettings.Builder<UpdateGameServerDeploymentRolloutRequest, Operation>
        updateGameServerDeploymentRolloutSettings;
    private final OperationCallSettings.Builder<
            UpdateGameServerDeploymentRolloutRequest, GameServerDeployment, OperationMetadata>
        updateGameServerDeploymentRolloutOperationSettings;
    private final UnaryCallSettings.Builder<
            PreviewGameServerDeploymentRolloutRequest, PreviewGameServerDeploymentRolloutResponse>
        previewGameServerDeploymentRolloutSettings;
    private final UnaryCallSettings.Builder<
            FetchDeploymentStateRequest, FetchDeploymentStateResponse>
        fetchDeploymentStateSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
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

      listGameServerDeploymentsSettings =
          PagedCallSettings.newBuilder(LIST_GAME_SERVER_DEPLOYMENTS_PAGE_STR_FACT);
      getGameServerDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGameServerDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGameServerDeploymentOperationSettings = OperationCallSettings.newBuilder();
      deleteGameServerDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteGameServerDeploymentOperationSettings = OperationCallSettings.newBuilder();
      updateGameServerDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateGameServerDeploymentOperationSettings = OperationCallSettings.newBuilder();
      getGameServerDeploymentRolloutSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateGameServerDeploymentRolloutSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateGameServerDeploymentRolloutOperationSettings = OperationCallSettings.newBuilder();
      previewGameServerDeploymentRolloutSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      fetchDeploymentStateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listGameServerDeploymentsSettings,
              getGameServerDeploymentSettings,
              createGameServerDeploymentSettings,
              deleteGameServerDeploymentSettings,
              updateGameServerDeploymentSettings,
              getGameServerDeploymentRolloutSettings,
              updateGameServerDeploymentRolloutSettings,
              previewGameServerDeploymentRolloutSettings,
              fetchDeploymentStateSettings);
      initDefaults(this);
    }

    protected Builder(GameServerDeploymentsServiceStubSettings settings) {
      super(settings);

      listGameServerDeploymentsSettings = settings.listGameServerDeploymentsSettings.toBuilder();
      getGameServerDeploymentSettings = settings.getGameServerDeploymentSettings.toBuilder();
      createGameServerDeploymentSettings = settings.createGameServerDeploymentSettings.toBuilder();
      createGameServerDeploymentOperationSettings =
          settings.createGameServerDeploymentOperationSettings.toBuilder();
      deleteGameServerDeploymentSettings = settings.deleteGameServerDeploymentSettings.toBuilder();
      deleteGameServerDeploymentOperationSettings =
          settings.deleteGameServerDeploymentOperationSettings.toBuilder();
      updateGameServerDeploymentSettings = settings.updateGameServerDeploymentSettings.toBuilder();
      updateGameServerDeploymentOperationSettings =
          settings.updateGameServerDeploymentOperationSettings.toBuilder();
      getGameServerDeploymentRolloutSettings =
          settings.getGameServerDeploymentRolloutSettings.toBuilder();
      updateGameServerDeploymentRolloutSettings =
          settings.updateGameServerDeploymentRolloutSettings.toBuilder();
      updateGameServerDeploymentRolloutOperationSettings =
          settings.updateGameServerDeploymentRolloutOperationSettings.toBuilder();
      previewGameServerDeploymentRolloutSettings =
          settings.previewGameServerDeploymentRolloutSettings.toBuilder();
      fetchDeploymentStateSettings = settings.fetchDeploymentStateSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listGameServerDeploymentsSettings,
              getGameServerDeploymentSettings,
              createGameServerDeploymentSettings,
              deleteGameServerDeploymentSettings,
              updateGameServerDeploymentSettings,
              getGameServerDeploymentRolloutSettings,
              updateGameServerDeploymentRolloutSettings,
              previewGameServerDeploymentRolloutSettings,
              fetchDeploymentStateSettings);
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
          .listGameServerDeploymentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getGameServerDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createGameServerDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteGameServerDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateGameServerDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getGameServerDeploymentRolloutSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateGameServerDeploymentRolloutSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .previewGameServerDeploymentRolloutSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .fetchDeploymentStateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createGameServerDeploymentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateGameServerDeploymentRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(GameServerDeployment.class))
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
          .deleteGameServerDeploymentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteGameServerDeploymentRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
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
          .updateGameServerDeploymentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateGameServerDeploymentRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(GameServerDeployment.class))
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
          .updateGameServerDeploymentRolloutOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateGameServerDeploymentRolloutRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(GameServerDeployment.class))
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

    /** Returns the builder for the settings used for calls to listGameServerDeployments. */
    public PagedCallSettings.Builder<
            ListGameServerDeploymentsRequest,
            ListGameServerDeploymentsResponse,
            ListGameServerDeploymentsPagedResponse>
        listGameServerDeploymentsSettings() {
      return listGameServerDeploymentsSettings;
    }

    /** Returns the builder for the settings used for calls to getGameServerDeployment. */
    public UnaryCallSettings.Builder<GetGameServerDeploymentRequest, GameServerDeployment>
        getGameServerDeploymentSettings() {
      return getGameServerDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to createGameServerDeployment. */
    public UnaryCallSettings.Builder<CreateGameServerDeploymentRequest, Operation>
        createGameServerDeploymentSettings() {
      return createGameServerDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to createGameServerDeployment. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateGameServerDeploymentRequest, GameServerDeployment, OperationMetadata>
        createGameServerDeploymentOperationSettings() {
      return createGameServerDeploymentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGameServerDeployment. */
    public UnaryCallSettings.Builder<DeleteGameServerDeploymentRequest, Operation>
        deleteGameServerDeploymentSettings() {
      return deleteGameServerDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGameServerDeployment. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DeleteGameServerDeploymentRequest, Empty, OperationMetadata>
        deleteGameServerDeploymentOperationSettings() {
      return deleteGameServerDeploymentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateGameServerDeployment. */
    public UnaryCallSettings.Builder<UpdateGameServerDeploymentRequest, Operation>
        updateGameServerDeploymentSettings() {
      return updateGameServerDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to updateGameServerDeployment. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateGameServerDeploymentRequest, GameServerDeployment, OperationMetadata>
        updateGameServerDeploymentOperationSettings() {
      return updateGameServerDeploymentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getGameServerDeploymentRollout. */
    public UnaryCallSettings.Builder<
            GetGameServerDeploymentRolloutRequest, GameServerDeploymentRollout>
        getGameServerDeploymentRolloutSettings() {
      return getGameServerDeploymentRolloutSettings;
    }

    /** Returns the builder for the settings used for calls to updateGameServerDeploymentRollout. */
    public UnaryCallSettings.Builder<UpdateGameServerDeploymentRolloutRequest, Operation>
        updateGameServerDeploymentRolloutSettings() {
      return updateGameServerDeploymentRolloutSettings;
    }

    /** Returns the builder for the settings used for calls to updateGameServerDeploymentRollout. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateGameServerDeploymentRolloutRequest, GameServerDeployment, OperationMetadata>
        updateGameServerDeploymentRolloutOperationSettings() {
      return updateGameServerDeploymentRolloutOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to previewGameServerDeploymentRollout.
     */
    public UnaryCallSettings.Builder<
            PreviewGameServerDeploymentRolloutRequest, PreviewGameServerDeploymentRolloutResponse>
        previewGameServerDeploymentRolloutSettings() {
      return previewGameServerDeploymentRolloutSettings;
    }

    /** Returns the builder for the settings used for calls to fetchDeploymentState. */
    public UnaryCallSettings.Builder<FetchDeploymentStateRequest, FetchDeploymentStateResponse>
        fetchDeploymentStateSettings() {
      return fetchDeploymentStateSettings;
    }

    @Override
    public GameServerDeploymentsServiceStubSettings build() throws IOException {
      return new GameServerDeploymentsServiceStubSettings(this);
    }
  }
}
