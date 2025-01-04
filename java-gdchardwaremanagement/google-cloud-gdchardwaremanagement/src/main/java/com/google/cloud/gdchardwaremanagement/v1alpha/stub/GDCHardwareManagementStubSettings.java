/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.gdchardwaremanagement.v1alpha.stub;

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
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gdchardwaremanagement.v1alpha.ChangeLogEntry;
import com.google.cloud.gdchardwaremanagement.v1alpha.Comment;
import com.google.cloud.gdchardwaremanagement.v1alpha.CreateCommentRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareGroupRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.CreateOrderRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.CreateSiteRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.CreateZoneRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareGroupRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.DeleteOrderRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.DeleteSiteRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.DeleteZoneRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.GetChangeLogEntryRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.GetCommentRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareGroupRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.GetOrderRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.GetSiteRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.GetSkuRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.GetZoneRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.Hardware;
import com.google.cloud.gdchardwaremanagement.v1alpha.HardwareGroup;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesResponse;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsResponse;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsResponse;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareResponse;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersResponse;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesResponse;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusResponse;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesResponse;
import com.google.cloud.gdchardwaremanagement.v1alpha.OperationMetadata;
import com.google.cloud.gdchardwaremanagement.v1alpha.Order;
import com.google.cloud.gdchardwaremanagement.v1alpha.RecordActionOnCommentRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.SignalZoneStateRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.Site;
import com.google.cloud.gdchardwaremanagement.v1alpha.Sku;
import com.google.cloud.gdchardwaremanagement.v1alpha.SubmitOrderRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareGroupRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.UpdateOrderRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.UpdateSiteRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.UpdateZoneRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.Zone;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link GDCHardwareManagementStub}.
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
 * GDCHardwareManagementStubSettings.Builder gDCHardwareManagementSettingsBuilder =
 *     GDCHardwareManagementStubSettings.newBuilder();
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
 * GDCHardwareManagementStubSettings gDCHardwareManagementSettings =
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
 * GDCHardwareManagementStubSettings.Builder gDCHardwareManagementSettingsBuilder =
 *     GDCHardwareManagementStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
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
public class GDCHardwareManagementStubSettings
    extends StubSettings<GDCHardwareManagementStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<ListOrdersRequest, ListOrdersResponse, ListOrdersPagedResponse>
      listOrdersSettings;
  private final UnaryCallSettings<GetOrderRequest, Order> getOrderSettings;
  private final UnaryCallSettings<CreateOrderRequest, Operation> createOrderSettings;
  private final OperationCallSettings<CreateOrderRequest, Order, OperationMetadata>
      createOrderOperationSettings;
  private final UnaryCallSettings<UpdateOrderRequest, Operation> updateOrderSettings;
  private final OperationCallSettings<UpdateOrderRequest, Order, OperationMetadata>
      updateOrderOperationSettings;
  private final UnaryCallSettings<DeleteOrderRequest, Operation> deleteOrderSettings;
  private final OperationCallSettings<DeleteOrderRequest, Empty, OperationMetadata>
      deleteOrderOperationSettings;
  private final UnaryCallSettings<SubmitOrderRequest, Operation> submitOrderSettings;
  private final OperationCallSettings<SubmitOrderRequest, Order, OperationMetadata>
      submitOrderOperationSettings;
  private final PagedCallSettings<ListSitesRequest, ListSitesResponse, ListSitesPagedResponse>
      listSitesSettings;
  private final UnaryCallSettings<GetSiteRequest, Site> getSiteSettings;
  private final UnaryCallSettings<CreateSiteRequest, Operation> createSiteSettings;
  private final OperationCallSettings<CreateSiteRequest, Site, OperationMetadata>
      createSiteOperationSettings;
  private final UnaryCallSettings<UpdateSiteRequest, Operation> updateSiteSettings;
  private final OperationCallSettings<UpdateSiteRequest, Site, OperationMetadata>
      updateSiteOperationSettings;
  private final UnaryCallSettings<DeleteSiteRequest, Operation> deleteSiteSettings;
  private final OperationCallSettings<DeleteSiteRequest, Empty, OperationMetadata>
      deleteSiteOperationSettings;
  private final PagedCallSettings<
          ListHardwareGroupsRequest, ListHardwareGroupsResponse, ListHardwareGroupsPagedResponse>
      listHardwareGroupsSettings;
  private final UnaryCallSettings<GetHardwareGroupRequest, HardwareGroup> getHardwareGroupSettings;
  private final UnaryCallSettings<CreateHardwareGroupRequest, Operation>
      createHardwareGroupSettings;
  private final OperationCallSettings<CreateHardwareGroupRequest, HardwareGroup, OperationMetadata>
      createHardwareGroupOperationSettings;
  private final UnaryCallSettings<UpdateHardwareGroupRequest, Operation>
      updateHardwareGroupSettings;
  private final OperationCallSettings<UpdateHardwareGroupRequest, HardwareGroup, OperationMetadata>
      updateHardwareGroupOperationSettings;
  private final UnaryCallSettings<DeleteHardwareGroupRequest, Operation>
      deleteHardwareGroupSettings;
  private final OperationCallSettings<DeleteHardwareGroupRequest, Empty, OperationMetadata>
      deleteHardwareGroupOperationSettings;
  private final PagedCallSettings<
          ListHardwareRequest, ListHardwareResponse, ListHardwarePagedResponse>
      listHardwareSettings;
  private final UnaryCallSettings<GetHardwareRequest, Hardware> getHardwareSettings;
  private final UnaryCallSettings<CreateHardwareRequest, Operation> createHardwareSettings;
  private final OperationCallSettings<CreateHardwareRequest, Hardware, OperationMetadata>
      createHardwareOperationSettings;
  private final UnaryCallSettings<UpdateHardwareRequest, Operation> updateHardwareSettings;
  private final OperationCallSettings<UpdateHardwareRequest, Hardware, OperationMetadata>
      updateHardwareOperationSettings;
  private final UnaryCallSettings<DeleteHardwareRequest, Operation> deleteHardwareSettings;
  private final OperationCallSettings<DeleteHardwareRequest, Empty, OperationMetadata>
      deleteHardwareOperationSettings;
  private final PagedCallSettings<
          ListCommentsRequest, ListCommentsResponse, ListCommentsPagedResponse>
      listCommentsSettings;
  private final UnaryCallSettings<GetCommentRequest, Comment> getCommentSettings;
  private final UnaryCallSettings<CreateCommentRequest, Operation> createCommentSettings;
  private final OperationCallSettings<CreateCommentRequest, Comment, OperationMetadata>
      createCommentOperationSettings;
  private final UnaryCallSettings<RecordActionOnCommentRequest, Comment>
      recordActionOnCommentSettings;
  private final PagedCallSettings<
          ListChangeLogEntriesRequest,
          ListChangeLogEntriesResponse,
          ListChangeLogEntriesPagedResponse>
      listChangeLogEntriesSettings;
  private final UnaryCallSettings<GetChangeLogEntryRequest, ChangeLogEntry>
      getChangeLogEntrySettings;
  private final PagedCallSettings<ListSkusRequest, ListSkusResponse, ListSkusPagedResponse>
      listSkusSettings;
  private final UnaryCallSettings<GetSkuRequest, Sku> getSkuSettings;
  private final PagedCallSettings<ListZonesRequest, ListZonesResponse, ListZonesPagedResponse>
      listZonesSettings;
  private final UnaryCallSettings<GetZoneRequest, Zone> getZoneSettings;
  private final UnaryCallSettings<CreateZoneRequest, Operation> createZoneSettings;
  private final OperationCallSettings<CreateZoneRequest, Zone, OperationMetadata>
      createZoneOperationSettings;
  private final UnaryCallSettings<UpdateZoneRequest, Operation> updateZoneSettings;
  private final OperationCallSettings<UpdateZoneRequest, Zone, OperationMetadata>
      updateZoneOperationSettings;
  private final UnaryCallSettings<DeleteZoneRequest, Operation> deleteZoneSettings;
  private final OperationCallSettings<DeleteZoneRequest, Empty, OperationMetadata>
      deleteZoneOperationSettings;
  private final UnaryCallSettings<SignalZoneStateRequest, Operation> signalZoneStateSettings;
  private final OperationCallSettings<SignalZoneStateRequest, Zone, OperationMetadata>
      signalZoneStateOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListOrdersRequest, ListOrdersResponse, Order>
      LIST_ORDERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListOrdersRequest, ListOrdersResponse, Order>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListOrdersRequest injectToken(ListOrdersRequest payload, String token) {
              return ListOrdersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListOrdersRequest injectPageSize(ListOrdersRequest payload, int pageSize) {
              return ListOrdersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListOrdersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListOrdersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Order> extractResources(ListOrdersResponse payload) {
              return payload.getOrdersList();
            }
          };

  private static final PagedListDescriptor<ListSitesRequest, ListSitesResponse, Site>
      LIST_SITES_PAGE_STR_DESC =
          new PagedListDescriptor<ListSitesRequest, ListSitesResponse, Site>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSitesRequest injectToken(ListSitesRequest payload, String token) {
              return ListSitesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSitesRequest injectPageSize(ListSitesRequest payload, int pageSize) {
              return ListSitesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSitesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSitesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Site> extractResources(ListSitesResponse payload) {
              return payload.getSitesList();
            }
          };

  private static final PagedListDescriptor<
          ListHardwareGroupsRequest, ListHardwareGroupsResponse, HardwareGroup>
      LIST_HARDWARE_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListHardwareGroupsRequest, ListHardwareGroupsResponse, HardwareGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListHardwareGroupsRequest injectToken(
                ListHardwareGroupsRequest payload, String token) {
              return ListHardwareGroupsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListHardwareGroupsRequest injectPageSize(
                ListHardwareGroupsRequest payload, int pageSize) {
              return ListHardwareGroupsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListHardwareGroupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListHardwareGroupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<HardwareGroup> extractResources(ListHardwareGroupsResponse payload) {
              return payload.getHardwareGroupsList();
            }
          };

  private static final PagedListDescriptor<ListHardwareRequest, ListHardwareResponse, Hardware>
      LIST_HARDWARE_PAGE_STR_DESC =
          new PagedListDescriptor<ListHardwareRequest, ListHardwareResponse, Hardware>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListHardwareRequest injectToken(ListHardwareRequest payload, String token) {
              return ListHardwareRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListHardwareRequest injectPageSize(ListHardwareRequest payload, int pageSize) {
              return ListHardwareRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListHardwareRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListHardwareResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Hardware> extractResources(ListHardwareResponse payload) {
              return payload.getHardwareList();
            }
          };

  private static final PagedListDescriptor<ListCommentsRequest, ListCommentsResponse, Comment>
      LIST_COMMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListCommentsRequest, ListCommentsResponse, Comment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCommentsRequest injectToken(ListCommentsRequest payload, String token) {
              return ListCommentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCommentsRequest injectPageSize(ListCommentsRequest payload, int pageSize) {
              return ListCommentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCommentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCommentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Comment> extractResources(ListCommentsResponse payload) {
              return payload.getCommentsList();
            }
          };

  private static final PagedListDescriptor<
          ListChangeLogEntriesRequest, ListChangeLogEntriesResponse, ChangeLogEntry>
      LIST_CHANGE_LOG_ENTRIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListChangeLogEntriesRequest, ListChangeLogEntriesResponse, ChangeLogEntry>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListChangeLogEntriesRequest injectToken(
                ListChangeLogEntriesRequest payload, String token) {
              return ListChangeLogEntriesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListChangeLogEntriesRequest injectPageSize(
                ListChangeLogEntriesRequest payload, int pageSize) {
              return ListChangeLogEntriesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListChangeLogEntriesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListChangeLogEntriesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ChangeLogEntry> extractResources(ListChangeLogEntriesResponse payload) {
              return payload.getChangeLogEntriesList();
            }
          };

  private static final PagedListDescriptor<ListSkusRequest, ListSkusResponse, Sku>
      LIST_SKUS_PAGE_STR_DESC =
          new PagedListDescriptor<ListSkusRequest, ListSkusResponse, Sku>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSkusRequest injectToken(ListSkusRequest payload, String token) {
              return ListSkusRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSkusRequest injectPageSize(ListSkusRequest payload, int pageSize) {
              return ListSkusRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSkusRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSkusResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Sku> extractResources(ListSkusResponse payload) {
              return payload.getSkusList();
            }
          };

  private static final PagedListDescriptor<ListZonesRequest, ListZonesResponse, Zone>
      LIST_ZONES_PAGE_STR_DESC =
          new PagedListDescriptor<ListZonesRequest, ListZonesResponse, Zone>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListZonesRequest injectToken(ListZonesRequest payload, String token) {
              return ListZonesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListZonesRequest injectPageSize(ListZonesRequest payload, int pageSize) {
              return ListZonesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListZonesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListZonesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Zone> extractResources(ListZonesResponse payload) {
              return payload.getZonesList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListOrdersRequest, ListOrdersResponse, ListOrdersPagedResponse>
      LIST_ORDERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListOrdersRequest, ListOrdersResponse, ListOrdersPagedResponse>() {
            @Override
            public ApiFuture<ListOrdersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListOrdersRequest, ListOrdersResponse> callable,
                ListOrdersRequest request,
                ApiCallContext context,
                ApiFuture<ListOrdersResponse> futureResponse) {
              PageContext<ListOrdersRequest, ListOrdersResponse, Order> pageContext =
                  PageContext.create(callable, LIST_ORDERS_PAGE_STR_DESC, request, context);
              return ListOrdersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSitesRequest, ListSitesResponse, ListSitesPagedResponse>
      LIST_SITES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSitesRequest, ListSitesResponse, ListSitesPagedResponse>() {
            @Override
            public ApiFuture<ListSitesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSitesRequest, ListSitesResponse> callable,
                ListSitesRequest request,
                ApiCallContext context,
                ApiFuture<ListSitesResponse> futureResponse) {
              PageContext<ListSitesRequest, ListSitesResponse, Site> pageContext =
                  PageContext.create(callable, LIST_SITES_PAGE_STR_DESC, request, context);
              return ListSitesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListHardwareGroupsRequest, ListHardwareGroupsResponse, ListHardwareGroupsPagedResponse>
      LIST_HARDWARE_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListHardwareGroupsRequest,
              ListHardwareGroupsResponse,
              ListHardwareGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListHardwareGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListHardwareGroupsRequest, ListHardwareGroupsResponse> callable,
                ListHardwareGroupsRequest request,
                ApiCallContext context,
                ApiFuture<ListHardwareGroupsResponse> futureResponse) {
              PageContext<ListHardwareGroupsRequest, ListHardwareGroupsResponse, HardwareGroup>
                  pageContext =
                      PageContext.create(
                          callable, LIST_HARDWARE_GROUPS_PAGE_STR_DESC, request, context);
              return ListHardwareGroupsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListHardwareRequest, ListHardwareResponse, ListHardwarePagedResponse>
      LIST_HARDWARE_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListHardwareRequest, ListHardwareResponse, ListHardwarePagedResponse>() {
            @Override
            public ApiFuture<ListHardwarePagedResponse> getFuturePagedResponse(
                UnaryCallable<ListHardwareRequest, ListHardwareResponse> callable,
                ListHardwareRequest request,
                ApiCallContext context,
                ApiFuture<ListHardwareResponse> futureResponse) {
              PageContext<ListHardwareRequest, ListHardwareResponse, Hardware> pageContext =
                  PageContext.create(callable, LIST_HARDWARE_PAGE_STR_DESC, request, context);
              return ListHardwarePagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCommentsRequest, ListCommentsResponse, ListCommentsPagedResponse>
      LIST_COMMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCommentsRequest, ListCommentsResponse, ListCommentsPagedResponse>() {
            @Override
            public ApiFuture<ListCommentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCommentsRequest, ListCommentsResponse> callable,
                ListCommentsRequest request,
                ApiCallContext context,
                ApiFuture<ListCommentsResponse> futureResponse) {
              PageContext<ListCommentsRequest, ListCommentsResponse, Comment> pageContext =
                  PageContext.create(callable, LIST_COMMENTS_PAGE_STR_DESC, request, context);
              return ListCommentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListChangeLogEntriesRequest,
          ListChangeLogEntriesResponse,
          ListChangeLogEntriesPagedResponse>
      LIST_CHANGE_LOG_ENTRIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListChangeLogEntriesRequest,
              ListChangeLogEntriesResponse,
              ListChangeLogEntriesPagedResponse>() {
            @Override
            public ApiFuture<ListChangeLogEntriesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListChangeLogEntriesRequest, ListChangeLogEntriesResponse> callable,
                ListChangeLogEntriesRequest request,
                ApiCallContext context,
                ApiFuture<ListChangeLogEntriesResponse> futureResponse) {
              PageContext<ListChangeLogEntriesRequest, ListChangeLogEntriesResponse, ChangeLogEntry>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CHANGE_LOG_ENTRIES_PAGE_STR_DESC, request, context);
              return ListChangeLogEntriesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSkusRequest, ListSkusResponse, ListSkusPagedResponse>
      LIST_SKUS_PAGE_STR_FACT =
          new PagedListResponseFactory<ListSkusRequest, ListSkusResponse, ListSkusPagedResponse>() {
            @Override
            public ApiFuture<ListSkusPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSkusRequest, ListSkusResponse> callable,
                ListSkusRequest request,
                ApiCallContext context,
                ApiFuture<ListSkusResponse> futureResponse) {
              PageContext<ListSkusRequest, ListSkusResponse, Sku> pageContext =
                  PageContext.create(callable, LIST_SKUS_PAGE_STR_DESC, request, context);
              return ListSkusPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListZonesRequest, ListZonesResponse, ListZonesPagedResponse>
      LIST_ZONES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListZonesRequest, ListZonesResponse, ListZonesPagedResponse>() {
            @Override
            public ApiFuture<ListZonesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListZonesRequest, ListZonesResponse> callable,
                ListZonesRequest request,
                ApiCallContext context,
                ApiFuture<ListZonesResponse> futureResponse) {
              PageContext<ListZonesRequest, ListZonesResponse, Zone> pageContext =
                  PageContext.create(callable, LIST_ZONES_PAGE_STR_DESC, request, context);
              return ListZonesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listOrders. */
  public PagedCallSettings<ListOrdersRequest, ListOrdersResponse, ListOrdersPagedResponse>
      listOrdersSettings() {
    return listOrdersSettings;
  }

  /** Returns the object with the settings used for calls to getOrder. */
  public UnaryCallSettings<GetOrderRequest, Order> getOrderSettings() {
    return getOrderSettings;
  }

  /** Returns the object with the settings used for calls to createOrder. */
  public UnaryCallSettings<CreateOrderRequest, Operation> createOrderSettings() {
    return createOrderSettings;
  }

  /** Returns the object with the settings used for calls to createOrder. */
  public OperationCallSettings<CreateOrderRequest, Order, OperationMetadata>
      createOrderOperationSettings() {
    return createOrderOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateOrder. */
  public UnaryCallSettings<UpdateOrderRequest, Operation> updateOrderSettings() {
    return updateOrderSettings;
  }

  /** Returns the object with the settings used for calls to updateOrder. */
  public OperationCallSettings<UpdateOrderRequest, Order, OperationMetadata>
      updateOrderOperationSettings() {
    return updateOrderOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteOrder. */
  public UnaryCallSettings<DeleteOrderRequest, Operation> deleteOrderSettings() {
    return deleteOrderSettings;
  }

  /** Returns the object with the settings used for calls to deleteOrder. */
  public OperationCallSettings<DeleteOrderRequest, Empty, OperationMetadata>
      deleteOrderOperationSettings() {
    return deleteOrderOperationSettings;
  }

  /** Returns the object with the settings used for calls to submitOrder. */
  public UnaryCallSettings<SubmitOrderRequest, Operation> submitOrderSettings() {
    return submitOrderSettings;
  }

  /** Returns the object with the settings used for calls to submitOrder. */
  public OperationCallSettings<SubmitOrderRequest, Order, OperationMetadata>
      submitOrderOperationSettings() {
    return submitOrderOperationSettings;
  }

  /** Returns the object with the settings used for calls to listSites. */
  public PagedCallSettings<ListSitesRequest, ListSitesResponse, ListSitesPagedResponse>
      listSitesSettings() {
    return listSitesSettings;
  }

  /** Returns the object with the settings used for calls to getSite. */
  public UnaryCallSettings<GetSiteRequest, Site> getSiteSettings() {
    return getSiteSettings;
  }

  /** Returns the object with the settings used for calls to createSite. */
  public UnaryCallSettings<CreateSiteRequest, Operation> createSiteSettings() {
    return createSiteSettings;
  }

  /** Returns the object with the settings used for calls to createSite. */
  public OperationCallSettings<CreateSiteRequest, Site, OperationMetadata>
      createSiteOperationSettings() {
    return createSiteOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateSite. */
  public UnaryCallSettings<UpdateSiteRequest, Operation> updateSiteSettings() {
    return updateSiteSettings;
  }

  /** Returns the object with the settings used for calls to updateSite. */
  public OperationCallSettings<UpdateSiteRequest, Site, OperationMetadata>
      updateSiteOperationSettings() {
    return updateSiteOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteSite. */
  public UnaryCallSettings<DeleteSiteRequest, Operation> deleteSiteSettings() {
    return deleteSiteSettings;
  }

  /** Returns the object with the settings used for calls to deleteSite. */
  public OperationCallSettings<DeleteSiteRequest, Empty, OperationMetadata>
      deleteSiteOperationSettings() {
    return deleteSiteOperationSettings;
  }

  /** Returns the object with the settings used for calls to listHardwareGroups. */
  public PagedCallSettings<
          ListHardwareGroupsRequest, ListHardwareGroupsResponse, ListHardwareGroupsPagedResponse>
      listHardwareGroupsSettings() {
    return listHardwareGroupsSettings;
  }

  /** Returns the object with the settings used for calls to getHardwareGroup. */
  public UnaryCallSettings<GetHardwareGroupRequest, HardwareGroup> getHardwareGroupSettings() {
    return getHardwareGroupSettings;
  }

  /** Returns the object with the settings used for calls to createHardwareGroup. */
  public UnaryCallSettings<CreateHardwareGroupRequest, Operation> createHardwareGroupSettings() {
    return createHardwareGroupSettings;
  }

  /** Returns the object with the settings used for calls to createHardwareGroup. */
  public OperationCallSettings<CreateHardwareGroupRequest, HardwareGroup, OperationMetadata>
      createHardwareGroupOperationSettings() {
    return createHardwareGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateHardwareGroup. */
  public UnaryCallSettings<UpdateHardwareGroupRequest, Operation> updateHardwareGroupSettings() {
    return updateHardwareGroupSettings;
  }

  /** Returns the object with the settings used for calls to updateHardwareGroup. */
  public OperationCallSettings<UpdateHardwareGroupRequest, HardwareGroup, OperationMetadata>
      updateHardwareGroupOperationSettings() {
    return updateHardwareGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteHardwareGroup. */
  public UnaryCallSettings<DeleteHardwareGroupRequest, Operation> deleteHardwareGroupSettings() {
    return deleteHardwareGroupSettings;
  }

  /** Returns the object with the settings used for calls to deleteHardwareGroup. */
  public OperationCallSettings<DeleteHardwareGroupRequest, Empty, OperationMetadata>
      deleteHardwareGroupOperationSettings() {
    return deleteHardwareGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to listHardware. */
  public PagedCallSettings<ListHardwareRequest, ListHardwareResponse, ListHardwarePagedResponse>
      listHardwareSettings() {
    return listHardwareSettings;
  }

  /** Returns the object with the settings used for calls to getHardware. */
  public UnaryCallSettings<GetHardwareRequest, Hardware> getHardwareSettings() {
    return getHardwareSettings;
  }

  /** Returns the object with the settings used for calls to createHardware. */
  public UnaryCallSettings<CreateHardwareRequest, Operation> createHardwareSettings() {
    return createHardwareSettings;
  }

  /** Returns the object with the settings used for calls to createHardware. */
  public OperationCallSettings<CreateHardwareRequest, Hardware, OperationMetadata>
      createHardwareOperationSettings() {
    return createHardwareOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateHardware. */
  public UnaryCallSettings<UpdateHardwareRequest, Operation> updateHardwareSettings() {
    return updateHardwareSettings;
  }

  /** Returns the object with the settings used for calls to updateHardware. */
  public OperationCallSettings<UpdateHardwareRequest, Hardware, OperationMetadata>
      updateHardwareOperationSettings() {
    return updateHardwareOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteHardware. */
  public UnaryCallSettings<DeleteHardwareRequest, Operation> deleteHardwareSettings() {
    return deleteHardwareSettings;
  }

  /** Returns the object with the settings used for calls to deleteHardware. */
  public OperationCallSettings<DeleteHardwareRequest, Empty, OperationMetadata>
      deleteHardwareOperationSettings() {
    return deleteHardwareOperationSettings;
  }

  /** Returns the object with the settings used for calls to listComments. */
  public PagedCallSettings<ListCommentsRequest, ListCommentsResponse, ListCommentsPagedResponse>
      listCommentsSettings() {
    return listCommentsSettings;
  }

  /** Returns the object with the settings used for calls to getComment. */
  public UnaryCallSettings<GetCommentRequest, Comment> getCommentSettings() {
    return getCommentSettings;
  }

  /** Returns the object with the settings used for calls to createComment. */
  public UnaryCallSettings<CreateCommentRequest, Operation> createCommentSettings() {
    return createCommentSettings;
  }

  /** Returns the object with the settings used for calls to createComment. */
  public OperationCallSettings<CreateCommentRequest, Comment, OperationMetadata>
      createCommentOperationSettings() {
    return createCommentOperationSettings;
  }

  /** Returns the object with the settings used for calls to recordActionOnComment. */
  public UnaryCallSettings<RecordActionOnCommentRequest, Comment> recordActionOnCommentSettings() {
    return recordActionOnCommentSettings;
  }

  /** Returns the object with the settings used for calls to listChangeLogEntries. */
  public PagedCallSettings<
          ListChangeLogEntriesRequest,
          ListChangeLogEntriesResponse,
          ListChangeLogEntriesPagedResponse>
      listChangeLogEntriesSettings() {
    return listChangeLogEntriesSettings;
  }

  /** Returns the object with the settings used for calls to getChangeLogEntry. */
  public UnaryCallSettings<GetChangeLogEntryRequest, ChangeLogEntry> getChangeLogEntrySettings() {
    return getChangeLogEntrySettings;
  }

  /** Returns the object with the settings used for calls to listSkus. */
  public PagedCallSettings<ListSkusRequest, ListSkusResponse, ListSkusPagedResponse>
      listSkusSettings() {
    return listSkusSettings;
  }

  /** Returns the object with the settings used for calls to getSku. */
  public UnaryCallSettings<GetSkuRequest, Sku> getSkuSettings() {
    return getSkuSettings;
  }

  /** Returns the object with the settings used for calls to listZones. */
  public PagedCallSettings<ListZonesRequest, ListZonesResponse, ListZonesPagedResponse>
      listZonesSettings() {
    return listZonesSettings;
  }

  /** Returns the object with the settings used for calls to getZone. */
  public UnaryCallSettings<GetZoneRequest, Zone> getZoneSettings() {
    return getZoneSettings;
  }

  /** Returns the object with the settings used for calls to createZone. */
  public UnaryCallSettings<CreateZoneRequest, Operation> createZoneSettings() {
    return createZoneSettings;
  }

  /** Returns the object with the settings used for calls to createZone. */
  public OperationCallSettings<CreateZoneRequest, Zone, OperationMetadata>
      createZoneOperationSettings() {
    return createZoneOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateZone. */
  public UnaryCallSettings<UpdateZoneRequest, Operation> updateZoneSettings() {
    return updateZoneSettings;
  }

  /** Returns the object with the settings used for calls to updateZone. */
  public OperationCallSettings<UpdateZoneRequest, Zone, OperationMetadata>
      updateZoneOperationSettings() {
    return updateZoneOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteZone. */
  public UnaryCallSettings<DeleteZoneRequest, Operation> deleteZoneSettings() {
    return deleteZoneSettings;
  }

  /** Returns the object with the settings used for calls to deleteZone. */
  public OperationCallSettings<DeleteZoneRequest, Empty, OperationMetadata>
      deleteZoneOperationSettings() {
    return deleteZoneOperationSettings;
  }

  /** Returns the object with the settings used for calls to signalZoneState. */
  public UnaryCallSettings<SignalZoneStateRequest, Operation> signalZoneStateSettings() {
    return signalZoneStateSettings;
  }

  /** Returns the object with the settings used for calls to signalZoneState. */
  public OperationCallSettings<SignalZoneStateRequest, Zone, OperationMetadata>
      signalZoneStateOperationSettings() {
    return signalZoneStateOperationSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  public GDCHardwareManagementStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcGDCHardwareManagementStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonGDCHardwareManagementStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "gdchardwaremanagement";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "gdchardwaremanagement.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "gdchardwaremanagement.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(GDCHardwareManagementStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(GDCHardwareManagementStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return GDCHardwareManagementStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected GDCHardwareManagementStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listOrdersSettings = settingsBuilder.listOrdersSettings().build();
    getOrderSettings = settingsBuilder.getOrderSettings().build();
    createOrderSettings = settingsBuilder.createOrderSettings().build();
    createOrderOperationSettings = settingsBuilder.createOrderOperationSettings().build();
    updateOrderSettings = settingsBuilder.updateOrderSettings().build();
    updateOrderOperationSettings = settingsBuilder.updateOrderOperationSettings().build();
    deleteOrderSettings = settingsBuilder.deleteOrderSettings().build();
    deleteOrderOperationSettings = settingsBuilder.deleteOrderOperationSettings().build();
    submitOrderSettings = settingsBuilder.submitOrderSettings().build();
    submitOrderOperationSettings = settingsBuilder.submitOrderOperationSettings().build();
    listSitesSettings = settingsBuilder.listSitesSettings().build();
    getSiteSettings = settingsBuilder.getSiteSettings().build();
    createSiteSettings = settingsBuilder.createSiteSettings().build();
    createSiteOperationSettings = settingsBuilder.createSiteOperationSettings().build();
    updateSiteSettings = settingsBuilder.updateSiteSettings().build();
    updateSiteOperationSettings = settingsBuilder.updateSiteOperationSettings().build();
    deleteSiteSettings = settingsBuilder.deleteSiteSettings().build();
    deleteSiteOperationSettings = settingsBuilder.deleteSiteOperationSettings().build();
    listHardwareGroupsSettings = settingsBuilder.listHardwareGroupsSettings().build();
    getHardwareGroupSettings = settingsBuilder.getHardwareGroupSettings().build();
    createHardwareGroupSettings = settingsBuilder.createHardwareGroupSettings().build();
    createHardwareGroupOperationSettings =
        settingsBuilder.createHardwareGroupOperationSettings().build();
    updateHardwareGroupSettings = settingsBuilder.updateHardwareGroupSettings().build();
    updateHardwareGroupOperationSettings =
        settingsBuilder.updateHardwareGroupOperationSettings().build();
    deleteHardwareGroupSettings = settingsBuilder.deleteHardwareGroupSettings().build();
    deleteHardwareGroupOperationSettings =
        settingsBuilder.deleteHardwareGroupOperationSettings().build();
    listHardwareSettings = settingsBuilder.listHardwareSettings().build();
    getHardwareSettings = settingsBuilder.getHardwareSettings().build();
    createHardwareSettings = settingsBuilder.createHardwareSettings().build();
    createHardwareOperationSettings = settingsBuilder.createHardwareOperationSettings().build();
    updateHardwareSettings = settingsBuilder.updateHardwareSettings().build();
    updateHardwareOperationSettings = settingsBuilder.updateHardwareOperationSettings().build();
    deleteHardwareSettings = settingsBuilder.deleteHardwareSettings().build();
    deleteHardwareOperationSettings = settingsBuilder.deleteHardwareOperationSettings().build();
    listCommentsSettings = settingsBuilder.listCommentsSettings().build();
    getCommentSettings = settingsBuilder.getCommentSettings().build();
    createCommentSettings = settingsBuilder.createCommentSettings().build();
    createCommentOperationSettings = settingsBuilder.createCommentOperationSettings().build();
    recordActionOnCommentSettings = settingsBuilder.recordActionOnCommentSettings().build();
    listChangeLogEntriesSettings = settingsBuilder.listChangeLogEntriesSettings().build();
    getChangeLogEntrySettings = settingsBuilder.getChangeLogEntrySettings().build();
    listSkusSettings = settingsBuilder.listSkusSettings().build();
    getSkuSettings = settingsBuilder.getSkuSettings().build();
    listZonesSettings = settingsBuilder.listZonesSettings().build();
    getZoneSettings = settingsBuilder.getZoneSettings().build();
    createZoneSettings = settingsBuilder.createZoneSettings().build();
    createZoneOperationSettings = settingsBuilder.createZoneOperationSettings().build();
    updateZoneSettings = settingsBuilder.updateZoneSettings().build();
    updateZoneOperationSettings = settingsBuilder.updateZoneOperationSettings().build();
    deleteZoneSettings = settingsBuilder.deleteZoneSettings().build();
    deleteZoneOperationSettings = settingsBuilder.deleteZoneOperationSettings().build();
    signalZoneStateSettings = settingsBuilder.signalZoneStateSettings().build();
    signalZoneStateOperationSettings = settingsBuilder.signalZoneStateOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for GDCHardwareManagementStubSettings. */
  public static class Builder
      extends StubSettings.Builder<GDCHardwareManagementStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListOrdersRequest, ListOrdersResponse, ListOrdersPagedResponse>
        listOrdersSettings;
    private final UnaryCallSettings.Builder<GetOrderRequest, Order> getOrderSettings;
    private final UnaryCallSettings.Builder<CreateOrderRequest, Operation> createOrderSettings;
    private final OperationCallSettings.Builder<CreateOrderRequest, Order, OperationMetadata>
        createOrderOperationSettings;
    private final UnaryCallSettings.Builder<UpdateOrderRequest, Operation> updateOrderSettings;
    private final OperationCallSettings.Builder<UpdateOrderRequest, Order, OperationMetadata>
        updateOrderOperationSettings;
    private final UnaryCallSettings.Builder<DeleteOrderRequest, Operation> deleteOrderSettings;
    private final OperationCallSettings.Builder<DeleteOrderRequest, Empty, OperationMetadata>
        deleteOrderOperationSettings;
    private final UnaryCallSettings.Builder<SubmitOrderRequest, Operation> submitOrderSettings;
    private final OperationCallSettings.Builder<SubmitOrderRequest, Order, OperationMetadata>
        submitOrderOperationSettings;
    private final PagedCallSettings.Builder<
            ListSitesRequest, ListSitesResponse, ListSitesPagedResponse>
        listSitesSettings;
    private final UnaryCallSettings.Builder<GetSiteRequest, Site> getSiteSettings;
    private final UnaryCallSettings.Builder<CreateSiteRequest, Operation> createSiteSettings;
    private final OperationCallSettings.Builder<CreateSiteRequest, Site, OperationMetadata>
        createSiteOperationSettings;
    private final UnaryCallSettings.Builder<UpdateSiteRequest, Operation> updateSiteSettings;
    private final OperationCallSettings.Builder<UpdateSiteRequest, Site, OperationMetadata>
        updateSiteOperationSettings;
    private final UnaryCallSettings.Builder<DeleteSiteRequest, Operation> deleteSiteSettings;
    private final OperationCallSettings.Builder<DeleteSiteRequest, Empty, OperationMetadata>
        deleteSiteOperationSettings;
    private final PagedCallSettings.Builder<
            ListHardwareGroupsRequest, ListHardwareGroupsResponse, ListHardwareGroupsPagedResponse>
        listHardwareGroupsSettings;
    private final UnaryCallSettings.Builder<GetHardwareGroupRequest, HardwareGroup>
        getHardwareGroupSettings;
    private final UnaryCallSettings.Builder<CreateHardwareGroupRequest, Operation>
        createHardwareGroupSettings;
    private final OperationCallSettings.Builder<
            CreateHardwareGroupRequest, HardwareGroup, OperationMetadata>
        createHardwareGroupOperationSettings;
    private final UnaryCallSettings.Builder<UpdateHardwareGroupRequest, Operation>
        updateHardwareGroupSettings;
    private final OperationCallSettings.Builder<
            UpdateHardwareGroupRequest, HardwareGroup, OperationMetadata>
        updateHardwareGroupOperationSettings;
    private final UnaryCallSettings.Builder<DeleteHardwareGroupRequest, Operation>
        deleteHardwareGroupSettings;
    private final OperationCallSettings.Builder<
            DeleteHardwareGroupRequest, Empty, OperationMetadata>
        deleteHardwareGroupOperationSettings;
    private final PagedCallSettings.Builder<
            ListHardwareRequest, ListHardwareResponse, ListHardwarePagedResponse>
        listHardwareSettings;
    private final UnaryCallSettings.Builder<GetHardwareRequest, Hardware> getHardwareSettings;
    private final UnaryCallSettings.Builder<CreateHardwareRequest, Operation>
        createHardwareSettings;
    private final OperationCallSettings.Builder<CreateHardwareRequest, Hardware, OperationMetadata>
        createHardwareOperationSettings;
    private final UnaryCallSettings.Builder<UpdateHardwareRequest, Operation>
        updateHardwareSettings;
    private final OperationCallSettings.Builder<UpdateHardwareRequest, Hardware, OperationMetadata>
        updateHardwareOperationSettings;
    private final UnaryCallSettings.Builder<DeleteHardwareRequest, Operation>
        deleteHardwareSettings;
    private final OperationCallSettings.Builder<DeleteHardwareRequest, Empty, OperationMetadata>
        deleteHardwareOperationSettings;
    private final PagedCallSettings.Builder<
            ListCommentsRequest, ListCommentsResponse, ListCommentsPagedResponse>
        listCommentsSettings;
    private final UnaryCallSettings.Builder<GetCommentRequest, Comment> getCommentSettings;
    private final UnaryCallSettings.Builder<CreateCommentRequest, Operation> createCommentSettings;
    private final OperationCallSettings.Builder<CreateCommentRequest, Comment, OperationMetadata>
        createCommentOperationSettings;
    private final UnaryCallSettings.Builder<RecordActionOnCommentRequest, Comment>
        recordActionOnCommentSettings;
    private final PagedCallSettings.Builder<
            ListChangeLogEntriesRequest,
            ListChangeLogEntriesResponse,
            ListChangeLogEntriesPagedResponse>
        listChangeLogEntriesSettings;
    private final UnaryCallSettings.Builder<GetChangeLogEntryRequest, ChangeLogEntry>
        getChangeLogEntrySettings;
    private final PagedCallSettings.Builder<
            ListSkusRequest, ListSkusResponse, ListSkusPagedResponse>
        listSkusSettings;
    private final UnaryCallSettings.Builder<GetSkuRequest, Sku> getSkuSettings;
    private final PagedCallSettings.Builder<
            ListZonesRequest, ListZonesResponse, ListZonesPagedResponse>
        listZonesSettings;
    private final UnaryCallSettings.Builder<GetZoneRequest, Zone> getZoneSettings;
    private final UnaryCallSettings.Builder<CreateZoneRequest, Operation> createZoneSettings;
    private final OperationCallSettings.Builder<CreateZoneRequest, Zone, OperationMetadata>
        createZoneOperationSettings;
    private final UnaryCallSettings.Builder<UpdateZoneRequest, Operation> updateZoneSettings;
    private final OperationCallSettings.Builder<UpdateZoneRequest, Zone, OperationMetadata>
        updateZoneOperationSettings;
    private final UnaryCallSettings.Builder<DeleteZoneRequest, Operation> deleteZoneSettings;
    private final OperationCallSettings.Builder<DeleteZoneRequest, Empty, OperationMetadata>
        deleteZoneOperationSettings;
    private final UnaryCallSettings.Builder<SignalZoneStateRequest, Operation>
        signalZoneStateSettings;
    private final OperationCallSettings.Builder<SignalZoneStateRequest, Zone, OperationMetadata>
        signalZoneStateOperationSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listOrdersSettings = PagedCallSettings.newBuilder(LIST_ORDERS_PAGE_STR_FACT);
      getOrderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createOrderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createOrderOperationSettings = OperationCallSettings.newBuilder();
      updateOrderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateOrderOperationSettings = OperationCallSettings.newBuilder();
      deleteOrderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteOrderOperationSettings = OperationCallSettings.newBuilder();
      submitOrderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      submitOrderOperationSettings = OperationCallSettings.newBuilder();
      listSitesSettings = PagedCallSettings.newBuilder(LIST_SITES_PAGE_STR_FACT);
      getSiteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSiteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSiteOperationSettings = OperationCallSettings.newBuilder();
      updateSiteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSiteOperationSettings = OperationCallSettings.newBuilder();
      deleteSiteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSiteOperationSettings = OperationCallSettings.newBuilder();
      listHardwareGroupsSettings = PagedCallSettings.newBuilder(LIST_HARDWARE_GROUPS_PAGE_STR_FACT);
      getHardwareGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createHardwareGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createHardwareGroupOperationSettings = OperationCallSettings.newBuilder();
      updateHardwareGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateHardwareGroupOperationSettings = OperationCallSettings.newBuilder();
      deleteHardwareGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteHardwareGroupOperationSettings = OperationCallSettings.newBuilder();
      listHardwareSettings = PagedCallSettings.newBuilder(LIST_HARDWARE_PAGE_STR_FACT);
      getHardwareSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createHardwareSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createHardwareOperationSettings = OperationCallSettings.newBuilder();
      updateHardwareSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateHardwareOperationSettings = OperationCallSettings.newBuilder();
      deleteHardwareSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteHardwareOperationSettings = OperationCallSettings.newBuilder();
      listCommentsSettings = PagedCallSettings.newBuilder(LIST_COMMENTS_PAGE_STR_FACT);
      getCommentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCommentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCommentOperationSettings = OperationCallSettings.newBuilder();
      recordActionOnCommentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listChangeLogEntriesSettings =
          PagedCallSettings.newBuilder(LIST_CHANGE_LOG_ENTRIES_PAGE_STR_FACT);
      getChangeLogEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSkusSettings = PagedCallSettings.newBuilder(LIST_SKUS_PAGE_STR_FACT);
      getSkuSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listZonesSettings = PagedCallSettings.newBuilder(LIST_ZONES_PAGE_STR_FACT);
      getZoneSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createZoneSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createZoneOperationSettings = OperationCallSettings.newBuilder();
      updateZoneSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateZoneOperationSettings = OperationCallSettings.newBuilder();
      deleteZoneSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteZoneOperationSettings = OperationCallSettings.newBuilder();
      signalZoneStateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      signalZoneStateOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listOrdersSettings,
              getOrderSettings,
              createOrderSettings,
              updateOrderSettings,
              deleteOrderSettings,
              submitOrderSettings,
              listSitesSettings,
              getSiteSettings,
              createSiteSettings,
              updateSiteSettings,
              deleteSiteSettings,
              listHardwareGroupsSettings,
              getHardwareGroupSettings,
              createHardwareGroupSettings,
              updateHardwareGroupSettings,
              deleteHardwareGroupSettings,
              listHardwareSettings,
              getHardwareSettings,
              createHardwareSettings,
              updateHardwareSettings,
              deleteHardwareSettings,
              listCommentsSettings,
              getCommentSettings,
              createCommentSettings,
              recordActionOnCommentSettings,
              listChangeLogEntriesSettings,
              getChangeLogEntrySettings,
              listSkusSettings,
              getSkuSettings,
              listZonesSettings,
              getZoneSettings,
              createZoneSettings,
              updateZoneSettings,
              deleteZoneSettings,
              signalZoneStateSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(GDCHardwareManagementStubSettings settings) {
      super(settings);

      listOrdersSettings = settings.listOrdersSettings.toBuilder();
      getOrderSettings = settings.getOrderSettings.toBuilder();
      createOrderSettings = settings.createOrderSettings.toBuilder();
      createOrderOperationSettings = settings.createOrderOperationSettings.toBuilder();
      updateOrderSettings = settings.updateOrderSettings.toBuilder();
      updateOrderOperationSettings = settings.updateOrderOperationSettings.toBuilder();
      deleteOrderSettings = settings.deleteOrderSettings.toBuilder();
      deleteOrderOperationSettings = settings.deleteOrderOperationSettings.toBuilder();
      submitOrderSettings = settings.submitOrderSettings.toBuilder();
      submitOrderOperationSettings = settings.submitOrderOperationSettings.toBuilder();
      listSitesSettings = settings.listSitesSettings.toBuilder();
      getSiteSettings = settings.getSiteSettings.toBuilder();
      createSiteSettings = settings.createSiteSettings.toBuilder();
      createSiteOperationSettings = settings.createSiteOperationSettings.toBuilder();
      updateSiteSettings = settings.updateSiteSettings.toBuilder();
      updateSiteOperationSettings = settings.updateSiteOperationSettings.toBuilder();
      deleteSiteSettings = settings.deleteSiteSettings.toBuilder();
      deleteSiteOperationSettings = settings.deleteSiteOperationSettings.toBuilder();
      listHardwareGroupsSettings = settings.listHardwareGroupsSettings.toBuilder();
      getHardwareGroupSettings = settings.getHardwareGroupSettings.toBuilder();
      createHardwareGroupSettings = settings.createHardwareGroupSettings.toBuilder();
      createHardwareGroupOperationSettings =
          settings.createHardwareGroupOperationSettings.toBuilder();
      updateHardwareGroupSettings = settings.updateHardwareGroupSettings.toBuilder();
      updateHardwareGroupOperationSettings =
          settings.updateHardwareGroupOperationSettings.toBuilder();
      deleteHardwareGroupSettings = settings.deleteHardwareGroupSettings.toBuilder();
      deleteHardwareGroupOperationSettings =
          settings.deleteHardwareGroupOperationSettings.toBuilder();
      listHardwareSettings = settings.listHardwareSettings.toBuilder();
      getHardwareSettings = settings.getHardwareSettings.toBuilder();
      createHardwareSettings = settings.createHardwareSettings.toBuilder();
      createHardwareOperationSettings = settings.createHardwareOperationSettings.toBuilder();
      updateHardwareSettings = settings.updateHardwareSettings.toBuilder();
      updateHardwareOperationSettings = settings.updateHardwareOperationSettings.toBuilder();
      deleteHardwareSettings = settings.deleteHardwareSettings.toBuilder();
      deleteHardwareOperationSettings = settings.deleteHardwareOperationSettings.toBuilder();
      listCommentsSettings = settings.listCommentsSettings.toBuilder();
      getCommentSettings = settings.getCommentSettings.toBuilder();
      createCommentSettings = settings.createCommentSettings.toBuilder();
      createCommentOperationSettings = settings.createCommentOperationSettings.toBuilder();
      recordActionOnCommentSettings = settings.recordActionOnCommentSettings.toBuilder();
      listChangeLogEntriesSettings = settings.listChangeLogEntriesSettings.toBuilder();
      getChangeLogEntrySettings = settings.getChangeLogEntrySettings.toBuilder();
      listSkusSettings = settings.listSkusSettings.toBuilder();
      getSkuSettings = settings.getSkuSettings.toBuilder();
      listZonesSettings = settings.listZonesSettings.toBuilder();
      getZoneSettings = settings.getZoneSettings.toBuilder();
      createZoneSettings = settings.createZoneSettings.toBuilder();
      createZoneOperationSettings = settings.createZoneOperationSettings.toBuilder();
      updateZoneSettings = settings.updateZoneSettings.toBuilder();
      updateZoneOperationSettings = settings.updateZoneOperationSettings.toBuilder();
      deleteZoneSettings = settings.deleteZoneSettings.toBuilder();
      deleteZoneOperationSettings = settings.deleteZoneOperationSettings.toBuilder();
      signalZoneStateSettings = settings.signalZoneStateSettings.toBuilder();
      signalZoneStateOperationSettings = settings.signalZoneStateOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listOrdersSettings,
              getOrderSettings,
              createOrderSettings,
              updateOrderSettings,
              deleteOrderSettings,
              submitOrderSettings,
              listSitesSettings,
              getSiteSettings,
              createSiteSettings,
              updateSiteSettings,
              deleteSiteSettings,
              listHardwareGroupsSettings,
              getHardwareGroupSettings,
              createHardwareGroupSettings,
              updateHardwareGroupSettings,
              deleteHardwareGroupSettings,
              listHardwareSettings,
              getHardwareSettings,
              createHardwareSettings,
              updateHardwareSettings,
              deleteHardwareSettings,
              listCommentsSettings,
              getCommentSettings,
              createCommentSettings,
              recordActionOnCommentSettings,
              listChangeLogEntriesSettings,
              getChangeLogEntrySettings,
              listSkusSettings,
              getSkuSettings,
              listZonesSettings,
              getZoneSettings,
              createZoneSettings,
              updateZoneSettings,
              deleteZoneSettings,
              signalZoneStateSettings,
              listLocationsSettings,
              getLocationSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listOrdersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getOrderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createOrderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateOrderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteOrderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .submitOrderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listSitesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getSiteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createSiteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateSiteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteSiteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listHardwareGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getHardwareGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createHardwareGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateHardwareGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteHardwareGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listHardwareSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getHardwareSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createHardwareSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateHardwareSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteHardwareSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listCommentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getCommentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createCommentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .recordActionOnCommentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listChangeLogEntriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getChangeLogEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listSkusSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getSkuSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listZonesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getZoneSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createZoneSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateZoneSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteZoneSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .signalZoneStateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createOrderOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateOrderRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Order.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateOrderOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateOrderRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Order.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteOrderOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteOrderRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .submitOrderOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<SubmitOrderRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Order.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createSiteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateSiteRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Site.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateSiteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateSiteRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Site.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteSiteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteSiteRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createHardwareGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateHardwareGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(HardwareGroup.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateHardwareGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateHardwareGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(HardwareGroup.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteHardwareGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteHardwareGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createHardwareOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateHardwareRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Hardware.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateHardwareOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateHardwareRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Hardware.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteHardwareOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteHardwareRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createCommentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateCommentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Comment.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createZoneOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateZoneRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Zone.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateZoneOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateZoneRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Zone.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteZoneOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteZoneRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .signalZoneStateOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SignalZoneStateRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Zone.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to listOrders. */
    public PagedCallSettings.Builder<ListOrdersRequest, ListOrdersResponse, ListOrdersPagedResponse>
        listOrdersSettings() {
      return listOrdersSettings;
    }

    /** Returns the builder for the settings used for calls to getOrder. */
    public UnaryCallSettings.Builder<GetOrderRequest, Order> getOrderSettings() {
      return getOrderSettings;
    }

    /** Returns the builder for the settings used for calls to createOrder. */
    public UnaryCallSettings.Builder<CreateOrderRequest, Operation> createOrderSettings() {
      return createOrderSettings;
    }

    /** Returns the builder for the settings used for calls to createOrder. */
    public OperationCallSettings.Builder<CreateOrderRequest, Order, OperationMetadata>
        createOrderOperationSettings() {
      return createOrderOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateOrder. */
    public UnaryCallSettings.Builder<UpdateOrderRequest, Operation> updateOrderSettings() {
      return updateOrderSettings;
    }

    /** Returns the builder for the settings used for calls to updateOrder. */
    public OperationCallSettings.Builder<UpdateOrderRequest, Order, OperationMetadata>
        updateOrderOperationSettings() {
      return updateOrderOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteOrder. */
    public UnaryCallSettings.Builder<DeleteOrderRequest, Operation> deleteOrderSettings() {
      return deleteOrderSettings;
    }

    /** Returns the builder for the settings used for calls to deleteOrder. */
    public OperationCallSettings.Builder<DeleteOrderRequest, Empty, OperationMetadata>
        deleteOrderOperationSettings() {
      return deleteOrderOperationSettings;
    }

    /** Returns the builder for the settings used for calls to submitOrder. */
    public UnaryCallSettings.Builder<SubmitOrderRequest, Operation> submitOrderSettings() {
      return submitOrderSettings;
    }

    /** Returns the builder for the settings used for calls to submitOrder. */
    public OperationCallSettings.Builder<SubmitOrderRequest, Order, OperationMetadata>
        submitOrderOperationSettings() {
      return submitOrderOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listSites. */
    public PagedCallSettings.Builder<ListSitesRequest, ListSitesResponse, ListSitesPagedResponse>
        listSitesSettings() {
      return listSitesSettings;
    }

    /** Returns the builder for the settings used for calls to getSite. */
    public UnaryCallSettings.Builder<GetSiteRequest, Site> getSiteSettings() {
      return getSiteSettings;
    }

    /** Returns the builder for the settings used for calls to createSite. */
    public UnaryCallSettings.Builder<CreateSiteRequest, Operation> createSiteSettings() {
      return createSiteSettings;
    }

    /** Returns the builder for the settings used for calls to createSite. */
    public OperationCallSettings.Builder<CreateSiteRequest, Site, OperationMetadata>
        createSiteOperationSettings() {
      return createSiteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateSite. */
    public UnaryCallSettings.Builder<UpdateSiteRequest, Operation> updateSiteSettings() {
      return updateSiteSettings;
    }

    /** Returns the builder for the settings used for calls to updateSite. */
    public OperationCallSettings.Builder<UpdateSiteRequest, Site, OperationMetadata>
        updateSiteOperationSettings() {
      return updateSiteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSite. */
    public UnaryCallSettings.Builder<DeleteSiteRequest, Operation> deleteSiteSettings() {
      return deleteSiteSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSite. */
    public OperationCallSettings.Builder<DeleteSiteRequest, Empty, OperationMetadata>
        deleteSiteOperationSettings() {
      return deleteSiteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listHardwareGroups. */
    public PagedCallSettings.Builder<
            ListHardwareGroupsRequest, ListHardwareGroupsResponse, ListHardwareGroupsPagedResponse>
        listHardwareGroupsSettings() {
      return listHardwareGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to getHardwareGroup. */
    public UnaryCallSettings.Builder<GetHardwareGroupRequest, HardwareGroup>
        getHardwareGroupSettings() {
      return getHardwareGroupSettings;
    }

    /** Returns the builder for the settings used for calls to createHardwareGroup. */
    public UnaryCallSettings.Builder<CreateHardwareGroupRequest, Operation>
        createHardwareGroupSettings() {
      return createHardwareGroupSettings;
    }

    /** Returns the builder for the settings used for calls to createHardwareGroup. */
    public OperationCallSettings.Builder<
            CreateHardwareGroupRequest, HardwareGroup, OperationMetadata>
        createHardwareGroupOperationSettings() {
      return createHardwareGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateHardwareGroup. */
    public UnaryCallSettings.Builder<UpdateHardwareGroupRequest, Operation>
        updateHardwareGroupSettings() {
      return updateHardwareGroupSettings;
    }

    /** Returns the builder for the settings used for calls to updateHardwareGroup. */
    public OperationCallSettings.Builder<
            UpdateHardwareGroupRequest, HardwareGroup, OperationMetadata>
        updateHardwareGroupOperationSettings() {
      return updateHardwareGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteHardwareGroup. */
    public UnaryCallSettings.Builder<DeleteHardwareGroupRequest, Operation>
        deleteHardwareGroupSettings() {
      return deleteHardwareGroupSettings;
    }

    /** Returns the builder for the settings used for calls to deleteHardwareGroup. */
    public OperationCallSettings.Builder<DeleteHardwareGroupRequest, Empty, OperationMetadata>
        deleteHardwareGroupOperationSettings() {
      return deleteHardwareGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listHardware. */
    public PagedCallSettings.Builder<
            ListHardwareRequest, ListHardwareResponse, ListHardwarePagedResponse>
        listHardwareSettings() {
      return listHardwareSettings;
    }

    /** Returns the builder for the settings used for calls to getHardware. */
    public UnaryCallSettings.Builder<GetHardwareRequest, Hardware> getHardwareSettings() {
      return getHardwareSettings;
    }

    /** Returns the builder for the settings used for calls to createHardware. */
    public UnaryCallSettings.Builder<CreateHardwareRequest, Operation> createHardwareSettings() {
      return createHardwareSettings;
    }

    /** Returns the builder for the settings used for calls to createHardware. */
    public OperationCallSettings.Builder<CreateHardwareRequest, Hardware, OperationMetadata>
        createHardwareOperationSettings() {
      return createHardwareOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateHardware. */
    public UnaryCallSettings.Builder<UpdateHardwareRequest, Operation> updateHardwareSettings() {
      return updateHardwareSettings;
    }

    /** Returns the builder for the settings used for calls to updateHardware. */
    public OperationCallSettings.Builder<UpdateHardwareRequest, Hardware, OperationMetadata>
        updateHardwareOperationSettings() {
      return updateHardwareOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteHardware. */
    public UnaryCallSettings.Builder<DeleteHardwareRequest, Operation> deleteHardwareSettings() {
      return deleteHardwareSettings;
    }

    /** Returns the builder for the settings used for calls to deleteHardware. */
    public OperationCallSettings.Builder<DeleteHardwareRequest, Empty, OperationMetadata>
        deleteHardwareOperationSettings() {
      return deleteHardwareOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listComments. */
    public PagedCallSettings.Builder<
            ListCommentsRequest, ListCommentsResponse, ListCommentsPagedResponse>
        listCommentsSettings() {
      return listCommentsSettings;
    }

    /** Returns the builder for the settings used for calls to getComment. */
    public UnaryCallSettings.Builder<GetCommentRequest, Comment> getCommentSettings() {
      return getCommentSettings;
    }

    /** Returns the builder for the settings used for calls to createComment. */
    public UnaryCallSettings.Builder<CreateCommentRequest, Operation> createCommentSettings() {
      return createCommentSettings;
    }

    /** Returns the builder for the settings used for calls to createComment. */
    public OperationCallSettings.Builder<CreateCommentRequest, Comment, OperationMetadata>
        createCommentOperationSettings() {
      return createCommentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to recordActionOnComment. */
    public UnaryCallSettings.Builder<RecordActionOnCommentRequest, Comment>
        recordActionOnCommentSettings() {
      return recordActionOnCommentSettings;
    }

    /** Returns the builder for the settings used for calls to listChangeLogEntries. */
    public PagedCallSettings.Builder<
            ListChangeLogEntriesRequest,
            ListChangeLogEntriesResponse,
            ListChangeLogEntriesPagedResponse>
        listChangeLogEntriesSettings() {
      return listChangeLogEntriesSettings;
    }

    /** Returns the builder for the settings used for calls to getChangeLogEntry. */
    public UnaryCallSettings.Builder<GetChangeLogEntryRequest, ChangeLogEntry>
        getChangeLogEntrySettings() {
      return getChangeLogEntrySettings;
    }

    /** Returns the builder for the settings used for calls to listSkus. */
    public PagedCallSettings.Builder<ListSkusRequest, ListSkusResponse, ListSkusPagedResponse>
        listSkusSettings() {
      return listSkusSettings;
    }

    /** Returns the builder for the settings used for calls to getSku. */
    public UnaryCallSettings.Builder<GetSkuRequest, Sku> getSkuSettings() {
      return getSkuSettings;
    }

    /** Returns the builder for the settings used for calls to listZones. */
    public PagedCallSettings.Builder<ListZonesRequest, ListZonesResponse, ListZonesPagedResponse>
        listZonesSettings() {
      return listZonesSettings;
    }

    /** Returns the builder for the settings used for calls to getZone. */
    public UnaryCallSettings.Builder<GetZoneRequest, Zone> getZoneSettings() {
      return getZoneSettings;
    }

    /** Returns the builder for the settings used for calls to createZone. */
    public UnaryCallSettings.Builder<CreateZoneRequest, Operation> createZoneSettings() {
      return createZoneSettings;
    }

    /** Returns the builder for the settings used for calls to createZone. */
    public OperationCallSettings.Builder<CreateZoneRequest, Zone, OperationMetadata>
        createZoneOperationSettings() {
      return createZoneOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateZone. */
    public UnaryCallSettings.Builder<UpdateZoneRequest, Operation> updateZoneSettings() {
      return updateZoneSettings;
    }

    /** Returns the builder for the settings used for calls to updateZone. */
    public OperationCallSettings.Builder<UpdateZoneRequest, Zone, OperationMetadata>
        updateZoneOperationSettings() {
      return updateZoneOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteZone. */
    public UnaryCallSettings.Builder<DeleteZoneRequest, Operation> deleteZoneSettings() {
      return deleteZoneSettings;
    }

    /** Returns the builder for the settings used for calls to deleteZone. */
    public OperationCallSettings.Builder<DeleteZoneRequest, Empty, OperationMetadata>
        deleteZoneOperationSettings() {
      return deleteZoneOperationSettings;
    }

    /** Returns the builder for the settings used for calls to signalZoneState. */
    public UnaryCallSettings.Builder<SignalZoneStateRequest, Operation> signalZoneStateSettings() {
      return signalZoneStateSettings;
    }

    /** Returns the builder for the settings used for calls to signalZoneState. */
    public OperationCallSettings.Builder<SignalZoneStateRequest, Zone, OperationMetadata>
        signalZoneStateOperationSettings() {
      return signalZoneStateOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    @Override
    public GDCHardwareManagementStubSettings build() throws IOException {
      return new GDCHardwareManagementStubSettings(this);
    }
  }
}
