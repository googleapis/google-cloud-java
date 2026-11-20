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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
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
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AgentRegistry service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class GrpcAgentRegistryStub extends AgentRegistryStub {
  private static final MethodDescriptor<ListAgentsRequest, ListAgentsResponse>
      listAgentsMethodDescriptor =
          MethodDescriptor.<ListAgentsRequest, ListAgentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/ListAgents")
              .setRequestMarshaller(ProtoUtils.marshaller(ListAgentsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListAgentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SearchAgentsRequest, SearchAgentsResponse>
      searchAgentsMethodDescriptor =
          MethodDescriptor.<SearchAgentsRequest, SearchAgentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/SearchAgents")
              .setRequestMarshaller(ProtoUtils.marshaller(SearchAgentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchAgentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAgentRequest, Agent> getAgentMethodDescriptor =
      MethodDescriptor.<GetAgentRequest, Agent>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/GetAgent")
          .setRequestMarshaller(ProtoUtils.marshaller(GetAgentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Agent.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListEndpointsRequest, ListEndpointsResponse>
      listEndpointsMethodDescriptor =
          MethodDescriptor.<ListEndpointsRequest, ListEndpointsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/ListEndpoints")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEndpointsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEndpointsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetEndpointRequest, Endpoint> getEndpointMethodDescriptor =
      MethodDescriptor.<GetEndpointRequest, Endpoint>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/GetEndpoint")
          .setRequestMarshaller(ProtoUtils.marshaller(GetEndpointRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Endpoint.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListMcpServersRequest, ListMcpServersResponse>
      listMcpServersMethodDescriptor =
          MethodDescriptor.<ListMcpServersRequest, ListMcpServersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/ListMcpServers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMcpServersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMcpServersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SearchMcpServersRequest, SearchMcpServersResponse>
      searchMcpServersMethodDescriptor =
          MethodDescriptor.<SearchMcpServersRequest, SearchMcpServersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/SearchMcpServers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchMcpServersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchMcpServersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetMcpServerRequest, McpServer>
      getMcpServerMethodDescriptor =
          MethodDescriptor.<GetMcpServerRequest, McpServer>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/GetMcpServer")
              .setRequestMarshaller(ProtoUtils.marshaller(GetMcpServerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(McpServer.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListServicesRequest, ListServicesResponse>
      listServicesMethodDescriptor =
          MethodDescriptor.<ListServicesRequest, ListServicesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/ListServices")
              .setRequestMarshaller(ProtoUtils.marshaller(ListServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServicesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetServiceRequest, Service> getServiceMethodDescriptor =
      MethodDescriptor.<GetServiceRequest, Service>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/GetService")
          .setRequestMarshaller(ProtoUtils.marshaller(GetServiceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Service.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateServiceRequest, Operation>
      createServiceMethodDescriptor =
          MethodDescriptor.<CreateServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/CreateService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateServiceRequest, Operation>
      updateServiceMethodDescriptor =
          MethodDescriptor.<UpdateServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/UpdateService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteServiceRequest, Operation>
      deleteServiceMethodDescriptor =
          MethodDescriptor.<DeleteServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/DeleteService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListBindingsRequest, ListBindingsResponse>
      listBindingsMethodDescriptor =
          MethodDescriptor.<ListBindingsRequest, ListBindingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/ListBindings")
              .setRequestMarshaller(ProtoUtils.marshaller(ListBindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBindingsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetBindingRequest, Binding> getBindingMethodDescriptor =
      MethodDescriptor.<GetBindingRequest, Binding>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/GetBinding")
          .setRequestMarshaller(ProtoUtils.marshaller(GetBindingRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Binding.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateBindingRequest, Operation>
      createBindingMethodDescriptor =
          MethodDescriptor.<CreateBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/CreateBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateBindingRequest, Operation>
      updateBindingMethodDescriptor =
          MethodDescriptor.<UpdateBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/UpdateBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteBindingRequest, Operation>
      deleteBindingMethodDescriptor =
          MethodDescriptor.<DeleteBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/DeleteBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          FetchAvailableBindingsRequest, FetchAvailableBindingsResponse>
      fetchAvailableBindingsMethodDescriptor =
          MethodDescriptor
              .<FetchAvailableBindingsRequest, FetchAvailableBindingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.agentregistry.v1.AgentRegistry/FetchAvailableBindings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchAvailableBindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchAvailableBindingsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateSkillRequest, Operation> createSkillMethodDescriptor =
      MethodDescriptor.<CreateSkillRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/CreateSkill")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateSkillRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetSkillRequest, Skill> getSkillMethodDescriptor =
      MethodDescriptor.<GetSkillRequest, Skill>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/GetSkill")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSkillRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Skill.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateSkillRequest, Operation> updateSkillMethodDescriptor =
      MethodDescriptor.<UpdateSkillRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/UpdateSkill")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateSkillRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteSkillRequest, Operation> deleteSkillMethodDescriptor =
      MethodDescriptor.<DeleteSkillRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/DeleteSkill")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteSkillRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListSkillsRequest, ListSkillsResponse>
      listSkillsMethodDescriptor =
          MethodDescriptor.<ListSkillsRequest, ListSkillsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/ListSkills")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSkillsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListSkillsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SearchSkillsRequest, SearchSkillsResponse>
      searchSkillsMethodDescriptor =
          MethodDescriptor.<SearchSkillsRequest, SearchSkillsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/SearchSkills")
              .setRequestMarshaller(ProtoUtils.marshaller(SearchSkillsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchSkillsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateSkillRevisionRequest, Operation>
      createSkillRevisionMethodDescriptor =
          MethodDescriptor.<CreateSkillRevisionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/CreateSkillRevision")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSkillRevisionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetSkillRevisionRequest, SkillRevision>
      getSkillRevisionMethodDescriptor =
          MethodDescriptor.<GetSkillRevisionRequest, SkillRevision>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/GetSkillRevision")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSkillRevisionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SkillRevision.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteSkillRevisionRequest, Operation>
      deleteSkillRevisionMethodDescriptor =
          MethodDescriptor.<DeleteSkillRevisionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/DeleteSkillRevision")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSkillRevisionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListSkillRevisionsRequest, ListSkillRevisionsResponse>
      listSkillRevisionsMethodDescriptor =
          MethodDescriptor.<ListSkillRevisionsRequest, ListSkillRevisionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/ListSkillRevisions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSkillRevisionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSkillRevisionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetPublisherRequest, Publisher>
      getPublisherMethodDescriptor =
          MethodDescriptor.<GetPublisherRequest, Publisher>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/GetPublisher")
              .setRequestMarshaller(ProtoUtils.marshaller(GetPublisherRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Publisher.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListPublishersRequest, ListPublishersResponse>
      listPublishersMethodDescriptor =
          MethodDescriptor.<ListPublishersRequest, ListPublishersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/ListPublishers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPublishersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPublishersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAiApplicationRequest, AiApplication>
      getAiApplicationMethodDescriptor =
          MethodDescriptor.<GetAiApplicationRequest, AiApplication>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/GetAiApplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAiApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AiApplication.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListAiApplicationsRequest, ListAiApplicationsResponse>
      listAiApplicationsMethodDescriptor =
          MethodDescriptor.<ListAiApplicationsRequest, ListAiApplicationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/ListAiApplications")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAiApplicationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAiApplicationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAiApplicationAgentRequest, Agent>
      getAiApplicationAgentMethodDescriptor =
          MethodDescriptor.<GetAiApplicationAgentRequest, Agent>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.agentregistry.v1.AgentRegistry/GetAiApplicationAgent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAiApplicationAgentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Agent.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListAiApplicationAgentsRequest, ListAiApplicationAgentsResponse>
      listAiApplicationAgentsMethodDescriptor =
          MethodDescriptor
              .<ListAiApplicationAgentsRequest, ListAiApplicationAgentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.agentregistry.v1.AgentRegistry/ListAiApplicationAgents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAiApplicationAgentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAiApplicationAgentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAiApplicationMcpServerRequest, McpServer>
      getAiApplicationMcpServerMethodDescriptor =
          MethodDescriptor.<GetAiApplicationMcpServerRequest, McpServer>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.agentregistry.v1.AgentRegistry/GetAiApplicationMcpServer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAiApplicationMcpServerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(McpServer.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListAiApplicationMcpServersRequest, ListAiApplicationMcpServersResponse>
      listAiApplicationMcpServersMethodDescriptor =
          MethodDescriptor
              .<ListAiApplicationMcpServersRequest, ListAiApplicationMcpServersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.agentregistry.v1.AgentRegistry/ListAiApplicationMcpServers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAiApplicationMcpServersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAiApplicationMcpServersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetFindingRequest, Finding> getFindingMethodDescriptor =
      MethodDescriptor.<GetFindingRequest, Finding>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/GetFinding")
          .setRequestMarshaller(ProtoUtils.marshaller(GetFindingRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Finding.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListFindingsRequest, ListFindingsResponse>
      listFindingsMethodDescriptor =
          MethodDescriptor.<ListFindingsRequest, ListFindingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.agentregistry.v1.AgentRegistry/ListFindings")
              .setRequestMarshaller(ProtoUtils.marshaller(ListFindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFindingsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAiApplicationEndpointRequest, Endpoint>
      getAiApplicationEndpointMethodDescriptor =
          MethodDescriptor.<GetAiApplicationEndpointRequest, Endpoint>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.agentregistry.v1.AgentRegistry/GetAiApplicationEndpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAiApplicationEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Endpoint.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListAiApplicationEndpointsRequest, ListAiApplicationEndpointsResponse>
      listAiApplicationEndpointsMethodDescriptor =
          MethodDescriptor
              .<ListAiApplicationEndpointsRequest, ListAiApplicationEndpointsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.agentregistry.v1.AgentRegistry/ListAiApplicationEndpoints")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAiApplicationEndpointsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAiApplicationEndpointsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetSkillEncryptionSpecRequest, SkillEncryptionSpec>
      getSkillEncryptionSpecMethodDescriptor =
          MethodDescriptor.<GetSkillEncryptionSpecRequest, SkillEncryptionSpec>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.agentregistry.v1.AgentRegistry/GetSkillEncryptionSpec")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSkillEncryptionSpecRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SkillEncryptionSpec.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateSkillEncryptionSpecRequest, Operation>
      updateSkillEncryptionSpecMethodDescriptor =
          MethodDescriptor.<UpdateSkillEncryptionSpecRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.agentregistry.v1.AgentRegistry/UpdateSkillEncryptionSpec")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSkillEncryptionSpecRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAgentRegistryStub create(AgentRegistryStubSettings settings)
      throws IOException {
    return new GrpcAgentRegistryStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAgentRegistryStub create(ClientContext clientContext) throws IOException {
    return new GrpcAgentRegistryStub(AgentRegistryStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAgentRegistryStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAgentRegistryStub(
        AgentRegistryStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAgentRegistryStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAgentRegistryStub(AgentRegistryStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAgentRegistryCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAgentRegistryStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAgentRegistryStub(
      AgentRegistryStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListAgentsRequest, ListAgentsResponse> listAgentsTransportSettings =
        GrpcCallSettings.<ListAgentsRequest, ListAgentsResponse>newBuilder()
            .setMethodDescriptor(listAgentsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<SearchAgentsRequest, SearchAgentsResponse> searchAgentsTransportSettings =
        GrpcCallSettings.<SearchAgentsRequest, SearchAgentsResponse>newBuilder()
            .setMethodDescriptor(searchAgentsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
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
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListEndpointsRequest, ListEndpointsResponse> listEndpointsTransportSettings =
        GrpcCallSettings.<ListEndpointsRequest, ListEndpointsResponse>newBuilder()
            .setMethodDescriptor(listEndpointsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetEndpointRequest, Endpoint> getEndpointTransportSettings =
        GrpcCallSettings.<GetEndpointRequest, Endpoint>newBuilder()
            .setMethodDescriptor(getEndpointMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListMcpServersRequest, ListMcpServersResponse>
        listMcpServersTransportSettings =
            GrpcCallSettings.<ListMcpServersRequest, ListMcpServersResponse>newBuilder()
                .setMethodDescriptor(listMcpServersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<SearchMcpServersRequest, SearchMcpServersResponse>
        searchMcpServersTransportSettings =
            GrpcCallSettings.<SearchMcpServersRequest, SearchMcpServersResponse>newBuilder()
                .setMethodDescriptor(searchMcpServersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetMcpServerRequest, McpServer> getMcpServerTransportSettings =
        GrpcCallSettings.<GetMcpServerRequest, McpServer>newBuilder()
            .setMethodDescriptor(getMcpServerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListServicesRequest, ListServicesResponse> listServicesTransportSettings =
        GrpcCallSettings.<ListServicesRequest, ListServicesResponse>newBuilder()
            .setMethodDescriptor(listServicesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetServiceRequest, Service> getServiceTransportSettings =
        GrpcCallSettings.<GetServiceRequest, Service>newBuilder()
            .setMethodDescriptor(getServiceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreateServiceRequest, Operation> createServiceTransportSettings =
        GrpcCallSettings.<CreateServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(createServiceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateServiceRequest, Operation> updateServiceTransportSettings =
        GrpcCallSettings.<UpdateServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateServiceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("service.name", String.valueOf(request.getService().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteServiceRequest, Operation> deleteServiceTransportSettings =
        GrpcCallSettings.<DeleteServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteServiceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListBindingsRequest, ListBindingsResponse> listBindingsTransportSettings =
        GrpcCallSettings.<ListBindingsRequest, ListBindingsResponse>newBuilder()
            .setMethodDescriptor(listBindingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetBindingRequest, Binding> getBindingTransportSettings =
        GrpcCallSettings.<GetBindingRequest, Binding>newBuilder()
            .setMethodDescriptor(getBindingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreateBindingRequest, Operation> createBindingTransportSettings =
        GrpcCallSettings.<CreateBindingRequest, Operation>newBuilder()
            .setMethodDescriptor(createBindingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateBindingRequest, Operation> updateBindingTransportSettings =
        GrpcCallSettings.<UpdateBindingRequest, Operation>newBuilder()
            .setMethodDescriptor(updateBindingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("binding.name", String.valueOf(request.getBinding().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteBindingRequest, Operation> deleteBindingTransportSettings =
        GrpcCallSettings.<DeleteBindingRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteBindingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<FetchAvailableBindingsRequest, FetchAvailableBindingsResponse>
        fetchAvailableBindingsTransportSettings =
            GrpcCallSettings
                .<FetchAvailableBindingsRequest, FetchAvailableBindingsResponse>newBuilder()
                .setMethodDescriptor(fetchAvailableBindingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<CreateSkillRequest, Operation> createSkillTransportSettings =
        GrpcCallSettings.<CreateSkillRequest, Operation>newBuilder()
            .setMethodDescriptor(createSkillMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetSkillRequest, Skill> getSkillTransportSettings =
        GrpcCallSettings.<GetSkillRequest, Skill>newBuilder()
            .setMethodDescriptor(getSkillMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<UpdateSkillRequest, Operation> updateSkillTransportSettings =
        GrpcCallSettings.<UpdateSkillRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSkillMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("skill.name", String.valueOf(request.getSkill().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteSkillRequest, Operation> deleteSkillTransportSettings =
        GrpcCallSettings.<DeleteSkillRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSkillMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListSkillsRequest, ListSkillsResponse> listSkillsTransportSettings =
        GrpcCallSettings.<ListSkillsRequest, ListSkillsResponse>newBuilder()
            .setMethodDescriptor(listSkillsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<SearchSkillsRequest, SearchSkillsResponse> searchSkillsTransportSettings =
        GrpcCallSettings.<SearchSkillsRequest, SearchSkillsResponse>newBuilder()
            .setMethodDescriptor(searchSkillsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<CreateSkillRevisionRequest, Operation> createSkillRevisionTransportSettings =
        GrpcCallSettings.<CreateSkillRevisionRequest, Operation>newBuilder()
            .setMethodDescriptor(createSkillRevisionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetSkillRevisionRequest, SkillRevision> getSkillRevisionTransportSettings =
        GrpcCallSettings.<GetSkillRevisionRequest, SkillRevision>newBuilder()
            .setMethodDescriptor(getSkillRevisionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<DeleteSkillRevisionRequest, Operation> deleteSkillRevisionTransportSettings =
        GrpcCallSettings.<DeleteSkillRevisionRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSkillRevisionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListSkillRevisionsRequest, ListSkillRevisionsResponse>
        listSkillRevisionsTransportSettings =
            GrpcCallSettings.<ListSkillRevisionsRequest, ListSkillRevisionsResponse>newBuilder()
                .setMethodDescriptor(listSkillRevisionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetPublisherRequest, Publisher> getPublisherTransportSettings =
        GrpcCallSettings.<GetPublisherRequest, Publisher>newBuilder()
            .setMethodDescriptor(getPublisherMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListPublishersRequest, ListPublishersResponse>
        listPublishersTransportSettings =
            GrpcCallSettings.<ListPublishersRequest, ListPublishersResponse>newBuilder()
                .setMethodDescriptor(listPublishersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetAiApplicationRequest, AiApplication> getAiApplicationTransportSettings =
        GrpcCallSettings.<GetAiApplicationRequest, AiApplication>newBuilder()
            .setMethodDescriptor(getAiApplicationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListAiApplicationsRequest, ListAiApplicationsResponse>
        listAiApplicationsTransportSettings =
            GrpcCallSettings.<ListAiApplicationsRequest, ListAiApplicationsResponse>newBuilder()
                .setMethodDescriptor(listAiApplicationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetAiApplicationAgentRequest, Agent> getAiApplicationAgentTransportSettings =
        GrpcCallSettings.<GetAiApplicationAgentRequest, Agent>newBuilder()
            .setMethodDescriptor(getAiApplicationAgentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListAiApplicationAgentsRequest, ListAiApplicationAgentsResponse>
        listAiApplicationAgentsTransportSettings =
            GrpcCallSettings
                .<ListAiApplicationAgentsRequest, ListAiApplicationAgentsResponse>newBuilder()
                .setMethodDescriptor(listAiApplicationAgentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetAiApplicationMcpServerRequest, McpServer>
        getAiApplicationMcpServerTransportSettings =
            GrpcCallSettings.<GetAiApplicationMcpServerRequest, McpServer>newBuilder()
                .setMethodDescriptor(getAiApplicationMcpServerMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListAiApplicationMcpServersRequest, ListAiApplicationMcpServersResponse>
        listAiApplicationMcpServersTransportSettings =
            GrpcCallSettings
                .<ListAiApplicationMcpServersRequest, ListAiApplicationMcpServersResponse>
                    newBuilder()
                .setMethodDescriptor(listAiApplicationMcpServersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetFindingRequest, Finding> getFindingTransportSettings =
        GrpcCallSettings.<GetFindingRequest, Finding>newBuilder()
            .setMethodDescriptor(getFindingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListFindingsRequest, ListFindingsResponse> listFindingsTransportSettings =
        GrpcCallSettings.<ListFindingsRequest, ListFindingsResponse>newBuilder()
            .setMethodDescriptor(listFindingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetAiApplicationEndpointRequest, Endpoint>
        getAiApplicationEndpointTransportSettings =
            GrpcCallSettings.<GetAiApplicationEndpointRequest, Endpoint>newBuilder()
                .setMethodDescriptor(getAiApplicationEndpointMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListAiApplicationEndpointsRequest, ListAiApplicationEndpointsResponse>
        listAiApplicationEndpointsTransportSettings =
            GrpcCallSettings
                .<ListAiApplicationEndpointsRequest, ListAiApplicationEndpointsResponse>newBuilder()
                .setMethodDescriptor(listAiApplicationEndpointsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetSkillEncryptionSpecRequest, SkillEncryptionSpec>
        getSkillEncryptionSpecTransportSettings =
            GrpcCallSettings.<GetSkillEncryptionSpecRequest, SkillEncryptionSpec>newBuilder()
                .setMethodDescriptor(getSkillEncryptionSpecMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<UpdateSkillEncryptionSpecRequest, Operation>
        updateSkillEncryptionSpecTransportSettings =
            GrpcCallSettings.<UpdateSkillEncryptionSpecRequest, Operation>newBuilder()
                .setMethodDescriptor(updateSkillEncryptionSpecMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "skill_encryption_spec.name",
                          String.valueOf(request.getSkillEncryptionSpec().getName()));
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
            operationsStub);
    this.updateServiceCallable =
        callableFactory.createUnaryCallable(
            updateServiceTransportSettings, settings.updateServiceSettings(), clientContext);
    this.updateServiceOperationCallable =
        callableFactory.createOperationCallable(
            updateServiceTransportSettings,
            settings.updateServiceOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteServiceCallable =
        callableFactory.createUnaryCallable(
            deleteServiceTransportSettings, settings.deleteServiceSettings(), clientContext);
    this.deleteServiceOperationCallable =
        callableFactory.createOperationCallable(
            deleteServiceTransportSettings,
            settings.deleteServiceOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
    this.updateBindingCallable =
        callableFactory.createUnaryCallable(
            updateBindingTransportSettings, settings.updateBindingSettings(), clientContext);
    this.updateBindingOperationCallable =
        callableFactory.createOperationCallable(
            updateBindingTransportSettings,
            settings.updateBindingOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteBindingCallable =
        callableFactory.createUnaryCallable(
            deleteBindingTransportSettings, settings.deleteBindingSettings(), clientContext);
    this.deleteBindingOperationCallable =
        callableFactory.createOperationCallable(
            deleteBindingTransportSettings,
            settings.deleteBindingOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
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
            operationsStub);
    this.deleteSkillCallable =
        callableFactory.createUnaryCallable(
            deleteSkillTransportSettings, settings.deleteSkillSettings(), clientContext);
    this.deleteSkillOperationCallable =
        callableFactory.createOperationCallable(
            deleteSkillTransportSettings,
            settings.deleteSkillOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
