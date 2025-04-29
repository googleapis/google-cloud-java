/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.workflows.v1.stub;

import static com.google.cloud.workflows.v1.WorkflowsClient.ListLocationsPagedResponse;
import static com.google.cloud.workflows.v1.WorkflowsClient.ListWorkflowRevisionsPagedResponse;
import static com.google.cloud.workflows.v1.WorkflowsClient.ListWorkflowsPagedResponse;

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
import com.google.cloud.workflows.v1.CreateWorkflowRequest;
import com.google.cloud.workflows.v1.DeleteWorkflowRequest;
import com.google.cloud.workflows.v1.GetWorkflowRequest;
import com.google.cloud.workflows.v1.ListWorkflowRevisionsRequest;
import com.google.cloud.workflows.v1.ListWorkflowRevisionsResponse;
import com.google.cloud.workflows.v1.ListWorkflowsRequest;
import com.google.cloud.workflows.v1.ListWorkflowsResponse;
import com.google.cloud.workflows.v1.OperationMetadata;
import com.google.cloud.workflows.v1.UpdateWorkflowRequest;
import com.google.cloud.workflows.v1.Workflow;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link WorkflowsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (workflows.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getWorkflow:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * WorkflowsStubSettings.Builder workflowsSettingsBuilder = WorkflowsStubSettings.newBuilder();
 * workflowsSettingsBuilder
 *     .getWorkflowSettings()
 *     .setRetrySettings(
 *         workflowsSettingsBuilder
 *             .getWorkflowSettings()
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
 * WorkflowsStubSettings workflowsSettings = workflowsSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createWorkflow:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * WorkflowsStubSettings.Builder workflowsSettingsBuilder = WorkflowsStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * workflowsSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class WorkflowsStubSettings extends StubSettings<WorkflowsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListWorkflowsRequest, ListWorkflowsResponse, ListWorkflowsPagedResponse>
      listWorkflowsSettings;
  private final UnaryCallSettings<GetWorkflowRequest, Workflow> getWorkflowSettings;
  private final UnaryCallSettings<CreateWorkflowRequest, Operation> createWorkflowSettings;
  private final OperationCallSettings<CreateWorkflowRequest, Workflow, OperationMetadata>
      createWorkflowOperationSettings;
  private final UnaryCallSettings<DeleteWorkflowRequest, Operation> deleteWorkflowSettings;
  private final OperationCallSettings<DeleteWorkflowRequest, Empty, OperationMetadata>
      deleteWorkflowOperationSettings;
  private final UnaryCallSettings<UpdateWorkflowRequest, Operation> updateWorkflowSettings;
  private final OperationCallSettings<UpdateWorkflowRequest, Workflow, OperationMetadata>
      updateWorkflowOperationSettings;
  private final PagedCallSettings<
          ListWorkflowRevisionsRequest,
          ListWorkflowRevisionsResponse,
          ListWorkflowRevisionsPagedResponse>
      listWorkflowRevisionsSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListWorkflowsRequest, ListWorkflowsResponse, Workflow>
      LIST_WORKFLOWS_PAGE_STR_DESC =
          new PagedListDescriptor<ListWorkflowsRequest, ListWorkflowsResponse, Workflow>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListWorkflowsRequest injectToken(ListWorkflowsRequest payload, String token) {
              return ListWorkflowsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListWorkflowsRequest injectPageSize(ListWorkflowsRequest payload, int pageSize) {
              return ListWorkflowsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListWorkflowsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListWorkflowsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Workflow> extractResources(ListWorkflowsResponse payload) {
              return payload.getWorkflowsList();
            }
          };

  private static final PagedListDescriptor<
          ListWorkflowRevisionsRequest, ListWorkflowRevisionsResponse, Workflow>
      LIST_WORKFLOW_REVISIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListWorkflowRevisionsRequest, ListWorkflowRevisionsResponse, Workflow>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListWorkflowRevisionsRequest injectToken(
                ListWorkflowRevisionsRequest payload, String token) {
              return ListWorkflowRevisionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListWorkflowRevisionsRequest injectPageSize(
                ListWorkflowRevisionsRequest payload, int pageSize) {
              return ListWorkflowRevisionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListWorkflowRevisionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListWorkflowRevisionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Workflow> extractResources(ListWorkflowRevisionsResponse payload) {
              return payload.getWorkflowsList();
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
          ListWorkflowsRequest, ListWorkflowsResponse, ListWorkflowsPagedResponse>
      LIST_WORKFLOWS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListWorkflowsRequest, ListWorkflowsResponse, ListWorkflowsPagedResponse>() {
            @Override
            public ApiFuture<ListWorkflowsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListWorkflowsRequest, ListWorkflowsResponse> callable,
                ListWorkflowsRequest request,
                ApiCallContext context,
                ApiFuture<ListWorkflowsResponse> futureResponse) {
              PageContext<ListWorkflowsRequest, ListWorkflowsResponse, Workflow> pageContext =
                  PageContext.create(callable, LIST_WORKFLOWS_PAGE_STR_DESC, request, context);
              return ListWorkflowsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListWorkflowRevisionsRequest,
          ListWorkflowRevisionsResponse,
          ListWorkflowRevisionsPagedResponse>
      LIST_WORKFLOW_REVISIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListWorkflowRevisionsRequest,
              ListWorkflowRevisionsResponse,
              ListWorkflowRevisionsPagedResponse>() {
            @Override
            public ApiFuture<ListWorkflowRevisionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListWorkflowRevisionsRequest, ListWorkflowRevisionsResponse> callable,
                ListWorkflowRevisionsRequest request,
                ApiCallContext context,
                ApiFuture<ListWorkflowRevisionsResponse> futureResponse) {
              PageContext<ListWorkflowRevisionsRequest, ListWorkflowRevisionsResponse, Workflow>
                  pageContext =
                      PageContext.create(
                          callable, LIST_WORKFLOW_REVISIONS_PAGE_STR_DESC, request, context);
              return ListWorkflowRevisionsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listWorkflows. */
  public PagedCallSettings<ListWorkflowsRequest, ListWorkflowsResponse, ListWorkflowsPagedResponse>
      listWorkflowsSettings() {
    return listWorkflowsSettings;
  }

  /** Returns the object with the settings used for calls to getWorkflow. */
  public UnaryCallSettings<GetWorkflowRequest, Workflow> getWorkflowSettings() {
    return getWorkflowSettings;
  }

  /** Returns the object with the settings used for calls to createWorkflow. */
  public UnaryCallSettings<CreateWorkflowRequest, Operation> createWorkflowSettings() {
    return createWorkflowSettings;
  }

  /** Returns the object with the settings used for calls to createWorkflow. */
  public OperationCallSettings<CreateWorkflowRequest, Workflow, OperationMetadata>
      createWorkflowOperationSettings() {
    return createWorkflowOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteWorkflow. */
  public UnaryCallSettings<DeleteWorkflowRequest, Operation> deleteWorkflowSettings() {
    return deleteWorkflowSettings;
  }

  /** Returns the object with the settings used for calls to deleteWorkflow. */
  public OperationCallSettings<DeleteWorkflowRequest, Empty, OperationMetadata>
      deleteWorkflowOperationSettings() {
    return deleteWorkflowOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateWorkflow. */
  public UnaryCallSettings<UpdateWorkflowRequest, Operation> updateWorkflowSettings() {
    return updateWorkflowSettings;
  }

  /** Returns the object with the settings used for calls to updateWorkflow. */
  public OperationCallSettings<UpdateWorkflowRequest, Workflow, OperationMetadata>
      updateWorkflowOperationSettings() {
    return updateWorkflowOperationSettings;
  }

  /** Returns the object with the settings used for calls to listWorkflowRevisions. */
  public PagedCallSettings<
          ListWorkflowRevisionsRequest,
          ListWorkflowRevisionsResponse,
          ListWorkflowRevisionsPagedResponse>
      listWorkflowRevisionsSettings() {
    return listWorkflowRevisionsSettings;
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

  public WorkflowsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcWorkflowsStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonWorkflowsStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "workflows";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "workflows.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "workflows.mtls.googleapis.com:443";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(WorkflowsStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(WorkflowsStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return WorkflowsStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected WorkflowsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listWorkflowsSettings = settingsBuilder.listWorkflowsSettings().build();
    getWorkflowSettings = settingsBuilder.getWorkflowSettings().build();
    createWorkflowSettings = settingsBuilder.createWorkflowSettings().build();
    createWorkflowOperationSettings = settingsBuilder.createWorkflowOperationSettings().build();
    deleteWorkflowSettings = settingsBuilder.deleteWorkflowSettings().build();
    deleteWorkflowOperationSettings = settingsBuilder.deleteWorkflowOperationSettings().build();
    updateWorkflowSettings = settingsBuilder.updateWorkflowSettings().build();
    updateWorkflowOperationSettings = settingsBuilder.updateWorkflowOperationSettings().build();
    listWorkflowRevisionsSettings = settingsBuilder.listWorkflowRevisionsSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for WorkflowsStubSettings. */
  public static class Builder extends StubSettings.Builder<WorkflowsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListWorkflowsRequest, ListWorkflowsResponse, ListWorkflowsPagedResponse>
        listWorkflowsSettings;
    private final UnaryCallSettings.Builder<GetWorkflowRequest, Workflow> getWorkflowSettings;
    private final UnaryCallSettings.Builder<CreateWorkflowRequest, Operation>
        createWorkflowSettings;
    private final OperationCallSettings.Builder<CreateWorkflowRequest, Workflow, OperationMetadata>
        createWorkflowOperationSettings;
    private final UnaryCallSettings.Builder<DeleteWorkflowRequest, Operation>
        deleteWorkflowSettings;
    private final OperationCallSettings.Builder<DeleteWorkflowRequest, Empty, OperationMetadata>
        deleteWorkflowOperationSettings;
    private final UnaryCallSettings.Builder<UpdateWorkflowRequest, Operation>
        updateWorkflowSettings;
    private final OperationCallSettings.Builder<UpdateWorkflowRequest, Workflow, OperationMetadata>
        updateWorkflowOperationSettings;
    private final PagedCallSettings.Builder<
            ListWorkflowRevisionsRequest,
            ListWorkflowRevisionsResponse,
            ListWorkflowRevisionsPagedResponse>
        listWorkflowRevisionsSettings;
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

      listWorkflowsSettings = PagedCallSettings.newBuilder(LIST_WORKFLOWS_PAGE_STR_FACT);
      getWorkflowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createWorkflowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createWorkflowOperationSettings = OperationCallSettings.newBuilder();
      deleteWorkflowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteWorkflowOperationSettings = OperationCallSettings.newBuilder();
      updateWorkflowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateWorkflowOperationSettings = OperationCallSettings.newBuilder();
      listWorkflowRevisionsSettings =
          PagedCallSettings.newBuilder(LIST_WORKFLOW_REVISIONS_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listWorkflowsSettings,
              getWorkflowSettings,
              createWorkflowSettings,
              deleteWorkflowSettings,
              updateWorkflowSettings,
              listWorkflowRevisionsSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(WorkflowsStubSettings settings) {
      super(settings);

      listWorkflowsSettings = settings.listWorkflowsSettings.toBuilder();
      getWorkflowSettings = settings.getWorkflowSettings.toBuilder();
      createWorkflowSettings = settings.createWorkflowSettings.toBuilder();
      createWorkflowOperationSettings = settings.createWorkflowOperationSettings.toBuilder();
      deleteWorkflowSettings = settings.deleteWorkflowSettings.toBuilder();
      deleteWorkflowOperationSettings = settings.deleteWorkflowOperationSettings.toBuilder();
      updateWorkflowSettings = settings.updateWorkflowSettings.toBuilder();
      updateWorkflowOperationSettings = settings.updateWorkflowOperationSettings.toBuilder();
      listWorkflowRevisionsSettings = settings.listWorkflowRevisionsSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listWorkflowsSettings,
              getWorkflowSettings,
              createWorkflowSettings,
              deleteWorkflowSettings,
              updateWorkflowSettings,
              listWorkflowRevisionsSettings,
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
          .listWorkflowsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getWorkflowSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createWorkflowSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteWorkflowSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateWorkflowSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listWorkflowRevisionsSettings()
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
          .createWorkflowOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateWorkflowRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Workflow.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteWorkflowOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteWorkflowRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateWorkflowOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateWorkflowRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Workflow.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
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

    /** Returns the builder for the settings used for calls to listWorkflows. */
    public PagedCallSettings.Builder<
            ListWorkflowsRequest, ListWorkflowsResponse, ListWorkflowsPagedResponse>
        listWorkflowsSettings() {
      return listWorkflowsSettings;
    }

    /** Returns the builder for the settings used for calls to getWorkflow. */
    public UnaryCallSettings.Builder<GetWorkflowRequest, Workflow> getWorkflowSettings() {
      return getWorkflowSettings;
    }

    /** Returns the builder for the settings used for calls to createWorkflow. */
    public UnaryCallSettings.Builder<CreateWorkflowRequest, Operation> createWorkflowSettings() {
      return createWorkflowSettings;
    }

    /** Returns the builder for the settings used for calls to createWorkflow. */
    public OperationCallSettings.Builder<CreateWorkflowRequest, Workflow, OperationMetadata>
        createWorkflowOperationSettings() {
      return createWorkflowOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteWorkflow. */
    public UnaryCallSettings.Builder<DeleteWorkflowRequest, Operation> deleteWorkflowSettings() {
      return deleteWorkflowSettings;
    }

    /** Returns the builder for the settings used for calls to deleteWorkflow. */
    public OperationCallSettings.Builder<DeleteWorkflowRequest, Empty, OperationMetadata>
        deleteWorkflowOperationSettings() {
      return deleteWorkflowOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateWorkflow. */
    public UnaryCallSettings.Builder<UpdateWorkflowRequest, Operation> updateWorkflowSettings() {
      return updateWorkflowSettings;
    }

    /** Returns the builder for the settings used for calls to updateWorkflow. */
    public OperationCallSettings.Builder<UpdateWorkflowRequest, Workflow, OperationMetadata>
        updateWorkflowOperationSettings() {
      return updateWorkflowOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listWorkflowRevisions. */
    public PagedCallSettings.Builder<
            ListWorkflowRevisionsRequest,
            ListWorkflowRevisionsResponse,
            ListWorkflowRevisionsPagedResponse>
        listWorkflowRevisionsSettings() {
      return listWorkflowRevisionsSettings;
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
    public WorkflowsStubSettings build() throws IOException {
      return new WorkflowsStubSettings(this);
    }
  }
}
