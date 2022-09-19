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

package com.google.cloud.gkemulticloud.v1.stub;

import static com.google.cloud.gkemulticloud.v1.AzureClustersClient.ListAzureClientsPagedResponse;
import static com.google.cloud.gkemulticloud.v1.AzureClustersClient.ListAzureClustersPagedResponse;
import static com.google.cloud.gkemulticloud.v1.AzureClustersClient.ListAzureNodePoolsPagedResponse;

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
import com.google.cloud.gkemulticloud.v1.AzureClient;
import com.google.cloud.gkemulticloud.v1.AzureCluster;
import com.google.cloud.gkemulticloud.v1.AzureNodePool;
import com.google.cloud.gkemulticloud.v1.AzureServerConfig;
import com.google.cloud.gkemulticloud.v1.CreateAzureClientRequest;
import com.google.cloud.gkemulticloud.v1.CreateAzureClusterRequest;
import com.google.cloud.gkemulticloud.v1.CreateAzureNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAzureClientRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAzureClusterRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAzureNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenResponse;
import com.google.cloud.gkemulticloud.v1.GetAzureClientRequest;
import com.google.cloud.gkemulticloud.v1.GetAzureClusterRequest;
import com.google.cloud.gkemulticloud.v1.GetAzureNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.GetAzureServerConfigRequest;
import com.google.cloud.gkemulticloud.v1.ListAzureClientsRequest;
import com.google.cloud.gkemulticloud.v1.ListAzureClientsResponse;
import com.google.cloud.gkemulticloud.v1.ListAzureClustersRequest;
import com.google.cloud.gkemulticloud.v1.ListAzureClustersResponse;
import com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsRequest;
import com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsResponse;
import com.google.cloud.gkemulticloud.v1.OperationMetadata;
import com.google.cloud.gkemulticloud.v1.UpdateAzureClusterRequest;
import com.google.cloud.gkemulticloud.v1.UpdateAzureNodePoolRequest;
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
 * Settings class to configure an instance of {@link AzureClustersStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (gkemulticloud.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getAzureClient to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AzureClustersStubSettings.Builder azureClustersSettingsBuilder =
 *     AzureClustersStubSettings.newBuilder();
 * azureClustersSettingsBuilder
 *     .getAzureClientSettings()
 *     .setRetrySettings(
 *         azureClustersSettingsBuilder.getAzureClientSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AzureClustersStubSettings azureClustersSettings = azureClustersSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AzureClustersStubSettings extends StubSettings<AzureClustersStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateAzureClientRequest, Operation> createAzureClientSettings;
  private final OperationCallSettings<CreateAzureClientRequest, AzureClient, OperationMetadata>
      createAzureClientOperationSettings;
  private final UnaryCallSettings<GetAzureClientRequest, AzureClient> getAzureClientSettings;
  private final PagedCallSettings<
          ListAzureClientsRequest, ListAzureClientsResponse, ListAzureClientsPagedResponse>
      listAzureClientsSettings;
  private final UnaryCallSettings<DeleteAzureClientRequest, Operation> deleteAzureClientSettings;
  private final OperationCallSettings<DeleteAzureClientRequest, Empty, OperationMetadata>
      deleteAzureClientOperationSettings;
  private final UnaryCallSettings<CreateAzureClusterRequest, Operation> createAzureClusterSettings;
  private final OperationCallSettings<CreateAzureClusterRequest, AzureCluster, OperationMetadata>
      createAzureClusterOperationSettings;
  private final UnaryCallSettings<UpdateAzureClusterRequest, Operation> updateAzureClusterSettings;
  private final OperationCallSettings<UpdateAzureClusterRequest, AzureCluster, OperationMetadata>
      updateAzureClusterOperationSettings;
  private final UnaryCallSettings<GetAzureClusterRequest, AzureCluster> getAzureClusterSettings;
  private final PagedCallSettings<
          ListAzureClustersRequest, ListAzureClustersResponse, ListAzureClustersPagedResponse>
      listAzureClustersSettings;
  private final UnaryCallSettings<DeleteAzureClusterRequest, Operation> deleteAzureClusterSettings;
  private final OperationCallSettings<DeleteAzureClusterRequest, Empty, OperationMetadata>
      deleteAzureClusterOperationSettings;
  private final UnaryCallSettings<GenerateAzureAccessTokenRequest, GenerateAzureAccessTokenResponse>
      generateAzureAccessTokenSettings;
  private final UnaryCallSettings<CreateAzureNodePoolRequest, Operation>
      createAzureNodePoolSettings;
  private final OperationCallSettings<CreateAzureNodePoolRequest, AzureNodePool, OperationMetadata>
      createAzureNodePoolOperationSettings;
  private final UnaryCallSettings<UpdateAzureNodePoolRequest, Operation>
      updateAzureNodePoolSettings;
  private final OperationCallSettings<UpdateAzureNodePoolRequest, AzureNodePool, OperationMetadata>
      updateAzureNodePoolOperationSettings;
  private final UnaryCallSettings<GetAzureNodePoolRequest, AzureNodePool> getAzureNodePoolSettings;
  private final PagedCallSettings<
          ListAzureNodePoolsRequest, ListAzureNodePoolsResponse, ListAzureNodePoolsPagedResponse>
      listAzureNodePoolsSettings;
  private final UnaryCallSettings<DeleteAzureNodePoolRequest, Operation>
      deleteAzureNodePoolSettings;
  private final OperationCallSettings<DeleteAzureNodePoolRequest, Empty, OperationMetadata>
      deleteAzureNodePoolOperationSettings;
  private final UnaryCallSettings<GetAzureServerConfigRequest, AzureServerConfig>
      getAzureServerConfigSettings;

  private static final PagedListDescriptor<
          ListAzureClientsRequest, ListAzureClientsResponse, AzureClient>
      LIST_AZURE_CLIENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAzureClientsRequest, ListAzureClientsResponse, AzureClient>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAzureClientsRequest injectToken(
                ListAzureClientsRequest payload, String token) {
              return ListAzureClientsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAzureClientsRequest injectPageSize(
                ListAzureClientsRequest payload, int pageSize) {
              return ListAzureClientsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAzureClientsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAzureClientsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AzureClient> extractResources(ListAzureClientsResponse payload) {
              return payload.getAzureClientsList() == null
                  ? ImmutableList.<AzureClient>of()
                  : payload.getAzureClientsList();
            }
          };

  private static final PagedListDescriptor<
          ListAzureClustersRequest, ListAzureClustersResponse, AzureCluster>
      LIST_AZURE_CLUSTERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAzureClustersRequest, ListAzureClustersResponse, AzureCluster>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAzureClustersRequest injectToken(
                ListAzureClustersRequest payload, String token) {
              return ListAzureClustersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAzureClustersRequest injectPageSize(
                ListAzureClustersRequest payload, int pageSize) {
              return ListAzureClustersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAzureClustersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAzureClustersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AzureCluster> extractResources(ListAzureClustersResponse payload) {
              return payload.getAzureClustersList() == null
                  ? ImmutableList.<AzureCluster>of()
                  : payload.getAzureClustersList();
            }
          };

  private static final PagedListDescriptor<
          ListAzureNodePoolsRequest, ListAzureNodePoolsResponse, AzureNodePool>
      LIST_AZURE_NODE_POOLS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAzureNodePoolsRequest, ListAzureNodePoolsResponse, AzureNodePool>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAzureNodePoolsRequest injectToken(
                ListAzureNodePoolsRequest payload, String token) {
              return ListAzureNodePoolsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAzureNodePoolsRequest injectPageSize(
                ListAzureNodePoolsRequest payload, int pageSize) {
              return ListAzureNodePoolsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAzureNodePoolsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAzureNodePoolsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AzureNodePool> extractResources(ListAzureNodePoolsResponse payload) {
              return payload.getAzureNodePoolsList() == null
                  ? ImmutableList.<AzureNodePool>of()
                  : payload.getAzureNodePoolsList();
            }
          };

  private static final PagedListResponseFactory<
          ListAzureClientsRequest, ListAzureClientsResponse, ListAzureClientsPagedResponse>
      LIST_AZURE_CLIENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAzureClientsRequest, ListAzureClientsResponse, ListAzureClientsPagedResponse>() {
            @Override
            public ApiFuture<ListAzureClientsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAzureClientsRequest, ListAzureClientsResponse> callable,
                ListAzureClientsRequest request,
                ApiCallContext context,
                ApiFuture<ListAzureClientsResponse> futureResponse) {
              PageContext<ListAzureClientsRequest, ListAzureClientsResponse, AzureClient>
                  pageContext =
                      PageContext.create(
                          callable, LIST_AZURE_CLIENTS_PAGE_STR_DESC, request, context);
              return ListAzureClientsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAzureClustersRequest, ListAzureClustersResponse, ListAzureClustersPagedResponse>
      LIST_AZURE_CLUSTERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAzureClustersRequest,
              ListAzureClustersResponse,
              ListAzureClustersPagedResponse>() {
            @Override
            public ApiFuture<ListAzureClustersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAzureClustersRequest, ListAzureClustersResponse> callable,
                ListAzureClustersRequest request,
                ApiCallContext context,
                ApiFuture<ListAzureClustersResponse> futureResponse) {
              PageContext<ListAzureClustersRequest, ListAzureClustersResponse, AzureCluster>
                  pageContext =
                      PageContext.create(
                          callable, LIST_AZURE_CLUSTERS_PAGE_STR_DESC, request, context);
              return ListAzureClustersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAzureNodePoolsRequest, ListAzureNodePoolsResponse, ListAzureNodePoolsPagedResponse>
      LIST_AZURE_NODE_POOLS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAzureNodePoolsRequest,
              ListAzureNodePoolsResponse,
              ListAzureNodePoolsPagedResponse>() {
            @Override
            public ApiFuture<ListAzureNodePoolsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAzureNodePoolsRequest, ListAzureNodePoolsResponse> callable,
                ListAzureNodePoolsRequest request,
                ApiCallContext context,
                ApiFuture<ListAzureNodePoolsResponse> futureResponse) {
              PageContext<ListAzureNodePoolsRequest, ListAzureNodePoolsResponse, AzureNodePool>
                  pageContext =
                      PageContext.create(
                          callable, LIST_AZURE_NODE_POOLS_PAGE_STR_DESC, request, context);
              return ListAzureNodePoolsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createAzureClient. */
  public UnaryCallSettings<CreateAzureClientRequest, Operation> createAzureClientSettings() {
    return createAzureClientSettings;
  }

  /** Returns the object with the settings used for calls to createAzureClient. */
  public OperationCallSettings<CreateAzureClientRequest, AzureClient, OperationMetadata>
      createAzureClientOperationSettings() {
    return createAzureClientOperationSettings;
  }

  /** Returns the object with the settings used for calls to getAzureClient. */
  public UnaryCallSettings<GetAzureClientRequest, AzureClient> getAzureClientSettings() {
    return getAzureClientSettings;
  }

  /** Returns the object with the settings used for calls to listAzureClients. */
  public PagedCallSettings<
          ListAzureClientsRequest, ListAzureClientsResponse, ListAzureClientsPagedResponse>
      listAzureClientsSettings() {
    return listAzureClientsSettings;
  }

  /** Returns the object with the settings used for calls to deleteAzureClient. */
  public UnaryCallSettings<DeleteAzureClientRequest, Operation> deleteAzureClientSettings() {
    return deleteAzureClientSettings;
  }

  /** Returns the object with the settings used for calls to deleteAzureClient. */
  public OperationCallSettings<DeleteAzureClientRequest, Empty, OperationMetadata>
      deleteAzureClientOperationSettings() {
    return deleteAzureClientOperationSettings;
  }

  /** Returns the object with the settings used for calls to createAzureCluster. */
  public UnaryCallSettings<CreateAzureClusterRequest, Operation> createAzureClusterSettings() {
    return createAzureClusterSettings;
  }

  /** Returns the object with the settings used for calls to createAzureCluster. */
  public OperationCallSettings<CreateAzureClusterRequest, AzureCluster, OperationMetadata>
      createAzureClusterOperationSettings() {
    return createAzureClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateAzureCluster. */
  public UnaryCallSettings<UpdateAzureClusterRequest, Operation> updateAzureClusterSettings() {
    return updateAzureClusterSettings;
  }

  /** Returns the object with the settings used for calls to updateAzureCluster. */
  public OperationCallSettings<UpdateAzureClusterRequest, AzureCluster, OperationMetadata>
      updateAzureClusterOperationSettings() {
    return updateAzureClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to getAzureCluster. */
  public UnaryCallSettings<GetAzureClusterRequest, AzureCluster> getAzureClusterSettings() {
    return getAzureClusterSettings;
  }

  /** Returns the object with the settings used for calls to listAzureClusters. */
  public PagedCallSettings<
          ListAzureClustersRequest, ListAzureClustersResponse, ListAzureClustersPagedResponse>
      listAzureClustersSettings() {
    return listAzureClustersSettings;
  }

  /** Returns the object with the settings used for calls to deleteAzureCluster. */
  public UnaryCallSettings<DeleteAzureClusterRequest, Operation> deleteAzureClusterSettings() {
    return deleteAzureClusterSettings;
  }

  /** Returns the object with the settings used for calls to deleteAzureCluster. */
  public OperationCallSettings<DeleteAzureClusterRequest, Empty, OperationMetadata>
      deleteAzureClusterOperationSettings() {
    return deleteAzureClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to generateAzureAccessToken. */
  public UnaryCallSettings<GenerateAzureAccessTokenRequest, GenerateAzureAccessTokenResponse>
      generateAzureAccessTokenSettings() {
    return generateAzureAccessTokenSettings;
  }

  /** Returns the object with the settings used for calls to createAzureNodePool. */
  public UnaryCallSettings<CreateAzureNodePoolRequest, Operation> createAzureNodePoolSettings() {
    return createAzureNodePoolSettings;
  }

  /** Returns the object with the settings used for calls to createAzureNodePool. */
  public OperationCallSettings<CreateAzureNodePoolRequest, AzureNodePool, OperationMetadata>
      createAzureNodePoolOperationSettings() {
    return createAzureNodePoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateAzureNodePool. */
  public UnaryCallSettings<UpdateAzureNodePoolRequest, Operation> updateAzureNodePoolSettings() {
    return updateAzureNodePoolSettings;
  }

  /** Returns the object with the settings used for calls to updateAzureNodePool. */
  public OperationCallSettings<UpdateAzureNodePoolRequest, AzureNodePool, OperationMetadata>
      updateAzureNodePoolOperationSettings() {
    return updateAzureNodePoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to getAzureNodePool. */
  public UnaryCallSettings<GetAzureNodePoolRequest, AzureNodePool> getAzureNodePoolSettings() {
    return getAzureNodePoolSettings;
  }

  /** Returns the object with the settings used for calls to listAzureNodePools. */
  public PagedCallSettings<
          ListAzureNodePoolsRequest, ListAzureNodePoolsResponse, ListAzureNodePoolsPagedResponse>
      listAzureNodePoolsSettings() {
    return listAzureNodePoolsSettings;
  }

  /** Returns the object with the settings used for calls to deleteAzureNodePool. */
  public UnaryCallSettings<DeleteAzureNodePoolRequest, Operation> deleteAzureNodePoolSettings() {
    return deleteAzureNodePoolSettings;
  }

  /** Returns the object with the settings used for calls to deleteAzureNodePool. */
  public OperationCallSettings<DeleteAzureNodePoolRequest, Empty, OperationMetadata>
      deleteAzureNodePoolOperationSettings() {
    return deleteAzureNodePoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to getAzureServerConfig. */
  public UnaryCallSettings<GetAzureServerConfigRequest, AzureServerConfig>
      getAzureServerConfigSettings() {
    return getAzureServerConfigSettings;
  }

  public AzureClustersStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAzureClustersStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAzureClustersStub.create(this);
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
    return "gkemulticloud.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "gkemulticloud.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(AzureClustersStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AzureClustersStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AzureClustersStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected AzureClustersStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createAzureClientSettings = settingsBuilder.createAzureClientSettings().build();
    createAzureClientOperationSettings =
        settingsBuilder.createAzureClientOperationSettings().build();
    getAzureClientSettings = settingsBuilder.getAzureClientSettings().build();
    listAzureClientsSettings = settingsBuilder.listAzureClientsSettings().build();
    deleteAzureClientSettings = settingsBuilder.deleteAzureClientSettings().build();
    deleteAzureClientOperationSettings =
        settingsBuilder.deleteAzureClientOperationSettings().build();
    createAzureClusterSettings = settingsBuilder.createAzureClusterSettings().build();
    createAzureClusterOperationSettings =
        settingsBuilder.createAzureClusterOperationSettings().build();
    updateAzureClusterSettings = settingsBuilder.updateAzureClusterSettings().build();
    updateAzureClusterOperationSettings =
        settingsBuilder.updateAzureClusterOperationSettings().build();
    getAzureClusterSettings = settingsBuilder.getAzureClusterSettings().build();
    listAzureClustersSettings = settingsBuilder.listAzureClustersSettings().build();
    deleteAzureClusterSettings = settingsBuilder.deleteAzureClusterSettings().build();
    deleteAzureClusterOperationSettings =
        settingsBuilder.deleteAzureClusterOperationSettings().build();
    generateAzureAccessTokenSettings = settingsBuilder.generateAzureAccessTokenSettings().build();
    createAzureNodePoolSettings = settingsBuilder.createAzureNodePoolSettings().build();
    createAzureNodePoolOperationSettings =
        settingsBuilder.createAzureNodePoolOperationSettings().build();
    updateAzureNodePoolSettings = settingsBuilder.updateAzureNodePoolSettings().build();
    updateAzureNodePoolOperationSettings =
        settingsBuilder.updateAzureNodePoolOperationSettings().build();
    getAzureNodePoolSettings = settingsBuilder.getAzureNodePoolSettings().build();
    listAzureNodePoolsSettings = settingsBuilder.listAzureNodePoolsSettings().build();
    deleteAzureNodePoolSettings = settingsBuilder.deleteAzureNodePoolSettings().build();
    deleteAzureNodePoolOperationSettings =
        settingsBuilder.deleteAzureNodePoolOperationSettings().build();
    getAzureServerConfigSettings = settingsBuilder.getAzureServerConfigSettings().build();
  }

  /** Builder for AzureClustersStubSettings. */
  public static class Builder extends StubSettings.Builder<AzureClustersStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateAzureClientRequest, Operation>
        createAzureClientSettings;
    private final OperationCallSettings.Builder<
            CreateAzureClientRequest, AzureClient, OperationMetadata>
        createAzureClientOperationSettings;
    private final UnaryCallSettings.Builder<GetAzureClientRequest, AzureClient>
        getAzureClientSettings;
    private final PagedCallSettings.Builder<
            ListAzureClientsRequest, ListAzureClientsResponse, ListAzureClientsPagedResponse>
        listAzureClientsSettings;
    private final UnaryCallSettings.Builder<DeleteAzureClientRequest, Operation>
        deleteAzureClientSettings;
    private final OperationCallSettings.Builder<DeleteAzureClientRequest, Empty, OperationMetadata>
        deleteAzureClientOperationSettings;
    private final UnaryCallSettings.Builder<CreateAzureClusterRequest, Operation>
        createAzureClusterSettings;
    private final OperationCallSettings.Builder<
            CreateAzureClusterRequest, AzureCluster, OperationMetadata>
        createAzureClusterOperationSettings;
    private final UnaryCallSettings.Builder<UpdateAzureClusterRequest, Operation>
        updateAzureClusterSettings;
    private final OperationCallSettings.Builder<
            UpdateAzureClusterRequest, AzureCluster, OperationMetadata>
        updateAzureClusterOperationSettings;
    private final UnaryCallSettings.Builder<GetAzureClusterRequest, AzureCluster>
        getAzureClusterSettings;
    private final PagedCallSettings.Builder<
            ListAzureClustersRequest, ListAzureClustersResponse, ListAzureClustersPagedResponse>
        listAzureClustersSettings;
    private final UnaryCallSettings.Builder<DeleteAzureClusterRequest, Operation>
        deleteAzureClusterSettings;
    private final OperationCallSettings.Builder<DeleteAzureClusterRequest, Empty, OperationMetadata>
        deleteAzureClusterOperationSettings;
    private final UnaryCallSettings.Builder<
            GenerateAzureAccessTokenRequest, GenerateAzureAccessTokenResponse>
        generateAzureAccessTokenSettings;
    private final UnaryCallSettings.Builder<CreateAzureNodePoolRequest, Operation>
        createAzureNodePoolSettings;
    private final OperationCallSettings.Builder<
            CreateAzureNodePoolRequest, AzureNodePool, OperationMetadata>
        createAzureNodePoolOperationSettings;
    private final UnaryCallSettings.Builder<UpdateAzureNodePoolRequest, Operation>
        updateAzureNodePoolSettings;
    private final OperationCallSettings.Builder<
            UpdateAzureNodePoolRequest, AzureNodePool, OperationMetadata>
        updateAzureNodePoolOperationSettings;
    private final UnaryCallSettings.Builder<GetAzureNodePoolRequest, AzureNodePool>
        getAzureNodePoolSettings;
    private final PagedCallSettings.Builder<
            ListAzureNodePoolsRequest, ListAzureNodePoolsResponse, ListAzureNodePoolsPagedResponse>
        listAzureNodePoolsSettings;
    private final UnaryCallSettings.Builder<DeleteAzureNodePoolRequest, Operation>
        deleteAzureNodePoolSettings;
    private final OperationCallSettings.Builder<
            DeleteAzureNodePoolRequest, Empty, OperationMetadata>
        deleteAzureNodePoolOperationSettings;
    private final UnaryCallSettings.Builder<GetAzureServerConfigRequest, AzureServerConfig>
        getAzureServerConfigSettings;
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
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createAzureClientSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAzureClientOperationSettings = OperationCallSettings.newBuilder();
      getAzureClientSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAzureClientsSettings = PagedCallSettings.newBuilder(LIST_AZURE_CLIENTS_PAGE_STR_FACT);
      deleteAzureClientSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAzureClientOperationSettings = OperationCallSettings.newBuilder();
      createAzureClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAzureClusterOperationSettings = OperationCallSettings.newBuilder();
      updateAzureClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAzureClusterOperationSettings = OperationCallSettings.newBuilder();
      getAzureClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAzureClustersSettings = PagedCallSettings.newBuilder(LIST_AZURE_CLUSTERS_PAGE_STR_FACT);
      deleteAzureClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAzureClusterOperationSettings = OperationCallSettings.newBuilder();
      generateAzureAccessTokenSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAzureNodePoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAzureNodePoolOperationSettings = OperationCallSettings.newBuilder();
      updateAzureNodePoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAzureNodePoolOperationSettings = OperationCallSettings.newBuilder();
      getAzureNodePoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAzureNodePoolsSettings =
          PagedCallSettings.newBuilder(LIST_AZURE_NODE_POOLS_PAGE_STR_FACT);
      deleteAzureNodePoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAzureNodePoolOperationSettings = OperationCallSettings.newBuilder();
      getAzureServerConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createAzureClientSettings,
              getAzureClientSettings,
              listAzureClientsSettings,
              deleteAzureClientSettings,
              createAzureClusterSettings,
              updateAzureClusterSettings,
              getAzureClusterSettings,
              listAzureClustersSettings,
              deleteAzureClusterSettings,
              generateAzureAccessTokenSettings,
              createAzureNodePoolSettings,
              updateAzureNodePoolSettings,
              getAzureNodePoolSettings,
              listAzureNodePoolsSettings,
              deleteAzureNodePoolSettings,
              getAzureServerConfigSettings);
      initDefaults(this);
    }

    protected Builder(AzureClustersStubSettings settings) {
      super(settings);

      createAzureClientSettings = settings.createAzureClientSettings.toBuilder();
      createAzureClientOperationSettings = settings.createAzureClientOperationSettings.toBuilder();
      getAzureClientSettings = settings.getAzureClientSettings.toBuilder();
      listAzureClientsSettings = settings.listAzureClientsSettings.toBuilder();
      deleteAzureClientSettings = settings.deleteAzureClientSettings.toBuilder();
      deleteAzureClientOperationSettings = settings.deleteAzureClientOperationSettings.toBuilder();
      createAzureClusterSettings = settings.createAzureClusterSettings.toBuilder();
      createAzureClusterOperationSettings =
          settings.createAzureClusterOperationSettings.toBuilder();
      updateAzureClusterSettings = settings.updateAzureClusterSettings.toBuilder();
      updateAzureClusterOperationSettings =
          settings.updateAzureClusterOperationSettings.toBuilder();
      getAzureClusterSettings = settings.getAzureClusterSettings.toBuilder();
      listAzureClustersSettings = settings.listAzureClustersSettings.toBuilder();
      deleteAzureClusterSettings = settings.deleteAzureClusterSettings.toBuilder();
      deleteAzureClusterOperationSettings =
          settings.deleteAzureClusterOperationSettings.toBuilder();
      generateAzureAccessTokenSettings = settings.generateAzureAccessTokenSettings.toBuilder();
      createAzureNodePoolSettings = settings.createAzureNodePoolSettings.toBuilder();
      createAzureNodePoolOperationSettings =
          settings.createAzureNodePoolOperationSettings.toBuilder();
      updateAzureNodePoolSettings = settings.updateAzureNodePoolSettings.toBuilder();
      updateAzureNodePoolOperationSettings =
          settings.updateAzureNodePoolOperationSettings.toBuilder();
      getAzureNodePoolSettings = settings.getAzureNodePoolSettings.toBuilder();
      listAzureNodePoolsSettings = settings.listAzureNodePoolsSettings.toBuilder();
      deleteAzureNodePoolSettings = settings.deleteAzureNodePoolSettings.toBuilder();
      deleteAzureNodePoolOperationSettings =
          settings.deleteAzureNodePoolOperationSettings.toBuilder();
      getAzureServerConfigSettings = settings.getAzureServerConfigSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createAzureClientSettings,
              getAzureClientSettings,
              listAzureClientsSettings,
              deleteAzureClientSettings,
              createAzureClusterSettings,
              updateAzureClusterSettings,
              getAzureClusterSettings,
              listAzureClustersSettings,
              deleteAzureClusterSettings,
              generateAzureAccessTokenSettings,
              createAzureNodePoolSettings,
              updateAzureNodePoolSettings,
              getAzureNodePoolSettings,
              listAzureNodePoolsSettings,
              deleteAzureNodePoolSettings,
              getAzureServerConfigSettings);
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
          .createAzureClientSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getAzureClientSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAzureClientsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteAzureClientSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createAzureClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateAzureClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getAzureClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAzureClustersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteAzureClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .generateAzureAccessTokenSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAzureNodePoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateAzureNodePoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getAzureNodePoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAzureNodePoolsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteAzureNodePoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getAzureServerConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAzureClientOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateAzureClientRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AzureClient.class))
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
          .deleteAzureClientOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteAzureClientRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .createAzureClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateAzureClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AzureCluster.class))
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
          .updateAzureClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateAzureClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AzureCluster.class))
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
          .deleteAzureClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteAzureClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .createAzureNodePoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateAzureNodePoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AzureNodePool.class))
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
          .updateAzureNodePoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateAzureNodePoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AzureNodePool.class))
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
          .deleteAzureNodePoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteAzureNodePoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to createAzureClient. */
    public UnaryCallSettings.Builder<CreateAzureClientRequest, Operation>
        createAzureClientSettings() {
      return createAzureClientSettings;
    }

    /** Returns the builder for the settings used for calls to createAzureClient. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateAzureClientRequest, AzureClient, OperationMetadata>
        createAzureClientOperationSettings() {
      return createAzureClientOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getAzureClient. */
    public UnaryCallSettings.Builder<GetAzureClientRequest, AzureClient> getAzureClientSettings() {
      return getAzureClientSettings;
    }

    /** Returns the builder for the settings used for calls to listAzureClients. */
    public PagedCallSettings.Builder<
            ListAzureClientsRequest, ListAzureClientsResponse, ListAzureClientsPagedResponse>
        listAzureClientsSettings() {
      return listAzureClientsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAzureClient. */
    public UnaryCallSettings.Builder<DeleteAzureClientRequest, Operation>
        deleteAzureClientSettings() {
      return deleteAzureClientSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAzureClient. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteAzureClientRequest, Empty, OperationMetadata>
        deleteAzureClientOperationSettings() {
      return deleteAzureClientOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createAzureCluster. */
    public UnaryCallSettings.Builder<CreateAzureClusterRequest, Operation>
        createAzureClusterSettings() {
      return createAzureClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createAzureCluster. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateAzureClusterRequest, AzureCluster, OperationMetadata>
        createAzureClusterOperationSettings() {
      return createAzureClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateAzureCluster. */
    public UnaryCallSettings.Builder<UpdateAzureClusterRequest, Operation>
        updateAzureClusterSettings() {
      return updateAzureClusterSettings;
    }

    /** Returns the builder for the settings used for calls to updateAzureCluster. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateAzureClusterRequest, AzureCluster, OperationMetadata>
        updateAzureClusterOperationSettings() {
      return updateAzureClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getAzureCluster. */
    public UnaryCallSettings.Builder<GetAzureClusterRequest, AzureCluster>
        getAzureClusterSettings() {
      return getAzureClusterSettings;
    }

    /** Returns the builder for the settings used for calls to listAzureClusters. */
    public PagedCallSettings.Builder<
            ListAzureClustersRequest, ListAzureClustersResponse, ListAzureClustersPagedResponse>
        listAzureClustersSettings() {
      return listAzureClustersSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAzureCluster. */
    public UnaryCallSettings.Builder<DeleteAzureClusterRequest, Operation>
        deleteAzureClusterSettings() {
      return deleteAzureClusterSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAzureCluster. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteAzureClusterRequest, Empty, OperationMetadata>
        deleteAzureClusterOperationSettings() {
      return deleteAzureClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to generateAzureAccessToken. */
    public UnaryCallSettings.Builder<
            GenerateAzureAccessTokenRequest, GenerateAzureAccessTokenResponse>
        generateAzureAccessTokenSettings() {
      return generateAzureAccessTokenSettings;
    }

    /** Returns the builder for the settings used for calls to createAzureNodePool. */
    public UnaryCallSettings.Builder<CreateAzureNodePoolRequest, Operation>
        createAzureNodePoolSettings() {
      return createAzureNodePoolSettings;
    }

    /** Returns the builder for the settings used for calls to createAzureNodePool. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateAzureNodePoolRequest, AzureNodePool, OperationMetadata>
        createAzureNodePoolOperationSettings() {
      return createAzureNodePoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateAzureNodePool. */
    public UnaryCallSettings.Builder<UpdateAzureNodePoolRequest, Operation>
        updateAzureNodePoolSettings() {
      return updateAzureNodePoolSettings;
    }

    /** Returns the builder for the settings used for calls to updateAzureNodePool. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateAzureNodePoolRequest, AzureNodePool, OperationMetadata>
        updateAzureNodePoolOperationSettings() {
      return updateAzureNodePoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getAzureNodePool. */
    public UnaryCallSettings.Builder<GetAzureNodePoolRequest, AzureNodePool>
        getAzureNodePoolSettings() {
      return getAzureNodePoolSettings;
    }

    /** Returns the builder for the settings used for calls to listAzureNodePools. */
    public PagedCallSettings.Builder<
            ListAzureNodePoolsRequest, ListAzureNodePoolsResponse, ListAzureNodePoolsPagedResponse>
        listAzureNodePoolsSettings() {
      return listAzureNodePoolsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAzureNodePool. */
    public UnaryCallSettings.Builder<DeleteAzureNodePoolRequest, Operation>
        deleteAzureNodePoolSettings() {
      return deleteAzureNodePoolSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAzureNodePool. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteAzureNodePoolRequest, Empty, OperationMetadata>
        deleteAzureNodePoolOperationSettings() {
      return deleteAzureNodePoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getAzureServerConfig. */
    public UnaryCallSettings.Builder<GetAzureServerConfigRequest, AzureServerConfig>
        getAzureServerConfigSettings() {
      return getAzureServerConfigSettings;
    }

    @Override
    public AzureClustersStubSettings build() throws IOException {
      return new AzureClustersStubSettings(this);
    }
  }
}
