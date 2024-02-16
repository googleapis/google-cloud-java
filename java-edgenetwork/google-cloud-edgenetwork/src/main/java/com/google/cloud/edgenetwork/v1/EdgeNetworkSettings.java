/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.edgenetwork.v1;

import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListInterconnectAttachmentsPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListInterconnectsPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListLocationsPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListNetworksPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListRoutersPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListSubnetsPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListZonesPagedResponse;

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
import com.google.cloud.edgenetwork.v1.stub.EdgeNetworkStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link EdgeNetworkClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (edgenetwork.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of initializeZone to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EdgeNetworkSettings.Builder edgeNetworkSettingsBuilder = EdgeNetworkSettings.newBuilder();
 * edgeNetworkSettingsBuilder
 *     .initializeZoneSettings()
 *     .setRetrySettings(
 *         edgeNetworkSettingsBuilder
 *             .initializeZoneSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * EdgeNetworkSettings edgeNetworkSettings = edgeNetworkSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class EdgeNetworkSettings extends ClientSettings<EdgeNetworkSettings> {

  /** Returns the object with the settings used for calls to initializeZone. */
  public UnaryCallSettings<InitializeZoneRequest, InitializeZoneResponse> initializeZoneSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).initializeZoneSettings();
  }

  /** Returns the object with the settings used for calls to listZones. */
  public PagedCallSettings<ListZonesRequest, ListZonesResponse, ListZonesPagedResponse>
      listZonesSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).listZonesSettings();
  }

  /** Returns the object with the settings used for calls to getZone. */
  public UnaryCallSettings<GetZoneRequest, Zone> getZoneSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).getZoneSettings();
  }

  /** Returns the object with the settings used for calls to listNetworks. */
  public PagedCallSettings<ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>
      listNetworksSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).listNetworksSettings();
  }

  /** Returns the object with the settings used for calls to getNetwork. */
  public UnaryCallSettings<GetNetworkRequest, Network> getNetworkSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).getNetworkSettings();
  }

  /** Returns the object with the settings used for calls to diagnoseNetwork. */
  public UnaryCallSettings<DiagnoseNetworkRequest, DiagnoseNetworkResponse>
      diagnoseNetworkSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).diagnoseNetworkSettings();
  }

  /** Returns the object with the settings used for calls to createNetwork. */
  public UnaryCallSettings<CreateNetworkRequest, Operation> createNetworkSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).createNetworkSettings();
  }

  /** Returns the object with the settings used for calls to createNetwork. */
  public OperationCallSettings<CreateNetworkRequest, Network, OperationMetadata>
      createNetworkOperationSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).createNetworkOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteNetwork. */
  public UnaryCallSettings<DeleteNetworkRequest, Operation> deleteNetworkSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).deleteNetworkSettings();
  }

  /** Returns the object with the settings used for calls to deleteNetwork. */
  public OperationCallSettings<DeleteNetworkRequest, Empty, OperationMetadata>
      deleteNetworkOperationSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).deleteNetworkOperationSettings();
  }

  /** Returns the object with the settings used for calls to listSubnets. */
  public PagedCallSettings<ListSubnetsRequest, ListSubnetsResponse, ListSubnetsPagedResponse>
      listSubnetsSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).listSubnetsSettings();
  }

  /** Returns the object with the settings used for calls to getSubnet. */
  public UnaryCallSettings<GetSubnetRequest, Subnet> getSubnetSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).getSubnetSettings();
  }

  /** Returns the object with the settings used for calls to createSubnet. */
  public UnaryCallSettings<CreateSubnetRequest, Operation> createSubnetSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).createSubnetSettings();
  }

  /** Returns the object with the settings used for calls to createSubnet. */
  public OperationCallSettings<CreateSubnetRequest, Subnet, OperationMetadata>
      createSubnetOperationSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).createSubnetOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateSubnet. */
  public UnaryCallSettings<UpdateSubnetRequest, Operation> updateSubnetSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).updateSubnetSettings();
  }

  /** Returns the object with the settings used for calls to updateSubnet. */
  public OperationCallSettings<UpdateSubnetRequest, Subnet, OperationMetadata>
      updateSubnetOperationSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).updateSubnetOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteSubnet. */
  public UnaryCallSettings<DeleteSubnetRequest, Operation> deleteSubnetSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).deleteSubnetSettings();
  }

  /** Returns the object with the settings used for calls to deleteSubnet. */
  public OperationCallSettings<DeleteSubnetRequest, Empty, OperationMetadata>
      deleteSubnetOperationSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).deleteSubnetOperationSettings();
  }

  /** Returns the object with the settings used for calls to listInterconnects. */
  public PagedCallSettings<
          ListInterconnectsRequest, ListInterconnectsResponse, ListInterconnectsPagedResponse>
      listInterconnectsSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).listInterconnectsSettings();
  }

  /** Returns the object with the settings used for calls to getInterconnect. */
  public UnaryCallSettings<GetInterconnectRequest, Interconnect> getInterconnectSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).getInterconnectSettings();
  }

  /** Returns the object with the settings used for calls to diagnoseInterconnect. */
  public UnaryCallSettings<DiagnoseInterconnectRequest, DiagnoseInterconnectResponse>
      diagnoseInterconnectSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).diagnoseInterconnectSettings();
  }

  /** Returns the object with the settings used for calls to listInterconnectAttachments. */
  public PagedCallSettings<
          ListInterconnectAttachmentsRequest,
          ListInterconnectAttachmentsResponse,
          ListInterconnectAttachmentsPagedResponse>
      listInterconnectAttachmentsSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).listInterconnectAttachmentsSettings();
  }

  /** Returns the object with the settings used for calls to getInterconnectAttachment. */
  public UnaryCallSettings<GetInterconnectAttachmentRequest, InterconnectAttachment>
      getInterconnectAttachmentSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).getInterconnectAttachmentSettings();
  }

  /** Returns the object with the settings used for calls to createInterconnectAttachment. */
  public UnaryCallSettings<CreateInterconnectAttachmentRequest, Operation>
      createInterconnectAttachmentSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).createInterconnectAttachmentSettings();
  }

  /** Returns the object with the settings used for calls to createInterconnectAttachment. */
  public OperationCallSettings<
          CreateInterconnectAttachmentRequest, InterconnectAttachment, OperationMetadata>
      createInterconnectAttachmentOperationSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings())
        .createInterconnectAttachmentOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteInterconnectAttachment. */
  public UnaryCallSettings<DeleteInterconnectAttachmentRequest, Operation>
      deleteInterconnectAttachmentSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).deleteInterconnectAttachmentSettings();
  }

  /** Returns the object with the settings used for calls to deleteInterconnectAttachment. */
  public OperationCallSettings<DeleteInterconnectAttachmentRequest, Empty, OperationMetadata>
      deleteInterconnectAttachmentOperationSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings())
        .deleteInterconnectAttachmentOperationSettings();
  }

  /** Returns the object with the settings used for calls to listRouters. */
  public PagedCallSettings<ListRoutersRequest, ListRoutersResponse, ListRoutersPagedResponse>
      listRoutersSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).listRoutersSettings();
  }

  /** Returns the object with the settings used for calls to getRouter. */
  public UnaryCallSettings<GetRouterRequest, Router> getRouterSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).getRouterSettings();
  }

  /** Returns the object with the settings used for calls to diagnoseRouter. */
  public UnaryCallSettings<DiagnoseRouterRequest, DiagnoseRouterResponse> diagnoseRouterSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).diagnoseRouterSettings();
  }

  /** Returns the object with the settings used for calls to createRouter. */
  public UnaryCallSettings<CreateRouterRequest, Operation> createRouterSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).createRouterSettings();
  }

  /** Returns the object with the settings used for calls to createRouter. */
  public OperationCallSettings<CreateRouterRequest, Router, OperationMetadata>
      createRouterOperationSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).createRouterOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateRouter. */
  public UnaryCallSettings<UpdateRouterRequest, Operation> updateRouterSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).updateRouterSettings();
  }

  /** Returns the object with the settings used for calls to updateRouter. */
  public OperationCallSettings<UpdateRouterRequest, Router, OperationMetadata>
      updateRouterOperationSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).updateRouterOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteRouter. */
  public UnaryCallSettings<DeleteRouterRequest, Operation> deleteRouterSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).deleteRouterSettings();
  }

  /** Returns the object with the settings used for calls to deleteRouter. */
  public OperationCallSettings<DeleteRouterRequest, Empty, OperationMetadata>
      deleteRouterOperationSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).deleteRouterOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((EdgeNetworkStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final EdgeNetworkSettings create(EdgeNetworkStubSettings stub) throws IOException {
    return new EdgeNetworkSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return EdgeNetworkStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return EdgeNetworkStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return EdgeNetworkStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return EdgeNetworkStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return EdgeNetworkStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return EdgeNetworkStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return EdgeNetworkStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return EdgeNetworkStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected EdgeNetworkSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for EdgeNetworkSettings. */
  public static class Builder extends ClientSettings.Builder<EdgeNetworkSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(EdgeNetworkStubSettings.newBuilder(clientContext));
    }

    protected Builder(EdgeNetworkSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(EdgeNetworkStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(EdgeNetworkStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(EdgeNetworkStubSettings.newHttpJsonBuilder());
    }

    public EdgeNetworkStubSettings.Builder getStubSettingsBuilder() {
      return ((EdgeNetworkStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to initializeZone. */
    public UnaryCallSettings.Builder<InitializeZoneRequest, InitializeZoneResponse>
        initializeZoneSettings() {
      return getStubSettingsBuilder().initializeZoneSettings();
    }

    /** Returns the builder for the settings used for calls to listZones. */
    public PagedCallSettings.Builder<ListZonesRequest, ListZonesResponse, ListZonesPagedResponse>
        listZonesSettings() {
      return getStubSettingsBuilder().listZonesSettings();
    }

    /** Returns the builder for the settings used for calls to getZone. */
    public UnaryCallSettings.Builder<GetZoneRequest, Zone> getZoneSettings() {
      return getStubSettingsBuilder().getZoneSettings();
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

    /** Returns the builder for the settings used for calls to diagnoseNetwork. */
    public UnaryCallSettings.Builder<DiagnoseNetworkRequest, DiagnoseNetworkResponse>
        diagnoseNetworkSettings() {
      return getStubSettingsBuilder().diagnoseNetworkSettings();
    }

    /** Returns the builder for the settings used for calls to createNetwork. */
    public UnaryCallSettings.Builder<CreateNetworkRequest, Operation> createNetworkSettings() {
      return getStubSettingsBuilder().createNetworkSettings();
    }

    /** Returns the builder for the settings used for calls to createNetwork. */
    public OperationCallSettings.Builder<CreateNetworkRequest, Network, OperationMetadata>
        createNetworkOperationSettings() {
      return getStubSettingsBuilder().createNetworkOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteNetwork. */
    public UnaryCallSettings.Builder<DeleteNetworkRequest, Operation> deleteNetworkSettings() {
      return getStubSettingsBuilder().deleteNetworkSettings();
    }

    /** Returns the builder for the settings used for calls to deleteNetwork. */
    public OperationCallSettings.Builder<DeleteNetworkRequest, Empty, OperationMetadata>
        deleteNetworkOperationSettings() {
      return getStubSettingsBuilder().deleteNetworkOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listSubnets. */
    public PagedCallSettings.Builder<
            ListSubnetsRequest, ListSubnetsResponse, ListSubnetsPagedResponse>
        listSubnetsSettings() {
      return getStubSettingsBuilder().listSubnetsSettings();
    }

    /** Returns the builder for the settings used for calls to getSubnet. */
    public UnaryCallSettings.Builder<GetSubnetRequest, Subnet> getSubnetSettings() {
      return getStubSettingsBuilder().getSubnetSettings();
    }

    /** Returns the builder for the settings used for calls to createSubnet. */
    public UnaryCallSettings.Builder<CreateSubnetRequest, Operation> createSubnetSettings() {
      return getStubSettingsBuilder().createSubnetSettings();
    }

    /** Returns the builder for the settings used for calls to createSubnet. */
    public OperationCallSettings.Builder<CreateSubnetRequest, Subnet, OperationMetadata>
        createSubnetOperationSettings() {
      return getStubSettingsBuilder().createSubnetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateSubnet. */
    public UnaryCallSettings.Builder<UpdateSubnetRequest, Operation> updateSubnetSettings() {
      return getStubSettingsBuilder().updateSubnetSettings();
    }

    /** Returns the builder for the settings used for calls to updateSubnet. */
    public OperationCallSettings.Builder<UpdateSubnetRequest, Subnet, OperationMetadata>
        updateSubnetOperationSettings() {
      return getStubSettingsBuilder().updateSubnetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSubnet. */
    public UnaryCallSettings.Builder<DeleteSubnetRequest, Operation> deleteSubnetSettings() {
      return getStubSettingsBuilder().deleteSubnetSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSubnet. */
    public OperationCallSettings.Builder<DeleteSubnetRequest, Empty, OperationMetadata>
        deleteSubnetOperationSettings() {
      return getStubSettingsBuilder().deleteSubnetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listInterconnects. */
    public PagedCallSettings.Builder<
            ListInterconnectsRequest, ListInterconnectsResponse, ListInterconnectsPagedResponse>
        listInterconnectsSettings() {
      return getStubSettingsBuilder().listInterconnectsSettings();
    }

    /** Returns the builder for the settings used for calls to getInterconnect. */
    public UnaryCallSettings.Builder<GetInterconnectRequest, Interconnect>
        getInterconnectSettings() {
      return getStubSettingsBuilder().getInterconnectSettings();
    }

    /** Returns the builder for the settings used for calls to diagnoseInterconnect. */
    public UnaryCallSettings.Builder<DiagnoseInterconnectRequest, DiagnoseInterconnectResponse>
        diagnoseInterconnectSettings() {
      return getStubSettingsBuilder().diagnoseInterconnectSettings();
    }

    /** Returns the builder for the settings used for calls to listInterconnectAttachments. */
    public PagedCallSettings.Builder<
            ListInterconnectAttachmentsRequest,
            ListInterconnectAttachmentsResponse,
            ListInterconnectAttachmentsPagedResponse>
        listInterconnectAttachmentsSettings() {
      return getStubSettingsBuilder().listInterconnectAttachmentsSettings();
    }

    /** Returns the builder for the settings used for calls to getInterconnectAttachment. */
    public UnaryCallSettings.Builder<GetInterconnectAttachmentRequest, InterconnectAttachment>
        getInterconnectAttachmentSettings() {
      return getStubSettingsBuilder().getInterconnectAttachmentSettings();
    }

    /** Returns the builder for the settings used for calls to createInterconnectAttachment. */
    public UnaryCallSettings.Builder<CreateInterconnectAttachmentRequest, Operation>
        createInterconnectAttachmentSettings() {
      return getStubSettingsBuilder().createInterconnectAttachmentSettings();
    }

    /** Returns the builder for the settings used for calls to createInterconnectAttachment. */
    public OperationCallSettings.Builder<
            CreateInterconnectAttachmentRequest, InterconnectAttachment, OperationMetadata>
        createInterconnectAttachmentOperationSettings() {
      return getStubSettingsBuilder().createInterconnectAttachmentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInterconnectAttachment. */
    public UnaryCallSettings.Builder<DeleteInterconnectAttachmentRequest, Operation>
        deleteInterconnectAttachmentSettings() {
      return getStubSettingsBuilder().deleteInterconnectAttachmentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInterconnectAttachment. */
    public OperationCallSettings.Builder<
            DeleteInterconnectAttachmentRequest, Empty, OperationMetadata>
        deleteInterconnectAttachmentOperationSettings() {
      return getStubSettingsBuilder().deleteInterconnectAttachmentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listRouters. */
    public PagedCallSettings.Builder<
            ListRoutersRequest, ListRoutersResponse, ListRoutersPagedResponse>
        listRoutersSettings() {
      return getStubSettingsBuilder().listRoutersSettings();
    }

    /** Returns the builder for the settings used for calls to getRouter. */
    public UnaryCallSettings.Builder<GetRouterRequest, Router> getRouterSettings() {
      return getStubSettingsBuilder().getRouterSettings();
    }

    /** Returns the builder for the settings used for calls to diagnoseRouter. */
    public UnaryCallSettings.Builder<DiagnoseRouterRequest, DiagnoseRouterResponse>
        diagnoseRouterSettings() {
      return getStubSettingsBuilder().diagnoseRouterSettings();
    }

    /** Returns the builder for the settings used for calls to createRouter. */
    public UnaryCallSettings.Builder<CreateRouterRequest, Operation> createRouterSettings() {
      return getStubSettingsBuilder().createRouterSettings();
    }

    /** Returns the builder for the settings used for calls to createRouter. */
    public OperationCallSettings.Builder<CreateRouterRequest, Router, OperationMetadata>
        createRouterOperationSettings() {
      return getStubSettingsBuilder().createRouterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateRouter. */
    public UnaryCallSettings.Builder<UpdateRouterRequest, Operation> updateRouterSettings() {
      return getStubSettingsBuilder().updateRouterSettings();
    }

    /** Returns the builder for the settings used for calls to updateRouter. */
    public OperationCallSettings.Builder<UpdateRouterRequest, Router, OperationMetadata>
        updateRouterOperationSettings() {
      return getStubSettingsBuilder().updateRouterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRouter. */
    public UnaryCallSettings.Builder<DeleteRouterRequest, Operation> deleteRouterSettings() {
      return getStubSettingsBuilder().deleteRouterSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRouter. */
    public OperationCallSettings.Builder<DeleteRouterRequest, Empty, OperationMetadata>
        deleteRouterOperationSettings() {
      return getStubSettingsBuilder().deleteRouterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    @Override
    public EdgeNetworkSettings build() throws IOException {
      return new EdgeNetworkSettings(this);
    }
  }
}
