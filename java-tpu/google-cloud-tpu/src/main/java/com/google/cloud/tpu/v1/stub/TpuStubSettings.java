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

package com.google.cloud.tpu.v1.stub;

import static com.google.cloud.tpu.v1.TpuClient.ListAcceleratorTypesPagedResponse;
import static com.google.cloud.tpu.v1.TpuClient.ListNodesPagedResponse;
import static com.google.cloud.tpu.v1.TpuClient.ListTensorFlowVersionsPagedResponse;

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
import com.google.cloud.tpu.v1.AcceleratorType;
import com.google.cloud.tpu.v1.CreateNodeRequest;
import com.google.cloud.tpu.v1.DeleteNodeRequest;
import com.google.cloud.tpu.v1.GetAcceleratorTypeRequest;
import com.google.cloud.tpu.v1.GetNodeRequest;
import com.google.cloud.tpu.v1.GetTensorFlowVersionRequest;
import com.google.cloud.tpu.v1.ListAcceleratorTypesRequest;
import com.google.cloud.tpu.v1.ListAcceleratorTypesResponse;
import com.google.cloud.tpu.v1.ListNodesRequest;
import com.google.cloud.tpu.v1.ListNodesResponse;
import com.google.cloud.tpu.v1.ListTensorFlowVersionsRequest;
import com.google.cloud.tpu.v1.ListTensorFlowVersionsResponse;
import com.google.cloud.tpu.v1.Node;
import com.google.cloud.tpu.v1.OperationMetadata;
import com.google.cloud.tpu.v1.ReimageNodeRequest;
import com.google.cloud.tpu.v1.StartNodeRequest;
import com.google.cloud.tpu.v1.StopNodeRequest;
import com.google.cloud.tpu.v1.TensorFlowVersion;
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
 * Settings class to configure an instance of {@link TpuStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (tpu.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getNode to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TpuStubSettings.Builder tpuSettingsBuilder = TpuStubSettings.newBuilder();
 * tpuSettingsBuilder
 *     .getNodeSettings()
 *     .setRetrySettings(
 *         tpuSettingsBuilder.getNodeSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TpuStubSettings tpuSettings = tpuSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class TpuStubSettings extends StubSettings<TpuStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<ListNodesRequest, ListNodesResponse, ListNodesPagedResponse>
      listNodesSettings;
  private final UnaryCallSettings<GetNodeRequest, Node> getNodeSettings;
  private final UnaryCallSettings<CreateNodeRequest, Operation> createNodeSettings;
  private final OperationCallSettings<CreateNodeRequest, Node, OperationMetadata>
      createNodeOperationSettings;
  private final UnaryCallSettings<DeleteNodeRequest, Operation> deleteNodeSettings;
  private final OperationCallSettings<DeleteNodeRequest, Node, OperationMetadata>
      deleteNodeOperationSettings;
  private final UnaryCallSettings<ReimageNodeRequest, Operation> reimageNodeSettings;
  private final OperationCallSettings<ReimageNodeRequest, Node, OperationMetadata>
      reimageNodeOperationSettings;
  private final UnaryCallSettings<StopNodeRequest, Operation> stopNodeSettings;
  private final OperationCallSettings<StopNodeRequest, Node, OperationMetadata>
      stopNodeOperationSettings;
  private final UnaryCallSettings<StartNodeRequest, Operation> startNodeSettings;
  private final OperationCallSettings<StartNodeRequest, Node, OperationMetadata>
      startNodeOperationSettings;
  private final PagedCallSettings<
          ListTensorFlowVersionsRequest,
          ListTensorFlowVersionsResponse,
          ListTensorFlowVersionsPagedResponse>
      listTensorFlowVersionsSettings;
  private final UnaryCallSettings<GetTensorFlowVersionRequest, TensorFlowVersion>
      getTensorFlowVersionSettings;
  private final PagedCallSettings<
          ListAcceleratorTypesRequest,
          ListAcceleratorTypesResponse,
          ListAcceleratorTypesPagedResponse>
      listAcceleratorTypesSettings;
  private final UnaryCallSettings<GetAcceleratorTypeRequest, AcceleratorType>
      getAcceleratorTypeSettings;

  private static final PagedListDescriptor<ListNodesRequest, ListNodesResponse, Node>
      LIST_NODES_PAGE_STR_DESC =
          new PagedListDescriptor<ListNodesRequest, ListNodesResponse, Node>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNodesRequest injectToken(ListNodesRequest payload, String token) {
              return ListNodesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNodesRequest injectPageSize(ListNodesRequest payload, int pageSize) {
              return ListNodesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListNodesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListNodesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Node> extractResources(ListNodesResponse payload) {
              return payload.getNodesList() == null
                  ? ImmutableList.<Node>of()
                  : payload.getNodesList();
            }
          };

  private static final PagedListDescriptor<
          ListTensorFlowVersionsRequest, ListTensorFlowVersionsResponse, TensorFlowVersion>
      LIST_TENSOR_FLOW_VERSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListTensorFlowVersionsRequest, ListTensorFlowVersionsResponse, TensorFlowVersion>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTensorFlowVersionsRequest injectToken(
                ListTensorFlowVersionsRequest payload, String token) {
              return ListTensorFlowVersionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTensorFlowVersionsRequest injectPageSize(
                ListTensorFlowVersionsRequest payload, int pageSize) {
              return ListTensorFlowVersionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListTensorFlowVersionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTensorFlowVersionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TensorFlowVersion> extractResources(
                ListTensorFlowVersionsResponse payload) {
              return payload.getTensorflowVersionsList() == null
                  ? ImmutableList.<TensorFlowVersion>of()
                  : payload.getTensorflowVersionsList();
            }
          };

  private static final PagedListDescriptor<
          ListAcceleratorTypesRequest, ListAcceleratorTypesResponse, AcceleratorType>
      LIST_ACCELERATOR_TYPES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAcceleratorTypesRequest, ListAcceleratorTypesResponse, AcceleratorType>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAcceleratorTypesRequest injectToken(
                ListAcceleratorTypesRequest payload, String token) {
              return ListAcceleratorTypesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAcceleratorTypesRequest injectPageSize(
                ListAcceleratorTypesRequest payload, int pageSize) {
              return ListAcceleratorTypesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAcceleratorTypesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAcceleratorTypesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AcceleratorType> extractResources(
                ListAcceleratorTypesResponse payload) {
              return payload.getAcceleratorTypesList() == null
                  ? ImmutableList.<AcceleratorType>of()
                  : payload.getAcceleratorTypesList();
            }
          };

  private static final PagedListResponseFactory<
          ListNodesRequest, ListNodesResponse, ListNodesPagedResponse>
      LIST_NODES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNodesRequest, ListNodesResponse, ListNodesPagedResponse>() {
            @Override
            public ApiFuture<ListNodesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNodesRequest, ListNodesResponse> callable,
                ListNodesRequest request,
                ApiCallContext context,
                ApiFuture<ListNodesResponse> futureResponse) {
              PageContext<ListNodesRequest, ListNodesResponse, Node> pageContext =
                  PageContext.create(callable, LIST_NODES_PAGE_STR_DESC, request, context);
              return ListNodesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTensorFlowVersionsRequest,
          ListTensorFlowVersionsResponse,
          ListTensorFlowVersionsPagedResponse>
      LIST_TENSOR_FLOW_VERSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTensorFlowVersionsRequest,
              ListTensorFlowVersionsResponse,
              ListTensorFlowVersionsPagedResponse>() {
            @Override
            public ApiFuture<ListTensorFlowVersionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTensorFlowVersionsRequest, ListTensorFlowVersionsResponse>
                    callable,
                ListTensorFlowVersionsRequest request,
                ApiCallContext context,
                ApiFuture<ListTensorFlowVersionsResponse> futureResponse) {
              PageContext<
                      ListTensorFlowVersionsRequest,
                      ListTensorFlowVersionsResponse,
                      TensorFlowVersion>
                  pageContext =
                      PageContext.create(
                          callable, LIST_TENSOR_FLOW_VERSIONS_PAGE_STR_DESC, request, context);
              return ListTensorFlowVersionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAcceleratorTypesRequest,
          ListAcceleratorTypesResponse,
          ListAcceleratorTypesPagedResponse>
      LIST_ACCELERATOR_TYPES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAcceleratorTypesRequest,
              ListAcceleratorTypesResponse,
              ListAcceleratorTypesPagedResponse>() {
            @Override
            public ApiFuture<ListAcceleratorTypesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAcceleratorTypesRequest, ListAcceleratorTypesResponse> callable,
                ListAcceleratorTypesRequest request,
                ApiCallContext context,
                ApiFuture<ListAcceleratorTypesResponse> futureResponse) {
              PageContext<
                      ListAcceleratorTypesRequest, ListAcceleratorTypesResponse, AcceleratorType>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ACCELERATOR_TYPES_PAGE_STR_DESC, request, context);
              return ListAcceleratorTypesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listNodes. */
  public PagedCallSettings<ListNodesRequest, ListNodesResponse, ListNodesPagedResponse>
      listNodesSettings() {
    return listNodesSettings;
  }

  /** Returns the object with the settings used for calls to getNode. */
  public UnaryCallSettings<GetNodeRequest, Node> getNodeSettings() {
    return getNodeSettings;
  }

  /** Returns the object with the settings used for calls to createNode. */
  public UnaryCallSettings<CreateNodeRequest, Operation> createNodeSettings() {
    return createNodeSettings;
  }

  /** Returns the object with the settings used for calls to createNode. */
  public OperationCallSettings<CreateNodeRequest, Node, OperationMetadata>
      createNodeOperationSettings() {
    return createNodeOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteNode. */
  public UnaryCallSettings<DeleteNodeRequest, Operation> deleteNodeSettings() {
    return deleteNodeSettings;
  }

  /** Returns the object with the settings used for calls to deleteNode. */
  public OperationCallSettings<DeleteNodeRequest, Node, OperationMetadata>
      deleteNodeOperationSettings() {
    return deleteNodeOperationSettings;
  }

  /** Returns the object with the settings used for calls to reimageNode. */
  public UnaryCallSettings<ReimageNodeRequest, Operation> reimageNodeSettings() {
    return reimageNodeSettings;
  }

  /** Returns the object with the settings used for calls to reimageNode. */
  public OperationCallSettings<ReimageNodeRequest, Node, OperationMetadata>
      reimageNodeOperationSettings() {
    return reimageNodeOperationSettings;
  }

  /** Returns the object with the settings used for calls to stopNode. */
  public UnaryCallSettings<StopNodeRequest, Operation> stopNodeSettings() {
    return stopNodeSettings;
  }

  /** Returns the object with the settings used for calls to stopNode. */
  public OperationCallSettings<StopNodeRequest, Node, OperationMetadata>
      stopNodeOperationSettings() {
    return stopNodeOperationSettings;
  }

  /** Returns the object with the settings used for calls to startNode. */
  public UnaryCallSettings<StartNodeRequest, Operation> startNodeSettings() {
    return startNodeSettings;
  }

  /** Returns the object with the settings used for calls to startNode. */
  public OperationCallSettings<StartNodeRequest, Node, OperationMetadata>
      startNodeOperationSettings() {
    return startNodeOperationSettings;
  }

  /** Returns the object with the settings used for calls to listTensorFlowVersions. */
  public PagedCallSettings<
          ListTensorFlowVersionsRequest,
          ListTensorFlowVersionsResponse,
          ListTensorFlowVersionsPagedResponse>
      listTensorFlowVersionsSettings() {
    return listTensorFlowVersionsSettings;
  }

  /** Returns the object with the settings used for calls to getTensorFlowVersion. */
  public UnaryCallSettings<GetTensorFlowVersionRequest, TensorFlowVersion>
      getTensorFlowVersionSettings() {
    return getTensorFlowVersionSettings;
  }

  /** Returns the object with the settings used for calls to listAcceleratorTypes. */
  public PagedCallSettings<
          ListAcceleratorTypesRequest,
          ListAcceleratorTypesResponse,
          ListAcceleratorTypesPagedResponse>
      listAcceleratorTypesSettings() {
    return listAcceleratorTypesSettings;
  }

  /** Returns the object with the settings used for calls to getAcceleratorType. */
  public UnaryCallSettings<GetAcceleratorTypeRequest, AcceleratorType>
      getAcceleratorTypeSettings() {
    return getAcceleratorTypeSettings;
  }

  public TpuStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcTpuStub.create(this);
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
    return "tpu.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "tpu.mtls.googleapis.com:443";
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
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(TpuStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
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

  protected TpuStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listNodesSettings = settingsBuilder.listNodesSettings().build();
    getNodeSettings = settingsBuilder.getNodeSettings().build();
    createNodeSettings = settingsBuilder.createNodeSettings().build();
    createNodeOperationSettings = settingsBuilder.createNodeOperationSettings().build();
    deleteNodeSettings = settingsBuilder.deleteNodeSettings().build();
    deleteNodeOperationSettings = settingsBuilder.deleteNodeOperationSettings().build();
    reimageNodeSettings = settingsBuilder.reimageNodeSettings().build();
    reimageNodeOperationSettings = settingsBuilder.reimageNodeOperationSettings().build();
    stopNodeSettings = settingsBuilder.stopNodeSettings().build();
    stopNodeOperationSettings = settingsBuilder.stopNodeOperationSettings().build();
    startNodeSettings = settingsBuilder.startNodeSettings().build();
    startNodeOperationSettings = settingsBuilder.startNodeOperationSettings().build();
    listTensorFlowVersionsSettings = settingsBuilder.listTensorFlowVersionsSettings().build();
    getTensorFlowVersionSettings = settingsBuilder.getTensorFlowVersionSettings().build();
    listAcceleratorTypesSettings = settingsBuilder.listAcceleratorTypesSettings().build();
    getAcceleratorTypeSettings = settingsBuilder.getAcceleratorTypeSettings().build();
  }

  /** Builder for TpuStubSettings. */
  public static class Builder extends StubSettings.Builder<TpuStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListNodesRequest, ListNodesResponse, ListNodesPagedResponse>
        listNodesSettings;
    private final UnaryCallSettings.Builder<GetNodeRequest, Node> getNodeSettings;
    private final UnaryCallSettings.Builder<CreateNodeRequest, Operation> createNodeSettings;
    private final OperationCallSettings.Builder<CreateNodeRequest, Node, OperationMetadata>
        createNodeOperationSettings;
    private final UnaryCallSettings.Builder<DeleteNodeRequest, Operation> deleteNodeSettings;
    private final OperationCallSettings.Builder<DeleteNodeRequest, Node, OperationMetadata>
        deleteNodeOperationSettings;
    private final UnaryCallSettings.Builder<ReimageNodeRequest, Operation> reimageNodeSettings;
    private final OperationCallSettings.Builder<ReimageNodeRequest, Node, OperationMetadata>
        reimageNodeOperationSettings;
    private final UnaryCallSettings.Builder<StopNodeRequest, Operation> stopNodeSettings;
    private final OperationCallSettings.Builder<StopNodeRequest, Node, OperationMetadata>
        stopNodeOperationSettings;
    private final UnaryCallSettings.Builder<StartNodeRequest, Operation> startNodeSettings;
    private final OperationCallSettings.Builder<StartNodeRequest, Node, OperationMetadata>
        startNodeOperationSettings;
    private final PagedCallSettings.Builder<
            ListTensorFlowVersionsRequest,
            ListTensorFlowVersionsResponse,
            ListTensorFlowVersionsPagedResponse>
        listTensorFlowVersionsSettings;
    private final UnaryCallSettings.Builder<GetTensorFlowVersionRequest, TensorFlowVersion>
        getTensorFlowVersionSettings;
    private final PagedCallSettings.Builder<
            ListAcceleratorTypesRequest,
            ListAcceleratorTypesResponse,
            ListAcceleratorTypesPagedResponse>
        listAcceleratorTypesSettings;
    private final UnaryCallSettings.Builder<GetAcceleratorTypeRequest, AcceleratorType>
        getAcceleratorTypeSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
      definitions.put("no_retry_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listNodesSettings = PagedCallSettings.newBuilder(LIST_NODES_PAGE_STR_FACT);
      getNodeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createNodeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createNodeOperationSettings = OperationCallSettings.newBuilder();
      deleteNodeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteNodeOperationSettings = OperationCallSettings.newBuilder();
      reimageNodeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      reimageNodeOperationSettings = OperationCallSettings.newBuilder();
      stopNodeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      stopNodeOperationSettings = OperationCallSettings.newBuilder();
      startNodeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      startNodeOperationSettings = OperationCallSettings.newBuilder();
      listTensorFlowVersionsSettings =
          PagedCallSettings.newBuilder(LIST_TENSOR_FLOW_VERSIONS_PAGE_STR_FACT);
      getTensorFlowVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAcceleratorTypesSettings =
          PagedCallSettings.newBuilder(LIST_ACCELERATOR_TYPES_PAGE_STR_FACT);
      getAcceleratorTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listNodesSettings,
              getNodeSettings,
              createNodeSettings,
              deleteNodeSettings,
              reimageNodeSettings,
              stopNodeSettings,
              startNodeSettings,
              listTensorFlowVersionsSettings,
              getTensorFlowVersionSettings,
              listAcceleratorTypesSettings,
              getAcceleratorTypeSettings);
      initDefaults(this);
    }

    protected Builder(TpuStubSettings settings) {
      super(settings);

      listNodesSettings = settings.listNodesSettings.toBuilder();
      getNodeSettings = settings.getNodeSettings.toBuilder();
      createNodeSettings = settings.createNodeSettings.toBuilder();
      createNodeOperationSettings = settings.createNodeOperationSettings.toBuilder();
      deleteNodeSettings = settings.deleteNodeSettings.toBuilder();
      deleteNodeOperationSettings = settings.deleteNodeOperationSettings.toBuilder();
      reimageNodeSettings = settings.reimageNodeSettings.toBuilder();
      reimageNodeOperationSettings = settings.reimageNodeOperationSettings.toBuilder();
      stopNodeSettings = settings.stopNodeSettings.toBuilder();
      stopNodeOperationSettings = settings.stopNodeOperationSettings.toBuilder();
      startNodeSettings = settings.startNodeSettings.toBuilder();
      startNodeOperationSettings = settings.startNodeOperationSettings.toBuilder();
      listTensorFlowVersionsSettings = settings.listTensorFlowVersionsSettings.toBuilder();
      getTensorFlowVersionSettings = settings.getTensorFlowVersionSettings.toBuilder();
      listAcceleratorTypesSettings = settings.listAcceleratorTypesSettings.toBuilder();
      getAcceleratorTypeSettings = settings.getAcceleratorTypeSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listNodesSettings,
              getNodeSettings,
              createNodeSettings,
              deleteNodeSettings,
              reimageNodeSettings,
              stopNodeSettings,
              startNodeSettings,
              listTensorFlowVersionsSettings,
              getTensorFlowVersionSettings,
              listAcceleratorTypesSettings,
              getAcceleratorTypeSettings);
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

    private static Builder initDefaults(Builder builder) {
      builder
          .listNodesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getNodeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createNodeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteNodeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .reimageNodeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .stopNodeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .startNodeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listTensorFlowVersionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getTensorFlowVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listAcceleratorTypesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getAcceleratorTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createNodeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateNodeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Node.class))
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
          .deleteNodeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteNodeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Node.class))
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
          .reimageNodeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<ReimageNodeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Node.class))
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
          .stopNodeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<StopNodeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Node.class))
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
          .startNodeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<StartNodeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Node.class))
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

    /** Returns the builder for the settings used for calls to listNodes. */
    public PagedCallSettings.Builder<ListNodesRequest, ListNodesResponse, ListNodesPagedResponse>
        listNodesSettings() {
      return listNodesSettings;
    }

    /** Returns the builder for the settings used for calls to getNode. */
    public UnaryCallSettings.Builder<GetNodeRequest, Node> getNodeSettings() {
      return getNodeSettings;
    }

    /** Returns the builder for the settings used for calls to createNode. */
    public UnaryCallSettings.Builder<CreateNodeRequest, Operation> createNodeSettings() {
      return createNodeSettings;
    }

    /** Returns the builder for the settings used for calls to createNode. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateNodeRequest, Node, OperationMetadata>
        createNodeOperationSettings() {
      return createNodeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNode. */
    public UnaryCallSettings.Builder<DeleteNodeRequest, Operation> deleteNodeSettings() {
      return deleteNodeSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNode. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteNodeRequest, Node, OperationMetadata>
        deleteNodeOperationSettings() {
      return deleteNodeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to reimageNode. */
    public UnaryCallSettings.Builder<ReimageNodeRequest, Operation> reimageNodeSettings() {
      return reimageNodeSettings;
    }

    /** Returns the builder for the settings used for calls to reimageNode. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<ReimageNodeRequest, Node, OperationMetadata>
        reimageNodeOperationSettings() {
      return reimageNodeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to stopNode. */
    public UnaryCallSettings.Builder<StopNodeRequest, Operation> stopNodeSettings() {
      return stopNodeSettings;
    }

    /** Returns the builder for the settings used for calls to stopNode. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<StopNodeRequest, Node, OperationMetadata>
        stopNodeOperationSettings() {
      return stopNodeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to startNode. */
    public UnaryCallSettings.Builder<StartNodeRequest, Operation> startNodeSettings() {
      return startNodeSettings;
    }

    /** Returns the builder for the settings used for calls to startNode. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<StartNodeRequest, Node, OperationMetadata>
        startNodeOperationSettings() {
      return startNodeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listTensorFlowVersions. */
    public PagedCallSettings.Builder<
            ListTensorFlowVersionsRequest,
            ListTensorFlowVersionsResponse,
            ListTensorFlowVersionsPagedResponse>
        listTensorFlowVersionsSettings() {
      return listTensorFlowVersionsSettings;
    }

    /** Returns the builder for the settings used for calls to getTensorFlowVersion. */
    public UnaryCallSettings.Builder<GetTensorFlowVersionRequest, TensorFlowVersion>
        getTensorFlowVersionSettings() {
      return getTensorFlowVersionSettings;
    }

    /** Returns the builder for the settings used for calls to listAcceleratorTypes. */
    public PagedCallSettings.Builder<
            ListAcceleratorTypesRequest,
            ListAcceleratorTypesResponse,
            ListAcceleratorTypesPagedResponse>
        listAcceleratorTypesSettings() {
      return listAcceleratorTypesSettings;
    }

    /** Returns the builder for the settings used for calls to getAcceleratorType. */
    public UnaryCallSettings.Builder<GetAcceleratorTypeRequest, AcceleratorType>
        getAcceleratorTypeSettings() {
      return getAcceleratorTypeSettings;
    }

    @Override
    public TpuStubSettings build() throws IOException {
      return new TpuStubSettings(this);
    }
  }
}
