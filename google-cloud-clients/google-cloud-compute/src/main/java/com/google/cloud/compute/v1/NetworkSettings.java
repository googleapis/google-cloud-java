/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.NetworkClient.ListNetworksPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.NetworkStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link NetworkClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://www.googleapis.com/compute/v1/projects/) and default
 *       port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of addPeeringNetwork to 30 seconds:
 *
 * <pre>
 * <code>
 * NetworkSettings.Builder networkSettingsBuilder =
 *     NetworkSettings.newBuilder();
 * networkSettingsBuilder.addPeeringNetworkSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * NetworkSettings networkSettings = networkSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class NetworkSettings extends ClientSettings<NetworkSettings> {
  /** Returns the object with the settings used for calls to addPeeringNetwork. */
  public UnaryCallSettings<AddPeeringNetworkHttpRequest, Operation> addPeeringNetworkSettings() {
    return ((NetworkStubSettings) getStubSettings()).addPeeringNetworkSettings();
  }

  /** Returns the object with the settings used for calls to deleteNetwork. */
  public UnaryCallSettings<DeleteNetworkHttpRequest, Operation> deleteNetworkSettings() {
    return ((NetworkStubSettings) getStubSettings()).deleteNetworkSettings();
  }

  /** Returns the object with the settings used for calls to getNetwork. */
  public UnaryCallSettings<GetNetworkHttpRequest, Network> getNetworkSettings() {
    return ((NetworkStubSettings) getStubSettings()).getNetworkSettings();
  }

  /** Returns the object with the settings used for calls to insertNetwork. */
  public UnaryCallSettings<InsertNetworkHttpRequest, Operation> insertNetworkSettings() {
    return ((NetworkStubSettings) getStubSettings()).insertNetworkSettings();
  }

  /** Returns the object with the settings used for calls to listNetworks. */
  public PagedCallSettings<ListNetworksHttpRequest, NetworkList, ListNetworksPagedResponse>
      listNetworksSettings() {
    return ((NetworkStubSettings) getStubSettings()).listNetworksSettings();
  }

  /** Returns the object with the settings used for calls to patchNetwork. */
  public UnaryCallSettings<PatchNetworkHttpRequest, Operation> patchNetworkSettings() {
    return ((NetworkStubSettings) getStubSettings()).patchNetworkSettings();
  }

  /** Returns the object with the settings used for calls to removePeeringNetwork. */
  public UnaryCallSettings<RemovePeeringNetworkHttpRequest, Operation>
      removePeeringNetworkSettings() {
    return ((NetworkStubSettings) getStubSettings()).removePeeringNetworkSettings();
  }

  /** Returns the object with the settings used for calls to switchToCustomModeNetwork. */
  public UnaryCallSettings<SwitchToCustomModeNetworkHttpRequest, Operation>
      switchToCustomModeNetworkSettings() {
    return ((NetworkStubSettings) getStubSettings()).switchToCustomModeNetworkSettings();
  }

  public static final NetworkSettings create(NetworkStubSettings stub) throws IOException {
    return new NetworkSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return NetworkStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return NetworkStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return NetworkStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return NetworkStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return NetworkStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return NetworkStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return NetworkStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return NetworkStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected NetworkSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for NetworkSettings. */
  public static class Builder extends ClientSettings.Builder<NetworkSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(NetworkStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(NetworkStubSettings.newBuilder());
    }

    protected Builder(NetworkSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(NetworkStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public NetworkStubSettings.Builder getStubSettingsBuilder() {
      return ((NetworkStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to addPeeringNetwork. */
    public UnaryCallSettings.Builder<AddPeeringNetworkHttpRequest, Operation>
        addPeeringNetworkSettings() {
      return getStubSettingsBuilder().addPeeringNetworkSettings();
    }

    /** Returns the builder for the settings used for calls to deleteNetwork. */
    public UnaryCallSettings.Builder<DeleteNetworkHttpRequest, Operation> deleteNetworkSettings() {
      return getStubSettingsBuilder().deleteNetworkSettings();
    }

    /** Returns the builder for the settings used for calls to getNetwork. */
    public UnaryCallSettings.Builder<GetNetworkHttpRequest, Network> getNetworkSettings() {
      return getStubSettingsBuilder().getNetworkSettings();
    }

    /** Returns the builder for the settings used for calls to insertNetwork. */
    public UnaryCallSettings.Builder<InsertNetworkHttpRequest, Operation> insertNetworkSettings() {
      return getStubSettingsBuilder().insertNetworkSettings();
    }

    /** Returns the builder for the settings used for calls to listNetworks. */
    public PagedCallSettings.Builder<
            ListNetworksHttpRequest, NetworkList, ListNetworksPagedResponse>
        listNetworksSettings() {
      return getStubSettingsBuilder().listNetworksSettings();
    }

    /** Returns the builder for the settings used for calls to patchNetwork. */
    public UnaryCallSettings.Builder<PatchNetworkHttpRequest, Operation> patchNetworkSettings() {
      return getStubSettingsBuilder().patchNetworkSettings();
    }

    /** Returns the builder for the settings used for calls to removePeeringNetwork. */
    public UnaryCallSettings.Builder<RemovePeeringNetworkHttpRequest, Operation>
        removePeeringNetworkSettings() {
      return getStubSettingsBuilder().removePeeringNetworkSettings();
    }

    /** Returns the builder for the settings used for calls to switchToCustomModeNetwork. */
    public UnaryCallSettings.Builder<SwitchToCustomModeNetworkHttpRequest, Operation>
        switchToCustomModeNetworkSettings() {
      return getStubSettingsBuilder().switchToCustomModeNetworkSettings();
    }

    @Override
    public NetworkSettings build() throws IOException {
      return new NetworkSettings(this);
    }
  }
}
