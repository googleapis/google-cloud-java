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

package com.google.cloud.workloadmanager.v1.stub;

import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListEvaluationsPagedResponse;
import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListExecutionResultsPagedResponse;
import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListExecutionsPagedResponse;
import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListScannedResourcesPagedResponse;

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
import com.google.cloud.workloadmanager.v1.CreateEvaluationRequest;
import com.google.cloud.workloadmanager.v1.DeleteEvaluationRequest;
import com.google.cloud.workloadmanager.v1.DeleteExecutionRequest;
import com.google.cloud.workloadmanager.v1.Evaluation;
import com.google.cloud.workloadmanager.v1.Execution;
import com.google.cloud.workloadmanager.v1.ExecutionResult;
import com.google.cloud.workloadmanager.v1.GetEvaluationRequest;
import com.google.cloud.workloadmanager.v1.GetExecutionRequest;
import com.google.cloud.workloadmanager.v1.ListEvaluationsRequest;
import com.google.cloud.workloadmanager.v1.ListEvaluationsResponse;
import com.google.cloud.workloadmanager.v1.ListExecutionResultsRequest;
import com.google.cloud.workloadmanager.v1.ListExecutionResultsResponse;
import com.google.cloud.workloadmanager.v1.ListExecutionsRequest;
import com.google.cloud.workloadmanager.v1.ListExecutionsResponse;
import com.google.cloud.workloadmanager.v1.ListRulesRequest;
import com.google.cloud.workloadmanager.v1.ListRulesResponse;
import com.google.cloud.workloadmanager.v1.ListScannedResourcesRequest;
import com.google.cloud.workloadmanager.v1.ListScannedResourcesResponse;
import com.google.cloud.workloadmanager.v1.OperationMetadata;
import com.google.cloud.workloadmanager.v1.RunEvaluationRequest;
import com.google.cloud.workloadmanager.v1.ScannedResource;
import com.google.cloud.workloadmanager.v1.UpdateEvaluationRequest;
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
 * Settings class to configure an instance of {@link WorkloadManagerStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (workloadmanager.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getEvaluation:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * WorkloadManagerStubSettings.Builder workloadManagerSettingsBuilder =
 *     WorkloadManagerStubSettings.newBuilder();
 * workloadManagerSettingsBuilder
 *     .getEvaluationSettings()
 *     .setRetrySettings(
 *         workloadManagerSettingsBuilder
 *             .getEvaluationSettings()
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
 * WorkloadManagerStubSettings workloadManagerSettings = workloadManagerSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createEvaluation:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * WorkloadManagerStubSettings.Builder workloadManagerSettingsBuilder =
 *     WorkloadManagerStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * workloadManagerSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class WorkloadManagerStubSettings extends StubSettings<WorkloadManagerStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListEvaluationsRequest, ListEvaluationsResponse, ListEvaluationsPagedResponse>
      listEvaluationsSettings;
  private final UnaryCallSettings<GetEvaluationRequest, Evaluation> getEvaluationSettings;
  private final UnaryCallSettings<CreateEvaluationRequest, Operation> createEvaluationSettings;
  private final OperationCallSettings<CreateEvaluationRequest, Evaluation, OperationMetadata>
      createEvaluationOperationSettings;
  private final UnaryCallSettings<UpdateEvaluationRequest, Operation> updateEvaluationSettings;
  private final OperationCallSettings<UpdateEvaluationRequest, Evaluation, OperationMetadata>
      updateEvaluationOperationSettings;
  private final UnaryCallSettings<DeleteEvaluationRequest, Operation> deleteEvaluationSettings;
  private final OperationCallSettings<DeleteEvaluationRequest, Empty, OperationMetadata>
      deleteEvaluationOperationSettings;
  private final PagedCallSettings<
          ListExecutionsRequest, ListExecutionsResponse, ListExecutionsPagedResponse>
      listExecutionsSettings;
  private final UnaryCallSettings<GetExecutionRequest, Execution> getExecutionSettings;
  private final UnaryCallSettings<RunEvaluationRequest, Operation> runEvaluationSettings;
  private final OperationCallSettings<RunEvaluationRequest, Execution, OperationMetadata>
      runEvaluationOperationSettings;
  private final UnaryCallSettings<DeleteExecutionRequest, Operation> deleteExecutionSettings;
  private final OperationCallSettings<DeleteExecutionRequest, Empty, OperationMetadata>
      deleteExecutionOperationSettings;
  private final PagedCallSettings<
          ListExecutionResultsRequest,
          ListExecutionResultsResponse,
          ListExecutionResultsPagedResponse>
      listExecutionResultsSettings;
  private final UnaryCallSettings<ListRulesRequest, ListRulesResponse> listRulesSettings;
  private final PagedCallSettings<
          ListScannedResourcesRequest,
          ListScannedResourcesResponse,
          ListScannedResourcesPagedResponse>
      listScannedResourcesSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListEvaluationsRequest, ListEvaluationsResponse, Evaluation>
      LIST_EVALUATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListEvaluationsRequest, ListEvaluationsResponse, Evaluation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEvaluationsRequest injectToken(
                ListEvaluationsRequest payload, String token) {
              return ListEvaluationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEvaluationsRequest injectPageSize(
                ListEvaluationsRequest payload, int pageSize) {
              return ListEvaluationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEvaluationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEvaluationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Evaluation> extractResources(ListEvaluationsResponse payload) {
              return payload.getEvaluationsList();
            }
          };

  private static final PagedListDescriptor<ListExecutionsRequest, ListExecutionsResponse, Execution>
      LIST_EXECUTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListExecutionsRequest, ListExecutionsResponse, Execution>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListExecutionsRequest injectToken(ListExecutionsRequest payload, String token) {
              return ListExecutionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListExecutionsRequest injectPageSize(
                ListExecutionsRequest payload, int pageSize) {
              return ListExecutionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListExecutionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListExecutionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Execution> extractResources(ListExecutionsResponse payload) {
              return payload.getExecutionsList();
            }
          };

  private static final PagedListDescriptor<
          ListExecutionResultsRequest, ListExecutionResultsResponse, ExecutionResult>
      LIST_EXECUTION_RESULTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListExecutionResultsRequest, ListExecutionResultsResponse, ExecutionResult>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListExecutionResultsRequest injectToken(
                ListExecutionResultsRequest payload, String token) {
              return ListExecutionResultsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListExecutionResultsRequest injectPageSize(
                ListExecutionResultsRequest payload, int pageSize) {
              return ListExecutionResultsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListExecutionResultsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListExecutionResultsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ExecutionResult> extractResources(
                ListExecutionResultsResponse payload) {
              return payload.getExecutionResultsList();
            }
          };

  private static final PagedListDescriptor<
          ListScannedResourcesRequest, ListScannedResourcesResponse, ScannedResource>
      LIST_SCANNED_RESOURCES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListScannedResourcesRequest, ListScannedResourcesResponse, ScannedResource>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListScannedResourcesRequest injectToken(
                ListScannedResourcesRequest payload, String token) {
              return ListScannedResourcesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListScannedResourcesRequest injectPageSize(
                ListScannedResourcesRequest payload, int pageSize) {
              return ListScannedResourcesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListScannedResourcesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListScannedResourcesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ScannedResource> extractResources(
                ListScannedResourcesResponse payload) {
              return payload.getScannedResourcesList();
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
          ListEvaluationsRequest, ListEvaluationsResponse, ListEvaluationsPagedResponse>
      LIST_EVALUATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEvaluationsRequest, ListEvaluationsResponse, ListEvaluationsPagedResponse>() {
            @Override
            public ApiFuture<ListEvaluationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEvaluationsRequest, ListEvaluationsResponse> callable,
                ListEvaluationsRequest request,
                ApiCallContext context,
                ApiFuture<ListEvaluationsResponse> futureResponse) {
              PageContext<ListEvaluationsRequest, ListEvaluationsResponse, Evaluation> pageContext =
                  PageContext.create(callable, LIST_EVALUATIONS_PAGE_STR_DESC, request, context);
              return ListEvaluationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListExecutionsRequest, ListExecutionsResponse, ListExecutionsPagedResponse>
      LIST_EXECUTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListExecutionsRequest, ListExecutionsResponse, ListExecutionsPagedResponse>() {
            @Override
            public ApiFuture<ListExecutionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListExecutionsRequest, ListExecutionsResponse> callable,
                ListExecutionsRequest request,
                ApiCallContext context,
                ApiFuture<ListExecutionsResponse> futureResponse) {
              PageContext<ListExecutionsRequest, ListExecutionsResponse, Execution> pageContext =
                  PageContext.create(callable, LIST_EXECUTIONS_PAGE_STR_DESC, request, context);
              return ListExecutionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListExecutionResultsRequest,
          ListExecutionResultsResponse,
          ListExecutionResultsPagedResponse>
      LIST_EXECUTION_RESULTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListExecutionResultsRequest,
              ListExecutionResultsResponse,
              ListExecutionResultsPagedResponse>() {
            @Override
            public ApiFuture<ListExecutionResultsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListExecutionResultsRequest, ListExecutionResultsResponse> callable,
                ListExecutionResultsRequest request,
                ApiCallContext context,
                ApiFuture<ListExecutionResultsResponse> futureResponse) {
              PageContext<
                      ListExecutionResultsRequest, ListExecutionResultsResponse, ExecutionResult>
                  pageContext =
                      PageContext.create(
                          callable, LIST_EXECUTION_RESULTS_PAGE_STR_DESC, request, context);
              return ListExecutionResultsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListScannedResourcesRequest,
          ListScannedResourcesResponse,
          ListScannedResourcesPagedResponse>
      LIST_SCANNED_RESOURCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListScannedResourcesRequest,
              ListScannedResourcesResponse,
              ListScannedResourcesPagedResponse>() {
            @Override
            public ApiFuture<ListScannedResourcesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListScannedResourcesRequest, ListScannedResourcesResponse> callable,
                ListScannedResourcesRequest request,
                ApiCallContext context,
                ApiFuture<ListScannedResourcesResponse> futureResponse) {
              PageContext<
                      ListScannedResourcesRequest, ListScannedResourcesResponse, ScannedResource>
                  pageContext =
                      PageContext.create(
                          callable, LIST_SCANNED_RESOURCES_PAGE_STR_DESC, request, context);
              return ListScannedResourcesPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listEvaluations. */
  public PagedCallSettings<
          ListEvaluationsRequest, ListEvaluationsResponse, ListEvaluationsPagedResponse>
      listEvaluationsSettings() {
    return listEvaluationsSettings;
  }

  /** Returns the object with the settings used for calls to getEvaluation. */
  public UnaryCallSettings<GetEvaluationRequest, Evaluation> getEvaluationSettings() {
    return getEvaluationSettings;
  }

  /** Returns the object with the settings used for calls to createEvaluation. */
  public UnaryCallSettings<CreateEvaluationRequest, Operation> createEvaluationSettings() {
    return createEvaluationSettings;
  }

  /** Returns the object with the settings used for calls to createEvaluation. */
  public OperationCallSettings<CreateEvaluationRequest, Evaluation, OperationMetadata>
      createEvaluationOperationSettings() {
    return createEvaluationOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateEvaluation. */
  public UnaryCallSettings<UpdateEvaluationRequest, Operation> updateEvaluationSettings() {
    return updateEvaluationSettings;
  }

  /** Returns the object with the settings used for calls to updateEvaluation. */
  public OperationCallSettings<UpdateEvaluationRequest, Evaluation, OperationMetadata>
      updateEvaluationOperationSettings() {
    return updateEvaluationOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteEvaluation. */
  public UnaryCallSettings<DeleteEvaluationRequest, Operation> deleteEvaluationSettings() {
    return deleteEvaluationSettings;
  }

  /** Returns the object with the settings used for calls to deleteEvaluation. */
  public OperationCallSettings<DeleteEvaluationRequest, Empty, OperationMetadata>
      deleteEvaluationOperationSettings() {
    return deleteEvaluationOperationSettings;
  }

  /** Returns the object with the settings used for calls to listExecutions. */
  public PagedCallSettings<
          ListExecutionsRequest, ListExecutionsResponse, ListExecutionsPagedResponse>
      listExecutionsSettings() {
    return listExecutionsSettings;
  }

  /** Returns the object with the settings used for calls to getExecution. */
  public UnaryCallSettings<GetExecutionRequest, Execution> getExecutionSettings() {
    return getExecutionSettings;
  }

  /** Returns the object with the settings used for calls to runEvaluation. */
  public UnaryCallSettings<RunEvaluationRequest, Operation> runEvaluationSettings() {
    return runEvaluationSettings;
  }

  /** Returns the object with the settings used for calls to runEvaluation. */
  public OperationCallSettings<RunEvaluationRequest, Execution, OperationMetadata>
      runEvaluationOperationSettings() {
    return runEvaluationOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteExecution. */
  public UnaryCallSettings<DeleteExecutionRequest, Operation> deleteExecutionSettings() {
    return deleteExecutionSettings;
  }

  /** Returns the object with the settings used for calls to deleteExecution. */
  public OperationCallSettings<DeleteExecutionRequest, Empty, OperationMetadata>
      deleteExecutionOperationSettings() {
    return deleteExecutionOperationSettings;
  }

  /** Returns the object with the settings used for calls to listExecutionResults. */
  public PagedCallSettings<
          ListExecutionResultsRequest,
          ListExecutionResultsResponse,
          ListExecutionResultsPagedResponse>
      listExecutionResultsSettings() {
    return listExecutionResultsSettings;
  }

  /** Returns the object with the settings used for calls to listRules. */
  public UnaryCallSettings<ListRulesRequest, ListRulesResponse> listRulesSettings() {
    return listRulesSettings;
  }

  /** Returns the object with the settings used for calls to listScannedResources. */
  public PagedCallSettings<
          ListScannedResourcesRequest,
          ListScannedResourcesResponse,
          ListScannedResourcesPagedResponse>
      listScannedResourcesSettings() {
    return listScannedResourcesSettings;
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

  public WorkloadManagerStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcWorkloadManagerStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonWorkloadManagerStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "workloadmanager";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "workloadmanager.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "workloadmanager.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(WorkloadManagerStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(WorkloadManagerStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return WorkloadManagerStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected WorkloadManagerStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listEvaluationsSettings = settingsBuilder.listEvaluationsSettings().build();
    getEvaluationSettings = settingsBuilder.getEvaluationSettings().build();
    createEvaluationSettings = settingsBuilder.createEvaluationSettings().build();
    createEvaluationOperationSettings = settingsBuilder.createEvaluationOperationSettings().build();
    updateEvaluationSettings = settingsBuilder.updateEvaluationSettings().build();
    updateEvaluationOperationSettings = settingsBuilder.updateEvaluationOperationSettings().build();
    deleteEvaluationSettings = settingsBuilder.deleteEvaluationSettings().build();
    deleteEvaluationOperationSettings = settingsBuilder.deleteEvaluationOperationSettings().build();
    listExecutionsSettings = settingsBuilder.listExecutionsSettings().build();
    getExecutionSettings = settingsBuilder.getExecutionSettings().build();
    runEvaluationSettings = settingsBuilder.runEvaluationSettings().build();
    runEvaluationOperationSettings = settingsBuilder.runEvaluationOperationSettings().build();
    deleteExecutionSettings = settingsBuilder.deleteExecutionSettings().build();
    deleteExecutionOperationSettings = settingsBuilder.deleteExecutionOperationSettings().build();
    listExecutionResultsSettings = settingsBuilder.listExecutionResultsSettings().build();
    listRulesSettings = settingsBuilder.listRulesSettings().build();
    listScannedResourcesSettings = settingsBuilder.listScannedResourcesSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for WorkloadManagerStubSettings. */
  public static class Builder extends StubSettings.Builder<WorkloadManagerStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListEvaluationsRequest, ListEvaluationsResponse, ListEvaluationsPagedResponse>
        listEvaluationsSettings;
    private final UnaryCallSettings.Builder<GetEvaluationRequest, Evaluation> getEvaluationSettings;
    private final UnaryCallSettings.Builder<CreateEvaluationRequest, Operation>
        createEvaluationSettings;
    private final OperationCallSettings.Builder<
            CreateEvaluationRequest, Evaluation, OperationMetadata>
        createEvaluationOperationSettings;
    private final UnaryCallSettings.Builder<UpdateEvaluationRequest, Operation>
        updateEvaluationSettings;
    private final OperationCallSettings.Builder<
            UpdateEvaluationRequest, Evaluation, OperationMetadata>
        updateEvaluationOperationSettings;
    private final UnaryCallSettings.Builder<DeleteEvaluationRequest, Operation>
        deleteEvaluationSettings;
    private final OperationCallSettings.Builder<DeleteEvaluationRequest, Empty, OperationMetadata>
        deleteEvaluationOperationSettings;
    private final PagedCallSettings.Builder<
            ListExecutionsRequest, ListExecutionsResponse, ListExecutionsPagedResponse>
        listExecutionsSettings;
    private final UnaryCallSettings.Builder<GetExecutionRequest, Execution> getExecutionSettings;
    private final UnaryCallSettings.Builder<RunEvaluationRequest, Operation> runEvaluationSettings;
    private final OperationCallSettings.Builder<RunEvaluationRequest, Execution, OperationMetadata>
        runEvaluationOperationSettings;
    private final UnaryCallSettings.Builder<DeleteExecutionRequest, Operation>
        deleteExecutionSettings;
    private final OperationCallSettings.Builder<DeleteExecutionRequest, Empty, OperationMetadata>
        deleteExecutionOperationSettings;
    private final PagedCallSettings.Builder<
            ListExecutionResultsRequest,
            ListExecutionResultsResponse,
            ListExecutionResultsPagedResponse>
        listExecutionResultsSettings;
    private final UnaryCallSettings.Builder<ListRulesRequest, ListRulesResponse> listRulesSettings;
    private final PagedCallSettings.Builder<
            ListScannedResourcesRequest,
            ListScannedResourcesResponse,
            ListScannedResourcesPagedResponse>
        listScannedResourcesSettings;
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
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listEvaluationsSettings = PagedCallSettings.newBuilder(LIST_EVALUATIONS_PAGE_STR_FACT);
      getEvaluationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEvaluationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEvaluationOperationSettings = OperationCallSettings.newBuilder();
      updateEvaluationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEvaluationOperationSettings = OperationCallSettings.newBuilder();
      deleteEvaluationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEvaluationOperationSettings = OperationCallSettings.newBuilder();
      listExecutionsSettings = PagedCallSettings.newBuilder(LIST_EXECUTIONS_PAGE_STR_FACT);
      getExecutionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      runEvaluationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      runEvaluationOperationSettings = OperationCallSettings.newBuilder();
      deleteExecutionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteExecutionOperationSettings = OperationCallSettings.newBuilder();
      listExecutionResultsSettings =
          PagedCallSettings.newBuilder(LIST_EXECUTION_RESULTS_PAGE_STR_FACT);
      listRulesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listScannedResourcesSettings =
          PagedCallSettings.newBuilder(LIST_SCANNED_RESOURCES_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listEvaluationsSettings,
              getEvaluationSettings,
              createEvaluationSettings,
              updateEvaluationSettings,
              deleteEvaluationSettings,
              listExecutionsSettings,
              getExecutionSettings,
              runEvaluationSettings,
              deleteExecutionSettings,
              listExecutionResultsSettings,
              listRulesSettings,
              listScannedResourcesSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(WorkloadManagerStubSettings settings) {
      super(settings);

      listEvaluationsSettings = settings.listEvaluationsSettings.toBuilder();
      getEvaluationSettings = settings.getEvaluationSettings.toBuilder();
      createEvaluationSettings = settings.createEvaluationSettings.toBuilder();
      createEvaluationOperationSettings = settings.createEvaluationOperationSettings.toBuilder();
      updateEvaluationSettings = settings.updateEvaluationSettings.toBuilder();
      updateEvaluationOperationSettings = settings.updateEvaluationOperationSettings.toBuilder();
      deleteEvaluationSettings = settings.deleteEvaluationSettings.toBuilder();
      deleteEvaluationOperationSettings = settings.deleteEvaluationOperationSettings.toBuilder();
      listExecutionsSettings = settings.listExecutionsSettings.toBuilder();
      getExecutionSettings = settings.getExecutionSettings.toBuilder();
      runEvaluationSettings = settings.runEvaluationSettings.toBuilder();
      runEvaluationOperationSettings = settings.runEvaluationOperationSettings.toBuilder();
      deleteExecutionSettings = settings.deleteExecutionSettings.toBuilder();
      deleteExecutionOperationSettings = settings.deleteExecutionOperationSettings.toBuilder();
      listExecutionResultsSettings = settings.listExecutionResultsSettings.toBuilder();
      listRulesSettings = settings.listRulesSettings.toBuilder();
      listScannedResourcesSettings = settings.listScannedResourcesSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listEvaluationsSettings,
              getEvaluationSettings,
              createEvaluationSettings,
              updateEvaluationSettings,
              deleteEvaluationSettings,
              listExecutionsSettings,
              getExecutionSettings,
              runEvaluationSettings,
              deleteExecutionSettings,
              listExecutionResultsSettings,
              listRulesSettings,
              listScannedResourcesSettings,
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
          .listEvaluationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getEvaluationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createEvaluationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateEvaluationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteEvaluationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listExecutionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getExecutionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .runEvaluationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteExecutionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listExecutionResultsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listRulesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listScannedResourcesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createEvaluationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateEvaluationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Evaluation.class))
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
          .updateEvaluationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateEvaluationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Evaluation.class))
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
          .deleteEvaluationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteEvaluationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .runEvaluationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RunEvaluationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Execution.class))
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
          .deleteExecutionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteExecutionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to listEvaluations. */
    public PagedCallSettings.Builder<
            ListEvaluationsRequest, ListEvaluationsResponse, ListEvaluationsPagedResponse>
        listEvaluationsSettings() {
      return listEvaluationsSettings;
    }

    /** Returns the builder for the settings used for calls to getEvaluation. */
    public UnaryCallSettings.Builder<GetEvaluationRequest, Evaluation> getEvaluationSettings() {
      return getEvaluationSettings;
    }

    /** Returns the builder for the settings used for calls to createEvaluation. */
    public UnaryCallSettings.Builder<CreateEvaluationRequest, Operation>
        createEvaluationSettings() {
      return createEvaluationSettings;
    }

    /** Returns the builder for the settings used for calls to createEvaluation. */
    public OperationCallSettings.Builder<CreateEvaluationRequest, Evaluation, OperationMetadata>
        createEvaluationOperationSettings() {
      return createEvaluationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateEvaluation. */
    public UnaryCallSettings.Builder<UpdateEvaluationRequest, Operation>
        updateEvaluationSettings() {
      return updateEvaluationSettings;
    }

    /** Returns the builder for the settings used for calls to updateEvaluation. */
    public OperationCallSettings.Builder<UpdateEvaluationRequest, Evaluation, OperationMetadata>
        updateEvaluationOperationSettings() {
      return updateEvaluationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEvaluation. */
    public UnaryCallSettings.Builder<DeleteEvaluationRequest, Operation>
        deleteEvaluationSettings() {
      return deleteEvaluationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEvaluation. */
    public OperationCallSettings.Builder<DeleteEvaluationRequest, Empty, OperationMetadata>
        deleteEvaluationOperationSettings() {
      return deleteEvaluationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listExecutions. */
    public PagedCallSettings.Builder<
            ListExecutionsRequest, ListExecutionsResponse, ListExecutionsPagedResponse>
        listExecutionsSettings() {
      return listExecutionsSettings;
    }

    /** Returns the builder for the settings used for calls to getExecution. */
    public UnaryCallSettings.Builder<GetExecutionRequest, Execution> getExecutionSettings() {
      return getExecutionSettings;
    }

    /** Returns the builder for the settings used for calls to runEvaluation. */
    public UnaryCallSettings.Builder<RunEvaluationRequest, Operation> runEvaluationSettings() {
      return runEvaluationSettings;
    }

    /** Returns the builder for the settings used for calls to runEvaluation. */
    public OperationCallSettings.Builder<RunEvaluationRequest, Execution, OperationMetadata>
        runEvaluationOperationSettings() {
      return runEvaluationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteExecution. */
    public UnaryCallSettings.Builder<DeleteExecutionRequest, Operation> deleteExecutionSettings() {
      return deleteExecutionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteExecution. */
    public OperationCallSettings.Builder<DeleteExecutionRequest, Empty, OperationMetadata>
        deleteExecutionOperationSettings() {
      return deleteExecutionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listExecutionResults. */
    public PagedCallSettings.Builder<
            ListExecutionResultsRequest,
            ListExecutionResultsResponse,
            ListExecutionResultsPagedResponse>
        listExecutionResultsSettings() {
      return listExecutionResultsSettings;
    }

    /** Returns the builder for the settings used for calls to listRules. */
    public UnaryCallSettings.Builder<ListRulesRequest, ListRulesResponse> listRulesSettings() {
      return listRulesSettings;
    }

    /** Returns the builder for the settings used for calls to listScannedResources. */
    public PagedCallSettings.Builder<
            ListScannedResourcesRequest,
            ListScannedResourcesResponse,
            ListScannedResourcesPagedResponse>
        listScannedResourcesSettings() {
      return listScannedResourcesSettings;
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
    public WorkloadManagerStubSettings build() throws IOException {
      return new WorkloadManagerStubSettings(this);
    }
  }
}
