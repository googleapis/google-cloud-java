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

package com.google.cloud.gaming.v1;

import static com.google.cloud.gaming.v1.GameServerConfigsServiceClient.ListGameServerConfigsPagedResponse;

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
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.gaming.v1.stub.GameServerConfigsServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link GameServerConfigsServiceClient}.
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GameServerConfigsServiceSettings.Builder gameServerConfigsServiceSettingsBuilder =
 *     GameServerConfigsServiceSettings.newBuilder();
 * gameServerConfigsServiceSettingsBuilder
 *     .getGameServerConfigSettings()
 *     .setRetrySettings(
 *         gameServerConfigsServiceSettingsBuilder
 *             .getGameServerConfigSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * GameServerConfigsServiceSettings gameServerConfigsServiceSettings =
 *     gameServerConfigsServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class GameServerConfigsServiceSettings
    extends ClientSettings<GameServerConfigsServiceSettings> {

  /** Returns the object with the settings used for calls to listGameServerConfigs. */
  public PagedCallSettings<
          ListGameServerConfigsRequest,
          ListGameServerConfigsResponse,
          ListGameServerConfigsPagedResponse>
      listGameServerConfigsSettings() {
    return ((GameServerConfigsServiceStubSettings) getStubSettings())
        .listGameServerConfigsSettings();
  }

  /** Returns the object with the settings used for calls to getGameServerConfig. */
  public UnaryCallSettings<GetGameServerConfigRequest, GameServerConfig>
      getGameServerConfigSettings() {
    return ((GameServerConfigsServiceStubSettings) getStubSettings()).getGameServerConfigSettings();
  }

  /** Returns the object with the settings used for calls to createGameServerConfig. */
  public UnaryCallSettings<CreateGameServerConfigRequest, Operation>
      createGameServerConfigSettings() {
    return ((GameServerConfigsServiceStubSettings) getStubSettings())
        .createGameServerConfigSettings();
  }

  /** Returns the object with the settings used for calls to createGameServerConfig. */
  public OperationCallSettings<CreateGameServerConfigRequest, GameServerConfig, OperationMetadata>
      createGameServerConfigOperationSettings() {
    return ((GameServerConfigsServiceStubSettings) getStubSettings())
        .createGameServerConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteGameServerConfig. */
  public UnaryCallSettings<DeleteGameServerConfigRequest, Operation>
      deleteGameServerConfigSettings() {
    return ((GameServerConfigsServiceStubSettings) getStubSettings())
        .deleteGameServerConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteGameServerConfig. */
  public OperationCallSettings<DeleteGameServerConfigRequest, Empty, OperationMetadata>
      deleteGameServerConfigOperationSettings() {
    return ((GameServerConfigsServiceStubSettings) getStubSettings())
        .deleteGameServerConfigOperationSettings();
  }

  public static final GameServerConfigsServiceSettings create(
      GameServerConfigsServiceStubSettings stub) throws IOException {
    return new GameServerConfigsServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return GameServerConfigsServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return GameServerConfigsServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return GameServerConfigsServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GameServerConfigsServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return GameServerConfigsServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return GameServerConfigsServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return GameServerConfigsServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return GameServerConfigsServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected GameServerConfigsServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for GameServerConfigsServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<GameServerConfigsServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(GameServerConfigsServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(GameServerConfigsServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(GameServerConfigsServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(GameServerConfigsServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(GameServerConfigsServiceStubSettings.newHttpJsonBuilder());
    }

    public GameServerConfigsServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((GameServerConfigsServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listGameServerConfigs. */
    public PagedCallSettings.Builder<
            ListGameServerConfigsRequest,
            ListGameServerConfigsResponse,
            ListGameServerConfigsPagedResponse>
        listGameServerConfigsSettings() {
      return getStubSettingsBuilder().listGameServerConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to getGameServerConfig. */
    public UnaryCallSettings.Builder<GetGameServerConfigRequest, GameServerConfig>
        getGameServerConfigSettings() {
      return getStubSettingsBuilder().getGameServerConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createGameServerConfig. */
    public UnaryCallSettings.Builder<CreateGameServerConfigRequest, Operation>
        createGameServerConfigSettings() {
      return getStubSettingsBuilder().createGameServerConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createGameServerConfig. */
    public OperationCallSettings.Builder<
            CreateGameServerConfigRequest, GameServerConfig, OperationMetadata>
        createGameServerConfigOperationSettings() {
      return getStubSettingsBuilder().createGameServerConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGameServerConfig. */
    public UnaryCallSettings.Builder<DeleteGameServerConfigRequest, Operation>
        deleteGameServerConfigSettings() {
      return getStubSettingsBuilder().deleteGameServerConfigSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGameServerConfig. */
    public OperationCallSettings.Builder<DeleteGameServerConfigRequest, Empty, OperationMetadata>
        deleteGameServerConfigOperationSettings() {
      return getStubSettingsBuilder().deleteGameServerConfigOperationSettings();
    }

    @Override
    public GameServerConfigsServiceSettings build() throws IOException {
      return new GameServerConfigsServiceSettings(this);
    }
  }
}
