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

package com.google.cloud.tpu.v2alpha1.stub;

import static com.google.cloud.tpu.v2alpha1.TpuClient.ListAcceleratorTypesPagedResponse;
import static com.google.cloud.tpu.v2alpha1.TpuClient.ListLocationsPagedResponse;
import static com.google.cloud.tpu.v2alpha1.TpuClient.ListNodesPagedResponse;
import static com.google.cloud.tpu.v2alpha1.TpuClient.ListQueuedResourcesPagedResponse;
import static com.google.cloud.tpu.v2alpha1.TpuClient.ListRuntimeVersionsPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.tpu.v2alpha1.AcceleratorType;
import com.google.cloud.tpu.v2alpha1.CreateNodeRequest;
import com.google.cloud.tpu.v2alpha1.CreateQueuedResourceRequest;
import com.google.cloud.tpu.v2alpha1.DeleteNodeRequest;
import com.google.cloud.tpu.v2alpha1.DeleteQueuedResourceRequest;
import com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityRequest;
import com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityResponse;
import com.google.cloud.tpu.v2alpha1.GetAcceleratorTypeRequest;
import com.google.cloud.tpu.v2alpha1.GetGuestAttributesRequest;
import com.google.cloud.tpu.v2alpha1.GetGuestAttributesResponse;
import com.google.cloud.tpu.v2alpha1.GetNodeRequest;
import com.google.cloud.tpu.v2alpha1.GetQueuedResourceRequest;
import com.google.cloud.tpu.v2alpha1.GetRuntimeVersionRequest;
import com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesRequest;
import com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesResponse;
import com.google.cloud.tpu.v2alpha1.ListNodesRequest;
import com.google.cloud.tpu.v2alpha1.ListNodesResponse;
import com.google.cloud.tpu.v2alpha1.ListQueuedResourcesRequest;
import com.google.cloud.tpu.v2alpha1.ListQueuedResourcesResponse;
import com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsRequest;
import com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsResponse;
import com.google.cloud.tpu.v2alpha1.Node;
import com.google.cloud.tpu.v2alpha1.OperationMetadata;
import com.google.cloud.tpu.v2alpha1.QueuedResource;
import com.google.cloud.tpu.v2alpha1.RuntimeVersion;
import com.google.cloud.tpu.v2alpha1.SimulateMaintenanceEventRequest;
import com.google.cloud.tpu.v2alpha1.StartNodeRequest;
import com.google.cloud.tpu.v2alpha1.StopNodeRequest;
import com.google.cloud.tpu.v2alpha1.UpdateNodeRequest;
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
@BetaApi
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
  private final OperationCallSettings<DeleteNodeRequest, Empty, OperationMetadata>
      deleteNodeOperationSettings;
  private final UnaryCallSettings<StopNodeRequest, Operation> stopNodeSettings;
  private final OperationCallSettings<StopNodeRequest, Node, OperationMetadata>
      stopNodeOperationSettings;
  private final UnaryCallSettings<StartNodeRequest, Operation> startNodeSettings;
  private final OperationCallSettings<StartNodeRequest, Node, OperationMetadata>
      startNodeOperationSettings;
  private final UnaryCallSettings<UpdateNodeRequest, Operation> updateNodeSettings;
  private final OperationCallSettings<UpdateNodeRequest, Node, OperationMetadata>
      updateNodeOperationSettings;
  private final PagedCallSettings<
          ListQueuedResourcesRequest, ListQueuedResourcesResponse, ListQueuedResourcesPagedResponse>
      listQueuedResourcesSettings;
  private final UnaryCallSettings<GetQueuedResourceRequest, QueuedResource>
      getQueuedResourceSettings;
  private final UnaryCallSettings<CreateQueuedResourceRequest, Operation>
      createQueuedResourceSettings;
  private final OperationCallSettings<
          CreateQueuedResourceRequest, QueuedResource, OperationMetadata>
      createQueuedResourceOperationSettings;
  private final UnaryCallSettings<DeleteQueuedResourceRequest, Operation>
      deleteQueuedResourceSettings;
  private final OperationCallSettings<
          DeleteQueuedResourceRequest, QueuedResource, OperationMetadata>
      deleteQueuedResourceOperationSettings;
  private final UnaryCallSettings<GenerateServiceIdentityRequest, GenerateServiceIdentityResponse>
      generateServiceIdentitySettings;
  private final PagedCallSettings<
          ListAcceleratorTypesRequest,
          ListAcceleratorTypesResponse,
          ListAcceleratorTypesPagedResponse>
      listAcceleratorTypesSettings;
  private final UnaryCallSettings<GetAcceleratorTypeRequest, AcceleratorType>
      getAcceleratorTypeSettings;
  private final PagedCallSettings<
          ListRuntimeVersionsRequest, ListRuntimeVersionsResponse, ListRuntimeVersionsPagedResponse>
      listRuntimeVersionsSettings;
  private final UnaryCallSettings<GetRuntimeVersionRequest, RuntimeVersion>
      getRuntimeVersionSettings;
  private final UnaryCallSettings<GetGuestAttributesRequest, GetGuestAttributesResponse>
      getGuestAttributesSettings;
  private final UnaryCallSettings<SimulateMaintenanceEventRequest, Operation>
      simulateMaintenanceEventSettings;
  private final OperationCallSettings<SimulateMaintenanceEventRequest, Node, OperationMetadata>
      simulateMaintenanceEventOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

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
          ListQueuedResourcesRequest, ListQueuedResourcesResponse, QueuedResource>
      LIST_QUEUED_RESOURCES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListQueuedResourcesRequest, ListQueuedResourcesResponse, QueuedResource>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListQueuedResourcesRequest injectToken(
                ListQueuedResourcesRequest payload, String token) {
              return ListQueuedResourcesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListQueuedResourcesRequest injectPageSize(
                ListQueuedResourcesRequest payload, int pageSize) {
              return ListQueuedResourcesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListQueuedResourcesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListQueuedResourcesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<QueuedResource> extractResources(ListQueuedResourcesResponse payload) {
              return payload.getQueuedResourcesList() == null
                  ? ImmutableList.<QueuedResource>of()
                  : payload.getQueuedResourcesList();
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

  private static final PagedListDescriptor<
          ListRuntimeVersionsRequest, ListRuntimeVersionsResponse, RuntimeVersion>
      LIST_RUNTIME_VERSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListRuntimeVersionsRequest, ListRuntimeVersionsResponse, RuntimeVersion>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRuntimeVersionsRequest injectToken(
                ListRuntimeVersionsRequest payload, String token) {
              return ListRuntimeVersionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRuntimeVersionsRequest injectPageSize(
                ListRuntimeVersionsRequest payload, int pageSize) {
              return ListRuntimeVersionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRuntimeVersionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRuntimeVersionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<RuntimeVersion> extractResources(ListRuntimeVersionsResponse payload) {
              return payload.getRuntimeVersionsList() == null
                  ? ImmutableList.<RuntimeVersion>of()
                  : payload.getRuntimeVersionsList();
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
          ListQueuedResourcesRequest, ListQueuedResourcesResponse, ListQueuedResourcesPagedResponse>
      LIST_QUEUED_RESOURCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListQueuedResourcesRequest,
              ListQueuedResourcesResponse,
              ListQueuedResourcesPagedResponse>() {
            @Override
            public ApiFuture<ListQueuedResourcesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListQueuedResourcesRequest, ListQueuedResourcesResponse> callable,
                ListQueuedResourcesRequest request,
                ApiCallContext context,
                ApiFuture<ListQueuedResourcesResponse> futureResponse) {
              PageContext<ListQueuedResourcesRequest, ListQueuedResourcesResponse, QueuedResource>
                  pageContext =
                      PageContext.create(
                          callable, LIST_QUEUED_RESOURCES_PAGE_STR_DESC, request, context);
              return ListQueuedResourcesPagedResponse.createAsync(pageContext, futureResponse);
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

  private static final PagedListResponseFactory<
          ListRuntimeVersionsRequest, ListRuntimeVersionsResponse, ListRuntimeVersionsPagedResponse>
      LIST_RUNTIME_VERSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRuntimeVersionsRequest,
              ListRuntimeVersionsResponse,
              ListRuntimeVersionsPagedResponse>() {
            @Override
            public ApiFuture<ListRuntimeVersionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRuntimeVersionsRequest, ListRuntimeVersionsResponse> callable,
                ListRuntimeVersionsRequest request,
                ApiCallContext context,
                ApiFuture<ListRuntimeVersionsResponse> futureResponse) {
              PageContext<ListRuntimeVersionsRequest, ListRuntimeVersionsResponse, RuntimeVersion>
                  pageContext =
                      PageContext.create(
                          callable, LIST_RUNTIME_VERSIONS_PAGE_STR_DESC, request, context);
              return ListRuntimeVersionsPagedResponse.createAsync(pageContext, futureResponse);
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
  public OperationCallSettings<DeleteNodeRequest, Empty, OperationMetadata>
      deleteNodeOperationSettings() {
    return deleteNodeOperationSettings;
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

  /** Returns the object with the settings used for calls to updateNode. */
  public UnaryCallSettings<UpdateNodeRequest, Operation> updateNodeSettings() {
    return updateNodeSettings;
  }

  /** Returns the object with the settings used for calls to updateNode. */
  public OperationCallSettings<UpdateNodeRequest, Node, OperationMetadata>
      updateNodeOperationSettings() {
    return updateNodeOperationSettings;
  }

  /** Returns the object with the settings used for calls to listQueuedResources. */
  public PagedCallSettings<
          ListQueuedResourcesRequest, ListQueuedResourcesResponse, ListQueuedResourcesPagedResponse>
      listQueuedResourcesSettings() {
    return listQueuedResourcesSettings;
  }

  /** Returns the object with the settings used for calls to getQueuedResource. */
  public UnaryCallSettings<GetQueuedResourceRequest, QueuedResource> getQueuedResourceSettings() {
    return getQueuedResourceSettings;
  }

  /** Returns the object with the settings used for calls to createQueuedResource. */
  public UnaryCallSettings<CreateQueuedResourceRequest, Operation> createQueuedResourceSettings() {
    return createQueuedResourceSettings;
  }

  /** Returns the object with the settings used for calls to createQueuedResource. */
  public OperationCallSettings<CreateQueuedResourceRequest, QueuedResource, OperationMetadata>
      createQueuedResourceOperationSettings() {
    return createQueuedResourceOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteQueuedResource. */
  public UnaryCallSettings<DeleteQueuedResourceRequest, Operation> deleteQueuedResourceSettings() {
    return deleteQueuedResourceSettings;
  }

  /** Returns the object with the settings used for calls to deleteQueuedResource. */
  public OperationCallSettings<DeleteQueuedResourceRequest, QueuedResource, OperationMetadata>
      deleteQueuedResourceOperationSettings() {
    return deleteQueuedResourceOperationSettings;
  }

  /** Returns the object with the settings used for calls to generateServiceIdentity. */
  public UnaryCallSettings<GenerateServiceIdentityRequest, GenerateServiceIdentityResponse>
      generateServiceIdentitySettings() {
    return generateServiceIdentitySettings;
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

  /** Returns the object with the settings used for calls to listRuntimeVersions. */
  public PagedCallSettings<
          ListRuntimeVersionsRequest, ListRuntimeVersionsResponse, ListRuntimeVersionsPagedResponse>
      listRuntimeVersionsSettings() {
    return listRuntimeVersionsSettings;
  }

  /** Returns the object with the settings used for calls to getRuntimeVersion. */
  public UnaryCallSettings<GetRuntimeVersionRequest, RuntimeVersion> getRuntimeVersionSettings() {
    return getRuntimeVersionSettings;
  }

  /** Returns the object with the settings used for calls to getGuestAttributes. */
  public UnaryCallSettings<GetGuestAttributesRequest, GetGuestAttributesResponse>
      getGuestAttributesSettings() {
    return getGuestAttributesSettings;
  }

  /** Returns the object with the settings used for calls to simulateMaintenanceEvent. */
  public UnaryCallSettings<SimulateMaintenanceEventRequest, Operation>
      simulateMaintenanceEventSettings() {
    return simulateMaintenanceEventSettings;
  }

  /** Returns the object with the settings used for calls to simulateMaintenanceEvent. */
  public OperationCallSettings<SimulateMaintenanceEventRequest, Node, OperationMetadata>
      simulateMaintenanceEventOperationSettings() {
    return simulateMaintenanceEventOperationSettings;
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
    stopNodeSettings = settingsBuilder.stopNodeSettings().build();
    stopNodeOperationSettings = settingsBuilder.stopNodeOperationSettings().build();
    startNodeSettings = settingsBuilder.startNodeSettings().build();
    startNodeOperationSettings = settingsBuilder.startNodeOperationSettings().build();
    updateNodeSettings = settingsBuilder.updateNodeSettings().build();
    updateNodeOperationSettings = settingsBuilder.updateNodeOperationSettings().build();
    listQueuedResourcesSettings = settingsBuilder.listQueuedResourcesSettings().build();
    getQueuedResourceSettings = settingsBuilder.getQueuedResourceSettings().build();
    createQueuedResourceSettings = settingsBuilder.createQueuedResourceSettings().build();
    createQueuedResourceOperationSettings =
        settingsBuilder.createQueuedResourceOperationSettings().build();
    deleteQueuedResourceSettings = settingsBuilder.deleteQueuedResourceSettings().build();
    deleteQueuedResourceOperationSettings =
        settingsBuilder.deleteQueuedResourceOperationSettings().build();
    generateServiceIdentitySettings = settingsBuilder.generateServiceIdentitySettings().build();
    listAcceleratorTypesSettings = settingsBuilder.listAcceleratorTypesSettings().build();
    getAcceleratorTypeSettings = settingsBuilder.getAcceleratorTypeSettings().build();
    listRuntimeVersionsSettings = settingsBuilder.listRuntimeVersionsSettings().build();
    getRuntimeVersionSettings = settingsBuilder.getRuntimeVersionSettings().build();
    getGuestAttributesSettings = settingsBuilder.getGuestAttributesSettings().build();
    simulateMaintenanceEventSettings = settingsBuilder.simulateMaintenanceEventSettings().build();
    simulateMaintenanceEventOperationSettings =
        settingsBuilder.simulateMaintenanceEventOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
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
    private final OperationCallSettings.Builder<DeleteNodeRequest, Empty, OperationMetadata>
        deleteNodeOperationSettings;
    private final UnaryCallSettings.Builder<StopNodeRequest, Operation> stopNodeSettings;
    private final OperationCallSettings.Builder<StopNodeRequest, Node, OperationMetadata>
        stopNodeOperationSettings;
    private final UnaryCallSettings.Builder<StartNodeRequest, Operation> startNodeSettings;
    private final OperationCallSettings.Builder<StartNodeRequest, Node, OperationMetadata>
        startNodeOperationSettings;
    private final UnaryCallSettings.Builder<UpdateNodeRequest, Operation> updateNodeSettings;
    private final OperationCallSettings.Builder<UpdateNodeRequest, Node, OperationMetadata>
        updateNodeOperationSettings;
    private final PagedCallSettings.Builder<
            ListQueuedResourcesRequest,
            ListQueuedResourcesResponse,
            ListQueuedResourcesPagedResponse>
        listQueuedResourcesSettings;
    private final UnaryCallSettings.Builder<GetQueuedResourceRequest, QueuedResource>
        getQueuedResourceSettings;
    private final UnaryCallSettings.Builder<CreateQueuedResourceRequest, Operation>
        createQueuedResourceSettings;
    private final OperationCallSettings.Builder<
            CreateQueuedResourceRequest, QueuedResource, OperationMetadata>
        createQueuedResourceOperationSettings;
    private final UnaryCallSettings.Builder<DeleteQueuedResourceRequest, Operation>
        deleteQueuedResourceSettings;
    private final OperationCallSettings.Builder<
            DeleteQueuedResourceRequest, QueuedResource, OperationMetadata>
        deleteQueuedResourceOperationSettings;
    private final UnaryCallSettings.Builder<
            GenerateServiceIdentityRequest, GenerateServiceIdentityResponse>
        generateServiceIdentitySettings;
    private final PagedCallSettings.Builder<
            ListAcceleratorTypesRequest,
            ListAcceleratorTypesResponse,
            ListAcceleratorTypesPagedResponse>
        listAcceleratorTypesSettings;
    private final UnaryCallSettings.Builder<GetAcceleratorTypeRequest, AcceleratorType>
        getAcceleratorTypeSettings;
    private final PagedCallSettings.Builder<
            ListRuntimeVersionsRequest,
            ListRuntimeVersionsResponse,
            ListRuntimeVersionsPagedResponse>
        listRuntimeVersionsSettings;
    private final UnaryCallSettings.Builder<GetRuntimeVersionRequest, RuntimeVersion>
        getRuntimeVersionSettings;
    private final UnaryCallSettings.Builder<GetGuestAttributesRequest, GetGuestAttributesResponse>
        getGuestAttributesSettings;
    private final UnaryCallSettings.Builder<SimulateMaintenanceEventRequest, Operation>
        simulateMaintenanceEventSettings;
    private final OperationCallSettings.Builder<
            SimulateMaintenanceEventRequest, Node, OperationMetadata>
        simulateMaintenanceEventOperationSettings;
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
      stopNodeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      stopNodeOperationSettings = OperationCallSettings.newBuilder();
      startNodeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      startNodeOperationSettings = OperationCallSettings.newBuilder();
      updateNodeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateNodeOperationSettings = OperationCallSettings.newBuilder();
      listQueuedResourcesSettings =
          PagedCallSettings.newBuilder(LIST_QUEUED_RESOURCES_PAGE_STR_FACT);
      getQueuedResourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createQueuedResourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createQueuedResourceOperationSettings = OperationCallSettings.newBuilder();
      deleteQueuedResourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteQueuedResourceOperationSettings = OperationCallSettings.newBuilder();
      generateServiceIdentitySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAcceleratorTypesSettings =
          PagedCallSettings.newBuilder(LIST_ACCELERATOR_TYPES_PAGE_STR_FACT);
      getAcceleratorTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listRuntimeVersionsSettings =
          PagedCallSettings.newBuilder(LIST_RUNTIME_VERSIONS_PAGE_STR_FACT);
      getRuntimeVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getGuestAttributesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      simulateMaintenanceEventSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      simulateMaintenanceEventOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listNodesSettings,
              getNodeSettings,
              createNodeSettings,
              deleteNodeSettings,
              stopNodeSettings,
              startNodeSettings,
              updateNodeSettings,
              listQueuedResourcesSettings,
              getQueuedResourceSettings,
              createQueuedResourceSettings,
              deleteQueuedResourceSettings,
              generateServiceIdentitySettings,
              listAcceleratorTypesSettings,
              getAcceleratorTypeSettings,
              listRuntimeVersionsSettings,
              getRuntimeVersionSettings,
              getGuestAttributesSettings,
              simulateMaintenanceEventSettings,
              listLocationsSettings,
              getLocationSettings);
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
      stopNodeSettings = settings.stopNodeSettings.toBuilder();
      stopNodeOperationSettings = settings.stopNodeOperationSettings.toBuilder();
      startNodeSettings = settings.startNodeSettings.toBuilder();
      startNodeOperationSettings = settings.startNodeOperationSettings.toBuilder();
      updateNodeSettings = settings.updateNodeSettings.toBuilder();
      updateNodeOperationSettings = settings.updateNodeOperationSettings.toBuilder();
      listQueuedResourcesSettings = settings.listQueuedResourcesSettings.toBuilder();
      getQueuedResourceSettings = settings.getQueuedResourceSettings.toBuilder();
      createQueuedResourceSettings = settings.createQueuedResourceSettings.toBuilder();
      createQueuedResourceOperationSettings =
          settings.createQueuedResourceOperationSettings.toBuilder();
      deleteQueuedResourceSettings = settings.deleteQueuedResourceSettings.toBuilder();
      deleteQueuedResourceOperationSettings =
          settings.deleteQueuedResourceOperationSettings.toBuilder();
      generateServiceIdentitySettings = settings.generateServiceIdentitySettings.toBuilder();
      listAcceleratorTypesSettings = settings.listAcceleratorTypesSettings.toBuilder();
      getAcceleratorTypeSettings = settings.getAcceleratorTypeSettings.toBuilder();
      listRuntimeVersionsSettings = settings.listRuntimeVersionsSettings.toBuilder();
      getRuntimeVersionSettings = settings.getRuntimeVersionSettings.toBuilder();
      getGuestAttributesSettings = settings.getGuestAttributesSettings.toBuilder();
      simulateMaintenanceEventSettings = settings.simulateMaintenanceEventSettings.toBuilder();
      simulateMaintenanceEventOperationSettings =
          settings.simulateMaintenanceEventOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listNodesSettings,
              getNodeSettings,
              createNodeSettings,
              deleteNodeSettings,
              stopNodeSettings,
              startNodeSettings,
              updateNodeSettings,
              listQueuedResourcesSettings,
              getQueuedResourceSettings,
              createQueuedResourceSettings,
              deleteQueuedResourceSettings,
              generateServiceIdentitySettings,
              listAcceleratorTypesSettings,
              getAcceleratorTypeSettings,
              listRuntimeVersionsSettings,
              getRuntimeVersionSettings,
              getGuestAttributesSettings,
              simulateMaintenanceEventSettings,
              listLocationsSettings,
              getLocationSettings);
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
          .stopNodeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .startNodeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateNodeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listQueuedResourcesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getQueuedResourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createQueuedResourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteQueuedResourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .generateServiceIdentitySettings()
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
          .listRuntimeVersionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getRuntimeVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getGuestAttributesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .simulateMaintenanceEventSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getLocationSettings()
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

      builder
          .updateNodeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateNodeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .createQueuedResourceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateQueuedResourceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(QueuedResource.class))
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
          .deleteQueuedResourceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteQueuedResourceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(QueuedResource.class))
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
          .simulateMaintenanceEventOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SimulateMaintenanceEventRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
    public OperationCallSettings.Builder<DeleteNodeRequest, Empty, OperationMetadata>
        deleteNodeOperationSettings() {
      return deleteNodeOperationSettings;
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

    /** Returns the builder for the settings used for calls to updateNode. */
    public UnaryCallSettings.Builder<UpdateNodeRequest, Operation> updateNodeSettings() {
      return updateNodeSettings;
    }

    /** Returns the builder for the settings used for calls to updateNode. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateNodeRequest, Node, OperationMetadata>
        updateNodeOperationSettings() {
      return updateNodeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listQueuedResources. */
    public PagedCallSettings.Builder<
            ListQueuedResourcesRequest,
            ListQueuedResourcesResponse,
            ListQueuedResourcesPagedResponse>
        listQueuedResourcesSettings() {
      return listQueuedResourcesSettings;
    }

    /** Returns the builder for the settings used for calls to getQueuedResource. */
    public UnaryCallSettings.Builder<GetQueuedResourceRequest, QueuedResource>
        getQueuedResourceSettings() {
      return getQueuedResourceSettings;
    }

    /** Returns the builder for the settings used for calls to createQueuedResource. */
    public UnaryCallSettings.Builder<CreateQueuedResourceRequest, Operation>
        createQueuedResourceSettings() {
      return createQueuedResourceSettings;
    }

    /** Returns the builder for the settings used for calls to createQueuedResource. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateQueuedResourceRequest, QueuedResource, OperationMetadata>
        createQueuedResourceOperationSettings() {
      return createQueuedResourceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteQueuedResource. */
    public UnaryCallSettings.Builder<DeleteQueuedResourceRequest, Operation>
        deleteQueuedResourceSettings() {
      return deleteQueuedResourceSettings;
    }

    /** Returns the builder for the settings used for calls to deleteQueuedResource. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DeleteQueuedResourceRequest, QueuedResource, OperationMetadata>
        deleteQueuedResourceOperationSettings() {
      return deleteQueuedResourceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to generateServiceIdentity. */
    public UnaryCallSettings.Builder<
            GenerateServiceIdentityRequest, GenerateServiceIdentityResponse>
        generateServiceIdentitySettings() {
      return generateServiceIdentitySettings;
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

    /** Returns the builder for the settings used for calls to listRuntimeVersions. */
    public PagedCallSettings.Builder<
            ListRuntimeVersionsRequest,
            ListRuntimeVersionsResponse,
            ListRuntimeVersionsPagedResponse>
        listRuntimeVersionsSettings() {
      return listRuntimeVersionsSettings;
    }

    /** Returns the builder for the settings used for calls to getRuntimeVersion. */
    public UnaryCallSettings.Builder<GetRuntimeVersionRequest, RuntimeVersion>
        getRuntimeVersionSettings() {
      return getRuntimeVersionSettings;
    }

    /** Returns the builder for the settings used for calls to getGuestAttributes. */
    public UnaryCallSettings.Builder<GetGuestAttributesRequest, GetGuestAttributesResponse>
        getGuestAttributesSettings() {
      return getGuestAttributesSettings;
    }

    /** Returns the builder for the settings used for calls to simulateMaintenanceEvent. */
    public UnaryCallSettings.Builder<SimulateMaintenanceEventRequest, Operation>
        simulateMaintenanceEventSettings() {
      return simulateMaintenanceEventSettings;
    }

    /** Returns the builder for the settings used for calls to simulateMaintenanceEvent. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SimulateMaintenanceEventRequest, Node, OperationMetadata>
        simulateMaintenanceEventOperationSettings() {
      return simulateMaintenanceEventOperationSettings;
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
    public TpuStubSettings build() throws IOException {
      return new TpuStubSettings(this);
    }
  }
}
