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
 * Service for managing Agent Registry resources.
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.CreateSkillRequest, com.google.longrunning.Operation>
      getCreateSkillMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSkill",
      requestType = com.google.cloud.agentregistry.v1.CreateSkillRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.CreateSkillRequest, com.google.longrunning.Operation>
      getCreateSkillMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.CreateSkillRequest, com.google.longrunning.Operation>
        getCreateSkillMethod;
    if ((getCreateSkillMethod = AgentRegistryGrpc.getCreateSkillMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getCreateSkillMethod = AgentRegistryGrpc.getCreateSkillMethod) == null) {
          AgentRegistryGrpc.getCreateSkillMethod =
              getCreateSkillMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.CreateSkillRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSkill"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.CreateSkillRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentRegistryMethodDescriptorSupplier("CreateSkill"))
                      .build();
        }
      }
    }
    return getCreateSkillMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetSkillRequest,
          com.google.cloud.agentregistry.v1.Skill>
      getGetSkillMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSkill",
      requestType = com.google.cloud.agentregistry.v1.GetSkillRequest.class,
      responseType = com.google.cloud.agentregistry.v1.Skill.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetSkillRequest,
          com.google.cloud.agentregistry.v1.Skill>
      getGetSkillMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.GetSkillRequest,
            com.google.cloud.agentregistry.v1.Skill>
        getGetSkillMethod;
    if ((getGetSkillMethod = AgentRegistryGrpc.getGetSkillMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getGetSkillMethod = AgentRegistryGrpc.getGetSkillMethod) == null) {
          AgentRegistryGrpc.getGetSkillMethod =
              getGetSkillMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.GetSkillRequest,
                          com.google.cloud.agentregistry.v1.Skill>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSkill"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.GetSkillRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.Skill.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentRegistryMethodDescriptorSupplier("GetSkill"))
                      .build();
        }
      }
    }
    return getGetSkillMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.UpdateSkillRequest, com.google.longrunning.Operation>
      getUpdateSkillMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSkill",
      requestType = com.google.cloud.agentregistry.v1.UpdateSkillRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.UpdateSkillRequest, com.google.longrunning.Operation>
      getUpdateSkillMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.UpdateSkillRequest, com.google.longrunning.Operation>
        getUpdateSkillMethod;
    if ((getUpdateSkillMethod = AgentRegistryGrpc.getUpdateSkillMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getUpdateSkillMethod = AgentRegistryGrpc.getUpdateSkillMethod) == null) {
          AgentRegistryGrpc.getUpdateSkillMethod =
              getUpdateSkillMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.UpdateSkillRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSkill"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.UpdateSkillRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentRegistryMethodDescriptorSupplier("UpdateSkill"))
                      .build();
        }
      }
    }
    return getUpdateSkillMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.DeleteSkillRequest, com.google.longrunning.Operation>
      getDeleteSkillMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSkill",
      requestType = com.google.cloud.agentregistry.v1.DeleteSkillRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.DeleteSkillRequest, com.google.longrunning.Operation>
      getDeleteSkillMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.DeleteSkillRequest, com.google.longrunning.Operation>
        getDeleteSkillMethod;
    if ((getDeleteSkillMethod = AgentRegistryGrpc.getDeleteSkillMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getDeleteSkillMethod = AgentRegistryGrpc.getDeleteSkillMethod) == null) {
          AgentRegistryGrpc.getDeleteSkillMethod =
              getDeleteSkillMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.DeleteSkillRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSkill"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.DeleteSkillRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentRegistryMethodDescriptorSupplier("DeleteSkill"))
                      .build();
        }
      }
    }
    return getDeleteSkillMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.ListSkillsRequest,
          com.google.cloud.agentregistry.v1.ListSkillsResponse>
      getListSkillsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSkills",
      requestType = com.google.cloud.agentregistry.v1.ListSkillsRequest.class,
      responseType = com.google.cloud.agentregistry.v1.ListSkillsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.ListSkillsRequest,
          com.google.cloud.agentregistry.v1.ListSkillsResponse>
      getListSkillsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.ListSkillsRequest,
            com.google.cloud.agentregistry.v1.ListSkillsResponse>
        getListSkillsMethod;
    if ((getListSkillsMethod = AgentRegistryGrpc.getListSkillsMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getListSkillsMethod = AgentRegistryGrpc.getListSkillsMethod) == null) {
          AgentRegistryGrpc.getListSkillsMethod =
              getListSkillsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.ListSkillsRequest,
                          com.google.cloud.agentregistry.v1.ListSkillsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSkills"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.ListSkillsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.ListSkillsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AgentRegistryMethodDescriptorSupplier("ListSkills"))
                      .build();
        }
      }
    }
    return getListSkillsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.SearchSkillsRequest,
          com.google.cloud.agentregistry.v1.SearchSkillsResponse>
      getSearchSkillsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchSkills",
      requestType = com.google.cloud.agentregistry.v1.SearchSkillsRequest.class,
      responseType = com.google.cloud.agentregistry.v1.SearchSkillsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.SearchSkillsRequest,
          com.google.cloud.agentregistry.v1.SearchSkillsResponse>
      getSearchSkillsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.SearchSkillsRequest,
            com.google.cloud.agentregistry.v1.SearchSkillsResponse>
        getSearchSkillsMethod;
    if ((getSearchSkillsMethod = AgentRegistryGrpc.getSearchSkillsMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getSearchSkillsMethod = AgentRegistryGrpc.getSearchSkillsMethod) == null) {
          AgentRegistryGrpc.getSearchSkillsMethod =
              getSearchSkillsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.SearchSkillsRequest,
                          com.google.cloud.agentregistry.v1.SearchSkillsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchSkills"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.SearchSkillsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.SearchSkillsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("SearchSkills"))
                      .build();
        }
      }
    }
    return getSearchSkillsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.CreateSkillRevisionRequest,
          com.google.longrunning.Operation>
      getCreateSkillRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSkillRevision",
      requestType = com.google.cloud.agentregistry.v1.CreateSkillRevisionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.CreateSkillRevisionRequest,
          com.google.longrunning.Operation>
      getCreateSkillRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.CreateSkillRevisionRequest,
            com.google.longrunning.Operation>
        getCreateSkillRevisionMethod;
    if ((getCreateSkillRevisionMethod = AgentRegistryGrpc.getCreateSkillRevisionMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getCreateSkillRevisionMethod = AgentRegistryGrpc.getCreateSkillRevisionMethod)
            == null) {
          AgentRegistryGrpc.getCreateSkillRevisionMethod =
              getCreateSkillRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.CreateSkillRevisionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateSkillRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.CreateSkillRevisionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("CreateSkillRevision"))
                      .build();
        }
      }
    }
    return getCreateSkillRevisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetSkillRevisionRequest,
          com.google.cloud.agentregistry.v1.SkillRevision>
      getGetSkillRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSkillRevision",
      requestType = com.google.cloud.agentregistry.v1.GetSkillRevisionRequest.class,
      responseType = com.google.cloud.agentregistry.v1.SkillRevision.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetSkillRevisionRequest,
          com.google.cloud.agentregistry.v1.SkillRevision>
      getGetSkillRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.GetSkillRevisionRequest,
            com.google.cloud.agentregistry.v1.SkillRevision>
        getGetSkillRevisionMethod;
    if ((getGetSkillRevisionMethod = AgentRegistryGrpc.getGetSkillRevisionMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getGetSkillRevisionMethod = AgentRegistryGrpc.getGetSkillRevisionMethod) == null) {
          AgentRegistryGrpc.getGetSkillRevisionMethod =
              getGetSkillRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.GetSkillRevisionRequest,
                          com.google.cloud.agentregistry.v1.SkillRevision>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSkillRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.GetSkillRevisionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.SkillRevision.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("GetSkillRevision"))
                      .build();
        }
      }
    }
    return getGetSkillRevisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.DeleteSkillRevisionRequest,
          com.google.longrunning.Operation>
      getDeleteSkillRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSkillRevision",
      requestType = com.google.cloud.agentregistry.v1.DeleteSkillRevisionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.DeleteSkillRevisionRequest,
          com.google.longrunning.Operation>
      getDeleteSkillRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.DeleteSkillRevisionRequest,
            com.google.longrunning.Operation>
        getDeleteSkillRevisionMethod;
    if ((getDeleteSkillRevisionMethod = AgentRegistryGrpc.getDeleteSkillRevisionMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getDeleteSkillRevisionMethod = AgentRegistryGrpc.getDeleteSkillRevisionMethod)
            == null) {
          AgentRegistryGrpc.getDeleteSkillRevisionMethod =
              getDeleteSkillRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.DeleteSkillRevisionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteSkillRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.DeleteSkillRevisionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("DeleteSkillRevision"))
                      .build();
        }
      }
    }
    return getDeleteSkillRevisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.ListSkillRevisionsRequest,
          com.google.cloud.agentregistry.v1.ListSkillRevisionsResponse>
      getListSkillRevisionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSkillRevisions",
      requestType = com.google.cloud.agentregistry.v1.ListSkillRevisionsRequest.class,
      responseType = com.google.cloud.agentregistry.v1.ListSkillRevisionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.ListSkillRevisionsRequest,
          com.google.cloud.agentregistry.v1.ListSkillRevisionsResponse>
      getListSkillRevisionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.ListSkillRevisionsRequest,
            com.google.cloud.agentregistry.v1.ListSkillRevisionsResponse>
        getListSkillRevisionsMethod;
    if ((getListSkillRevisionsMethod = AgentRegistryGrpc.getListSkillRevisionsMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getListSkillRevisionsMethod = AgentRegistryGrpc.getListSkillRevisionsMethod) == null) {
          AgentRegistryGrpc.getListSkillRevisionsMethod =
              getListSkillRevisionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.ListSkillRevisionsRequest,
                          com.google.cloud.agentregistry.v1.ListSkillRevisionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSkillRevisions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.ListSkillRevisionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.ListSkillRevisionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("ListSkillRevisions"))
                      .build();
        }
      }
    }
    return getListSkillRevisionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetPublisherRequest,
          com.google.cloud.agentregistry.v1.Publisher>
      getGetPublisherMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPublisher",
      requestType = com.google.cloud.agentregistry.v1.GetPublisherRequest.class,
      responseType = com.google.cloud.agentregistry.v1.Publisher.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetPublisherRequest,
          com.google.cloud.agentregistry.v1.Publisher>
      getGetPublisherMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.GetPublisherRequest,
            com.google.cloud.agentregistry.v1.Publisher>
        getGetPublisherMethod;
    if ((getGetPublisherMethod = AgentRegistryGrpc.getGetPublisherMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getGetPublisherMethod = AgentRegistryGrpc.getGetPublisherMethod) == null) {
          AgentRegistryGrpc.getGetPublisherMethod =
              getGetPublisherMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.GetPublisherRequest,
                          com.google.cloud.agentregistry.v1.Publisher>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPublisher"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.GetPublisherRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.Publisher.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("GetPublisher"))
                      .build();
        }
      }
    }
    return getGetPublisherMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.ListPublishersRequest,
          com.google.cloud.agentregistry.v1.ListPublishersResponse>
      getListPublishersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPublishers",
      requestType = com.google.cloud.agentregistry.v1.ListPublishersRequest.class,
      responseType = com.google.cloud.agentregistry.v1.ListPublishersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.ListPublishersRequest,
          com.google.cloud.agentregistry.v1.ListPublishersResponse>
      getListPublishersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.ListPublishersRequest,
            com.google.cloud.agentregistry.v1.ListPublishersResponse>
        getListPublishersMethod;
    if ((getListPublishersMethod = AgentRegistryGrpc.getListPublishersMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getListPublishersMethod = AgentRegistryGrpc.getListPublishersMethod) == null) {
          AgentRegistryGrpc.getListPublishersMethod =
              getListPublishersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.ListPublishersRequest,
                          com.google.cloud.agentregistry.v1.ListPublishersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPublishers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.ListPublishersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.ListPublishersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("ListPublishers"))
                      .build();
        }
      }
    }
    return getListPublishersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetAiApplicationRequest,
          com.google.cloud.agentregistry.v1.AiApplication>
      getGetAiApplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAiApplication",
      requestType = com.google.cloud.agentregistry.v1.GetAiApplicationRequest.class,
      responseType = com.google.cloud.agentregistry.v1.AiApplication.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetAiApplicationRequest,
          com.google.cloud.agentregistry.v1.AiApplication>
      getGetAiApplicationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.GetAiApplicationRequest,
            com.google.cloud.agentregistry.v1.AiApplication>
        getGetAiApplicationMethod;
    if ((getGetAiApplicationMethod = AgentRegistryGrpc.getGetAiApplicationMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getGetAiApplicationMethod = AgentRegistryGrpc.getGetAiApplicationMethod) == null) {
          AgentRegistryGrpc.getGetAiApplicationMethod =
              getGetAiApplicationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.GetAiApplicationRequest,
                          com.google.cloud.agentregistry.v1.AiApplication>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAiApplication"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.GetAiApplicationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.AiApplication.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("GetAiApplication"))
                      .build();
        }
      }
    }
    return getGetAiApplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.ListAiApplicationsRequest,
          com.google.cloud.agentregistry.v1.ListAiApplicationsResponse>
      getListAiApplicationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAiApplications",
      requestType = com.google.cloud.agentregistry.v1.ListAiApplicationsRequest.class,
      responseType = com.google.cloud.agentregistry.v1.ListAiApplicationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.ListAiApplicationsRequest,
          com.google.cloud.agentregistry.v1.ListAiApplicationsResponse>
      getListAiApplicationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.ListAiApplicationsRequest,
            com.google.cloud.agentregistry.v1.ListAiApplicationsResponse>
        getListAiApplicationsMethod;
    if ((getListAiApplicationsMethod = AgentRegistryGrpc.getListAiApplicationsMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getListAiApplicationsMethod = AgentRegistryGrpc.getListAiApplicationsMethod) == null) {
          AgentRegistryGrpc.getListAiApplicationsMethod =
              getListAiApplicationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.ListAiApplicationsRequest,
                          com.google.cloud.agentregistry.v1.ListAiApplicationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAiApplications"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.ListAiApplicationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.ListAiApplicationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("ListAiApplications"))
                      .build();
        }
      }
    }
    return getListAiApplicationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetAiApplicationAgentRequest,
          com.google.cloud.agentregistry.v1.Agent>
      getGetAiApplicationAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAiApplicationAgent",
      requestType = com.google.cloud.agentregistry.v1.GetAiApplicationAgentRequest.class,
      responseType = com.google.cloud.agentregistry.v1.Agent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetAiApplicationAgentRequest,
          com.google.cloud.agentregistry.v1.Agent>
      getGetAiApplicationAgentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.GetAiApplicationAgentRequest,
            com.google.cloud.agentregistry.v1.Agent>
        getGetAiApplicationAgentMethod;
    if ((getGetAiApplicationAgentMethod = AgentRegistryGrpc.getGetAiApplicationAgentMethod)
        == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getGetAiApplicationAgentMethod = AgentRegistryGrpc.getGetAiApplicationAgentMethod)
            == null) {
          AgentRegistryGrpc.getGetAiApplicationAgentMethod =
              getGetAiApplicationAgentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.GetAiApplicationAgentRequest,
                          com.google.cloud.agentregistry.v1.Agent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetAiApplicationAgent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.GetAiApplicationAgentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.Agent.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("GetAiApplicationAgent"))
                      .build();
        }
      }
    }
    return getGetAiApplicationAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.ListAiApplicationAgentsRequest,
          com.google.cloud.agentregistry.v1.ListAiApplicationAgentsResponse>
      getListAiApplicationAgentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAiApplicationAgents",
      requestType = com.google.cloud.agentregistry.v1.ListAiApplicationAgentsRequest.class,
      responseType = com.google.cloud.agentregistry.v1.ListAiApplicationAgentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.ListAiApplicationAgentsRequest,
          com.google.cloud.agentregistry.v1.ListAiApplicationAgentsResponse>
      getListAiApplicationAgentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.ListAiApplicationAgentsRequest,
            com.google.cloud.agentregistry.v1.ListAiApplicationAgentsResponse>
        getListAiApplicationAgentsMethod;
    if ((getListAiApplicationAgentsMethod = AgentRegistryGrpc.getListAiApplicationAgentsMethod)
        == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getListAiApplicationAgentsMethod = AgentRegistryGrpc.getListAiApplicationAgentsMethod)
            == null) {
          AgentRegistryGrpc.getListAiApplicationAgentsMethod =
              getListAiApplicationAgentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.ListAiApplicationAgentsRequest,
                          com.google.cloud.agentregistry.v1.ListAiApplicationAgentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAiApplicationAgents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.ListAiApplicationAgentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.ListAiApplicationAgentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("ListAiApplicationAgents"))
                      .build();
        }
      }
    }
    return getListAiApplicationAgentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetAiApplicationMcpServerRequest,
          com.google.cloud.agentregistry.v1.McpServer>
      getGetAiApplicationMcpServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAiApplicationMcpServer",
      requestType = com.google.cloud.agentregistry.v1.GetAiApplicationMcpServerRequest.class,
      responseType = com.google.cloud.agentregistry.v1.McpServer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetAiApplicationMcpServerRequest,
          com.google.cloud.agentregistry.v1.McpServer>
      getGetAiApplicationMcpServerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.GetAiApplicationMcpServerRequest,
            com.google.cloud.agentregistry.v1.McpServer>
        getGetAiApplicationMcpServerMethod;
    if ((getGetAiApplicationMcpServerMethod = AgentRegistryGrpc.getGetAiApplicationMcpServerMethod)
        == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getGetAiApplicationMcpServerMethod =
                AgentRegistryGrpc.getGetAiApplicationMcpServerMethod)
            == null) {
          AgentRegistryGrpc.getGetAiApplicationMcpServerMethod =
              getGetAiApplicationMcpServerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.GetAiApplicationMcpServerRequest,
                          com.google.cloud.agentregistry.v1.McpServer>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetAiApplicationMcpServer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.GetAiApplicationMcpServerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.McpServer.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("GetAiApplicationMcpServer"))
                      .build();
        }
      }
    }
    return getGetAiApplicationMcpServerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersRequest,
          com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersResponse>
      getListAiApplicationMcpServersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAiApplicationMcpServers",
      requestType = com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersRequest.class,
      responseType = com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersRequest,
          com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersResponse>
      getListAiApplicationMcpServersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersRequest,
            com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersResponse>
        getListAiApplicationMcpServersMethod;
    if ((getListAiApplicationMcpServersMethod =
            AgentRegistryGrpc.getListAiApplicationMcpServersMethod)
        == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getListAiApplicationMcpServersMethod =
                AgentRegistryGrpc.getListAiApplicationMcpServersMethod)
            == null) {
          AgentRegistryGrpc.getListAiApplicationMcpServersMethod =
              getListAiApplicationMcpServersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersRequest,
                          com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAiApplicationMcpServers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("ListAiApplicationMcpServers"))
                      .build();
        }
      }
    }
    return getListAiApplicationMcpServersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetFindingRequest,
          com.google.cloud.agentregistry.v1.Finding>
      getGetFindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFinding",
      requestType = com.google.cloud.agentregistry.v1.GetFindingRequest.class,
      responseType = com.google.cloud.agentregistry.v1.Finding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetFindingRequest,
          com.google.cloud.agentregistry.v1.Finding>
      getGetFindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.GetFindingRequest,
            com.google.cloud.agentregistry.v1.Finding>
        getGetFindingMethod;
    if ((getGetFindingMethod = AgentRegistryGrpc.getGetFindingMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getGetFindingMethod = AgentRegistryGrpc.getGetFindingMethod) == null) {
          AgentRegistryGrpc.getGetFindingMethod =
              getGetFindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.GetFindingRequest,
                          com.google.cloud.agentregistry.v1.Finding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.GetFindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.Finding.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentRegistryMethodDescriptorSupplier("GetFinding"))
                      .build();
        }
      }
    }
    return getGetFindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.ListFindingsRequest,
          com.google.cloud.agentregistry.v1.ListFindingsResponse>
      getListFindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFindings",
      requestType = com.google.cloud.agentregistry.v1.ListFindingsRequest.class,
      responseType = com.google.cloud.agentregistry.v1.ListFindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.ListFindingsRequest,
          com.google.cloud.agentregistry.v1.ListFindingsResponse>
      getListFindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.ListFindingsRequest,
            com.google.cloud.agentregistry.v1.ListFindingsResponse>
        getListFindingsMethod;
    if ((getListFindingsMethod = AgentRegistryGrpc.getListFindingsMethod) == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getListFindingsMethod = AgentRegistryGrpc.getListFindingsMethod) == null) {
          AgentRegistryGrpc.getListFindingsMethod =
              getListFindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.ListFindingsRequest,
                          com.google.cloud.agentregistry.v1.ListFindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.ListFindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.ListFindingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("ListFindings"))
                      .build();
        }
      }
    }
    return getListFindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetAiApplicationEndpointRequest,
          com.google.cloud.agentregistry.v1.Endpoint>
      getGetAiApplicationEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAiApplicationEndpoint",
      requestType = com.google.cloud.agentregistry.v1.GetAiApplicationEndpointRequest.class,
      responseType = com.google.cloud.agentregistry.v1.Endpoint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetAiApplicationEndpointRequest,
          com.google.cloud.agentregistry.v1.Endpoint>
      getGetAiApplicationEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.GetAiApplicationEndpointRequest,
            com.google.cloud.agentregistry.v1.Endpoint>
        getGetAiApplicationEndpointMethod;
    if ((getGetAiApplicationEndpointMethod = AgentRegistryGrpc.getGetAiApplicationEndpointMethod)
        == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getGetAiApplicationEndpointMethod =
                AgentRegistryGrpc.getGetAiApplicationEndpointMethod)
            == null) {
          AgentRegistryGrpc.getGetAiApplicationEndpointMethod =
              getGetAiApplicationEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.GetAiApplicationEndpointRequest,
                          com.google.cloud.agentregistry.v1.Endpoint>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetAiApplicationEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.GetAiApplicationEndpointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.Endpoint.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("GetAiApplicationEndpoint"))
                      .build();
        }
      }
    }
    return getGetAiApplicationEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsRequest,
          com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsResponse>
      getListAiApplicationEndpointsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAiApplicationEndpoints",
      requestType = com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsRequest.class,
      responseType = com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsRequest,
          com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsResponse>
      getListAiApplicationEndpointsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsRequest,
            com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsResponse>
        getListAiApplicationEndpointsMethod;
    if ((getListAiApplicationEndpointsMethod =
            AgentRegistryGrpc.getListAiApplicationEndpointsMethod)
        == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getListAiApplicationEndpointsMethod =
                AgentRegistryGrpc.getListAiApplicationEndpointsMethod)
            == null) {
          AgentRegistryGrpc.getListAiApplicationEndpointsMethod =
              getListAiApplicationEndpointsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsRequest,
                          com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAiApplicationEndpoints"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("ListAiApplicationEndpoints"))
                      .build();
        }
      }
    }
    return getListAiApplicationEndpointsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetSkillEncryptionSpecRequest,
          com.google.cloud.agentregistry.v1.SkillEncryptionSpec>
      getGetSkillEncryptionSpecMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSkillEncryptionSpec",
      requestType = com.google.cloud.agentregistry.v1.GetSkillEncryptionSpecRequest.class,
      responseType = com.google.cloud.agentregistry.v1.SkillEncryptionSpec.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.GetSkillEncryptionSpecRequest,
          com.google.cloud.agentregistry.v1.SkillEncryptionSpec>
      getGetSkillEncryptionSpecMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.GetSkillEncryptionSpecRequest,
            com.google.cloud.agentregistry.v1.SkillEncryptionSpec>
        getGetSkillEncryptionSpecMethod;
    if ((getGetSkillEncryptionSpecMethod = AgentRegistryGrpc.getGetSkillEncryptionSpecMethod)
        == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getGetSkillEncryptionSpecMethod = AgentRegistryGrpc.getGetSkillEncryptionSpecMethod)
            == null) {
          AgentRegistryGrpc.getGetSkillEncryptionSpecMethod =
              getGetSkillEncryptionSpecMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.GetSkillEncryptionSpecRequest,
                          com.google.cloud.agentregistry.v1.SkillEncryptionSpec>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetSkillEncryptionSpec"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.GetSkillEncryptionSpecRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.SkillEncryptionSpec
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("GetSkillEncryptionSpec"))
                      .build();
        }
      }
    }
    return getGetSkillEncryptionSpecMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.UpdateSkillEncryptionSpecRequest,
          com.google.longrunning.Operation>
      getUpdateSkillEncryptionSpecMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSkillEncryptionSpec",
      requestType = com.google.cloud.agentregistry.v1.UpdateSkillEncryptionSpecRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.agentregistry.v1.UpdateSkillEncryptionSpecRequest,
          com.google.longrunning.Operation>
      getUpdateSkillEncryptionSpecMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.agentregistry.v1.UpdateSkillEncryptionSpecRequest,
            com.google.longrunning.Operation>
        getUpdateSkillEncryptionSpecMethod;
    if ((getUpdateSkillEncryptionSpecMethod = AgentRegistryGrpc.getUpdateSkillEncryptionSpecMethod)
        == null) {
      synchronized (AgentRegistryGrpc.class) {
        if ((getUpdateSkillEncryptionSpecMethod =
                AgentRegistryGrpc.getUpdateSkillEncryptionSpecMethod)
            == null) {
          AgentRegistryGrpc.getUpdateSkillEncryptionSpecMethod =
              getUpdateSkillEncryptionSpecMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.agentregistry.v1.UpdateSkillEncryptionSpecRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateSkillEncryptionSpec"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.agentregistry.v1.UpdateSkillEncryptionSpecRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentRegistryMethodDescriptorSupplier("UpdateSkillEncryptionSpec"))
                      .build();
        }
      }
    }
    return getUpdateSkillEncryptionSpecMethod;
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
   * Service for managing Agent Registry resources.
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

    /**
     *
     *
     * <pre>
     * =========================================================================
     * # Skills Collection APIs
     * Creates a Skill resource container, optionally publishing the initial
     * SkillRevision inline in a single, atomic CRUD roundtrip.
     * </pre>
     */
    default void createSkill(
        com.google.cloud.agentregistry.v1.CreateSkillRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSkillMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches the active configuration and metadata of a Skill.
     * </pre>
     */
    default void getSkill(
        com.google.cloud.agentregistry.v1.GetSkillRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Skill> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSkillMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates Skill metadata or overrides active pointers/state using REST
     * standard PATCH.
     * </pre>
     */
    default void updateSkill(
        com.google.cloud.agentregistry.v1.UpdateSkillRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSkillMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Skill container along with all its revisions.
     * </pre>
     */
    default void deleteSkill(
        com.google.cloud.agentregistry.v1.DeleteSkillRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSkillMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists logical Skills available in a project.
     * </pre>
     */
    default void listSkills(
        com.google.cloud.agentregistry.v1.ListSkillsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.ListSkillsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSkillsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Custom deep-search method to filter by frontmatter or query SKILL.md text
     * blobs.
     * </pre>
     */
    default void searchSkills(
        com.google.cloud.agentregistry.v1.SearchSkillsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.SearchSkillsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchSkillsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new immutable revision and triggers validation pipelines.
     * </pre>
     */
    default void createSkillRevision(
        com.google.cloud.agentregistry.v1.CreateSkillRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSkillRevisionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single immutable Revision.
     * </pre>
     */
    default void getSkillRevision(
        com.google.cloud.agentregistry.v1.GetSkillRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.SkillRevision>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSkillRevisionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific revision (restricted to admins to purge accidentally
     * committed secrets).
     * </pre>
     */
    default void deleteSkillRevision(
        com.google.cloud.agentregistry.v1.DeleteSkillRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSkillRevisionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all revisions belonging to a parent Skill.
     * </pre>
     */
    default void listSkillRevisions(
        com.google.cloud.agentregistry.v1.ListSkillRevisionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.ListSkillRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSkillRevisionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches details of a specific Publisher.
     * </pre>
     */
    default void getPublisher(
        com.google.cloud.agentregistry.v1.GetPublisherRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Publisher> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPublisherMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all Publishers in a location.
     * </pre>
     */
    default void listPublishers(
        com.google.cloud.agentregistry.v1.ListPublishersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.ListPublishersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPublishersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AI Application.
     * </pre>
     */
    default void getAiApplication(
        com.google.cloud.agentregistry.v1.GetAiApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.AiApplication>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAiApplicationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists AI Applications in a given project and location.
     * </pre>
     */
    default void listAiApplications(
        com.google.cloud.agentregistry.v1.ListAiApplicationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.ListAiApplicationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAiApplicationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Agent under an AI Application.
     * </pre>
     */
    default void getAiApplicationAgent(
        com.google.cloud.agentregistry.v1.GetAiApplicationAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Agent> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAiApplicationAgentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Agents under an AI Application.
     * </pre>
     */
    default void listAiApplicationAgents(
        com.google.cloud.agentregistry.v1.ListAiApplicationAgentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.agentregistry.v1.ListAiApplicationAgentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAiApplicationAgentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single McpServer under an AI Application.
     * </pre>
     */
    default void getAiApplicationMcpServer(
        com.google.cloud.agentregistry.v1.GetAiApplicationMcpServerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.McpServer> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAiApplicationMcpServerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists McpServers under an AI Application.
     * </pre>
     */
    default void listAiApplicationMcpServers(
        com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAiApplicationMcpServersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Finding.
     * </pre>
     */
    default void getFinding(
        com.google.cloud.agentregistry.v1.GetFindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Finding> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Findings in a given project and location.
     * </pre>
     */
    default void listFindings(
        com.google.cloud.agentregistry.v1.ListFindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.ListFindingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFindingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Endpoint under an AI Application.
     * </pre>
     */
    default void getAiApplicationEndpoint(
        com.google.cloud.agentregistry.v1.GetAiApplicationEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Endpoint> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAiApplicationEndpointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Endpoints under an AI Application.
     * </pre>
     */
    default void listAiApplicationEndpoints(
        com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAiApplicationEndpointsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * =========================================================================
     * # Skill Encryption Spec Service Methods
     * Gets the customer-managed encryption key (CMEK) configuration for Skills in
     * a specific project and location.
     * </pre>
     */
    default void getSkillEncryptionSpec(
        com.google.cloud.agentregistry.v1.GetSkillEncryptionSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.SkillEncryptionSpec>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSkillEncryptionSpecMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the customer-managed encryption key (CMEK) configuration for Skills
     * in a specific project and location.
     * This method is only allowed when no Skills exist in the target project and
     * location. If any Skill already exists in the location, the request fails
     * with `FAILED_PRECONDITION`.
     * </pre>
     */
    default void updateSkillEncryptionSpec(
        com.google.cloud.agentregistry.v1.UpdateSkillEncryptionSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSkillEncryptionSpecMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AgentRegistry.
   *
   * <pre>
   * Service for managing Agent Registry resources.
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
   * Service for managing Agent Registry resources.
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

    /**
     *
     *
     * <pre>
     * =========================================================================
     * # Skills Collection APIs
     * Creates a Skill resource container, optionally publishing the initial
     * SkillRevision inline in a single, atomic CRUD roundtrip.
     * </pre>
     */
    public void createSkill(
        com.google.cloud.agentregistry.v1.CreateSkillRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSkillMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches the active configuration and metadata of a Skill.
     * </pre>
     */
    public void getSkill(
        com.google.cloud.agentregistry.v1.GetSkillRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Skill> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSkillMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates Skill metadata or overrides active pointers/state using REST
     * standard PATCH.
     * </pre>
     */
    public void updateSkill(
        com.google.cloud.agentregistry.v1.UpdateSkillRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSkillMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Skill container along with all its revisions.
     * </pre>
     */
    public void deleteSkill(
        com.google.cloud.agentregistry.v1.DeleteSkillRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSkillMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists logical Skills available in a project.
     * </pre>
     */
    public void listSkills(
        com.google.cloud.agentregistry.v1.ListSkillsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.ListSkillsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSkillsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Custom deep-search method to filter by frontmatter or query SKILL.md text
     * blobs.
     * </pre>
     */
    public void searchSkills(
        com.google.cloud.agentregistry.v1.SearchSkillsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.SearchSkillsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchSkillsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new immutable revision and triggers validation pipelines.
     * </pre>
     */
    public void createSkillRevision(
        com.google.cloud.agentregistry.v1.CreateSkillRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSkillRevisionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single immutable Revision.
     * </pre>
     */
    public void getSkillRevision(
        com.google.cloud.agentregistry.v1.GetSkillRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.SkillRevision>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSkillRevisionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific revision (restricted to admins to purge accidentally
     * committed secrets).
     * </pre>
     */
    public void deleteSkillRevision(
        com.google.cloud.agentregistry.v1.DeleteSkillRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSkillRevisionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all revisions belonging to a parent Skill.
     * </pre>
     */
    public void listSkillRevisions(
        com.google.cloud.agentregistry.v1.ListSkillRevisionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.ListSkillRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSkillRevisionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches details of a specific Publisher.
     * </pre>
     */
    public void getPublisher(
        com.google.cloud.agentregistry.v1.GetPublisherRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Publisher> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPublisherMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all Publishers in a location.
     * </pre>
     */
    public void listPublishers(
        com.google.cloud.agentregistry.v1.ListPublishersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.ListPublishersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPublishersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AI Application.
     * </pre>
     */
    public void getAiApplication(
        com.google.cloud.agentregistry.v1.GetAiApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.AiApplication>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAiApplicationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists AI Applications in a given project and location.
     * </pre>
     */
    public void listAiApplications(
        com.google.cloud.agentregistry.v1.ListAiApplicationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.ListAiApplicationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAiApplicationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Agent under an AI Application.
     * </pre>
     */
    public void getAiApplicationAgent(
        com.google.cloud.agentregistry.v1.GetAiApplicationAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Agent> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAiApplicationAgentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Agents under an AI Application.
     * </pre>
     */
    public void listAiApplicationAgents(
        com.google.cloud.agentregistry.v1.ListAiApplicationAgentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.agentregistry.v1.ListAiApplicationAgentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAiApplicationAgentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single McpServer under an AI Application.
     * </pre>
     */
    public void getAiApplicationMcpServer(
        com.google.cloud.agentregistry.v1.GetAiApplicationMcpServerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.McpServer> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAiApplicationMcpServerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists McpServers under an AI Application.
     * </pre>
     */
    public void listAiApplicationMcpServers(
        com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAiApplicationMcpServersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Finding.
     * </pre>
     */
    public void getFinding(
        com.google.cloud.agentregistry.v1.GetFindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Finding> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFindingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Findings in a given project and location.
     * </pre>
     */
    public void listFindings(
        com.google.cloud.agentregistry.v1.ListFindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.ListFindingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFindingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Endpoint under an AI Application.
     * </pre>
     */
    public void getAiApplicationEndpoint(
        com.google.cloud.agentregistry.v1.GetAiApplicationEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Endpoint> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAiApplicationEndpointMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Endpoints under an AI Application.
     * </pre>
     */
    public void listAiApplicationEndpoints(
        com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAiApplicationEndpointsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * =========================================================================
     * # Skill Encryption Spec Service Methods
     * Gets the customer-managed encryption key (CMEK) configuration for Skills in
     * a specific project and location.
     * </pre>
     */
    public void getSkillEncryptionSpec(
        com.google.cloud.agentregistry.v1.GetSkillEncryptionSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.SkillEncryptionSpec>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSkillEncryptionSpecMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the customer-managed encryption key (CMEK) configuration for Skills
     * in a specific project and location.
     * This method is only allowed when no Skills exist in the target project and
     * location. If any Skill already exists in the location, the request fails
     * with `FAILED_PRECONDITION`.
     * </pre>
     */
    public void updateSkillEncryptionSpec(
        com.google.cloud.agentregistry.v1.UpdateSkillEncryptionSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSkillEncryptionSpecMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AgentRegistry.
   *
   * <pre>
   * Service for managing Agent Registry resources.
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

    /**
     *
     *
     * <pre>
     * =========================================================================
     * # Skills Collection APIs
     * Creates a Skill resource container, optionally publishing the initial
     * SkillRevision inline in a single, atomic CRUD roundtrip.
     * </pre>
     */
    public com.google.longrunning.Operation createSkill(
        com.google.cloud.agentregistry.v1.CreateSkillRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateSkillMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches the active configuration and metadata of a Skill.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.Skill getSkill(
        com.google.cloud.agentregistry.v1.GetSkillRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSkillMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates Skill metadata or overrides active pointers/state using REST
     * standard PATCH.
     * </pre>
     */
    public com.google.longrunning.Operation updateSkill(
        com.google.cloud.agentregistry.v1.UpdateSkillRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateSkillMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Skill container along with all its revisions.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSkill(
        com.google.cloud.agentregistry.v1.DeleteSkillRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteSkillMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists logical Skills available in a project.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.ListSkillsResponse listSkills(
        com.google.cloud.agentregistry.v1.ListSkillsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListSkillsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Custom deep-search method to filter by frontmatter or query SKILL.md text
     * blobs.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.SearchSkillsResponse searchSkills(
        com.google.cloud.agentregistry.v1.SearchSkillsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSearchSkillsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new immutable revision and triggers validation pipelines.
     * </pre>
     */
    public com.google.longrunning.Operation createSkillRevision(
        com.google.cloud.agentregistry.v1.CreateSkillRevisionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateSkillRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single immutable Revision.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.SkillRevision getSkillRevision(
        com.google.cloud.agentregistry.v1.GetSkillRevisionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSkillRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific revision (restricted to admins to purge accidentally
     * committed secrets).
     * </pre>
     */
    public com.google.longrunning.Operation deleteSkillRevision(
        com.google.cloud.agentregistry.v1.DeleteSkillRevisionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteSkillRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all revisions belonging to a parent Skill.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.ListSkillRevisionsResponse listSkillRevisions(
        com.google.cloud.agentregistry.v1.ListSkillRevisionsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListSkillRevisionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches details of a specific Publisher.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.Publisher getPublisher(
        com.google.cloud.agentregistry.v1.GetPublisherRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetPublisherMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all Publishers in a location.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.ListPublishersResponse listPublishers(
        com.google.cloud.agentregistry.v1.ListPublishersRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListPublishersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AI Application.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.AiApplication getAiApplication(
        com.google.cloud.agentregistry.v1.GetAiApplicationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAiApplicationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists AI Applications in a given project and location.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.ListAiApplicationsResponse listAiApplications(
        com.google.cloud.agentregistry.v1.ListAiApplicationsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAiApplicationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Agent under an AI Application.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.Agent getAiApplicationAgent(
        com.google.cloud.agentregistry.v1.GetAiApplicationAgentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAiApplicationAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Agents under an AI Application.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.ListAiApplicationAgentsResponse
        listAiApplicationAgents(
            com.google.cloud.agentregistry.v1.ListAiApplicationAgentsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAiApplicationAgentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single McpServer under an AI Application.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.McpServer getAiApplicationMcpServer(
        com.google.cloud.agentregistry.v1.GetAiApplicationMcpServerRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAiApplicationMcpServerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists McpServers under an AI Application.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersResponse
        listAiApplicationMcpServers(
            com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAiApplicationMcpServersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Finding.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.Finding getFinding(
        com.google.cloud.agentregistry.v1.GetFindingRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetFindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Findings in a given project and location.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.ListFindingsResponse listFindings(
        com.google.cloud.agentregistry.v1.ListFindingsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListFindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Endpoint under an AI Application.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.Endpoint getAiApplicationEndpoint(
        com.google.cloud.agentregistry.v1.GetAiApplicationEndpointRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAiApplicationEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Endpoints under an AI Application.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsResponse
        listAiApplicationEndpoints(
            com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAiApplicationEndpointsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * =========================================================================
     * # Skill Encryption Spec Service Methods
     * Gets the customer-managed encryption key (CMEK) configuration for Skills in
     * a specific project and location.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.SkillEncryptionSpec getSkillEncryptionSpec(
        com.google.cloud.agentregistry.v1.GetSkillEncryptionSpecRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSkillEncryptionSpecMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the customer-managed encryption key (CMEK) configuration for Skills
     * in a specific project and location.
     * This method is only allowed when no Skills exist in the target project and
     * location. If any Skill already exists in the location, the request fails
     * with `FAILED_PRECONDITION`.
     * </pre>
     */
    public com.google.longrunning.Operation updateSkillEncryptionSpec(
        com.google.cloud.agentregistry.v1.UpdateSkillEncryptionSpecRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateSkillEncryptionSpecMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service AgentRegistry.
   *
   * <pre>
   * Service for managing Agent Registry resources.
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

    /**
     *
     *
     * <pre>
     * =========================================================================
     * # Skills Collection APIs
     * Creates a Skill resource container, optionally publishing the initial
     * SkillRevision inline in a single, atomic CRUD roundtrip.
     * </pre>
     */
    public com.google.longrunning.Operation createSkill(
        com.google.cloud.agentregistry.v1.CreateSkillRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSkillMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches the active configuration and metadata of a Skill.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.Skill getSkill(
        com.google.cloud.agentregistry.v1.GetSkillRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSkillMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates Skill metadata or overrides active pointers/state using REST
     * standard PATCH.
     * </pre>
     */
    public com.google.longrunning.Operation updateSkill(
        com.google.cloud.agentregistry.v1.UpdateSkillRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSkillMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Skill container along with all its revisions.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSkill(
        com.google.cloud.agentregistry.v1.DeleteSkillRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSkillMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists logical Skills available in a project.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.ListSkillsResponse listSkills(
        com.google.cloud.agentregistry.v1.ListSkillsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSkillsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Custom deep-search method to filter by frontmatter or query SKILL.md text
     * blobs.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.SearchSkillsResponse searchSkills(
        com.google.cloud.agentregistry.v1.SearchSkillsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchSkillsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new immutable revision and triggers validation pipelines.
     * </pre>
     */
    public com.google.longrunning.Operation createSkillRevision(
        com.google.cloud.agentregistry.v1.CreateSkillRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSkillRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single immutable Revision.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.SkillRevision getSkillRevision(
        com.google.cloud.agentregistry.v1.GetSkillRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSkillRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific revision (restricted to admins to purge accidentally
     * committed secrets).
     * </pre>
     */
    public com.google.longrunning.Operation deleteSkillRevision(
        com.google.cloud.agentregistry.v1.DeleteSkillRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSkillRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all revisions belonging to a parent Skill.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.ListSkillRevisionsResponse listSkillRevisions(
        com.google.cloud.agentregistry.v1.ListSkillRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSkillRevisionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches details of a specific Publisher.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.Publisher getPublisher(
        com.google.cloud.agentregistry.v1.GetPublisherRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPublisherMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all Publishers in a location.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.ListPublishersResponse listPublishers(
        com.google.cloud.agentregistry.v1.ListPublishersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPublishersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AI Application.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.AiApplication getAiApplication(
        com.google.cloud.agentregistry.v1.GetAiApplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAiApplicationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists AI Applications in a given project and location.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.ListAiApplicationsResponse listAiApplications(
        com.google.cloud.agentregistry.v1.ListAiApplicationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAiApplicationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Agent under an AI Application.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.Agent getAiApplicationAgent(
        com.google.cloud.agentregistry.v1.GetAiApplicationAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAiApplicationAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Agents under an AI Application.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.ListAiApplicationAgentsResponse
        listAiApplicationAgents(
            com.google.cloud.agentregistry.v1.ListAiApplicationAgentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAiApplicationAgentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single McpServer under an AI Application.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.McpServer getAiApplicationMcpServer(
        com.google.cloud.agentregistry.v1.GetAiApplicationMcpServerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAiApplicationMcpServerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists McpServers under an AI Application.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersResponse
        listAiApplicationMcpServers(
            com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAiApplicationMcpServersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Finding.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.Finding getFinding(
        com.google.cloud.agentregistry.v1.GetFindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Findings in a given project and location.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.ListFindingsResponse listFindings(
        com.google.cloud.agentregistry.v1.ListFindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Endpoint under an AI Application.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.Endpoint getAiApplicationEndpoint(
        com.google.cloud.agentregistry.v1.GetAiApplicationEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAiApplicationEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Endpoints under an AI Application.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsResponse
        listAiApplicationEndpoints(
            com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAiApplicationEndpointsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * =========================================================================
     * # Skill Encryption Spec Service Methods
     * Gets the customer-managed encryption key (CMEK) configuration for Skills in
     * a specific project and location.
     * </pre>
     */
    public com.google.cloud.agentregistry.v1.SkillEncryptionSpec getSkillEncryptionSpec(
        com.google.cloud.agentregistry.v1.GetSkillEncryptionSpecRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSkillEncryptionSpecMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the customer-managed encryption key (CMEK) configuration for Skills
     * in a specific project and location.
     * This method is only allowed when no Skills exist in the target project and
     * location. If any Skill already exists in the location, the request fails
     * with `FAILED_PRECONDITION`.
     * </pre>
     */
    public com.google.longrunning.Operation updateSkillEncryptionSpec(
        com.google.cloud.agentregistry.v1.UpdateSkillEncryptionSpecRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSkillEncryptionSpecMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AgentRegistry.
   *
   * <pre>
   * Service for managing Agent Registry resources.
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

    /**
     *
     *
     * <pre>
     * =========================================================================
     * # Skills Collection APIs
     * Creates a Skill resource container, optionally publishing the initial
     * SkillRevision inline in a single, atomic CRUD roundtrip.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createSkill(com.google.cloud.agentregistry.v1.CreateSkillRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSkillMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches the active configuration and metadata of a Skill.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.Skill>
        getSkill(com.google.cloud.agentregistry.v1.GetSkillRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSkillMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates Skill metadata or overrides active pointers/state using REST
     * standard PATCH.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateSkill(com.google.cloud.agentregistry.v1.UpdateSkillRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSkillMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Skill container along with all its revisions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteSkill(com.google.cloud.agentregistry.v1.DeleteSkillRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSkillMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists logical Skills available in a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.ListSkillsResponse>
        listSkills(com.google.cloud.agentregistry.v1.ListSkillsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSkillsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Custom deep-search method to filter by frontmatter or query SKILL.md text
     * blobs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.SearchSkillsResponse>
        searchSkills(com.google.cloud.agentregistry.v1.SearchSkillsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchSkillsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new immutable revision and triggers validation pipelines.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createSkillRevision(com.google.cloud.agentregistry.v1.CreateSkillRevisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSkillRevisionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single immutable Revision.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.SkillRevision>
        getSkillRevision(com.google.cloud.agentregistry.v1.GetSkillRevisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSkillRevisionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific revision (restricted to admins to purge accidentally
     * committed secrets).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteSkillRevision(com.google.cloud.agentregistry.v1.DeleteSkillRevisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSkillRevisionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all revisions belonging to a parent Skill.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.ListSkillRevisionsResponse>
        listSkillRevisions(com.google.cloud.agentregistry.v1.ListSkillRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSkillRevisionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches details of a specific Publisher.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.Publisher>
        getPublisher(com.google.cloud.agentregistry.v1.GetPublisherRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPublisherMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all Publishers in a location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.ListPublishersResponse>
        listPublishers(com.google.cloud.agentregistry.v1.ListPublishersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPublishersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AI Application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.AiApplication>
        getAiApplication(com.google.cloud.agentregistry.v1.GetAiApplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAiApplicationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists AI Applications in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.ListAiApplicationsResponse>
        listAiApplications(com.google.cloud.agentregistry.v1.ListAiApplicationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAiApplicationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Agent under an AI Application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.Agent>
        getAiApplicationAgent(
            com.google.cloud.agentregistry.v1.GetAiApplicationAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAiApplicationAgentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Agents under an AI Application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.ListAiApplicationAgentsResponse>
        listAiApplicationAgents(
            com.google.cloud.agentregistry.v1.ListAiApplicationAgentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAiApplicationAgentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single McpServer under an AI Application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.McpServer>
        getAiApplicationMcpServer(
            com.google.cloud.agentregistry.v1.GetAiApplicationMcpServerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAiApplicationMcpServerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists McpServers under an AI Application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersResponse>
        listAiApplicationMcpServers(
            com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAiApplicationMcpServersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Finding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.Finding>
        getFinding(com.google.cloud.agentregistry.v1.GetFindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Findings in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.ListFindingsResponse>
        listFindings(com.google.cloud.agentregistry.v1.ListFindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFindingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Endpoint under an AI Application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.Endpoint>
        getAiApplicationEndpoint(
            com.google.cloud.agentregistry.v1.GetAiApplicationEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAiApplicationEndpointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Endpoints under an AI Application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsResponse>
        listAiApplicationEndpoints(
            com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAiApplicationEndpointsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * =========================================================================
     * # Skill Encryption Spec Service Methods
     * Gets the customer-managed encryption key (CMEK) configuration for Skills in
     * a specific project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.agentregistry.v1.SkillEncryptionSpec>
        getSkillEncryptionSpec(
            com.google.cloud.agentregistry.v1.GetSkillEncryptionSpecRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSkillEncryptionSpecMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the customer-managed encryption key (CMEK) configuration for Skills
     * in a specific project and location.
     * This method is only allowed when no Skills exist in the target project and
     * location. If any Skill already exists in the location, the request fails
     * with `FAILED_PRECONDITION`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateSkillEncryptionSpec(
            com.google.cloud.agentregistry.v1.UpdateSkillEncryptionSpecRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSkillEncryptionSpecMethod(), getCallOptions()), request);
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
  private static final int METHODID_CREATE_SKILL = 19;
  private static final int METHODID_GET_SKILL = 20;
  private static final int METHODID_UPDATE_SKILL = 21;
  private static final int METHODID_DELETE_SKILL = 22;
  private static final int METHODID_LIST_SKILLS = 23;
  private static final int METHODID_SEARCH_SKILLS = 24;
  private static final int METHODID_CREATE_SKILL_REVISION = 25;
  private static final int METHODID_GET_SKILL_REVISION = 26;
  private static final int METHODID_DELETE_SKILL_REVISION = 27;
  private static final int METHODID_LIST_SKILL_REVISIONS = 28;
  private static final int METHODID_GET_PUBLISHER = 29;
  private static final int METHODID_LIST_PUBLISHERS = 30;
  private static final int METHODID_GET_AI_APPLICATION = 31;
  private static final int METHODID_LIST_AI_APPLICATIONS = 32;
  private static final int METHODID_GET_AI_APPLICATION_AGENT = 33;
  private static final int METHODID_LIST_AI_APPLICATION_AGENTS = 34;
  private static final int METHODID_GET_AI_APPLICATION_MCP_SERVER = 35;
  private static final int METHODID_LIST_AI_APPLICATION_MCP_SERVERS = 36;
  private static final int METHODID_GET_FINDING = 37;
  private static final int METHODID_LIST_FINDINGS = 38;
  private static final int METHODID_GET_AI_APPLICATION_ENDPOINT = 39;
  private static final int METHODID_LIST_AI_APPLICATION_ENDPOINTS = 40;
  private static final int METHODID_GET_SKILL_ENCRYPTION_SPEC = 41;
  private static final int METHODID_UPDATE_SKILL_ENCRYPTION_SPEC = 42;

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
        case METHODID_CREATE_SKILL:
          serviceImpl.createSkill(
              (com.google.cloud.agentregistry.v1.CreateSkillRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_SKILL:
          serviceImpl.getSkill(
              (com.google.cloud.agentregistry.v1.GetSkillRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Skill>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SKILL:
          serviceImpl.updateSkill(
              (com.google.cloud.agentregistry.v1.UpdateSkillRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SKILL:
          serviceImpl.deleteSkill(
              (com.google.cloud.agentregistry.v1.DeleteSkillRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SKILLS:
          serviceImpl.listSkills(
              (com.google.cloud.agentregistry.v1.ListSkillsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.ListSkillsResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_SKILLS:
          serviceImpl.searchSkills(
              (com.google.cloud.agentregistry.v1.SearchSkillsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.SearchSkillsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_SKILL_REVISION:
          serviceImpl.createSkillRevision(
              (com.google.cloud.agentregistry.v1.CreateSkillRevisionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_SKILL_REVISION:
          serviceImpl.getSkillRevision(
              (com.google.cloud.agentregistry.v1.GetSkillRevisionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.SkillRevision>)
                  responseObserver);
          break;
        case METHODID_DELETE_SKILL_REVISION:
          serviceImpl.deleteSkillRevision(
              (com.google.cloud.agentregistry.v1.DeleteSkillRevisionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SKILL_REVISIONS:
          serviceImpl.listSkillRevisions(
              (com.google.cloud.agentregistry.v1.ListSkillRevisionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.agentregistry.v1.ListSkillRevisionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PUBLISHER:
          serviceImpl.getPublisher(
              (com.google.cloud.agentregistry.v1.GetPublisherRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Publisher>)
                  responseObserver);
          break;
        case METHODID_LIST_PUBLISHERS:
          serviceImpl.listPublishers(
              (com.google.cloud.agentregistry.v1.ListPublishersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.agentregistry.v1.ListPublishersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_AI_APPLICATION:
          serviceImpl.getAiApplication(
              (com.google.cloud.agentregistry.v1.GetAiApplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.AiApplication>)
                  responseObserver);
          break;
        case METHODID_LIST_AI_APPLICATIONS:
          serviceImpl.listAiApplications(
              (com.google.cloud.agentregistry.v1.ListAiApplicationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.agentregistry.v1.ListAiApplicationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_AI_APPLICATION_AGENT:
          serviceImpl.getAiApplicationAgent(
              (com.google.cloud.agentregistry.v1.GetAiApplicationAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Agent>)
                  responseObserver);
          break;
        case METHODID_LIST_AI_APPLICATION_AGENTS:
          serviceImpl.listAiApplicationAgents(
              (com.google.cloud.agentregistry.v1.ListAiApplicationAgentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.agentregistry.v1.ListAiApplicationAgentsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_AI_APPLICATION_MCP_SERVER:
          serviceImpl.getAiApplicationMcpServer(
              (com.google.cloud.agentregistry.v1.GetAiApplicationMcpServerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.McpServer>)
                  responseObserver);
          break;
        case METHODID_LIST_AI_APPLICATION_MCP_SERVERS:
          serviceImpl.listAiApplicationMcpServers(
              (com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_FINDING:
          serviceImpl.getFinding(
              (com.google.cloud.agentregistry.v1.GetFindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Finding>)
                  responseObserver);
          break;
        case METHODID_LIST_FINDINGS:
          serviceImpl.listFindings(
              (com.google.cloud.agentregistry.v1.ListFindingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.ListFindingsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_AI_APPLICATION_ENDPOINT:
          serviceImpl.getAiApplicationEndpoint(
              (com.google.cloud.agentregistry.v1.GetAiApplicationEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.Endpoint>)
                  responseObserver);
          break;
        case METHODID_LIST_AI_APPLICATION_ENDPOINTS:
          serviceImpl.listAiApplicationEndpoints(
              (com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SKILL_ENCRYPTION_SPEC:
          serviceImpl.getSkillEncryptionSpec(
              (com.google.cloud.agentregistry.v1.GetSkillEncryptionSpecRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.agentregistry.v1.SkillEncryptionSpec>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SKILL_ENCRYPTION_SPEC:
          serviceImpl.updateSkillEncryptionSpec(
              (com.google.cloud.agentregistry.v1.UpdateSkillEncryptionSpecRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
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
        .addMethod(
            getCreateSkillMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.CreateSkillRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SKILL)))
        .addMethod(
            getGetSkillMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.GetSkillRequest,
                    com.google.cloud.agentregistry.v1.Skill>(service, METHODID_GET_SKILL)))
        .addMethod(
            getUpdateSkillMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.UpdateSkillRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_SKILL)))
        .addMethod(
            getDeleteSkillMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.DeleteSkillRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_SKILL)))
        .addMethod(
            getListSkillsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.ListSkillsRequest,
                    com.google.cloud.agentregistry.v1.ListSkillsResponse>(
                    service, METHODID_LIST_SKILLS)))
        .addMethod(
            getSearchSkillsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.SearchSkillsRequest,
                    com.google.cloud.agentregistry.v1.SearchSkillsResponse>(
                    service, METHODID_SEARCH_SKILLS)))
        .addMethod(
            getCreateSkillRevisionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.CreateSkillRevisionRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SKILL_REVISION)))
        .addMethod(
            getGetSkillRevisionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.GetSkillRevisionRequest,
                    com.google.cloud.agentregistry.v1.SkillRevision>(
                    service, METHODID_GET_SKILL_REVISION)))
        .addMethod(
            getDeleteSkillRevisionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.DeleteSkillRevisionRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_SKILL_REVISION)))
        .addMethod(
            getListSkillRevisionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.ListSkillRevisionsRequest,
                    com.google.cloud.agentregistry.v1.ListSkillRevisionsResponse>(
                    service, METHODID_LIST_SKILL_REVISIONS)))
        .addMethod(
            getGetPublisherMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.GetPublisherRequest,
                    com.google.cloud.agentregistry.v1.Publisher>(service, METHODID_GET_PUBLISHER)))
        .addMethod(
            getListPublishersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.ListPublishersRequest,
                    com.google.cloud.agentregistry.v1.ListPublishersResponse>(
                    service, METHODID_LIST_PUBLISHERS)))
        .addMethod(
            getGetAiApplicationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.GetAiApplicationRequest,
                    com.google.cloud.agentregistry.v1.AiApplication>(
                    service, METHODID_GET_AI_APPLICATION)))
        .addMethod(
            getListAiApplicationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.ListAiApplicationsRequest,
                    com.google.cloud.agentregistry.v1.ListAiApplicationsResponse>(
                    service, METHODID_LIST_AI_APPLICATIONS)))
        .addMethod(
            getGetAiApplicationAgentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.GetAiApplicationAgentRequest,
                    com.google.cloud.agentregistry.v1.Agent>(
                    service, METHODID_GET_AI_APPLICATION_AGENT)))
        .addMethod(
            getListAiApplicationAgentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.ListAiApplicationAgentsRequest,
                    com.google.cloud.agentregistry.v1.ListAiApplicationAgentsResponse>(
                    service, METHODID_LIST_AI_APPLICATION_AGENTS)))
        .addMethod(
            getGetAiApplicationMcpServerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.GetAiApplicationMcpServerRequest,
                    com.google.cloud.agentregistry.v1.McpServer>(
                    service, METHODID_GET_AI_APPLICATION_MCP_SERVER)))
        .addMethod(
            getListAiApplicationMcpServersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersRequest,
                    com.google.cloud.agentregistry.v1.ListAiApplicationMcpServersResponse>(
                    service, METHODID_LIST_AI_APPLICATION_MCP_SERVERS)))
        .addMethod(
            getGetFindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.GetFindingRequest,
                    com.google.cloud.agentregistry.v1.Finding>(service, METHODID_GET_FINDING)))
        .addMethod(
            getListFindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.ListFindingsRequest,
                    com.google.cloud.agentregistry.v1.ListFindingsResponse>(
                    service, METHODID_LIST_FINDINGS)))
        .addMethod(
            getGetAiApplicationEndpointMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.GetAiApplicationEndpointRequest,
                    com.google.cloud.agentregistry.v1.Endpoint>(
                    service, METHODID_GET_AI_APPLICATION_ENDPOINT)))
        .addMethod(
            getListAiApplicationEndpointsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsRequest,
                    com.google.cloud.agentregistry.v1.ListAiApplicationEndpointsResponse>(
                    service, METHODID_LIST_AI_APPLICATION_ENDPOINTS)))
        .addMethod(
            getGetSkillEncryptionSpecMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.GetSkillEncryptionSpecRequest,
                    com.google.cloud.agentregistry.v1.SkillEncryptionSpec>(
                    service, METHODID_GET_SKILL_ENCRYPTION_SPEC)))
        .addMethod(
            getUpdateSkillEncryptionSpecMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.agentregistry.v1.UpdateSkillEncryptionSpecRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_SKILL_ENCRYPTION_SPEC)))
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
                      .addMethod(getCreateSkillMethod())
                      .addMethod(getGetSkillMethod())
                      .addMethod(getUpdateSkillMethod())
                      .addMethod(getDeleteSkillMethod())
                      .addMethod(getListSkillsMethod())
                      .addMethod(getSearchSkillsMethod())
                      .addMethod(getCreateSkillRevisionMethod())
                      .addMethod(getGetSkillRevisionMethod())
                      .addMethod(getDeleteSkillRevisionMethod())
                      .addMethod(getListSkillRevisionsMethod())
                      .addMethod(getGetPublisherMethod())
                      .addMethod(getListPublishersMethod())
                      .addMethod(getGetAiApplicationMethod())
                      .addMethod(getListAiApplicationsMethod())
                      .addMethod(getGetAiApplicationAgentMethod())
                      .addMethod(getListAiApplicationAgentsMethod())
                      .addMethod(getGetAiApplicationMcpServerMethod())
                      .addMethod(getListAiApplicationMcpServersMethod())
                      .addMethod(getGetFindingMethod())
                      .addMethod(getListFindingsMethod())
                      .addMethod(getGetAiApplicationEndpointMethod())
                      .addMethod(getListAiApplicationEndpointsMethod())
                      .addMethod(getGetSkillEncryptionSpecMethod())
                      .addMethod(getUpdateSkillEncryptionSpecMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
