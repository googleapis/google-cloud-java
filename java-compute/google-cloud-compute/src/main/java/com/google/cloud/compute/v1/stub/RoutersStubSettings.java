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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.RoutersClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.RoutersClient.GetNatMappingInfoPagedResponse;
import static com.google.cloud.compute.v1.RoutersClient.ListBgpRoutesPagedResponse;
import static com.google.cloud.compute.v1.RoutersClient.ListPagedResponse;
import static com.google.cloud.compute.v1.RoutersClient.ListRoutePoliciesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.httpjson.ProtoOperationTransformers;
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
import com.google.cloud.compute.v1.AggregatedListRoutersRequest;
import com.google.cloud.compute.v1.BgpRoute;
import com.google.cloud.compute.v1.DeleteRoutePolicyRouterRequest;
import com.google.cloud.compute.v1.DeleteRouterRequest;
import com.google.cloud.compute.v1.GetNatIpInfoRouterRequest;
import com.google.cloud.compute.v1.GetNatMappingInfoRoutersRequest;
import com.google.cloud.compute.v1.GetRoutePolicyRouterRequest;
import com.google.cloud.compute.v1.GetRouterRequest;
import com.google.cloud.compute.v1.GetRouterStatusRouterRequest;
import com.google.cloud.compute.v1.InsertRouterRequest;
import com.google.cloud.compute.v1.ListBgpRoutesRoutersRequest;
import com.google.cloud.compute.v1.ListRoutePoliciesRoutersRequest;
import com.google.cloud.compute.v1.ListRoutersRequest;
import com.google.cloud.compute.v1.NatIpInfoResponse;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRoutePolicyRouterRequest;
import com.google.cloud.compute.v1.PatchRouterRequest;
import com.google.cloud.compute.v1.PreviewRouterRequest;
import com.google.cloud.compute.v1.RoutePolicy;
import com.google.cloud.compute.v1.Router;
import com.google.cloud.compute.v1.RouterAggregatedList;
import com.google.cloud.compute.v1.RouterList;
import com.google.cloud.compute.v1.RouterStatusResponse;
import com.google.cloud.compute.v1.RoutersGetRoutePolicyResponse;
import com.google.cloud.compute.v1.RoutersListBgpRoutes;
import com.google.cloud.compute.v1.RoutersListRoutePolicies;
import com.google.cloud.compute.v1.RoutersPreviewResponse;
import com.google.cloud.compute.v1.RoutersScopedList;
import com.google.cloud.compute.v1.UpdateRoutePolicyRouterRequest;
import com.google.cloud.compute.v1.UpdateRouterRequest;
import com.google.cloud.compute.v1.VmEndpointNatMappings;
import com.google.cloud.compute.v1.VmEndpointNatMappingsList;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RoutersStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (compute.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of get:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RoutersStubSettings.Builder routersSettingsBuilder = RoutersStubSettings.newBuilder();
 * routersSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         routersSettingsBuilder
 *             .getSettings()
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
 * RoutersStubSettings routersSettings = routersSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for delete:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RoutersStubSettings.Builder routersSettingsBuilder = RoutersStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * routersSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RoutersStubSettings extends StubSettings<RoutersStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final PagedCallSettings<
          AggregatedListRoutersRequest, RouterAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings;
  private final UnaryCallSettings<DeleteRouterRequest, Operation> deleteSettings;
  private final OperationCallSettings<DeleteRouterRequest, Operation, Operation>
      deleteOperationSettings;
  private final UnaryCallSettings<DeleteRoutePolicyRouterRequest, Operation>
      deleteRoutePolicySettings;
  private final OperationCallSettings<DeleteRoutePolicyRouterRequest, Operation, Operation>
      deleteRoutePolicyOperationSettings;
  private final UnaryCallSettings<GetRouterRequest, Router> getSettings;
  private final UnaryCallSettings<GetNatIpInfoRouterRequest, NatIpInfoResponse>
      getNatIpInfoSettings;
  private final PagedCallSettings<
          GetNatMappingInfoRoutersRequest,
          VmEndpointNatMappingsList,
          GetNatMappingInfoPagedResponse>
      getNatMappingInfoSettings;
  private final UnaryCallSettings<GetRoutePolicyRouterRequest, RoutersGetRoutePolicyResponse>
      getRoutePolicySettings;
  private final UnaryCallSettings<GetRouterStatusRouterRequest, RouterStatusResponse>
      getRouterStatusSettings;
  private final UnaryCallSettings<InsertRouterRequest, Operation> insertSettings;
  private final OperationCallSettings<InsertRouterRequest, Operation, Operation>
      insertOperationSettings;
  private final PagedCallSettings<ListRoutersRequest, RouterList, ListPagedResponse> listSettings;
  private final PagedCallSettings<
          ListBgpRoutesRoutersRequest, RoutersListBgpRoutes, ListBgpRoutesPagedResponse>
      listBgpRoutesSettings;
  private final PagedCallSettings<
          ListRoutePoliciesRoutersRequest, RoutersListRoutePolicies, ListRoutePoliciesPagedResponse>
      listRoutePoliciesSettings;
  private final UnaryCallSettings<PatchRouterRequest, Operation> patchSettings;
  private final OperationCallSettings<PatchRouterRequest, Operation, Operation>
      patchOperationSettings;
  private final UnaryCallSettings<PatchRoutePolicyRouterRequest, Operation>
      patchRoutePolicySettings;
  private final OperationCallSettings<PatchRoutePolicyRouterRequest, Operation, Operation>
      patchRoutePolicyOperationSettings;
  private final UnaryCallSettings<PreviewRouterRequest, RoutersPreviewResponse> previewSettings;
  private final UnaryCallSettings<UpdateRouterRequest, Operation> updateSettings;
  private final OperationCallSettings<UpdateRouterRequest, Operation, Operation>
      updateOperationSettings;
  private final UnaryCallSettings<UpdateRoutePolicyRouterRequest, Operation>
      updateRoutePolicySettings;
  private final OperationCallSettings<UpdateRoutePolicyRouterRequest, Operation, Operation>
      updateRoutePolicyOperationSettings;

  private static final PagedListDescriptor<
          AggregatedListRoutersRequest, RouterAggregatedList, Map.Entry<String, RoutersScopedList>>
      AGGREGATED_LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListRoutersRequest,
              RouterAggregatedList,
              Map.Entry<String, RoutersScopedList>>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListRoutersRequest injectToken(
                AggregatedListRoutersRequest payload, String token) {
              return AggregatedListRoutersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public AggregatedListRoutersRequest injectPageSize(
                AggregatedListRoutersRequest payload, int pageSize) {
              return AggregatedListRoutersRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListRoutersRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(RouterAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Map.Entry<String, RoutersScopedList>> extractResources(
                RouterAggregatedList payload) {
              return payload.getItemsMap().entrySet();
            }
          };

  private static final PagedListDescriptor<
          GetNatMappingInfoRoutersRequest, VmEndpointNatMappingsList, VmEndpointNatMappings>
      GET_NAT_MAPPING_INFO_PAGE_STR_DESC =
          new PagedListDescriptor<
              GetNatMappingInfoRoutersRequest, VmEndpointNatMappingsList, VmEndpointNatMappings>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public GetNatMappingInfoRoutersRequest injectToken(
                GetNatMappingInfoRoutersRequest payload, String token) {
              return GetNatMappingInfoRoutersRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public GetNatMappingInfoRoutersRequest injectPageSize(
                GetNatMappingInfoRoutersRequest payload, int pageSize) {
              return GetNatMappingInfoRoutersRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(GetNatMappingInfoRoutersRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(VmEndpointNatMappingsList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<VmEndpointNatMappings> extractResources(
                VmEndpointNatMappingsList payload) {
              return payload.getResultList();
            }
          };

  private static final PagedListDescriptor<ListRoutersRequest, RouterList, Router>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<ListRoutersRequest, RouterList, Router>() {
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
              return ListRoutersRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRoutersRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(RouterList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Router> extractResources(RouterList payload) {
              return payload.getItemsList();
            }
          };

  private static final PagedListDescriptor<
          ListBgpRoutesRoutersRequest, RoutersListBgpRoutes, BgpRoute>
      LIST_BGP_ROUTES_PAGE_STR_DESC =
          new PagedListDescriptor<ListBgpRoutesRoutersRequest, RoutersListBgpRoutes, BgpRoute>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBgpRoutesRoutersRequest injectToken(
                ListBgpRoutesRoutersRequest payload, String token) {
              return ListBgpRoutesRoutersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBgpRoutesRoutersRequest injectPageSize(
                ListBgpRoutesRoutersRequest payload, int pageSize) {
              return ListBgpRoutesRoutersRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListBgpRoutesRoutersRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(RoutersListBgpRoutes payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<BgpRoute> extractResources(RoutersListBgpRoutes payload) {
              return payload.getResultList();
            }
          };

  private static final PagedListDescriptor<
          ListRoutePoliciesRoutersRequest, RoutersListRoutePolicies, RoutePolicy>
      LIST_ROUTE_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListRoutePoliciesRoutersRequest, RoutersListRoutePolicies, RoutePolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRoutePoliciesRoutersRequest injectToken(
                ListRoutePoliciesRoutersRequest payload, String token) {
              return ListRoutePoliciesRoutersRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListRoutePoliciesRoutersRequest injectPageSize(
                ListRoutePoliciesRoutersRequest payload, int pageSize) {
              return ListRoutePoliciesRoutersRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListRoutePoliciesRoutersRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(RoutersListRoutePolicies payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<RoutePolicy> extractResources(RoutersListRoutePolicies payload) {
              return payload.getResultList();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListRoutersRequest, RouterAggregatedList, AggregatedListPagedResponse>
      AGGREGATED_LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListRoutersRequest, RouterAggregatedList, AggregatedListPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListRoutersRequest, RouterAggregatedList> callable,
                AggregatedListRoutersRequest request,
                ApiCallContext context,
                ApiFuture<RouterAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListRoutersRequest,
                      RouterAggregatedList,
                      Map.Entry<String, RoutersScopedList>>
                  pageContext =
                      PageContext.create(callable, AGGREGATED_LIST_PAGE_STR_DESC, request, context);
              return AggregatedListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          GetNatMappingInfoRoutersRequest,
          VmEndpointNatMappingsList,
          GetNatMappingInfoPagedResponse>
      GET_NAT_MAPPING_INFO_PAGE_STR_FACT =
          new PagedListResponseFactory<
              GetNatMappingInfoRoutersRequest,
              VmEndpointNatMappingsList,
              GetNatMappingInfoPagedResponse>() {
            @Override
            public ApiFuture<GetNatMappingInfoPagedResponse> getFuturePagedResponse(
                UnaryCallable<GetNatMappingInfoRoutersRequest, VmEndpointNatMappingsList> callable,
                GetNatMappingInfoRoutersRequest request,
                ApiCallContext context,
                ApiFuture<VmEndpointNatMappingsList> futureResponse) {
              PageContext<
                      GetNatMappingInfoRoutersRequest,
                      VmEndpointNatMappingsList,
                      VmEndpointNatMappings>
                  pageContext =
                      PageContext.create(
                          callable, GET_NAT_MAPPING_INFO_PAGE_STR_DESC, request, context);
              return GetNatMappingInfoPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<ListRoutersRequest, RouterList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<ListRoutersRequest, RouterList, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRoutersRequest, RouterList> callable,
                ListRoutersRequest request,
                ApiCallContext context,
                ApiFuture<RouterList> futureResponse) {
              PageContext<ListRoutersRequest, RouterList, Router> pageContext =
                  PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBgpRoutesRoutersRequest, RoutersListBgpRoutes, ListBgpRoutesPagedResponse>
      LIST_BGP_ROUTES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBgpRoutesRoutersRequest, RoutersListBgpRoutes, ListBgpRoutesPagedResponse>() {
            @Override
            public ApiFuture<ListBgpRoutesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBgpRoutesRoutersRequest, RoutersListBgpRoutes> callable,
                ListBgpRoutesRoutersRequest request,
                ApiCallContext context,
                ApiFuture<RoutersListBgpRoutes> futureResponse) {
              PageContext<ListBgpRoutesRoutersRequest, RoutersListBgpRoutes, BgpRoute> pageContext =
                  PageContext.create(callable, LIST_BGP_ROUTES_PAGE_STR_DESC, request, context);
              return ListBgpRoutesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListRoutePoliciesRoutersRequest, RoutersListRoutePolicies, ListRoutePoliciesPagedResponse>
      LIST_ROUTE_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRoutePoliciesRoutersRequest,
              RoutersListRoutePolicies,
              ListRoutePoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListRoutePoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRoutePoliciesRoutersRequest, RoutersListRoutePolicies> callable,
                ListRoutePoliciesRoutersRequest request,
                ApiCallContext context,
                ApiFuture<RoutersListRoutePolicies> futureResponse) {
              PageContext<ListRoutePoliciesRoutersRequest, RoutersListRoutePolicies, RoutePolicy>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ROUTE_POLICIES_PAGE_STR_DESC, request, context);
              return ListRoutePoliciesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListRoutersRequest, RouterAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings() {
    return aggregatedListSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteRouterRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteRouterRequest, Operation, Operation>
      deleteOperationSettings() {
    return deleteOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteRoutePolicy. */
  public UnaryCallSettings<DeleteRoutePolicyRouterRequest, Operation> deleteRoutePolicySettings() {
    return deleteRoutePolicySettings;
  }

  /** Returns the object with the settings used for calls to deleteRoutePolicy. */
  public OperationCallSettings<DeleteRoutePolicyRouterRequest, Operation, Operation>
      deleteRoutePolicyOperationSettings() {
    return deleteRoutePolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetRouterRequest, Router> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to getNatIpInfo. */
  public UnaryCallSettings<GetNatIpInfoRouterRequest, NatIpInfoResponse> getNatIpInfoSettings() {
    return getNatIpInfoSettings;
  }

  /** Returns the object with the settings used for calls to getNatMappingInfo. */
  public PagedCallSettings<
          GetNatMappingInfoRoutersRequest,
          VmEndpointNatMappingsList,
          GetNatMappingInfoPagedResponse>
      getNatMappingInfoSettings() {
    return getNatMappingInfoSettings;
  }

  /** Returns the object with the settings used for calls to getRoutePolicy. */
  public UnaryCallSettings<GetRoutePolicyRouterRequest, RoutersGetRoutePolicyResponse>
      getRoutePolicySettings() {
    return getRoutePolicySettings;
  }

  /** Returns the object with the settings used for calls to getRouterStatus. */
  public UnaryCallSettings<GetRouterStatusRouterRequest, RouterStatusResponse>
      getRouterStatusSettings() {
    return getRouterStatusSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertRouterRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertRouterRequest, Operation, Operation>
      insertOperationSettings() {
    return insertOperationSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListRoutersRequest, RouterList, ListPagedResponse> listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to listBgpRoutes. */
  public PagedCallSettings<
          ListBgpRoutesRoutersRequest, RoutersListBgpRoutes, ListBgpRoutesPagedResponse>
      listBgpRoutesSettings() {
    return listBgpRoutesSettings;
  }

  /** Returns the object with the settings used for calls to listRoutePolicies. */
  public PagedCallSettings<
          ListRoutePoliciesRoutersRequest, RoutersListRoutePolicies, ListRoutePoliciesPagedResponse>
      listRoutePoliciesSettings() {
    return listRoutePoliciesSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchRouterRequest, Operation> patchSettings() {
    return patchSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchRouterRequest, Operation, Operation> patchOperationSettings() {
    return patchOperationSettings;
  }

  /** Returns the object with the settings used for calls to patchRoutePolicy. */
  public UnaryCallSettings<PatchRoutePolicyRouterRequest, Operation> patchRoutePolicySettings() {
    return patchRoutePolicySettings;
  }

  /** Returns the object with the settings used for calls to patchRoutePolicy. */
  public OperationCallSettings<PatchRoutePolicyRouterRequest, Operation, Operation>
      patchRoutePolicyOperationSettings() {
    return patchRoutePolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to preview. */
  public UnaryCallSettings<PreviewRouterRequest, RoutersPreviewResponse> previewSettings() {
    return previewSettings;
  }

  /** Returns the object with the settings used for calls to update. */
  public UnaryCallSettings<UpdateRouterRequest, Operation> updateSettings() {
    return updateSettings;
  }

  /** Returns the object with the settings used for calls to update. */
  public OperationCallSettings<UpdateRouterRequest, Operation, Operation>
      updateOperationSettings() {
    return updateOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateRoutePolicy. */
  public UnaryCallSettings<UpdateRoutePolicyRouterRequest, Operation> updateRoutePolicySettings() {
    return updateRoutePolicySettings;
  }

  /** Returns the object with the settings used for calls to updateRoutePolicy. */
  public OperationCallSettings<UpdateRoutePolicyRouterRequest, Operation, Operation>
      updateRoutePolicyOperationSettings() {
    return updateRoutePolicyOperationSettings;
  }

  public RoutersStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonRoutersStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "compute";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "compute.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "compute.mtls.googleapis.com:443";
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
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(RoutersStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
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

  protected RoutersStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    aggregatedListSettings = settingsBuilder.aggregatedListSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    deleteOperationSettings = settingsBuilder.deleteOperationSettings().build();
    deleteRoutePolicySettings = settingsBuilder.deleteRoutePolicySettings().build();
    deleteRoutePolicyOperationSettings =
        settingsBuilder.deleteRoutePolicyOperationSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    getNatIpInfoSettings = settingsBuilder.getNatIpInfoSettings().build();
    getNatMappingInfoSettings = settingsBuilder.getNatMappingInfoSettings().build();
    getRoutePolicySettings = settingsBuilder.getRoutePolicySettings().build();
    getRouterStatusSettings = settingsBuilder.getRouterStatusSettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    insertOperationSettings = settingsBuilder.insertOperationSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    listBgpRoutesSettings = settingsBuilder.listBgpRoutesSettings().build();
    listRoutePoliciesSettings = settingsBuilder.listRoutePoliciesSettings().build();
    patchSettings = settingsBuilder.patchSettings().build();
    patchOperationSettings = settingsBuilder.patchOperationSettings().build();
    patchRoutePolicySettings = settingsBuilder.patchRoutePolicySettings().build();
    patchRoutePolicyOperationSettings = settingsBuilder.patchRoutePolicyOperationSettings().build();
    previewSettings = settingsBuilder.previewSettings().build();
    updateSettings = settingsBuilder.updateSettings().build();
    updateOperationSettings = settingsBuilder.updateOperationSettings().build();
    updateRoutePolicySettings = settingsBuilder.updateRoutePolicySettings().build();
    updateRoutePolicyOperationSettings =
        settingsBuilder.updateRoutePolicyOperationSettings().build();
  }

  /** Builder for RoutersStubSettings. */
  public static class Builder extends StubSettings.Builder<RoutersStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            AggregatedListRoutersRequest, RouterAggregatedList, AggregatedListPagedResponse>
        aggregatedListSettings;
    private final UnaryCallSettings.Builder<DeleteRouterRequest, Operation> deleteSettings;
    private final OperationCallSettings.Builder<DeleteRouterRequest, Operation, Operation>
        deleteOperationSettings;
    private final UnaryCallSettings.Builder<DeleteRoutePolicyRouterRequest, Operation>
        deleteRoutePolicySettings;
    private final OperationCallSettings.Builder<
            DeleteRoutePolicyRouterRequest, Operation, Operation>
        deleteRoutePolicyOperationSettings;
    private final UnaryCallSettings.Builder<GetRouterRequest, Router> getSettings;
    private final UnaryCallSettings.Builder<GetNatIpInfoRouterRequest, NatIpInfoResponse>
        getNatIpInfoSettings;
    private final PagedCallSettings.Builder<
            GetNatMappingInfoRoutersRequest,
            VmEndpointNatMappingsList,
            GetNatMappingInfoPagedResponse>
        getNatMappingInfoSettings;
    private final UnaryCallSettings.Builder<
            GetRoutePolicyRouterRequest, RoutersGetRoutePolicyResponse>
        getRoutePolicySettings;
    private final UnaryCallSettings.Builder<GetRouterStatusRouterRequest, RouterStatusResponse>
        getRouterStatusSettings;
    private final UnaryCallSettings.Builder<InsertRouterRequest, Operation> insertSettings;
    private final OperationCallSettings.Builder<InsertRouterRequest, Operation, Operation>
        insertOperationSettings;
    private final PagedCallSettings.Builder<ListRoutersRequest, RouterList, ListPagedResponse>
        listSettings;
    private final PagedCallSettings.Builder<
            ListBgpRoutesRoutersRequest, RoutersListBgpRoutes, ListBgpRoutesPagedResponse>
        listBgpRoutesSettings;
    private final PagedCallSettings.Builder<
            ListRoutePoliciesRoutersRequest,
            RoutersListRoutePolicies,
            ListRoutePoliciesPagedResponse>
        listRoutePoliciesSettings;
    private final UnaryCallSettings.Builder<PatchRouterRequest, Operation> patchSettings;
    private final OperationCallSettings.Builder<PatchRouterRequest, Operation, Operation>
        patchOperationSettings;
    private final UnaryCallSettings.Builder<PatchRoutePolicyRouterRequest, Operation>
        patchRoutePolicySettings;
    private final OperationCallSettings.Builder<PatchRoutePolicyRouterRequest, Operation, Operation>
        patchRoutePolicyOperationSettings;
    private final UnaryCallSettings.Builder<PreviewRouterRequest, RoutersPreviewResponse>
        previewSettings;
    private final UnaryCallSettings.Builder<UpdateRouterRequest, Operation> updateSettings;
    private final OperationCallSettings.Builder<UpdateRouterRequest, Operation, Operation>
        updateOperationSettings;
    private final UnaryCallSettings.Builder<UpdateRoutePolicyRouterRequest, Operation>
        updateRoutePolicySettings;
    private final OperationCallSettings.Builder<
            UpdateRoutePolicyRouterRequest, Operation, Operation>
        updateRoutePolicyOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
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
              .setInitialRetryDelayDuration(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setTotalTimeoutDuration(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setTotalTimeoutDuration(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      aggregatedListSettings = PagedCallSettings.newBuilder(AGGREGATED_LIST_PAGE_STR_FACT);
      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteOperationSettings = OperationCallSettings.newBuilder();
      deleteRoutePolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteRoutePolicyOperationSettings = OperationCallSettings.newBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getNatIpInfoSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getNatMappingInfoSettings = PagedCallSettings.newBuilder(GET_NAT_MAPPING_INFO_PAGE_STR_FACT);
      getRoutePolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getRouterStatusSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertOperationSettings = OperationCallSettings.newBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      listBgpRoutesSettings = PagedCallSettings.newBuilder(LIST_BGP_ROUTES_PAGE_STR_FACT);
      listRoutePoliciesSettings = PagedCallSettings.newBuilder(LIST_ROUTE_POLICIES_PAGE_STR_FACT);
      patchSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      patchOperationSettings = OperationCallSettings.newBuilder();
      patchRoutePolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      patchRoutePolicyOperationSettings = OperationCallSettings.newBuilder();
      previewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateOperationSettings = OperationCallSettings.newBuilder();
      updateRoutePolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateRoutePolicyOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListSettings,
              deleteSettings,
              deleteRoutePolicySettings,
              getSettings,
              getNatIpInfoSettings,
              getNatMappingInfoSettings,
              getRoutePolicySettings,
              getRouterStatusSettings,
              insertSettings,
              listSettings,
              listBgpRoutesSettings,
              listRoutePoliciesSettings,
              patchSettings,
              patchRoutePolicySettings,
              previewSettings,
              updateSettings,
              updateRoutePolicySettings);
      initDefaults(this);
    }

    protected Builder(RoutersStubSettings settings) {
      super(settings);

      aggregatedListSettings = settings.aggregatedListSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      deleteOperationSettings = settings.deleteOperationSettings.toBuilder();
      deleteRoutePolicySettings = settings.deleteRoutePolicySettings.toBuilder();
      deleteRoutePolicyOperationSettings = settings.deleteRoutePolicyOperationSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      getNatIpInfoSettings = settings.getNatIpInfoSettings.toBuilder();
      getNatMappingInfoSettings = settings.getNatMappingInfoSettings.toBuilder();
      getRoutePolicySettings = settings.getRoutePolicySettings.toBuilder();
      getRouterStatusSettings = settings.getRouterStatusSettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      insertOperationSettings = settings.insertOperationSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      listBgpRoutesSettings = settings.listBgpRoutesSettings.toBuilder();
      listRoutePoliciesSettings = settings.listRoutePoliciesSettings.toBuilder();
      patchSettings = settings.patchSettings.toBuilder();
      patchOperationSettings = settings.patchOperationSettings.toBuilder();
      patchRoutePolicySettings = settings.patchRoutePolicySettings.toBuilder();
      patchRoutePolicyOperationSettings = settings.patchRoutePolicyOperationSettings.toBuilder();
      previewSettings = settings.previewSettings.toBuilder();
      updateSettings = settings.updateSettings.toBuilder();
      updateOperationSettings = settings.updateOperationSettings.toBuilder();
      updateRoutePolicySettings = settings.updateRoutePolicySettings.toBuilder();
      updateRoutePolicyOperationSettings = settings.updateRoutePolicyOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListSettings,
              deleteSettings,
              deleteRoutePolicySettings,
              getSettings,
              getNatIpInfoSettings,
              getNatMappingInfoSettings,
              getRoutePolicySettings,
              getRouterStatusSettings,
              insertSettings,
              listSettings,
              listBgpRoutesSettings,
              listRoutePoliciesSettings,
              patchSettings,
              patchRoutePolicySettings,
              previewSettings,
              updateSettings,
              updateRoutePolicySettings);
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
          .aggregatedListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteRoutePolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getNatIpInfoSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getNatMappingInfoSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getRoutePolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getRouterStatusSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .insertSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listBgpRoutesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listRoutePoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .patchSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .patchRoutePolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .previewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateRoutePolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteRouterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .deleteRoutePolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteRoutePolicyRouterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .insertOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<InsertRouterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .patchOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<PatchRouterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .patchRoutePolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<PatchRoutePolicyRouterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .updateOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateRouterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .updateRoutePolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateRoutePolicyRouterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
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

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListRoutersRequest, RouterAggregatedList, AggregatedListPagedResponse>
        aggregatedListSettings() {
      return aggregatedListSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteRouterRequest, Operation> deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteRouterRequest, Operation, Operation>
        deleteOperationSettings() {
      return deleteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRoutePolicy. */
    public UnaryCallSettings.Builder<DeleteRoutePolicyRouterRequest, Operation>
        deleteRoutePolicySettings() {
      return deleteRoutePolicySettings;
    }

    /** Returns the builder for the settings used for calls to deleteRoutePolicy. */
    public OperationCallSettings.Builder<DeleteRoutePolicyRouterRequest, Operation, Operation>
        deleteRoutePolicyOperationSettings() {
      return deleteRoutePolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetRouterRequest, Router> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to getNatIpInfo. */
    public UnaryCallSettings.Builder<GetNatIpInfoRouterRequest, NatIpInfoResponse>
        getNatIpInfoSettings() {
      return getNatIpInfoSettings;
    }

    /** Returns the builder for the settings used for calls to getNatMappingInfo. */
    public PagedCallSettings.Builder<
            GetNatMappingInfoRoutersRequest,
            VmEndpointNatMappingsList,
            GetNatMappingInfoPagedResponse>
        getNatMappingInfoSettings() {
      return getNatMappingInfoSettings;
    }

    /** Returns the builder for the settings used for calls to getRoutePolicy. */
    public UnaryCallSettings.Builder<GetRoutePolicyRouterRequest, RoutersGetRoutePolicyResponse>
        getRoutePolicySettings() {
      return getRoutePolicySettings;
    }

    /** Returns the builder for the settings used for calls to getRouterStatus. */
    public UnaryCallSettings.Builder<GetRouterStatusRouterRequest, RouterStatusResponse>
        getRouterStatusSettings() {
      return getRouterStatusSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertRouterRequest, Operation> insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertRouterRequest, Operation, Operation>
        insertOperationSettings() {
      return insertOperationSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<ListRoutersRequest, RouterList, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to listBgpRoutes. */
    public PagedCallSettings.Builder<
            ListBgpRoutesRoutersRequest, RoutersListBgpRoutes, ListBgpRoutesPagedResponse>
        listBgpRoutesSettings() {
      return listBgpRoutesSettings;
    }

    /** Returns the builder for the settings used for calls to listRoutePolicies. */
    public PagedCallSettings.Builder<
            ListRoutePoliciesRoutersRequest,
            RoutersListRoutePolicies,
            ListRoutePoliciesPagedResponse>
        listRoutePoliciesSettings() {
      return listRoutePoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchRouterRequest, Operation> patchSettings() {
      return patchSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    public OperationCallSettings.Builder<PatchRouterRequest, Operation, Operation>
        patchOperationSettings() {
      return patchOperationSettings;
    }

    /** Returns the builder for the settings used for calls to patchRoutePolicy. */
    public UnaryCallSettings.Builder<PatchRoutePolicyRouterRequest, Operation>
        patchRoutePolicySettings() {
      return patchRoutePolicySettings;
    }

    /** Returns the builder for the settings used for calls to patchRoutePolicy. */
    public OperationCallSettings.Builder<PatchRoutePolicyRouterRequest, Operation, Operation>
        patchRoutePolicyOperationSettings() {
      return patchRoutePolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to preview. */
    public UnaryCallSettings.Builder<PreviewRouterRequest, RoutersPreviewResponse>
        previewSettings() {
      return previewSettings;
    }

    /** Returns the builder for the settings used for calls to update. */
    public UnaryCallSettings.Builder<UpdateRouterRequest, Operation> updateSettings() {
      return updateSettings;
    }

    /** Returns the builder for the settings used for calls to update. */
    public OperationCallSettings.Builder<UpdateRouterRequest, Operation, Operation>
        updateOperationSettings() {
      return updateOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateRoutePolicy. */
    public UnaryCallSettings.Builder<UpdateRoutePolicyRouterRequest, Operation>
        updateRoutePolicySettings() {
      return updateRoutePolicySettings;
    }

    /** Returns the builder for the settings used for calls to updateRoutePolicy. */
    public OperationCallSettings.Builder<UpdateRoutePolicyRouterRequest, Operation, Operation>
        updateRoutePolicyOperationSettings() {
      return updateRoutePolicyOperationSettings;
    }

    @Override
    public RoutersStubSettings build() throws IOException {
      return new RoutersStubSettings(this);
    }
  }
}
