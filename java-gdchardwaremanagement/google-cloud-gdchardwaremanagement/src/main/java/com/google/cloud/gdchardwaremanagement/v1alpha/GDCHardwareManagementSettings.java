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

package com.google.cloud.gdchardwaremanagement.v1alpha;

import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListChangeLogEntriesPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListCommentsPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListHardwareGroupsPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListHardwarePagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListLocationsPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListOrdersPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListSitesPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListSkusPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListZonesPagedResponse;

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
import com.google.cloud.gdchardwaremanagement.v1alpha.stub.GDCHardwareManagementStubSettings;
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
 * Settings class to configure an instance of {@link GDCHardwareManagementClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (gdchardwaremanagement.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getOrder:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GDCHardwareManagementSettings.Builder gDCHardwareManagementSettingsBuilder =
 *     GDCHardwareManagementSettings.newBuilder();
 * gDCHardwareManagementSettingsBuilder
 *     .getOrderSettings()
 *     .setRetrySettings(
 *         gDCHardwareManagementSettingsBuilder
 *             .getOrderSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * GDCHardwareManagementSettings gDCHardwareManagementSettings =
 *     gDCHardwareManagementSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createOrder:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GDCHardwareManagementSettings.Builder gDCHardwareManagementSettingsBuilder =
 *     GDCHardwareManagementSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelay(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * gDCHardwareManagementSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GDCHardwareManagementSettings extends ClientSettings<GDCHardwareManagementSettings> {

  /** Returns the object with the settings used for calls to listOrders. */
  public PagedCallSettings<ListOrdersRequest, ListOrdersResponse, ListOrdersPagedResponse>
      listOrdersSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).listOrdersSettings();
  }

  /** Returns the object with the settings used for calls to getOrder. */
  public UnaryCallSettings<GetOrderRequest, Order> getOrderSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).getOrderSettings();
  }

  /** Returns the object with the settings used for calls to createOrder. */
  public UnaryCallSettings<CreateOrderRequest, Operation> createOrderSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).createOrderSettings();
  }

  /** Returns the object with the settings used for calls to createOrder. */
  public OperationCallSettings<CreateOrderRequest, Order, OperationMetadata>
      createOrderOperationSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).createOrderOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateOrder. */
  public UnaryCallSettings<UpdateOrderRequest, Operation> updateOrderSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).updateOrderSettings();
  }

  /** Returns the object with the settings used for calls to updateOrder. */
  public OperationCallSettings<UpdateOrderRequest, Order, OperationMetadata>
      updateOrderOperationSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).updateOrderOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteOrder. */
  public UnaryCallSettings<DeleteOrderRequest, Operation> deleteOrderSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).deleteOrderSettings();
  }

  /** Returns the object with the settings used for calls to deleteOrder. */
  public OperationCallSettings<DeleteOrderRequest, Empty, OperationMetadata>
      deleteOrderOperationSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).deleteOrderOperationSettings();
  }

  /** Returns the object with the settings used for calls to submitOrder. */
  public UnaryCallSettings<SubmitOrderRequest, Operation> submitOrderSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).submitOrderSettings();
  }

  /** Returns the object with the settings used for calls to submitOrder. */
  public OperationCallSettings<SubmitOrderRequest, Order, OperationMetadata>
      submitOrderOperationSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).submitOrderOperationSettings();
  }

  /** Returns the object with the settings used for calls to listSites. */
  public PagedCallSettings<ListSitesRequest, ListSitesResponse, ListSitesPagedResponse>
      listSitesSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).listSitesSettings();
  }

  /** Returns the object with the settings used for calls to getSite. */
  public UnaryCallSettings<GetSiteRequest, Site> getSiteSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).getSiteSettings();
  }

  /** Returns the object with the settings used for calls to createSite. */
  public UnaryCallSettings<CreateSiteRequest, Operation> createSiteSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).createSiteSettings();
  }

  /** Returns the object with the settings used for calls to createSite. */
  public OperationCallSettings<CreateSiteRequest, Site, OperationMetadata>
      createSiteOperationSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).createSiteOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateSite. */
  public UnaryCallSettings<UpdateSiteRequest, Operation> updateSiteSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).updateSiteSettings();
  }

  /** Returns the object with the settings used for calls to updateSite. */
  public OperationCallSettings<UpdateSiteRequest, Site, OperationMetadata>
      updateSiteOperationSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).updateSiteOperationSettings();
  }

  /** Returns the object with the settings used for calls to listHardwareGroups. */
  public PagedCallSettings<
          ListHardwareGroupsRequest, ListHardwareGroupsResponse, ListHardwareGroupsPagedResponse>
      listHardwareGroupsSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).listHardwareGroupsSettings();
  }

  /** Returns the object with the settings used for calls to getHardwareGroup. */
  public UnaryCallSettings<GetHardwareGroupRequest, HardwareGroup> getHardwareGroupSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).getHardwareGroupSettings();
  }

  /** Returns the object with the settings used for calls to createHardwareGroup. */
  public UnaryCallSettings<CreateHardwareGroupRequest, Operation> createHardwareGroupSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).createHardwareGroupSettings();
  }

  /** Returns the object with the settings used for calls to createHardwareGroup. */
  public OperationCallSettings<CreateHardwareGroupRequest, HardwareGroup, OperationMetadata>
      createHardwareGroupOperationSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings())
        .createHardwareGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateHardwareGroup. */
  public UnaryCallSettings<UpdateHardwareGroupRequest, Operation> updateHardwareGroupSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).updateHardwareGroupSettings();
  }

  /** Returns the object with the settings used for calls to updateHardwareGroup. */
  public OperationCallSettings<UpdateHardwareGroupRequest, HardwareGroup, OperationMetadata>
      updateHardwareGroupOperationSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings())
        .updateHardwareGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteHardwareGroup. */
  public UnaryCallSettings<DeleteHardwareGroupRequest, Operation> deleteHardwareGroupSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).deleteHardwareGroupSettings();
  }

  /** Returns the object with the settings used for calls to deleteHardwareGroup. */
  public OperationCallSettings<DeleteHardwareGroupRequest, Empty, OperationMetadata>
      deleteHardwareGroupOperationSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings())
        .deleteHardwareGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to listHardware. */
  public PagedCallSettings<ListHardwareRequest, ListHardwareResponse, ListHardwarePagedResponse>
      listHardwareSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).listHardwareSettings();
  }

  /** Returns the object with the settings used for calls to getHardware. */
  public UnaryCallSettings<GetHardwareRequest, Hardware> getHardwareSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).getHardwareSettings();
  }

  /** Returns the object with the settings used for calls to createHardware. */
  public UnaryCallSettings<CreateHardwareRequest, Operation> createHardwareSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).createHardwareSettings();
  }

  /** Returns the object with the settings used for calls to createHardware. */
  public OperationCallSettings<CreateHardwareRequest, Hardware, OperationMetadata>
      createHardwareOperationSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings())
        .createHardwareOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateHardware. */
  public UnaryCallSettings<UpdateHardwareRequest, Operation> updateHardwareSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).updateHardwareSettings();
  }

  /** Returns the object with the settings used for calls to updateHardware. */
  public OperationCallSettings<UpdateHardwareRequest, Hardware, OperationMetadata>
      updateHardwareOperationSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings())
        .updateHardwareOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteHardware. */
  public UnaryCallSettings<DeleteHardwareRequest, Operation> deleteHardwareSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).deleteHardwareSettings();
  }

  /** Returns the object with the settings used for calls to deleteHardware. */
  public OperationCallSettings<DeleteHardwareRequest, Empty, OperationMetadata>
      deleteHardwareOperationSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings())
        .deleteHardwareOperationSettings();
  }

  /** Returns the object with the settings used for calls to listComments. */
  public PagedCallSettings<ListCommentsRequest, ListCommentsResponse, ListCommentsPagedResponse>
      listCommentsSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).listCommentsSettings();
  }

  /** Returns the object with the settings used for calls to getComment. */
  public UnaryCallSettings<GetCommentRequest, Comment> getCommentSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).getCommentSettings();
  }

  /** Returns the object with the settings used for calls to createComment. */
  public UnaryCallSettings<CreateCommentRequest, Operation> createCommentSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).createCommentSettings();
  }

  /** Returns the object with the settings used for calls to createComment. */
  public OperationCallSettings<CreateCommentRequest, Comment, OperationMetadata>
      createCommentOperationSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).createCommentOperationSettings();
  }

  /** Returns the object with the settings used for calls to recordActionOnComment. */
  public UnaryCallSettings<RecordActionOnCommentRequest, Comment> recordActionOnCommentSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).recordActionOnCommentSettings();
  }

  /** Returns the object with the settings used for calls to listChangeLogEntries. */
  public PagedCallSettings<
          ListChangeLogEntriesRequest,
          ListChangeLogEntriesResponse,
          ListChangeLogEntriesPagedResponse>
      listChangeLogEntriesSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).listChangeLogEntriesSettings();
  }

  /** Returns the object with the settings used for calls to getChangeLogEntry. */
  public UnaryCallSettings<GetChangeLogEntryRequest, ChangeLogEntry> getChangeLogEntrySettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).getChangeLogEntrySettings();
  }

  /** Returns the object with the settings used for calls to listSkus. */
  public PagedCallSettings<ListSkusRequest, ListSkusResponse, ListSkusPagedResponse>
      listSkusSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).listSkusSettings();
  }

  /** Returns the object with the settings used for calls to getSku. */
  public UnaryCallSettings<GetSkuRequest, Sku> getSkuSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).getSkuSettings();
  }

  /** Returns the object with the settings used for calls to listZones. */
  public PagedCallSettings<ListZonesRequest, ListZonesResponse, ListZonesPagedResponse>
      listZonesSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).listZonesSettings();
  }

  /** Returns the object with the settings used for calls to getZone. */
  public UnaryCallSettings<GetZoneRequest, Zone> getZoneSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).getZoneSettings();
  }

  /** Returns the object with the settings used for calls to createZone. */
  public UnaryCallSettings<CreateZoneRequest, Operation> createZoneSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).createZoneSettings();
  }

  /** Returns the object with the settings used for calls to createZone. */
  public OperationCallSettings<CreateZoneRequest, Zone, OperationMetadata>
      createZoneOperationSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).createZoneOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateZone. */
  public UnaryCallSettings<UpdateZoneRequest, Operation> updateZoneSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).updateZoneSettings();
  }

  /** Returns the object with the settings used for calls to updateZone. */
  public OperationCallSettings<UpdateZoneRequest, Zone, OperationMetadata>
      updateZoneOperationSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).updateZoneOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteZone. */
  public UnaryCallSettings<DeleteZoneRequest, Operation> deleteZoneSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).deleteZoneSettings();
  }

  /** Returns the object with the settings used for calls to deleteZone. */
  public OperationCallSettings<DeleteZoneRequest, Empty, OperationMetadata>
      deleteZoneOperationSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).deleteZoneOperationSettings();
  }

  /** Returns the object with the settings used for calls to signalZoneState. */
  public UnaryCallSettings<SignalZoneStateRequest, Operation> signalZoneStateSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).signalZoneStateSettings();
  }

  /** Returns the object with the settings used for calls to signalZoneState. */
  public OperationCallSettings<SignalZoneStateRequest, Zone, OperationMetadata>
      signalZoneStateOperationSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings())
        .signalZoneStateOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((GDCHardwareManagementStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final GDCHardwareManagementSettings create(GDCHardwareManagementStubSettings stub)
      throws IOException {
    return new GDCHardwareManagementSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return GDCHardwareManagementStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return GDCHardwareManagementStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return GDCHardwareManagementStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GDCHardwareManagementStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return GDCHardwareManagementStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return GDCHardwareManagementStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return GDCHardwareManagementStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return GDCHardwareManagementStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
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

  protected GDCHardwareManagementSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for GDCHardwareManagementSettings. */
  public static class Builder
      extends ClientSettings.Builder<GDCHardwareManagementSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(GDCHardwareManagementStubSettings.newBuilder(clientContext));
    }

    protected Builder(GDCHardwareManagementSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(GDCHardwareManagementStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(GDCHardwareManagementStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(GDCHardwareManagementStubSettings.newHttpJsonBuilder());
    }

    public GDCHardwareManagementStubSettings.Builder getStubSettingsBuilder() {
      return ((GDCHardwareManagementStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listOrders. */
    public PagedCallSettings.Builder<ListOrdersRequest, ListOrdersResponse, ListOrdersPagedResponse>
        listOrdersSettings() {
      return getStubSettingsBuilder().listOrdersSettings();
    }

    /** Returns the builder for the settings used for calls to getOrder. */
    public UnaryCallSettings.Builder<GetOrderRequest, Order> getOrderSettings() {
      return getStubSettingsBuilder().getOrderSettings();
    }

    /** Returns the builder for the settings used for calls to createOrder. */
    public UnaryCallSettings.Builder<CreateOrderRequest, Operation> createOrderSettings() {
      return getStubSettingsBuilder().createOrderSettings();
    }

    /** Returns the builder for the settings used for calls to createOrder. */
    public OperationCallSettings.Builder<CreateOrderRequest, Order, OperationMetadata>
        createOrderOperationSettings() {
      return getStubSettingsBuilder().createOrderOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateOrder. */
    public UnaryCallSettings.Builder<UpdateOrderRequest, Operation> updateOrderSettings() {
      return getStubSettingsBuilder().updateOrderSettings();
    }

    /** Returns the builder for the settings used for calls to updateOrder. */
    public OperationCallSettings.Builder<UpdateOrderRequest, Order, OperationMetadata>
        updateOrderOperationSettings() {
      return getStubSettingsBuilder().updateOrderOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteOrder. */
    public UnaryCallSettings.Builder<DeleteOrderRequest, Operation> deleteOrderSettings() {
      return getStubSettingsBuilder().deleteOrderSettings();
    }

    /** Returns the builder for the settings used for calls to deleteOrder. */
    public OperationCallSettings.Builder<DeleteOrderRequest, Empty, OperationMetadata>
        deleteOrderOperationSettings() {
      return getStubSettingsBuilder().deleteOrderOperationSettings();
    }

    /** Returns the builder for the settings used for calls to submitOrder. */
    public UnaryCallSettings.Builder<SubmitOrderRequest, Operation> submitOrderSettings() {
      return getStubSettingsBuilder().submitOrderSettings();
    }

    /** Returns the builder for the settings used for calls to submitOrder. */
    public OperationCallSettings.Builder<SubmitOrderRequest, Order, OperationMetadata>
        submitOrderOperationSettings() {
      return getStubSettingsBuilder().submitOrderOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listSites. */
    public PagedCallSettings.Builder<ListSitesRequest, ListSitesResponse, ListSitesPagedResponse>
        listSitesSettings() {
      return getStubSettingsBuilder().listSitesSettings();
    }

    /** Returns the builder for the settings used for calls to getSite. */
    public UnaryCallSettings.Builder<GetSiteRequest, Site> getSiteSettings() {
      return getStubSettingsBuilder().getSiteSettings();
    }

    /** Returns the builder for the settings used for calls to createSite. */
    public UnaryCallSettings.Builder<CreateSiteRequest, Operation> createSiteSettings() {
      return getStubSettingsBuilder().createSiteSettings();
    }

    /** Returns the builder for the settings used for calls to createSite. */
    public OperationCallSettings.Builder<CreateSiteRequest, Site, OperationMetadata>
        createSiteOperationSettings() {
      return getStubSettingsBuilder().createSiteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateSite. */
    public UnaryCallSettings.Builder<UpdateSiteRequest, Operation> updateSiteSettings() {
      return getStubSettingsBuilder().updateSiteSettings();
    }

    /** Returns the builder for the settings used for calls to updateSite. */
    public OperationCallSettings.Builder<UpdateSiteRequest, Site, OperationMetadata>
        updateSiteOperationSettings() {
      return getStubSettingsBuilder().updateSiteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listHardwareGroups. */
    public PagedCallSettings.Builder<
            ListHardwareGroupsRequest, ListHardwareGroupsResponse, ListHardwareGroupsPagedResponse>
        listHardwareGroupsSettings() {
      return getStubSettingsBuilder().listHardwareGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to getHardwareGroup. */
    public UnaryCallSettings.Builder<GetHardwareGroupRequest, HardwareGroup>
        getHardwareGroupSettings() {
      return getStubSettingsBuilder().getHardwareGroupSettings();
    }

    /** Returns the builder for the settings used for calls to createHardwareGroup. */
    public UnaryCallSettings.Builder<CreateHardwareGroupRequest, Operation>
        createHardwareGroupSettings() {
      return getStubSettingsBuilder().createHardwareGroupSettings();
    }

    /** Returns the builder for the settings used for calls to createHardwareGroup. */
    public OperationCallSettings.Builder<
            CreateHardwareGroupRequest, HardwareGroup, OperationMetadata>
        createHardwareGroupOperationSettings() {
      return getStubSettingsBuilder().createHardwareGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateHardwareGroup. */
    public UnaryCallSettings.Builder<UpdateHardwareGroupRequest, Operation>
        updateHardwareGroupSettings() {
      return getStubSettingsBuilder().updateHardwareGroupSettings();
    }

    /** Returns the builder for the settings used for calls to updateHardwareGroup. */
    public OperationCallSettings.Builder<
            UpdateHardwareGroupRequest, HardwareGroup, OperationMetadata>
        updateHardwareGroupOperationSettings() {
      return getStubSettingsBuilder().updateHardwareGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteHardwareGroup. */
    public UnaryCallSettings.Builder<DeleteHardwareGroupRequest, Operation>
        deleteHardwareGroupSettings() {
      return getStubSettingsBuilder().deleteHardwareGroupSettings();
    }

    /** Returns the builder for the settings used for calls to deleteHardwareGroup. */
    public OperationCallSettings.Builder<DeleteHardwareGroupRequest, Empty, OperationMetadata>
        deleteHardwareGroupOperationSettings() {
      return getStubSettingsBuilder().deleteHardwareGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listHardware. */
    public PagedCallSettings.Builder<
            ListHardwareRequest, ListHardwareResponse, ListHardwarePagedResponse>
        listHardwareSettings() {
      return getStubSettingsBuilder().listHardwareSettings();
    }

    /** Returns the builder for the settings used for calls to getHardware. */
    public UnaryCallSettings.Builder<GetHardwareRequest, Hardware> getHardwareSettings() {
      return getStubSettingsBuilder().getHardwareSettings();
    }

    /** Returns the builder for the settings used for calls to createHardware. */
    public UnaryCallSettings.Builder<CreateHardwareRequest, Operation> createHardwareSettings() {
      return getStubSettingsBuilder().createHardwareSettings();
    }

    /** Returns the builder for the settings used for calls to createHardware. */
    public OperationCallSettings.Builder<CreateHardwareRequest, Hardware, OperationMetadata>
        createHardwareOperationSettings() {
      return getStubSettingsBuilder().createHardwareOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateHardware. */
    public UnaryCallSettings.Builder<UpdateHardwareRequest, Operation> updateHardwareSettings() {
      return getStubSettingsBuilder().updateHardwareSettings();
    }

    /** Returns the builder for the settings used for calls to updateHardware. */
    public OperationCallSettings.Builder<UpdateHardwareRequest, Hardware, OperationMetadata>
        updateHardwareOperationSettings() {
      return getStubSettingsBuilder().updateHardwareOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteHardware. */
    public UnaryCallSettings.Builder<DeleteHardwareRequest, Operation> deleteHardwareSettings() {
      return getStubSettingsBuilder().deleteHardwareSettings();
    }

    /** Returns the builder for the settings used for calls to deleteHardware. */
    public OperationCallSettings.Builder<DeleteHardwareRequest, Empty, OperationMetadata>
        deleteHardwareOperationSettings() {
      return getStubSettingsBuilder().deleteHardwareOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listComments. */
    public PagedCallSettings.Builder<
            ListCommentsRequest, ListCommentsResponse, ListCommentsPagedResponse>
        listCommentsSettings() {
      return getStubSettingsBuilder().listCommentsSettings();
    }

    /** Returns the builder for the settings used for calls to getComment. */
    public UnaryCallSettings.Builder<GetCommentRequest, Comment> getCommentSettings() {
      return getStubSettingsBuilder().getCommentSettings();
    }

    /** Returns the builder for the settings used for calls to createComment. */
    public UnaryCallSettings.Builder<CreateCommentRequest, Operation> createCommentSettings() {
      return getStubSettingsBuilder().createCommentSettings();
    }

    /** Returns the builder for the settings used for calls to createComment. */
    public OperationCallSettings.Builder<CreateCommentRequest, Comment, OperationMetadata>
        createCommentOperationSettings() {
      return getStubSettingsBuilder().createCommentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to recordActionOnComment. */
    public UnaryCallSettings.Builder<RecordActionOnCommentRequest, Comment>
        recordActionOnCommentSettings() {
      return getStubSettingsBuilder().recordActionOnCommentSettings();
    }

    /** Returns the builder for the settings used for calls to listChangeLogEntries. */
    public PagedCallSettings.Builder<
            ListChangeLogEntriesRequest,
            ListChangeLogEntriesResponse,
            ListChangeLogEntriesPagedResponse>
        listChangeLogEntriesSettings() {
      return getStubSettingsBuilder().listChangeLogEntriesSettings();
    }

    /** Returns the builder for the settings used for calls to getChangeLogEntry. */
    public UnaryCallSettings.Builder<GetChangeLogEntryRequest, ChangeLogEntry>
        getChangeLogEntrySettings() {
      return getStubSettingsBuilder().getChangeLogEntrySettings();
    }

    /** Returns the builder for the settings used for calls to listSkus. */
    public PagedCallSettings.Builder<ListSkusRequest, ListSkusResponse, ListSkusPagedResponse>
        listSkusSettings() {
      return getStubSettingsBuilder().listSkusSettings();
    }

    /** Returns the builder for the settings used for calls to getSku. */
    public UnaryCallSettings.Builder<GetSkuRequest, Sku> getSkuSettings() {
      return getStubSettingsBuilder().getSkuSettings();
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

    /** Returns the builder for the settings used for calls to createZone. */
    public UnaryCallSettings.Builder<CreateZoneRequest, Operation> createZoneSettings() {
      return getStubSettingsBuilder().createZoneSettings();
    }

    /** Returns the builder for the settings used for calls to createZone. */
    public OperationCallSettings.Builder<CreateZoneRequest, Zone, OperationMetadata>
        createZoneOperationSettings() {
      return getStubSettingsBuilder().createZoneOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateZone. */
    public UnaryCallSettings.Builder<UpdateZoneRequest, Operation> updateZoneSettings() {
      return getStubSettingsBuilder().updateZoneSettings();
    }

    /** Returns the builder for the settings used for calls to updateZone. */
    public OperationCallSettings.Builder<UpdateZoneRequest, Zone, OperationMetadata>
        updateZoneOperationSettings() {
      return getStubSettingsBuilder().updateZoneOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteZone. */
    public UnaryCallSettings.Builder<DeleteZoneRequest, Operation> deleteZoneSettings() {
      return getStubSettingsBuilder().deleteZoneSettings();
    }

    /** Returns the builder for the settings used for calls to deleteZone. */
    public OperationCallSettings.Builder<DeleteZoneRequest, Empty, OperationMetadata>
        deleteZoneOperationSettings() {
      return getStubSettingsBuilder().deleteZoneOperationSettings();
    }

    /** Returns the builder for the settings used for calls to signalZoneState. */
    public UnaryCallSettings.Builder<SignalZoneStateRequest, Operation> signalZoneStateSettings() {
      return getStubSettingsBuilder().signalZoneStateSettings();
    }

    /** Returns the builder for the settings used for calls to signalZoneState. */
    public OperationCallSettings.Builder<SignalZoneStateRequest, Zone, OperationMetadata>
        signalZoneStateOperationSettings() {
      return getStubSettingsBuilder().signalZoneStateOperationSettings();
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
    public GDCHardwareManagementSettings build() throws IOException {
      return new GDCHardwareManagementSettings(this);
    }
  }
}
