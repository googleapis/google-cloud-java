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

package com.google.cloud.saasplatform.saasservicemgmt.v1beta1.stub;

import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListLocationsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListReleasesPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListSaasPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListTenantsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListUnitKindsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListUnitOperationsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListUnitsPagedResponse;

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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
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
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateReleaseRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateSaasRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateTenantRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitOperationRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteReleaseRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteSaasRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteTenantRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitOperationRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetReleaseRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetSaasRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetTenantRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitOperationRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesResponse;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasResponse;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsResponse;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsResponse;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitOperationsRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitOperationsResponse;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsResponse;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateReleaseRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateSaasRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateTenantRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitOperationRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SaasDeploymentsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (saasservicemgmt.googleapis.com) and default port (443) are
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
 * of getSaas:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SaasDeploymentsStubSettings.Builder saasDeploymentsSettingsBuilder =
 *     SaasDeploymentsStubSettings.newBuilder();
 * saasDeploymentsSettingsBuilder
 *     .getSaasSettings()
 *     .setRetrySettings(
 *         saasDeploymentsSettingsBuilder
 *             .getSaasSettings()
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
 * SaasDeploymentsStubSettings saasDeploymentsSettings = saasDeploymentsSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SaasDeploymentsStubSettings extends StubSettings<SaasDeploymentsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<ListSaasRequest, ListSaasResponse, ListSaasPagedResponse>
      listSaasSettings;
  private final UnaryCallSettings<GetSaasRequest, Saas> getSaasSettings;
  private final UnaryCallSettings<CreateSaasRequest, Saas> createSaasSettings;
  private final UnaryCallSettings<UpdateSaasRequest, Saas> updateSaasSettings;
  private final UnaryCallSettings<DeleteSaasRequest, Empty> deleteSaasSettings;
  private final PagedCallSettings<ListTenantsRequest, ListTenantsResponse, ListTenantsPagedResponse>
      listTenantsSettings;
  private final UnaryCallSettings<GetTenantRequest, Tenant> getTenantSettings;
  private final UnaryCallSettings<CreateTenantRequest, Tenant> createTenantSettings;
  private final UnaryCallSettings<UpdateTenantRequest, Tenant> updateTenantSettings;
  private final UnaryCallSettings<DeleteTenantRequest, Empty> deleteTenantSettings;
  private final PagedCallSettings<
          ListUnitKindsRequest, ListUnitKindsResponse, ListUnitKindsPagedResponse>
      listUnitKindsSettings;
  private final UnaryCallSettings<GetUnitKindRequest, UnitKind> getUnitKindSettings;
  private final UnaryCallSettings<CreateUnitKindRequest, UnitKind> createUnitKindSettings;
  private final UnaryCallSettings<UpdateUnitKindRequest, UnitKind> updateUnitKindSettings;
  private final UnaryCallSettings<DeleteUnitKindRequest, Empty> deleteUnitKindSettings;
  private final PagedCallSettings<ListUnitsRequest, ListUnitsResponse, ListUnitsPagedResponse>
      listUnitsSettings;
  private final UnaryCallSettings<GetUnitRequest, Unit> getUnitSettings;
  private final UnaryCallSettings<CreateUnitRequest, Unit> createUnitSettings;
  private final UnaryCallSettings<UpdateUnitRequest, Unit> updateUnitSettings;
  private final UnaryCallSettings<DeleteUnitRequest, Empty> deleteUnitSettings;
  private final PagedCallSettings<
          ListUnitOperationsRequest, ListUnitOperationsResponse, ListUnitOperationsPagedResponse>
      listUnitOperationsSettings;
  private final UnaryCallSettings<GetUnitOperationRequest, UnitOperation> getUnitOperationSettings;
  private final UnaryCallSettings<CreateUnitOperationRequest, UnitOperation>
      createUnitOperationSettings;
  private final UnaryCallSettings<UpdateUnitOperationRequest, UnitOperation>
      updateUnitOperationSettings;
  private final UnaryCallSettings<DeleteUnitOperationRequest, Empty> deleteUnitOperationSettings;
  private final PagedCallSettings<
          ListReleasesRequest, ListReleasesResponse, ListReleasesPagedResponse>
      listReleasesSettings;
  private final UnaryCallSettings<GetReleaseRequest, Release> getReleaseSettings;
  private final UnaryCallSettings<CreateReleaseRequest, Release> createReleaseSettings;
  private final UnaryCallSettings<UpdateReleaseRequest, Release> updateReleaseSettings;
  private final UnaryCallSettings<DeleteReleaseRequest, Empty> deleteReleaseSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListSaasRequest, ListSaasResponse, Saas>
      LIST_SAAS_PAGE_STR_DESC =
          new PagedListDescriptor<ListSaasRequest, ListSaasResponse, Saas>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSaasRequest injectToken(ListSaasRequest payload, String token) {
              return ListSaasRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSaasRequest injectPageSize(ListSaasRequest payload, int pageSize) {
              return ListSaasRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSaasRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSaasResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Saas> extractResources(ListSaasResponse payload) {
              return payload.getSaasList();
            }
          };

  private static final PagedListDescriptor<ListTenantsRequest, ListTenantsResponse, Tenant>
      LIST_TENANTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListTenantsRequest, ListTenantsResponse, Tenant>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTenantsRequest injectToken(ListTenantsRequest payload, String token) {
              return ListTenantsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTenantsRequest injectPageSize(ListTenantsRequest payload, int pageSize) {
              return ListTenantsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTenantsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTenantsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Tenant> extractResources(ListTenantsResponse payload) {
              return payload.getTenantsList();
            }
          };

  private static final PagedListDescriptor<ListUnitKindsRequest, ListUnitKindsResponse, UnitKind>
      LIST_UNIT_KINDS_PAGE_STR_DESC =
          new PagedListDescriptor<ListUnitKindsRequest, ListUnitKindsResponse, UnitKind>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListUnitKindsRequest injectToken(ListUnitKindsRequest payload, String token) {
              return ListUnitKindsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListUnitKindsRequest injectPageSize(ListUnitKindsRequest payload, int pageSize) {
              return ListUnitKindsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListUnitKindsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListUnitKindsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<UnitKind> extractResources(ListUnitKindsResponse payload) {
              return payload.getUnitKindsList();
            }
          };

  private static final PagedListDescriptor<ListUnitsRequest, ListUnitsResponse, Unit>
      LIST_UNITS_PAGE_STR_DESC =
          new PagedListDescriptor<ListUnitsRequest, ListUnitsResponse, Unit>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListUnitsRequest injectToken(ListUnitsRequest payload, String token) {
              return ListUnitsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListUnitsRequest injectPageSize(ListUnitsRequest payload, int pageSize) {
              return ListUnitsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListUnitsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListUnitsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Unit> extractResources(ListUnitsResponse payload) {
              return payload.getUnitsList();
            }
          };

  private static final PagedListDescriptor<
          ListUnitOperationsRequest, ListUnitOperationsResponse, UnitOperation>
      LIST_UNIT_OPERATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListUnitOperationsRequest, ListUnitOperationsResponse, UnitOperation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListUnitOperationsRequest injectToken(
                ListUnitOperationsRequest payload, String token) {
              return ListUnitOperationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListUnitOperationsRequest injectPageSize(
                ListUnitOperationsRequest payload, int pageSize) {
              return ListUnitOperationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListUnitOperationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListUnitOperationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<UnitOperation> extractResources(ListUnitOperationsResponse payload) {
              return payload.getUnitOperationsList();
            }
          };

  private static final PagedListDescriptor<ListReleasesRequest, ListReleasesResponse, Release>
      LIST_RELEASES_PAGE_STR_DESC =
          new PagedListDescriptor<ListReleasesRequest, ListReleasesResponse, Release>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListReleasesRequest injectToken(ListReleasesRequest payload, String token) {
              return ListReleasesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListReleasesRequest injectPageSize(ListReleasesRequest payload, int pageSize) {
              return ListReleasesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListReleasesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListReleasesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Release> extractResources(ListReleasesResponse payload) {
              return payload.getReleasesList();
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
          ListSaasRequest, ListSaasResponse, ListSaasPagedResponse>
      LIST_SAAS_PAGE_STR_FACT =
          new PagedListResponseFactory<ListSaasRequest, ListSaasResponse, ListSaasPagedResponse>() {
            @Override
            public ApiFuture<ListSaasPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSaasRequest, ListSaasResponse> callable,
                ListSaasRequest request,
                ApiCallContext context,
                ApiFuture<ListSaasResponse> futureResponse) {
              PageContext<ListSaasRequest, ListSaasResponse, Saas> pageContext =
                  PageContext.create(callable, LIST_SAAS_PAGE_STR_DESC, request, context);
              return ListSaasPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTenantsRequest, ListTenantsResponse, ListTenantsPagedResponse>
      LIST_TENANTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTenantsRequest, ListTenantsResponse, ListTenantsPagedResponse>() {
            @Override
            public ApiFuture<ListTenantsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTenantsRequest, ListTenantsResponse> callable,
                ListTenantsRequest request,
                ApiCallContext context,
                ApiFuture<ListTenantsResponse> futureResponse) {
              PageContext<ListTenantsRequest, ListTenantsResponse, Tenant> pageContext =
                  PageContext.create(callable, LIST_TENANTS_PAGE_STR_DESC, request, context);
              return ListTenantsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListUnitKindsRequest, ListUnitKindsResponse, ListUnitKindsPagedResponse>
      LIST_UNIT_KINDS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListUnitKindsRequest, ListUnitKindsResponse, ListUnitKindsPagedResponse>() {
            @Override
            public ApiFuture<ListUnitKindsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListUnitKindsRequest, ListUnitKindsResponse> callable,
                ListUnitKindsRequest request,
                ApiCallContext context,
                ApiFuture<ListUnitKindsResponse> futureResponse) {
              PageContext<ListUnitKindsRequest, ListUnitKindsResponse, UnitKind> pageContext =
                  PageContext.create(callable, LIST_UNIT_KINDS_PAGE_STR_DESC, request, context);
              return ListUnitKindsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListUnitsRequest, ListUnitsResponse, ListUnitsPagedResponse>
      LIST_UNITS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListUnitsRequest, ListUnitsResponse, ListUnitsPagedResponse>() {
            @Override
            public ApiFuture<ListUnitsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListUnitsRequest, ListUnitsResponse> callable,
                ListUnitsRequest request,
                ApiCallContext context,
                ApiFuture<ListUnitsResponse> futureResponse) {
              PageContext<ListUnitsRequest, ListUnitsResponse, Unit> pageContext =
                  PageContext.create(callable, LIST_UNITS_PAGE_STR_DESC, request, context);
              return ListUnitsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListUnitOperationsRequest, ListUnitOperationsResponse, ListUnitOperationsPagedResponse>
      LIST_UNIT_OPERATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListUnitOperationsRequest,
              ListUnitOperationsResponse,
              ListUnitOperationsPagedResponse>() {
            @Override
            public ApiFuture<ListUnitOperationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListUnitOperationsRequest, ListUnitOperationsResponse> callable,
                ListUnitOperationsRequest request,
                ApiCallContext context,
                ApiFuture<ListUnitOperationsResponse> futureResponse) {
              PageContext<ListUnitOperationsRequest, ListUnitOperationsResponse, UnitOperation>
                  pageContext =
                      PageContext.create(
                          callable, LIST_UNIT_OPERATIONS_PAGE_STR_DESC, request, context);
              return ListUnitOperationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListReleasesRequest, ListReleasesResponse, ListReleasesPagedResponse>
      LIST_RELEASES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListReleasesRequest, ListReleasesResponse, ListReleasesPagedResponse>() {
            @Override
            public ApiFuture<ListReleasesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListReleasesRequest, ListReleasesResponse> callable,
                ListReleasesRequest request,
                ApiCallContext context,
                ApiFuture<ListReleasesResponse> futureResponse) {
              PageContext<ListReleasesRequest, ListReleasesResponse, Release> pageContext =
                  PageContext.create(callable, LIST_RELEASES_PAGE_STR_DESC, request, context);
              return ListReleasesPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listSaas. */
  public PagedCallSettings<ListSaasRequest, ListSaasResponse, ListSaasPagedResponse>
      listSaasSettings() {
    return listSaasSettings;
  }

  /** Returns the object with the settings used for calls to getSaas. */
  public UnaryCallSettings<GetSaasRequest, Saas> getSaasSettings() {
    return getSaasSettings;
  }

  /** Returns the object with the settings used for calls to createSaas. */
  public UnaryCallSettings<CreateSaasRequest, Saas> createSaasSettings() {
    return createSaasSettings;
  }

  /** Returns the object with the settings used for calls to updateSaas. */
  public UnaryCallSettings<UpdateSaasRequest, Saas> updateSaasSettings() {
    return updateSaasSettings;
  }

  /** Returns the object with the settings used for calls to deleteSaas. */
  public UnaryCallSettings<DeleteSaasRequest, Empty> deleteSaasSettings() {
    return deleteSaasSettings;
  }

  /** Returns the object with the settings used for calls to listTenants. */
  public PagedCallSettings<ListTenantsRequest, ListTenantsResponse, ListTenantsPagedResponse>
      listTenantsSettings() {
    return listTenantsSettings;
  }

  /** Returns the object with the settings used for calls to getTenant. */
  public UnaryCallSettings<GetTenantRequest, Tenant> getTenantSettings() {
    return getTenantSettings;
  }

  /** Returns the object with the settings used for calls to createTenant. */
  public UnaryCallSettings<CreateTenantRequest, Tenant> createTenantSettings() {
    return createTenantSettings;
  }

  /** Returns the object with the settings used for calls to updateTenant. */
  public UnaryCallSettings<UpdateTenantRequest, Tenant> updateTenantSettings() {
    return updateTenantSettings;
  }

  /** Returns the object with the settings used for calls to deleteTenant. */
  public UnaryCallSettings<DeleteTenantRequest, Empty> deleteTenantSettings() {
    return deleteTenantSettings;
  }

  /** Returns the object with the settings used for calls to listUnitKinds. */
  public PagedCallSettings<ListUnitKindsRequest, ListUnitKindsResponse, ListUnitKindsPagedResponse>
      listUnitKindsSettings() {
    return listUnitKindsSettings;
  }

  /** Returns the object with the settings used for calls to getUnitKind. */
  public UnaryCallSettings<GetUnitKindRequest, UnitKind> getUnitKindSettings() {
    return getUnitKindSettings;
  }

  /** Returns the object with the settings used for calls to createUnitKind. */
  public UnaryCallSettings<CreateUnitKindRequest, UnitKind> createUnitKindSettings() {
    return createUnitKindSettings;
  }

  /** Returns the object with the settings used for calls to updateUnitKind. */
  public UnaryCallSettings<UpdateUnitKindRequest, UnitKind> updateUnitKindSettings() {
    return updateUnitKindSettings;
  }

  /** Returns the object with the settings used for calls to deleteUnitKind. */
  public UnaryCallSettings<DeleteUnitKindRequest, Empty> deleteUnitKindSettings() {
    return deleteUnitKindSettings;
  }

  /** Returns the object with the settings used for calls to listUnits. */
  public PagedCallSettings<ListUnitsRequest, ListUnitsResponse, ListUnitsPagedResponse>
      listUnitsSettings() {
    return listUnitsSettings;
  }

  /** Returns the object with the settings used for calls to getUnit. */
  public UnaryCallSettings<GetUnitRequest, Unit> getUnitSettings() {
    return getUnitSettings;
  }

  /** Returns the object with the settings used for calls to createUnit. */
  public UnaryCallSettings<CreateUnitRequest, Unit> createUnitSettings() {
    return createUnitSettings;
  }

  /** Returns the object with the settings used for calls to updateUnit. */
  public UnaryCallSettings<UpdateUnitRequest, Unit> updateUnitSettings() {
    return updateUnitSettings;
  }

  /** Returns the object with the settings used for calls to deleteUnit. */
  public UnaryCallSettings<DeleteUnitRequest, Empty> deleteUnitSettings() {
    return deleteUnitSettings;
  }

  /** Returns the object with the settings used for calls to listUnitOperations. */
  public PagedCallSettings<
          ListUnitOperationsRequest, ListUnitOperationsResponse, ListUnitOperationsPagedResponse>
      listUnitOperationsSettings() {
    return listUnitOperationsSettings;
  }

  /** Returns the object with the settings used for calls to getUnit. */
  public UnaryCallSettings<GetUnitOperationRequest, UnitOperation> getUnitOperationSettings() {
    return getUnitOperationSettings;
  }

  /** Returns the object with the settings used for calls to createUnit. */
  public UnaryCallSettings<CreateUnitOperationRequest, UnitOperation>
      createUnitOperationSettings() {
    return createUnitOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateUnit. */
  public UnaryCallSettings<UpdateUnitOperationRequest, UnitOperation>
      updateUnitOperationSettings() {
    return updateUnitOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteUnit. */
  public UnaryCallSettings<DeleteUnitOperationRequest, Empty> deleteUnitOperationSettings() {
    return deleteUnitOperationSettings;
  }

  /** Returns the object with the settings used for calls to listReleases. */
  public PagedCallSettings<ListReleasesRequest, ListReleasesResponse, ListReleasesPagedResponse>
      listReleasesSettings() {
    return listReleasesSettings;
  }

  /** Returns the object with the settings used for calls to getRelease. */
  public UnaryCallSettings<GetReleaseRequest, Release> getReleaseSettings() {
    return getReleaseSettings;
  }

  /** Returns the object with the settings used for calls to createRelease. */
  public UnaryCallSettings<CreateReleaseRequest, Release> createReleaseSettings() {
    return createReleaseSettings;
  }

  /** Returns the object with the settings used for calls to updateRelease. */
  public UnaryCallSettings<UpdateReleaseRequest, Release> updateReleaseSettings() {
    return updateReleaseSettings;
  }

  /** Returns the object with the settings used for calls to deleteRelease. */
  public UnaryCallSettings<DeleteReleaseRequest, Empty> deleteReleaseSettings() {
    return deleteReleaseSettings;
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

  public SaasDeploymentsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcSaasDeploymentsStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonSaasDeploymentsStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "saasservicemgmt";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "saasservicemgmt.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "saasservicemgmt.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(SaasDeploymentsStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(SaasDeploymentsStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SaasDeploymentsStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected SaasDeploymentsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listSaasSettings = settingsBuilder.listSaasSettings().build();
    getSaasSettings = settingsBuilder.getSaasSettings().build();
    createSaasSettings = settingsBuilder.createSaasSettings().build();
    updateSaasSettings = settingsBuilder.updateSaasSettings().build();
    deleteSaasSettings = settingsBuilder.deleteSaasSettings().build();
    listTenantsSettings = settingsBuilder.listTenantsSettings().build();
    getTenantSettings = settingsBuilder.getTenantSettings().build();
    createTenantSettings = settingsBuilder.createTenantSettings().build();
    updateTenantSettings = settingsBuilder.updateTenantSettings().build();
    deleteTenantSettings = settingsBuilder.deleteTenantSettings().build();
    listUnitKindsSettings = settingsBuilder.listUnitKindsSettings().build();
    getUnitKindSettings = settingsBuilder.getUnitKindSettings().build();
    createUnitKindSettings = settingsBuilder.createUnitKindSettings().build();
    updateUnitKindSettings = settingsBuilder.updateUnitKindSettings().build();
    deleteUnitKindSettings = settingsBuilder.deleteUnitKindSettings().build();
    listUnitsSettings = settingsBuilder.listUnitsSettings().build();
    getUnitSettings = settingsBuilder.getUnitSettings().build();
    createUnitSettings = settingsBuilder.createUnitSettings().build();
    updateUnitSettings = settingsBuilder.updateUnitSettings().build();
    deleteUnitSettings = settingsBuilder.deleteUnitSettings().build();
    listUnitOperationsSettings = settingsBuilder.listUnitOperationsSettings().build();
    getUnitOperationSettings = settingsBuilder.getUnitOperationSettings().build();
    createUnitOperationSettings = settingsBuilder.createUnitOperationSettings().build();
    updateUnitOperationSettings = settingsBuilder.updateUnitOperationSettings().build();
    deleteUnitOperationSettings = settingsBuilder.deleteUnitOperationSettings().build();
    listReleasesSettings = settingsBuilder.listReleasesSettings().build();
    getReleaseSettings = settingsBuilder.getReleaseSettings().build();
    createReleaseSettings = settingsBuilder.createReleaseSettings().build();
    updateReleaseSettings = settingsBuilder.updateReleaseSettings().build();
    deleteReleaseSettings = settingsBuilder.deleteReleaseSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for SaasDeploymentsStubSettings. */
  public static class Builder extends StubSettings.Builder<SaasDeploymentsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListSaasRequest, ListSaasResponse, ListSaasPagedResponse>
        listSaasSettings;
    private final UnaryCallSettings.Builder<GetSaasRequest, Saas> getSaasSettings;
    private final UnaryCallSettings.Builder<CreateSaasRequest, Saas> createSaasSettings;
    private final UnaryCallSettings.Builder<UpdateSaasRequest, Saas> updateSaasSettings;
    private final UnaryCallSettings.Builder<DeleteSaasRequest, Empty> deleteSaasSettings;
    private final PagedCallSettings.Builder<
            ListTenantsRequest, ListTenantsResponse, ListTenantsPagedResponse>
        listTenantsSettings;
    private final UnaryCallSettings.Builder<GetTenantRequest, Tenant> getTenantSettings;
    private final UnaryCallSettings.Builder<CreateTenantRequest, Tenant> createTenantSettings;
    private final UnaryCallSettings.Builder<UpdateTenantRequest, Tenant> updateTenantSettings;
    private final UnaryCallSettings.Builder<DeleteTenantRequest, Empty> deleteTenantSettings;
    private final PagedCallSettings.Builder<
            ListUnitKindsRequest, ListUnitKindsResponse, ListUnitKindsPagedResponse>
        listUnitKindsSettings;
    private final UnaryCallSettings.Builder<GetUnitKindRequest, UnitKind> getUnitKindSettings;
    private final UnaryCallSettings.Builder<CreateUnitKindRequest, UnitKind> createUnitKindSettings;
    private final UnaryCallSettings.Builder<UpdateUnitKindRequest, UnitKind> updateUnitKindSettings;
    private final UnaryCallSettings.Builder<DeleteUnitKindRequest, Empty> deleteUnitKindSettings;
    private final PagedCallSettings.Builder<
            ListUnitsRequest, ListUnitsResponse, ListUnitsPagedResponse>
        listUnitsSettings;
    private final UnaryCallSettings.Builder<GetUnitRequest, Unit> getUnitSettings;
    private final UnaryCallSettings.Builder<CreateUnitRequest, Unit> createUnitSettings;
    private final UnaryCallSettings.Builder<UpdateUnitRequest, Unit> updateUnitSettings;
    private final UnaryCallSettings.Builder<DeleteUnitRequest, Empty> deleteUnitSettings;
    private final PagedCallSettings.Builder<
            ListUnitOperationsRequest, ListUnitOperationsResponse, ListUnitOperationsPagedResponse>
        listUnitOperationsSettings;
    private final UnaryCallSettings.Builder<GetUnitOperationRequest, UnitOperation>
        getUnitOperationSettings;
    private final UnaryCallSettings.Builder<CreateUnitOperationRequest, UnitOperation>
        createUnitOperationSettings;
    private final UnaryCallSettings.Builder<UpdateUnitOperationRequest, UnitOperation>
        updateUnitOperationSettings;
    private final UnaryCallSettings.Builder<DeleteUnitOperationRequest, Empty>
        deleteUnitOperationSettings;
    private final PagedCallSettings.Builder<
            ListReleasesRequest, ListReleasesResponse, ListReleasesPagedResponse>
        listReleasesSettings;
    private final UnaryCallSettings.Builder<GetReleaseRequest, Release> getReleaseSettings;
    private final UnaryCallSettings.Builder<CreateReleaseRequest, Release> createReleaseSettings;
    private final UnaryCallSettings.Builder<UpdateReleaseRequest, Release> updateReleaseSettings;
    private final UnaryCallSettings.Builder<DeleteReleaseRequest, Empty> deleteReleaseSettings;
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
          "retry_policy_1_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_4_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "no_retry_5_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setInitialRpcTimeoutDuration(Duration.ofMillis(80000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(80000L))
              .setTotalTimeoutDuration(Duration.ofMillis(80000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setTotalTimeoutDuration(Duration.ofMillis(30000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setTotalTimeoutDuration(Duration.ofMillis(30000L))
              .build();
      definitions.put("no_retry_4_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(80000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(80000L))
              .setTotalTimeoutDuration(Duration.ofMillis(80000L))
              .build();
      definitions.put("no_retry_5_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listSaasSettings = PagedCallSettings.newBuilder(LIST_SAAS_PAGE_STR_FACT);
      getSaasSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSaasSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSaasSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSaasSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listTenantsSettings = PagedCallSettings.newBuilder(LIST_TENANTS_PAGE_STR_FACT);
      getTenantSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTenantSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTenantSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTenantSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listUnitKindsSettings = PagedCallSettings.newBuilder(LIST_UNIT_KINDS_PAGE_STR_FACT);
      getUnitKindSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createUnitKindSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateUnitKindSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteUnitKindSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listUnitsSettings = PagedCallSettings.newBuilder(LIST_UNITS_PAGE_STR_FACT);
      getUnitSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createUnitSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateUnitSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteUnitSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listUnitOperationsSettings = PagedCallSettings.newBuilder(LIST_UNIT_OPERATIONS_PAGE_STR_FACT);
      getUnitOperationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createUnitOperationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateUnitOperationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteUnitOperationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listReleasesSettings = PagedCallSettings.newBuilder(LIST_RELEASES_PAGE_STR_FACT);
      getReleaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createReleaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateReleaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteReleaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listSaasSettings,
              getSaasSettings,
              createSaasSettings,
              updateSaasSettings,
              deleteSaasSettings,
              listTenantsSettings,
              getTenantSettings,
              createTenantSettings,
              updateTenantSettings,
              deleteTenantSettings,
              listUnitKindsSettings,
              getUnitKindSettings,
              createUnitKindSettings,
              updateUnitKindSettings,
              deleteUnitKindSettings,
              listUnitsSettings,
              getUnitSettings,
              createUnitSettings,
              updateUnitSettings,
              deleteUnitSettings,
              listUnitOperationsSettings,
              getUnitOperationSettings,
              createUnitOperationSettings,
              updateUnitOperationSettings,
              deleteUnitOperationSettings,
              listReleasesSettings,
              getReleaseSettings,
              createReleaseSettings,
              updateReleaseSettings,
              deleteReleaseSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(SaasDeploymentsStubSettings settings) {
      super(settings);

      listSaasSettings = settings.listSaasSettings.toBuilder();
      getSaasSettings = settings.getSaasSettings.toBuilder();
      createSaasSettings = settings.createSaasSettings.toBuilder();
      updateSaasSettings = settings.updateSaasSettings.toBuilder();
      deleteSaasSettings = settings.deleteSaasSettings.toBuilder();
      listTenantsSettings = settings.listTenantsSettings.toBuilder();
      getTenantSettings = settings.getTenantSettings.toBuilder();
      createTenantSettings = settings.createTenantSettings.toBuilder();
      updateTenantSettings = settings.updateTenantSettings.toBuilder();
      deleteTenantSettings = settings.deleteTenantSettings.toBuilder();
      listUnitKindsSettings = settings.listUnitKindsSettings.toBuilder();
      getUnitKindSettings = settings.getUnitKindSettings.toBuilder();
      createUnitKindSettings = settings.createUnitKindSettings.toBuilder();
      updateUnitKindSettings = settings.updateUnitKindSettings.toBuilder();
      deleteUnitKindSettings = settings.deleteUnitKindSettings.toBuilder();
      listUnitsSettings = settings.listUnitsSettings.toBuilder();
      getUnitSettings = settings.getUnitSettings.toBuilder();
      createUnitSettings = settings.createUnitSettings.toBuilder();
      updateUnitSettings = settings.updateUnitSettings.toBuilder();
      deleteUnitSettings = settings.deleteUnitSettings.toBuilder();
      listUnitOperationsSettings = settings.listUnitOperationsSettings.toBuilder();
      getUnitOperationSettings = settings.getUnitOperationSettings.toBuilder();
      createUnitOperationSettings = settings.createUnitOperationSettings.toBuilder();
      updateUnitOperationSettings = settings.updateUnitOperationSettings.toBuilder();
      deleteUnitOperationSettings = settings.deleteUnitOperationSettings.toBuilder();
      listReleasesSettings = settings.listReleasesSettings.toBuilder();
      getReleaseSettings = settings.getReleaseSettings.toBuilder();
      createReleaseSettings = settings.createReleaseSettings.toBuilder();
      updateReleaseSettings = settings.updateReleaseSettings.toBuilder();
      deleteReleaseSettings = settings.deleteReleaseSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listSaasSettings,
              getSaasSettings,
              createSaasSettings,
              updateSaasSettings,
              deleteSaasSettings,
              listTenantsSettings,
              getTenantSettings,
              createTenantSettings,
              updateTenantSettings,
              deleteTenantSettings,
              listUnitKindsSettings,
              getUnitKindSettings,
              createUnitKindSettings,
              updateUnitKindSettings,
              deleteUnitKindSettings,
              listUnitsSettings,
              getUnitSettings,
              createUnitSettings,
              updateUnitSettings,
              deleteUnitSettings,
              listUnitOperationsSettings,
              getUnitOperationSettings,
              createUnitOperationSettings,
              updateUnitOperationSettings,
              deleteUnitOperationSettings,
              listReleasesSettings,
              getReleaseSettings,
              createReleaseSettings,
              updateReleaseSettings,
              deleteReleaseSettings,
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
          .listSaasSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getSaasSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createSaasSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_4_params"));

      builder
          .updateSaasSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_4_params"));

      builder
          .deleteSaasSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listTenantsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getTenantSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createTenantSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_4_params"));

      builder
          .updateTenantSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_4_params"));

      builder
          .deleteTenantSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listUnitKindsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getUnitKindSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createUnitKindSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_4_params"));

      builder
          .updateUnitKindSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_5_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_5_params"));

      builder
          .deleteUnitKindSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listUnitsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getUnitSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createUnitSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_4_params"));

      builder
          .updateUnitSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_4_params"));

      builder
          .deleteUnitSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listUnitOperationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getUnitOperationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createUnitOperationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_4_params"));

      builder
          .updateUnitOperationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_4_params"));

      builder
          .deleteUnitOperationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listReleasesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getReleaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createReleaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_4_params"));

      builder
          .updateReleaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_4_params"));

      builder
          .deleteReleaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

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

    /** Returns the builder for the settings used for calls to listSaas. */
    public PagedCallSettings.Builder<ListSaasRequest, ListSaasResponse, ListSaasPagedResponse>
        listSaasSettings() {
      return listSaasSettings;
    }

    /** Returns the builder for the settings used for calls to getSaas. */
    public UnaryCallSettings.Builder<GetSaasRequest, Saas> getSaasSettings() {
      return getSaasSettings;
    }

    /** Returns the builder for the settings used for calls to createSaas. */
    public UnaryCallSettings.Builder<CreateSaasRequest, Saas> createSaasSettings() {
      return createSaasSettings;
    }

    /** Returns the builder for the settings used for calls to updateSaas. */
    public UnaryCallSettings.Builder<UpdateSaasRequest, Saas> updateSaasSettings() {
      return updateSaasSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSaas. */
    public UnaryCallSettings.Builder<DeleteSaasRequest, Empty> deleteSaasSettings() {
      return deleteSaasSettings;
    }

    /** Returns the builder for the settings used for calls to listTenants. */
    public PagedCallSettings.Builder<
            ListTenantsRequest, ListTenantsResponse, ListTenantsPagedResponse>
        listTenantsSettings() {
      return listTenantsSettings;
    }

    /** Returns the builder for the settings used for calls to getTenant. */
    public UnaryCallSettings.Builder<GetTenantRequest, Tenant> getTenantSettings() {
      return getTenantSettings;
    }

    /** Returns the builder for the settings used for calls to createTenant. */
    public UnaryCallSettings.Builder<CreateTenantRequest, Tenant> createTenantSettings() {
      return createTenantSettings;
    }

    /** Returns the builder for the settings used for calls to updateTenant. */
    public UnaryCallSettings.Builder<UpdateTenantRequest, Tenant> updateTenantSettings() {
      return updateTenantSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTenant. */
    public UnaryCallSettings.Builder<DeleteTenantRequest, Empty> deleteTenantSettings() {
      return deleteTenantSettings;
    }

    /** Returns the builder for the settings used for calls to listUnitKinds. */
    public PagedCallSettings.Builder<
            ListUnitKindsRequest, ListUnitKindsResponse, ListUnitKindsPagedResponse>
        listUnitKindsSettings() {
      return listUnitKindsSettings;
    }

    /** Returns the builder for the settings used for calls to getUnitKind. */
    public UnaryCallSettings.Builder<GetUnitKindRequest, UnitKind> getUnitKindSettings() {
      return getUnitKindSettings;
    }

    /** Returns the builder for the settings used for calls to createUnitKind. */
    public UnaryCallSettings.Builder<CreateUnitKindRequest, UnitKind> createUnitKindSettings() {
      return createUnitKindSettings;
    }

    /** Returns the builder for the settings used for calls to updateUnitKind. */
    public UnaryCallSettings.Builder<UpdateUnitKindRequest, UnitKind> updateUnitKindSettings() {
      return updateUnitKindSettings;
    }

    /** Returns the builder for the settings used for calls to deleteUnitKind. */
    public UnaryCallSettings.Builder<DeleteUnitKindRequest, Empty> deleteUnitKindSettings() {
      return deleteUnitKindSettings;
    }

    /** Returns the builder for the settings used for calls to listUnits. */
    public PagedCallSettings.Builder<ListUnitsRequest, ListUnitsResponse, ListUnitsPagedResponse>
        listUnitsSettings() {
      return listUnitsSettings;
    }

    /** Returns the builder for the settings used for calls to getUnit. */
    public UnaryCallSettings.Builder<GetUnitRequest, Unit> getUnitSettings() {
      return getUnitSettings;
    }

    /** Returns the builder for the settings used for calls to createUnit. */
    public UnaryCallSettings.Builder<CreateUnitRequest, Unit> createUnitSettings() {
      return createUnitSettings;
    }

    /** Returns the builder for the settings used for calls to updateUnit. */
    public UnaryCallSettings.Builder<UpdateUnitRequest, Unit> updateUnitSettings() {
      return updateUnitSettings;
    }

    /** Returns the builder for the settings used for calls to deleteUnit. */
    public UnaryCallSettings.Builder<DeleteUnitRequest, Empty> deleteUnitSettings() {
      return deleteUnitSettings;
    }

    /** Returns the builder for the settings used for calls to listUnitOperations. */
    public PagedCallSettings.Builder<
            ListUnitOperationsRequest, ListUnitOperationsResponse, ListUnitOperationsPagedResponse>
        listUnitOperationsSettings() {
      return listUnitOperationsSettings;
    }

    /** Returns the builder for the settings used for calls to getUnit. */
    public UnaryCallSettings.Builder<GetUnitOperationRequest, UnitOperation>
        getUnitOperationSettings() {
      return getUnitOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createUnit. */
    public UnaryCallSettings.Builder<CreateUnitOperationRequest, UnitOperation>
        createUnitOperationSettings() {
      return createUnitOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateUnit. */
    public UnaryCallSettings.Builder<UpdateUnitOperationRequest, UnitOperation>
        updateUnitOperationSettings() {
      return updateUnitOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteUnit. */
    public UnaryCallSettings.Builder<DeleteUnitOperationRequest, Empty>
        deleteUnitOperationSettings() {
      return deleteUnitOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listReleases. */
    public PagedCallSettings.Builder<
            ListReleasesRequest, ListReleasesResponse, ListReleasesPagedResponse>
        listReleasesSettings() {
      return listReleasesSettings;
    }

    /** Returns the builder for the settings used for calls to getRelease. */
    public UnaryCallSettings.Builder<GetReleaseRequest, Release> getReleaseSettings() {
      return getReleaseSettings;
    }

    /** Returns the builder for the settings used for calls to createRelease. */
    public UnaryCallSettings.Builder<CreateReleaseRequest, Release> createReleaseSettings() {
      return createReleaseSettings;
    }

    /** Returns the builder for the settings used for calls to updateRelease. */
    public UnaryCallSettings.Builder<UpdateReleaseRequest, Release> updateReleaseSettings() {
      return updateReleaseSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRelease. */
    public UnaryCallSettings.Builder<DeleteReleaseRequest, Empty> deleteReleaseSettings() {
      return deleteReleaseSettings;
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
    public SaasDeploymentsStubSettings build() throws IOException {
      return new SaasDeploymentsStubSettings(this);
    }
  }
}
