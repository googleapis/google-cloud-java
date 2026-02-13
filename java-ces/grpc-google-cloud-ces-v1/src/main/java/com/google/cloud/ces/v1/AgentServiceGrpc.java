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
package com.google.cloud.ces.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The service that manages agent-related resources in Gemini Enterprise for
 * Customer Engagement (CES).
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class AgentServiceGrpc {

  private AgentServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.ces.v1.AgentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.ListAppsRequest, com.google.cloud.ces.v1.ListAppsResponse>
      getListAppsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListApps",
      requestType = com.google.cloud.ces.v1.ListAppsRequest.class,
      responseType = com.google.cloud.ces.v1.ListAppsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.ListAppsRequest, com.google.cloud.ces.v1.ListAppsResponse>
      getListAppsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.ListAppsRequest, com.google.cloud.ces.v1.ListAppsResponse>
        getListAppsMethod;
    if ((getListAppsMethod = AgentServiceGrpc.getListAppsMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getListAppsMethod = AgentServiceGrpc.getListAppsMethod) == null) {
          AgentServiceGrpc.getListAppsMethod =
              getListAppsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.ListAppsRequest,
                          com.google.cloud.ces.v1.ListAppsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListApps"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.ListAppsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.ListAppsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentServiceMethodDescriptorSupplier("ListApps"))
                      .build();
        }
      }
    }
    return getListAppsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.GetAppRequest, com.google.cloud.ces.v1.App>
      getGetAppMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetApp",
      requestType = com.google.cloud.ces.v1.GetAppRequest.class,
      responseType = com.google.cloud.ces.v1.App.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.GetAppRequest, com.google.cloud.ces.v1.App>
      getGetAppMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.ces.v1.GetAppRequest, com.google.cloud.ces.v1.App>
        getGetAppMethod;
    if ((getGetAppMethod = AgentServiceGrpc.getGetAppMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getGetAppMethod = AgentServiceGrpc.getGetAppMethod) == null) {
          AgentServiceGrpc.getGetAppMethod =
              getGetAppMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.GetAppRequest, com.google.cloud.ces.v1.App>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetApp"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.GetAppRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.App.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentServiceMethodDescriptorSupplier("GetApp"))
                      .build();
        }
      }
    }
    return getGetAppMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.CreateAppRequest, com.google.longrunning.Operation>
      getCreateAppMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateApp",
      requestType = com.google.cloud.ces.v1.CreateAppRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.CreateAppRequest, com.google.longrunning.Operation>
      getCreateAppMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.CreateAppRequest, com.google.longrunning.Operation>
        getCreateAppMethod;
    if ((getCreateAppMethod = AgentServiceGrpc.getCreateAppMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getCreateAppMethod = AgentServiceGrpc.getCreateAppMethod) == null) {
          AgentServiceGrpc.getCreateAppMethod =
              getCreateAppMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.CreateAppRequest, com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateApp"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.CreateAppRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentServiceMethodDescriptorSupplier("CreateApp"))
                      .build();
        }
      }
    }
    return getCreateAppMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.UpdateAppRequest, com.google.cloud.ces.v1.App>
      getUpdateAppMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateApp",
      requestType = com.google.cloud.ces.v1.UpdateAppRequest.class,
      responseType = com.google.cloud.ces.v1.App.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.UpdateAppRequest, com.google.cloud.ces.v1.App>
      getUpdateAppMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.ces.v1.UpdateAppRequest, com.google.cloud.ces.v1.App>
        getUpdateAppMethod;
    if ((getUpdateAppMethod = AgentServiceGrpc.getUpdateAppMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getUpdateAppMethod = AgentServiceGrpc.getUpdateAppMethod) == null) {
          AgentServiceGrpc.getUpdateAppMethod =
              getUpdateAppMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.UpdateAppRequest, com.google.cloud.ces.v1.App>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateApp"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.UpdateAppRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.App.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentServiceMethodDescriptorSupplier("UpdateApp"))
                      .build();
        }
      }
    }
    return getUpdateAppMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.DeleteAppRequest, com.google.longrunning.Operation>
      getDeleteAppMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteApp",
      requestType = com.google.cloud.ces.v1.DeleteAppRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.DeleteAppRequest, com.google.longrunning.Operation>
      getDeleteAppMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.DeleteAppRequest, com.google.longrunning.Operation>
        getDeleteAppMethod;
    if ((getDeleteAppMethod = AgentServiceGrpc.getDeleteAppMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getDeleteAppMethod = AgentServiceGrpc.getDeleteAppMethod) == null) {
          AgentServiceGrpc.getDeleteAppMethod =
              getDeleteAppMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.DeleteAppRequest, com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteApp"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.DeleteAppRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentServiceMethodDescriptorSupplier("DeleteApp"))
                      .build();
        }
      }
    }
    return getDeleteAppMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.ExportAppRequest, com.google.longrunning.Operation>
      getExportAppMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportApp",
      requestType = com.google.cloud.ces.v1.ExportAppRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.ExportAppRequest, com.google.longrunning.Operation>
      getExportAppMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.ExportAppRequest, com.google.longrunning.Operation>
        getExportAppMethod;
    if ((getExportAppMethod = AgentServiceGrpc.getExportAppMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getExportAppMethod = AgentServiceGrpc.getExportAppMethod) == null) {
          AgentServiceGrpc.getExportAppMethod =
              getExportAppMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.ExportAppRequest, com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportApp"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.ExportAppRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentServiceMethodDescriptorSupplier("ExportApp"))
                      .build();
        }
      }
    }
    return getExportAppMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.ImportAppRequest, com.google.longrunning.Operation>
      getImportAppMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportApp",
      requestType = com.google.cloud.ces.v1.ImportAppRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.ImportAppRequest, com.google.longrunning.Operation>
      getImportAppMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.ImportAppRequest, com.google.longrunning.Operation>
        getImportAppMethod;
    if ((getImportAppMethod = AgentServiceGrpc.getImportAppMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getImportAppMethod = AgentServiceGrpc.getImportAppMethod) == null) {
          AgentServiceGrpc.getImportAppMethod =
              getImportAppMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.ImportAppRequest, com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportApp"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.ImportAppRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentServiceMethodDescriptorSupplier("ImportApp"))
                      .build();
        }
      }
    }
    return getImportAppMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.ListAgentsRequest, com.google.cloud.ces.v1.ListAgentsResponse>
      getListAgentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAgents",
      requestType = com.google.cloud.ces.v1.ListAgentsRequest.class,
      responseType = com.google.cloud.ces.v1.ListAgentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.ListAgentsRequest, com.google.cloud.ces.v1.ListAgentsResponse>
      getListAgentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.ListAgentsRequest, com.google.cloud.ces.v1.ListAgentsResponse>
        getListAgentsMethod;
    if ((getListAgentsMethod = AgentServiceGrpc.getListAgentsMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getListAgentsMethod = AgentServiceGrpc.getListAgentsMethod) == null) {
          AgentServiceGrpc.getListAgentsMethod =
              getListAgentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.ListAgentsRequest,
                          com.google.cloud.ces.v1.ListAgentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAgents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.ListAgentsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.ListAgentsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentServiceMethodDescriptorSupplier("ListAgents"))
                      .build();
        }
      }
    }
    return getListAgentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.GetAgentRequest, com.google.cloud.ces.v1.Agent>
      getGetAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAgent",
      requestType = com.google.cloud.ces.v1.GetAgentRequest.class,
      responseType = com.google.cloud.ces.v1.Agent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.GetAgentRequest, com.google.cloud.ces.v1.Agent>
      getGetAgentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.ces.v1.GetAgentRequest, com.google.cloud.ces.v1.Agent>
        getGetAgentMethod;
    if ((getGetAgentMethod = AgentServiceGrpc.getGetAgentMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getGetAgentMethod = AgentServiceGrpc.getGetAgentMethod) == null) {
          AgentServiceGrpc.getGetAgentMethod =
              getGetAgentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.GetAgentRequest, com.google.cloud.ces.v1.Agent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAgent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.GetAgentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.Agent.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentServiceMethodDescriptorSupplier("GetAgent"))
                      .build();
        }
      }
    }
    return getGetAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.CreateAgentRequest, com.google.cloud.ces.v1.Agent>
      getCreateAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAgent",
      requestType = com.google.cloud.ces.v1.CreateAgentRequest.class,
      responseType = com.google.cloud.ces.v1.Agent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.CreateAgentRequest, com.google.cloud.ces.v1.Agent>
      getCreateAgentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.CreateAgentRequest, com.google.cloud.ces.v1.Agent>
        getCreateAgentMethod;
    if ((getCreateAgentMethod = AgentServiceGrpc.getCreateAgentMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getCreateAgentMethod = AgentServiceGrpc.getCreateAgentMethod) == null) {
          AgentServiceGrpc.getCreateAgentMethod =
              getCreateAgentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.CreateAgentRequest, com.google.cloud.ces.v1.Agent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAgent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.CreateAgentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.Agent.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentServiceMethodDescriptorSupplier("CreateAgent"))
                      .build();
        }
      }
    }
    return getCreateAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.UpdateAgentRequest, com.google.cloud.ces.v1.Agent>
      getUpdateAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAgent",
      requestType = com.google.cloud.ces.v1.UpdateAgentRequest.class,
      responseType = com.google.cloud.ces.v1.Agent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.UpdateAgentRequest, com.google.cloud.ces.v1.Agent>
      getUpdateAgentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.UpdateAgentRequest, com.google.cloud.ces.v1.Agent>
        getUpdateAgentMethod;
    if ((getUpdateAgentMethod = AgentServiceGrpc.getUpdateAgentMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getUpdateAgentMethod = AgentServiceGrpc.getUpdateAgentMethod) == null) {
          AgentServiceGrpc.getUpdateAgentMethod =
              getUpdateAgentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.UpdateAgentRequest, com.google.cloud.ces.v1.Agent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAgent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.UpdateAgentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.Agent.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentServiceMethodDescriptorSupplier("UpdateAgent"))
                      .build();
        }
      }
    }
    return getUpdateAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.DeleteAgentRequest, com.google.protobuf.Empty>
      getDeleteAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAgent",
      requestType = com.google.cloud.ces.v1.DeleteAgentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.DeleteAgentRequest, com.google.protobuf.Empty>
      getDeleteAgentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.ces.v1.DeleteAgentRequest, com.google.protobuf.Empty>
        getDeleteAgentMethod;
    if ((getDeleteAgentMethod = AgentServiceGrpc.getDeleteAgentMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getDeleteAgentMethod = AgentServiceGrpc.getDeleteAgentMethod) == null) {
          AgentServiceGrpc.getDeleteAgentMethod =
              getDeleteAgentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.DeleteAgentRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAgent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.DeleteAgentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentServiceMethodDescriptorSupplier("DeleteAgent"))
                      .build();
        }
      }
    }
    return getDeleteAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.ListExamplesRequest, com.google.cloud.ces.v1.ListExamplesResponse>
      getListExamplesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListExamples",
      requestType = com.google.cloud.ces.v1.ListExamplesRequest.class,
      responseType = com.google.cloud.ces.v1.ListExamplesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.ListExamplesRequest, com.google.cloud.ces.v1.ListExamplesResponse>
      getListExamplesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.ListExamplesRequest,
            com.google.cloud.ces.v1.ListExamplesResponse>
        getListExamplesMethod;
    if ((getListExamplesMethod = AgentServiceGrpc.getListExamplesMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getListExamplesMethod = AgentServiceGrpc.getListExamplesMethod) == null) {
          AgentServiceGrpc.getListExamplesMethod =
              getListExamplesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.ListExamplesRequest,
                          com.google.cloud.ces.v1.ListExamplesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListExamples"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.ListExamplesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.ListExamplesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentServiceMethodDescriptorSupplier("ListExamples"))
                      .build();
        }
      }
    }
    return getListExamplesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.GetExampleRequest, com.google.cloud.ces.v1.Example>
      getGetExampleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetExample",
      requestType = com.google.cloud.ces.v1.GetExampleRequest.class,
      responseType = com.google.cloud.ces.v1.Example.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.GetExampleRequest, com.google.cloud.ces.v1.Example>
      getGetExampleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.GetExampleRequest, com.google.cloud.ces.v1.Example>
        getGetExampleMethod;
    if ((getGetExampleMethod = AgentServiceGrpc.getGetExampleMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getGetExampleMethod = AgentServiceGrpc.getGetExampleMethod) == null) {
          AgentServiceGrpc.getGetExampleMethod =
              getGetExampleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.GetExampleRequest, com.google.cloud.ces.v1.Example>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetExample"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.GetExampleRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.Example.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentServiceMethodDescriptorSupplier("GetExample"))
                      .build();
        }
      }
    }
    return getGetExampleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.CreateExampleRequest, com.google.cloud.ces.v1.Example>
      getCreateExampleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateExample",
      requestType = com.google.cloud.ces.v1.CreateExampleRequest.class,
      responseType = com.google.cloud.ces.v1.Example.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.CreateExampleRequest, com.google.cloud.ces.v1.Example>
      getCreateExampleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.CreateExampleRequest, com.google.cloud.ces.v1.Example>
        getCreateExampleMethod;
    if ((getCreateExampleMethod = AgentServiceGrpc.getCreateExampleMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getCreateExampleMethod = AgentServiceGrpc.getCreateExampleMethod) == null) {
          AgentServiceGrpc.getCreateExampleMethod =
              getCreateExampleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.CreateExampleRequest,
                          com.google.cloud.ces.v1.Example>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateExample"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.CreateExampleRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.Example.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentServiceMethodDescriptorSupplier("CreateExample"))
                      .build();
        }
      }
    }
    return getCreateExampleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.UpdateExampleRequest, com.google.cloud.ces.v1.Example>
      getUpdateExampleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateExample",
      requestType = com.google.cloud.ces.v1.UpdateExampleRequest.class,
      responseType = com.google.cloud.ces.v1.Example.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.UpdateExampleRequest, com.google.cloud.ces.v1.Example>
      getUpdateExampleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.UpdateExampleRequest, com.google.cloud.ces.v1.Example>
        getUpdateExampleMethod;
    if ((getUpdateExampleMethod = AgentServiceGrpc.getUpdateExampleMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getUpdateExampleMethod = AgentServiceGrpc.getUpdateExampleMethod) == null) {
          AgentServiceGrpc.getUpdateExampleMethod =
              getUpdateExampleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.UpdateExampleRequest,
                          com.google.cloud.ces.v1.Example>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateExample"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.UpdateExampleRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.Example.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentServiceMethodDescriptorSupplier("UpdateExample"))
                      .build();
        }
      }
    }
    return getUpdateExampleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.DeleteExampleRequest, com.google.protobuf.Empty>
      getDeleteExampleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteExample",
      requestType = com.google.cloud.ces.v1.DeleteExampleRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.DeleteExampleRequest, com.google.protobuf.Empty>
      getDeleteExampleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.DeleteExampleRequest, com.google.protobuf.Empty>
        getDeleteExampleMethod;
    if ((getDeleteExampleMethod = AgentServiceGrpc.getDeleteExampleMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getDeleteExampleMethod = AgentServiceGrpc.getDeleteExampleMethod) == null) {
          AgentServiceGrpc.getDeleteExampleMethod =
              getDeleteExampleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.DeleteExampleRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteExample"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.DeleteExampleRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentServiceMethodDescriptorSupplier("DeleteExample"))
                      .build();
        }
      }
    }
    return getDeleteExampleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.ListToolsRequest, com.google.cloud.ces.v1.ListToolsResponse>
      getListToolsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTools",
      requestType = com.google.cloud.ces.v1.ListToolsRequest.class,
      responseType = com.google.cloud.ces.v1.ListToolsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.ListToolsRequest, com.google.cloud.ces.v1.ListToolsResponse>
      getListToolsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.ListToolsRequest, com.google.cloud.ces.v1.ListToolsResponse>
        getListToolsMethod;
    if ((getListToolsMethod = AgentServiceGrpc.getListToolsMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getListToolsMethod = AgentServiceGrpc.getListToolsMethod) == null) {
          AgentServiceGrpc.getListToolsMethod =
              getListToolsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.ListToolsRequest,
                          com.google.cloud.ces.v1.ListToolsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTools"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.ListToolsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.ListToolsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentServiceMethodDescriptorSupplier("ListTools"))
                      .build();
        }
      }
    }
    return getListToolsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.GetToolRequest, com.google.cloud.ces.v1.Tool>
      getGetToolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTool",
      requestType = com.google.cloud.ces.v1.GetToolRequest.class,
      responseType = com.google.cloud.ces.v1.Tool.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.GetToolRequest, com.google.cloud.ces.v1.Tool>
      getGetToolMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.ces.v1.GetToolRequest, com.google.cloud.ces.v1.Tool>
        getGetToolMethod;
    if ((getGetToolMethod = AgentServiceGrpc.getGetToolMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getGetToolMethod = AgentServiceGrpc.getGetToolMethod) == null) {
          AgentServiceGrpc.getGetToolMethod =
              getGetToolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.GetToolRequest, com.google.cloud.ces.v1.Tool>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.GetToolRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.Tool.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentServiceMethodDescriptorSupplier("GetTool"))
                      .build();
        }
      }
    }
    return getGetToolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.ListConversationsRequest,
          com.google.cloud.ces.v1.ListConversationsResponse>
      getListConversationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConversations",
      requestType = com.google.cloud.ces.v1.ListConversationsRequest.class,
      responseType = com.google.cloud.ces.v1.ListConversationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.ListConversationsRequest,
          com.google.cloud.ces.v1.ListConversationsResponse>
      getListConversationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.ListConversationsRequest,
            com.google.cloud.ces.v1.ListConversationsResponse>
        getListConversationsMethod;
    if ((getListConversationsMethod = AgentServiceGrpc.getListConversationsMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getListConversationsMethod = AgentServiceGrpc.getListConversationsMethod) == null) {
          AgentServiceGrpc.getListConversationsMethod =
              getListConversationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.ListConversationsRequest,
                          com.google.cloud.ces.v1.ListConversationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListConversations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.ListConversationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.ListConversationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentServiceMethodDescriptorSupplier("ListConversations"))
                      .build();
        }
      }
    }
    return getListConversationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.GetConversationRequest, com.google.cloud.ces.v1.Conversation>
      getGetConversationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConversation",
      requestType = com.google.cloud.ces.v1.GetConversationRequest.class,
      responseType = com.google.cloud.ces.v1.Conversation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.GetConversationRequest, com.google.cloud.ces.v1.Conversation>
      getGetConversationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.GetConversationRequest, com.google.cloud.ces.v1.Conversation>
        getGetConversationMethod;
    if ((getGetConversationMethod = AgentServiceGrpc.getGetConversationMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getGetConversationMethod = AgentServiceGrpc.getGetConversationMethod) == null) {
          AgentServiceGrpc.getGetConversationMethod =
              getGetConversationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.GetConversationRequest,
                          com.google.cloud.ces.v1.Conversation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConversation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.GetConversationRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.Conversation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentServiceMethodDescriptorSupplier("GetConversation"))
                      .build();
        }
      }
    }
    return getGetConversationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.DeleteConversationRequest, com.google.protobuf.Empty>
      getDeleteConversationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteConversation",
      requestType = com.google.cloud.ces.v1.DeleteConversationRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.DeleteConversationRequest, com.google.protobuf.Empty>
      getDeleteConversationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.DeleteConversationRequest, com.google.protobuf.Empty>
        getDeleteConversationMethod;
    if ((getDeleteConversationMethod = AgentServiceGrpc.getDeleteConversationMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getDeleteConversationMethod = AgentServiceGrpc.getDeleteConversationMethod) == null) {
          AgentServiceGrpc.getDeleteConversationMethod =
              getDeleteConversationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.DeleteConversationRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteConversation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.DeleteConversationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentServiceMethodDescriptorSupplier("DeleteConversation"))
                      .build();
        }
      }
    }
    return getDeleteConversationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.BatchDeleteConversationsRequest, com.google.longrunning.Operation>
      getBatchDeleteConversationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchDeleteConversations",
      requestType = com.google.cloud.ces.v1.BatchDeleteConversationsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.BatchDeleteConversationsRequest, com.google.longrunning.Operation>
      getBatchDeleteConversationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.BatchDeleteConversationsRequest,
            com.google.longrunning.Operation>
        getBatchDeleteConversationsMethod;
    if ((getBatchDeleteConversationsMethod = AgentServiceGrpc.getBatchDeleteConversationsMethod)
        == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getBatchDeleteConversationsMethod = AgentServiceGrpc.getBatchDeleteConversationsMethod)
            == null) {
          AgentServiceGrpc.getBatchDeleteConversationsMethod =
              getBatchDeleteConversationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.BatchDeleteConversationsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchDeleteConversations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.BatchDeleteConversationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentServiceMethodDescriptorSupplier("BatchDeleteConversations"))
                      .build();
        }
      }
    }
    return getBatchDeleteConversationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.CreateToolRequest, com.google.cloud.ces.v1.Tool>
      getCreateToolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTool",
      requestType = com.google.cloud.ces.v1.CreateToolRequest.class,
      responseType = com.google.cloud.ces.v1.Tool.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.CreateToolRequest, com.google.cloud.ces.v1.Tool>
      getCreateToolMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.CreateToolRequest, com.google.cloud.ces.v1.Tool>
        getCreateToolMethod;
    if ((getCreateToolMethod = AgentServiceGrpc.getCreateToolMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getCreateToolMethod = AgentServiceGrpc.getCreateToolMethod) == null) {
          AgentServiceGrpc.getCreateToolMethod =
              getCreateToolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.CreateToolRequest, com.google.cloud.ces.v1.Tool>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.CreateToolRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.Tool.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentServiceMethodDescriptorSupplier("CreateTool"))
                      .build();
        }
      }
    }
    return getCreateToolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.UpdateToolRequest, com.google.cloud.ces.v1.Tool>
      getUpdateToolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTool",
      requestType = com.google.cloud.ces.v1.UpdateToolRequest.class,
      responseType = com.google.cloud.ces.v1.Tool.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.UpdateToolRequest, com.google.cloud.ces.v1.Tool>
      getUpdateToolMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.UpdateToolRequest, com.google.cloud.ces.v1.Tool>
        getUpdateToolMethod;
    if ((getUpdateToolMethod = AgentServiceGrpc.getUpdateToolMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getUpdateToolMethod = AgentServiceGrpc.getUpdateToolMethod) == null) {
          AgentServiceGrpc.getUpdateToolMethod =
              getUpdateToolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.UpdateToolRequest, com.google.cloud.ces.v1.Tool>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.UpdateToolRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.Tool.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentServiceMethodDescriptorSupplier("UpdateTool"))
                      .build();
        }
      }
    }
    return getUpdateToolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.DeleteToolRequest, com.google.protobuf.Empty>
      getDeleteToolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTool",
      requestType = com.google.cloud.ces.v1.DeleteToolRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.DeleteToolRequest, com.google.protobuf.Empty>
      getDeleteToolMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.ces.v1.DeleteToolRequest, com.google.protobuf.Empty>
        getDeleteToolMethod;
    if ((getDeleteToolMethod = AgentServiceGrpc.getDeleteToolMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getDeleteToolMethod = AgentServiceGrpc.getDeleteToolMethod) == null) {
          AgentServiceGrpc.getDeleteToolMethod =
              getDeleteToolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.DeleteToolRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.DeleteToolRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentServiceMethodDescriptorSupplier("DeleteTool"))
                      .build();
        }
      }
    }
    return getDeleteToolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.ListGuardrailsRequest,
          com.google.cloud.ces.v1.ListGuardrailsResponse>
      getListGuardrailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGuardrails",
      requestType = com.google.cloud.ces.v1.ListGuardrailsRequest.class,
      responseType = com.google.cloud.ces.v1.ListGuardrailsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.ListGuardrailsRequest,
          com.google.cloud.ces.v1.ListGuardrailsResponse>
      getListGuardrailsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.ListGuardrailsRequest,
            com.google.cloud.ces.v1.ListGuardrailsResponse>
        getListGuardrailsMethod;
    if ((getListGuardrailsMethod = AgentServiceGrpc.getListGuardrailsMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getListGuardrailsMethod = AgentServiceGrpc.getListGuardrailsMethod) == null) {
          AgentServiceGrpc.getListGuardrailsMethod =
              getListGuardrailsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.ListGuardrailsRequest,
                          com.google.cloud.ces.v1.ListGuardrailsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListGuardrails"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.ListGuardrailsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.ListGuardrailsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentServiceMethodDescriptorSupplier("ListGuardrails"))
                      .build();
        }
      }
    }
    return getListGuardrailsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.GetGuardrailRequest, com.google.cloud.ces.v1.Guardrail>
      getGetGuardrailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGuardrail",
      requestType = com.google.cloud.ces.v1.GetGuardrailRequest.class,
      responseType = com.google.cloud.ces.v1.Guardrail.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.GetGuardrailRequest, com.google.cloud.ces.v1.Guardrail>
      getGetGuardrailMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.GetGuardrailRequest, com.google.cloud.ces.v1.Guardrail>
        getGetGuardrailMethod;
    if ((getGetGuardrailMethod = AgentServiceGrpc.getGetGuardrailMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getGetGuardrailMethod = AgentServiceGrpc.getGetGuardrailMethod) == null) {
          AgentServiceGrpc.getGetGuardrailMethod =
              getGetGuardrailMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.GetGuardrailRequest,
                          com.google.cloud.ces.v1.Guardrail>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetGuardrail"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.GetGuardrailRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.Guardrail.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentServiceMethodDescriptorSupplier("GetGuardrail"))
                      .build();
        }
      }
    }
    return getGetGuardrailMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.CreateGuardrailRequest, com.google.cloud.ces.v1.Guardrail>
      getCreateGuardrailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateGuardrail",
      requestType = com.google.cloud.ces.v1.CreateGuardrailRequest.class,
      responseType = com.google.cloud.ces.v1.Guardrail.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.CreateGuardrailRequest, com.google.cloud.ces.v1.Guardrail>
      getCreateGuardrailMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.CreateGuardrailRequest, com.google.cloud.ces.v1.Guardrail>
        getCreateGuardrailMethod;
    if ((getCreateGuardrailMethod = AgentServiceGrpc.getCreateGuardrailMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getCreateGuardrailMethod = AgentServiceGrpc.getCreateGuardrailMethod) == null) {
          AgentServiceGrpc.getCreateGuardrailMethod =
              getCreateGuardrailMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.CreateGuardrailRequest,
                          com.google.cloud.ces.v1.Guardrail>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateGuardrail"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.CreateGuardrailRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.Guardrail.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentServiceMethodDescriptorSupplier("CreateGuardrail"))
                      .build();
        }
      }
    }
    return getCreateGuardrailMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.UpdateGuardrailRequest, com.google.cloud.ces.v1.Guardrail>
      getUpdateGuardrailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGuardrail",
      requestType = com.google.cloud.ces.v1.UpdateGuardrailRequest.class,
      responseType = com.google.cloud.ces.v1.Guardrail.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.UpdateGuardrailRequest, com.google.cloud.ces.v1.Guardrail>
      getUpdateGuardrailMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.UpdateGuardrailRequest, com.google.cloud.ces.v1.Guardrail>
        getUpdateGuardrailMethod;
    if ((getUpdateGuardrailMethod = AgentServiceGrpc.getUpdateGuardrailMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getUpdateGuardrailMethod = AgentServiceGrpc.getUpdateGuardrailMethod) == null) {
          AgentServiceGrpc.getUpdateGuardrailMethod =
              getUpdateGuardrailMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.UpdateGuardrailRequest,
                          com.google.cloud.ces.v1.Guardrail>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateGuardrail"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.UpdateGuardrailRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.Guardrail.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentServiceMethodDescriptorSupplier("UpdateGuardrail"))
                      .build();
        }
      }
    }
    return getUpdateGuardrailMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.DeleteGuardrailRequest, com.google.protobuf.Empty>
      getDeleteGuardrailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGuardrail",
      requestType = com.google.cloud.ces.v1.DeleteGuardrailRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.DeleteGuardrailRequest, com.google.protobuf.Empty>
      getDeleteGuardrailMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.DeleteGuardrailRequest, com.google.protobuf.Empty>
        getDeleteGuardrailMethod;
    if ((getDeleteGuardrailMethod = AgentServiceGrpc.getDeleteGuardrailMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getDeleteGuardrailMethod = AgentServiceGrpc.getDeleteGuardrailMethod) == null) {
          AgentServiceGrpc.getDeleteGuardrailMethod =
              getDeleteGuardrailMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.DeleteGuardrailRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteGuardrail"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.DeleteGuardrailRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentServiceMethodDescriptorSupplier("DeleteGuardrail"))
                      .build();
        }
      }
    }
    return getDeleteGuardrailMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.ListDeploymentsRequest,
          com.google.cloud.ces.v1.ListDeploymentsResponse>
      getListDeploymentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDeployments",
      requestType = com.google.cloud.ces.v1.ListDeploymentsRequest.class,
      responseType = com.google.cloud.ces.v1.ListDeploymentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.ListDeploymentsRequest,
          com.google.cloud.ces.v1.ListDeploymentsResponse>
      getListDeploymentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.ListDeploymentsRequest,
            com.google.cloud.ces.v1.ListDeploymentsResponse>
        getListDeploymentsMethod;
    if ((getListDeploymentsMethod = AgentServiceGrpc.getListDeploymentsMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getListDeploymentsMethod = AgentServiceGrpc.getListDeploymentsMethod) == null) {
          AgentServiceGrpc.getListDeploymentsMethod =
              getListDeploymentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.ListDeploymentsRequest,
                          com.google.cloud.ces.v1.ListDeploymentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDeployments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.ListDeploymentsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.ListDeploymentsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentServiceMethodDescriptorSupplier("ListDeployments"))
                      .build();
        }
      }
    }
    return getListDeploymentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.GetDeploymentRequest, com.google.cloud.ces.v1.Deployment>
      getGetDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDeployment",
      requestType = com.google.cloud.ces.v1.GetDeploymentRequest.class,
      responseType = com.google.cloud.ces.v1.Deployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.GetDeploymentRequest, com.google.cloud.ces.v1.Deployment>
      getGetDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.GetDeploymentRequest, com.google.cloud.ces.v1.Deployment>
        getGetDeploymentMethod;
    if ((getGetDeploymentMethod = AgentServiceGrpc.getGetDeploymentMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getGetDeploymentMethod = AgentServiceGrpc.getGetDeploymentMethod) == null) {
          AgentServiceGrpc.getGetDeploymentMethod =
              getGetDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.GetDeploymentRequest,
                          com.google.cloud.ces.v1.Deployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.GetDeploymentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.Deployment.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentServiceMethodDescriptorSupplier("GetDeployment"))
                      .build();
        }
      }
    }
    return getGetDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.CreateDeploymentRequest, com.google.cloud.ces.v1.Deployment>
      getCreateDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDeployment",
      requestType = com.google.cloud.ces.v1.CreateDeploymentRequest.class,
      responseType = com.google.cloud.ces.v1.Deployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.CreateDeploymentRequest, com.google.cloud.ces.v1.Deployment>
      getCreateDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.CreateDeploymentRequest, com.google.cloud.ces.v1.Deployment>
        getCreateDeploymentMethod;
    if ((getCreateDeploymentMethod = AgentServiceGrpc.getCreateDeploymentMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getCreateDeploymentMethod = AgentServiceGrpc.getCreateDeploymentMethod) == null) {
          AgentServiceGrpc.getCreateDeploymentMethod =
              getCreateDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.CreateDeploymentRequest,
                          com.google.cloud.ces.v1.Deployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.CreateDeploymentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.Deployment.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentServiceMethodDescriptorSupplier("CreateDeployment"))
                      .build();
        }
      }
    }
    return getCreateDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.UpdateDeploymentRequest, com.google.cloud.ces.v1.Deployment>
      getUpdateDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDeployment",
      requestType = com.google.cloud.ces.v1.UpdateDeploymentRequest.class,
      responseType = com.google.cloud.ces.v1.Deployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.UpdateDeploymentRequest, com.google.cloud.ces.v1.Deployment>
      getUpdateDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.UpdateDeploymentRequest, com.google.cloud.ces.v1.Deployment>
        getUpdateDeploymentMethod;
    if ((getUpdateDeploymentMethod = AgentServiceGrpc.getUpdateDeploymentMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getUpdateDeploymentMethod = AgentServiceGrpc.getUpdateDeploymentMethod) == null) {
          AgentServiceGrpc.getUpdateDeploymentMethod =
              getUpdateDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.UpdateDeploymentRequest,
                          com.google.cloud.ces.v1.Deployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.UpdateDeploymentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.Deployment.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentServiceMethodDescriptorSupplier("UpdateDeployment"))
                      .build();
        }
      }
    }
    return getUpdateDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.DeleteDeploymentRequest, com.google.protobuf.Empty>
      getDeleteDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDeployment",
      requestType = com.google.cloud.ces.v1.DeleteDeploymentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.DeleteDeploymentRequest, com.google.protobuf.Empty>
      getDeleteDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.DeleteDeploymentRequest, com.google.protobuf.Empty>
        getDeleteDeploymentMethod;
    if ((getDeleteDeploymentMethod = AgentServiceGrpc.getDeleteDeploymentMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getDeleteDeploymentMethod = AgentServiceGrpc.getDeleteDeploymentMethod) == null) {
          AgentServiceGrpc.getDeleteDeploymentMethod =
              getDeleteDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.DeleteDeploymentRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.DeleteDeploymentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentServiceMethodDescriptorSupplier("DeleteDeployment"))
                      .build();
        }
      }
    }
    return getDeleteDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.ListToolsetsRequest, com.google.cloud.ces.v1.ListToolsetsResponse>
      getListToolsetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListToolsets",
      requestType = com.google.cloud.ces.v1.ListToolsetsRequest.class,
      responseType = com.google.cloud.ces.v1.ListToolsetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.ListToolsetsRequest, com.google.cloud.ces.v1.ListToolsetsResponse>
      getListToolsetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.ListToolsetsRequest,
            com.google.cloud.ces.v1.ListToolsetsResponse>
        getListToolsetsMethod;
    if ((getListToolsetsMethod = AgentServiceGrpc.getListToolsetsMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getListToolsetsMethod = AgentServiceGrpc.getListToolsetsMethod) == null) {
          AgentServiceGrpc.getListToolsetsMethod =
              getListToolsetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.ListToolsetsRequest,
                          com.google.cloud.ces.v1.ListToolsetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListToolsets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.ListToolsetsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.ListToolsetsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentServiceMethodDescriptorSupplier("ListToolsets"))
                      .build();
        }
      }
    }
    return getListToolsetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.GetToolsetRequest, com.google.cloud.ces.v1.Toolset>
      getGetToolsetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetToolset",
      requestType = com.google.cloud.ces.v1.GetToolsetRequest.class,
      responseType = com.google.cloud.ces.v1.Toolset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.GetToolsetRequest, com.google.cloud.ces.v1.Toolset>
      getGetToolsetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.GetToolsetRequest, com.google.cloud.ces.v1.Toolset>
        getGetToolsetMethod;
    if ((getGetToolsetMethod = AgentServiceGrpc.getGetToolsetMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getGetToolsetMethod = AgentServiceGrpc.getGetToolsetMethod) == null) {
          AgentServiceGrpc.getGetToolsetMethod =
              getGetToolsetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.GetToolsetRequest, com.google.cloud.ces.v1.Toolset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetToolset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.GetToolsetRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.Toolset.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentServiceMethodDescriptorSupplier("GetToolset"))
                      .build();
        }
      }
    }
    return getGetToolsetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.CreateToolsetRequest, com.google.cloud.ces.v1.Toolset>
      getCreateToolsetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateToolset",
      requestType = com.google.cloud.ces.v1.CreateToolsetRequest.class,
      responseType = com.google.cloud.ces.v1.Toolset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.CreateToolsetRequest, com.google.cloud.ces.v1.Toolset>
      getCreateToolsetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.CreateToolsetRequest, com.google.cloud.ces.v1.Toolset>
        getCreateToolsetMethod;
    if ((getCreateToolsetMethod = AgentServiceGrpc.getCreateToolsetMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getCreateToolsetMethod = AgentServiceGrpc.getCreateToolsetMethod) == null) {
          AgentServiceGrpc.getCreateToolsetMethod =
              getCreateToolsetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.CreateToolsetRequest,
                          com.google.cloud.ces.v1.Toolset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateToolset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.CreateToolsetRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.Toolset.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentServiceMethodDescriptorSupplier("CreateToolset"))
                      .build();
        }
      }
    }
    return getCreateToolsetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.UpdateToolsetRequest, com.google.cloud.ces.v1.Toolset>
      getUpdateToolsetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateToolset",
      requestType = com.google.cloud.ces.v1.UpdateToolsetRequest.class,
      responseType = com.google.cloud.ces.v1.Toolset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.UpdateToolsetRequest, com.google.cloud.ces.v1.Toolset>
      getUpdateToolsetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.UpdateToolsetRequest, com.google.cloud.ces.v1.Toolset>
        getUpdateToolsetMethod;
    if ((getUpdateToolsetMethod = AgentServiceGrpc.getUpdateToolsetMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getUpdateToolsetMethod = AgentServiceGrpc.getUpdateToolsetMethod) == null) {
          AgentServiceGrpc.getUpdateToolsetMethod =
              getUpdateToolsetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.UpdateToolsetRequest,
                          com.google.cloud.ces.v1.Toolset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateToolset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.UpdateToolsetRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.Toolset.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentServiceMethodDescriptorSupplier("UpdateToolset"))
                      .build();
        }
      }
    }
    return getUpdateToolsetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.DeleteToolsetRequest, com.google.protobuf.Empty>
      getDeleteToolsetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteToolset",
      requestType = com.google.cloud.ces.v1.DeleteToolsetRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.DeleteToolsetRequest, com.google.protobuf.Empty>
      getDeleteToolsetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.DeleteToolsetRequest, com.google.protobuf.Empty>
        getDeleteToolsetMethod;
    if ((getDeleteToolsetMethod = AgentServiceGrpc.getDeleteToolsetMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getDeleteToolsetMethod = AgentServiceGrpc.getDeleteToolsetMethod) == null) {
          AgentServiceGrpc.getDeleteToolsetMethod =
              getDeleteToolsetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.DeleteToolsetRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteToolset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.DeleteToolsetRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentServiceMethodDescriptorSupplier("DeleteToolset"))
                      .build();
        }
      }
    }
    return getDeleteToolsetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.ListAppVersionsRequest,
          com.google.cloud.ces.v1.ListAppVersionsResponse>
      getListAppVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAppVersions",
      requestType = com.google.cloud.ces.v1.ListAppVersionsRequest.class,
      responseType = com.google.cloud.ces.v1.ListAppVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.ListAppVersionsRequest,
          com.google.cloud.ces.v1.ListAppVersionsResponse>
      getListAppVersionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.ListAppVersionsRequest,
            com.google.cloud.ces.v1.ListAppVersionsResponse>
        getListAppVersionsMethod;
    if ((getListAppVersionsMethod = AgentServiceGrpc.getListAppVersionsMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getListAppVersionsMethod = AgentServiceGrpc.getListAppVersionsMethod) == null) {
          AgentServiceGrpc.getListAppVersionsMethod =
              getListAppVersionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.ListAppVersionsRequest,
                          com.google.cloud.ces.v1.ListAppVersionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAppVersions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.ListAppVersionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.ListAppVersionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentServiceMethodDescriptorSupplier("ListAppVersions"))
                      .build();
        }
      }
    }
    return getListAppVersionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.GetAppVersionRequest, com.google.cloud.ces.v1.AppVersion>
      getGetAppVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAppVersion",
      requestType = com.google.cloud.ces.v1.GetAppVersionRequest.class,
      responseType = com.google.cloud.ces.v1.AppVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.GetAppVersionRequest, com.google.cloud.ces.v1.AppVersion>
      getGetAppVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.GetAppVersionRequest, com.google.cloud.ces.v1.AppVersion>
        getGetAppVersionMethod;
    if ((getGetAppVersionMethod = AgentServiceGrpc.getGetAppVersionMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getGetAppVersionMethod = AgentServiceGrpc.getGetAppVersionMethod) == null) {
          AgentServiceGrpc.getGetAppVersionMethod =
              getGetAppVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.GetAppVersionRequest,
                          com.google.cloud.ces.v1.AppVersion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAppVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.GetAppVersionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.AppVersion.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentServiceMethodDescriptorSupplier("GetAppVersion"))
                      .build();
        }
      }
    }
    return getGetAppVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.CreateAppVersionRequest, com.google.cloud.ces.v1.AppVersion>
      getCreateAppVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAppVersion",
      requestType = com.google.cloud.ces.v1.CreateAppVersionRequest.class,
      responseType = com.google.cloud.ces.v1.AppVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.CreateAppVersionRequest, com.google.cloud.ces.v1.AppVersion>
      getCreateAppVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.CreateAppVersionRequest, com.google.cloud.ces.v1.AppVersion>
        getCreateAppVersionMethod;
    if ((getCreateAppVersionMethod = AgentServiceGrpc.getCreateAppVersionMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getCreateAppVersionMethod = AgentServiceGrpc.getCreateAppVersionMethod) == null) {
          AgentServiceGrpc.getCreateAppVersionMethod =
              getCreateAppVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.CreateAppVersionRequest,
                          com.google.cloud.ces.v1.AppVersion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAppVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.CreateAppVersionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.AppVersion.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentServiceMethodDescriptorSupplier("CreateAppVersion"))
                      .build();
        }
      }
    }
    return getCreateAppVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.DeleteAppVersionRequest, com.google.protobuf.Empty>
      getDeleteAppVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAppVersion",
      requestType = com.google.cloud.ces.v1.DeleteAppVersionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.DeleteAppVersionRequest, com.google.protobuf.Empty>
      getDeleteAppVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.DeleteAppVersionRequest, com.google.protobuf.Empty>
        getDeleteAppVersionMethod;
    if ((getDeleteAppVersionMethod = AgentServiceGrpc.getDeleteAppVersionMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getDeleteAppVersionMethod = AgentServiceGrpc.getDeleteAppVersionMethod) == null) {
          AgentServiceGrpc.getDeleteAppVersionMethod =
              getDeleteAppVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.DeleteAppVersionRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAppVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.DeleteAppVersionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentServiceMethodDescriptorSupplier("DeleteAppVersion"))
                      .build();
        }
      }
    }
    return getDeleteAppVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.RestoreAppVersionRequest, com.google.longrunning.Operation>
      getRestoreAppVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestoreAppVersion",
      requestType = com.google.cloud.ces.v1.RestoreAppVersionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.RestoreAppVersionRequest, com.google.longrunning.Operation>
      getRestoreAppVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.RestoreAppVersionRequest, com.google.longrunning.Operation>
        getRestoreAppVersionMethod;
    if ((getRestoreAppVersionMethod = AgentServiceGrpc.getRestoreAppVersionMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getRestoreAppVersionMethod = AgentServiceGrpc.getRestoreAppVersionMethod) == null) {
          AgentServiceGrpc.getRestoreAppVersionMethod =
              getRestoreAppVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.RestoreAppVersionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RestoreAppVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.RestoreAppVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentServiceMethodDescriptorSupplier("RestoreAppVersion"))
                      .build();
        }
      }
    }
    return getRestoreAppVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.ListChangelogsRequest,
          com.google.cloud.ces.v1.ListChangelogsResponse>
      getListChangelogsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListChangelogs",
      requestType = com.google.cloud.ces.v1.ListChangelogsRequest.class,
      responseType = com.google.cloud.ces.v1.ListChangelogsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.ListChangelogsRequest,
          com.google.cloud.ces.v1.ListChangelogsResponse>
      getListChangelogsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.ListChangelogsRequest,
            com.google.cloud.ces.v1.ListChangelogsResponse>
        getListChangelogsMethod;
    if ((getListChangelogsMethod = AgentServiceGrpc.getListChangelogsMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getListChangelogsMethod = AgentServiceGrpc.getListChangelogsMethod) == null) {
          AgentServiceGrpc.getListChangelogsMethod =
              getListChangelogsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.ListChangelogsRequest,
                          com.google.cloud.ces.v1.ListChangelogsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListChangelogs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.ListChangelogsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.ListChangelogsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentServiceMethodDescriptorSupplier("ListChangelogs"))
                      .build();
        }
      }
    }
    return getListChangelogsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.GetChangelogRequest, com.google.cloud.ces.v1.Changelog>
      getGetChangelogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetChangelog",
      requestType = com.google.cloud.ces.v1.GetChangelogRequest.class,
      responseType = com.google.cloud.ces.v1.Changelog.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.GetChangelogRequest, com.google.cloud.ces.v1.Changelog>
      getGetChangelogMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.GetChangelogRequest, com.google.cloud.ces.v1.Changelog>
        getGetChangelogMethod;
    if ((getGetChangelogMethod = AgentServiceGrpc.getGetChangelogMethod) == null) {
      synchronized (AgentServiceGrpc.class) {
        if ((getGetChangelogMethod = AgentServiceGrpc.getGetChangelogMethod) == null) {
          AgentServiceGrpc.getGetChangelogMethod =
              getGetChangelogMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.GetChangelogRequest,
                          com.google.cloud.ces.v1.Changelog>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetChangelog"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.GetChangelogRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.Changelog.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentServiceMethodDescriptorSupplier("GetChangelog"))
                      .build();
        }
      }
    }
    return getGetChangelogMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AgentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgentServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AgentServiceStub>() {
          @java.lang.Override
          public AgentServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AgentServiceStub(channel, callOptions);
          }
        };
    return AgentServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static AgentServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgentServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AgentServiceBlockingV2Stub>() {
          @java.lang.Override
          public AgentServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AgentServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return AgentServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AgentServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgentServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AgentServiceBlockingStub>() {
          @java.lang.Override
          public AgentServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AgentServiceBlockingStub(channel, callOptions);
          }
        };
    return AgentServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AgentServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgentServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AgentServiceFutureStub>() {
          @java.lang.Override
          public AgentServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AgentServiceFutureStub(channel, callOptions);
          }
        };
    return AgentServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The service that manages agent-related resources in Gemini Enterprise for
   * Customer Engagement (CES).
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists apps in the given project and location.
     * </pre>
     */
    default void listApps(
        com.google.cloud.ces.v1.ListAppsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListAppsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAppsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified app.
     * </pre>
     */
    default void getApp(
        com.google.cloud.ces.v1.GetAppRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.App> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAppMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new app in the given project and location.
     * </pre>
     */
    default void createApp(
        com.google.cloud.ces.v1.CreateAppRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAppMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified app.
     * </pre>
     */
    default void updateApp(
        com.google.cloud.ces.v1.UpdateAppRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.App> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateAppMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified app.
     * </pre>
     */
    default void deleteApp(
        com.google.cloud.ces.v1.DeleteAppRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteAppMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports the specified app.
     * </pre>
     */
    default void exportApp(
        com.google.cloud.ces.v1.ExportAppRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExportAppMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports the specified app.
     * </pre>
     */
    default void importApp(
        com.google.cloud.ces.v1.ImportAppRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getImportAppMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists agents in the given app.
     * </pre>
     */
    default void listAgents(
        com.google.cloud.ces.v1.ListAgentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListAgentsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAgentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified agent.
     * </pre>
     */
    default void getAgent(
        com.google.cloud.ces.v1.GetAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Agent> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAgentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new agent in the given app.
     * </pre>
     */
    default void createAgent(
        com.google.cloud.ces.v1.CreateAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Agent> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAgentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified agent.
     * </pre>
     */
    default void updateAgent(
        com.google.cloud.ces.v1.UpdateAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Agent> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAgentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified agent.
     * </pre>
     */
    default void deleteAgent(
        com.google.cloud.ces.v1.DeleteAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAgentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists examples in the given app.
     * </pre>
     */
    default void listExamples(
        com.google.cloud.ces.v1.ListExamplesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListExamplesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListExamplesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified example.
     * </pre>
     */
    default void getExample(
        com.google.cloud.ces.v1.GetExampleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Example> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetExampleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new example in the given app.
     * </pre>
     */
    default void createExample(
        com.google.cloud.ces.v1.CreateExampleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Example> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateExampleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified example.
     * </pre>
     */
    default void updateExample(
        com.google.cloud.ces.v1.UpdateExampleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Example> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateExampleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified example.
     * </pre>
     */
    default void deleteExample(
        com.google.cloud.ces.v1.DeleteExampleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteExampleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists tools in the given app.
     * </pre>
     */
    default void listTools(
        com.google.cloud.ces.v1.ListToolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListToolsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListToolsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified tool.
     * </pre>
     */
    default void getTool(
        com.google.cloud.ces.v1.GetToolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Tool> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetToolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists conversations in the given app.
     * </pre>
     */
    default void listConversations(
        com.google.cloud.ces.v1.ListConversationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListConversationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListConversationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified conversation.
     * </pre>
     */
    default void getConversation(
        com.google.cloud.ces.v1.GetConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Conversation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetConversationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified conversation.
     * </pre>
     */
    default void deleteConversation(
        com.google.cloud.ces.v1.DeleteConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteConversationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Batch deletes the specified conversations.
     * </pre>
     */
    default void batchDeleteConversations(
        com.google.cloud.ces.v1.BatchDeleteConversationsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchDeleteConversationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new tool in the given app.
     * </pre>
     */
    default void createTool(
        com.google.cloud.ces.v1.CreateToolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Tool> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateToolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified tool.
     * </pre>
     */
    default void updateTool(
        com.google.cloud.ces.v1.UpdateToolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Tool> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateToolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified tool.
     * </pre>
     */
    default void deleteTool(
        com.google.cloud.ces.v1.DeleteToolRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteToolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists guardrails in the given app.
     * </pre>
     */
    default void listGuardrails(
        com.google.cloud.ces.v1.ListGuardrailsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListGuardrailsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListGuardrailsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified guardrail.
     * </pre>
     */
    default void getGuardrail(
        com.google.cloud.ces.v1.GetGuardrailRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Guardrail> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetGuardrailMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new guardrail in the given app.
     * </pre>
     */
    default void createGuardrail(
        com.google.cloud.ces.v1.CreateGuardrailRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Guardrail> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateGuardrailMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified guardrail.
     * </pre>
     */
    default void updateGuardrail(
        com.google.cloud.ces.v1.UpdateGuardrailRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Guardrail> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateGuardrailMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified guardrail.
     * </pre>
     */
    default void deleteGuardrail(
        com.google.cloud.ces.v1.DeleteGuardrailRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteGuardrailMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists deployments in the given app.
     * </pre>
     */
    default void listDeployments(
        com.google.cloud.ces.v1.ListDeploymentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListDeploymentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDeploymentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified deployment.
     * </pre>
     */
    default void getDeployment(
        com.google.cloud.ces.v1.GetDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Deployment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new deployment in the given app.
     * </pre>
     */
    default void createDeployment(
        com.google.cloud.ces.v1.CreateDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Deployment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified deployment.
     * </pre>
     */
    default void updateDeployment(
        com.google.cloud.ces.v1.UpdateDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Deployment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified deployment.
     * </pre>
     */
    default void deleteDeployment(
        com.google.cloud.ces.v1.DeleteDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists toolsets in the given app.
     * </pre>
     */
    default void listToolsets(
        com.google.cloud.ces.v1.ListToolsetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListToolsetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListToolsetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified toolset.
     * </pre>
     */
    default void getToolset(
        com.google.cloud.ces.v1.GetToolsetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Toolset> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetToolsetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new toolset in the given app.
     * </pre>
     */
    default void createToolset(
        com.google.cloud.ces.v1.CreateToolsetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Toolset> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateToolsetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified toolset.
     * </pre>
     */
    default void updateToolset(
        com.google.cloud.ces.v1.UpdateToolsetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Toolset> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateToolsetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified toolset.
     * </pre>
     */
    default void deleteToolset(
        com.google.cloud.ces.v1.DeleteToolsetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteToolsetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all app versions in the given app.
     * </pre>
     */
    default void listAppVersions(
        com.google.cloud.ces.v1.ListAppVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListAppVersionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAppVersionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified app version.
     * </pre>
     */
    default void getAppVersion(
        com.google.cloud.ces.v1.GetAppVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.AppVersion> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAppVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new app version in the given app.
     * </pre>
     */
    default void createAppVersion(
        com.google.cloud.ces.v1.CreateAppVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.AppVersion> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAppVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified app version.
     * </pre>
     */
    default void deleteAppVersion(
        com.google.cloud.ces.v1.DeleteAppVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAppVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restores the specified app version.
     * This will create a new app version from the current draft app and overwrite
     * the current draft with the specified app version.
     * </pre>
     */
    default void restoreAppVersion(
        com.google.cloud.ces.v1.RestoreAppVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRestoreAppVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the changelogs of the specified app.
     * </pre>
     */
    default void listChangelogs(
        com.google.cloud.ces.v1.ListChangelogsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListChangelogsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListChangelogsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified changelog.
     * </pre>
     */
    default void getChangelog(
        com.google.cloud.ces.v1.GetChangelogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Changelog> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetChangelogMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AgentService.
   *
   * <pre>
   * The service that manages agent-related resources in Gemini Enterprise for
   * Customer Engagement (CES).
   * </pre>
   */
  public abstract static class AgentServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AgentServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AgentService.
   *
   * <pre>
   * The service that manages agent-related resources in Gemini Enterprise for
   * Customer Engagement (CES).
   * </pre>
   */
  public static final class AgentServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AgentServiceStub> {
    private AgentServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgentServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists apps in the given project and location.
     * </pre>
     */
    public void listApps(
        com.google.cloud.ces.v1.ListAppsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListAppsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAppsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified app.
     * </pre>
     */
    public void getApp(
        com.google.cloud.ces.v1.GetAppRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.App> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAppMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new app in the given project and location.
     * </pre>
     */
    public void createApp(
        com.google.cloud.ces.v1.CreateAppRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAppMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified app.
     * </pre>
     */
    public void updateApp(
        com.google.cloud.ces.v1.UpdateAppRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.App> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAppMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified app.
     * </pre>
     */
    public void deleteApp(
        com.google.cloud.ces.v1.DeleteAppRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAppMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports the specified app.
     * </pre>
     */
    public void exportApp(
        com.google.cloud.ces.v1.ExportAppRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportAppMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports the specified app.
     * </pre>
     */
    public void importApp(
        com.google.cloud.ces.v1.ImportAppRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportAppMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists agents in the given app.
     * </pre>
     */
    public void listAgents(
        com.google.cloud.ces.v1.ListAgentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListAgentsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAgentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified agent.
     * </pre>
     */
    public void getAgent(
        com.google.cloud.ces.v1.GetAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Agent> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAgentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new agent in the given app.
     * </pre>
     */
    public void createAgent(
        com.google.cloud.ces.v1.CreateAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Agent> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAgentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified agent.
     * </pre>
     */
    public void updateAgent(
        com.google.cloud.ces.v1.UpdateAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Agent> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAgentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified agent.
     * </pre>
     */
    public void deleteAgent(
        com.google.cloud.ces.v1.DeleteAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAgentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists examples in the given app.
     * </pre>
     */
    public void listExamples(
        com.google.cloud.ces.v1.ListExamplesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListExamplesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListExamplesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified example.
     * </pre>
     */
    public void getExample(
        com.google.cloud.ces.v1.GetExampleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Example> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetExampleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new example in the given app.
     * </pre>
     */
    public void createExample(
        com.google.cloud.ces.v1.CreateExampleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Example> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateExampleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified example.
     * </pre>
     */
    public void updateExample(
        com.google.cloud.ces.v1.UpdateExampleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Example> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateExampleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified example.
     * </pre>
     */
    public void deleteExample(
        com.google.cloud.ces.v1.DeleteExampleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteExampleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists tools in the given app.
     * </pre>
     */
    public void listTools(
        com.google.cloud.ces.v1.ListToolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListToolsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListToolsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified tool.
     * </pre>
     */
    public void getTool(
        com.google.cloud.ces.v1.GetToolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Tool> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetToolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists conversations in the given app.
     * </pre>
     */
    public void listConversations(
        com.google.cloud.ces.v1.ListConversationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListConversationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConversationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified conversation.
     * </pre>
     */
    public void getConversation(
        com.google.cloud.ces.v1.GetConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Conversation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConversationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified conversation.
     * </pre>
     */
    public void deleteConversation(
        com.google.cloud.ces.v1.DeleteConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteConversationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Batch deletes the specified conversations.
     * </pre>
     */
    public void batchDeleteConversations(
        com.google.cloud.ces.v1.BatchDeleteConversationsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchDeleteConversationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new tool in the given app.
     * </pre>
     */
    public void createTool(
        com.google.cloud.ces.v1.CreateToolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Tool> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateToolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified tool.
     * </pre>
     */
    public void updateTool(
        com.google.cloud.ces.v1.UpdateToolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Tool> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateToolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified tool.
     * </pre>
     */
    public void deleteTool(
        com.google.cloud.ces.v1.DeleteToolRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteToolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists guardrails in the given app.
     * </pre>
     */
    public void listGuardrails(
        com.google.cloud.ces.v1.ListGuardrailsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListGuardrailsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGuardrailsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified guardrail.
     * </pre>
     */
    public void getGuardrail(
        com.google.cloud.ces.v1.GetGuardrailRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Guardrail> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGuardrailMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new guardrail in the given app.
     * </pre>
     */
    public void createGuardrail(
        com.google.cloud.ces.v1.CreateGuardrailRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Guardrail> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateGuardrailMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified guardrail.
     * </pre>
     */
    public void updateGuardrail(
        com.google.cloud.ces.v1.UpdateGuardrailRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Guardrail> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateGuardrailMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified guardrail.
     * </pre>
     */
    public void deleteGuardrail(
        com.google.cloud.ces.v1.DeleteGuardrailRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteGuardrailMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists deployments in the given app.
     * </pre>
     */
    public void listDeployments(
        com.google.cloud.ces.v1.ListDeploymentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListDeploymentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDeploymentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified deployment.
     * </pre>
     */
    public void getDeployment(
        com.google.cloud.ces.v1.GetDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Deployment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new deployment in the given app.
     * </pre>
     */
    public void createDeployment(
        com.google.cloud.ces.v1.CreateDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Deployment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified deployment.
     * </pre>
     */
    public void updateDeployment(
        com.google.cloud.ces.v1.UpdateDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Deployment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified deployment.
     * </pre>
     */
    public void deleteDeployment(
        com.google.cloud.ces.v1.DeleteDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists toolsets in the given app.
     * </pre>
     */
    public void listToolsets(
        com.google.cloud.ces.v1.ListToolsetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListToolsetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListToolsetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified toolset.
     * </pre>
     */
    public void getToolset(
        com.google.cloud.ces.v1.GetToolsetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Toolset> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetToolsetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new toolset in the given app.
     * </pre>
     */
    public void createToolset(
        com.google.cloud.ces.v1.CreateToolsetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Toolset> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateToolsetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified toolset.
     * </pre>
     */
    public void updateToolset(
        com.google.cloud.ces.v1.UpdateToolsetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Toolset> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateToolsetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified toolset.
     * </pre>
     */
    public void deleteToolset(
        com.google.cloud.ces.v1.DeleteToolsetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteToolsetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all app versions in the given app.
     * </pre>
     */
    public void listAppVersions(
        com.google.cloud.ces.v1.ListAppVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListAppVersionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAppVersionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified app version.
     * </pre>
     */
    public void getAppVersion(
        com.google.cloud.ces.v1.GetAppVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.AppVersion> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAppVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new app version in the given app.
     * </pre>
     */
    public void createAppVersion(
        com.google.cloud.ces.v1.CreateAppVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.AppVersion> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAppVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified app version.
     * </pre>
     */
    public void deleteAppVersion(
        com.google.cloud.ces.v1.DeleteAppVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAppVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restores the specified app version.
     * This will create a new app version from the current draft app and overwrite
     * the current draft with the specified app version.
     * </pre>
     */
    public void restoreAppVersion(
        com.google.cloud.ces.v1.RestoreAppVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestoreAppVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the changelogs of the specified app.
     * </pre>
     */
    public void listChangelogs(
        com.google.cloud.ces.v1.ListChangelogsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListChangelogsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListChangelogsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified changelog.
     * </pre>
     */
    public void getChangelog(
        com.google.cloud.ces.v1.GetChangelogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Changelog> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetChangelogMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AgentService.
   *
   * <pre>
   * The service that manages agent-related resources in Gemini Enterprise for
   * Customer Engagement (CES).
   * </pre>
   */
  public static final class AgentServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<AgentServiceBlockingV2Stub> {
    private AgentServiceBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgentServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists apps in the given project and location.
     * </pre>
     */
    public com.google.cloud.ces.v1.ListAppsResponse listApps(
        com.google.cloud.ces.v1.ListAppsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAppsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified app.
     * </pre>
     */
    public com.google.cloud.ces.v1.App getApp(com.google.cloud.ces.v1.GetAppRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAppMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new app in the given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createApp(
        com.google.cloud.ces.v1.CreateAppRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateAppMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified app.
     * </pre>
     */
    public com.google.cloud.ces.v1.App updateApp(com.google.cloud.ces.v1.UpdateAppRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateAppMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified app.
     * </pre>
     */
    public com.google.longrunning.Operation deleteApp(
        com.google.cloud.ces.v1.DeleteAppRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteAppMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports the specified app.
     * </pre>
     */
    public com.google.longrunning.Operation exportApp(
        com.google.cloud.ces.v1.ExportAppRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getExportAppMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports the specified app.
     * </pre>
     */
    public com.google.longrunning.Operation importApp(
        com.google.cloud.ces.v1.ImportAppRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getImportAppMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists agents in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.ListAgentsResponse listAgents(
        com.google.cloud.ces.v1.ListAgentsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAgentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified agent.
     * </pre>
     */
    public com.google.cloud.ces.v1.Agent getAgent(com.google.cloud.ces.v1.GetAgentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new agent in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.Agent createAgent(
        com.google.cloud.ces.v1.CreateAgentRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified agent.
     * </pre>
     */
    public com.google.cloud.ces.v1.Agent updateAgent(
        com.google.cloud.ces.v1.UpdateAgentRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified agent.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAgent(com.google.cloud.ces.v1.DeleteAgentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists examples in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.ListExamplesResponse listExamples(
        com.google.cloud.ces.v1.ListExamplesRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListExamplesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified example.
     * </pre>
     */
    public com.google.cloud.ces.v1.Example getExample(
        com.google.cloud.ces.v1.GetExampleRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetExampleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new example in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.Example createExample(
        com.google.cloud.ces.v1.CreateExampleRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateExampleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified example.
     * </pre>
     */
    public com.google.cloud.ces.v1.Example updateExample(
        com.google.cloud.ces.v1.UpdateExampleRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateExampleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified example.
     * </pre>
     */
    public com.google.protobuf.Empty deleteExample(
        com.google.cloud.ces.v1.DeleteExampleRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteExampleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists tools in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.ListToolsResponse listTools(
        com.google.cloud.ces.v1.ListToolsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListToolsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified tool.
     * </pre>
     */
    public com.google.cloud.ces.v1.Tool getTool(com.google.cloud.ces.v1.GetToolRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetToolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists conversations in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.ListConversationsResponse listConversations(
        com.google.cloud.ces.v1.ListConversationsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListConversationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified conversation.
     * </pre>
     */
    public com.google.cloud.ces.v1.Conversation getConversation(
        com.google.cloud.ces.v1.GetConversationRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified conversation.
     * </pre>
     */
    public com.google.protobuf.Empty deleteConversation(
        com.google.cloud.ces.v1.DeleteConversationRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Batch deletes the specified conversations.
     * </pre>
     */
    public com.google.longrunning.Operation batchDeleteConversations(
        com.google.cloud.ces.v1.BatchDeleteConversationsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBatchDeleteConversationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new tool in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.Tool createTool(
        com.google.cloud.ces.v1.CreateToolRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateToolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified tool.
     * </pre>
     */
    public com.google.cloud.ces.v1.Tool updateTool(
        com.google.cloud.ces.v1.UpdateToolRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateToolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified tool.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTool(com.google.cloud.ces.v1.DeleteToolRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteToolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists guardrails in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.ListGuardrailsResponse listGuardrails(
        com.google.cloud.ces.v1.ListGuardrailsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListGuardrailsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified guardrail.
     * </pre>
     */
    public com.google.cloud.ces.v1.Guardrail getGuardrail(
        com.google.cloud.ces.v1.GetGuardrailRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetGuardrailMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new guardrail in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.Guardrail createGuardrail(
        com.google.cloud.ces.v1.CreateGuardrailRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateGuardrailMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified guardrail.
     * </pre>
     */
    public com.google.cloud.ces.v1.Guardrail updateGuardrail(
        com.google.cloud.ces.v1.UpdateGuardrailRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateGuardrailMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified guardrail.
     * </pre>
     */
    public com.google.protobuf.Empty deleteGuardrail(
        com.google.cloud.ces.v1.DeleteGuardrailRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteGuardrailMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists deployments in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.ListDeploymentsResponse listDeployments(
        com.google.cloud.ces.v1.ListDeploymentsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListDeploymentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified deployment.
     * </pre>
     */
    public com.google.cloud.ces.v1.Deployment getDeployment(
        com.google.cloud.ces.v1.GetDeploymentRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new deployment in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.Deployment createDeployment(
        com.google.cloud.ces.v1.CreateDeploymentRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified deployment.
     * </pre>
     */
    public com.google.cloud.ces.v1.Deployment updateDeployment(
        com.google.cloud.ces.v1.UpdateDeploymentRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified deployment.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDeployment(
        com.google.cloud.ces.v1.DeleteDeploymentRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists toolsets in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.ListToolsetsResponse listToolsets(
        com.google.cloud.ces.v1.ListToolsetsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListToolsetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified toolset.
     * </pre>
     */
    public com.google.cloud.ces.v1.Toolset getToolset(
        com.google.cloud.ces.v1.GetToolsetRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetToolsetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new toolset in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.Toolset createToolset(
        com.google.cloud.ces.v1.CreateToolsetRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateToolsetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified toolset.
     * </pre>
     */
    public com.google.cloud.ces.v1.Toolset updateToolset(
        com.google.cloud.ces.v1.UpdateToolsetRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateToolsetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified toolset.
     * </pre>
     */
    public com.google.protobuf.Empty deleteToolset(
        com.google.cloud.ces.v1.DeleteToolsetRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteToolsetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all app versions in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.ListAppVersionsResponse listAppVersions(
        com.google.cloud.ces.v1.ListAppVersionsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAppVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified app version.
     * </pre>
     */
    public com.google.cloud.ces.v1.AppVersion getAppVersion(
        com.google.cloud.ces.v1.GetAppVersionRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAppVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new app version in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.AppVersion createAppVersion(
        com.google.cloud.ces.v1.CreateAppVersionRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateAppVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified app version.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAppVersion(
        com.google.cloud.ces.v1.DeleteAppVersionRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteAppVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restores the specified app version.
     * This will create a new app version from the current draft app and overwrite
     * the current draft with the specified app version.
     * </pre>
     */
    public com.google.longrunning.Operation restoreAppVersion(
        com.google.cloud.ces.v1.RestoreAppVersionRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRestoreAppVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the changelogs of the specified app.
     * </pre>
     */
    public com.google.cloud.ces.v1.ListChangelogsResponse listChangelogs(
        com.google.cloud.ces.v1.ListChangelogsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListChangelogsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified changelog.
     * </pre>
     */
    public com.google.cloud.ces.v1.Changelog getChangelog(
        com.google.cloud.ces.v1.GetChangelogRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetChangelogMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service AgentService.
   *
   * <pre>
   * The service that manages agent-related resources in Gemini Enterprise for
   * Customer Engagement (CES).
   * </pre>
   */
  public static final class AgentServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AgentServiceBlockingStub> {
    private AgentServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgentServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists apps in the given project and location.
     * </pre>
     */
    public com.google.cloud.ces.v1.ListAppsResponse listApps(
        com.google.cloud.ces.v1.ListAppsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAppsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified app.
     * </pre>
     */
    public com.google.cloud.ces.v1.App getApp(com.google.cloud.ces.v1.GetAppRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAppMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new app in the given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createApp(
        com.google.cloud.ces.v1.CreateAppRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAppMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified app.
     * </pre>
     */
    public com.google.cloud.ces.v1.App updateApp(com.google.cloud.ces.v1.UpdateAppRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAppMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified app.
     * </pre>
     */
    public com.google.longrunning.Operation deleteApp(
        com.google.cloud.ces.v1.DeleteAppRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAppMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports the specified app.
     * </pre>
     */
    public com.google.longrunning.Operation exportApp(
        com.google.cloud.ces.v1.ExportAppRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportAppMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports the specified app.
     * </pre>
     */
    public com.google.longrunning.Operation importApp(
        com.google.cloud.ces.v1.ImportAppRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportAppMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists agents in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.ListAgentsResponse listAgents(
        com.google.cloud.ces.v1.ListAgentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAgentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified agent.
     * </pre>
     */
    public com.google.cloud.ces.v1.Agent getAgent(com.google.cloud.ces.v1.GetAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new agent in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.Agent createAgent(
        com.google.cloud.ces.v1.CreateAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified agent.
     * </pre>
     */
    public com.google.cloud.ces.v1.Agent updateAgent(
        com.google.cloud.ces.v1.UpdateAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified agent.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAgent(
        com.google.cloud.ces.v1.DeleteAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists examples in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.ListExamplesResponse listExamples(
        com.google.cloud.ces.v1.ListExamplesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListExamplesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified example.
     * </pre>
     */
    public com.google.cloud.ces.v1.Example getExample(
        com.google.cloud.ces.v1.GetExampleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetExampleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new example in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.Example createExample(
        com.google.cloud.ces.v1.CreateExampleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateExampleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified example.
     * </pre>
     */
    public com.google.cloud.ces.v1.Example updateExample(
        com.google.cloud.ces.v1.UpdateExampleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateExampleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified example.
     * </pre>
     */
    public com.google.protobuf.Empty deleteExample(
        com.google.cloud.ces.v1.DeleteExampleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteExampleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists tools in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.ListToolsResponse listTools(
        com.google.cloud.ces.v1.ListToolsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListToolsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified tool.
     * </pre>
     */
    public com.google.cloud.ces.v1.Tool getTool(com.google.cloud.ces.v1.GetToolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetToolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists conversations in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.ListConversationsResponse listConversations(
        com.google.cloud.ces.v1.ListConversationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConversationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified conversation.
     * </pre>
     */
    public com.google.cloud.ces.v1.Conversation getConversation(
        com.google.cloud.ces.v1.GetConversationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified conversation.
     * </pre>
     */
    public com.google.protobuf.Empty deleteConversation(
        com.google.cloud.ces.v1.DeleteConversationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Batch deletes the specified conversations.
     * </pre>
     */
    public com.google.longrunning.Operation batchDeleteConversations(
        com.google.cloud.ces.v1.BatchDeleteConversationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchDeleteConversationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new tool in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.Tool createTool(
        com.google.cloud.ces.v1.CreateToolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateToolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified tool.
     * </pre>
     */
    public com.google.cloud.ces.v1.Tool updateTool(
        com.google.cloud.ces.v1.UpdateToolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateToolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified tool.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTool(com.google.cloud.ces.v1.DeleteToolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteToolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists guardrails in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.ListGuardrailsResponse listGuardrails(
        com.google.cloud.ces.v1.ListGuardrailsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGuardrailsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified guardrail.
     * </pre>
     */
    public com.google.cloud.ces.v1.Guardrail getGuardrail(
        com.google.cloud.ces.v1.GetGuardrailRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGuardrailMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new guardrail in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.Guardrail createGuardrail(
        com.google.cloud.ces.v1.CreateGuardrailRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGuardrailMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified guardrail.
     * </pre>
     */
    public com.google.cloud.ces.v1.Guardrail updateGuardrail(
        com.google.cloud.ces.v1.UpdateGuardrailRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGuardrailMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified guardrail.
     * </pre>
     */
    public com.google.protobuf.Empty deleteGuardrail(
        com.google.cloud.ces.v1.DeleteGuardrailRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGuardrailMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists deployments in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.ListDeploymentsResponse listDeployments(
        com.google.cloud.ces.v1.ListDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDeploymentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified deployment.
     * </pre>
     */
    public com.google.cloud.ces.v1.Deployment getDeployment(
        com.google.cloud.ces.v1.GetDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new deployment in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.Deployment createDeployment(
        com.google.cloud.ces.v1.CreateDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified deployment.
     * </pre>
     */
    public com.google.cloud.ces.v1.Deployment updateDeployment(
        com.google.cloud.ces.v1.UpdateDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified deployment.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDeployment(
        com.google.cloud.ces.v1.DeleteDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists toolsets in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.ListToolsetsResponse listToolsets(
        com.google.cloud.ces.v1.ListToolsetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListToolsetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified toolset.
     * </pre>
     */
    public com.google.cloud.ces.v1.Toolset getToolset(
        com.google.cloud.ces.v1.GetToolsetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetToolsetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new toolset in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.Toolset createToolset(
        com.google.cloud.ces.v1.CreateToolsetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateToolsetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified toolset.
     * </pre>
     */
    public com.google.cloud.ces.v1.Toolset updateToolset(
        com.google.cloud.ces.v1.UpdateToolsetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateToolsetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified toolset.
     * </pre>
     */
    public com.google.protobuf.Empty deleteToolset(
        com.google.cloud.ces.v1.DeleteToolsetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteToolsetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all app versions in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.ListAppVersionsResponse listAppVersions(
        com.google.cloud.ces.v1.ListAppVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAppVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified app version.
     * </pre>
     */
    public com.google.cloud.ces.v1.AppVersion getAppVersion(
        com.google.cloud.ces.v1.GetAppVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAppVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new app version in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1.AppVersion createAppVersion(
        com.google.cloud.ces.v1.CreateAppVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAppVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified app version.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAppVersion(
        com.google.cloud.ces.v1.DeleteAppVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAppVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restores the specified app version.
     * This will create a new app version from the current draft app and overwrite
     * the current draft with the specified app version.
     * </pre>
     */
    public com.google.longrunning.Operation restoreAppVersion(
        com.google.cloud.ces.v1.RestoreAppVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestoreAppVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the changelogs of the specified app.
     * </pre>
     */
    public com.google.cloud.ces.v1.ListChangelogsResponse listChangelogs(
        com.google.cloud.ces.v1.ListChangelogsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListChangelogsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified changelog.
     * </pre>
     */
    public com.google.cloud.ces.v1.Changelog getChangelog(
        com.google.cloud.ces.v1.GetChangelogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetChangelogMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AgentService.
   *
   * <pre>
   * The service that manages agent-related resources in Gemini Enterprise for
   * Customer Engagement (CES).
   * </pre>
   */
  public static final class AgentServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AgentServiceFutureStub> {
    private AgentServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgentServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists apps in the given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1.ListAppsResponse>
        listApps(com.google.cloud.ces.v1.ListAppsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAppsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.ces.v1.App> getApp(
        com.google.cloud.ces.v1.GetAppRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAppMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new app in the given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createApp(com.google.cloud.ces.v1.CreateAppRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAppMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.ces.v1.App>
        updateApp(com.google.cloud.ces.v1.UpdateAppRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAppMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteApp(com.google.cloud.ces.v1.DeleteAppRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAppMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports the specified app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportApp(com.google.cloud.ces.v1.ExportAppRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportAppMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports the specified app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importApp(com.google.cloud.ces.v1.ImportAppRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportAppMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists agents in the given app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1.ListAgentsResponse>
        listAgents(com.google.cloud.ces.v1.ListAgentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAgentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.ces.v1.Agent>
        getAgent(com.google.cloud.ces.v1.GetAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAgentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new agent in the given app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.ces.v1.Agent>
        createAgent(com.google.cloud.ces.v1.CreateAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAgentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.ces.v1.Agent>
        updateAgent(com.google.cloud.ces.v1.UpdateAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAgentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAgent(com.google.cloud.ces.v1.DeleteAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAgentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists examples in the given app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1.ListExamplesResponse>
        listExamples(com.google.cloud.ces.v1.ListExamplesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListExamplesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified example.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.ces.v1.Example>
        getExample(com.google.cloud.ces.v1.GetExampleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetExampleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new example in the given app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.ces.v1.Example>
        createExample(com.google.cloud.ces.v1.CreateExampleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateExampleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified example.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.ces.v1.Example>
        updateExample(com.google.cloud.ces.v1.UpdateExampleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateExampleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified example.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteExample(com.google.cloud.ces.v1.DeleteExampleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteExampleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists tools in the given app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1.ListToolsResponse>
        listTools(com.google.cloud.ces.v1.ListToolsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListToolsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified tool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.ces.v1.Tool> getTool(
        com.google.cloud.ces.v1.GetToolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetToolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists conversations in the given app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1.ListConversationsResponse>
        listConversations(com.google.cloud.ces.v1.ListConversationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConversationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified conversation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.ces.v1.Conversation>
        getConversation(com.google.cloud.ces.v1.GetConversationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConversationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified conversation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteConversation(com.google.cloud.ces.v1.DeleteConversationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteConversationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Batch deletes the specified conversations.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchDeleteConversations(com.google.cloud.ces.v1.BatchDeleteConversationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchDeleteConversationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new tool in the given app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.ces.v1.Tool>
        createTool(com.google.cloud.ces.v1.CreateToolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateToolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified tool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.ces.v1.Tool>
        updateTool(com.google.cloud.ces.v1.UpdateToolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateToolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified tool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteTool(
        com.google.cloud.ces.v1.DeleteToolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteToolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists guardrails in the given app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1.ListGuardrailsResponse>
        listGuardrails(com.google.cloud.ces.v1.ListGuardrailsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGuardrailsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified guardrail.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.ces.v1.Guardrail>
        getGuardrail(com.google.cloud.ces.v1.GetGuardrailRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGuardrailMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new guardrail in the given app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.ces.v1.Guardrail>
        createGuardrail(com.google.cloud.ces.v1.CreateGuardrailRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateGuardrailMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified guardrail.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.ces.v1.Guardrail>
        updateGuardrail(com.google.cloud.ces.v1.UpdateGuardrailRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateGuardrailMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified guardrail.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteGuardrail(com.google.cloud.ces.v1.DeleteGuardrailRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteGuardrailMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists deployments in the given app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1.ListDeploymentsResponse>
        listDeployments(com.google.cloud.ces.v1.ListDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDeploymentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.ces.v1.Deployment>
        getDeployment(com.google.cloud.ces.v1.GetDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new deployment in the given app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.ces.v1.Deployment>
        createDeployment(com.google.cloud.ces.v1.CreateDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.ces.v1.Deployment>
        updateDeployment(com.google.cloud.ces.v1.UpdateDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDeployment(com.google.cloud.ces.v1.DeleteDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists toolsets in the given app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1.ListToolsetsResponse>
        listToolsets(com.google.cloud.ces.v1.ListToolsetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListToolsetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified toolset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.ces.v1.Toolset>
        getToolset(com.google.cloud.ces.v1.GetToolsetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetToolsetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new toolset in the given app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.ces.v1.Toolset>
        createToolset(com.google.cloud.ces.v1.CreateToolsetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateToolsetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified toolset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.ces.v1.Toolset>
        updateToolset(com.google.cloud.ces.v1.UpdateToolsetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateToolsetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified toolset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteToolset(com.google.cloud.ces.v1.DeleteToolsetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteToolsetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all app versions in the given app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1.ListAppVersionsResponse>
        listAppVersions(com.google.cloud.ces.v1.ListAppVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAppVersionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified app version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.ces.v1.AppVersion>
        getAppVersion(com.google.cloud.ces.v1.GetAppVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAppVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new app version in the given app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.ces.v1.AppVersion>
        createAppVersion(com.google.cloud.ces.v1.CreateAppVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAppVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified app version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAppVersion(com.google.cloud.ces.v1.DeleteAppVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAppVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Restores the specified app version.
     * This will create a new app version from the current draft app and overwrite
     * the current draft with the specified app version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        restoreAppVersion(com.google.cloud.ces.v1.RestoreAppVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestoreAppVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the changelogs of the specified app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1.ListChangelogsResponse>
        listChangelogs(com.google.cloud.ces.v1.ListChangelogsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListChangelogsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified changelog.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.ces.v1.Changelog>
        getChangelog(com.google.cloud.ces.v1.GetChangelogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetChangelogMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_APPS = 0;
  private static final int METHODID_GET_APP = 1;
  private static final int METHODID_CREATE_APP = 2;
  private static final int METHODID_UPDATE_APP = 3;
  private static final int METHODID_DELETE_APP = 4;
  private static final int METHODID_EXPORT_APP = 5;
  private static final int METHODID_IMPORT_APP = 6;
  private static final int METHODID_LIST_AGENTS = 7;
  private static final int METHODID_GET_AGENT = 8;
  private static final int METHODID_CREATE_AGENT = 9;
  private static final int METHODID_UPDATE_AGENT = 10;
  private static final int METHODID_DELETE_AGENT = 11;
  private static final int METHODID_LIST_EXAMPLES = 12;
  private static final int METHODID_GET_EXAMPLE = 13;
  private static final int METHODID_CREATE_EXAMPLE = 14;
  private static final int METHODID_UPDATE_EXAMPLE = 15;
  private static final int METHODID_DELETE_EXAMPLE = 16;
  private static final int METHODID_LIST_TOOLS = 17;
  private static final int METHODID_GET_TOOL = 18;
  private static final int METHODID_LIST_CONVERSATIONS = 19;
  private static final int METHODID_GET_CONVERSATION = 20;
  private static final int METHODID_DELETE_CONVERSATION = 21;
  private static final int METHODID_BATCH_DELETE_CONVERSATIONS = 22;
  private static final int METHODID_CREATE_TOOL = 23;
  private static final int METHODID_UPDATE_TOOL = 24;
  private static final int METHODID_DELETE_TOOL = 25;
  private static final int METHODID_LIST_GUARDRAILS = 26;
  private static final int METHODID_GET_GUARDRAIL = 27;
  private static final int METHODID_CREATE_GUARDRAIL = 28;
  private static final int METHODID_UPDATE_GUARDRAIL = 29;
  private static final int METHODID_DELETE_GUARDRAIL = 30;
  private static final int METHODID_LIST_DEPLOYMENTS = 31;
  private static final int METHODID_GET_DEPLOYMENT = 32;
  private static final int METHODID_CREATE_DEPLOYMENT = 33;
  private static final int METHODID_UPDATE_DEPLOYMENT = 34;
  private static final int METHODID_DELETE_DEPLOYMENT = 35;
  private static final int METHODID_LIST_TOOLSETS = 36;
  private static final int METHODID_GET_TOOLSET = 37;
  private static final int METHODID_CREATE_TOOLSET = 38;
  private static final int METHODID_UPDATE_TOOLSET = 39;
  private static final int METHODID_DELETE_TOOLSET = 40;
  private static final int METHODID_LIST_APP_VERSIONS = 41;
  private static final int METHODID_GET_APP_VERSION = 42;
  private static final int METHODID_CREATE_APP_VERSION = 43;
  private static final int METHODID_DELETE_APP_VERSION = 44;
  private static final int METHODID_RESTORE_APP_VERSION = 45;
  private static final int METHODID_LIST_CHANGELOGS = 46;
  private static final int METHODID_GET_CHANGELOG = 47;

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
        case METHODID_LIST_APPS:
          serviceImpl.listApps(
              (com.google.cloud.ces.v1.ListAppsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListAppsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_APP:
          serviceImpl.getApp(
              (com.google.cloud.ces.v1.GetAppRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.App>) responseObserver);
          break;
        case METHODID_CREATE_APP:
          serviceImpl.createApp(
              (com.google.cloud.ces.v1.CreateAppRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_APP:
          serviceImpl.updateApp(
              (com.google.cloud.ces.v1.UpdateAppRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.App>) responseObserver);
          break;
        case METHODID_DELETE_APP:
          serviceImpl.deleteApp(
              (com.google.cloud.ces.v1.DeleteAppRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_APP:
          serviceImpl.exportApp(
              (com.google.cloud.ces.v1.ExportAppRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_APP:
          serviceImpl.importApp(
              (com.google.cloud.ces.v1.ImportAppRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_AGENTS:
          serviceImpl.listAgents(
              (com.google.cloud.ces.v1.ListAgentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListAgentsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_AGENT:
          serviceImpl.getAgent(
              (com.google.cloud.ces.v1.GetAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Agent>) responseObserver);
          break;
        case METHODID_CREATE_AGENT:
          serviceImpl.createAgent(
              (com.google.cloud.ces.v1.CreateAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Agent>) responseObserver);
          break;
        case METHODID_UPDATE_AGENT:
          serviceImpl.updateAgent(
              (com.google.cloud.ces.v1.UpdateAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Agent>) responseObserver);
          break;
        case METHODID_DELETE_AGENT:
          serviceImpl.deleteAgent(
              (com.google.cloud.ces.v1.DeleteAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_EXAMPLES:
          serviceImpl.listExamples(
              (com.google.cloud.ces.v1.ListExamplesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListExamplesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_EXAMPLE:
          serviceImpl.getExample(
              (com.google.cloud.ces.v1.GetExampleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Example>) responseObserver);
          break;
        case METHODID_CREATE_EXAMPLE:
          serviceImpl.createExample(
              (com.google.cloud.ces.v1.CreateExampleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Example>) responseObserver);
          break;
        case METHODID_UPDATE_EXAMPLE:
          serviceImpl.updateExample(
              (com.google.cloud.ces.v1.UpdateExampleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Example>) responseObserver);
          break;
        case METHODID_DELETE_EXAMPLE:
          serviceImpl.deleteExample(
              (com.google.cloud.ces.v1.DeleteExampleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_TOOLS:
          serviceImpl.listTools(
              (com.google.cloud.ces.v1.ListToolsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListToolsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TOOL:
          serviceImpl.getTool(
              (com.google.cloud.ces.v1.GetToolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Tool>) responseObserver);
          break;
        case METHODID_LIST_CONVERSATIONS:
          serviceImpl.listConversations(
              (com.google.cloud.ces.v1.ListConversationsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListConversationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CONVERSATION:
          serviceImpl.getConversation(
              (com.google.cloud.ces.v1.GetConversationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Conversation>) responseObserver);
          break;
        case METHODID_DELETE_CONVERSATION:
          serviceImpl.deleteConversation(
              (com.google.cloud.ces.v1.DeleteConversationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_BATCH_DELETE_CONVERSATIONS:
          serviceImpl.batchDeleteConversations(
              (com.google.cloud.ces.v1.BatchDeleteConversationsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_TOOL:
          serviceImpl.createTool(
              (com.google.cloud.ces.v1.CreateToolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Tool>) responseObserver);
          break;
        case METHODID_UPDATE_TOOL:
          serviceImpl.updateTool(
              (com.google.cloud.ces.v1.UpdateToolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Tool>) responseObserver);
          break;
        case METHODID_DELETE_TOOL:
          serviceImpl.deleteTool(
              (com.google.cloud.ces.v1.DeleteToolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_GUARDRAILS:
          serviceImpl.listGuardrails(
              (com.google.cloud.ces.v1.ListGuardrailsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListGuardrailsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_GUARDRAIL:
          serviceImpl.getGuardrail(
              (com.google.cloud.ces.v1.GetGuardrailRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Guardrail>) responseObserver);
          break;
        case METHODID_CREATE_GUARDRAIL:
          serviceImpl.createGuardrail(
              (com.google.cloud.ces.v1.CreateGuardrailRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Guardrail>) responseObserver);
          break;
        case METHODID_UPDATE_GUARDRAIL:
          serviceImpl.updateGuardrail(
              (com.google.cloud.ces.v1.UpdateGuardrailRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Guardrail>) responseObserver);
          break;
        case METHODID_DELETE_GUARDRAIL:
          serviceImpl.deleteGuardrail(
              (com.google.cloud.ces.v1.DeleteGuardrailRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_DEPLOYMENTS:
          serviceImpl.listDeployments(
              (com.google.cloud.ces.v1.ListDeploymentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListDeploymentsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DEPLOYMENT:
          serviceImpl.getDeployment(
              (com.google.cloud.ces.v1.GetDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Deployment>) responseObserver);
          break;
        case METHODID_CREATE_DEPLOYMENT:
          serviceImpl.createDeployment(
              (com.google.cloud.ces.v1.CreateDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Deployment>) responseObserver);
          break;
        case METHODID_UPDATE_DEPLOYMENT:
          serviceImpl.updateDeployment(
              (com.google.cloud.ces.v1.UpdateDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Deployment>) responseObserver);
          break;
        case METHODID_DELETE_DEPLOYMENT:
          serviceImpl.deleteDeployment(
              (com.google.cloud.ces.v1.DeleteDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_TOOLSETS:
          serviceImpl.listToolsets(
              (com.google.cloud.ces.v1.ListToolsetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListToolsetsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TOOLSET:
          serviceImpl.getToolset(
              (com.google.cloud.ces.v1.GetToolsetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Toolset>) responseObserver);
          break;
        case METHODID_CREATE_TOOLSET:
          serviceImpl.createToolset(
              (com.google.cloud.ces.v1.CreateToolsetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Toolset>) responseObserver);
          break;
        case METHODID_UPDATE_TOOLSET:
          serviceImpl.updateToolset(
              (com.google.cloud.ces.v1.UpdateToolsetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Toolset>) responseObserver);
          break;
        case METHODID_DELETE_TOOLSET:
          serviceImpl.deleteToolset(
              (com.google.cloud.ces.v1.DeleteToolsetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_APP_VERSIONS:
          serviceImpl.listAppVersions(
              (com.google.cloud.ces.v1.ListAppVersionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListAppVersionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_APP_VERSION:
          serviceImpl.getAppVersion(
              (com.google.cloud.ces.v1.GetAppVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.AppVersion>) responseObserver);
          break;
        case METHODID_CREATE_APP_VERSION:
          serviceImpl.createAppVersion(
              (com.google.cloud.ces.v1.CreateAppVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.AppVersion>) responseObserver);
          break;
        case METHODID_DELETE_APP_VERSION:
          serviceImpl.deleteAppVersion(
              (com.google.cloud.ces.v1.DeleteAppVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_RESTORE_APP_VERSION:
          serviceImpl.restoreAppVersion(
              (com.google.cloud.ces.v1.RestoreAppVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_CHANGELOGS:
          serviceImpl.listChangelogs(
              (com.google.cloud.ces.v1.ListChangelogsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ListChangelogsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CHANGELOG:
          serviceImpl.getChangelog(
              (com.google.cloud.ces.v1.GetChangelogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.Changelog>) responseObserver);
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
            getListAppsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.ListAppsRequest,
                    com.google.cloud.ces.v1.ListAppsResponse>(service, METHODID_LIST_APPS)))
        .addMethod(
            getGetAppMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.GetAppRequest, com.google.cloud.ces.v1.App>(
                    service, METHODID_GET_APP)))
        .addMethod(
            getCreateAppMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.CreateAppRequest, com.google.longrunning.Operation>(
                    service, METHODID_CREATE_APP)))
        .addMethod(
            getUpdateAppMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.UpdateAppRequest, com.google.cloud.ces.v1.App>(
                    service, METHODID_UPDATE_APP)))
        .addMethod(
            getDeleteAppMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.DeleteAppRequest, com.google.longrunning.Operation>(
                    service, METHODID_DELETE_APP)))
        .addMethod(
            getExportAppMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.ExportAppRequest, com.google.longrunning.Operation>(
                    service, METHODID_EXPORT_APP)))
        .addMethod(
            getImportAppMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.ImportAppRequest, com.google.longrunning.Operation>(
                    service, METHODID_IMPORT_APP)))
        .addMethod(
            getListAgentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.ListAgentsRequest,
                    com.google.cloud.ces.v1.ListAgentsResponse>(service, METHODID_LIST_AGENTS)))
        .addMethod(
            getGetAgentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.GetAgentRequest, com.google.cloud.ces.v1.Agent>(
                    service, METHODID_GET_AGENT)))
        .addMethod(
            getCreateAgentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.CreateAgentRequest, com.google.cloud.ces.v1.Agent>(
                    service, METHODID_CREATE_AGENT)))
        .addMethod(
            getUpdateAgentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.UpdateAgentRequest, com.google.cloud.ces.v1.Agent>(
                    service, METHODID_UPDATE_AGENT)))
        .addMethod(
            getDeleteAgentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.DeleteAgentRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_AGENT)))
        .addMethod(
            getListExamplesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.ListExamplesRequest,
                    com.google.cloud.ces.v1.ListExamplesResponse>(service, METHODID_LIST_EXAMPLES)))
        .addMethod(
            getGetExampleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.GetExampleRequest, com.google.cloud.ces.v1.Example>(
                    service, METHODID_GET_EXAMPLE)))
        .addMethod(
            getCreateExampleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.CreateExampleRequest, com.google.cloud.ces.v1.Example>(
                    service, METHODID_CREATE_EXAMPLE)))
        .addMethod(
            getUpdateExampleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.UpdateExampleRequest, com.google.cloud.ces.v1.Example>(
                    service, METHODID_UPDATE_EXAMPLE)))
        .addMethod(
            getDeleteExampleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.DeleteExampleRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_EXAMPLE)))
        .addMethod(
            getListToolsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.ListToolsRequest,
                    com.google.cloud.ces.v1.ListToolsResponse>(service, METHODID_LIST_TOOLS)))
        .addMethod(
            getGetToolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.GetToolRequest, com.google.cloud.ces.v1.Tool>(
                    service, METHODID_GET_TOOL)))
        .addMethod(
            getListConversationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.ListConversationsRequest,
                    com.google.cloud.ces.v1.ListConversationsResponse>(
                    service, METHODID_LIST_CONVERSATIONS)))
        .addMethod(
            getGetConversationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.GetConversationRequest,
                    com.google.cloud.ces.v1.Conversation>(service, METHODID_GET_CONVERSATION)))
        .addMethod(
            getDeleteConversationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.DeleteConversationRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_CONVERSATION)))
        .addMethod(
            getBatchDeleteConversationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.BatchDeleteConversationsRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_BATCH_DELETE_CONVERSATIONS)))
        .addMethod(
            getCreateToolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.CreateToolRequest, com.google.cloud.ces.v1.Tool>(
                    service, METHODID_CREATE_TOOL)))
        .addMethod(
            getUpdateToolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.UpdateToolRequest, com.google.cloud.ces.v1.Tool>(
                    service, METHODID_UPDATE_TOOL)))
        .addMethod(
            getDeleteToolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.DeleteToolRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_TOOL)))
        .addMethod(
            getListGuardrailsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.ListGuardrailsRequest,
                    com.google.cloud.ces.v1.ListGuardrailsResponse>(
                    service, METHODID_LIST_GUARDRAILS)))
        .addMethod(
            getGetGuardrailMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.GetGuardrailRequest, com.google.cloud.ces.v1.Guardrail>(
                    service, METHODID_GET_GUARDRAIL)))
        .addMethod(
            getCreateGuardrailMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.CreateGuardrailRequest,
                    com.google.cloud.ces.v1.Guardrail>(service, METHODID_CREATE_GUARDRAIL)))
        .addMethod(
            getUpdateGuardrailMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.UpdateGuardrailRequest,
                    com.google.cloud.ces.v1.Guardrail>(service, METHODID_UPDATE_GUARDRAIL)))
        .addMethod(
            getDeleteGuardrailMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.DeleteGuardrailRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_GUARDRAIL)))
        .addMethod(
            getListDeploymentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.ListDeploymentsRequest,
                    com.google.cloud.ces.v1.ListDeploymentsResponse>(
                    service, METHODID_LIST_DEPLOYMENTS)))
        .addMethod(
            getGetDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.GetDeploymentRequest,
                    com.google.cloud.ces.v1.Deployment>(service, METHODID_GET_DEPLOYMENT)))
        .addMethod(
            getCreateDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.CreateDeploymentRequest,
                    com.google.cloud.ces.v1.Deployment>(service, METHODID_CREATE_DEPLOYMENT)))
        .addMethod(
            getUpdateDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.UpdateDeploymentRequest,
                    com.google.cloud.ces.v1.Deployment>(service, METHODID_UPDATE_DEPLOYMENT)))
        .addMethod(
            getDeleteDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.DeleteDeploymentRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_DEPLOYMENT)))
        .addMethod(
            getListToolsetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.ListToolsetsRequest,
                    com.google.cloud.ces.v1.ListToolsetsResponse>(service, METHODID_LIST_TOOLSETS)))
        .addMethod(
            getGetToolsetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.GetToolsetRequest, com.google.cloud.ces.v1.Toolset>(
                    service, METHODID_GET_TOOLSET)))
        .addMethod(
            getCreateToolsetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.CreateToolsetRequest, com.google.cloud.ces.v1.Toolset>(
                    service, METHODID_CREATE_TOOLSET)))
        .addMethod(
            getUpdateToolsetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.UpdateToolsetRequest, com.google.cloud.ces.v1.Toolset>(
                    service, METHODID_UPDATE_TOOLSET)))
        .addMethod(
            getDeleteToolsetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.DeleteToolsetRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_TOOLSET)))
        .addMethod(
            getListAppVersionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.ListAppVersionsRequest,
                    com.google.cloud.ces.v1.ListAppVersionsResponse>(
                    service, METHODID_LIST_APP_VERSIONS)))
        .addMethod(
            getGetAppVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.GetAppVersionRequest,
                    com.google.cloud.ces.v1.AppVersion>(service, METHODID_GET_APP_VERSION)))
        .addMethod(
            getCreateAppVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.CreateAppVersionRequest,
                    com.google.cloud.ces.v1.AppVersion>(service, METHODID_CREATE_APP_VERSION)))
        .addMethod(
            getDeleteAppVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.DeleteAppVersionRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_APP_VERSION)))
        .addMethod(
            getRestoreAppVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.RestoreAppVersionRequest,
                    com.google.longrunning.Operation>(service, METHODID_RESTORE_APP_VERSION)))
        .addMethod(
            getListChangelogsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.ListChangelogsRequest,
                    com.google.cloud.ces.v1.ListChangelogsResponse>(
                    service, METHODID_LIST_CHANGELOGS)))
        .addMethod(
            getGetChangelogMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.GetChangelogRequest, com.google.cloud.ces.v1.Changelog>(
                    service, METHODID_GET_CHANGELOG)))
        .build();
  }

  private abstract static class AgentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AgentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.ces.v1.AgentServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AgentService");
    }
  }

  private static final class AgentServiceFileDescriptorSupplier
      extends AgentServiceBaseDescriptorSupplier {
    AgentServiceFileDescriptorSupplier() {}
  }

  private static final class AgentServiceMethodDescriptorSupplier
      extends AgentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AgentServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AgentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AgentServiceFileDescriptorSupplier())
                      .addMethod(getListAppsMethod())
                      .addMethod(getGetAppMethod())
                      .addMethod(getCreateAppMethod())
                      .addMethod(getUpdateAppMethod())
                      .addMethod(getDeleteAppMethod())
                      .addMethod(getExportAppMethod())
                      .addMethod(getImportAppMethod())
                      .addMethod(getListAgentsMethod())
                      .addMethod(getGetAgentMethod())
                      .addMethod(getCreateAgentMethod())
                      .addMethod(getUpdateAgentMethod())
                      .addMethod(getDeleteAgentMethod())
                      .addMethod(getListExamplesMethod())
                      .addMethod(getGetExampleMethod())
                      .addMethod(getCreateExampleMethod())
                      .addMethod(getUpdateExampleMethod())
                      .addMethod(getDeleteExampleMethod())
                      .addMethod(getListToolsMethod())
                      .addMethod(getGetToolMethod())
                      .addMethod(getListConversationsMethod())
                      .addMethod(getGetConversationMethod())
                      .addMethod(getDeleteConversationMethod())
                      .addMethod(getBatchDeleteConversationsMethod())
                      .addMethod(getCreateToolMethod())
                      .addMethod(getUpdateToolMethod())
                      .addMethod(getDeleteToolMethod())
                      .addMethod(getListGuardrailsMethod())
                      .addMethod(getGetGuardrailMethod())
                      .addMethod(getCreateGuardrailMethod())
                      .addMethod(getUpdateGuardrailMethod())
                      .addMethod(getDeleteGuardrailMethod())
                      .addMethod(getListDeploymentsMethod())
                      .addMethod(getGetDeploymentMethod())
                      .addMethod(getCreateDeploymentMethod())
                      .addMethod(getUpdateDeploymentMethod())
                      .addMethod(getDeleteDeploymentMethod())
                      .addMethod(getListToolsetsMethod())
                      .addMethod(getGetToolsetMethod())
                      .addMethod(getCreateToolsetMethod())
                      .addMethod(getUpdateToolsetMethod())
                      .addMethod(getDeleteToolsetMethod())
                      .addMethod(getListAppVersionsMethod())
                      .addMethod(getGetAppVersionMethod())
                      .addMethod(getCreateAppVersionMethod())
                      .addMethod(getDeleteAppVersionMethod())
                      .addMethod(getRestoreAppVersionMethod())
                      .addMethod(getListChangelogsMethod())
                      .addMethod(getGetChangelogMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
