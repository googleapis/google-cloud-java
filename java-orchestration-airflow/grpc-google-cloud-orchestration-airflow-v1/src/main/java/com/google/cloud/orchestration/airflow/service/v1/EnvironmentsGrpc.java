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
package com.google.cloud.orchestration.airflow.service.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Managed Apache Airflow Environments.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/orchestration/airflow/service/v1/environments.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EnvironmentsGrpc {

  private EnvironmentsGrpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.orchestration.airflow.service.v1.Environments";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.orchestration.airflow.service.v1.CreateEnvironmentRequest,
          com.google.longrunning.Operation>
      getCreateEnvironmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEnvironment",
      requestType =
          com.google.cloud.orchestration.airflow.service.v1.CreateEnvironmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.orchestration.airflow.service.v1.CreateEnvironmentRequest,
          com.google.longrunning.Operation>
      getCreateEnvironmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.orchestration.airflow.service.v1.CreateEnvironmentRequest,
            com.google.longrunning.Operation>
        getCreateEnvironmentMethod;
    if ((getCreateEnvironmentMethod = EnvironmentsGrpc.getCreateEnvironmentMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getCreateEnvironmentMethod = EnvironmentsGrpc.getCreateEnvironmentMethod) == null) {
          EnvironmentsGrpc.getCreateEnvironmentMethod =
              getCreateEnvironmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.orchestration.airflow.service.v1.CreateEnvironmentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEnvironment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orchestration.airflow.service.v1
                                  .CreateEnvironmentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EnvironmentsMethodDescriptorSupplier("CreateEnvironment"))
                      .build();
        }
      }
    }
    return getCreateEnvironmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.orchestration.airflow.service.v1.GetEnvironmentRequest,
          com.google.cloud.orchestration.airflow.service.v1.Environment>
      getGetEnvironmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEnvironment",
      requestType = com.google.cloud.orchestration.airflow.service.v1.GetEnvironmentRequest.class,
      responseType = com.google.cloud.orchestration.airflow.service.v1.Environment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.orchestration.airflow.service.v1.GetEnvironmentRequest,
          com.google.cloud.orchestration.airflow.service.v1.Environment>
      getGetEnvironmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.orchestration.airflow.service.v1.GetEnvironmentRequest,
            com.google.cloud.orchestration.airflow.service.v1.Environment>
        getGetEnvironmentMethod;
    if ((getGetEnvironmentMethod = EnvironmentsGrpc.getGetEnvironmentMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getGetEnvironmentMethod = EnvironmentsGrpc.getGetEnvironmentMethod) == null) {
          EnvironmentsGrpc.getGetEnvironmentMethod =
              getGetEnvironmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.orchestration.airflow.service.v1.GetEnvironmentRequest,
                          com.google.cloud.orchestration.airflow.service.v1.Environment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEnvironment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orchestration.airflow.service.v1
                                  .GetEnvironmentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orchestration.airflow.service.v1.Environment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EnvironmentsMethodDescriptorSupplier("GetEnvironment"))
                      .build();
        }
      }
    }
    return getGetEnvironmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.orchestration.airflow.service.v1.ListEnvironmentsRequest,
          com.google.cloud.orchestration.airflow.service.v1.ListEnvironmentsResponse>
      getListEnvironmentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEnvironments",
      requestType = com.google.cloud.orchestration.airflow.service.v1.ListEnvironmentsRequest.class,
      responseType =
          com.google.cloud.orchestration.airflow.service.v1.ListEnvironmentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.orchestration.airflow.service.v1.ListEnvironmentsRequest,
          com.google.cloud.orchestration.airflow.service.v1.ListEnvironmentsResponse>
      getListEnvironmentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.orchestration.airflow.service.v1.ListEnvironmentsRequest,
            com.google.cloud.orchestration.airflow.service.v1.ListEnvironmentsResponse>
        getListEnvironmentsMethod;
    if ((getListEnvironmentsMethod = EnvironmentsGrpc.getListEnvironmentsMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getListEnvironmentsMethod = EnvironmentsGrpc.getListEnvironmentsMethod) == null) {
          EnvironmentsGrpc.getListEnvironmentsMethod =
              getListEnvironmentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.orchestration.airflow.service.v1.ListEnvironmentsRequest,
                          com.google.cloud.orchestration.airflow.service.v1
                              .ListEnvironmentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEnvironments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orchestration.airflow.service.v1
                                  .ListEnvironmentsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orchestration.airflow.service.v1
                                  .ListEnvironmentsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EnvironmentsMethodDescriptorSupplier("ListEnvironments"))
                      .build();
        }
      }
    }
    return getListEnvironmentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.orchestration.airflow.service.v1.UpdateEnvironmentRequest,
          com.google.longrunning.Operation>
      getUpdateEnvironmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEnvironment",
      requestType =
          com.google.cloud.orchestration.airflow.service.v1.UpdateEnvironmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.orchestration.airflow.service.v1.UpdateEnvironmentRequest,
          com.google.longrunning.Operation>
      getUpdateEnvironmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.orchestration.airflow.service.v1.UpdateEnvironmentRequest,
            com.google.longrunning.Operation>
        getUpdateEnvironmentMethod;
    if ((getUpdateEnvironmentMethod = EnvironmentsGrpc.getUpdateEnvironmentMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getUpdateEnvironmentMethod = EnvironmentsGrpc.getUpdateEnvironmentMethod) == null) {
          EnvironmentsGrpc.getUpdateEnvironmentMethod =
              getUpdateEnvironmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.orchestration.airflow.service.v1.UpdateEnvironmentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEnvironment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orchestration.airflow.service.v1
                                  .UpdateEnvironmentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EnvironmentsMethodDescriptorSupplier("UpdateEnvironment"))
                      .build();
        }
      }
    }
    return getUpdateEnvironmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.orchestration.airflow.service.v1.DeleteEnvironmentRequest,
          com.google.longrunning.Operation>
      getDeleteEnvironmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEnvironment",
      requestType =
          com.google.cloud.orchestration.airflow.service.v1.DeleteEnvironmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.orchestration.airflow.service.v1.DeleteEnvironmentRequest,
          com.google.longrunning.Operation>
      getDeleteEnvironmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.orchestration.airflow.service.v1.DeleteEnvironmentRequest,
            com.google.longrunning.Operation>
        getDeleteEnvironmentMethod;
    if ((getDeleteEnvironmentMethod = EnvironmentsGrpc.getDeleteEnvironmentMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getDeleteEnvironmentMethod = EnvironmentsGrpc.getDeleteEnvironmentMethod) == null) {
          EnvironmentsGrpc.getDeleteEnvironmentMethod =
              getDeleteEnvironmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.orchestration.airflow.service.v1.DeleteEnvironmentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEnvironment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orchestration.airflow.service.v1
                                  .DeleteEnvironmentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EnvironmentsMethodDescriptorSupplier("DeleteEnvironment"))
                      .build();
        }
      }
    }
    return getDeleteEnvironmentMethod;
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
   * Managed Apache Airflow Environments.
   * </pre>
   */
  public abstract static class EnvironmentsImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Create a new environment.
     * </pre>
     */
    public void createEnvironment(
        com.google.cloud.orchestration.airflow.service.v1.CreateEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEnvironmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get an existing environment.
     * </pre>
     */
    public void getEnvironment(
        com.google.cloud.orchestration.airflow.service.v1.GetEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1.Environment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEnvironmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List environments.
     * </pre>
     */
    public void listEnvironments(
        com.google.cloud.orchestration.airflow.service.v1.ListEnvironmentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.orchestration.airflow.service.v1.ListEnvironmentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEnvironmentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update an environment.
     * </pre>
     */
    public void updateEnvironment(
        com.google.cloud.orchestration.airflow.service.v1.UpdateEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEnvironmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete an environment.
     * </pre>
     */
    public void deleteEnvironment(
        com.google.cloud.orchestration.airflow.service.v1.DeleteEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEnvironmentMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateEnvironmentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.orchestration.airflow.service.v1.CreateEnvironmentRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_ENVIRONMENT)))
          .addMethod(
              getGetEnvironmentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.orchestration.airflow.service.v1.GetEnvironmentRequest,
                      com.google.cloud.orchestration.airflow.service.v1.Environment>(
                      this, METHODID_GET_ENVIRONMENT)))
          .addMethod(
              getListEnvironmentsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.orchestration.airflow.service.v1.ListEnvironmentsRequest,
                      com.google.cloud.orchestration.airflow.service.v1.ListEnvironmentsResponse>(
                      this, METHODID_LIST_ENVIRONMENTS)))
          .addMethod(
              getUpdateEnvironmentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.orchestration.airflow.service.v1.UpdateEnvironmentRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_ENVIRONMENT)))
          .addMethod(
              getDeleteEnvironmentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.orchestration.airflow.service.v1.DeleteEnvironmentRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_ENVIRONMENT)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Managed Apache Airflow Environments.
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
     * Create a new environment.
     * </pre>
     */
    public void createEnvironment(
        com.google.cloud.orchestration.airflow.service.v1.CreateEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEnvironmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get an existing environment.
     * </pre>
     */
    public void getEnvironment(
        com.google.cloud.orchestration.airflow.service.v1.GetEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1.Environment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEnvironmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List environments.
     * </pre>
     */
    public void listEnvironments(
        com.google.cloud.orchestration.airflow.service.v1.ListEnvironmentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.orchestration.airflow.service.v1.ListEnvironmentsResponse>
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
     * Update an environment.
     * </pre>
     */
    public void updateEnvironment(
        com.google.cloud.orchestration.airflow.service.v1.UpdateEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEnvironmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete an environment.
     * </pre>
     */
    public void deleteEnvironment(
        com.google.cloud.orchestration.airflow.service.v1.DeleteEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEnvironmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Managed Apache Airflow Environments.
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
     * Create a new environment.
     * </pre>
     */
    public com.google.longrunning.Operation createEnvironment(
        com.google.cloud.orchestration.airflow.service.v1.CreateEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEnvironmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get an existing environment.
     * </pre>
     */
    public com.google.cloud.orchestration.airflow.service.v1.Environment getEnvironment(
        com.google.cloud.orchestration.airflow.service.v1.GetEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEnvironmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List environments.
     * </pre>
     */
    public com.google.cloud.orchestration.airflow.service.v1.ListEnvironmentsResponse
        listEnvironments(
            com.google.cloud.orchestration.airflow.service.v1.ListEnvironmentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEnvironmentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update an environment.
     * </pre>
     */
    public com.google.longrunning.Operation updateEnvironment(
        com.google.cloud.orchestration.airflow.service.v1.UpdateEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEnvironmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete an environment.
     * </pre>
     */
    public com.google.longrunning.Operation deleteEnvironment(
        com.google.cloud.orchestration.airflow.service.v1.DeleteEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEnvironmentMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Managed Apache Airflow Environments.
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
     * Create a new environment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createEnvironment(
            com.google.cloud.orchestration.airflow.service.v1.CreateEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEnvironmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get an existing environment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.orchestration.airflow.service.v1.Environment>
        getEnvironment(
            com.google.cloud.orchestration.airflow.service.v1.GetEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEnvironmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List environments.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.orchestration.airflow.service.v1.ListEnvironmentsResponse>
        listEnvironments(
            com.google.cloud.orchestration.airflow.service.v1.ListEnvironmentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEnvironmentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update an environment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateEnvironment(
            com.google.cloud.orchestration.airflow.service.v1.UpdateEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEnvironmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete an environment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteEnvironment(
            com.google.cloud.orchestration.airflow.service.v1.DeleteEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEnvironmentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ENVIRONMENT = 0;
  private static final int METHODID_GET_ENVIRONMENT = 1;
  private static final int METHODID_LIST_ENVIRONMENTS = 2;
  private static final int METHODID_UPDATE_ENVIRONMENT = 3;
  private static final int METHODID_DELETE_ENVIRONMENT = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EnvironmentsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EnvironmentsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_ENVIRONMENT:
          serviceImpl.createEnvironment(
              (com.google.cloud.orchestration.airflow.service.v1.CreateEnvironmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_ENVIRONMENT:
          serviceImpl.getEnvironment(
              (com.google.cloud.orchestration.airflow.service.v1.GetEnvironmentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.orchestration.airflow.service.v1.Environment>)
                  responseObserver);
          break;
        case METHODID_LIST_ENVIRONMENTS:
          serviceImpl.listEnvironments(
              (com.google.cloud.orchestration.airflow.service.v1.ListEnvironmentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.orchestration.airflow.service.v1.ListEnvironmentsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ENVIRONMENT:
          serviceImpl.updateEnvironment(
              (com.google.cloud.orchestration.airflow.service.v1.UpdateEnvironmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ENVIRONMENT:
          serviceImpl.deleteEnvironment(
              (com.google.cloud.orchestration.airflow.service.v1.DeleteEnvironmentRequest) request,
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

  private abstract static class EnvironmentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EnvironmentsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.orchestration.airflow.service.v1.EnvironmentsOuterClass
          .getDescriptor();
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
    private final String methodName;

    EnvironmentsMethodDescriptorSupplier(String methodName) {
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
                      .addMethod(getCreateEnvironmentMethod())
                      .addMethod(getGetEnvironmentMethod())
                      .addMethod(getListEnvironmentsMethod())
                      .addMethod(getUpdateEnvironmentMethod())
                      .addMethod(getDeleteEnvironmentMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
