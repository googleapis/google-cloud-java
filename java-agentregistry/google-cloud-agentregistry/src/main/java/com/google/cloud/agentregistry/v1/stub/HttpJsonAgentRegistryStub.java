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
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListAiApplicationAgentsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListAiApplicationEndpointsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListAiApplicationMcpServersPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListAiApplicationsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListBindingsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListEndpointsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListFindingsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListLocationsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListMcpServersPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListPublishersPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListServicesPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListSkillRevisionsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListSkillsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.SearchAgentsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.SearchMcpServersPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.SearchSkillsPagedResponse;

import com.google.api.HttpRule;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.agentregistry.v1.Agent;
import com.google.cloud.agentregistry.v1.AiApplication;
import com.google.cloud.agentregistry.v1.Binding;
import com.google.cloud.agentregistry.v1.CreateBindingRequest;
import com.google.cloud.agentregistry.v1.CreateServiceRequest;
import com.google.cloud.agentregistry.v1.CreateSkillRequest;
import com.google.cloud.agentregistry.v1.CreateSkillRevisionRequest;
import com.google.cloud.agentregistry.v1.DeleteBindingRequest;
import com.google.cloud.agentregistry.v1.DeleteServiceRequest;
import com.google.cloud.agentregistry.v1.DeleteSkillRequest;
import com.google.cloud.agentregistry.v1.DeleteSkillRevisionRequest;
import com.google.cloud.agentregistry.v1.Endpoint;
import com.google.cloud.agentregistry.v1.FetchAvailableBindingsRequest;
import com.google.cloud.agentregistry.v1.FetchAvailableBindingsResponse;
import com.google.cloud.agentregistry.v1.Finding;
import com.google.cloud.agentregistry.v1.GetAgentRequest;
import com.google.cloud.agentregistry.v1.GetAiApplicationAgentRequest;
import com.google.cloud.agentregistry.v1.GetAiApplicationEndpointRequest;
import com.google.cloud.agentregistry.v1.GetAiApplicationMcpServerRequest;
import com.google.cloud.agentregistry.v1.GetAiApplicationRequest;
import com.google.cloud.agentregistry.v1.GetBindingRequest;
import com.google.cloud.agentregistry.v1.GetEndpointRequest;
import com.google.cloud.agentregistry.v1.GetFindingRequest;
import com.google.cloud.agentregistry.v1.GetMcpServerRequest;
import com.google.cloud.agentregistry.v1.GetPublisherRequest;
import com.google.cloud.agentregistry.v1.GetServiceRequest;
import com.google.cloud.agentregistry.v1.GetSkillEncryptionSpecRequest;
import com.google.cloud.agentregistry.v1.GetSkillRequest;
import com.google.cloud.agentregistry.v1.GetSkillRevisionRequest;
import com.google.cloud.agentregistry.v1.ListAgentsRequest;
import com.google.cloud.agentregistry.v1.ListAgentsResponse;
import com.google.cloud.agentregistry.v1.ListAiApplicationAgentsRequest;
import com.google.cloud.agentregistry.v1.ListAiApplicationAgentsResponse;
import com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsRequest;
import com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsResponse;
import com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersRequest;
import com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersResponse;
import com.google.cloud.agentregistry.v1.ListAiApplicationsRequest;
import com.google.cloud.agentregistry.v1.ListAiApplicationsResponse;
import com.google.cloud.agentregistry.v1.ListBindingsRequest;
import com.google.cloud.agentregistry.v1.ListBindingsResponse;
import com.google.cloud.agentregistry.v1.ListEndpointsRequest;
import com.google.cloud.agentregistry.v1.ListEndpointsResponse;
import com.google.cloud.agentregistry.v1.ListFindingsRequest;
import com.google.cloud.agentregistry.v1.ListFindingsResponse;
import com.google.cloud.agentregistry.v1.ListMcpServersRequest;
import com.google.cloud.agentregistry.v1.ListMcpServersResponse;
import com.google.cloud.agentregistry.v1.ListPublishersRequest;
import com.google.cloud.agentregistry.v1.ListPublishersResponse;
import com.google.cloud.agentregistry.v1.ListServicesRequest;
import com.google.cloud.agentregistry.v1.ListServicesResponse;
import com.google.cloud.agentregistry.v1.ListSkillRevisionsRequest;
import com.google.cloud.agentregistry.v1.ListSkillRevisionsResponse;
import com.google.cloud.agentregistry.v1.ListSkillsRequest;
import com.google.cloud.agentregistry.v1.ListSkillsResponse;
import com.google.cloud.agentregistry.v1.McpServer;
import com.google.cloud.agentregistry.v1.OperationMetadata;
import com.google.cloud.agentregistry.v1.Publisher;
import com.google.cloud.agentregistry.v1.SearchAgentsRequest;
import com.google.cloud.agentregistry.v1.SearchAgentsResponse;
import com.google.cloud.agentregistry.v1.SearchMcpServersRequest;
import com.google.cloud.agentregistry.v1.SearchMcpServersResponse;
import com.google.cloud.agentregistry.v1.SearchSkillsRequest;
import com.google.cloud.agentregistry.v1.SearchSkillsResponse;
import com.google.cloud.agentregistry.v1.Service;
import com.google.cloud.agentregistry.v1.Skill;
import com.google.cloud.agentregistry.v1.SkillEncryptionSpec;
import com.google.cloud.agentregistry.v1.SkillRevision;
import com.google.cloud.agentregistry.v1.UpdateBindingRequest;
import com.google.cloud.agentregistry.v1.UpdateServiceRequest;
import com.google.cloud.agentregistry.v1.UpdateSkillEncryptionSpecRequest;
import com.google.cloud.agentregistry.v1.UpdateSkillRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the AgentRegistry service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonAgentRegistryStub extends AgentRegistryStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(SkillEncryptionSpec.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Binding.getDescriptor())
          .add(SkillRevision.getDescriptor())
          .add(Skill.getDescriptor())
          .add(Service.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListAgentsRequest, ListAgentsResponse>
      listAgentsMethodDescriptor =
          ApiMethodDescriptor.<ListAgentsRequest, ListAgentsResponse>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/ListAgents")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAgentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/agents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAgentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAgentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAgentsResponse>newBuilder()
                      .setDefaultInstance(ListAgentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SearchAgentsRequest, SearchAgentsResponse>
      searchAgentsMethodDescriptor =
          ApiMethodDescriptor.<SearchAgentsRequest, SearchAgentsResponse>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/SearchAgents")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchAgentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/agents:search",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchAgentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchAgentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchAgentsResponse>newBuilder()
                      .setDefaultInstance(SearchAgentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAgentRequest, Agent> getAgentMethodDescriptor =
      ApiMethodDescriptor.<GetAgentRequest, Agent>newBuilder()
          .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/GetAgent")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetAgentRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/agents/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetAgentRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetAgentRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Agent>newBuilder()
                  .setDefaultInstance(Agent.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListEndpointsRequest, ListEndpointsResponse>
      listEndpointsMethodDescriptor =
          ApiMethodDescriptor.<ListEndpointsRequest, ListEndpointsResponse>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/ListEndpoints")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEndpointsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/endpoints",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEndpointsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEndpointsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListEndpointsResponse>newBuilder()
                      .setDefaultInstance(ListEndpointsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetEndpointRequest, Endpoint>
      getEndpointMethodDescriptor =
          ApiMethodDescriptor.<GetEndpointRequest, Endpoint>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/GetEndpoint")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEndpointRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/endpoints/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEndpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEndpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Endpoint>newBuilder()
                      .setDefaultInstance(Endpoint.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListMcpServersRequest, ListMcpServersResponse>
      listMcpServersMethodDescriptor =
          ApiMethodDescriptor.<ListMcpServersRequest, ListMcpServersResponse>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/ListMcpServers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMcpServersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/mcpServers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMcpServersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMcpServersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListMcpServersResponse>newBuilder()
                      .setDefaultInstance(ListMcpServersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SearchMcpServersRequest, SearchMcpServersResponse>
      searchMcpServersMethodDescriptor =
          ApiMethodDescriptor.<SearchMcpServersRequest, SearchMcpServersResponse>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/SearchMcpServers")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchMcpServersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/mcpServers:search",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchMcpServersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchMcpServersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchMcpServersResponse>newBuilder()
                      .setDefaultInstance(SearchMcpServersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetMcpServerRequest, McpServer>
      getMcpServerMethodDescriptor =
          ApiMethodDescriptor.<GetMcpServerRequest, McpServer>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/GetMcpServer")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetMcpServerRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/mcpServers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetMcpServerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetMcpServerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<McpServer>newBuilder()
                      .setDefaultInstance(McpServer.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListServicesRequest, ListServicesResponse>
      listServicesMethodDescriptor =
          ApiMethodDescriptor.<ListServicesRequest, ListServicesResponse>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/ListServices")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListServicesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/services",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListServicesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListServicesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListServicesResponse>newBuilder()
                      .setDefaultInstance(ListServicesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetServiceRequest, Service> getServiceMethodDescriptor =
      ApiMethodDescriptor.<GetServiceRequest, Service>newBuilder()
          .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/GetService")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetServiceRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/services/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetServiceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetServiceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Service>newBuilder()
                  .setDefaultInstance(Service.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateServiceRequest, Operation>
      createServiceMethodDescriptor =
          ApiMethodDescriptor.<CreateServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/CreateService")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateServiceRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/services",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "serviceId", request.getServiceId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("service", request.getService(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateServiceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateServiceRequest, Operation>
      updateServiceMethodDescriptor =
          ApiMethodDescriptor.<UpdateServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/UpdateService")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateServiceRequest>newBuilder()
                      .setPath(
                          "/v1/{service.name=projects/*/locations/*/services/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "service.name", request.getService().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("service", request.getService(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateServiceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteServiceRequest, Operation>
      deleteServiceMethodDescriptor =
          ApiMethodDescriptor.<DeleteServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/DeleteService")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteServiceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/services/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteServiceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListBindingsRequest, ListBindingsResponse>
      listBindingsMethodDescriptor =
          ApiMethodDescriptor.<ListBindingsRequest, ListBindingsResponse>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/ListBindings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBindingsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/bindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListBindingsResponse>newBuilder()
                      .setDefaultInstance(ListBindingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetBindingRequest, Binding> getBindingMethodDescriptor =
      ApiMethodDescriptor.<GetBindingRequest, Binding>newBuilder()
          .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/GetBinding")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetBindingRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/bindings/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetBindingRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetBindingRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Binding>newBuilder()
                  .setDefaultInstance(Binding.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateBindingRequest, Operation>
      createBindingMethodDescriptor =
          ApiMethodDescriptor.<CreateBindingRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/CreateBinding")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/bindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "bindingId", request.getBindingId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("binding", request.getBinding(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateBindingRequest, Operation>
      updateBindingMethodDescriptor =
          ApiMethodDescriptor.<UpdateBindingRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/UpdateBinding")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{binding.name=projects/*/locations/*/bindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "binding.name", request.getBinding().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("binding", request.getBinding(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteBindingRequest, Operation>
      deleteBindingMethodDescriptor =
          ApiMethodDescriptor.<DeleteBindingRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/DeleteBinding")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/bindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          FetchAvailableBindingsRequest, FetchAvailableBindingsResponse>
      fetchAvailableBindingsMethodDescriptor =
          ApiMethodDescriptor
              .<FetchAvailableBindingsRequest, FetchAvailableBindingsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.agentregistry.v1.AgentRegistry/FetchAvailableBindings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchAvailableBindingsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/bindings:fetchAvailable",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchAvailableBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchAvailableBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "sourceIdentifier", request.getSourceIdentifier());
                            serializer.putQueryParam(
                                fields, "targetIdentifier", request.getTargetIdentifier());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchAvailableBindingsResponse>newBuilder()
                      .setDefaultInstance(FetchAvailableBindingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateSkillRequest, Operation>
      createSkillMethodDescriptor =
          ApiMethodDescriptor.<CreateSkillRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/CreateSkill")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSkillRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/skills",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSkillRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSkillRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "skillId", request.getSkillId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("skill", request.getSkill(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateSkillRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetSkillRequest, Skill> getSkillMethodDescriptor =
      ApiMethodDescriptor.<GetSkillRequest, Skill>newBuilder()
          .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/GetSkill")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSkillRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/skills/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetSkillRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetSkillRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Skill>newBuilder()
                  .setDefaultInstance(Skill.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateSkillRequest, Operation>
      updateSkillMethodDescriptor =
          ApiMethodDescriptor.<UpdateSkillRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/UpdateSkill")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSkillRequest>newBuilder()
                      .setPath(
                          "/v1/{skill.name=projects/*/locations/*/skills/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSkillRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "skill.name", request.getSkill().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSkillRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("skill", request.getSkill(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateSkillRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteSkillRequest, Operation>
      deleteSkillMethodDescriptor =
          ApiMethodDescriptor.<DeleteSkillRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/DeleteSkill")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSkillRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/skills/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSkillRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSkillRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteSkillRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListSkillsRequest, ListSkillsResponse>
      listSkillsMethodDescriptor =
          ApiMethodDescriptor.<ListSkillsRequest, ListSkillsResponse>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/ListSkills")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSkillsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/skills",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSkillsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSkillsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSkillsResponse>newBuilder()
                      .setDefaultInstance(ListSkillsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SearchSkillsRequest, SearchSkillsResponse>
      searchSkillsMethodDescriptor =
          ApiMethodDescriptor.<SearchSkillsRequest, SearchSkillsResponse>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/SearchSkills")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchSkillsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/skills:search",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchSkillsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{parent=projects/*/locations/*}/skills:search")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchSkillsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchSkillsResponse>newBuilder()
                      .setDefaultInstance(SearchSkillsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateSkillRevisionRequest, Operation>
      createSkillRevisionMethodDescriptor =
          ApiMethodDescriptor.<CreateSkillRevisionRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/CreateSkillRevision")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSkillRevisionRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/skills/*}/revisions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSkillRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSkillRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "skillRevisionId", request.getSkillRevisionId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("skillRevision", request.getSkillRevision(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateSkillRevisionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetSkillRevisionRequest, SkillRevision>
      getSkillRevisionMethodDescriptor =
          ApiMethodDescriptor.<GetSkillRevisionRequest, SkillRevision>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/GetSkillRevision")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSkillRevisionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/skills/*/revisions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSkillRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSkillRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SkillRevision>newBuilder()
                      .setDefaultInstance(SkillRevision.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSkillRevisionRequest, Operation>
      deleteSkillRevisionMethodDescriptor =
          ApiMethodDescriptor.<DeleteSkillRevisionRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/DeleteSkillRevision")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSkillRevisionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/skills/*/revisions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSkillRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSkillRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteSkillRevisionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListSkillRevisionsRequest, ListSkillRevisionsResponse>
      listSkillRevisionsMethodDescriptor =
          ApiMethodDescriptor.<ListSkillRevisionsRequest, ListSkillRevisionsResponse>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/ListSkillRevisions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSkillRevisionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/skills/*}/revisions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSkillRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSkillRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSkillRevisionsResponse>newBuilder()
                      .setDefaultInstance(ListSkillRevisionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPublisherRequest, Publisher>
      getPublisherMethodDescriptor =
          ApiMethodDescriptor.<GetPublisherRequest, Publisher>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/GetPublisher")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPublisherRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/publishers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPublisherRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPublisherRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Publisher>newBuilder()
                      .setDefaultInstance(Publisher.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListPublishersRequest, ListPublishersResponse>
      listPublishersMethodDescriptor =
          ApiMethodDescriptor.<ListPublishersRequest, ListPublishersResponse>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/ListPublishers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPublishersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/publishers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPublishersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPublishersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPublishersResponse>newBuilder()
                      .setDefaultInstance(ListPublishersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAiApplicationRequest, AiApplication>
      getAiApplicationMethodDescriptor =
          ApiMethodDescriptor.<GetAiApplicationRequest, AiApplication>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/GetAiApplication")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAiApplicationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/aiApplications/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAiApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAiApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AiApplication>newBuilder()
                      .setDefaultInstance(AiApplication.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAiApplicationsRequest, ListAiApplicationsResponse>
      listAiApplicationsMethodDescriptor =
          ApiMethodDescriptor.<ListAiApplicationsRequest, ListAiApplicationsResponse>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/ListAiApplications")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAiApplicationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/aiApplications",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAiApplicationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAiApplicationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAiApplicationsResponse>newBuilder()
                      .setDefaultInstance(ListAiApplicationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAiApplicationAgentRequest, Agent>
      getAiApplicationAgentMethodDescriptor =
          ApiMethodDescriptor.<GetAiApplicationAgentRequest, Agent>newBuilder()
              .setFullMethodName(
                  "google.cloud.agentregistry.v1.AgentRegistry/GetAiApplicationAgent")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAiApplicationAgentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/aiApplications/*/agents/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAiApplicationAgentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAiApplicationAgentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Agent>newBuilder()
                      .setDefaultInstance(Agent.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListAiApplicationAgentsRequest, ListAiApplicationAgentsResponse>
      listAiApplicationAgentsMethodDescriptor =
          ApiMethodDescriptor
              .<ListAiApplicationAgentsRequest, ListAiApplicationAgentsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.agentregistry.v1.AgentRegistry/ListAiApplicationAgents")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAiApplicationAgentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/aiApplications/*}/agents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAiApplicationAgentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAiApplicationAgentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAiApplicationAgentsResponse>newBuilder()
                      .setDefaultInstance(ListAiApplicationAgentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAiApplicationMcpServerRequest, McpServer>
      getAiApplicationMcpServerMethodDescriptor =
          ApiMethodDescriptor.<GetAiApplicationMcpServerRequest, McpServer>newBuilder()
              .setFullMethodName(
                  "google.cloud.agentregistry.v1.AgentRegistry/GetAiApplicationMcpServer")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAiApplicationMcpServerRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/aiApplications/*/mcpServers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAiApplicationMcpServerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAiApplicationMcpServerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<McpServer>newBuilder()
                      .setDefaultInstance(McpServer.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListAiApplicationMcpServersRequest, ListAiApplicationMcpServersResponse>
      listAiApplicationMcpServersMethodDescriptor =
          ApiMethodDescriptor
              .<ListAiApplicationMcpServersRequest, ListAiApplicationMcpServersResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.agentregistry.v1.AgentRegistry/ListAiApplicationMcpServers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAiApplicationMcpServersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/aiApplications/*}/mcpServers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAiApplicationMcpServersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAiApplicationMcpServersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAiApplicationMcpServersResponse>newBuilder()
                      .setDefaultInstance(ListAiApplicationMcpServersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetFindingRequest, Finding> getFindingMethodDescriptor =
      ApiMethodDescriptor.<GetFindingRequest, Finding>newBuilder()
          .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/GetFinding")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetFindingRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/findings/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetFindingRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetFindingRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Finding>newBuilder()
                  .setDefaultInstance(Finding.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListFindingsRequest, ListFindingsResponse>
      listFindingsMethodDescriptor =
          ApiMethodDescriptor.<ListFindingsRequest, ListFindingsResponse>newBuilder()
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/ListFindings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFindingsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/findings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListFindingsResponse>newBuilder()
                      .setDefaultInstance(ListFindingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAiApplicationEndpointRequest, Endpoint>
      getAiApplicationEndpointMethodDescriptor =
          ApiMethodDescriptor.<GetAiApplicationEndpointRequest, Endpoint>newBuilder()
              .setFullMethodName(
                  "google.cloud.agentregistry.v1.AgentRegistry/GetAiApplicationEndpoint")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAiApplicationEndpointRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/aiApplications/*/endpoints/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAiApplicationEndpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAiApplicationEndpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Endpoint>newBuilder()
                      .setDefaultInstance(Endpoint.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListAiApplicationEndpointsRequest, ListAiApplicationEndpointsResponse>
      listAiApplicationEndpointsMethodDescriptor =
          ApiMethodDescriptor
              .<ListAiApplicationEndpointsRequest, ListAiApplicationEndpointsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.agentregistry.v1.AgentRegistry/ListAiApplicationEndpoints")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAiApplicationEndpointsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/aiApplications/*}/endpoints",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAiApplicationEndpointsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAiApplicationEndpointsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAiApplicationEndpointsResponse>newBuilder()
                      .setDefaultInstance(ListAiApplicationEndpointsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSkillEncryptionSpecRequest, SkillEncryptionSpec>
      getSkillEncryptionSpecMethodDescriptor =
          ApiMethodDescriptor.<GetSkillEncryptionSpecRequest, SkillEncryptionSpec>newBuilder()
              .setFullMethodName(
                  "google.cloud.agentregistry.v1.AgentRegistry/GetSkillEncryptionSpec")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSkillEncryptionSpecRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/skillEncryptionSpec}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSkillEncryptionSpecRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSkillEncryptionSpecRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SkillEncryptionSpec>newBuilder()
                      .setDefaultInstance(SkillEncryptionSpec.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSkillEncryptionSpecRequest, Operation>
      updateSkillEncryptionSpecMethodDescriptor =
          ApiMethodDescriptor.<UpdateSkillEncryptionSpecRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.agentregistry.v1.AgentRegistry/UpdateSkillEncryptionSpec")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSkillEncryptionSpecRequest>newBuilder()
                      .setPath(
                          "/v1/{skillEncryptionSpec.name=projects/*/locations/*/skillEncryptionSpec}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSkillEncryptionSpecRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "skillEncryptionSpec.name",
                                request.getSkillEncryptionSpec().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSkillEncryptionSpecRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "skillEncryptionSpec",
                                      request.getSkillEncryptionSpec(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateSkillEncryptionSpecRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListAgentsRequest, ListAgentsResponse> listAgentsCallable;
  private final UnaryCallable<ListAgentsRequest, ListAgentsPagedResponse> listAgentsPagedCallable;
  private final UnaryCallable<SearchAgentsRequest, SearchAgentsResponse> searchAgentsCallable;
  private final UnaryCallable<SearchAgentsRequest, SearchAgentsPagedResponse>
      searchAgentsPagedCallable;
  private final UnaryCallable<GetAgentRequest, Agent> getAgentCallable;
  private final UnaryCallable<ListEndpointsRequest, ListEndpointsResponse> listEndpointsCallable;
  private final UnaryCallable<ListEndpointsRequest, ListEndpointsPagedResponse>
      listEndpointsPagedCallable;
  private final UnaryCallable<GetEndpointRequest, Endpoint> getEndpointCallable;
  private final UnaryCallable<ListMcpServersRequest, ListMcpServersResponse> listMcpServersCallable;
  private final UnaryCallable<ListMcpServersRequest, ListMcpServersPagedResponse>
      listMcpServersPagedCallable;
  private final UnaryCallable<SearchMcpServersRequest, SearchMcpServersResponse>
      searchMcpServersCallable;
  private final UnaryCallable<SearchMcpServersRequest, SearchMcpServersPagedResponse>
      searchMcpServersPagedCallable;
  private final UnaryCallable<GetMcpServerRequest, McpServer> getMcpServerCallable;
  private final UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable;
  private final UnaryCallable<ListServicesRequest, ListServicesPagedResponse>
      listServicesPagedCallable;
  private final UnaryCallable<GetServiceRequest, Service> getServiceCallable;
  private final UnaryCallable<CreateServiceRequest, Operation> createServiceCallable;
  private final OperationCallable<CreateServiceRequest, Service, OperationMetadata>
      createServiceOperationCallable;
  private final UnaryCallable<UpdateServiceRequest, Operation> updateServiceCallable;
  private final OperationCallable<UpdateServiceRequest, Service, OperationMetadata>
      updateServiceOperationCallable;
  private final UnaryCallable<DeleteServiceRequest, Operation> deleteServiceCallable;
  private final OperationCallable<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationCallable;
  private final UnaryCallable<ListBindingsRequest, ListBindingsResponse> listBindingsCallable;
  private final UnaryCallable<ListBindingsRequest, ListBindingsPagedResponse>
      listBindingsPagedCallable;
  private final UnaryCallable<GetBindingRequest, Binding> getBindingCallable;
  private final UnaryCallable<CreateBindingRequest, Operation> createBindingCallable;
  private final OperationCallable<CreateBindingRequest, Binding, OperationMetadata>
      createBindingOperationCallable;
  private final UnaryCallable<UpdateBindingRequest, Operation> updateBindingCallable;
  private final OperationCallable<UpdateBindingRequest, Binding, OperationMetadata>
      updateBindingOperationCallable;
  private final UnaryCallable<DeleteBindingRequest, Operation> deleteBindingCallable;
  private final OperationCallable<DeleteBindingRequest, Empty, OperationMetadata>
      deleteBindingOperationCallable;
  private final UnaryCallable<FetchAvailableBindingsRequest, FetchAvailableBindingsResponse>
      fetchAvailableBindingsCallable;
  private final UnaryCallable<FetchAvailableBindingsRequest, FetchAvailableBindingsPagedResponse>
      fetchAvailableBindingsPagedCallable;
  private final UnaryCallable<CreateSkillRequest, Operation> createSkillCallable;
  private final OperationCallable<CreateSkillRequest, Skill, OperationMetadata>
      createSkillOperationCallable;
  private final UnaryCallable<GetSkillRequest, Skill> getSkillCallable;
  private final UnaryCallable<UpdateSkillRequest, Operation> updateSkillCallable;
  private final OperationCallable<UpdateSkillRequest, Skill, OperationMetadata>
      updateSkillOperationCallable;
  private final UnaryCallable<DeleteSkillRequest, Operation> deleteSkillCallable;
  private final OperationCallable<DeleteSkillRequest, Empty, OperationMetadata>
      deleteSkillOperationCallable;
  private final UnaryCallable<ListSkillsRequest, ListSkillsResponse> listSkillsCallable;
  private final UnaryCallable<ListSkillsRequest, ListSkillsPagedResponse> listSkillsPagedCallable;
  private final UnaryCallable<SearchSkillsRequest, SearchSkillsResponse> searchSkillsCallable;
  private final UnaryCallable<SearchSkillsRequest, SearchSkillsPagedResponse>
      searchSkillsPagedCallable;
  private final UnaryCallable<CreateSkillRevisionRequest, Operation> createSkillRevisionCallable;
  private final OperationCallable<CreateSkillRevisionRequest, SkillRevision, OperationMetadata>
      createSkillRevisionOperationCallable;
  private final UnaryCallable<GetSkillRevisionRequest, SkillRevision> getSkillRevisionCallable;
  private final UnaryCallable<DeleteSkillRevisionRequest, Operation> deleteSkillRevisionCallable;
  private final OperationCallable<DeleteSkillRevisionRequest, Empty, OperationMetadata>
      deleteSkillRevisionOperationCallable;
  private final UnaryCallable<ListSkillRevisionsRequest, ListSkillRevisionsResponse>
      listSkillRevisionsCallable;
  private final UnaryCallable<ListSkillRevisionsRequest, ListSkillRevisionsPagedResponse>
      listSkillRevisionsPagedCallable;
  private final UnaryCallable<GetPublisherRequest, Publisher> getPublisherCallable;
  private final UnaryCallable<ListPublishersRequest, ListPublishersResponse> listPublishersCallable;
  private final UnaryCallable<ListPublishersRequest, ListPublishersPagedResponse>
      listPublishersPagedCallable;
  private final UnaryCallable<GetAiApplicationRequest, AiApplication> getAiApplicationCallable;
  private final UnaryCallable<ListAiApplicationsRequest, ListAiApplicationsResponse>
      listAiApplicationsCallable;
  private final UnaryCallable<ListAiApplicationsRequest, ListAiApplicationsPagedResponse>
      listAiApplicationsPagedCallable;
  private final UnaryCallable<GetAiApplicationAgentRequest, Agent> getAiApplicationAgentCallable;
  private final UnaryCallable<ListAiApplicationAgentsRequest, ListAiApplicationAgentsResponse>
      listAiApplicationAgentsCallable;
  private final UnaryCallable<ListAiApplicationAgentsRequest, ListAiApplicationAgentsPagedResponse>
      listAiApplicationAgentsPagedCallable;
  private final UnaryCallable<GetAiApplicationMcpServerRequest, McpServer>
      getAiApplicationMcpServerCallable;
  private final UnaryCallable<
          ListAiApplicationMcpServersRequest, ListAiApplicationMcpServersResponse>
      listAiApplicationMcpServersCallable;
  private final UnaryCallable<
          ListAiApplicationMcpServersRequest, ListAiApplicationMcpServersPagedResponse>
      listAiApplicationMcpServersPagedCallable;
  private final UnaryCallable<GetFindingRequest, Finding> getFindingCallable;
  private final UnaryCallable<ListFindingsRequest, ListFindingsResponse> listFindingsCallable;
  private final UnaryCallable<ListFindingsRequest, ListFindingsPagedResponse>
      listFindingsPagedCallable;
  private final UnaryCallable<GetAiApplicationEndpointRequest, Endpoint>
      getAiApplicationEndpointCallable;
  private final UnaryCallable<ListAiApplicationEndpointsRequest, ListAiApplicationEndpointsResponse>
      listAiApplicationEndpointsCallable;
  private final UnaryCallable<
          ListAiApplicationEndpointsRequest, ListAiApplicationEndpointsPagedResponse>
      listAiApplicationEndpointsPagedCallable;
  private final UnaryCallable<GetSkillEncryptionSpecRequest, SkillEncryptionSpec>
      getSkillEncryptionSpecCallable;
  private final UnaryCallable<UpdateSkillEncryptionSpecRequest, Operation>
      updateSkillEncryptionSpecCallable;
  private final OperationCallable<
          UpdateSkillEncryptionSpecRequest, SkillEncryptionSpec, OperationMetadata>
      updateSkillEncryptionSpecOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAgentRegistryStub create(AgentRegistryStubSettings settings)
      throws IOException {
    return new HttpJsonAgentRegistryStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAgentRegistryStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAgentRegistryStub(
        AgentRegistryStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAgentRegistryStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAgentRegistryStub(
        AgentRegistryStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAgentRegistryStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAgentRegistryStub(
      AgentRegistryStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAgentRegistryCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAgentRegistryStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAgentRegistryStub(
      AgentRegistryStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.CancelOperation",
                    HttpRule.newBuilder()
                        .setPost("/v1/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<ListAgentsRequest, ListAgentsResponse> listAgentsTransportSettings =
        HttpJsonCallSettings.<ListAgentsRequest, ListAgentsResponse>newBuilder()
            .setMethodDescriptor(listAgentsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<SearchAgentsRequest, SearchAgentsResponse> searchAgentsTransportSettings =
        HttpJsonCallSettings.<SearchAgentsRequest, SearchAgentsResponse>newBuilder()
            .setMethodDescriptor(searchAgentsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<GetAgentRequest, Agent> getAgentTransportSettings =
        HttpJsonCallSettings.<GetAgentRequest, Agent>newBuilder()
            .setMethodDescriptor(getAgentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListEndpointsRequest, ListEndpointsResponse>
        listEndpointsTransportSettings =
            HttpJsonCallSettings.<ListEndpointsRequest, ListEndpointsResponse>newBuilder()
                .setMethodDescriptor(listEndpointsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetEndpointRequest, Endpoint> getEndpointTransportSettings =
        HttpJsonCallSettings.<GetEndpointRequest, Endpoint>newBuilder()
            .setMethodDescriptor(getEndpointMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListMcpServersRequest, ListMcpServersResponse>
        listMcpServersTransportSettings =
            HttpJsonCallSettings.<ListMcpServersRequest, ListMcpServersResponse>newBuilder()
                .setMethodDescriptor(listMcpServersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<SearchMcpServersRequest, SearchMcpServersResponse>
        searchMcpServersTransportSettings =
            HttpJsonCallSettings.<SearchMcpServersRequest, SearchMcpServersResponse>newBuilder()
                .setMethodDescriptor(searchMcpServersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetMcpServerRequest, McpServer> getMcpServerTransportSettings =
        HttpJsonCallSettings.<GetMcpServerRequest, McpServer>newBuilder()
            .setMethodDescriptor(getMcpServerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListServicesRequest, ListServicesResponse> listServicesTransportSettings =
        HttpJsonCallSettings.<ListServicesRequest, ListServicesResponse>newBuilder()
            .setMethodDescriptor(listServicesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<GetServiceRequest, Service> getServiceTransportSettings =
        HttpJsonCallSettings.<GetServiceRequest, Service>newBuilder()
            .setMethodDescriptor(getServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<CreateServiceRequest, Operation> createServiceTransportSettings =
        HttpJsonCallSettings.<CreateServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(createServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<UpdateServiceRequest, Operation> updateServiceTransportSettings =
        HttpJsonCallSettings.<UpdateServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("service.name", String.valueOf(request.getService().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteServiceRequest, Operation> deleteServiceTransportSettings =
        HttpJsonCallSettings.<DeleteServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListBindingsRequest, ListBindingsResponse> listBindingsTransportSettings =
        HttpJsonCallSettings.<ListBindingsRequest, ListBindingsResponse>newBuilder()
            .setMethodDescriptor(listBindingsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<GetBindingRequest, Binding> getBindingTransportSettings =
        HttpJsonCallSettings.<GetBindingRequest, Binding>newBuilder()
            .setMethodDescriptor(getBindingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<CreateBindingRequest, Operation> createBindingTransportSettings =
        HttpJsonCallSettings.<CreateBindingRequest, Operation>newBuilder()
            .setMethodDescriptor(createBindingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<UpdateBindingRequest, Operation> updateBindingTransportSettings =
        HttpJsonCallSettings.<UpdateBindingRequest, Operation>newBuilder()
            .setMethodDescriptor(updateBindingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("binding.name", String.valueOf(request.getBinding().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteBindingRequest, Operation> deleteBindingTransportSettings =
        HttpJsonCallSettings.<DeleteBindingRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteBindingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<FetchAvailableBindingsRequest, FetchAvailableBindingsResponse>
        fetchAvailableBindingsTransportSettings =
            HttpJsonCallSettings
                .<FetchAvailableBindingsRequest, FetchAvailableBindingsResponse>newBuilder()
                .setMethodDescriptor(fetchAvailableBindingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateSkillRequest, Operation> createSkillTransportSettings =
        HttpJsonCallSettings.<CreateSkillRequest, Operation>newBuilder()
            .setMethodDescriptor(createSkillMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<GetSkillRequest, Skill> getSkillTransportSettings =
        HttpJsonCallSettings.<GetSkillRequest, Skill>newBuilder()
            .setMethodDescriptor(getSkillMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<UpdateSkillRequest, Operation> updateSkillTransportSettings =
        HttpJsonCallSettings.<UpdateSkillRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSkillMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("skill.name", String.valueOf(request.getSkill().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteSkillRequest, Operation> deleteSkillTransportSettings =
        HttpJsonCallSettings.<DeleteSkillRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSkillMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListSkillsRequest, ListSkillsResponse> listSkillsTransportSettings =
        HttpJsonCallSettings.<ListSkillsRequest, ListSkillsResponse>newBuilder()
            .setMethodDescriptor(listSkillsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<SearchSkillsRequest, SearchSkillsResponse> searchSkillsTransportSettings =
        HttpJsonCallSettings.<SearchSkillsRequest, SearchSkillsResponse>newBuilder()
            .setMethodDescriptor(searchSkillsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<CreateSkillRevisionRequest, Operation>
        createSkillRevisionTransportSettings =
            HttpJsonCallSettings.<CreateSkillRevisionRequest, Operation>newBuilder()
                .setMethodDescriptor(createSkillRevisionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetSkillRevisionRequest, SkillRevision> getSkillRevisionTransportSettings =
        HttpJsonCallSettings.<GetSkillRevisionRequest, SkillRevision>newBuilder()
            .setMethodDescriptor(getSkillRevisionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<DeleteSkillRevisionRequest, Operation>
        deleteSkillRevisionTransportSettings =
            HttpJsonCallSettings.<DeleteSkillRevisionRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteSkillRevisionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListSkillRevisionsRequest, ListSkillRevisionsResponse>
        listSkillRevisionsTransportSettings =
            HttpJsonCallSettings.<ListSkillRevisionsRequest, ListSkillRevisionsResponse>newBuilder()
                .setMethodDescriptor(listSkillRevisionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetPublisherRequest, Publisher> getPublisherTransportSettings =
        HttpJsonCallSettings.<GetPublisherRequest, Publisher>newBuilder()
            .setMethodDescriptor(getPublisherMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListPublishersRequest, ListPublishersResponse>
        listPublishersTransportSettings =
            HttpJsonCallSettings.<ListPublishersRequest, ListPublishersResponse>newBuilder()
                .setMethodDescriptor(listPublishersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetAiApplicationRequest, AiApplication> getAiApplicationTransportSettings =
        HttpJsonCallSettings.<GetAiApplicationRequest, AiApplication>newBuilder()
            .setMethodDescriptor(getAiApplicationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListAiApplicationsRequest, ListAiApplicationsResponse>
        listAiApplicationsTransportSettings =
            HttpJsonCallSettings.<ListAiApplicationsRequest, ListAiApplicationsResponse>newBuilder()
                .setMethodDescriptor(listAiApplicationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetAiApplicationAgentRequest, Agent>
        getAiApplicationAgentTransportSettings =
            HttpJsonCallSettings.<GetAiApplicationAgentRequest, Agent>newBuilder()
                .setMethodDescriptor(getAiApplicationAgentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListAiApplicationAgentsRequest, ListAiApplicationAgentsResponse>
        listAiApplicationAgentsTransportSettings =
            HttpJsonCallSettings
                .<ListAiApplicationAgentsRequest, ListAiApplicationAgentsResponse>newBuilder()
                .setMethodDescriptor(listAiApplicationAgentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetAiApplicationMcpServerRequest, McpServer>
        getAiApplicationMcpServerTransportSettings =
            HttpJsonCallSettings.<GetAiApplicationMcpServerRequest, McpServer>newBuilder()
                .setMethodDescriptor(getAiApplicationMcpServerMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListAiApplicationMcpServersRequest, ListAiApplicationMcpServersResponse>
        listAiApplicationMcpServersTransportSettings =
            HttpJsonCallSettings
                .<ListAiApplicationMcpServersRequest, ListAiApplicationMcpServersResponse>
                    newBuilder()
                .setMethodDescriptor(listAiApplicationMcpServersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetFindingRequest, Finding> getFindingTransportSettings =
        HttpJsonCallSettings.<GetFindingRequest, Finding>newBuilder()
            .setMethodDescriptor(getFindingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListFindingsRequest, ListFindingsResponse> listFindingsTransportSettings =
        HttpJsonCallSettings.<ListFindingsRequest, ListFindingsResponse>newBuilder()
            .setMethodDescriptor(listFindingsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<GetAiApplicationEndpointRequest, Endpoint>
        getAiApplicationEndpointTransportSettings =
            HttpJsonCallSettings.<GetAiApplicationEndpointRequest, Endpoint>newBuilder()
                .setMethodDescriptor(getAiApplicationEndpointMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListAiApplicationEndpointsRequest, ListAiApplicationEndpointsResponse>
        listAiApplicationEndpointsTransportSettings =
            HttpJsonCallSettings
                .<ListAiApplicationEndpointsRequest, ListAiApplicationEndpointsResponse>newBuilder()
                .setMethodDescriptor(listAiApplicationEndpointsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetSkillEncryptionSpecRequest, SkillEncryptionSpec>
        getSkillEncryptionSpecTransportSettings =
            HttpJsonCallSettings.<GetSkillEncryptionSpecRequest, SkillEncryptionSpec>newBuilder()
                .setMethodDescriptor(getSkillEncryptionSpecMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<UpdateSkillEncryptionSpecRequest, Operation>
        updateSkillEncryptionSpecTransportSettings =
            HttpJsonCallSettings.<UpdateSkillEncryptionSpecRequest, Operation>newBuilder()
                .setMethodDescriptor(updateSkillEncryptionSpecMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "skill_encryption_spec.name",
                          String.valueOf(request.getSkillEncryptionSpec().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listAgentsCallable =
        callableFactory.createUnaryCallable(
            listAgentsTransportSettings, settings.listAgentsSettings(), clientContext);
    this.listAgentsPagedCallable =
        callableFactory.createPagedCallable(
            listAgentsTransportSettings, settings.listAgentsSettings(), clientContext);
    this.searchAgentsCallable =
        callableFactory.createUnaryCallable(
            searchAgentsTransportSettings, settings.searchAgentsSettings(), clientContext);
    this.searchAgentsPagedCallable =
        callableFactory.createPagedCallable(
            searchAgentsTransportSettings, settings.searchAgentsSettings(), clientContext);
    this.getAgentCallable =
        callableFactory.createUnaryCallable(
            getAgentTransportSettings, settings.getAgentSettings(), clientContext);
    this.listEndpointsCallable =
        callableFactory.createUnaryCallable(
            listEndpointsTransportSettings, settings.listEndpointsSettings(), clientContext);
    this.listEndpointsPagedCallable =
        callableFactory.createPagedCallable(
            listEndpointsTransportSettings, settings.listEndpointsSettings(), clientContext);
    this.getEndpointCallable =
        callableFactory.createUnaryCallable(
            getEndpointTransportSettings, settings.getEndpointSettings(), clientContext);
    this.listMcpServersCallable =
        callableFactory.createUnaryCallable(
            listMcpServersTransportSettings, settings.listMcpServersSettings(), clientContext);
    this.listMcpServersPagedCallable =
        callableFactory.createPagedCallable(
            listMcpServersTransportSettings, settings.listMcpServersSettings(), clientContext);
    this.searchMcpServersCallable =
        callableFactory.createUnaryCallable(
            searchMcpServersTransportSettings, settings.searchMcpServersSettings(), clientContext);
    this.searchMcpServersPagedCallable =
        callableFactory.createPagedCallable(
            searchMcpServersTransportSettings, settings.searchMcpServersSettings(), clientContext);
    this.getMcpServerCallable =
        callableFactory.createUnaryCallable(
            getMcpServerTransportSettings, settings.getMcpServerSettings(), clientContext);
    this.listServicesCallable =
        callableFactory.createUnaryCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.listServicesPagedCallable =
        callableFactory.createPagedCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.getServiceCallable =
        callableFactory.createUnaryCallable(
            getServiceTransportSettings, settings.getServiceSettings(), clientContext);
    this.createServiceCallable =
        callableFactory.createUnaryCallable(
            createServiceTransportSettings, settings.createServiceSettings(), clientContext);
    this.createServiceOperationCallable =
        callableFactory.createOperationCallable(
            createServiceTransportSettings,
            settings.createServiceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateServiceCallable =
        callableFactory.createUnaryCallable(
            updateServiceTransportSettings, settings.updateServiceSettings(), clientContext);
    this.updateServiceOperationCallable =
        callableFactory.createOperationCallable(
            updateServiceTransportSettings,
            settings.updateServiceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteServiceCallable =
        callableFactory.createUnaryCallable(
            deleteServiceTransportSettings, settings.deleteServiceSettings(), clientContext);
    this.deleteServiceOperationCallable =
        callableFactory.createOperationCallable(
            deleteServiceTransportSettings,
            settings.deleteServiceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listBindingsCallable =
        callableFactory.createUnaryCallable(
            listBindingsTransportSettings, settings.listBindingsSettings(), clientContext);
    this.listBindingsPagedCallable =
        callableFactory.createPagedCallable(
            listBindingsTransportSettings, settings.listBindingsSettings(), clientContext);
    this.getBindingCallable =
        callableFactory.createUnaryCallable(
            getBindingTransportSettings, settings.getBindingSettings(), clientContext);
    this.createBindingCallable =
        callableFactory.createUnaryCallable(
            createBindingTransportSettings, settings.createBindingSettings(), clientContext);
    this.createBindingOperationCallable =
        callableFactory.createOperationCallable(
            createBindingTransportSettings,
            settings.createBindingOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateBindingCallable =
        callableFactory.createUnaryCallable(
            updateBindingTransportSettings, settings.updateBindingSettings(), clientContext);
    this.updateBindingOperationCallable =
        callableFactory.createOperationCallable(
            updateBindingTransportSettings,
            settings.updateBindingOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteBindingCallable =
        callableFactory.createUnaryCallable(
            deleteBindingTransportSettings, settings.deleteBindingSettings(), clientContext);
    this.deleteBindingOperationCallable =
        callableFactory.createOperationCallable(
            deleteBindingTransportSettings,
            settings.deleteBindingOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.fetchAvailableBindingsCallable =
        callableFactory.createUnaryCallable(
            fetchAvailableBindingsTransportSettings,
            settings.fetchAvailableBindingsSettings(),
            clientContext);
    this.fetchAvailableBindingsPagedCallable =
        callableFactory.createPagedCallable(
            fetchAvailableBindingsTransportSettings,
            settings.fetchAvailableBindingsSettings(),
            clientContext);
    this.createSkillCallable =
        callableFactory.createUnaryCallable(
            createSkillTransportSettings, settings.createSkillSettings(), clientContext);
    this.createSkillOperationCallable =
        callableFactory.createOperationCallable(
            createSkillTransportSettings,
            settings.createSkillOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getSkillCallable =
        callableFactory.createUnaryCallable(
            getSkillTransportSettings, settings.getSkillSettings(), clientContext);
    this.updateSkillCallable =
        callableFactory.createUnaryCallable(
            updateSkillTransportSettings, settings.updateSkillSettings(), clientContext);
    this.updateSkillOperationCallable =
        callableFactory.createOperationCallable(
            updateSkillTransportSettings,
            settings.updateSkillOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteSkillCallable =
        callableFactory.createUnaryCallable(
            deleteSkillTransportSettings, settings.deleteSkillSettings(), clientContext);
    this.deleteSkillOperationCallable =
        callableFactory.createOperationCallable(
            deleteSkillTransportSettings,
            settings.deleteSkillOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listSkillsCallable =
        callableFactory.createUnaryCallable(
            listSkillsTransportSettings, settings.listSkillsSettings(), clientContext);
    this.listSkillsPagedCallable =
        callableFactory.createPagedCallable(
            listSkillsTransportSettings, settings.listSkillsSettings(), clientContext);
    this.searchSkillsCallable =
        callableFactory.createUnaryCallable(
            searchSkillsTransportSettings, settings.searchSkillsSettings(), clientContext);
    this.searchSkillsPagedCallable =
        callableFactory.createPagedCallable(
            searchSkillsTransportSettings, settings.searchSkillsSettings(), clientContext);
    this.createSkillRevisionCallable =
        callableFactory.createUnaryCallable(
            createSkillRevisionTransportSettings,
            settings.createSkillRevisionSettings(),
            clientContext);
    this.createSkillRevisionOperationCallable =
        callableFactory.createOperationCallable(
            createSkillRevisionTransportSettings,
            settings.createSkillRevisionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getSkillRevisionCallable =
        callableFactory.createUnaryCallable(
            getSkillRevisionTransportSettings, settings.getSkillRevisionSettings(), clientContext);
    this.deleteSkillRevisionCallable =
        callableFactory.createUnaryCallable(
            deleteSkillRevisionTransportSettings,
            settings.deleteSkillRevisionSettings(),
            clientContext);
    this.deleteSkillRevisionOperationCallable =
        callableFactory.createOperationCallable(
            deleteSkillRevisionTransportSettings,
            settings.deleteSkillRevisionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listSkillRevisionsCallable =
        callableFactory.createUnaryCallable(
            listSkillRevisionsTransportSettings,
            settings.listSkillRevisionsSettings(),
            clientContext);
    this.listSkillRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listSkillRevisionsTransportSettings,
            settings.listSkillRevisionsSettings(),
            clientContext);
    this.getPublisherCallable =
        callableFactory.createUnaryCallable(
            getPublisherTransportSettings, settings.getPublisherSettings(), clientContext);
    this.listPublishersCallable =
        callableFactory.createUnaryCallable(
            listPublishersTransportSettings, settings.listPublishersSettings(), clientContext);
    this.listPublishersPagedCallable =
        callableFactory.createPagedCallable(
            listPublishersTransportSettings, settings.listPublishersSettings(), clientContext);
    this.getAiApplicationCallable =
        callableFactory.createUnaryCallable(
            getAiApplicationTransportSettings, settings.getAiApplicationSettings(), clientContext);
    this.listAiApplicationsCallable =
        callableFactory.createUnaryCallable(
            listAiApplicationsTransportSettings,
            settings.listAiApplicationsSettings(),
            clientContext);
    this.listAiApplicationsPagedCallable =
        callableFactory.createPagedCallable(
            listAiApplicationsTransportSettings,
            settings.listAiApplicationsSettings(),
            clientContext);
    this.getAiApplicationAgentCallable =
        callableFactory.createUnaryCallable(
            getAiApplicationAgentTransportSettings,
            settings.getAiApplicationAgentSettings(),
            clientContext);
    this.listAiApplicationAgentsCallable =
        callableFactory.createUnaryCallable(
            listAiApplicationAgentsTransportSettings,
            settings.listAiApplicationAgentsSettings(),
            clientContext);
    this.listAiApplicationAgentsPagedCallable =
        callableFactory.createPagedCallable(
            listAiApplicationAgentsTransportSettings,
            settings.listAiApplicationAgentsSettings(),
            clientContext);
    this.getAiApplicationMcpServerCallable =
        callableFactory.createUnaryCallable(
            getAiApplicationMcpServerTransportSettings,
            settings.getAiApplicationMcpServerSettings(),
            clientContext);
    this.listAiApplicationMcpServersCallable =
        callableFactory.createUnaryCallable(
            listAiApplicationMcpServersTransportSettings,
            settings.listAiApplicationMcpServersSettings(),
            clientContext);
    this.listAiApplicationMcpServersPagedCallable =
        callableFactory.createPagedCallable(
            listAiApplicationMcpServersTransportSettings,
            settings.listAiApplicationMcpServersSettings(),
            clientContext);
    this.getFindingCallable =
        callableFactory.createUnaryCallable(
            getFindingTransportSettings, settings.getFindingSettings(), clientContext);
    this.listFindingsCallable =
        callableFactory.createUnaryCallable(
            listFindingsTransportSettings, settings.listFindingsSettings(), clientContext);
    this.listFindingsPagedCallable =
        callableFactory.createPagedCallable(
            listFindingsTransportSettings, settings.listFindingsSettings(), clientContext);
    this.getAiApplicationEndpointCallable =
        callableFactory.createUnaryCallable(
            getAiApplicationEndpointTransportSettings,
            settings.getAiApplicationEndpointSettings(),
            clientContext);
    this.listAiApplicationEndpointsCallable =
        callableFactory.createUnaryCallable(
            listAiApplicationEndpointsTransportSettings,
            settings.listAiApplicationEndpointsSettings(),
            clientContext);
    this.listAiApplicationEndpointsPagedCallable =
        callableFactory.createPagedCallable(
            listAiApplicationEndpointsTransportSettings,
            settings.listAiApplicationEndpointsSettings(),
            clientContext);
    this.getSkillEncryptionSpecCallable =
        callableFactory.createUnaryCallable(
            getSkillEncryptionSpecTransportSettings,
            settings.getSkillEncryptionSpecSettings(),
            clientContext);
    this.updateSkillEncryptionSpecCallable =
        callableFactory.createUnaryCallable(
            updateSkillEncryptionSpecTransportSettings,
            settings.updateSkillEncryptionSpecSettings(),
            clientContext);
    this.updateSkillEncryptionSpecOperationCallable =
        callableFactory.createOperationCallable(
            updateSkillEncryptionSpecTransportSettings,
            settings.updateSkillEncryptionSpecOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listAgentsMethodDescriptor);
    methodDescriptors.add(searchAgentsMethodDescriptor);
    methodDescriptors.add(getAgentMethodDescriptor);
    methodDescriptors.add(listEndpointsMethodDescriptor);
    methodDescriptors.add(getEndpointMethodDescriptor);
    methodDescriptors.add(listMcpServersMethodDescriptor);
    methodDescriptors.add(searchMcpServersMethodDescriptor);
    methodDescriptors.add(getMcpServerMethodDescriptor);
    methodDescriptors.add(listServicesMethodDescriptor);
    methodDescriptors.add(getServiceMethodDescriptor);
    methodDescriptors.add(createServiceMethodDescriptor);
    methodDescriptors.add(updateServiceMethodDescriptor);
    methodDescriptors.add(deleteServiceMethodDescriptor);
    methodDescriptors.add(listBindingsMethodDescriptor);
    methodDescriptors.add(getBindingMethodDescriptor);
    methodDescriptors.add(createBindingMethodDescriptor);
    methodDescriptors.add(updateBindingMethodDescriptor);
    methodDescriptors.add(deleteBindingMethodDescriptor);
    methodDescriptors.add(fetchAvailableBindingsMethodDescriptor);
    methodDescriptors.add(createSkillMethodDescriptor);
    methodDescriptors.add(getSkillMethodDescriptor);
    methodDescriptors.add(updateSkillMethodDescriptor);
    methodDescriptors.add(deleteSkillMethodDescriptor);
    methodDescriptors.add(listSkillsMethodDescriptor);
    methodDescriptors.add(searchSkillsMethodDescriptor);
    methodDescriptors.add(createSkillRevisionMethodDescriptor);
    methodDescriptors.add(getSkillRevisionMethodDescriptor);
    methodDescriptors.add(deleteSkillRevisionMethodDescriptor);
    methodDescriptors.add(listSkillRevisionsMethodDescriptor);
    methodDescriptors.add(getPublisherMethodDescriptor);
    methodDescriptors.add(listPublishersMethodDescriptor);
    methodDescriptors.add(getAiApplicationMethodDescriptor);
    methodDescriptors.add(listAiApplicationsMethodDescriptor);
    methodDescriptors.add(getAiApplicationAgentMethodDescriptor);
    methodDescriptors.add(listAiApplicationAgentsMethodDescriptor);
    methodDescriptors.add(getAiApplicationMcpServerMethodDescriptor);
    methodDescriptors.add(listAiApplicationMcpServersMethodDescriptor);
    methodDescriptors.add(getFindingMethodDescriptor);
    methodDescriptors.add(listFindingsMethodDescriptor);
    methodDescriptors.add(getAiApplicationEndpointMethodDescriptor);
    methodDescriptors.add(listAiApplicationEndpointsMethodDescriptor);
    methodDescriptors.add(getSkillEncryptionSpecMethodDescriptor);
    methodDescriptors.add(updateSkillEncryptionSpecMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListAgentsRequest, ListAgentsResponse> listAgentsCallable() {
    return listAgentsCallable;
  }

  @Override
  public UnaryCallable<ListAgentsRequest, ListAgentsPagedResponse> listAgentsPagedCallable() {
    return listAgentsPagedCallable;
  }

  @Override
  public UnaryCallable<SearchAgentsRequest, SearchAgentsResponse> searchAgentsCallable() {
    return searchAgentsCallable;
  }

  @Override
  public UnaryCallable<SearchAgentsRequest, SearchAgentsPagedResponse> searchAgentsPagedCallable() {
    return searchAgentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetAgentRequest, Agent> getAgentCallable() {
    return getAgentCallable;
  }

  @Override
  public UnaryCallable<ListEndpointsRequest, ListEndpointsResponse> listEndpointsCallable() {
    return listEndpointsCallable;
  }

  @Override
  public UnaryCallable<ListEndpointsRequest, ListEndpointsPagedResponse>
      listEndpointsPagedCallable() {
    return listEndpointsPagedCallable;
  }

  @Override
  public UnaryCallable<GetEndpointRequest, Endpoint> getEndpointCallable() {
    return getEndpointCallable;
  }

  @Override
  public UnaryCallable<ListMcpServersRequest, ListMcpServersResponse> listMcpServersCallable() {
    return listMcpServersCallable;
  }

  @Override
  public UnaryCallable<ListMcpServersRequest, ListMcpServersPagedResponse>
      listMcpServersPagedCallable() {
    return listMcpServersPagedCallable;
  }

  @Override
  public UnaryCallable<SearchMcpServersRequest, SearchMcpServersResponse>
      searchMcpServersCallable() {
    return searchMcpServersCallable;
  }

  @Override
  public UnaryCallable<SearchMcpServersRequest, SearchMcpServersPagedResponse>
      searchMcpServersPagedCallable() {
    return searchMcpServersPagedCallable;
  }

  @Override
  public UnaryCallable<GetMcpServerRequest, McpServer> getMcpServerCallable() {
    return getMcpServerCallable;
  }

  @Override
  public UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable() {
    return listServicesCallable;
  }

  @Override
  public UnaryCallable<ListServicesRequest, ListServicesPagedResponse> listServicesPagedCallable() {
    return listServicesPagedCallable;
  }

  @Override
  public UnaryCallable<GetServiceRequest, Service> getServiceCallable() {
    return getServiceCallable;
  }

  @Override
  public UnaryCallable<CreateServiceRequest, Operation> createServiceCallable() {
    return createServiceCallable;
  }

  @Override
  public OperationCallable<CreateServiceRequest, Service, OperationMetadata>
      createServiceOperationCallable() {
    return createServiceOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateServiceRequest, Operation> updateServiceCallable() {
    return updateServiceCallable;
  }

  @Override
  public OperationCallable<UpdateServiceRequest, Service, OperationMetadata>
      updateServiceOperationCallable() {
    return updateServiceOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteServiceRequest, Operation> deleteServiceCallable() {
    return deleteServiceCallable;
  }

  @Override
  public OperationCallable<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationCallable() {
    return deleteServiceOperationCallable;
  }

  @Override
  public UnaryCallable<ListBindingsRequest, ListBindingsResponse> listBindingsCallable() {
    return listBindingsCallable;
  }

  @Override
  public UnaryCallable<ListBindingsRequest, ListBindingsPagedResponse> listBindingsPagedCallable() {
    return listBindingsPagedCallable;
  }

  @Override
  public UnaryCallable<GetBindingRequest, Binding> getBindingCallable() {
    return getBindingCallable;
  }

  @Override
  public UnaryCallable<CreateBindingRequest, Operation> createBindingCallable() {
    return createBindingCallable;
  }

  @Override
  public OperationCallable<CreateBindingRequest, Binding, OperationMetadata>
      createBindingOperationCallable() {
    return createBindingOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateBindingRequest, Operation> updateBindingCallable() {
    return updateBindingCallable;
  }

  @Override
  public OperationCallable<UpdateBindingRequest, Binding, OperationMetadata>
      updateBindingOperationCallable() {
    return updateBindingOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteBindingRequest, Operation> deleteBindingCallable() {
    return deleteBindingCallable;
  }

  @Override
  public OperationCallable<DeleteBindingRequest, Empty, OperationMetadata>
      deleteBindingOperationCallable() {
    return deleteBindingOperationCallable;
  }

  @Override
  public UnaryCallable<FetchAvailableBindingsRequest, FetchAvailableBindingsResponse>
      fetchAvailableBindingsCallable() {
    return fetchAvailableBindingsCallable;
  }

  @Override
  public UnaryCallable<FetchAvailableBindingsRequest, FetchAvailableBindingsPagedResponse>
      fetchAvailableBindingsPagedCallable() {
    return fetchAvailableBindingsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateSkillRequest, Operation> createSkillCallable() {
    return createSkillCallable;
  }

  @Override
  public OperationCallable<CreateSkillRequest, Skill, OperationMetadata>
      createSkillOperationCallable() {
    return createSkillOperationCallable;
  }

  @Override
  public UnaryCallable<GetSkillRequest, Skill> getSkillCallable() {
    return getSkillCallable;
  }

  @Override
  public UnaryCallable<UpdateSkillRequest, Operation> updateSkillCallable() {
    return updateSkillCallable;
  }

  @Override
  public OperationCallable<UpdateSkillRequest, Skill, OperationMetadata>
      updateSkillOperationCallable() {
    return updateSkillOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteSkillRequest, Operation> deleteSkillCallable() {
    return deleteSkillCallable;
  }

  @Override
  public OperationCallable<DeleteSkillRequest, Empty, OperationMetadata>
      deleteSkillOperationCallable() {
    return deleteSkillOperationCallable;
  }

  @Override
  public UnaryCallable<ListSkillsRequest, ListSkillsResponse> listSkillsCallable() {
    return listSkillsCallable;
  }

  @Override
  public UnaryCallable<ListSkillsRequest, ListSkillsPagedResponse> listSkillsPagedCallable() {
    return listSkillsPagedCallable;
  }

  @Override
  public UnaryCallable<SearchSkillsRequest, SearchSkillsResponse> searchSkillsCallable() {
    return searchSkillsCallable;
  }

  @Override
  public UnaryCallable<SearchSkillsRequest, SearchSkillsPagedResponse> searchSkillsPagedCallable() {
    return searchSkillsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateSkillRevisionRequest, Operation> createSkillRevisionCallable() {
    return createSkillRevisionCallable;
  }

  @Override
  public OperationCallable<CreateSkillRevisionRequest, SkillRevision, OperationMetadata>
      createSkillRevisionOperationCallable() {
    return createSkillRevisionOperationCallable;
  }

  @Override
  public UnaryCallable<GetSkillRevisionRequest, SkillRevision> getSkillRevisionCallable() {
    return getSkillRevisionCallable;
  }

  @Override
  public UnaryCallable<DeleteSkillRevisionRequest, Operation> deleteSkillRevisionCallable() {
    return deleteSkillRevisionCallable;
  }

  @Override
  public OperationCallable<DeleteSkillRevisionRequest, Empty, OperationMetadata>
      deleteSkillRevisionOperationCallable() {
    return deleteSkillRevisionOperationCallable;
  }

  @Override
  public UnaryCallable<ListSkillRevisionsRequest, ListSkillRevisionsResponse>
      listSkillRevisionsCallable() {
    return listSkillRevisionsCallable;
  }

  @Override
  public UnaryCallable<ListSkillRevisionsRequest, ListSkillRevisionsPagedResponse>
      listSkillRevisionsPagedCallable() {
    return listSkillRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetPublisherRequest, Publisher> getPublisherCallable() {
    return getPublisherCallable;
  }

  @Override
  public UnaryCallable<ListPublishersRequest, ListPublishersResponse> listPublishersCallable() {
    return listPublishersCallable;
  }

  @Override
  public UnaryCallable<ListPublishersRequest, ListPublishersPagedResponse>
      listPublishersPagedCallable() {
    return listPublishersPagedCallable;
  }

  @Override
  public UnaryCallable<GetAiApplicationRequest, AiApplication> getAiApplicationCallable() {
    return getAiApplicationCallable;
  }

  @Override
  public UnaryCallable<ListAiApplicationsRequest, ListAiApplicationsResponse>
      listAiApplicationsCallable() {
    return listAiApplicationsCallable;
  }

  @Override
  public UnaryCallable<ListAiApplicationsRequest, ListAiApplicationsPagedResponse>
      listAiApplicationsPagedCallable() {
    return listAiApplicationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetAiApplicationAgentRequest, Agent> getAiApplicationAgentCallable() {
    return getAiApplicationAgentCallable;
  }

  @Override
  public UnaryCallable<ListAiApplicationAgentsRequest, ListAiApplicationAgentsResponse>
      listAiApplicationAgentsCallable() {
    return listAiApplicationAgentsCallable;
  }

  @Override
  public UnaryCallable<ListAiApplicationAgentsRequest, ListAiApplicationAgentsPagedResponse>
      listAiApplicationAgentsPagedCallable() {
    return listAiApplicationAgentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetAiApplicationMcpServerRequest, McpServer>
      getAiApplicationMcpServerCallable() {
    return getAiApplicationMcpServerCallable;
  }

  @Override
  public UnaryCallable<ListAiApplicationMcpServersRequest, ListAiApplicationMcpServersResponse>
      listAiApplicationMcpServersCallable() {
    return listAiApplicationMcpServersCallable;
  }

  @Override
  public UnaryCallable<ListAiApplicationMcpServersRequest, ListAiApplicationMcpServersPagedResponse>
      listAiApplicationMcpServersPagedCallable() {
    return listAiApplicationMcpServersPagedCallable;
  }

  @Override
  public UnaryCallable<GetFindingRequest, Finding> getFindingCallable() {
    return getFindingCallable;
  }

  @Override
  public UnaryCallable<ListFindingsRequest, ListFindingsResponse> listFindingsCallable() {
    return listFindingsCallable;
  }

  @Override
  public UnaryCallable<ListFindingsRequest, ListFindingsPagedResponse> listFindingsPagedCallable() {
    return listFindingsPagedCallable;
  }

  @Override
  public UnaryCallable<GetAiApplicationEndpointRequest, Endpoint>
      getAiApplicationEndpointCallable() {
    return getAiApplicationEndpointCallable;
  }

  @Override
  public UnaryCallable<ListAiApplicationEndpointsRequest, ListAiApplicationEndpointsResponse>
      listAiApplicationEndpointsCallable() {
    return listAiApplicationEndpointsCallable;
  }

  @Override
  public UnaryCallable<ListAiApplicationEndpointsRequest, ListAiApplicationEndpointsPagedResponse>
      listAiApplicationEndpointsPagedCallable() {
    return listAiApplicationEndpointsPagedCallable;
  }

  @Override
  public UnaryCallable<GetSkillEncryptionSpecRequest, SkillEncryptionSpec>
      getSkillEncryptionSpecCallable() {
    return getSkillEncryptionSpecCallable;
  }

  @Override
  public UnaryCallable<UpdateSkillEncryptionSpecRequest, Operation>
      updateSkillEncryptionSpecCallable() {
    return updateSkillEncryptionSpecCallable;
  }

  @Override
  public OperationCallable<UpdateSkillEncryptionSpecRequest, SkillEncryptionSpec, OperationMetadata>
      updateSkillEncryptionSpecOperationCallable() {
    return updateSkillEncryptionSpecOperationCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
