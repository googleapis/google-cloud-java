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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the AgentService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonAgentServiceStub extends AgentServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(BatchDeleteConversationsResponse.getDescriptor())
          .add(ExportAppResponse.getDescriptor())
          .add(App.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(ImportAppResponse.getDescriptor())
          .add(RestoreAppVersionResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListAppsRequest, ListAppsResponse>
      listAppsMethodDescriptor =
          ApiMethodDescriptor.<ListAppsRequest, ListAppsResponse>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/ListApps")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAppsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/apps",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAppsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAppsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListAppsResponse>newBuilder()
                      .setDefaultInstance(ListAppsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAppRequest, App> getAppMethodDescriptor =
      ApiMethodDescriptor.<GetAppRequest, App>newBuilder()
          .setFullMethodName("google.cloud.ces.v1.AgentService/GetApp")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetAppRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/apps/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetAppRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetAppRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<App>newBuilder()
                  .setDefaultInstance(App.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateAppRequest, Operation> createAppMethodDescriptor =
      ApiMethodDescriptor.<CreateAppRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.ces.v1.AgentService/CreateApp")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateAppRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=projects/*/locations/*}/apps",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateAppRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateAppRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "appId", request.getAppId());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request -> ProtoRestSerializer.create().toBody("app", request.getApp(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (CreateAppRequest request, Operation response) ->
                  HttpJsonOperationSnapshot.create(response))
          .build();

  private static final ApiMethodDescriptor<UpdateAppRequest, App> updateAppMethodDescriptor =
      ApiMethodDescriptor.<UpdateAppRequest, App>newBuilder()
          .setFullMethodName("google.cloud.ces.v1.AgentService/UpdateApp")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateAppRequest>newBuilder()
                  .setPath(
                      "/v1/{app.name=projects/*/locations/*/apps/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateAppRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "app.name", request.getApp().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateAppRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request -> ProtoRestSerializer.create().toBody("app", request.getApp(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<App>newBuilder()
                  .setDefaultInstance(App.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteAppRequest, Operation> deleteAppMethodDescriptor =
      ApiMethodDescriptor.<DeleteAppRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.ces.v1.AgentService/DeleteApp")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteAppRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/apps/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteAppRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteAppRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "etag", request.getEtag());
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
              (DeleteAppRequest request, Operation response) ->
                  HttpJsonOperationSnapshot.create(response))
          .build();

  private static final ApiMethodDescriptor<ExportAppRequest, Operation> exportAppMethodDescriptor =
      ApiMethodDescriptor.<ExportAppRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.ces.v1.AgentService/ExportApp")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<ExportAppRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/apps/*}:exportApp",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<ExportAppRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<ExportAppRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearName().build(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (ExportAppRequest request, Operation response) ->
                  HttpJsonOperationSnapshot.create(response))
          .build();

  private static final ApiMethodDescriptor<ImportAppRequest, Operation> importAppMethodDescriptor =
      ApiMethodDescriptor.<ImportAppRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.ces.v1.AgentService/ImportApp")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<ImportAppRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=projects/*/locations/*}/apps:importApp",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<ImportAppRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<ImportAppRequest> serializer =
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
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (ImportAppRequest request, Operation response) ->
                  HttpJsonOperationSnapshot.create(response))
          .build();

  private static final ApiMethodDescriptor<ListAgentsRequest, ListAgentsResponse>
      listAgentsMethodDescriptor =
          ApiMethodDescriptor.<ListAgentsRequest, ListAgentsResponse>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/ListAgents")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAgentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apps/*}/agents",
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

  private static final ApiMethodDescriptor<GetAgentRequest, Agent> getAgentMethodDescriptor =
      ApiMethodDescriptor.<GetAgentRequest, Agent>newBuilder()
          .setFullMethodName("google.cloud.ces.v1.AgentService/GetAgent")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetAgentRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/apps/*/agents/*}",
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

  private static final ApiMethodDescriptor<CreateAgentRequest, Agent> createAgentMethodDescriptor =
      ApiMethodDescriptor.<CreateAgentRequest, Agent>newBuilder()
          .setFullMethodName("google.cloud.ces.v1.AgentService/CreateAgent")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateAgentRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=projects/*/locations/*/apps/*}/agents",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateAgentRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateAgentRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "agentId", request.getAgentId());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("agent", request.getAgent(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Agent>newBuilder()
                  .setDefaultInstance(Agent.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateAgentRequest, Agent> updateAgentMethodDescriptor =
      ApiMethodDescriptor.<UpdateAgentRequest, Agent>newBuilder()
          .setFullMethodName("google.cloud.ces.v1.AgentService/UpdateAgent")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateAgentRequest>newBuilder()
                  .setPath(
                      "/v1/{agent.name=projects/*/locations/*/apps/*/agents/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateAgentRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "agent.name", request.getAgent().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateAgentRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("agent", request.getAgent(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Agent>newBuilder()
                  .setDefaultInstance(Agent.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteAgentRequest, Empty> deleteAgentMethodDescriptor =
      ApiMethodDescriptor.<DeleteAgentRequest, Empty>newBuilder()
          .setFullMethodName("google.cloud.ces.v1.AgentService/DeleteAgent")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteAgentRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/apps/*/agents/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteAgentRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteAgentRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "etag", request.getEtag());
                        serializer.putQueryParam(fields, "force", request.getForce());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Empty>newBuilder()
                  .setDefaultInstance(Empty.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListExamplesRequest, ListExamplesResponse>
      listExamplesMethodDescriptor =
          ApiMethodDescriptor.<ListExamplesRequest, ListExamplesResponse>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/ListExamples")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListExamplesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apps/*}/examples",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListExamplesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListExamplesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListExamplesResponse>newBuilder()
                      .setDefaultInstance(ListExamplesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetExampleRequest, Example> getExampleMethodDescriptor =
      ApiMethodDescriptor.<GetExampleRequest, Example>newBuilder()
          .setFullMethodName("google.cloud.ces.v1.AgentService/GetExample")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetExampleRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/apps/*/examples/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetExampleRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetExampleRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Example>newBuilder()
                  .setDefaultInstance(Example.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateExampleRequest, Example>
      createExampleMethodDescriptor =
          ApiMethodDescriptor.<CreateExampleRequest, Example>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/CreateExample")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateExampleRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apps/*}/examples",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateExampleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateExampleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "exampleId", request.getExampleId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("example", request.getExample(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Example>newBuilder()
                      .setDefaultInstance(Example.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateExampleRequest, Example>
      updateExampleMethodDescriptor =
          ApiMethodDescriptor.<UpdateExampleRequest, Example>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/UpdateExample")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateExampleRequest>newBuilder()
                      .setPath(
                          "/v1/{example.name=projects/*/locations/*/apps/*/examples/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateExampleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "example.name", request.getExample().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateExampleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("example", request.getExample(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Example>newBuilder()
                      .setDefaultInstance(Example.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteExampleRequest, Empty>
      deleteExampleMethodDescriptor =
          ApiMethodDescriptor.<DeleteExampleRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/DeleteExample")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteExampleRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apps/*/examples/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteExampleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteExampleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListToolsRequest, ListToolsResponse>
      listToolsMethodDescriptor =
          ApiMethodDescriptor.<ListToolsRequest, ListToolsResponse>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/ListTools")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListToolsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apps/*}/tools",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListToolsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListToolsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListToolsResponse>newBuilder()
                      .setDefaultInstance(ListToolsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetToolRequest, Tool> getToolMethodDescriptor =
      ApiMethodDescriptor.<GetToolRequest, Tool>newBuilder()
          .setFullMethodName("google.cloud.ces.v1.AgentService/GetTool")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetToolRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/apps/*/tools/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetToolRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetToolRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Tool>newBuilder()
                  .setDefaultInstance(Tool.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListConversationsRequest, ListConversationsResponse>
      listConversationsMethodDescriptor =
          ApiMethodDescriptor.<ListConversationsRequest, ListConversationsResponse>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/ListConversations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListConversationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apps/*}/conversations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListConversationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListConversationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "source", request.getSourceValue());
                            serializer.putQueryParam(fields, "sources", request.getSourcesList());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListConversationsResponse>newBuilder()
                      .setDefaultInstance(ListConversationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetConversationRequest, Conversation>
      getConversationMethodDescriptor =
          ApiMethodDescriptor.<GetConversationRequest, Conversation>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/GetConversation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetConversationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apps/*/conversations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetConversationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetConversationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "source", request.getSourceValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Conversation>newBuilder()
                      .setDefaultInstance(Conversation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteConversationRequest, Empty>
      deleteConversationMethodDescriptor =
          ApiMethodDescriptor.<DeleteConversationRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/DeleteConversation")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteConversationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apps/*/conversations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConversationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConversationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "source", request.getSourceValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchDeleteConversationsRequest, Operation>
      batchDeleteConversationsMethodDescriptor =
          ApiMethodDescriptor.<BatchDeleteConversationsRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/BatchDeleteConversations")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchDeleteConversationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apps/*}/conversations:batchDelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeleteConversationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeleteConversationsRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (BatchDeleteConversationsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateToolRequest, Tool> createToolMethodDescriptor =
      ApiMethodDescriptor.<CreateToolRequest, Tool>newBuilder()
          .setFullMethodName("google.cloud.ces.v1.AgentService/CreateTool")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateToolRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=projects/*/locations/*/apps/*}/tools",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateToolRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateToolRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "toolId", request.getToolId());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("tool", request.getTool(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Tool>newBuilder()
                  .setDefaultInstance(Tool.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateToolRequest, Tool> updateToolMethodDescriptor =
      ApiMethodDescriptor.<UpdateToolRequest, Tool>newBuilder()
          .setFullMethodName("google.cloud.ces.v1.AgentService/UpdateTool")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateToolRequest>newBuilder()
                  .setPath(
                      "/v1/{tool.name=projects/*/locations/*/apps/*/tools/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateToolRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "tool.name", request.getTool().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateToolRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("tool", request.getTool(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Tool>newBuilder()
                  .setDefaultInstance(Tool.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteToolRequest, Empty> deleteToolMethodDescriptor =
      ApiMethodDescriptor.<DeleteToolRequest, Empty>newBuilder()
          .setFullMethodName("google.cloud.ces.v1.AgentService/DeleteTool")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteToolRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/apps/*/tools/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteToolRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteToolRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "etag", request.getEtag());
                        serializer.putQueryParam(fields, "force", request.getForce());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Empty>newBuilder()
                  .setDefaultInstance(Empty.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListGuardrailsRequest, ListGuardrailsResponse>
      listGuardrailsMethodDescriptor =
          ApiMethodDescriptor.<ListGuardrailsRequest, ListGuardrailsResponse>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/ListGuardrails")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGuardrailsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apps/*}/guardrails",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGuardrailsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGuardrailsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListGuardrailsResponse>newBuilder()
                      .setDefaultInstance(ListGuardrailsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetGuardrailRequest, Guardrail>
      getGuardrailMethodDescriptor =
          ApiMethodDescriptor.<GetGuardrailRequest, Guardrail>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/GetGuardrail")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGuardrailRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apps/*/guardrails/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGuardrailRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGuardrailRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Guardrail>newBuilder()
                      .setDefaultInstance(Guardrail.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateGuardrailRequest, Guardrail>
      createGuardrailMethodDescriptor =
          ApiMethodDescriptor.<CreateGuardrailRequest, Guardrail>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/CreateGuardrail")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateGuardrailRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apps/*}/guardrails",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGuardrailRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGuardrailRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "guardrailId", request.getGuardrailId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("guardrail", request.getGuardrail(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Guardrail>newBuilder()
                      .setDefaultInstance(Guardrail.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateGuardrailRequest, Guardrail>
      updateGuardrailMethodDescriptor =
          ApiMethodDescriptor.<UpdateGuardrailRequest, Guardrail>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/UpdateGuardrail")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateGuardrailRequest>newBuilder()
                      .setPath(
                          "/v1/{guardrail.name=projects/*/locations/*/apps/*/guardrails/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGuardrailRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "guardrail.name", request.getGuardrail().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGuardrailRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("guardrail", request.getGuardrail(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Guardrail>newBuilder()
                      .setDefaultInstance(Guardrail.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteGuardrailRequest, Empty>
      deleteGuardrailMethodDescriptor =
          ApiMethodDescriptor.<DeleteGuardrailRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/DeleteGuardrail")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGuardrailRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apps/*/guardrails/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGuardrailRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGuardrailRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDeploymentsRequest, ListDeploymentsResponse>
      listDeploymentsMethodDescriptor =
          ApiMethodDescriptor.<ListDeploymentsRequest, ListDeploymentsResponse>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/ListDeployments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDeploymentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apps/*}/deployments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeploymentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeploymentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDeploymentsResponse>newBuilder()
                      .setDefaultInstance(ListDeploymentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDeploymentRequest, Deployment>
      getDeploymentMethodDescriptor =
          ApiMethodDescriptor.<GetDeploymentRequest, Deployment>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/GetDeployment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apps/*/deployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Deployment>newBuilder()
                      .setDefaultInstance(Deployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateDeploymentRequest, Deployment>
      createDeploymentMethodDescriptor =
          ApiMethodDescriptor.<CreateDeploymentRequest, Deployment>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/CreateDeployment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apps/*}/deployments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "deploymentId", request.getDeploymentId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("deployment", request.getDeployment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Deployment>newBuilder()
                      .setDefaultInstance(Deployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDeploymentRequest, Deployment>
      updateDeploymentMethodDescriptor =
          ApiMethodDescriptor.<UpdateDeploymentRequest, Deployment>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/UpdateDeployment")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{deployment.name=projects/*/locations/*/apps/*/deployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "deployment.name", request.getDeployment().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("deployment", request.getDeployment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Deployment>newBuilder()
                      .setDefaultInstance(Deployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDeploymentRequest, Empty>
      deleteDeploymentMethodDescriptor =
          ApiMethodDescriptor.<DeleteDeploymentRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/DeleteDeployment")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apps/*/deployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListToolsetsRequest, ListToolsetsResponse>
      listToolsetsMethodDescriptor =
          ApiMethodDescriptor.<ListToolsetsRequest, ListToolsetsResponse>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/ListToolsets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListToolsetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apps/*}/toolsets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListToolsetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListToolsetsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListToolsetsResponse>newBuilder()
                      .setDefaultInstance(ListToolsetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetToolsetRequest, Toolset> getToolsetMethodDescriptor =
      ApiMethodDescriptor.<GetToolsetRequest, Toolset>newBuilder()
          .setFullMethodName("google.cloud.ces.v1.AgentService/GetToolset")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetToolsetRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/apps/*/toolsets/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetToolsetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetToolsetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Toolset>newBuilder()
                  .setDefaultInstance(Toolset.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateToolsetRequest, Toolset>
      createToolsetMethodDescriptor =
          ApiMethodDescriptor.<CreateToolsetRequest, Toolset>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/CreateToolset")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateToolsetRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apps/*}/toolsets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateToolsetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateToolsetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "toolsetId", request.getToolsetId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("toolset", request.getToolset(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Toolset>newBuilder()
                      .setDefaultInstance(Toolset.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateToolsetRequest, Toolset>
      updateToolsetMethodDescriptor =
          ApiMethodDescriptor.<UpdateToolsetRequest, Toolset>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/UpdateToolset")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateToolsetRequest>newBuilder()
                      .setPath(
                          "/v1/{toolset.name=projects/*/locations/*/apps/*/toolsets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateToolsetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "toolset.name", request.getToolset().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateToolsetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("toolset", request.getToolset(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Toolset>newBuilder()
                      .setDefaultInstance(Toolset.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteToolsetRequest, Empty>
      deleteToolsetMethodDescriptor =
          ApiMethodDescriptor.<DeleteToolsetRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/DeleteToolset")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteToolsetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apps/*/toolsets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteToolsetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteToolsetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAppVersionsRequest, ListAppVersionsResponse>
      listAppVersionsMethodDescriptor =
          ApiMethodDescriptor.<ListAppVersionsRequest, ListAppVersionsResponse>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/ListAppVersions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAppVersionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apps/*}/versions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAppVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAppVersionsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListAppVersionsResponse>newBuilder()
                      .setDefaultInstance(ListAppVersionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAppVersionRequest, AppVersion>
      getAppVersionMethodDescriptor =
          ApiMethodDescriptor.<GetAppVersionRequest, AppVersion>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/GetAppVersion")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAppVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apps/*/versions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAppVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAppVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AppVersion>newBuilder()
                      .setDefaultInstance(AppVersion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAppVersionRequest, AppVersion>
      createAppVersionMethodDescriptor =
          ApiMethodDescriptor.<CreateAppVersionRequest, AppVersion>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/CreateAppVersion")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAppVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apps/*}/versions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAppVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAppVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "appVersionId", request.getAppVersionId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("appVersion", request.getAppVersion(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AppVersion>newBuilder()
                      .setDefaultInstance(AppVersion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAppVersionRequest, Empty>
      deleteAppVersionMethodDescriptor =
          ApiMethodDescriptor.<DeleteAppVersionRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/DeleteAppVersion")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAppVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apps/*/versions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAppVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAppVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RestoreAppVersionRequest, Operation>
      restoreAppVersionMethodDescriptor =
          ApiMethodDescriptor.<RestoreAppVersionRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/RestoreAppVersion")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RestoreAppVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apps/*/versions/*}:restore",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RestoreAppVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RestoreAppVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RestoreAppVersionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListChangelogsRequest, ListChangelogsResponse>
      listChangelogsMethodDescriptor =
          ApiMethodDescriptor.<ListChangelogsRequest, ListChangelogsResponse>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/ListChangelogs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListChangelogsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apps/*}/changelogs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListChangelogsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListChangelogsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListChangelogsResponse>newBuilder()
                      .setDefaultInstance(ListChangelogsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetChangelogRequest, Changelog>
      getChangelogMethodDescriptor =
          ApiMethodDescriptor.<GetChangelogRequest, Changelog>newBuilder()
              .setFullMethodName("google.cloud.ces.v1.AgentService/GetChangelog")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetChangelogRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apps/*/changelogs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetChangelogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetChangelogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Changelog>newBuilder()
                      .setDefaultInstance(Changelog.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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

  private final UnaryCallable<ListAppsRequest, ListAppsResponse> listAppsCallable;
  private final UnaryCallable<ListAppsRequest, ListAppsPagedResponse> listAppsPagedCallable;
  private final UnaryCallable<GetAppRequest, App> getAppCallable;
  private final UnaryCallable<CreateAppRequest, Operation> createAppCallable;
  private final OperationCallable<CreateAppRequest, App, OperationMetadata>
      createAppOperationCallable;
  private final UnaryCallable<UpdateAppRequest, App> updateAppCallable;
  private final UnaryCallable<DeleteAppRequest, Operation> deleteAppCallable;
  private final OperationCallable<DeleteAppRequest, Empty, OperationMetadata>
      deleteAppOperationCallable;
  private final UnaryCallable<ExportAppRequest, Operation> exportAppCallable;
  private final OperationCallable<ExportAppRequest, ExportAppResponse, OperationMetadata>
      exportAppOperationCallable;
  private final UnaryCallable<ImportAppRequest, Operation> importAppCallable;
  private final OperationCallable<ImportAppRequest, ImportAppResponse, OperationMetadata>
      importAppOperationCallable;
  private final UnaryCallable<ListAgentsRequest, ListAgentsResponse> listAgentsCallable;
  private final UnaryCallable<ListAgentsRequest, ListAgentsPagedResponse> listAgentsPagedCallable;
  private final UnaryCallable<GetAgentRequest, Agent> getAgentCallable;
  private final UnaryCallable<CreateAgentRequest, Agent> createAgentCallable;
  private final UnaryCallable<UpdateAgentRequest, Agent> updateAgentCallable;
  private final UnaryCallable<DeleteAgentRequest, Empty> deleteAgentCallable;
  private final UnaryCallable<ListExamplesRequest, ListExamplesResponse> listExamplesCallable;
  private final UnaryCallable<ListExamplesRequest, ListExamplesPagedResponse>
      listExamplesPagedCallable;
  private final UnaryCallable<GetExampleRequest, Example> getExampleCallable;
  private final UnaryCallable<CreateExampleRequest, Example> createExampleCallable;
  private final UnaryCallable<UpdateExampleRequest, Example> updateExampleCallable;
  private final UnaryCallable<DeleteExampleRequest, Empty> deleteExampleCallable;
  private final UnaryCallable<ListToolsRequest, ListToolsResponse> listToolsCallable;
  private final UnaryCallable<ListToolsRequest, ListToolsPagedResponse> listToolsPagedCallable;
  private final UnaryCallable<GetToolRequest, Tool> getToolCallable;
  private final UnaryCallable<ListConversationsRequest, ListConversationsResponse>
      listConversationsCallable;
  private final UnaryCallable<ListConversationsRequest, ListConversationsPagedResponse>
      listConversationsPagedCallable;
  private final UnaryCallable<GetConversationRequest, Conversation> getConversationCallable;
  private final UnaryCallable<DeleteConversationRequest, Empty> deleteConversationCallable;
  private final UnaryCallable<BatchDeleteConversationsRequest, Operation>
      batchDeleteConversationsCallable;
  private final OperationCallable<
          BatchDeleteConversationsRequest, BatchDeleteConversationsResponse, OperationMetadata>
      batchDeleteConversationsOperationCallable;
  private final UnaryCallable<CreateToolRequest, Tool> createToolCallable;
  private final UnaryCallable<UpdateToolRequest, Tool> updateToolCallable;
  private final UnaryCallable<DeleteToolRequest, Empty> deleteToolCallable;
  private final UnaryCallable<ListGuardrailsRequest, ListGuardrailsResponse> listGuardrailsCallable;
  private final UnaryCallable<ListGuardrailsRequest, ListGuardrailsPagedResponse>
      listGuardrailsPagedCallable;
  private final UnaryCallable<GetGuardrailRequest, Guardrail> getGuardrailCallable;
  private final UnaryCallable<CreateGuardrailRequest, Guardrail> createGuardrailCallable;
  private final UnaryCallable<UpdateGuardrailRequest, Guardrail> updateGuardrailCallable;
  private final UnaryCallable<DeleteGuardrailRequest, Empty> deleteGuardrailCallable;
  private final UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse>
      listDeploymentsCallable;
  private final UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable;
  private final UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable;
  private final UnaryCallable<CreateDeploymentRequest, Deployment> createDeploymentCallable;
  private final UnaryCallable<UpdateDeploymentRequest, Deployment> updateDeploymentCallable;
  private final UnaryCallable<DeleteDeploymentRequest, Empty> deleteDeploymentCallable;
  private final UnaryCallable<ListToolsetsRequest, ListToolsetsResponse> listToolsetsCallable;
  private final UnaryCallable<ListToolsetsRequest, ListToolsetsPagedResponse>
      listToolsetsPagedCallable;
  private final UnaryCallable<GetToolsetRequest, Toolset> getToolsetCallable;
  private final UnaryCallable<CreateToolsetRequest, Toolset> createToolsetCallable;
  private final UnaryCallable<UpdateToolsetRequest, Toolset> updateToolsetCallable;
  private final UnaryCallable<DeleteToolsetRequest, Empty> deleteToolsetCallable;
  private final UnaryCallable<ListAppVersionsRequest, ListAppVersionsResponse>
      listAppVersionsCallable;
  private final UnaryCallable<ListAppVersionsRequest, ListAppVersionsPagedResponse>
      listAppVersionsPagedCallable;
  private final UnaryCallable<GetAppVersionRequest, AppVersion> getAppVersionCallable;
  private final UnaryCallable<CreateAppVersionRequest, AppVersion> createAppVersionCallable;
  private final UnaryCallable<DeleteAppVersionRequest, Empty> deleteAppVersionCallable;
  private final UnaryCallable<RestoreAppVersionRequest, Operation> restoreAppVersionCallable;
  private final OperationCallable<
          RestoreAppVersionRequest, RestoreAppVersionResponse, OperationMetadata>
      restoreAppVersionOperationCallable;
  private final UnaryCallable<ListChangelogsRequest, ListChangelogsResponse> listChangelogsCallable;
  private final UnaryCallable<ListChangelogsRequest, ListChangelogsPagedResponse>
      listChangelogsPagedCallable;
  private final UnaryCallable<GetChangelogRequest, Changelog> getChangelogCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAgentServiceStub create(AgentServiceStubSettings settings)
      throws IOException {
    return new HttpJsonAgentServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAgentServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAgentServiceStub(
        AgentServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAgentServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAgentServiceStub(
        AgentServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAgentServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAgentServiceStub(AgentServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonAgentServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAgentServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAgentServiceStub(
      AgentServiceStubSettings settings,
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

    HttpJsonCallSettings<ListAppsRequest, ListAppsResponse> listAppsTransportSettings =
        HttpJsonCallSettings.<ListAppsRequest, ListAppsResponse>newBuilder()
            .setMethodDescriptor(listAppsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetAppRequest, App> getAppTransportSettings =
        HttpJsonCallSettings.<GetAppRequest, App>newBuilder()
            .setMethodDescriptor(getAppMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateAppRequest, Operation> createAppTransportSettings =
        HttpJsonCallSettings.<CreateAppRequest, Operation>newBuilder()
            .setMethodDescriptor(createAppMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateAppRequest, App> updateAppTransportSettings =
        HttpJsonCallSettings.<UpdateAppRequest, App>newBuilder()
            .setMethodDescriptor(updateAppMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("app.name", String.valueOf(request.getApp().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteAppRequest, Operation> deleteAppTransportSettings =
        HttpJsonCallSettings.<DeleteAppRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAppMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ExportAppRequest, Operation> exportAppTransportSettings =
        HttpJsonCallSettings.<ExportAppRequest, Operation>newBuilder()
            .setMethodDescriptor(exportAppMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ImportAppRequest, Operation> importAppTransportSettings =
        HttpJsonCallSettings.<ImportAppRequest, Operation>newBuilder()
            .setMethodDescriptor(importAppMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
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
            .build();
    HttpJsonCallSettings<CreateAgentRequest, Agent> createAgentTransportSettings =
        HttpJsonCallSettings.<CreateAgentRequest, Agent>newBuilder()
            .setMethodDescriptor(createAgentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateAgentRequest, Agent> updateAgentTransportSettings =
        HttpJsonCallSettings.<UpdateAgentRequest, Agent>newBuilder()
            .setMethodDescriptor(updateAgentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("agent.name", String.valueOf(request.getAgent().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteAgentRequest, Empty> deleteAgentTransportSettings =
        HttpJsonCallSettings.<DeleteAgentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAgentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListExamplesRequest, ListExamplesResponse> listExamplesTransportSettings =
        HttpJsonCallSettings.<ListExamplesRequest, ListExamplesResponse>newBuilder()
            .setMethodDescriptor(listExamplesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetExampleRequest, Example> getExampleTransportSettings =
        HttpJsonCallSettings.<GetExampleRequest, Example>newBuilder()
            .setMethodDescriptor(getExampleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateExampleRequest, Example> createExampleTransportSettings =
        HttpJsonCallSettings.<CreateExampleRequest, Example>newBuilder()
            .setMethodDescriptor(createExampleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateExampleRequest, Example> updateExampleTransportSettings =
        HttpJsonCallSettings.<UpdateExampleRequest, Example>newBuilder()
            .setMethodDescriptor(updateExampleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("example.name", String.valueOf(request.getExample().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteExampleRequest, Empty> deleteExampleTransportSettings =
        HttpJsonCallSettings.<DeleteExampleRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteExampleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListToolsRequest, ListToolsResponse> listToolsTransportSettings =
        HttpJsonCallSettings.<ListToolsRequest, ListToolsResponse>newBuilder()
            .setMethodDescriptor(listToolsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetToolRequest, Tool> getToolTransportSettings =
        HttpJsonCallSettings.<GetToolRequest, Tool>newBuilder()
            .setMethodDescriptor(getToolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListConversationsRequest, ListConversationsResponse>
        listConversationsTransportSettings =
            HttpJsonCallSettings.<ListConversationsRequest, ListConversationsResponse>newBuilder()
                .setMethodDescriptor(listConversationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetConversationRequest, Conversation> getConversationTransportSettings =
        HttpJsonCallSettings.<GetConversationRequest, Conversation>newBuilder()
            .setMethodDescriptor(getConversationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteConversationRequest, Empty> deleteConversationTransportSettings =
        HttpJsonCallSettings.<DeleteConversationRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteConversationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchDeleteConversationsRequest, Operation>
        batchDeleteConversationsTransportSettings =
            HttpJsonCallSettings.<BatchDeleteConversationsRequest, Operation>newBuilder()
                .setMethodDescriptor(batchDeleteConversationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateToolRequest, Tool> createToolTransportSettings =
        HttpJsonCallSettings.<CreateToolRequest, Tool>newBuilder()
            .setMethodDescriptor(createToolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateToolRequest, Tool> updateToolTransportSettings =
        HttpJsonCallSettings.<UpdateToolRequest, Tool>newBuilder()
            .setMethodDescriptor(updateToolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("tool.name", String.valueOf(request.getTool().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteToolRequest, Empty> deleteToolTransportSettings =
        HttpJsonCallSettings.<DeleteToolRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteToolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListGuardrailsRequest, ListGuardrailsResponse>
        listGuardrailsTransportSettings =
            HttpJsonCallSettings.<ListGuardrailsRequest, ListGuardrailsResponse>newBuilder()
                .setMethodDescriptor(listGuardrailsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetGuardrailRequest, Guardrail> getGuardrailTransportSettings =
        HttpJsonCallSettings.<GetGuardrailRequest, Guardrail>newBuilder()
            .setMethodDescriptor(getGuardrailMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateGuardrailRequest, Guardrail> createGuardrailTransportSettings =
        HttpJsonCallSettings.<CreateGuardrailRequest, Guardrail>newBuilder()
            .setMethodDescriptor(createGuardrailMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateGuardrailRequest, Guardrail> updateGuardrailTransportSettings =
        HttpJsonCallSettings.<UpdateGuardrailRequest, Guardrail>newBuilder()
            .setMethodDescriptor(updateGuardrailMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("guardrail.name", String.valueOf(request.getGuardrail().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteGuardrailRequest, Empty> deleteGuardrailTransportSettings =
        HttpJsonCallSettings.<DeleteGuardrailRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteGuardrailMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListDeploymentsRequest, ListDeploymentsResponse>
        listDeploymentsTransportSettings =
            HttpJsonCallSettings.<ListDeploymentsRequest, ListDeploymentsResponse>newBuilder()
                .setMethodDescriptor(listDeploymentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetDeploymentRequest, Deployment> getDeploymentTransportSettings =
        HttpJsonCallSettings.<GetDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(getDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateDeploymentRequest, Deployment> createDeploymentTransportSettings =
        HttpJsonCallSettings.<CreateDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(createDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateDeploymentRequest, Deployment> updateDeploymentTransportSettings =
        HttpJsonCallSettings.<UpdateDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(updateDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("deployment.name", String.valueOf(request.getDeployment().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteDeploymentRequest, Empty> deleteDeploymentTransportSettings =
        HttpJsonCallSettings.<DeleteDeploymentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListToolsetsRequest, ListToolsetsResponse> listToolsetsTransportSettings =
        HttpJsonCallSettings.<ListToolsetsRequest, ListToolsetsResponse>newBuilder()
            .setMethodDescriptor(listToolsetsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetToolsetRequest, Toolset> getToolsetTransportSettings =
        HttpJsonCallSettings.<GetToolsetRequest, Toolset>newBuilder()
            .setMethodDescriptor(getToolsetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateToolsetRequest, Toolset> createToolsetTransportSettings =
        HttpJsonCallSettings.<CreateToolsetRequest, Toolset>newBuilder()
            .setMethodDescriptor(createToolsetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateToolsetRequest, Toolset> updateToolsetTransportSettings =
        HttpJsonCallSettings.<UpdateToolsetRequest, Toolset>newBuilder()
            .setMethodDescriptor(updateToolsetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("toolset.name", String.valueOf(request.getToolset().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteToolsetRequest, Empty> deleteToolsetTransportSettings =
        HttpJsonCallSettings.<DeleteToolsetRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteToolsetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListAppVersionsRequest, ListAppVersionsResponse>
        listAppVersionsTransportSettings =
            HttpJsonCallSettings.<ListAppVersionsRequest, ListAppVersionsResponse>newBuilder()
                .setMethodDescriptor(listAppVersionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetAppVersionRequest, AppVersion> getAppVersionTransportSettings =
        HttpJsonCallSettings.<GetAppVersionRequest, AppVersion>newBuilder()
            .setMethodDescriptor(getAppVersionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateAppVersionRequest, AppVersion> createAppVersionTransportSettings =
        HttpJsonCallSettings.<CreateAppVersionRequest, AppVersion>newBuilder()
            .setMethodDescriptor(createAppVersionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteAppVersionRequest, Empty> deleteAppVersionTransportSettings =
        HttpJsonCallSettings.<DeleteAppVersionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAppVersionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RestoreAppVersionRequest, Operation> restoreAppVersionTransportSettings =
        HttpJsonCallSettings.<RestoreAppVersionRequest, Operation>newBuilder()
            .setMethodDescriptor(restoreAppVersionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListChangelogsRequest, ListChangelogsResponse>
        listChangelogsTransportSettings =
            HttpJsonCallSettings.<ListChangelogsRequest, ListChangelogsResponse>newBuilder()
                .setMethodDescriptor(listChangelogsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetChangelogRequest, Changelog> getChangelogTransportSettings =
        HttpJsonCallSettings.<GetChangelogRequest, Changelog>newBuilder()
            .setMethodDescriptor(getChangelogMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
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

    this.listAppsCallable =
        callableFactory.createUnaryCallable(
            listAppsTransportSettings, settings.listAppsSettings(), clientContext);
    this.listAppsPagedCallable =
        callableFactory.createPagedCallable(
            listAppsTransportSettings, settings.listAppsSettings(), clientContext);
    this.getAppCallable =
        callableFactory.createUnaryCallable(
            getAppTransportSettings, settings.getAppSettings(), clientContext);
    this.createAppCallable =
        callableFactory.createUnaryCallable(
            createAppTransportSettings, settings.createAppSettings(), clientContext);
    this.createAppOperationCallable =
        callableFactory.createOperationCallable(
            createAppTransportSettings,
            settings.createAppOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateAppCallable =
        callableFactory.createUnaryCallable(
            updateAppTransportSettings, settings.updateAppSettings(), clientContext);
    this.deleteAppCallable =
        callableFactory.createUnaryCallable(
            deleteAppTransportSettings, settings.deleteAppSettings(), clientContext);
    this.deleteAppOperationCallable =
        callableFactory.createOperationCallable(
            deleteAppTransportSettings,
            settings.deleteAppOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.exportAppCallable =
        callableFactory.createUnaryCallable(
            exportAppTransportSettings, settings.exportAppSettings(), clientContext);
    this.exportAppOperationCallable =
        callableFactory.createOperationCallable(
            exportAppTransportSettings,
            settings.exportAppOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.importAppCallable =
        callableFactory.createUnaryCallable(
            importAppTransportSettings, settings.importAppSettings(), clientContext);
    this.importAppOperationCallable =
        callableFactory.createOperationCallable(
            importAppTransportSettings,
            settings.importAppOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listAgentsCallable =
        callableFactory.createUnaryCallable(
            listAgentsTransportSettings, settings.listAgentsSettings(), clientContext);
    this.listAgentsPagedCallable =
        callableFactory.createPagedCallable(
            listAgentsTransportSettings, settings.listAgentsSettings(), clientContext);
    this.getAgentCallable =
        callableFactory.createUnaryCallable(
            getAgentTransportSettings, settings.getAgentSettings(), clientContext);
    this.createAgentCallable =
        callableFactory.createUnaryCallable(
            createAgentTransportSettings, settings.createAgentSettings(), clientContext);
    this.updateAgentCallable =
        callableFactory.createUnaryCallable(
            updateAgentTransportSettings, settings.updateAgentSettings(), clientContext);
    this.deleteAgentCallable =
        callableFactory.createUnaryCallable(
            deleteAgentTransportSettings, settings.deleteAgentSettings(), clientContext);
    this.listExamplesCallable =
        callableFactory.createUnaryCallable(
            listExamplesTransportSettings, settings.listExamplesSettings(), clientContext);
    this.listExamplesPagedCallable =
        callableFactory.createPagedCallable(
            listExamplesTransportSettings, settings.listExamplesSettings(), clientContext);
    this.getExampleCallable =
        callableFactory.createUnaryCallable(
            getExampleTransportSettings, settings.getExampleSettings(), clientContext);
    this.createExampleCallable =
        callableFactory.createUnaryCallable(
            createExampleTransportSettings, settings.createExampleSettings(), clientContext);
    this.updateExampleCallable =
        callableFactory.createUnaryCallable(
            updateExampleTransportSettings, settings.updateExampleSettings(), clientContext);
    this.deleteExampleCallable =
        callableFactory.createUnaryCallable(
            deleteExampleTransportSettings, settings.deleteExampleSettings(), clientContext);
    this.listToolsCallable =
        callableFactory.createUnaryCallable(
            listToolsTransportSettings, settings.listToolsSettings(), clientContext);
    this.listToolsPagedCallable =
        callableFactory.createPagedCallable(
            listToolsTransportSettings, settings.listToolsSettings(), clientContext);
    this.getToolCallable =
        callableFactory.createUnaryCallable(
            getToolTransportSettings, settings.getToolSettings(), clientContext);
    this.listConversationsCallable =
        callableFactory.createUnaryCallable(
            listConversationsTransportSettings,
            settings.listConversationsSettings(),
            clientContext);
    this.listConversationsPagedCallable =
        callableFactory.createPagedCallable(
            listConversationsTransportSettings,
            settings.listConversationsSettings(),
            clientContext);
    this.getConversationCallable =
        callableFactory.createUnaryCallable(
            getConversationTransportSettings, settings.getConversationSettings(), clientContext);
    this.deleteConversationCallable =
        callableFactory.createUnaryCallable(
            deleteConversationTransportSettings,
            settings.deleteConversationSettings(),
            clientContext);
    this.batchDeleteConversationsCallable =
        callableFactory.createUnaryCallable(
            batchDeleteConversationsTransportSettings,
            settings.batchDeleteConversationsSettings(),
            clientContext);
    this.batchDeleteConversationsOperationCallable =
        callableFactory.createOperationCallable(
            batchDeleteConversationsTransportSettings,
            settings.batchDeleteConversationsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createToolCallable =
        callableFactory.createUnaryCallable(
            createToolTransportSettings, settings.createToolSettings(), clientContext);
    this.updateToolCallable =
        callableFactory.createUnaryCallable(
            updateToolTransportSettings, settings.updateToolSettings(), clientContext);
    this.deleteToolCallable =
        callableFactory.createUnaryCallable(
            deleteToolTransportSettings, settings.deleteToolSettings(), clientContext);
    this.listGuardrailsCallable =
        callableFactory.createUnaryCallable(
            listGuardrailsTransportSettings, settings.listGuardrailsSettings(), clientContext);
    this.listGuardrailsPagedCallable =
        callableFactory.createPagedCallable(
            listGuardrailsTransportSettings, settings.listGuardrailsSettings(), clientContext);
    this.getGuardrailCallable =
        callableFactory.createUnaryCallable(
            getGuardrailTransportSettings, settings.getGuardrailSettings(), clientContext);
    this.createGuardrailCallable =
        callableFactory.createUnaryCallable(
            createGuardrailTransportSettings, settings.createGuardrailSettings(), clientContext);
    this.updateGuardrailCallable =
        callableFactory.createUnaryCallable(
            updateGuardrailTransportSettings, settings.updateGuardrailSettings(), clientContext);
    this.deleteGuardrailCallable =
        callableFactory.createUnaryCallable(
            deleteGuardrailTransportSettings, settings.deleteGuardrailSettings(), clientContext);
    this.listDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listDeploymentsTransportSettings, settings.listDeploymentsSettings(), clientContext);
    this.listDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listDeploymentsTransportSettings, settings.listDeploymentsSettings(), clientContext);
    this.getDeploymentCallable =
        callableFactory.createUnaryCallable(
            getDeploymentTransportSettings, settings.getDeploymentSettings(), clientContext);
    this.createDeploymentCallable =
        callableFactory.createUnaryCallable(
            createDeploymentTransportSettings, settings.createDeploymentSettings(), clientContext);
    this.updateDeploymentCallable =
        callableFactory.createUnaryCallable(
            updateDeploymentTransportSettings, settings.updateDeploymentSettings(), clientContext);
    this.deleteDeploymentCallable =
        callableFactory.createUnaryCallable(
            deleteDeploymentTransportSettings, settings.deleteDeploymentSettings(), clientContext);
    this.listToolsetsCallable =
        callableFactory.createUnaryCallable(
            listToolsetsTransportSettings, settings.listToolsetsSettings(), clientContext);
    this.listToolsetsPagedCallable =
        callableFactory.createPagedCallable(
            listToolsetsTransportSettings, settings.listToolsetsSettings(), clientContext);
    this.getToolsetCallable =
        callableFactory.createUnaryCallable(
            getToolsetTransportSettings, settings.getToolsetSettings(), clientContext);
    this.createToolsetCallable =
        callableFactory.createUnaryCallable(
            createToolsetTransportSettings, settings.createToolsetSettings(), clientContext);
    this.updateToolsetCallable =
        callableFactory.createUnaryCallable(
            updateToolsetTransportSettings, settings.updateToolsetSettings(), clientContext);
    this.deleteToolsetCallable =
        callableFactory.createUnaryCallable(
            deleteToolsetTransportSettings, settings.deleteToolsetSettings(), clientContext);
    this.listAppVersionsCallable =
        callableFactory.createUnaryCallable(
            listAppVersionsTransportSettings, settings.listAppVersionsSettings(), clientContext);
    this.listAppVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listAppVersionsTransportSettings, settings.listAppVersionsSettings(), clientContext);
    this.getAppVersionCallable =
        callableFactory.createUnaryCallable(
            getAppVersionTransportSettings, settings.getAppVersionSettings(), clientContext);
    this.createAppVersionCallable =
        callableFactory.createUnaryCallable(
            createAppVersionTransportSettings, settings.createAppVersionSettings(), clientContext);
    this.deleteAppVersionCallable =
        callableFactory.createUnaryCallable(
            deleteAppVersionTransportSettings, settings.deleteAppVersionSettings(), clientContext);
    this.restoreAppVersionCallable =
        callableFactory.createUnaryCallable(
            restoreAppVersionTransportSettings,
            settings.restoreAppVersionSettings(),
            clientContext);
    this.restoreAppVersionOperationCallable =
        callableFactory.createOperationCallable(
            restoreAppVersionTransportSettings,
            settings.restoreAppVersionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listChangelogsCallable =
        callableFactory.createUnaryCallable(
            listChangelogsTransportSettings, settings.listChangelogsSettings(), clientContext);
    this.listChangelogsPagedCallable =
        callableFactory.createPagedCallable(
            listChangelogsTransportSettings, settings.listChangelogsSettings(), clientContext);
    this.getChangelogCallable =
        callableFactory.createUnaryCallable(
            getChangelogTransportSettings, settings.getChangelogSettings(), clientContext);
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
    methodDescriptors.add(listAppsMethodDescriptor);
    methodDescriptors.add(getAppMethodDescriptor);
    methodDescriptors.add(createAppMethodDescriptor);
    methodDescriptors.add(updateAppMethodDescriptor);
    methodDescriptors.add(deleteAppMethodDescriptor);
    methodDescriptors.add(exportAppMethodDescriptor);
    methodDescriptors.add(importAppMethodDescriptor);
    methodDescriptors.add(listAgentsMethodDescriptor);
    methodDescriptors.add(getAgentMethodDescriptor);
    methodDescriptors.add(createAgentMethodDescriptor);
    methodDescriptors.add(updateAgentMethodDescriptor);
    methodDescriptors.add(deleteAgentMethodDescriptor);
    methodDescriptors.add(listExamplesMethodDescriptor);
    methodDescriptors.add(getExampleMethodDescriptor);
    methodDescriptors.add(createExampleMethodDescriptor);
    methodDescriptors.add(updateExampleMethodDescriptor);
    methodDescriptors.add(deleteExampleMethodDescriptor);
    methodDescriptors.add(listToolsMethodDescriptor);
    methodDescriptors.add(getToolMethodDescriptor);
    methodDescriptors.add(listConversationsMethodDescriptor);
    methodDescriptors.add(getConversationMethodDescriptor);
    methodDescriptors.add(deleteConversationMethodDescriptor);
    methodDescriptors.add(batchDeleteConversationsMethodDescriptor);
    methodDescriptors.add(createToolMethodDescriptor);
    methodDescriptors.add(updateToolMethodDescriptor);
    methodDescriptors.add(deleteToolMethodDescriptor);
    methodDescriptors.add(listGuardrailsMethodDescriptor);
    methodDescriptors.add(getGuardrailMethodDescriptor);
    methodDescriptors.add(createGuardrailMethodDescriptor);
    methodDescriptors.add(updateGuardrailMethodDescriptor);
    methodDescriptors.add(deleteGuardrailMethodDescriptor);
    methodDescriptors.add(listDeploymentsMethodDescriptor);
    methodDescriptors.add(getDeploymentMethodDescriptor);
    methodDescriptors.add(createDeploymentMethodDescriptor);
    methodDescriptors.add(updateDeploymentMethodDescriptor);
    methodDescriptors.add(deleteDeploymentMethodDescriptor);
    methodDescriptors.add(listToolsetsMethodDescriptor);
    methodDescriptors.add(getToolsetMethodDescriptor);
    methodDescriptors.add(createToolsetMethodDescriptor);
    methodDescriptors.add(updateToolsetMethodDescriptor);
    methodDescriptors.add(deleteToolsetMethodDescriptor);
    methodDescriptors.add(listAppVersionsMethodDescriptor);
    methodDescriptors.add(getAppVersionMethodDescriptor);
    methodDescriptors.add(createAppVersionMethodDescriptor);
    methodDescriptors.add(deleteAppVersionMethodDescriptor);
    methodDescriptors.add(restoreAppVersionMethodDescriptor);
    methodDescriptors.add(listChangelogsMethodDescriptor);
    methodDescriptors.add(getChangelogMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListAppsRequest, ListAppsResponse> listAppsCallable() {
    return listAppsCallable;
  }

  @Override
  public UnaryCallable<ListAppsRequest, ListAppsPagedResponse> listAppsPagedCallable() {
    return listAppsPagedCallable;
  }

  @Override
  public UnaryCallable<GetAppRequest, App> getAppCallable() {
    return getAppCallable;
  }

  @Override
  public UnaryCallable<CreateAppRequest, Operation> createAppCallable() {
    return createAppCallable;
  }

  @Override
  public OperationCallable<CreateAppRequest, App, OperationMetadata> createAppOperationCallable() {
    return createAppOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAppRequest, App> updateAppCallable() {
    return updateAppCallable;
  }

  @Override
  public UnaryCallable<DeleteAppRequest, Operation> deleteAppCallable() {
    return deleteAppCallable;
  }

  @Override
  public OperationCallable<DeleteAppRequest, Empty, OperationMetadata>
      deleteAppOperationCallable() {
    return deleteAppOperationCallable;
  }

  @Override
  public UnaryCallable<ExportAppRequest, Operation> exportAppCallable() {
    return exportAppCallable;
  }

  @Override
  public OperationCallable<ExportAppRequest, ExportAppResponse, OperationMetadata>
      exportAppOperationCallable() {
    return exportAppOperationCallable;
  }

  @Override
  public UnaryCallable<ImportAppRequest, Operation> importAppCallable() {
    return importAppCallable;
  }

  @Override
  public OperationCallable<ImportAppRequest, ImportAppResponse, OperationMetadata>
      importAppOperationCallable() {
    return importAppOperationCallable;
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
  public UnaryCallable<GetAgentRequest, Agent> getAgentCallable() {
    return getAgentCallable;
  }

  @Override
  public UnaryCallable<CreateAgentRequest, Agent> createAgentCallable() {
    return createAgentCallable;
  }

  @Override
  public UnaryCallable<UpdateAgentRequest, Agent> updateAgentCallable() {
    return updateAgentCallable;
  }

  @Override
  public UnaryCallable<DeleteAgentRequest, Empty> deleteAgentCallable() {
    return deleteAgentCallable;
  }

  @Override
  public UnaryCallable<ListExamplesRequest, ListExamplesResponse> listExamplesCallable() {
    return listExamplesCallable;
  }

  @Override
  public UnaryCallable<ListExamplesRequest, ListExamplesPagedResponse> listExamplesPagedCallable() {
    return listExamplesPagedCallable;
  }

  @Override
  public UnaryCallable<GetExampleRequest, Example> getExampleCallable() {
    return getExampleCallable;
  }

  @Override
  public UnaryCallable<CreateExampleRequest, Example> createExampleCallable() {
    return createExampleCallable;
  }

  @Override
  public UnaryCallable<UpdateExampleRequest, Example> updateExampleCallable() {
    return updateExampleCallable;
  }

  @Override
  public UnaryCallable<DeleteExampleRequest, Empty> deleteExampleCallable() {
    return deleteExampleCallable;
  }

  @Override
  public UnaryCallable<ListToolsRequest, ListToolsResponse> listToolsCallable() {
    return listToolsCallable;
  }

  @Override
  public UnaryCallable<ListToolsRequest, ListToolsPagedResponse> listToolsPagedCallable() {
    return listToolsPagedCallable;
  }

  @Override
  public UnaryCallable<GetToolRequest, Tool> getToolCallable() {
    return getToolCallable;
  }

  @Override
  public UnaryCallable<ListConversationsRequest, ListConversationsResponse>
      listConversationsCallable() {
    return listConversationsCallable;
  }

  @Override
  public UnaryCallable<ListConversationsRequest, ListConversationsPagedResponse>
      listConversationsPagedCallable() {
    return listConversationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetConversationRequest, Conversation> getConversationCallable() {
    return getConversationCallable;
  }

  @Override
  public UnaryCallable<DeleteConversationRequest, Empty> deleteConversationCallable() {
    return deleteConversationCallable;
  }

  @Override
  public UnaryCallable<BatchDeleteConversationsRequest, Operation>
      batchDeleteConversationsCallable() {
    return batchDeleteConversationsCallable;
  }

  @Override
  public OperationCallable<
          BatchDeleteConversationsRequest, BatchDeleteConversationsResponse, OperationMetadata>
      batchDeleteConversationsOperationCallable() {
    return batchDeleteConversationsOperationCallable;
  }

  @Override
  public UnaryCallable<CreateToolRequest, Tool> createToolCallable() {
    return createToolCallable;
  }

  @Override
  public UnaryCallable<UpdateToolRequest, Tool> updateToolCallable() {
    return updateToolCallable;
  }

  @Override
  public UnaryCallable<DeleteToolRequest, Empty> deleteToolCallable() {
    return deleteToolCallable;
  }

  @Override
  public UnaryCallable<ListGuardrailsRequest, ListGuardrailsResponse> listGuardrailsCallable() {
    return listGuardrailsCallable;
  }

  @Override
  public UnaryCallable<ListGuardrailsRequest, ListGuardrailsPagedResponse>
      listGuardrailsPagedCallable() {
    return listGuardrailsPagedCallable;
  }

  @Override
  public UnaryCallable<GetGuardrailRequest, Guardrail> getGuardrailCallable() {
    return getGuardrailCallable;
  }

  @Override
  public UnaryCallable<CreateGuardrailRequest, Guardrail> createGuardrailCallable() {
    return createGuardrailCallable;
  }

  @Override
  public UnaryCallable<UpdateGuardrailRequest, Guardrail> updateGuardrailCallable() {
    return updateGuardrailCallable;
  }

  @Override
  public UnaryCallable<DeleteGuardrailRequest, Empty> deleteGuardrailCallable() {
    return deleteGuardrailCallable;
  }

  @Override
  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse> listDeploymentsCallable() {
    return listDeploymentsCallable;
  }

  @Override
  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable() {
    return listDeploymentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable() {
    return getDeploymentCallable;
  }

  @Override
  public UnaryCallable<CreateDeploymentRequest, Deployment> createDeploymentCallable() {
    return createDeploymentCallable;
  }

  @Override
  public UnaryCallable<UpdateDeploymentRequest, Deployment> updateDeploymentCallable() {
    return updateDeploymentCallable;
  }

  @Override
  public UnaryCallable<DeleteDeploymentRequest, Empty> deleteDeploymentCallable() {
    return deleteDeploymentCallable;
  }

  @Override
  public UnaryCallable<ListToolsetsRequest, ListToolsetsResponse> listToolsetsCallable() {
    return listToolsetsCallable;
  }

  @Override
  public UnaryCallable<ListToolsetsRequest, ListToolsetsPagedResponse> listToolsetsPagedCallable() {
    return listToolsetsPagedCallable;
  }

  @Override
  public UnaryCallable<GetToolsetRequest, Toolset> getToolsetCallable() {
    return getToolsetCallable;
  }

  @Override
  public UnaryCallable<CreateToolsetRequest, Toolset> createToolsetCallable() {
    return createToolsetCallable;
  }

  @Override
  public UnaryCallable<UpdateToolsetRequest, Toolset> updateToolsetCallable() {
    return updateToolsetCallable;
  }

  @Override
  public UnaryCallable<DeleteToolsetRequest, Empty> deleteToolsetCallable() {
    return deleteToolsetCallable;
  }

  @Override
  public UnaryCallable<ListAppVersionsRequest, ListAppVersionsResponse> listAppVersionsCallable() {
    return listAppVersionsCallable;
  }

  @Override
  public UnaryCallable<ListAppVersionsRequest, ListAppVersionsPagedResponse>
      listAppVersionsPagedCallable() {
    return listAppVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetAppVersionRequest, AppVersion> getAppVersionCallable() {
    return getAppVersionCallable;
  }

  @Override
  public UnaryCallable<CreateAppVersionRequest, AppVersion> createAppVersionCallable() {
    return createAppVersionCallable;
  }

  @Override
  public UnaryCallable<DeleteAppVersionRequest, Empty> deleteAppVersionCallable() {
    return deleteAppVersionCallable;
  }

  @Override
  public UnaryCallable<RestoreAppVersionRequest, Operation> restoreAppVersionCallable() {
    return restoreAppVersionCallable;
  }

  @Override
  public OperationCallable<RestoreAppVersionRequest, RestoreAppVersionResponse, OperationMetadata>
      restoreAppVersionOperationCallable() {
    return restoreAppVersionOperationCallable;
  }

  @Override
  public UnaryCallable<ListChangelogsRequest, ListChangelogsResponse> listChangelogsCallable() {
    return listChangelogsCallable;
  }

  @Override
  public UnaryCallable<ListChangelogsRequest, ListChangelogsPagedResponse>
      listChangelogsPagedCallable() {
    return listChangelogsPagedCallable;
  }

  @Override
  public UnaryCallable<GetChangelogRequest, Changelog> getChangelogCallable() {
    return getChangelogCallable;
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
