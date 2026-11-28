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
package com.google.cloud.aiplatform.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service for managing Agent Anomaly Detection for monitored agents.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class AgentAnomalyDetectionServiceGrpc {

  private AgentAnomalyDetectionServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.aiplatform.v1.AgentAnomalyDetectionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetAgentAnomalyDetectionScopeRequest,
          com.google.cloud.aiplatform.v1.AgentAnomalyDetectionScope>
      getGetAgentAnomalyDetectionScopeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAgentAnomalyDetectionScope",
      requestType = com.google.cloud.aiplatform.v1.GetAgentAnomalyDetectionScopeRequest.class,
      responseType = com.google.cloud.aiplatform.v1.AgentAnomalyDetectionScope.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetAgentAnomalyDetectionScopeRequest,
          com.google.cloud.aiplatform.v1.AgentAnomalyDetectionScope>
      getGetAgentAnomalyDetectionScopeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.GetAgentAnomalyDetectionScopeRequest,
            com.google.cloud.aiplatform.v1.AgentAnomalyDetectionScope>
        getGetAgentAnomalyDetectionScopeMethod;
    if ((getGetAgentAnomalyDetectionScopeMethod =
            AgentAnomalyDetectionServiceGrpc.getGetAgentAnomalyDetectionScopeMethod)
        == null) {
      synchronized (AgentAnomalyDetectionServiceGrpc.class) {
        if ((getGetAgentAnomalyDetectionScopeMethod =
                AgentAnomalyDetectionServiceGrpc.getGetAgentAnomalyDetectionScopeMethod)
            == null) {
          AgentAnomalyDetectionServiceGrpc.getGetAgentAnomalyDetectionScopeMethod =
              getGetAgentAnomalyDetectionScopeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.GetAgentAnomalyDetectionScopeRequest,
                          com.google.cloud.aiplatform.v1.AgentAnomalyDetectionScope>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetAgentAnomalyDetectionScope"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.GetAgentAnomalyDetectionScopeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.AgentAnomalyDetectionScope
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentAnomalyDetectionServiceMethodDescriptorSupplier(
                              "GetAgentAnomalyDetectionScope"))
                      .build();
        }
      }
    }
    return getGetAgentAnomalyDetectionScopeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetMonitoredAgentRequest,
          com.google.cloud.aiplatform.v1.MonitoredAgent>
      getGetMonitoredAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMonitoredAgent",
      requestType = com.google.cloud.aiplatform.v1.GetMonitoredAgentRequest.class,
      responseType = com.google.cloud.aiplatform.v1.MonitoredAgent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetMonitoredAgentRequest,
          com.google.cloud.aiplatform.v1.MonitoredAgent>
      getGetMonitoredAgentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.GetMonitoredAgentRequest,
            com.google.cloud.aiplatform.v1.MonitoredAgent>
        getGetMonitoredAgentMethod;
    if ((getGetMonitoredAgentMethod = AgentAnomalyDetectionServiceGrpc.getGetMonitoredAgentMethod)
        == null) {
      synchronized (AgentAnomalyDetectionServiceGrpc.class) {
        if ((getGetMonitoredAgentMethod =
                AgentAnomalyDetectionServiceGrpc.getGetMonitoredAgentMethod)
            == null) {
          AgentAnomalyDetectionServiceGrpc.getGetMonitoredAgentMethod =
              getGetMonitoredAgentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.GetMonitoredAgentRequest,
                          com.google.cloud.aiplatform.v1.MonitoredAgent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMonitoredAgent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.GetMonitoredAgentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.MonitoredAgent.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentAnomalyDetectionServiceMethodDescriptorSupplier(
                              "GetMonitoredAgent"))
                      .build();
        }
      }
    }
    return getGetMonitoredAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListMonitoredAgentsRequest,
          com.google.cloud.aiplatform.v1.ListMonitoredAgentsResponse>
      getListMonitoredAgentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMonitoredAgents",
      requestType = com.google.cloud.aiplatform.v1.ListMonitoredAgentsRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListMonitoredAgentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListMonitoredAgentsRequest,
          com.google.cloud.aiplatform.v1.ListMonitoredAgentsResponse>
      getListMonitoredAgentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ListMonitoredAgentsRequest,
            com.google.cloud.aiplatform.v1.ListMonitoredAgentsResponse>
        getListMonitoredAgentsMethod;
    if ((getListMonitoredAgentsMethod =
            AgentAnomalyDetectionServiceGrpc.getListMonitoredAgentsMethod)
        == null) {
      synchronized (AgentAnomalyDetectionServiceGrpc.class) {
        if ((getListMonitoredAgentsMethod =
                AgentAnomalyDetectionServiceGrpc.getListMonitoredAgentsMethod)
            == null) {
          AgentAnomalyDetectionServiceGrpc.getListMonitoredAgentsMethod =
              getListMonitoredAgentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ListMonitoredAgentsRequest,
                          com.google.cloud.aiplatform.v1.ListMonitoredAgentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListMonitoredAgents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListMonitoredAgentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListMonitoredAgentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentAnomalyDetectionServiceMethodDescriptorSupplier(
                              "ListMonitoredAgents"))
                      .build();
        }
      }
    }
    return getListMonitoredAgentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.EnableMonitoredAgentRequest,
          com.google.longrunning.Operation>
      getEnableMonitoredAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EnableMonitoredAgent",
      requestType = com.google.cloud.aiplatform.v1.EnableMonitoredAgentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.EnableMonitoredAgentRequest,
          com.google.longrunning.Operation>
      getEnableMonitoredAgentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.EnableMonitoredAgentRequest,
            com.google.longrunning.Operation>
        getEnableMonitoredAgentMethod;
    if ((getEnableMonitoredAgentMethod =
            AgentAnomalyDetectionServiceGrpc.getEnableMonitoredAgentMethod)
        == null) {
      synchronized (AgentAnomalyDetectionServiceGrpc.class) {
        if ((getEnableMonitoredAgentMethod =
                AgentAnomalyDetectionServiceGrpc.getEnableMonitoredAgentMethod)
            == null) {
          AgentAnomalyDetectionServiceGrpc.getEnableMonitoredAgentMethod =
              getEnableMonitoredAgentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.EnableMonitoredAgentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "EnableMonitoredAgent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.EnableMonitoredAgentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentAnomalyDetectionServiceMethodDescriptorSupplier(
                              "EnableMonitoredAgent"))
                      .build();
        }
      }
    }
    return getEnableMonitoredAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.DisableMonitoredAgentRequest,
          com.google.longrunning.Operation>
      getDisableMonitoredAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DisableMonitoredAgent",
      requestType = com.google.cloud.aiplatform.v1.DisableMonitoredAgentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.DisableMonitoredAgentRequest,
          com.google.longrunning.Operation>
      getDisableMonitoredAgentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.DisableMonitoredAgentRequest,
            com.google.longrunning.Operation>
        getDisableMonitoredAgentMethod;
    if ((getDisableMonitoredAgentMethod =
            AgentAnomalyDetectionServiceGrpc.getDisableMonitoredAgentMethod)
        == null) {
      synchronized (AgentAnomalyDetectionServiceGrpc.class) {
        if ((getDisableMonitoredAgentMethod =
                AgentAnomalyDetectionServiceGrpc.getDisableMonitoredAgentMethod)
            == null) {
          AgentAnomalyDetectionServiceGrpc.getDisableMonitoredAgentMethod =
              getDisableMonitoredAgentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.DisableMonitoredAgentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DisableMonitoredAgent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.DisableMonitoredAgentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentAnomalyDetectionServiceMethodDescriptorSupplier(
                              "DisableMonitoredAgent"))
                      .build();
        }
      }
    }
    return getDisableMonitoredAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.DeleteAgentAnomalyDetectionScopeRequest,
          com.google.longrunning.Operation>
      getDeleteAgentAnomalyDetectionScopeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAgentAnomalyDetectionScope",
      requestType = com.google.cloud.aiplatform.v1.DeleteAgentAnomalyDetectionScopeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.DeleteAgentAnomalyDetectionScopeRequest,
          com.google.longrunning.Operation>
      getDeleteAgentAnomalyDetectionScopeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.DeleteAgentAnomalyDetectionScopeRequest,
            com.google.longrunning.Operation>
        getDeleteAgentAnomalyDetectionScopeMethod;
    if ((getDeleteAgentAnomalyDetectionScopeMethod =
            AgentAnomalyDetectionServiceGrpc.getDeleteAgentAnomalyDetectionScopeMethod)
        == null) {
      synchronized (AgentAnomalyDetectionServiceGrpc.class) {
        if ((getDeleteAgentAnomalyDetectionScopeMethod =
                AgentAnomalyDetectionServiceGrpc.getDeleteAgentAnomalyDetectionScopeMethod)
            == null) {
          AgentAnomalyDetectionServiceGrpc.getDeleteAgentAnomalyDetectionScopeMethod =
              getDeleteAgentAnomalyDetectionScopeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.DeleteAgentAnomalyDetectionScopeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteAgentAnomalyDetectionScope"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.DeleteAgentAnomalyDetectionScopeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentAnomalyDetectionServiceMethodDescriptorSupplier(
                              "DeleteAgentAnomalyDetectionScope"))
                      .build();
        }
      }
    }
    return getDeleteAgentAnomalyDetectionScopeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CreateAgentAnomalyDetectionScopeRequest,
          com.google.longrunning.Operation>
      getCreateAgentAnomalyDetectionScopeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAgentAnomalyDetectionScope",
      requestType = com.google.cloud.aiplatform.v1.CreateAgentAnomalyDetectionScopeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CreateAgentAnomalyDetectionScopeRequest,
          com.google.longrunning.Operation>
      getCreateAgentAnomalyDetectionScopeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.CreateAgentAnomalyDetectionScopeRequest,
            com.google.longrunning.Operation>
        getCreateAgentAnomalyDetectionScopeMethod;
    if ((getCreateAgentAnomalyDetectionScopeMethod =
            AgentAnomalyDetectionServiceGrpc.getCreateAgentAnomalyDetectionScopeMethod)
        == null) {
      synchronized (AgentAnomalyDetectionServiceGrpc.class) {
        if ((getCreateAgentAnomalyDetectionScopeMethod =
                AgentAnomalyDetectionServiceGrpc.getCreateAgentAnomalyDetectionScopeMethod)
            == null) {
          AgentAnomalyDetectionServiceGrpc.getCreateAgentAnomalyDetectionScopeMethod =
              getCreateAgentAnomalyDetectionScopeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.CreateAgentAnomalyDetectionScopeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateAgentAnomalyDetectionScope"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.CreateAgentAnomalyDetectionScopeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentAnomalyDetectionServiceMethodDescriptorSupplier(
                              "CreateAgentAnomalyDetectionScope"))
                      .build();
        }
      }
    }
    return getCreateAgentAnomalyDetectionScopeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesRequest,
          com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesResponse>
      getListAgentAnomalyDetectionScopesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAgentAnomalyDetectionScopes",
      requestType = com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesRequest,
          com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesResponse>
      getListAgentAnomalyDetectionScopesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesRequest,
            com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesResponse>
        getListAgentAnomalyDetectionScopesMethod;
    if ((getListAgentAnomalyDetectionScopesMethod =
            AgentAnomalyDetectionServiceGrpc.getListAgentAnomalyDetectionScopesMethod)
        == null) {
      synchronized (AgentAnomalyDetectionServiceGrpc.class) {
        if ((getListAgentAnomalyDetectionScopesMethod =
                AgentAnomalyDetectionServiceGrpc.getListAgentAnomalyDetectionScopesMethod)
            == null) {
          AgentAnomalyDetectionServiceGrpc.getListAgentAnomalyDetectionScopesMethod =
              getListAgentAnomalyDetectionScopesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesRequest,
                          com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAgentAnomalyDetectionScopes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentAnomalyDetectionServiceMethodDescriptorSupplier(
                              "ListAgentAnomalyDetectionScopes"))
                      .build();
        }
      }
    }
    return getListAgentAnomalyDetectionScopesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListAnalyzedSessionsRequest,
          com.google.cloud.aiplatform.v1.ListAnalyzedSessionsResponse>
      getListAnalyzedSessionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAnalyzedSessions",
      requestType = com.google.cloud.aiplatform.v1.ListAnalyzedSessionsRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListAnalyzedSessionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListAnalyzedSessionsRequest,
          com.google.cloud.aiplatform.v1.ListAnalyzedSessionsResponse>
      getListAnalyzedSessionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ListAnalyzedSessionsRequest,
            com.google.cloud.aiplatform.v1.ListAnalyzedSessionsResponse>
        getListAnalyzedSessionsMethod;
    if ((getListAnalyzedSessionsMethod =
            AgentAnomalyDetectionServiceGrpc.getListAnalyzedSessionsMethod)
        == null) {
      synchronized (AgentAnomalyDetectionServiceGrpc.class) {
        if ((getListAnalyzedSessionsMethod =
                AgentAnomalyDetectionServiceGrpc.getListAnalyzedSessionsMethod)
            == null) {
          AgentAnomalyDetectionServiceGrpc.getListAnalyzedSessionsMethod =
              getListAnalyzedSessionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ListAnalyzedSessionsRequest,
                          com.google.cloud.aiplatform.v1.ListAnalyzedSessionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAnalyzedSessions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListAnalyzedSessionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListAnalyzedSessionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentAnomalyDetectionServiceMethodDescriptorSupplier(
                              "ListAnalyzedSessions"))
                      .build();
        }
      }
    }
    return getListAnalyzedSessionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetAnalyzedSessionRequest,
          com.google.cloud.aiplatform.v1.AnalyzedSession>
      getGetAnalyzedSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAnalyzedSession",
      requestType = com.google.cloud.aiplatform.v1.GetAnalyzedSessionRequest.class,
      responseType = com.google.cloud.aiplatform.v1.AnalyzedSession.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetAnalyzedSessionRequest,
          com.google.cloud.aiplatform.v1.AnalyzedSession>
      getGetAnalyzedSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.GetAnalyzedSessionRequest,
            com.google.cloud.aiplatform.v1.AnalyzedSession>
        getGetAnalyzedSessionMethod;
    if ((getGetAnalyzedSessionMethod = AgentAnomalyDetectionServiceGrpc.getGetAnalyzedSessionMethod)
        == null) {
      synchronized (AgentAnomalyDetectionServiceGrpc.class) {
        if ((getGetAnalyzedSessionMethod =
                AgentAnomalyDetectionServiceGrpc.getGetAnalyzedSessionMethod)
            == null) {
          AgentAnomalyDetectionServiceGrpc.getGetAnalyzedSessionMethod =
              getGetAnalyzedSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.GetAnalyzedSessionRequest,
                          com.google.cloud.aiplatform.v1.AnalyzedSession>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAnalyzedSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.GetAnalyzedSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.AnalyzedSession.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentAnomalyDetectionServiceMethodDescriptorSupplier(
                              "GetAnalyzedSession"))
                      .build();
        }
      }
    }
    return getGetAnalyzedSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsRequest,
          com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsResponse>
      getListAnalyzedInvocationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAnalyzedInvocations",
      requestType = com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsRequest,
          com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsResponse>
      getListAnalyzedInvocationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsRequest,
            com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsResponse>
        getListAnalyzedInvocationsMethod;
    if ((getListAnalyzedInvocationsMethod =
            AgentAnomalyDetectionServiceGrpc.getListAnalyzedInvocationsMethod)
        == null) {
      synchronized (AgentAnomalyDetectionServiceGrpc.class) {
        if ((getListAnalyzedInvocationsMethod =
                AgentAnomalyDetectionServiceGrpc.getListAnalyzedInvocationsMethod)
            == null) {
          AgentAnomalyDetectionServiceGrpc.getListAnalyzedInvocationsMethod =
              getListAnalyzedInvocationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsRequest,
                          com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAnalyzedInvocations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentAnomalyDetectionServiceMethodDescriptorSupplier(
                              "ListAnalyzedInvocations"))
                      .build();
        }
      }
    }
    return getListAnalyzedInvocationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetAnalyzedInvocationRequest,
          com.google.cloud.aiplatform.v1.AnalyzedInvocation>
      getGetAnalyzedInvocationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAnalyzedInvocation",
      requestType = com.google.cloud.aiplatform.v1.GetAnalyzedInvocationRequest.class,
      responseType = com.google.cloud.aiplatform.v1.AnalyzedInvocation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetAnalyzedInvocationRequest,
          com.google.cloud.aiplatform.v1.AnalyzedInvocation>
      getGetAnalyzedInvocationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.GetAnalyzedInvocationRequest,
            com.google.cloud.aiplatform.v1.AnalyzedInvocation>
        getGetAnalyzedInvocationMethod;
    if ((getGetAnalyzedInvocationMethod =
            AgentAnomalyDetectionServiceGrpc.getGetAnalyzedInvocationMethod)
        == null) {
      synchronized (AgentAnomalyDetectionServiceGrpc.class) {
        if ((getGetAnalyzedInvocationMethod =
                AgentAnomalyDetectionServiceGrpc.getGetAnalyzedInvocationMethod)
            == null) {
          AgentAnomalyDetectionServiceGrpc.getGetAnalyzedInvocationMethod =
              getGetAnalyzedInvocationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.GetAnalyzedInvocationRequest,
                          com.google.cloud.aiplatform.v1.AnalyzedInvocation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetAnalyzedInvocation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.GetAnalyzedInvocationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.AnalyzedInvocation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentAnomalyDetectionServiceMethodDescriptorSupplier(
                              "GetAnalyzedInvocation"))
                      .build();
        }
      }
    }
    return getGetAnalyzedInvocationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsRequest,
          com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsResponse>
      getAggregateAnalyzedSessionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AggregateAnalyzedSessions",
      requestType = com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsRequest.class,
      responseType = com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsRequest,
          com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsResponse>
      getAggregateAnalyzedSessionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsRequest,
            com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsResponse>
        getAggregateAnalyzedSessionsMethod;
    if ((getAggregateAnalyzedSessionsMethod =
            AgentAnomalyDetectionServiceGrpc.getAggregateAnalyzedSessionsMethod)
        == null) {
      synchronized (AgentAnomalyDetectionServiceGrpc.class) {
        if ((getAggregateAnalyzedSessionsMethod =
                AgentAnomalyDetectionServiceGrpc.getAggregateAnalyzedSessionsMethod)
            == null) {
          AgentAnomalyDetectionServiceGrpc.getAggregateAnalyzedSessionsMethod =
              getAggregateAnalyzedSessionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsRequest,
                          com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "AggregateAnalyzedSessions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentAnomalyDetectionServiceMethodDescriptorSupplier(
                              "AggregateAnalyzedSessions"))
                      .build();
        }
      }
    }
    return getAggregateAnalyzedSessionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ClearTrainingDataRequest, com.google.longrunning.Operation>
      getClearTrainingDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ClearTrainingData",
      requestType = com.google.cloud.aiplatform.v1.ClearTrainingDataRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ClearTrainingDataRequest, com.google.longrunning.Operation>
      getClearTrainingDataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ClearTrainingDataRequest,
            com.google.longrunning.Operation>
        getClearTrainingDataMethod;
    if ((getClearTrainingDataMethod = AgentAnomalyDetectionServiceGrpc.getClearTrainingDataMethod)
        == null) {
      synchronized (AgentAnomalyDetectionServiceGrpc.class) {
        if ((getClearTrainingDataMethod =
                AgentAnomalyDetectionServiceGrpc.getClearTrainingDataMethod)
            == null) {
          AgentAnomalyDetectionServiceGrpc.getClearTrainingDataMethod =
              getClearTrainingDataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ClearTrainingDataRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ClearTrainingData"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ClearTrainingDataRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentAnomalyDetectionServiceMethodDescriptorSupplier(
                              "ClearTrainingData"))
                      .build();
        }
      }
    }
    return getClearTrainingDataMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AgentAnomalyDetectionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgentAnomalyDetectionServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AgentAnomalyDetectionServiceStub>() {
          @java.lang.Override
          public AgentAnomalyDetectionServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AgentAnomalyDetectionServiceStub(channel, callOptions);
          }
        };
    return AgentAnomalyDetectionServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static AgentAnomalyDetectionServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgentAnomalyDetectionServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AgentAnomalyDetectionServiceBlockingV2Stub>() {
          @java.lang.Override
          public AgentAnomalyDetectionServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AgentAnomalyDetectionServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return AgentAnomalyDetectionServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AgentAnomalyDetectionServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgentAnomalyDetectionServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AgentAnomalyDetectionServiceBlockingStub>() {
          @java.lang.Override
          public AgentAnomalyDetectionServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AgentAnomalyDetectionServiceBlockingStub(channel, callOptions);
          }
        };
    return AgentAnomalyDetectionServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AgentAnomalyDetectionServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgentAnomalyDetectionServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AgentAnomalyDetectionServiceFutureStub>() {
          @java.lang.Override
          public AgentAnomalyDetectionServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AgentAnomalyDetectionServiceFutureStub(channel, callOptions);
          }
        };
    return AgentAnomalyDetectionServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service for managing Agent Anomaly Detection for monitored agents.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets the details of a specific AgentAnomalyDetectionScope.
     * </pre>
     */
    default void getAgentAnomalyDetectionScope(
        com.google.cloud.aiplatform.v1.GetAgentAnomalyDetectionScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.AgentAnomalyDetectionScope>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAgentAnomalyDetectionScopeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific MonitoredAgent.
     * </pre>
     */
    default void getMonitoredAgent(
        com.google.cloud.aiplatform.v1.GetMonitoredAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.MonitoredAgent>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMonitoredAgentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists MonitoredAgents in a specific Location.
     * </pre>
     */
    default void listMonitoredAgents(
        com.google.cloud.aiplatform.v1.ListMonitoredAgentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListMonitoredAgentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMonitoredAgentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Enables a specific MonitoredAgent.
     * </pre>
     */
    default void enableMonitoredAgent(
        com.google.cloud.aiplatform.v1.EnableMonitoredAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getEnableMonitoredAgentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Disables a specific MonitoredAgent.
     * </pre>
     */
    default void disableMonitoredAgent(
        com.google.cloud.aiplatform.v1.DisableMonitoredAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDisableMonitoredAgentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific AgentAnomalyDetectionScope.
     * </pre>
     */
    default void deleteAgentAnomalyDetectionScope(
        com.google.cloud.aiplatform.v1.DeleteAgentAnomalyDetectionScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAgentAnomalyDetectionScopeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AgentAnomalyDetectionScope.
     * </pre>
     */
    default void createAgentAnomalyDetectionScope(
        com.google.cloud.aiplatform.v1.CreateAgentAnomalyDetectionScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAgentAnomalyDetectionScopeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists AgentAnomalyDetectionScopes in a Location.
     * </pre>
     */
    default void listAgentAnomalyDetectionScopes(
        com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAgentAnomalyDetectionScopesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists AnalyzedSessions in a MonitoredAgent.
     * </pre>
     */
    default void listAnalyzedSessions(
        com.google.cloud.aiplatform.v1.ListAnalyzedSessionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListAnalyzedSessionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAnalyzedSessionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific AnalyzedSession.
     * </pre>
     */
    default void getAnalyzedSession(
        com.google.cloud.aiplatform.v1.GetAnalyzedSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.AnalyzedSession>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAnalyzedSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists AnalyzedInvocations in a MonitoredAgent's AnalyzedSession.
     * </pre>
     */
    default void listAnalyzedInvocations(
        com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAnalyzedInvocationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific AnalyzedInvocation.
     * </pre>
     */
    default void getAnalyzedInvocation(
        com.google.cloud.aiplatform.v1.GetAnalyzedInvocationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.AnalyzedInvocation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAnalyzedInvocationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Aggregates AnalyzedSessions across MonitoredAgents.
     * To aggregate across all MonitoredAgents in a
     * location, use the following format for the parent field:
     * `projects/{project}/locations/{location}/monitoredAgents/-`
     * </pre>
     */
    default void aggregateAnalyzedSessions(
        com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAggregateAnalyzedSessionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Clears (purges) the trained model artifacts derived from a MonitoredAgent's
     * data. The purged model is rebuilt by the next scheduled training run.
     * To clear every MonitoredAgent in a location's scope, use the `-` wildcard
     * agent segment for the name field:
     * `projects/{project}/locations/{location}/monitoredAgents/-`
     * This is the on-demand data-deletion path for customers who have deleted the
     * underlying logs / observability data a model was trained on. It deletes
     * only the derived model artifacts (it does NOT delete the scope or stop
     * monitoring). To stop monitoring an agent entirely, disable it via
     * DisableMonitoredAgent.
     * </pre>
     */
    default void clearTrainingData(
        com.google.cloud.aiplatform.v1.ClearTrainingDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getClearTrainingDataMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AgentAnomalyDetectionService.
   *
   * <pre>
   * A service for managing Agent Anomaly Detection for monitored agents.
   * </pre>
   */
  public abstract static class AgentAnomalyDetectionServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AgentAnomalyDetectionServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AgentAnomalyDetectionService.
   *
   * <pre>
   * A service for managing Agent Anomaly Detection for monitored agents.
   * </pre>
   */
  public static final class AgentAnomalyDetectionServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AgentAnomalyDetectionServiceStub> {
    private AgentAnomalyDetectionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentAnomalyDetectionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgentAnomalyDetectionServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific AgentAnomalyDetectionScope.
     * </pre>
     */
    public void getAgentAnomalyDetectionScope(
        com.google.cloud.aiplatform.v1.GetAgentAnomalyDetectionScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.AgentAnomalyDetectionScope>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAgentAnomalyDetectionScopeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific MonitoredAgent.
     * </pre>
     */
    public void getMonitoredAgent(
        com.google.cloud.aiplatform.v1.GetMonitoredAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.MonitoredAgent>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMonitoredAgentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists MonitoredAgents in a specific Location.
     * </pre>
     */
    public void listMonitoredAgents(
        com.google.cloud.aiplatform.v1.ListMonitoredAgentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListMonitoredAgentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMonitoredAgentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Enables a specific MonitoredAgent.
     * </pre>
     */
    public void enableMonitoredAgent(
        com.google.cloud.aiplatform.v1.EnableMonitoredAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEnableMonitoredAgentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Disables a specific MonitoredAgent.
     * </pre>
     */
    public void disableMonitoredAgent(
        com.google.cloud.aiplatform.v1.DisableMonitoredAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDisableMonitoredAgentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific AgentAnomalyDetectionScope.
     * </pre>
     */
    public void deleteAgentAnomalyDetectionScope(
        com.google.cloud.aiplatform.v1.DeleteAgentAnomalyDetectionScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAgentAnomalyDetectionScopeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AgentAnomalyDetectionScope.
     * </pre>
     */
    public void createAgentAnomalyDetectionScope(
        com.google.cloud.aiplatform.v1.CreateAgentAnomalyDetectionScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAgentAnomalyDetectionScopeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists AgentAnomalyDetectionScopes in a Location.
     * </pre>
     */
    public void listAgentAnomalyDetectionScopes(
        com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAgentAnomalyDetectionScopesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists AnalyzedSessions in a MonitoredAgent.
     * </pre>
     */
    public void listAnalyzedSessions(
        com.google.cloud.aiplatform.v1.ListAnalyzedSessionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListAnalyzedSessionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAnalyzedSessionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific AnalyzedSession.
     * </pre>
     */
    public void getAnalyzedSession(
        com.google.cloud.aiplatform.v1.GetAnalyzedSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.AnalyzedSession>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAnalyzedSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists AnalyzedInvocations in a MonitoredAgent's AnalyzedSession.
     * </pre>
     */
    public void listAnalyzedInvocations(
        com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAnalyzedInvocationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific AnalyzedInvocation.
     * </pre>
     */
    public void getAnalyzedInvocation(
        com.google.cloud.aiplatform.v1.GetAnalyzedInvocationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.AnalyzedInvocation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAnalyzedInvocationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Aggregates AnalyzedSessions across MonitoredAgents.
     * To aggregate across all MonitoredAgents in a
     * location, use the following format for the parent field:
     * `projects/{project}/locations/{location}/monitoredAgents/-`
     * </pre>
     */
    public void aggregateAnalyzedSessions(
        com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAggregateAnalyzedSessionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Clears (purges) the trained model artifacts derived from a MonitoredAgent's
     * data. The purged model is rebuilt by the next scheduled training run.
     * To clear every MonitoredAgent in a location's scope, use the `-` wildcard
     * agent segment for the name field:
     * `projects/{project}/locations/{location}/monitoredAgents/-`
     * This is the on-demand data-deletion path for customers who have deleted the
     * underlying logs / observability data a model was trained on. It deletes
     * only the derived model artifacts (it does NOT delete the scope or stop
     * monitoring). To stop monitoring an agent entirely, disable it via
     * DisableMonitoredAgent.
     * </pre>
     */
    public void clearTrainingData(
        com.google.cloud.aiplatform.v1.ClearTrainingDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getClearTrainingDataMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AgentAnomalyDetectionService.
   *
   * <pre>
   * A service for managing Agent Anomaly Detection for monitored agents.
   * </pre>
   */
  public static final class AgentAnomalyDetectionServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<AgentAnomalyDetectionServiceBlockingV2Stub> {
    private AgentAnomalyDetectionServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentAnomalyDetectionServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgentAnomalyDetectionServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific AgentAnomalyDetectionScope.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.AgentAnomalyDetectionScope getAgentAnomalyDetectionScope(
        com.google.cloud.aiplatform.v1.GetAgentAnomalyDetectionScopeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAgentAnomalyDetectionScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific MonitoredAgent.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.MonitoredAgent getMonitoredAgent(
        com.google.cloud.aiplatform.v1.GetMonitoredAgentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetMonitoredAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists MonitoredAgents in a specific Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListMonitoredAgentsResponse listMonitoredAgents(
        com.google.cloud.aiplatform.v1.ListMonitoredAgentsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListMonitoredAgentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Enables a specific MonitoredAgent.
     * </pre>
     */
    public com.google.longrunning.Operation enableMonitoredAgent(
        com.google.cloud.aiplatform.v1.EnableMonitoredAgentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getEnableMonitoredAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Disables a specific MonitoredAgent.
     * </pre>
     */
    public com.google.longrunning.Operation disableMonitoredAgent(
        com.google.cloud.aiplatform.v1.DisableMonitoredAgentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDisableMonitoredAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific AgentAnomalyDetectionScope.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAgentAnomalyDetectionScope(
        com.google.cloud.aiplatform.v1.DeleteAgentAnomalyDetectionScopeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteAgentAnomalyDetectionScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AgentAnomalyDetectionScope.
     * </pre>
     */
    public com.google.longrunning.Operation createAgentAnomalyDetectionScope(
        com.google.cloud.aiplatform.v1.CreateAgentAnomalyDetectionScopeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateAgentAnomalyDetectionScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists AgentAnomalyDetectionScopes in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesResponse
        listAgentAnomalyDetectionScopes(
            com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAgentAnomalyDetectionScopesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists AnalyzedSessions in a MonitoredAgent.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListAnalyzedSessionsResponse listAnalyzedSessions(
        com.google.cloud.aiplatform.v1.ListAnalyzedSessionsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAnalyzedSessionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific AnalyzedSession.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.AnalyzedSession getAnalyzedSession(
        com.google.cloud.aiplatform.v1.GetAnalyzedSessionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAnalyzedSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists AnalyzedInvocations in a MonitoredAgent's AnalyzedSession.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsResponse listAnalyzedInvocations(
        com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAnalyzedInvocationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific AnalyzedInvocation.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.AnalyzedInvocation getAnalyzedInvocation(
        com.google.cloud.aiplatform.v1.GetAnalyzedInvocationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAnalyzedInvocationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Aggregates AnalyzedSessions across MonitoredAgents.
     * To aggregate across all MonitoredAgents in a
     * location, use the following format for the parent field:
     * `projects/{project}/locations/{location}/monitoredAgents/-`
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsResponse
        aggregateAnalyzedSessions(
            com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getAggregateAnalyzedSessionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Clears (purges) the trained model artifacts derived from a MonitoredAgent's
     * data. The purged model is rebuilt by the next scheduled training run.
     * To clear every MonitoredAgent in a location's scope, use the `-` wildcard
     * agent segment for the name field:
     * `projects/{project}/locations/{location}/monitoredAgents/-`
     * This is the on-demand data-deletion path for customers who have deleted the
     * underlying logs / observability data a model was trained on. It deletes
     * only the derived model artifacts (it does NOT delete the scope or stop
     * monitoring). To stop monitoring an agent entirely, disable it via
     * DisableMonitoredAgent.
     * </pre>
     */
    public com.google.longrunning.Operation clearTrainingData(
        com.google.cloud.aiplatform.v1.ClearTrainingDataRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getClearTrainingDataMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * AgentAnomalyDetectionService.
   *
   * <pre>
   * A service for managing Agent Anomaly Detection for monitored agents.
   * </pre>
   */
  public static final class AgentAnomalyDetectionServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AgentAnomalyDetectionServiceBlockingStub> {
    private AgentAnomalyDetectionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentAnomalyDetectionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgentAnomalyDetectionServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific AgentAnomalyDetectionScope.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.AgentAnomalyDetectionScope getAgentAnomalyDetectionScope(
        com.google.cloud.aiplatform.v1.GetAgentAnomalyDetectionScopeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAgentAnomalyDetectionScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific MonitoredAgent.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.MonitoredAgent getMonitoredAgent(
        com.google.cloud.aiplatform.v1.GetMonitoredAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMonitoredAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists MonitoredAgents in a specific Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListMonitoredAgentsResponse listMonitoredAgents(
        com.google.cloud.aiplatform.v1.ListMonitoredAgentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMonitoredAgentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Enables a specific MonitoredAgent.
     * </pre>
     */
    public com.google.longrunning.Operation enableMonitoredAgent(
        com.google.cloud.aiplatform.v1.EnableMonitoredAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEnableMonitoredAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Disables a specific MonitoredAgent.
     * </pre>
     */
    public com.google.longrunning.Operation disableMonitoredAgent(
        com.google.cloud.aiplatform.v1.DisableMonitoredAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDisableMonitoredAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific AgentAnomalyDetectionScope.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAgentAnomalyDetectionScope(
        com.google.cloud.aiplatform.v1.DeleteAgentAnomalyDetectionScopeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAgentAnomalyDetectionScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AgentAnomalyDetectionScope.
     * </pre>
     */
    public com.google.longrunning.Operation createAgentAnomalyDetectionScope(
        com.google.cloud.aiplatform.v1.CreateAgentAnomalyDetectionScopeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAgentAnomalyDetectionScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists AgentAnomalyDetectionScopes in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesResponse
        listAgentAnomalyDetectionScopes(
            com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAgentAnomalyDetectionScopesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists AnalyzedSessions in a MonitoredAgent.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListAnalyzedSessionsResponse listAnalyzedSessions(
        com.google.cloud.aiplatform.v1.ListAnalyzedSessionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAnalyzedSessionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific AnalyzedSession.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.AnalyzedSession getAnalyzedSession(
        com.google.cloud.aiplatform.v1.GetAnalyzedSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnalyzedSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists AnalyzedInvocations in a MonitoredAgent's AnalyzedSession.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsResponse listAnalyzedInvocations(
        com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAnalyzedInvocationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific AnalyzedInvocation.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.AnalyzedInvocation getAnalyzedInvocation(
        com.google.cloud.aiplatform.v1.GetAnalyzedInvocationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnalyzedInvocationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Aggregates AnalyzedSessions across MonitoredAgents.
     * To aggregate across all MonitoredAgents in a
     * location, use the following format for the parent field:
     * `projects/{project}/locations/{location}/monitoredAgents/-`
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsResponse
        aggregateAnalyzedSessions(
            com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAggregateAnalyzedSessionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Clears (purges) the trained model artifacts derived from a MonitoredAgent's
     * data. The purged model is rebuilt by the next scheduled training run.
     * To clear every MonitoredAgent in a location's scope, use the `-` wildcard
     * agent segment for the name field:
     * `projects/{project}/locations/{location}/monitoredAgents/-`
     * This is the on-demand data-deletion path for customers who have deleted the
     * underlying logs / observability data a model was trained on. It deletes
     * only the derived model artifacts (it does NOT delete the scope or stop
     * monitoring). To stop monitoring an agent entirely, disable it via
     * DisableMonitoredAgent.
     * </pre>
     */
    public com.google.longrunning.Operation clearTrainingData(
        com.google.cloud.aiplatform.v1.ClearTrainingDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getClearTrainingDataMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * AgentAnomalyDetectionService.
   *
   * <pre>
   * A service for managing Agent Anomaly Detection for monitored agents.
   * </pre>
   */
  public static final class AgentAnomalyDetectionServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AgentAnomalyDetectionServiceFutureStub> {
    private AgentAnomalyDetectionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentAnomalyDetectionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgentAnomalyDetectionServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific AgentAnomalyDetectionScope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.AgentAnomalyDetectionScope>
        getAgentAnomalyDetectionScope(
            com.google.cloud.aiplatform.v1.GetAgentAnomalyDetectionScopeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAgentAnomalyDetectionScopeMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific MonitoredAgent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.MonitoredAgent>
        getMonitoredAgent(com.google.cloud.aiplatform.v1.GetMonitoredAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMonitoredAgentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists MonitoredAgents in a specific Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.ListMonitoredAgentsResponse>
        listMonitoredAgents(com.google.cloud.aiplatform.v1.ListMonitoredAgentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMonitoredAgentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Enables a specific MonitoredAgent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        enableMonitoredAgent(com.google.cloud.aiplatform.v1.EnableMonitoredAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEnableMonitoredAgentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Disables a specific MonitoredAgent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        disableMonitoredAgent(com.google.cloud.aiplatform.v1.DisableMonitoredAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDisableMonitoredAgentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific AgentAnomalyDetectionScope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteAgentAnomalyDetectionScope(
            com.google.cloud.aiplatform.v1.DeleteAgentAnomalyDetectionScopeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAgentAnomalyDetectionScopeMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AgentAnomalyDetectionScope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createAgentAnomalyDetectionScope(
            com.google.cloud.aiplatform.v1.CreateAgentAnomalyDetectionScopeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAgentAnomalyDetectionScopeMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists AgentAnomalyDetectionScopes in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesResponse>
        listAgentAnomalyDetectionScopes(
            com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAgentAnomalyDetectionScopesMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists AnalyzedSessions in a MonitoredAgent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.ListAnalyzedSessionsResponse>
        listAnalyzedSessions(com.google.cloud.aiplatform.v1.ListAnalyzedSessionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAnalyzedSessionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific AnalyzedSession.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.AnalyzedSession>
        getAnalyzedSession(com.google.cloud.aiplatform.v1.GetAnalyzedSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAnalyzedSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists AnalyzedInvocations in a MonitoredAgent's AnalyzedSession.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsResponse>
        listAnalyzedInvocations(
            com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAnalyzedInvocationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific AnalyzedInvocation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.AnalyzedInvocation>
        getAnalyzedInvocation(com.google.cloud.aiplatform.v1.GetAnalyzedInvocationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAnalyzedInvocationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Aggregates AnalyzedSessions across MonitoredAgents.
     * To aggregate across all MonitoredAgents in a
     * location, use the following format for the parent field:
     * `projects/{project}/locations/{location}/monitoredAgents/-`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsResponse>
        aggregateAnalyzedSessions(
            com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAggregateAnalyzedSessionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Clears (purges) the trained model artifacts derived from a MonitoredAgent's
     * data. The purged model is rebuilt by the next scheduled training run.
     * To clear every MonitoredAgent in a location's scope, use the `-` wildcard
     * agent segment for the name field:
     * `projects/{project}/locations/{location}/monitoredAgents/-`
     * This is the on-demand data-deletion path for customers who have deleted the
     * underlying logs / observability data a model was trained on. It deletes
     * only the derived model artifacts (it does NOT delete the scope or stop
     * monitoring). To stop monitoring an agent entirely, disable it via
     * DisableMonitoredAgent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        clearTrainingData(com.google.cloud.aiplatform.v1.ClearTrainingDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getClearTrainingDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_AGENT_ANOMALY_DETECTION_SCOPE = 0;
  private static final int METHODID_GET_MONITORED_AGENT = 1;
  private static final int METHODID_LIST_MONITORED_AGENTS = 2;
  private static final int METHODID_ENABLE_MONITORED_AGENT = 3;
  private static final int METHODID_DISABLE_MONITORED_AGENT = 4;
  private static final int METHODID_DELETE_AGENT_ANOMALY_DETECTION_SCOPE = 5;
  private static final int METHODID_CREATE_AGENT_ANOMALY_DETECTION_SCOPE = 6;
  private static final int METHODID_LIST_AGENT_ANOMALY_DETECTION_SCOPES = 7;
  private static final int METHODID_LIST_ANALYZED_SESSIONS = 8;
  private static final int METHODID_GET_ANALYZED_SESSION = 9;
  private static final int METHODID_LIST_ANALYZED_INVOCATIONS = 10;
  private static final int METHODID_GET_ANALYZED_INVOCATION = 11;
  private static final int METHODID_AGGREGATE_ANALYZED_SESSIONS = 12;
  private static final int METHODID_CLEAR_TRAINING_DATA = 13;

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
        case METHODID_GET_AGENT_ANOMALY_DETECTION_SCOPE:
          serviceImpl.getAgentAnomalyDetectionScope(
              (com.google.cloud.aiplatform.v1.GetAgentAnomalyDetectionScopeRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1.AgentAnomalyDetectionScope>)
                  responseObserver);
          break;
        case METHODID_GET_MONITORED_AGENT:
          serviceImpl.getMonitoredAgent(
              (com.google.cloud.aiplatform.v1.GetMonitoredAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.MonitoredAgent>)
                  responseObserver);
          break;
        case METHODID_LIST_MONITORED_AGENTS:
          serviceImpl.listMonitoredAgents(
              (com.google.cloud.aiplatform.v1.ListMonitoredAgentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1.ListMonitoredAgentsResponse>)
                  responseObserver);
          break;
        case METHODID_ENABLE_MONITORED_AGENT:
          serviceImpl.enableMonitoredAgent(
              (com.google.cloud.aiplatform.v1.EnableMonitoredAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DISABLE_MONITORED_AGENT:
          serviceImpl.disableMonitoredAgent(
              (com.google.cloud.aiplatform.v1.DisableMonitoredAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_AGENT_ANOMALY_DETECTION_SCOPE:
          serviceImpl.deleteAgentAnomalyDetectionScope(
              (com.google.cloud.aiplatform.v1.DeleteAgentAnomalyDetectionScopeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_AGENT_ANOMALY_DETECTION_SCOPE:
          serviceImpl.createAgentAnomalyDetectionScope(
              (com.google.cloud.aiplatform.v1.CreateAgentAnomalyDetectionScopeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_AGENT_ANOMALY_DETECTION_SCOPES:
          serviceImpl.listAgentAnomalyDetectionScopes(
              (com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_ANALYZED_SESSIONS:
          serviceImpl.listAnalyzedSessions(
              (com.google.cloud.aiplatform.v1.ListAnalyzedSessionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1.ListAnalyzedSessionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ANALYZED_SESSION:
          serviceImpl.getAnalyzedSession(
              (com.google.cloud.aiplatform.v1.GetAnalyzedSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.AnalyzedSession>)
                  responseObserver);
          break;
        case METHODID_LIST_ANALYZED_INVOCATIONS:
          serviceImpl.listAnalyzedInvocations(
              (com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ANALYZED_INVOCATION:
          serviceImpl.getAnalyzedInvocation(
              (com.google.cloud.aiplatform.v1.GetAnalyzedInvocationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.AnalyzedInvocation>)
                  responseObserver);
          break;
        case METHODID_AGGREGATE_ANALYZED_SESSIONS:
          serviceImpl.aggregateAnalyzedSessions(
              (com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsResponse>)
                  responseObserver);
          break;
        case METHODID_CLEAR_TRAINING_DATA:
          serviceImpl.clearTrainingData(
              (com.google.cloud.aiplatform.v1.ClearTrainingDataRequest) request,
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
            getGetAgentAnomalyDetectionScopeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.GetAgentAnomalyDetectionScopeRequest,
                    com.google.cloud.aiplatform.v1.AgentAnomalyDetectionScope>(
                    service, METHODID_GET_AGENT_ANOMALY_DETECTION_SCOPE)))
        .addMethod(
            getGetMonitoredAgentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.GetMonitoredAgentRequest,
                    com.google.cloud.aiplatform.v1.MonitoredAgent>(
                    service, METHODID_GET_MONITORED_AGENT)))
        .addMethod(
            getListMonitoredAgentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.ListMonitoredAgentsRequest,
                    com.google.cloud.aiplatform.v1.ListMonitoredAgentsResponse>(
                    service, METHODID_LIST_MONITORED_AGENTS)))
        .addMethod(
            getEnableMonitoredAgentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.EnableMonitoredAgentRequest,
                    com.google.longrunning.Operation>(service, METHODID_ENABLE_MONITORED_AGENT)))
        .addMethod(
            getDisableMonitoredAgentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.DisableMonitoredAgentRequest,
                    com.google.longrunning.Operation>(service, METHODID_DISABLE_MONITORED_AGENT)))
        .addMethod(
            getDeleteAgentAnomalyDetectionScopeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.DeleteAgentAnomalyDetectionScopeRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_AGENT_ANOMALY_DETECTION_SCOPE)))
        .addMethod(
            getCreateAgentAnomalyDetectionScopeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.CreateAgentAnomalyDetectionScopeRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_AGENT_ANOMALY_DETECTION_SCOPE)))
        .addMethod(
            getListAgentAnomalyDetectionScopesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesRequest,
                    com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesResponse>(
                    service, METHODID_LIST_AGENT_ANOMALY_DETECTION_SCOPES)))
        .addMethod(
            getListAnalyzedSessionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.ListAnalyzedSessionsRequest,
                    com.google.cloud.aiplatform.v1.ListAnalyzedSessionsResponse>(
                    service, METHODID_LIST_ANALYZED_SESSIONS)))
        .addMethod(
            getGetAnalyzedSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.GetAnalyzedSessionRequest,
                    com.google.cloud.aiplatform.v1.AnalyzedSession>(
                    service, METHODID_GET_ANALYZED_SESSION)))
        .addMethod(
            getListAnalyzedInvocationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsRequest,
                    com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsResponse>(
                    service, METHODID_LIST_ANALYZED_INVOCATIONS)))
        .addMethod(
            getGetAnalyzedInvocationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.GetAnalyzedInvocationRequest,
                    com.google.cloud.aiplatform.v1.AnalyzedInvocation>(
                    service, METHODID_GET_ANALYZED_INVOCATION)))
        .addMethod(
            getAggregateAnalyzedSessionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsRequest,
                    com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsResponse>(
                    service, METHODID_AGGREGATE_ANALYZED_SESSIONS)))
        .addMethod(
            getClearTrainingDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.ClearTrainingDataRequest,
                    com.google.longrunning.Operation>(service, METHODID_CLEAR_TRAINING_DATA)))
        .build();
  }

  private abstract static class AgentAnomalyDetectionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AgentAnomalyDetectionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AgentAnomalyDetectionService");
    }
  }

  private static final class AgentAnomalyDetectionServiceFileDescriptorSupplier
      extends AgentAnomalyDetectionServiceBaseDescriptorSupplier {
    AgentAnomalyDetectionServiceFileDescriptorSupplier() {}
  }

  private static final class AgentAnomalyDetectionServiceMethodDescriptorSupplier
      extends AgentAnomalyDetectionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AgentAnomalyDetectionServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AgentAnomalyDetectionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AgentAnomalyDetectionServiceFileDescriptorSupplier())
                      .addMethod(getGetAgentAnomalyDetectionScopeMethod())
                      .addMethod(getGetMonitoredAgentMethod())
                      .addMethod(getListMonitoredAgentsMethod())
                      .addMethod(getEnableMonitoredAgentMethod())
                      .addMethod(getDisableMonitoredAgentMethod())
                      .addMethod(getDeleteAgentAnomalyDetectionScopeMethod())
                      .addMethod(getCreateAgentAnomalyDetectionScopeMethod())
                      .addMethod(getListAgentAnomalyDetectionScopesMethod())
                      .addMethod(getListAnalyzedSessionsMethod())
                      .addMethod(getGetAnalyzedSessionMethod())
                      .addMethod(getListAnalyzedInvocationsMethod())
                      .addMethod(getGetAnalyzedInvocationMethod())
                      .addMethod(getAggregateAnalyzedSessionsMethod())
                      .addMethod(getClearTrainingDataMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
