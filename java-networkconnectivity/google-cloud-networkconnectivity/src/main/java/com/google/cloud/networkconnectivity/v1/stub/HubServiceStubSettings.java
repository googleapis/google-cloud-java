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

package com.google.cloud.networkconnectivity.v1.stub;

import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListGroupsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListHubSpokesPagedResponse;
import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListHubsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListRouteTablesPagedResponse;
import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListRoutesPagedResponse;
import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListSpokesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networkconnectivity.v1.AcceptHubSpokeRequest;
import com.google.cloud.networkconnectivity.v1.AcceptHubSpokeResponse;
import com.google.cloud.networkconnectivity.v1.CreateHubRequest;
import com.google.cloud.networkconnectivity.v1.CreateSpokeRequest;
import com.google.cloud.networkconnectivity.v1.DeleteHubRequest;
import com.google.cloud.networkconnectivity.v1.DeleteSpokeRequest;
import com.google.cloud.networkconnectivity.v1.GetGroupRequest;
import com.google.cloud.networkconnectivity.v1.GetHubRequest;
import com.google.cloud.networkconnectivity.v1.GetRouteRequest;
import com.google.cloud.networkconnectivity.v1.GetRouteTableRequest;
import com.google.cloud.networkconnectivity.v1.GetSpokeRequest;
import com.google.cloud.networkconnectivity.v1.Group;
import com.google.cloud.networkconnectivity.v1.Hub;
import com.google.cloud.networkconnectivity.v1.ListGroupsRequest;
import com.google.cloud.networkconnectivity.v1.ListGroupsResponse;
import com.google.cloud.networkconnectivity.v1.ListHubSpokesRequest;
import com.google.cloud.networkconnectivity.v1.ListHubSpokesResponse;
import com.google.cloud.networkconnectivity.v1.ListHubsRequest;
import com.google.cloud.networkconnectivity.v1.ListHubsResponse;
import com.google.cloud.networkconnectivity.v1.ListRouteTablesRequest;
import com.google.cloud.networkconnectivity.v1.ListRouteTablesResponse;
import com.google.cloud.networkconnectivity.v1.ListRoutesRequest;
import com.google.cloud.networkconnectivity.v1.ListRoutesResponse;
import com.google.cloud.networkconnectivity.v1.ListSpokesRequest;
import com.google.cloud.networkconnectivity.v1.ListSpokesResponse;
import com.google.cloud.networkconnectivity.v1.OperationMetadata;
import com.google.cloud.networkconnectivity.v1.RejectHubSpokeRequest;
import com.google.cloud.networkconnectivity.v1.RejectHubSpokeResponse;
import com.google.cloud.networkconnectivity.v1.Route;
import com.google.cloud.networkconnectivity.v1.RouteTable;
import com.google.cloud.networkconnectivity.v1.Spoke;
import com.google.cloud.networkconnectivity.v1.UpdateHubRequest;
import com.google.cloud.networkconnectivity.v1.UpdateSpokeRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link HubServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (networkconnectivity.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getHub to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * HubServiceStubSettings.Builder hubServiceSettingsBuilder = HubServiceStubSettings.newBuilder();
 * hubServiceSettingsBuilder
 *     .getHubSettings()
 *     .setRetrySettings(
 *         hubServiceSettingsBuilder
 *             .getHubSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * HubServiceStubSettings hubServiceSettings = hubServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class HubServiceStubSettings extends StubSettings<HubServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<ListHubsRequest, ListHubsResponse, ListHubsPagedResponse>
      listHubsSettings;
  private final UnaryCallSettings<GetHubRequest, Hub> getHubSettings;
  private final UnaryCallSettings<CreateHubRequest, Operation> createHubSettings;
  private final OperationCallSettings<CreateHubRequest, Hub, OperationMetadata>
      createHubOperationSettings;
  private final UnaryCallSettings<UpdateHubRequest, Operation> updateHubSettings;
  private final OperationCallSettings<UpdateHubRequest, Hub, OperationMetadata>
      updateHubOperationSettings;
  private final UnaryCallSettings<DeleteHubRequest, Operation> deleteHubSettings;
  private final OperationCallSettings<DeleteHubRequest, Empty, OperationMetadata>
      deleteHubOperationSettings;
  private final PagedCallSettings<
          ListHubSpokesRequest, ListHubSpokesResponse, ListHubSpokesPagedResponse>
      listHubSpokesSettings;
  private final PagedCallSettings<ListSpokesRequest, ListSpokesResponse, ListSpokesPagedResponse>
      listSpokesSettings;
  private final UnaryCallSettings<GetSpokeRequest, Spoke> getSpokeSettings;
  private final UnaryCallSettings<CreateSpokeRequest, Operation> createSpokeSettings;
  private final OperationCallSettings<CreateSpokeRequest, Spoke, OperationMetadata>
      createSpokeOperationSettings;
  private final UnaryCallSettings<UpdateSpokeRequest, Operation> updateSpokeSettings;
  private final OperationCallSettings<UpdateSpokeRequest, Spoke, OperationMetadata>
      updateSpokeOperationSettings;
  private final UnaryCallSettings<RejectHubSpokeRequest, Operation> rejectHubSpokeSettings;
  private final OperationCallSettings<
          RejectHubSpokeRequest, RejectHubSpokeResponse, OperationMetadata>
      rejectHubSpokeOperationSettings;
  private final UnaryCallSettings<AcceptHubSpokeRequest, Operation> acceptHubSpokeSettings;
  private final OperationCallSettings<
          AcceptHubSpokeRequest, AcceptHubSpokeResponse, OperationMetadata>
      acceptHubSpokeOperationSettings;
  private final UnaryCallSettings<DeleteSpokeRequest, Operation> deleteSpokeSettings;
  private final OperationCallSettings<DeleteSpokeRequest, Empty, OperationMetadata>
      deleteSpokeOperationSettings;
  private final UnaryCallSettings<GetRouteTableRequest, RouteTable> getRouteTableSettings;
  private final UnaryCallSettings<GetRouteRequest, Route> getRouteSettings;
  private final PagedCallSettings<ListRoutesRequest, ListRoutesResponse, ListRoutesPagedResponse>
      listRoutesSettings;
  private final PagedCallSettings<
          ListRouteTablesRequest, ListRouteTablesResponse, ListRouteTablesPagedResponse>
      listRouteTablesSettings;
  private final UnaryCallSettings<GetGroupRequest, Group> getGroupSettings;
  private final PagedCallSettings<ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
      listGroupsSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<ListHubsRequest, ListHubsResponse, Hub>
      LIST_HUBS_PAGE_STR_DESC =
          new PagedListDescriptor<ListHubsRequest, ListHubsResponse, Hub>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListHubsRequest injectToken(ListHubsRequest payload, String token) {
              return ListHubsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListHubsRequest injectPageSize(ListHubsRequest payload, int pageSize) {
              return ListHubsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListHubsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListHubsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Hub> extractResources(ListHubsResponse payload) {
              return payload.getHubsList() == null
                  ? ImmutableList.<Hub>of()
                  : payload.getHubsList();
            }
          };

  private static final PagedListDescriptor<ListHubSpokesRequest, ListHubSpokesResponse, Spoke>
      LIST_HUB_SPOKES_PAGE_STR_DESC =
          new PagedListDescriptor<ListHubSpokesRequest, ListHubSpokesResponse, Spoke>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListHubSpokesRequest injectToken(ListHubSpokesRequest payload, String token) {
              return ListHubSpokesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListHubSpokesRequest injectPageSize(ListHubSpokesRequest payload, int pageSize) {
              return ListHubSpokesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListHubSpokesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListHubSpokesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Spoke> extractResources(ListHubSpokesResponse payload) {
              return payload.getSpokesList() == null
                  ? ImmutableList.<Spoke>of()
                  : payload.getSpokesList();
            }
          };

  private static final PagedListDescriptor<ListSpokesRequest, ListSpokesResponse, Spoke>
      LIST_SPOKES_PAGE_STR_DESC =
          new PagedListDescriptor<ListSpokesRequest, ListSpokesResponse, Spoke>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSpokesRequest injectToken(ListSpokesRequest payload, String token) {
              return ListSpokesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSpokesRequest injectPageSize(ListSpokesRequest payload, int pageSize) {
              return ListSpokesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSpokesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSpokesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Spoke> extractResources(ListSpokesResponse payload) {
              return payload.getSpokesList() == null
                  ? ImmutableList.<Spoke>of()
                  : payload.getSpokesList();
            }
          };

  private static final PagedListDescriptor<ListRoutesRequest, ListRoutesResponse, Route>
      LIST_ROUTES_PAGE_STR_DESC =
          new PagedListDescriptor<ListRoutesRequest, ListRoutesResponse, Route>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRoutesRequest injectToken(ListRoutesRequest payload, String token) {
              return ListRoutesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRoutesRequest injectPageSize(ListRoutesRequest payload, int pageSize) {
              return ListRoutesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRoutesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRoutesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Route> extractResources(ListRoutesResponse payload) {
              return payload.getRoutesList() == null
                  ? ImmutableList.<Route>of()
                  : payload.getRoutesList();
            }
          };

  private static final PagedListDescriptor<
          ListRouteTablesRequest, ListRouteTablesResponse, RouteTable>
      LIST_ROUTE_TABLES_PAGE_STR_DESC =
          new PagedListDescriptor<ListRouteTablesRequest, ListRouteTablesResponse, RouteTable>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRouteTablesRequest injectToken(
                ListRouteTablesRequest payload, String token) {
              return ListRouteTablesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRouteTablesRequest injectPageSize(
                ListRouteTablesRequest payload, int pageSize) {
              return ListRouteTablesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRouteTablesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRouteTablesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<RouteTable> extractResources(ListRouteTablesResponse payload) {
              return payload.getRouteTablesList() == null
                  ? ImmutableList.<RouteTable>of()
                  : payload.getRouteTablesList();
            }
          };

  private static final PagedListDescriptor<ListGroupsRequest, ListGroupsResponse, Group>
      LIST_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<ListGroupsRequest, ListGroupsResponse, Group>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGroupsRequest injectToken(ListGroupsRequest payload, String token) {
              return ListGroupsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListGroupsRequest injectPageSize(ListGroupsRequest payload, int pageSize) {
              return ListGroupsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListGroupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListGroupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Group> extractResources(ListGroupsResponse payload) {
              return payload.getGroupsList() == null
                  ? ImmutableList.<Group>of()
                  : payload.getGroupsList();
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
          ListHubsRequest, ListHubsResponse, ListHubsPagedResponse>
      LIST_HUBS_PAGE_STR_FACT =
          new PagedListResponseFactory<ListHubsRequest, ListHubsResponse, ListHubsPagedResponse>() {
            @Override
            public ApiFuture<ListHubsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListHubsRequest, ListHubsResponse> callable,
                ListHubsRequest request,
                ApiCallContext context,
                ApiFuture<ListHubsResponse> futureResponse) {
              PageContext<ListHubsRequest, ListHubsResponse, Hub> pageContext =
                  PageContext.create(callable, LIST_HUBS_PAGE_STR_DESC, request, context);
              return ListHubsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListHubSpokesRequest, ListHubSpokesResponse, ListHubSpokesPagedResponse>
      LIST_HUB_SPOKES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListHubSpokesRequest, ListHubSpokesResponse, ListHubSpokesPagedResponse>() {
            @Override
            public ApiFuture<ListHubSpokesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListHubSpokesRequest, ListHubSpokesResponse> callable,
                ListHubSpokesRequest request,
                ApiCallContext context,
                ApiFuture<ListHubSpokesResponse> futureResponse) {
              PageContext<ListHubSpokesRequest, ListHubSpokesResponse, Spoke> pageContext =
                  PageContext.create(callable, LIST_HUB_SPOKES_PAGE_STR_DESC, request, context);
              return ListHubSpokesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSpokesRequest, ListSpokesResponse, ListSpokesPagedResponse>
      LIST_SPOKES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSpokesRequest, ListSpokesResponse, ListSpokesPagedResponse>() {
            @Override
            public ApiFuture<ListSpokesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSpokesRequest, ListSpokesResponse> callable,
                ListSpokesRequest request,
                ApiCallContext context,
                ApiFuture<ListSpokesResponse> futureResponse) {
              PageContext<ListSpokesRequest, ListSpokesResponse, Spoke> pageContext =
                  PageContext.create(callable, LIST_SPOKES_PAGE_STR_DESC, request, context);
              return ListSpokesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListRoutesRequest, ListRoutesResponse, ListRoutesPagedResponse>
      LIST_ROUTES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRoutesRequest, ListRoutesResponse, ListRoutesPagedResponse>() {
            @Override
            public ApiFuture<ListRoutesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRoutesRequest, ListRoutesResponse> callable,
                ListRoutesRequest request,
                ApiCallContext context,
                ApiFuture<ListRoutesResponse> futureResponse) {
              PageContext<ListRoutesRequest, ListRoutesResponse, Route> pageContext =
                  PageContext.create(callable, LIST_ROUTES_PAGE_STR_DESC, request, context);
              return ListRoutesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListRouteTablesRequest, ListRouteTablesResponse, ListRouteTablesPagedResponse>
      LIST_ROUTE_TABLES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRouteTablesRequest, ListRouteTablesResponse, ListRouteTablesPagedResponse>() {
            @Override
            public ApiFuture<ListRouteTablesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRouteTablesRequest, ListRouteTablesResponse> callable,
                ListRouteTablesRequest request,
                ApiCallContext context,
                ApiFuture<ListRouteTablesResponse> futureResponse) {
              PageContext<ListRouteTablesRequest, ListRouteTablesResponse, RouteTable> pageContext =
                  PageContext.create(callable, LIST_ROUTE_TABLES_PAGE_STR_DESC, request, context);
              return ListRouteTablesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
      LIST_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGroupsRequest, ListGroupsResponse> callable,
                ListGroupsRequest request,
                ApiCallContext context,
                ApiFuture<ListGroupsResponse> futureResponse) {
              PageContext<ListGroupsRequest, ListGroupsResponse, Group> pageContext =
                  PageContext.create(callable, LIST_GROUPS_PAGE_STR_DESC, request, context);
              return ListGroupsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listHubs. */
  public PagedCallSettings<ListHubsRequest, ListHubsResponse, ListHubsPagedResponse>
      listHubsSettings() {
    return listHubsSettings;
  }

  /** Returns the object with the settings used for calls to getHub. */
  public UnaryCallSettings<GetHubRequest, Hub> getHubSettings() {
    return getHubSettings;
  }

  /** Returns the object with the settings used for calls to createHub. */
  public UnaryCallSettings<CreateHubRequest, Operation> createHubSettings() {
    return createHubSettings;
  }

  /** Returns the object with the settings used for calls to createHub. */
  public OperationCallSettings<CreateHubRequest, Hub, OperationMetadata>
      createHubOperationSettings() {
    return createHubOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateHub. */
  public UnaryCallSettings<UpdateHubRequest, Operation> updateHubSettings() {
    return updateHubSettings;
  }

  /** Returns the object with the settings used for calls to updateHub. */
  public OperationCallSettings<UpdateHubRequest, Hub, OperationMetadata>
      updateHubOperationSettings() {
    return updateHubOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteHub. */
  public UnaryCallSettings<DeleteHubRequest, Operation> deleteHubSettings() {
    return deleteHubSettings;
  }

  /** Returns the object with the settings used for calls to deleteHub. */
  public OperationCallSettings<DeleteHubRequest, Empty, OperationMetadata>
      deleteHubOperationSettings() {
    return deleteHubOperationSettings;
  }

  /** Returns the object with the settings used for calls to listHubSpokes. */
  public PagedCallSettings<ListHubSpokesRequest, ListHubSpokesResponse, ListHubSpokesPagedResponse>
      listHubSpokesSettings() {
    return listHubSpokesSettings;
  }

  /** Returns the object with the settings used for calls to listSpokes. */
  public PagedCallSettings<ListSpokesRequest, ListSpokesResponse, ListSpokesPagedResponse>
      listSpokesSettings() {
    return listSpokesSettings;
  }

  /** Returns the object with the settings used for calls to getSpoke. */
  public UnaryCallSettings<GetSpokeRequest, Spoke> getSpokeSettings() {
    return getSpokeSettings;
  }

  /** Returns the object with the settings used for calls to createSpoke. */
  public UnaryCallSettings<CreateSpokeRequest, Operation> createSpokeSettings() {
    return createSpokeSettings;
  }

  /** Returns the object with the settings used for calls to createSpoke. */
  public OperationCallSettings<CreateSpokeRequest, Spoke, OperationMetadata>
      createSpokeOperationSettings() {
    return createSpokeOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateSpoke. */
  public UnaryCallSettings<UpdateSpokeRequest, Operation> updateSpokeSettings() {
    return updateSpokeSettings;
  }

  /** Returns the object with the settings used for calls to updateSpoke. */
  public OperationCallSettings<UpdateSpokeRequest, Spoke, OperationMetadata>
      updateSpokeOperationSettings() {
    return updateSpokeOperationSettings;
  }

  /** Returns the object with the settings used for calls to rejectHubSpoke. */
  public UnaryCallSettings<RejectHubSpokeRequest, Operation> rejectHubSpokeSettings() {
    return rejectHubSpokeSettings;
  }

  /** Returns the object with the settings used for calls to rejectHubSpoke. */
  public OperationCallSettings<RejectHubSpokeRequest, RejectHubSpokeResponse, OperationMetadata>
      rejectHubSpokeOperationSettings() {
    return rejectHubSpokeOperationSettings;
  }

  /** Returns the object with the settings used for calls to acceptHubSpoke. */
  public UnaryCallSettings<AcceptHubSpokeRequest, Operation> acceptHubSpokeSettings() {
    return acceptHubSpokeSettings;
  }

  /** Returns the object with the settings used for calls to acceptHubSpoke. */
  public OperationCallSettings<AcceptHubSpokeRequest, AcceptHubSpokeResponse, OperationMetadata>
      acceptHubSpokeOperationSettings() {
    return acceptHubSpokeOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteSpoke. */
  public UnaryCallSettings<DeleteSpokeRequest, Operation> deleteSpokeSettings() {
    return deleteSpokeSettings;
  }

  /** Returns the object with the settings used for calls to deleteSpoke. */
  public OperationCallSettings<DeleteSpokeRequest, Empty, OperationMetadata>
      deleteSpokeOperationSettings() {
    return deleteSpokeOperationSettings;
  }

  /** Returns the object with the settings used for calls to getRouteTable. */
  public UnaryCallSettings<GetRouteTableRequest, RouteTable> getRouteTableSettings() {
    return getRouteTableSettings;
  }

  /** Returns the object with the settings used for calls to getRoute. */
  public UnaryCallSettings<GetRouteRequest, Route> getRouteSettings() {
    return getRouteSettings;
  }

  /** Returns the object with the settings used for calls to listRoutes. */
  public PagedCallSettings<ListRoutesRequest, ListRoutesResponse, ListRoutesPagedResponse>
      listRoutesSettings() {
    return listRoutesSettings;
  }

  /** Returns the object with the settings used for calls to listRouteTables. */
  public PagedCallSettings<
          ListRouteTablesRequest, ListRouteTablesResponse, ListRouteTablesPagedResponse>
      listRouteTablesSettings() {
    return listRouteTablesSettings;
  }

  /** Returns the object with the settings used for calls to getGroup. */
  public UnaryCallSettings<GetGroupRequest, Group> getGroupSettings() {
    return getGroupSettings;
  }

  /** Returns the object with the settings used for calls to listGroups. */
  public PagedCallSettings<ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
      listGroupsSettings() {
    return listGroupsSettings;
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

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public HubServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcHubServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "networkconnectivity";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "networkconnectivity.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "networkconnectivity.mtls.googleapis.com:443";
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(HubServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
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

  protected HubServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listHubsSettings = settingsBuilder.listHubsSettings().build();
    getHubSettings = settingsBuilder.getHubSettings().build();
    createHubSettings = settingsBuilder.createHubSettings().build();
    createHubOperationSettings = settingsBuilder.createHubOperationSettings().build();
    updateHubSettings = settingsBuilder.updateHubSettings().build();
    updateHubOperationSettings = settingsBuilder.updateHubOperationSettings().build();
    deleteHubSettings = settingsBuilder.deleteHubSettings().build();
    deleteHubOperationSettings = settingsBuilder.deleteHubOperationSettings().build();
    listHubSpokesSettings = settingsBuilder.listHubSpokesSettings().build();
    listSpokesSettings = settingsBuilder.listSpokesSettings().build();
    getSpokeSettings = settingsBuilder.getSpokeSettings().build();
    createSpokeSettings = settingsBuilder.createSpokeSettings().build();
    createSpokeOperationSettings = settingsBuilder.createSpokeOperationSettings().build();
    updateSpokeSettings = settingsBuilder.updateSpokeSettings().build();
    updateSpokeOperationSettings = settingsBuilder.updateSpokeOperationSettings().build();
    rejectHubSpokeSettings = settingsBuilder.rejectHubSpokeSettings().build();
    rejectHubSpokeOperationSettings = settingsBuilder.rejectHubSpokeOperationSettings().build();
    acceptHubSpokeSettings = settingsBuilder.acceptHubSpokeSettings().build();
    acceptHubSpokeOperationSettings = settingsBuilder.acceptHubSpokeOperationSettings().build();
    deleteSpokeSettings = settingsBuilder.deleteSpokeSettings().build();
    deleteSpokeOperationSettings = settingsBuilder.deleteSpokeOperationSettings().build();
    getRouteTableSettings = settingsBuilder.getRouteTableSettings().build();
    getRouteSettings = settingsBuilder.getRouteSettings().build();
    listRoutesSettings = settingsBuilder.listRoutesSettings().build();
    listRouteTablesSettings = settingsBuilder.listRouteTablesSettings().build();
    getGroupSettings = settingsBuilder.getGroupSettings().build();
    listGroupsSettings = settingsBuilder.listGroupsSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for HubServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<HubServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListHubsRequest, ListHubsResponse, ListHubsPagedResponse>
        listHubsSettings;
    private final UnaryCallSettings.Builder<GetHubRequest, Hub> getHubSettings;
    private final UnaryCallSettings.Builder<CreateHubRequest, Operation> createHubSettings;
    private final OperationCallSettings.Builder<CreateHubRequest, Hub, OperationMetadata>
        createHubOperationSettings;
    private final UnaryCallSettings.Builder<UpdateHubRequest, Operation> updateHubSettings;
    private final OperationCallSettings.Builder<UpdateHubRequest, Hub, OperationMetadata>
        updateHubOperationSettings;
    private final UnaryCallSettings.Builder<DeleteHubRequest, Operation> deleteHubSettings;
    private final OperationCallSettings.Builder<DeleteHubRequest, Empty, OperationMetadata>
        deleteHubOperationSettings;
    private final PagedCallSettings.Builder<
            ListHubSpokesRequest, ListHubSpokesResponse, ListHubSpokesPagedResponse>
        listHubSpokesSettings;
    private final PagedCallSettings.Builder<
            ListSpokesRequest, ListSpokesResponse, ListSpokesPagedResponse>
        listSpokesSettings;
    private final UnaryCallSettings.Builder<GetSpokeRequest, Spoke> getSpokeSettings;
    private final UnaryCallSettings.Builder<CreateSpokeRequest, Operation> createSpokeSettings;
    private final OperationCallSettings.Builder<CreateSpokeRequest, Spoke, OperationMetadata>
        createSpokeOperationSettings;
    private final UnaryCallSettings.Builder<UpdateSpokeRequest, Operation> updateSpokeSettings;
    private final OperationCallSettings.Builder<UpdateSpokeRequest, Spoke, OperationMetadata>
        updateSpokeOperationSettings;
    private final UnaryCallSettings.Builder<RejectHubSpokeRequest, Operation>
        rejectHubSpokeSettings;
    private final OperationCallSettings.Builder<
            RejectHubSpokeRequest, RejectHubSpokeResponse, OperationMetadata>
        rejectHubSpokeOperationSettings;
    private final UnaryCallSettings.Builder<AcceptHubSpokeRequest, Operation>
        acceptHubSpokeSettings;
    private final OperationCallSettings.Builder<
            AcceptHubSpokeRequest, AcceptHubSpokeResponse, OperationMetadata>
        acceptHubSpokeOperationSettings;
    private final UnaryCallSettings.Builder<DeleteSpokeRequest, Operation> deleteSpokeSettings;
    private final OperationCallSettings.Builder<DeleteSpokeRequest, Empty, OperationMetadata>
        deleteSpokeOperationSettings;
    private final UnaryCallSettings.Builder<GetRouteTableRequest, RouteTable> getRouteTableSettings;
    private final UnaryCallSettings.Builder<GetRouteRequest, Route> getRouteSettings;
    private final PagedCallSettings.Builder<
            ListRoutesRequest, ListRoutesResponse, ListRoutesPagedResponse>
        listRoutesSettings;
    private final PagedCallSettings.Builder<
            ListRouteTablesRequest, ListRouteTablesResponse, ListRouteTablesPagedResponse>
        listRouteTablesSettings;
    private final UnaryCallSettings.Builder<GetGroupRequest, Group> getGroupSettings;
    private final PagedCallSettings.Builder<
            ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
        listGroupsSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
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
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
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
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listHubsSettings = PagedCallSettings.newBuilder(LIST_HUBS_PAGE_STR_FACT);
      getHubSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createHubSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createHubOperationSettings = OperationCallSettings.newBuilder();
      updateHubSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateHubOperationSettings = OperationCallSettings.newBuilder();
      deleteHubSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteHubOperationSettings = OperationCallSettings.newBuilder();
      listHubSpokesSettings = PagedCallSettings.newBuilder(LIST_HUB_SPOKES_PAGE_STR_FACT);
      listSpokesSettings = PagedCallSettings.newBuilder(LIST_SPOKES_PAGE_STR_FACT);
      getSpokeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSpokeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSpokeOperationSettings = OperationCallSettings.newBuilder();
      updateSpokeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSpokeOperationSettings = OperationCallSettings.newBuilder();
      rejectHubSpokeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      rejectHubSpokeOperationSettings = OperationCallSettings.newBuilder();
      acceptHubSpokeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      acceptHubSpokeOperationSettings = OperationCallSettings.newBuilder();
      deleteSpokeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSpokeOperationSettings = OperationCallSettings.newBuilder();
      getRouteTableSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getRouteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listRoutesSettings = PagedCallSettings.newBuilder(LIST_ROUTES_PAGE_STR_FACT);
      listRouteTablesSettings = PagedCallSettings.newBuilder(LIST_ROUTE_TABLES_PAGE_STR_FACT);
      getGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listGroupsSettings = PagedCallSettings.newBuilder(LIST_GROUPS_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listHubsSettings,
              getHubSettings,
              createHubSettings,
              updateHubSettings,
              deleteHubSettings,
              listHubSpokesSettings,
              listSpokesSettings,
              getSpokeSettings,
              createSpokeSettings,
              updateSpokeSettings,
              rejectHubSpokeSettings,
              acceptHubSpokeSettings,
              deleteSpokeSettings,
              getRouteTableSettings,
              getRouteSettings,
              listRoutesSettings,
              listRouteTablesSettings,
              getGroupSettings,
              listGroupsSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(HubServiceStubSettings settings) {
      super(settings);

      listHubsSettings = settings.listHubsSettings.toBuilder();
      getHubSettings = settings.getHubSettings.toBuilder();
      createHubSettings = settings.createHubSettings.toBuilder();
      createHubOperationSettings = settings.createHubOperationSettings.toBuilder();
      updateHubSettings = settings.updateHubSettings.toBuilder();
      updateHubOperationSettings = settings.updateHubOperationSettings.toBuilder();
      deleteHubSettings = settings.deleteHubSettings.toBuilder();
      deleteHubOperationSettings = settings.deleteHubOperationSettings.toBuilder();
      listHubSpokesSettings = settings.listHubSpokesSettings.toBuilder();
      listSpokesSettings = settings.listSpokesSettings.toBuilder();
      getSpokeSettings = settings.getSpokeSettings.toBuilder();
      createSpokeSettings = settings.createSpokeSettings.toBuilder();
      createSpokeOperationSettings = settings.createSpokeOperationSettings.toBuilder();
      updateSpokeSettings = settings.updateSpokeSettings.toBuilder();
      updateSpokeOperationSettings = settings.updateSpokeOperationSettings.toBuilder();
      rejectHubSpokeSettings = settings.rejectHubSpokeSettings.toBuilder();
      rejectHubSpokeOperationSettings = settings.rejectHubSpokeOperationSettings.toBuilder();
      acceptHubSpokeSettings = settings.acceptHubSpokeSettings.toBuilder();
      acceptHubSpokeOperationSettings = settings.acceptHubSpokeOperationSettings.toBuilder();
      deleteSpokeSettings = settings.deleteSpokeSettings.toBuilder();
      deleteSpokeOperationSettings = settings.deleteSpokeOperationSettings.toBuilder();
      getRouteTableSettings = settings.getRouteTableSettings.toBuilder();
      getRouteSettings = settings.getRouteSettings.toBuilder();
      listRoutesSettings = settings.listRoutesSettings.toBuilder();
      listRouteTablesSettings = settings.listRouteTablesSettings.toBuilder();
      getGroupSettings = settings.getGroupSettings.toBuilder();
      listGroupsSettings = settings.listGroupsSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listHubsSettings,
              getHubSettings,
              createHubSettings,
              updateHubSettings,
              deleteHubSettings,
              listHubSpokesSettings,
              listSpokesSettings,
              getSpokeSettings,
              createSpokeSettings,
              updateSpokeSettings,
              rejectHubSpokeSettings,
              acceptHubSpokeSettings,
              deleteSpokeSettings,
              getRouteTableSettings,
              getRouteSettings,
              listRoutesSettings,
              listRouteTablesSettings,
              getGroupSettings,
              listGroupsSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
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

    private static Builder initDefaults(Builder builder) {
      builder
          .listHubsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getHubSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createHubSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateHubSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteHubSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listHubSpokesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listSpokesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getSpokeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createSpokeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateSpokeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .rejectHubSpokeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .acceptHubSpokeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteSpokeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getRouteTableSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getRouteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listRoutesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listRouteTablesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createHubOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateHubRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Hub.class))
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
          .updateHubOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateHubRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Hub.class))
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
          .deleteHubOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteHubRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .createSpokeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateSpokeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Spoke.class))
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
          .updateSpokeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateSpokeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Spoke.class))
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
          .rejectHubSpokeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RejectHubSpokeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(RejectHubSpokeResponse.class))
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
          .acceptHubSpokeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AcceptHubSpokeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AcceptHubSpokeResponse.class))
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
          .deleteSpokeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteSpokeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to listHubs. */
    public PagedCallSettings.Builder<ListHubsRequest, ListHubsResponse, ListHubsPagedResponse>
        listHubsSettings() {
      return listHubsSettings;
    }

    /** Returns the builder for the settings used for calls to getHub. */
    public UnaryCallSettings.Builder<GetHubRequest, Hub> getHubSettings() {
      return getHubSettings;
    }

    /** Returns the builder for the settings used for calls to createHub. */
    public UnaryCallSettings.Builder<CreateHubRequest, Operation> createHubSettings() {
      return createHubSettings;
    }

    /** Returns the builder for the settings used for calls to createHub. */
    public OperationCallSettings.Builder<CreateHubRequest, Hub, OperationMetadata>
        createHubOperationSettings() {
      return createHubOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateHub. */
    public UnaryCallSettings.Builder<UpdateHubRequest, Operation> updateHubSettings() {
      return updateHubSettings;
    }

    /** Returns the builder for the settings used for calls to updateHub. */
    public OperationCallSettings.Builder<UpdateHubRequest, Hub, OperationMetadata>
        updateHubOperationSettings() {
      return updateHubOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteHub. */
    public UnaryCallSettings.Builder<DeleteHubRequest, Operation> deleteHubSettings() {
      return deleteHubSettings;
    }

    /** Returns the builder for the settings used for calls to deleteHub. */
    public OperationCallSettings.Builder<DeleteHubRequest, Empty, OperationMetadata>
        deleteHubOperationSettings() {
      return deleteHubOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listHubSpokes. */
    public PagedCallSettings.Builder<
            ListHubSpokesRequest, ListHubSpokesResponse, ListHubSpokesPagedResponse>
        listHubSpokesSettings() {
      return listHubSpokesSettings;
    }

    /** Returns the builder for the settings used for calls to listSpokes. */
    public PagedCallSettings.Builder<ListSpokesRequest, ListSpokesResponse, ListSpokesPagedResponse>
        listSpokesSettings() {
      return listSpokesSettings;
    }

    /** Returns the builder for the settings used for calls to getSpoke. */
    public UnaryCallSettings.Builder<GetSpokeRequest, Spoke> getSpokeSettings() {
      return getSpokeSettings;
    }

    /** Returns the builder for the settings used for calls to createSpoke. */
    public UnaryCallSettings.Builder<CreateSpokeRequest, Operation> createSpokeSettings() {
      return createSpokeSettings;
    }

    /** Returns the builder for the settings used for calls to createSpoke. */
    public OperationCallSettings.Builder<CreateSpokeRequest, Spoke, OperationMetadata>
        createSpokeOperationSettings() {
      return createSpokeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateSpoke. */
    public UnaryCallSettings.Builder<UpdateSpokeRequest, Operation> updateSpokeSettings() {
      return updateSpokeSettings;
    }

    /** Returns the builder for the settings used for calls to updateSpoke. */
    public OperationCallSettings.Builder<UpdateSpokeRequest, Spoke, OperationMetadata>
        updateSpokeOperationSettings() {
      return updateSpokeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to rejectHubSpoke. */
    public UnaryCallSettings.Builder<RejectHubSpokeRequest, Operation> rejectHubSpokeSettings() {
      return rejectHubSpokeSettings;
    }

    /** Returns the builder for the settings used for calls to rejectHubSpoke. */
    public OperationCallSettings.Builder<
            RejectHubSpokeRequest, RejectHubSpokeResponse, OperationMetadata>
        rejectHubSpokeOperationSettings() {
      return rejectHubSpokeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to acceptHubSpoke. */
    public UnaryCallSettings.Builder<AcceptHubSpokeRequest, Operation> acceptHubSpokeSettings() {
      return acceptHubSpokeSettings;
    }

    /** Returns the builder for the settings used for calls to acceptHubSpoke. */
    public OperationCallSettings.Builder<
            AcceptHubSpokeRequest, AcceptHubSpokeResponse, OperationMetadata>
        acceptHubSpokeOperationSettings() {
      return acceptHubSpokeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSpoke. */
    public UnaryCallSettings.Builder<DeleteSpokeRequest, Operation> deleteSpokeSettings() {
      return deleteSpokeSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSpoke. */
    public OperationCallSettings.Builder<DeleteSpokeRequest, Empty, OperationMetadata>
        deleteSpokeOperationSettings() {
      return deleteSpokeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getRouteTable. */
    public UnaryCallSettings.Builder<GetRouteTableRequest, RouteTable> getRouteTableSettings() {
      return getRouteTableSettings;
    }

    /** Returns the builder for the settings used for calls to getRoute. */
    public UnaryCallSettings.Builder<GetRouteRequest, Route> getRouteSettings() {
      return getRouteSettings;
    }

    /** Returns the builder for the settings used for calls to listRoutes. */
    public PagedCallSettings.Builder<ListRoutesRequest, ListRoutesResponse, ListRoutesPagedResponse>
        listRoutesSettings() {
      return listRoutesSettings;
    }

    /** Returns the builder for the settings used for calls to listRouteTables. */
    public PagedCallSettings.Builder<
            ListRouteTablesRequest, ListRouteTablesResponse, ListRouteTablesPagedResponse>
        listRouteTablesSettings() {
      return listRouteTablesSettings;
    }

    /** Returns the builder for the settings used for calls to getGroup. */
    public UnaryCallSettings.Builder<GetGroupRequest, Group> getGroupSettings() {
      return getGroupSettings;
    }

    /** Returns the builder for the settings used for calls to listGroups. */
    public PagedCallSettings.Builder<ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
        listGroupsSettings() {
      return listGroupsSettings;
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

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public HubServiceStubSettings build() throws IOException {
      return new HubServiceStubSettings(this);
    }
  }
}
