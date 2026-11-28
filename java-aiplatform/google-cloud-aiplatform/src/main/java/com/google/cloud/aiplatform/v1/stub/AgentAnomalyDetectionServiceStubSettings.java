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

package com.google.cloud.aiplatform.v1.stub;

import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.AggregateAnalyzedSessionsPagedResponse;
import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.ListAgentAnomalyDetectionScopesPagedResponse;
import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.ListAnalyzedInvocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.ListAnalyzedSessionsPagedResponse;
import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.ListMonitoredAgentsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
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
import com.google.api.gax.rpc.LibraryMetadata;
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
import com.google.cloud.aiplatform.v1.AgentAnomalyDetectionScope;
import com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsRequest;
import com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsResponse;
import com.google.cloud.aiplatform.v1.AnalyzedInvocation;
import com.google.cloud.aiplatform.v1.AnalyzedSession;
import com.google.cloud.aiplatform.v1.ClearTrainingDataOperationMetadata;
import com.google.cloud.aiplatform.v1.ClearTrainingDataRequest;
import com.google.cloud.aiplatform.v1.ClearTrainingDataResponse;
import com.google.cloud.aiplatform.v1.CreateAgentAnomalyDetectionScopeOperationMetadata;
import com.google.cloud.aiplatform.v1.CreateAgentAnomalyDetectionScopeRequest;
import com.google.cloud.aiplatform.v1.DeleteAgentAnomalyDetectionScopeOperationMetadata;
import com.google.cloud.aiplatform.v1.DeleteAgentAnomalyDetectionScopeRequest;
import com.google.cloud.aiplatform.v1.DisableMonitoredAgentOperationMetadata;
import com.google.cloud.aiplatform.v1.DisableMonitoredAgentRequest;
import com.google.cloud.aiplatform.v1.EnableMonitoredAgentOperationMetadata;
import com.google.cloud.aiplatform.v1.EnableMonitoredAgentRequest;
import com.google.cloud.aiplatform.v1.GetAgentAnomalyDetectionScopeRequest;
import com.google.cloud.aiplatform.v1.GetAnalyzedInvocationRequest;
import com.google.cloud.aiplatform.v1.GetAnalyzedSessionRequest;
import com.google.cloud.aiplatform.v1.GetMonitoredAgentRequest;
import com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesRequest;
import com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesResponse;
import com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsRequest;
import com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsResponse;
import com.google.cloud.aiplatform.v1.ListAnalyzedSessionsRequest;
import com.google.cloud.aiplatform.v1.ListAnalyzedSessionsResponse;
import com.google.cloud.aiplatform.v1.ListMonitoredAgentsRequest;
import com.google.cloud.aiplatform.v1.ListMonitoredAgentsResponse;
import com.google.cloud.aiplatform.v1.MonitoredAgent;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AgentAnomalyDetectionServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (aiplatform.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getAgentAnomalyDetectionScope:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AgentAnomalyDetectionServiceStubSettings.Builder agentAnomalyDetectionServiceSettingsBuilder =
 *     AgentAnomalyDetectionServiceStubSettings.newBuilder();
 * agentAnomalyDetectionServiceSettingsBuilder
 *     .getAgentAnomalyDetectionScopeSettings()
 *     .setRetrySettings(
 *         agentAnomalyDetectionServiceSettingsBuilder
 *             .getAgentAnomalyDetectionScopeSettings()
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
 * AgentAnomalyDetectionServiceStubSettings agentAnomalyDetectionServiceSettings =
 *     agentAnomalyDetectionServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for enableMonitoredAgent:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AgentAnomalyDetectionServiceStubSettings.Builder agentAnomalyDetectionServiceSettingsBuilder =
 *     AgentAnomalyDetectionServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * agentAnomalyDetectionServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class AgentAnomalyDetectionServiceStubSettings
    extends StubSettings<AgentAnomalyDetectionServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<GetAgentAnomalyDetectionScopeRequest, AgentAnomalyDetectionScope>
      getAgentAnomalyDetectionScopeSettings;
  private final UnaryCallSettings<GetMonitoredAgentRequest, MonitoredAgent>
      getMonitoredAgentSettings;
  private final PagedCallSettings<
          ListMonitoredAgentsRequest, ListMonitoredAgentsResponse, ListMonitoredAgentsPagedResponse>
      listMonitoredAgentsSettings;
  private final UnaryCallSettings<EnableMonitoredAgentRequest, Operation>
      enableMonitoredAgentSettings;
  private final OperationCallSettings<
          EnableMonitoredAgentRequest, MonitoredAgent, EnableMonitoredAgentOperationMetadata>
      enableMonitoredAgentOperationSettings;
  private final UnaryCallSettings<DisableMonitoredAgentRequest, Operation>
      disableMonitoredAgentSettings;
  private final OperationCallSettings<
          DisableMonitoredAgentRequest, MonitoredAgent, DisableMonitoredAgentOperationMetadata>
      disableMonitoredAgentOperationSettings;
  private final UnaryCallSettings<DeleteAgentAnomalyDetectionScopeRequest, Operation>
      deleteAgentAnomalyDetectionScopeSettings;
  private final OperationCallSettings<
          DeleteAgentAnomalyDetectionScopeRequest,
          Empty,
          DeleteAgentAnomalyDetectionScopeOperationMetadata>
      deleteAgentAnomalyDetectionScopeOperationSettings;
  private final UnaryCallSettings<CreateAgentAnomalyDetectionScopeRequest, Operation>
      createAgentAnomalyDetectionScopeSettings;
  private final OperationCallSettings<
          CreateAgentAnomalyDetectionScopeRequest,
          AgentAnomalyDetectionScope,
          CreateAgentAnomalyDetectionScopeOperationMetadata>
      createAgentAnomalyDetectionScopeOperationSettings;
  private final PagedCallSettings<
          ListAgentAnomalyDetectionScopesRequest,
          ListAgentAnomalyDetectionScopesResponse,
          ListAgentAnomalyDetectionScopesPagedResponse>
      listAgentAnomalyDetectionScopesSettings;
  private final PagedCallSettings<
          ListAnalyzedSessionsRequest,
          ListAnalyzedSessionsResponse,
          ListAnalyzedSessionsPagedResponse>
      listAnalyzedSessionsSettings;
  private final UnaryCallSettings<GetAnalyzedSessionRequest, AnalyzedSession>
      getAnalyzedSessionSettings;
  private final PagedCallSettings<
          ListAnalyzedInvocationsRequest,
          ListAnalyzedInvocationsResponse,
          ListAnalyzedInvocationsPagedResponse>
      listAnalyzedInvocationsSettings;
  private final UnaryCallSettings<GetAnalyzedInvocationRequest, AnalyzedInvocation>
      getAnalyzedInvocationSettings;
  private final PagedCallSettings<
          AggregateAnalyzedSessionsRequest,
          AggregateAnalyzedSessionsResponse,
          AggregateAnalyzedSessionsPagedResponse>
      aggregateAnalyzedSessionsSettings;
  private final UnaryCallSettings<ClearTrainingDataRequest, Operation> clearTrainingDataSettings;
  private final OperationCallSettings<
          ClearTrainingDataRequest, ClearTrainingDataResponse, ClearTrainingDataOperationMetadata>
      clearTrainingDataOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListMonitoredAgentsRequest, ListMonitoredAgentsResponse, MonitoredAgent>
      LIST_MONITORED_AGENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListMonitoredAgentsRequest, ListMonitoredAgentsResponse, MonitoredAgent>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMonitoredAgentsRequest injectToken(
                ListMonitoredAgentsRequest payload, String token) {
              return ListMonitoredAgentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMonitoredAgentsRequest injectPageSize(
                ListMonitoredAgentsRequest payload, int pageSize) {
              return ListMonitoredAgentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMonitoredAgentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMonitoredAgentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MonitoredAgent> extractResources(ListMonitoredAgentsResponse payload) {
              return payload.getMonitoredAgentsList();
            }
          };

  private static final PagedListDescriptor<
          ListAgentAnomalyDetectionScopesRequest,
          ListAgentAnomalyDetectionScopesResponse,
          AgentAnomalyDetectionScope>
      LIST_AGENT_ANOMALY_DETECTION_SCOPES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAgentAnomalyDetectionScopesRequest,
              ListAgentAnomalyDetectionScopesResponse,
              AgentAnomalyDetectionScope>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAgentAnomalyDetectionScopesRequest injectToken(
                ListAgentAnomalyDetectionScopesRequest payload, String token) {
              return ListAgentAnomalyDetectionScopesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListAgentAnomalyDetectionScopesRequest injectPageSize(
                ListAgentAnomalyDetectionScopesRequest payload, int pageSize) {
              return ListAgentAnomalyDetectionScopesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListAgentAnomalyDetectionScopesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAgentAnomalyDetectionScopesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AgentAnomalyDetectionScope> extractResources(
                ListAgentAnomalyDetectionScopesResponse payload) {
              return payload.getAgentAnomalyDetectionScopesList();
            }
          };

  private static final PagedListDescriptor<
          ListAnalyzedSessionsRequest, ListAnalyzedSessionsResponse, AnalyzedSession>
      LIST_ANALYZED_SESSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAnalyzedSessionsRequest, ListAnalyzedSessionsResponse, AnalyzedSession>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAnalyzedSessionsRequest injectToken(
                ListAnalyzedSessionsRequest payload, String token) {
              return ListAnalyzedSessionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAnalyzedSessionsRequest injectPageSize(
                ListAnalyzedSessionsRequest payload, int pageSize) {
              return ListAnalyzedSessionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAnalyzedSessionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAnalyzedSessionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AnalyzedSession> extractResources(
                ListAnalyzedSessionsResponse payload) {
              return payload.getAnalyzedSessionsList();
            }
          };

  private static final PagedListDescriptor<
          ListAnalyzedInvocationsRequest, ListAnalyzedInvocationsResponse, AnalyzedInvocation>
      LIST_ANALYZED_INVOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAnalyzedInvocationsRequest,
              ListAnalyzedInvocationsResponse,
              AnalyzedInvocation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAnalyzedInvocationsRequest injectToken(
                ListAnalyzedInvocationsRequest payload, String token) {
              return ListAnalyzedInvocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAnalyzedInvocationsRequest injectPageSize(
                ListAnalyzedInvocationsRequest payload, int pageSize) {
              return ListAnalyzedInvocationsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListAnalyzedInvocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAnalyzedInvocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AnalyzedInvocation> extractResources(
                ListAnalyzedInvocationsResponse payload) {
              return payload.getAnalyzedInvocationsList();
            }
          };

  private static final PagedListDescriptor<
          AggregateAnalyzedSessionsRequest,
          AggregateAnalyzedSessionsResponse,
          AggregateAnalyzedSessionsResponse.AgentAggregate>
      AGGREGATE_ANALYZED_SESSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregateAnalyzedSessionsRequest,
              AggregateAnalyzedSessionsResponse,
              AggregateAnalyzedSessionsResponse.AgentAggregate>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregateAnalyzedSessionsRequest injectToken(
                AggregateAnalyzedSessionsRequest payload, String token) {
              return AggregateAnalyzedSessionsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregateAnalyzedSessionsRequest injectPageSize(
                AggregateAnalyzedSessionsRequest payload, int pageSize) {
              return AggregateAnalyzedSessionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregateAnalyzedSessionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(AggregateAnalyzedSessionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AggregateAnalyzedSessionsResponse.AgentAggregate> extractResources(
                AggregateAnalyzedSessionsResponse payload) {
              return payload.getAgentAggregatesList();
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
          ListMonitoredAgentsRequest, ListMonitoredAgentsResponse, ListMonitoredAgentsPagedResponse>
      LIST_MONITORED_AGENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMonitoredAgentsRequest,
              ListMonitoredAgentsResponse,
              ListMonitoredAgentsPagedResponse>() {
            @Override
            public ApiFuture<ListMonitoredAgentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMonitoredAgentsRequest, ListMonitoredAgentsResponse> callable,
                ListMonitoredAgentsRequest request,
                ApiCallContext context,
                ApiFuture<ListMonitoredAgentsResponse> futureResponse) {
              PageContext<ListMonitoredAgentsRequest, ListMonitoredAgentsResponse, MonitoredAgent>
                  pageContext =
                      PageContext.create(
                          callable, LIST_MONITORED_AGENTS_PAGE_STR_DESC, request, context);
              return ListMonitoredAgentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAgentAnomalyDetectionScopesRequest,
          ListAgentAnomalyDetectionScopesResponse,
          ListAgentAnomalyDetectionScopesPagedResponse>
      LIST_AGENT_ANOMALY_DETECTION_SCOPES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAgentAnomalyDetectionScopesRequest,
              ListAgentAnomalyDetectionScopesResponse,
              ListAgentAnomalyDetectionScopesPagedResponse>() {
            @Override
            public ApiFuture<ListAgentAnomalyDetectionScopesPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListAgentAnomalyDetectionScopesRequest,
                        ListAgentAnomalyDetectionScopesResponse>
                    callable,
                ListAgentAnomalyDetectionScopesRequest request,
                ApiCallContext context,
                ApiFuture<ListAgentAnomalyDetectionScopesResponse> futureResponse) {
              PageContext<
                      ListAgentAnomalyDetectionScopesRequest,
                      ListAgentAnomalyDetectionScopesResponse,
                      AgentAnomalyDetectionScope>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_AGENT_ANOMALY_DETECTION_SCOPES_PAGE_STR_DESC,
                          request,
                          context);
              return ListAgentAnomalyDetectionScopesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAnalyzedSessionsRequest,
          ListAnalyzedSessionsResponse,
          ListAnalyzedSessionsPagedResponse>
      LIST_ANALYZED_SESSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAnalyzedSessionsRequest,
              ListAnalyzedSessionsResponse,
              ListAnalyzedSessionsPagedResponse>() {
            @Override
            public ApiFuture<ListAnalyzedSessionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAnalyzedSessionsRequest, ListAnalyzedSessionsResponse> callable,
                ListAnalyzedSessionsRequest request,
                ApiCallContext context,
                ApiFuture<ListAnalyzedSessionsResponse> futureResponse) {
              PageContext<
                      ListAnalyzedSessionsRequest, ListAnalyzedSessionsResponse, AnalyzedSession>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ANALYZED_SESSIONS_PAGE_STR_DESC, request, context);
              return ListAnalyzedSessionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAnalyzedInvocationsRequest,
          ListAnalyzedInvocationsResponse,
          ListAnalyzedInvocationsPagedResponse>
      LIST_ANALYZED_INVOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAnalyzedInvocationsRequest,
              ListAnalyzedInvocationsResponse,
              ListAnalyzedInvocationsPagedResponse>() {
            @Override
            public ApiFuture<ListAnalyzedInvocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAnalyzedInvocationsRequest, ListAnalyzedInvocationsResponse>
                    callable,
                ListAnalyzedInvocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListAnalyzedInvocationsResponse> futureResponse) {
              PageContext<
                      ListAnalyzedInvocationsRequest,
                      ListAnalyzedInvocationsResponse,
                      AnalyzedInvocation>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ANALYZED_INVOCATIONS_PAGE_STR_DESC, request, context);
              return ListAnalyzedInvocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          AggregateAnalyzedSessionsRequest,
          AggregateAnalyzedSessionsResponse,
          AggregateAnalyzedSessionsPagedResponse>
      AGGREGATE_ANALYZED_SESSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregateAnalyzedSessionsRequest,
              AggregateAnalyzedSessionsResponse,
              AggregateAnalyzedSessionsPagedResponse>() {
            @Override
            public ApiFuture<AggregateAnalyzedSessionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregateAnalyzedSessionsRequest, AggregateAnalyzedSessionsResponse>
                    callable,
                AggregateAnalyzedSessionsRequest request,
                ApiCallContext context,
                ApiFuture<AggregateAnalyzedSessionsResponse> futureResponse) {
              PageContext<
                      AggregateAnalyzedSessionsRequest,
                      AggregateAnalyzedSessionsResponse,
                      AggregateAnalyzedSessionsResponse.AgentAggregate>
                  pageContext =
                      PageContext.create(
                          callable, AGGREGATE_ANALYZED_SESSIONS_PAGE_STR_DESC, request, context);
              return AggregateAnalyzedSessionsPagedResponse.createAsync(
                  pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to getAgentAnomalyDetectionScope. */
  public UnaryCallSettings<GetAgentAnomalyDetectionScopeRequest, AgentAnomalyDetectionScope>
      getAgentAnomalyDetectionScopeSettings() {
    return getAgentAnomalyDetectionScopeSettings;
  }

  /** Returns the object with the settings used for calls to getMonitoredAgent. */
  public UnaryCallSettings<GetMonitoredAgentRequest, MonitoredAgent> getMonitoredAgentSettings() {
    return getMonitoredAgentSettings;
  }

  /** Returns the object with the settings used for calls to listMonitoredAgents. */
  public PagedCallSettings<
          ListMonitoredAgentsRequest, ListMonitoredAgentsResponse, ListMonitoredAgentsPagedResponse>
      listMonitoredAgentsSettings() {
    return listMonitoredAgentsSettings;
  }

  /** Returns the object with the settings used for calls to enableMonitoredAgent. */
  public UnaryCallSettings<EnableMonitoredAgentRequest, Operation> enableMonitoredAgentSettings() {
    return enableMonitoredAgentSettings;
  }

  /** Returns the object with the settings used for calls to enableMonitoredAgent. */
  public OperationCallSettings<
          EnableMonitoredAgentRequest, MonitoredAgent, EnableMonitoredAgentOperationMetadata>
      enableMonitoredAgentOperationSettings() {
    return enableMonitoredAgentOperationSettings;
  }

  /** Returns the object with the settings used for calls to disableMonitoredAgent. */
  public UnaryCallSettings<DisableMonitoredAgentRequest, Operation>
      disableMonitoredAgentSettings() {
    return disableMonitoredAgentSettings;
  }

  /** Returns the object with the settings used for calls to disableMonitoredAgent. */
  public OperationCallSettings<
          DisableMonitoredAgentRequest, MonitoredAgent, DisableMonitoredAgentOperationMetadata>
      disableMonitoredAgentOperationSettings() {
    return disableMonitoredAgentOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteAgentAnomalyDetectionScope. */
  public UnaryCallSettings<DeleteAgentAnomalyDetectionScopeRequest, Operation>
      deleteAgentAnomalyDetectionScopeSettings() {
    return deleteAgentAnomalyDetectionScopeSettings;
  }

  /** Returns the object with the settings used for calls to deleteAgentAnomalyDetectionScope. */
  public OperationCallSettings<
          DeleteAgentAnomalyDetectionScopeRequest,
          Empty,
          DeleteAgentAnomalyDetectionScopeOperationMetadata>
      deleteAgentAnomalyDetectionScopeOperationSettings() {
    return deleteAgentAnomalyDetectionScopeOperationSettings;
  }

  /** Returns the object with the settings used for calls to createAgentAnomalyDetectionScope. */
  public UnaryCallSettings<CreateAgentAnomalyDetectionScopeRequest, Operation>
      createAgentAnomalyDetectionScopeSettings() {
    return createAgentAnomalyDetectionScopeSettings;
  }

  /** Returns the object with the settings used for calls to createAgentAnomalyDetectionScope. */
  public OperationCallSettings<
          CreateAgentAnomalyDetectionScopeRequest,
          AgentAnomalyDetectionScope,
          CreateAgentAnomalyDetectionScopeOperationMetadata>
      createAgentAnomalyDetectionScopeOperationSettings() {
    return createAgentAnomalyDetectionScopeOperationSettings;
  }

  /** Returns the object with the settings used for calls to listAgentAnomalyDetectionScopes. */
  public PagedCallSettings<
          ListAgentAnomalyDetectionScopesRequest,
          ListAgentAnomalyDetectionScopesResponse,
          ListAgentAnomalyDetectionScopesPagedResponse>
      listAgentAnomalyDetectionScopesSettings() {
    return listAgentAnomalyDetectionScopesSettings;
  }

  /** Returns the object with the settings used for calls to listAnalyzedSessions. */
  public PagedCallSettings<
          ListAnalyzedSessionsRequest,
          ListAnalyzedSessionsResponse,
          ListAnalyzedSessionsPagedResponse>
      listAnalyzedSessionsSettings() {
    return listAnalyzedSessionsSettings;
  }

  /** Returns the object with the settings used for calls to getAnalyzedSession. */
  public UnaryCallSettings<GetAnalyzedSessionRequest, AnalyzedSession>
      getAnalyzedSessionSettings() {
    return getAnalyzedSessionSettings;
  }

  /** Returns the object with the settings used for calls to listAnalyzedInvocations. */
  public PagedCallSettings<
          ListAnalyzedInvocationsRequest,
          ListAnalyzedInvocationsResponse,
          ListAnalyzedInvocationsPagedResponse>
      listAnalyzedInvocationsSettings() {
    return listAnalyzedInvocationsSettings;
  }

  /** Returns the object with the settings used for calls to getAnalyzedInvocation. */
  public UnaryCallSettings<GetAnalyzedInvocationRequest, AnalyzedInvocation>
      getAnalyzedInvocationSettings() {
    return getAnalyzedInvocationSettings;
  }

  /** Returns the object with the settings used for calls to aggregateAnalyzedSessions. */
  public PagedCallSettings<
          AggregateAnalyzedSessionsRequest,
          AggregateAnalyzedSessionsResponse,
          AggregateAnalyzedSessionsPagedResponse>
      aggregateAnalyzedSessionsSettings() {
    return aggregateAnalyzedSessionsSettings;
  }

  /** Returns the object with the settings used for calls to clearTrainingData. */
  public UnaryCallSettings<ClearTrainingDataRequest, Operation> clearTrainingDataSettings() {
    return clearTrainingDataSettings;
  }

  /** Returns the object with the settings used for calls to clearTrainingData. */
  public OperationCallSettings<
          ClearTrainingDataRequest, ClearTrainingDataResponse, ClearTrainingDataOperationMetadata>
      clearTrainingDataOperationSettings() {
    return clearTrainingDataOperationSettings;
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

  public AgentAnomalyDetectionServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAgentAnomalyDetectionServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "aiplatform";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "aiplatform.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "aiplatform.mtls.googleapis.com:443";
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

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic",
            GaxProperties.getLibraryVersion(AgentAnomalyDetectionServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected AgentAnomalyDetectionServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getAgentAnomalyDetectionScopeSettings =
        settingsBuilder.getAgentAnomalyDetectionScopeSettings().build();
    getMonitoredAgentSettings = settingsBuilder.getMonitoredAgentSettings().build();
    listMonitoredAgentsSettings = settingsBuilder.listMonitoredAgentsSettings().build();
    enableMonitoredAgentSettings = settingsBuilder.enableMonitoredAgentSettings().build();
    enableMonitoredAgentOperationSettings =
        settingsBuilder.enableMonitoredAgentOperationSettings().build();
    disableMonitoredAgentSettings = settingsBuilder.disableMonitoredAgentSettings().build();
    disableMonitoredAgentOperationSettings =
        settingsBuilder.disableMonitoredAgentOperationSettings().build();
    deleteAgentAnomalyDetectionScopeSettings =
        settingsBuilder.deleteAgentAnomalyDetectionScopeSettings().build();
    deleteAgentAnomalyDetectionScopeOperationSettings =
        settingsBuilder.deleteAgentAnomalyDetectionScopeOperationSettings().build();
    createAgentAnomalyDetectionScopeSettings =
        settingsBuilder.createAgentAnomalyDetectionScopeSettings().build();
    createAgentAnomalyDetectionScopeOperationSettings =
        settingsBuilder.createAgentAnomalyDetectionScopeOperationSettings().build();
    listAgentAnomalyDetectionScopesSettings =
        settingsBuilder.listAgentAnomalyDetectionScopesSettings().build();
    listAnalyzedSessionsSettings = settingsBuilder.listAnalyzedSessionsSettings().build();
    getAnalyzedSessionSettings = settingsBuilder.getAnalyzedSessionSettings().build();
    listAnalyzedInvocationsSettings = settingsBuilder.listAnalyzedInvocationsSettings().build();
    getAnalyzedInvocationSettings = settingsBuilder.getAnalyzedInvocationSettings().build();
    aggregateAnalyzedSessionsSettings = settingsBuilder.aggregateAnalyzedSessionsSettings().build();
    clearTrainingDataSettings = settingsBuilder.clearTrainingDataSettings().build();
    clearTrainingDataOperationSettings =
        settingsBuilder.clearTrainingDataOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-aiplatform")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for AgentAnomalyDetectionServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<AgentAnomalyDetectionServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<
            GetAgentAnomalyDetectionScopeRequest, AgentAnomalyDetectionScope>
        getAgentAnomalyDetectionScopeSettings;
    private final UnaryCallSettings.Builder<GetMonitoredAgentRequest, MonitoredAgent>
        getMonitoredAgentSettings;
    private final PagedCallSettings.Builder<
            ListMonitoredAgentsRequest,
            ListMonitoredAgentsResponse,
            ListMonitoredAgentsPagedResponse>
        listMonitoredAgentsSettings;
    private final UnaryCallSettings.Builder<EnableMonitoredAgentRequest, Operation>
        enableMonitoredAgentSettings;
    private final OperationCallSettings.Builder<
            EnableMonitoredAgentRequest, MonitoredAgent, EnableMonitoredAgentOperationMetadata>
        enableMonitoredAgentOperationSettings;
    private final UnaryCallSettings.Builder<DisableMonitoredAgentRequest, Operation>
        disableMonitoredAgentSettings;
    private final OperationCallSettings.Builder<
            DisableMonitoredAgentRequest, MonitoredAgent, DisableMonitoredAgentOperationMetadata>
        disableMonitoredAgentOperationSettings;
    private final UnaryCallSettings.Builder<DeleteAgentAnomalyDetectionScopeRequest, Operation>
        deleteAgentAnomalyDetectionScopeSettings;
    private final OperationCallSettings.Builder<
            DeleteAgentAnomalyDetectionScopeRequest,
            Empty,
            DeleteAgentAnomalyDetectionScopeOperationMetadata>
        deleteAgentAnomalyDetectionScopeOperationSettings;
    private final UnaryCallSettings.Builder<CreateAgentAnomalyDetectionScopeRequest, Operation>
        createAgentAnomalyDetectionScopeSettings;
    private final OperationCallSettings.Builder<
            CreateAgentAnomalyDetectionScopeRequest,
            AgentAnomalyDetectionScope,
            CreateAgentAnomalyDetectionScopeOperationMetadata>
        createAgentAnomalyDetectionScopeOperationSettings;
    private final PagedCallSettings.Builder<
            ListAgentAnomalyDetectionScopesRequest,
            ListAgentAnomalyDetectionScopesResponse,
            ListAgentAnomalyDetectionScopesPagedResponse>
        listAgentAnomalyDetectionScopesSettings;
    private final PagedCallSettings.Builder<
            ListAnalyzedSessionsRequest,
            ListAnalyzedSessionsResponse,
            ListAnalyzedSessionsPagedResponse>
        listAnalyzedSessionsSettings;
    private final UnaryCallSettings.Builder<GetAnalyzedSessionRequest, AnalyzedSession>
        getAnalyzedSessionSettings;
    private final PagedCallSettings.Builder<
            ListAnalyzedInvocationsRequest,
            ListAnalyzedInvocationsResponse,
            ListAnalyzedInvocationsPagedResponse>
        listAnalyzedInvocationsSettings;
    private final UnaryCallSettings.Builder<GetAnalyzedInvocationRequest, AnalyzedInvocation>
        getAnalyzedInvocationSettings;
    private final PagedCallSettings.Builder<
            AggregateAnalyzedSessionsRequest,
            AggregateAnalyzedSessionsResponse,
            AggregateAnalyzedSessionsPagedResponse>
        aggregateAnalyzedSessionsSettings;
    private final UnaryCallSettings.Builder<ClearTrainingDataRequest, Operation>
        clearTrainingDataSettings;
    private final OperationCallSettings.Builder<
            ClearTrainingDataRequest, ClearTrainingDataResponse, ClearTrainingDataOperationMetadata>
        clearTrainingDataOperationSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
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

    protected Builder(@Nullable ClientContext clientContext) {
      super(clientContext);

      getAgentAnomalyDetectionScopeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getMonitoredAgentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listMonitoredAgentsSettings =
          PagedCallSettings.newBuilder(LIST_MONITORED_AGENTS_PAGE_STR_FACT);
      enableMonitoredAgentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      enableMonitoredAgentOperationSettings = OperationCallSettings.newBuilder();
      disableMonitoredAgentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      disableMonitoredAgentOperationSettings = OperationCallSettings.newBuilder();
      deleteAgentAnomalyDetectionScopeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAgentAnomalyDetectionScopeOperationSettings = OperationCallSettings.newBuilder();
      createAgentAnomalyDetectionScopeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAgentAnomalyDetectionScopeOperationSettings = OperationCallSettings.newBuilder();
      listAgentAnomalyDetectionScopesSettings =
          PagedCallSettings.newBuilder(LIST_AGENT_ANOMALY_DETECTION_SCOPES_PAGE_STR_FACT);
      listAnalyzedSessionsSettings =
          PagedCallSettings.newBuilder(LIST_ANALYZED_SESSIONS_PAGE_STR_FACT);
      getAnalyzedSessionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAnalyzedInvocationsSettings =
          PagedCallSettings.newBuilder(LIST_ANALYZED_INVOCATIONS_PAGE_STR_FACT);
      getAnalyzedInvocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      aggregateAnalyzedSessionsSettings =
          PagedCallSettings.newBuilder(AGGREGATE_ANALYZED_SESSIONS_PAGE_STR_FACT);
      clearTrainingDataSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      clearTrainingDataOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getAgentAnomalyDetectionScopeSettings,
              getMonitoredAgentSettings,
              listMonitoredAgentsSettings,
              enableMonitoredAgentSettings,
              disableMonitoredAgentSettings,
              deleteAgentAnomalyDetectionScopeSettings,
              createAgentAnomalyDetectionScopeSettings,
              listAgentAnomalyDetectionScopesSettings,
              listAnalyzedSessionsSettings,
              getAnalyzedSessionSettings,
              listAnalyzedInvocationsSettings,
              getAnalyzedInvocationSettings,
              aggregateAnalyzedSessionsSettings,
              clearTrainingDataSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(AgentAnomalyDetectionServiceStubSettings settings) {
      super(settings);

      getAgentAnomalyDetectionScopeSettings =
          settings.getAgentAnomalyDetectionScopeSettings.toBuilder();
      getMonitoredAgentSettings = settings.getMonitoredAgentSettings.toBuilder();
      listMonitoredAgentsSettings = settings.listMonitoredAgentsSettings.toBuilder();
      enableMonitoredAgentSettings = settings.enableMonitoredAgentSettings.toBuilder();
      enableMonitoredAgentOperationSettings =
          settings.enableMonitoredAgentOperationSettings.toBuilder();
      disableMonitoredAgentSettings = settings.disableMonitoredAgentSettings.toBuilder();
      disableMonitoredAgentOperationSettings =
          settings.disableMonitoredAgentOperationSettings.toBuilder();
      deleteAgentAnomalyDetectionScopeSettings =
          settings.deleteAgentAnomalyDetectionScopeSettings.toBuilder();
      deleteAgentAnomalyDetectionScopeOperationSettings =
          settings.deleteAgentAnomalyDetectionScopeOperationSettings.toBuilder();
      createAgentAnomalyDetectionScopeSettings =
          settings.createAgentAnomalyDetectionScopeSettings.toBuilder();
      createAgentAnomalyDetectionScopeOperationSettings =
          settings.createAgentAnomalyDetectionScopeOperationSettings.toBuilder();
      listAgentAnomalyDetectionScopesSettings =
          settings.listAgentAnomalyDetectionScopesSettings.toBuilder();
      listAnalyzedSessionsSettings = settings.listAnalyzedSessionsSettings.toBuilder();
      getAnalyzedSessionSettings = settings.getAnalyzedSessionSettings.toBuilder();
      listAnalyzedInvocationsSettings = settings.listAnalyzedInvocationsSettings.toBuilder();
      getAnalyzedInvocationSettings = settings.getAnalyzedInvocationSettings.toBuilder();
      aggregateAnalyzedSessionsSettings = settings.aggregateAnalyzedSessionsSettings.toBuilder();
      clearTrainingDataSettings = settings.clearTrainingDataSettings.toBuilder();
      clearTrainingDataOperationSettings = settings.clearTrainingDataOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getAgentAnomalyDetectionScopeSettings,
              getMonitoredAgentSettings,
              listMonitoredAgentsSettings,
              enableMonitoredAgentSettings,
              disableMonitoredAgentSettings,
              deleteAgentAnomalyDetectionScopeSettings,
              createAgentAnomalyDetectionScopeSettings,
              listAgentAnomalyDetectionScopesSettings,
              listAnalyzedSessionsSettings,
              getAnalyzedSessionSettings,
              listAnalyzedInvocationsSettings,
              getAnalyzedInvocationSettings,
              aggregateAnalyzedSessionsSettings,
              clearTrainingDataSettings,
              listLocationsSettings,
              getLocationSettings,
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

    private static Builder initDefaults(Builder builder) {
      builder
          .getAgentAnomalyDetectionScopeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getMonitoredAgentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listMonitoredAgentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .enableMonitoredAgentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .disableMonitoredAgentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteAgentAnomalyDetectionScopeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createAgentAnomalyDetectionScopeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listAgentAnomalyDetectionScopesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listAnalyzedSessionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getAnalyzedSessionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listAnalyzedInvocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getAnalyzedInvocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .aggregateAnalyzedSessionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .clearTrainingDataSettings()
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
          .enableMonitoredAgentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<EnableMonitoredAgentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MonitoredAgent.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  EnableMonitoredAgentOperationMetadata.class))
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
          .disableMonitoredAgentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DisableMonitoredAgentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MonitoredAgent.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  DisableMonitoredAgentOperationMetadata.class))
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
          .deleteAgentAnomalyDetectionScopeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteAgentAnomalyDetectionScopeRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  DeleteAgentAnomalyDetectionScopeOperationMetadata.class))
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
          .createAgentAnomalyDetectionScopeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateAgentAnomalyDetectionScopeRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  AgentAnomalyDetectionScope.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateAgentAnomalyDetectionScopeOperationMetadata.class))
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
          .clearTrainingDataOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ClearTrainingDataRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ClearTrainingDataResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ClearTrainingDataOperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to getAgentAnomalyDetectionScope. */
    public UnaryCallSettings.Builder<
            GetAgentAnomalyDetectionScopeRequest, AgentAnomalyDetectionScope>
        getAgentAnomalyDetectionScopeSettings() {
      return getAgentAnomalyDetectionScopeSettings;
    }

    /** Returns the builder for the settings used for calls to getMonitoredAgent. */
    public UnaryCallSettings.Builder<GetMonitoredAgentRequest, MonitoredAgent>
        getMonitoredAgentSettings() {
      return getMonitoredAgentSettings;
    }

    /** Returns the builder for the settings used for calls to listMonitoredAgents. */
    public PagedCallSettings.Builder<
            ListMonitoredAgentsRequest,
            ListMonitoredAgentsResponse,
            ListMonitoredAgentsPagedResponse>
        listMonitoredAgentsSettings() {
      return listMonitoredAgentsSettings;
    }

    /** Returns the builder for the settings used for calls to enableMonitoredAgent. */
    public UnaryCallSettings.Builder<EnableMonitoredAgentRequest, Operation>
        enableMonitoredAgentSettings() {
      return enableMonitoredAgentSettings;
    }

    /** Returns the builder for the settings used for calls to enableMonitoredAgent. */
    public OperationCallSettings.Builder<
            EnableMonitoredAgentRequest, MonitoredAgent, EnableMonitoredAgentOperationMetadata>
        enableMonitoredAgentOperationSettings() {
      return enableMonitoredAgentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to disableMonitoredAgent. */
    public UnaryCallSettings.Builder<DisableMonitoredAgentRequest, Operation>
        disableMonitoredAgentSettings() {
      return disableMonitoredAgentSettings;
    }

    /** Returns the builder for the settings used for calls to disableMonitoredAgent. */
    public OperationCallSettings.Builder<
            DisableMonitoredAgentRequest, MonitoredAgent, DisableMonitoredAgentOperationMetadata>
        disableMonitoredAgentOperationSettings() {
      return disableMonitoredAgentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAgentAnomalyDetectionScope. */
    public UnaryCallSettings.Builder<DeleteAgentAnomalyDetectionScopeRequest, Operation>
        deleteAgentAnomalyDetectionScopeSettings() {
      return deleteAgentAnomalyDetectionScopeSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAgentAnomalyDetectionScope. */
    public OperationCallSettings.Builder<
            DeleteAgentAnomalyDetectionScopeRequest,
            Empty,
            DeleteAgentAnomalyDetectionScopeOperationMetadata>
        deleteAgentAnomalyDetectionScopeOperationSettings() {
      return deleteAgentAnomalyDetectionScopeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createAgentAnomalyDetectionScope. */
    public UnaryCallSettings.Builder<CreateAgentAnomalyDetectionScopeRequest, Operation>
        createAgentAnomalyDetectionScopeSettings() {
      return createAgentAnomalyDetectionScopeSettings;
    }

    /** Returns the builder for the settings used for calls to createAgentAnomalyDetectionScope. */
    public OperationCallSettings.Builder<
            CreateAgentAnomalyDetectionScopeRequest,
            AgentAnomalyDetectionScope,
            CreateAgentAnomalyDetectionScopeOperationMetadata>
        createAgentAnomalyDetectionScopeOperationSettings() {
      return createAgentAnomalyDetectionScopeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listAgentAnomalyDetectionScopes. */
    public PagedCallSettings.Builder<
            ListAgentAnomalyDetectionScopesRequest,
            ListAgentAnomalyDetectionScopesResponse,
            ListAgentAnomalyDetectionScopesPagedResponse>
        listAgentAnomalyDetectionScopesSettings() {
      return listAgentAnomalyDetectionScopesSettings;
    }

    /** Returns the builder for the settings used for calls to listAnalyzedSessions. */
    public PagedCallSettings.Builder<
            ListAnalyzedSessionsRequest,
            ListAnalyzedSessionsResponse,
            ListAnalyzedSessionsPagedResponse>
        listAnalyzedSessionsSettings() {
      return listAnalyzedSessionsSettings;
    }

    /** Returns the builder for the settings used for calls to getAnalyzedSession. */
    public UnaryCallSettings.Builder<GetAnalyzedSessionRequest, AnalyzedSession>
        getAnalyzedSessionSettings() {
      return getAnalyzedSessionSettings;
    }

    /** Returns the builder for the settings used for calls to listAnalyzedInvocations. */
    public PagedCallSettings.Builder<
            ListAnalyzedInvocationsRequest,
            ListAnalyzedInvocationsResponse,
            ListAnalyzedInvocationsPagedResponse>
        listAnalyzedInvocationsSettings() {
      return listAnalyzedInvocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getAnalyzedInvocation. */
    public UnaryCallSettings.Builder<GetAnalyzedInvocationRequest, AnalyzedInvocation>
        getAnalyzedInvocationSettings() {
      return getAnalyzedInvocationSettings;
    }

    /** Returns the builder for the settings used for calls to aggregateAnalyzedSessions. */
    public PagedCallSettings.Builder<
            AggregateAnalyzedSessionsRequest,
            AggregateAnalyzedSessionsResponse,
            AggregateAnalyzedSessionsPagedResponse>
        aggregateAnalyzedSessionsSettings() {
      return aggregateAnalyzedSessionsSettings;
    }

    /** Returns the builder for the settings used for calls to clearTrainingData. */
    public UnaryCallSettings.Builder<ClearTrainingDataRequest, Operation>
        clearTrainingDataSettings() {
      return clearTrainingDataSettings;
    }

    /** Returns the builder for the settings used for calls to clearTrainingData. */
    public OperationCallSettings.Builder<
            ClearTrainingDataRequest, ClearTrainingDataResponse, ClearTrainingDataOperationMetadata>
        clearTrainingDataOperationSettings() {
      return clearTrainingDataOperationSettings;
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
    public AgentAnomalyDetectionServiceStubSettings build() throws IOException {
      return new AgentAnomalyDetectionServiceStubSettings(this);
    }
  }
}
