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

import static com.google.cloud.compute.v1.SubnetworkClient.AggregatedListSubnetworksPagedResponse;
import static com.google.cloud.compute.v1.SubnetworkClient.ListSubnetworksPagedResponse;
import static com.google.cloud.compute.v1.SubnetworkClient.ListUsableSubnetworksPagedResponse;

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
import com.google.cloud.compute.v1.stub.SubnetworkStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link SubnetworkClient}.
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
 * example, to set the total timeout of deleteSubnetwork to 30 seconds:
 *
 * <pre>
 * <code>
 * SubnetworkSettings.Builder subnetworkSettingsBuilder =
 *     SubnetworkSettings.newBuilder();
 * subnetworkSettingsBuilder.deleteSubnetworkSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * SubnetworkSettings subnetworkSettings = subnetworkSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class SubnetworkSettings extends ClientSettings<SubnetworkSettings> {
  /** Returns the object with the settings used for calls to aggregatedListSubnetworks. */
  public PagedCallSettings<
          AggregatedListSubnetworksHttpRequest,
          SubnetworkAggregatedList,
          AggregatedListSubnetworksPagedResponse>
      aggregatedListSubnetworksSettings() {
    return ((SubnetworkStubSettings) getStubSettings()).aggregatedListSubnetworksSettings();
  }

  /** Returns the object with the settings used for calls to deleteSubnetwork. */
  public UnaryCallSettings<DeleteSubnetworkHttpRequest, Operation> deleteSubnetworkSettings() {
    return ((SubnetworkStubSettings) getStubSettings()).deleteSubnetworkSettings();
  }

  /** Returns the object with the settings used for calls to expandIpCidrRangeSubnetwork. */
  public UnaryCallSettings<ExpandIpCidrRangeSubnetworkHttpRequest, Operation>
      expandIpCidrRangeSubnetworkSettings() {
    return ((SubnetworkStubSettings) getStubSettings()).expandIpCidrRangeSubnetworkSettings();
  }

  /** Returns the object with the settings used for calls to getSubnetwork. */
  public UnaryCallSettings<GetSubnetworkHttpRequest, Subnetwork> getSubnetworkSettings() {
    return ((SubnetworkStubSettings) getStubSettings()).getSubnetworkSettings();
  }

  /** Returns the object with the settings used for calls to insertSubnetwork. */
  public UnaryCallSettings<InsertSubnetworkHttpRequest, Operation> insertSubnetworkSettings() {
    return ((SubnetworkStubSettings) getStubSettings()).insertSubnetworkSettings();
  }

  /** Returns the object with the settings used for calls to listSubnetworks. */
  public PagedCallSettings<ListSubnetworksHttpRequest, SubnetworkList, ListSubnetworksPagedResponse>
      listSubnetworksSettings() {
    return ((SubnetworkStubSettings) getStubSettings()).listSubnetworksSettings();
  }

  /** Returns the object with the settings used for calls to listUsableSubnetworks. */
  public PagedCallSettings<
          ListUsableSubnetworksHttpRequest,
          UsableSubnetworksAggregatedList,
          ListUsableSubnetworksPagedResponse>
      listUsableSubnetworksSettings() {
    return ((SubnetworkStubSettings) getStubSettings()).listUsableSubnetworksSettings();
  }

  /** Returns the object with the settings used for calls to patchSubnetwork. */
  public UnaryCallSettings<PatchSubnetworkHttpRequest, Operation> patchSubnetworkSettings() {
    return ((SubnetworkStubSettings) getStubSettings()).patchSubnetworkSettings();
  }

  /** Returns the object with the settings used for calls to setPrivateIpGoogleAccessSubnetwork. */
  public UnaryCallSettings<SetPrivateIpGoogleAccessSubnetworkHttpRequest, Operation>
      setPrivateIpGoogleAccessSubnetworkSettings() {
    return ((SubnetworkStubSettings) getStubSettings())
        .setPrivateIpGoogleAccessSubnetworkSettings();
  }

  public static final SubnetworkSettings create(SubnetworkStubSettings stub) throws IOException {
    return new SubnetworkSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SubnetworkStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SubnetworkStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return SubnetworkStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SubnetworkStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SubnetworkStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return SubnetworkStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SubnetworkStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SubnetworkStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SubnetworkSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SubnetworkSettings. */
  public static class Builder extends ClientSettings.Builder<SubnetworkSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(SubnetworkStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(SubnetworkStubSettings.newBuilder());
    }

    protected Builder(SubnetworkSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SubnetworkStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public SubnetworkStubSettings.Builder getStubSettingsBuilder() {
      return ((SubnetworkStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to aggregatedListSubnetworks. */
    public PagedCallSettings.Builder<
            AggregatedListSubnetworksHttpRequest,
            SubnetworkAggregatedList,
            AggregatedListSubnetworksPagedResponse>
        aggregatedListSubnetworksSettings() {
      return getStubSettingsBuilder().aggregatedListSubnetworksSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSubnetwork. */
    public UnaryCallSettings.Builder<DeleteSubnetworkHttpRequest, Operation>
        deleteSubnetworkSettings() {
      return getStubSettingsBuilder().deleteSubnetworkSettings();
    }

    /** Returns the builder for the settings used for calls to expandIpCidrRangeSubnetwork. */
    public UnaryCallSettings.Builder<ExpandIpCidrRangeSubnetworkHttpRequest, Operation>
        expandIpCidrRangeSubnetworkSettings() {
      return getStubSettingsBuilder().expandIpCidrRangeSubnetworkSettings();
    }

    /** Returns the builder for the settings used for calls to getSubnetwork. */
    public UnaryCallSettings.Builder<GetSubnetworkHttpRequest, Subnetwork> getSubnetworkSettings() {
      return getStubSettingsBuilder().getSubnetworkSettings();
    }

    /** Returns the builder for the settings used for calls to insertSubnetwork. */
    public UnaryCallSettings.Builder<InsertSubnetworkHttpRequest, Operation>
        insertSubnetworkSettings() {
      return getStubSettingsBuilder().insertSubnetworkSettings();
    }

    /** Returns the builder for the settings used for calls to listSubnetworks. */
    public PagedCallSettings.Builder<
            ListSubnetworksHttpRequest, SubnetworkList, ListSubnetworksPagedResponse>
        listSubnetworksSettings() {
      return getStubSettingsBuilder().listSubnetworksSettings();
    }

    /** Returns the builder for the settings used for calls to listUsableSubnetworks. */
    public PagedCallSettings.Builder<
            ListUsableSubnetworksHttpRequest,
            UsableSubnetworksAggregatedList,
            ListUsableSubnetworksPagedResponse>
        listUsableSubnetworksSettings() {
      return getStubSettingsBuilder().listUsableSubnetworksSettings();
    }

    /** Returns the builder for the settings used for calls to patchSubnetwork. */
    public UnaryCallSettings.Builder<PatchSubnetworkHttpRequest, Operation>
        patchSubnetworkSettings() {
      return getStubSettingsBuilder().patchSubnetworkSettings();
    }

    /**
     * Returns the builder for the settings used for calls to setPrivateIpGoogleAccessSubnetwork.
     */
    public UnaryCallSettings.Builder<SetPrivateIpGoogleAccessSubnetworkHttpRequest, Operation>
        setPrivateIpGoogleAccessSubnetworkSettings() {
      return getStubSettingsBuilder().setPrivateIpGoogleAccessSubnetworkSettings();
    }

    @Override
    public SubnetworkSettings build() throws IOException {
      return new SubnetworkSettings(this);
    }
  }
}
