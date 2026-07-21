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

package com.google.cloud.agentidentity.v1.stub;

import static com.google.cloud.agentidentity.v1.AuthProviderServiceClient.ListAccessSummariesPagedResponse;
import static com.google.cloud.agentidentity.v1.AuthProviderServiceClient.ListAuthProvidersPagedResponse;
import static com.google.cloud.agentidentity.v1.AuthProviderServiceClient.ListAuthorizationsPagedResponse;
import static com.google.cloud.agentidentity.v1.AuthProviderServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.agentidentity.v1.AuthProviderServiceClient.QueryAuthProvidersPagedResponse;
import static com.google.cloud.agentidentity.v1.AuthProviderServiceClient.QueryWorkloadsPagedResponse;

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
import com.google.api.gax.rpc.LibraryMetadata;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.agentidentity.v1.AccessSummary;
import com.google.cloud.agentidentity.v1.AuthProvider;
import com.google.cloud.agentidentity.v1.Authorization;
import com.google.cloud.agentidentity.v1.CreateAuthProviderRequest;
import com.google.cloud.agentidentity.v1.DeleteAuthProviderRequest;
import com.google.cloud.agentidentity.v1.DeleteAuthorizationRequest;
import com.google.cloud.agentidentity.v1.DisableAuthProviderRequest;
import com.google.cloud.agentidentity.v1.EnableAuthProviderRequest;
import com.google.cloud.agentidentity.v1.GetAccessSummaryRequest;
import com.google.cloud.agentidentity.v1.GetAuthProviderRequest;
import com.google.cloud.agentidentity.v1.GetAuthorizationRequest;
import com.google.cloud.agentidentity.v1.ListAccessSummariesRequest;
import com.google.cloud.agentidentity.v1.ListAccessSummariesResponse;
import com.google.cloud.agentidentity.v1.ListAuthProvidersRequest;
import com.google.cloud.agentidentity.v1.ListAuthProvidersResponse;
import com.google.cloud.agentidentity.v1.ListAuthorizationsRequest;
import com.google.cloud.agentidentity.v1.ListAuthorizationsResponse;
import com.google.cloud.agentidentity.v1.QueryAuthProvidersRequest;
import com.google.cloud.agentidentity.v1.QueryAuthProvidersResponse;
import com.google.cloud.agentidentity.v1.QueryWorkloadsRequest;
import com.google.cloud.agentidentity.v1.QueryWorkloadsResponse;
import com.google.cloud.agentidentity.v1.RevokeAuthorizationRequest;
import com.google.cloud.agentidentity.v1.RevokeAuthorizationResponse;
import com.google.cloud.agentidentity.v1.UndeleteAuthProviderRequest;
import com.google.cloud.agentidentity.v1.UpdateAuthProviderRequest;
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
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AuthProviderServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (agentidentity.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getAuthProvider:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AuthProviderServiceStubSettings.Builder authProviderServiceSettingsBuilder =
 *     AuthProviderServiceStubSettings.newBuilder();
 * authProviderServiceSettingsBuilder
 *     .getAuthProviderSettings()
 *     .setRetrySettings(
 *         authProviderServiceSettingsBuilder
 *             .getAuthProviderSettings()
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
 * AuthProviderServiceStubSettings authProviderServiceSettings =
 *     authProviderServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class AuthProviderServiceStubSettings extends StubSettings<AuthProviderServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListAuthProvidersRequest, ListAuthProvidersResponse, ListAuthProvidersPagedResponse>
      listAuthProvidersSettings;
  private final UnaryCallSettings<GetAuthProviderRequest, AuthProvider> getAuthProviderSettings;
  private final UnaryCallSettings<CreateAuthProviderRequest, AuthProvider>
      createAuthProviderSettings;
  private final UnaryCallSettings<UpdateAuthProviderRequest, AuthProvider>
      updateAuthProviderSettings;
  private final UnaryCallSettings<DeleteAuthProviderRequest, Empty> deleteAuthProviderSettings;
  private final UnaryCallSettings<UndeleteAuthProviderRequest, AuthProvider>
      undeleteAuthProviderSettings;
  private final PagedCallSettings<
          QueryAuthProvidersRequest, QueryAuthProvidersResponse, QueryAuthProvidersPagedResponse>
      queryAuthProvidersSettings;
  private final PagedCallSettings<
          QueryWorkloadsRequest, QueryWorkloadsResponse, QueryWorkloadsPagedResponse>
      queryWorkloadsSettings;
  private final PagedCallSettings<
          ListAuthorizationsRequest, ListAuthorizationsResponse, ListAuthorizationsPagedResponse>
      listAuthorizationsSettings;
  private final UnaryCallSettings<GetAuthorizationRequest, Authorization> getAuthorizationSettings;
  private final UnaryCallSettings<DeleteAuthorizationRequest, Empty> deleteAuthorizationSettings;
  private final PagedCallSettings<
          ListAccessSummariesRequest, ListAccessSummariesResponse, ListAccessSummariesPagedResponse>
      listAccessSummariesSettings;
  private final UnaryCallSettings<GetAccessSummaryRequest, AccessSummary> getAccessSummarySettings;
  private final UnaryCallSettings<RevokeAuthorizationRequest, RevokeAuthorizationResponse>
      revokeAuthorizationSettings;
  private final UnaryCallSettings<EnableAuthProviderRequest, AuthProvider>
      enableAuthProviderSettings;
  private final UnaryCallSettings<DisableAuthProviderRequest, AuthProvider>
      disableAuthProviderSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListAuthProvidersRequest, ListAuthProvidersResponse, AuthProvider>
      LIST_AUTH_PROVIDERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAuthProvidersRequest, ListAuthProvidersResponse, AuthProvider>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAuthProvidersRequest injectToken(
                ListAuthProvidersRequest payload, String token) {
              return ListAuthProvidersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAuthProvidersRequest injectPageSize(
                ListAuthProvidersRequest payload, int pageSize) {
              return ListAuthProvidersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAuthProvidersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAuthProvidersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AuthProvider> extractResources(ListAuthProvidersResponse payload) {
              return payload.getAuthProvidersList();
            }
          };

  private static final PagedListDescriptor<
          QueryAuthProvidersRequest, QueryAuthProvidersResponse, String>
      QUERY_AUTH_PROVIDERS_PAGE_STR_DESC =
          new PagedListDescriptor<QueryAuthProvidersRequest, QueryAuthProvidersResponse, String>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public QueryAuthProvidersRequest injectToken(
                QueryAuthProvidersRequest payload, String token) {
              return QueryAuthProvidersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public QueryAuthProvidersRequest injectPageSize(
                QueryAuthProvidersRequest payload, int pageSize) {
              return QueryAuthProvidersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(QueryAuthProvidersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(QueryAuthProvidersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<String> extractResources(QueryAuthProvidersResponse payload) {
              return payload.getAuthProviderNamesList();
            }
          };

  private static final PagedListDescriptor<QueryWorkloadsRequest, QueryWorkloadsResponse, String>
      QUERY_WORKLOADS_PAGE_STR_DESC =
          new PagedListDescriptor<QueryWorkloadsRequest, QueryWorkloadsResponse, String>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public QueryWorkloadsRequest injectToken(QueryWorkloadsRequest payload, String token) {
              return QueryWorkloadsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public QueryWorkloadsRequest injectPageSize(
                QueryWorkloadsRequest payload, int pageSize) {
              return QueryWorkloadsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(QueryWorkloadsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(QueryWorkloadsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<String> extractResources(QueryWorkloadsResponse payload) {
              return payload.getWorkloadIdsList();
            }
          };

  private static final PagedListDescriptor<
          ListAuthorizationsRequest, ListAuthorizationsResponse, Authorization>
      LIST_AUTHORIZATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAuthorizationsRequest, ListAuthorizationsResponse, Authorization>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAuthorizationsRequest injectToken(
                ListAuthorizationsRequest payload, String token) {
              return ListAuthorizationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAuthorizationsRequest injectPageSize(
                ListAuthorizationsRequest payload, int pageSize) {
              return ListAuthorizationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAuthorizationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAuthorizationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Authorization> extractResources(ListAuthorizationsResponse payload) {
              return payload.getAuthorizationsList();
            }
          };

  private static final PagedListDescriptor<
          ListAccessSummariesRequest, ListAccessSummariesResponse, AccessSummary>
      LIST_ACCESS_SUMMARIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAccessSummariesRequest, ListAccessSummariesResponse, AccessSummary>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAccessSummariesRequest injectToken(
                ListAccessSummariesRequest payload, String token) {
              return ListAccessSummariesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAccessSummariesRequest injectPageSize(
                ListAccessSummariesRequest payload, int pageSize) {
              return ListAccessSummariesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAccessSummariesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAccessSummariesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AccessSummary> extractResources(ListAccessSummariesResponse payload) {
              return payload.getAccessSummariesList();
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
          ListAuthProvidersRequest, ListAuthProvidersResponse, ListAuthProvidersPagedResponse>
      LIST_AUTH_PROVIDERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAuthProvidersRequest,
              ListAuthProvidersResponse,
              ListAuthProvidersPagedResponse>() {
            @Override
            public ApiFuture<ListAuthProvidersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAuthProvidersRequest, ListAuthProvidersResponse> callable,
                ListAuthProvidersRequest request,
                ApiCallContext context,
                ApiFuture<ListAuthProvidersResponse> futureResponse) {
              PageContext<ListAuthProvidersRequest, ListAuthProvidersResponse, AuthProvider>
                  pageContext =
                      PageContext.create(
                          callable, LIST_AUTH_PROVIDERS_PAGE_STR_DESC, request, context);
              return ListAuthProvidersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          QueryAuthProvidersRequest, QueryAuthProvidersResponse, QueryAuthProvidersPagedResponse>
      QUERY_AUTH_PROVIDERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              QueryAuthProvidersRequest,
              QueryAuthProvidersResponse,
              QueryAuthProvidersPagedResponse>() {
            @Override
            public ApiFuture<QueryAuthProvidersPagedResponse> getFuturePagedResponse(
                UnaryCallable<QueryAuthProvidersRequest, QueryAuthProvidersResponse> callable,
                QueryAuthProvidersRequest request,
                ApiCallContext context,
                ApiFuture<QueryAuthProvidersResponse> futureResponse) {
              PageContext<QueryAuthProvidersRequest, QueryAuthProvidersResponse, String>
                  pageContext =
                      PageContext.create(
                          callable, QUERY_AUTH_PROVIDERS_PAGE_STR_DESC, request, context);
              return QueryAuthProvidersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          QueryWorkloadsRequest, QueryWorkloadsResponse, QueryWorkloadsPagedResponse>
      QUERY_WORKLOADS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              QueryWorkloadsRequest, QueryWorkloadsResponse, QueryWorkloadsPagedResponse>() {
            @Override
            public ApiFuture<QueryWorkloadsPagedResponse> getFuturePagedResponse(
                UnaryCallable<QueryWorkloadsRequest, QueryWorkloadsResponse> callable,
                QueryWorkloadsRequest request,
                ApiCallContext context,
                ApiFuture<QueryWorkloadsResponse> futureResponse) {
              PageContext<QueryWorkloadsRequest, QueryWorkloadsResponse, String> pageContext =
                  PageContext.create(callable, QUERY_WORKLOADS_PAGE_STR_DESC, request, context);
              return QueryWorkloadsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAuthorizationsRequest, ListAuthorizationsResponse, ListAuthorizationsPagedResponse>
      LIST_AUTHORIZATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAuthorizationsRequest,
              ListAuthorizationsResponse,
              ListAuthorizationsPagedResponse>() {
            @Override
            public ApiFuture<ListAuthorizationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAuthorizationsRequest, ListAuthorizationsResponse> callable,
                ListAuthorizationsRequest request,
                ApiCallContext context,
                ApiFuture<ListAuthorizationsResponse> futureResponse) {
              PageContext<ListAuthorizationsRequest, ListAuthorizationsResponse, Authorization>
                  pageContext =
                      PageContext.create(
                          callable, LIST_AUTHORIZATIONS_PAGE_STR_DESC, request, context);
              return ListAuthorizationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAccessSummariesRequest, ListAccessSummariesResponse, ListAccessSummariesPagedResponse>
      LIST_ACCESS_SUMMARIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAccessSummariesRequest,
              ListAccessSummariesResponse,
              ListAccessSummariesPagedResponse>() {
            @Override
            public ApiFuture<ListAccessSummariesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAccessSummariesRequest, ListAccessSummariesResponse> callable,
                ListAccessSummariesRequest request,
                ApiCallContext context,
                ApiFuture<ListAccessSummariesResponse> futureResponse) {
              PageContext<ListAccessSummariesRequest, ListAccessSummariesResponse, AccessSummary>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ACCESS_SUMMARIES_PAGE_STR_DESC, request, context);
              return ListAccessSummariesPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listAuthProviders. */
  public PagedCallSettings<
          ListAuthProvidersRequest, ListAuthProvidersResponse, ListAuthProvidersPagedResponse>
      listAuthProvidersSettings() {
    return listAuthProvidersSettings;
  }

  /** Returns the object with the settings used for calls to getAuthProvider. */
  public UnaryCallSettings<GetAuthProviderRequest, AuthProvider> getAuthProviderSettings() {
    return getAuthProviderSettings;
  }

  /** Returns the object with the settings used for calls to createAuthProvider. */
  public UnaryCallSettings<CreateAuthProviderRequest, AuthProvider> createAuthProviderSettings() {
    return createAuthProviderSettings;
  }

  /** Returns the object with the settings used for calls to updateAuthProvider. */
  public UnaryCallSettings<UpdateAuthProviderRequest, AuthProvider> updateAuthProviderSettings() {
    return updateAuthProviderSettings;
  }

  /** Returns the object with the settings used for calls to deleteAuthProvider. */
  public UnaryCallSettings<DeleteAuthProviderRequest, Empty> deleteAuthProviderSettings() {
    return deleteAuthProviderSettings;
  }

  /** Returns the object with the settings used for calls to undeleteAuthProvider. */
  public UnaryCallSettings<UndeleteAuthProviderRequest, AuthProvider>
      undeleteAuthProviderSettings() {
    return undeleteAuthProviderSettings;
  }

  /** Returns the object with the settings used for calls to queryAuthProviders. */
  public PagedCallSettings<
          QueryAuthProvidersRequest, QueryAuthProvidersResponse, QueryAuthProvidersPagedResponse>
      queryAuthProvidersSettings() {
    return queryAuthProvidersSettings;
  }

  /** Returns the object with the settings used for calls to queryWorkloads. */
  public PagedCallSettings<
          QueryWorkloadsRequest, QueryWorkloadsResponse, QueryWorkloadsPagedResponse>
      queryWorkloadsSettings() {
    return queryWorkloadsSettings;
  }

  /** Returns the object with the settings used for calls to listAuthorizations. */
  public PagedCallSettings<
          ListAuthorizationsRequest, ListAuthorizationsResponse, ListAuthorizationsPagedResponse>
      listAuthorizationsSettings() {
    return listAuthorizationsSettings;
  }

  /** Returns the object with the settings used for calls to getAuthorization. */
  public UnaryCallSettings<GetAuthorizationRequest, Authorization> getAuthorizationSettings() {
    return getAuthorizationSettings;
  }

  /** Returns the object with the settings used for calls to deleteAuthorization. */
  public UnaryCallSettings<DeleteAuthorizationRequest, Empty> deleteAuthorizationSettings() {
    return deleteAuthorizationSettings;
  }

  /** Returns the object with the settings used for calls to listAccessSummaries. */
  public PagedCallSettings<
          ListAccessSummariesRequest, ListAccessSummariesResponse, ListAccessSummariesPagedResponse>
      listAccessSummariesSettings() {
    return listAccessSummariesSettings;
  }

  /** Returns the object with the settings used for calls to getAccessSummary. */
  public UnaryCallSettings<GetAccessSummaryRequest, AccessSummary> getAccessSummarySettings() {
    return getAccessSummarySettings;
  }

  /** Returns the object with the settings used for calls to revokeAuthorization. */
  public UnaryCallSettings<RevokeAuthorizationRequest, RevokeAuthorizationResponse>
      revokeAuthorizationSettings() {
    return revokeAuthorizationSettings;
  }

  /** Returns the object with the settings used for calls to enableAuthProvider. */
  public UnaryCallSettings<EnableAuthProviderRequest, AuthProvider> enableAuthProviderSettings() {
    return enableAuthProviderSettings;
  }

  /** Returns the object with the settings used for calls to disableAuthProvider. */
  public UnaryCallSettings<DisableAuthProviderRequest, AuthProvider> disableAuthProviderSettings() {
    return disableAuthProviderSettings;
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

  public AuthProviderServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAuthProviderServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAuthProviderServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "agentidentity";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "agentidentity.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "agentidentity.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(AuthProviderServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AuthProviderServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AuthProviderServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected AuthProviderServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listAuthProvidersSettings = settingsBuilder.listAuthProvidersSettings().build();
    getAuthProviderSettings = settingsBuilder.getAuthProviderSettings().build();
    createAuthProviderSettings = settingsBuilder.createAuthProviderSettings().build();
    updateAuthProviderSettings = settingsBuilder.updateAuthProviderSettings().build();
    deleteAuthProviderSettings = settingsBuilder.deleteAuthProviderSettings().build();
    undeleteAuthProviderSettings = settingsBuilder.undeleteAuthProviderSettings().build();
    queryAuthProvidersSettings = settingsBuilder.queryAuthProvidersSettings().build();
    queryWorkloadsSettings = settingsBuilder.queryWorkloadsSettings().build();
    listAuthorizationsSettings = settingsBuilder.listAuthorizationsSettings().build();
    getAuthorizationSettings = settingsBuilder.getAuthorizationSettings().build();
    deleteAuthorizationSettings = settingsBuilder.deleteAuthorizationSettings().build();
    listAccessSummariesSettings = settingsBuilder.listAccessSummariesSettings().build();
    getAccessSummarySettings = settingsBuilder.getAccessSummarySettings().build();
    revokeAuthorizationSettings = settingsBuilder.revokeAuthorizationSettings().build();
    enableAuthProviderSettings = settingsBuilder.enableAuthProviderSettings().build();
    disableAuthProviderSettings = settingsBuilder.disableAuthProviderSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-agentidentity")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for AuthProviderServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<AuthProviderServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListAuthProvidersRequest, ListAuthProvidersResponse, ListAuthProvidersPagedResponse>
        listAuthProvidersSettings;
    private final UnaryCallSettings.Builder<GetAuthProviderRequest, AuthProvider>
        getAuthProviderSettings;
    private final UnaryCallSettings.Builder<CreateAuthProviderRequest, AuthProvider>
        createAuthProviderSettings;
    private final UnaryCallSettings.Builder<UpdateAuthProviderRequest, AuthProvider>
        updateAuthProviderSettings;
    private final UnaryCallSettings.Builder<DeleteAuthProviderRequest, Empty>
        deleteAuthProviderSettings;
    private final UnaryCallSettings.Builder<UndeleteAuthProviderRequest, AuthProvider>
        undeleteAuthProviderSettings;
    private final PagedCallSettings.Builder<
            QueryAuthProvidersRequest, QueryAuthProvidersResponse, QueryAuthProvidersPagedResponse>
        queryAuthProvidersSettings;
    private final PagedCallSettings.Builder<
            QueryWorkloadsRequest, QueryWorkloadsResponse, QueryWorkloadsPagedResponse>
        queryWorkloadsSettings;
    private final PagedCallSettings.Builder<
            ListAuthorizationsRequest, ListAuthorizationsResponse, ListAuthorizationsPagedResponse>
        listAuthorizationsSettings;
    private final UnaryCallSettings.Builder<GetAuthorizationRequest, Authorization>
        getAuthorizationSettings;
    private final UnaryCallSettings.Builder<DeleteAuthorizationRequest, Empty>
        deleteAuthorizationSettings;
    private final PagedCallSettings.Builder<
            ListAccessSummariesRequest,
            ListAccessSummariesResponse,
            ListAccessSummariesPagedResponse>
        listAccessSummariesSettings;
    private final UnaryCallSettings.Builder<GetAccessSummaryRequest, AccessSummary>
        getAccessSummarySettings;
    private final UnaryCallSettings.Builder<RevokeAuthorizationRequest, RevokeAuthorizationResponse>
        revokeAuthorizationSettings;
    private final UnaryCallSettings.Builder<EnableAuthProviderRequest, AuthProvider>
        enableAuthProviderSettings;
    private final UnaryCallSettings.Builder<DisableAuthProviderRequest, AuthProvider>
        disableAuthProviderSettings;
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
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(clientContext);

      listAuthProvidersSettings = PagedCallSettings.newBuilder(LIST_AUTH_PROVIDERS_PAGE_STR_FACT);
      getAuthProviderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAuthProviderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAuthProviderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAuthProviderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      undeleteAuthProviderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      queryAuthProvidersSettings = PagedCallSettings.newBuilder(QUERY_AUTH_PROVIDERS_PAGE_STR_FACT);
      queryWorkloadsSettings = PagedCallSettings.newBuilder(QUERY_WORKLOADS_PAGE_STR_FACT);
      listAuthorizationsSettings = PagedCallSettings.newBuilder(LIST_AUTHORIZATIONS_PAGE_STR_FACT);
      getAuthorizationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAuthorizationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAccessSummariesSettings =
          PagedCallSettings.newBuilder(LIST_ACCESS_SUMMARIES_PAGE_STR_FACT);
      getAccessSummarySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      revokeAuthorizationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      enableAuthProviderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      disableAuthProviderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAuthProvidersSettings,
              getAuthProviderSettings,
              createAuthProviderSettings,
              updateAuthProviderSettings,
              deleteAuthProviderSettings,
              undeleteAuthProviderSettings,
              queryAuthProvidersSettings,
              queryWorkloadsSettings,
              listAuthorizationsSettings,
              getAuthorizationSettings,
              deleteAuthorizationSettings,
              listAccessSummariesSettings,
              getAccessSummarySettings,
              revokeAuthorizationSettings,
              enableAuthProviderSettings,
              disableAuthProviderSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(AuthProviderServiceStubSettings settings) {
      super(settings);

      listAuthProvidersSettings = settings.listAuthProvidersSettings.toBuilder();
      getAuthProviderSettings = settings.getAuthProviderSettings.toBuilder();
      createAuthProviderSettings = settings.createAuthProviderSettings.toBuilder();
      updateAuthProviderSettings = settings.updateAuthProviderSettings.toBuilder();
      deleteAuthProviderSettings = settings.deleteAuthProviderSettings.toBuilder();
      undeleteAuthProviderSettings = settings.undeleteAuthProviderSettings.toBuilder();
      queryAuthProvidersSettings = settings.queryAuthProvidersSettings.toBuilder();
      queryWorkloadsSettings = settings.queryWorkloadsSettings.toBuilder();
      listAuthorizationsSettings = settings.listAuthorizationsSettings.toBuilder();
      getAuthorizationSettings = settings.getAuthorizationSettings.toBuilder();
      deleteAuthorizationSettings = settings.deleteAuthorizationSettings.toBuilder();
      listAccessSummariesSettings = settings.listAccessSummariesSettings.toBuilder();
      getAccessSummarySettings = settings.getAccessSummarySettings.toBuilder();
      revokeAuthorizationSettings = settings.revokeAuthorizationSettings.toBuilder();
      enableAuthProviderSettings = settings.enableAuthProviderSettings.toBuilder();
      disableAuthProviderSettings = settings.disableAuthProviderSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAuthProvidersSettings,
              getAuthProviderSettings,
              createAuthProviderSettings,
              updateAuthProviderSettings,
              deleteAuthProviderSettings,
              undeleteAuthProviderSettings,
              queryAuthProvidersSettings,
              queryWorkloadsSettings,
              listAuthorizationsSettings,
              getAuthorizationSettings,
              deleteAuthorizationSettings,
              listAccessSummariesSettings,
              getAccessSummarySettings,
              revokeAuthorizationSettings,
              enableAuthProviderSettings,
              disableAuthProviderSettings,
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
          .listAuthProvidersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getAuthProviderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAuthProviderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateAuthProviderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteAuthProviderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .undeleteAuthProviderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .queryAuthProvidersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .queryWorkloadsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAuthorizationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getAuthorizationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteAuthorizationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAccessSummariesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getAccessSummarySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .revokeAuthorizationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .enableAuthProviderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .disableAuthProviderSettings()
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

    /** Returns the builder for the settings used for calls to listAuthProviders. */
    public PagedCallSettings.Builder<
            ListAuthProvidersRequest, ListAuthProvidersResponse, ListAuthProvidersPagedResponse>
        listAuthProvidersSettings() {
      return listAuthProvidersSettings;
    }

    /** Returns the builder for the settings used for calls to getAuthProvider. */
    public UnaryCallSettings.Builder<GetAuthProviderRequest, AuthProvider>
        getAuthProviderSettings() {
      return getAuthProviderSettings;
    }

    /** Returns the builder for the settings used for calls to createAuthProvider. */
    public UnaryCallSettings.Builder<CreateAuthProviderRequest, AuthProvider>
        createAuthProviderSettings() {
      return createAuthProviderSettings;
    }

    /** Returns the builder for the settings used for calls to updateAuthProvider. */
    public UnaryCallSettings.Builder<UpdateAuthProviderRequest, AuthProvider>
        updateAuthProviderSettings() {
      return updateAuthProviderSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAuthProvider. */
    public UnaryCallSettings.Builder<DeleteAuthProviderRequest, Empty>
        deleteAuthProviderSettings() {
      return deleteAuthProviderSettings;
    }

    /** Returns the builder for the settings used for calls to undeleteAuthProvider. */
    public UnaryCallSettings.Builder<UndeleteAuthProviderRequest, AuthProvider>
        undeleteAuthProviderSettings() {
      return undeleteAuthProviderSettings;
    }

    /** Returns the builder for the settings used for calls to queryAuthProviders. */
    public PagedCallSettings.Builder<
            QueryAuthProvidersRequest, QueryAuthProvidersResponse, QueryAuthProvidersPagedResponse>
        queryAuthProvidersSettings() {
      return queryAuthProvidersSettings;
    }

    /** Returns the builder for the settings used for calls to queryWorkloads. */
    public PagedCallSettings.Builder<
            QueryWorkloadsRequest, QueryWorkloadsResponse, QueryWorkloadsPagedResponse>
        queryWorkloadsSettings() {
      return queryWorkloadsSettings;
    }

    /** Returns the builder for the settings used for calls to listAuthorizations. */
    public PagedCallSettings.Builder<
            ListAuthorizationsRequest, ListAuthorizationsResponse, ListAuthorizationsPagedResponse>
        listAuthorizationsSettings() {
      return listAuthorizationsSettings;
    }

    /** Returns the builder for the settings used for calls to getAuthorization. */
    public UnaryCallSettings.Builder<GetAuthorizationRequest, Authorization>
        getAuthorizationSettings() {
      return getAuthorizationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAuthorization. */
    public UnaryCallSettings.Builder<DeleteAuthorizationRequest, Empty>
        deleteAuthorizationSettings() {
      return deleteAuthorizationSettings;
    }

    /** Returns the builder for the settings used for calls to listAccessSummaries. */
    public PagedCallSettings.Builder<
            ListAccessSummariesRequest,
            ListAccessSummariesResponse,
            ListAccessSummariesPagedResponse>
        listAccessSummariesSettings() {
      return listAccessSummariesSettings;
    }

    /** Returns the builder for the settings used for calls to getAccessSummary. */
    public UnaryCallSettings.Builder<GetAccessSummaryRequest, AccessSummary>
        getAccessSummarySettings() {
      return getAccessSummarySettings;
    }

    /** Returns the builder for the settings used for calls to revokeAuthorization. */
    public UnaryCallSettings.Builder<RevokeAuthorizationRequest, RevokeAuthorizationResponse>
        revokeAuthorizationSettings() {
      return revokeAuthorizationSettings;
    }

    /** Returns the builder for the settings used for calls to enableAuthProvider. */
    public UnaryCallSettings.Builder<EnableAuthProviderRequest, AuthProvider>
        enableAuthProviderSettings() {
      return enableAuthProviderSettings;
    }

    /** Returns the builder for the settings used for calls to disableAuthProvider. */
    public UnaryCallSettings.Builder<DisableAuthProviderRequest, AuthProvider>
        disableAuthProviderSettings() {
      return disableAuthProviderSettings;
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
    public AuthProviderServiceStubSettings build() throws IOException {
      return new AuthProviderServiceStubSettings(this);
    }
  }
}
