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

import static com.google.cloud.compute.v1.VpnGatewayClient.AggregatedListVpnGatewaysPagedResponse;
import static com.google.cloud.compute.v1.VpnGatewayClient.ListVpnGatewaysPagedResponse;

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
import com.google.cloud.compute.v1.stub.VpnGatewayStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link VpnGatewayClient}.
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
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of deleteVpnGateway to 30 seconds:
 *
 * <pre>
 * <code>
 * VpnGatewaySettings.Builder vpnGatewaySettingsBuilder =
 *     VpnGatewaySettings.newBuilder();
 * vpnGatewaySettingsBuilder.deleteVpnGatewaySettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * VpnGatewaySettings vpnGatewaySettings = vpnGatewaySettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class VpnGatewaySettings extends ClientSettings<VpnGatewaySettings> {
  /** Returns the object with the settings used for calls to aggregatedListVpnGateways. */
  public PagedCallSettings<
          AggregatedListVpnGatewaysHttpRequest,
          VpnGatewayAggregatedList,
          AggregatedListVpnGatewaysPagedResponse>
      aggregatedListVpnGatewaysSettings() {
    return ((VpnGatewayStubSettings) getStubSettings()).aggregatedListVpnGatewaysSettings();
  }

  /** Returns the object with the settings used for calls to deleteVpnGateway. */
  public UnaryCallSettings<DeleteVpnGatewayHttpRequest, Operation> deleteVpnGatewaySettings() {
    return ((VpnGatewayStubSettings) getStubSettings()).deleteVpnGatewaySettings();
  }

  /** Returns the object with the settings used for calls to getVpnGateway. */
  public UnaryCallSettings<GetVpnGatewayHttpRequest, VpnGateway> getVpnGatewaySettings() {
    return ((VpnGatewayStubSettings) getStubSettings()).getVpnGatewaySettings();
  }

  /** Returns the object with the settings used for calls to getStatusVpnGateway. */
  public UnaryCallSettings<GetStatusVpnGatewayHttpRequest, VpnGatewaysGetStatusResponse>
      getStatusVpnGatewaySettings() {
    return ((VpnGatewayStubSettings) getStubSettings()).getStatusVpnGatewaySettings();
  }

  /** Returns the object with the settings used for calls to insertVpnGateway. */
  public UnaryCallSettings<InsertVpnGatewayHttpRequest, Operation> insertVpnGatewaySettings() {
    return ((VpnGatewayStubSettings) getStubSettings()).insertVpnGatewaySettings();
  }

  /** Returns the object with the settings used for calls to listVpnGateways. */
  public PagedCallSettings<ListVpnGatewaysHttpRequest, VpnGatewayList, ListVpnGatewaysPagedResponse>
      listVpnGatewaysSettings() {
    return ((VpnGatewayStubSettings) getStubSettings()).listVpnGatewaysSettings();
  }

  /** Returns the object with the settings used for calls to setLabelsVpnGateway. */
  public UnaryCallSettings<SetLabelsVpnGatewayHttpRequest, Operation>
      setLabelsVpnGatewaySettings() {
    return ((VpnGatewayStubSettings) getStubSettings()).setLabelsVpnGatewaySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissionsVpnGateway. */
  public UnaryCallSettings<TestIamPermissionsVpnGatewayHttpRequest, TestPermissionsResponse>
      testIamPermissionsVpnGatewaySettings() {
    return ((VpnGatewayStubSettings) getStubSettings()).testIamPermissionsVpnGatewaySettings();
  }

  public static final VpnGatewaySettings create(VpnGatewayStubSettings stub) throws IOException {
    return new VpnGatewaySettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return VpnGatewayStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return VpnGatewayStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return VpnGatewayStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return VpnGatewayStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return VpnGatewayStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return VpnGatewayStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return VpnGatewayStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return VpnGatewayStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected VpnGatewaySettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for VpnGatewaySettings. */
  public static class Builder extends ClientSettings.Builder<VpnGatewaySettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(VpnGatewayStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(VpnGatewayStubSettings.newBuilder());
    }

    protected Builder(VpnGatewaySettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(VpnGatewayStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public VpnGatewayStubSettings.Builder getStubSettingsBuilder() {
      return ((VpnGatewayStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to aggregatedListVpnGateways. */
    public PagedCallSettings.Builder<
            AggregatedListVpnGatewaysHttpRequest,
            VpnGatewayAggregatedList,
            AggregatedListVpnGatewaysPagedResponse>
        aggregatedListVpnGatewaysSettings() {
      return getStubSettingsBuilder().aggregatedListVpnGatewaysSettings();
    }

    /** Returns the builder for the settings used for calls to deleteVpnGateway. */
    public UnaryCallSettings.Builder<DeleteVpnGatewayHttpRequest, Operation>
        deleteVpnGatewaySettings() {
      return getStubSettingsBuilder().deleteVpnGatewaySettings();
    }

    /** Returns the builder for the settings used for calls to getVpnGateway. */
    public UnaryCallSettings.Builder<GetVpnGatewayHttpRequest, VpnGateway> getVpnGatewaySettings() {
      return getStubSettingsBuilder().getVpnGatewaySettings();
    }

    /** Returns the builder for the settings used for calls to getStatusVpnGateway. */
    public UnaryCallSettings.Builder<GetStatusVpnGatewayHttpRequest, VpnGatewaysGetStatusResponse>
        getStatusVpnGatewaySettings() {
      return getStubSettingsBuilder().getStatusVpnGatewaySettings();
    }

    /** Returns the builder for the settings used for calls to insertVpnGateway. */
    public UnaryCallSettings.Builder<InsertVpnGatewayHttpRequest, Operation>
        insertVpnGatewaySettings() {
      return getStubSettingsBuilder().insertVpnGatewaySettings();
    }

    /** Returns the builder for the settings used for calls to listVpnGateways. */
    public PagedCallSettings.Builder<
            ListVpnGatewaysHttpRequest, VpnGatewayList, ListVpnGatewaysPagedResponse>
        listVpnGatewaysSettings() {
      return getStubSettingsBuilder().listVpnGatewaysSettings();
    }

    /** Returns the builder for the settings used for calls to setLabelsVpnGateway. */
    public UnaryCallSettings.Builder<SetLabelsVpnGatewayHttpRequest, Operation>
        setLabelsVpnGatewaySettings() {
      return getStubSettingsBuilder().setLabelsVpnGatewaySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissionsVpnGateway. */
    public UnaryCallSettings.Builder<
            TestIamPermissionsVpnGatewayHttpRequest, TestPermissionsResponse>
        testIamPermissionsVpnGatewaySettings() {
      return getStubSettingsBuilder().testIamPermissionsVpnGatewaySettings();
    }

    @Override
    public VpnGatewaySettings build() throws IOException {
      return new VpnGatewaySettings(this);
    }
  }
}
