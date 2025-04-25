/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.dialogflow.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing [Environments][google.cloud.dialogflow.v2.Environment].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/v2/environment.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EnvironmentsGrpc {

  private EnvironmentsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.dialogflow.v2.Environments";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.ListEnvironmentsRequest,
          com.google.cloud.dialogflow.v2.ListEnvironmentsResponse>
      getListEnvironmentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEnvironments",
      requestType = com.google.cloud.dialogflow.v2.ListEnvironmentsRequest.class,
      responseType = com.google.cloud.dialogflow.v2.ListEnvironmentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.ListEnvironmentsRequest,
          com.google.cloud.dialogflow.v2.ListEnvironmentsResponse>
      getListEnvironmentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.ListEnvironmentsRequest,
            com.google.cloud.dialogflow.v2.ListEnvironmentsResponse>
        getListEnvironmentsMethod;
    if ((getListEnvironmentsMethod = EnvironmentsGrpc.getListEnvironmentsMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getListEnvironmentsMethod = EnvironmentsGrpc.getListEnvironmentsMethod) == null) {
          EnvironmentsGrpc.getListEnvironmentsMethod =
              getListEnvironmentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.ListEnvironmentsRequest,
                          com.google.cloud.dialogflow.v2.ListEnvironmentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEnvironments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.ListEnvironmentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.ListEnvironmentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EnvironmentsMethodDescriptorSupplier("ListEnvironments"))
                      .build();
        }
      }
    }
    return getListEnvironmentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GetEnvironmentRequest,
          com.google.cloud.dialogflow.v2.Environment>
      getGetEnvironmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEnvironment",
      requestType = com.google.cloud.dialogflow.v2.GetEnvironmentRequest.class,
      responseType = com.google.cloud.dialogflow.v2.Environment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GetEnvironmentRequest,
          com.google.cloud.dialogflow.v2.Environment>
      getGetEnvironmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.GetEnvironmentRequest,
            com.google.cloud.dialogflow.v2.Environment>
        getGetEnvironmentMethod;
    if ((getGetEnvironmentMethod = EnvironmentsGrpc.getGetEnvironmentMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getGetEnvironmentMethod = EnvironmentsGrpc.getGetEnvironmentMethod) == null) {
          EnvironmentsGrpc.getGetEnvironmentMethod =
              getGetEnvironmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.GetEnvironmentRequest,
                          com.google.cloud.dialogflow.v2.Environment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEnvironment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.GetEnvironmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.Environment.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EnvironmentsMethodDescriptorSupplier("GetEnvironment"))
                      .build();
        }
      }
    }
    return getGetEnvironmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.CreateEnvironmentRequest,
          com.google.cloud.dialogflow.v2.Environment>
      getCreateEnvironmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEnvironment",
      requestType = com.google.cloud.dialogflow.v2.CreateEnvironmentRequest.class,
      responseType = com.google.cloud.dialogflow.v2.Environment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.CreateEnvironmentRequest,
          com.google.cloud.dialogflow.v2.Environment>
      getCreateEnvironmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.CreateEnvironmentRequest,
            com.google.cloud.dialogflow.v2.Environment>
        getCreateEnvironmentMethod;
    if ((getCreateEnvironmentMethod = EnvironmentsGrpc.getCreateEnvironmentMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getCreateEnvironmentMethod = EnvironmentsGrpc.getCreateEnvironmentMethod) == null) {
          EnvironmentsGrpc.getCreateEnvironmentMethod =
              getCreateEnvironmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.CreateEnvironmentRequest,
                          com.google.cloud.dialogflow.v2.Environment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEnvironment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.CreateEnvironmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.Environment.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EnvironmentsMethodDescriptorSupplier("CreateEnvironment"))
                      .build();
        }
      }
    }
    return getCreateEnvironmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.UpdateEnvironmentRequest,
          com.google.cloud.dialogflow.v2.Environment>
      getUpdateEnvironmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEnvironment",
      requestType = com.google.cloud.dialogflow.v2.UpdateEnvironmentRequest.class,
      responseType = com.google.cloud.dialogflow.v2.Environment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.UpdateEnvironmentRequest,
          com.google.cloud.dialogflow.v2.Environment>
      getUpdateEnvironmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.UpdateEnvironmentRequest,
            com.google.cloud.dialogflow.v2.Environment>
        getUpdateEnvironmentMethod;
    if ((getUpdateEnvironmentMethod = EnvironmentsGrpc.getUpdateEnvironmentMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getUpdateEnvironmentMethod = EnvironmentsGrpc.getUpdateEnvironmentMethod) == null) {
          EnvironmentsGrpc.getUpdateEnvironmentMethod =
              getUpdateEnvironmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.UpdateEnvironmentRequest,
                          com.google.cloud.dialogflow.v2.Environment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEnvironment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.UpdateEnvironmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.Environment.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EnvironmentsMethodDescriptorSupplier("UpdateEnvironment"))
                      .build();
        }
      }
    }
    return getUpdateEnvironmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DeleteEnvironmentRequest, com.google.protobuf.Empty>
      getDeleteEnvironmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEnvironment",
      requestType = com.google.cloud.dialogflow.v2.DeleteEnvironmentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DeleteEnvironmentRequest, com.google.protobuf.Empty>
      getDeleteEnvironmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.DeleteEnvironmentRequest, com.google.protobuf.Empty>
        getDeleteEnvironmentMethod;
    if ((getDeleteEnvironmentMethod = EnvironmentsGrpc.getDeleteEnvironmentMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getDeleteEnvironmentMethod = EnvironmentsGrpc.getDeleteEnvironmentMethod) == null) {
          EnvironmentsGrpc.getDeleteEnvironmentMethod =
              getDeleteEnvironmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.DeleteEnvironmentRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEnvironment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.DeleteEnvironmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EnvironmentsMethodDescriptorSupplier("DeleteEnvironment"))
                      .build();
        }
      }
    }
    return getDeleteEnvironmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GetEnvironmentHistoryRequest,
          com.google.cloud.dialogflow.v2.EnvironmentHistory>
      getGetEnvironmentHistoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEnvironmentHistory",
      requestType = com.google.cloud.dialogflow.v2.GetEnvironmentHistoryRequest.class,
      responseType = com.google.cloud.dialogflow.v2.EnvironmentHistory.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GetEnvironmentHistoryRequest,
          com.google.cloud.dialogflow.v2.EnvironmentHistory>
      getGetEnvironmentHistoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.GetEnvironmentHistoryRequest,
            com.google.cloud.dialogflow.v2.EnvironmentHistory>
        getGetEnvironmentHistoryMethod;
    if ((getGetEnvironmentHistoryMethod = EnvironmentsGrpc.getGetEnvironmentHistoryMethod)
        == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getGetEnvironmentHistoryMethod = EnvironmentsGrpc.getGetEnvironmentHistoryMethod)
            == null) {
          EnvironmentsGrpc.getGetEnvironmentHistoryMethod =
              getGetEnvironmentHistoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.GetEnvironmentHistoryRequest,
                          com.google.cloud.dialogflow.v2.EnvironmentHistory>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetEnvironmentHistory"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.GetEnvironmentHistoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.EnvironmentHistory
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EnvironmentsMethodDescriptorSupplier("GetEnvironmentHistory"))
                      .build();
        }
      }
    }
    return getGetEnvironmentHistoryMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static EnvironmentsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnvironmentsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EnvironmentsStub>() {
          @java.lang.Override
          public EnvironmentsStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EnvironmentsStub(channel, callOptions);
          }
        };
    return EnvironmentsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EnvironmentsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnvironmentsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EnvironmentsBlockingStub>() {
          @java.lang.Override
          public EnvironmentsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EnvironmentsBlockingStub(channel, callOptions);
          }
        };
    return EnvironmentsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static EnvironmentsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnvironmentsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EnvironmentsFutureStub>() {
          @java.lang.Override
          public EnvironmentsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EnvironmentsFutureStub(channel, callOptions);
          }
        };
    return EnvironmentsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Environments][google.cloud.dialogflow.v2.Environment].
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Returns the list of all non-default environments of the specified agent.
     * </pre>
     */
    default void listEnvironments(
        com.google.cloud.dialogflow.v2.ListEnvironmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListEnvironmentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEnvironmentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified agent environment.
     * </pre>
     */
    default void getEnvironment(
        com.google.cloud.dialogflow.v2.GetEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Environment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEnvironmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an agent environment.
     * </pre>
     */
    default void createEnvironment(
        com.google.cloud.dialogflow.v2.CreateEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Environment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEnvironmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified agent environment.
     * This method allows you to deploy new agent versions into the environment.
     * When an environment is pointed to a new agent version by setting
     * `environment.agent_version`, the environment is temporarily set to the
     * `LOADING` state. During that time, the environment continues serving the
     * previous version of the agent. After the new agent version is done loading,
     * the environment is set back to the `RUNNING` state.
     * You can use "-" as Environment ID in environment name to update an agent
     * version in the default environment. WARNING: this will negate all recent
     * changes to the draft agent and can't be undone. You may want to save the
     * draft agent to a version before calling this method.
     * </pre>
     */
    default void updateEnvironment(
        com.google.cloud.dialogflow.v2.UpdateEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Environment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEnvironmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified agent environment.
     * </pre>
     */
    default void deleteEnvironment(
        com.google.cloud.dialogflow.v2.DeleteEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEnvironmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the history of the specified environment.
     * </pre>
     */
    default void getEnvironmentHistory(
        com.google.cloud.dialogflow.v2.GetEnvironmentHistoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.EnvironmentHistory>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEnvironmentHistoryMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Environments.
   *
   * <pre>
   * Service for managing [Environments][google.cloud.dialogflow.v2.Environment].
   * </pre>
   */
  public abstract static class EnvironmentsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return EnvironmentsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Environments.
   *
   * <pre>
   * Service for managing [Environments][google.cloud.dialogflow.v2.Environment].
   * </pre>
   */
  public static final class EnvironmentsStub
      extends io.grpc.stub.AbstractAsyncStub<EnvironmentsStub> {
    private EnvironmentsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnvironmentsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnvironmentsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all non-default environments of the specified agent.
     * </pre>
     */
    public void listEnvironments(
        com.google.cloud.dialogflow.v2.ListEnvironmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListEnvironmentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEnvironmentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified agent environment.
     * </pre>
     */
    public void getEnvironment(
        com.google.cloud.dialogflow.v2.GetEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Environment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEnvironmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an agent environment.
     * </pre>
     */
    public void createEnvironment(
        com.google.cloud.dialogflow.v2.CreateEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Environment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEnvironmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified agent environment.
     * This method allows you to deploy new agent versions into the environment.
     * When an environment is pointed to a new agent version by setting
     * `environment.agent_version`, the environment is temporarily set to the
     * `LOADING` state. During that time, the environment continues serving the
     * previous version of the agent. After the new agent version is done loading,
     * the environment is set back to the `RUNNING` state.
     * You can use "-" as Environment ID in environment name to update an agent
     * version in the default environment. WARNING: this will negate all recent
     * changes to the draft agent and can't be undone. You may want to save the
     * draft agent to a version before calling this method.
     * </pre>
     */
    public void updateEnvironment(
        com.google.cloud.dialogflow.v2.UpdateEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Environment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEnvironmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified agent environment.
     * </pre>
     */
    public void deleteEnvironment(
        com.google.cloud.dialogflow.v2.DeleteEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEnvironmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the history of the specified environment.
     * </pre>
     */
    public void getEnvironmentHistory(
        com.google.cloud.dialogflow.v2.GetEnvironmentHistoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.EnvironmentHistory>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEnvironmentHistoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Environments.
   *
   * <pre>
   * Service for managing [Environments][google.cloud.dialogflow.v2.Environment].
   * </pre>
   */
  public static final class EnvironmentsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EnvironmentsBlockingStub> {
    private EnvironmentsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnvironmentsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnvironmentsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all non-default environments of the specified agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.ListEnvironmentsResponse listEnvironments(
        com.google.cloud.dialogflow.v2.ListEnvironmentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEnvironmentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified agent environment.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.Environment getEnvironment(
        com.google.cloud.dialogflow.v2.GetEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEnvironmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an agent environment.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.Environment createEnvironment(
        com.google.cloud.dialogflow.v2.CreateEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEnvironmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified agent environment.
     * This method allows you to deploy new agent versions into the environment.
     * When an environment is pointed to a new agent version by setting
     * `environment.agent_version`, the environment is temporarily set to the
     * `LOADING` state. During that time, the environment continues serving the
     * previous version of the agent. After the new agent version is done loading,
     * the environment is set back to the `RUNNING` state.
     * You can use "-" as Environment ID in environment name to update an agent
     * version in the default environment. WARNING: this will negate all recent
     * changes to the draft agent and can't be undone. You may want to save the
     * draft agent to a version before calling this method.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.Environment updateEnvironment(
        com.google.cloud.dialogflow.v2.UpdateEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEnvironmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified agent environment.
     * </pre>
     */
    public com.google.protobuf.Empty deleteEnvironment(
        com.google.cloud.dialogflow.v2.DeleteEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEnvironmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the history of the specified environment.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.EnvironmentHistory getEnvironmentHistory(
        com.google.cloud.dialogflow.v2.GetEnvironmentHistoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEnvironmentHistoryMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Environments.
   *
   * <pre>
   * Service for managing [Environments][google.cloud.dialogflow.v2.Environment].
   * </pre>
   */
  public static final class EnvironmentsFutureStub
      extends io.grpc.stub.AbstractFutureStub<EnvironmentsFutureStub> {
    private EnvironmentsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnvironmentsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnvironmentsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all non-default environments of the specified agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.ListEnvironmentsResponse>
        listEnvironments(com.google.cloud.dialogflow.v2.ListEnvironmentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEnvironmentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified agent environment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.Environment>
        getEnvironment(com.google.cloud.dialogflow.v2.GetEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEnvironmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an agent environment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.Environment>
        createEnvironment(com.google.cloud.dialogflow.v2.CreateEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEnvironmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified agent environment.
     * This method allows you to deploy new agent versions into the environment.
     * When an environment is pointed to a new agent version by setting
     * `environment.agent_version`, the environment is temporarily set to the
     * `LOADING` state. During that time, the environment continues serving the
     * previous version of the agent. After the new agent version is done loading,
     * the environment is set back to the `RUNNING` state.
     * You can use "-" as Environment ID in environment name to update an agent
     * version in the default environment. WARNING: this will negate all recent
     * changes to the draft agent and can't be undone. You may want to save the
     * draft agent to a version before calling this method.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.Environment>
        updateEnvironment(com.google.cloud.dialogflow.v2.UpdateEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEnvironmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified agent environment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteEnvironment(com.google.cloud.dialogflow.v2.DeleteEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEnvironmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the history of the specified environment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.EnvironmentHistory>
        getEnvironmentHistory(com.google.cloud.dialogflow.v2.GetEnvironmentHistoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEnvironmentHistoryMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ENVIRONMENTS = 0;
  private static final int METHODID_GET_ENVIRONMENT = 1;
  private static final int METHODID_CREATE_ENVIRONMENT = 2;
  private static final int METHODID_UPDATE_ENVIRONMENT = 3;
  private static final int METHODID_DELETE_ENVIRONMENT = 4;
  private static final int METHODID_GET_ENVIRONMENT_HISTORY = 5;

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
        case METHODID_LIST_ENVIRONMENTS:
          serviceImpl.listEnvironments(
              (com.google.cloud.dialogflow.v2.ListEnvironmentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListEnvironmentsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ENVIRONMENT:
          serviceImpl.getEnvironment(
              (com.google.cloud.dialogflow.v2.GetEnvironmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Environment>)
                  responseObserver);
          break;
        case METHODID_CREATE_ENVIRONMENT:
          serviceImpl.createEnvironment(
              (com.google.cloud.dialogflow.v2.CreateEnvironmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Environment>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ENVIRONMENT:
          serviceImpl.updateEnvironment(
              (com.google.cloud.dialogflow.v2.UpdateEnvironmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Environment>)
                  responseObserver);
          break;
        case METHODID_DELETE_ENVIRONMENT:
          serviceImpl.deleteEnvironment(
              (com.google.cloud.dialogflow.v2.DeleteEnvironmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_ENVIRONMENT_HISTORY:
          serviceImpl.getEnvironmentHistory(
              (com.google.cloud.dialogflow.v2.GetEnvironmentHistoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.EnvironmentHistory>)
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
            getListEnvironmentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.ListEnvironmentsRequest,
                    com.google.cloud.dialogflow.v2.ListEnvironmentsResponse>(
                    service, METHODID_LIST_ENVIRONMENTS)))
        .addMethod(
            getGetEnvironmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.GetEnvironmentRequest,
                    com.google.cloud.dialogflow.v2.Environment>(service, METHODID_GET_ENVIRONMENT)))
        .addMethod(
            getCreateEnvironmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.CreateEnvironmentRequest,
                    com.google.cloud.dialogflow.v2.Environment>(
                    service, METHODID_CREATE_ENVIRONMENT)))
        .addMethod(
            getUpdateEnvironmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.UpdateEnvironmentRequest,
                    com.google.cloud.dialogflow.v2.Environment>(
                    service, METHODID_UPDATE_ENVIRONMENT)))
        .addMethod(
            getDeleteEnvironmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.DeleteEnvironmentRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_ENVIRONMENT)))
        .addMethod(
            getGetEnvironmentHistoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.GetEnvironmentHistoryRequest,
                    com.google.cloud.dialogflow.v2.EnvironmentHistory>(
                    service, METHODID_GET_ENVIRONMENT_HISTORY)))
        .build();
  }

  private abstract static class EnvironmentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EnvironmentsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.v2.EnvironmentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Environments");
    }
  }

  private static final class EnvironmentsFileDescriptorSupplier
      extends EnvironmentsBaseDescriptorSupplier {
    EnvironmentsFileDescriptorSupplier() {}
  }

  private static final class EnvironmentsMethodDescriptorSupplier
      extends EnvironmentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    EnvironmentsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (EnvironmentsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new EnvironmentsFileDescriptorSupplier())
                      .addMethod(getListEnvironmentsMethod())
                      .addMethod(getGetEnvironmentMethod())
                      .addMethod(getCreateEnvironmentMethod())
                      .addMethod(getUpdateEnvironmentMethod())
                      .addMethod(getDeleteEnvironmentMethod())
                      .addMethod(getGetEnvironmentHistoryMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
