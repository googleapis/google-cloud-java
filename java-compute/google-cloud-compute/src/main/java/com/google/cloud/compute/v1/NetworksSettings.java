/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.compute.v1.NetworksClient.ListPagedResponse;
import static com.google.cloud.compute.v1.NetworksClient.ListPeeringRoutesPagedResponse;

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
import com.google.cloud.compute.v1.stub.NetworksStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link NetworksClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (compute.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of addPeering to 30 seconds:
 *
 * <pre>
 * <code>
 * NetworksSettings.Builder networksSettingsBuilder =
 *     NetworksSettings.newBuilder();
 * networksSettingsBuilder
 *     .addPeeringSettings()
 *     .setRetrySettings(
 *         networksSettingsBuilder.addPeeringSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * NetworksSettings networksSettings = networksSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class NetworksSettings extends ClientSettings<NetworksSettings> {
  /** Returns the object with the settings used for calls to addPeering. */
  public UnaryCallSettings<AddPeeringNetworkRequest, Operation> addPeeringSettings() {
    return ((NetworksStubSettings) getStubSettings()).addPeeringSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteNetworkRequest, Operation> deleteSettings() {
    return ((NetworksStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetNetworkRequest, Network> getSettings() {
    return ((NetworksStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to getEffectiveFirewalls. */
  public UnaryCallSettings<
          GetEffectiveFirewallsNetworkRequest, NetworksGetEffectiveFirewallsResponse>
      getEffectiveFirewallsSettings() {
    return ((NetworksStubSettings) getStubSettings()).getEffectiveFirewallsSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertNetworkRequest, Operation> insertSettings() {
    return ((NetworksStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListNetworksRequest, NetworkList, ListPagedResponse> listSettings() {
    return ((NetworksStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to listPeeringRoutes. */
  public PagedCallSettings<
          ListPeeringRoutesNetworksRequest,
          ExchangedPeeringRoutesList,
          ListPeeringRoutesPagedResponse>
      listPeeringRoutesSettings() {
    return ((NetworksStubSettings) getStubSettings()).listPeeringRoutesSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchNetworkRequest, Operation> patchSettings() {
    return ((NetworksStubSettings) getStubSettings()).patchSettings();
  }

  /** Returns the object with the settings used for calls to removePeering. */
  public UnaryCallSettings<RemovePeeringNetworkRequest, Operation> removePeeringSettings() {
    return ((NetworksStubSettings) getStubSettings()).removePeeringSettings();
  }

  /** Returns the object with the settings used for calls to switchToCustomMode. */
  public UnaryCallSettings<SwitchToCustomModeNetworkRequest, Operation>
      switchToCustomModeSettings() {
    return ((NetworksStubSettings) getStubSettings()).switchToCustomModeSettings();
  }

  /** Returns the object with the settings used for calls to updatePeering. */
  public UnaryCallSettings<UpdatePeeringNetworkRequest, Operation> updatePeeringSettings() {
    return ((NetworksStubSettings) getStubSettings()).updatePeeringSettings();
  }

  public static final NetworksSettings create(NetworksStubSettings stub) throws IOException {
    return new NetworksSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return NetworksStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return NetworksStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return NetworksStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return NetworksStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return NetworksStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return NetworksStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return NetworksStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return NetworksStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected NetworksSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for NetworksSettings. */
  public static class Builder extends ClientSettings.Builder<NetworksSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(NetworksStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(NetworksStubSettings.newBuilder());
    }

    protected Builder(NetworksSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(NetworksStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public NetworksStubSettings.Builder getStubSettingsBuilder() {
      return ((NetworksStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to addPeering. */
    public UnaryCallSettings.Builder<AddPeeringNetworkRequest, Operation> addPeeringSettings() {
      return getStubSettingsBuilder().addPeeringSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteNetworkRequest, Operation> deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetNetworkRequest, Network> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to getEffectiveFirewalls. */
    public UnaryCallSettings.Builder<
            GetEffectiveFirewallsNetworkRequest, NetworksGetEffectiveFirewallsResponse>
        getEffectiveFirewallsSettings() {
      return getStubSettingsBuilder().getEffectiveFirewallsSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertNetworkRequest, Operation> insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<ListNetworksRequest, NetworkList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to listPeeringRoutes. */
    public PagedCallSettings.Builder<
            ListPeeringRoutesNetworksRequest,
            ExchangedPeeringRoutesList,
            ListPeeringRoutesPagedResponse>
        listPeeringRoutesSettings() {
      return getStubSettingsBuilder().listPeeringRoutesSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchNetworkRequest, Operation> patchSettings() {
      return getStubSettingsBuilder().patchSettings();
    }

    /** Returns the builder for the settings used for calls to removePeering. */
    public UnaryCallSettings.Builder<RemovePeeringNetworkRequest, Operation>
        removePeeringSettings() {
      return getStubSettingsBuilder().removePeeringSettings();
    }

    /** Returns the builder for the settings used for calls to switchToCustomMode. */
    public UnaryCallSettings.Builder<SwitchToCustomModeNetworkRequest, Operation>
        switchToCustomModeSettings() {
      return getStubSettingsBuilder().switchToCustomModeSettings();
    }

    /** Returns the builder for the settings used for calls to updatePeering. */
    public UnaryCallSettings.Builder<UpdatePeeringNetworkRequest, Operation>
        updatePeeringSettings() {
      return getStubSettingsBuilder().updatePeeringSettings();
    }

    @Override
    public NetworksSettings build() throws IOException {
      return new NetworksSettings(this);
    }
  }
}
