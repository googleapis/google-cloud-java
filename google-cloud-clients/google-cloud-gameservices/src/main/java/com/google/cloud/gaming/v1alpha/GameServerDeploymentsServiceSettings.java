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
package com.google.cloud.gaming.v1alpha;

import static com.google.cloud.gaming.v1alpha.GameServerDeploymentsServiceClient.ListGameServerDeploymentsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.gaming.v1alpha.stub.GameServerDeploymentsServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
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
 * <pre>
 * <code>
 * GameServerDeploymentsServiceSettings.Builder gameServerDeploymentsServiceSettingsBuilder =
 *     GameServerDeploymentsServiceSettings.newBuilder();
 * gameServerDeploymentsServiceSettingsBuilder.getGameServerDeploymentSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * GameServerDeploymentsServiceSettings gameServerDeploymentsServiceSettings = gameServerDeploymentsServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
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
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public OperationCallSettings<CreateGameServerDeploymentRequest, GameServerDeployment, Empty>
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
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public OperationCallSettings<DeleteGameServerDeploymentRequest, Empty, Empty>
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
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public OperationCallSettings<UpdateGameServerDeploymentRequest, GameServerDeployment, Empty>
      updateGameServerDeploymentOperationSettings() {
    return ((GameServerDeploymentsServiceStubSettings) getStubSettings())
        .updateGameServerDeploymentOperationSettings();
  }

  /** Returns the object with the settings used for calls to startRollout. */
  public UnaryCallSettings<StartRolloutRequest, Operation> startRolloutSettings() {
    return ((GameServerDeploymentsServiceStubSettings) getStubSettings()).startRolloutSettings();
  }

  /** Returns the object with the settings used for calls to startRollout. */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public OperationCallSettings<StartRolloutRequest, GameServerDeployment, Empty>
      startRolloutOperationSettings() {
    return ((GameServerDeploymentsServiceStubSettings) getStubSettings())
        .startRolloutOperationSettings();
  }

  /** Returns the object with the settings used for calls to setRolloutTarget. */
  public UnaryCallSettings<SetRolloutTargetRequest, Operation> setRolloutTargetSettings() {
    return ((GameServerDeploymentsServiceStubSettings) getStubSettings())
        .setRolloutTargetSettings();
  }

  /** Returns the object with the settings used for calls to setRolloutTarget. */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public OperationCallSettings<SetRolloutTargetRequest, GameServerDeployment, Empty>
      setRolloutTargetOperationSettings() {
    return ((GameServerDeploymentsServiceStubSettings) getStubSettings())
        .setRolloutTargetOperationSettings();
  }

  /** Returns the object with the settings used for calls to commitRollout. */
  public UnaryCallSettings<CommitRolloutRequest, Operation> commitRolloutSettings() {
    return ((GameServerDeploymentsServiceStubSettings) getStubSettings()).commitRolloutSettings();
  }

  /** Returns the object with the settings used for calls to commitRollout. */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public OperationCallSettings<CommitRolloutRequest, GameServerDeployment, Empty>
      commitRolloutOperationSettings() {
    return ((GameServerDeploymentsServiceStubSettings) getStubSettings())
        .commitRolloutOperationSettings();
  }

  /** Returns the object with the settings used for calls to revertRollout. */
  public UnaryCallSettings<RevertRolloutRequest, Operation> revertRolloutSettings() {
    return ((GameServerDeploymentsServiceStubSettings) getStubSettings()).revertRolloutSettings();
  }

  /** Returns the object with the settings used for calls to revertRollout. */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public OperationCallSettings<RevertRolloutRequest, GameServerDeployment, Empty>
      revertRolloutOperationSettings() {
    return ((GameServerDeploymentsServiceStubSettings) getStubSettings())
        .revertRolloutOperationSettings();
  }

  /** Returns the object with the settings used for calls to getDeploymentTarget. */
  public UnaryCallSettings<GetDeploymentTargetRequest, DeploymentTarget>
      getDeploymentTargetSettings() {
    return ((GameServerDeploymentsServiceStubSettings) getStubSettings())
        .getDeploymentTargetSettings();
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return GameServerDeploymentsServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return GameServerDeploymentsServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return GameServerDeploymentsServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected GameServerDeploymentsServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for GameServerDeploymentsServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<GameServerDeploymentsServiceSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(GameServerDeploymentsServiceStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(GameServerDeploymentsServiceStubSettings.newBuilder());
    }

    protected Builder(GameServerDeploymentsServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(GameServerDeploymentsServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public GameServerDeploymentsServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((GameServerDeploymentsServiceStubSettings.Builder) getStubSettings());
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
    @BetaApi(
        "The surface for long-running operations is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateGameServerDeploymentRequest, GameServerDeployment, Empty>
        createGameServerDeploymentOperationSettings() {
      return getStubSettingsBuilder().createGameServerDeploymentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGameServerDeployment. */
    public UnaryCallSettings.Builder<DeleteGameServerDeploymentRequest, Operation>
        deleteGameServerDeploymentSettings() {
      return getStubSettingsBuilder().deleteGameServerDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGameServerDeployment. */
    @BetaApi(
        "The surface for long-running operations is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteGameServerDeploymentRequest, Empty, Empty>
        deleteGameServerDeploymentOperationSettings() {
      return getStubSettingsBuilder().deleteGameServerDeploymentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateGameServerDeployment. */
    public UnaryCallSettings.Builder<UpdateGameServerDeploymentRequest, Operation>
        updateGameServerDeploymentSettings() {
      return getStubSettingsBuilder().updateGameServerDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to updateGameServerDeployment. */
    @BetaApi(
        "The surface for long-running operations is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateGameServerDeploymentRequest, GameServerDeployment, Empty>
        updateGameServerDeploymentOperationSettings() {
      return getStubSettingsBuilder().updateGameServerDeploymentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to startRollout. */
    public UnaryCallSettings.Builder<StartRolloutRequest, Operation> startRolloutSettings() {
      return getStubSettingsBuilder().startRolloutSettings();
    }

    /** Returns the builder for the settings used for calls to startRollout. */
    @BetaApi(
        "The surface for long-running operations is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<StartRolloutRequest, GameServerDeployment, Empty>
        startRolloutOperationSettings() {
      return getStubSettingsBuilder().startRolloutOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setRolloutTarget. */
    public UnaryCallSettings.Builder<SetRolloutTargetRequest, Operation>
        setRolloutTargetSettings() {
      return getStubSettingsBuilder().setRolloutTargetSettings();
    }

    /** Returns the builder for the settings used for calls to setRolloutTarget. */
    @BetaApi(
        "The surface for long-running operations is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SetRolloutTargetRequest, GameServerDeployment, Empty>
        setRolloutTargetOperationSettings() {
      return getStubSettingsBuilder().setRolloutTargetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to commitRollout. */
    public UnaryCallSettings.Builder<CommitRolloutRequest, Operation> commitRolloutSettings() {
      return getStubSettingsBuilder().commitRolloutSettings();
    }

    /** Returns the builder for the settings used for calls to commitRollout. */
    @BetaApi(
        "The surface for long-running operations is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CommitRolloutRequest, GameServerDeployment, Empty>
        commitRolloutOperationSettings() {
      return getStubSettingsBuilder().commitRolloutOperationSettings();
    }

    /** Returns the builder for the settings used for calls to revertRollout. */
    public UnaryCallSettings.Builder<RevertRolloutRequest, Operation> revertRolloutSettings() {
      return getStubSettingsBuilder().revertRolloutSettings();
    }

    /** Returns the builder for the settings used for calls to revertRollout. */
    @BetaApi(
        "The surface for long-running operations is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<RevertRolloutRequest, GameServerDeployment, Empty>
        revertRolloutOperationSettings() {
      return getStubSettingsBuilder().revertRolloutOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getDeploymentTarget. */
    public UnaryCallSettings.Builder<GetDeploymentTargetRequest, DeploymentTarget>
        getDeploymentTargetSettings() {
      return getStubSettingsBuilder().getDeploymentTargetSettings();
    }

    @Override
    public GameServerDeploymentsServiceSettings build() throws IOException {
      return new GameServerDeploymentsServiceSettings(this);
    }
  }
}
