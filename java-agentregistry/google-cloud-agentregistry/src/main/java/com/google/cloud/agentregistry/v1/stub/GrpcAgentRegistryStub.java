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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
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
