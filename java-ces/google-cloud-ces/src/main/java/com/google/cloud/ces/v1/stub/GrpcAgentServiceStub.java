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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
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
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AgentService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAgentServiceStub extends AgentServiceStub {
  private static final MethodDescriptor<ListAppsRequest, ListAppsResponse>
      listAppsMethodDescriptor =
          MethodDescriptor.<ListAppsRequest, ListAppsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/ListApps")
              .setRequestMarshaller(ProtoUtils.marshaller(ListAppsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListAppsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAppRequest, App> getAppMethodDescriptor =
      MethodDescriptor.<GetAppRequest, App>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.ces.v1.AgentService/GetApp")
          .setRequestMarshaller(ProtoUtils.marshaller(GetAppRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(App.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateAppRequest, Operation> createAppMethodDescriptor =
      MethodDescriptor.<CreateAppRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.ces.v1.AgentService/CreateApp")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateAppRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateAppRequest, App> updateAppMethodDescriptor =
      MethodDescriptor.<UpdateAppRequest, App>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.ces.v1.AgentService/UpdateApp")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateAppRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(App.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteAppRequest, Operation> deleteAppMethodDescriptor =
      MethodDescriptor.<DeleteAppRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.ces.v1.AgentService/DeleteApp")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteAppRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ExportAppRequest, Operation> exportAppMethodDescriptor =
      MethodDescriptor.<ExportAppRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.ces.v1.AgentService/ExportApp")
          .setRequestMarshaller(ProtoUtils.marshaller(ExportAppRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ImportAppRequest, Operation> importAppMethodDescriptor =
      MethodDescriptor.<ImportAppRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.ces.v1.AgentService/ImportApp")
          .setRequestMarshaller(ProtoUtils.marshaller(ImportAppRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListAgentsRequest, ListAgentsResponse>
      listAgentsMethodDescriptor =
          MethodDescriptor.<ListAgentsRequest, ListAgentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/ListAgents")
              .setRequestMarshaller(ProtoUtils.marshaller(ListAgentsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListAgentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAgentRequest, Agent> getAgentMethodDescriptor =
      MethodDescriptor.<GetAgentRequest, Agent>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.ces.v1.AgentService/GetAgent")
          .setRequestMarshaller(ProtoUtils.marshaller(GetAgentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Agent.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateAgentRequest, Agent> createAgentMethodDescriptor =
      MethodDescriptor.<CreateAgentRequest, Agent>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.ces.v1.AgentService/CreateAgent")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateAgentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Agent.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateAgentRequest, Agent> updateAgentMethodDescriptor =
      MethodDescriptor.<UpdateAgentRequest, Agent>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.ces.v1.AgentService/UpdateAgent")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateAgentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Agent.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteAgentRequest, Empty> deleteAgentMethodDescriptor =
      MethodDescriptor.<DeleteAgentRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.ces.v1.AgentService/DeleteAgent")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteAgentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListExamplesRequest, ListExamplesResponse>
      listExamplesMethodDescriptor =
          MethodDescriptor.<ListExamplesRequest, ListExamplesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/ListExamples")
              .setRequestMarshaller(ProtoUtils.marshaller(ListExamplesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListExamplesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetExampleRequest, Example> getExampleMethodDescriptor =
      MethodDescriptor.<GetExampleRequest, Example>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.ces.v1.AgentService/GetExample")
          .setRequestMarshaller(ProtoUtils.marshaller(GetExampleRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Example.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateExampleRequest, Example>
      createExampleMethodDescriptor =
          MethodDescriptor.<CreateExampleRequest, Example>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/CreateExample")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateExampleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Example.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateExampleRequest, Example>
      updateExampleMethodDescriptor =
          MethodDescriptor.<UpdateExampleRequest, Example>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/UpdateExample")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateExampleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Example.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteExampleRequest, Empty> deleteExampleMethodDescriptor =
      MethodDescriptor.<DeleteExampleRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.ces.v1.AgentService/DeleteExample")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteExampleRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListToolsRequest, ListToolsResponse>
      listToolsMethodDescriptor =
          MethodDescriptor.<ListToolsRequest, ListToolsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/ListTools")
              .setRequestMarshaller(ProtoUtils.marshaller(ListToolsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListToolsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetToolRequest, Tool> getToolMethodDescriptor =
      MethodDescriptor.<GetToolRequest, Tool>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.ces.v1.AgentService/GetTool")
          .setRequestMarshaller(ProtoUtils.marshaller(GetToolRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Tool.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListConversationsRequest, ListConversationsResponse>
      listConversationsMethodDescriptor =
          MethodDescriptor.<ListConversationsRequest, ListConversationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/ListConversations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConversationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConversationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetConversationRequest, Conversation>
      getConversationMethodDescriptor =
          MethodDescriptor.<GetConversationRequest, Conversation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/GetConversation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConversationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Conversation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteConversationRequest, Empty>
      deleteConversationMethodDescriptor =
          MethodDescriptor.<DeleteConversationRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/DeleteConversation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteConversationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<BatchDeleteConversationsRequest, Operation>
      batchDeleteConversationsMethodDescriptor =
          MethodDescriptor.<BatchDeleteConversationsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/BatchDeleteConversations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchDeleteConversationsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateToolRequest, Tool> createToolMethodDescriptor =
      MethodDescriptor.<CreateToolRequest, Tool>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.ces.v1.AgentService/CreateTool")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateToolRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Tool.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateToolRequest, Tool> updateToolMethodDescriptor =
      MethodDescriptor.<UpdateToolRequest, Tool>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.ces.v1.AgentService/UpdateTool")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateToolRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Tool.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteToolRequest, Empty> deleteToolMethodDescriptor =
      MethodDescriptor.<DeleteToolRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.ces.v1.AgentService/DeleteTool")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteToolRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListGuardrailsRequest, ListGuardrailsResponse>
      listGuardrailsMethodDescriptor =
          MethodDescriptor.<ListGuardrailsRequest, ListGuardrailsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/ListGuardrails")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListGuardrailsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListGuardrailsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetGuardrailRequest, Guardrail>
      getGuardrailMethodDescriptor =
          MethodDescriptor.<GetGuardrailRequest, Guardrail>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/GetGuardrail")
              .setRequestMarshaller(ProtoUtils.marshaller(GetGuardrailRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Guardrail.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateGuardrailRequest, Guardrail>
      createGuardrailMethodDescriptor =
          MethodDescriptor.<CreateGuardrailRequest, Guardrail>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/CreateGuardrail")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateGuardrailRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Guardrail.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateGuardrailRequest, Guardrail>
      updateGuardrailMethodDescriptor =
          MethodDescriptor.<UpdateGuardrailRequest, Guardrail>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/UpdateGuardrail")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateGuardrailRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Guardrail.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteGuardrailRequest, Empty>
      deleteGuardrailMethodDescriptor =
          MethodDescriptor.<DeleteGuardrailRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/DeleteGuardrail")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteGuardrailRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListDeploymentsRequest, ListDeploymentsResponse>
      listDeploymentsMethodDescriptor =
          MethodDescriptor.<ListDeploymentsRequest, ListDeploymentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/ListDeployments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDeploymentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDeploymentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetDeploymentRequest, Deployment>
      getDeploymentMethodDescriptor =
          MethodDescriptor.<GetDeploymentRequest, Deployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/GetDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Deployment.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateDeploymentRequest, Deployment>
      createDeploymentMethodDescriptor =
          MethodDescriptor.<CreateDeploymentRequest, Deployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/CreateDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Deployment.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateDeploymentRequest, Deployment>
      updateDeploymentMethodDescriptor =
          MethodDescriptor.<UpdateDeploymentRequest, Deployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/UpdateDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Deployment.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteDeploymentRequest, Empty>
      deleteDeploymentMethodDescriptor =
          MethodDescriptor.<DeleteDeploymentRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/DeleteDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListToolsetsRequest, ListToolsetsResponse>
      listToolsetsMethodDescriptor =
          MethodDescriptor.<ListToolsetsRequest, ListToolsetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/ListToolsets")
              .setRequestMarshaller(ProtoUtils.marshaller(ListToolsetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListToolsetsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetToolsetRequest, Toolset> getToolsetMethodDescriptor =
      MethodDescriptor.<GetToolsetRequest, Toolset>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.ces.v1.AgentService/GetToolset")
          .setRequestMarshaller(ProtoUtils.marshaller(GetToolsetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Toolset.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateToolsetRequest, Toolset>
      createToolsetMethodDescriptor =
          MethodDescriptor.<CreateToolsetRequest, Toolset>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/CreateToolset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateToolsetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Toolset.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateToolsetRequest, Toolset>
      updateToolsetMethodDescriptor =
          MethodDescriptor.<UpdateToolsetRequest, Toolset>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/UpdateToolset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateToolsetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Toolset.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteToolsetRequest, Empty> deleteToolsetMethodDescriptor =
      MethodDescriptor.<DeleteToolsetRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.ces.v1.AgentService/DeleteToolset")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteToolsetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListAppVersionsRequest, ListAppVersionsResponse>
      listAppVersionsMethodDescriptor =
          MethodDescriptor.<ListAppVersionsRequest, ListAppVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/ListAppVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAppVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAppVersionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAppVersionRequest, AppVersion>
      getAppVersionMethodDescriptor =
          MethodDescriptor.<GetAppVersionRequest, AppVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/GetAppVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAppVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AppVersion.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateAppVersionRequest, AppVersion>
      createAppVersionMethodDescriptor =
          MethodDescriptor.<CreateAppVersionRequest, AppVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/CreateAppVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAppVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AppVersion.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteAppVersionRequest, Empty>
      deleteAppVersionMethodDescriptor =
          MethodDescriptor.<DeleteAppVersionRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/DeleteAppVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAppVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RestoreAppVersionRequest, Operation>
      restoreAppVersionMethodDescriptor =
          MethodDescriptor.<RestoreAppVersionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/RestoreAppVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RestoreAppVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListChangelogsRequest, ListChangelogsResponse>
      listChangelogsMethodDescriptor =
          MethodDescriptor.<ListChangelogsRequest, ListChangelogsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/ListChangelogs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListChangelogsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListChangelogsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetChangelogRequest, Changelog>
      getChangelogMethodDescriptor =
          MethodDescriptor.<GetChangelogRequest, Changelog>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1.AgentService/GetChangelog")
              .setRequestMarshaller(ProtoUtils.marshaller(GetChangelogRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Changelog.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAgentServiceStub create(AgentServiceStubSettings settings)
      throws IOException {
    return new GrpcAgentServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAgentServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcAgentServiceStub(AgentServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAgentServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAgentServiceStub(
        AgentServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAgentServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAgentServiceStub(AgentServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAgentServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAgentServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAgentServiceStub(
      AgentServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListAppsRequest, ListAppsResponse> listAppsTransportSettings =
        GrpcCallSettings.<ListAppsRequest, ListAppsResponse>newBuilder()
            .setMethodDescriptor(listAppsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetAppRequest, App> getAppTransportSettings =
        GrpcCallSettings.<GetAppRequest, App>newBuilder()
            .setMethodDescriptor(getAppMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateAppRequest, Operation> createAppTransportSettings =
        GrpcCallSettings.<CreateAppRequest, Operation>newBuilder()
            .setMethodDescriptor(createAppMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateAppRequest, App> updateAppTransportSettings =
        GrpcCallSettings.<UpdateAppRequest, App>newBuilder()
            .setMethodDescriptor(updateAppMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("app.name", String.valueOf(request.getApp().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteAppRequest, Operation> deleteAppTransportSettings =
        GrpcCallSettings.<DeleteAppRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAppMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ExportAppRequest, Operation> exportAppTransportSettings =
        GrpcCallSettings.<ExportAppRequest, Operation>newBuilder()
            .setMethodDescriptor(exportAppMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ImportAppRequest, Operation> importAppTransportSettings =
        GrpcCallSettings.<ImportAppRequest, Operation>newBuilder()
            .setMethodDescriptor(importAppMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListAgentsRequest, ListAgentsResponse> listAgentsTransportSettings =
        GrpcCallSettings.<ListAgentsRequest, ListAgentsResponse>newBuilder()
            .setMethodDescriptor(listAgentsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetAgentRequest, Agent> getAgentTransportSettings =
        GrpcCallSettings.<GetAgentRequest, Agent>newBuilder()
            .setMethodDescriptor(getAgentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateAgentRequest, Agent> createAgentTransportSettings =
        GrpcCallSettings.<CreateAgentRequest, Agent>newBuilder()
            .setMethodDescriptor(createAgentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateAgentRequest, Agent> updateAgentTransportSettings =
        GrpcCallSettings.<UpdateAgentRequest, Agent>newBuilder()
            .setMethodDescriptor(updateAgentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("agent.name", String.valueOf(request.getAgent().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteAgentRequest, Empty> deleteAgentTransportSettings =
        GrpcCallSettings.<DeleteAgentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAgentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListExamplesRequest, ListExamplesResponse> listExamplesTransportSettings =
        GrpcCallSettings.<ListExamplesRequest, ListExamplesResponse>newBuilder()
            .setMethodDescriptor(listExamplesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetExampleRequest, Example> getExampleTransportSettings =
        GrpcCallSettings.<GetExampleRequest, Example>newBuilder()
            .setMethodDescriptor(getExampleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateExampleRequest, Example> createExampleTransportSettings =
        GrpcCallSettings.<CreateExampleRequest, Example>newBuilder()
            .setMethodDescriptor(createExampleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateExampleRequest, Example> updateExampleTransportSettings =
        GrpcCallSettings.<UpdateExampleRequest, Example>newBuilder()
            .setMethodDescriptor(updateExampleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("example.name", String.valueOf(request.getExample().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteExampleRequest, Empty> deleteExampleTransportSettings =
        GrpcCallSettings.<DeleteExampleRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteExampleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListToolsRequest, ListToolsResponse> listToolsTransportSettings =
        GrpcCallSettings.<ListToolsRequest, ListToolsResponse>newBuilder()
            .setMethodDescriptor(listToolsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetToolRequest, Tool> getToolTransportSettings =
        GrpcCallSettings.<GetToolRequest, Tool>newBuilder()
            .setMethodDescriptor(getToolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListConversationsRequest, ListConversationsResponse>
        listConversationsTransportSettings =
            GrpcCallSettings.<ListConversationsRequest, ListConversationsResponse>newBuilder()
                .setMethodDescriptor(listConversationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetConversationRequest, Conversation> getConversationTransportSettings =
        GrpcCallSettings.<GetConversationRequest, Conversation>newBuilder()
            .setMethodDescriptor(getConversationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteConversationRequest, Empty> deleteConversationTransportSettings =
        GrpcCallSettings.<DeleteConversationRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteConversationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<BatchDeleteConversationsRequest, Operation>
        batchDeleteConversationsTransportSettings =
            GrpcCallSettings.<BatchDeleteConversationsRequest, Operation>newBuilder()
                .setMethodDescriptor(batchDeleteConversationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateToolRequest, Tool> createToolTransportSettings =
        GrpcCallSettings.<CreateToolRequest, Tool>newBuilder()
            .setMethodDescriptor(createToolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateToolRequest, Tool> updateToolTransportSettings =
        GrpcCallSettings.<UpdateToolRequest, Tool>newBuilder()
            .setMethodDescriptor(updateToolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("tool.name", String.valueOf(request.getTool().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteToolRequest, Empty> deleteToolTransportSettings =
        GrpcCallSettings.<DeleteToolRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteToolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListGuardrailsRequest, ListGuardrailsResponse>
        listGuardrailsTransportSettings =
            GrpcCallSettings.<ListGuardrailsRequest, ListGuardrailsResponse>newBuilder()
                .setMethodDescriptor(listGuardrailsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetGuardrailRequest, Guardrail> getGuardrailTransportSettings =
        GrpcCallSettings.<GetGuardrailRequest, Guardrail>newBuilder()
            .setMethodDescriptor(getGuardrailMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateGuardrailRequest, Guardrail> createGuardrailTransportSettings =
        GrpcCallSettings.<CreateGuardrailRequest, Guardrail>newBuilder()
            .setMethodDescriptor(createGuardrailMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateGuardrailRequest, Guardrail> updateGuardrailTransportSettings =
        GrpcCallSettings.<UpdateGuardrailRequest, Guardrail>newBuilder()
            .setMethodDescriptor(updateGuardrailMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("guardrail.name", String.valueOf(request.getGuardrail().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteGuardrailRequest, Empty> deleteGuardrailTransportSettings =
        GrpcCallSettings.<DeleteGuardrailRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteGuardrailMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDeploymentsRequest, ListDeploymentsResponse>
        listDeploymentsTransportSettings =
            GrpcCallSettings.<ListDeploymentsRequest, ListDeploymentsResponse>newBuilder()
                .setMethodDescriptor(listDeploymentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetDeploymentRequest, Deployment> getDeploymentTransportSettings =
        GrpcCallSettings.<GetDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(getDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateDeploymentRequest, Deployment> createDeploymentTransportSettings =
        GrpcCallSettings.<CreateDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(createDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDeploymentRequest, Deployment> updateDeploymentTransportSettings =
        GrpcCallSettings.<UpdateDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(updateDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("deployment.name", String.valueOf(request.getDeployment().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDeploymentRequest, Empty> deleteDeploymentTransportSettings =
        GrpcCallSettings.<DeleteDeploymentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListToolsetsRequest, ListToolsetsResponse> listToolsetsTransportSettings =
        GrpcCallSettings.<ListToolsetsRequest, ListToolsetsResponse>newBuilder()
            .setMethodDescriptor(listToolsetsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetToolsetRequest, Toolset> getToolsetTransportSettings =
        GrpcCallSettings.<GetToolsetRequest, Toolset>newBuilder()
            .setMethodDescriptor(getToolsetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateToolsetRequest, Toolset> createToolsetTransportSettings =
        GrpcCallSettings.<CreateToolsetRequest, Toolset>newBuilder()
            .setMethodDescriptor(createToolsetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateToolsetRequest, Toolset> updateToolsetTransportSettings =
        GrpcCallSettings.<UpdateToolsetRequest, Toolset>newBuilder()
            .setMethodDescriptor(updateToolsetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("toolset.name", String.valueOf(request.getToolset().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteToolsetRequest, Empty> deleteToolsetTransportSettings =
        GrpcCallSettings.<DeleteToolsetRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteToolsetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListAppVersionsRequest, ListAppVersionsResponse>
        listAppVersionsTransportSettings =
            GrpcCallSettings.<ListAppVersionsRequest, ListAppVersionsResponse>newBuilder()
                .setMethodDescriptor(listAppVersionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetAppVersionRequest, AppVersion> getAppVersionTransportSettings =
        GrpcCallSettings.<GetAppVersionRequest, AppVersion>newBuilder()
            .setMethodDescriptor(getAppVersionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateAppVersionRequest, AppVersion> createAppVersionTransportSettings =
        GrpcCallSettings.<CreateAppVersionRequest, AppVersion>newBuilder()
            .setMethodDescriptor(createAppVersionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteAppVersionRequest, Empty> deleteAppVersionTransportSettings =
        GrpcCallSettings.<DeleteAppVersionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAppVersionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RestoreAppVersionRequest, Operation> restoreAppVersionTransportSettings =
        GrpcCallSettings.<RestoreAppVersionRequest, Operation>newBuilder()
            .setMethodDescriptor(restoreAppVersionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListChangelogsRequest, ListChangelogsResponse>
        listChangelogsTransportSettings =
            GrpcCallSettings.<ListChangelogsRequest, ListChangelogsResponse>newBuilder()
                .setMethodDescriptor(listChangelogsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetChangelogRequest, Changelog> getChangelogTransportSettings =
        GrpcCallSettings.<GetChangelogRequest, Changelog>newBuilder()
            .setMethodDescriptor(getChangelogMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
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
            operationsStub);
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
            operationsStub);
    this.exportAppCallable =
        callableFactory.createUnaryCallable(
            exportAppTransportSettings, settings.exportAppSettings(), clientContext);
    this.exportAppOperationCallable =
        callableFactory.createOperationCallable(
            exportAppTransportSettings,
            settings.exportAppOperationSettings(),
            clientContext,
            operationsStub);
    this.importAppCallable =
        callableFactory.createUnaryCallable(
            importAppTransportSettings, settings.importAppSettings(), clientContext);
    this.importAppOperationCallable =
        callableFactory.createOperationCallable(
            importAppTransportSettings,
            settings.importAppOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
