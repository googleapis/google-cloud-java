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
package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.VpnTunnelClient.AggregatedListVpnTunnelsPagedResponse;
import static com.google.cloud.compute.v1.VpnTunnelClient.ListVpnTunnelsPagedResponse;

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
import com.google.cloud.compute.v1.stub.VpnTunnelStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link VpnTunnelClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://compute.googleapis.com/compute/v1/projects/) and
 *       default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of deleteVpnTunnel to 30 seconds:
 *
 * <pre>
 * <code>
 * VpnTunnelSettings.Builder vpnTunnelSettingsBuilder =
 *     VpnTunnelSettings.newBuilder();
 * vpnTunnelSettingsBuilder.deleteVpnTunnelSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * VpnTunnelSettings vpnTunnelSettings = vpnTunnelSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class VpnTunnelSettings extends ClientSettings<VpnTunnelSettings> {
  /** Returns the object with the settings used for calls to aggregatedListVpnTunnels. */
  public PagedCallSettings<
          AggregatedListVpnTunnelsHttpRequest,
          VpnTunnelAggregatedList,
          AggregatedListVpnTunnelsPagedResponse>
      aggregatedListVpnTunnelsSettings() {
    return ((VpnTunnelStubSettings) getStubSettings()).aggregatedListVpnTunnelsSettings();
  }

  /** Returns the object with the settings used for calls to deleteVpnTunnel. */
  public UnaryCallSettings<DeleteVpnTunnelHttpRequest, Operation> deleteVpnTunnelSettings() {
    return ((VpnTunnelStubSettings) getStubSettings()).deleteVpnTunnelSettings();
  }

  /** Returns the object with the settings used for calls to getVpnTunnel. */
  public UnaryCallSettings<GetVpnTunnelHttpRequest, VpnTunnel> getVpnTunnelSettings() {
    return ((VpnTunnelStubSettings) getStubSettings()).getVpnTunnelSettings();
  }

  /** Returns the object with the settings used for calls to insertVpnTunnel. */
  public UnaryCallSettings<InsertVpnTunnelHttpRequest, Operation> insertVpnTunnelSettings() {
    return ((VpnTunnelStubSettings) getStubSettings()).insertVpnTunnelSettings();
  }

  /** Returns the object with the settings used for calls to listVpnTunnels. */
  public PagedCallSettings<ListVpnTunnelsHttpRequest, VpnTunnelList, ListVpnTunnelsPagedResponse>
      listVpnTunnelsSettings() {
    return ((VpnTunnelStubSettings) getStubSettings()).listVpnTunnelsSettings();
  }

  public static final VpnTunnelSettings create(VpnTunnelStubSettings stub) throws IOException {
    return new VpnTunnelSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return VpnTunnelStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return VpnTunnelStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return VpnTunnelStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return VpnTunnelStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return VpnTunnelStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return VpnTunnelStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return VpnTunnelStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return VpnTunnelStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected VpnTunnelSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for VpnTunnelSettings. */
  public static class Builder extends ClientSettings.Builder<VpnTunnelSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(VpnTunnelStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(VpnTunnelStubSettings.newBuilder());
    }

    protected Builder(VpnTunnelSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(VpnTunnelStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public VpnTunnelStubSettings.Builder getStubSettingsBuilder() {
      return ((VpnTunnelStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to aggregatedListVpnTunnels. */
    public PagedCallSettings.Builder<
            AggregatedListVpnTunnelsHttpRequest,
            VpnTunnelAggregatedList,
            AggregatedListVpnTunnelsPagedResponse>
        aggregatedListVpnTunnelsSettings() {
      return getStubSettingsBuilder().aggregatedListVpnTunnelsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteVpnTunnel. */
    public UnaryCallSettings.Builder<DeleteVpnTunnelHttpRequest, Operation>
        deleteVpnTunnelSettings() {
      return getStubSettingsBuilder().deleteVpnTunnelSettings();
    }

    /** Returns the builder for the settings used for calls to getVpnTunnel. */
    public UnaryCallSettings.Builder<GetVpnTunnelHttpRequest, VpnTunnel> getVpnTunnelSettings() {
      return getStubSettingsBuilder().getVpnTunnelSettings();
    }

    /** Returns the builder for the settings used for calls to insertVpnTunnel. */
    public UnaryCallSettings.Builder<InsertVpnTunnelHttpRequest, Operation>
        insertVpnTunnelSettings() {
      return getStubSettingsBuilder().insertVpnTunnelSettings();
    }

    /** Returns the builder for the settings used for calls to listVpnTunnels. */
    public PagedCallSettings.Builder<
            ListVpnTunnelsHttpRequest, VpnTunnelList, ListVpnTunnelsPagedResponse>
        listVpnTunnelsSettings() {
      return getStubSettingsBuilder().listVpnTunnelsSettings();
    }

    @Override
    public VpnTunnelSettings build() throws IOException {
      return new VpnTunnelSettings(this);
    }
  }
}
