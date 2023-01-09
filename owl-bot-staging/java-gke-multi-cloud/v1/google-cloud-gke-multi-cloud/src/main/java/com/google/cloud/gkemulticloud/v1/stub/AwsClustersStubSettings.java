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

import static com.google.cloud.gkemulticloud.v1.AwsClustersClient.ListAwsClustersPagedResponse;
import static com.google.cloud.gkemulticloud.v1.AwsClustersClient.ListAwsNodePoolsPagedResponse;

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
import com.google.cloud.gkemulticloud.v1.AwsCluster;
import com.google.cloud.gkemulticloud.v1.AwsNodePool;
import com.google.cloud.gkemulticloud.v1.AwsServerConfig;
import com.google.cloud.gkemulticloud.v1.CreateAwsClusterRequest;
import com.google.cloud.gkemulticloud.v1.CreateAwsNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAwsClusterRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAwsNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenResponse;
import com.google.cloud.gkemulticloud.v1.GetAwsClusterRequest;
import com.google.cloud.gkemulticloud.v1.GetAwsNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.GetAwsServerConfigRequest;
import com.google.cloud.gkemulticloud.v1.ListAwsClustersRequest;
import com.google.cloud.gkemulticloud.v1.ListAwsClustersResponse;
import com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsRequest;
import com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsResponse;
import com.google.cloud.gkemulticloud.v1.OperationMetadata;
import com.google.cloud.gkemulticloud.v1.UpdateAwsClusterRequest;
import com.google.cloud.gkemulticloud.v1.UpdateAwsNodePoolRequest;
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
 * Settings class to configure an instance of {@link AwsClustersStub}.
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
 * <p>For example, to set the total timeout of getAwsCluster to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AwsClustersStubSettings.Builder awsClustersSettingsBuilder =
 *     AwsClustersStubSettings.newBuilder();
 * awsClustersSettingsBuilder
 *     .getAwsClusterSettings()
 *     .setRetrySettings(
 *         awsClustersSettingsBuilder
 *             .getAwsClusterSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AwsClustersStubSettings awsClustersSettings = awsClustersSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AwsClustersStubSettings extends StubSettings<AwsClustersStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateAwsClusterRequest, Operation> createAwsClusterSettings;
  private final OperationCallSettings<CreateAwsClusterRequest, AwsCluster, OperationMetadata>
      createAwsClusterOperationSettings;
  private final UnaryCallSettings<UpdateAwsClusterRequest, Operation> updateAwsClusterSettings;
  private final OperationCallSettings<UpdateAwsClusterRequest, AwsCluster, OperationMetadata>
      updateAwsClusterOperationSettings;
  private final UnaryCallSettings<GetAwsClusterRequest, AwsCluster> getAwsClusterSettings;
  private final PagedCallSettings<
          ListAwsClustersRequest, ListAwsClustersResponse, ListAwsClustersPagedResponse>
      listAwsClustersSettings;
  private final UnaryCallSettings<DeleteAwsClusterRequest, Operation> deleteAwsClusterSettings;
  private final OperationCallSettings<DeleteAwsClusterRequest, Empty, OperationMetadata>
      deleteAwsClusterOperationSettings;
  private final UnaryCallSettings<GenerateAwsAccessTokenRequest, GenerateAwsAccessTokenResponse>
      generateAwsAccessTokenSettings;
  private final UnaryCallSettings<CreateAwsNodePoolRequest, Operation> createAwsNodePoolSettings;
  private final OperationCallSettings<CreateAwsNodePoolRequest, AwsNodePool, OperationMetadata>
      createAwsNodePoolOperationSettings;
  private final UnaryCallSettings<UpdateAwsNodePoolRequest, Operation> updateAwsNodePoolSettings;
  private final OperationCallSettings<UpdateAwsNodePoolRequest, AwsNodePool, OperationMetadata>
      updateAwsNodePoolOperationSettings;
  private final UnaryCallSettings<GetAwsNodePoolRequest, AwsNodePool> getAwsNodePoolSettings;
  private final PagedCallSettings<
          ListAwsNodePoolsRequest, ListAwsNodePoolsResponse, ListAwsNodePoolsPagedResponse>
      listAwsNodePoolsSettings;
  private final UnaryCallSettings<DeleteAwsNodePoolRequest, Operation> deleteAwsNodePoolSettings;
  private final OperationCallSettings<DeleteAwsNodePoolRequest, Empty, OperationMetadata>
      deleteAwsNodePoolOperationSettings;
  private final UnaryCallSettings<GetAwsServerConfigRequest, AwsServerConfig>
      getAwsServerConfigSettings;

  private static final PagedListDescriptor<
          ListAwsClustersRequest, ListAwsClustersResponse, AwsCluster>
      LIST_AWS_CLUSTERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListAwsClustersRequest, ListAwsClustersResponse, AwsCluster>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAwsClustersRequest injectToken(
                ListAwsClustersRequest payload, String token) {
              return ListAwsClustersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAwsClustersRequest injectPageSize(
                ListAwsClustersRequest payload, int pageSize) {
              return ListAwsClustersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAwsClustersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAwsClustersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AwsCluster> extractResources(ListAwsClustersResponse payload) {
              return payload.getAwsClustersList() == null
                  ? ImmutableList.<AwsCluster>of()
                  : payload.getAwsClustersList();
            }
          };

  private static final PagedListDescriptor<
          ListAwsNodePoolsRequest, ListAwsNodePoolsResponse, AwsNodePool>
      LIST_AWS_NODE_POOLS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAwsNodePoolsRequest, ListAwsNodePoolsResponse, AwsNodePool>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAwsNodePoolsRequest injectToken(
                ListAwsNodePoolsRequest payload, String token) {
              return ListAwsNodePoolsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAwsNodePoolsRequest injectPageSize(
                ListAwsNodePoolsRequest payload, int pageSize) {
              return ListAwsNodePoolsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAwsNodePoolsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAwsNodePoolsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AwsNodePool> extractResources(ListAwsNodePoolsResponse payload) {
              return payload.getAwsNodePoolsList() == null
                  ? ImmutableList.<AwsNodePool>of()
                  : payload.getAwsNodePoolsList();
            }
          };

  private static final PagedListResponseFactory<
          ListAwsClustersRequest, ListAwsClustersResponse, ListAwsClustersPagedResponse>
      LIST_AWS_CLUSTERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAwsClustersRequest, ListAwsClustersResponse, ListAwsClustersPagedResponse>() {
            @Override
            public ApiFuture<ListAwsClustersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAwsClustersRequest, ListAwsClustersResponse> callable,
                ListAwsClustersRequest request,
                ApiCallContext context,
                ApiFuture<ListAwsClustersResponse> futureResponse) {
              PageContext<ListAwsClustersRequest, ListAwsClustersResponse, AwsCluster> pageContext =
                  PageContext.create(callable, LIST_AWS_CLUSTERS_PAGE_STR_DESC, request, context);
              return ListAwsClustersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAwsNodePoolsRequest, ListAwsNodePoolsResponse, ListAwsNodePoolsPagedResponse>
      LIST_AWS_NODE_POOLS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAwsNodePoolsRequest, ListAwsNodePoolsResponse, ListAwsNodePoolsPagedResponse>() {
            @Override
            public ApiFuture<ListAwsNodePoolsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAwsNodePoolsRequest, ListAwsNodePoolsResponse> callable,
                ListAwsNodePoolsRequest request,
                ApiCallContext context,
                ApiFuture<ListAwsNodePoolsResponse> futureResponse) {
              PageContext<ListAwsNodePoolsRequest, ListAwsNodePoolsResponse, AwsNodePool>
                  pageContext =
                      PageContext.create(
                          callable, LIST_AWS_NODE_POOLS_PAGE_STR_DESC, request, context);
              return ListAwsNodePoolsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createAwsCluster. */
  public UnaryCallSettings<CreateAwsClusterRequest, Operation> createAwsClusterSettings() {
    return createAwsClusterSettings;
  }

  /** Returns the object with the settings used for calls to createAwsCluster. */
  public OperationCallSettings<CreateAwsClusterRequest, AwsCluster, OperationMetadata>
      createAwsClusterOperationSettings() {
    return createAwsClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateAwsCluster. */
  public UnaryCallSettings<UpdateAwsClusterRequest, Operation> updateAwsClusterSettings() {
    return updateAwsClusterSettings;
  }

  /** Returns the object with the settings used for calls to updateAwsCluster. */
  public OperationCallSettings<UpdateAwsClusterRequest, AwsCluster, OperationMetadata>
      updateAwsClusterOperationSettings() {
    return updateAwsClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to getAwsCluster. */
  public UnaryCallSettings<GetAwsClusterRequest, AwsCluster> getAwsClusterSettings() {
    return getAwsClusterSettings;
  }

  /** Returns the object with the settings used for calls to listAwsClusters. */
  public PagedCallSettings<
          ListAwsClustersRequest, ListAwsClustersResponse, ListAwsClustersPagedResponse>
      listAwsClustersSettings() {
    return listAwsClustersSettings;
  }

  /** Returns the object with the settings used for calls to deleteAwsCluster. */
  public UnaryCallSettings<DeleteAwsClusterRequest, Operation> deleteAwsClusterSettings() {
    return deleteAwsClusterSettings;
  }

  /** Returns the object with the settings used for calls to deleteAwsCluster. */
  public OperationCallSettings<DeleteAwsClusterRequest, Empty, OperationMetadata>
      deleteAwsClusterOperationSettings() {
    return deleteAwsClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to generateAwsAccessToken. */
  public UnaryCallSettings<GenerateAwsAccessTokenRequest, GenerateAwsAccessTokenResponse>
      generateAwsAccessTokenSettings() {
    return generateAwsAccessTokenSettings;
  }

  /** Returns the object with the settings used for calls to createAwsNodePool. */
  public UnaryCallSettings<CreateAwsNodePoolRequest, Operation> createAwsNodePoolSettings() {
    return createAwsNodePoolSettings;
  }

  /** Returns the object with the settings used for calls to createAwsNodePool. */
  public OperationCallSettings<CreateAwsNodePoolRequest, AwsNodePool, OperationMetadata>
      createAwsNodePoolOperationSettings() {
    return createAwsNodePoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateAwsNodePool. */
  public UnaryCallSettings<UpdateAwsNodePoolRequest, Operation> updateAwsNodePoolSettings() {
    return updateAwsNodePoolSettings;
  }

  /** Returns the object with the settings used for calls to updateAwsNodePool. */
  public OperationCallSettings<UpdateAwsNodePoolRequest, AwsNodePool, OperationMetadata>
      updateAwsNodePoolOperationSettings() {
    return updateAwsNodePoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to getAwsNodePool. */
  public UnaryCallSettings<GetAwsNodePoolRequest, AwsNodePool> getAwsNodePoolSettings() {
    return getAwsNodePoolSettings;
  }

  /** Returns the object with the settings used for calls to listAwsNodePools. */
  public PagedCallSettings<
          ListAwsNodePoolsRequest, ListAwsNodePoolsResponse, ListAwsNodePoolsPagedResponse>
      listAwsNodePoolsSettings() {
    return listAwsNodePoolsSettings;
  }

  /** Returns the object with the settings used for calls to deleteAwsNodePool. */
  public UnaryCallSettings<DeleteAwsNodePoolRequest, Operation> deleteAwsNodePoolSettings() {
    return deleteAwsNodePoolSettings;
  }

  /** Returns the object with the settings used for calls to deleteAwsNodePool. */
  public OperationCallSettings<DeleteAwsNodePoolRequest, Empty, OperationMetadata>
      deleteAwsNodePoolOperationSettings() {
    return deleteAwsNodePoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to getAwsServerConfig. */
  public UnaryCallSettings<GetAwsServerConfigRequest, AwsServerConfig>
      getAwsServerConfigSettings() {
    return getAwsServerConfigSettings;
  }

  public AwsClustersStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAwsClustersStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAwsClustersStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(AwsClustersStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AwsClustersStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AwsClustersStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected AwsClustersStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createAwsClusterSettings = settingsBuilder.createAwsClusterSettings().build();
    createAwsClusterOperationSettings = settingsBuilder.createAwsClusterOperationSettings().build();
    updateAwsClusterSettings = settingsBuilder.updateAwsClusterSettings().build();
    updateAwsClusterOperationSettings = settingsBuilder.updateAwsClusterOperationSettings().build();
    getAwsClusterSettings = settingsBuilder.getAwsClusterSettings().build();
    listAwsClustersSettings = settingsBuilder.listAwsClustersSettings().build();
    deleteAwsClusterSettings = settingsBuilder.deleteAwsClusterSettings().build();
    deleteAwsClusterOperationSettings = settingsBuilder.deleteAwsClusterOperationSettings().build();
    generateAwsAccessTokenSettings = settingsBuilder.generateAwsAccessTokenSettings().build();
    createAwsNodePoolSettings = settingsBuilder.createAwsNodePoolSettings().build();
    createAwsNodePoolOperationSettings =
        settingsBuilder.createAwsNodePoolOperationSettings().build();
    updateAwsNodePoolSettings = settingsBuilder.updateAwsNodePoolSettings().build();
    updateAwsNodePoolOperationSettings =
        settingsBuilder.updateAwsNodePoolOperationSettings().build();
    getAwsNodePoolSettings = settingsBuilder.getAwsNodePoolSettings().build();
    listAwsNodePoolsSettings = settingsBuilder.listAwsNodePoolsSettings().build();
    deleteAwsNodePoolSettings = settingsBuilder.deleteAwsNodePoolSettings().build();
    deleteAwsNodePoolOperationSettings =
        settingsBuilder.deleteAwsNodePoolOperationSettings().build();
    getAwsServerConfigSettings = settingsBuilder.getAwsServerConfigSettings().build();
  }

  /** Builder for AwsClustersStubSettings. */
  public static class Builder extends StubSettings.Builder<AwsClustersStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateAwsClusterRequest, Operation>
        createAwsClusterSettings;
    private final OperationCallSettings.Builder<
            CreateAwsClusterRequest, AwsCluster, OperationMetadata>
        createAwsClusterOperationSettings;
    private final UnaryCallSettings.Builder<UpdateAwsClusterRequest, Operation>
        updateAwsClusterSettings;
    private final OperationCallSettings.Builder<
            UpdateAwsClusterRequest, AwsCluster, OperationMetadata>
        updateAwsClusterOperationSettings;
    private final UnaryCallSettings.Builder<GetAwsClusterRequest, AwsCluster> getAwsClusterSettings;
    private final PagedCallSettings.Builder<
            ListAwsClustersRequest, ListAwsClustersResponse, ListAwsClustersPagedResponse>
        listAwsClustersSettings;
    private final UnaryCallSettings.Builder<DeleteAwsClusterRequest, Operation>
        deleteAwsClusterSettings;
    private final OperationCallSettings.Builder<DeleteAwsClusterRequest, Empty, OperationMetadata>
        deleteAwsClusterOperationSettings;
    private final UnaryCallSettings.Builder<
            GenerateAwsAccessTokenRequest, GenerateAwsAccessTokenResponse>
        generateAwsAccessTokenSettings;
    private final UnaryCallSettings.Builder<CreateAwsNodePoolRequest, Operation>
        createAwsNodePoolSettings;
    private final OperationCallSettings.Builder<
            CreateAwsNodePoolRequest, AwsNodePool, OperationMetadata>
        createAwsNodePoolOperationSettings;
    private final UnaryCallSettings.Builder<UpdateAwsNodePoolRequest, Operation>
        updateAwsNodePoolSettings;
    private final OperationCallSettings.Builder<
            UpdateAwsNodePoolRequest, AwsNodePool, OperationMetadata>
        updateAwsNodePoolOperationSettings;
    private final UnaryCallSettings.Builder<GetAwsNodePoolRequest, AwsNodePool>
        getAwsNodePoolSettings;
    private final PagedCallSettings.Builder<
            ListAwsNodePoolsRequest, ListAwsNodePoolsResponse, ListAwsNodePoolsPagedResponse>
        listAwsNodePoolsSettings;
    private final UnaryCallSettings.Builder<DeleteAwsNodePoolRequest, Operation>
        deleteAwsNodePoolSettings;
    private final OperationCallSettings.Builder<DeleteAwsNodePoolRequest, Empty, OperationMetadata>
        deleteAwsNodePoolOperationSettings;
    private final UnaryCallSettings.Builder<GetAwsServerConfigRequest, AwsServerConfig>
        getAwsServerConfigSettings;
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

      createAwsClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAwsClusterOperationSettings = OperationCallSettings.newBuilder();
      updateAwsClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAwsClusterOperationSettings = OperationCallSettings.newBuilder();
      getAwsClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAwsClustersSettings = PagedCallSettings.newBuilder(LIST_AWS_CLUSTERS_PAGE_STR_FACT);
      deleteAwsClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAwsClusterOperationSettings = OperationCallSettings.newBuilder();
      generateAwsAccessTokenSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAwsNodePoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAwsNodePoolOperationSettings = OperationCallSettings.newBuilder();
      updateAwsNodePoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAwsNodePoolOperationSettings = OperationCallSettings.newBuilder();
      getAwsNodePoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAwsNodePoolsSettings = PagedCallSettings.newBuilder(LIST_AWS_NODE_POOLS_PAGE_STR_FACT);
      deleteAwsNodePoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAwsNodePoolOperationSettings = OperationCallSettings.newBuilder();
      getAwsServerConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createAwsClusterSettings,
              updateAwsClusterSettings,
              getAwsClusterSettings,
              listAwsClustersSettings,
              deleteAwsClusterSettings,
              generateAwsAccessTokenSettings,
              createAwsNodePoolSettings,
              updateAwsNodePoolSettings,
              getAwsNodePoolSettings,
              listAwsNodePoolsSettings,
              deleteAwsNodePoolSettings,
              getAwsServerConfigSettings);
      initDefaults(this);
    }

    protected Builder(AwsClustersStubSettings settings) {
      super(settings);

      createAwsClusterSettings = settings.createAwsClusterSettings.toBuilder();
      createAwsClusterOperationSettings = settings.createAwsClusterOperationSettings.toBuilder();
      updateAwsClusterSettings = settings.updateAwsClusterSettings.toBuilder();
      updateAwsClusterOperationSettings = settings.updateAwsClusterOperationSettings.toBuilder();
      getAwsClusterSettings = settings.getAwsClusterSettings.toBuilder();
      listAwsClustersSettings = settings.listAwsClustersSettings.toBuilder();
      deleteAwsClusterSettings = settings.deleteAwsClusterSettings.toBuilder();
      deleteAwsClusterOperationSettings = settings.deleteAwsClusterOperationSettings.toBuilder();
      generateAwsAccessTokenSettings = settings.generateAwsAccessTokenSettings.toBuilder();
      createAwsNodePoolSettings = settings.createAwsNodePoolSettings.toBuilder();
      createAwsNodePoolOperationSettings = settings.createAwsNodePoolOperationSettings.toBuilder();
      updateAwsNodePoolSettings = settings.updateAwsNodePoolSettings.toBuilder();
      updateAwsNodePoolOperationSettings = settings.updateAwsNodePoolOperationSettings.toBuilder();
      getAwsNodePoolSettings = settings.getAwsNodePoolSettings.toBuilder();
      listAwsNodePoolsSettings = settings.listAwsNodePoolsSettings.toBuilder();
      deleteAwsNodePoolSettings = settings.deleteAwsNodePoolSettings.toBuilder();
      deleteAwsNodePoolOperationSettings = settings.deleteAwsNodePoolOperationSettings.toBuilder();
      getAwsServerConfigSettings = settings.getAwsServerConfigSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createAwsClusterSettings,
              updateAwsClusterSettings,
              getAwsClusterSettings,
              listAwsClustersSettings,
              deleteAwsClusterSettings,
              generateAwsAccessTokenSettings,
              createAwsNodePoolSettings,
              updateAwsNodePoolSettings,
              getAwsNodePoolSettings,
              listAwsNodePoolsSettings,
              deleteAwsNodePoolSettings,
              getAwsServerConfigSettings);
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
          .createAwsClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateAwsClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getAwsClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAwsClustersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteAwsClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .generateAwsAccessTokenSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAwsNodePoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateAwsNodePoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getAwsNodePoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAwsNodePoolsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteAwsNodePoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getAwsServerConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAwsClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateAwsClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AwsCluster.class))
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
          .updateAwsClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateAwsClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AwsCluster.class))
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
          .deleteAwsClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteAwsClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .createAwsNodePoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateAwsNodePoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AwsNodePool.class))
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
          .updateAwsNodePoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateAwsNodePoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AwsNodePool.class))
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
          .deleteAwsNodePoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteAwsNodePoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to createAwsCluster. */
    public UnaryCallSettings.Builder<CreateAwsClusterRequest, Operation>
        createAwsClusterSettings() {
      return createAwsClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createAwsCluster. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateAwsClusterRequest, AwsCluster, OperationMetadata>
        createAwsClusterOperationSettings() {
      return createAwsClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateAwsCluster. */
    public UnaryCallSettings.Builder<UpdateAwsClusterRequest, Operation>
        updateAwsClusterSettings() {
      return updateAwsClusterSettings;
    }

    /** Returns the builder for the settings used for calls to updateAwsCluster. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateAwsClusterRequest, AwsCluster, OperationMetadata>
        updateAwsClusterOperationSettings() {
      return updateAwsClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getAwsCluster. */
    public UnaryCallSettings.Builder<GetAwsClusterRequest, AwsCluster> getAwsClusterSettings() {
      return getAwsClusterSettings;
    }

    /** Returns the builder for the settings used for calls to listAwsClusters. */
    public PagedCallSettings.Builder<
            ListAwsClustersRequest, ListAwsClustersResponse, ListAwsClustersPagedResponse>
        listAwsClustersSettings() {
      return listAwsClustersSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAwsCluster. */
    public UnaryCallSettings.Builder<DeleteAwsClusterRequest, Operation>
        deleteAwsClusterSettings() {
      return deleteAwsClusterSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAwsCluster. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteAwsClusterRequest, Empty, OperationMetadata>
        deleteAwsClusterOperationSettings() {
      return deleteAwsClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to generateAwsAccessToken. */
    public UnaryCallSettings.Builder<GenerateAwsAccessTokenRequest, GenerateAwsAccessTokenResponse>
        generateAwsAccessTokenSettings() {
      return generateAwsAccessTokenSettings;
    }

    /** Returns the builder for the settings used for calls to createAwsNodePool. */
    public UnaryCallSettings.Builder<CreateAwsNodePoolRequest, Operation>
        createAwsNodePoolSettings() {
      return createAwsNodePoolSettings;
    }

    /** Returns the builder for the settings used for calls to createAwsNodePool. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateAwsNodePoolRequest, AwsNodePool, OperationMetadata>
        createAwsNodePoolOperationSettings() {
      return createAwsNodePoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateAwsNodePool. */
    public UnaryCallSettings.Builder<UpdateAwsNodePoolRequest, Operation>
        updateAwsNodePoolSettings() {
      return updateAwsNodePoolSettings;
    }

    /** Returns the builder for the settings used for calls to updateAwsNodePool. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateAwsNodePoolRequest, AwsNodePool, OperationMetadata>
        updateAwsNodePoolOperationSettings() {
      return updateAwsNodePoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getAwsNodePool. */
    public UnaryCallSettings.Builder<GetAwsNodePoolRequest, AwsNodePool> getAwsNodePoolSettings() {
      return getAwsNodePoolSettings;
    }

    /** Returns the builder for the settings used for calls to listAwsNodePools. */
    public PagedCallSettings.Builder<
            ListAwsNodePoolsRequest, ListAwsNodePoolsResponse, ListAwsNodePoolsPagedResponse>
        listAwsNodePoolsSettings() {
      return listAwsNodePoolsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAwsNodePool. */
    public UnaryCallSettings.Builder<DeleteAwsNodePoolRequest, Operation>
        deleteAwsNodePoolSettings() {
      return deleteAwsNodePoolSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAwsNodePool. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteAwsNodePoolRequest, Empty, OperationMetadata>
        deleteAwsNodePoolOperationSettings() {
      return deleteAwsNodePoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getAwsServerConfig. */
    public UnaryCallSettings.Builder<GetAwsServerConfigRequest, AwsServerConfig>
        getAwsServerConfigSettings() {
      return getAwsServerConfigSettings;
    }

    @Override
    public AwsClustersStubSettings build() throws IOException {
      return new AwsClustersStubSettings(this);
    }
  }
}
