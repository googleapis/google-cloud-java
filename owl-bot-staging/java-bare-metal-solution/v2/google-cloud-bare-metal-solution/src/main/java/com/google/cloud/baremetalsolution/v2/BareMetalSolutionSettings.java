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

package com.google.cloud.baremetalsolution.v2;

import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListInstancesPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListLunsPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListNetworksPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListNfsSharesPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListVolumesPagedResponse;

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
import com.google.cloud.baremetalsolution.v2.stub.BareMetalSolutionStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link BareMetalSolutionClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (baremetalsolution.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getInstance to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BareMetalSolutionSettings.Builder bareMetalSolutionSettingsBuilder =
 *     BareMetalSolutionSettings.newBuilder();
 * bareMetalSolutionSettingsBuilder
 *     .getInstanceSettings()
 *     .setRetrySettings(
 *         bareMetalSolutionSettingsBuilder.getInstanceSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * BareMetalSolutionSettings bareMetalSolutionSettings = bareMetalSolutionSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class BareMetalSolutionSettings extends ClientSettings<BareMetalSolutionSettings> {

  /** Returns the object with the settings used for calls to listInstances. */
  public PagedCallSettings<ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).listInstancesSettings();
  }

  /** Returns the object with the settings used for calls to getInstance. */
  public UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).getInstanceSettings();
  }

  /** Returns the object with the settings used for calls to updateInstance. */
  public UnaryCallSettings<UpdateInstanceRequest, Operation> updateInstanceSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).updateInstanceSettings();
  }

  /** Returns the object with the settings used for calls to updateInstance. */
  public OperationCallSettings<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).updateInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to resetInstance. */
  public UnaryCallSettings<ResetInstanceRequest, Operation> resetInstanceSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).resetInstanceSettings();
  }

  /** Returns the object with the settings used for calls to resetInstance. */
  public OperationCallSettings<ResetInstanceRequest, ResetInstanceResponse, OperationMetadata>
      resetInstanceOperationSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).resetInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to startInstance. */
  public UnaryCallSettings<StartInstanceRequest, Operation> startInstanceSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).startInstanceSettings();
  }

  /** Returns the object with the settings used for calls to startInstance. */
  public OperationCallSettings<StartInstanceRequest, StartInstanceResponse, OperationMetadata>
      startInstanceOperationSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).startInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to stopInstance. */
  public UnaryCallSettings<StopInstanceRequest, Operation> stopInstanceSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).stopInstanceSettings();
  }

  /** Returns the object with the settings used for calls to stopInstance. */
  public OperationCallSettings<StopInstanceRequest, StopInstanceResponse, OperationMetadata>
      stopInstanceOperationSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).stopInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to detachLun. */
  public UnaryCallSettings<DetachLunRequest, Operation> detachLunSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).detachLunSettings();
  }

  /** Returns the object with the settings used for calls to detachLun. */
  public OperationCallSettings<DetachLunRequest, Instance, OperationMetadata>
      detachLunOperationSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).detachLunOperationSettings();
  }

  /** Returns the object with the settings used for calls to listVolumes. */
  public PagedCallSettings<ListVolumesRequest, ListVolumesResponse, ListVolumesPagedResponse>
      listVolumesSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).listVolumesSettings();
  }

  /** Returns the object with the settings used for calls to getVolume. */
  public UnaryCallSettings<GetVolumeRequest, Volume> getVolumeSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).getVolumeSettings();
  }

  /** Returns the object with the settings used for calls to updateVolume. */
  public UnaryCallSettings<UpdateVolumeRequest, Operation> updateVolumeSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).updateVolumeSettings();
  }

  /** Returns the object with the settings used for calls to updateVolume. */
  public OperationCallSettings<UpdateVolumeRequest, Volume, OperationMetadata>
      updateVolumeOperationSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).updateVolumeOperationSettings();
  }

  /** Returns the object with the settings used for calls to resizeVolume. */
  public UnaryCallSettings<ResizeVolumeRequest, Operation> resizeVolumeSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).resizeVolumeSettings();
  }

  /** Returns the object with the settings used for calls to resizeVolume. */
  public OperationCallSettings<ResizeVolumeRequest, Volume, OperationMetadata>
      resizeVolumeOperationSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).resizeVolumeOperationSettings();
  }

  /** Returns the object with the settings used for calls to listNetworks. */
  public PagedCallSettings<ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>
      listNetworksSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).listNetworksSettings();
  }

  /** Returns the object with the settings used for calls to listNetworkUsage. */
  public UnaryCallSettings<ListNetworkUsageRequest, ListNetworkUsageResponse>
      listNetworkUsageSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).listNetworkUsageSettings();
  }

  /** Returns the object with the settings used for calls to getNetwork. */
  public UnaryCallSettings<GetNetworkRequest, Network> getNetworkSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).getNetworkSettings();
  }

  /** Returns the object with the settings used for calls to updateNetwork. */
  public UnaryCallSettings<UpdateNetworkRequest, Operation> updateNetworkSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).updateNetworkSettings();
  }

  /** Returns the object with the settings used for calls to updateNetwork. */
  public OperationCallSettings<UpdateNetworkRequest, Network, OperationMetadata>
      updateNetworkOperationSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).updateNetworkOperationSettings();
  }

  /** Returns the object with the settings used for calls to getLun. */
  public UnaryCallSettings<GetLunRequest, Lun> getLunSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).getLunSettings();
  }

  /** Returns the object with the settings used for calls to listLuns. */
  public PagedCallSettings<ListLunsRequest, ListLunsResponse, ListLunsPagedResponse>
      listLunsSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).listLunsSettings();
  }

  /** Returns the object with the settings used for calls to getNfsShare. */
  public UnaryCallSettings<GetNfsShareRequest, NfsShare> getNfsShareSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).getNfsShareSettings();
  }

  /** Returns the object with the settings used for calls to listNfsShares. */
  public PagedCallSettings<ListNfsSharesRequest, ListNfsSharesResponse, ListNfsSharesPagedResponse>
      listNfsSharesSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).listNfsSharesSettings();
  }

  /** Returns the object with the settings used for calls to updateNfsShare. */
  public UnaryCallSettings<UpdateNfsShareRequest, Operation> updateNfsShareSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).updateNfsShareSettings();
  }

  /** Returns the object with the settings used for calls to updateNfsShare. */
  public OperationCallSettings<UpdateNfsShareRequest, NfsShare, OperationMetadata>
      updateNfsShareOperationSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).updateNfsShareOperationSettings();
  }

  public static final BareMetalSolutionSettings create(BareMetalSolutionStubSettings stub)
      throws IOException {
    return new BareMetalSolutionSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return BareMetalSolutionStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return BareMetalSolutionStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return BareMetalSolutionStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return BareMetalSolutionStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return BareMetalSolutionStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return BareMetalSolutionStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return BareMetalSolutionStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BareMetalSolutionStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected BareMetalSolutionSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for BareMetalSolutionSettings. */
  public static class Builder extends ClientSettings.Builder<BareMetalSolutionSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(BareMetalSolutionStubSettings.newBuilder(clientContext));
    }

    protected Builder(BareMetalSolutionSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(BareMetalSolutionStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(BareMetalSolutionStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(BareMetalSolutionStubSettings.newHttpJsonBuilder());
    }

    public BareMetalSolutionStubSettings.Builder getStubSettingsBuilder() {
      return ((BareMetalSolutionStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listInstances. */
    public PagedCallSettings.Builder<
            ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
        listInstancesSettings() {
      return getStubSettingsBuilder().listInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to getInstance. */
    public UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings() {
      return getStubSettingsBuilder().getInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to updateInstance. */
    public UnaryCallSettings.Builder<UpdateInstanceRequest, Operation> updateInstanceSettings() {
      return getStubSettingsBuilder().updateInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to updateInstance. */
    public OperationCallSettings.Builder<UpdateInstanceRequest, Instance, OperationMetadata>
        updateInstanceOperationSettings() {
      return getStubSettingsBuilder().updateInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to resetInstance. */
    public UnaryCallSettings.Builder<ResetInstanceRequest, Operation> resetInstanceSettings() {
      return getStubSettingsBuilder().resetInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to resetInstance. */
    public OperationCallSettings.Builder<
            ResetInstanceRequest, ResetInstanceResponse, OperationMetadata>
        resetInstanceOperationSettings() {
      return getStubSettingsBuilder().resetInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to startInstance. */
    public UnaryCallSettings.Builder<StartInstanceRequest, Operation> startInstanceSettings() {
      return getStubSettingsBuilder().startInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to startInstance. */
    public OperationCallSettings.Builder<
            StartInstanceRequest, StartInstanceResponse, OperationMetadata>
        startInstanceOperationSettings() {
      return getStubSettingsBuilder().startInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to stopInstance. */
    public UnaryCallSettings.Builder<StopInstanceRequest, Operation> stopInstanceSettings() {
      return getStubSettingsBuilder().stopInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to stopInstance. */
    public OperationCallSettings.Builder<
            StopInstanceRequest, StopInstanceResponse, OperationMetadata>
        stopInstanceOperationSettings() {
      return getStubSettingsBuilder().stopInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to detachLun. */
    public UnaryCallSettings.Builder<DetachLunRequest, Operation> detachLunSettings() {
      return getStubSettingsBuilder().detachLunSettings();
    }

    /** Returns the builder for the settings used for calls to detachLun. */
    public OperationCallSettings.Builder<DetachLunRequest, Instance, OperationMetadata>
        detachLunOperationSettings() {
      return getStubSettingsBuilder().detachLunOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listVolumes. */
    public PagedCallSettings.Builder<
            ListVolumesRequest, ListVolumesResponse, ListVolumesPagedResponse>
        listVolumesSettings() {
      return getStubSettingsBuilder().listVolumesSettings();
    }

    /** Returns the builder for the settings used for calls to getVolume. */
    public UnaryCallSettings.Builder<GetVolumeRequest, Volume> getVolumeSettings() {
      return getStubSettingsBuilder().getVolumeSettings();
    }

    /** Returns the builder for the settings used for calls to updateVolume. */
    public UnaryCallSettings.Builder<UpdateVolumeRequest, Operation> updateVolumeSettings() {
      return getStubSettingsBuilder().updateVolumeSettings();
    }

    /** Returns the builder for the settings used for calls to updateVolume. */
    public OperationCallSettings.Builder<UpdateVolumeRequest, Volume, OperationMetadata>
        updateVolumeOperationSettings() {
      return getStubSettingsBuilder().updateVolumeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to resizeVolume. */
    public UnaryCallSettings.Builder<ResizeVolumeRequest, Operation> resizeVolumeSettings() {
      return getStubSettingsBuilder().resizeVolumeSettings();
    }

    /** Returns the builder for the settings used for calls to resizeVolume. */
    public OperationCallSettings.Builder<ResizeVolumeRequest, Volume, OperationMetadata>
        resizeVolumeOperationSettings() {
      return getStubSettingsBuilder().resizeVolumeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listNetworks. */
    public PagedCallSettings.Builder<
            ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>
        listNetworksSettings() {
      return getStubSettingsBuilder().listNetworksSettings();
    }

    /** Returns the builder for the settings used for calls to listNetworkUsage. */
    public UnaryCallSettings.Builder<ListNetworkUsageRequest, ListNetworkUsageResponse>
        listNetworkUsageSettings() {
      return getStubSettingsBuilder().listNetworkUsageSettings();
    }

    /** Returns the builder for the settings used for calls to getNetwork. */
    public UnaryCallSettings.Builder<GetNetworkRequest, Network> getNetworkSettings() {
      return getStubSettingsBuilder().getNetworkSettings();
    }

    /** Returns the builder for the settings used for calls to updateNetwork. */
    public UnaryCallSettings.Builder<UpdateNetworkRequest, Operation> updateNetworkSettings() {
      return getStubSettingsBuilder().updateNetworkSettings();
    }

    /** Returns the builder for the settings used for calls to updateNetwork. */
    public OperationCallSettings.Builder<UpdateNetworkRequest, Network, OperationMetadata>
        updateNetworkOperationSettings() {
      return getStubSettingsBuilder().updateNetworkOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getLun. */
    public UnaryCallSettings.Builder<GetLunRequest, Lun> getLunSettings() {
      return getStubSettingsBuilder().getLunSettings();
    }

    /** Returns the builder for the settings used for calls to listLuns. */
    public PagedCallSettings.Builder<ListLunsRequest, ListLunsResponse, ListLunsPagedResponse>
        listLunsSettings() {
      return getStubSettingsBuilder().listLunsSettings();
    }

    /** Returns the builder for the settings used for calls to getNfsShare. */
    public UnaryCallSettings.Builder<GetNfsShareRequest, NfsShare> getNfsShareSettings() {
      return getStubSettingsBuilder().getNfsShareSettings();
    }

    /** Returns the builder for the settings used for calls to listNfsShares. */
    public PagedCallSettings.Builder<
            ListNfsSharesRequest, ListNfsSharesResponse, ListNfsSharesPagedResponse>
        listNfsSharesSettings() {
      return getStubSettingsBuilder().listNfsSharesSettings();
    }

    /** Returns the builder for the settings used for calls to updateNfsShare. */
    public UnaryCallSettings.Builder<UpdateNfsShareRequest, Operation> updateNfsShareSettings() {
      return getStubSettingsBuilder().updateNfsShareSettings();
    }

    /** Returns the builder for the settings used for calls to updateNfsShare. */
    public OperationCallSettings.Builder<UpdateNfsShareRequest, NfsShare, OperationMetadata>
        updateNfsShareOperationSettings() {
      return getStubSettingsBuilder().updateNfsShareOperationSettings();
    }

    @Override
    public BareMetalSolutionSettings build() throws IOException {
      return new BareMetalSolutionSettings(this);
    }
  }
}
