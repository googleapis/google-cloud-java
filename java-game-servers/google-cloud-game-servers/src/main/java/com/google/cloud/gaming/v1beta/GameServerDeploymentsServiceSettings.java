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

package com.google.cloud.gaming.v1beta;

import static com.google.cloud.gaming.v1beta.GameServerDeploymentsServiceClient.ListGameServerDeploymentsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.gaming.v1beta.stub.GameServerDeploymentsServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link GameServerDeploymentsServiceClient}.
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GameServerDeploymentsServiceSettings.Builder gameServerDeploymentsServiceSettingsBuilder =
 *     GameServerDeploymentsServiceSettings.newBuilder();
 * gameServerDeploymentsServiceSettingsBuilder
 *     .getGameServerDeploymentSettings()
 *     .setRetrySettings(
 *         gameServerDeploymentsServiceSettingsBuilder
 *             .getGameServerDeploymentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * GameServerDeploymentsServiceSettings gameServerDeploymentsServiceSettings =
 *     gameServerDeploymentsServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GameServerDeploymentsServiceSettings
    extends ClientSettings<GameServerDeploymentsServiceSettings> {

  /** Returns the object with the settings used for calls to listGameServerDeployments. */
  public PagedCallSettings<
          ListGameServerDeploymentsRequest,
          ListGameServerDeploymentsResponse,
          ListGameServerDeploymentsPagedResponse>
      listGameServerDeploymentsSettings() {
    return ((GameServerDeploymentsServiceStubSettings) getStubSettings())
        .listGameServerDeploymentsSettings();
  }

  /** Returns the object with the settings used for calls to getGameServerDeployment. */
  public UnaryCallSettings<GetGameServerDeploymentRequest, GameServerDeployment>
      getGameServerDeploymentSettings() {
    return ((GameServerDeploymentsServiceStubSettings) getStubSettings())
        .getGameServerDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to createGameServerDeployment. */
  public UnaryCallSettings<CreateGameServerDeploymentRequest, Operation>
      createGameServerDeploymentSettings() {
    return ((GameServerDeploymentsServiceStubSettings) getStubSettings())
        .createGameServerDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to createGameServerDeployment. */
  public OperationCallSettings<
          CreateGameServerDeploymentRequest, GameServerDeployment, OperationMetadata>
      createGameServerDeploymentOperationSettings() {
    return ((GameServerDeploymentsServiceStubSettings) getStubSettings())
        .createGameServerDeploymentOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteGameServerDeployment. */
  public UnaryCallSettings<DeleteGameServerDeploymentRequest, Operation>
      deleteGameServerDeploymentSettings() {
    return ((GameServerDeploymentsServiceStubSettings) getStubSettings())
        .deleteGameServerDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to deleteGameServerDeployment. */
  public OperationCallSettings<DeleteGameServerDeploymentRequest, Empty, OperationMetadata>
      deleteGameServerDeploymentOperationSettings() {
    return ((GameServerDeploymentsServiceStubSettings) getStubSettings())
        .deleteGameServerDeploymentOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateGameServerDeployment. */
  public UnaryCallSettings<UpdateGameServerDeploymentRequest, Operation>
      updateGameServerDeploymentSettings() {
    return ((GameServerDeploymentsServiceStubSettings) getStubSettings())
        .updateGameServerDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to updateGameServerDeployment. */
  public OperationCallSettings<
          UpdateGameServerDeploymentRequest, GameServerDeployment, OperationMetadata>
      updateGameServerDeploymentOperationSettings() {
    return ((GameServerDeploymentsServiceStubSettings) getStubSettings())
        .updateGameServerDeploymentOperationSettings();
  }

  /** Returns the object with the settings used for calls to getGameServerDeploymentRollout. */
  public UnaryCallSettings<GetGameServerDeploymentRolloutRequest, GameServerDeploymentRollout>
      getGameServerDeploymentRolloutSettings() {
    return ((GameServerDeploymentsServiceStubSettings) getStubSettings())
        .getGameServerDeploymentRolloutSettings();
  }

  /** Returns the object with the settings used for calls to updateGameServerDeploymentRollout. */
  public UnaryCallSettings<UpdateGameServerDeploymentRolloutRequest, Operation>
      updateGameServerDeploymentRolloutSettings() {
    return ((GameServerDeploymentsServiceStubSettings) getStubSettings())
        .updateGameServerDeploymentRolloutSettings();
  }

  /** Returns the object with the settings used for calls to updateGameServerDeploymentRollout. */
  public OperationCallSettings<
          UpdateGameServerDeploymentRolloutRequest, GameServerDeployment, OperationMetadata>
      updateGameServerDeploymentRolloutOperationSettings() {
    return ((GameServerDeploymentsServiceStubSettings) getStubSettings())
        .updateGameServerDeploymentRolloutOperationSettings();
  }

  /** Returns the object with the settings used for calls to previewGameServerDeploymentRollout. */
  public UnaryCallSettings<
          PreviewGameServerDeploymentRolloutRequest, PreviewGameServerDeploymentRolloutResponse>
      previewGameServerDeploymentRolloutSettings() {
    return ((GameServerDeploymentsServiceStubSettings) getStubSettings())
        .previewGameServerDeploymentRolloutSettings();
  }

  /** Returns the object with the settings used for calls to fetchDeploymentState. */
  public UnaryCallSettings<FetchDeploymentStateRequest, FetchDeploymentStateResponse>
      fetchDeploymentStateSettings() {
    return ((GameServerDeploymentsServiceStubSettings) getStubSettings())
        .fetchDeploymentStateSettings();
  }

  public static final GameServerDeploymentsServiceSettings create(
      GameServerDeploymentsServiceStubSettings stub) throws IOException {
    return new GameServerDeploymentsServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return GameServerDeploymentsServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return GameServerDeploymentsServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return GameServerDeploymentsServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GameServerDeploymentsServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return GameServerDeploymentsServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return GameServerDeploymentsServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return GameServerDeploymentsServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return GameServerDeploymentsServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
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

  protected GameServerDeploymentsServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for GameServerDeploymentsServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<GameServerDeploymentsServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(GameServerDeploymentsServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(GameServerDeploymentsServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(GameServerDeploymentsServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(GameServerDeploymentsServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(GameServerDeploymentsServiceStubSettings.newHttpJsonBuilder());
    }

    public GameServerDeploymentsServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((GameServerDeploymentsServiceStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to listGameServerDeployments. */
    public PagedCallSettings.Builder<
            ListGameServerDeploymentsRequest,
            ListGameServerDeploymentsResponse,
            ListGameServerDeploymentsPagedResponse>
        listGameServerDeploymentsSettings() {
      return getStubSettingsBuilder().listGameServerDeploymentsSettings();
    }

    /** Returns the builder for the settings used for calls to getGameServerDeployment. */
    public UnaryCallSettings.Builder<GetGameServerDeploymentRequest, GameServerDeployment>
        getGameServerDeploymentSettings() {
      return getStubSettingsBuilder().getGameServerDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to createGameServerDeployment. */
    public UnaryCallSettings.Builder<CreateGameServerDeploymentRequest, Operation>
        createGameServerDeploymentSettings() {
      return getStubSettingsBuilder().createGameServerDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to createGameServerDeployment. */
    public OperationCallSettings.Builder<
            CreateGameServerDeploymentRequest, GameServerDeployment, OperationMetadata>
        createGameServerDeploymentOperationSettings() {
      return getStubSettingsBuilder().createGameServerDeploymentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGameServerDeployment. */
    public UnaryCallSettings.Builder<DeleteGameServerDeploymentRequest, Operation>
        deleteGameServerDeploymentSettings() {
      return getStubSettingsBuilder().deleteGameServerDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGameServerDeployment. */
    public OperationCallSettings.Builder<
            DeleteGameServerDeploymentRequest, Empty, OperationMetadata>
        deleteGameServerDeploymentOperationSettings() {
      return getStubSettingsBuilder().deleteGameServerDeploymentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateGameServerDeployment. */
    public UnaryCallSettings.Builder<UpdateGameServerDeploymentRequest, Operation>
        updateGameServerDeploymentSettings() {
      return getStubSettingsBuilder().updateGameServerDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to updateGameServerDeployment. */
    public OperationCallSettings.Builder<
            UpdateGameServerDeploymentRequest, GameServerDeployment, OperationMetadata>
        updateGameServerDeploymentOperationSettings() {
      return getStubSettingsBuilder().updateGameServerDeploymentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getGameServerDeploymentRollout. */
    public UnaryCallSettings.Builder<
            GetGameServerDeploymentRolloutRequest, GameServerDeploymentRollout>
        getGameServerDeploymentRolloutSettings() {
      return getStubSettingsBuilder().getGameServerDeploymentRolloutSettings();
    }

    /** Returns the builder for the settings used for calls to updateGameServerDeploymentRollout. */
    public UnaryCallSettings.Builder<UpdateGameServerDeploymentRolloutRequest, Operation>
        updateGameServerDeploymentRolloutSettings() {
      return getStubSettingsBuilder().updateGameServerDeploymentRolloutSettings();
    }

    /** Returns the builder for the settings used for calls to updateGameServerDeploymentRollout. */
    public OperationCallSettings.Builder<
            UpdateGameServerDeploymentRolloutRequest, GameServerDeployment, OperationMetadata>
        updateGameServerDeploymentRolloutOperationSettings() {
      return getStubSettingsBuilder().updateGameServerDeploymentRolloutOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to previewGameServerDeploymentRollout.
     */
    public UnaryCallSettings.Builder<
            PreviewGameServerDeploymentRolloutRequest, PreviewGameServerDeploymentRolloutResponse>
        previewGameServerDeploymentRolloutSettings() {
      return getStubSettingsBuilder().previewGameServerDeploymentRolloutSettings();
    }

    /** Returns the builder for the settings used for calls to fetchDeploymentState. */
    public UnaryCallSettings.Builder<FetchDeploymentStateRequest, FetchDeploymentStateResponse>
        fetchDeploymentStateSettings() {
      return getStubSettingsBuilder().fetchDeploymentStateSettings();
    }

    @Override
    public GameServerDeploymentsServiceSettings build() throws IOException {
      return new GameServerDeploymentsServiceSettings(this);
    }
  }
}
