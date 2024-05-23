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

package com.google.cloud.developerconnect.v1.stub;

import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.FetchGitRefsPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.FetchLinkableGitRepositoriesPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.ListConnectionsPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.ListGitRepositoryLinksPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.ListLocationsPagedResponse;

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
import com.google.cloud.developerconnect.v1.Connection;
import com.google.cloud.developerconnect.v1.CreateConnectionRequest;
import com.google.cloud.developerconnect.v1.CreateGitRepositoryLinkRequest;
import com.google.cloud.developerconnect.v1.DeleteConnectionRequest;
import com.google.cloud.developerconnect.v1.DeleteGitRepositoryLinkRequest;
import com.google.cloud.developerconnect.v1.FetchGitHubInstallationsRequest;
import com.google.cloud.developerconnect.v1.FetchGitHubInstallationsResponse;
import com.google.cloud.developerconnect.v1.FetchGitRefsRequest;
import com.google.cloud.developerconnect.v1.FetchGitRefsResponse;
import com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesRequest;
import com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesResponse;
import com.google.cloud.developerconnect.v1.FetchReadTokenRequest;
import com.google.cloud.developerconnect.v1.FetchReadTokenResponse;
import com.google.cloud.developerconnect.v1.FetchReadWriteTokenRequest;
import com.google.cloud.developerconnect.v1.FetchReadWriteTokenResponse;
import com.google.cloud.developerconnect.v1.GetConnectionRequest;
import com.google.cloud.developerconnect.v1.GetGitRepositoryLinkRequest;
import com.google.cloud.developerconnect.v1.GitRepositoryLink;
import com.google.cloud.developerconnect.v1.LinkableGitRepository;
import com.google.cloud.developerconnect.v1.ListConnectionsRequest;
import com.google.cloud.developerconnect.v1.ListConnectionsResponse;
import com.google.cloud.developerconnect.v1.ListGitRepositoryLinksRequest;
import com.google.cloud.developerconnect.v1.ListGitRepositoryLinksResponse;
import com.google.cloud.developerconnect.v1.OperationMetadata;
import com.google.cloud.developerconnect.v1.UpdateConnectionRequest;
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
 * Settings class to configure an instance of {@link DeveloperConnectStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (developerconnect.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getConnection to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DeveloperConnectStubSettings.Builder developerConnectSettingsBuilder =
 *     DeveloperConnectStubSettings.newBuilder();
 * developerConnectSettingsBuilder
 *     .getConnectionSettings()
 *     .setRetrySettings(
 *         developerConnectSettingsBuilder
 *             .getConnectionSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DeveloperConnectStubSettings developerConnectSettings = developerConnectSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DeveloperConnectStubSettings extends StubSettings<DeveloperConnectStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
      listConnectionsSettings;
  private final UnaryCallSettings<GetConnectionRequest, Connection> getConnectionSettings;
  private final UnaryCallSettings<CreateConnectionRequest, Operation> createConnectionSettings;
  private final OperationCallSettings<CreateConnectionRequest, Connection, OperationMetadata>
      createConnectionOperationSettings;
  private final UnaryCallSettings<UpdateConnectionRequest, Operation> updateConnectionSettings;
  private final OperationCallSettings<UpdateConnectionRequest, Connection, OperationMetadata>
      updateConnectionOperationSettings;
  private final UnaryCallSettings<DeleteConnectionRequest, Operation> deleteConnectionSettings;
  private final OperationCallSettings<DeleteConnectionRequest, Empty, OperationMetadata>
      deleteConnectionOperationSettings;
  private final UnaryCallSettings<CreateGitRepositoryLinkRequest, Operation>
      createGitRepositoryLinkSettings;
  private final OperationCallSettings<
          CreateGitRepositoryLinkRequest, GitRepositoryLink, OperationMetadata>
      createGitRepositoryLinkOperationSettings;
  private final UnaryCallSettings<DeleteGitRepositoryLinkRequest, Operation>
      deleteGitRepositoryLinkSettings;
  private final OperationCallSettings<DeleteGitRepositoryLinkRequest, Empty, OperationMetadata>
      deleteGitRepositoryLinkOperationSettings;
  private final PagedCallSettings<
          ListGitRepositoryLinksRequest,
          ListGitRepositoryLinksResponse,
          ListGitRepositoryLinksPagedResponse>
      listGitRepositoryLinksSettings;
  private final UnaryCallSettings<GetGitRepositoryLinkRequest, GitRepositoryLink>
      getGitRepositoryLinkSettings;
  private final UnaryCallSettings<FetchReadWriteTokenRequest, FetchReadWriteTokenResponse>
      fetchReadWriteTokenSettings;
  private final UnaryCallSettings<FetchReadTokenRequest, FetchReadTokenResponse>
      fetchReadTokenSettings;
  private final PagedCallSettings<
          FetchLinkableGitRepositoriesRequest,
          FetchLinkableGitRepositoriesResponse,
          FetchLinkableGitRepositoriesPagedResponse>
      fetchLinkableGitRepositoriesSettings;
  private final UnaryCallSettings<FetchGitHubInstallationsRequest, FetchGitHubInstallationsResponse>
      fetchGitHubInstallationsSettings;
  private final PagedCallSettings<
          FetchGitRefsRequest, FetchGitRefsResponse, FetchGitRefsPagedResponse>
      fetchGitRefsSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListConnectionsRequest, ListConnectionsResponse, Connection>
      LIST_CONNECTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListConnectionsRequest, ListConnectionsResponse, Connection>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListConnectionsRequest injectToken(
                ListConnectionsRequest payload, String token) {
              return ListConnectionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListConnectionsRequest injectPageSize(
                ListConnectionsRequest payload, int pageSize) {
              return ListConnectionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListConnectionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListConnectionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Connection> extractResources(ListConnectionsResponse payload) {
              return payload.getConnectionsList() == null
                  ? ImmutableList.<Connection>of()
                  : payload.getConnectionsList();
            }
          };

  private static final PagedListDescriptor<
          ListGitRepositoryLinksRequest, ListGitRepositoryLinksResponse, GitRepositoryLink>
      LIST_GIT_REPOSITORY_LINKS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListGitRepositoryLinksRequest, ListGitRepositoryLinksResponse, GitRepositoryLink>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGitRepositoryLinksRequest injectToken(
                ListGitRepositoryLinksRequest payload, String token) {
              return ListGitRepositoryLinksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListGitRepositoryLinksRequest injectPageSize(
                ListGitRepositoryLinksRequest payload, int pageSize) {
              return ListGitRepositoryLinksRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListGitRepositoryLinksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListGitRepositoryLinksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<GitRepositoryLink> extractResources(
                ListGitRepositoryLinksResponse payload) {
              return payload.getGitRepositoryLinksList() == null
                  ? ImmutableList.<GitRepositoryLink>of()
                  : payload.getGitRepositoryLinksList();
            }
          };

  private static final PagedListDescriptor<
          FetchLinkableGitRepositoriesRequest,
          FetchLinkableGitRepositoriesResponse,
          LinkableGitRepository>
      FETCH_LINKABLE_GIT_REPOSITORIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              FetchLinkableGitRepositoriesRequest,
              FetchLinkableGitRepositoriesResponse,
              LinkableGitRepository>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public FetchLinkableGitRepositoriesRequest injectToken(
                FetchLinkableGitRepositoriesRequest payload, String token) {
              return FetchLinkableGitRepositoriesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public FetchLinkableGitRepositoriesRequest injectPageSize(
                FetchLinkableGitRepositoriesRequest payload, int pageSize) {
              return FetchLinkableGitRepositoriesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(FetchLinkableGitRepositoriesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(FetchLinkableGitRepositoriesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LinkableGitRepository> extractResources(
                FetchLinkableGitRepositoriesResponse payload) {
              return payload.getLinkableGitRepositoriesList() == null
                  ? ImmutableList.<LinkableGitRepository>of()
                  : payload.getLinkableGitRepositoriesList();
            }
          };

  private static final PagedListDescriptor<FetchGitRefsRequest, FetchGitRefsResponse, String>
      FETCH_GIT_REFS_PAGE_STR_DESC =
          new PagedListDescriptor<FetchGitRefsRequest, FetchGitRefsResponse, String>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public FetchGitRefsRequest injectToken(FetchGitRefsRequest payload, String token) {
              return FetchGitRefsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public FetchGitRefsRequest injectPageSize(FetchGitRefsRequest payload, int pageSize) {
              return FetchGitRefsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(FetchGitRefsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(FetchGitRefsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<String> extractResources(FetchGitRefsResponse payload) {
              return payload.getRefNamesList() == null
                  ? ImmutableList.<String>of()
                  : payload.getRefNamesList();
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
          ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
      LIST_CONNECTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>() {
            @Override
            public ApiFuture<ListConnectionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListConnectionsRequest, ListConnectionsResponse> callable,
                ListConnectionsRequest request,
                ApiCallContext context,
                ApiFuture<ListConnectionsResponse> futureResponse) {
              PageContext<ListConnectionsRequest, ListConnectionsResponse, Connection> pageContext =
                  PageContext.create(callable, LIST_CONNECTIONS_PAGE_STR_DESC, request, context);
              return ListConnectionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListGitRepositoryLinksRequest,
          ListGitRepositoryLinksResponse,
          ListGitRepositoryLinksPagedResponse>
      LIST_GIT_REPOSITORY_LINKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGitRepositoryLinksRequest,
              ListGitRepositoryLinksResponse,
              ListGitRepositoryLinksPagedResponse>() {
            @Override
            public ApiFuture<ListGitRepositoryLinksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGitRepositoryLinksRequest, ListGitRepositoryLinksResponse>
                    callable,
                ListGitRepositoryLinksRequest request,
                ApiCallContext context,
                ApiFuture<ListGitRepositoryLinksResponse> futureResponse) {
              PageContext<
                      ListGitRepositoryLinksRequest,
                      ListGitRepositoryLinksResponse,
                      GitRepositoryLink>
                  pageContext =
                      PageContext.create(
                          callable, LIST_GIT_REPOSITORY_LINKS_PAGE_STR_DESC, request, context);
              return ListGitRepositoryLinksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          FetchLinkableGitRepositoriesRequest,
          FetchLinkableGitRepositoriesResponse,
          FetchLinkableGitRepositoriesPagedResponse>
      FETCH_LINKABLE_GIT_REPOSITORIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              FetchLinkableGitRepositoriesRequest,
              FetchLinkableGitRepositoriesResponse,
              FetchLinkableGitRepositoriesPagedResponse>() {
            @Override
            public ApiFuture<FetchLinkableGitRepositoriesPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        FetchLinkableGitRepositoriesRequest, FetchLinkableGitRepositoriesResponse>
                    callable,
                FetchLinkableGitRepositoriesRequest request,
                ApiCallContext context,
                ApiFuture<FetchLinkableGitRepositoriesResponse> futureResponse) {
              PageContext<
                      FetchLinkableGitRepositoriesRequest,
                      FetchLinkableGitRepositoriesResponse,
                      LinkableGitRepository>
                  pageContext =
                      PageContext.create(
                          callable,
                          FETCH_LINKABLE_GIT_REPOSITORIES_PAGE_STR_DESC,
                          request,
                          context);
              return FetchLinkableGitRepositoriesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          FetchGitRefsRequest, FetchGitRefsResponse, FetchGitRefsPagedResponse>
      FETCH_GIT_REFS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              FetchGitRefsRequest, FetchGitRefsResponse, FetchGitRefsPagedResponse>() {
            @Override
            public ApiFuture<FetchGitRefsPagedResponse> getFuturePagedResponse(
                UnaryCallable<FetchGitRefsRequest, FetchGitRefsResponse> callable,
                FetchGitRefsRequest request,
                ApiCallContext context,
                ApiFuture<FetchGitRefsResponse> futureResponse) {
              PageContext<FetchGitRefsRequest, FetchGitRefsResponse, String> pageContext =
                  PageContext.create(callable, FETCH_GIT_REFS_PAGE_STR_DESC, request, context);
              return FetchGitRefsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listConnections. */
  public PagedCallSettings<
          ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
      listConnectionsSettings() {
    return listConnectionsSettings;
  }

  /** Returns the object with the settings used for calls to getConnection. */
  public UnaryCallSettings<GetConnectionRequest, Connection> getConnectionSettings() {
    return getConnectionSettings;
  }

  /** Returns the object with the settings used for calls to createConnection. */
  public UnaryCallSettings<CreateConnectionRequest, Operation> createConnectionSettings() {
    return createConnectionSettings;
  }

  /** Returns the object with the settings used for calls to createConnection. */
  public OperationCallSettings<CreateConnectionRequest, Connection, OperationMetadata>
      createConnectionOperationSettings() {
    return createConnectionOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateConnection. */
  public UnaryCallSettings<UpdateConnectionRequest, Operation> updateConnectionSettings() {
    return updateConnectionSettings;
  }

  /** Returns the object with the settings used for calls to updateConnection. */
  public OperationCallSettings<UpdateConnectionRequest, Connection, OperationMetadata>
      updateConnectionOperationSettings() {
    return updateConnectionOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteConnection. */
  public UnaryCallSettings<DeleteConnectionRequest, Operation> deleteConnectionSettings() {
    return deleteConnectionSettings;
  }

  /** Returns the object with the settings used for calls to deleteConnection. */
  public OperationCallSettings<DeleteConnectionRequest, Empty, OperationMetadata>
      deleteConnectionOperationSettings() {
    return deleteConnectionOperationSettings;
  }

  /** Returns the object with the settings used for calls to createGitRepositoryLink. */
  public UnaryCallSettings<CreateGitRepositoryLinkRequest, Operation>
      createGitRepositoryLinkSettings() {
    return createGitRepositoryLinkSettings;
  }

  /** Returns the object with the settings used for calls to createGitRepositoryLink. */
  public OperationCallSettings<CreateGitRepositoryLinkRequest, GitRepositoryLink, OperationMetadata>
      createGitRepositoryLinkOperationSettings() {
    return createGitRepositoryLinkOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteGitRepositoryLink. */
  public UnaryCallSettings<DeleteGitRepositoryLinkRequest, Operation>
      deleteGitRepositoryLinkSettings() {
    return deleteGitRepositoryLinkSettings;
  }

  /** Returns the object with the settings used for calls to deleteGitRepositoryLink. */
  public OperationCallSettings<DeleteGitRepositoryLinkRequest, Empty, OperationMetadata>
      deleteGitRepositoryLinkOperationSettings() {
    return deleteGitRepositoryLinkOperationSettings;
  }

  /** Returns the object with the settings used for calls to listGitRepositoryLinks. */
  public PagedCallSettings<
          ListGitRepositoryLinksRequest,
          ListGitRepositoryLinksResponse,
          ListGitRepositoryLinksPagedResponse>
      listGitRepositoryLinksSettings() {
    return listGitRepositoryLinksSettings;
  }

  /** Returns the object with the settings used for calls to getGitRepositoryLink. */
  public UnaryCallSettings<GetGitRepositoryLinkRequest, GitRepositoryLink>
      getGitRepositoryLinkSettings() {
    return getGitRepositoryLinkSettings;
  }

  /** Returns the object with the settings used for calls to fetchReadWriteToken. */
  public UnaryCallSettings<FetchReadWriteTokenRequest, FetchReadWriteTokenResponse>
      fetchReadWriteTokenSettings() {
    return fetchReadWriteTokenSettings;
  }

  /** Returns the object with the settings used for calls to fetchReadToken. */
  public UnaryCallSettings<FetchReadTokenRequest, FetchReadTokenResponse> fetchReadTokenSettings() {
    return fetchReadTokenSettings;
  }

  /** Returns the object with the settings used for calls to fetchLinkableGitRepositories. */
  public PagedCallSettings<
          FetchLinkableGitRepositoriesRequest,
          FetchLinkableGitRepositoriesResponse,
          FetchLinkableGitRepositoriesPagedResponse>
      fetchLinkableGitRepositoriesSettings() {
    return fetchLinkableGitRepositoriesSettings;
  }

  /** Returns the object with the settings used for calls to fetchGitHubInstallations. */
  public UnaryCallSettings<FetchGitHubInstallationsRequest, FetchGitHubInstallationsResponse>
      fetchGitHubInstallationsSettings() {
    return fetchGitHubInstallationsSettings;
  }

  /** Returns the object with the settings used for calls to fetchGitRefs. */
  public PagedCallSettings<FetchGitRefsRequest, FetchGitRefsResponse, FetchGitRefsPagedResponse>
      fetchGitRefsSettings() {
    return fetchGitRefsSettings;
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

  public DeveloperConnectStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDeveloperConnectStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDeveloperConnectStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "developerconnect";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "developerconnect.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "developerconnect.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(DeveloperConnectStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DeveloperConnectStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DeveloperConnectStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DeveloperConnectStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listConnectionsSettings = settingsBuilder.listConnectionsSettings().build();
    getConnectionSettings = settingsBuilder.getConnectionSettings().build();
    createConnectionSettings = settingsBuilder.createConnectionSettings().build();
    createConnectionOperationSettings = settingsBuilder.createConnectionOperationSettings().build();
    updateConnectionSettings = settingsBuilder.updateConnectionSettings().build();
    updateConnectionOperationSettings = settingsBuilder.updateConnectionOperationSettings().build();
    deleteConnectionSettings = settingsBuilder.deleteConnectionSettings().build();
    deleteConnectionOperationSettings = settingsBuilder.deleteConnectionOperationSettings().build();
    createGitRepositoryLinkSettings = settingsBuilder.createGitRepositoryLinkSettings().build();
    createGitRepositoryLinkOperationSettings =
        settingsBuilder.createGitRepositoryLinkOperationSettings().build();
    deleteGitRepositoryLinkSettings = settingsBuilder.deleteGitRepositoryLinkSettings().build();
    deleteGitRepositoryLinkOperationSettings =
        settingsBuilder.deleteGitRepositoryLinkOperationSettings().build();
    listGitRepositoryLinksSettings = settingsBuilder.listGitRepositoryLinksSettings().build();
    getGitRepositoryLinkSettings = settingsBuilder.getGitRepositoryLinkSettings().build();
    fetchReadWriteTokenSettings = settingsBuilder.fetchReadWriteTokenSettings().build();
    fetchReadTokenSettings = settingsBuilder.fetchReadTokenSettings().build();
    fetchLinkableGitRepositoriesSettings =
        settingsBuilder.fetchLinkableGitRepositoriesSettings().build();
    fetchGitHubInstallationsSettings = settingsBuilder.fetchGitHubInstallationsSettings().build();
    fetchGitRefsSettings = settingsBuilder.fetchGitRefsSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for DeveloperConnectStubSettings. */
  public static class Builder extends StubSettings.Builder<DeveloperConnectStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
        listConnectionsSettings;
    private final UnaryCallSettings.Builder<GetConnectionRequest, Connection> getConnectionSettings;
    private final UnaryCallSettings.Builder<CreateConnectionRequest, Operation>
        createConnectionSettings;
    private final OperationCallSettings.Builder<
            CreateConnectionRequest, Connection, OperationMetadata>
        createConnectionOperationSettings;
    private final UnaryCallSettings.Builder<UpdateConnectionRequest, Operation>
        updateConnectionSettings;
    private final OperationCallSettings.Builder<
            UpdateConnectionRequest, Connection, OperationMetadata>
        updateConnectionOperationSettings;
    private final UnaryCallSettings.Builder<DeleteConnectionRequest, Operation>
        deleteConnectionSettings;
    private final OperationCallSettings.Builder<DeleteConnectionRequest, Empty, OperationMetadata>
        deleteConnectionOperationSettings;
    private final UnaryCallSettings.Builder<CreateGitRepositoryLinkRequest, Operation>
        createGitRepositoryLinkSettings;
    private final OperationCallSettings.Builder<
            CreateGitRepositoryLinkRequest, GitRepositoryLink, OperationMetadata>
        createGitRepositoryLinkOperationSettings;
    private final UnaryCallSettings.Builder<DeleteGitRepositoryLinkRequest, Operation>
        deleteGitRepositoryLinkSettings;
    private final OperationCallSettings.Builder<
            DeleteGitRepositoryLinkRequest, Empty, OperationMetadata>
        deleteGitRepositoryLinkOperationSettings;
    private final PagedCallSettings.Builder<
            ListGitRepositoryLinksRequest,
            ListGitRepositoryLinksResponse,
            ListGitRepositoryLinksPagedResponse>
        listGitRepositoryLinksSettings;
    private final UnaryCallSettings.Builder<GetGitRepositoryLinkRequest, GitRepositoryLink>
        getGitRepositoryLinkSettings;
    private final UnaryCallSettings.Builder<FetchReadWriteTokenRequest, FetchReadWriteTokenResponse>
        fetchReadWriteTokenSettings;
    private final UnaryCallSettings.Builder<FetchReadTokenRequest, FetchReadTokenResponse>
        fetchReadTokenSettings;
    private final PagedCallSettings.Builder<
            FetchLinkableGitRepositoriesRequest,
            FetchLinkableGitRepositoriesResponse,
            FetchLinkableGitRepositoriesPagedResponse>
        fetchLinkableGitRepositoriesSettings;
    private final UnaryCallSettings.Builder<
            FetchGitHubInstallationsRequest, FetchGitHubInstallationsResponse>
        fetchGitHubInstallationsSettings;
    private final PagedCallSettings.Builder<
            FetchGitRefsRequest, FetchGitRefsResponse, FetchGitRefsPagedResponse>
        fetchGitRefsSettings;
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
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listConnectionsSettings = PagedCallSettings.newBuilder(LIST_CONNECTIONS_PAGE_STR_FACT);
      getConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createConnectionOperationSettings = OperationCallSettings.newBuilder();
      updateConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateConnectionOperationSettings = OperationCallSettings.newBuilder();
      deleteConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteConnectionOperationSettings = OperationCallSettings.newBuilder();
      createGitRepositoryLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGitRepositoryLinkOperationSettings = OperationCallSettings.newBuilder();
      deleteGitRepositoryLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteGitRepositoryLinkOperationSettings = OperationCallSettings.newBuilder();
      listGitRepositoryLinksSettings =
          PagedCallSettings.newBuilder(LIST_GIT_REPOSITORY_LINKS_PAGE_STR_FACT);
      getGitRepositoryLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      fetchReadWriteTokenSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      fetchReadTokenSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      fetchLinkableGitRepositoriesSettings =
          PagedCallSettings.newBuilder(FETCH_LINKABLE_GIT_REPOSITORIES_PAGE_STR_FACT);
      fetchGitHubInstallationsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      fetchGitRefsSettings = PagedCallSettings.newBuilder(FETCH_GIT_REFS_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listConnectionsSettings,
              getConnectionSettings,
              createConnectionSettings,
              updateConnectionSettings,
              deleteConnectionSettings,
              createGitRepositoryLinkSettings,
              deleteGitRepositoryLinkSettings,
              listGitRepositoryLinksSettings,
              getGitRepositoryLinkSettings,
              fetchReadWriteTokenSettings,
              fetchReadTokenSettings,
              fetchLinkableGitRepositoriesSettings,
              fetchGitHubInstallationsSettings,
              fetchGitRefsSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(DeveloperConnectStubSettings settings) {
      super(settings);

      listConnectionsSettings = settings.listConnectionsSettings.toBuilder();
      getConnectionSettings = settings.getConnectionSettings.toBuilder();
      createConnectionSettings = settings.createConnectionSettings.toBuilder();
      createConnectionOperationSettings = settings.createConnectionOperationSettings.toBuilder();
      updateConnectionSettings = settings.updateConnectionSettings.toBuilder();
      updateConnectionOperationSettings = settings.updateConnectionOperationSettings.toBuilder();
      deleteConnectionSettings = settings.deleteConnectionSettings.toBuilder();
      deleteConnectionOperationSettings = settings.deleteConnectionOperationSettings.toBuilder();
      createGitRepositoryLinkSettings = settings.createGitRepositoryLinkSettings.toBuilder();
      createGitRepositoryLinkOperationSettings =
          settings.createGitRepositoryLinkOperationSettings.toBuilder();
      deleteGitRepositoryLinkSettings = settings.deleteGitRepositoryLinkSettings.toBuilder();
      deleteGitRepositoryLinkOperationSettings =
          settings.deleteGitRepositoryLinkOperationSettings.toBuilder();
      listGitRepositoryLinksSettings = settings.listGitRepositoryLinksSettings.toBuilder();
      getGitRepositoryLinkSettings = settings.getGitRepositoryLinkSettings.toBuilder();
      fetchReadWriteTokenSettings = settings.fetchReadWriteTokenSettings.toBuilder();
      fetchReadTokenSettings = settings.fetchReadTokenSettings.toBuilder();
      fetchLinkableGitRepositoriesSettings =
          settings.fetchLinkableGitRepositoriesSettings.toBuilder();
      fetchGitHubInstallationsSettings = settings.fetchGitHubInstallationsSettings.toBuilder();
      fetchGitRefsSettings = settings.fetchGitRefsSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listConnectionsSettings,
              getConnectionSettings,
              createConnectionSettings,
              updateConnectionSettings,
              deleteConnectionSettings,
              createGitRepositoryLinkSettings,
              deleteGitRepositoryLinkSettings,
              listGitRepositoryLinksSettings,
              getGitRepositoryLinkSettings,
              fetchReadWriteTokenSettings,
              fetchReadTokenSettings,
              fetchLinkableGitRepositoriesSettings,
              fetchGitHubInstallationsSettings,
              fetchGitRefsSettings,
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
          .listConnectionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createGitRepositoryLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteGitRepositoryLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listGitRepositoryLinksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getGitRepositoryLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .fetchReadWriteTokenSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .fetchReadTokenSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .fetchLinkableGitRepositoriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .fetchGitHubInstallationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .fetchGitRefsSettings()
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
          .createConnectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateConnectionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Connection.class))
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
          .updateConnectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateConnectionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Connection.class))
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
          .deleteConnectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteConnectionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createGitRepositoryLinkOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateGitRepositoryLinkRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(GitRepositoryLink.class))
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
          .deleteGitRepositoryLinkOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteGitRepositoryLinkRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to listConnections. */
    public PagedCallSettings.Builder<
            ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
        listConnectionsSettings() {
      return listConnectionsSettings;
    }

    /** Returns the builder for the settings used for calls to getConnection. */
    public UnaryCallSettings.Builder<GetConnectionRequest, Connection> getConnectionSettings() {
      return getConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to createConnection. */
    public UnaryCallSettings.Builder<CreateConnectionRequest, Operation>
        createConnectionSettings() {
      return createConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to createConnection. */
    public OperationCallSettings.Builder<CreateConnectionRequest, Connection, OperationMetadata>
        createConnectionOperationSettings() {
      return createConnectionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateConnection. */
    public UnaryCallSettings.Builder<UpdateConnectionRequest, Operation>
        updateConnectionSettings() {
      return updateConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to updateConnection. */
    public OperationCallSettings.Builder<UpdateConnectionRequest, Connection, OperationMetadata>
        updateConnectionOperationSettings() {
      return updateConnectionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConnection. */
    public UnaryCallSettings.Builder<DeleteConnectionRequest, Operation>
        deleteConnectionSettings() {
      return deleteConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConnection. */
    public OperationCallSettings.Builder<DeleteConnectionRequest, Empty, OperationMetadata>
        deleteConnectionOperationSettings() {
      return deleteConnectionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createGitRepositoryLink. */
    public UnaryCallSettings.Builder<CreateGitRepositoryLinkRequest, Operation>
        createGitRepositoryLinkSettings() {
      return createGitRepositoryLinkSettings;
    }

    /** Returns the builder for the settings used for calls to createGitRepositoryLink. */
    public OperationCallSettings.Builder<
            CreateGitRepositoryLinkRequest, GitRepositoryLink, OperationMetadata>
        createGitRepositoryLinkOperationSettings() {
      return createGitRepositoryLinkOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGitRepositoryLink. */
    public UnaryCallSettings.Builder<DeleteGitRepositoryLinkRequest, Operation>
        deleteGitRepositoryLinkSettings() {
      return deleteGitRepositoryLinkSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGitRepositoryLink. */
    public OperationCallSettings.Builder<DeleteGitRepositoryLinkRequest, Empty, OperationMetadata>
        deleteGitRepositoryLinkOperationSettings() {
      return deleteGitRepositoryLinkOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listGitRepositoryLinks. */
    public PagedCallSettings.Builder<
            ListGitRepositoryLinksRequest,
            ListGitRepositoryLinksResponse,
            ListGitRepositoryLinksPagedResponse>
        listGitRepositoryLinksSettings() {
      return listGitRepositoryLinksSettings;
    }

    /** Returns the builder for the settings used for calls to getGitRepositoryLink. */
    public UnaryCallSettings.Builder<GetGitRepositoryLinkRequest, GitRepositoryLink>
        getGitRepositoryLinkSettings() {
      return getGitRepositoryLinkSettings;
    }

    /** Returns the builder for the settings used for calls to fetchReadWriteToken. */
    public UnaryCallSettings.Builder<FetchReadWriteTokenRequest, FetchReadWriteTokenResponse>
        fetchReadWriteTokenSettings() {
      return fetchReadWriteTokenSettings;
    }

    /** Returns the builder for the settings used for calls to fetchReadToken. */
    public UnaryCallSettings.Builder<FetchReadTokenRequest, FetchReadTokenResponse>
        fetchReadTokenSettings() {
      return fetchReadTokenSettings;
    }

    /** Returns the builder for the settings used for calls to fetchLinkableGitRepositories. */
    public PagedCallSettings.Builder<
            FetchLinkableGitRepositoriesRequest,
            FetchLinkableGitRepositoriesResponse,
            FetchLinkableGitRepositoriesPagedResponse>
        fetchLinkableGitRepositoriesSettings() {
      return fetchLinkableGitRepositoriesSettings;
    }

    /** Returns the builder for the settings used for calls to fetchGitHubInstallations. */
    public UnaryCallSettings.Builder<
            FetchGitHubInstallationsRequest, FetchGitHubInstallationsResponse>
        fetchGitHubInstallationsSettings() {
      return fetchGitHubInstallationsSettings;
    }

    /** Returns the builder for the settings used for calls to fetchGitRefs. */
    public PagedCallSettings.Builder<
            FetchGitRefsRequest, FetchGitRefsResponse, FetchGitRefsPagedResponse>
        fetchGitRefsSettings() {
      return fetchGitRefsSettings;
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
    public DeveloperConnectStubSettings build() throws IOException {
      return new DeveloperConnectStubSettings(this);
    }
  }
}
