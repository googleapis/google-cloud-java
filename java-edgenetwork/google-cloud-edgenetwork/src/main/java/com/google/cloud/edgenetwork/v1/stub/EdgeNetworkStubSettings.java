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

package com.google.cloud.edgenetwork.v1.stub;

import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListInterconnectAttachmentsPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListInterconnectsPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListLocationsPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListNetworksPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListRoutersPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListSubnetsPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListZonesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
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
import com.google.cloud.edgenetwork.v1.CreateInterconnectAttachmentRequest;
import com.google.cloud.edgenetwork.v1.CreateNetworkRequest;
import com.google.cloud.edgenetwork.v1.CreateRouterRequest;
import com.google.cloud.edgenetwork.v1.CreateSubnetRequest;
import com.google.cloud.edgenetwork.v1.DeleteInterconnectAttachmentRequest;
import com.google.cloud.edgenetwork.v1.DeleteNetworkRequest;
import com.google.cloud.edgenetwork.v1.DeleteRouterRequest;
import com.google.cloud.edgenetwork.v1.DeleteSubnetRequest;
import com.google.cloud.edgenetwork.v1.DiagnoseInterconnectRequest;
import com.google.cloud.edgenetwork.v1.DiagnoseInterconnectResponse;
import com.google.cloud.edgenetwork.v1.DiagnoseNetworkRequest;
import com.google.cloud.edgenetwork.v1.DiagnoseNetworkResponse;
import com.google.cloud.edgenetwork.v1.DiagnoseRouterRequest;
import com.google.cloud.edgenetwork.v1.DiagnoseRouterResponse;
import com.google.cloud.edgenetwork.v1.GetInterconnectAttachmentRequest;
import com.google.cloud.edgenetwork.v1.GetInterconnectRequest;
import com.google.cloud.edgenetwork.v1.GetNetworkRequest;
import com.google.cloud.edgenetwork.v1.GetRouterRequest;
import com.google.cloud.edgenetwork.v1.GetSubnetRequest;
import com.google.cloud.edgenetwork.v1.GetZoneRequest;
import com.google.cloud.edgenetwork.v1.InitializeZoneRequest;
import com.google.cloud.edgenetwork.v1.InitializeZoneResponse;
import com.google.cloud.edgenetwork.v1.Interconnect;
import com.google.cloud.edgenetwork.v1.InterconnectAttachment;
import com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsRequest;
import com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsResponse;
import com.google.cloud.edgenetwork.v1.ListInterconnectsRequest;
import com.google.cloud.edgenetwork.v1.ListInterconnectsResponse;
import com.google.cloud.edgenetwork.v1.ListNetworksRequest;
import com.google.cloud.edgenetwork.v1.ListNetworksResponse;
import com.google.cloud.edgenetwork.v1.ListRoutersRequest;
import com.google.cloud.edgenetwork.v1.ListRoutersResponse;
import com.google.cloud.edgenetwork.v1.ListSubnetsRequest;
import com.google.cloud.edgenetwork.v1.ListSubnetsResponse;
import com.google.cloud.edgenetwork.v1.ListZonesRequest;
import com.google.cloud.edgenetwork.v1.ListZonesResponse;
import com.google.cloud.edgenetwork.v1.Network;
import com.google.cloud.edgenetwork.v1.OperationMetadata;
import com.google.cloud.edgenetwork.v1.Router;
import com.google.cloud.edgenetwork.v1.Subnet;
import com.google.cloud.edgenetwork.v1.UpdateRouterRequest;
import com.google.cloud.edgenetwork.v1.UpdateSubnetRequest;
import com.google.cloud.edgenetwork.v1.Zone;
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
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link EdgeNetworkStub}.
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
 * EdgeNetworkStubSettings.Builder edgeNetworkSettingsBuilder =
 *     EdgeNetworkStubSettings.newBuilder();
 * edgeNetworkSettingsBuilder
 *     .initializeZoneSettings()
 *     .setRetrySettings(
 *         edgeNetworkSettingsBuilder
 *             .initializeZoneSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * EdgeNetworkStubSettings edgeNetworkSettings = edgeNetworkSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class EdgeNetworkStubSettings extends StubSettings<EdgeNetworkStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<InitializeZoneRequest, InitializeZoneResponse>
      initializeZoneSettings;
  private final PagedCallSettings<ListZonesRequest, ListZonesResponse, ListZonesPagedResponse>
      listZonesSettings;
  private final UnaryCallSettings<GetZoneRequest, Zone> getZoneSettings;
  private final PagedCallSettings<
          ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>
      listNetworksSettings;
  private final UnaryCallSettings<GetNetworkRequest, Network> getNetworkSettings;
  private final UnaryCallSettings<DiagnoseNetworkRequest, DiagnoseNetworkResponse>
      diagnoseNetworkSettings;
  private final UnaryCallSettings<CreateNetworkRequest, Operation> createNetworkSettings;
  private final OperationCallSettings<CreateNetworkRequest, Network, OperationMetadata>
      createNetworkOperationSettings;
  private final UnaryCallSettings<DeleteNetworkRequest, Operation> deleteNetworkSettings;
  private final OperationCallSettings<DeleteNetworkRequest, Empty, OperationMetadata>
      deleteNetworkOperationSettings;
  private final PagedCallSettings<ListSubnetsRequest, ListSubnetsResponse, ListSubnetsPagedResponse>
      listSubnetsSettings;
  private final UnaryCallSettings<GetSubnetRequest, Subnet> getSubnetSettings;
  private final UnaryCallSettings<CreateSubnetRequest, Operation> createSubnetSettings;
  private final OperationCallSettings<CreateSubnetRequest, Subnet, OperationMetadata>
      createSubnetOperationSettings;
  private final UnaryCallSettings<UpdateSubnetRequest, Operation> updateSubnetSettings;
  private final OperationCallSettings<UpdateSubnetRequest, Subnet, OperationMetadata>
      updateSubnetOperationSettings;
  private final UnaryCallSettings<DeleteSubnetRequest, Operation> deleteSubnetSettings;
  private final OperationCallSettings<DeleteSubnetRequest, Empty, OperationMetadata>
      deleteSubnetOperationSettings;
  private final PagedCallSettings<
          ListInterconnectsRequest, ListInterconnectsResponse, ListInterconnectsPagedResponse>
      listInterconnectsSettings;
  private final UnaryCallSettings<GetInterconnectRequest, Interconnect> getInterconnectSettings;
  private final UnaryCallSettings<DiagnoseInterconnectRequest, DiagnoseInterconnectResponse>
      diagnoseInterconnectSettings;
  private final PagedCallSettings<
          ListInterconnectAttachmentsRequest,
          ListInterconnectAttachmentsResponse,
          ListInterconnectAttachmentsPagedResponse>
      listInterconnectAttachmentsSettings;
  private final UnaryCallSettings<GetInterconnectAttachmentRequest, InterconnectAttachment>
      getInterconnectAttachmentSettings;
  private final UnaryCallSettings<CreateInterconnectAttachmentRequest, Operation>
      createInterconnectAttachmentSettings;
  private final OperationCallSettings<
          CreateInterconnectAttachmentRequest, InterconnectAttachment, OperationMetadata>
      createInterconnectAttachmentOperationSettings;
  private final UnaryCallSettings<DeleteInterconnectAttachmentRequest, Operation>
      deleteInterconnectAttachmentSettings;
  private final OperationCallSettings<DeleteInterconnectAttachmentRequest, Empty, OperationMetadata>
      deleteInterconnectAttachmentOperationSettings;
  private final PagedCallSettings<ListRoutersRequest, ListRoutersResponse, ListRoutersPagedResponse>
      listRoutersSettings;
  private final UnaryCallSettings<GetRouterRequest, Router> getRouterSettings;
  private final UnaryCallSettings<DiagnoseRouterRequest, DiagnoseRouterResponse>
      diagnoseRouterSettings;
  private final UnaryCallSettings<CreateRouterRequest, Operation> createRouterSettings;
  private final OperationCallSettings<CreateRouterRequest, Router, OperationMetadata>
      createRouterOperationSettings;
  private final UnaryCallSettings<UpdateRouterRequest, Operation> updateRouterSettings;
  private final OperationCallSettings<UpdateRouterRequest, Router, OperationMetadata>
      updateRouterOperationSettings;
  private final UnaryCallSettings<DeleteRouterRequest, Operation> deleteRouterSettings;
  private final OperationCallSettings<DeleteRouterRequest, Empty, OperationMetadata>
      deleteRouterOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

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
              return payload.getZonesList() == null
                  ? ImmutableList.<Zone>of()
                  : payload.getZonesList();
            }
          };

  private static final PagedListDescriptor<ListNetworksRequest, ListNetworksResponse, Network>
      LIST_NETWORKS_PAGE_STR_DESC =
          new PagedListDescriptor<ListNetworksRequest, ListNetworksResponse, Network>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNetworksRequest injectToken(ListNetworksRequest payload, String token) {
              return ListNetworksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNetworksRequest injectPageSize(ListNetworksRequest payload, int pageSize) {
              return ListNetworksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListNetworksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListNetworksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Network> extractResources(ListNetworksResponse payload) {
              return payload.getNetworksList() == null
                  ? ImmutableList.<Network>of()
                  : payload.getNetworksList();
            }
          };

  private static final PagedListDescriptor<ListSubnetsRequest, ListSubnetsResponse, Subnet>
      LIST_SUBNETS_PAGE_STR_DESC =
          new PagedListDescriptor<ListSubnetsRequest, ListSubnetsResponse, Subnet>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSubnetsRequest injectToken(ListSubnetsRequest payload, String token) {
              return ListSubnetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSubnetsRequest injectPageSize(ListSubnetsRequest payload, int pageSize) {
              return ListSubnetsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSubnetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSubnetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Subnet> extractResources(ListSubnetsResponse payload) {
              return payload.getSubnetsList() == null
                  ? ImmutableList.<Subnet>of()
                  : payload.getSubnetsList();
            }
          };

  private static final PagedListDescriptor<
          ListInterconnectsRequest, ListInterconnectsResponse, Interconnect>
      LIST_INTERCONNECTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListInterconnectsRequest, ListInterconnectsResponse, Interconnect>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInterconnectsRequest injectToken(
                ListInterconnectsRequest payload, String token) {
              return ListInterconnectsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListInterconnectsRequest injectPageSize(
                ListInterconnectsRequest payload, int pageSize) {
              return ListInterconnectsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListInterconnectsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListInterconnectsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Interconnect> extractResources(ListInterconnectsResponse payload) {
              return payload.getInterconnectsList() == null
                  ? ImmutableList.<Interconnect>of()
                  : payload.getInterconnectsList();
            }
          };

  private static final PagedListDescriptor<
          ListInterconnectAttachmentsRequest,
          ListInterconnectAttachmentsResponse,
          InterconnectAttachment>
      LIST_INTERCONNECT_ATTACHMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListInterconnectAttachmentsRequest,
              ListInterconnectAttachmentsResponse,
              InterconnectAttachment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInterconnectAttachmentsRequest injectToken(
                ListInterconnectAttachmentsRequest payload, String token) {
              return ListInterconnectAttachmentsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListInterconnectAttachmentsRequest injectPageSize(
                ListInterconnectAttachmentsRequest payload, int pageSize) {
              return ListInterconnectAttachmentsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListInterconnectAttachmentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListInterconnectAttachmentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<InterconnectAttachment> extractResources(
                ListInterconnectAttachmentsResponse payload) {
              return payload.getInterconnectAttachmentsList() == null
                  ? ImmutableList.<InterconnectAttachment>of()
                  : payload.getInterconnectAttachmentsList();
            }
          };

  private static final PagedListDescriptor<ListRoutersRequest, ListRoutersResponse, Router>
      LIST_ROUTERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListRoutersRequest, ListRoutersResponse, Router>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRoutersRequest injectToken(ListRoutersRequest payload, String token) {
              return ListRoutersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRoutersRequest injectPageSize(ListRoutersRequest payload, int pageSize) {
              return ListRoutersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRoutersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRoutersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Router> extractResources(ListRoutersResponse payload) {
              return payload.getRoutersList() == null
                  ? ImmutableList.<Router>of()
                  : payload.getRoutersList();
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
              return payload.getLocationsList() == null
                  ? ImmutableList.<Location>of()
                  : payload.getLocationsList();
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
          ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>
      LIST_NETWORKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>() {
            @Override
            public ApiFuture<ListNetworksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNetworksRequest, ListNetworksResponse> callable,
                ListNetworksRequest request,
                ApiCallContext context,
                ApiFuture<ListNetworksResponse> futureResponse) {
              PageContext<ListNetworksRequest, ListNetworksResponse, Network> pageContext =
                  PageContext.create(callable, LIST_NETWORKS_PAGE_STR_DESC, request, context);
              return ListNetworksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSubnetsRequest, ListSubnetsResponse, ListSubnetsPagedResponse>
      LIST_SUBNETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSubnetsRequest, ListSubnetsResponse, ListSubnetsPagedResponse>() {
            @Override
            public ApiFuture<ListSubnetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSubnetsRequest, ListSubnetsResponse> callable,
                ListSubnetsRequest request,
                ApiCallContext context,
                ApiFuture<ListSubnetsResponse> futureResponse) {
              PageContext<ListSubnetsRequest, ListSubnetsResponse, Subnet> pageContext =
                  PageContext.create(callable, LIST_SUBNETS_PAGE_STR_DESC, request, context);
              return ListSubnetsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListInterconnectsRequest, ListInterconnectsResponse, ListInterconnectsPagedResponse>
      LIST_INTERCONNECTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInterconnectsRequest,
              ListInterconnectsResponse,
              ListInterconnectsPagedResponse>() {
            @Override
            public ApiFuture<ListInterconnectsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListInterconnectsRequest, ListInterconnectsResponse> callable,
                ListInterconnectsRequest request,
                ApiCallContext context,
                ApiFuture<ListInterconnectsResponse> futureResponse) {
              PageContext<ListInterconnectsRequest, ListInterconnectsResponse, Interconnect>
                  pageContext =
                      PageContext.create(
                          callable, LIST_INTERCONNECTS_PAGE_STR_DESC, request, context);
              return ListInterconnectsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListInterconnectAttachmentsRequest,
          ListInterconnectAttachmentsResponse,
          ListInterconnectAttachmentsPagedResponse>
      LIST_INTERCONNECT_ATTACHMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInterconnectAttachmentsRequest,
              ListInterconnectAttachmentsResponse,
              ListInterconnectAttachmentsPagedResponse>() {
            @Override
            public ApiFuture<ListInterconnectAttachmentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListInterconnectAttachmentsRequest, ListInterconnectAttachmentsResponse>
                    callable,
                ListInterconnectAttachmentsRequest request,
                ApiCallContext context,
                ApiFuture<ListInterconnectAttachmentsResponse> futureResponse) {
              PageContext<
                      ListInterconnectAttachmentsRequest,
                      ListInterconnectAttachmentsResponse,
                      InterconnectAttachment>
                  pageContext =
                      PageContext.create(
                          callable, LIST_INTERCONNECT_ATTACHMENTS_PAGE_STR_DESC, request, context);
              return ListInterconnectAttachmentsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListRoutersRequest, ListRoutersResponse, ListRoutersPagedResponse>
      LIST_ROUTERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRoutersRequest, ListRoutersResponse, ListRoutersPagedResponse>() {
            @Override
            public ApiFuture<ListRoutersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRoutersRequest, ListRoutersResponse> callable,
                ListRoutersRequest request,
                ApiCallContext context,
                ApiFuture<ListRoutersResponse> futureResponse) {
              PageContext<ListRoutersRequest, ListRoutersResponse, Router> pageContext =
                  PageContext.create(callable, LIST_ROUTERS_PAGE_STR_DESC, request, context);
              return ListRoutersPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to initializeZone. */
  public UnaryCallSettings<InitializeZoneRequest, InitializeZoneResponse> initializeZoneSettings() {
    return initializeZoneSettings;
  }

  /**
   * Returns the object with the settings used for calls to listZones.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public PagedCallSettings<ListZonesRequest, ListZonesResponse, ListZonesPagedResponse>
      listZonesSettings() {
    return listZonesSettings;
  }

  /**
   * Returns the object with the settings used for calls to getZone.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<GetZoneRequest, Zone> getZoneSettings() {
    return getZoneSettings;
  }

  /** Returns the object with the settings used for calls to listNetworks. */
  public PagedCallSettings<ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>
      listNetworksSettings() {
    return listNetworksSettings;
  }

  /** Returns the object with the settings used for calls to getNetwork. */
  public UnaryCallSettings<GetNetworkRequest, Network> getNetworkSettings() {
    return getNetworkSettings;
  }

  /** Returns the object with the settings used for calls to diagnoseNetwork. */
  public UnaryCallSettings<DiagnoseNetworkRequest, DiagnoseNetworkResponse>
      diagnoseNetworkSettings() {
    return diagnoseNetworkSettings;
  }

  /** Returns the object with the settings used for calls to createNetwork. */
  public UnaryCallSettings<CreateNetworkRequest, Operation> createNetworkSettings() {
    return createNetworkSettings;
  }

  /** Returns the object with the settings used for calls to createNetwork. */
  public OperationCallSettings<CreateNetworkRequest, Network, OperationMetadata>
      createNetworkOperationSettings() {
    return createNetworkOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteNetwork. */
  public UnaryCallSettings<DeleteNetworkRequest, Operation> deleteNetworkSettings() {
    return deleteNetworkSettings;
  }

  /** Returns the object with the settings used for calls to deleteNetwork. */
  public OperationCallSettings<DeleteNetworkRequest, Empty, OperationMetadata>
      deleteNetworkOperationSettings() {
    return deleteNetworkOperationSettings;
  }

  /** Returns the object with the settings used for calls to listSubnets. */
  public PagedCallSettings<ListSubnetsRequest, ListSubnetsResponse, ListSubnetsPagedResponse>
      listSubnetsSettings() {
    return listSubnetsSettings;
  }

  /** Returns the object with the settings used for calls to getSubnet. */
  public UnaryCallSettings<GetSubnetRequest, Subnet> getSubnetSettings() {
    return getSubnetSettings;
  }

  /** Returns the object with the settings used for calls to createSubnet. */
  public UnaryCallSettings<CreateSubnetRequest, Operation> createSubnetSettings() {
    return createSubnetSettings;
  }

  /** Returns the object with the settings used for calls to createSubnet. */
  public OperationCallSettings<CreateSubnetRequest, Subnet, OperationMetadata>
      createSubnetOperationSettings() {
    return createSubnetOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateSubnet. */
  public UnaryCallSettings<UpdateSubnetRequest, Operation> updateSubnetSettings() {
    return updateSubnetSettings;
  }

  /** Returns the object with the settings used for calls to updateSubnet. */
  public OperationCallSettings<UpdateSubnetRequest, Subnet, OperationMetadata>
      updateSubnetOperationSettings() {
    return updateSubnetOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteSubnet. */
  public UnaryCallSettings<DeleteSubnetRequest, Operation> deleteSubnetSettings() {
    return deleteSubnetSettings;
  }

  /** Returns the object with the settings used for calls to deleteSubnet. */
  public OperationCallSettings<DeleteSubnetRequest, Empty, OperationMetadata>
      deleteSubnetOperationSettings() {
    return deleteSubnetOperationSettings;
  }

  /** Returns the object with the settings used for calls to listInterconnects. */
  public PagedCallSettings<
          ListInterconnectsRequest, ListInterconnectsResponse, ListInterconnectsPagedResponse>
      listInterconnectsSettings() {
    return listInterconnectsSettings;
  }

  /** Returns the object with the settings used for calls to getInterconnect. */
  public UnaryCallSettings<GetInterconnectRequest, Interconnect> getInterconnectSettings() {
    return getInterconnectSettings;
  }

  /** Returns the object with the settings used for calls to diagnoseInterconnect. */
  public UnaryCallSettings<DiagnoseInterconnectRequest, DiagnoseInterconnectResponse>
      diagnoseInterconnectSettings() {
    return diagnoseInterconnectSettings;
  }

  /** Returns the object with the settings used for calls to listInterconnectAttachments. */
  public PagedCallSettings<
          ListInterconnectAttachmentsRequest,
          ListInterconnectAttachmentsResponse,
          ListInterconnectAttachmentsPagedResponse>
      listInterconnectAttachmentsSettings() {
    return listInterconnectAttachmentsSettings;
  }

  /** Returns the object with the settings used for calls to getInterconnectAttachment. */
  public UnaryCallSettings<GetInterconnectAttachmentRequest, InterconnectAttachment>
      getInterconnectAttachmentSettings() {
    return getInterconnectAttachmentSettings;
  }

  /** Returns the object with the settings used for calls to createInterconnectAttachment. */
  public UnaryCallSettings<CreateInterconnectAttachmentRequest, Operation>
      createInterconnectAttachmentSettings() {
    return createInterconnectAttachmentSettings;
  }

  /** Returns the object with the settings used for calls to createInterconnectAttachment. */
  public OperationCallSettings<
          CreateInterconnectAttachmentRequest, InterconnectAttachment, OperationMetadata>
      createInterconnectAttachmentOperationSettings() {
    return createInterconnectAttachmentOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteInterconnectAttachment. */
  public UnaryCallSettings<DeleteInterconnectAttachmentRequest, Operation>
      deleteInterconnectAttachmentSettings() {
    return deleteInterconnectAttachmentSettings;
  }

  /** Returns the object with the settings used for calls to deleteInterconnectAttachment. */
  public OperationCallSettings<DeleteInterconnectAttachmentRequest, Empty, OperationMetadata>
      deleteInterconnectAttachmentOperationSettings() {
    return deleteInterconnectAttachmentOperationSettings;
  }

  /** Returns the object with the settings used for calls to listRouters. */
  public PagedCallSettings<ListRoutersRequest, ListRoutersResponse, ListRoutersPagedResponse>
      listRoutersSettings() {
    return listRoutersSettings;
  }

  /** Returns the object with the settings used for calls to getRouter. */
  public UnaryCallSettings<GetRouterRequest, Router> getRouterSettings() {
    return getRouterSettings;
  }

  /** Returns the object with the settings used for calls to diagnoseRouter. */
  public UnaryCallSettings<DiagnoseRouterRequest, DiagnoseRouterResponse> diagnoseRouterSettings() {
    return diagnoseRouterSettings;
  }

  /** Returns the object with the settings used for calls to createRouter. */
  public UnaryCallSettings<CreateRouterRequest, Operation> createRouterSettings() {
    return createRouterSettings;
  }

  /** Returns the object with the settings used for calls to createRouter. */
  public OperationCallSettings<CreateRouterRequest, Router, OperationMetadata>
      createRouterOperationSettings() {
    return createRouterOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateRouter. */
  public UnaryCallSettings<UpdateRouterRequest, Operation> updateRouterSettings() {
    return updateRouterSettings;
  }

  /** Returns the object with the settings used for calls to updateRouter. */
  public OperationCallSettings<UpdateRouterRequest, Router, OperationMetadata>
      updateRouterOperationSettings() {
    return updateRouterOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteRouter. */
  public UnaryCallSettings<DeleteRouterRequest, Operation> deleteRouterSettings() {
    return deleteRouterSettings;
  }

  /** Returns the object with the settings used for calls to deleteRouter. */
  public OperationCallSettings<DeleteRouterRequest, Empty, OperationMetadata>
      deleteRouterOperationSettings() {
    return deleteRouterOperationSettings;
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

  public EdgeNetworkStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcEdgeNetworkStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonEdgeNetworkStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "edgenetwork";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "edgenetwork.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "edgenetwork.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(EdgeNetworkStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(EdgeNetworkStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return EdgeNetworkStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected EdgeNetworkStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    initializeZoneSettings = settingsBuilder.initializeZoneSettings().build();
    listZonesSettings = settingsBuilder.listZonesSettings().build();
    getZoneSettings = settingsBuilder.getZoneSettings().build();
    listNetworksSettings = settingsBuilder.listNetworksSettings().build();
    getNetworkSettings = settingsBuilder.getNetworkSettings().build();
    diagnoseNetworkSettings = settingsBuilder.diagnoseNetworkSettings().build();
    createNetworkSettings = settingsBuilder.createNetworkSettings().build();
    createNetworkOperationSettings = settingsBuilder.createNetworkOperationSettings().build();
    deleteNetworkSettings = settingsBuilder.deleteNetworkSettings().build();
    deleteNetworkOperationSettings = settingsBuilder.deleteNetworkOperationSettings().build();
    listSubnetsSettings = settingsBuilder.listSubnetsSettings().build();
    getSubnetSettings = settingsBuilder.getSubnetSettings().build();
    createSubnetSettings = settingsBuilder.createSubnetSettings().build();
    createSubnetOperationSettings = settingsBuilder.createSubnetOperationSettings().build();
    updateSubnetSettings = settingsBuilder.updateSubnetSettings().build();
    updateSubnetOperationSettings = settingsBuilder.updateSubnetOperationSettings().build();
    deleteSubnetSettings = settingsBuilder.deleteSubnetSettings().build();
    deleteSubnetOperationSettings = settingsBuilder.deleteSubnetOperationSettings().build();
    listInterconnectsSettings = settingsBuilder.listInterconnectsSettings().build();
    getInterconnectSettings = settingsBuilder.getInterconnectSettings().build();
    diagnoseInterconnectSettings = settingsBuilder.diagnoseInterconnectSettings().build();
    listInterconnectAttachmentsSettings =
        settingsBuilder.listInterconnectAttachmentsSettings().build();
    getInterconnectAttachmentSettings = settingsBuilder.getInterconnectAttachmentSettings().build();
    createInterconnectAttachmentSettings =
        settingsBuilder.createInterconnectAttachmentSettings().build();
    createInterconnectAttachmentOperationSettings =
        settingsBuilder.createInterconnectAttachmentOperationSettings().build();
    deleteInterconnectAttachmentSettings =
        settingsBuilder.deleteInterconnectAttachmentSettings().build();
    deleteInterconnectAttachmentOperationSettings =
        settingsBuilder.deleteInterconnectAttachmentOperationSettings().build();
    listRoutersSettings = settingsBuilder.listRoutersSettings().build();
    getRouterSettings = settingsBuilder.getRouterSettings().build();
    diagnoseRouterSettings = settingsBuilder.diagnoseRouterSettings().build();
    createRouterSettings = settingsBuilder.createRouterSettings().build();
    createRouterOperationSettings = settingsBuilder.createRouterOperationSettings().build();
    updateRouterSettings = settingsBuilder.updateRouterSettings().build();
    updateRouterOperationSettings = settingsBuilder.updateRouterOperationSettings().build();
    deleteRouterSettings = settingsBuilder.deleteRouterSettings().build();
    deleteRouterOperationSettings = settingsBuilder.deleteRouterOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for EdgeNetworkStubSettings. */
  public static class Builder extends StubSettings.Builder<EdgeNetworkStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<InitializeZoneRequest, InitializeZoneResponse>
        initializeZoneSettings;
    private final PagedCallSettings.Builder<
            ListZonesRequest, ListZonesResponse, ListZonesPagedResponse>
        listZonesSettings;
    private final UnaryCallSettings.Builder<GetZoneRequest, Zone> getZoneSettings;
    private final PagedCallSettings.Builder<
            ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>
        listNetworksSettings;
    private final UnaryCallSettings.Builder<GetNetworkRequest, Network> getNetworkSettings;
    private final UnaryCallSettings.Builder<DiagnoseNetworkRequest, DiagnoseNetworkResponse>
        diagnoseNetworkSettings;
    private final UnaryCallSettings.Builder<CreateNetworkRequest, Operation> createNetworkSettings;
    private final OperationCallSettings.Builder<CreateNetworkRequest, Network, OperationMetadata>
        createNetworkOperationSettings;
    private final UnaryCallSettings.Builder<DeleteNetworkRequest, Operation> deleteNetworkSettings;
    private final OperationCallSettings.Builder<DeleteNetworkRequest, Empty, OperationMetadata>
        deleteNetworkOperationSettings;
    private final PagedCallSettings.Builder<
            ListSubnetsRequest, ListSubnetsResponse, ListSubnetsPagedResponse>
        listSubnetsSettings;
    private final UnaryCallSettings.Builder<GetSubnetRequest, Subnet> getSubnetSettings;
    private final UnaryCallSettings.Builder<CreateSubnetRequest, Operation> createSubnetSettings;
    private final OperationCallSettings.Builder<CreateSubnetRequest, Subnet, OperationMetadata>
        createSubnetOperationSettings;
    private final UnaryCallSettings.Builder<UpdateSubnetRequest, Operation> updateSubnetSettings;
    private final OperationCallSettings.Builder<UpdateSubnetRequest, Subnet, OperationMetadata>
        updateSubnetOperationSettings;
    private final UnaryCallSettings.Builder<DeleteSubnetRequest, Operation> deleteSubnetSettings;
    private final OperationCallSettings.Builder<DeleteSubnetRequest, Empty, OperationMetadata>
        deleteSubnetOperationSettings;
    private final PagedCallSettings.Builder<
            ListInterconnectsRequest, ListInterconnectsResponse, ListInterconnectsPagedResponse>
        listInterconnectsSettings;
    private final UnaryCallSettings.Builder<GetInterconnectRequest, Interconnect>
        getInterconnectSettings;
    private final UnaryCallSettings.Builder<
            DiagnoseInterconnectRequest, DiagnoseInterconnectResponse>
        diagnoseInterconnectSettings;
    private final PagedCallSettings.Builder<
            ListInterconnectAttachmentsRequest,
            ListInterconnectAttachmentsResponse,
            ListInterconnectAttachmentsPagedResponse>
        listInterconnectAttachmentsSettings;
    private final UnaryCallSettings.Builder<
            GetInterconnectAttachmentRequest, InterconnectAttachment>
        getInterconnectAttachmentSettings;
    private final UnaryCallSettings.Builder<CreateInterconnectAttachmentRequest, Operation>
        createInterconnectAttachmentSettings;
    private final OperationCallSettings.Builder<
            CreateInterconnectAttachmentRequest, InterconnectAttachment, OperationMetadata>
        createInterconnectAttachmentOperationSettings;
    private final UnaryCallSettings.Builder<DeleteInterconnectAttachmentRequest, Operation>
        deleteInterconnectAttachmentSettings;
    private final OperationCallSettings.Builder<
            DeleteInterconnectAttachmentRequest, Empty, OperationMetadata>
        deleteInterconnectAttachmentOperationSettings;
    private final PagedCallSettings.Builder<
            ListRoutersRequest, ListRoutersResponse, ListRoutersPagedResponse>
        listRoutersSettings;
    private final UnaryCallSettings.Builder<GetRouterRequest, Router> getRouterSettings;
    private final UnaryCallSettings.Builder<DiagnoseRouterRequest, DiagnoseRouterResponse>
        diagnoseRouterSettings;
    private final UnaryCallSettings.Builder<CreateRouterRequest, Operation> createRouterSettings;
    private final OperationCallSettings.Builder<CreateRouterRequest, Router, OperationMetadata>
        createRouterOperationSettings;
    private final UnaryCallSettings.Builder<UpdateRouterRequest, Operation> updateRouterSettings;
    private final OperationCallSettings.Builder<UpdateRouterRequest, Router, OperationMetadata>
        updateRouterOperationSettings;
    private final UnaryCallSettings.Builder<DeleteRouterRequest, Operation> deleteRouterSettings;
    private final OperationCallSettings.Builder<DeleteRouterRequest, Empty, OperationMetadata>
        deleteRouterOperationSettings;
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
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      initializeZoneSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listZonesSettings = PagedCallSettings.newBuilder(LIST_ZONES_PAGE_STR_FACT);
      getZoneSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listNetworksSettings = PagedCallSettings.newBuilder(LIST_NETWORKS_PAGE_STR_FACT);
      getNetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      diagnoseNetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createNetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createNetworkOperationSettings = OperationCallSettings.newBuilder();
      deleteNetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteNetworkOperationSettings = OperationCallSettings.newBuilder();
      listSubnetsSettings = PagedCallSettings.newBuilder(LIST_SUBNETS_PAGE_STR_FACT);
      getSubnetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSubnetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSubnetOperationSettings = OperationCallSettings.newBuilder();
      updateSubnetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSubnetOperationSettings = OperationCallSettings.newBuilder();
      deleteSubnetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSubnetOperationSettings = OperationCallSettings.newBuilder();
      listInterconnectsSettings = PagedCallSettings.newBuilder(LIST_INTERCONNECTS_PAGE_STR_FACT);
      getInterconnectSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      diagnoseInterconnectSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listInterconnectAttachmentsSettings =
          PagedCallSettings.newBuilder(LIST_INTERCONNECT_ATTACHMENTS_PAGE_STR_FACT);
      getInterconnectAttachmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInterconnectAttachmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInterconnectAttachmentOperationSettings = OperationCallSettings.newBuilder();
      deleteInterconnectAttachmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteInterconnectAttachmentOperationSettings = OperationCallSettings.newBuilder();
      listRoutersSettings = PagedCallSettings.newBuilder(LIST_ROUTERS_PAGE_STR_FACT);
      getRouterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      diagnoseRouterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createRouterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createRouterOperationSettings = OperationCallSettings.newBuilder();
      updateRouterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateRouterOperationSettings = OperationCallSettings.newBuilder();
      deleteRouterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteRouterOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              initializeZoneSettings,
              listZonesSettings,
              getZoneSettings,
              listNetworksSettings,
              getNetworkSettings,
              diagnoseNetworkSettings,
              createNetworkSettings,
              deleteNetworkSettings,
              listSubnetsSettings,
              getSubnetSettings,
              createSubnetSettings,
              updateSubnetSettings,
              deleteSubnetSettings,
              listInterconnectsSettings,
              getInterconnectSettings,
              diagnoseInterconnectSettings,
              listInterconnectAttachmentsSettings,
              getInterconnectAttachmentSettings,
              createInterconnectAttachmentSettings,
              deleteInterconnectAttachmentSettings,
              listRoutersSettings,
              getRouterSettings,
              diagnoseRouterSettings,
              createRouterSettings,
              updateRouterSettings,
              deleteRouterSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(EdgeNetworkStubSettings settings) {
      super(settings);

      initializeZoneSettings = settings.initializeZoneSettings.toBuilder();
      listZonesSettings = settings.listZonesSettings.toBuilder();
      getZoneSettings = settings.getZoneSettings.toBuilder();
      listNetworksSettings = settings.listNetworksSettings.toBuilder();
      getNetworkSettings = settings.getNetworkSettings.toBuilder();
      diagnoseNetworkSettings = settings.diagnoseNetworkSettings.toBuilder();
      createNetworkSettings = settings.createNetworkSettings.toBuilder();
      createNetworkOperationSettings = settings.createNetworkOperationSettings.toBuilder();
      deleteNetworkSettings = settings.deleteNetworkSettings.toBuilder();
      deleteNetworkOperationSettings = settings.deleteNetworkOperationSettings.toBuilder();
      listSubnetsSettings = settings.listSubnetsSettings.toBuilder();
      getSubnetSettings = settings.getSubnetSettings.toBuilder();
      createSubnetSettings = settings.createSubnetSettings.toBuilder();
      createSubnetOperationSettings = settings.createSubnetOperationSettings.toBuilder();
      updateSubnetSettings = settings.updateSubnetSettings.toBuilder();
      updateSubnetOperationSettings = settings.updateSubnetOperationSettings.toBuilder();
      deleteSubnetSettings = settings.deleteSubnetSettings.toBuilder();
      deleteSubnetOperationSettings = settings.deleteSubnetOperationSettings.toBuilder();
      listInterconnectsSettings = settings.listInterconnectsSettings.toBuilder();
      getInterconnectSettings = settings.getInterconnectSettings.toBuilder();
      diagnoseInterconnectSettings = settings.diagnoseInterconnectSettings.toBuilder();
      listInterconnectAttachmentsSettings =
          settings.listInterconnectAttachmentsSettings.toBuilder();
      getInterconnectAttachmentSettings = settings.getInterconnectAttachmentSettings.toBuilder();
      createInterconnectAttachmentSettings =
          settings.createInterconnectAttachmentSettings.toBuilder();
      createInterconnectAttachmentOperationSettings =
          settings.createInterconnectAttachmentOperationSettings.toBuilder();
      deleteInterconnectAttachmentSettings =
          settings.deleteInterconnectAttachmentSettings.toBuilder();
      deleteInterconnectAttachmentOperationSettings =
          settings.deleteInterconnectAttachmentOperationSettings.toBuilder();
      listRoutersSettings = settings.listRoutersSettings.toBuilder();
      getRouterSettings = settings.getRouterSettings.toBuilder();
      diagnoseRouterSettings = settings.diagnoseRouterSettings.toBuilder();
      createRouterSettings = settings.createRouterSettings.toBuilder();
      createRouterOperationSettings = settings.createRouterOperationSettings.toBuilder();
      updateRouterSettings = settings.updateRouterSettings.toBuilder();
      updateRouterOperationSettings = settings.updateRouterOperationSettings.toBuilder();
      deleteRouterSettings = settings.deleteRouterSettings.toBuilder();
      deleteRouterOperationSettings = settings.deleteRouterOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              initializeZoneSettings,
              listZonesSettings,
              getZoneSettings,
              listNetworksSettings,
              getNetworkSettings,
              diagnoseNetworkSettings,
              createNetworkSettings,
              deleteNetworkSettings,
              listSubnetsSettings,
              getSubnetSettings,
              createSubnetSettings,
              updateSubnetSettings,
              deleteSubnetSettings,
              listInterconnectsSettings,
              getInterconnectSettings,
              diagnoseInterconnectSettings,
              listInterconnectAttachmentsSettings,
              getInterconnectAttachmentSettings,
              createInterconnectAttachmentSettings,
              deleteInterconnectAttachmentSettings,
              listRoutersSettings,
              getRouterSettings,
              diagnoseRouterSettings,
              createRouterSettings,
              updateRouterSettings,
              deleteRouterSettings,
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
          .initializeZoneSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listZonesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getZoneSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listNetworksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getNetworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .diagnoseNetworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createNetworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteNetworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listSubnetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getSubnetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createSubnetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateSubnetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteSubnetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listInterconnectsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getInterconnectSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .diagnoseInterconnectSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listInterconnectAttachmentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getInterconnectAttachmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createInterconnectAttachmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteInterconnectAttachmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listRoutersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getRouterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .diagnoseRouterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createRouterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateRouterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteRouterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createNetworkOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateNetworkRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Network.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteNetworkOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteNetworkRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createSubnetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateSubnetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Subnet.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateSubnetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateSubnetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Subnet.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteSubnetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteSubnetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createInterconnectAttachmentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateInterconnectAttachmentRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(InterconnectAttachment.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteInterconnectAttachmentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteInterconnectAttachmentRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createRouterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateRouterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Router.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateRouterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateRouterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Router.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteRouterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteRouterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
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

    /** Returns the builder for the settings used for calls to initializeZone. */
    public UnaryCallSettings.Builder<InitializeZoneRequest, InitializeZoneResponse>
        initializeZoneSettings() {
      return initializeZoneSettings;
    }

    /**
     * Returns the builder for the settings used for calls to listZones.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public PagedCallSettings.Builder<ListZonesRequest, ListZonesResponse, ListZonesPagedResponse>
        listZonesSettings() {
      return listZonesSettings;
    }

    /**
     * Returns the builder for the settings used for calls to getZone.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<GetZoneRequest, Zone> getZoneSettings() {
      return getZoneSettings;
    }

    /** Returns the builder for the settings used for calls to listNetworks. */
    public PagedCallSettings.Builder<
            ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>
        listNetworksSettings() {
      return listNetworksSettings;
    }

    /** Returns the builder for the settings used for calls to getNetwork. */
    public UnaryCallSettings.Builder<GetNetworkRequest, Network> getNetworkSettings() {
      return getNetworkSettings;
    }

    /** Returns the builder for the settings used for calls to diagnoseNetwork. */
    public UnaryCallSettings.Builder<DiagnoseNetworkRequest, DiagnoseNetworkResponse>
        diagnoseNetworkSettings() {
      return diagnoseNetworkSettings;
    }

    /** Returns the builder for the settings used for calls to createNetwork. */
    public UnaryCallSettings.Builder<CreateNetworkRequest, Operation> createNetworkSettings() {
      return createNetworkSettings;
    }

    /** Returns the builder for the settings used for calls to createNetwork. */
    public OperationCallSettings.Builder<CreateNetworkRequest, Network, OperationMetadata>
        createNetworkOperationSettings() {
      return createNetworkOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNetwork. */
    public UnaryCallSettings.Builder<DeleteNetworkRequest, Operation> deleteNetworkSettings() {
      return deleteNetworkSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNetwork. */
    public OperationCallSettings.Builder<DeleteNetworkRequest, Empty, OperationMetadata>
        deleteNetworkOperationSettings() {
      return deleteNetworkOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listSubnets. */
    public PagedCallSettings.Builder<
            ListSubnetsRequest, ListSubnetsResponse, ListSubnetsPagedResponse>
        listSubnetsSettings() {
      return listSubnetsSettings;
    }

    /** Returns the builder for the settings used for calls to getSubnet. */
    public UnaryCallSettings.Builder<GetSubnetRequest, Subnet> getSubnetSettings() {
      return getSubnetSettings;
    }

    /** Returns the builder for the settings used for calls to createSubnet. */
    public UnaryCallSettings.Builder<CreateSubnetRequest, Operation> createSubnetSettings() {
      return createSubnetSettings;
    }

    /** Returns the builder for the settings used for calls to createSubnet. */
    public OperationCallSettings.Builder<CreateSubnetRequest, Subnet, OperationMetadata>
        createSubnetOperationSettings() {
      return createSubnetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateSubnet. */
    public UnaryCallSettings.Builder<UpdateSubnetRequest, Operation> updateSubnetSettings() {
      return updateSubnetSettings;
    }

    /** Returns the builder for the settings used for calls to updateSubnet. */
    public OperationCallSettings.Builder<UpdateSubnetRequest, Subnet, OperationMetadata>
        updateSubnetOperationSettings() {
      return updateSubnetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSubnet. */
    public UnaryCallSettings.Builder<DeleteSubnetRequest, Operation> deleteSubnetSettings() {
      return deleteSubnetSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSubnet. */
    public OperationCallSettings.Builder<DeleteSubnetRequest, Empty, OperationMetadata>
        deleteSubnetOperationSettings() {
      return deleteSubnetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listInterconnects. */
    public PagedCallSettings.Builder<
            ListInterconnectsRequest, ListInterconnectsResponse, ListInterconnectsPagedResponse>
        listInterconnectsSettings() {
      return listInterconnectsSettings;
    }

    /** Returns the builder for the settings used for calls to getInterconnect. */
    public UnaryCallSettings.Builder<GetInterconnectRequest, Interconnect>
        getInterconnectSettings() {
      return getInterconnectSettings;
    }

    /** Returns the builder for the settings used for calls to diagnoseInterconnect. */
    public UnaryCallSettings.Builder<DiagnoseInterconnectRequest, DiagnoseInterconnectResponse>
        diagnoseInterconnectSettings() {
      return diagnoseInterconnectSettings;
    }

    /** Returns the builder for the settings used for calls to listInterconnectAttachments. */
    public PagedCallSettings.Builder<
            ListInterconnectAttachmentsRequest,
            ListInterconnectAttachmentsResponse,
            ListInterconnectAttachmentsPagedResponse>
        listInterconnectAttachmentsSettings() {
      return listInterconnectAttachmentsSettings;
    }

    /** Returns the builder for the settings used for calls to getInterconnectAttachment. */
    public UnaryCallSettings.Builder<GetInterconnectAttachmentRequest, InterconnectAttachment>
        getInterconnectAttachmentSettings() {
      return getInterconnectAttachmentSettings;
    }

    /** Returns the builder for the settings used for calls to createInterconnectAttachment. */
    public UnaryCallSettings.Builder<CreateInterconnectAttachmentRequest, Operation>
        createInterconnectAttachmentSettings() {
      return createInterconnectAttachmentSettings;
    }

    /** Returns the builder for the settings used for calls to createInterconnectAttachment. */
    public OperationCallSettings.Builder<
            CreateInterconnectAttachmentRequest, InterconnectAttachment, OperationMetadata>
        createInterconnectAttachmentOperationSettings() {
      return createInterconnectAttachmentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInterconnectAttachment. */
    public UnaryCallSettings.Builder<DeleteInterconnectAttachmentRequest, Operation>
        deleteInterconnectAttachmentSettings() {
      return deleteInterconnectAttachmentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInterconnectAttachment. */
    public OperationCallSettings.Builder<
            DeleteInterconnectAttachmentRequest, Empty, OperationMetadata>
        deleteInterconnectAttachmentOperationSettings() {
      return deleteInterconnectAttachmentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listRouters. */
    public PagedCallSettings.Builder<
            ListRoutersRequest, ListRoutersResponse, ListRoutersPagedResponse>
        listRoutersSettings() {
      return listRoutersSettings;
    }

    /** Returns the builder for the settings used for calls to getRouter. */
    public UnaryCallSettings.Builder<GetRouterRequest, Router> getRouterSettings() {
      return getRouterSettings;
    }

    /** Returns the builder for the settings used for calls to diagnoseRouter. */
    public UnaryCallSettings.Builder<DiagnoseRouterRequest, DiagnoseRouterResponse>
        diagnoseRouterSettings() {
      return diagnoseRouterSettings;
    }

    /** Returns the builder for the settings used for calls to createRouter. */
    public UnaryCallSettings.Builder<CreateRouterRequest, Operation> createRouterSettings() {
      return createRouterSettings;
    }

    /** Returns the builder for the settings used for calls to createRouter. */
    public OperationCallSettings.Builder<CreateRouterRequest, Router, OperationMetadata>
        createRouterOperationSettings() {
      return createRouterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateRouter. */
    public UnaryCallSettings.Builder<UpdateRouterRequest, Operation> updateRouterSettings() {
      return updateRouterSettings;
    }

    /** Returns the builder for the settings used for calls to updateRouter. */
    public OperationCallSettings.Builder<UpdateRouterRequest, Router, OperationMetadata>
        updateRouterOperationSettings() {
      return updateRouterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRouter. */
    public UnaryCallSettings.Builder<DeleteRouterRequest, Operation> deleteRouterSettings() {
      return deleteRouterSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRouter. */
    public OperationCallSettings.Builder<DeleteRouterRequest, Empty, OperationMetadata>
        deleteRouterOperationSettings() {
      return deleteRouterOperationSettings;
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
    public EdgeNetworkStubSettings build() throws IOException {
      return new EdgeNetworkStubSettings(this);
    }
  }
}
