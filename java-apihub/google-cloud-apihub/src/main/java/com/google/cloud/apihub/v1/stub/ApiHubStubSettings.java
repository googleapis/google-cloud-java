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

package com.google.cloud.apihub.v1.stub;

import static com.google.cloud.apihub.v1.ApiHubClient.ListApiOperationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListApisPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListAttributesPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListDeploymentsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListExternalApisPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListLocationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListSpecsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListVersionsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.SearchResourcesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
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
import com.google.cloud.apihub.v1.Api;
import com.google.cloud.apihub.v1.ApiOperation;
import com.google.cloud.apihub.v1.Attribute;
import com.google.cloud.apihub.v1.CreateApiOperationRequest;
import com.google.cloud.apihub.v1.CreateApiRequest;
import com.google.cloud.apihub.v1.CreateAttributeRequest;
import com.google.cloud.apihub.v1.CreateDeploymentRequest;
import com.google.cloud.apihub.v1.CreateExternalApiRequest;
import com.google.cloud.apihub.v1.CreateSpecRequest;
import com.google.cloud.apihub.v1.CreateVersionRequest;
import com.google.cloud.apihub.v1.Definition;
import com.google.cloud.apihub.v1.DeleteApiOperationRequest;
import com.google.cloud.apihub.v1.DeleteApiRequest;
import com.google.cloud.apihub.v1.DeleteAttributeRequest;
import com.google.cloud.apihub.v1.DeleteDeploymentRequest;
import com.google.cloud.apihub.v1.DeleteExternalApiRequest;
import com.google.cloud.apihub.v1.DeleteSpecRequest;
import com.google.cloud.apihub.v1.DeleteVersionRequest;
import com.google.cloud.apihub.v1.Deployment;
import com.google.cloud.apihub.v1.ExternalApi;
import com.google.cloud.apihub.v1.GetApiOperationRequest;
import com.google.cloud.apihub.v1.GetApiRequest;
import com.google.cloud.apihub.v1.GetAttributeRequest;
import com.google.cloud.apihub.v1.GetDefinitionRequest;
import com.google.cloud.apihub.v1.GetDeploymentRequest;
import com.google.cloud.apihub.v1.GetExternalApiRequest;
import com.google.cloud.apihub.v1.GetSpecContentsRequest;
import com.google.cloud.apihub.v1.GetSpecRequest;
import com.google.cloud.apihub.v1.GetVersionRequest;
import com.google.cloud.apihub.v1.ListApiOperationsRequest;
import com.google.cloud.apihub.v1.ListApiOperationsResponse;
import com.google.cloud.apihub.v1.ListApisRequest;
import com.google.cloud.apihub.v1.ListApisResponse;
import com.google.cloud.apihub.v1.ListAttributesRequest;
import com.google.cloud.apihub.v1.ListAttributesResponse;
import com.google.cloud.apihub.v1.ListDeploymentsRequest;
import com.google.cloud.apihub.v1.ListDeploymentsResponse;
import com.google.cloud.apihub.v1.ListExternalApisRequest;
import com.google.cloud.apihub.v1.ListExternalApisResponse;
import com.google.cloud.apihub.v1.ListSpecsRequest;
import com.google.cloud.apihub.v1.ListSpecsResponse;
import com.google.cloud.apihub.v1.ListVersionsRequest;
import com.google.cloud.apihub.v1.ListVersionsResponse;
import com.google.cloud.apihub.v1.SearchResourcesRequest;
import com.google.cloud.apihub.v1.SearchResourcesResponse;
import com.google.cloud.apihub.v1.SearchResult;
import com.google.cloud.apihub.v1.Spec;
import com.google.cloud.apihub.v1.SpecContents;
import com.google.cloud.apihub.v1.UpdateApiOperationRequest;
import com.google.cloud.apihub.v1.UpdateApiRequest;
import com.google.cloud.apihub.v1.UpdateAttributeRequest;
import com.google.cloud.apihub.v1.UpdateDeploymentRequest;
import com.google.cloud.apihub.v1.UpdateExternalApiRequest;
import com.google.cloud.apihub.v1.UpdateSpecRequest;
import com.google.cloud.apihub.v1.UpdateVersionRequest;
import com.google.cloud.apihub.v1.Version;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * Settings class to configure an instance of {@link ApiHubStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (apihub.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createApi:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ApiHubStubSettings.Builder apiHubSettingsBuilder = ApiHubStubSettings.newBuilder();
 * apiHubSettingsBuilder
 *     .createApiSettings()
 *     .setRetrySettings(
 *         apiHubSettingsBuilder
 *             .createApiSettings()
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
 * ApiHubStubSettings apiHubSettings = apiHubSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class ApiHubStubSettings extends StubSettings<ApiHubStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateApiRequest, Api> createApiSettings;
  private final UnaryCallSettings<GetApiRequest, Api> getApiSettings;
  private final PagedCallSettings<ListApisRequest, ListApisResponse, ListApisPagedResponse>
      listApisSettings;
  private final UnaryCallSettings<UpdateApiRequest, Api> updateApiSettings;
  private final UnaryCallSettings<DeleteApiRequest, Empty> deleteApiSettings;
  private final UnaryCallSettings<CreateVersionRequest, Version> createVersionSettings;
  private final UnaryCallSettings<GetVersionRequest, Version> getVersionSettings;
  private final PagedCallSettings<
          ListVersionsRequest, ListVersionsResponse, ListVersionsPagedResponse>
      listVersionsSettings;
  private final UnaryCallSettings<UpdateVersionRequest, Version> updateVersionSettings;
  private final UnaryCallSettings<DeleteVersionRequest, Empty> deleteVersionSettings;
  private final UnaryCallSettings<CreateSpecRequest, Spec> createSpecSettings;
  private final UnaryCallSettings<GetSpecRequest, Spec> getSpecSettings;
  private final UnaryCallSettings<GetSpecContentsRequest, SpecContents> getSpecContentsSettings;
  private final PagedCallSettings<ListSpecsRequest, ListSpecsResponse, ListSpecsPagedResponse>
      listSpecsSettings;
  private final UnaryCallSettings<UpdateSpecRequest, Spec> updateSpecSettings;
  private final UnaryCallSettings<DeleteSpecRequest, Empty> deleteSpecSettings;
  private final UnaryCallSettings<CreateApiOperationRequest, ApiOperation>
      createApiOperationSettings;
  private final UnaryCallSettings<GetApiOperationRequest, ApiOperation> getApiOperationSettings;
  private final PagedCallSettings<
          ListApiOperationsRequest, ListApiOperationsResponse, ListApiOperationsPagedResponse>
      listApiOperationsSettings;
  private final UnaryCallSettings<UpdateApiOperationRequest, ApiOperation>
      updateApiOperationSettings;
  private final UnaryCallSettings<DeleteApiOperationRequest, Empty> deleteApiOperationSettings;
  private final UnaryCallSettings<GetDefinitionRequest, Definition> getDefinitionSettings;
  private final UnaryCallSettings<CreateDeploymentRequest, Deployment> createDeploymentSettings;
  private final UnaryCallSettings<GetDeploymentRequest, Deployment> getDeploymentSettings;
  private final PagedCallSettings<
          ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
      listDeploymentsSettings;
  private final UnaryCallSettings<UpdateDeploymentRequest, Deployment> updateDeploymentSettings;
  private final UnaryCallSettings<DeleteDeploymentRequest, Empty> deleteDeploymentSettings;
  private final UnaryCallSettings<CreateAttributeRequest, Attribute> createAttributeSettings;
  private final UnaryCallSettings<GetAttributeRequest, Attribute> getAttributeSettings;
  private final UnaryCallSettings<UpdateAttributeRequest, Attribute> updateAttributeSettings;
  private final UnaryCallSettings<DeleteAttributeRequest, Empty> deleteAttributeSettings;
  private final PagedCallSettings<
          ListAttributesRequest, ListAttributesResponse, ListAttributesPagedResponse>
      listAttributesSettings;
  private final PagedCallSettings<
          SearchResourcesRequest, SearchResourcesResponse, SearchResourcesPagedResponse>
      searchResourcesSettings;
  private final UnaryCallSettings<CreateExternalApiRequest, ExternalApi> createExternalApiSettings;
  private final UnaryCallSettings<GetExternalApiRequest, ExternalApi> getExternalApiSettings;
  private final UnaryCallSettings<UpdateExternalApiRequest, ExternalApi> updateExternalApiSettings;
  private final UnaryCallSettings<DeleteExternalApiRequest, Empty> deleteExternalApiSettings;
  private final PagedCallSettings<
          ListExternalApisRequest, ListExternalApisResponse, ListExternalApisPagedResponse>
      listExternalApisSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListApisRequest, ListApisResponse, Api>
      LIST_APIS_PAGE_STR_DESC =
          new PagedListDescriptor<ListApisRequest, ListApisResponse, Api>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListApisRequest injectToken(ListApisRequest payload, String token) {
              return ListApisRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListApisRequest injectPageSize(ListApisRequest payload, int pageSize) {
              return ListApisRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListApisRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListApisResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Api> extractResources(ListApisResponse payload) {
              return payload.getApisList();
            }
          };

  private static final PagedListDescriptor<ListVersionsRequest, ListVersionsResponse, Version>
      LIST_VERSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListVersionsRequest, ListVersionsResponse, Version>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListVersionsRequest injectToken(ListVersionsRequest payload, String token) {
              return ListVersionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListVersionsRequest injectPageSize(ListVersionsRequest payload, int pageSize) {
              return ListVersionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListVersionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListVersionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Version> extractResources(ListVersionsResponse payload) {
              return payload.getVersionsList();
            }
          };

  private static final PagedListDescriptor<ListSpecsRequest, ListSpecsResponse, Spec>
      LIST_SPECS_PAGE_STR_DESC =
          new PagedListDescriptor<ListSpecsRequest, ListSpecsResponse, Spec>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSpecsRequest injectToken(ListSpecsRequest payload, String token) {
              return ListSpecsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSpecsRequest injectPageSize(ListSpecsRequest payload, int pageSize) {
              return ListSpecsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSpecsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSpecsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Spec> extractResources(ListSpecsResponse payload) {
              return payload.getSpecsList();
            }
          };

  private static final PagedListDescriptor<
          ListApiOperationsRequest, ListApiOperationsResponse, ApiOperation>
      LIST_API_OPERATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListApiOperationsRequest, ListApiOperationsResponse, ApiOperation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListApiOperationsRequest injectToken(
                ListApiOperationsRequest payload, String token) {
              return ListApiOperationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListApiOperationsRequest injectPageSize(
                ListApiOperationsRequest payload, int pageSize) {
              return ListApiOperationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListApiOperationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListApiOperationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ApiOperation> extractResources(ListApiOperationsResponse payload) {
              return payload.getApiOperationsList();
            }
          };

  private static final PagedListDescriptor<
          ListDeploymentsRequest, ListDeploymentsResponse, Deployment>
      LIST_DEPLOYMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDeploymentsRequest, ListDeploymentsResponse, Deployment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDeploymentsRequest injectToken(
                ListDeploymentsRequest payload, String token) {
              return ListDeploymentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDeploymentsRequest injectPageSize(
                ListDeploymentsRequest payload, int pageSize) {
              return ListDeploymentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDeploymentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDeploymentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Deployment> extractResources(ListDeploymentsResponse payload) {
              return payload.getDeploymentsList();
            }
          };

  private static final PagedListDescriptor<ListAttributesRequest, ListAttributesResponse, Attribute>
      LIST_ATTRIBUTES_PAGE_STR_DESC =
          new PagedListDescriptor<ListAttributesRequest, ListAttributesResponse, Attribute>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAttributesRequest injectToken(ListAttributesRequest payload, String token) {
              return ListAttributesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAttributesRequest injectPageSize(
                ListAttributesRequest payload, int pageSize) {
              return ListAttributesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAttributesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAttributesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Attribute> extractResources(ListAttributesResponse payload) {
              return payload.getAttributesList();
            }
          };

  private static final PagedListDescriptor<
          SearchResourcesRequest, SearchResourcesResponse, SearchResult>
      SEARCH_RESOURCES_PAGE_STR_DESC =
          new PagedListDescriptor<SearchResourcesRequest, SearchResourcesResponse, SearchResult>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchResourcesRequest injectToken(
                SearchResourcesRequest payload, String token) {
              return SearchResourcesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchResourcesRequest injectPageSize(
                SearchResourcesRequest payload, int pageSize) {
              return SearchResourcesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchResourcesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchResourcesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SearchResult> extractResources(SearchResourcesResponse payload) {
              return payload.getSearchResultsList();
            }
          };

  private static final PagedListDescriptor<
          ListExternalApisRequest, ListExternalApisResponse, ExternalApi>
      LIST_EXTERNAL_APIS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListExternalApisRequest, ListExternalApisResponse, ExternalApi>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListExternalApisRequest injectToken(
                ListExternalApisRequest payload, String token) {
              return ListExternalApisRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListExternalApisRequest injectPageSize(
                ListExternalApisRequest payload, int pageSize) {
              return ListExternalApisRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListExternalApisRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListExternalApisResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ExternalApi> extractResources(ListExternalApisResponse payload) {
              return payload.getExternalApisList();
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
          ListApisRequest, ListApisResponse, ListApisPagedResponse>
      LIST_APIS_PAGE_STR_FACT =
          new PagedListResponseFactory<ListApisRequest, ListApisResponse, ListApisPagedResponse>() {
            @Override
            public ApiFuture<ListApisPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListApisRequest, ListApisResponse> callable,
                ListApisRequest request,
                ApiCallContext context,
                ApiFuture<ListApisResponse> futureResponse) {
              PageContext<ListApisRequest, ListApisResponse, Api> pageContext =
                  PageContext.create(callable, LIST_APIS_PAGE_STR_DESC, request, context);
              return ListApisPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListVersionsRequest, ListVersionsResponse, ListVersionsPagedResponse>
      LIST_VERSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListVersionsRequest, ListVersionsResponse, ListVersionsPagedResponse>() {
            @Override
            public ApiFuture<ListVersionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListVersionsRequest, ListVersionsResponse> callable,
                ListVersionsRequest request,
                ApiCallContext context,
                ApiFuture<ListVersionsResponse> futureResponse) {
              PageContext<ListVersionsRequest, ListVersionsResponse, Version> pageContext =
                  PageContext.create(callable, LIST_VERSIONS_PAGE_STR_DESC, request, context);
              return ListVersionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSpecsRequest, ListSpecsResponse, ListSpecsPagedResponse>
      LIST_SPECS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSpecsRequest, ListSpecsResponse, ListSpecsPagedResponse>() {
            @Override
            public ApiFuture<ListSpecsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSpecsRequest, ListSpecsResponse> callable,
                ListSpecsRequest request,
                ApiCallContext context,
                ApiFuture<ListSpecsResponse> futureResponse) {
              PageContext<ListSpecsRequest, ListSpecsResponse, Spec> pageContext =
                  PageContext.create(callable, LIST_SPECS_PAGE_STR_DESC, request, context);
              return ListSpecsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListApiOperationsRequest, ListApiOperationsResponse, ListApiOperationsPagedResponse>
      LIST_API_OPERATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListApiOperationsRequest,
              ListApiOperationsResponse,
              ListApiOperationsPagedResponse>() {
            @Override
            public ApiFuture<ListApiOperationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListApiOperationsRequest, ListApiOperationsResponse> callable,
                ListApiOperationsRequest request,
                ApiCallContext context,
                ApiFuture<ListApiOperationsResponse> futureResponse) {
              PageContext<ListApiOperationsRequest, ListApiOperationsResponse, ApiOperation>
                  pageContext =
                      PageContext.create(
                          callable, LIST_API_OPERATIONS_PAGE_STR_DESC, request, context);
              return ListApiOperationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
      LIST_DEPLOYMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>() {
            @Override
            public ApiFuture<ListDeploymentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse> callable,
                ListDeploymentsRequest request,
                ApiCallContext context,
                ApiFuture<ListDeploymentsResponse> futureResponse) {
              PageContext<ListDeploymentsRequest, ListDeploymentsResponse, Deployment> pageContext =
                  PageContext.create(callable, LIST_DEPLOYMENTS_PAGE_STR_DESC, request, context);
              return ListDeploymentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAttributesRequest, ListAttributesResponse, ListAttributesPagedResponse>
      LIST_ATTRIBUTES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAttributesRequest, ListAttributesResponse, ListAttributesPagedResponse>() {
            @Override
            public ApiFuture<ListAttributesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAttributesRequest, ListAttributesResponse> callable,
                ListAttributesRequest request,
                ApiCallContext context,
                ApiFuture<ListAttributesResponse> futureResponse) {
              PageContext<ListAttributesRequest, ListAttributesResponse, Attribute> pageContext =
                  PageContext.create(callable, LIST_ATTRIBUTES_PAGE_STR_DESC, request, context);
              return ListAttributesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchResourcesRequest, SearchResourcesResponse, SearchResourcesPagedResponse>
      SEARCH_RESOURCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchResourcesRequest, SearchResourcesResponse, SearchResourcesPagedResponse>() {
            @Override
            public ApiFuture<SearchResourcesPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchResourcesRequest, SearchResourcesResponse> callable,
                SearchResourcesRequest request,
                ApiCallContext context,
                ApiFuture<SearchResourcesResponse> futureResponse) {
              PageContext<SearchResourcesRequest, SearchResourcesResponse, SearchResult>
                  pageContext =
                      PageContext.create(
                          callable, SEARCH_RESOURCES_PAGE_STR_DESC, request, context);
              return SearchResourcesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListExternalApisRequest, ListExternalApisResponse, ListExternalApisPagedResponse>
      LIST_EXTERNAL_APIS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListExternalApisRequest, ListExternalApisResponse, ListExternalApisPagedResponse>() {
            @Override
            public ApiFuture<ListExternalApisPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListExternalApisRequest, ListExternalApisResponse> callable,
                ListExternalApisRequest request,
                ApiCallContext context,
                ApiFuture<ListExternalApisResponse> futureResponse) {
              PageContext<ListExternalApisRequest, ListExternalApisResponse, ExternalApi>
                  pageContext =
                      PageContext.create(
                          callable, LIST_EXTERNAL_APIS_PAGE_STR_DESC, request, context);
              return ListExternalApisPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createApi. */
  public UnaryCallSettings<CreateApiRequest, Api> createApiSettings() {
    return createApiSettings;
  }

  /** Returns the object with the settings used for calls to getApi. */
  public UnaryCallSettings<GetApiRequest, Api> getApiSettings() {
    return getApiSettings;
  }

  /** Returns the object with the settings used for calls to listApis. */
  public PagedCallSettings<ListApisRequest, ListApisResponse, ListApisPagedResponse>
      listApisSettings() {
    return listApisSettings;
  }

  /** Returns the object with the settings used for calls to updateApi. */
  public UnaryCallSettings<UpdateApiRequest, Api> updateApiSettings() {
    return updateApiSettings;
  }

  /** Returns the object with the settings used for calls to deleteApi. */
  public UnaryCallSettings<DeleteApiRequest, Empty> deleteApiSettings() {
    return deleteApiSettings;
  }

  /** Returns the object with the settings used for calls to createVersion. */
  public UnaryCallSettings<CreateVersionRequest, Version> createVersionSettings() {
    return createVersionSettings;
  }

  /** Returns the object with the settings used for calls to getVersion. */
  public UnaryCallSettings<GetVersionRequest, Version> getVersionSettings() {
    return getVersionSettings;
  }

  /** Returns the object with the settings used for calls to listVersions. */
  public PagedCallSettings<ListVersionsRequest, ListVersionsResponse, ListVersionsPagedResponse>
      listVersionsSettings() {
    return listVersionsSettings;
  }

  /** Returns the object with the settings used for calls to updateVersion. */
  public UnaryCallSettings<UpdateVersionRequest, Version> updateVersionSettings() {
    return updateVersionSettings;
  }

  /** Returns the object with the settings used for calls to deleteVersion. */
  public UnaryCallSettings<DeleteVersionRequest, Empty> deleteVersionSettings() {
    return deleteVersionSettings;
  }

  /** Returns the object with the settings used for calls to createSpec. */
  public UnaryCallSettings<CreateSpecRequest, Spec> createSpecSettings() {
    return createSpecSettings;
  }

  /** Returns the object with the settings used for calls to getSpec. */
  public UnaryCallSettings<GetSpecRequest, Spec> getSpecSettings() {
    return getSpecSettings;
  }

  /** Returns the object with the settings used for calls to getSpecContents. */
  public UnaryCallSettings<GetSpecContentsRequest, SpecContents> getSpecContentsSettings() {
    return getSpecContentsSettings;
  }

  /** Returns the object with the settings used for calls to listSpecs. */
  public PagedCallSettings<ListSpecsRequest, ListSpecsResponse, ListSpecsPagedResponse>
      listSpecsSettings() {
    return listSpecsSettings;
  }

  /** Returns the object with the settings used for calls to updateSpec. */
  public UnaryCallSettings<UpdateSpecRequest, Spec> updateSpecSettings() {
    return updateSpecSettings;
  }

  /** Returns the object with the settings used for calls to deleteSpec. */
  public UnaryCallSettings<DeleteSpecRequest, Empty> deleteSpecSettings() {
    return deleteSpecSettings;
  }

  /** Returns the object with the settings used for calls to createApi. */
  public UnaryCallSettings<CreateApiOperationRequest, ApiOperation> createApiOperationSettings() {
    return createApiOperationSettings;
  }

  /** Returns the object with the settings used for calls to getApi. */
  public UnaryCallSettings<GetApiOperationRequest, ApiOperation> getApiOperationSettings() {
    return getApiOperationSettings;
  }

  /** Returns the object with the settings used for calls to listApiOperations. */
  public PagedCallSettings<
          ListApiOperationsRequest, ListApiOperationsResponse, ListApiOperationsPagedResponse>
      listApiOperationsSettings() {
    return listApiOperationsSettings;
  }

  /** Returns the object with the settings used for calls to updateApi. */
  public UnaryCallSettings<UpdateApiOperationRequest, ApiOperation> updateApiOperationSettings() {
    return updateApiOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteApi. */
  public UnaryCallSettings<DeleteApiOperationRequest, Empty> deleteApiOperationSettings() {
    return deleteApiOperationSettings;
  }

  /** Returns the object with the settings used for calls to getDefinition. */
  public UnaryCallSettings<GetDefinitionRequest, Definition> getDefinitionSettings() {
    return getDefinitionSettings;
  }

  /** Returns the object with the settings used for calls to createDeployment. */
  public UnaryCallSettings<CreateDeploymentRequest, Deployment> createDeploymentSettings() {
    return createDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to getDeployment. */
  public UnaryCallSettings<GetDeploymentRequest, Deployment> getDeploymentSettings() {
    return getDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to listDeployments. */
  public PagedCallSettings<
          ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
      listDeploymentsSettings() {
    return listDeploymentsSettings;
  }

  /** Returns the object with the settings used for calls to updateDeployment. */
  public UnaryCallSettings<UpdateDeploymentRequest, Deployment> updateDeploymentSettings() {
    return updateDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to deleteDeployment. */
  public UnaryCallSettings<DeleteDeploymentRequest, Empty> deleteDeploymentSettings() {
    return deleteDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to createAttribute. */
  public UnaryCallSettings<CreateAttributeRequest, Attribute> createAttributeSettings() {
    return createAttributeSettings;
  }

  /** Returns the object with the settings used for calls to getAttribute. */
  public UnaryCallSettings<GetAttributeRequest, Attribute> getAttributeSettings() {
    return getAttributeSettings;
  }

  /** Returns the object with the settings used for calls to updateAttribute. */
  public UnaryCallSettings<UpdateAttributeRequest, Attribute> updateAttributeSettings() {
    return updateAttributeSettings;
  }

  /** Returns the object with the settings used for calls to deleteAttribute. */
  public UnaryCallSettings<DeleteAttributeRequest, Empty> deleteAttributeSettings() {
    return deleteAttributeSettings;
  }

  /** Returns the object with the settings used for calls to listAttributes. */
  public PagedCallSettings<
          ListAttributesRequest, ListAttributesResponse, ListAttributesPagedResponse>
      listAttributesSettings() {
    return listAttributesSettings;
  }

  /** Returns the object with the settings used for calls to searchResources. */
  public PagedCallSettings<
          SearchResourcesRequest, SearchResourcesResponse, SearchResourcesPagedResponse>
      searchResourcesSettings() {
    return searchResourcesSettings;
  }

  /** Returns the object with the settings used for calls to createExternalApi. */
  public UnaryCallSettings<CreateExternalApiRequest, ExternalApi> createExternalApiSettings() {
    return createExternalApiSettings;
  }

  /** Returns the object with the settings used for calls to getExternalApi. */
  public UnaryCallSettings<GetExternalApiRequest, ExternalApi> getExternalApiSettings() {
    return getExternalApiSettings;
  }

  /** Returns the object with the settings used for calls to updateExternalApi. */
  public UnaryCallSettings<UpdateExternalApiRequest, ExternalApi> updateExternalApiSettings() {
    return updateExternalApiSettings;
  }

  /** Returns the object with the settings used for calls to deleteExternalApi. */
  public UnaryCallSettings<DeleteExternalApiRequest, Empty> deleteExternalApiSettings() {
    return deleteExternalApiSettings;
  }

  /** Returns the object with the settings used for calls to listExternalApis. */
  public PagedCallSettings<
          ListExternalApisRequest, ListExternalApisResponse, ListExternalApisPagedResponse>
      listExternalApisSettings() {
    return listExternalApisSettings;
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

  public ApiHubStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonApiHubStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "apihub";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "apihub.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "apihub.mtls.googleapis.com:443";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(ApiHubStubSettings.class))
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

  protected ApiHubStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createApiSettings = settingsBuilder.createApiSettings().build();
    getApiSettings = settingsBuilder.getApiSettings().build();
    listApisSettings = settingsBuilder.listApisSettings().build();
    updateApiSettings = settingsBuilder.updateApiSettings().build();
    deleteApiSettings = settingsBuilder.deleteApiSettings().build();
    createVersionSettings = settingsBuilder.createVersionSettings().build();
    getVersionSettings = settingsBuilder.getVersionSettings().build();
    listVersionsSettings = settingsBuilder.listVersionsSettings().build();
    updateVersionSettings = settingsBuilder.updateVersionSettings().build();
    deleteVersionSettings = settingsBuilder.deleteVersionSettings().build();
    createSpecSettings = settingsBuilder.createSpecSettings().build();
    getSpecSettings = settingsBuilder.getSpecSettings().build();
    getSpecContentsSettings = settingsBuilder.getSpecContentsSettings().build();
    listSpecsSettings = settingsBuilder.listSpecsSettings().build();
    updateSpecSettings = settingsBuilder.updateSpecSettings().build();
    deleteSpecSettings = settingsBuilder.deleteSpecSettings().build();
    createApiOperationSettings = settingsBuilder.createApiOperationSettings().build();
    getApiOperationSettings = settingsBuilder.getApiOperationSettings().build();
    listApiOperationsSettings = settingsBuilder.listApiOperationsSettings().build();
    updateApiOperationSettings = settingsBuilder.updateApiOperationSettings().build();
    deleteApiOperationSettings = settingsBuilder.deleteApiOperationSettings().build();
    getDefinitionSettings = settingsBuilder.getDefinitionSettings().build();
    createDeploymentSettings = settingsBuilder.createDeploymentSettings().build();
    getDeploymentSettings = settingsBuilder.getDeploymentSettings().build();
    listDeploymentsSettings = settingsBuilder.listDeploymentsSettings().build();
    updateDeploymentSettings = settingsBuilder.updateDeploymentSettings().build();
    deleteDeploymentSettings = settingsBuilder.deleteDeploymentSettings().build();
    createAttributeSettings = settingsBuilder.createAttributeSettings().build();
    getAttributeSettings = settingsBuilder.getAttributeSettings().build();
    updateAttributeSettings = settingsBuilder.updateAttributeSettings().build();
    deleteAttributeSettings = settingsBuilder.deleteAttributeSettings().build();
    listAttributesSettings = settingsBuilder.listAttributesSettings().build();
    searchResourcesSettings = settingsBuilder.searchResourcesSettings().build();
    createExternalApiSettings = settingsBuilder.createExternalApiSettings().build();
    getExternalApiSettings = settingsBuilder.getExternalApiSettings().build();
    updateExternalApiSettings = settingsBuilder.updateExternalApiSettings().build();
    deleteExternalApiSettings = settingsBuilder.deleteExternalApiSettings().build();
    listExternalApisSettings = settingsBuilder.listExternalApisSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for ApiHubStubSettings. */
  public static class Builder extends StubSettings.Builder<ApiHubStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateApiRequest, Api> createApiSettings;
    private final UnaryCallSettings.Builder<GetApiRequest, Api> getApiSettings;
    private final PagedCallSettings.Builder<
            ListApisRequest, ListApisResponse, ListApisPagedResponse>
        listApisSettings;
    private final UnaryCallSettings.Builder<UpdateApiRequest, Api> updateApiSettings;
    private final UnaryCallSettings.Builder<DeleteApiRequest, Empty> deleteApiSettings;
    private final UnaryCallSettings.Builder<CreateVersionRequest, Version> createVersionSettings;
    private final UnaryCallSettings.Builder<GetVersionRequest, Version> getVersionSettings;
    private final PagedCallSettings.Builder<
            ListVersionsRequest, ListVersionsResponse, ListVersionsPagedResponse>
        listVersionsSettings;
    private final UnaryCallSettings.Builder<UpdateVersionRequest, Version> updateVersionSettings;
    private final UnaryCallSettings.Builder<DeleteVersionRequest, Empty> deleteVersionSettings;
    private final UnaryCallSettings.Builder<CreateSpecRequest, Spec> createSpecSettings;
    private final UnaryCallSettings.Builder<GetSpecRequest, Spec> getSpecSettings;
    private final UnaryCallSettings.Builder<GetSpecContentsRequest, SpecContents>
        getSpecContentsSettings;
    private final PagedCallSettings.Builder<
            ListSpecsRequest, ListSpecsResponse, ListSpecsPagedResponse>
        listSpecsSettings;
    private final UnaryCallSettings.Builder<UpdateSpecRequest, Spec> updateSpecSettings;
    private final UnaryCallSettings.Builder<DeleteSpecRequest, Empty> deleteSpecSettings;
    private final UnaryCallSettings.Builder<CreateApiOperationRequest, ApiOperation>
        createApiOperationSettings;
    private final UnaryCallSettings.Builder<GetApiOperationRequest, ApiOperation>
        getApiOperationSettings;
    private final PagedCallSettings.Builder<
            ListApiOperationsRequest, ListApiOperationsResponse, ListApiOperationsPagedResponse>
        listApiOperationsSettings;
    private final UnaryCallSettings.Builder<UpdateApiOperationRequest, ApiOperation>
        updateApiOperationSettings;
    private final UnaryCallSettings.Builder<DeleteApiOperationRequest, Empty>
        deleteApiOperationSettings;
    private final UnaryCallSettings.Builder<GetDefinitionRequest, Definition> getDefinitionSettings;
    private final UnaryCallSettings.Builder<CreateDeploymentRequest, Deployment>
        createDeploymentSettings;
    private final UnaryCallSettings.Builder<GetDeploymentRequest, Deployment> getDeploymentSettings;
    private final PagedCallSettings.Builder<
            ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
        listDeploymentsSettings;
    private final UnaryCallSettings.Builder<UpdateDeploymentRequest, Deployment>
        updateDeploymentSettings;
    private final UnaryCallSettings.Builder<DeleteDeploymentRequest, Empty>
        deleteDeploymentSettings;
    private final UnaryCallSettings.Builder<CreateAttributeRequest, Attribute>
        createAttributeSettings;
    private final UnaryCallSettings.Builder<GetAttributeRequest, Attribute> getAttributeSettings;
    private final UnaryCallSettings.Builder<UpdateAttributeRequest, Attribute>
        updateAttributeSettings;
    private final UnaryCallSettings.Builder<DeleteAttributeRequest, Empty> deleteAttributeSettings;
    private final PagedCallSettings.Builder<
            ListAttributesRequest, ListAttributesResponse, ListAttributesPagedResponse>
        listAttributesSettings;
    private final PagedCallSettings.Builder<
            SearchResourcesRequest, SearchResourcesResponse, SearchResourcesPagedResponse>
        searchResourcesSettings;
    private final UnaryCallSettings.Builder<CreateExternalApiRequest, ExternalApi>
        createExternalApiSettings;
    private final UnaryCallSettings.Builder<GetExternalApiRequest, ExternalApi>
        getExternalApiSettings;
    private final UnaryCallSettings.Builder<UpdateExternalApiRequest, ExternalApi>
        updateExternalApiSettings;
    private final UnaryCallSettings.Builder<DeleteExternalApiRequest, Empty>
        deleteExternalApiSettings;
    private final PagedCallSettings.Builder<
            ListExternalApisRequest, ListExternalApisResponse, ListExternalApisPagedResponse>
        listExternalApisSettings;
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
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_2_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
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
              .setInitialRpcTimeoutDuration(Duration.ofMillis(300000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(300000L))
              .setTotalTimeoutDuration(Duration.ofMillis(300000L))
              .build();
      definitions.put("no_retry_2_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createApiSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getApiSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listApisSettings = PagedCallSettings.newBuilder(LIST_APIS_PAGE_STR_FACT);
      updateApiSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteApiSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listVersionsSettings = PagedCallSettings.newBuilder(LIST_VERSIONS_PAGE_STR_FACT);
      updateVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSpecSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSpecSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSpecContentsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSpecsSettings = PagedCallSettings.newBuilder(LIST_SPECS_PAGE_STR_FACT);
      updateSpecSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSpecSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createApiOperationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getApiOperationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listApiOperationsSettings = PagedCallSettings.newBuilder(LIST_API_OPERATIONS_PAGE_STR_FACT);
      updateApiOperationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteApiOperationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getDefinitionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDeploymentsSettings = PagedCallSettings.newBuilder(LIST_DEPLOYMENTS_PAGE_STR_FACT);
      updateDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAttributeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getAttributeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAttributeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAttributeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAttributesSettings = PagedCallSettings.newBuilder(LIST_ATTRIBUTES_PAGE_STR_FACT);
      searchResourcesSettings = PagedCallSettings.newBuilder(SEARCH_RESOURCES_PAGE_STR_FACT);
      createExternalApiSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getExternalApiSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateExternalApiSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteExternalApiSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listExternalApisSettings = PagedCallSettings.newBuilder(LIST_EXTERNAL_APIS_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createApiSettings,
              getApiSettings,
              listApisSettings,
              updateApiSettings,
              deleteApiSettings,
              createVersionSettings,
              getVersionSettings,
              listVersionsSettings,
              updateVersionSettings,
              deleteVersionSettings,
              createSpecSettings,
              getSpecSettings,
              getSpecContentsSettings,
              listSpecsSettings,
              updateSpecSettings,
              deleteSpecSettings,
              createApiOperationSettings,
              getApiOperationSettings,
              listApiOperationsSettings,
              updateApiOperationSettings,
              deleteApiOperationSettings,
              getDefinitionSettings,
              createDeploymentSettings,
              getDeploymentSettings,
              listDeploymentsSettings,
              updateDeploymentSettings,
              deleteDeploymentSettings,
              createAttributeSettings,
              getAttributeSettings,
              updateAttributeSettings,
              deleteAttributeSettings,
              listAttributesSettings,
              searchResourcesSettings,
              createExternalApiSettings,
              getExternalApiSettings,
              updateExternalApiSettings,
              deleteExternalApiSettings,
              listExternalApisSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(ApiHubStubSettings settings) {
      super(settings);

      createApiSettings = settings.createApiSettings.toBuilder();
      getApiSettings = settings.getApiSettings.toBuilder();
      listApisSettings = settings.listApisSettings.toBuilder();
      updateApiSettings = settings.updateApiSettings.toBuilder();
      deleteApiSettings = settings.deleteApiSettings.toBuilder();
      createVersionSettings = settings.createVersionSettings.toBuilder();
      getVersionSettings = settings.getVersionSettings.toBuilder();
      listVersionsSettings = settings.listVersionsSettings.toBuilder();
      updateVersionSettings = settings.updateVersionSettings.toBuilder();
      deleteVersionSettings = settings.deleteVersionSettings.toBuilder();
      createSpecSettings = settings.createSpecSettings.toBuilder();
      getSpecSettings = settings.getSpecSettings.toBuilder();
      getSpecContentsSettings = settings.getSpecContentsSettings.toBuilder();
      listSpecsSettings = settings.listSpecsSettings.toBuilder();
      updateSpecSettings = settings.updateSpecSettings.toBuilder();
      deleteSpecSettings = settings.deleteSpecSettings.toBuilder();
      createApiOperationSettings = settings.createApiOperationSettings.toBuilder();
      getApiOperationSettings = settings.getApiOperationSettings.toBuilder();
      listApiOperationsSettings = settings.listApiOperationsSettings.toBuilder();
      updateApiOperationSettings = settings.updateApiOperationSettings.toBuilder();
      deleteApiOperationSettings = settings.deleteApiOperationSettings.toBuilder();
      getDefinitionSettings = settings.getDefinitionSettings.toBuilder();
      createDeploymentSettings = settings.createDeploymentSettings.toBuilder();
      getDeploymentSettings = settings.getDeploymentSettings.toBuilder();
      listDeploymentsSettings = settings.listDeploymentsSettings.toBuilder();
      updateDeploymentSettings = settings.updateDeploymentSettings.toBuilder();
      deleteDeploymentSettings = settings.deleteDeploymentSettings.toBuilder();
      createAttributeSettings = settings.createAttributeSettings.toBuilder();
      getAttributeSettings = settings.getAttributeSettings.toBuilder();
      updateAttributeSettings = settings.updateAttributeSettings.toBuilder();
      deleteAttributeSettings = settings.deleteAttributeSettings.toBuilder();
      listAttributesSettings = settings.listAttributesSettings.toBuilder();
      searchResourcesSettings = settings.searchResourcesSettings.toBuilder();
      createExternalApiSettings = settings.createExternalApiSettings.toBuilder();
      getExternalApiSettings = settings.getExternalApiSettings.toBuilder();
      updateExternalApiSettings = settings.updateExternalApiSettings.toBuilder();
      deleteExternalApiSettings = settings.deleteExternalApiSettings.toBuilder();
      listExternalApisSettings = settings.listExternalApisSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createApiSettings,
              getApiSettings,
              listApisSettings,
              updateApiSettings,
              deleteApiSettings,
              createVersionSettings,
              getVersionSettings,
              listVersionsSettings,
              updateVersionSettings,
              deleteVersionSettings,
              createSpecSettings,
              getSpecSettings,
              getSpecContentsSettings,
              listSpecsSettings,
              updateSpecSettings,
              deleteSpecSettings,
              createApiOperationSettings,
              getApiOperationSettings,
              listApiOperationsSettings,
              updateApiOperationSettings,
              deleteApiOperationSettings,
              getDefinitionSettings,
              createDeploymentSettings,
              getDeploymentSettings,
              listDeploymentsSettings,
              updateDeploymentSettings,
              deleteDeploymentSettings,
              createAttributeSettings,
              getAttributeSettings,
              updateAttributeSettings,
              deleteAttributeSettings,
              listAttributesSettings,
              searchResourcesSettings,
              createExternalApiSettings,
              getExternalApiSettings,
              updateExternalApiSettings,
              deleteExternalApiSettings,
              listExternalApisSettings,
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

    private static Builder initDefaults(Builder builder) {
      builder
          .createApiSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getApiSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listApisSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateApiSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteApiSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .createVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listVersionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .createSpecSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getSpecSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getSpecContentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listSpecsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateSpecSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteSpecSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .createApiOperationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getApiOperationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listApiOperationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateApiOperationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteApiOperationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getDefinitionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDeploymentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createAttributeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getAttributeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateAttributeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteAttributeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listAttributesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .searchResourcesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createExternalApiSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getExternalApiSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateExternalApiSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteExternalApiSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listExternalApisSettings()
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

    /** Returns the builder for the settings used for calls to createApi. */
    public UnaryCallSettings.Builder<CreateApiRequest, Api> createApiSettings() {
      return createApiSettings;
    }

    /** Returns the builder for the settings used for calls to getApi. */
    public UnaryCallSettings.Builder<GetApiRequest, Api> getApiSettings() {
      return getApiSettings;
    }

    /** Returns the builder for the settings used for calls to listApis. */
    public PagedCallSettings.Builder<ListApisRequest, ListApisResponse, ListApisPagedResponse>
        listApisSettings() {
      return listApisSettings;
    }

    /** Returns the builder for the settings used for calls to updateApi. */
    public UnaryCallSettings.Builder<UpdateApiRequest, Api> updateApiSettings() {
      return updateApiSettings;
    }

    /** Returns the builder for the settings used for calls to deleteApi. */
    public UnaryCallSettings.Builder<DeleteApiRequest, Empty> deleteApiSettings() {
      return deleteApiSettings;
    }

    /** Returns the builder for the settings used for calls to createVersion. */
    public UnaryCallSettings.Builder<CreateVersionRequest, Version> createVersionSettings() {
      return createVersionSettings;
    }

    /** Returns the builder for the settings used for calls to getVersion. */
    public UnaryCallSettings.Builder<GetVersionRequest, Version> getVersionSettings() {
      return getVersionSettings;
    }

    /** Returns the builder for the settings used for calls to listVersions. */
    public PagedCallSettings.Builder<
            ListVersionsRequest, ListVersionsResponse, ListVersionsPagedResponse>
        listVersionsSettings() {
      return listVersionsSettings;
    }

    /** Returns the builder for the settings used for calls to updateVersion. */
    public UnaryCallSettings.Builder<UpdateVersionRequest, Version> updateVersionSettings() {
      return updateVersionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteVersion. */
    public UnaryCallSettings.Builder<DeleteVersionRequest, Empty> deleteVersionSettings() {
      return deleteVersionSettings;
    }

    /** Returns the builder for the settings used for calls to createSpec. */
    public UnaryCallSettings.Builder<CreateSpecRequest, Spec> createSpecSettings() {
      return createSpecSettings;
    }

    /** Returns the builder for the settings used for calls to getSpec. */
    public UnaryCallSettings.Builder<GetSpecRequest, Spec> getSpecSettings() {
      return getSpecSettings;
    }

    /** Returns the builder for the settings used for calls to getSpecContents. */
    public UnaryCallSettings.Builder<GetSpecContentsRequest, SpecContents>
        getSpecContentsSettings() {
      return getSpecContentsSettings;
    }

    /** Returns the builder for the settings used for calls to listSpecs. */
    public PagedCallSettings.Builder<ListSpecsRequest, ListSpecsResponse, ListSpecsPagedResponse>
        listSpecsSettings() {
      return listSpecsSettings;
    }

    /** Returns the builder for the settings used for calls to updateSpec. */
    public UnaryCallSettings.Builder<UpdateSpecRequest, Spec> updateSpecSettings() {
      return updateSpecSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSpec. */
    public UnaryCallSettings.Builder<DeleteSpecRequest, Empty> deleteSpecSettings() {
      return deleteSpecSettings;
    }

    /** Returns the builder for the settings used for calls to createApi. */
    public UnaryCallSettings.Builder<CreateApiOperationRequest, ApiOperation>
        createApiOperationSettings() {
      return createApiOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getApi. */
    public UnaryCallSettings.Builder<GetApiOperationRequest, ApiOperation>
        getApiOperationSettings() {
      return getApiOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listApiOperations. */
    public PagedCallSettings.Builder<
            ListApiOperationsRequest, ListApiOperationsResponse, ListApiOperationsPagedResponse>
        listApiOperationsSettings() {
      return listApiOperationsSettings;
    }

    /** Returns the builder for the settings used for calls to updateApi. */
    public UnaryCallSettings.Builder<UpdateApiOperationRequest, ApiOperation>
        updateApiOperationSettings() {
      return updateApiOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteApi. */
    public UnaryCallSettings.Builder<DeleteApiOperationRequest, Empty>
        deleteApiOperationSettings() {
      return deleteApiOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getDefinition. */
    public UnaryCallSettings.Builder<GetDefinitionRequest, Definition> getDefinitionSettings() {
      return getDefinitionSettings;
    }

    /** Returns the builder for the settings used for calls to createDeployment. */
    public UnaryCallSettings.Builder<CreateDeploymentRequest, Deployment>
        createDeploymentSettings() {
      return createDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to getDeployment. */
    public UnaryCallSettings.Builder<GetDeploymentRequest, Deployment> getDeploymentSettings() {
      return getDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to listDeployments. */
    public PagedCallSettings.Builder<
            ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
        listDeploymentsSettings() {
      return listDeploymentsSettings;
    }

    /** Returns the builder for the settings used for calls to updateDeployment. */
    public UnaryCallSettings.Builder<UpdateDeploymentRequest, Deployment>
        updateDeploymentSettings() {
      return updateDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDeployment. */
    public UnaryCallSettings.Builder<DeleteDeploymentRequest, Empty> deleteDeploymentSettings() {
      return deleteDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to createAttribute. */
    public UnaryCallSettings.Builder<CreateAttributeRequest, Attribute> createAttributeSettings() {
      return createAttributeSettings;
    }

    /** Returns the builder for the settings used for calls to getAttribute. */
    public UnaryCallSettings.Builder<GetAttributeRequest, Attribute> getAttributeSettings() {
      return getAttributeSettings;
    }

    /** Returns the builder for the settings used for calls to updateAttribute. */
    public UnaryCallSettings.Builder<UpdateAttributeRequest, Attribute> updateAttributeSettings() {
      return updateAttributeSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAttribute. */
    public UnaryCallSettings.Builder<DeleteAttributeRequest, Empty> deleteAttributeSettings() {
      return deleteAttributeSettings;
    }

    /** Returns the builder for the settings used for calls to listAttributes. */
    public PagedCallSettings.Builder<
            ListAttributesRequest, ListAttributesResponse, ListAttributesPagedResponse>
        listAttributesSettings() {
      return listAttributesSettings;
    }

    /** Returns the builder for the settings used for calls to searchResources. */
    public PagedCallSettings.Builder<
            SearchResourcesRequest, SearchResourcesResponse, SearchResourcesPagedResponse>
        searchResourcesSettings() {
      return searchResourcesSettings;
    }

    /** Returns the builder for the settings used for calls to createExternalApi. */
    public UnaryCallSettings.Builder<CreateExternalApiRequest, ExternalApi>
        createExternalApiSettings() {
      return createExternalApiSettings;
    }

    /** Returns the builder for the settings used for calls to getExternalApi. */
    public UnaryCallSettings.Builder<GetExternalApiRequest, ExternalApi> getExternalApiSettings() {
      return getExternalApiSettings;
    }

    /** Returns the builder for the settings used for calls to updateExternalApi. */
    public UnaryCallSettings.Builder<UpdateExternalApiRequest, ExternalApi>
        updateExternalApiSettings() {
      return updateExternalApiSettings;
    }

    /** Returns the builder for the settings used for calls to deleteExternalApi. */
    public UnaryCallSettings.Builder<DeleteExternalApiRequest, Empty> deleteExternalApiSettings() {
      return deleteExternalApiSettings;
    }

    /** Returns the builder for the settings used for calls to listExternalApis. */
    public PagedCallSettings.Builder<
            ListExternalApisRequest, ListExternalApisResponse, ListExternalApisPagedResponse>
        listExternalApisSettings() {
      return listExternalApisSettings;
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
    public ApiHubStubSettings build() throws IOException {
      return new ApiHubStubSettings(this);
    }
  }
}
