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

package com.google.cloud.apigeeregistry.v1.stub;

import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiDeploymentRevisionsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiDeploymentsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiSpecRevisionsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiSpecsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiVersionsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApisPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListArtifactsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListLocationsPagedResponse;

import com.google.api.HttpBody;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
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
import com.google.cloud.apigeeregistry.v1.Api;
import com.google.cloud.apigeeregistry.v1.ApiDeployment;
import com.google.cloud.apigeeregistry.v1.ApiSpec;
import com.google.cloud.apigeeregistry.v1.ApiVersion;
import com.google.cloud.apigeeregistry.v1.Artifact;
import com.google.cloud.apigeeregistry.v1.CreateApiDeploymentRequest;
import com.google.cloud.apigeeregistry.v1.CreateApiRequest;
import com.google.cloud.apigeeregistry.v1.CreateApiSpecRequest;
import com.google.cloud.apigeeregistry.v1.CreateApiVersionRequest;
import com.google.cloud.apigeeregistry.v1.CreateArtifactRequest;
import com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRequest;
import com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRevisionRequest;
import com.google.cloud.apigeeregistry.v1.DeleteApiRequest;
import com.google.cloud.apigeeregistry.v1.DeleteApiSpecRequest;
import com.google.cloud.apigeeregistry.v1.DeleteApiSpecRevisionRequest;
import com.google.cloud.apigeeregistry.v1.DeleteApiVersionRequest;
import com.google.cloud.apigeeregistry.v1.DeleteArtifactRequest;
import com.google.cloud.apigeeregistry.v1.GetApiDeploymentRequest;
import com.google.cloud.apigeeregistry.v1.GetApiRequest;
import com.google.cloud.apigeeregistry.v1.GetApiSpecContentsRequest;
import com.google.cloud.apigeeregistry.v1.GetApiSpecRequest;
import com.google.cloud.apigeeregistry.v1.GetApiVersionRequest;
import com.google.cloud.apigeeregistry.v1.GetArtifactContentsRequest;
import com.google.cloud.apigeeregistry.v1.GetArtifactRequest;
import com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsRequest;
import com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsResponse;
import com.google.cloud.apigeeregistry.v1.ListApiDeploymentsRequest;
import com.google.cloud.apigeeregistry.v1.ListApiDeploymentsResponse;
import com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsRequest;
import com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsResponse;
import com.google.cloud.apigeeregistry.v1.ListApiSpecsRequest;
import com.google.cloud.apigeeregistry.v1.ListApiSpecsResponse;
import com.google.cloud.apigeeregistry.v1.ListApiVersionsRequest;
import com.google.cloud.apigeeregistry.v1.ListApiVersionsResponse;
import com.google.cloud.apigeeregistry.v1.ListApisRequest;
import com.google.cloud.apigeeregistry.v1.ListApisResponse;
import com.google.cloud.apigeeregistry.v1.ListArtifactsRequest;
import com.google.cloud.apigeeregistry.v1.ListArtifactsResponse;
import com.google.cloud.apigeeregistry.v1.ReplaceArtifactRequest;
import com.google.cloud.apigeeregistry.v1.RollbackApiDeploymentRequest;
import com.google.cloud.apigeeregistry.v1.RollbackApiSpecRequest;
import com.google.cloud.apigeeregistry.v1.TagApiDeploymentRevisionRequest;
import com.google.cloud.apigeeregistry.v1.TagApiSpecRevisionRequest;
import com.google.cloud.apigeeregistry.v1.UpdateApiDeploymentRequest;
import com.google.cloud.apigeeregistry.v1.UpdateApiRequest;
import com.google.cloud.apigeeregistry.v1.UpdateApiSpecRequest;
import com.google.cloud.apigeeregistry.v1.UpdateApiVersionRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RegistryStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (apigeeregistry.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getApi to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegistryStubSettings.Builder registrySettingsBuilder = RegistryStubSettings.newBuilder();
 * registrySettingsBuilder
 *     .getApiSettings()
 *     .setRetrySettings(
 *         registrySettingsBuilder
 *             .getApiSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RegistryStubSettings registrySettings = registrySettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RegistryStubSettings extends StubSettings<RegistryStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<ListApisRequest, ListApisResponse, ListApisPagedResponse>
      listApisSettings;
  private final UnaryCallSettings<GetApiRequest, Api> getApiSettings;
  private final UnaryCallSettings<CreateApiRequest, Api> createApiSettings;
  private final UnaryCallSettings<UpdateApiRequest, Api> updateApiSettings;
  private final UnaryCallSettings<DeleteApiRequest, Empty> deleteApiSettings;
  private final PagedCallSettings<
          ListApiVersionsRequest, ListApiVersionsResponse, ListApiVersionsPagedResponse>
      listApiVersionsSettings;
  private final UnaryCallSettings<GetApiVersionRequest, ApiVersion> getApiVersionSettings;
  private final UnaryCallSettings<CreateApiVersionRequest, ApiVersion> createApiVersionSettings;
  private final UnaryCallSettings<UpdateApiVersionRequest, ApiVersion> updateApiVersionSettings;
  private final UnaryCallSettings<DeleteApiVersionRequest, Empty> deleteApiVersionSettings;
  private final PagedCallSettings<
          ListApiSpecsRequest, ListApiSpecsResponse, ListApiSpecsPagedResponse>
      listApiSpecsSettings;
  private final UnaryCallSettings<GetApiSpecRequest, ApiSpec> getApiSpecSettings;
  private final UnaryCallSettings<GetApiSpecContentsRequest, HttpBody> getApiSpecContentsSettings;
  private final UnaryCallSettings<CreateApiSpecRequest, ApiSpec> createApiSpecSettings;
  private final UnaryCallSettings<UpdateApiSpecRequest, ApiSpec> updateApiSpecSettings;
  private final UnaryCallSettings<DeleteApiSpecRequest, Empty> deleteApiSpecSettings;
  private final UnaryCallSettings<TagApiSpecRevisionRequest, ApiSpec> tagApiSpecRevisionSettings;
  private final PagedCallSettings<
          ListApiSpecRevisionsRequest,
          ListApiSpecRevisionsResponse,
          ListApiSpecRevisionsPagedResponse>
      listApiSpecRevisionsSettings;
  private final UnaryCallSettings<RollbackApiSpecRequest, ApiSpec> rollbackApiSpecSettings;
  private final UnaryCallSettings<DeleteApiSpecRevisionRequest, ApiSpec>
      deleteApiSpecRevisionSettings;
  private final PagedCallSettings<
          ListApiDeploymentsRequest, ListApiDeploymentsResponse, ListApiDeploymentsPagedResponse>
      listApiDeploymentsSettings;
  private final UnaryCallSettings<GetApiDeploymentRequest, ApiDeployment> getApiDeploymentSettings;
  private final UnaryCallSettings<CreateApiDeploymentRequest, ApiDeployment>
      createApiDeploymentSettings;
  private final UnaryCallSettings<UpdateApiDeploymentRequest, ApiDeployment>
      updateApiDeploymentSettings;
  private final UnaryCallSettings<DeleteApiDeploymentRequest, Empty> deleteApiDeploymentSettings;
  private final UnaryCallSettings<TagApiDeploymentRevisionRequest, ApiDeployment>
      tagApiDeploymentRevisionSettings;
  private final PagedCallSettings<
          ListApiDeploymentRevisionsRequest,
          ListApiDeploymentRevisionsResponse,
          ListApiDeploymentRevisionsPagedResponse>
      listApiDeploymentRevisionsSettings;
  private final UnaryCallSettings<RollbackApiDeploymentRequest, ApiDeployment>
      rollbackApiDeploymentSettings;
  private final UnaryCallSettings<DeleteApiDeploymentRevisionRequest, ApiDeployment>
      deleteApiDeploymentRevisionSettings;
  private final PagedCallSettings<
          ListArtifactsRequest, ListArtifactsResponse, ListArtifactsPagedResponse>
      listArtifactsSettings;
  private final UnaryCallSettings<GetArtifactRequest, Artifact> getArtifactSettings;
  private final UnaryCallSettings<GetArtifactContentsRequest, HttpBody> getArtifactContentsSettings;
  private final UnaryCallSettings<CreateArtifactRequest, Artifact> createArtifactSettings;
  private final UnaryCallSettings<ReplaceArtifactRequest, Artifact> replaceArtifactSettings;
  private final UnaryCallSettings<DeleteArtifactRequest, Empty> deleteArtifactSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

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
              return payload.getApisList() == null
                  ? ImmutableList.<Api>of()
                  : payload.getApisList();
            }
          };

  private static final PagedListDescriptor<
          ListApiVersionsRequest, ListApiVersionsResponse, ApiVersion>
      LIST_API_VERSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListApiVersionsRequest, ListApiVersionsResponse, ApiVersion>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListApiVersionsRequest injectToken(
                ListApiVersionsRequest payload, String token) {
              return ListApiVersionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListApiVersionsRequest injectPageSize(
                ListApiVersionsRequest payload, int pageSize) {
              return ListApiVersionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListApiVersionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListApiVersionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ApiVersion> extractResources(ListApiVersionsResponse payload) {
              return payload.getApiVersionsList() == null
                  ? ImmutableList.<ApiVersion>of()
                  : payload.getApiVersionsList();
            }
          };

  private static final PagedListDescriptor<ListApiSpecsRequest, ListApiSpecsResponse, ApiSpec>
      LIST_API_SPECS_PAGE_STR_DESC =
          new PagedListDescriptor<ListApiSpecsRequest, ListApiSpecsResponse, ApiSpec>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListApiSpecsRequest injectToken(ListApiSpecsRequest payload, String token) {
              return ListApiSpecsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListApiSpecsRequest injectPageSize(ListApiSpecsRequest payload, int pageSize) {
              return ListApiSpecsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListApiSpecsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListApiSpecsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ApiSpec> extractResources(ListApiSpecsResponse payload) {
              return payload.getApiSpecsList() == null
                  ? ImmutableList.<ApiSpec>of()
                  : payload.getApiSpecsList();
            }
          };

  private static final PagedListDescriptor<
          ListApiSpecRevisionsRequest, ListApiSpecRevisionsResponse, ApiSpec>
      LIST_API_SPEC_REVISIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListApiSpecRevisionsRequest, ListApiSpecRevisionsResponse, ApiSpec>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListApiSpecRevisionsRequest injectToken(
                ListApiSpecRevisionsRequest payload, String token) {
              return ListApiSpecRevisionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListApiSpecRevisionsRequest injectPageSize(
                ListApiSpecRevisionsRequest payload, int pageSize) {
              return ListApiSpecRevisionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListApiSpecRevisionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListApiSpecRevisionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ApiSpec> extractResources(ListApiSpecRevisionsResponse payload) {
              return payload.getApiSpecsList() == null
                  ? ImmutableList.<ApiSpec>of()
                  : payload.getApiSpecsList();
            }
          };

  private static final PagedListDescriptor<
          ListApiDeploymentsRequest, ListApiDeploymentsResponse, ApiDeployment>
      LIST_API_DEPLOYMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListApiDeploymentsRequest, ListApiDeploymentsResponse, ApiDeployment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListApiDeploymentsRequest injectToken(
                ListApiDeploymentsRequest payload, String token) {
              return ListApiDeploymentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListApiDeploymentsRequest injectPageSize(
                ListApiDeploymentsRequest payload, int pageSize) {
              return ListApiDeploymentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListApiDeploymentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListApiDeploymentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ApiDeployment> extractResources(ListApiDeploymentsResponse payload) {
              return payload.getApiDeploymentsList() == null
                  ? ImmutableList.<ApiDeployment>of()
                  : payload.getApiDeploymentsList();
            }
          };

  private static final PagedListDescriptor<
          ListApiDeploymentRevisionsRequest, ListApiDeploymentRevisionsResponse, ApiDeployment>
      LIST_API_DEPLOYMENT_REVISIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListApiDeploymentRevisionsRequest,
              ListApiDeploymentRevisionsResponse,
              ApiDeployment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListApiDeploymentRevisionsRequest injectToken(
                ListApiDeploymentRevisionsRequest payload, String token) {
              return ListApiDeploymentRevisionsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListApiDeploymentRevisionsRequest injectPageSize(
                ListApiDeploymentRevisionsRequest payload, int pageSize) {
              return ListApiDeploymentRevisionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListApiDeploymentRevisionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListApiDeploymentRevisionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ApiDeployment> extractResources(
                ListApiDeploymentRevisionsResponse payload) {
              return payload.getApiDeploymentsList() == null
                  ? ImmutableList.<ApiDeployment>of()
                  : payload.getApiDeploymentsList();
            }
          };

  private static final PagedListDescriptor<ListArtifactsRequest, ListArtifactsResponse, Artifact>
      LIST_ARTIFACTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListArtifactsRequest, ListArtifactsResponse, Artifact>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListArtifactsRequest injectToken(ListArtifactsRequest payload, String token) {
              return ListArtifactsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListArtifactsRequest injectPageSize(ListArtifactsRequest payload, int pageSize) {
              return ListArtifactsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListArtifactsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListArtifactsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Artifact> extractResources(ListArtifactsResponse payload) {
              return payload.getArtifactsList() == null
                  ? ImmutableList.<Artifact>of()
                  : payload.getArtifactsList();
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
          ListApiVersionsRequest, ListApiVersionsResponse, ListApiVersionsPagedResponse>
      LIST_API_VERSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListApiVersionsRequest, ListApiVersionsResponse, ListApiVersionsPagedResponse>() {
            @Override
            public ApiFuture<ListApiVersionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListApiVersionsRequest, ListApiVersionsResponse> callable,
                ListApiVersionsRequest request,
                ApiCallContext context,
                ApiFuture<ListApiVersionsResponse> futureResponse) {
              PageContext<ListApiVersionsRequest, ListApiVersionsResponse, ApiVersion> pageContext =
                  PageContext.create(callable, LIST_API_VERSIONS_PAGE_STR_DESC, request, context);
              return ListApiVersionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListApiSpecsRequest, ListApiSpecsResponse, ListApiSpecsPagedResponse>
      LIST_API_SPECS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListApiSpecsRequest, ListApiSpecsResponse, ListApiSpecsPagedResponse>() {
            @Override
            public ApiFuture<ListApiSpecsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListApiSpecsRequest, ListApiSpecsResponse> callable,
                ListApiSpecsRequest request,
                ApiCallContext context,
                ApiFuture<ListApiSpecsResponse> futureResponse) {
              PageContext<ListApiSpecsRequest, ListApiSpecsResponse, ApiSpec> pageContext =
                  PageContext.create(callable, LIST_API_SPECS_PAGE_STR_DESC, request, context);
              return ListApiSpecsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListApiSpecRevisionsRequest,
          ListApiSpecRevisionsResponse,
          ListApiSpecRevisionsPagedResponse>
      LIST_API_SPEC_REVISIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListApiSpecRevisionsRequest,
              ListApiSpecRevisionsResponse,
              ListApiSpecRevisionsPagedResponse>() {
            @Override
            public ApiFuture<ListApiSpecRevisionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListApiSpecRevisionsRequest, ListApiSpecRevisionsResponse> callable,
                ListApiSpecRevisionsRequest request,
                ApiCallContext context,
                ApiFuture<ListApiSpecRevisionsResponse> futureResponse) {
              PageContext<ListApiSpecRevisionsRequest, ListApiSpecRevisionsResponse, ApiSpec>
                  pageContext =
                      PageContext.create(
                          callable, LIST_API_SPEC_REVISIONS_PAGE_STR_DESC, request, context);
              return ListApiSpecRevisionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListApiDeploymentsRequest, ListApiDeploymentsResponse, ListApiDeploymentsPagedResponse>
      LIST_API_DEPLOYMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListApiDeploymentsRequest,
              ListApiDeploymentsResponse,
              ListApiDeploymentsPagedResponse>() {
            @Override
            public ApiFuture<ListApiDeploymentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListApiDeploymentsRequest, ListApiDeploymentsResponse> callable,
                ListApiDeploymentsRequest request,
                ApiCallContext context,
                ApiFuture<ListApiDeploymentsResponse> futureResponse) {
              PageContext<ListApiDeploymentsRequest, ListApiDeploymentsResponse, ApiDeployment>
                  pageContext =
                      PageContext.create(
                          callable, LIST_API_DEPLOYMENTS_PAGE_STR_DESC, request, context);
              return ListApiDeploymentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListApiDeploymentRevisionsRequest,
          ListApiDeploymentRevisionsResponse,
          ListApiDeploymentRevisionsPagedResponse>
      LIST_API_DEPLOYMENT_REVISIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListApiDeploymentRevisionsRequest,
              ListApiDeploymentRevisionsResponse,
              ListApiDeploymentRevisionsPagedResponse>() {
            @Override
            public ApiFuture<ListApiDeploymentRevisionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListApiDeploymentRevisionsRequest, ListApiDeploymentRevisionsResponse>
                    callable,
                ListApiDeploymentRevisionsRequest request,
                ApiCallContext context,
                ApiFuture<ListApiDeploymentRevisionsResponse> futureResponse) {
              PageContext<
                      ListApiDeploymentRevisionsRequest,
                      ListApiDeploymentRevisionsResponse,
                      ApiDeployment>
                  pageContext =
                      PageContext.create(
                          callable, LIST_API_DEPLOYMENT_REVISIONS_PAGE_STR_DESC, request, context);
              return ListApiDeploymentRevisionsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListArtifactsRequest, ListArtifactsResponse, ListArtifactsPagedResponse>
      LIST_ARTIFACTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListArtifactsRequest, ListArtifactsResponse, ListArtifactsPagedResponse>() {
            @Override
            public ApiFuture<ListArtifactsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListArtifactsRequest, ListArtifactsResponse> callable,
                ListArtifactsRequest request,
                ApiCallContext context,
                ApiFuture<ListArtifactsResponse> futureResponse) {
              PageContext<ListArtifactsRequest, ListArtifactsResponse, Artifact> pageContext =
                  PageContext.create(callable, LIST_ARTIFACTS_PAGE_STR_DESC, request, context);
              return ListArtifactsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listApis. */
  public PagedCallSettings<ListApisRequest, ListApisResponse, ListApisPagedResponse>
      listApisSettings() {
    return listApisSettings;
  }

  /** Returns the object with the settings used for calls to getApi. */
  public UnaryCallSettings<GetApiRequest, Api> getApiSettings() {
    return getApiSettings;
  }

  /** Returns the object with the settings used for calls to createApi. */
  public UnaryCallSettings<CreateApiRequest, Api> createApiSettings() {
    return createApiSettings;
  }

  /** Returns the object with the settings used for calls to updateApi. */
  public UnaryCallSettings<UpdateApiRequest, Api> updateApiSettings() {
    return updateApiSettings;
  }

  /** Returns the object with the settings used for calls to deleteApi. */
  public UnaryCallSettings<DeleteApiRequest, Empty> deleteApiSettings() {
    return deleteApiSettings;
  }

  /** Returns the object with the settings used for calls to listApiVersions. */
  public PagedCallSettings<
          ListApiVersionsRequest, ListApiVersionsResponse, ListApiVersionsPagedResponse>
      listApiVersionsSettings() {
    return listApiVersionsSettings;
  }

  /** Returns the object with the settings used for calls to getApiVersion. */
  public UnaryCallSettings<GetApiVersionRequest, ApiVersion> getApiVersionSettings() {
    return getApiVersionSettings;
  }

  /** Returns the object with the settings used for calls to createApiVersion. */
  public UnaryCallSettings<CreateApiVersionRequest, ApiVersion> createApiVersionSettings() {
    return createApiVersionSettings;
  }

  /** Returns the object with the settings used for calls to updateApiVersion. */
  public UnaryCallSettings<UpdateApiVersionRequest, ApiVersion> updateApiVersionSettings() {
    return updateApiVersionSettings;
  }

  /** Returns the object with the settings used for calls to deleteApiVersion. */
  public UnaryCallSettings<DeleteApiVersionRequest, Empty> deleteApiVersionSettings() {
    return deleteApiVersionSettings;
  }

  /** Returns the object with the settings used for calls to listApiSpecs. */
  public PagedCallSettings<ListApiSpecsRequest, ListApiSpecsResponse, ListApiSpecsPagedResponse>
      listApiSpecsSettings() {
    return listApiSpecsSettings;
  }

  /** Returns the object with the settings used for calls to getApiSpec. */
  public UnaryCallSettings<GetApiSpecRequest, ApiSpec> getApiSpecSettings() {
    return getApiSpecSettings;
  }

  /** Returns the object with the settings used for calls to getApiSpecContents. */
  public UnaryCallSettings<GetApiSpecContentsRequest, HttpBody> getApiSpecContentsSettings() {
    return getApiSpecContentsSettings;
  }

  /** Returns the object with the settings used for calls to createApiSpec. */
  public UnaryCallSettings<CreateApiSpecRequest, ApiSpec> createApiSpecSettings() {
    return createApiSpecSettings;
  }

  /** Returns the object with the settings used for calls to updateApiSpec. */
  public UnaryCallSettings<UpdateApiSpecRequest, ApiSpec> updateApiSpecSettings() {
    return updateApiSpecSettings;
  }

  /** Returns the object with the settings used for calls to deleteApiSpec. */
  public UnaryCallSettings<DeleteApiSpecRequest, Empty> deleteApiSpecSettings() {
    return deleteApiSpecSettings;
  }

  /** Returns the object with the settings used for calls to tagApiSpecRevision. */
  public UnaryCallSettings<TagApiSpecRevisionRequest, ApiSpec> tagApiSpecRevisionSettings() {
    return tagApiSpecRevisionSettings;
  }

  /** Returns the object with the settings used for calls to listApiSpecRevisions. */
  public PagedCallSettings<
          ListApiSpecRevisionsRequest,
          ListApiSpecRevisionsResponse,
          ListApiSpecRevisionsPagedResponse>
      listApiSpecRevisionsSettings() {
    return listApiSpecRevisionsSettings;
  }

  /** Returns the object with the settings used for calls to rollbackApiSpec. */
  public UnaryCallSettings<RollbackApiSpecRequest, ApiSpec> rollbackApiSpecSettings() {
    return rollbackApiSpecSettings;
  }

  /** Returns the object with the settings used for calls to deleteApiSpecRevision. */
  public UnaryCallSettings<DeleteApiSpecRevisionRequest, ApiSpec> deleteApiSpecRevisionSettings() {
    return deleteApiSpecRevisionSettings;
  }

  /** Returns the object with the settings used for calls to listApiDeployments. */
  public PagedCallSettings<
          ListApiDeploymentsRequest, ListApiDeploymentsResponse, ListApiDeploymentsPagedResponse>
      listApiDeploymentsSettings() {
    return listApiDeploymentsSettings;
  }

  /** Returns the object with the settings used for calls to getApiDeployment. */
  public UnaryCallSettings<GetApiDeploymentRequest, ApiDeployment> getApiDeploymentSettings() {
    return getApiDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to createApiDeployment. */
  public UnaryCallSettings<CreateApiDeploymentRequest, ApiDeployment>
      createApiDeploymentSettings() {
    return createApiDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to updateApiDeployment. */
  public UnaryCallSettings<UpdateApiDeploymentRequest, ApiDeployment>
      updateApiDeploymentSettings() {
    return updateApiDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to deleteApiDeployment. */
  public UnaryCallSettings<DeleteApiDeploymentRequest, Empty> deleteApiDeploymentSettings() {
    return deleteApiDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to tagApiDeploymentRevision. */
  public UnaryCallSettings<TagApiDeploymentRevisionRequest, ApiDeployment>
      tagApiDeploymentRevisionSettings() {
    return tagApiDeploymentRevisionSettings;
  }

  /** Returns the object with the settings used for calls to listApiDeploymentRevisions. */
  public PagedCallSettings<
          ListApiDeploymentRevisionsRequest,
          ListApiDeploymentRevisionsResponse,
          ListApiDeploymentRevisionsPagedResponse>
      listApiDeploymentRevisionsSettings() {
    return listApiDeploymentRevisionsSettings;
  }

  /** Returns the object with the settings used for calls to rollbackApiDeployment. */
  public UnaryCallSettings<RollbackApiDeploymentRequest, ApiDeployment>
      rollbackApiDeploymentSettings() {
    return rollbackApiDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to deleteApiDeploymentRevision. */
  public UnaryCallSettings<DeleteApiDeploymentRevisionRequest, ApiDeployment>
      deleteApiDeploymentRevisionSettings() {
    return deleteApiDeploymentRevisionSettings;
  }

  /** Returns the object with the settings used for calls to listArtifacts. */
  public PagedCallSettings<ListArtifactsRequest, ListArtifactsResponse, ListArtifactsPagedResponse>
      listArtifactsSettings() {
    return listArtifactsSettings;
  }

  /** Returns the object with the settings used for calls to getArtifact. */
  public UnaryCallSettings<GetArtifactRequest, Artifact> getArtifactSettings() {
    return getArtifactSettings;
  }

  /** Returns the object with the settings used for calls to getArtifactContents. */
  public UnaryCallSettings<GetArtifactContentsRequest, HttpBody> getArtifactContentsSettings() {
    return getArtifactContentsSettings;
  }

  /** Returns the object with the settings used for calls to createArtifact. */
  public UnaryCallSettings<CreateArtifactRequest, Artifact> createArtifactSettings() {
    return createArtifactSettings;
  }

  /** Returns the object with the settings used for calls to replaceArtifact. */
  public UnaryCallSettings<ReplaceArtifactRequest, Artifact> replaceArtifactSettings() {
    return replaceArtifactSettings;
  }

  /** Returns the object with the settings used for calls to deleteArtifact. */
  public UnaryCallSettings<DeleteArtifactRequest, Empty> deleteArtifactSettings() {
    return deleteArtifactSettings;
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

  public RegistryStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcRegistryStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonRegistryStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "apigeeregistry.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "apigeeregistry.mtls.googleapis.com:443";
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(RegistryStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(RegistryStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RegistryStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected RegistryStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listApisSettings = settingsBuilder.listApisSettings().build();
    getApiSettings = settingsBuilder.getApiSettings().build();
    createApiSettings = settingsBuilder.createApiSettings().build();
    updateApiSettings = settingsBuilder.updateApiSettings().build();
    deleteApiSettings = settingsBuilder.deleteApiSettings().build();
    listApiVersionsSettings = settingsBuilder.listApiVersionsSettings().build();
    getApiVersionSettings = settingsBuilder.getApiVersionSettings().build();
    createApiVersionSettings = settingsBuilder.createApiVersionSettings().build();
    updateApiVersionSettings = settingsBuilder.updateApiVersionSettings().build();
    deleteApiVersionSettings = settingsBuilder.deleteApiVersionSettings().build();
    listApiSpecsSettings = settingsBuilder.listApiSpecsSettings().build();
    getApiSpecSettings = settingsBuilder.getApiSpecSettings().build();
    getApiSpecContentsSettings = settingsBuilder.getApiSpecContentsSettings().build();
    createApiSpecSettings = settingsBuilder.createApiSpecSettings().build();
    updateApiSpecSettings = settingsBuilder.updateApiSpecSettings().build();
    deleteApiSpecSettings = settingsBuilder.deleteApiSpecSettings().build();
    tagApiSpecRevisionSettings = settingsBuilder.tagApiSpecRevisionSettings().build();
    listApiSpecRevisionsSettings = settingsBuilder.listApiSpecRevisionsSettings().build();
    rollbackApiSpecSettings = settingsBuilder.rollbackApiSpecSettings().build();
    deleteApiSpecRevisionSettings = settingsBuilder.deleteApiSpecRevisionSettings().build();
    listApiDeploymentsSettings = settingsBuilder.listApiDeploymentsSettings().build();
    getApiDeploymentSettings = settingsBuilder.getApiDeploymentSettings().build();
    createApiDeploymentSettings = settingsBuilder.createApiDeploymentSettings().build();
    updateApiDeploymentSettings = settingsBuilder.updateApiDeploymentSettings().build();
    deleteApiDeploymentSettings = settingsBuilder.deleteApiDeploymentSettings().build();
    tagApiDeploymentRevisionSettings = settingsBuilder.tagApiDeploymentRevisionSettings().build();
    listApiDeploymentRevisionsSettings =
        settingsBuilder.listApiDeploymentRevisionsSettings().build();
    rollbackApiDeploymentSettings = settingsBuilder.rollbackApiDeploymentSettings().build();
    deleteApiDeploymentRevisionSettings =
        settingsBuilder.deleteApiDeploymentRevisionSettings().build();
    listArtifactsSettings = settingsBuilder.listArtifactsSettings().build();
    getArtifactSettings = settingsBuilder.getArtifactSettings().build();
    getArtifactContentsSettings = settingsBuilder.getArtifactContentsSettings().build();
    createArtifactSettings = settingsBuilder.createArtifactSettings().build();
    replaceArtifactSettings = settingsBuilder.replaceArtifactSettings().build();
    deleteArtifactSettings = settingsBuilder.deleteArtifactSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for RegistryStubSettings. */
  public static class Builder extends StubSettings.Builder<RegistryStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListApisRequest, ListApisResponse, ListApisPagedResponse>
        listApisSettings;
    private final UnaryCallSettings.Builder<GetApiRequest, Api> getApiSettings;
    private final UnaryCallSettings.Builder<CreateApiRequest, Api> createApiSettings;
    private final UnaryCallSettings.Builder<UpdateApiRequest, Api> updateApiSettings;
    private final UnaryCallSettings.Builder<DeleteApiRequest, Empty> deleteApiSettings;
    private final PagedCallSettings.Builder<
            ListApiVersionsRequest, ListApiVersionsResponse, ListApiVersionsPagedResponse>
        listApiVersionsSettings;
    private final UnaryCallSettings.Builder<GetApiVersionRequest, ApiVersion> getApiVersionSettings;
    private final UnaryCallSettings.Builder<CreateApiVersionRequest, ApiVersion>
        createApiVersionSettings;
    private final UnaryCallSettings.Builder<UpdateApiVersionRequest, ApiVersion>
        updateApiVersionSettings;
    private final UnaryCallSettings.Builder<DeleteApiVersionRequest, Empty>
        deleteApiVersionSettings;
    private final PagedCallSettings.Builder<
            ListApiSpecsRequest, ListApiSpecsResponse, ListApiSpecsPagedResponse>
        listApiSpecsSettings;
    private final UnaryCallSettings.Builder<GetApiSpecRequest, ApiSpec> getApiSpecSettings;
    private final UnaryCallSettings.Builder<GetApiSpecContentsRequest, HttpBody>
        getApiSpecContentsSettings;
    private final UnaryCallSettings.Builder<CreateApiSpecRequest, ApiSpec> createApiSpecSettings;
    private final UnaryCallSettings.Builder<UpdateApiSpecRequest, ApiSpec> updateApiSpecSettings;
    private final UnaryCallSettings.Builder<DeleteApiSpecRequest, Empty> deleteApiSpecSettings;
    private final UnaryCallSettings.Builder<TagApiSpecRevisionRequest, ApiSpec>
        tagApiSpecRevisionSettings;
    private final PagedCallSettings.Builder<
            ListApiSpecRevisionsRequest,
            ListApiSpecRevisionsResponse,
            ListApiSpecRevisionsPagedResponse>
        listApiSpecRevisionsSettings;
    private final UnaryCallSettings.Builder<RollbackApiSpecRequest, ApiSpec>
        rollbackApiSpecSettings;
    private final UnaryCallSettings.Builder<DeleteApiSpecRevisionRequest, ApiSpec>
        deleteApiSpecRevisionSettings;
    private final PagedCallSettings.Builder<
            ListApiDeploymentsRequest, ListApiDeploymentsResponse, ListApiDeploymentsPagedResponse>
        listApiDeploymentsSettings;
    private final UnaryCallSettings.Builder<GetApiDeploymentRequest, ApiDeployment>
        getApiDeploymentSettings;
    private final UnaryCallSettings.Builder<CreateApiDeploymentRequest, ApiDeployment>
        createApiDeploymentSettings;
    private final UnaryCallSettings.Builder<UpdateApiDeploymentRequest, ApiDeployment>
        updateApiDeploymentSettings;
    private final UnaryCallSettings.Builder<DeleteApiDeploymentRequest, Empty>
        deleteApiDeploymentSettings;
    private final UnaryCallSettings.Builder<TagApiDeploymentRevisionRequest, ApiDeployment>
        tagApiDeploymentRevisionSettings;
    private final PagedCallSettings.Builder<
            ListApiDeploymentRevisionsRequest,
            ListApiDeploymentRevisionsResponse,
            ListApiDeploymentRevisionsPagedResponse>
        listApiDeploymentRevisionsSettings;
    private final UnaryCallSettings.Builder<RollbackApiDeploymentRequest, ApiDeployment>
        rollbackApiDeploymentSettings;
    private final UnaryCallSettings.Builder<DeleteApiDeploymentRevisionRequest, ApiDeployment>
        deleteApiDeploymentRevisionSettings;
    private final PagedCallSettings.Builder<
            ListArtifactsRequest, ListArtifactsResponse, ListArtifactsPagedResponse>
        listArtifactsSettings;
    private final UnaryCallSettings.Builder<GetArtifactRequest, Artifact> getArtifactSettings;
    private final UnaryCallSettings.Builder<GetArtifactContentsRequest, HttpBody>
        getArtifactContentsSettings;
    private final UnaryCallSettings.Builder<CreateArtifactRequest, Artifact> createArtifactSettings;
    private final UnaryCallSettings.Builder<ReplaceArtifactRequest, Artifact>
        replaceArtifactSettings;
    private final UnaryCallSettings.Builder<DeleteArtifactRequest, Empty> deleteArtifactSettings;
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
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.ABORTED,
                  StatusCode.Code.CANCELLED,
                  StatusCode.Code.DEADLINE_EXCEEDED,
                  StatusCode.Code.UNAVAILABLE)));
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
              .setInitialRetryDelay(Duration.ofMillis(200L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
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
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listApisSettings = PagedCallSettings.newBuilder(LIST_APIS_PAGE_STR_FACT);
      getApiSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createApiSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateApiSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteApiSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listApiVersionsSettings = PagedCallSettings.newBuilder(LIST_API_VERSIONS_PAGE_STR_FACT);
      getApiVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createApiVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateApiVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteApiVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listApiSpecsSettings = PagedCallSettings.newBuilder(LIST_API_SPECS_PAGE_STR_FACT);
      getApiSpecSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getApiSpecContentsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createApiSpecSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateApiSpecSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteApiSpecSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      tagApiSpecRevisionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listApiSpecRevisionsSettings =
          PagedCallSettings.newBuilder(LIST_API_SPEC_REVISIONS_PAGE_STR_FACT);
      rollbackApiSpecSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteApiSpecRevisionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listApiDeploymentsSettings = PagedCallSettings.newBuilder(LIST_API_DEPLOYMENTS_PAGE_STR_FACT);
      getApiDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createApiDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateApiDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteApiDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      tagApiDeploymentRevisionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listApiDeploymentRevisionsSettings =
          PagedCallSettings.newBuilder(LIST_API_DEPLOYMENT_REVISIONS_PAGE_STR_FACT);
      rollbackApiDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteApiDeploymentRevisionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listArtifactsSettings = PagedCallSettings.newBuilder(LIST_ARTIFACTS_PAGE_STR_FACT);
      getArtifactSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getArtifactContentsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createArtifactSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      replaceArtifactSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteArtifactSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listApisSettings,
              getApiSettings,
              createApiSettings,
              updateApiSettings,
              deleteApiSettings,
              listApiVersionsSettings,
              getApiVersionSettings,
              createApiVersionSettings,
              updateApiVersionSettings,
              deleteApiVersionSettings,
              listApiSpecsSettings,
              getApiSpecSettings,
              getApiSpecContentsSettings,
              createApiSpecSettings,
              updateApiSpecSettings,
              deleteApiSpecSettings,
              tagApiSpecRevisionSettings,
              listApiSpecRevisionsSettings,
              rollbackApiSpecSettings,
              deleteApiSpecRevisionSettings,
              listApiDeploymentsSettings,
              getApiDeploymentSettings,
              createApiDeploymentSettings,
              updateApiDeploymentSettings,
              deleteApiDeploymentSettings,
              tagApiDeploymentRevisionSettings,
              listApiDeploymentRevisionsSettings,
              rollbackApiDeploymentSettings,
              deleteApiDeploymentRevisionSettings,
              listArtifactsSettings,
              getArtifactSettings,
              getArtifactContentsSettings,
              createArtifactSettings,
              replaceArtifactSettings,
              deleteArtifactSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(RegistryStubSettings settings) {
      super(settings);

      listApisSettings = settings.listApisSettings.toBuilder();
      getApiSettings = settings.getApiSettings.toBuilder();
      createApiSettings = settings.createApiSettings.toBuilder();
      updateApiSettings = settings.updateApiSettings.toBuilder();
      deleteApiSettings = settings.deleteApiSettings.toBuilder();
      listApiVersionsSettings = settings.listApiVersionsSettings.toBuilder();
      getApiVersionSettings = settings.getApiVersionSettings.toBuilder();
      createApiVersionSettings = settings.createApiVersionSettings.toBuilder();
      updateApiVersionSettings = settings.updateApiVersionSettings.toBuilder();
      deleteApiVersionSettings = settings.deleteApiVersionSettings.toBuilder();
      listApiSpecsSettings = settings.listApiSpecsSettings.toBuilder();
      getApiSpecSettings = settings.getApiSpecSettings.toBuilder();
      getApiSpecContentsSettings = settings.getApiSpecContentsSettings.toBuilder();
      createApiSpecSettings = settings.createApiSpecSettings.toBuilder();
      updateApiSpecSettings = settings.updateApiSpecSettings.toBuilder();
      deleteApiSpecSettings = settings.deleteApiSpecSettings.toBuilder();
      tagApiSpecRevisionSettings = settings.tagApiSpecRevisionSettings.toBuilder();
      listApiSpecRevisionsSettings = settings.listApiSpecRevisionsSettings.toBuilder();
      rollbackApiSpecSettings = settings.rollbackApiSpecSettings.toBuilder();
      deleteApiSpecRevisionSettings = settings.deleteApiSpecRevisionSettings.toBuilder();
      listApiDeploymentsSettings = settings.listApiDeploymentsSettings.toBuilder();
      getApiDeploymentSettings = settings.getApiDeploymentSettings.toBuilder();
      createApiDeploymentSettings = settings.createApiDeploymentSettings.toBuilder();
      updateApiDeploymentSettings = settings.updateApiDeploymentSettings.toBuilder();
      deleteApiDeploymentSettings = settings.deleteApiDeploymentSettings.toBuilder();
      tagApiDeploymentRevisionSettings = settings.tagApiDeploymentRevisionSettings.toBuilder();
      listApiDeploymentRevisionsSettings = settings.listApiDeploymentRevisionsSettings.toBuilder();
      rollbackApiDeploymentSettings = settings.rollbackApiDeploymentSettings.toBuilder();
      deleteApiDeploymentRevisionSettings =
          settings.deleteApiDeploymentRevisionSettings.toBuilder();
      listArtifactsSettings = settings.listArtifactsSettings.toBuilder();
      getArtifactSettings = settings.getArtifactSettings.toBuilder();
      getArtifactContentsSettings = settings.getArtifactContentsSettings.toBuilder();
      createArtifactSettings = settings.createArtifactSettings.toBuilder();
      replaceArtifactSettings = settings.replaceArtifactSettings.toBuilder();
      deleteArtifactSettings = settings.deleteArtifactSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listApisSettings,
              getApiSettings,
              createApiSettings,
              updateApiSettings,
              deleteApiSettings,
              listApiVersionsSettings,
              getApiVersionSettings,
              createApiVersionSettings,
              updateApiVersionSettings,
              deleteApiVersionSettings,
              listApiSpecsSettings,
              getApiSpecSettings,
              getApiSpecContentsSettings,
              createApiSpecSettings,
              updateApiSpecSettings,
              deleteApiSpecSettings,
              tagApiSpecRevisionSettings,
              listApiSpecRevisionsSettings,
              rollbackApiSpecSettings,
              deleteApiSpecRevisionSettings,
              listApiDeploymentsSettings,
              getApiDeploymentSettings,
              createApiDeploymentSettings,
              updateApiDeploymentSettings,
              deleteApiDeploymentSettings,
              tagApiDeploymentRevisionSettings,
              listApiDeploymentRevisionsSettings,
              rollbackApiDeploymentSettings,
              deleteApiDeploymentRevisionSettings,
              listArtifactsSettings,
              getArtifactSettings,
              getArtifactContentsSettings,
              createArtifactSettings,
              replaceArtifactSettings,
              deleteArtifactSettings,
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
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listApisSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getApiSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createApiSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateApiSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteApiSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listApiVersionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getApiVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createApiVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateApiVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteApiVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listApiSpecsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getApiSpecSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getApiSpecContentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createApiSpecSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateApiSpecSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteApiSpecSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .tagApiSpecRevisionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listApiSpecRevisionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .rollbackApiSpecSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteApiSpecRevisionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listApiDeploymentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getApiDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createApiDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateApiDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteApiDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .tagApiDeploymentRevisionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listApiDeploymentRevisionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .rollbackApiDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteApiDeploymentRevisionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listArtifactsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getArtifactSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getArtifactContentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createArtifactSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .replaceArtifactSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteArtifactSettings()
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

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .testIamPermissionsSettings()
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

    /** Returns the builder for the settings used for calls to listApis. */
    public PagedCallSettings.Builder<ListApisRequest, ListApisResponse, ListApisPagedResponse>
        listApisSettings() {
      return listApisSettings;
    }

    /** Returns the builder for the settings used for calls to getApi. */
    public UnaryCallSettings.Builder<GetApiRequest, Api> getApiSettings() {
      return getApiSettings;
    }

    /** Returns the builder for the settings used for calls to createApi. */
    public UnaryCallSettings.Builder<CreateApiRequest, Api> createApiSettings() {
      return createApiSettings;
    }

    /** Returns the builder for the settings used for calls to updateApi. */
    public UnaryCallSettings.Builder<UpdateApiRequest, Api> updateApiSettings() {
      return updateApiSettings;
    }

    /** Returns the builder for the settings used for calls to deleteApi. */
    public UnaryCallSettings.Builder<DeleteApiRequest, Empty> deleteApiSettings() {
      return deleteApiSettings;
    }

    /** Returns the builder for the settings used for calls to listApiVersions. */
    public PagedCallSettings.Builder<
            ListApiVersionsRequest, ListApiVersionsResponse, ListApiVersionsPagedResponse>
        listApiVersionsSettings() {
      return listApiVersionsSettings;
    }

    /** Returns the builder for the settings used for calls to getApiVersion. */
    public UnaryCallSettings.Builder<GetApiVersionRequest, ApiVersion> getApiVersionSettings() {
      return getApiVersionSettings;
    }

    /** Returns the builder for the settings used for calls to createApiVersion. */
    public UnaryCallSettings.Builder<CreateApiVersionRequest, ApiVersion>
        createApiVersionSettings() {
      return createApiVersionSettings;
    }

    /** Returns the builder for the settings used for calls to updateApiVersion. */
    public UnaryCallSettings.Builder<UpdateApiVersionRequest, ApiVersion>
        updateApiVersionSettings() {
      return updateApiVersionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteApiVersion. */
    public UnaryCallSettings.Builder<DeleteApiVersionRequest, Empty> deleteApiVersionSettings() {
      return deleteApiVersionSettings;
    }

    /** Returns the builder for the settings used for calls to listApiSpecs. */
    public PagedCallSettings.Builder<
            ListApiSpecsRequest, ListApiSpecsResponse, ListApiSpecsPagedResponse>
        listApiSpecsSettings() {
      return listApiSpecsSettings;
    }

    /** Returns the builder for the settings used for calls to getApiSpec. */
    public UnaryCallSettings.Builder<GetApiSpecRequest, ApiSpec> getApiSpecSettings() {
      return getApiSpecSettings;
    }

    /** Returns the builder for the settings used for calls to getApiSpecContents. */
    public UnaryCallSettings.Builder<GetApiSpecContentsRequest, HttpBody>
        getApiSpecContentsSettings() {
      return getApiSpecContentsSettings;
    }

    /** Returns the builder for the settings used for calls to createApiSpec. */
    public UnaryCallSettings.Builder<CreateApiSpecRequest, ApiSpec> createApiSpecSettings() {
      return createApiSpecSettings;
    }

    /** Returns the builder for the settings used for calls to updateApiSpec. */
    public UnaryCallSettings.Builder<UpdateApiSpecRequest, ApiSpec> updateApiSpecSettings() {
      return updateApiSpecSettings;
    }

    /** Returns the builder for the settings used for calls to deleteApiSpec. */
    public UnaryCallSettings.Builder<DeleteApiSpecRequest, Empty> deleteApiSpecSettings() {
      return deleteApiSpecSettings;
    }

    /** Returns the builder for the settings used for calls to tagApiSpecRevision. */
    public UnaryCallSettings.Builder<TagApiSpecRevisionRequest, ApiSpec>
        tagApiSpecRevisionSettings() {
      return tagApiSpecRevisionSettings;
    }

    /** Returns the builder for the settings used for calls to listApiSpecRevisions. */
    public PagedCallSettings.Builder<
            ListApiSpecRevisionsRequest,
            ListApiSpecRevisionsResponse,
            ListApiSpecRevisionsPagedResponse>
        listApiSpecRevisionsSettings() {
      return listApiSpecRevisionsSettings;
    }

    /** Returns the builder for the settings used for calls to rollbackApiSpec. */
    public UnaryCallSettings.Builder<RollbackApiSpecRequest, ApiSpec> rollbackApiSpecSettings() {
      return rollbackApiSpecSettings;
    }

    /** Returns the builder for the settings used for calls to deleteApiSpecRevision. */
    public UnaryCallSettings.Builder<DeleteApiSpecRevisionRequest, ApiSpec>
        deleteApiSpecRevisionSettings() {
      return deleteApiSpecRevisionSettings;
    }

    /** Returns the builder for the settings used for calls to listApiDeployments. */
    public PagedCallSettings.Builder<
            ListApiDeploymentsRequest, ListApiDeploymentsResponse, ListApiDeploymentsPagedResponse>
        listApiDeploymentsSettings() {
      return listApiDeploymentsSettings;
    }

    /** Returns the builder for the settings used for calls to getApiDeployment. */
    public UnaryCallSettings.Builder<GetApiDeploymentRequest, ApiDeployment>
        getApiDeploymentSettings() {
      return getApiDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to createApiDeployment. */
    public UnaryCallSettings.Builder<CreateApiDeploymentRequest, ApiDeployment>
        createApiDeploymentSettings() {
      return createApiDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to updateApiDeployment. */
    public UnaryCallSettings.Builder<UpdateApiDeploymentRequest, ApiDeployment>
        updateApiDeploymentSettings() {
      return updateApiDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteApiDeployment. */
    public UnaryCallSettings.Builder<DeleteApiDeploymentRequest, Empty>
        deleteApiDeploymentSettings() {
      return deleteApiDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to tagApiDeploymentRevision. */
    public UnaryCallSettings.Builder<TagApiDeploymentRevisionRequest, ApiDeployment>
        tagApiDeploymentRevisionSettings() {
      return tagApiDeploymentRevisionSettings;
    }

    /** Returns the builder for the settings used for calls to listApiDeploymentRevisions. */
    public PagedCallSettings.Builder<
            ListApiDeploymentRevisionsRequest,
            ListApiDeploymentRevisionsResponse,
            ListApiDeploymentRevisionsPagedResponse>
        listApiDeploymentRevisionsSettings() {
      return listApiDeploymentRevisionsSettings;
    }

    /** Returns the builder for the settings used for calls to rollbackApiDeployment. */
    public UnaryCallSettings.Builder<RollbackApiDeploymentRequest, ApiDeployment>
        rollbackApiDeploymentSettings() {
      return rollbackApiDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteApiDeploymentRevision. */
    public UnaryCallSettings.Builder<DeleteApiDeploymentRevisionRequest, ApiDeployment>
        deleteApiDeploymentRevisionSettings() {
      return deleteApiDeploymentRevisionSettings;
    }

    /** Returns the builder for the settings used for calls to listArtifacts. */
    public PagedCallSettings.Builder<
            ListArtifactsRequest, ListArtifactsResponse, ListArtifactsPagedResponse>
        listArtifactsSettings() {
      return listArtifactsSettings;
    }

    /** Returns the builder for the settings used for calls to getArtifact. */
    public UnaryCallSettings.Builder<GetArtifactRequest, Artifact> getArtifactSettings() {
      return getArtifactSettings;
    }

    /** Returns the builder for the settings used for calls to getArtifactContents. */
    public UnaryCallSettings.Builder<GetArtifactContentsRequest, HttpBody>
        getArtifactContentsSettings() {
      return getArtifactContentsSettings;
    }

    /** Returns the builder for the settings used for calls to createArtifact. */
    public UnaryCallSettings.Builder<CreateArtifactRequest, Artifact> createArtifactSettings() {
      return createArtifactSettings;
    }

    /** Returns the builder for the settings used for calls to replaceArtifact. */
    public UnaryCallSettings.Builder<ReplaceArtifactRequest, Artifact> replaceArtifactSettings() {
      return replaceArtifactSettings;
    }

    /** Returns the builder for the settings used for calls to deleteArtifact. */
    public UnaryCallSettings.Builder<DeleteArtifactRequest, Empty> deleteArtifactSettings() {
      return deleteArtifactSettings;
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
    public RegistryStubSettings build() throws IOException {
      return new RegistryStubSettings(this);
    }
  }
}
