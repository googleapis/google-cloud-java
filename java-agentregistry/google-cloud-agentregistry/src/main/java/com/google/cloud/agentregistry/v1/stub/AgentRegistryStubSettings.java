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

package com.google.cloud.agentregistry.v1.stub;

import static com.google.cloud.agentregistry.v1.AgentRegistryClient.FetchAvailableBindingsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListAgentsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListBindingsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListEndpointsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListLocationsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListMcpServersPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListServicesPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.SearchAgentsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.SearchMcpServersPagedResponse;

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
import com.google.cloud.agentregistry.v1.Agent;
import com.google.cloud.agentregistry.v1.Binding;
import com.google.cloud.agentregistry.v1.CreateBindingRequest;
import com.google.cloud.agentregistry.v1.CreateServiceRequest;
import com.google.cloud.agentregistry.v1.DeleteBindingRequest;
import com.google.cloud.agentregistry.v1.DeleteServiceRequest;
import com.google.cloud.agentregistry.v1.Endpoint;
import com.google.cloud.agentregistry.v1.FetchAvailableBindingsRequest;
import com.google.cloud.agentregistry.v1.FetchAvailableBindingsResponse;
import com.google.cloud.agentregistry.v1.GetAgentRequest;
import com.google.cloud.agentregistry.v1.GetBindingRequest;
import com.google.cloud.agentregistry.v1.GetEndpointRequest;
import com.google.cloud.agentregistry.v1.GetMcpServerRequest;
import com.google.cloud.agentregistry.v1.GetServiceRequest;
import com.google.cloud.agentregistry.v1.ListAgentsRequest;
import com.google.cloud.agentregistry.v1.ListAgentsResponse;
import com.google.cloud.agentregistry.v1.ListBindingsRequest;
import com.google.cloud.agentregistry.v1.ListBindingsResponse;
import com.google.cloud.agentregistry.v1.ListEndpointsRequest;
import com.google.cloud.agentregistry.v1.ListEndpointsResponse;
import com.google.cloud.agentregistry.v1.ListMcpServersRequest;
import com.google.cloud.agentregistry.v1.ListMcpServersResponse;
import com.google.cloud.agentregistry.v1.ListServicesRequest;
import com.google.cloud.agentregistry.v1.ListServicesResponse;
import com.google.cloud.agentregistry.v1.McpServer;
import com.google.cloud.agentregistry.v1.OperationMetadata;
import com.google.cloud.agentregistry.v1.SearchAgentsRequest;
import com.google.cloud.agentregistry.v1.SearchAgentsResponse;
import com.google.cloud.agentregistry.v1.SearchMcpServersRequest;
import com.google.cloud.agentregistry.v1.SearchMcpServersResponse;
import com.google.cloud.agentregistry.v1.Service;
import com.google.cloud.agentregistry.v1.UpdateBindingRequest;
import com.google.cloud.agentregistry.v1.UpdateServiceRequest;
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
 * Settings class to configure an instance of {@link AgentRegistryStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (agentregistry.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getAgent:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AgentRegistryStubSettings.Builder agentRegistrySettingsBuilder =
 *     AgentRegistryStubSettings.newBuilder();
 * agentRegistrySettingsBuilder
 *     .getAgentSettings()
 *     .setRetrySettings(
 *         agentRegistrySettingsBuilder
 *             .getAgentSettings()
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
 * AgentRegistryStubSettings agentRegistrySettings = agentRegistrySettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createService:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AgentRegistryStubSettings.Builder agentRegistrySettingsBuilder =
 *     AgentRegistryStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * agentRegistrySettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class AgentRegistryStubSettings extends StubSettings<AgentRegistryStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/agentregistry.read-only")
          .add("https://www.googleapis.com/auth/agentregistry.read-write")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .build();

  private final PagedCallSettings<ListAgentsRequest, ListAgentsResponse, ListAgentsPagedResponse>
      listAgentsSettings;
  private final PagedCallSettings<
          SearchAgentsRequest, SearchAgentsResponse, SearchAgentsPagedResponse>
      searchAgentsSettings;
  private final UnaryCallSettings<GetAgentRequest, Agent> getAgentSettings;
  private final PagedCallSettings<
          ListEndpointsRequest, ListEndpointsResponse, ListEndpointsPagedResponse>
      listEndpointsSettings;
  private final UnaryCallSettings<GetEndpointRequest, Endpoint> getEndpointSettings;
  private final PagedCallSettings<
          ListMcpServersRequest, ListMcpServersResponse, ListMcpServersPagedResponse>
      listMcpServersSettings;
  private final PagedCallSettings<
          SearchMcpServersRequest, SearchMcpServersResponse, SearchMcpServersPagedResponse>
      searchMcpServersSettings;
  private final UnaryCallSettings<GetMcpServerRequest, McpServer> getMcpServerSettings;
  private final PagedCallSettings<
          ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      listServicesSettings;
  private final UnaryCallSettings<GetServiceRequest, Service> getServiceSettings;
  private final UnaryCallSettings<CreateServiceRequest, Operation> createServiceSettings;
  private final OperationCallSettings<CreateServiceRequest, Service, OperationMetadata>
      createServiceOperationSettings;
  private final UnaryCallSettings<UpdateServiceRequest, Operation> updateServiceSettings;
  private final OperationCallSettings<UpdateServiceRequest, Service, OperationMetadata>
      updateServiceOperationSettings;
  private final UnaryCallSettings<DeleteServiceRequest, Operation> deleteServiceSettings;
  private final OperationCallSettings<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationSettings;
  private final PagedCallSettings<
          ListBindingsRequest, ListBindingsResponse, ListBindingsPagedResponse>
      listBindingsSettings;
  private final UnaryCallSettings<GetBindingRequest, Binding> getBindingSettings;
  private final UnaryCallSettings<CreateBindingRequest, Operation> createBindingSettings;
  private final OperationCallSettings<CreateBindingRequest, Binding, OperationMetadata>
      createBindingOperationSettings;
  private final UnaryCallSettings<UpdateBindingRequest, Operation> updateBindingSettings;
  private final OperationCallSettings<UpdateBindingRequest, Binding, OperationMetadata>
      updateBindingOperationSettings;
  private final UnaryCallSettings<DeleteBindingRequest, Operation> deleteBindingSettings;
  private final OperationCallSettings<DeleteBindingRequest, Empty, OperationMetadata>
      deleteBindingOperationSettings;
  private final PagedCallSettings<
          FetchAvailableBindingsRequest,
          FetchAvailableBindingsResponse,
          FetchAvailableBindingsPagedResponse>
      fetchAvailableBindingsSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

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

  private static final PagedListDescriptor<SearchAgentsRequest, SearchAgentsResponse, Agent>
      SEARCH_AGENTS_PAGE_STR_DESC =
          new PagedListDescriptor<SearchAgentsRequest, SearchAgentsResponse, Agent>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchAgentsRequest injectToken(SearchAgentsRequest payload, String token) {
              return SearchAgentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchAgentsRequest injectPageSize(SearchAgentsRequest payload, int pageSize) {
              return SearchAgentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchAgentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchAgentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Agent> extractResources(SearchAgentsResponse payload) {
              return payload.getAgentsList();
            }
          };

  private static final PagedListDescriptor<ListEndpointsRequest, ListEndpointsResponse, Endpoint>
      LIST_ENDPOINTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListEndpointsRequest, ListEndpointsResponse, Endpoint>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEndpointsRequest injectToken(ListEndpointsRequest payload, String token) {
              return ListEndpointsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEndpointsRequest injectPageSize(ListEndpointsRequest payload, int pageSize) {
              return ListEndpointsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEndpointsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEndpointsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Endpoint> extractResources(ListEndpointsResponse payload) {
              return payload.getEndpointsList();
            }
          };

  private static final PagedListDescriptor<ListMcpServersRequest, ListMcpServersResponse, McpServer>
      LIST_MCP_SERVERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListMcpServersRequest, ListMcpServersResponse, McpServer>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMcpServersRequest injectToken(ListMcpServersRequest payload, String token) {
              return ListMcpServersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMcpServersRequest injectPageSize(
                ListMcpServersRequest payload, int pageSize) {
              return ListMcpServersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMcpServersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMcpServersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<McpServer> extractResources(ListMcpServersResponse payload) {
              return payload.getMcpServersList();
            }
          };

  private static final PagedListDescriptor<
          SearchMcpServersRequest, SearchMcpServersResponse, McpServer>
      SEARCH_MCP_SERVERS_PAGE_STR_DESC =
          new PagedListDescriptor<SearchMcpServersRequest, SearchMcpServersResponse, McpServer>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchMcpServersRequest injectToken(
                SearchMcpServersRequest payload, String token) {
              return SearchMcpServersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchMcpServersRequest injectPageSize(
                SearchMcpServersRequest payload, int pageSize) {
              return SearchMcpServersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchMcpServersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchMcpServersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<McpServer> extractResources(SearchMcpServersResponse payload) {
              return payload.getMcpServersList();
            }
          };

  private static final PagedListDescriptor<ListServicesRequest, ListServicesResponse, Service>
      LIST_SERVICES_PAGE_STR_DESC =
          new PagedListDescriptor<ListServicesRequest, ListServicesResponse, Service>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListServicesRequest injectToken(ListServicesRequest payload, String token) {
              return ListServicesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListServicesRequest injectPageSize(ListServicesRequest payload, int pageSize) {
              return ListServicesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListServicesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListServicesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Service> extractResources(ListServicesResponse payload) {
              return payload.getServicesList();
            }
          };

  private static final PagedListDescriptor<ListBindingsRequest, ListBindingsResponse, Binding>
      LIST_BINDINGS_PAGE_STR_DESC =
          new PagedListDescriptor<ListBindingsRequest, ListBindingsResponse, Binding>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBindingsRequest injectToken(ListBindingsRequest payload, String token) {
              return ListBindingsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBindingsRequest injectPageSize(ListBindingsRequest payload, int pageSize) {
              return ListBindingsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBindingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBindingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Binding> extractResources(ListBindingsResponse payload) {
              return payload.getBindingsList();
            }
          };

  private static final PagedListDescriptor<
          FetchAvailableBindingsRequest, FetchAvailableBindingsResponse, Binding>
      FETCH_AVAILABLE_BINDINGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              FetchAvailableBindingsRequest, FetchAvailableBindingsResponse, Binding>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public FetchAvailableBindingsRequest injectToken(
                FetchAvailableBindingsRequest payload, String token) {
              return FetchAvailableBindingsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public FetchAvailableBindingsRequest injectPageSize(
                FetchAvailableBindingsRequest payload, int pageSize) {
              return FetchAvailableBindingsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(FetchAvailableBindingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(FetchAvailableBindingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Binding> extractResources(FetchAvailableBindingsResponse payload) {
              return payload.getBindingsList();
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
          SearchAgentsRequest, SearchAgentsResponse, SearchAgentsPagedResponse>
      SEARCH_AGENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchAgentsRequest, SearchAgentsResponse, SearchAgentsPagedResponse>() {
            @Override
            public ApiFuture<SearchAgentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchAgentsRequest, SearchAgentsResponse> callable,
                SearchAgentsRequest request,
                ApiCallContext context,
                ApiFuture<SearchAgentsResponse> futureResponse) {
              PageContext<SearchAgentsRequest, SearchAgentsResponse, Agent> pageContext =
                  PageContext.create(callable, SEARCH_AGENTS_PAGE_STR_DESC, request, context);
              return SearchAgentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListEndpointsRequest, ListEndpointsResponse, ListEndpointsPagedResponse>
      LIST_ENDPOINTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEndpointsRequest, ListEndpointsResponse, ListEndpointsPagedResponse>() {
            @Override
            public ApiFuture<ListEndpointsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEndpointsRequest, ListEndpointsResponse> callable,
                ListEndpointsRequest request,
                ApiCallContext context,
                ApiFuture<ListEndpointsResponse> futureResponse) {
              PageContext<ListEndpointsRequest, ListEndpointsResponse, Endpoint> pageContext =
                  PageContext.create(callable, LIST_ENDPOINTS_PAGE_STR_DESC, request, context);
              return ListEndpointsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListMcpServersRequest, ListMcpServersResponse, ListMcpServersPagedResponse>
      LIST_MCP_SERVERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMcpServersRequest, ListMcpServersResponse, ListMcpServersPagedResponse>() {
            @Override
            public ApiFuture<ListMcpServersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMcpServersRequest, ListMcpServersResponse> callable,
                ListMcpServersRequest request,
                ApiCallContext context,
                ApiFuture<ListMcpServersResponse> futureResponse) {
              PageContext<ListMcpServersRequest, ListMcpServersResponse, McpServer> pageContext =
                  PageContext.create(callable, LIST_MCP_SERVERS_PAGE_STR_DESC, request, context);
              return ListMcpServersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchMcpServersRequest, SearchMcpServersResponse, SearchMcpServersPagedResponse>
      SEARCH_MCP_SERVERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchMcpServersRequest, SearchMcpServersResponse, SearchMcpServersPagedResponse>() {
            @Override
            public ApiFuture<SearchMcpServersPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchMcpServersRequest, SearchMcpServersResponse> callable,
                SearchMcpServersRequest request,
                ApiCallContext context,
                ApiFuture<SearchMcpServersResponse> futureResponse) {
              PageContext<SearchMcpServersRequest, SearchMcpServersResponse, McpServer>
                  pageContext =
                      PageContext.create(
                          callable, SEARCH_MCP_SERVERS_PAGE_STR_DESC, request, context);
              return SearchMcpServersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      LIST_SERVICES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>() {
            @Override
            public ApiFuture<ListServicesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListServicesRequest, ListServicesResponse> callable,
                ListServicesRequest request,
                ApiCallContext context,
                ApiFuture<ListServicesResponse> futureResponse) {
              PageContext<ListServicesRequest, ListServicesResponse, Service> pageContext =
                  PageContext.create(callable, LIST_SERVICES_PAGE_STR_DESC, request, context);
              return ListServicesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBindingsRequest, ListBindingsResponse, ListBindingsPagedResponse>
      LIST_BINDINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBindingsRequest, ListBindingsResponse, ListBindingsPagedResponse>() {
            @Override
            public ApiFuture<ListBindingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBindingsRequest, ListBindingsResponse> callable,
                ListBindingsRequest request,
                ApiCallContext context,
                ApiFuture<ListBindingsResponse> futureResponse) {
              PageContext<ListBindingsRequest, ListBindingsResponse, Binding> pageContext =
                  PageContext.create(callable, LIST_BINDINGS_PAGE_STR_DESC, request, context);
              return ListBindingsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          FetchAvailableBindingsRequest,
          FetchAvailableBindingsResponse,
          FetchAvailableBindingsPagedResponse>
      FETCH_AVAILABLE_BINDINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              FetchAvailableBindingsRequest,
              FetchAvailableBindingsResponse,
              FetchAvailableBindingsPagedResponse>() {
            @Override
            public ApiFuture<FetchAvailableBindingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<FetchAvailableBindingsRequest, FetchAvailableBindingsResponse>
                    callable,
                FetchAvailableBindingsRequest request,
                ApiCallContext context,
                ApiFuture<FetchAvailableBindingsResponse> futureResponse) {
              PageContext<FetchAvailableBindingsRequest, FetchAvailableBindingsResponse, Binding>
                  pageContext =
                      PageContext.create(
                          callable, FETCH_AVAILABLE_BINDINGS_PAGE_STR_DESC, request, context);
              return FetchAvailableBindingsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listAgents. */
  public PagedCallSettings<ListAgentsRequest, ListAgentsResponse, ListAgentsPagedResponse>
      listAgentsSettings() {
    return listAgentsSettings;
  }

  /** Returns the object with the settings used for calls to searchAgents. */
  public PagedCallSettings<SearchAgentsRequest, SearchAgentsResponse, SearchAgentsPagedResponse>
      searchAgentsSettings() {
    return searchAgentsSettings;
  }

  /** Returns the object with the settings used for calls to getAgent. */
  public UnaryCallSettings<GetAgentRequest, Agent> getAgentSettings() {
    return getAgentSettings;
  }

  /** Returns the object with the settings used for calls to listEndpoints. */
  public PagedCallSettings<ListEndpointsRequest, ListEndpointsResponse, ListEndpointsPagedResponse>
      listEndpointsSettings() {
    return listEndpointsSettings;
  }

  /** Returns the object with the settings used for calls to getEndpoint. */
  public UnaryCallSettings<GetEndpointRequest, Endpoint> getEndpointSettings() {
    return getEndpointSettings;
  }

  /** Returns the object with the settings used for calls to listMcpServers. */
  public PagedCallSettings<
          ListMcpServersRequest, ListMcpServersResponse, ListMcpServersPagedResponse>
      listMcpServersSettings() {
    return listMcpServersSettings;
  }

  /** Returns the object with the settings used for calls to searchMcpServers. */
  public PagedCallSettings<
          SearchMcpServersRequest, SearchMcpServersResponse, SearchMcpServersPagedResponse>
      searchMcpServersSettings() {
    return searchMcpServersSettings;
  }

  /** Returns the object with the settings used for calls to getMcpServer. */
  public UnaryCallSettings<GetMcpServerRequest, McpServer> getMcpServerSettings() {
    return getMcpServerSettings;
  }

  /** Returns the object with the settings used for calls to listServices. */
  public PagedCallSettings<ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      listServicesSettings() {
    return listServicesSettings;
  }

  /** Returns the object with the settings used for calls to getService. */
  public UnaryCallSettings<GetServiceRequest, Service> getServiceSettings() {
    return getServiceSettings;
  }

  /** Returns the object with the settings used for calls to createService. */
  public UnaryCallSettings<CreateServiceRequest, Operation> createServiceSettings() {
    return createServiceSettings;
  }

  /** Returns the object with the settings used for calls to createService. */
  public OperationCallSettings<CreateServiceRequest, Service, OperationMetadata>
      createServiceOperationSettings() {
    return createServiceOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateService. */
  public UnaryCallSettings<UpdateServiceRequest, Operation> updateServiceSettings() {
    return updateServiceSettings;
  }

  /** Returns the object with the settings used for calls to updateService. */
  public OperationCallSettings<UpdateServiceRequest, Service, OperationMetadata>
      updateServiceOperationSettings() {
    return updateServiceOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteService. */
  public UnaryCallSettings<DeleteServiceRequest, Operation> deleteServiceSettings() {
    return deleteServiceSettings;
  }

  /** Returns the object with the settings used for calls to deleteService. */
  public OperationCallSettings<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationSettings() {
    return deleteServiceOperationSettings;
  }

  /** Returns the object with the settings used for calls to listBindings. */
  public PagedCallSettings<ListBindingsRequest, ListBindingsResponse, ListBindingsPagedResponse>
      listBindingsSettings() {
    return listBindingsSettings;
  }

  /** Returns the object with the settings used for calls to getBinding. */
  public UnaryCallSettings<GetBindingRequest, Binding> getBindingSettings() {
    return getBindingSettings;
  }

  /** Returns the object with the settings used for calls to createBinding. */
  public UnaryCallSettings<CreateBindingRequest, Operation> createBindingSettings() {
    return createBindingSettings;
  }

  /** Returns the object with the settings used for calls to createBinding. */
  public OperationCallSettings<CreateBindingRequest, Binding, OperationMetadata>
      createBindingOperationSettings() {
    return createBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateBinding. */
  public UnaryCallSettings<UpdateBindingRequest, Operation> updateBindingSettings() {
    return updateBindingSettings;
  }

  /** Returns the object with the settings used for calls to updateBinding. */
  public OperationCallSettings<UpdateBindingRequest, Binding, OperationMetadata>
      updateBindingOperationSettings() {
    return updateBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteBinding. */
  public UnaryCallSettings<DeleteBindingRequest, Operation> deleteBindingSettings() {
    return deleteBindingSettings;
  }

  /** Returns the object with the settings used for calls to deleteBinding. */
  public OperationCallSettings<DeleteBindingRequest, Empty, OperationMetadata>
      deleteBindingOperationSettings() {
    return deleteBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to fetchAvailableBindings. */
  public PagedCallSettings<
          FetchAvailableBindingsRequest,
          FetchAvailableBindingsResponse,
          FetchAvailableBindingsPagedResponse>
      fetchAvailableBindingsSettings() {
    return fetchAvailableBindingsSettings;
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

  public AgentRegistryStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAgentRegistryStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAgentRegistryStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "agentregistry";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "agentregistry.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "agentregistry.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(AgentRegistryStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AgentRegistryStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AgentRegistryStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected AgentRegistryStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listAgentsSettings = settingsBuilder.listAgentsSettings().build();
    searchAgentsSettings = settingsBuilder.searchAgentsSettings().build();
    getAgentSettings = settingsBuilder.getAgentSettings().build();
    listEndpointsSettings = settingsBuilder.listEndpointsSettings().build();
    getEndpointSettings = settingsBuilder.getEndpointSettings().build();
    listMcpServersSettings = settingsBuilder.listMcpServersSettings().build();
    searchMcpServersSettings = settingsBuilder.searchMcpServersSettings().build();
    getMcpServerSettings = settingsBuilder.getMcpServerSettings().build();
    listServicesSettings = settingsBuilder.listServicesSettings().build();
    getServiceSettings = settingsBuilder.getServiceSettings().build();
    createServiceSettings = settingsBuilder.createServiceSettings().build();
    createServiceOperationSettings = settingsBuilder.createServiceOperationSettings().build();
    updateServiceSettings = settingsBuilder.updateServiceSettings().build();
    updateServiceOperationSettings = settingsBuilder.updateServiceOperationSettings().build();
    deleteServiceSettings = settingsBuilder.deleteServiceSettings().build();
    deleteServiceOperationSettings = settingsBuilder.deleteServiceOperationSettings().build();
    listBindingsSettings = settingsBuilder.listBindingsSettings().build();
    getBindingSettings = settingsBuilder.getBindingSettings().build();
    createBindingSettings = settingsBuilder.createBindingSettings().build();
    createBindingOperationSettings = settingsBuilder.createBindingOperationSettings().build();
    updateBindingSettings = settingsBuilder.updateBindingSettings().build();
    updateBindingOperationSettings = settingsBuilder.updateBindingOperationSettings().build();
    deleteBindingSettings = settingsBuilder.deleteBindingSettings().build();
    deleteBindingOperationSettings = settingsBuilder.deleteBindingOperationSettings().build();
    fetchAvailableBindingsSettings = settingsBuilder.fetchAvailableBindingsSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-agentregistry")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for AgentRegistryStubSettings. */
  public static class Builder extends StubSettings.Builder<AgentRegistryStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListAgentsRequest, ListAgentsResponse, ListAgentsPagedResponse>
        listAgentsSettings;
    private final PagedCallSettings.Builder<
            SearchAgentsRequest, SearchAgentsResponse, SearchAgentsPagedResponse>
        searchAgentsSettings;
    private final UnaryCallSettings.Builder<GetAgentRequest, Agent> getAgentSettings;
    private final PagedCallSettings.Builder<
            ListEndpointsRequest, ListEndpointsResponse, ListEndpointsPagedResponse>
        listEndpointsSettings;
    private final UnaryCallSettings.Builder<GetEndpointRequest, Endpoint> getEndpointSettings;
    private final PagedCallSettings.Builder<
            ListMcpServersRequest, ListMcpServersResponse, ListMcpServersPagedResponse>
        listMcpServersSettings;
    private final PagedCallSettings.Builder<
            SearchMcpServersRequest, SearchMcpServersResponse, SearchMcpServersPagedResponse>
        searchMcpServersSettings;
    private final UnaryCallSettings.Builder<GetMcpServerRequest, McpServer> getMcpServerSettings;
    private final PagedCallSettings.Builder<
            ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
        listServicesSettings;
    private final UnaryCallSettings.Builder<GetServiceRequest, Service> getServiceSettings;
    private final UnaryCallSettings.Builder<CreateServiceRequest, Operation> createServiceSettings;
    private final OperationCallSettings.Builder<CreateServiceRequest, Service, OperationMetadata>
        createServiceOperationSettings;
    private final UnaryCallSettings.Builder<UpdateServiceRequest, Operation> updateServiceSettings;
    private final OperationCallSettings.Builder<UpdateServiceRequest, Service, OperationMetadata>
        updateServiceOperationSettings;
    private final UnaryCallSettings.Builder<DeleteServiceRequest, Operation> deleteServiceSettings;
    private final OperationCallSettings.Builder<DeleteServiceRequest, Empty, OperationMetadata>
        deleteServiceOperationSettings;
    private final PagedCallSettings.Builder<
            ListBindingsRequest, ListBindingsResponse, ListBindingsPagedResponse>
        listBindingsSettings;
    private final UnaryCallSettings.Builder<GetBindingRequest, Binding> getBindingSettings;
    private final UnaryCallSettings.Builder<CreateBindingRequest, Operation> createBindingSettings;
    private final OperationCallSettings.Builder<CreateBindingRequest, Binding, OperationMetadata>
        createBindingOperationSettings;
    private final UnaryCallSettings.Builder<UpdateBindingRequest, Operation> updateBindingSettings;
    private final OperationCallSettings.Builder<UpdateBindingRequest, Binding, OperationMetadata>
        updateBindingOperationSettings;
    private final UnaryCallSettings.Builder<DeleteBindingRequest, Operation> deleteBindingSettings;
    private final OperationCallSettings.Builder<DeleteBindingRequest, Empty, OperationMetadata>
        deleteBindingOperationSettings;
    private final PagedCallSettings.Builder<
            FetchAvailableBindingsRequest,
            FetchAvailableBindingsResponse,
            FetchAvailableBindingsPagedResponse>
        fetchAvailableBindingsSettings;
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

      listAgentsSettings = PagedCallSettings.newBuilder(LIST_AGENTS_PAGE_STR_FACT);
      searchAgentsSettings = PagedCallSettings.newBuilder(SEARCH_AGENTS_PAGE_STR_FACT);
      getAgentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listEndpointsSettings = PagedCallSettings.newBuilder(LIST_ENDPOINTS_PAGE_STR_FACT);
      getEndpointSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listMcpServersSettings = PagedCallSettings.newBuilder(LIST_MCP_SERVERS_PAGE_STR_FACT);
      searchMcpServersSettings = PagedCallSettings.newBuilder(SEARCH_MCP_SERVERS_PAGE_STR_FACT);
      getMcpServerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listServicesSettings = PagedCallSettings.newBuilder(LIST_SERVICES_PAGE_STR_FACT);
      getServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createServiceOperationSettings = OperationCallSettings.newBuilder();
      updateServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateServiceOperationSettings = OperationCallSettings.newBuilder();
      deleteServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteServiceOperationSettings = OperationCallSettings.newBuilder();
      listBindingsSettings = PagedCallSettings.newBuilder(LIST_BINDINGS_PAGE_STR_FACT);
      getBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBindingOperationSettings = OperationCallSettings.newBuilder();
      updateBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBindingOperationSettings = OperationCallSettings.newBuilder();
      deleteBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteBindingOperationSettings = OperationCallSettings.newBuilder();
      fetchAvailableBindingsSettings =
          PagedCallSettings.newBuilder(FETCH_AVAILABLE_BINDINGS_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAgentsSettings,
              searchAgentsSettings,
              getAgentSettings,
              listEndpointsSettings,
              getEndpointSettings,
              listMcpServersSettings,
              searchMcpServersSettings,
              getMcpServerSettings,
              listServicesSettings,
              getServiceSettings,
              createServiceSettings,
              updateServiceSettings,
              deleteServiceSettings,
              listBindingsSettings,
              getBindingSettings,
              createBindingSettings,
              updateBindingSettings,
              deleteBindingSettings,
              fetchAvailableBindingsSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(AgentRegistryStubSettings settings) {
      super(settings);

      listAgentsSettings = settings.listAgentsSettings.toBuilder();
      searchAgentsSettings = settings.searchAgentsSettings.toBuilder();
      getAgentSettings = settings.getAgentSettings.toBuilder();
      listEndpointsSettings = settings.listEndpointsSettings.toBuilder();
      getEndpointSettings = settings.getEndpointSettings.toBuilder();
      listMcpServersSettings = settings.listMcpServersSettings.toBuilder();
      searchMcpServersSettings = settings.searchMcpServersSettings.toBuilder();
      getMcpServerSettings = settings.getMcpServerSettings.toBuilder();
      listServicesSettings = settings.listServicesSettings.toBuilder();
      getServiceSettings = settings.getServiceSettings.toBuilder();
      createServiceSettings = settings.createServiceSettings.toBuilder();
      createServiceOperationSettings = settings.createServiceOperationSettings.toBuilder();
      updateServiceSettings = settings.updateServiceSettings.toBuilder();
      updateServiceOperationSettings = settings.updateServiceOperationSettings.toBuilder();
      deleteServiceSettings = settings.deleteServiceSettings.toBuilder();
      deleteServiceOperationSettings = settings.deleteServiceOperationSettings.toBuilder();
      listBindingsSettings = settings.listBindingsSettings.toBuilder();
      getBindingSettings = settings.getBindingSettings.toBuilder();
      createBindingSettings = settings.createBindingSettings.toBuilder();
      createBindingOperationSettings = settings.createBindingOperationSettings.toBuilder();
      updateBindingSettings = settings.updateBindingSettings.toBuilder();
      updateBindingOperationSettings = settings.updateBindingOperationSettings.toBuilder();
      deleteBindingSettings = settings.deleteBindingSettings.toBuilder();
      deleteBindingOperationSettings = settings.deleteBindingOperationSettings.toBuilder();
      fetchAvailableBindingsSettings = settings.fetchAvailableBindingsSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAgentsSettings,
              searchAgentsSettings,
              getAgentSettings,
              listEndpointsSettings,
              getEndpointSettings,
              listMcpServersSettings,
              searchMcpServersSettings,
              getMcpServerSettings,
              listServicesSettings,
              getServiceSettings,
              createServiceSettings,
              updateServiceSettings,
              deleteServiceSettings,
              listBindingsSettings,
              getBindingSettings,
              createBindingSettings,
              updateBindingSettings,
              deleteBindingSettings,
              fetchAvailableBindingsSettings,
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
          .listAgentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .searchAgentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getAgentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listEndpointsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getEndpointSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listMcpServersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .searchMcpServersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getMcpServerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listServicesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listBindingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .fetchAvailableBindingsSettings()
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
          .createServiceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateServiceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Service.class))
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
          .updateServiceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateServiceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Service.class))
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
          .deleteServiceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteServiceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .createBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateBindingRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Binding.class))
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
          .updateBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateBindingRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Binding.class))
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
          .deleteBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteBindingRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to listAgents. */
    public PagedCallSettings.Builder<ListAgentsRequest, ListAgentsResponse, ListAgentsPagedResponse>
        listAgentsSettings() {
      return listAgentsSettings;
    }

    /** Returns the builder for the settings used for calls to searchAgents. */
    public PagedCallSettings.Builder<
            SearchAgentsRequest, SearchAgentsResponse, SearchAgentsPagedResponse>
        searchAgentsSettings() {
      return searchAgentsSettings;
    }

    /** Returns the builder for the settings used for calls to getAgent. */
    public UnaryCallSettings.Builder<GetAgentRequest, Agent> getAgentSettings() {
      return getAgentSettings;
    }

    /** Returns the builder for the settings used for calls to listEndpoints. */
    public PagedCallSettings.Builder<
            ListEndpointsRequest, ListEndpointsResponse, ListEndpointsPagedResponse>
        listEndpointsSettings() {
      return listEndpointsSettings;
    }

    /** Returns the builder for the settings used for calls to getEndpoint. */
    public UnaryCallSettings.Builder<GetEndpointRequest, Endpoint> getEndpointSettings() {
      return getEndpointSettings;
    }

    /** Returns the builder for the settings used for calls to listMcpServers. */
    public PagedCallSettings.Builder<
            ListMcpServersRequest, ListMcpServersResponse, ListMcpServersPagedResponse>
        listMcpServersSettings() {
      return listMcpServersSettings;
    }

    /** Returns the builder for the settings used for calls to searchMcpServers. */
    public PagedCallSettings.Builder<
            SearchMcpServersRequest, SearchMcpServersResponse, SearchMcpServersPagedResponse>
        searchMcpServersSettings() {
      return searchMcpServersSettings;
    }

    /** Returns the builder for the settings used for calls to getMcpServer. */
    public UnaryCallSettings.Builder<GetMcpServerRequest, McpServer> getMcpServerSettings() {
      return getMcpServerSettings;
    }

    /** Returns the builder for the settings used for calls to listServices. */
    public PagedCallSettings.Builder<
            ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
        listServicesSettings() {
      return listServicesSettings;
    }

    /** Returns the builder for the settings used for calls to getService. */
    public UnaryCallSettings.Builder<GetServiceRequest, Service> getServiceSettings() {
      return getServiceSettings;
    }

    /** Returns the builder for the settings used for calls to createService. */
    public UnaryCallSettings.Builder<CreateServiceRequest, Operation> createServiceSettings() {
      return createServiceSettings;
    }

    /** Returns the builder for the settings used for calls to createService. */
    public OperationCallSettings.Builder<CreateServiceRequest, Service, OperationMetadata>
        createServiceOperationSettings() {
      return createServiceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateService. */
    public UnaryCallSettings.Builder<UpdateServiceRequest, Operation> updateServiceSettings() {
      return updateServiceSettings;
    }

    /** Returns the builder for the settings used for calls to updateService. */
    public OperationCallSettings.Builder<UpdateServiceRequest, Service, OperationMetadata>
        updateServiceOperationSettings() {
      return updateServiceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteService. */
    public UnaryCallSettings.Builder<DeleteServiceRequest, Operation> deleteServiceSettings() {
      return deleteServiceSettings;
    }

    /** Returns the builder for the settings used for calls to deleteService. */
    public OperationCallSettings.Builder<DeleteServiceRequest, Empty, OperationMetadata>
        deleteServiceOperationSettings() {
      return deleteServiceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listBindings. */
    public PagedCallSettings.Builder<
            ListBindingsRequest, ListBindingsResponse, ListBindingsPagedResponse>
        listBindingsSettings() {
      return listBindingsSettings;
    }

    /** Returns the builder for the settings used for calls to getBinding. */
    public UnaryCallSettings.Builder<GetBindingRequest, Binding> getBindingSettings() {
      return getBindingSettings;
    }

    /** Returns the builder for the settings used for calls to createBinding. */
    public UnaryCallSettings.Builder<CreateBindingRequest, Operation> createBindingSettings() {
      return createBindingSettings;
    }

    /** Returns the builder for the settings used for calls to createBinding. */
    public OperationCallSettings.Builder<CreateBindingRequest, Binding, OperationMetadata>
        createBindingOperationSettings() {
      return createBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateBinding. */
    public UnaryCallSettings.Builder<UpdateBindingRequest, Operation> updateBindingSettings() {
      return updateBindingSettings;
    }

    /** Returns the builder for the settings used for calls to updateBinding. */
    public OperationCallSettings.Builder<UpdateBindingRequest, Binding, OperationMetadata>
        updateBindingOperationSettings() {
      return updateBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBinding. */
    public UnaryCallSettings.Builder<DeleteBindingRequest, Operation> deleteBindingSettings() {
      return deleteBindingSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBinding. */
    public OperationCallSettings.Builder<DeleteBindingRequest, Empty, OperationMetadata>
        deleteBindingOperationSettings() {
      return deleteBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to fetchAvailableBindings. */
    public PagedCallSettings.Builder<
            FetchAvailableBindingsRequest,
            FetchAvailableBindingsResponse,
            FetchAvailableBindingsPagedResponse>
        fetchAvailableBindingsSettings() {
      return fetchAvailableBindingsSettings;
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
    public AgentRegistryStubSettings build() throws IOException {
      return new AgentRegistryStubSettings(this);
    }
  }
}
