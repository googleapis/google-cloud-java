/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.agentregistry.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing Agents, Endpoints, McpServers, Services, and Bindings.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class AgentRegistryGrpc {

  private AgentRegistryGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.agentregistry.v1.AgentRegistry";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.ListAgentsRequest,
          com.google.cloud.agentregistry.v1.ListAgentsResponse>
      getListAgentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAgents",
      requestType = com.google.cloud.agentregistry.v1.ListAgentsRequest.class,
      responseType = com.google.cloud.agentregistry.v1.ListAgentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.ListAgentsRequest,
          com.google.cloud.agentregistry.v1.ListAgentsResponse>
      getListAgentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.ListAgentsRequest,
            com.google.cloud.agentregistry.v1.ListAgentsResponse>
        getListAgentsMethod;
    if ((getListAgentsMethod = AgentRegistryGrpc.getListAgentsMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getListAgentsMethod = AgentRegistryGrpc.getListAgentsMethod) == null) {
          AgentRegistryGrpc.getListAgentsMethod =
              getListAgentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.ListAgentsRequest,
                          com.google.cloud.agentregistry.v1.ListAgentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAgents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.ListAgentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.ListAgentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AgentRegistryMethodDescriptorSupplier("ListAgents"))
                      .build();
        }
      }
    }
    return getListAgentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.SearchAgentsRequest,
          com.google.cloud.agentregistry.v1.SearchAgentsResponse>
      getSearchAgentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchAgents",
      requestType = com.google.cloud.agentregistry.v1.SearchAgentsRequest.class,
      responseType = com.google.cloud.agentregistry.v1.SearchAgentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.SearchAgentsRequest,
          com.google.cloud.agentregistry.v1.SearchAgentsResponse>
      getSearchAgentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.SearchAgentsRequest,
            com.google.cloud.agentregistry.v1.SearchAgentsResponse>
        getSearchAgentsMethod;
    if ((getSearchAgentsMethod = AgentRegistryGrpc.getSearchAgentsMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getSearchAgentsMethod = AgentRegistryGrpc.getSearchAgentsMethod) == null) {
          AgentRegistryGrpc.getSearchAgentsMethod =
              getSearchAgentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.SearchAgentsRequest,
                          com.google.cloud.agentregistry.v1.SearchAgentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchAgents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.SearchAgentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.SearchAgentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("SearchAgents"))
                      .build();
        }
      }
    }
    return getSearchAgentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetAgentRequest,
          com.google.cloud.agentregistry.v1.Agent>
      getGetAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAgent",
      requestType = com.google.cloud.agentregistry.v1.GetAgentRequest.class,
      responseType = com.google.cloud.agentregistry.v1.Agent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetAgentRequest,
          com.google.cloud.agentregistry.v1.Agent>
      getGetAgentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.GetAgentRequest,
            com.google.cloud.agentregistry.v1.Agent>
        getGetAgentMethod;
    if ((getGetAgentMethod = AgentRegistryGrpc.getGetAgentMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getGetAgentMethod = AgentRegistryGrpc.getGetAgentMethod) == null) {
          AgentRegistryGrpc.getGetAgentMethod =
              getGetAgentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.GetAgentRequest,
                          com.google.cloud.agentregistry.v1.Agent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAgent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.GetAgentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.Agent.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentRegistryMethodDescriptorSupplier("GetAgent"))
                      .build();
        }
      }
    }
    return getGetAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.ListEndpointsRequest,
          com.google.cloud.agentregistry.v1.ListEndpointsResponse>
      getListEndpointsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEndpoints",
      requestType = com.google.cloud.agentregistry.v1.ListEndpointsRequest.class,
      responseType = com.google.cloud.agentregistry.v1.ListEndpointsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.ListEndpointsRequest,
          com.google.cloud.agentregistry.v1.ListEndpointsResponse>
      getListEndpointsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.ListEndpointsRequest,
            com.google.cloud.agentregistry.v1.ListEndpointsResponse>
        getListEndpointsMethod;
    if ((getListEndpointsMethod = AgentRegistryGrpc.getListEndpointsMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getListEndpointsMethod = AgentRegistryGrpc.getListEndpointsMethod) == null) {
          AgentRegistryGrpc.getListEndpointsMethod =
              getListEndpointsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.ListEndpointsRequest,
                          com.google.cloud.agentregistry.v1.ListEndpointsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEndpoints"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.ListEndpointsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.ListEndpointsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("ListEndpoints"))
                      .build();
        }
      }
    }
    return getListEndpointsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetEndpointRequest,
          com.google.cloud.agentregistry.v1.Endpoint>
      getGetEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEndpoint",
      requestType = com.google.cloud.agentregistry.v1.GetEndpointRequest.class,
      responseType = com.google.cloud.agentregistry.v1.Endpoint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetEndpointRequest,
          com.google.cloud.agentregistry.v1.Endpoint>
      getGetEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.GetEndpointRequest,
            com.google.cloud.agentregistry.v1.Endpoint>
        getGetEndpointMethod;
    if ((getGetEndpointMethod = AgentRegistryGrpc.getGetEndpointMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getGetEndpointMethod = AgentRegistryGrpc.getGetEndpointMethod) == null) {
          AgentRegistryGrpc.getGetEndpointMethod =
              getGetEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.GetEndpointRequest,
                          com.google.cloud.agentregistry.v1.Endpoint>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.GetEndpointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.Endpoint.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentRegistryMethodDescriptorSupplier("GetEndpoint"))
                      .build();
        }
      }
    }
    return getGetEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.ListMcpServersRequest,
          com.google.cloud.agentregistry.v1.ListMcpServersResponse>
      getListMcpServersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMcpServers",
      requestType = com.google.cloud.agentregistry.v1.ListMcpServersRequest.class,
      responseType = com.google.cloud.agentregistry.v1.ListMcpServersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.ListMcpServersRequest,
          com.google.cloud.agentregistry.v1.ListMcpServersResponse>
      getListMcpServersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.ListMcpServersRequest,
            com.google.cloud.agentregistry.v1.ListMcpServersResponse>
        getListMcpServersMethod;
    if ((getListMcpServersMethod = AgentRegistryGrpc.getListMcpServersMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getListMcpServersMethod = AgentRegistryGrpc.getListMcpServersMethod) == null) {
          AgentRegistryGrpc.getListMcpServersMethod =
              getListMcpServersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.ListMcpServersRequest,
                          com.google.cloud.agentregistry.v1.ListMcpServersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMcpServers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.ListMcpServersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.ListMcpServersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("ListMcpServers"))
                      .build();
        }
      }
    }
    return getListMcpServersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.SearchMcpServersRequest,
          com.google.cloud.agentregistry.v1.SearchMcpServersResponse>
      getSearchMcpServersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchMcpServers",
      requestType = com.google.cloud.agentregistry.v1.SearchMcpServersRequest.class,
      responseType = com.google.cloud.agentregistry.v1.SearchMcpServersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.SearchMcpServersRequest,
          com.google.cloud.agentregistry.v1.SearchMcpServersResponse>
      getSearchMcpServersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.SearchMcpServersRequest,
            com.google.cloud.agentregistry.v1.SearchMcpServersResponse>
        getSearchMcpServersMethod;
    if ((getSearchMcpServersMethod = AgentRegistryGrpc.getSearchMcpServersMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getSearchMcpServersMethod = AgentRegistryGrpc.getSearchMcpServersMethod) == null) {
          AgentRegistryGrpc.getSearchMcpServersMethod =
              getSearchMcpServersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.SearchMcpServersRequest,
                          com.google.cloud.agentregistry.v1.SearchMcpServersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchMcpServers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.SearchMcpServersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.SearchMcpServersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("SearchMcpServers"))
                      .build();
        }
      }
    }
    return getSearchMcpServersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetMcpServerRequest,
          com.google.cloud.agentregistry.v1.McpServer>
      getGetMcpServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMcpServer",
      requestType = com.google.cloud.agentregistry.v1.GetMcpServerRequest.class,
      responseType = com.google.cloud.agentregistry.v1.McpServer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetMcpServerRequest,
          com.google.cloud.agentregistry.v1.McpServer>
      getGetMcpServerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.GetMcpServerRequest,
            com.google.cloud.agentregistry.v1.McpServer>
        getGetMcpServerMethod;
    if ((getGetMcpServerMethod = AgentRegistryGrpc.getGetMcpServerMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getGetMcpServerMethod = AgentRegistryGrpc.getGetMcpServerMethod) == null) {
          AgentRegistryGrpc.getGetMcpServerMethod =
              getGetMcpServerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.GetMcpServerRequest,
                          com.google.cloud.agentregistry.v1.McpServer>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMcpServer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.GetMcpServerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.McpServer.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("GetMcpServer"))
                      .build();
        }
      }
    }
    return getGetMcpServerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.ListServicesRequest,
          com.google.cloud.agentregistry.v1.ListServicesResponse>
      getListServicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServices",
      requestType = com.google.cloud.agentregistry.v1.ListServicesRequest.class,
      responseType = com.google.cloud.agentregistry.v1.ListServicesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.ListServicesRequest,
          com.google.cloud.agentregistry.v1.ListServicesResponse>
      getListServicesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.ListServicesRequest,
            com.google.cloud.agentregistry.v1.ListServicesResponse>
        getListServicesMethod;
    if ((getListServicesMethod = AgentRegistryGrpc.getListServicesMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getListServicesMethod = AgentRegistryGrpc.getListServicesMethod) == null) {
          AgentRegistryGrpc.getListServicesMethod =
              getListServicesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.ListServicesRequest,
                          com.google.cloud.agentregistry.v1.ListServicesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListServices"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.ListServicesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.ListServicesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("ListServices"))
                      .build();
        }
      }
    }
    return getListServicesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetServiceRequest,
          com.google.cloud.agentregistry.v1.Service>
      getGetServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetService",
      requestType = com.google.cloud.agentregistry.v1.GetServiceRequest.class,
      responseType = com.google.cloud.agentregistry.v1.Service.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetServiceRequest,
          com.google.cloud.agentregistry.v1.Service>
      getGetServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.GetServiceRequest,
            com.google.cloud.agentregistry.v1.Service>
        getGetServiceMethod;
    if ((getGetServiceMethod = AgentRegistryGrpc.getGetServiceMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getGetServiceMethod = AgentRegistryGrpc.getGetServiceMethod) == null) {
          AgentRegistryGrpc.getGetServiceMethod =
              getGetServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.GetServiceRequest,
                          com.google.cloud.agentregistry.v1.Service>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.GetServiceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.Service.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentRegistryMethodDescriptorSupplier("GetService"))
                      .build();
        }
      }
    }
    return getGetServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.CreateServiceRequest, com.google.longrunning.Operation>
      getCreateServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateService",
      requestType = com.google.cloud.agentregistry.v1.CreateServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.CreateServiceRequest, com.google.longrunning.Operation>
      getCreateServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.CreateServiceRequest,
            com.google.longrunning.Operation>
        getCreateServiceMethod;
    if ((getCreateServiceMethod = AgentRegistryGrpc.getCreateServiceMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getCreateServiceMethod = AgentRegistryGrpc.getCreateServiceMethod) == null) {
          AgentRegistryGrpc.getCreateServiceMethod =
              getCreateServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.CreateServiceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.CreateServiceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("CreateService"))
                      .build();
        }
      }
    }
    return getCreateServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.UpdateServiceRequest, com.google.longrunning.Operation>
      getUpdateServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateService",
      requestType = com.google.cloud.agentregistry.v1.UpdateServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.UpdateServiceRequest, com.google.longrunning.Operation>
      getUpdateServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.UpdateServiceRequest,
            com.google.longrunning.Operation>
        getUpdateServiceMethod;
    if ((getUpdateServiceMethod = AgentRegistryGrpc.getUpdateServiceMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getUpdateServiceMethod = AgentRegistryGrpc.getUpdateServiceMethod) == null) {
          AgentRegistryGrpc.getUpdateServiceMethod =
              getUpdateServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.UpdateServiceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.UpdateServiceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("UpdateService"))
                      .build();
        }
      }
    }
    return getUpdateServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.DeleteServiceRequest, com.google.longrunning.Operation>
      getDeleteServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteService",
      requestType = com.google.cloud.agentregistry.v1.DeleteServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.DeleteServiceRequest, com.google.longrunning.Operation>
      getDeleteServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.DeleteServiceRequest,
            com.google.longrunning.Operation>
        getDeleteServiceMethod;
    if ((getDeleteServiceMethod = AgentRegistryGrpc.getDeleteServiceMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getDeleteServiceMethod = AgentRegistryGrpc.getDeleteServiceMethod) == null) {
          AgentRegistryGrpc.getDeleteServiceMethod =
              getDeleteServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.DeleteServiceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.DeleteServiceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("DeleteService"))
                      .build();
        }
      }
    }
    return getDeleteServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.ListBindingsRequest,
          com.google.cloud.agentregistry.v1.ListBindingsResponse>
      getListBindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBindings",
      requestType = com.google.cloud.agentregistry.v1.ListBindingsRequest.class,
      responseType = com.google.cloud.agentregistry.v1.ListBindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.ListBindingsRequest,
          com.google.cloud.agentregistry.v1.ListBindingsResponse>
      getListBindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.ListBindingsRequest,
            com.google.cloud.agentregistry.v1.ListBindingsResponse>
        getListBindingsMethod;
    if ((getListBindingsMethod = AgentRegistryGrpc.getListBindingsMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getListBindingsMethod = AgentRegistryGrpc.getListBindingsMethod) == null) {
          AgentRegistryGrpc.getListBindingsMethod =
              getListBindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.ListBindingsRequest,
                          com.google.cloud.agentregistry.v1.ListBindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.ListBindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.ListBindingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("ListBindings"))
                      .build();
        }
      }
    }
    return getListBindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetBindingRequest,
          com.google.cloud.agentregistry.v1.Binding>
      getGetBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBinding",
      requestType = com.google.cloud.agentregistry.v1.GetBindingRequest.class,
      responseType = com.google.cloud.agentregistry.v1.Binding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetBindingRequest,
          com.google.cloud.agentregistry.v1.Binding>
      getGetBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.GetBindingRequest,
            com.google.cloud.agentregistry.v1.Binding>
        getGetBindingMethod;
    if ((getGetBindingMethod = AgentRegistryGrpc.getGetBindingMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getGetBindingMethod = AgentRegistryGrpc.getGetBindingMethod) == null) {
          AgentRegistryGrpc.getGetBindingMethod =
              getGetBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.GetBindingRequest,
                          com.google.cloud.agentregistry.v1.Binding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.GetBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.Binding.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentRegistryMethodDescriptorSupplier("GetBinding"))
                      .build();
        }
      }
    }
    return getGetBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.CreateBindingRequest, com.google.longrunning.Operation>
      getCreateBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBinding",
      requestType = com.google.cloud.agentregistry.v1.CreateBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.CreateBindingRequest, com.google.longrunning.Operation>
      getCreateBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.CreateBindingRequest,
            com.google.longrunning.Operation>
        getCreateBindingMethod;
    if ((getCreateBindingMethod = AgentRegistryGrpc.getCreateBindingMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getCreateBindingMethod = AgentRegistryGrpc.getCreateBindingMethod) == null) {
          AgentRegistryGrpc.getCreateBindingMethod =
              getCreateBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.CreateBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.CreateBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("CreateBinding"))
                      .build();
        }
      }
    }
    return getCreateBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.UpdateBindingRequest, com.google.longrunning.Operation>
      getUpdateBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBinding",
      requestType = com.google.cloud.agentregistry.v1.UpdateBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.UpdateBindingRequest, com.google.longrunning.Operation>
      getUpdateBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.UpdateBindingRequest,
            com.google.longrunning.Operation>
        getUpdateBindingMethod;
    if ((getUpdateBindingMethod = AgentRegistryGrpc.getUpdateBindingMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getUpdateBindingMethod = AgentRegistryGrpc.getUpdateBindingMethod) == null) {
          AgentRegistryGrpc.getUpdateBindingMethod =
              getUpdateBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.UpdateBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.UpdateBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("UpdateBinding"))
                      .build();
        }
      }
    }
    return getUpdateBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.DeleteBindingRequest, com.google.longrunning.Operation>
      getDeleteBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBinding",
      requestType = com.google.cloud.agentregistry.v1.DeleteBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.DeleteBindingRequest, com.google.longrunning.Operation>
      getDeleteBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.DeleteBindingRequest,
            com.google.longrunning.Operation>
        getDeleteBindingMethod;
    if ((getDeleteBindingMethod = AgentRegistryGrpc.getDeleteBindingMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getDeleteBindingMethod = AgentRegistryGrpc.getDeleteBindingMethod) == null) {
          AgentRegistryGrpc.getDeleteBindingMethod =
              getDeleteBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.DeleteBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.DeleteBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("DeleteBinding"))
                      .build();
        }
      }
    }
    return getDeleteBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.FetchAvailableBindingsRequest,
          com.google.cloud.agentregistry.v1.FetchAvailableBindingsResponse>
      getFetchAvailableBindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchAvailableBindings",
      requestType = com.google.cloud.agentregistry.v1.FetchAvailableBindingsRequest.class,
      responseType = com.google.cloud.agentregistry.v1.FetchAvailableBindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.FetchAvailableBindingsRequest,
          com.google.cloud.agentregistry.v1.FetchAvailableBindingsResponse>
      getFetchAvailableBindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.FetchAvailableBindingsRequest,
            com.google.cloud.agentregistry.v1.FetchAvailableBindingsResponse>
        getFetchAvailableBindingsMethod;
    if ((getFetchAvailableBindingsMethod = AgentRegistryGrpc.getFetchAvailableBindingsMethod)
        == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getFetchAvailableBindingsMethod = AgentRegistryGrpc.getFetchAvailableBindingsMethod)
            == null) {
          AgentRegistryGrpc.getFetchAvailableBindingsMethod =
              getFetchAvailableBindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.FetchAvailableBindingsRequest,
                          com.google.cloud.agentregistry.v1.FetchAvailableBindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "FetchAvailableBindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.FetchAvailableBindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.FetchAvailableBindingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("FetchAvailableBindings"))
                      .build();
        }
      }
    }
    return getFetchAvailableBindingsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AgentRegistryStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgentRegistryStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AgentRegistryStub>() {
          @java.lang.Override
          public AgentRegistryStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AgentRegistryStub(channel, callOptions);
          }
        };
    return AgentRegistryStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static AgentRegistryBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgentRegistryBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AgentRegistryBlockingV2Stub>() {
          @java.lang.Override
          public AgentRegistryBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AgentRegistryBlockingV2Stub(channel, callOptions);
          }
        };
    return AgentRegistryBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AgentRegistryBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgentRegistryBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AgentRegistryBlockingStub>() {
          @java.lang.Override
          public AgentRegistryBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AgentRegistryBlockingStub(channel, callOptions);
          }
        };
    return AgentRegistryBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AgentRegistryFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgentRegistryFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AgentRegistryFutureStub>() {
          @java.lang.Override
          public AgentRegistryFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AgentRegistryFutureStub(channel, callOptions);
          }
        };
    return AgentRegistryFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing Agents, Endpoints, McpServers, Services, and Bindings.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists Agents in a given project and location.
     * </pre>
     */
    default void listAgents(
        com.google.cloud.agentregistry.v1.ListAgentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.ListAgentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAgentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches Agents in a given project and location.
     * </pre>
     */
    default void searchAgents(
        com.google.cloud.agentregistry.v1.SearchAgentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.SearchAgentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchAgentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Agent.
     * </pre>
     */
    default void getAgent(
        com.google.cloud.agentregistry.v1.GetAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Agent> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAgentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Endpoints in a given project and location.
     * </pre>
     */
    default void listEndpoints(
        com.google.cloud.agentregistry.v1.ListEndpointsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.ListEndpointsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEndpointsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Endpoint.
     * </pre>
     */
    default void getEndpoint(
        com.google.cloud.agentregistry.v1.GetEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Endpoint> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEndpointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists McpServers in a given project and location.
     * </pre>
     */
    default void listMcpServers(
        com.google.cloud.agentregistry.v1.ListMcpServersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.ListMcpServersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMcpServersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches McpServers in a given project and location.
     * </pre>
     */
    default void searchMcpServers(
        com.google.cloud.agentregistry.v1.SearchMcpServersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.SearchMcpServersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchMcpServersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single McpServer.
     * </pre>
     */
    default void getMcpServer(
        com.google.cloud.agentregistry.v1.GetMcpServerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.McpServer> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMcpServerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Services in a given project and location.
     * </pre>
     */
    default void listServices(
        com.google.cloud.agentregistry.v1.ListServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.ListServicesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListServicesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Service.
     * </pre>
     */
    default void getService(
        com.google.cloud.agentregistry.v1.GetServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Service> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Service in a given project and location.
     * </pre>
     */
    default void createService(
        com.google.cloud.agentregistry.v1.CreateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Service.
     * </pre>
     */
    default void updateService(
        com.google.cloud.agentregistry.v1.UpdateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Service.
     * </pre>
     */
    default void deleteService(
        com.google.cloud.agentregistry.v1.DeleteServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Bindings in a given project and location.
     * </pre>
     */
    default void listBindings(
        com.google.cloud.agentregistry.v1.ListBindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.ListBindingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBindingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Binding.
     * </pre>
     */
    default void getBinding(
        com.google.cloud.agentregistry.v1.GetBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Binding> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Binding in a given project and location.
     * </pre>
     */
    default void createBinding(
        com.google.cloud.agentregistry.v1.CreateBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Binding.
     * </pre>
     */
    default void updateBinding(
        com.google.cloud.agentregistry.v1.UpdateBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Binding.
     * </pre>
     */
    default void deleteBinding(
        com.google.cloud.agentregistry.v1.DeleteBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches available Bindings.
     * </pre>
     */
    default void fetchAvailableBindings(
        com.google.cloud.agentregistry.v1.FetchAvailableBindingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.agentregistry.v1.FetchAvailableBindingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchAvailableBindingsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AgentRegistry.
   *
   * <pre>
   * Service for managing Agents, Endpoints, McpServers, Services, and Bindings.
   * </pre>
   */
  public abstract static class AgentRegistryImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AgentRegistryGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AgentRegistry.
   *
   * <pre>
   * Service for managing Agents, Endpoints, McpServers, Services, and Bindings.
   * </pre>
   */
  public static final class AgentRegistryStub
      extends io.grpc.stub.AbstractAsyncStub<AgentRegistryStub> {
    private AgentRegistryStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentRegistryStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgentRegistryStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Agents in a given project and location.
     * </pre>
     */
    public void listAgents(
        com.google.cloud.agentregistry.v1.ListAgentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.ListAgentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAgentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches Agents in a given project and location.
     * </pre>
     */
    public void searchAgents(
        com.google.cloud.agentregistry.v1.SearchAgentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.SearchAgentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchAgentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Agent.
     * </pre>
     */
    public void getAgent(
        com.google.cloud.agentregistry.v1.GetAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Agent> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAgentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Endpoints in a given project and location.
     * </pre>
     */
    public void listEndpoints(
        com.google.cloud.agentregistry.v1.ListEndpointsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.ListEndpointsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEndpointsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Endpoint.
     * </pre>
     */
    public void getEndpoint(
        com.google.cloud.agentregistry.v1.GetEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Endpoint> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEndpointMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists McpServers in a given project and location.
     * </pre>
     */
    public void listMcpServers(
        com.google.cloud.agentregistry.v1.ListMcpServersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.ListMcpServersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMcpServersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches McpServers in a given project and location.
     * </pre>
     */
    public void searchMcpServers(
        com.google.cloud.agentregistry.v1.SearchMcpServersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.SearchMcpServersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchMcpServersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single McpServer.
     * </pre>
     */
    public void getMcpServer(
        com.google.cloud.agentregistry.v1.GetMcpServerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.McpServer> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMcpServerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Services in a given project and location.
     * </pre>
     */
    public void listServices(
        com.google.cloud.agentregistry.v1.ListServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.ListServicesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServicesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Service.
     * </pre>
     */
    public void getService(
        com.google.cloud.agentregistry.v1.GetServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Service> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Service in a given project and location.
     * </pre>
     */
    public void createService(
        com.google.cloud.agentregistry.v1.CreateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Service.
     * </pre>
     */
    public void updateService(
        com.google.cloud.agentregistry.v1.UpdateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Service.
     * </pre>
     */
    public void deleteService(
        com.google.cloud.agentregistry.v1.DeleteServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Bindings in a given project and location.
     * </pre>
     */
    public void listBindings(
        com.google.cloud.agentregistry.v1.ListBindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.ListBindingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBindingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Binding.
     * </pre>
     */
    public void getBinding(
        com.google.cloud.agentregistry.v1.GetBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Binding> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBindingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Binding in a given project and location.
     * </pre>
     */
    public void createBinding(
        com.google.cloud.agentregistry.v1.CreateBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Binding.
     * </pre>
     */
    public void updateBinding(
        com.google.cloud.agentregistry.v1.UpdateBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Binding.
     * </pre>
     */
    public void deleteBinding(
        com.google.cloud.agentregistry.v1.DeleteBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches available Bindings.
     * </pre>
     */
    public void fetchAvailableBindings(
        com.google.cloud.agentregistry.v1.FetchAvailableBindingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.agentregistry.v1.FetchAvailableBindingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchAvailableBindingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AgentRegistry.
   *
   * <pre>
   * Service for managing Agents, Endpoints, McpServers, Services, and Bindings.
   * </pre>
   */
  public static final class AgentRegistryBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<AgentRegistryBlockingV2Stub> {
    private AgentRegistryBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentRegistryBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgentRegistryBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Agents in a given project and location.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.ListAgentsResponse listAgents(
        com.google.cloud.agentregistry.v1.ListAgentsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAgentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches Agents in a given project and location.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.SearchAgentsResponse searchAgents(
        com.google.cloud.agentregistry.v1.SearchAgentsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSearchAgentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Agent.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.Agent getAgent(
        com.google.cloud.agentregistry.v1.GetAgentRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Endpoints in a given project and location.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.ListEndpointsResponse listEndpoints(
        com.google.cloud.agentregistry.v1.ListEndpointsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListEndpointsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Endpoint.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.Endpoint getEndpoint(
        com.google.cloud.agentregistry.v1.GetEndpointRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists McpServers in a given project and location.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.ListMcpServersResponse listMcpServers(
        com.google.cloud.agentregistry.v1.ListMcpServersRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListMcpServersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches McpServers in a given project and location.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.SearchMcpServersResponse searchMcpServers(
        com.google.cloud.agentregistry.v1.SearchMcpServersRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSearchMcpServersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single McpServer.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.McpServer getMcpServer(
        com.google.cloud.agentregistry.v1.GetMcpServerRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetMcpServerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Services in a given project and location.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.ListServicesResponse listServices(
        com.google.cloud.agentregistry.v1.ListServicesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListServicesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Service.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.Service getService(
        com.google.cloud.agentregistry.v1.GetServiceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Service in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createService(
        com.google.cloud.agentregistry.v1.CreateServiceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Service.
     * </pre>
     */
    public com.google.longrunning.Operation updateService(
        com.google.cloud.agentregistry.v1.UpdateServiceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Service.
     * </pre>
     */
    public com.google.longrunning.Operation deleteService(
        com.google.cloud.agentregistry.v1.DeleteServiceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Bindings in a given project and location.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.ListBindingsResponse listBindings(
        com.google.cloud.agentregistry.v1.ListBindingsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListBindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Binding.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.Binding getBinding(
        com.google.cloud.agentregistry.v1.GetBindingRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Binding in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createBinding(
        com.google.cloud.agentregistry.v1.CreateBindingRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Binding.
     * </pre>
     */
    public com.google.longrunning.Operation updateBinding(
        com.google.cloud.agentregistry.v1.UpdateBindingRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Binding.
     * </pre>
     */
    public com.google.longrunning.Operation deleteBinding(
        com.google.cloud.agentregistry.v1.DeleteBindingRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches available Bindings.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.FetchAvailableBindingsResponse fetchAvailableBindings(
        com.google.cloud.agentregistry.v1.FetchAvailableBindingsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getFetchAvailableBindingsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service AgentRegistry.
   *
   * <pre>
   * Service for managing Agents, Endpoints, McpServers, Services, and Bindings.
   * </pre>
   */
  public static final class AgentRegistryBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AgentRegistryBlockingStub> {
    private AgentRegistryBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentRegistryBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgentRegistryBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Agents in a given project and location.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.ListAgentsResponse listAgents(
        com.google.cloud.agentregistry.v1.ListAgentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAgentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches Agents in a given project and location.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.SearchAgentsResponse searchAgents(
        com.google.cloud.agentregistry.v1.SearchAgentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchAgentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Agent.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.Agent getAgent(
        com.google.cloud.agentregistry.v1.GetAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Endpoints in a given project and location.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.ListEndpointsResponse listEndpoints(
        com.google.cloud.agentregistry.v1.ListEndpointsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEndpointsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Endpoint.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.Endpoint getEndpoint(
        com.google.cloud.agentregistry.v1.GetEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists McpServers in a given project and location.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.ListMcpServersResponse listMcpServers(
        com.google.cloud.agentregistry.v1.ListMcpServersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMcpServersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches McpServers in a given project and location.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.SearchMcpServersResponse searchMcpServers(
        com.google.cloud.agentregistry.v1.SearchMcpServersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchMcpServersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single McpServer.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.McpServer getMcpServer(
        com.google.cloud.agentregistry.v1.GetMcpServerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMcpServerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Services in a given project and location.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.ListServicesResponse listServices(
        com.google.cloud.agentregistry.v1.ListServicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServicesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Service.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.Service getService(
        com.google.cloud.agentregistry.v1.GetServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Service in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createService(
        com.google.cloud.agentregistry.v1.CreateServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Service.
     * </pre>
     */
    public com.google.longrunning.Operation updateService(
        com.google.cloud.agentregistry.v1.UpdateServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Service.
     * </pre>
     */
    public com.google.longrunning.Operation deleteService(
        com.google.cloud.agentregistry.v1.DeleteServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Bindings in a given project and location.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.ListBindingsResponse listBindings(
        com.google.cloud.agentregistry.v1.ListBindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Binding.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.Binding getBinding(
        com.google.cloud.agentregistry.v1.GetBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Binding in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createBinding(
        com.google.cloud.agentregistry.v1.CreateBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Binding.
     * </pre>
     */
    public com.google.longrunning.Operation updateBinding(
        com.google.cloud.agentregistry.v1.UpdateBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Binding.
     * </pre>
     */
    public com.google.longrunning.Operation deleteBinding(
        com.google.cloud.agentregistry.v1.DeleteBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches available Bindings.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.FetchAvailableBindingsResponse fetchAvailableBindings(
        com.google.cloud.agentregistry.v1.FetchAvailableBindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchAvailableBindingsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AgentRegistry.
   *
   * <pre>
   * Service for managing Agents, Endpoints, McpServers, Services, and Bindings.
   * </pre>
   */
  public static final class AgentRegistryFutureStub
      extends io.grpc.stub.AbstractFutureStub<AgentRegistryFutureStub> {
    private AgentRegistryFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentRegistryFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgentRegistryFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Agents in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.ListAgentsResponse>
        listAgents(com.google.cloud.agentregistry.v1.ListAgentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAgentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Searches Agents in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.SearchAgentsResponse>
        searchAgents(com.google.cloud.agentregistry.v1.SearchAgentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchAgentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.Agent>
        getAgent(com.google.cloud.agentregistry.v1.GetAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAgentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Endpoints in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.ListEndpointsResponse>
        listEndpoints(com.google.cloud.agentregistry.v1.ListEndpointsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEndpointsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Endpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.Endpoint>
        getEndpoint(com.google.cloud.agentregistry.v1.GetEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEndpointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists McpServers in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.ListMcpServersResponse>
        listMcpServers(com.google.cloud.agentregistry.v1.ListMcpServersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMcpServersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Searches McpServers in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.SearchMcpServersResponse>
        searchMcpServers(com.google.cloud.agentregistry.v1.SearchMcpServersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchMcpServersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single McpServer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.McpServer>
        getMcpServer(com.google.cloud.agentregistry.v1.GetMcpServerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMcpServerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Services in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.ListServicesResponse>
        listServices(com.google.cloud.agentregistry.v1.ListServicesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServicesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.Service>
        getService(com.google.cloud.agentregistry.v1.GetServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Service in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createService(com.google.cloud.agentregistry.v1.CreateServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateService(com.google.cloud.agentregistry.v1.UpdateServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteService(com.google.cloud.agentregistry.v1.DeleteServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Bindings in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.ListBindingsResponse>
        listBindings(com.google.cloud.agentregistry.v1.ListBindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBindingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Binding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.Binding>
        getBinding(com.google.cloud.agentregistry.v1.GetBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Binding in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createBinding(com.google.cloud.agentregistry.v1.CreateBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Binding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateBinding(com.google.cloud.agentregistry.v1.UpdateBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Binding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteBinding(com.google.cloud.agentregistry.v1.DeleteBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches available Bindings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.FetchAvailableBindingsResponse>
        fetchAvailableBindings(
            com.google.cloud.agentregistry.v1.FetchAvailableBindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchAvailableBindingsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_AGENTS = 0;
  private static final int METHODID_SEARCH_AGENTS = 1;
  private static final int METHODID_GET_AGENT = 2;
  private static final int METHODID_LIST_ENDPOINTS = 3;
  private static final int METHODID_GET_ENDPOINT = 4;
  private static final int METHODID_LIST_MCP_SERVERS = 5;
  private static final int METHODID_SEARCH_MCP_SERVERS = 6;
  private static final int METHODID_GET_MCP_SERVER = 7;
  private static final int METHODID_LIST_SERVICES = 8;
  private static final int METHODID_GET_SERVICE = 9;
  private static final int METHODID_CREATE_SERVICE = 10;
  private static final int METHODID_UPDATE_SERVICE = 11;
  private static final int METHODID_DELETE_SERVICE = 12;
  private static final int METHODID_LIST_BINDINGS = 13;
  private static final int METHODID_GET_BINDING = 14;
  private static final int METHODID_CREATE_BINDING = 15;
  private static final int METHODID_UPDATE_BINDING = 16;
  private static final int METHODID_DELETE_BINDING = 17;
  private static final int METHODID_FETCH_AVAILABLE_BINDINGS = 18;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_AGENTS:
          serviceImpl.listAgents(
              (com.google.cloud.agentregistry.v1.ListAgentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.ListAgentsResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_AGENTS:
          serviceImpl.searchAgents(
              (com.google.cloud.agentregistry.v1.SearchAgentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.SearchAgentsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_AGENT:
          serviceImpl.getAgent(
              (com.google.cloud.agentregistry.v1.GetAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Agent>)
                  responseObserver);
          break;
        case METHODID_LIST_ENDPOINTS:
          serviceImpl.listEndpoints(
              (com.google.cloud.agentregistry.v1.ListEndpointsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.ListEndpointsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ENDPOINT:
          serviceImpl.getEndpoint(
              (com.google.cloud.agentregistry.v1.GetEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Endpoint>)
                  responseObserver);
          break;
        case METHODID_LIST_MCP_SERVERS:
          serviceImpl.listMcpServers(
              (com.google.cloud.agentregistry.v1.ListMcpServersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.agentregistry.v1.ListMcpServersResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_MCP_SERVERS:
          serviceImpl.searchMcpServers(
              (com.google.cloud.agentregistry.v1.SearchMcpServersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.agentregistry.v1.SearchMcpServersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_MCP_SERVER:
          serviceImpl.getMcpServer(
              (com.google.cloud.agentregistry.v1.GetMcpServerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.McpServer>)
                  responseObserver);
          break;
        case METHODID_LIST_SERVICES:
          serviceImpl.listServices(
              (com.google.cloud.agentregistry.v1.ListServicesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.ListServicesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SERVICE:
          serviceImpl.getService(
              (com.google.cloud.agentregistry.v1.GetServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Service>)
                  responseObserver);
          break;
        case METHODID_CREATE_SERVICE:
          serviceImpl.createService(
              (com.google.cloud.agentregistry.v1.CreateServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_SERVICE:
          serviceImpl.updateService(
              (com.google.cloud.agentregistry.v1.UpdateServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SERVICE:
          serviceImpl.deleteService(
              (com.google.cloud.agentregistry.v1.DeleteServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_BINDINGS:
          serviceImpl.listBindings(
              (com.google.cloud.agentregistry.v1.ListBindingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.ListBindingsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_BINDING:
          serviceImpl.getBinding(
              (com.google.cloud.agentregistry.v1.GetBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Binding>)
                  responseObserver);
          break;
        case METHODID_CREATE_BINDING:
          serviceImpl.createBinding(
              (com.google.cloud.agentregistry.v1.CreateBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_BINDING:
          serviceImpl.updateBinding(
              (com.google.cloud.agentregistry.v1.UpdateBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_BINDING:
          serviceImpl.deleteBinding(
              (com.google.cloud.agentregistry.v1.DeleteBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_FETCH_AVAILABLE_BINDINGS:
          serviceImpl.fetchAvailableBindings(
              (com.google.cloud.agentregistry.v1.FetchAvailableBindingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.agentregistry.v1.FetchAvailableBindingsResponse>)
                  responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getListAgentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.ListAgentsRequest,
                    com.google.cloud.agentregistry.v1.ListAgentsResponse>(
                    service, METHODID_LIST_AGENTS)))
        .addMethod(
            getSearchAgentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.SearchAgentsRequest,
                    com.google.cloud.agentregistry.v1.SearchAgentsResponse>(
                    service, METHODID_SEARCH_AGENTS)))
        .addMethod(
            getGetAgentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.GetAgentRequest,
                    com.google.cloud.agentregistry.v1.Agent>(service, METHODID_GET_AGENT)))
        .addMethod(
            getListEndpointsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.ListEndpointsRequest,
                    com.google.cloud.agentregistry.v1.ListEndpointsResponse>(
                    service, METHODID_LIST_ENDPOINTS)))
        .addMethod(
            getGetEndpointMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.GetEndpointRequest,
                    com.google.cloud.agentregistry.v1.Endpoint>(service, METHODID_GET_ENDPOINT)))
        .addMethod(
            getListMcpServersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.ListMcpServersRequest,
                    com.google.cloud.agentregistry.v1.ListMcpServersResponse>(
                    service, METHODID_LIST_MCP_SERVERS)))
        .addMethod(
            getSearchMcpServersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.SearchMcpServersRequest,
                    com.google.cloud.agentregistry.v1.SearchMcpServersResponse>(
                    service, METHODID_SEARCH_MCP_SERVERS)))
        .addMethod(
            getGetMcpServerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.GetMcpServerRequest,
                    com.google.cloud.agentregistry.v1.McpServer>(service, METHODID_GET_MCP_SERVER)))
        .addMethod(
            getListServicesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.ListServicesRequest,
                    com.google.cloud.agentregistry.v1.ListServicesResponse>(
                    service, METHODID_LIST_SERVICES)))
        .addMethod(
            getGetServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.GetServiceRequest,
                    com.google.cloud.agentregistry.v1.Service>(service, METHODID_GET_SERVICE)))
        .addMethod(
            getCreateServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.CreateServiceRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SERVICE)))
        .addMethod(
            getUpdateServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.UpdateServiceRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_SERVICE)))
        .addMethod(
            getDeleteServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.DeleteServiceRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_SERVICE)))
        .addMethod(
            getListBindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.ListBindingsRequest,
                    com.google.cloud.agentregistry.v1.ListBindingsResponse>(
                    service, METHODID_LIST_BINDINGS)))
        .addMethod(
            getGetBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.GetBindingRequest,
                    com.google.cloud.agentregistry.v1.Binding>(service, METHODID_GET_BINDING)))
        .addMethod(
            getCreateBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.CreateBindingRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_BINDING)))
        .addMethod(
            getUpdateBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.UpdateBindingRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_BINDING)))
        .addMethod(
            getDeleteBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.DeleteBindingRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_BINDING)))
        .addMethod(
            getFetchAvailableBindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.FetchAvailableBindingsRequest,
                    com.google.cloud.agentregistry.v1.FetchAvailableBindingsResponse>(
                    service, METHODID_FETCH_AVAILABLE_BINDINGS)))
        .build();
  }

  private abstract static class AgentRegistryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AgentRegistryBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.agentregistry.v1.AgentRegistryServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AgentRegistry");
    }
  }

  private static final class AgentRegistryFileDescriptorSupplier
      extends AgentRegistryBaseDescriptorSupplier {
    AgentRegistryFileDescriptorSupplier() {}
  }

  private static final class AgentRegistryMethodDescriptorSupplier
      extends AgentRegistryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AgentRegistryMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AgentRegistryGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AgentRegistryFileDescriptorSupplier())
                      .addMethod(getListAgentsMethod())
                      .addMethod(getSearchAgentsMethod())
                      .addMethod(getGetAgentMethod())
                      .addMethod(getListEndpointsMethod())
                      .addMethod(getGetEndpointMethod())
                      .addMethod(getListMcpServersMethod())
                      .addMethod(getSearchMcpServersMethod())
                      .addMethod(getGetMcpServerMethod())
                      .addMethod(getListServicesMethod())
                      .addMethod(getGetServiceMethod())
                      .addMethod(getCreateServiceMethod())
                      .addMethod(getUpdateServiceMethod())
                      .addMethod(getDeleteServiceMethod())
                      .addMethod(getListBindingsMethod())
                      .addMethod(getGetBindingMethod())
                      .addMethod(getCreateBindingMethod())
                      .addMethod(getUpdateBindingMethod())
                      .addMethod(getDeleteBindingMethod())
                      .addMethod(getFetchAvailableBindingsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
