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

package com.google.cloud.ces.v1.stub;

import static com.google.cloud.ces.v1.AgentServiceClient.ListAgentsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListAppVersionsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListAppsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListChangelogsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListConversationsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListDeploymentsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListExamplesPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListGuardrailsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListToolsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListToolsetsPagedResponse;

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
import com.google.cloud.ces.v1.Agent;
import com.google.cloud.ces.v1.App;
import com.google.cloud.ces.v1.AppVersion;
import com.google.cloud.ces.v1.BatchDeleteConversationsRequest;
import com.google.cloud.ces.v1.BatchDeleteConversationsResponse;
import com.google.cloud.ces.v1.Changelog;
import com.google.cloud.ces.v1.Conversation;
import com.google.cloud.ces.v1.CreateAgentRequest;
import com.google.cloud.ces.v1.CreateAppRequest;
import com.google.cloud.ces.v1.CreateAppVersionRequest;
import com.google.cloud.ces.v1.CreateDeploymentRequest;
import com.google.cloud.ces.v1.CreateExampleRequest;
import com.google.cloud.ces.v1.CreateGuardrailRequest;
import com.google.cloud.ces.v1.CreateToolRequest;
import com.google.cloud.ces.v1.CreateToolsetRequest;
import com.google.cloud.ces.v1.DeleteAgentRequest;
import com.google.cloud.ces.v1.DeleteAppRequest;
import com.google.cloud.ces.v1.DeleteAppVersionRequest;
import com.google.cloud.ces.v1.DeleteConversationRequest;
import com.google.cloud.ces.v1.DeleteDeploymentRequest;
import com.google.cloud.ces.v1.DeleteExampleRequest;
import com.google.cloud.ces.v1.DeleteGuardrailRequest;
import com.google.cloud.ces.v1.DeleteToolRequest;
import com.google.cloud.ces.v1.DeleteToolsetRequest;
import com.google.cloud.ces.v1.Deployment;
import com.google.cloud.ces.v1.Example;
import com.google.cloud.ces.v1.ExportAppRequest;
import com.google.cloud.ces.v1.ExportAppResponse;
import com.google.cloud.ces.v1.GetAgentRequest;
import com.google.cloud.ces.v1.GetAppRequest;
import com.google.cloud.ces.v1.GetAppVersionRequest;
import com.google.cloud.ces.v1.GetChangelogRequest;
import com.google.cloud.ces.v1.GetConversationRequest;
import com.google.cloud.ces.v1.GetDeploymentRequest;
import com.google.cloud.ces.v1.GetExampleRequest;
import com.google.cloud.ces.v1.GetGuardrailRequest;
import com.google.cloud.ces.v1.GetToolRequest;
import com.google.cloud.ces.v1.GetToolsetRequest;
import com.google.cloud.ces.v1.Guardrail;
import com.google.cloud.ces.v1.ImportAppRequest;
import com.google.cloud.ces.v1.ImportAppResponse;
import com.google.cloud.ces.v1.ListAgentsRequest;
import com.google.cloud.ces.v1.ListAgentsResponse;
import com.google.cloud.ces.v1.ListAppVersionsRequest;
import com.google.cloud.ces.v1.ListAppVersionsResponse;
import com.google.cloud.ces.v1.ListAppsRequest;
import com.google.cloud.ces.v1.ListAppsResponse;
import com.google.cloud.ces.v1.ListChangelogsRequest;
import com.google.cloud.ces.v1.ListChangelogsResponse;
import com.google.cloud.ces.v1.ListConversationsRequest;
import com.google.cloud.ces.v1.ListConversationsResponse;
import com.google.cloud.ces.v1.ListDeploymentsRequest;
import com.google.cloud.ces.v1.ListDeploymentsResponse;
import com.google.cloud.ces.v1.ListExamplesRequest;
import com.google.cloud.ces.v1.ListExamplesResponse;
import com.google.cloud.ces.v1.ListGuardrailsRequest;
import com.google.cloud.ces.v1.ListGuardrailsResponse;
import com.google.cloud.ces.v1.ListToolsRequest;
import com.google.cloud.ces.v1.ListToolsResponse;
import com.google.cloud.ces.v1.ListToolsetsRequest;
import com.google.cloud.ces.v1.ListToolsetsResponse;
import com.google.cloud.ces.v1.OperationMetadata;
import com.google.cloud.ces.v1.RestoreAppVersionRequest;
import com.google.cloud.ces.v1.RestoreAppVersionResponse;
import com.google.cloud.ces.v1.Tool;
import com.google.cloud.ces.v1.Toolset;
import com.google.cloud.ces.v1.UpdateAgentRequest;
import com.google.cloud.ces.v1.UpdateAppRequest;
import com.google.cloud.ces.v1.UpdateDeploymentRequest;
import com.google.cloud.ces.v1.UpdateExampleRequest;
import com.google.cloud.ces.v1.UpdateGuardrailRequest;
import com.google.cloud.ces.v1.UpdateToolRequest;
import com.google.cloud.ces.v1.UpdateToolsetRequest;
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
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AgentServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (ces.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getApp:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AgentServiceStubSettings.Builder agentServiceSettingsBuilder =
 *     AgentServiceStubSettings.newBuilder();
 * agentServiceSettingsBuilder
 *     .getAppSettings()
 *     .setRetrySettings(
 *         agentServiceSettingsBuilder
 *             .getAppSettings()
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
 * AgentServiceStubSettings agentServiceSettings = agentServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createApp:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AgentServiceStubSettings.Builder agentServiceSettingsBuilder =
 *     AgentServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * agentServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AgentServiceStubSettings extends StubSettings<AgentServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/ces")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final PagedCallSettings<ListAppsRequest, ListAppsResponse, ListAppsPagedResponse>
      listAppsSettings;
  private final UnaryCallSettings<GetAppRequest, App> getAppSettings;
  private final UnaryCallSettings<CreateAppRequest, Operation> createAppSettings;
  private final OperationCallSettings<CreateAppRequest, App, OperationMetadata>
      createAppOperationSettings;
  private final UnaryCallSettings<UpdateAppRequest, App> updateAppSettings;
  private final UnaryCallSettings<DeleteAppRequest, Operation> deleteAppSettings;
  private final OperationCallSettings<DeleteAppRequest, Empty, OperationMetadata>
      deleteAppOperationSettings;
  private final UnaryCallSettings<ExportAppRequest, Operation> exportAppSettings;
  private final OperationCallSettings<ExportAppRequest, ExportAppResponse, OperationMetadata>
      exportAppOperationSettings;
  private final UnaryCallSettings<ImportAppRequest, Operation> importAppSettings;
  private final OperationCallSettings<ImportAppRequest, ImportAppResponse, OperationMetadata>
      importAppOperationSettings;
  private final PagedCallSettings<ListAgentsRequest, ListAgentsResponse, ListAgentsPagedResponse>
      listAgentsSettings;
  private final UnaryCallSettings<GetAgentRequest, Agent> getAgentSettings;
  private final UnaryCallSettings<CreateAgentRequest, Agent> createAgentSettings;
  private final UnaryCallSettings<UpdateAgentRequest, Agent> updateAgentSettings;
  private final UnaryCallSettings<DeleteAgentRequest, Empty> deleteAgentSettings;
  private final PagedCallSettings<
          ListExamplesRequest, ListExamplesResponse, ListExamplesPagedResponse>
      listExamplesSettings;
  private final UnaryCallSettings<GetExampleRequest, Example> getExampleSettings;
  private final UnaryCallSettings<CreateExampleRequest, Example> createExampleSettings;
  private final UnaryCallSettings<UpdateExampleRequest, Example> updateExampleSettings;
  private final UnaryCallSettings<DeleteExampleRequest, Empty> deleteExampleSettings;
  private final PagedCallSettings<ListToolsRequest, ListToolsResponse, ListToolsPagedResponse>
      listToolsSettings;
  private final UnaryCallSettings<GetToolRequest, Tool> getToolSettings;
  private final PagedCallSettings<
          ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
      listConversationsSettings;
  private final UnaryCallSettings<GetConversationRequest, Conversation> getConversationSettings;
  private final UnaryCallSettings<DeleteConversationRequest, Empty> deleteConversationSettings;
  private final UnaryCallSettings<BatchDeleteConversationsRequest, Operation>
      batchDeleteConversationsSettings;
  private final OperationCallSettings<
          BatchDeleteConversationsRequest, BatchDeleteConversationsResponse, OperationMetadata>
      batchDeleteConversationsOperationSettings;
  private final UnaryCallSettings<CreateToolRequest, Tool> createToolSettings;
  private final UnaryCallSettings<UpdateToolRequest, Tool> updateToolSettings;
  private final UnaryCallSettings<DeleteToolRequest, Empty> deleteToolSettings;
  private final PagedCallSettings<
          ListGuardrailsRequest, ListGuardrailsResponse, ListGuardrailsPagedResponse>
      listGuardrailsSettings;
  private final UnaryCallSettings<GetGuardrailRequest, Guardrail> getGuardrailSettings;
  private final UnaryCallSettings<CreateGuardrailRequest, Guardrail> createGuardrailSettings;
  private final UnaryCallSettings<UpdateGuardrailRequest, Guardrail> updateGuardrailSettings;
  private final UnaryCallSettings<DeleteGuardrailRequest, Empty> deleteGuardrailSettings;
  private final PagedCallSettings<
          ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
      listDeploymentsSettings;
  private final UnaryCallSettings<GetDeploymentRequest, Deployment> getDeploymentSettings;
  private final UnaryCallSettings<CreateDeploymentRequest, Deployment> createDeploymentSettings;
  private final UnaryCallSettings<UpdateDeploymentRequest, Deployment> updateDeploymentSettings;
  private final UnaryCallSettings<DeleteDeploymentRequest, Empty> deleteDeploymentSettings;
  private final PagedCallSettings<
          ListToolsetsRequest, ListToolsetsResponse, ListToolsetsPagedResponse>
      listToolsetsSettings;
  private final UnaryCallSettings<GetToolsetRequest, Toolset> getToolsetSettings;
  private final UnaryCallSettings<CreateToolsetRequest, Toolset> createToolsetSettings;
  private final UnaryCallSettings<UpdateToolsetRequest, Toolset> updateToolsetSettings;
  private final UnaryCallSettings<DeleteToolsetRequest, Empty> deleteToolsetSettings;
  private final PagedCallSettings<
          ListAppVersionsRequest, ListAppVersionsResponse, ListAppVersionsPagedResponse>
      listAppVersionsSettings;
  private final UnaryCallSettings<GetAppVersionRequest, AppVersion> getAppVersionSettings;
  private final UnaryCallSettings<CreateAppVersionRequest, AppVersion> createAppVersionSettings;
  private final UnaryCallSettings<DeleteAppVersionRequest, Empty> deleteAppVersionSettings;
  private final UnaryCallSettings<RestoreAppVersionRequest, Operation> restoreAppVersionSettings;
  private final OperationCallSettings<
          RestoreAppVersionRequest, RestoreAppVersionResponse, OperationMetadata>
      restoreAppVersionOperationSettings;
  private final PagedCallSettings<
          ListChangelogsRequest, ListChangelogsResponse, ListChangelogsPagedResponse>
      listChangelogsSettings;
  private final UnaryCallSettings<GetChangelogRequest, Changelog> getChangelogSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListAppsRequest, ListAppsResponse, App>
      LIST_APPS_PAGE_STR_DESC =
          new PagedListDescriptor<ListAppsRequest, ListAppsResponse, App>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAppsRequest injectToken(ListAppsRequest payload, String token) {
              return ListAppsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAppsRequest injectPageSize(ListAppsRequest payload, int pageSize) {
              return ListAppsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAppsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAppsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<App> extractResources(ListAppsResponse payload) {
              return payload.getAppsList();
            }
          };

  private static final PagedListDescriptor<ListAgentsRequest, ListAgentsResponse, Agent>
      LIST_AGENTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListAgentsRequest, ListAgentsResponse, Agent>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAgentsRequest injectToken(ListAgentsRequest payload, String token) {
              return ListAgentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAgentsRequest injectPageSize(ListAgentsRequest payload, int pageSize) {
              return ListAgentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAgentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAgentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Agent> extractResources(ListAgentsResponse payload) {
              return payload.getAgentsList();
            }
          };

  private static final PagedListDescriptor<ListExamplesRequest, ListExamplesResponse, Example>
      LIST_EXAMPLES_PAGE_STR_DESC =
          new PagedListDescriptor<ListExamplesRequest, ListExamplesResponse, Example>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListExamplesRequest injectToken(ListExamplesRequest payload, String token) {
              return ListExamplesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListExamplesRequest injectPageSize(ListExamplesRequest payload, int pageSize) {
              return ListExamplesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListExamplesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListExamplesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Example> extractResources(ListExamplesResponse payload) {
              return payload.getExamplesList();
            }
          };

  private static final PagedListDescriptor<ListToolsRequest, ListToolsResponse, Tool>
      LIST_TOOLS_PAGE_STR_DESC =
          new PagedListDescriptor<ListToolsRequest, ListToolsResponse, Tool>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListToolsRequest injectToken(ListToolsRequest payload, String token) {
              return ListToolsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListToolsRequest injectPageSize(ListToolsRequest payload, int pageSize) {
              return ListToolsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListToolsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListToolsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Tool> extractResources(ListToolsResponse payload) {
              return payload.getToolsList();
            }
          };

  private static final PagedListDescriptor<
          ListConversationsRequest, ListConversationsResponse, Conversation>
      LIST_CONVERSATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListConversationsRequest, ListConversationsResponse, Conversation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListConversationsRequest injectToken(
                ListConversationsRequest payload, String token) {
              return ListConversationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListConversationsRequest injectPageSize(
                ListConversationsRequest payload, int pageSize) {
              return ListConversationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListConversationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListConversationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Conversation> extractResources(ListConversationsResponse payload) {
              return payload.getConversationsList();
            }
          };

  private static final PagedListDescriptor<ListGuardrailsRequest, ListGuardrailsResponse, Guardrail>
      LIST_GUARDRAILS_PAGE_STR_DESC =
          new PagedListDescriptor<ListGuardrailsRequest, ListGuardrailsResponse, Guardrail>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGuardrailsRequest injectToken(ListGuardrailsRequest payload, String token) {
              return ListGuardrailsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListGuardrailsRequest injectPageSize(
                ListGuardrailsRequest payload, int pageSize) {
              return ListGuardrailsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListGuardrailsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListGuardrailsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Guardrail> extractResources(ListGuardrailsResponse payload) {
              return payload.getGuardrailsList();
            }
          };

  private static final PagedListDescriptor<
          ListDeploymentsRequest, ListDeploymentsResponse, Deployment>
      LIST_DEPLOYMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDeploymentsRequest, ListDeploymentsResponse, Deployment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDeploymentsRequest injectToken(
                ListDeploymentsRequest payload, String token) {
              return ListDeploymentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDeploymentsRequest injectPageSize(
                ListDeploymentsRequest payload, int pageSize) {
              return ListDeploymentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDeploymentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDeploymentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Deployment> extractResources(ListDeploymentsResponse payload) {
              return payload.getDeploymentsList();
            }
          };

  private static final PagedListDescriptor<ListToolsetsRequest, ListToolsetsResponse, Toolset>
      LIST_TOOLSETS_PAGE_STR_DESC =
          new PagedListDescriptor<ListToolsetsRequest, ListToolsetsResponse, Toolset>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListToolsetsRequest injectToken(ListToolsetsRequest payload, String token) {
              return ListToolsetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListToolsetsRequest injectPageSize(ListToolsetsRequest payload, int pageSize) {
              return ListToolsetsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListToolsetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListToolsetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Toolset> extractResources(ListToolsetsResponse payload) {
              return payload.getToolsetsList();
            }
          };

  private static final PagedListDescriptor<
          ListAppVersionsRequest, ListAppVersionsResponse, AppVersion>
      LIST_APP_VERSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListAppVersionsRequest, ListAppVersionsResponse, AppVersion>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAppVersionsRequest injectToken(
                ListAppVersionsRequest payload, String token) {
              return ListAppVersionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAppVersionsRequest injectPageSize(
                ListAppVersionsRequest payload, int pageSize) {
              return ListAppVersionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAppVersionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAppVersionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AppVersion> extractResources(ListAppVersionsResponse payload) {
              return payload.getAppVersionsList();
            }
          };

  private static final PagedListDescriptor<ListChangelogsRequest, ListChangelogsResponse, Changelog>
      LIST_CHANGELOGS_PAGE_STR_DESC =
          new PagedListDescriptor<ListChangelogsRequest, ListChangelogsResponse, Changelog>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListChangelogsRequest injectToken(ListChangelogsRequest payload, String token) {
              return ListChangelogsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListChangelogsRequest injectPageSize(
                ListChangelogsRequest payload, int pageSize) {
              return ListChangelogsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListChangelogsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListChangelogsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Changelog> extractResources(ListChangelogsResponse payload) {
              return payload.getChangelogsList();
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
          ListAppsRequest, ListAppsResponse, ListAppsPagedResponse>
      LIST_APPS_PAGE_STR_FACT =
          new PagedListResponseFactory<ListAppsRequest, ListAppsResponse, ListAppsPagedResponse>() {
            @Override
            public ApiFuture<ListAppsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAppsRequest, ListAppsResponse> callable,
                ListAppsRequest request,
                ApiCallContext context,
                ApiFuture<ListAppsResponse> futureResponse) {
              PageContext<ListAppsRequest, ListAppsResponse, App> pageContext =
                  PageContext.create(callable, LIST_APPS_PAGE_STR_DESC, request, context);
              return ListAppsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAgentsRequest, ListAgentsResponse, ListAgentsPagedResponse>
      LIST_AGENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAgentsRequest, ListAgentsResponse, ListAgentsPagedResponse>() {
            @Override
            public ApiFuture<ListAgentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAgentsRequest, ListAgentsResponse> callable,
                ListAgentsRequest request,
                ApiCallContext context,
                ApiFuture<ListAgentsResponse> futureResponse) {
              PageContext<ListAgentsRequest, ListAgentsResponse, Agent> pageContext =
                  PageContext.create(callable, LIST_AGENTS_PAGE_STR_DESC, request, context);
              return ListAgentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListExamplesRequest, ListExamplesResponse, ListExamplesPagedResponse>
      LIST_EXAMPLES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListExamplesRequest, ListExamplesResponse, ListExamplesPagedResponse>() {
            @Override
            public ApiFuture<ListExamplesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListExamplesRequest, ListExamplesResponse> callable,
                ListExamplesRequest request,
                ApiCallContext context,
                ApiFuture<ListExamplesResponse> futureResponse) {
              PageContext<ListExamplesRequest, ListExamplesResponse, Example> pageContext =
                  PageContext.create(callable, LIST_EXAMPLES_PAGE_STR_DESC, request, context);
              return ListExamplesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListToolsRequest, ListToolsResponse, ListToolsPagedResponse>
      LIST_TOOLS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListToolsRequest, ListToolsResponse, ListToolsPagedResponse>() {
            @Override
            public ApiFuture<ListToolsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListToolsRequest, ListToolsResponse> callable,
                ListToolsRequest request,
                ApiCallContext context,
                ApiFuture<ListToolsResponse> futureResponse) {
              PageContext<ListToolsRequest, ListToolsResponse, Tool> pageContext =
                  PageContext.create(callable, LIST_TOOLS_PAGE_STR_DESC, request, context);
              return ListToolsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
      LIST_CONVERSATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListConversationsRequest,
              ListConversationsResponse,
              ListConversationsPagedResponse>() {
            @Override
            public ApiFuture<ListConversationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListConversationsRequest, ListConversationsResponse> callable,
                ListConversationsRequest request,
                ApiCallContext context,
                ApiFuture<ListConversationsResponse> futureResponse) {
              PageContext<ListConversationsRequest, ListConversationsResponse, Conversation>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CONVERSATIONS_PAGE_STR_DESC, request, context);
              return ListConversationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListGuardrailsRequest, ListGuardrailsResponse, ListGuardrailsPagedResponse>
      LIST_GUARDRAILS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGuardrailsRequest, ListGuardrailsResponse, ListGuardrailsPagedResponse>() {
            @Override
            public ApiFuture<ListGuardrailsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGuardrailsRequest, ListGuardrailsResponse> callable,
                ListGuardrailsRequest request,
                ApiCallContext context,
                ApiFuture<ListGuardrailsResponse> futureResponse) {
              PageContext<ListGuardrailsRequest, ListGuardrailsResponse, Guardrail> pageContext =
                  PageContext.create(callable, LIST_GUARDRAILS_PAGE_STR_DESC, request, context);
              return ListGuardrailsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
      LIST_DEPLOYMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>() {
            @Override
            public ApiFuture<ListDeploymentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse> callable,
                ListDeploymentsRequest request,
                ApiCallContext context,
                ApiFuture<ListDeploymentsResponse> futureResponse) {
              PageContext<ListDeploymentsRequest, ListDeploymentsResponse, Deployment> pageContext =
                  PageContext.create(callable, LIST_DEPLOYMENTS_PAGE_STR_DESC, request, context);
              return ListDeploymentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListToolsetsRequest, ListToolsetsResponse, ListToolsetsPagedResponse>
      LIST_TOOLSETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListToolsetsRequest, ListToolsetsResponse, ListToolsetsPagedResponse>() {
            @Override
            public ApiFuture<ListToolsetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListToolsetsRequest, ListToolsetsResponse> callable,
                ListToolsetsRequest request,
                ApiCallContext context,
                ApiFuture<ListToolsetsResponse> futureResponse) {
              PageContext<ListToolsetsRequest, ListToolsetsResponse, Toolset> pageContext =
                  PageContext.create(callable, LIST_TOOLSETS_PAGE_STR_DESC, request, context);
              return ListToolsetsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAppVersionsRequest, ListAppVersionsResponse, ListAppVersionsPagedResponse>
      LIST_APP_VERSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAppVersionsRequest, ListAppVersionsResponse, ListAppVersionsPagedResponse>() {
            @Override
            public ApiFuture<ListAppVersionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAppVersionsRequest, ListAppVersionsResponse> callable,
                ListAppVersionsRequest request,
                ApiCallContext context,
                ApiFuture<ListAppVersionsResponse> futureResponse) {
              PageContext<ListAppVersionsRequest, ListAppVersionsResponse, AppVersion> pageContext =
                  PageContext.create(callable, LIST_APP_VERSIONS_PAGE_STR_DESC, request, context);
              return ListAppVersionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListChangelogsRequest, ListChangelogsResponse, ListChangelogsPagedResponse>
      LIST_CHANGELOGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListChangelogsRequest, ListChangelogsResponse, ListChangelogsPagedResponse>() {
            @Override
            public ApiFuture<ListChangelogsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListChangelogsRequest, ListChangelogsResponse> callable,
                ListChangelogsRequest request,
                ApiCallContext context,
                ApiFuture<ListChangelogsResponse> futureResponse) {
              PageContext<ListChangelogsRequest, ListChangelogsResponse, Changelog> pageContext =
                  PageContext.create(callable, LIST_CHANGELOGS_PAGE_STR_DESC, request, context);
              return ListChangelogsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listApps. */
  public PagedCallSettings<ListAppsRequest, ListAppsResponse, ListAppsPagedResponse>
      listAppsSettings() {
    return listAppsSettings;
  }

  /** Returns the object with the settings used for calls to getApp. */
  public UnaryCallSettings<GetAppRequest, App> getAppSettings() {
    return getAppSettings;
  }

  /** Returns the object with the settings used for calls to createApp. */
  public UnaryCallSettings<CreateAppRequest, Operation> createAppSettings() {
    return createAppSettings;
  }

  /** Returns the object with the settings used for calls to createApp. */
  public OperationCallSettings<CreateAppRequest, App, OperationMetadata>
      createAppOperationSettings() {
    return createAppOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateApp. */
  public UnaryCallSettings<UpdateAppRequest, App> updateAppSettings() {
    return updateAppSettings;
  }

  /** Returns the object with the settings used for calls to deleteApp. */
  public UnaryCallSettings<DeleteAppRequest, Operation> deleteAppSettings() {
    return deleteAppSettings;
  }

  /** Returns the object with the settings used for calls to deleteApp. */
  public OperationCallSettings<DeleteAppRequest, Empty, OperationMetadata>
      deleteAppOperationSettings() {
    return deleteAppOperationSettings;
  }

  /** Returns the object with the settings used for calls to exportApp. */
  public UnaryCallSettings<ExportAppRequest, Operation> exportAppSettings() {
    return exportAppSettings;
  }

  /** Returns the object with the settings used for calls to exportApp. */
  public OperationCallSettings<ExportAppRequest, ExportAppResponse, OperationMetadata>
      exportAppOperationSettings() {
    return exportAppOperationSettings;
  }

  /** Returns the object with the settings used for calls to importApp. */
  public UnaryCallSettings<ImportAppRequest, Operation> importAppSettings() {
    return importAppSettings;
  }

  /** Returns the object with the settings used for calls to importApp. */
  public OperationCallSettings<ImportAppRequest, ImportAppResponse, OperationMetadata>
      importAppOperationSettings() {
    return importAppOperationSettings;
  }

  /** Returns the object with the settings used for calls to listAgents. */
  public PagedCallSettings<ListAgentsRequest, ListAgentsResponse, ListAgentsPagedResponse>
      listAgentsSettings() {
    return listAgentsSettings;
  }

  /** Returns the object with the settings used for calls to getAgent. */
  public UnaryCallSettings<GetAgentRequest, Agent> getAgentSettings() {
    return getAgentSettings;
  }

  /** Returns the object with the settings used for calls to createAgent. */
  public UnaryCallSettings<CreateAgentRequest, Agent> createAgentSettings() {
    return createAgentSettings;
  }

  /** Returns the object with the settings used for calls to updateAgent. */
  public UnaryCallSettings<UpdateAgentRequest, Agent> updateAgentSettings() {
    return updateAgentSettings;
  }

  /** Returns the object with the settings used for calls to deleteAgent. */
  public UnaryCallSettings<DeleteAgentRequest, Empty> deleteAgentSettings() {
    return deleteAgentSettings;
  }

  /** Returns the object with the settings used for calls to listExamples. */
  public PagedCallSettings<ListExamplesRequest, ListExamplesResponse, ListExamplesPagedResponse>
      listExamplesSettings() {
    return listExamplesSettings;
  }

  /** Returns the object with the settings used for calls to getExample. */
  public UnaryCallSettings<GetExampleRequest, Example> getExampleSettings() {
    return getExampleSettings;
  }

  /** Returns the object with the settings used for calls to createExample. */
  public UnaryCallSettings<CreateExampleRequest, Example> createExampleSettings() {
    return createExampleSettings;
  }

  /** Returns the object with the settings used for calls to updateExample. */
  public UnaryCallSettings<UpdateExampleRequest, Example> updateExampleSettings() {
    return updateExampleSettings;
  }

  /** Returns the object with the settings used for calls to deleteExample. */
  public UnaryCallSettings<DeleteExampleRequest, Empty> deleteExampleSettings() {
    return deleteExampleSettings;
  }

  /** Returns the object with the settings used for calls to listTools. */
  public PagedCallSettings<ListToolsRequest, ListToolsResponse, ListToolsPagedResponse>
      listToolsSettings() {
    return listToolsSettings;
  }

  /** Returns the object with the settings used for calls to getTool. */
  public UnaryCallSettings<GetToolRequest, Tool> getToolSettings() {
    return getToolSettings;
  }

  /** Returns the object with the settings used for calls to listConversations. */
  public PagedCallSettings<
          ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
      listConversationsSettings() {
    return listConversationsSettings;
  }

  /** Returns the object with the settings used for calls to getConversation. */
  public UnaryCallSettings<GetConversationRequest, Conversation> getConversationSettings() {
    return getConversationSettings;
  }

  /** Returns the object with the settings used for calls to deleteConversation. */
  public UnaryCallSettings<DeleteConversationRequest, Empty> deleteConversationSettings() {
    return deleteConversationSettings;
  }

  /** Returns the object with the settings used for calls to batchDeleteConversations. */
  public UnaryCallSettings<BatchDeleteConversationsRequest, Operation>
      batchDeleteConversationsSettings() {
    return batchDeleteConversationsSettings;
  }

  /** Returns the object with the settings used for calls to batchDeleteConversations. */
  public OperationCallSettings<
          BatchDeleteConversationsRequest, BatchDeleteConversationsResponse, OperationMetadata>
      batchDeleteConversationsOperationSettings() {
    return batchDeleteConversationsOperationSettings;
  }

  /** Returns the object with the settings used for calls to createTool. */
  public UnaryCallSettings<CreateToolRequest, Tool> createToolSettings() {
    return createToolSettings;
  }

  /** Returns the object with the settings used for calls to updateTool. */
  public UnaryCallSettings<UpdateToolRequest, Tool> updateToolSettings() {
    return updateToolSettings;
  }

  /** Returns the object with the settings used for calls to deleteTool. */
  public UnaryCallSettings<DeleteToolRequest, Empty> deleteToolSettings() {
    return deleteToolSettings;
  }

  /** Returns the object with the settings used for calls to listGuardrails. */
  public PagedCallSettings<
          ListGuardrailsRequest, ListGuardrailsResponse, ListGuardrailsPagedResponse>
      listGuardrailsSettings() {
    return listGuardrailsSettings;
  }

  /** Returns the object with the settings used for calls to getGuardrail. */
  public UnaryCallSettings<GetGuardrailRequest, Guardrail> getGuardrailSettings() {
    return getGuardrailSettings;
  }

  /** Returns the object with the settings used for calls to createGuardrail. */
  public UnaryCallSettings<CreateGuardrailRequest, Guardrail> createGuardrailSettings() {
    return createGuardrailSettings;
  }

  /** Returns the object with the settings used for calls to updateGuardrail. */
  public UnaryCallSettings<UpdateGuardrailRequest, Guardrail> updateGuardrailSettings() {
    return updateGuardrailSettings;
  }

  /** Returns the object with the settings used for calls to deleteGuardrail. */
  public UnaryCallSettings<DeleteGuardrailRequest, Empty> deleteGuardrailSettings() {
    return deleteGuardrailSettings;
  }

  /** Returns the object with the settings used for calls to listDeployments. */
  public PagedCallSettings<
          ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
      listDeploymentsSettings() {
    return listDeploymentsSettings;
  }

  /** Returns the object with the settings used for calls to getDeployment. */
  public UnaryCallSettings<GetDeploymentRequest, Deployment> getDeploymentSettings() {
    return getDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to createDeployment. */
  public UnaryCallSettings<CreateDeploymentRequest, Deployment> createDeploymentSettings() {
    return createDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to updateDeployment. */
  public UnaryCallSettings<UpdateDeploymentRequest, Deployment> updateDeploymentSettings() {
    return updateDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to deleteDeployment. */
  public UnaryCallSettings<DeleteDeploymentRequest, Empty> deleteDeploymentSettings() {
    return deleteDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to listToolsets. */
  public PagedCallSettings<ListToolsetsRequest, ListToolsetsResponse, ListToolsetsPagedResponse>
      listToolsetsSettings() {
    return listToolsetsSettings;
  }

  /** Returns the object with the settings used for calls to getToolset. */
  public UnaryCallSettings<GetToolsetRequest, Toolset> getToolsetSettings() {
    return getToolsetSettings;
  }

  /** Returns the object with the settings used for calls to createToolset. */
  public UnaryCallSettings<CreateToolsetRequest, Toolset> createToolsetSettings() {
    return createToolsetSettings;
  }

  /** Returns the object with the settings used for calls to updateToolset. */
  public UnaryCallSettings<UpdateToolsetRequest, Toolset> updateToolsetSettings() {
    return updateToolsetSettings;
  }

  /** Returns the object with the settings used for calls to deleteToolset. */
  public UnaryCallSettings<DeleteToolsetRequest, Empty> deleteToolsetSettings() {
    return deleteToolsetSettings;
  }

  /** Returns the object with the settings used for calls to listAppVersions. */
  public PagedCallSettings<
          ListAppVersionsRequest, ListAppVersionsResponse, ListAppVersionsPagedResponse>
      listAppVersionsSettings() {
    return listAppVersionsSettings;
  }

  /** Returns the object with the settings used for calls to getAppVersion. */
  public UnaryCallSettings<GetAppVersionRequest, AppVersion> getAppVersionSettings() {
    return getAppVersionSettings;
  }

  /** Returns the object with the settings used for calls to createAppVersion. */
  public UnaryCallSettings<CreateAppVersionRequest, AppVersion> createAppVersionSettings() {
    return createAppVersionSettings;
  }

  /** Returns the object with the settings used for calls to deleteAppVersion. */
  public UnaryCallSettings<DeleteAppVersionRequest, Empty> deleteAppVersionSettings() {
    return deleteAppVersionSettings;
  }

  /** Returns the object with the settings used for calls to restoreAppVersion. */
  public UnaryCallSettings<RestoreAppVersionRequest, Operation> restoreAppVersionSettings() {
    return restoreAppVersionSettings;
  }

  /** Returns the object with the settings used for calls to restoreAppVersion. */
  public OperationCallSettings<
          RestoreAppVersionRequest, RestoreAppVersionResponse, OperationMetadata>
      restoreAppVersionOperationSettings() {
    return restoreAppVersionOperationSettings;
  }

  /** Returns the object with the settings used for calls to listChangelogs. */
  public PagedCallSettings<
          ListChangelogsRequest, ListChangelogsResponse, ListChangelogsPagedResponse>
      listChangelogsSettings() {
    return listChangelogsSettings;
  }

  /** Returns the object with the settings used for calls to getChangelog. */
  public UnaryCallSettings<GetChangelogRequest, Changelog> getChangelogSettings() {
    return getChangelogSettings;
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

  public AgentServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAgentServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAgentServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "ces";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "ces.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "ces.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(AgentServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AgentServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AgentServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected AgentServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listAppsSettings = settingsBuilder.listAppsSettings().build();
    getAppSettings = settingsBuilder.getAppSettings().build();
    createAppSettings = settingsBuilder.createAppSettings().build();
    createAppOperationSettings = settingsBuilder.createAppOperationSettings().build();
    updateAppSettings = settingsBuilder.updateAppSettings().build();
    deleteAppSettings = settingsBuilder.deleteAppSettings().build();
    deleteAppOperationSettings = settingsBuilder.deleteAppOperationSettings().build();
    exportAppSettings = settingsBuilder.exportAppSettings().build();
    exportAppOperationSettings = settingsBuilder.exportAppOperationSettings().build();
    importAppSettings = settingsBuilder.importAppSettings().build();
    importAppOperationSettings = settingsBuilder.importAppOperationSettings().build();
    listAgentsSettings = settingsBuilder.listAgentsSettings().build();
    getAgentSettings = settingsBuilder.getAgentSettings().build();
    createAgentSettings = settingsBuilder.createAgentSettings().build();
    updateAgentSettings = settingsBuilder.updateAgentSettings().build();
    deleteAgentSettings = settingsBuilder.deleteAgentSettings().build();
    listExamplesSettings = settingsBuilder.listExamplesSettings().build();
    getExampleSettings = settingsBuilder.getExampleSettings().build();
    createExampleSettings = settingsBuilder.createExampleSettings().build();
    updateExampleSettings = settingsBuilder.updateExampleSettings().build();
    deleteExampleSettings = settingsBuilder.deleteExampleSettings().build();
    listToolsSettings = settingsBuilder.listToolsSettings().build();
    getToolSettings = settingsBuilder.getToolSettings().build();
    listConversationsSettings = settingsBuilder.listConversationsSettings().build();
    getConversationSettings = settingsBuilder.getConversationSettings().build();
    deleteConversationSettings = settingsBuilder.deleteConversationSettings().build();
    batchDeleteConversationsSettings = settingsBuilder.batchDeleteConversationsSettings().build();
    batchDeleteConversationsOperationSettings =
        settingsBuilder.batchDeleteConversationsOperationSettings().build();
    createToolSettings = settingsBuilder.createToolSettings().build();
    updateToolSettings = settingsBuilder.updateToolSettings().build();
    deleteToolSettings = settingsBuilder.deleteToolSettings().build();
    listGuardrailsSettings = settingsBuilder.listGuardrailsSettings().build();
    getGuardrailSettings = settingsBuilder.getGuardrailSettings().build();
    createGuardrailSettings = settingsBuilder.createGuardrailSettings().build();
    updateGuardrailSettings = settingsBuilder.updateGuardrailSettings().build();
    deleteGuardrailSettings = settingsBuilder.deleteGuardrailSettings().build();
    listDeploymentsSettings = settingsBuilder.listDeploymentsSettings().build();
    getDeploymentSettings = settingsBuilder.getDeploymentSettings().build();
    createDeploymentSettings = settingsBuilder.createDeploymentSettings().build();
    updateDeploymentSettings = settingsBuilder.updateDeploymentSettings().build();
    deleteDeploymentSettings = settingsBuilder.deleteDeploymentSettings().build();
    listToolsetsSettings = settingsBuilder.listToolsetsSettings().build();
    getToolsetSettings = settingsBuilder.getToolsetSettings().build();
    createToolsetSettings = settingsBuilder.createToolsetSettings().build();
    updateToolsetSettings = settingsBuilder.updateToolsetSettings().build();
    deleteToolsetSettings = settingsBuilder.deleteToolsetSettings().build();
    listAppVersionsSettings = settingsBuilder.listAppVersionsSettings().build();
    getAppVersionSettings = settingsBuilder.getAppVersionSettings().build();
    createAppVersionSettings = settingsBuilder.createAppVersionSettings().build();
    deleteAppVersionSettings = settingsBuilder.deleteAppVersionSettings().build();
    restoreAppVersionSettings = settingsBuilder.restoreAppVersionSettings().build();
    restoreAppVersionOperationSettings =
        settingsBuilder.restoreAppVersionOperationSettings().build();
    listChangelogsSettings = settingsBuilder.listChangelogsSettings().build();
    getChangelogSettings = settingsBuilder.getChangelogSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for AgentServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<AgentServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListAppsRequest, ListAppsResponse, ListAppsPagedResponse>
        listAppsSettings;
    private final UnaryCallSettings.Builder<GetAppRequest, App> getAppSettings;
    private final UnaryCallSettings.Builder<CreateAppRequest, Operation> createAppSettings;
    private final OperationCallSettings.Builder<CreateAppRequest, App, OperationMetadata>
        createAppOperationSettings;
    private final UnaryCallSettings.Builder<UpdateAppRequest, App> updateAppSettings;
    private final UnaryCallSettings.Builder<DeleteAppRequest, Operation> deleteAppSettings;
    private final OperationCallSettings.Builder<DeleteAppRequest, Empty, OperationMetadata>
        deleteAppOperationSettings;
    private final UnaryCallSettings.Builder<ExportAppRequest, Operation> exportAppSettings;
    private final OperationCallSettings.Builder<
            ExportAppRequest, ExportAppResponse, OperationMetadata>
        exportAppOperationSettings;
    private final UnaryCallSettings.Builder<ImportAppRequest, Operation> importAppSettings;
    private final OperationCallSettings.Builder<
            ImportAppRequest, ImportAppResponse, OperationMetadata>
        importAppOperationSettings;
    private final PagedCallSettings.Builder<
            ListAgentsRequest, ListAgentsResponse, ListAgentsPagedResponse>
        listAgentsSettings;
    private final UnaryCallSettings.Builder<GetAgentRequest, Agent> getAgentSettings;
    private final UnaryCallSettings.Builder<CreateAgentRequest, Agent> createAgentSettings;
    private final UnaryCallSettings.Builder<UpdateAgentRequest, Agent> updateAgentSettings;
    private final UnaryCallSettings.Builder<DeleteAgentRequest, Empty> deleteAgentSettings;
    private final PagedCallSettings.Builder<
            ListExamplesRequest, ListExamplesResponse, ListExamplesPagedResponse>
        listExamplesSettings;
    private final UnaryCallSettings.Builder<GetExampleRequest, Example> getExampleSettings;
    private final UnaryCallSettings.Builder<CreateExampleRequest, Example> createExampleSettings;
    private final UnaryCallSettings.Builder<UpdateExampleRequest, Example> updateExampleSettings;
    private final UnaryCallSettings.Builder<DeleteExampleRequest, Empty> deleteExampleSettings;
    private final PagedCallSettings.Builder<
            ListToolsRequest, ListToolsResponse, ListToolsPagedResponse>
        listToolsSettings;
    private final UnaryCallSettings.Builder<GetToolRequest, Tool> getToolSettings;
    private final PagedCallSettings.Builder<
            ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
        listConversationsSettings;
    private final UnaryCallSettings.Builder<GetConversationRequest, Conversation>
        getConversationSettings;
    private final UnaryCallSettings.Builder<DeleteConversationRequest, Empty>
        deleteConversationSettings;
    private final UnaryCallSettings.Builder<BatchDeleteConversationsRequest, Operation>
        batchDeleteConversationsSettings;
    private final OperationCallSettings.Builder<
            BatchDeleteConversationsRequest, BatchDeleteConversationsResponse, OperationMetadata>
        batchDeleteConversationsOperationSettings;
    private final UnaryCallSettings.Builder<CreateToolRequest, Tool> createToolSettings;
    private final UnaryCallSettings.Builder<UpdateToolRequest, Tool> updateToolSettings;
    private final UnaryCallSettings.Builder<DeleteToolRequest, Empty> deleteToolSettings;
    private final PagedCallSettings.Builder<
            ListGuardrailsRequest, ListGuardrailsResponse, ListGuardrailsPagedResponse>
        listGuardrailsSettings;
    private final UnaryCallSettings.Builder<GetGuardrailRequest, Guardrail> getGuardrailSettings;
    private final UnaryCallSettings.Builder<CreateGuardrailRequest, Guardrail>
        createGuardrailSettings;
    private final UnaryCallSettings.Builder<UpdateGuardrailRequest, Guardrail>
        updateGuardrailSettings;
    private final UnaryCallSettings.Builder<DeleteGuardrailRequest, Empty> deleteGuardrailSettings;
    private final PagedCallSettings.Builder<
            ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
        listDeploymentsSettings;
    private final UnaryCallSettings.Builder<GetDeploymentRequest, Deployment> getDeploymentSettings;
    private final UnaryCallSettings.Builder<CreateDeploymentRequest, Deployment>
        createDeploymentSettings;
    private final UnaryCallSettings.Builder<UpdateDeploymentRequest, Deployment>
        updateDeploymentSettings;
    private final UnaryCallSettings.Builder<DeleteDeploymentRequest, Empty>
        deleteDeploymentSettings;
    private final PagedCallSettings.Builder<
            ListToolsetsRequest, ListToolsetsResponse, ListToolsetsPagedResponse>
        listToolsetsSettings;
    private final UnaryCallSettings.Builder<GetToolsetRequest, Toolset> getToolsetSettings;
    private final UnaryCallSettings.Builder<CreateToolsetRequest, Toolset> createToolsetSettings;
    private final UnaryCallSettings.Builder<UpdateToolsetRequest, Toolset> updateToolsetSettings;
    private final UnaryCallSettings.Builder<DeleteToolsetRequest, Empty> deleteToolsetSettings;
    private final PagedCallSettings.Builder<
            ListAppVersionsRequest, ListAppVersionsResponse, ListAppVersionsPagedResponse>
        listAppVersionsSettings;
    private final UnaryCallSettings.Builder<GetAppVersionRequest, AppVersion> getAppVersionSettings;
    private final UnaryCallSettings.Builder<CreateAppVersionRequest, AppVersion>
        createAppVersionSettings;
    private final UnaryCallSettings.Builder<DeleteAppVersionRequest, Empty>
        deleteAppVersionSettings;
    private final UnaryCallSettings.Builder<RestoreAppVersionRequest, Operation>
        restoreAppVersionSettings;
    private final OperationCallSettings.Builder<
            RestoreAppVersionRequest, RestoreAppVersionResponse, OperationMetadata>
        restoreAppVersionOperationSettings;
    private final PagedCallSettings.Builder<
            ListChangelogsRequest, ListChangelogsResponse, ListChangelogsPagedResponse>
        listChangelogsSettings;
    private final UnaryCallSettings.Builder<GetChangelogRequest, Changelog> getChangelogSettings;
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
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listAppsSettings = PagedCallSettings.newBuilder(LIST_APPS_PAGE_STR_FACT);
      getAppSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAppSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAppOperationSettings = OperationCallSettings.newBuilder();
      updateAppSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAppSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAppOperationSettings = OperationCallSettings.newBuilder();
      exportAppSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportAppOperationSettings = OperationCallSettings.newBuilder();
      importAppSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importAppOperationSettings = OperationCallSettings.newBuilder();
      listAgentsSettings = PagedCallSettings.newBuilder(LIST_AGENTS_PAGE_STR_FACT);
      getAgentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAgentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAgentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAgentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listExamplesSettings = PagedCallSettings.newBuilder(LIST_EXAMPLES_PAGE_STR_FACT);
      getExampleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createExampleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateExampleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteExampleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listToolsSettings = PagedCallSettings.newBuilder(LIST_TOOLS_PAGE_STR_FACT);
      getToolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listConversationsSettings = PagedCallSettings.newBuilder(LIST_CONVERSATIONS_PAGE_STR_FACT);
      getConversationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteConversationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeleteConversationsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeleteConversationsOperationSettings = OperationCallSettings.newBuilder();
      createToolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateToolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteToolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listGuardrailsSettings = PagedCallSettings.newBuilder(LIST_GUARDRAILS_PAGE_STR_FACT);
      getGuardrailSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGuardrailSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateGuardrailSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteGuardrailSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDeploymentsSettings = PagedCallSettings.newBuilder(LIST_DEPLOYMENTS_PAGE_STR_FACT);
      getDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listToolsetsSettings = PagedCallSettings.newBuilder(LIST_TOOLSETS_PAGE_STR_FACT);
      getToolsetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createToolsetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateToolsetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteToolsetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAppVersionsSettings = PagedCallSettings.newBuilder(LIST_APP_VERSIONS_PAGE_STR_FACT);
      getAppVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAppVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAppVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      restoreAppVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      restoreAppVersionOperationSettings = OperationCallSettings.newBuilder();
      listChangelogsSettings = PagedCallSettings.newBuilder(LIST_CHANGELOGS_PAGE_STR_FACT);
      getChangelogSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAppsSettings,
              getAppSettings,
              createAppSettings,
              updateAppSettings,
              deleteAppSettings,
              exportAppSettings,
              importAppSettings,
              listAgentsSettings,
              getAgentSettings,
              createAgentSettings,
              updateAgentSettings,
              deleteAgentSettings,
              listExamplesSettings,
              getExampleSettings,
              createExampleSettings,
              updateExampleSettings,
              deleteExampleSettings,
              listToolsSettings,
              getToolSettings,
              listConversationsSettings,
              getConversationSettings,
              deleteConversationSettings,
              batchDeleteConversationsSettings,
              createToolSettings,
              updateToolSettings,
              deleteToolSettings,
              listGuardrailsSettings,
              getGuardrailSettings,
              createGuardrailSettings,
              updateGuardrailSettings,
              deleteGuardrailSettings,
              listDeploymentsSettings,
              getDeploymentSettings,
              createDeploymentSettings,
              updateDeploymentSettings,
              deleteDeploymentSettings,
              listToolsetsSettings,
              getToolsetSettings,
              createToolsetSettings,
              updateToolsetSettings,
              deleteToolsetSettings,
              listAppVersionsSettings,
              getAppVersionSettings,
              createAppVersionSettings,
              deleteAppVersionSettings,
              restoreAppVersionSettings,
              listChangelogsSettings,
              getChangelogSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(AgentServiceStubSettings settings) {
      super(settings);

      listAppsSettings = settings.listAppsSettings.toBuilder();
      getAppSettings = settings.getAppSettings.toBuilder();
      createAppSettings = settings.createAppSettings.toBuilder();
      createAppOperationSettings = settings.createAppOperationSettings.toBuilder();
      updateAppSettings = settings.updateAppSettings.toBuilder();
      deleteAppSettings = settings.deleteAppSettings.toBuilder();
      deleteAppOperationSettings = settings.deleteAppOperationSettings.toBuilder();
      exportAppSettings = settings.exportAppSettings.toBuilder();
      exportAppOperationSettings = settings.exportAppOperationSettings.toBuilder();
      importAppSettings = settings.importAppSettings.toBuilder();
      importAppOperationSettings = settings.importAppOperationSettings.toBuilder();
      listAgentsSettings = settings.listAgentsSettings.toBuilder();
      getAgentSettings = settings.getAgentSettings.toBuilder();
      createAgentSettings = settings.createAgentSettings.toBuilder();
      updateAgentSettings = settings.updateAgentSettings.toBuilder();
      deleteAgentSettings = settings.deleteAgentSettings.toBuilder();
      listExamplesSettings = settings.listExamplesSettings.toBuilder();
      getExampleSettings = settings.getExampleSettings.toBuilder();
      createExampleSettings = settings.createExampleSettings.toBuilder();
      updateExampleSettings = settings.updateExampleSettings.toBuilder();
      deleteExampleSettings = settings.deleteExampleSettings.toBuilder();
      listToolsSettings = settings.listToolsSettings.toBuilder();
      getToolSettings = settings.getToolSettings.toBuilder();
      listConversationsSettings = settings.listConversationsSettings.toBuilder();
      getConversationSettings = settings.getConversationSettings.toBuilder();
      deleteConversationSettings = settings.deleteConversationSettings.toBuilder();
      batchDeleteConversationsSettings = settings.batchDeleteConversationsSettings.toBuilder();
      batchDeleteConversationsOperationSettings =
          settings.batchDeleteConversationsOperationSettings.toBuilder();
      createToolSettings = settings.createToolSettings.toBuilder();
      updateToolSettings = settings.updateToolSettings.toBuilder();
      deleteToolSettings = settings.deleteToolSettings.toBuilder();
      listGuardrailsSettings = settings.listGuardrailsSettings.toBuilder();
      getGuardrailSettings = settings.getGuardrailSettings.toBuilder();
      createGuardrailSettings = settings.createGuardrailSettings.toBuilder();
      updateGuardrailSettings = settings.updateGuardrailSettings.toBuilder();
      deleteGuardrailSettings = settings.deleteGuardrailSettings.toBuilder();
      listDeploymentsSettings = settings.listDeploymentsSettings.toBuilder();
      getDeploymentSettings = settings.getDeploymentSettings.toBuilder();
      createDeploymentSettings = settings.createDeploymentSettings.toBuilder();
      updateDeploymentSettings = settings.updateDeploymentSettings.toBuilder();
      deleteDeploymentSettings = settings.deleteDeploymentSettings.toBuilder();
      listToolsetsSettings = settings.listToolsetsSettings.toBuilder();
      getToolsetSettings = settings.getToolsetSettings.toBuilder();
      createToolsetSettings = settings.createToolsetSettings.toBuilder();
      updateToolsetSettings = settings.updateToolsetSettings.toBuilder();
      deleteToolsetSettings = settings.deleteToolsetSettings.toBuilder();
      listAppVersionsSettings = settings.listAppVersionsSettings.toBuilder();
      getAppVersionSettings = settings.getAppVersionSettings.toBuilder();
      createAppVersionSettings = settings.createAppVersionSettings.toBuilder();
      deleteAppVersionSettings = settings.deleteAppVersionSettings.toBuilder();
      restoreAppVersionSettings = settings.restoreAppVersionSettings.toBuilder();
      restoreAppVersionOperationSettings = settings.restoreAppVersionOperationSettings.toBuilder();
      listChangelogsSettings = settings.listChangelogsSettings.toBuilder();
      getChangelogSettings = settings.getChangelogSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAppsSettings,
              getAppSettings,
              createAppSettings,
              updateAppSettings,
              deleteAppSettings,
              exportAppSettings,
              importAppSettings,
              listAgentsSettings,
              getAgentSettings,
              createAgentSettings,
              updateAgentSettings,
              deleteAgentSettings,
              listExamplesSettings,
              getExampleSettings,
              createExampleSettings,
              updateExampleSettings,
              deleteExampleSettings,
              listToolsSettings,
              getToolSettings,
              listConversationsSettings,
              getConversationSettings,
              deleteConversationSettings,
              batchDeleteConversationsSettings,
              createToolSettings,
              updateToolSettings,
              deleteToolSettings,
              listGuardrailsSettings,
              getGuardrailSettings,
              createGuardrailSettings,
              updateGuardrailSettings,
              deleteGuardrailSettings,
              listDeploymentsSettings,
              getDeploymentSettings,
              createDeploymentSettings,
              updateDeploymentSettings,
              deleteDeploymentSettings,
              listToolsetsSettings,
              getToolsetSettings,
              createToolsetSettings,
              updateToolsetSettings,
              deleteToolsetSettings,
              listAppVersionsSettings,
              getAppVersionSettings,
              createAppVersionSettings,
              deleteAppVersionSettings,
              restoreAppVersionSettings,
              listChangelogsSettings,
              getChangelogSettings,
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
          .listAppsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getAppSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAppSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateAppSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteAppSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .exportAppSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .importAppSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAgentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getAgentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAgentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateAgentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteAgentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listExamplesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getExampleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createExampleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateExampleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteExampleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listToolsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getToolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listConversationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getConversationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteConversationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchDeleteConversationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createToolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateToolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteToolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listGuardrailsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getGuardrailSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createGuardrailSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateGuardrailSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteGuardrailSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDeploymentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listToolsetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getToolsetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createToolsetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateToolsetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteToolsetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAppVersionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getAppVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAppVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteAppVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .restoreAppVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listChangelogsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getChangelogSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAppOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateAppRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(App.class))
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
          .deleteAppOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteAppRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .exportAppOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<ExportAppRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ExportAppResponse.class))
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
          .importAppOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<ImportAppRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ImportAppResponse.class))
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
          .batchDeleteConversationsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchDeleteConversationsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BatchDeleteConversationsResponse.class))
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
          .restoreAppVersionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RestoreAppVersionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  RestoreAppVersionResponse.class))
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

    /** Returns the builder for the settings used for calls to listApps. */
    public PagedCallSettings.Builder<ListAppsRequest, ListAppsResponse, ListAppsPagedResponse>
        listAppsSettings() {
      return listAppsSettings;
    }

    /** Returns the builder for the settings used for calls to getApp. */
    public UnaryCallSettings.Builder<GetAppRequest, App> getAppSettings() {
      return getAppSettings;
    }

    /** Returns the builder for the settings used for calls to createApp. */
    public UnaryCallSettings.Builder<CreateAppRequest, Operation> createAppSettings() {
      return createAppSettings;
    }

    /** Returns the builder for the settings used for calls to createApp. */
    public OperationCallSettings.Builder<CreateAppRequest, App, OperationMetadata>
        createAppOperationSettings() {
      return createAppOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateApp. */
    public UnaryCallSettings.Builder<UpdateAppRequest, App> updateAppSettings() {
      return updateAppSettings;
    }

    /** Returns the builder for the settings used for calls to deleteApp. */
    public UnaryCallSettings.Builder<DeleteAppRequest, Operation> deleteAppSettings() {
      return deleteAppSettings;
    }

    /** Returns the builder for the settings used for calls to deleteApp. */
    public OperationCallSettings.Builder<DeleteAppRequest, Empty, OperationMetadata>
        deleteAppOperationSettings() {
      return deleteAppOperationSettings;
    }

    /** Returns the builder for the settings used for calls to exportApp. */
    public UnaryCallSettings.Builder<ExportAppRequest, Operation> exportAppSettings() {
      return exportAppSettings;
    }

    /** Returns the builder for the settings used for calls to exportApp. */
    public OperationCallSettings.Builder<ExportAppRequest, ExportAppResponse, OperationMetadata>
        exportAppOperationSettings() {
      return exportAppOperationSettings;
    }

    /** Returns the builder for the settings used for calls to importApp. */
    public UnaryCallSettings.Builder<ImportAppRequest, Operation> importAppSettings() {
      return importAppSettings;
    }

    /** Returns the builder for the settings used for calls to importApp. */
    public OperationCallSettings.Builder<ImportAppRequest, ImportAppResponse, OperationMetadata>
        importAppOperationSettings() {
      return importAppOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listAgents. */
    public PagedCallSettings.Builder<ListAgentsRequest, ListAgentsResponse, ListAgentsPagedResponse>
        listAgentsSettings() {
      return listAgentsSettings;
    }

    /** Returns the builder for the settings used for calls to getAgent. */
    public UnaryCallSettings.Builder<GetAgentRequest, Agent> getAgentSettings() {
      return getAgentSettings;
    }

    /** Returns the builder for the settings used for calls to createAgent. */
    public UnaryCallSettings.Builder<CreateAgentRequest, Agent> createAgentSettings() {
      return createAgentSettings;
    }

    /** Returns the builder for the settings used for calls to updateAgent. */
    public UnaryCallSettings.Builder<UpdateAgentRequest, Agent> updateAgentSettings() {
      return updateAgentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAgent. */
    public UnaryCallSettings.Builder<DeleteAgentRequest, Empty> deleteAgentSettings() {
      return deleteAgentSettings;
    }

    /** Returns the builder for the settings used for calls to listExamples. */
    public PagedCallSettings.Builder<
            ListExamplesRequest, ListExamplesResponse, ListExamplesPagedResponse>
        listExamplesSettings() {
      return listExamplesSettings;
    }

    /** Returns the builder for the settings used for calls to getExample. */
    public UnaryCallSettings.Builder<GetExampleRequest, Example> getExampleSettings() {
      return getExampleSettings;
    }

    /** Returns the builder for the settings used for calls to createExample. */
    public UnaryCallSettings.Builder<CreateExampleRequest, Example> createExampleSettings() {
      return createExampleSettings;
    }

    /** Returns the builder for the settings used for calls to updateExample. */
    public UnaryCallSettings.Builder<UpdateExampleRequest, Example> updateExampleSettings() {
      return updateExampleSettings;
    }

    /** Returns the builder for the settings used for calls to deleteExample. */
    public UnaryCallSettings.Builder<DeleteExampleRequest, Empty> deleteExampleSettings() {
      return deleteExampleSettings;
    }

    /** Returns the builder for the settings used for calls to listTools. */
    public PagedCallSettings.Builder<ListToolsRequest, ListToolsResponse, ListToolsPagedResponse>
        listToolsSettings() {
      return listToolsSettings;
    }

    /** Returns the builder for the settings used for calls to getTool. */
    public UnaryCallSettings.Builder<GetToolRequest, Tool> getToolSettings() {
      return getToolSettings;
    }

    /** Returns the builder for the settings used for calls to listConversations. */
    public PagedCallSettings.Builder<
            ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
        listConversationsSettings() {
      return listConversationsSettings;
    }

    /** Returns the builder for the settings used for calls to getConversation. */
    public UnaryCallSettings.Builder<GetConversationRequest, Conversation>
        getConversationSettings() {
      return getConversationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConversation. */
    public UnaryCallSettings.Builder<DeleteConversationRequest, Empty>
        deleteConversationSettings() {
      return deleteConversationSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeleteConversations. */
    public UnaryCallSettings.Builder<BatchDeleteConversationsRequest, Operation>
        batchDeleteConversationsSettings() {
      return batchDeleteConversationsSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeleteConversations. */
    public OperationCallSettings.Builder<
            BatchDeleteConversationsRequest, BatchDeleteConversationsResponse, OperationMetadata>
        batchDeleteConversationsOperationSettings() {
      return batchDeleteConversationsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createTool. */
    public UnaryCallSettings.Builder<CreateToolRequest, Tool> createToolSettings() {
      return createToolSettings;
    }

    /** Returns the builder for the settings used for calls to updateTool. */
    public UnaryCallSettings.Builder<UpdateToolRequest, Tool> updateToolSettings() {
      return updateToolSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTool. */
    public UnaryCallSettings.Builder<DeleteToolRequest, Empty> deleteToolSettings() {
      return deleteToolSettings;
    }

    /** Returns the builder for the settings used for calls to listGuardrails. */
    public PagedCallSettings.Builder<
            ListGuardrailsRequest, ListGuardrailsResponse, ListGuardrailsPagedResponse>
        listGuardrailsSettings() {
      return listGuardrailsSettings;
    }

    /** Returns the builder for the settings used for calls to getGuardrail. */
    public UnaryCallSettings.Builder<GetGuardrailRequest, Guardrail> getGuardrailSettings() {
      return getGuardrailSettings;
    }

    /** Returns the builder for the settings used for calls to createGuardrail. */
    public UnaryCallSettings.Builder<CreateGuardrailRequest, Guardrail> createGuardrailSettings() {
      return createGuardrailSettings;
    }

    /** Returns the builder for the settings used for calls to updateGuardrail. */
    public UnaryCallSettings.Builder<UpdateGuardrailRequest, Guardrail> updateGuardrailSettings() {
      return updateGuardrailSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGuardrail. */
    public UnaryCallSettings.Builder<DeleteGuardrailRequest, Empty> deleteGuardrailSettings() {
      return deleteGuardrailSettings;
    }

    /** Returns the builder for the settings used for calls to listDeployments. */
    public PagedCallSettings.Builder<
            ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
        listDeploymentsSettings() {
      return listDeploymentsSettings;
    }

    /** Returns the builder for the settings used for calls to getDeployment. */
    public UnaryCallSettings.Builder<GetDeploymentRequest, Deployment> getDeploymentSettings() {
      return getDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to createDeployment. */
    public UnaryCallSettings.Builder<CreateDeploymentRequest, Deployment>
        createDeploymentSettings() {
      return createDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to updateDeployment. */
    public UnaryCallSettings.Builder<UpdateDeploymentRequest, Deployment>
        updateDeploymentSettings() {
      return updateDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDeployment. */
    public UnaryCallSettings.Builder<DeleteDeploymentRequest, Empty> deleteDeploymentSettings() {
      return deleteDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to listToolsets. */
    public PagedCallSettings.Builder<
            ListToolsetsRequest, ListToolsetsResponse, ListToolsetsPagedResponse>
        listToolsetsSettings() {
      return listToolsetsSettings;
    }

    /** Returns the builder for the settings used for calls to getToolset. */
    public UnaryCallSettings.Builder<GetToolsetRequest, Toolset> getToolsetSettings() {
      return getToolsetSettings;
    }

    /** Returns the builder for the settings used for calls to createToolset. */
    public UnaryCallSettings.Builder<CreateToolsetRequest, Toolset> createToolsetSettings() {
      return createToolsetSettings;
    }

    /** Returns the builder for the settings used for calls to updateToolset. */
    public UnaryCallSettings.Builder<UpdateToolsetRequest, Toolset> updateToolsetSettings() {
      return updateToolsetSettings;
    }

    /** Returns the builder for the settings used for calls to deleteToolset. */
    public UnaryCallSettings.Builder<DeleteToolsetRequest, Empty> deleteToolsetSettings() {
      return deleteToolsetSettings;
    }

    /** Returns the builder for the settings used for calls to listAppVersions. */
    public PagedCallSettings.Builder<
            ListAppVersionsRequest, ListAppVersionsResponse, ListAppVersionsPagedResponse>
        listAppVersionsSettings() {
      return listAppVersionsSettings;
    }

    /** Returns the builder for the settings used for calls to getAppVersion. */
    public UnaryCallSettings.Builder<GetAppVersionRequest, AppVersion> getAppVersionSettings() {
      return getAppVersionSettings;
    }

    /** Returns the builder for the settings used for calls to createAppVersion. */
    public UnaryCallSettings.Builder<CreateAppVersionRequest, AppVersion>
        createAppVersionSettings() {
      return createAppVersionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAppVersion. */
    public UnaryCallSettings.Builder<DeleteAppVersionRequest, Empty> deleteAppVersionSettings() {
      return deleteAppVersionSettings;
    }

    /** Returns the builder for the settings used for calls to restoreAppVersion. */
    public UnaryCallSettings.Builder<RestoreAppVersionRequest, Operation>
        restoreAppVersionSettings() {
      return restoreAppVersionSettings;
    }

    /** Returns the builder for the settings used for calls to restoreAppVersion. */
    public OperationCallSettings.Builder<
            RestoreAppVersionRequest, RestoreAppVersionResponse, OperationMetadata>
        restoreAppVersionOperationSettings() {
      return restoreAppVersionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listChangelogs. */
    public PagedCallSettings.Builder<
            ListChangelogsRequest, ListChangelogsResponse, ListChangelogsPagedResponse>
        listChangelogsSettings() {
      return listChangelogsSettings;
    }

    /** Returns the builder for the settings used for calls to getChangelog. */
    public UnaryCallSettings.Builder<GetChangelogRequest, Changelog> getChangelogSettings() {
      return getChangelogSettings;
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
    public AgentServiceStubSettings build() throws IOException {
      return new AgentServiceStubSettings(this);
    }
  }
}
