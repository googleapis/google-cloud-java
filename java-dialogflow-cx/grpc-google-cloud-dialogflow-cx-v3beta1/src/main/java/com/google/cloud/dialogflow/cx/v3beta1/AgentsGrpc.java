/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.dialogflow.cx.v3beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing [Agents][google.cloud.dialogflow.cx.v3beta1.Agent].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/cx/v3beta1/agent.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AgentsGrpc {

  private AgentsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.cx.v3beta1.Agents";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ListAgentsRequest,
          com.google.cloud.dialogflow.cx.v3beta1.ListAgentsResponse>
      getListAgentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAgents",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.ListAgentsRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.ListAgentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ListAgentsRequest,
          com.google.cloud.dialogflow.cx.v3beta1.ListAgentsResponse>
      getListAgentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.ListAgentsRequest,
            com.google.cloud.dialogflow.cx.v3beta1.ListAgentsResponse>
        getListAgentsMethod;
    if ((getListAgentsMethod = AgentsGrpc.getListAgentsMethod) == null) {
      synchronized (AgentsGrpc.class) {
        if ((getListAgentsMethod = AgentsGrpc.getListAgentsMethod) == null) {
          AgentsGrpc.getListAgentsMethod =
              getListAgentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.ListAgentsRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.ListAgentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAgents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ListAgentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ListAgentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AgentsMethodDescriptorSupplier("ListAgents"))
                      .build();
        }
      }
    }
    return getListAgentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.GetAgentRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Agent>
      getGetAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAgent",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.GetAgentRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.Agent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.GetAgentRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Agent>
      getGetAgentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.GetAgentRequest,
            com.google.cloud.dialogflow.cx.v3beta1.Agent>
        getGetAgentMethod;
    if ((getGetAgentMethod = AgentsGrpc.getGetAgentMethod) == null) {
      synchronized (AgentsGrpc.class) {
        if ((getGetAgentMethod = AgentsGrpc.getGetAgentMethod) == null) {
          AgentsGrpc.getGetAgentMethod =
              getGetAgentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.GetAgentRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.Agent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAgent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.GetAgentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.Agent.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentsMethodDescriptorSupplier("GetAgent"))
                      .build();
        }
      }
    }
    return getGetAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.CreateAgentRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Agent>
      getCreateAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAgent",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.CreateAgentRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.Agent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.CreateAgentRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Agent>
      getCreateAgentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.CreateAgentRequest,
            com.google.cloud.dialogflow.cx.v3beta1.Agent>
        getCreateAgentMethod;
    if ((getCreateAgentMethod = AgentsGrpc.getCreateAgentMethod) == null) {
      synchronized (AgentsGrpc.class) {
        if ((getCreateAgentMethod = AgentsGrpc.getCreateAgentMethod) == null) {
          AgentsGrpc.getCreateAgentMethod =
              getCreateAgentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.CreateAgentRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.Agent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAgent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.CreateAgentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.Agent.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentsMethodDescriptorSupplier("CreateAgent"))
                      .build();
        }
      }
    }
    return getCreateAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.UpdateAgentRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Agent>
      getUpdateAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAgent",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.UpdateAgentRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.Agent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.UpdateAgentRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Agent>
      getUpdateAgentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.UpdateAgentRequest,
            com.google.cloud.dialogflow.cx.v3beta1.Agent>
        getUpdateAgentMethod;
    if ((getUpdateAgentMethod = AgentsGrpc.getUpdateAgentMethod) == null) {
      synchronized (AgentsGrpc.class) {
        if ((getUpdateAgentMethod = AgentsGrpc.getUpdateAgentMethod) == null) {
          AgentsGrpc.getUpdateAgentMethod =
              getUpdateAgentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.UpdateAgentRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.Agent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAgent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.UpdateAgentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.Agent.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentsMethodDescriptorSupplier("UpdateAgent"))
                      .build();
        }
      }
    }
    return getUpdateAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.DeleteAgentRequest, com.google.protobuf.Empty>
      getDeleteAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAgent",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.DeleteAgentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.DeleteAgentRequest, com.google.protobuf.Empty>
      getDeleteAgentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.DeleteAgentRequest, com.google.protobuf.Empty>
        getDeleteAgentMethod;
    if ((getDeleteAgentMethod = AgentsGrpc.getDeleteAgentMethod) == null) {
      synchronized (AgentsGrpc.class) {
        if ((getDeleteAgentMethod = AgentsGrpc.getDeleteAgentMethod) == null) {
          AgentsGrpc.getDeleteAgentMethod =
              getDeleteAgentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.DeleteAgentRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAgent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.DeleteAgentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentsMethodDescriptorSupplier("DeleteAgent"))
                      .build();
        }
      }
    }
    return getDeleteAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ExportAgentRequest,
          com.google.longrunning.Operation>
      getExportAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportAgent",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.ExportAgentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ExportAgentRequest,
          com.google.longrunning.Operation>
      getExportAgentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.ExportAgentRequest,
            com.google.longrunning.Operation>
        getExportAgentMethod;
    if ((getExportAgentMethod = AgentsGrpc.getExportAgentMethod) == null) {
      synchronized (AgentsGrpc.class) {
        if ((getExportAgentMethod = AgentsGrpc.getExportAgentMethod) == null) {
          AgentsGrpc.getExportAgentMethod =
              getExportAgentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.ExportAgentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportAgent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ExportAgentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentsMethodDescriptorSupplier("ExportAgent"))
                      .build();
        }
      }
    }
    return getExportAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.RestoreAgentRequest,
          com.google.longrunning.Operation>
      getRestoreAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestoreAgent",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.RestoreAgentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.RestoreAgentRequest,
          com.google.longrunning.Operation>
      getRestoreAgentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.RestoreAgentRequest,
            com.google.longrunning.Operation>
        getRestoreAgentMethod;
    if ((getRestoreAgentMethod = AgentsGrpc.getRestoreAgentMethod) == null) {
      synchronized (AgentsGrpc.class) {
        if ((getRestoreAgentMethod = AgentsGrpc.getRestoreAgentMethod) == null) {
          AgentsGrpc.getRestoreAgentMethod =
              getRestoreAgentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.RestoreAgentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RestoreAgent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.RestoreAgentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AgentsMethodDescriptorSupplier("RestoreAgent"))
                      .build();
        }
      }
    }
    return getRestoreAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ValidateAgentRequest,
          com.google.cloud.dialogflow.cx.v3beta1.AgentValidationResult>
      getValidateAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateAgent",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.ValidateAgentRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.AgentValidationResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ValidateAgentRequest,
          com.google.cloud.dialogflow.cx.v3beta1.AgentValidationResult>
      getValidateAgentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.ValidateAgentRequest,
            com.google.cloud.dialogflow.cx.v3beta1.AgentValidationResult>
        getValidateAgentMethod;
    if ((getValidateAgentMethod = AgentsGrpc.getValidateAgentMethod) == null) {
      synchronized (AgentsGrpc.class) {
        if ((getValidateAgentMethod = AgentsGrpc.getValidateAgentMethod) == null) {
          AgentsGrpc.getValidateAgentMethod =
              getValidateAgentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.ValidateAgentRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.AgentValidationResult>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateAgent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ValidateAgentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.AgentValidationResult
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AgentsMethodDescriptorSupplier("ValidateAgent"))
                      .build();
        }
      }
    }
    return getValidateAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.GetAgentValidationResultRequest,
          com.google.cloud.dialogflow.cx.v3beta1.AgentValidationResult>
      getGetAgentValidationResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAgentValidationResult",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.GetAgentValidationResultRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.AgentValidationResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.GetAgentValidationResultRequest,
          com.google.cloud.dialogflow.cx.v3beta1.AgentValidationResult>
      getGetAgentValidationResultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.GetAgentValidationResultRequest,
            com.google.cloud.dialogflow.cx.v3beta1.AgentValidationResult>
        getGetAgentValidationResultMethod;
    if ((getGetAgentValidationResultMethod = AgentsGrpc.getGetAgentValidationResultMethod)
        == null) {
      synchronized (AgentsGrpc.class) {
        if ((getGetAgentValidationResultMethod = AgentsGrpc.getGetAgentValidationResultMethod)
            == null) {
          AgentsGrpc.getGetAgentValidationResultMethod =
              getGetAgentValidationResultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.GetAgentValidationResultRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.AgentValidationResult>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetAgentValidationResult"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.GetAgentValidationResultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.AgentValidationResult
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AgentsMethodDescriptorSupplier("GetAgentValidationResult"))
                      .build();
        }
      }
    }
    return getGetAgentValidationResultMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AgentsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgentsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AgentsStub>() {
          @java.lang.Override
          public AgentsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AgentsStub(channel, callOptions);
          }
        };
    return AgentsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AgentsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgentsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AgentsBlockingStub>() {
          @java.lang.Override
          public AgentsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AgentsBlockingStub(channel, callOptions);
          }
        };
    return AgentsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AgentsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgentsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AgentsFutureStub>() {
          @java.lang.Override
          public AgentsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AgentsFutureStub(channel, callOptions);
          }
        };
    return AgentsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Agents][google.cloud.dialogflow.cx.v3beta1.Agent].
   * </pre>
   */
  public abstract static class AgentsImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Returns the list of all agents in the specified location.
     * </pre>
     */
    public void listAgents(
        com.google.cloud.dialogflow.cx.v3beta1.ListAgentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.ListAgentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAgentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified agent.
     * </pre>
     */
    public void getAgent(
        com.google.cloud.dialogflow.cx.v3beta1.GetAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Agent>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAgentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an agent in the specified location.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void createAgent(
        com.google.cloud.dialogflow.cx.v3beta1.CreateAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Agent>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAgentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified agent.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void updateAgent(
        com.google.cloud.dialogflow.cx.v3beta1.UpdateAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Agent>
            responseObserver) {
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
    public void deleteAgent(
        com.google.cloud.dialogflow.cx.v3beta1.DeleteAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAgentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports the specified agent to a binary file.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: [ExportAgentResponse][google.cloud.dialogflow.cx.v3beta1.ExportAgentResponse]
     * </pre>
     */
    public void exportAgent(
        com.google.cloud.dialogflow.cx.v3beta1.ExportAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportAgentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restores the specified agent from a binary file.
     * Replaces the current agent with a new one. Note that all existing resources
     * in agent (e.g. intents, entity types, flows) will be removed.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void restoreAgent(
        com.google.cloud.dialogflow.cx.v3beta1.RestoreAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRestoreAgentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Validates the specified agent and creates or updates validation results.
     * The agent in draft version is validated. Please call this API after the
     * training is completed to get the complete validation results.
     * </pre>
     */
    public void validateAgent(
        com.google.cloud.dialogflow.cx.v3beta1.ValidateAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.AgentValidationResult>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getValidateAgentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the latest agent validation result. Agent validation is performed
     * when ValidateAgent is called.
     * </pre>
     */
    public void getAgentValidationResult(
        com.google.cloud.dialogflow.cx.v3beta1.GetAgentValidationResultRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.AgentValidationResult>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAgentValidationResultMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListAgentsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.ListAgentsRequest,
                      com.google.cloud.dialogflow.cx.v3beta1.ListAgentsResponse>(
                      this, METHODID_LIST_AGENTS)))
          .addMethod(
              getGetAgentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.GetAgentRequest,
                      com.google.cloud.dialogflow.cx.v3beta1.Agent>(this, METHODID_GET_AGENT)))
          .addMethod(
              getCreateAgentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.CreateAgentRequest,
                      com.google.cloud.dialogflow.cx.v3beta1.Agent>(this, METHODID_CREATE_AGENT)))
          .addMethod(
              getUpdateAgentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.UpdateAgentRequest,
                      com.google.cloud.dialogflow.cx.v3beta1.Agent>(this, METHODID_UPDATE_AGENT)))
          .addMethod(
              getDeleteAgentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.DeleteAgentRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_AGENT)))
          .addMethod(
              getExportAgentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.ExportAgentRequest,
                      com.google.longrunning.Operation>(this, METHODID_EXPORT_AGENT)))
          .addMethod(
              getRestoreAgentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.RestoreAgentRequest,
                      com.google.longrunning.Operation>(this, METHODID_RESTORE_AGENT)))
          .addMethod(
              getValidateAgentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.ValidateAgentRequest,
                      com.google.cloud.dialogflow.cx.v3beta1.AgentValidationResult>(
                      this, METHODID_VALIDATE_AGENT)))
          .addMethod(
              getGetAgentValidationResultMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.GetAgentValidationResultRequest,
                      com.google.cloud.dialogflow.cx.v3beta1.AgentValidationResult>(
                      this, METHODID_GET_AGENT_VALIDATION_RESULT)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Agents][google.cloud.dialogflow.cx.v3beta1.Agent].
   * </pre>
   */
  public static final class AgentsStub extends io.grpc.stub.AbstractAsyncStub<AgentsStub> {
    private AgentsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgentsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all agents in the specified location.
     * </pre>
     */
    public void listAgents(
        com.google.cloud.dialogflow.cx.v3beta1.ListAgentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.ListAgentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAgentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified agent.
     * </pre>
     */
    public void getAgent(
        com.google.cloud.dialogflow.cx.v3beta1.GetAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Agent>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAgentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an agent in the specified location.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void createAgent(
        com.google.cloud.dialogflow.cx.v3beta1.CreateAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Agent>
            responseObserver) {
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
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void updateAgent(
        com.google.cloud.dialogflow.cx.v3beta1.UpdateAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Agent>
            responseObserver) {
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
        com.google.cloud.dialogflow.cx.v3beta1.DeleteAgentRequest request,
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
     * Exports the specified agent to a binary file.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: [ExportAgentResponse][google.cloud.dialogflow.cx.v3beta1.ExportAgentResponse]
     * </pre>
     */
    public void exportAgent(
        com.google.cloud.dialogflow.cx.v3beta1.ExportAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportAgentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restores the specified agent from a binary file.
     * Replaces the current agent with a new one. Note that all existing resources
     * in agent (e.g. intents, entity types, flows) will be removed.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void restoreAgent(
        com.google.cloud.dialogflow.cx.v3beta1.RestoreAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestoreAgentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Validates the specified agent and creates or updates validation results.
     * The agent in draft version is validated. Please call this API after the
     * training is completed to get the complete validation results.
     * </pre>
     */
    public void validateAgent(
        com.google.cloud.dialogflow.cx.v3beta1.ValidateAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.AgentValidationResult>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateAgentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the latest agent validation result. Agent validation is performed
     * when ValidateAgent is called.
     * </pre>
     */
    public void getAgentValidationResult(
        com.google.cloud.dialogflow.cx.v3beta1.GetAgentValidationResultRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.AgentValidationResult>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAgentValidationResultMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Agents][google.cloud.dialogflow.cx.v3beta1.Agent].
   * </pre>
   */
  public static final class AgentsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AgentsBlockingStub> {
    private AgentsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentsBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgentsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all agents in the specified location.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.ListAgentsResponse listAgents(
        com.google.cloud.dialogflow.cx.v3beta1.ListAgentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAgentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.Agent getAgent(
        com.google.cloud.dialogflow.cx.v3beta1.GetAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an agent in the specified location.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.Agent createAgent(
        com.google.cloud.dialogflow.cx.v3beta1.CreateAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified agent.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.Agent updateAgent(
        com.google.cloud.dialogflow.cx.v3beta1.UpdateAgentRequest request) {
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
        com.google.cloud.dialogflow.cx.v3beta1.DeleteAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports the specified agent to a binary file.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: [ExportAgentResponse][google.cloud.dialogflow.cx.v3beta1.ExportAgentResponse]
     * </pre>
     */
    public com.google.longrunning.Operation exportAgent(
        com.google.cloud.dialogflow.cx.v3beta1.ExportAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restores the specified agent from a binary file.
     * Replaces the current agent with a new one. Note that all existing resources
     * in agent (e.g. intents, entity types, flows) will be removed.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.longrunning.Operation restoreAgent(
        com.google.cloud.dialogflow.cx.v3beta1.RestoreAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestoreAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Validates the specified agent and creates or updates validation results.
     * The agent in draft version is validated. Please call this API after the
     * training is completed to get the complete validation results.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.AgentValidationResult validateAgent(
        com.google.cloud.dialogflow.cx.v3beta1.ValidateAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the latest agent validation result. Agent validation is performed
     * when ValidateAgent is called.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.AgentValidationResult getAgentValidationResult(
        com.google.cloud.dialogflow.cx.v3beta1.GetAgentValidationResultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAgentValidationResultMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Agents][google.cloud.dialogflow.cx.v3beta1.Agent].
   * </pre>
   */
  public static final class AgentsFutureStub
      extends io.grpc.stub.AbstractFutureStub<AgentsFutureStub> {
    private AgentsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentsFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgentsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all agents in the specified location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.ListAgentsResponse>
        listAgents(com.google.cloud.dialogflow.cx.v3beta1.ListAgentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAgentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.Agent>
        getAgent(com.google.cloud.dialogflow.cx.v3beta1.GetAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAgentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an agent in the specified location.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.Agent>
        createAgent(com.google.cloud.dialogflow.cx.v3beta1.CreateAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAgentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified agent.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.Agent>
        updateAgent(com.google.cloud.dialogflow.cx.v3beta1.UpdateAgentRequest request) {
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
        deleteAgent(com.google.cloud.dialogflow.cx.v3beta1.DeleteAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAgentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports the specified agent to a binary file.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: [ExportAgentResponse][google.cloud.dialogflow.cx.v3beta1.ExportAgentResponse]
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportAgent(com.google.cloud.dialogflow.cx.v3beta1.ExportAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportAgentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Restores the specified agent from a binary file.
     * Replaces the current agent with a new one. Note that all existing resources
     * in agent (e.g. intents, entity types, flows) will be removed.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        restoreAgent(com.google.cloud.dialogflow.cx.v3beta1.RestoreAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestoreAgentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Validates the specified agent and creates or updates validation results.
     * The agent in draft version is validated. Please call this API after the
     * training is completed to get the complete validation results.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.AgentValidationResult>
        validateAgent(com.google.cloud.dialogflow.cx.v3beta1.ValidateAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateAgentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the latest agent validation result. Agent validation is performed
     * when ValidateAgent is called.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.AgentValidationResult>
        getAgentValidationResult(
            com.google.cloud.dialogflow.cx.v3beta1.GetAgentValidationResultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAgentValidationResultMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_AGENTS = 0;
  private static final int METHODID_GET_AGENT = 1;
  private static final int METHODID_CREATE_AGENT = 2;
  private static final int METHODID_UPDATE_AGENT = 3;
  private static final int METHODID_DELETE_AGENT = 4;
  private static final int METHODID_EXPORT_AGENT = 5;
  private static final int METHODID_RESTORE_AGENT = 6;
  private static final int METHODID_VALIDATE_AGENT = 7;
  private static final int METHODID_GET_AGENT_VALIDATION_RESULT = 8;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AgentsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AgentsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_AGENTS:
          serviceImpl.listAgents(
              (com.google.cloud.dialogflow.cx.v3beta1.ListAgentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.cx.v3beta1.ListAgentsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_AGENT:
          serviceImpl.getAgent(
              (com.google.cloud.dialogflow.cx.v3beta1.GetAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Agent>)
                  responseObserver);
          break;
        case METHODID_CREATE_AGENT:
          serviceImpl.createAgent(
              (com.google.cloud.dialogflow.cx.v3beta1.CreateAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Agent>)
                  responseObserver);
          break;
        case METHODID_UPDATE_AGENT:
          serviceImpl.updateAgent(
              (com.google.cloud.dialogflow.cx.v3beta1.UpdateAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Agent>)
                  responseObserver);
          break;
        case METHODID_DELETE_AGENT:
          serviceImpl.deleteAgent(
              (com.google.cloud.dialogflow.cx.v3beta1.DeleteAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_EXPORT_AGENT:
          serviceImpl.exportAgent(
              (com.google.cloud.dialogflow.cx.v3beta1.ExportAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESTORE_AGENT:
          serviceImpl.restoreAgent(
              (com.google.cloud.dialogflow.cx.v3beta1.RestoreAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_VALIDATE_AGENT:
          serviceImpl.validateAgent(
              (com.google.cloud.dialogflow.cx.v3beta1.ValidateAgentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.cx.v3beta1.AgentValidationResult>)
                  responseObserver);
          break;
        case METHODID_GET_AGENT_VALIDATION_RESULT:
          serviceImpl.getAgentValidationResult(
              (com.google.cloud.dialogflow.cx.v3beta1.GetAgentValidationResultRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.cx.v3beta1.AgentValidationResult>)
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

  private abstract static class AgentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AgentsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.cx.v3beta1.AgentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Agents");
    }
  }

  private static final class AgentsFileDescriptorSupplier extends AgentsBaseDescriptorSupplier {
    AgentsFileDescriptorSupplier() {}
  }

  private static final class AgentsMethodDescriptorSupplier extends AgentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AgentsMethodDescriptorSupplier(String methodName) {
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
      synchronized (AgentsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AgentsFileDescriptorSupplier())
                      .addMethod(getListAgentsMethod())
                      .addMethod(getGetAgentMethod())
                      .addMethod(getCreateAgentMethod())
                      .addMethod(getUpdateAgentMethod())
                      .addMethod(getDeleteAgentMethod())
                      .addMethod(getExportAgentMethod())
                      .addMethod(getRestoreAgentMethod())
                      .addMethod(getValidateAgentMethod())
                      .addMethod(getGetAgentValidationResultMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
