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

package com.google.cloud.devtools.cloudbuild.v2.stub;

import static com.google.cloud.devtools.cloudbuild.v2.RepositoryManagerClient.FetchLinkableRepositoriesPagedResponse;
import static com.google.cloud.devtools.cloudbuild.v2.RepositoryManagerClient.ListConnectionsPagedResponse;
import static com.google.cloud.devtools.cloudbuild.v2.RepositoryManagerClient.ListRepositoriesPagedResponse;

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
import com.google.cloudbuild.v2.BatchCreateRepositoriesRequest;
import com.google.cloudbuild.v2.BatchCreateRepositoriesResponse;
import com.google.cloudbuild.v2.Connection;
import com.google.cloudbuild.v2.CreateConnectionRequest;
import com.google.cloudbuild.v2.CreateRepositoryRequest;
import com.google.cloudbuild.v2.DeleteConnectionRequest;
import com.google.cloudbuild.v2.DeleteRepositoryRequest;
import com.google.cloudbuild.v2.FetchGitRefsRequest;
import com.google.cloudbuild.v2.FetchGitRefsResponse;
import com.google.cloudbuild.v2.FetchLinkableRepositoriesRequest;
import com.google.cloudbuild.v2.FetchLinkableRepositoriesResponse;
import com.google.cloudbuild.v2.FetchReadTokenRequest;
import com.google.cloudbuild.v2.FetchReadTokenResponse;
import com.google.cloudbuild.v2.FetchReadWriteTokenRequest;
import com.google.cloudbuild.v2.FetchReadWriteTokenResponse;
import com.google.cloudbuild.v2.GetConnectionRequest;
import com.google.cloudbuild.v2.GetRepositoryRequest;
import com.google.cloudbuild.v2.ListConnectionsRequest;
import com.google.cloudbuild.v2.ListConnectionsResponse;
import com.google.cloudbuild.v2.ListRepositoriesRequest;
import com.google.cloudbuild.v2.ListRepositoriesResponse;
import com.google.cloudbuild.v2.OperationMetadata;
import com.google.cloudbuild.v2.Repository;
import com.google.cloudbuild.v2.UpdateConnectionRequest;
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
 * Settings class to configure an instance of {@link RepositoryManagerStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudbuild.googleapis.com) and default port (443) are used.
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
 * RepositoryManagerStubSettings.Builder repositoryManagerSettingsBuilder =
 *     RepositoryManagerStubSettings.newBuilder();
 * repositoryManagerSettingsBuilder
 *     .getConnectionSettings()
 *     .setRetrySettings(
 *         repositoryManagerSettingsBuilder
 *             .getConnectionSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RepositoryManagerStubSettings repositoryManagerSettings =
 *     repositoryManagerSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RepositoryManagerStubSettings extends StubSettings<RepositoryManagerStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateConnectionRequest, Operation> createConnectionSettings;
  private final OperationCallSettings<CreateConnectionRequest, Connection, OperationMetadata>
      createConnectionOperationSettings;
  private final UnaryCallSettings<GetConnectionRequest, Connection> getConnectionSettings;
  private final PagedCallSettings<
          ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
      listConnectionsSettings;
  private final UnaryCallSettings<UpdateConnectionRequest, Operation> updateConnectionSettings;
  private final OperationCallSettings<UpdateConnectionRequest, Connection, OperationMetadata>
      updateConnectionOperationSettings;
  private final UnaryCallSettings<DeleteConnectionRequest, Operation> deleteConnectionSettings;
  private final OperationCallSettings<DeleteConnectionRequest, Empty, OperationMetadata>
      deleteConnectionOperationSettings;
  private final UnaryCallSettings<CreateRepositoryRequest, Operation> createRepositorySettings;
  private final OperationCallSettings<CreateRepositoryRequest, Repository, OperationMetadata>
      createRepositoryOperationSettings;
  private final UnaryCallSettings<BatchCreateRepositoriesRequest, Operation>
      batchCreateRepositoriesSettings;
  private final OperationCallSettings<
          BatchCreateRepositoriesRequest, BatchCreateRepositoriesResponse, OperationMetadata>
      batchCreateRepositoriesOperationSettings;
  private final UnaryCallSettings<GetRepositoryRequest, Repository> getRepositorySettings;
  private final PagedCallSettings<
          ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>
      listRepositoriesSettings;
  private final UnaryCallSettings<DeleteRepositoryRequest, Operation> deleteRepositorySettings;
  private final OperationCallSettings<DeleteRepositoryRequest, Empty, OperationMetadata>
      deleteRepositoryOperationSettings;
  private final UnaryCallSettings<FetchReadWriteTokenRequest, FetchReadWriteTokenResponse>
      fetchReadWriteTokenSettings;
  private final UnaryCallSettings<FetchReadTokenRequest, FetchReadTokenResponse>
      fetchReadTokenSettings;
  private final PagedCallSettings<
          FetchLinkableRepositoriesRequest,
          FetchLinkableRepositoriesResponse,
          FetchLinkableRepositoriesPagedResponse>
      fetchLinkableRepositoriesSettings;
  private final UnaryCallSettings<FetchGitRefsRequest, FetchGitRefsResponse> fetchGitRefsSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

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
          ListRepositoriesRequest, ListRepositoriesResponse, Repository>
      LIST_REPOSITORIES_PAGE_STR_DESC =
          new PagedListDescriptor<ListRepositoriesRequest, ListRepositoriesResponse, Repository>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRepositoriesRequest injectToken(
                ListRepositoriesRequest payload, String token) {
              return ListRepositoriesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRepositoriesRequest injectPageSize(
                ListRepositoriesRequest payload, int pageSize) {
              return ListRepositoriesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRepositoriesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRepositoriesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Repository> extractResources(ListRepositoriesResponse payload) {
              return payload.getRepositoriesList() == null
                  ? ImmutableList.<Repository>of()
                  : payload.getRepositoriesList();
            }
          };

  private static final PagedListDescriptor<
          FetchLinkableRepositoriesRequest, FetchLinkableRepositoriesResponse, Repository>
      FETCH_LINKABLE_REPOSITORIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              FetchLinkableRepositoriesRequest, FetchLinkableRepositoriesResponse, Repository>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public FetchLinkableRepositoriesRequest injectToken(
                FetchLinkableRepositoriesRequest payload, String token) {
              return FetchLinkableRepositoriesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public FetchLinkableRepositoriesRequest injectPageSize(
                FetchLinkableRepositoriesRequest payload, int pageSize) {
              return FetchLinkableRepositoriesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(FetchLinkableRepositoriesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(FetchLinkableRepositoriesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Repository> extractResources(
                FetchLinkableRepositoriesResponse payload) {
              return payload.getRepositoriesList() == null
                  ? ImmutableList.<Repository>of()
                  : payload.getRepositoriesList();
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
          ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>
      LIST_REPOSITORIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>() {
            @Override
            public ApiFuture<ListRepositoriesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRepositoriesRequest, ListRepositoriesResponse> callable,
                ListRepositoriesRequest request,
                ApiCallContext context,
                ApiFuture<ListRepositoriesResponse> futureResponse) {
              PageContext<ListRepositoriesRequest, ListRepositoriesResponse, Repository>
                  pageContext =
                      PageContext.create(
                          callable, LIST_REPOSITORIES_PAGE_STR_DESC, request, context);
              return ListRepositoriesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          FetchLinkableRepositoriesRequest,
          FetchLinkableRepositoriesResponse,
          FetchLinkableRepositoriesPagedResponse>
      FETCH_LINKABLE_REPOSITORIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              FetchLinkableRepositoriesRequest,
              FetchLinkableRepositoriesResponse,
              FetchLinkableRepositoriesPagedResponse>() {
            @Override
            public ApiFuture<FetchLinkableRepositoriesPagedResponse> getFuturePagedResponse(
                UnaryCallable<FetchLinkableRepositoriesRequest, FetchLinkableRepositoriesResponse>
                    callable,
                FetchLinkableRepositoriesRequest request,
                ApiCallContext context,
                ApiFuture<FetchLinkableRepositoriesResponse> futureResponse) {
              PageContext<
                      FetchLinkableRepositoriesRequest,
                      FetchLinkableRepositoriesResponse,
                      Repository>
                  pageContext =
                      PageContext.create(
                          callable, FETCH_LINKABLE_REPOSITORIES_PAGE_STR_DESC, request, context);
              return FetchLinkableRepositoriesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createConnection. */
  public UnaryCallSettings<CreateConnectionRequest, Operation> createConnectionSettings() {
    return createConnectionSettings;
  }

  /** Returns the object with the settings used for calls to createConnection. */
  public OperationCallSettings<CreateConnectionRequest, Connection, OperationMetadata>
      createConnectionOperationSettings() {
    return createConnectionOperationSettings;
  }

  /** Returns the object with the settings used for calls to getConnection. */
  public UnaryCallSettings<GetConnectionRequest, Connection> getConnectionSettings() {
    return getConnectionSettings;
  }

  /** Returns the object with the settings used for calls to listConnections. */
  public PagedCallSettings<
          ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
      listConnectionsSettings() {
    return listConnectionsSettings;
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

  /** Returns the object with the settings used for calls to createRepository. */
  public UnaryCallSettings<CreateRepositoryRequest, Operation> createRepositorySettings() {
    return createRepositorySettings;
  }

  /** Returns the object with the settings used for calls to createRepository. */
  public OperationCallSettings<CreateRepositoryRequest, Repository, OperationMetadata>
      createRepositoryOperationSettings() {
    return createRepositoryOperationSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateRepositories. */
  public UnaryCallSettings<BatchCreateRepositoriesRequest, Operation>
      batchCreateRepositoriesSettings() {
    return batchCreateRepositoriesSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateRepositories. */
  public OperationCallSettings<
          BatchCreateRepositoriesRequest, BatchCreateRepositoriesResponse, OperationMetadata>
      batchCreateRepositoriesOperationSettings() {
    return batchCreateRepositoriesOperationSettings;
  }

  /** Returns the object with the settings used for calls to getRepository. */
  public UnaryCallSettings<GetRepositoryRequest, Repository> getRepositorySettings() {
    return getRepositorySettings;
  }

  /** Returns the object with the settings used for calls to listRepositories. */
  public PagedCallSettings<
          ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>
      listRepositoriesSettings() {
    return listRepositoriesSettings;
  }

  /** Returns the object with the settings used for calls to deleteRepository. */
  public UnaryCallSettings<DeleteRepositoryRequest, Operation> deleteRepositorySettings() {
    return deleteRepositorySettings;
  }

  /** Returns the object with the settings used for calls to deleteRepository. */
  public OperationCallSettings<DeleteRepositoryRequest, Empty, OperationMetadata>
      deleteRepositoryOperationSettings() {
    return deleteRepositoryOperationSettings;
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

  /** Returns the object with the settings used for calls to fetchLinkableRepositories. */
  public PagedCallSettings<
          FetchLinkableRepositoriesRequest,
          FetchLinkableRepositoriesResponse,
          FetchLinkableRepositoriesPagedResponse>
      fetchLinkableRepositoriesSettings() {
    return fetchLinkableRepositoriesSettings;
  }

  /** Returns the object with the settings used for calls to fetchGitRefs. */
  public UnaryCallSettings<FetchGitRefsRequest, FetchGitRefsResponse> fetchGitRefsSettings() {
    return fetchGitRefsSettings;
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

  public RepositoryManagerStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcRepositoryManagerStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonRepositoryManagerStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "cloudbuild";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "cloudbuild.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "cloudbuild.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(RepositoryManagerStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(RepositoryManagerStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RepositoryManagerStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected RepositoryManagerStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createConnectionSettings = settingsBuilder.createConnectionSettings().build();
    createConnectionOperationSettings = settingsBuilder.createConnectionOperationSettings().build();
    getConnectionSettings = settingsBuilder.getConnectionSettings().build();
    listConnectionsSettings = settingsBuilder.listConnectionsSettings().build();
    updateConnectionSettings = settingsBuilder.updateConnectionSettings().build();
    updateConnectionOperationSettings = settingsBuilder.updateConnectionOperationSettings().build();
    deleteConnectionSettings = settingsBuilder.deleteConnectionSettings().build();
    deleteConnectionOperationSettings = settingsBuilder.deleteConnectionOperationSettings().build();
    createRepositorySettings = settingsBuilder.createRepositorySettings().build();
    createRepositoryOperationSettings = settingsBuilder.createRepositoryOperationSettings().build();
    batchCreateRepositoriesSettings = settingsBuilder.batchCreateRepositoriesSettings().build();
    batchCreateRepositoriesOperationSettings =
        settingsBuilder.batchCreateRepositoriesOperationSettings().build();
    getRepositorySettings = settingsBuilder.getRepositorySettings().build();
    listRepositoriesSettings = settingsBuilder.listRepositoriesSettings().build();
    deleteRepositorySettings = settingsBuilder.deleteRepositorySettings().build();
    deleteRepositoryOperationSettings = settingsBuilder.deleteRepositoryOperationSettings().build();
    fetchReadWriteTokenSettings = settingsBuilder.fetchReadWriteTokenSettings().build();
    fetchReadTokenSettings = settingsBuilder.fetchReadTokenSettings().build();
    fetchLinkableRepositoriesSettings = settingsBuilder.fetchLinkableRepositoriesSettings().build();
    fetchGitRefsSettings = settingsBuilder.fetchGitRefsSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for RepositoryManagerStubSettings. */
  public static class Builder extends StubSettings.Builder<RepositoryManagerStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateConnectionRequest, Operation>
        createConnectionSettings;
    private final OperationCallSettings.Builder<
            CreateConnectionRequest, Connection, OperationMetadata>
        createConnectionOperationSettings;
    private final UnaryCallSettings.Builder<GetConnectionRequest, Connection> getConnectionSettings;
    private final PagedCallSettings.Builder<
            ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
        listConnectionsSettings;
    private final UnaryCallSettings.Builder<UpdateConnectionRequest, Operation>
        updateConnectionSettings;
    private final OperationCallSettings.Builder<
            UpdateConnectionRequest, Connection, OperationMetadata>
        updateConnectionOperationSettings;
    private final UnaryCallSettings.Builder<DeleteConnectionRequest, Operation>
        deleteConnectionSettings;
    private final OperationCallSettings.Builder<DeleteConnectionRequest, Empty, OperationMetadata>
        deleteConnectionOperationSettings;
    private final UnaryCallSettings.Builder<CreateRepositoryRequest, Operation>
        createRepositorySettings;
    private final OperationCallSettings.Builder<
            CreateRepositoryRequest, Repository, OperationMetadata>
        createRepositoryOperationSettings;
    private final UnaryCallSettings.Builder<BatchCreateRepositoriesRequest, Operation>
        batchCreateRepositoriesSettings;
    private final OperationCallSettings.Builder<
            BatchCreateRepositoriesRequest, BatchCreateRepositoriesResponse, OperationMetadata>
        batchCreateRepositoriesOperationSettings;
    private final UnaryCallSettings.Builder<GetRepositoryRequest, Repository> getRepositorySettings;
    private final PagedCallSettings.Builder<
            ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>
        listRepositoriesSettings;
    private final UnaryCallSettings.Builder<DeleteRepositoryRequest, Operation>
        deleteRepositorySettings;
    private final OperationCallSettings.Builder<DeleteRepositoryRequest, Empty, OperationMetadata>
        deleteRepositoryOperationSettings;
    private final UnaryCallSettings.Builder<FetchReadWriteTokenRequest, FetchReadWriteTokenResponse>
        fetchReadWriteTokenSettings;
    private final UnaryCallSettings.Builder<FetchReadTokenRequest, FetchReadTokenResponse>
        fetchReadTokenSettings;
    private final PagedCallSettings.Builder<
            FetchLinkableRepositoriesRequest,
            FetchLinkableRepositoriesResponse,
            FetchLinkableRepositoriesPagedResponse>
        fetchLinkableRepositoriesSettings;
    private final UnaryCallSettings.Builder<FetchGitRefsRequest, FetchGitRefsResponse>
        fetchGitRefsSettings;
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
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
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

      createConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createConnectionOperationSettings = OperationCallSettings.newBuilder();
      getConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listConnectionsSettings = PagedCallSettings.newBuilder(LIST_CONNECTIONS_PAGE_STR_FACT);
      updateConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateConnectionOperationSettings = OperationCallSettings.newBuilder();
      deleteConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteConnectionOperationSettings = OperationCallSettings.newBuilder();
      createRepositorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createRepositoryOperationSettings = OperationCallSettings.newBuilder();
      batchCreateRepositoriesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateRepositoriesOperationSettings = OperationCallSettings.newBuilder();
      getRepositorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listRepositoriesSettings = PagedCallSettings.newBuilder(LIST_REPOSITORIES_PAGE_STR_FACT);
      deleteRepositorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteRepositoryOperationSettings = OperationCallSettings.newBuilder();
      fetchReadWriteTokenSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      fetchReadTokenSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      fetchLinkableRepositoriesSettings =
          PagedCallSettings.newBuilder(FETCH_LINKABLE_REPOSITORIES_PAGE_STR_FACT);
      fetchGitRefsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createConnectionSettings,
              getConnectionSettings,
              listConnectionsSettings,
              updateConnectionSettings,
              deleteConnectionSettings,
              createRepositorySettings,
              batchCreateRepositoriesSettings,
              getRepositorySettings,
              listRepositoriesSettings,
              deleteRepositorySettings,
              fetchReadWriteTokenSettings,
              fetchReadTokenSettings,
              fetchLinkableRepositoriesSettings,
              fetchGitRefsSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(RepositoryManagerStubSettings settings) {
      super(settings);

      createConnectionSettings = settings.createConnectionSettings.toBuilder();
      createConnectionOperationSettings = settings.createConnectionOperationSettings.toBuilder();
      getConnectionSettings = settings.getConnectionSettings.toBuilder();
      listConnectionsSettings = settings.listConnectionsSettings.toBuilder();
      updateConnectionSettings = settings.updateConnectionSettings.toBuilder();
      updateConnectionOperationSettings = settings.updateConnectionOperationSettings.toBuilder();
      deleteConnectionSettings = settings.deleteConnectionSettings.toBuilder();
      deleteConnectionOperationSettings = settings.deleteConnectionOperationSettings.toBuilder();
      createRepositorySettings = settings.createRepositorySettings.toBuilder();
      createRepositoryOperationSettings = settings.createRepositoryOperationSettings.toBuilder();
      batchCreateRepositoriesSettings = settings.batchCreateRepositoriesSettings.toBuilder();
      batchCreateRepositoriesOperationSettings =
          settings.batchCreateRepositoriesOperationSettings.toBuilder();
      getRepositorySettings = settings.getRepositorySettings.toBuilder();
      listRepositoriesSettings = settings.listRepositoriesSettings.toBuilder();
      deleteRepositorySettings = settings.deleteRepositorySettings.toBuilder();
      deleteRepositoryOperationSettings = settings.deleteRepositoryOperationSettings.toBuilder();
      fetchReadWriteTokenSettings = settings.fetchReadWriteTokenSettings.toBuilder();
      fetchReadTokenSettings = settings.fetchReadTokenSettings.toBuilder();
      fetchLinkableRepositoriesSettings = settings.fetchLinkableRepositoriesSettings.toBuilder();
      fetchGitRefsSettings = settings.fetchGitRefsSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createConnectionSettings,
              getConnectionSettings,
              listConnectionsSettings,
              updateConnectionSettings,
              deleteConnectionSettings,
              createRepositorySettings,
              batchCreateRepositoriesSettings,
              getRepositorySettings,
              listRepositoriesSettings,
              deleteRepositorySettings,
              fetchReadWriteTokenSettings,
              fetchReadTokenSettings,
              fetchLinkableRepositoriesSettings,
              fetchGitRefsSettings,
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
          .createConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listConnectionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createRepositorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .batchCreateRepositoriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getRepositorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listRepositoriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteRepositorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .fetchReadWriteTokenSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .fetchReadTokenSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .fetchLinkableRepositoriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .fetchGitRefsSettings()
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

      builder
          .createConnectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateConnectionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
          .createRepositoryOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateRepositoryRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Repository.class))
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
          .batchCreateRepositoriesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchCreateRepositoriesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BatchCreateRepositoriesResponse.class))
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
          .deleteRepositoryOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteRepositoryRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to getConnection. */
    public UnaryCallSettings.Builder<GetConnectionRequest, Connection> getConnectionSettings() {
      return getConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to listConnections. */
    public PagedCallSettings.Builder<
            ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
        listConnectionsSettings() {
      return listConnectionsSettings;
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

    /** Returns the builder for the settings used for calls to createRepository. */
    public UnaryCallSettings.Builder<CreateRepositoryRequest, Operation>
        createRepositorySettings() {
      return createRepositorySettings;
    }

    /** Returns the builder for the settings used for calls to createRepository. */
    public OperationCallSettings.Builder<CreateRepositoryRequest, Repository, OperationMetadata>
        createRepositoryOperationSettings() {
      return createRepositoryOperationSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateRepositories. */
    public UnaryCallSettings.Builder<BatchCreateRepositoriesRequest, Operation>
        batchCreateRepositoriesSettings() {
      return batchCreateRepositoriesSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateRepositories. */
    public OperationCallSettings.Builder<
            BatchCreateRepositoriesRequest, BatchCreateRepositoriesResponse, OperationMetadata>
        batchCreateRepositoriesOperationSettings() {
      return batchCreateRepositoriesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getRepository. */
    public UnaryCallSettings.Builder<GetRepositoryRequest, Repository> getRepositorySettings() {
      return getRepositorySettings;
    }

    /** Returns the builder for the settings used for calls to listRepositories. */
    public PagedCallSettings.Builder<
            ListRepositoriesRequest, ListRepositoriesResponse, ListRepositoriesPagedResponse>
        listRepositoriesSettings() {
      return listRepositoriesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRepository. */
    public UnaryCallSettings.Builder<DeleteRepositoryRequest, Operation>
        deleteRepositorySettings() {
      return deleteRepositorySettings;
    }

    /** Returns the builder for the settings used for calls to deleteRepository. */
    public OperationCallSettings.Builder<DeleteRepositoryRequest, Empty, OperationMetadata>
        deleteRepositoryOperationSettings() {
      return deleteRepositoryOperationSettings;
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

    /** Returns the builder for the settings used for calls to fetchLinkableRepositories. */
    public PagedCallSettings.Builder<
            FetchLinkableRepositoriesRequest,
            FetchLinkableRepositoriesResponse,
            FetchLinkableRepositoriesPagedResponse>
        fetchLinkableRepositoriesSettings() {
      return fetchLinkableRepositoriesSettings;
    }

    /** Returns the builder for the settings used for calls to fetchGitRefs. */
    public UnaryCallSettings.Builder<FetchGitRefsRequest, FetchGitRefsResponse>
        fetchGitRefsSettings() {
      return fetchGitRefsSettings;
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
    public RepositoryManagerStubSettings build() throws IOException {
      return new RepositoryManagerStubSettings(this);
    }
  }
}
