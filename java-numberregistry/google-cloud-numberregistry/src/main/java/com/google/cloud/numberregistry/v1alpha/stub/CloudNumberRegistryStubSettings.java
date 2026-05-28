/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.numberregistry.v1alpha.stub;

import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListCustomRangesPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListDiscoveredRangesPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListIpamAdminScopesPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListRealmsPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListRegistryBooksPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.SearchIpResourcesPagedResponse;

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
import com.google.api.gax.rpc.LibraryMetadata;
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
import com.google.cloud.numberregistry.v1alpha.CheckAvailabilityIpamAdminScopesRequest;
import com.google.cloud.numberregistry.v1alpha.CheckAvailabilityIpamAdminScopesResponse;
import com.google.cloud.numberregistry.v1alpha.CleanupIpamAdminScopeRequest;
import com.google.cloud.numberregistry.v1alpha.CreateCustomRangeRequest;
import com.google.cloud.numberregistry.v1alpha.CreateIpamAdminScopeRequest;
import com.google.cloud.numberregistry.v1alpha.CreateRealmRequest;
import com.google.cloud.numberregistry.v1alpha.CreateRegistryBookRequest;
import com.google.cloud.numberregistry.v1alpha.CustomRange;
import com.google.cloud.numberregistry.v1alpha.DeleteCustomRangeRequest;
import com.google.cloud.numberregistry.v1alpha.DeleteIpamAdminScopeRequest;
import com.google.cloud.numberregistry.v1alpha.DeleteRealmRequest;
import com.google.cloud.numberregistry.v1alpha.DeleteRegistryBookRequest;
import com.google.cloud.numberregistry.v1alpha.DisableIpamAdminScopeRequest;
import com.google.cloud.numberregistry.v1alpha.DiscoveredRange;
import com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesRequest;
import com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesResponse;
import com.google.cloud.numberregistry.v1alpha.FindDiscoveredRangeFreeIpRangesRequest;
import com.google.cloud.numberregistry.v1alpha.FindDiscoveredRangeFreeIpRangesResponse;
import com.google.cloud.numberregistry.v1alpha.GetCustomRangeRequest;
import com.google.cloud.numberregistry.v1alpha.GetDiscoveredRangeRequest;
import com.google.cloud.numberregistry.v1alpha.GetIpamAdminScopeRequest;
import com.google.cloud.numberregistry.v1alpha.GetRealmRequest;
import com.google.cloud.numberregistry.v1alpha.GetRegistryBookRequest;
import com.google.cloud.numberregistry.v1alpha.IpamAdminScope;
import com.google.cloud.numberregistry.v1alpha.ListCustomRangesRequest;
import com.google.cloud.numberregistry.v1alpha.ListCustomRangesResponse;
import com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesRequest;
import com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesResponse;
import com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesRequest;
import com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesResponse;
import com.google.cloud.numberregistry.v1alpha.ListRealmsRequest;
import com.google.cloud.numberregistry.v1alpha.ListRealmsResponse;
import com.google.cloud.numberregistry.v1alpha.ListRegistryBooksRequest;
import com.google.cloud.numberregistry.v1alpha.ListRegistryBooksResponse;
import com.google.cloud.numberregistry.v1alpha.OperationMetadata;
import com.google.cloud.numberregistry.v1alpha.Range;
import com.google.cloud.numberregistry.v1alpha.Realm;
import com.google.cloud.numberregistry.v1alpha.RegistryBook;
import com.google.cloud.numberregistry.v1alpha.SearchIpResourcesRequest;
import com.google.cloud.numberregistry.v1alpha.SearchIpResourcesResponse;
import com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationRequest;
import com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationResponse;
import com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationRequest;
import com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationResponse;
import com.google.cloud.numberregistry.v1alpha.UpdateCustomRangeRequest;
import com.google.cloud.numberregistry.v1alpha.UpdateIpamAdminScopeRequest;
import com.google.cloud.numberregistry.v1alpha.UpdateRealmRequest;
import com.google.cloud.numberregistry.v1alpha.UpdateRegistryBookRequest;
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
 * Settings class to configure an instance of {@link CloudNumberRegistryStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudnumberregistry.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getIpamAdminScope:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudNumberRegistryStubSettings.Builder cloudNumberRegistrySettingsBuilder =
 *     CloudNumberRegistryStubSettings.newBuilder();
 * cloudNumberRegistrySettingsBuilder
 *     .getIpamAdminScopeSettings()
 *     .setRetrySettings(
 *         cloudNumberRegistrySettingsBuilder
 *             .getIpamAdminScopeSettings()
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
 * CloudNumberRegistryStubSettings cloudNumberRegistrySettings =
 *     cloudNumberRegistrySettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createIpamAdminScope:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudNumberRegistryStubSettings.Builder cloudNumberRegistrySettingsBuilder =
 *     CloudNumberRegistryStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * cloudNumberRegistrySettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class CloudNumberRegistryStubSettings extends StubSettings<CloudNumberRegistryStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListIpamAdminScopesRequest, ListIpamAdminScopesResponse, ListIpamAdminScopesPagedResponse>
      listIpamAdminScopesSettings;
  private final UnaryCallSettings<GetIpamAdminScopeRequest, IpamAdminScope>
      getIpamAdminScopeSettings;
  private final UnaryCallSettings<
          CheckAvailabilityIpamAdminScopesRequest, CheckAvailabilityIpamAdminScopesResponse>
      checkAvailabilityIpamAdminScopesSettings;
  private final UnaryCallSettings<CreateIpamAdminScopeRequest, Operation>
      createIpamAdminScopeSettings;
  private final OperationCallSettings<
          CreateIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      createIpamAdminScopeOperationSettings;
  private final UnaryCallSettings<UpdateIpamAdminScopeRequest, Operation>
      updateIpamAdminScopeSettings;
  private final OperationCallSettings<
          UpdateIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      updateIpamAdminScopeOperationSettings;
  private final UnaryCallSettings<DeleteIpamAdminScopeRequest, Operation>
      deleteIpamAdminScopeSettings;
  private final OperationCallSettings<DeleteIpamAdminScopeRequest, Empty, OperationMetadata>
      deleteIpamAdminScopeOperationSettings;
  private final UnaryCallSettings<DisableIpamAdminScopeRequest, Operation>
      disableIpamAdminScopeSettings;
  private final OperationCallSettings<
          DisableIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      disableIpamAdminScopeOperationSettings;
  private final UnaryCallSettings<CleanupIpamAdminScopeRequest, Operation>
      cleanupIpamAdminScopeSettings;
  private final OperationCallSettings<
          CleanupIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      cleanupIpamAdminScopeOperationSettings;
  private final PagedCallSettings<
          ListRegistryBooksRequest, ListRegistryBooksResponse, ListRegistryBooksPagedResponse>
      listRegistryBooksSettings;
  private final UnaryCallSettings<GetRegistryBookRequest, RegistryBook> getRegistryBookSettings;
  private final PagedCallSettings<
          SearchIpResourcesRequest, SearchIpResourcesResponse, SearchIpResourcesPagedResponse>
      searchIpResourcesSettings;
  private final UnaryCallSettings<CreateRegistryBookRequest, Operation> createRegistryBookSettings;
  private final OperationCallSettings<CreateRegistryBookRequest, RegistryBook, OperationMetadata>
      createRegistryBookOperationSettings;
  private final UnaryCallSettings<UpdateRegistryBookRequest, Operation> updateRegistryBookSettings;
  private final OperationCallSettings<UpdateRegistryBookRequest, RegistryBook, OperationMetadata>
      updateRegistryBookOperationSettings;
  private final UnaryCallSettings<DeleteRegistryBookRequest, Operation> deleteRegistryBookSettings;
  private final OperationCallSettings<DeleteRegistryBookRequest, Empty, OperationMetadata>
      deleteRegistryBookOperationSettings;
  private final PagedCallSettings<ListRealmsRequest, ListRealmsResponse, ListRealmsPagedResponse>
      listRealmsSettings;
  private final UnaryCallSettings<GetRealmRequest, Realm> getRealmSettings;
  private final UnaryCallSettings<CreateRealmRequest, Operation> createRealmSettings;
  private final OperationCallSettings<CreateRealmRequest, Realm, OperationMetadata>
      createRealmOperationSettings;
  private final UnaryCallSettings<UpdateRealmRequest, Operation> updateRealmSettings;
  private final OperationCallSettings<UpdateRealmRequest, Realm, OperationMetadata>
      updateRealmOperationSettings;
  private final UnaryCallSettings<DeleteRealmRequest, Operation> deleteRealmSettings;
  private final OperationCallSettings<DeleteRealmRequest, Empty, OperationMetadata>
      deleteRealmOperationSettings;
  private final PagedCallSettings<
          ListDiscoveredRangesRequest,
          ListDiscoveredRangesResponse,
          ListDiscoveredRangesPagedResponse>
      listDiscoveredRangesSettings;
  private final UnaryCallSettings<GetDiscoveredRangeRequest, DiscoveredRange>
      getDiscoveredRangeSettings;
  private final UnaryCallSettings<
          FindDiscoveredRangeFreeIpRangesRequest, FindDiscoveredRangeFreeIpRangesResponse>
      findDiscoveredRangeFreeIpRangesSettings;
  private final PagedCallSettings<
          ListCustomRangesRequest, ListCustomRangesResponse, ListCustomRangesPagedResponse>
      listCustomRangesSettings;
  private final UnaryCallSettings<GetCustomRangeRequest, CustomRange> getCustomRangeSettings;
  private final UnaryCallSettings<
          ShowCustomRangeUtilizationRequest, ShowCustomRangeUtilizationResponse>
      showCustomRangeUtilizationSettings;
  private final UnaryCallSettings<
          ShowDiscoveredRangeUtilizationRequest, ShowDiscoveredRangeUtilizationResponse>
      showDiscoveredRangeUtilizationSettings;
  private final UnaryCallSettings<
          FindCustomRangeFreeIpRangesRequest, FindCustomRangeFreeIpRangesResponse>
      findCustomRangeFreeIpRangesSettings;
  private final UnaryCallSettings<CreateCustomRangeRequest, Operation> createCustomRangeSettings;
  private final OperationCallSettings<CreateCustomRangeRequest, CustomRange, OperationMetadata>
      createCustomRangeOperationSettings;
  private final UnaryCallSettings<UpdateCustomRangeRequest, Operation> updateCustomRangeSettings;
  private final OperationCallSettings<UpdateCustomRangeRequest, CustomRange, OperationMetadata>
      updateCustomRangeOperationSettings;
  private final UnaryCallSettings<DeleteCustomRangeRequest, Operation> deleteCustomRangeSettings;
  private final OperationCallSettings<DeleteCustomRangeRequest, Empty, OperationMetadata>
      deleteCustomRangeOperationSettings;

  private static final PagedListDescriptor<
          ListIpamAdminScopesRequest, ListIpamAdminScopesResponse, IpamAdminScope>
      LIST_IPAM_ADMIN_SCOPES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListIpamAdminScopesRequest, ListIpamAdminScopesResponse, IpamAdminScope>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListIpamAdminScopesRequest injectToken(
                ListIpamAdminScopesRequest payload, String token) {
              return ListIpamAdminScopesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListIpamAdminScopesRequest injectPageSize(
                ListIpamAdminScopesRequest payload, int pageSize) {
              return ListIpamAdminScopesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListIpamAdminScopesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListIpamAdminScopesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<IpamAdminScope> extractResources(ListIpamAdminScopesResponse payload) {
              return payload.getIpamAdminScopesList();
            }
          };

  private static final PagedListDescriptor<
          ListRegistryBooksRequest, ListRegistryBooksResponse, RegistryBook>
      LIST_REGISTRY_BOOKS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListRegistryBooksRequest, ListRegistryBooksResponse, RegistryBook>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRegistryBooksRequest injectToken(
                ListRegistryBooksRequest payload, String token) {
              return ListRegistryBooksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRegistryBooksRequest injectPageSize(
                ListRegistryBooksRequest payload, int pageSize) {
              return ListRegistryBooksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRegistryBooksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRegistryBooksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<RegistryBook> extractResources(ListRegistryBooksResponse payload) {
              return payload.getRegistryBooksList();
            }
          };

  private static final PagedListDescriptor<
          SearchIpResourcesRequest, SearchIpResourcesResponse, Range>
      SEARCH_IP_RESOURCES_PAGE_STR_DESC =
          new PagedListDescriptor<SearchIpResourcesRequest, SearchIpResourcesResponse, Range>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchIpResourcesRequest injectToken(
                SearchIpResourcesRequest payload, String token) {
              return SearchIpResourcesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchIpResourcesRequest injectPageSize(
                SearchIpResourcesRequest payload, int pageSize) {
              return SearchIpResourcesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchIpResourcesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchIpResourcesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Range> extractResources(SearchIpResourcesResponse payload) {
              return payload.getRangesList();
            }
          };

  private static final PagedListDescriptor<ListRealmsRequest, ListRealmsResponse, Realm>
      LIST_REALMS_PAGE_STR_DESC =
          new PagedListDescriptor<ListRealmsRequest, ListRealmsResponse, Realm>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRealmsRequest injectToken(ListRealmsRequest payload, String token) {
              return ListRealmsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRealmsRequest injectPageSize(ListRealmsRequest payload, int pageSize) {
              return ListRealmsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRealmsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRealmsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Realm> extractResources(ListRealmsResponse payload) {
              return payload.getRealmsList();
            }
          };

  private static final PagedListDescriptor<
          ListDiscoveredRangesRequest, ListDiscoveredRangesResponse, DiscoveredRange>
      LIST_DISCOVERED_RANGES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDiscoveredRangesRequest, ListDiscoveredRangesResponse, DiscoveredRange>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDiscoveredRangesRequest injectToken(
                ListDiscoveredRangesRequest payload, String token) {
              return ListDiscoveredRangesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDiscoveredRangesRequest injectPageSize(
                ListDiscoveredRangesRequest payload, int pageSize) {
              return ListDiscoveredRangesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDiscoveredRangesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDiscoveredRangesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DiscoveredRange> extractResources(
                ListDiscoveredRangesResponse payload) {
              return payload.getDiscoveredRangesList();
            }
          };

  private static final PagedListDescriptor<
          ListCustomRangesRequest, ListCustomRangesResponse, CustomRange>
      LIST_CUSTOM_RANGES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListCustomRangesRequest, ListCustomRangesResponse, CustomRange>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCustomRangesRequest injectToken(
                ListCustomRangesRequest payload, String token) {
              return ListCustomRangesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCustomRangesRequest injectPageSize(
                ListCustomRangesRequest payload, int pageSize) {
              return ListCustomRangesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCustomRangesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCustomRangesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CustomRange> extractResources(ListCustomRangesResponse payload) {
              return payload.getCustomRangesList();
            }
          };

  private static final PagedListResponseFactory<
          ListIpamAdminScopesRequest, ListIpamAdminScopesResponse, ListIpamAdminScopesPagedResponse>
      LIST_IPAM_ADMIN_SCOPES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListIpamAdminScopesRequest,
              ListIpamAdminScopesResponse,
              ListIpamAdminScopesPagedResponse>() {
            @Override
            public ApiFuture<ListIpamAdminScopesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListIpamAdminScopesRequest, ListIpamAdminScopesResponse> callable,
                ListIpamAdminScopesRequest request,
                ApiCallContext context,
                ApiFuture<ListIpamAdminScopesResponse> futureResponse) {
              PageContext<ListIpamAdminScopesRequest, ListIpamAdminScopesResponse, IpamAdminScope>
                  pageContext =
                      PageContext.create(
                          callable, LIST_IPAM_ADMIN_SCOPES_PAGE_STR_DESC, request, context);
              return ListIpamAdminScopesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListRegistryBooksRequest, ListRegistryBooksResponse, ListRegistryBooksPagedResponse>
      LIST_REGISTRY_BOOKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRegistryBooksRequest,
              ListRegistryBooksResponse,
              ListRegistryBooksPagedResponse>() {
            @Override
            public ApiFuture<ListRegistryBooksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRegistryBooksRequest, ListRegistryBooksResponse> callable,
                ListRegistryBooksRequest request,
                ApiCallContext context,
                ApiFuture<ListRegistryBooksResponse> futureResponse) {
              PageContext<ListRegistryBooksRequest, ListRegistryBooksResponse, RegistryBook>
                  pageContext =
                      PageContext.create(
                          callable, LIST_REGISTRY_BOOKS_PAGE_STR_DESC, request, context);
              return ListRegistryBooksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchIpResourcesRequest, SearchIpResourcesResponse, SearchIpResourcesPagedResponse>
      SEARCH_IP_RESOURCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchIpResourcesRequest,
              SearchIpResourcesResponse,
              SearchIpResourcesPagedResponse>() {
            @Override
            public ApiFuture<SearchIpResourcesPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchIpResourcesRequest, SearchIpResourcesResponse> callable,
                SearchIpResourcesRequest request,
                ApiCallContext context,
                ApiFuture<SearchIpResourcesResponse> futureResponse) {
              PageContext<SearchIpResourcesRequest, SearchIpResourcesResponse, Range> pageContext =
                  PageContext.create(callable, SEARCH_IP_RESOURCES_PAGE_STR_DESC, request, context);
              return SearchIpResourcesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListRealmsRequest, ListRealmsResponse, ListRealmsPagedResponse>
      LIST_REALMS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRealmsRequest, ListRealmsResponse, ListRealmsPagedResponse>() {
            @Override
            public ApiFuture<ListRealmsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRealmsRequest, ListRealmsResponse> callable,
                ListRealmsRequest request,
                ApiCallContext context,
                ApiFuture<ListRealmsResponse> futureResponse) {
              PageContext<ListRealmsRequest, ListRealmsResponse, Realm> pageContext =
                  PageContext.create(callable, LIST_REALMS_PAGE_STR_DESC, request, context);
              return ListRealmsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDiscoveredRangesRequest,
          ListDiscoveredRangesResponse,
          ListDiscoveredRangesPagedResponse>
      LIST_DISCOVERED_RANGES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDiscoveredRangesRequest,
              ListDiscoveredRangesResponse,
              ListDiscoveredRangesPagedResponse>() {
            @Override
            public ApiFuture<ListDiscoveredRangesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDiscoveredRangesRequest, ListDiscoveredRangesResponse> callable,
                ListDiscoveredRangesRequest request,
                ApiCallContext context,
                ApiFuture<ListDiscoveredRangesResponse> futureResponse) {
              PageContext<
                      ListDiscoveredRangesRequest, ListDiscoveredRangesResponse, DiscoveredRange>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DISCOVERED_RANGES_PAGE_STR_DESC, request, context);
              return ListDiscoveredRangesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCustomRangesRequest, ListCustomRangesResponse, ListCustomRangesPagedResponse>
      LIST_CUSTOM_RANGES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCustomRangesRequest, ListCustomRangesResponse, ListCustomRangesPagedResponse>() {
            @Override
            public ApiFuture<ListCustomRangesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCustomRangesRequest, ListCustomRangesResponse> callable,
                ListCustomRangesRequest request,
                ApiCallContext context,
                ApiFuture<ListCustomRangesResponse> futureResponse) {
              PageContext<ListCustomRangesRequest, ListCustomRangesResponse, CustomRange>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CUSTOM_RANGES_PAGE_STR_DESC, request, context);
              return ListCustomRangesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listIpamAdminScopes. */
  public PagedCallSettings<
          ListIpamAdminScopesRequest, ListIpamAdminScopesResponse, ListIpamAdminScopesPagedResponse>
      listIpamAdminScopesSettings() {
    return listIpamAdminScopesSettings;
  }

  /** Returns the object with the settings used for calls to getIpamAdminScope. */
  public UnaryCallSettings<GetIpamAdminScopeRequest, IpamAdminScope> getIpamAdminScopeSettings() {
    return getIpamAdminScopeSettings;
  }

  /** Returns the object with the settings used for calls to checkAvailabilityIpamAdminScopes. */
  public UnaryCallSettings<
          CheckAvailabilityIpamAdminScopesRequest, CheckAvailabilityIpamAdminScopesResponse>
      checkAvailabilityIpamAdminScopesSettings() {
    return checkAvailabilityIpamAdminScopesSettings;
  }

  /** Returns the object with the settings used for calls to createIpamAdminScope. */
  public UnaryCallSettings<CreateIpamAdminScopeRequest, Operation> createIpamAdminScopeSettings() {
    return createIpamAdminScopeSettings;
  }

  /** Returns the object with the settings used for calls to createIpamAdminScope. */
  public OperationCallSettings<CreateIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      createIpamAdminScopeOperationSettings() {
    return createIpamAdminScopeOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateIpamAdminScope. */
  public UnaryCallSettings<UpdateIpamAdminScopeRequest, Operation> updateIpamAdminScopeSettings() {
    return updateIpamAdminScopeSettings;
  }

  /** Returns the object with the settings used for calls to updateIpamAdminScope. */
  public OperationCallSettings<UpdateIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      updateIpamAdminScopeOperationSettings() {
    return updateIpamAdminScopeOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteIpamAdminScope. */
  public UnaryCallSettings<DeleteIpamAdminScopeRequest, Operation> deleteIpamAdminScopeSettings() {
    return deleteIpamAdminScopeSettings;
  }

  /** Returns the object with the settings used for calls to deleteIpamAdminScope. */
  public OperationCallSettings<DeleteIpamAdminScopeRequest, Empty, OperationMetadata>
      deleteIpamAdminScopeOperationSettings() {
    return deleteIpamAdminScopeOperationSettings;
  }

  /** Returns the object with the settings used for calls to disableIpamAdminScope. */
  public UnaryCallSettings<DisableIpamAdminScopeRequest, Operation>
      disableIpamAdminScopeSettings() {
    return disableIpamAdminScopeSettings;
  }

  /** Returns the object with the settings used for calls to disableIpamAdminScope. */
  public OperationCallSettings<DisableIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      disableIpamAdminScopeOperationSettings() {
    return disableIpamAdminScopeOperationSettings;
  }

  /** Returns the object with the settings used for calls to cleanupIpamAdminScope. */
  public UnaryCallSettings<CleanupIpamAdminScopeRequest, Operation>
      cleanupIpamAdminScopeSettings() {
    return cleanupIpamAdminScopeSettings;
  }

  /** Returns the object with the settings used for calls to cleanupIpamAdminScope. */
  public OperationCallSettings<CleanupIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      cleanupIpamAdminScopeOperationSettings() {
    return cleanupIpamAdminScopeOperationSettings;
  }

  /** Returns the object with the settings used for calls to listRegistryBooks. */
  public PagedCallSettings<
          ListRegistryBooksRequest, ListRegistryBooksResponse, ListRegistryBooksPagedResponse>
      listRegistryBooksSettings() {
    return listRegistryBooksSettings;
  }

  /** Returns the object with the settings used for calls to getRegistryBook. */
  public UnaryCallSettings<GetRegistryBookRequest, RegistryBook> getRegistryBookSettings() {
    return getRegistryBookSettings;
  }

  /** Returns the object with the settings used for calls to searchIpResources. */
  public PagedCallSettings<
          SearchIpResourcesRequest, SearchIpResourcesResponse, SearchIpResourcesPagedResponse>
      searchIpResourcesSettings() {
    return searchIpResourcesSettings;
  }

  /** Returns the object with the settings used for calls to createRegistryBook. */
  public UnaryCallSettings<CreateRegistryBookRequest, Operation> createRegistryBookSettings() {
    return createRegistryBookSettings;
  }

  /** Returns the object with the settings used for calls to createRegistryBook. */
  public OperationCallSettings<CreateRegistryBookRequest, RegistryBook, OperationMetadata>
      createRegistryBookOperationSettings() {
    return createRegistryBookOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateRegistryBook. */
  public UnaryCallSettings<UpdateRegistryBookRequest, Operation> updateRegistryBookSettings() {
    return updateRegistryBookSettings;
  }

  /** Returns the object with the settings used for calls to updateRegistryBook. */
  public OperationCallSettings<UpdateRegistryBookRequest, RegistryBook, OperationMetadata>
      updateRegistryBookOperationSettings() {
    return updateRegistryBookOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteRegistryBook. */
  public UnaryCallSettings<DeleteRegistryBookRequest, Operation> deleteRegistryBookSettings() {
    return deleteRegistryBookSettings;
  }

  /** Returns the object with the settings used for calls to deleteRegistryBook. */
  public OperationCallSettings<DeleteRegistryBookRequest, Empty, OperationMetadata>
      deleteRegistryBookOperationSettings() {
    return deleteRegistryBookOperationSettings;
  }

  /** Returns the object with the settings used for calls to listRealms. */
  public PagedCallSettings<ListRealmsRequest, ListRealmsResponse, ListRealmsPagedResponse>
      listRealmsSettings() {
    return listRealmsSettings;
  }

  /** Returns the object with the settings used for calls to getRealm. */
  public UnaryCallSettings<GetRealmRequest, Realm> getRealmSettings() {
    return getRealmSettings;
  }

  /** Returns the object with the settings used for calls to createRealm. */
  public UnaryCallSettings<CreateRealmRequest, Operation> createRealmSettings() {
    return createRealmSettings;
  }

  /** Returns the object with the settings used for calls to createRealm. */
  public OperationCallSettings<CreateRealmRequest, Realm, OperationMetadata>
      createRealmOperationSettings() {
    return createRealmOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateRealm. */
  public UnaryCallSettings<UpdateRealmRequest, Operation> updateRealmSettings() {
    return updateRealmSettings;
  }

  /** Returns the object with the settings used for calls to updateRealm. */
  public OperationCallSettings<UpdateRealmRequest, Realm, OperationMetadata>
      updateRealmOperationSettings() {
    return updateRealmOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteRealm. */
  public UnaryCallSettings<DeleteRealmRequest, Operation> deleteRealmSettings() {
    return deleteRealmSettings;
  }

  /** Returns the object with the settings used for calls to deleteRealm. */
  public OperationCallSettings<DeleteRealmRequest, Empty, OperationMetadata>
      deleteRealmOperationSettings() {
    return deleteRealmOperationSettings;
  }

  /** Returns the object with the settings used for calls to listDiscoveredRanges. */
  public PagedCallSettings<
          ListDiscoveredRangesRequest,
          ListDiscoveredRangesResponse,
          ListDiscoveredRangesPagedResponse>
      listDiscoveredRangesSettings() {
    return listDiscoveredRangesSettings;
  }

  /** Returns the object with the settings used for calls to getDiscoveredRange. */
  public UnaryCallSettings<GetDiscoveredRangeRequest, DiscoveredRange>
      getDiscoveredRangeSettings() {
    return getDiscoveredRangeSettings;
  }

  /** Returns the object with the settings used for calls to findDiscoveredRangeFreeIpRanges. */
  public UnaryCallSettings<
          FindDiscoveredRangeFreeIpRangesRequest, FindDiscoveredRangeFreeIpRangesResponse>
      findDiscoveredRangeFreeIpRangesSettings() {
    return findDiscoveredRangeFreeIpRangesSettings;
  }

  /** Returns the object with the settings used for calls to listCustomRanges. */
  public PagedCallSettings<
          ListCustomRangesRequest, ListCustomRangesResponse, ListCustomRangesPagedResponse>
      listCustomRangesSettings() {
    return listCustomRangesSettings;
  }

  /** Returns the object with the settings used for calls to getCustomRange. */
  public UnaryCallSettings<GetCustomRangeRequest, CustomRange> getCustomRangeSettings() {
    return getCustomRangeSettings;
  }

  /** Returns the object with the settings used for calls to showCustomRangeUtilization. */
  public UnaryCallSettings<ShowCustomRangeUtilizationRequest, ShowCustomRangeUtilizationResponse>
      showCustomRangeUtilizationSettings() {
    return showCustomRangeUtilizationSettings;
  }

  /** Returns the object with the settings used for calls to showDiscoveredRangeUtilization. */
  public UnaryCallSettings<
          ShowDiscoveredRangeUtilizationRequest, ShowDiscoveredRangeUtilizationResponse>
      showDiscoveredRangeUtilizationSettings() {
    return showDiscoveredRangeUtilizationSettings;
  }

  /** Returns the object with the settings used for calls to findCustomRangeFreeIpRanges. */
  public UnaryCallSettings<FindCustomRangeFreeIpRangesRequest, FindCustomRangeFreeIpRangesResponse>
      findCustomRangeFreeIpRangesSettings() {
    return findCustomRangeFreeIpRangesSettings;
  }

  /** Returns the object with the settings used for calls to createCustomRange. */
  public UnaryCallSettings<CreateCustomRangeRequest, Operation> createCustomRangeSettings() {
    return createCustomRangeSettings;
  }

  /** Returns the object with the settings used for calls to createCustomRange. */
  public OperationCallSettings<CreateCustomRangeRequest, CustomRange, OperationMetadata>
      createCustomRangeOperationSettings() {
    return createCustomRangeOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateCustomRange. */
  public UnaryCallSettings<UpdateCustomRangeRequest, Operation> updateCustomRangeSettings() {
    return updateCustomRangeSettings;
  }

  /** Returns the object with the settings used for calls to updateCustomRange. */
  public OperationCallSettings<UpdateCustomRangeRequest, CustomRange, OperationMetadata>
      updateCustomRangeOperationSettings() {
    return updateCustomRangeOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteCustomRange. */
  public UnaryCallSettings<DeleteCustomRangeRequest, Operation> deleteCustomRangeSettings() {
    return deleteCustomRangeSettings;
  }

  /** Returns the object with the settings used for calls to deleteCustomRange. */
  public OperationCallSettings<DeleteCustomRangeRequest, Empty, OperationMetadata>
      deleteCustomRangeOperationSettings() {
    return deleteCustomRangeOperationSettings;
  }

  public CloudNumberRegistryStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcCloudNumberRegistryStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonCloudNumberRegistryStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "cloudnumberregistry";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "cloudnumberregistry.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "cloudnumberregistry.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(CloudNumberRegistryStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(CloudNumberRegistryStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CloudNumberRegistryStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected CloudNumberRegistryStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listIpamAdminScopesSettings = settingsBuilder.listIpamAdminScopesSettings().build();
    getIpamAdminScopeSettings = settingsBuilder.getIpamAdminScopeSettings().build();
    checkAvailabilityIpamAdminScopesSettings =
        settingsBuilder.checkAvailabilityIpamAdminScopesSettings().build();
    createIpamAdminScopeSettings = settingsBuilder.createIpamAdminScopeSettings().build();
    createIpamAdminScopeOperationSettings =
        settingsBuilder.createIpamAdminScopeOperationSettings().build();
    updateIpamAdminScopeSettings = settingsBuilder.updateIpamAdminScopeSettings().build();
    updateIpamAdminScopeOperationSettings =
        settingsBuilder.updateIpamAdminScopeOperationSettings().build();
    deleteIpamAdminScopeSettings = settingsBuilder.deleteIpamAdminScopeSettings().build();
    deleteIpamAdminScopeOperationSettings =
        settingsBuilder.deleteIpamAdminScopeOperationSettings().build();
    disableIpamAdminScopeSettings = settingsBuilder.disableIpamAdminScopeSettings().build();
    disableIpamAdminScopeOperationSettings =
        settingsBuilder.disableIpamAdminScopeOperationSettings().build();
    cleanupIpamAdminScopeSettings = settingsBuilder.cleanupIpamAdminScopeSettings().build();
    cleanupIpamAdminScopeOperationSettings =
        settingsBuilder.cleanupIpamAdminScopeOperationSettings().build();
    listRegistryBooksSettings = settingsBuilder.listRegistryBooksSettings().build();
    getRegistryBookSettings = settingsBuilder.getRegistryBookSettings().build();
    searchIpResourcesSettings = settingsBuilder.searchIpResourcesSettings().build();
    createRegistryBookSettings = settingsBuilder.createRegistryBookSettings().build();
    createRegistryBookOperationSettings =
        settingsBuilder.createRegistryBookOperationSettings().build();
    updateRegistryBookSettings = settingsBuilder.updateRegistryBookSettings().build();
    updateRegistryBookOperationSettings =
        settingsBuilder.updateRegistryBookOperationSettings().build();
    deleteRegistryBookSettings = settingsBuilder.deleteRegistryBookSettings().build();
    deleteRegistryBookOperationSettings =
        settingsBuilder.deleteRegistryBookOperationSettings().build();
    listRealmsSettings = settingsBuilder.listRealmsSettings().build();
    getRealmSettings = settingsBuilder.getRealmSettings().build();
    createRealmSettings = settingsBuilder.createRealmSettings().build();
    createRealmOperationSettings = settingsBuilder.createRealmOperationSettings().build();
    updateRealmSettings = settingsBuilder.updateRealmSettings().build();
    updateRealmOperationSettings = settingsBuilder.updateRealmOperationSettings().build();
    deleteRealmSettings = settingsBuilder.deleteRealmSettings().build();
    deleteRealmOperationSettings = settingsBuilder.deleteRealmOperationSettings().build();
    listDiscoveredRangesSettings = settingsBuilder.listDiscoveredRangesSettings().build();
    getDiscoveredRangeSettings = settingsBuilder.getDiscoveredRangeSettings().build();
    findDiscoveredRangeFreeIpRangesSettings =
        settingsBuilder.findDiscoveredRangeFreeIpRangesSettings().build();
    listCustomRangesSettings = settingsBuilder.listCustomRangesSettings().build();
    getCustomRangeSettings = settingsBuilder.getCustomRangeSettings().build();
    showCustomRangeUtilizationSettings =
        settingsBuilder.showCustomRangeUtilizationSettings().build();
    showDiscoveredRangeUtilizationSettings =
        settingsBuilder.showDiscoveredRangeUtilizationSettings().build();
    findCustomRangeFreeIpRangesSettings =
        settingsBuilder.findCustomRangeFreeIpRangesSettings().build();
    createCustomRangeSettings = settingsBuilder.createCustomRangeSettings().build();
    createCustomRangeOperationSettings =
        settingsBuilder.createCustomRangeOperationSettings().build();
    updateCustomRangeSettings = settingsBuilder.updateCustomRangeSettings().build();
    updateCustomRangeOperationSettings =
        settingsBuilder.updateCustomRangeOperationSettings().build();
    deleteCustomRangeSettings = settingsBuilder.deleteCustomRangeSettings().build();
    deleteCustomRangeOperationSettings =
        settingsBuilder.deleteCustomRangeOperationSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-numberregistry")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for CloudNumberRegistryStubSettings. */
  public static class Builder
      extends StubSettings.Builder<CloudNumberRegistryStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListIpamAdminScopesRequest,
            ListIpamAdminScopesResponse,
            ListIpamAdminScopesPagedResponse>
        listIpamAdminScopesSettings;
    private final UnaryCallSettings.Builder<GetIpamAdminScopeRequest, IpamAdminScope>
        getIpamAdminScopeSettings;
    private final UnaryCallSettings.Builder<
            CheckAvailabilityIpamAdminScopesRequest, CheckAvailabilityIpamAdminScopesResponse>
        checkAvailabilityIpamAdminScopesSettings;
    private final UnaryCallSettings.Builder<CreateIpamAdminScopeRequest, Operation>
        createIpamAdminScopeSettings;
    private final OperationCallSettings.Builder<
            CreateIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
        createIpamAdminScopeOperationSettings;
    private final UnaryCallSettings.Builder<UpdateIpamAdminScopeRequest, Operation>
        updateIpamAdminScopeSettings;
    private final OperationCallSettings.Builder<
            UpdateIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
        updateIpamAdminScopeOperationSettings;
    private final UnaryCallSettings.Builder<DeleteIpamAdminScopeRequest, Operation>
        deleteIpamAdminScopeSettings;
    private final OperationCallSettings.Builder<
            DeleteIpamAdminScopeRequest, Empty, OperationMetadata>
        deleteIpamAdminScopeOperationSettings;
    private final UnaryCallSettings.Builder<DisableIpamAdminScopeRequest, Operation>
        disableIpamAdminScopeSettings;
    private final OperationCallSettings.Builder<
            DisableIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
        disableIpamAdminScopeOperationSettings;
    private final UnaryCallSettings.Builder<CleanupIpamAdminScopeRequest, Operation>
        cleanupIpamAdminScopeSettings;
    private final OperationCallSettings.Builder<
            CleanupIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
        cleanupIpamAdminScopeOperationSettings;
    private final PagedCallSettings.Builder<
            ListRegistryBooksRequest, ListRegistryBooksResponse, ListRegistryBooksPagedResponse>
        listRegistryBooksSettings;
    private final UnaryCallSettings.Builder<GetRegistryBookRequest, RegistryBook>
        getRegistryBookSettings;
    private final PagedCallSettings.Builder<
            SearchIpResourcesRequest, SearchIpResourcesResponse, SearchIpResourcesPagedResponse>
        searchIpResourcesSettings;
    private final UnaryCallSettings.Builder<CreateRegistryBookRequest, Operation>
        createRegistryBookSettings;
    private final OperationCallSettings.Builder<
            CreateRegistryBookRequest, RegistryBook, OperationMetadata>
        createRegistryBookOperationSettings;
    private final UnaryCallSettings.Builder<UpdateRegistryBookRequest, Operation>
        updateRegistryBookSettings;
    private final OperationCallSettings.Builder<
            UpdateRegistryBookRequest, RegistryBook, OperationMetadata>
        updateRegistryBookOperationSettings;
    private final UnaryCallSettings.Builder<DeleteRegistryBookRequest, Operation>
        deleteRegistryBookSettings;
    private final OperationCallSettings.Builder<DeleteRegistryBookRequest, Empty, OperationMetadata>
        deleteRegistryBookOperationSettings;
    private final PagedCallSettings.Builder<
            ListRealmsRequest, ListRealmsResponse, ListRealmsPagedResponse>
        listRealmsSettings;
    private final UnaryCallSettings.Builder<GetRealmRequest, Realm> getRealmSettings;
    private final UnaryCallSettings.Builder<CreateRealmRequest, Operation> createRealmSettings;
    private final OperationCallSettings.Builder<CreateRealmRequest, Realm, OperationMetadata>
        createRealmOperationSettings;
    private final UnaryCallSettings.Builder<UpdateRealmRequest, Operation> updateRealmSettings;
    private final OperationCallSettings.Builder<UpdateRealmRequest, Realm, OperationMetadata>
        updateRealmOperationSettings;
    private final UnaryCallSettings.Builder<DeleteRealmRequest, Operation> deleteRealmSettings;
    private final OperationCallSettings.Builder<DeleteRealmRequest, Empty, OperationMetadata>
        deleteRealmOperationSettings;
    private final PagedCallSettings.Builder<
            ListDiscoveredRangesRequest,
            ListDiscoveredRangesResponse,
            ListDiscoveredRangesPagedResponse>
        listDiscoveredRangesSettings;
    private final UnaryCallSettings.Builder<GetDiscoveredRangeRequest, DiscoveredRange>
        getDiscoveredRangeSettings;
    private final UnaryCallSettings.Builder<
            FindDiscoveredRangeFreeIpRangesRequest, FindDiscoveredRangeFreeIpRangesResponse>
        findDiscoveredRangeFreeIpRangesSettings;
    private final PagedCallSettings.Builder<
            ListCustomRangesRequest, ListCustomRangesResponse, ListCustomRangesPagedResponse>
        listCustomRangesSettings;
    private final UnaryCallSettings.Builder<GetCustomRangeRequest, CustomRange>
        getCustomRangeSettings;
    private final UnaryCallSettings.Builder<
            ShowCustomRangeUtilizationRequest, ShowCustomRangeUtilizationResponse>
        showCustomRangeUtilizationSettings;
    private final UnaryCallSettings.Builder<
            ShowDiscoveredRangeUtilizationRequest, ShowDiscoveredRangeUtilizationResponse>
        showDiscoveredRangeUtilizationSettings;
    private final UnaryCallSettings.Builder<
            FindCustomRangeFreeIpRangesRequest, FindCustomRangeFreeIpRangesResponse>
        findCustomRangeFreeIpRangesSettings;
    private final UnaryCallSettings.Builder<CreateCustomRangeRequest, Operation>
        createCustomRangeSettings;
    private final OperationCallSettings.Builder<
            CreateCustomRangeRequest, CustomRange, OperationMetadata>
        createCustomRangeOperationSettings;
    private final UnaryCallSettings.Builder<UpdateCustomRangeRequest, Operation>
        updateCustomRangeSettings;
    private final OperationCallSettings.Builder<
            UpdateCustomRangeRequest, CustomRange, OperationMetadata>
        updateCustomRangeOperationSettings;
    private final UnaryCallSettings.Builder<DeleteCustomRangeRequest, Operation>
        deleteCustomRangeSettings;
    private final OperationCallSettings.Builder<DeleteCustomRangeRequest, Empty, OperationMetadata>
        deleteCustomRangeOperationSettings;
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
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listIpamAdminScopesSettings =
          PagedCallSettings.newBuilder(LIST_IPAM_ADMIN_SCOPES_PAGE_STR_FACT);
      getIpamAdminScopeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      checkAvailabilityIpamAdminScopesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createIpamAdminScopeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createIpamAdminScopeOperationSettings = OperationCallSettings.newBuilder();
      updateIpamAdminScopeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateIpamAdminScopeOperationSettings = OperationCallSettings.newBuilder();
      deleteIpamAdminScopeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteIpamAdminScopeOperationSettings = OperationCallSettings.newBuilder();
      disableIpamAdminScopeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      disableIpamAdminScopeOperationSettings = OperationCallSettings.newBuilder();
      cleanupIpamAdminScopeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      cleanupIpamAdminScopeOperationSettings = OperationCallSettings.newBuilder();
      listRegistryBooksSettings = PagedCallSettings.newBuilder(LIST_REGISTRY_BOOKS_PAGE_STR_FACT);
      getRegistryBookSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      searchIpResourcesSettings = PagedCallSettings.newBuilder(SEARCH_IP_RESOURCES_PAGE_STR_FACT);
      createRegistryBookSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createRegistryBookOperationSettings = OperationCallSettings.newBuilder();
      updateRegistryBookSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateRegistryBookOperationSettings = OperationCallSettings.newBuilder();
      deleteRegistryBookSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteRegistryBookOperationSettings = OperationCallSettings.newBuilder();
      listRealmsSettings = PagedCallSettings.newBuilder(LIST_REALMS_PAGE_STR_FACT);
      getRealmSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createRealmSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createRealmOperationSettings = OperationCallSettings.newBuilder();
      updateRealmSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateRealmOperationSettings = OperationCallSettings.newBuilder();
      deleteRealmSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteRealmOperationSettings = OperationCallSettings.newBuilder();
      listDiscoveredRangesSettings =
          PagedCallSettings.newBuilder(LIST_DISCOVERED_RANGES_PAGE_STR_FACT);
      getDiscoveredRangeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      findDiscoveredRangeFreeIpRangesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCustomRangesSettings = PagedCallSettings.newBuilder(LIST_CUSTOM_RANGES_PAGE_STR_FACT);
      getCustomRangeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      showCustomRangeUtilizationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      showDiscoveredRangeUtilizationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      findCustomRangeFreeIpRangesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCustomRangeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCustomRangeOperationSettings = OperationCallSettings.newBuilder();
      updateCustomRangeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCustomRangeOperationSettings = OperationCallSettings.newBuilder();
      deleteCustomRangeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCustomRangeOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listIpamAdminScopesSettings,
              getIpamAdminScopeSettings,
              checkAvailabilityIpamAdminScopesSettings,
              createIpamAdminScopeSettings,
              updateIpamAdminScopeSettings,
              deleteIpamAdminScopeSettings,
              disableIpamAdminScopeSettings,
              cleanupIpamAdminScopeSettings,
              listRegistryBooksSettings,
              getRegistryBookSettings,
              searchIpResourcesSettings,
              createRegistryBookSettings,
              updateRegistryBookSettings,
              deleteRegistryBookSettings,
              listRealmsSettings,
              getRealmSettings,
              createRealmSettings,
              updateRealmSettings,
              deleteRealmSettings,
              listDiscoveredRangesSettings,
              getDiscoveredRangeSettings,
              findDiscoveredRangeFreeIpRangesSettings,
              listCustomRangesSettings,
              getCustomRangeSettings,
              showCustomRangeUtilizationSettings,
              showDiscoveredRangeUtilizationSettings,
              findCustomRangeFreeIpRangesSettings,
              createCustomRangeSettings,
              updateCustomRangeSettings,
              deleteCustomRangeSettings);
      initDefaults(this);
    }

    protected Builder(CloudNumberRegistryStubSettings settings) {
      super(settings);

      listIpamAdminScopesSettings = settings.listIpamAdminScopesSettings.toBuilder();
      getIpamAdminScopeSettings = settings.getIpamAdminScopeSettings.toBuilder();
      checkAvailabilityIpamAdminScopesSettings =
          settings.checkAvailabilityIpamAdminScopesSettings.toBuilder();
      createIpamAdminScopeSettings = settings.createIpamAdminScopeSettings.toBuilder();
      createIpamAdminScopeOperationSettings =
          settings.createIpamAdminScopeOperationSettings.toBuilder();
      updateIpamAdminScopeSettings = settings.updateIpamAdminScopeSettings.toBuilder();
      updateIpamAdminScopeOperationSettings =
          settings.updateIpamAdminScopeOperationSettings.toBuilder();
      deleteIpamAdminScopeSettings = settings.deleteIpamAdminScopeSettings.toBuilder();
      deleteIpamAdminScopeOperationSettings =
          settings.deleteIpamAdminScopeOperationSettings.toBuilder();
      disableIpamAdminScopeSettings = settings.disableIpamAdminScopeSettings.toBuilder();
      disableIpamAdminScopeOperationSettings =
          settings.disableIpamAdminScopeOperationSettings.toBuilder();
      cleanupIpamAdminScopeSettings = settings.cleanupIpamAdminScopeSettings.toBuilder();
      cleanupIpamAdminScopeOperationSettings =
          settings.cleanupIpamAdminScopeOperationSettings.toBuilder();
      listRegistryBooksSettings = settings.listRegistryBooksSettings.toBuilder();
      getRegistryBookSettings = settings.getRegistryBookSettings.toBuilder();
      searchIpResourcesSettings = settings.searchIpResourcesSettings.toBuilder();
      createRegistryBookSettings = settings.createRegistryBookSettings.toBuilder();
      createRegistryBookOperationSettings =
          settings.createRegistryBookOperationSettings.toBuilder();
      updateRegistryBookSettings = settings.updateRegistryBookSettings.toBuilder();
      updateRegistryBookOperationSettings =
          settings.updateRegistryBookOperationSettings.toBuilder();
      deleteRegistryBookSettings = settings.deleteRegistryBookSettings.toBuilder();
      deleteRegistryBookOperationSettings =
          settings.deleteRegistryBookOperationSettings.toBuilder();
      listRealmsSettings = settings.listRealmsSettings.toBuilder();
      getRealmSettings = settings.getRealmSettings.toBuilder();
      createRealmSettings = settings.createRealmSettings.toBuilder();
      createRealmOperationSettings = settings.createRealmOperationSettings.toBuilder();
      updateRealmSettings = settings.updateRealmSettings.toBuilder();
      updateRealmOperationSettings = settings.updateRealmOperationSettings.toBuilder();
      deleteRealmSettings = settings.deleteRealmSettings.toBuilder();
      deleteRealmOperationSettings = settings.deleteRealmOperationSettings.toBuilder();
      listDiscoveredRangesSettings = settings.listDiscoveredRangesSettings.toBuilder();
      getDiscoveredRangeSettings = settings.getDiscoveredRangeSettings.toBuilder();
      findDiscoveredRangeFreeIpRangesSettings =
          settings.findDiscoveredRangeFreeIpRangesSettings.toBuilder();
      listCustomRangesSettings = settings.listCustomRangesSettings.toBuilder();
      getCustomRangeSettings = settings.getCustomRangeSettings.toBuilder();
      showCustomRangeUtilizationSettings = settings.showCustomRangeUtilizationSettings.toBuilder();
      showDiscoveredRangeUtilizationSettings =
          settings.showDiscoveredRangeUtilizationSettings.toBuilder();
      findCustomRangeFreeIpRangesSettings =
          settings.findCustomRangeFreeIpRangesSettings.toBuilder();
      createCustomRangeSettings = settings.createCustomRangeSettings.toBuilder();
      createCustomRangeOperationSettings = settings.createCustomRangeOperationSettings.toBuilder();
      updateCustomRangeSettings = settings.updateCustomRangeSettings.toBuilder();
      updateCustomRangeOperationSettings = settings.updateCustomRangeOperationSettings.toBuilder();
      deleteCustomRangeSettings = settings.deleteCustomRangeSettings.toBuilder();
      deleteCustomRangeOperationSettings = settings.deleteCustomRangeOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listIpamAdminScopesSettings,
              getIpamAdminScopeSettings,
              checkAvailabilityIpamAdminScopesSettings,
              createIpamAdminScopeSettings,
              updateIpamAdminScopeSettings,
              deleteIpamAdminScopeSettings,
              disableIpamAdminScopeSettings,
              cleanupIpamAdminScopeSettings,
              listRegistryBooksSettings,
              getRegistryBookSettings,
              searchIpResourcesSettings,
              createRegistryBookSettings,
              updateRegistryBookSettings,
              deleteRegistryBookSettings,
              listRealmsSettings,
              getRealmSettings,
              createRealmSettings,
              updateRealmSettings,
              deleteRealmSettings,
              listDiscoveredRangesSettings,
              getDiscoveredRangeSettings,
              findDiscoveredRangeFreeIpRangesSettings,
              listCustomRangesSettings,
              getCustomRangeSettings,
              showCustomRangeUtilizationSettings,
              showDiscoveredRangeUtilizationSettings,
              findCustomRangeFreeIpRangesSettings,
              createCustomRangeSettings,
              updateCustomRangeSettings,
              deleteCustomRangeSettings);
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
          .listIpamAdminScopesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getIpamAdminScopeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .checkAvailabilityIpamAdminScopesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createIpamAdminScopeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateIpamAdminScopeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteIpamAdminScopeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .disableIpamAdminScopeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .cleanupIpamAdminScopeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listRegistryBooksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getRegistryBookSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .searchIpResourcesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createRegistryBookSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateRegistryBookSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteRegistryBookSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listRealmsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getRealmSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createRealmSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateRealmSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteRealmSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listDiscoveredRangesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getDiscoveredRangeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .findDiscoveredRangeFreeIpRangesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listCustomRangesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getCustomRangeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .showCustomRangeUtilizationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .showDiscoveredRangeUtilizationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .findCustomRangeFreeIpRangesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createCustomRangeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateCustomRangeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteCustomRangeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createIpamAdminScopeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateIpamAdminScopeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(IpamAdminScope.class))
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
          .updateIpamAdminScopeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateIpamAdminScopeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(IpamAdminScope.class))
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
          .deleteIpamAdminScopeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteIpamAdminScopeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .disableIpamAdminScopeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DisableIpamAdminScopeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(IpamAdminScope.class))
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
          .cleanupIpamAdminScopeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CleanupIpamAdminScopeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(IpamAdminScope.class))
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
          .createRegistryBookOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateRegistryBookRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(RegistryBook.class))
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
          .updateRegistryBookOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateRegistryBookRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(RegistryBook.class))
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
          .deleteRegistryBookOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteRegistryBookRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createRealmOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateRealmRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Realm.class))
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
          .updateRealmOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateRealmRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Realm.class))
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
          .deleteRealmOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteRealmRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createCustomRangeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateCustomRangeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CustomRange.class))
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
          .updateCustomRangeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateCustomRangeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CustomRange.class))
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
          .deleteCustomRangeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteCustomRangeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to listIpamAdminScopes. */
    public PagedCallSettings.Builder<
            ListIpamAdminScopesRequest,
            ListIpamAdminScopesResponse,
            ListIpamAdminScopesPagedResponse>
        listIpamAdminScopesSettings() {
      return listIpamAdminScopesSettings;
    }

    /** Returns the builder for the settings used for calls to getIpamAdminScope. */
    public UnaryCallSettings.Builder<GetIpamAdminScopeRequest, IpamAdminScope>
        getIpamAdminScopeSettings() {
      return getIpamAdminScopeSettings;
    }

    /** Returns the builder for the settings used for calls to checkAvailabilityIpamAdminScopes. */
    public UnaryCallSettings.Builder<
            CheckAvailabilityIpamAdminScopesRequest, CheckAvailabilityIpamAdminScopesResponse>
        checkAvailabilityIpamAdminScopesSettings() {
      return checkAvailabilityIpamAdminScopesSettings;
    }

    /** Returns the builder for the settings used for calls to createIpamAdminScope. */
    public UnaryCallSettings.Builder<CreateIpamAdminScopeRequest, Operation>
        createIpamAdminScopeSettings() {
      return createIpamAdminScopeSettings;
    }

    /** Returns the builder for the settings used for calls to createIpamAdminScope. */
    public OperationCallSettings.Builder<
            CreateIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
        createIpamAdminScopeOperationSettings() {
      return createIpamAdminScopeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateIpamAdminScope. */
    public UnaryCallSettings.Builder<UpdateIpamAdminScopeRequest, Operation>
        updateIpamAdminScopeSettings() {
      return updateIpamAdminScopeSettings;
    }

    /** Returns the builder for the settings used for calls to updateIpamAdminScope. */
    public OperationCallSettings.Builder<
            UpdateIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
        updateIpamAdminScopeOperationSettings() {
      return updateIpamAdminScopeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteIpamAdminScope. */
    public UnaryCallSettings.Builder<DeleteIpamAdminScopeRequest, Operation>
        deleteIpamAdminScopeSettings() {
      return deleteIpamAdminScopeSettings;
    }

    /** Returns the builder for the settings used for calls to deleteIpamAdminScope. */
    public OperationCallSettings.Builder<DeleteIpamAdminScopeRequest, Empty, OperationMetadata>
        deleteIpamAdminScopeOperationSettings() {
      return deleteIpamAdminScopeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to disableIpamAdminScope. */
    public UnaryCallSettings.Builder<DisableIpamAdminScopeRequest, Operation>
        disableIpamAdminScopeSettings() {
      return disableIpamAdminScopeSettings;
    }

    /** Returns the builder for the settings used for calls to disableIpamAdminScope. */
    public OperationCallSettings.Builder<
            DisableIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
        disableIpamAdminScopeOperationSettings() {
      return disableIpamAdminScopeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to cleanupIpamAdminScope. */
    public UnaryCallSettings.Builder<CleanupIpamAdminScopeRequest, Operation>
        cleanupIpamAdminScopeSettings() {
      return cleanupIpamAdminScopeSettings;
    }

    /** Returns the builder for the settings used for calls to cleanupIpamAdminScope. */
    public OperationCallSettings.Builder<
            CleanupIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
        cleanupIpamAdminScopeOperationSettings() {
      return cleanupIpamAdminScopeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listRegistryBooks. */
    public PagedCallSettings.Builder<
            ListRegistryBooksRequest, ListRegistryBooksResponse, ListRegistryBooksPagedResponse>
        listRegistryBooksSettings() {
      return listRegistryBooksSettings;
    }

    /** Returns the builder for the settings used for calls to getRegistryBook. */
    public UnaryCallSettings.Builder<GetRegistryBookRequest, RegistryBook>
        getRegistryBookSettings() {
      return getRegistryBookSettings;
    }

    /** Returns the builder for the settings used for calls to searchIpResources. */
    public PagedCallSettings.Builder<
            SearchIpResourcesRequest, SearchIpResourcesResponse, SearchIpResourcesPagedResponse>
        searchIpResourcesSettings() {
      return searchIpResourcesSettings;
    }

    /** Returns the builder for the settings used for calls to createRegistryBook. */
    public UnaryCallSettings.Builder<CreateRegistryBookRequest, Operation>
        createRegistryBookSettings() {
      return createRegistryBookSettings;
    }

    /** Returns the builder for the settings used for calls to createRegistryBook. */
    public OperationCallSettings.Builder<CreateRegistryBookRequest, RegistryBook, OperationMetadata>
        createRegistryBookOperationSettings() {
      return createRegistryBookOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateRegistryBook. */
    public UnaryCallSettings.Builder<UpdateRegistryBookRequest, Operation>
        updateRegistryBookSettings() {
      return updateRegistryBookSettings;
    }

    /** Returns the builder for the settings used for calls to updateRegistryBook. */
    public OperationCallSettings.Builder<UpdateRegistryBookRequest, RegistryBook, OperationMetadata>
        updateRegistryBookOperationSettings() {
      return updateRegistryBookOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRegistryBook. */
    public UnaryCallSettings.Builder<DeleteRegistryBookRequest, Operation>
        deleteRegistryBookSettings() {
      return deleteRegistryBookSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRegistryBook. */
    public OperationCallSettings.Builder<DeleteRegistryBookRequest, Empty, OperationMetadata>
        deleteRegistryBookOperationSettings() {
      return deleteRegistryBookOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listRealms. */
    public PagedCallSettings.Builder<ListRealmsRequest, ListRealmsResponse, ListRealmsPagedResponse>
        listRealmsSettings() {
      return listRealmsSettings;
    }

    /** Returns the builder for the settings used for calls to getRealm. */
    public UnaryCallSettings.Builder<GetRealmRequest, Realm> getRealmSettings() {
      return getRealmSettings;
    }

    /** Returns the builder for the settings used for calls to createRealm. */
    public UnaryCallSettings.Builder<CreateRealmRequest, Operation> createRealmSettings() {
      return createRealmSettings;
    }

    /** Returns the builder for the settings used for calls to createRealm. */
    public OperationCallSettings.Builder<CreateRealmRequest, Realm, OperationMetadata>
        createRealmOperationSettings() {
      return createRealmOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateRealm. */
    public UnaryCallSettings.Builder<UpdateRealmRequest, Operation> updateRealmSettings() {
      return updateRealmSettings;
    }

    /** Returns the builder for the settings used for calls to updateRealm. */
    public OperationCallSettings.Builder<UpdateRealmRequest, Realm, OperationMetadata>
        updateRealmOperationSettings() {
      return updateRealmOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRealm. */
    public UnaryCallSettings.Builder<DeleteRealmRequest, Operation> deleteRealmSettings() {
      return deleteRealmSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRealm. */
    public OperationCallSettings.Builder<DeleteRealmRequest, Empty, OperationMetadata>
        deleteRealmOperationSettings() {
      return deleteRealmOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listDiscoveredRanges. */
    public PagedCallSettings.Builder<
            ListDiscoveredRangesRequest,
            ListDiscoveredRangesResponse,
            ListDiscoveredRangesPagedResponse>
        listDiscoveredRangesSettings() {
      return listDiscoveredRangesSettings;
    }

    /** Returns the builder for the settings used for calls to getDiscoveredRange. */
    public UnaryCallSettings.Builder<GetDiscoveredRangeRequest, DiscoveredRange>
        getDiscoveredRangeSettings() {
      return getDiscoveredRangeSettings;
    }

    /** Returns the builder for the settings used for calls to findDiscoveredRangeFreeIpRanges. */
    public UnaryCallSettings.Builder<
            FindDiscoveredRangeFreeIpRangesRequest, FindDiscoveredRangeFreeIpRangesResponse>
        findDiscoveredRangeFreeIpRangesSettings() {
      return findDiscoveredRangeFreeIpRangesSettings;
    }

    /** Returns the builder for the settings used for calls to listCustomRanges. */
    public PagedCallSettings.Builder<
            ListCustomRangesRequest, ListCustomRangesResponse, ListCustomRangesPagedResponse>
        listCustomRangesSettings() {
      return listCustomRangesSettings;
    }

    /** Returns the builder for the settings used for calls to getCustomRange. */
    public UnaryCallSettings.Builder<GetCustomRangeRequest, CustomRange> getCustomRangeSettings() {
      return getCustomRangeSettings;
    }

    /** Returns the builder for the settings used for calls to showCustomRangeUtilization. */
    public UnaryCallSettings.Builder<
            ShowCustomRangeUtilizationRequest, ShowCustomRangeUtilizationResponse>
        showCustomRangeUtilizationSettings() {
      return showCustomRangeUtilizationSettings;
    }

    /** Returns the builder for the settings used for calls to showDiscoveredRangeUtilization. */
    public UnaryCallSettings.Builder<
            ShowDiscoveredRangeUtilizationRequest, ShowDiscoveredRangeUtilizationResponse>
        showDiscoveredRangeUtilizationSettings() {
      return showDiscoveredRangeUtilizationSettings;
    }

    /** Returns the builder for the settings used for calls to findCustomRangeFreeIpRanges. */
    public UnaryCallSettings.Builder<
            FindCustomRangeFreeIpRangesRequest, FindCustomRangeFreeIpRangesResponse>
        findCustomRangeFreeIpRangesSettings() {
      return findCustomRangeFreeIpRangesSettings;
    }

    /** Returns the builder for the settings used for calls to createCustomRange. */
    public UnaryCallSettings.Builder<CreateCustomRangeRequest, Operation>
        createCustomRangeSettings() {
      return createCustomRangeSettings;
    }

    /** Returns the builder for the settings used for calls to createCustomRange. */
    public OperationCallSettings.Builder<CreateCustomRangeRequest, CustomRange, OperationMetadata>
        createCustomRangeOperationSettings() {
      return createCustomRangeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateCustomRange. */
    public UnaryCallSettings.Builder<UpdateCustomRangeRequest, Operation>
        updateCustomRangeSettings() {
      return updateCustomRangeSettings;
    }

    /** Returns the builder for the settings used for calls to updateCustomRange. */
    public OperationCallSettings.Builder<UpdateCustomRangeRequest, CustomRange, OperationMetadata>
        updateCustomRangeOperationSettings() {
      return updateCustomRangeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCustomRange. */
    public UnaryCallSettings.Builder<DeleteCustomRangeRequest, Operation>
        deleteCustomRangeSettings() {
      return deleteCustomRangeSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCustomRange. */
    public OperationCallSettings.Builder<DeleteCustomRangeRequest, Empty, OperationMetadata>
        deleteCustomRangeOperationSettings() {
      return deleteCustomRangeOperationSettings;
    }

    @Override
    public CloudNumberRegistryStubSettings build() throws IOException {
      return new CloudNumberRegistryStubSettings(this);
    }
  }
}
