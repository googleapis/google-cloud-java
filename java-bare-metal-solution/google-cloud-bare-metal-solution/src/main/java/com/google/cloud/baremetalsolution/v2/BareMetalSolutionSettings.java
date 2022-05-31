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
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListSnapshotSchedulePoliciesPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListVolumeSnapshotsPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListVolumesPagedResponse;

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
import com.google.cloud.baremetalsolution.v2.stub.BareMetalSolutionStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
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
 * // This snippet has been automatically generated for illustrative purposes only.
 * // It may require modifications to work in your environment.
 * BareMetalSolutionSettings.Builder bareMetalSolutionSettingsBuilder =
 *     BareMetalSolutionSettings.newBuilder();
 * bareMetalSolutionSettingsBuilder
 *     .getInstanceSettings()
 *     .setRetrySettings(
 *         bareMetalSolutionSettingsBuilder
 *             .getInstanceSettings()
 *             .getRetrySettings()
 *             .toBuilder()
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

  /** Returns the object with the settings used for calls to resetInstance. */
  public UnaryCallSettings<ResetInstanceRequest, Operation> resetInstanceSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).resetInstanceSettings();
  }

  /** Returns the object with the settings used for calls to resetInstance. */
  public OperationCallSettings<ResetInstanceRequest, ResetInstanceResponse, OperationMetadata>
      resetInstanceOperationSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).resetInstanceOperationSettings();
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

  /** Returns the object with the settings used for calls to listNetworks. */
  public PagedCallSettings<ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>
      listNetworksSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).listNetworksSettings();
  }

  /** Returns the object with the settings used for calls to getNetwork. */
  public UnaryCallSettings<GetNetworkRequest, Network> getNetworkSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).getNetworkSettings();
  }

  /** Returns the object with the settings used for calls to listSnapshotSchedulePolicies. */
  public PagedCallSettings<
          ListSnapshotSchedulePoliciesRequest,
          ListSnapshotSchedulePoliciesResponse,
          ListSnapshotSchedulePoliciesPagedResponse>
      listSnapshotSchedulePoliciesSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings())
        .listSnapshotSchedulePoliciesSettings();
  }

  /** Returns the object with the settings used for calls to getSnapshotSchedulePolicy. */
  public UnaryCallSettings<GetSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
      getSnapshotSchedulePolicySettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).getSnapshotSchedulePolicySettings();
  }

  /** Returns the object with the settings used for calls to createSnapshotSchedulePolicy. */
  public UnaryCallSettings<CreateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
      createSnapshotSchedulePolicySettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings())
        .createSnapshotSchedulePolicySettings();
  }

  /** Returns the object with the settings used for calls to updateSnapshotSchedulePolicy. */
  public UnaryCallSettings<UpdateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
      updateSnapshotSchedulePolicySettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings())
        .updateSnapshotSchedulePolicySettings();
  }

  /** Returns the object with the settings used for calls to deleteSnapshotSchedulePolicy. */
  public UnaryCallSettings<DeleteSnapshotSchedulePolicyRequest, Empty>
      deleteSnapshotSchedulePolicySettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings())
        .deleteSnapshotSchedulePolicySettings();
  }

  /** Returns the object with the settings used for calls to createVolumeSnapshot. */
  public UnaryCallSettings<CreateVolumeSnapshotRequest, VolumeSnapshot>
      createVolumeSnapshotSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).createVolumeSnapshotSettings();
  }

  /** Returns the object with the settings used for calls to restoreVolumeSnapshot. */
  public UnaryCallSettings<RestoreVolumeSnapshotRequest, Operation>
      restoreVolumeSnapshotSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).restoreVolumeSnapshotSettings();
  }

  /** Returns the object with the settings used for calls to restoreVolumeSnapshot. */
  public OperationCallSettings<RestoreVolumeSnapshotRequest, VolumeSnapshot, OperationMetadata>
      restoreVolumeSnapshotOperationSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings())
        .restoreVolumeSnapshotOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteVolumeSnapshot. */
  public UnaryCallSettings<DeleteVolumeSnapshotRequest, Empty> deleteVolumeSnapshotSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).deleteVolumeSnapshotSettings();
  }

  /** Returns the object with the settings used for calls to getVolumeSnapshot. */
  public UnaryCallSettings<GetVolumeSnapshotRequest, VolumeSnapshot> getVolumeSnapshotSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).getVolumeSnapshotSettings();
  }

  /** Returns the object with the settings used for calls to listVolumeSnapshots. */
  public PagedCallSettings<
          ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse, ListVolumeSnapshotsPagedResponse>
      listVolumeSnapshotsSettings() {
    return ((BareMetalSolutionStubSettings) getStubSettings()).listVolumeSnapshotsSettings();
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return BareMetalSolutionStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return BareMetalSolutionStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BareMetalSolutionStubSettings.defaultApiClientHeaderProviderBuilder();
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

    /** Returns the builder for the settings used for calls to listNetworks. */
    public PagedCallSettings.Builder<
            ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>
        listNetworksSettings() {
      return getStubSettingsBuilder().listNetworksSettings();
    }

    /** Returns the builder for the settings used for calls to getNetwork. */
    public UnaryCallSettings.Builder<GetNetworkRequest, Network> getNetworkSettings() {
      return getStubSettingsBuilder().getNetworkSettings();
    }

    /** Returns the builder for the settings used for calls to listSnapshotSchedulePolicies. */
    public PagedCallSettings.Builder<
            ListSnapshotSchedulePoliciesRequest,
            ListSnapshotSchedulePoliciesResponse,
            ListSnapshotSchedulePoliciesPagedResponse>
        listSnapshotSchedulePoliciesSettings() {
      return getStubSettingsBuilder().listSnapshotSchedulePoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to getSnapshotSchedulePolicy. */
    public UnaryCallSettings.Builder<GetSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
        getSnapshotSchedulePolicySettings() {
      return getStubSettingsBuilder().getSnapshotSchedulePolicySettings();
    }

    /** Returns the builder for the settings used for calls to createSnapshotSchedulePolicy. */
    public UnaryCallSettings.Builder<CreateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
        createSnapshotSchedulePolicySettings() {
      return getStubSettingsBuilder().createSnapshotSchedulePolicySettings();
    }

    /** Returns the builder for the settings used for calls to updateSnapshotSchedulePolicy. */
    public UnaryCallSettings.Builder<UpdateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
        updateSnapshotSchedulePolicySettings() {
      return getStubSettingsBuilder().updateSnapshotSchedulePolicySettings();
    }

    /** Returns the builder for the settings used for calls to deleteSnapshotSchedulePolicy. */
    public UnaryCallSettings.Builder<DeleteSnapshotSchedulePolicyRequest, Empty>
        deleteSnapshotSchedulePolicySettings() {
      return getStubSettingsBuilder().deleteSnapshotSchedulePolicySettings();
    }

    /** Returns the builder for the settings used for calls to createVolumeSnapshot. */
    public UnaryCallSettings.Builder<CreateVolumeSnapshotRequest, VolumeSnapshot>
        createVolumeSnapshotSettings() {
      return getStubSettingsBuilder().createVolumeSnapshotSettings();
    }

    /** Returns the builder for the settings used for calls to restoreVolumeSnapshot. */
    public UnaryCallSettings.Builder<RestoreVolumeSnapshotRequest, Operation>
        restoreVolumeSnapshotSettings() {
      return getStubSettingsBuilder().restoreVolumeSnapshotSettings();
    }

    /** Returns the builder for the settings used for calls to restoreVolumeSnapshot. */
    public OperationCallSettings.Builder<
            RestoreVolumeSnapshotRequest, VolumeSnapshot, OperationMetadata>
        restoreVolumeSnapshotOperationSettings() {
      return getStubSettingsBuilder().restoreVolumeSnapshotOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteVolumeSnapshot. */
    public UnaryCallSettings.Builder<DeleteVolumeSnapshotRequest, Empty>
        deleteVolumeSnapshotSettings() {
      return getStubSettingsBuilder().deleteVolumeSnapshotSettings();
    }

    /** Returns the builder for the settings used for calls to getVolumeSnapshot. */
    public UnaryCallSettings.Builder<GetVolumeSnapshotRequest, VolumeSnapshot>
        getVolumeSnapshotSettings() {
      return getStubSettingsBuilder().getVolumeSnapshotSettings();
    }

    /** Returns the builder for the settings used for calls to listVolumeSnapshots. */
    public PagedCallSettings.Builder<
            ListVolumeSnapshotsRequest,
            ListVolumeSnapshotsResponse,
            ListVolumeSnapshotsPagedResponse>
        listVolumeSnapshotsSettings() {
      return getStubSettingsBuilder().listVolumeSnapshotsSettings();
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

    @Override
    public BareMetalSolutionSettings build() throws IOException {
      return new BareMetalSolutionSettings(this);
    }
  }
}
