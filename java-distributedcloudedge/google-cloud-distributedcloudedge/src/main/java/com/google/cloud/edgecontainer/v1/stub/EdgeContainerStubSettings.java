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

package com.google.cloud.edgecontainer.v1.stub;

import static com.google.cloud.edgecontainer.v1.EdgeContainerClient.ListClustersPagedResponse;
import static com.google.cloud.edgecontainer.v1.EdgeContainerClient.ListMachinesPagedResponse;
import static com.google.cloud.edgecontainer.v1.EdgeContainerClient.ListNodePoolsPagedResponse;
import static com.google.cloud.edgecontainer.v1.EdgeContainerClient.ListVpnConnectionsPagedResponse;

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
import com.google.cloud.edgecontainer.v1.Cluster;
import com.google.cloud.edgecontainer.v1.CreateClusterRequest;
import com.google.cloud.edgecontainer.v1.CreateNodePoolRequest;
import com.google.cloud.edgecontainer.v1.CreateVpnConnectionRequest;
import com.google.cloud.edgecontainer.v1.DeleteClusterRequest;
import com.google.cloud.edgecontainer.v1.DeleteNodePoolRequest;
import com.google.cloud.edgecontainer.v1.DeleteVpnConnectionRequest;
import com.google.cloud.edgecontainer.v1.GenerateAccessTokenRequest;
import com.google.cloud.edgecontainer.v1.GenerateAccessTokenResponse;
import com.google.cloud.edgecontainer.v1.GetClusterRequest;
import com.google.cloud.edgecontainer.v1.GetMachineRequest;
import com.google.cloud.edgecontainer.v1.GetNodePoolRequest;
import com.google.cloud.edgecontainer.v1.GetVpnConnectionRequest;
import com.google.cloud.edgecontainer.v1.ListClustersRequest;
import com.google.cloud.edgecontainer.v1.ListClustersResponse;
import com.google.cloud.edgecontainer.v1.ListMachinesRequest;
import com.google.cloud.edgecontainer.v1.ListMachinesResponse;
import com.google.cloud.edgecontainer.v1.ListNodePoolsRequest;
import com.google.cloud.edgecontainer.v1.ListNodePoolsResponse;
import com.google.cloud.edgecontainer.v1.ListVpnConnectionsRequest;
import com.google.cloud.edgecontainer.v1.ListVpnConnectionsResponse;
import com.google.cloud.edgecontainer.v1.Machine;
import com.google.cloud.edgecontainer.v1.NodePool;
import com.google.cloud.edgecontainer.v1.OperationMetadata;
import com.google.cloud.edgecontainer.v1.UpdateClusterRequest;
import com.google.cloud.edgecontainer.v1.UpdateNodePoolRequest;
import com.google.cloud.edgecontainer.v1.VpnConnection;
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
 * Settings class to configure an instance of {@link EdgeContainerStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (edgecontainer.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getCluster to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EdgeContainerStubSettings.Builder edgeContainerSettingsBuilder =
 *     EdgeContainerStubSettings.newBuilder();
 * edgeContainerSettingsBuilder
 *     .getClusterSettings()
 *     .setRetrySettings(
 *         edgeContainerSettingsBuilder.getClusterSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * EdgeContainerStubSettings edgeContainerSettings = edgeContainerSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class EdgeContainerStubSettings extends StubSettings<EdgeContainerStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
      listClustersSettings;
  private final UnaryCallSettings<GetClusterRequest, Cluster> getClusterSettings;
  private final UnaryCallSettings<CreateClusterRequest, Operation> createClusterSettings;
  private final OperationCallSettings<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationSettings;
  private final UnaryCallSettings<UpdateClusterRequest, Operation> updateClusterSettings;
  private final OperationCallSettings<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationSettings;
  private final UnaryCallSettings<DeleteClusterRequest, Operation> deleteClusterSettings;
  private final OperationCallSettings<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationSettings;
  private final UnaryCallSettings<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
      generateAccessTokenSettings;
  private final PagedCallSettings<
          ListNodePoolsRequest, ListNodePoolsResponse, ListNodePoolsPagedResponse>
      listNodePoolsSettings;
  private final UnaryCallSettings<GetNodePoolRequest, NodePool> getNodePoolSettings;
  private final UnaryCallSettings<CreateNodePoolRequest, Operation> createNodePoolSettings;
  private final OperationCallSettings<CreateNodePoolRequest, NodePool, OperationMetadata>
      createNodePoolOperationSettings;
  private final UnaryCallSettings<UpdateNodePoolRequest, Operation> updateNodePoolSettings;
  private final OperationCallSettings<UpdateNodePoolRequest, NodePool, OperationMetadata>
      updateNodePoolOperationSettings;
  private final UnaryCallSettings<DeleteNodePoolRequest, Operation> deleteNodePoolSettings;
  private final OperationCallSettings<DeleteNodePoolRequest, Empty, OperationMetadata>
      deleteNodePoolOperationSettings;
  private final PagedCallSettings<
          ListMachinesRequest, ListMachinesResponse, ListMachinesPagedResponse>
      listMachinesSettings;
  private final UnaryCallSettings<GetMachineRequest, Machine> getMachineSettings;
  private final PagedCallSettings<
          ListVpnConnectionsRequest, ListVpnConnectionsResponse, ListVpnConnectionsPagedResponse>
      listVpnConnectionsSettings;
  private final UnaryCallSettings<GetVpnConnectionRequest, VpnConnection> getVpnConnectionSettings;
  private final UnaryCallSettings<CreateVpnConnectionRequest, Operation>
      createVpnConnectionSettings;
  private final OperationCallSettings<CreateVpnConnectionRequest, VpnConnection, OperationMetadata>
      createVpnConnectionOperationSettings;
  private final UnaryCallSettings<DeleteVpnConnectionRequest, Operation>
      deleteVpnConnectionSettings;
  private final OperationCallSettings<DeleteVpnConnectionRequest, Empty, OperationMetadata>
      deleteVpnConnectionOperationSettings;

  private static final PagedListDescriptor<ListClustersRequest, ListClustersResponse, Cluster>
      LIST_CLUSTERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListClustersRequest, ListClustersResponse, Cluster>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListClustersRequest injectToken(ListClustersRequest payload, String token) {
              return ListClustersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListClustersRequest injectPageSize(ListClustersRequest payload, int pageSize) {
              return ListClustersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListClustersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListClustersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Cluster> extractResources(ListClustersResponse payload) {
              return payload.getClustersList() == null
                  ? ImmutableList.<Cluster>of()
                  : payload.getClustersList();
            }
          };

  private static final PagedListDescriptor<ListNodePoolsRequest, ListNodePoolsResponse, NodePool>
      LIST_NODE_POOLS_PAGE_STR_DESC =
          new PagedListDescriptor<ListNodePoolsRequest, ListNodePoolsResponse, NodePool>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNodePoolsRequest injectToken(ListNodePoolsRequest payload, String token) {
              return ListNodePoolsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNodePoolsRequest injectPageSize(ListNodePoolsRequest payload, int pageSize) {
              return ListNodePoolsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListNodePoolsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListNodePoolsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NodePool> extractResources(ListNodePoolsResponse payload) {
              return payload.getNodePoolsList() == null
                  ? ImmutableList.<NodePool>of()
                  : payload.getNodePoolsList();
            }
          };

  private static final PagedListDescriptor<ListMachinesRequest, ListMachinesResponse, Machine>
      LIST_MACHINES_PAGE_STR_DESC =
          new PagedListDescriptor<ListMachinesRequest, ListMachinesResponse, Machine>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMachinesRequest injectToken(ListMachinesRequest payload, String token) {
              return ListMachinesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMachinesRequest injectPageSize(ListMachinesRequest payload, int pageSize) {
              return ListMachinesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMachinesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMachinesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Machine> extractResources(ListMachinesResponse payload) {
              return payload.getMachinesList() == null
                  ? ImmutableList.<Machine>of()
                  : payload.getMachinesList();
            }
          };

  private static final PagedListDescriptor<
          ListVpnConnectionsRequest, ListVpnConnectionsResponse, VpnConnection>
      LIST_VPN_CONNECTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListVpnConnectionsRequest, ListVpnConnectionsResponse, VpnConnection>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListVpnConnectionsRequest injectToken(
                ListVpnConnectionsRequest payload, String token) {
              return ListVpnConnectionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListVpnConnectionsRequest injectPageSize(
                ListVpnConnectionsRequest payload, int pageSize) {
              return ListVpnConnectionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListVpnConnectionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListVpnConnectionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<VpnConnection> extractResources(ListVpnConnectionsResponse payload) {
              return payload.getVpnConnectionsList() == null
                  ? ImmutableList.<VpnConnection>of()
                  : payload.getVpnConnectionsList();
            }
          };

  private static final PagedListResponseFactory<
          ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
      LIST_CLUSTERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>() {
            @Override
            public ApiFuture<ListClustersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListClustersRequest, ListClustersResponse> callable,
                ListClustersRequest request,
                ApiCallContext context,
                ApiFuture<ListClustersResponse> futureResponse) {
              PageContext<ListClustersRequest, ListClustersResponse, Cluster> pageContext =
                  PageContext.create(callable, LIST_CLUSTERS_PAGE_STR_DESC, request, context);
              return ListClustersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNodePoolsRequest, ListNodePoolsResponse, ListNodePoolsPagedResponse>
      LIST_NODE_POOLS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNodePoolsRequest, ListNodePoolsResponse, ListNodePoolsPagedResponse>() {
            @Override
            public ApiFuture<ListNodePoolsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNodePoolsRequest, ListNodePoolsResponse> callable,
                ListNodePoolsRequest request,
                ApiCallContext context,
                ApiFuture<ListNodePoolsResponse> futureResponse) {
              PageContext<ListNodePoolsRequest, ListNodePoolsResponse, NodePool> pageContext =
                  PageContext.create(callable, LIST_NODE_POOLS_PAGE_STR_DESC, request, context);
              return ListNodePoolsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListMachinesRequest, ListMachinesResponse, ListMachinesPagedResponse>
      LIST_MACHINES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMachinesRequest, ListMachinesResponse, ListMachinesPagedResponse>() {
            @Override
            public ApiFuture<ListMachinesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMachinesRequest, ListMachinesResponse> callable,
                ListMachinesRequest request,
                ApiCallContext context,
                ApiFuture<ListMachinesResponse> futureResponse) {
              PageContext<ListMachinesRequest, ListMachinesResponse, Machine> pageContext =
                  PageContext.create(callable, LIST_MACHINES_PAGE_STR_DESC, request, context);
              return ListMachinesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListVpnConnectionsRequest, ListVpnConnectionsResponse, ListVpnConnectionsPagedResponse>
      LIST_VPN_CONNECTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListVpnConnectionsRequest,
              ListVpnConnectionsResponse,
              ListVpnConnectionsPagedResponse>() {
            @Override
            public ApiFuture<ListVpnConnectionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListVpnConnectionsRequest, ListVpnConnectionsResponse> callable,
                ListVpnConnectionsRequest request,
                ApiCallContext context,
                ApiFuture<ListVpnConnectionsResponse> futureResponse) {
              PageContext<ListVpnConnectionsRequest, ListVpnConnectionsResponse, VpnConnection>
                  pageContext =
                      PageContext.create(
                          callable, LIST_VPN_CONNECTIONS_PAGE_STR_DESC, request, context);
              return ListVpnConnectionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listClusters. */
  public PagedCallSettings<ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
      listClustersSettings() {
    return listClustersSettings;
  }

  /** Returns the object with the settings used for calls to getCluster. */
  public UnaryCallSettings<GetClusterRequest, Cluster> getClusterSettings() {
    return getClusterSettings;
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public UnaryCallSettings<CreateClusterRequest, Operation> createClusterSettings() {
    return createClusterSettings;
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public OperationCallSettings<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationSettings() {
    return createClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public UnaryCallSettings<UpdateClusterRequest, Operation> updateClusterSettings() {
    return updateClusterSettings;
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public OperationCallSettings<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationSettings() {
    return updateClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public UnaryCallSettings<DeleteClusterRequest, Operation> deleteClusterSettings() {
    return deleteClusterSettings;
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public OperationCallSettings<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationSettings() {
    return deleteClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to generateAccessToken. */
  public UnaryCallSettings<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
      generateAccessTokenSettings() {
    return generateAccessTokenSettings;
  }

  /** Returns the object with the settings used for calls to listNodePools. */
  public PagedCallSettings<ListNodePoolsRequest, ListNodePoolsResponse, ListNodePoolsPagedResponse>
      listNodePoolsSettings() {
    return listNodePoolsSettings;
  }

  /** Returns the object with the settings used for calls to getNodePool. */
  public UnaryCallSettings<GetNodePoolRequest, NodePool> getNodePoolSettings() {
    return getNodePoolSettings;
  }

  /** Returns the object with the settings used for calls to createNodePool. */
  public UnaryCallSettings<CreateNodePoolRequest, Operation> createNodePoolSettings() {
    return createNodePoolSettings;
  }

  /** Returns the object with the settings used for calls to createNodePool. */
  public OperationCallSettings<CreateNodePoolRequest, NodePool, OperationMetadata>
      createNodePoolOperationSettings() {
    return createNodePoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateNodePool. */
  public UnaryCallSettings<UpdateNodePoolRequest, Operation> updateNodePoolSettings() {
    return updateNodePoolSettings;
  }

  /** Returns the object with the settings used for calls to updateNodePool. */
  public OperationCallSettings<UpdateNodePoolRequest, NodePool, OperationMetadata>
      updateNodePoolOperationSettings() {
    return updateNodePoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteNodePool. */
  public UnaryCallSettings<DeleteNodePoolRequest, Operation> deleteNodePoolSettings() {
    return deleteNodePoolSettings;
  }

  /** Returns the object with the settings used for calls to deleteNodePool. */
  public OperationCallSettings<DeleteNodePoolRequest, Empty, OperationMetadata>
      deleteNodePoolOperationSettings() {
    return deleteNodePoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to listMachines. */
  public PagedCallSettings<ListMachinesRequest, ListMachinesResponse, ListMachinesPagedResponse>
      listMachinesSettings() {
    return listMachinesSettings;
  }

  /** Returns the object with the settings used for calls to getMachine. */
  public UnaryCallSettings<GetMachineRequest, Machine> getMachineSettings() {
    return getMachineSettings;
  }

  /** Returns the object with the settings used for calls to listVpnConnections. */
  public PagedCallSettings<
          ListVpnConnectionsRequest, ListVpnConnectionsResponse, ListVpnConnectionsPagedResponse>
      listVpnConnectionsSettings() {
    return listVpnConnectionsSettings;
  }

  /** Returns the object with the settings used for calls to getVpnConnection. */
  public UnaryCallSettings<GetVpnConnectionRequest, VpnConnection> getVpnConnectionSettings() {
    return getVpnConnectionSettings;
  }

  /** Returns the object with the settings used for calls to createVpnConnection. */
  public UnaryCallSettings<CreateVpnConnectionRequest, Operation> createVpnConnectionSettings() {
    return createVpnConnectionSettings;
  }

  /** Returns the object with the settings used for calls to createVpnConnection. */
  public OperationCallSettings<CreateVpnConnectionRequest, VpnConnection, OperationMetadata>
      createVpnConnectionOperationSettings() {
    return createVpnConnectionOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteVpnConnection. */
  public UnaryCallSettings<DeleteVpnConnectionRequest, Operation> deleteVpnConnectionSettings() {
    return deleteVpnConnectionSettings;
  }

  /** Returns the object with the settings used for calls to deleteVpnConnection. */
  public OperationCallSettings<DeleteVpnConnectionRequest, Empty, OperationMetadata>
      deleteVpnConnectionOperationSettings() {
    return deleteVpnConnectionOperationSettings;
  }

  public EdgeContainerStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcEdgeContainerStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonEdgeContainerStub.create(this);
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
    return "edgecontainer.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "edgecontainer.mtls.googleapis.com:443";
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
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(EdgeContainerStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(EdgeContainerStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return EdgeContainerStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected EdgeContainerStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listClustersSettings = settingsBuilder.listClustersSettings().build();
    getClusterSettings = settingsBuilder.getClusterSettings().build();
    createClusterSettings = settingsBuilder.createClusterSettings().build();
    createClusterOperationSettings = settingsBuilder.createClusterOperationSettings().build();
    updateClusterSettings = settingsBuilder.updateClusterSettings().build();
    updateClusterOperationSettings = settingsBuilder.updateClusterOperationSettings().build();
    deleteClusterSettings = settingsBuilder.deleteClusterSettings().build();
    deleteClusterOperationSettings = settingsBuilder.deleteClusterOperationSettings().build();
    generateAccessTokenSettings = settingsBuilder.generateAccessTokenSettings().build();
    listNodePoolsSettings = settingsBuilder.listNodePoolsSettings().build();
    getNodePoolSettings = settingsBuilder.getNodePoolSettings().build();
    createNodePoolSettings = settingsBuilder.createNodePoolSettings().build();
    createNodePoolOperationSettings = settingsBuilder.createNodePoolOperationSettings().build();
    updateNodePoolSettings = settingsBuilder.updateNodePoolSettings().build();
    updateNodePoolOperationSettings = settingsBuilder.updateNodePoolOperationSettings().build();
    deleteNodePoolSettings = settingsBuilder.deleteNodePoolSettings().build();
    deleteNodePoolOperationSettings = settingsBuilder.deleteNodePoolOperationSettings().build();
    listMachinesSettings = settingsBuilder.listMachinesSettings().build();
    getMachineSettings = settingsBuilder.getMachineSettings().build();
    listVpnConnectionsSettings = settingsBuilder.listVpnConnectionsSettings().build();
    getVpnConnectionSettings = settingsBuilder.getVpnConnectionSettings().build();
    createVpnConnectionSettings = settingsBuilder.createVpnConnectionSettings().build();
    createVpnConnectionOperationSettings =
        settingsBuilder.createVpnConnectionOperationSettings().build();
    deleteVpnConnectionSettings = settingsBuilder.deleteVpnConnectionSettings().build();
    deleteVpnConnectionOperationSettings =
        settingsBuilder.deleteVpnConnectionOperationSettings().build();
  }

  /** Builder for EdgeContainerStubSettings. */
  public static class Builder extends StubSettings.Builder<EdgeContainerStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
        listClustersSettings;
    private final UnaryCallSettings.Builder<GetClusterRequest, Cluster> getClusterSettings;
    private final UnaryCallSettings.Builder<CreateClusterRequest, Operation> createClusterSettings;
    private final OperationCallSettings.Builder<CreateClusterRequest, Cluster, OperationMetadata>
        createClusterOperationSettings;
    private final UnaryCallSettings.Builder<UpdateClusterRequest, Operation> updateClusterSettings;
    private final OperationCallSettings.Builder<UpdateClusterRequest, Cluster, OperationMetadata>
        updateClusterOperationSettings;
    private final UnaryCallSettings.Builder<DeleteClusterRequest, Operation> deleteClusterSettings;
    private final OperationCallSettings.Builder<DeleteClusterRequest, Empty, OperationMetadata>
        deleteClusterOperationSettings;
    private final UnaryCallSettings.Builder<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
        generateAccessTokenSettings;
    private final PagedCallSettings.Builder<
            ListNodePoolsRequest, ListNodePoolsResponse, ListNodePoolsPagedResponse>
        listNodePoolsSettings;
    private final UnaryCallSettings.Builder<GetNodePoolRequest, NodePool> getNodePoolSettings;
    private final UnaryCallSettings.Builder<CreateNodePoolRequest, Operation>
        createNodePoolSettings;
    private final OperationCallSettings.Builder<CreateNodePoolRequest, NodePool, OperationMetadata>
        createNodePoolOperationSettings;
    private final UnaryCallSettings.Builder<UpdateNodePoolRequest, Operation>
        updateNodePoolSettings;
    private final OperationCallSettings.Builder<UpdateNodePoolRequest, NodePool, OperationMetadata>
        updateNodePoolOperationSettings;
    private final UnaryCallSettings.Builder<DeleteNodePoolRequest, Operation>
        deleteNodePoolSettings;
    private final OperationCallSettings.Builder<DeleteNodePoolRequest, Empty, OperationMetadata>
        deleteNodePoolOperationSettings;
    private final PagedCallSettings.Builder<
            ListMachinesRequest, ListMachinesResponse, ListMachinesPagedResponse>
        listMachinesSettings;
    private final UnaryCallSettings.Builder<GetMachineRequest, Machine> getMachineSettings;
    private final PagedCallSettings.Builder<
            ListVpnConnectionsRequest, ListVpnConnectionsResponse, ListVpnConnectionsPagedResponse>
        listVpnConnectionsSettings;
    private final UnaryCallSettings.Builder<GetVpnConnectionRequest, VpnConnection>
        getVpnConnectionSettings;
    private final UnaryCallSettings.Builder<CreateVpnConnectionRequest, Operation>
        createVpnConnectionSettings;
    private final OperationCallSettings.Builder<
            CreateVpnConnectionRequest, VpnConnection, OperationMetadata>
        createVpnConnectionOperationSettings;
    private final UnaryCallSettings.Builder<DeleteVpnConnectionRequest, Operation>
        deleteVpnConnectionSettings;
    private final OperationCallSettings.Builder<
            DeleteVpnConnectionRequest, Empty, OperationMetadata>
        deleteVpnConnectionOperationSettings;
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

      listClustersSettings = PagedCallSettings.newBuilder(LIST_CLUSTERS_PAGE_STR_FACT);
      getClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createClusterOperationSettings = OperationCallSettings.newBuilder();
      updateClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateClusterOperationSettings = OperationCallSettings.newBuilder();
      deleteClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteClusterOperationSettings = OperationCallSettings.newBuilder();
      generateAccessTokenSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listNodePoolsSettings = PagedCallSettings.newBuilder(LIST_NODE_POOLS_PAGE_STR_FACT);
      getNodePoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createNodePoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createNodePoolOperationSettings = OperationCallSettings.newBuilder();
      updateNodePoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateNodePoolOperationSettings = OperationCallSettings.newBuilder();
      deleteNodePoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteNodePoolOperationSettings = OperationCallSettings.newBuilder();
      listMachinesSettings = PagedCallSettings.newBuilder(LIST_MACHINES_PAGE_STR_FACT);
      getMachineSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listVpnConnectionsSettings = PagedCallSettings.newBuilder(LIST_VPN_CONNECTIONS_PAGE_STR_FACT);
      getVpnConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createVpnConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createVpnConnectionOperationSettings = OperationCallSettings.newBuilder();
      deleteVpnConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteVpnConnectionOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listClustersSettings,
              getClusterSettings,
              createClusterSettings,
              updateClusterSettings,
              deleteClusterSettings,
              generateAccessTokenSettings,
              listNodePoolsSettings,
              getNodePoolSettings,
              createNodePoolSettings,
              updateNodePoolSettings,
              deleteNodePoolSettings,
              listMachinesSettings,
              getMachineSettings,
              listVpnConnectionsSettings,
              getVpnConnectionSettings,
              createVpnConnectionSettings,
              deleteVpnConnectionSettings);
      initDefaults(this);
    }

    protected Builder(EdgeContainerStubSettings settings) {
      super(settings);

      listClustersSettings = settings.listClustersSettings.toBuilder();
      getClusterSettings = settings.getClusterSettings.toBuilder();
      createClusterSettings = settings.createClusterSettings.toBuilder();
      createClusterOperationSettings = settings.createClusterOperationSettings.toBuilder();
      updateClusterSettings = settings.updateClusterSettings.toBuilder();
      updateClusterOperationSettings = settings.updateClusterOperationSettings.toBuilder();
      deleteClusterSettings = settings.deleteClusterSettings.toBuilder();
      deleteClusterOperationSettings = settings.deleteClusterOperationSettings.toBuilder();
      generateAccessTokenSettings = settings.generateAccessTokenSettings.toBuilder();
      listNodePoolsSettings = settings.listNodePoolsSettings.toBuilder();
      getNodePoolSettings = settings.getNodePoolSettings.toBuilder();
      createNodePoolSettings = settings.createNodePoolSettings.toBuilder();
      createNodePoolOperationSettings = settings.createNodePoolOperationSettings.toBuilder();
      updateNodePoolSettings = settings.updateNodePoolSettings.toBuilder();
      updateNodePoolOperationSettings = settings.updateNodePoolOperationSettings.toBuilder();
      deleteNodePoolSettings = settings.deleteNodePoolSettings.toBuilder();
      deleteNodePoolOperationSettings = settings.deleteNodePoolOperationSettings.toBuilder();
      listMachinesSettings = settings.listMachinesSettings.toBuilder();
      getMachineSettings = settings.getMachineSettings.toBuilder();
      listVpnConnectionsSettings = settings.listVpnConnectionsSettings.toBuilder();
      getVpnConnectionSettings = settings.getVpnConnectionSettings.toBuilder();
      createVpnConnectionSettings = settings.createVpnConnectionSettings.toBuilder();
      createVpnConnectionOperationSettings =
          settings.createVpnConnectionOperationSettings.toBuilder();
      deleteVpnConnectionSettings = settings.deleteVpnConnectionSettings.toBuilder();
      deleteVpnConnectionOperationSettings =
          settings.deleteVpnConnectionOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listClustersSettings,
              getClusterSettings,
              createClusterSettings,
              updateClusterSettings,
              deleteClusterSettings,
              generateAccessTokenSettings,
              listNodePoolsSettings,
              getNodePoolSettings,
              createNodePoolSettings,
              updateNodePoolSettings,
              deleteNodePoolSettings,
              listMachinesSettings,
              getMachineSettings,
              listVpnConnectionsSettings,
              getVpnConnectionSettings,
              createVpnConnectionSettings,
              deleteVpnConnectionSettings);
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
          .listClustersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .generateAccessTokenSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listNodePoolsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getNodePoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createNodePoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateNodePoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteNodePoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listMachinesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getMachineSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listVpnConnectionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getVpnConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createVpnConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteVpnConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Cluster.class))
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
          .updateClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Cluster.class))
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
          .deleteClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .createNodePoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateNodePoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(NodePool.class))
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
          .updateNodePoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateNodePoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(NodePool.class))
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
          .deleteNodePoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteNodePoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .createVpnConnectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateVpnConnectionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(VpnConnection.class))
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
          .deleteVpnConnectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteVpnConnectionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to listClusters. */
    public PagedCallSettings.Builder<
            ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
        listClustersSettings() {
      return listClustersSettings;
    }

    /** Returns the builder for the settings used for calls to getCluster. */
    public UnaryCallSettings.Builder<GetClusterRequest, Cluster> getClusterSettings() {
      return getClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createCluster. */
    public UnaryCallSettings.Builder<CreateClusterRequest, Operation> createClusterSettings() {
      return createClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createCluster. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateClusterRequest, Cluster, OperationMetadata>
        createClusterOperationSettings() {
      return createClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateCluster. */
    public UnaryCallSettings.Builder<UpdateClusterRequest, Operation> updateClusterSettings() {
      return updateClusterSettings;
    }

    /** Returns the builder for the settings used for calls to updateCluster. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateClusterRequest, Cluster, OperationMetadata>
        updateClusterOperationSettings() {
      return updateClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCluster. */
    public UnaryCallSettings.Builder<DeleteClusterRequest, Operation> deleteClusterSettings() {
      return deleteClusterSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCluster. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteClusterRequest, Empty, OperationMetadata>
        deleteClusterOperationSettings() {
      return deleteClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to generateAccessToken. */
    public UnaryCallSettings.Builder<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
        generateAccessTokenSettings() {
      return generateAccessTokenSettings;
    }

    /** Returns the builder for the settings used for calls to listNodePools. */
    public PagedCallSettings.Builder<
            ListNodePoolsRequest, ListNodePoolsResponse, ListNodePoolsPagedResponse>
        listNodePoolsSettings() {
      return listNodePoolsSettings;
    }

    /** Returns the builder for the settings used for calls to getNodePool. */
    public UnaryCallSettings.Builder<GetNodePoolRequest, NodePool> getNodePoolSettings() {
      return getNodePoolSettings;
    }

    /** Returns the builder for the settings used for calls to createNodePool. */
    public UnaryCallSettings.Builder<CreateNodePoolRequest, Operation> createNodePoolSettings() {
      return createNodePoolSettings;
    }

    /** Returns the builder for the settings used for calls to createNodePool. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateNodePoolRequest, NodePool, OperationMetadata>
        createNodePoolOperationSettings() {
      return createNodePoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateNodePool. */
    public UnaryCallSettings.Builder<UpdateNodePoolRequest, Operation> updateNodePoolSettings() {
      return updateNodePoolSettings;
    }

    /** Returns the builder for the settings used for calls to updateNodePool. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateNodePoolRequest, NodePool, OperationMetadata>
        updateNodePoolOperationSettings() {
      return updateNodePoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNodePool. */
    public UnaryCallSettings.Builder<DeleteNodePoolRequest, Operation> deleteNodePoolSettings() {
      return deleteNodePoolSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNodePool. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteNodePoolRequest, Empty, OperationMetadata>
        deleteNodePoolOperationSettings() {
      return deleteNodePoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listMachines. */
    public PagedCallSettings.Builder<
            ListMachinesRequest, ListMachinesResponse, ListMachinesPagedResponse>
        listMachinesSettings() {
      return listMachinesSettings;
    }

    /** Returns the builder for the settings used for calls to getMachine. */
    public UnaryCallSettings.Builder<GetMachineRequest, Machine> getMachineSettings() {
      return getMachineSettings;
    }

    /** Returns the builder for the settings used for calls to listVpnConnections. */
    public PagedCallSettings.Builder<
            ListVpnConnectionsRequest, ListVpnConnectionsResponse, ListVpnConnectionsPagedResponse>
        listVpnConnectionsSettings() {
      return listVpnConnectionsSettings;
    }

    /** Returns the builder for the settings used for calls to getVpnConnection. */
    public UnaryCallSettings.Builder<GetVpnConnectionRequest, VpnConnection>
        getVpnConnectionSettings() {
      return getVpnConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to createVpnConnection. */
    public UnaryCallSettings.Builder<CreateVpnConnectionRequest, Operation>
        createVpnConnectionSettings() {
      return createVpnConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to createVpnConnection. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateVpnConnectionRequest, VpnConnection, OperationMetadata>
        createVpnConnectionOperationSettings() {
      return createVpnConnectionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteVpnConnection. */
    public UnaryCallSettings.Builder<DeleteVpnConnectionRequest, Operation>
        deleteVpnConnectionSettings() {
      return deleteVpnConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteVpnConnection. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteVpnConnectionRequest, Empty, OperationMetadata>
        deleteVpnConnectionOperationSettings() {
      return deleteVpnConnectionOperationSettings;
    }

    @Override
    public EdgeContainerStubSettings build() throws IOException {
      return new EdgeContainerStubSettings(this);
    }
  }
}
