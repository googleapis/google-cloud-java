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

package com.google.cloud.privilegedaccessmanager.v1.stub;

import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.ListEntitlementsPagedResponse;
import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.ListGrantsPagedResponse;
import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.SearchEntitlementsPagedResponse;
import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.SearchGrantsPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.privilegedaccessmanager.v1.ApproveGrantRequest;
import com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusRequest;
import com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusResponse;
import com.google.cloud.privilegedaccessmanager.v1.CreateEntitlementRequest;
import com.google.cloud.privilegedaccessmanager.v1.CreateGrantRequest;
import com.google.cloud.privilegedaccessmanager.v1.DeleteEntitlementRequest;
import com.google.cloud.privilegedaccessmanager.v1.DenyGrantRequest;
import com.google.cloud.privilegedaccessmanager.v1.Entitlement;
import com.google.cloud.privilegedaccessmanager.v1.GetEntitlementRequest;
import com.google.cloud.privilegedaccessmanager.v1.GetGrantRequest;
import com.google.cloud.privilegedaccessmanager.v1.Grant;
import com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsRequest;
import com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsResponse;
import com.google.cloud.privilegedaccessmanager.v1.ListGrantsRequest;
import com.google.cloud.privilegedaccessmanager.v1.ListGrantsResponse;
import com.google.cloud.privilegedaccessmanager.v1.OperationMetadata;
import com.google.cloud.privilegedaccessmanager.v1.RevokeGrantRequest;
import com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsRequest;
import com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsResponse;
import com.google.cloud.privilegedaccessmanager.v1.SearchGrantsRequest;
import com.google.cloud.privilegedaccessmanager.v1.SearchGrantsResponse;
import com.google.cloud.privilegedaccessmanager.v1.UpdateEntitlementRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PrivilegedAccessManagerStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (privilegedaccessmanager.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of checkOnboardingStatus to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PrivilegedAccessManagerStubSettings.Builder privilegedAccessManagerSettingsBuilder =
 *     PrivilegedAccessManagerStubSettings.newBuilder();
 * privilegedAccessManagerSettingsBuilder
 *     .checkOnboardingStatusSettings()
 *     .setRetrySettings(
 *         privilegedAccessManagerSettingsBuilder
 *             .checkOnboardingStatusSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * PrivilegedAccessManagerStubSettings privilegedAccessManagerSettings =
 *     privilegedAccessManagerSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class PrivilegedAccessManagerStubSettings
    extends StubSettings<PrivilegedAccessManagerStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CheckOnboardingStatusRequest, CheckOnboardingStatusResponse>
      checkOnboardingStatusSettings;
  private final PagedCallSettings<
          ListEntitlementsRequest, ListEntitlementsResponse, ListEntitlementsPagedResponse>
      listEntitlementsSettings;
  private final PagedCallSettings<
          SearchEntitlementsRequest, SearchEntitlementsResponse, SearchEntitlementsPagedResponse>
      searchEntitlementsSettings;
  private final UnaryCallSettings<GetEntitlementRequest, Entitlement> getEntitlementSettings;
  private final UnaryCallSettings<CreateEntitlementRequest, Operation> createEntitlementSettings;
  private final OperationCallSettings<CreateEntitlementRequest, Entitlement, OperationMetadata>
      createEntitlementOperationSettings;
  private final UnaryCallSettings<DeleteEntitlementRequest, Operation> deleteEntitlementSettings;
  private final OperationCallSettings<DeleteEntitlementRequest, Entitlement, OperationMetadata>
      deleteEntitlementOperationSettings;
  private final UnaryCallSettings<UpdateEntitlementRequest, Operation> updateEntitlementSettings;
  private final OperationCallSettings<UpdateEntitlementRequest, Entitlement, OperationMetadata>
      updateEntitlementOperationSettings;
  private final PagedCallSettings<ListGrantsRequest, ListGrantsResponse, ListGrantsPagedResponse>
      listGrantsSettings;
  private final PagedCallSettings<
          SearchGrantsRequest, SearchGrantsResponse, SearchGrantsPagedResponse>
      searchGrantsSettings;
  private final UnaryCallSettings<GetGrantRequest, Grant> getGrantSettings;
  private final UnaryCallSettings<CreateGrantRequest, Grant> createGrantSettings;
  private final UnaryCallSettings<ApproveGrantRequest, Grant> approveGrantSettings;
  private final UnaryCallSettings<DenyGrantRequest, Grant> denyGrantSettings;
  private final UnaryCallSettings<RevokeGrantRequest, Operation> revokeGrantSettings;
  private final OperationCallSettings<RevokeGrantRequest, Grant, OperationMetadata>
      revokeGrantOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListEntitlementsRequest, ListEntitlementsResponse, Entitlement>
      LIST_ENTITLEMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListEntitlementsRequest, ListEntitlementsResponse, Entitlement>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEntitlementsRequest injectToken(
                ListEntitlementsRequest payload, String token) {
              return ListEntitlementsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEntitlementsRequest injectPageSize(
                ListEntitlementsRequest payload, int pageSize) {
              return ListEntitlementsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEntitlementsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEntitlementsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Entitlement> extractResources(ListEntitlementsResponse payload) {
              return payload.getEntitlementsList() == null
                  ? ImmutableList.<Entitlement>of()
                  : payload.getEntitlementsList();
            }
          };

  private static final PagedListDescriptor<
          SearchEntitlementsRequest, SearchEntitlementsResponse, Entitlement>
      SEARCH_ENTITLEMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              SearchEntitlementsRequest, SearchEntitlementsResponse, Entitlement>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchEntitlementsRequest injectToken(
                SearchEntitlementsRequest payload, String token) {
              return SearchEntitlementsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchEntitlementsRequest injectPageSize(
                SearchEntitlementsRequest payload, int pageSize) {
              return SearchEntitlementsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchEntitlementsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchEntitlementsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Entitlement> extractResources(SearchEntitlementsResponse payload) {
              return payload.getEntitlementsList() == null
                  ? ImmutableList.<Entitlement>of()
                  : payload.getEntitlementsList();
            }
          };

  private static final PagedListDescriptor<ListGrantsRequest, ListGrantsResponse, Grant>
      LIST_GRANTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListGrantsRequest, ListGrantsResponse, Grant>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGrantsRequest injectToken(ListGrantsRequest payload, String token) {
              return ListGrantsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListGrantsRequest injectPageSize(ListGrantsRequest payload, int pageSize) {
              return ListGrantsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListGrantsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListGrantsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Grant> extractResources(ListGrantsResponse payload) {
              return payload.getGrantsList() == null
                  ? ImmutableList.<Grant>of()
                  : payload.getGrantsList();
            }
          };

  private static final PagedListDescriptor<SearchGrantsRequest, SearchGrantsResponse, Grant>
      SEARCH_GRANTS_PAGE_STR_DESC =
          new PagedListDescriptor<SearchGrantsRequest, SearchGrantsResponse, Grant>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchGrantsRequest injectToken(SearchGrantsRequest payload, String token) {
              return SearchGrantsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchGrantsRequest injectPageSize(SearchGrantsRequest payload, int pageSize) {
              return SearchGrantsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchGrantsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchGrantsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Grant> extractResources(SearchGrantsResponse payload) {
              return payload.getGrantsList() == null
                  ? ImmutableList.<Grant>of()
                  : payload.getGrantsList();
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
          ListEntitlementsRequest, ListEntitlementsResponse, ListEntitlementsPagedResponse>
      LIST_ENTITLEMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEntitlementsRequest, ListEntitlementsResponse, ListEntitlementsPagedResponse>() {
            @Override
            public ApiFuture<ListEntitlementsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEntitlementsRequest, ListEntitlementsResponse> callable,
                ListEntitlementsRequest request,
                ApiCallContext context,
                ApiFuture<ListEntitlementsResponse> futureResponse) {
              PageContext<ListEntitlementsRequest, ListEntitlementsResponse, Entitlement>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ENTITLEMENTS_PAGE_STR_DESC, request, context);
              return ListEntitlementsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchEntitlementsRequest, SearchEntitlementsResponse, SearchEntitlementsPagedResponse>
      SEARCH_ENTITLEMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchEntitlementsRequest,
              SearchEntitlementsResponse,
              SearchEntitlementsPagedResponse>() {
            @Override
            public ApiFuture<SearchEntitlementsPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchEntitlementsRequest, SearchEntitlementsResponse> callable,
                SearchEntitlementsRequest request,
                ApiCallContext context,
                ApiFuture<SearchEntitlementsResponse> futureResponse) {
              PageContext<SearchEntitlementsRequest, SearchEntitlementsResponse, Entitlement>
                  pageContext =
                      PageContext.create(
                          callable, SEARCH_ENTITLEMENTS_PAGE_STR_DESC, request, context);
              return SearchEntitlementsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListGrantsRequest, ListGrantsResponse, ListGrantsPagedResponse>
      LIST_GRANTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGrantsRequest, ListGrantsResponse, ListGrantsPagedResponse>() {
            @Override
            public ApiFuture<ListGrantsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGrantsRequest, ListGrantsResponse> callable,
                ListGrantsRequest request,
                ApiCallContext context,
                ApiFuture<ListGrantsResponse> futureResponse) {
              PageContext<ListGrantsRequest, ListGrantsResponse, Grant> pageContext =
                  PageContext.create(callable, LIST_GRANTS_PAGE_STR_DESC, request, context);
              return ListGrantsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchGrantsRequest, SearchGrantsResponse, SearchGrantsPagedResponse>
      SEARCH_GRANTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchGrantsRequest, SearchGrantsResponse, SearchGrantsPagedResponse>() {
            @Override
            public ApiFuture<SearchGrantsPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchGrantsRequest, SearchGrantsResponse> callable,
                SearchGrantsRequest request,
                ApiCallContext context,
                ApiFuture<SearchGrantsResponse> futureResponse) {
              PageContext<SearchGrantsRequest, SearchGrantsResponse, Grant> pageContext =
                  PageContext.create(callable, SEARCH_GRANTS_PAGE_STR_DESC, request, context);
              return SearchGrantsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to checkOnboardingStatus. */
  public UnaryCallSettings<CheckOnboardingStatusRequest, CheckOnboardingStatusResponse>
      checkOnboardingStatusSettings() {
    return checkOnboardingStatusSettings;
  }

  /** Returns the object with the settings used for calls to listEntitlements. */
  public PagedCallSettings<
          ListEntitlementsRequest, ListEntitlementsResponse, ListEntitlementsPagedResponse>
      listEntitlementsSettings() {
    return listEntitlementsSettings;
  }

  /** Returns the object with the settings used for calls to searchEntitlements. */
  public PagedCallSettings<
          SearchEntitlementsRequest, SearchEntitlementsResponse, SearchEntitlementsPagedResponse>
      searchEntitlementsSettings() {
    return searchEntitlementsSettings;
  }

  /** Returns the object with the settings used for calls to getEntitlement. */
  public UnaryCallSettings<GetEntitlementRequest, Entitlement> getEntitlementSettings() {
    return getEntitlementSettings;
  }

  /** Returns the object with the settings used for calls to createEntitlement. */
  public UnaryCallSettings<CreateEntitlementRequest, Operation> createEntitlementSettings() {
    return createEntitlementSettings;
  }

  /** Returns the object with the settings used for calls to createEntitlement. */
  public OperationCallSettings<CreateEntitlementRequest, Entitlement, OperationMetadata>
      createEntitlementOperationSettings() {
    return createEntitlementOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteEntitlement. */
  public UnaryCallSettings<DeleteEntitlementRequest, Operation> deleteEntitlementSettings() {
    return deleteEntitlementSettings;
  }

  /** Returns the object with the settings used for calls to deleteEntitlement. */
  public OperationCallSettings<DeleteEntitlementRequest, Entitlement, OperationMetadata>
      deleteEntitlementOperationSettings() {
    return deleteEntitlementOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateEntitlement. */
  public UnaryCallSettings<UpdateEntitlementRequest, Operation> updateEntitlementSettings() {
    return updateEntitlementSettings;
  }

  /** Returns the object with the settings used for calls to updateEntitlement. */
  public OperationCallSettings<UpdateEntitlementRequest, Entitlement, OperationMetadata>
      updateEntitlementOperationSettings() {
    return updateEntitlementOperationSettings;
  }

  /** Returns the object with the settings used for calls to listGrants. */
  public PagedCallSettings<ListGrantsRequest, ListGrantsResponse, ListGrantsPagedResponse>
      listGrantsSettings() {
    return listGrantsSettings;
  }

  /** Returns the object with the settings used for calls to searchGrants. */
  public PagedCallSettings<SearchGrantsRequest, SearchGrantsResponse, SearchGrantsPagedResponse>
      searchGrantsSettings() {
    return searchGrantsSettings;
  }

  /** Returns the object with the settings used for calls to getGrant. */
  public UnaryCallSettings<GetGrantRequest, Grant> getGrantSettings() {
    return getGrantSettings;
  }

  /** Returns the object with the settings used for calls to createGrant. */
  public UnaryCallSettings<CreateGrantRequest, Grant> createGrantSettings() {
    return createGrantSettings;
  }

  /** Returns the object with the settings used for calls to approveGrant. */
  public UnaryCallSettings<ApproveGrantRequest, Grant> approveGrantSettings() {
    return approveGrantSettings;
  }

  /** Returns the object with the settings used for calls to denyGrant. */
  public UnaryCallSettings<DenyGrantRequest, Grant> denyGrantSettings() {
    return denyGrantSettings;
  }

  /** Returns the object with the settings used for calls to revokeGrant. */
  public UnaryCallSettings<RevokeGrantRequest, Operation> revokeGrantSettings() {
    return revokeGrantSettings;
  }

  /** Returns the object with the settings used for calls to revokeGrant. */
  public OperationCallSettings<RevokeGrantRequest, Grant, OperationMetadata>
      revokeGrantOperationSettings() {
    return revokeGrantOperationSettings;
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

  public PrivilegedAccessManagerStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcPrivilegedAccessManagerStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonPrivilegedAccessManagerStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "privilegedaccessmanager";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "privilegedaccessmanager.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "privilegedaccessmanager.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(PrivilegedAccessManagerStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(PrivilegedAccessManagerStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PrivilegedAccessManagerStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected PrivilegedAccessManagerStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    checkOnboardingStatusSettings = settingsBuilder.checkOnboardingStatusSettings().build();
    listEntitlementsSettings = settingsBuilder.listEntitlementsSettings().build();
    searchEntitlementsSettings = settingsBuilder.searchEntitlementsSettings().build();
    getEntitlementSettings = settingsBuilder.getEntitlementSettings().build();
    createEntitlementSettings = settingsBuilder.createEntitlementSettings().build();
    createEntitlementOperationSettings =
        settingsBuilder.createEntitlementOperationSettings().build();
    deleteEntitlementSettings = settingsBuilder.deleteEntitlementSettings().build();
    deleteEntitlementOperationSettings =
        settingsBuilder.deleteEntitlementOperationSettings().build();
    updateEntitlementSettings = settingsBuilder.updateEntitlementSettings().build();
    updateEntitlementOperationSettings =
        settingsBuilder.updateEntitlementOperationSettings().build();
    listGrantsSettings = settingsBuilder.listGrantsSettings().build();
    searchGrantsSettings = settingsBuilder.searchGrantsSettings().build();
    getGrantSettings = settingsBuilder.getGrantSettings().build();
    createGrantSettings = settingsBuilder.createGrantSettings().build();
    approveGrantSettings = settingsBuilder.approveGrantSettings().build();
    denyGrantSettings = settingsBuilder.denyGrantSettings().build();
    revokeGrantSettings = settingsBuilder.revokeGrantSettings().build();
    revokeGrantOperationSettings = settingsBuilder.revokeGrantOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for PrivilegedAccessManagerStubSettings. */
  public static class Builder
      extends StubSettings.Builder<PrivilegedAccessManagerStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<
            CheckOnboardingStatusRequest, CheckOnboardingStatusResponse>
        checkOnboardingStatusSettings;
    private final PagedCallSettings.Builder<
            ListEntitlementsRequest, ListEntitlementsResponse, ListEntitlementsPagedResponse>
        listEntitlementsSettings;
    private final PagedCallSettings.Builder<
            SearchEntitlementsRequest, SearchEntitlementsResponse, SearchEntitlementsPagedResponse>
        searchEntitlementsSettings;
    private final UnaryCallSettings.Builder<GetEntitlementRequest, Entitlement>
        getEntitlementSettings;
    private final UnaryCallSettings.Builder<CreateEntitlementRequest, Operation>
        createEntitlementSettings;
    private final OperationCallSettings.Builder<
            CreateEntitlementRequest, Entitlement, OperationMetadata>
        createEntitlementOperationSettings;
    private final UnaryCallSettings.Builder<DeleteEntitlementRequest, Operation>
        deleteEntitlementSettings;
    private final OperationCallSettings.Builder<
            DeleteEntitlementRequest, Entitlement, OperationMetadata>
        deleteEntitlementOperationSettings;
    private final UnaryCallSettings.Builder<UpdateEntitlementRequest, Operation>
        updateEntitlementSettings;
    private final OperationCallSettings.Builder<
            UpdateEntitlementRequest, Entitlement, OperationMetadata>
        updateEntitlementOperationSettings;
    private final PagedCallSettings.Builder<
            ListGrantsRequest, ListGrantsResponse, ListGrantsPagedResponse>
        listGrantsSettings;
    private final PagedCallSettings.Builder<
            SearchGrantsRequest, SearchGrantsResponse, SearchGrantsPagedResponse>
        searchGrantsSettings;
    private final UnaryCallSettings.Builder<GetGrantRequest, Grant> getGrantSettings;
    private final UnaryCallSettings.Builder<CreateGrantRequest, Grant> createGrantSettings;
    private final UnaryCallSettings.Builder<ApproveGrantRequest, Grant> approveGrantSettings;
    private final UnaryCallSettings.Builder<DenyGrantRequest, Grant> denyGrantSettings;
    private final UnaryCallSettings.Builder<RevokeGrantRequest, Operation> revokeGrantSettings;
    private final OperationCallSettings.Builder<RevokeGrantRequest, Grant, OperationMetadata>
        revokeGrantOperationSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      checkOnboardingStatusSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listEntitlementsSettings = PagedCallSettings.newBuilder(LIST_ENTITLEMENTS_PAGE_STR_FACT);
      searchEntitlementsSettings = PagedCallSettings.newBuilder(SEARCH_ENTITLEMENTS_PAGE_STR_FACT);
      getEntitlementSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEntitlementSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEntitlementOperationSettings = OperationCallSettings.newBuilder();
      deleteEntitlementSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEntitlementOperationSettings = OperationCallSettings.newBuilder();
      updateEntitlementSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEntitlementOperationSettings = OperationCallSettings.newBuilder();
      listGrantsSettings = PagedCallSettings.newBuilder(LIST_GRANTS_PAGE_STR_FACT);
      searchGrantsSettings = PagedCallSettings.newBuilder(SEARCH_GRANTS_PAGE_STR_FACT);
      getGrantSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGrantSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      approveGrantSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      denyGrantSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      revokeGrantSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      revokeGrantOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              checkOnboardingStatusSettings,
              listEntitlementsSettings,
              searchEntitlementsSettings,
              getEntitlementSettings,
              createEntitlementSettings,
              deleteEntitlementSettings,
              updateEntitlementSettings,
              listGrantsSettings,
              searchGrantsSettings,
              getGrantSettings,
              createGrantSettings,
              approveGrantSettings,
              denyGrantSettings,
              revokeGrantSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(PrivilegedAccessManagerStubSettings settings) {
      super(settings);

      checkOnboardingStatusSettings = settings.checkOnboardingStatusSettings.toBuilder();
      listEntitlementsSettings = settings.listEntitlementsSettings.toBuilder();
      searchEntitlementsSettings = settings.searchEntitlementsSettings.toBuilder();
      getEntitlementSettings = settings.getEntitlementSettings.toBuilder();
      createEntitlementSettings = settings.createEntitlementSettings.toBuilder();
      createEntitlementOperationSettings = settings.createEntitlementOperationSettings.toBuilder();
      deleteEntitlementSettings = settings.deleteEntitlementSettings.toBuilder();
      deleteEntitlementOperationSettings = settings.deleteEntitlementOperationSettings.toBuilder();
      updateEntitlementSettings = settings.updateEntitlementSettings.toBuilder();
      updateEntitlementOperationSettings = settings.updateEntitlementOperationSettings.toBuilder();
      listGrantsSettings = settings.listGrantsSettings.toBuilder();
      searchGrantsSettings = settings.searchGrantsSettings.toBuilder();
      getGrantSettings = settings.getGrantSettings.toBuilder();
      createGrantSettings = settings.createGrantSettings.toBuilder();
      approveGrantSettings = settings.approveGrantSettings.toBuilder();
      denyGrantSettings = settings.denyGrantSettings.toBuilder();
      revokeGrantSettings = settings.revokeGrantSettings.toBuilder();
      revokeGrantOperationSettings = settings.revokeGrantOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              checkOnboardingStatusSettings,
              listEntitlementsSettings,
              searchEntitlementsSettings,
              getEntitlementSettings,
              createEntitlementSettings,
              deleteEntitlementSettings,
              updateEntitlementSettings,
              listGrantsSettings,
              searchGrantsSettings,
              getGrantSettings,
              createGrantSettings,
              approveGrantSettings,
              denyGrantSettings,
              revokeGrantSettings,
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
          .checkOnboardingStatusSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listEntitlementsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .searchEntitlementsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getEntitlementSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createEntitlementSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteEntitlementSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateEntitlementSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listGrantsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .searchGrantsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getGrantSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createGrantSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .approveGrantSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .denyGrantSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .revokeGrantSettings()
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
          .createEntitlementOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateEntitlementRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Entitlement.class))
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
                      .setTotalTimeout(Duration.ofMillis(900000L))
                      .build()));

      builder
          .deleteEntitlementOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteEntitlementRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Entitlement.class))
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
                      .setTotalTimeout(Duration.ofMillis(900000L))
                      .build()));

      builder
          .updateEntitlementOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateEntitlementRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Entitlement.class))
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
                      .setTotalTimeout(Duration.ofMillis(900000L))
                      .build()));

      builder
          .revokeGrantOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<RevokeGrantRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Grant.class))
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
                      .setTotalTimeout(Duration.ofMillis(900000L))
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

    /** Returns the builder for the settings used for calls to checkOnboardingStatus. */
    public UnaryCallSettings.Builder<CheckOnboardingStatusRequest, CheckOnboardingStatusResponse>
        checkOnboardingStatusSettings() {
      return checkOnboardingStatusSettings;
    }

    /** Returns the builder for the settings used for calls to listEntitlements. */
    public PagedCallSettings.Builder<
            ListEntitlementsRequest, ListEntitlementsResponse, ListEntitlementsPagedResponse>
        listEntitlementsSettings() {
      return listEntitlementsSettings;
    }

    /** Returns the builder for the settings used for calls to searchEntitlements. */
    public PagedCallSettings.Builder<
            SearchEntitlementsRequest, SearchEntitlementsResponse, SearchEntitlementsPagedResponse>
        searchEntitlementsSettings() {
      return searchEntitlementsSettings;
    }

    /** Returns the builder for the settings used for calls to getEntitlement. */
    public UnaryCallSettings.Builder<GetEntitlementRequest, Entitlement> getEntitlementSettings() {
      return getEntitlementSettings;
    }

    /** Returns the builder for the settings used for calls to createEntitlement. */
    public UnaryCallSettings.Builder<CreateEntitlementRequest, Operation>
        createEntitlementSettings() {
      return createEntitlementSettings;
    }

    /** Returns the builder for the settings used for calls to createEntitlement. */
    public OperationCallSettings.Builder<CreateEntitlementRequest, Entitlement, OperationMetadata>
        createEntitlementOperationSettings() {
      return createEntitlementOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEntitlement. */
    public UnaryCallSettings.Builder<DeleteEntitlementRequest, Operation>
        deleteEntitlementSettings() {
      return deleteEntitlementSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEntitlement. */
    public OperationCallSettings.Builder<DeleteEntitlementRequest, Entitlement, OperationMetadata>
        deleteEntitlementOperationSettings() {
      return deleteEntitlementOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateEntitlement. */
    public UnaryCallSettings.Builder<UpdateEntitlementRequest, Operation>
        updateEntitlementSettings() {
      return updateEntitlementSettings;
    }

    /** Returns the builder for the settings used for calls to updateEntitlement. */
    public OperationCallSettings.Builder<UpdateEntitlementRequest, Entitlement, OperationMetadata>
        updateEntitlementOperationSettings() {
      return updateEntitlementOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listGrants. */
    public PagedCallSettings.Builder<ListGrantsRequest, ListGrantsResponse, ListGrantsPagedResponse>
        listGrantsSettings() {
      return listGrantsSettings;
    }

    /** Returns the builder for the settings used for calls to searchGrants. */
    public PagedCallSettings.Builder<
            SearchGrantsRequest, SearchGrantsResponse, SearchGrantsPagedResponse>
        searchGrantsSettings() {
      return searchGrantsSettings;
    }

    /** Returns the builder for the settings used for calls to getGrant. */
    public UnaryCallSettings.Builder<GetGrantRequest, Grant> getGrantSettings() {
      return getGrantSettings;
    }

    /** Returns the builder for the settings used for calls to createGrant. */
    public UnaryCallSettings.Builder<CreateGrantRequest, Grant> createGrantSettings() {
      return createGrantSettings;
    }

    /** Returns the builder for the settings used for calls to approveGrant. */
    public UnaryCallSettings.Builder<ApproveGrantRequest, Grant> approveGrantSettings() {
      return approveGrantSettings;
    }

    /** Returns the builder for the settings used for calls to denyGrant. */
    public UnaryCallSettings.Builder<DenyGrantRequest, Grant> denyGrantSettings() {
      return denyGrantSettings;
    }

    /** Returns the builder for the settings used for calls to revokeGrant. */
    public UnaryCallSettings.Builder<RevokeGrantRequest, Operation> revokeGrantSettings() {
      return revokeGrantSettings;
    }

    /** Returns the builder for the settings used for calls to revokeGrant. */
    public OperationCallSettings.Builder<RevokeGrantRequest, Grant, OperationMetadata>
        revokeGrantOperationSettings() {
      return revokeGrantOperationSettings;
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
    public PrivilegedAccessManagerStubSettings build() throws IOException {
      return new PrivilegedAccessManagerStubSettings(this);
    }
  }
}
